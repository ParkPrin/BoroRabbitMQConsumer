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
public class LoginResult {
	private String userId; // 아이디

	private String userNm; // 사용자이름

	private Long userNo; // 사용자식별값

	private String displayBizNm; // 사업자명 표시

	private Boolean isTempUser; // 임시 계정 여부

	private Boolean isTempPassword; // 임시 비밀번호 여부

	private String bizNm; // 사업자명(상호)

	private String tmpYn; // (없는 내용) 임시비밀번호여부

	private UserStatusCode status; // 상태코드

	private String message; // 메세지


	private Boolean groupMaster; // 그룹 마스터 여부 (중상, 일반 그룹 마스터 모두 해당함)

	private Boolean middleMaster; // 중상마스터여부

	private Boolean middleGroup;  // 중상인지 여부 (내가 관리자가 아니라도 중상일 순 있잖아)

	private Boolean webPrintUse;

	private List<PersonalSetMap> personalSet; // 개인정보

	private List<BizAuth> bizAuth; // 사업자 인증정보

	private List<MenuAuthMap> menuAuth; // 메뉴 인증정보

	private String token; // : String
}
