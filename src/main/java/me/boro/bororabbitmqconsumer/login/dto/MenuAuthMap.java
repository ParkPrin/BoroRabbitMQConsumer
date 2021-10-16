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
public class MenuAuthMap {

	private String menuId; // 메뉴인증 정보의 메뉴아이디

	private String menuNm; // 메뉴인증 정보의 메뉴명

	private String menuUrl; // 메뉴인증 정보의 프로그램URL

	private Boolean menuIsFavorite; // 메뉴인증 즐겨찾기 여부

	private List<MenuAuth> menuInfo; // 메뉴인증 정보의 상세정보

}
