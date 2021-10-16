package me.boro.bororabbitmqconsumer.order.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Argument;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderRabbitMqListener {

	public static final String ORDER_QUEUE_NAME = "boro.order.queue";
	public static final String ORDER_EXCHANGE_NAME = "boro.order.exchange";
	public static final String ORDER_ROUTING_KEY = "boro.order.queue";
	public static final String ORDER_DURABLE = "true";

	public static final String ORDER_EXCHANGE_DLX_NAME = "boro.order.exchange.dlx";
	public static final String ORDER_ROUTING_DLX_KEY = "boro.order.queue.dlx";


	private static final ObjectMapper mapper = new ObjectMapper();

	private int index;

	@RabbitListener(
			bindings = @QueueBinding(
					value = @Queue(value = ORDER_QUEUE_NAME, durable = ORDER_DURABLE, arguments = {
							@Argument(name = "x-dead-letter-exchange", value = ORDER_EXCHANGE_DLX_NAME),
							@Argument(name = "x-dead-letter-routing-key", value = ORDER_ROUTING_DLX_KEY),
					}),
					exchange = @Exchange(value = ORDER_EXCHANGE_NAME, type = ExchangeTypes.TOPIC),
					key = ORDER_ROUTING_KEY
			)
	)
	public void receiveMessage(final Message message) throws Exception {
		log.info("message.getBody()={}", new String(message.getBody()));

		if (++index % 2 == 0) {
			// 메시지 소비 실패.
			// AmqpRejectAndDontRequeueException을 발생시키면 Reject되면서 다시 Queue에 들어가지 않는다.
			// Manual Rejection 또는 AmqpRejectAndDontRequeueException처리를 안하면, 메시지가 다시 Queue로 들어가서 반복된 에러가 발생할 수 있다.
			// Reject처리 후 DLQ로 보낼지 여부는 RabbitMQ Queue의 x-dead-letter-exchange(+ x-dead-letter-routing-key) 설정에 따라간다.
			throw new AmqpRejectAndDontRequeueException("실패처리. Reject And Don't Requeue Exception");
		}

		log.info("메시지 소비 성공");
	}

}
