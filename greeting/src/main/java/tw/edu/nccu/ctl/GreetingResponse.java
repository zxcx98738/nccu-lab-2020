package tw.edu.nccu.ctl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GreetingResponse {
	/**
	 * Http Code
	 */
	private String code;

	/**
	 * 回傳信息
	 */
	private String msg;

	/**
	 * 回傳資料
	 */
	private String data;
}
