package me.boro.bororabbitmqconsumer.login.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
@Builder
public class LoginResultTest {



	private String userId; // 아이디

	private String userNm; // 사용자이름

	private Long userNo; // 사용자식별값

	private String displayBizNm; // 사업자명 표시

	private Boolean isTempUser; // 임시 계정 여부

	private Boolean isTempPassword; // 임시 비밀번호 여부

	private String bizNm; // 사업자명(상호)

	private String tmpYn; // (없는 내용) 임시비밀번호여부

}