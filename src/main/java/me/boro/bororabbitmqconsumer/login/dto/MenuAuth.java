package me.boro.bororabbitmqconsumer.login.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuAuth {

	private String bizCd; // : String

	private String bizNm; // : String

}
