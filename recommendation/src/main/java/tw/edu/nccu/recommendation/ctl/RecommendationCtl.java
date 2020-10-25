package tw.edu.nccu.recommendation.ctl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import tw.edu.nccu.recommendation.bo.CreditCard;
import tw.edu.nccu.recommendation.bo.CreditCardResponse;
import tw.edu.nccu.recommendation.bo.Weights;
import tw.edu.nccu.recommendation.service.RuleService;

@Slf4j
@RestController
@RequestMapping(path = "/api")
@CrossOrigin(value = "*")
public class RecommendationCtl {

	@Autowired
	RuleService ruleService;

	/**
	 * 取得所有信用卡
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@GetMapping(path = "/recommendation", produces = "application/json; charset=UTF-8")
	@ApiOperation(value = "取得推薦結果")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"), })
	public ResponseEntity<CreditCardResponse> getRecommandateCreditCard() throws JsonProcessingException {
		CreditCardResponse response = new CreditCardResponse();
		response.setCode("200");
		response.setMsg("操作成功");
		List<CreditCard> data = ruleService.aggregateResult();
		Collections.sort(data);
		if (data.size() < 3) {
			response.setData(data.subList(0, data.size()));
		} else {
			response.setData(data.subList(0, 3));
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/weight", produces = "application/json; charset=UTF-8")
	@ApiOperation(value = "取得國內外現金回饋/年費/其他優惠評分權重")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"), })
	public ResponseEntity<Weights> getWeight() throws JsonProcessingException {
		return new ResponseEntity<>(ruleService.getWeight(), HttpStatus.OK);
	}

}
