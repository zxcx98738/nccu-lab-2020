package tw.edu.nccu.recommendation.bo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardResponse {

	/**
	 * 回應代碼
	 */
	private String code;

	/**
	 * 回應信息
	 */
	private String msg;

	/**
	 * 回應資料
	 */
	private List<CreditCard> data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<CreditCard> getData() {
		return data;
	}

	public void setData(List<CreditCard> data) {
		this.data = data;
	}

}
