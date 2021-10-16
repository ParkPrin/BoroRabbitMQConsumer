package me.boro.bororabbitmqconsumer.login.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BizAuth {

	private String bizCd; // 사업자 코드

	private Boolean bizMaster; // BizMaster 여부

	private String programAuth; // 회사별 권한

	private Boolean allSellerManager; // 전체매출처관리여부

	private Boolean allPurchaseManager; // 전체매입처관리여부

	private List<Integer> authEmployCd; // 권한사원코드

}
