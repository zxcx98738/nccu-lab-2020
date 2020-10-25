package tw.edu.nccu.recommendation.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tw.edu.nccu.recommendation.bo.CreditCardResponse;

@Service
public class DataService {

	private static final String API_HOST = "http://credit-card-nccu-lab2-common.nccu-lab-teacher-4c2f3918c1e51a612ffc44c361c1a42f-0000.jp-tok.containers.appdomain.cloud/api/credit-card";

	/**
	 * 取得呼叫新用卡API的結果
	 * 
	 * @return
	 */
	public CreditCardResponse fetchCreditCardResponse() {
		RestTemplate restTemplate = new RestTemplate();
		CreditCardResponse response = restTemplate.getForObject(API_HOST, CreditCardResponse.class);
		return response;
	}

}
