package tw.edu.nccu.creditcard.ctl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import tw.edu.nccu.creditcard.bo.CreditCardRequest;
import tw.edu.nccu.creditcard.bo.GenericResponse;
import tw.edu.nccu.creditcard.entity.CreditCard;
import tw.edu.nccu.creditcard.repository.CreditCardRepository;

@Slf4j
@RestController
@RequestMapping(path = "/api")
@CrossOrigin(value = "*")
public class CreditCardController {

	@Autowired
	CreditCardRepository creditCardRepository;

	/**
	 * 取得所有信用卡
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@GetMapping(path = "/credit-card", produces = "application/json; charset=UTF-8")
	@ApiOperation(value = "取得所有信用卡主檔資料")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"), })
	public ResponseEntity<GenericResponse> getCreditCard(HttpServletRequest request) throws JsonProcessingException {
		log.info("Get all master data ...");
		GenericResponse response = new GenericResponse();
		response.setData(creditCardRepository.findAll());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * 取得單張信用卡資料
	 * 
	 * @param id
	 * @return
	 * @throws JsonProcessingException
	 */
	@GetMapping(path = "/credit-card/{id}", produces = "application/json; charset=UTF-8")
	@ApiOperation(value = "依照id取得某一筆信用卡主檔資料")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"), })
	public ResponseEntity<GenericResponse> getCreditCardById(@PathVariable String id) throws JsonProcessingException {
		log.info("Get one master data ...");
		GenericResponse response = new GenericResponse();
		response.setData(creditCardRepository.findById(Long.parseLong(id)));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * 新增信用卡主檔資料
	 * 
	 * @param id
	 * @return
	 * @throws JsonProcessingException
	 */
	@PostMapping(path = "/credit-card", produces = "application/json; charset=UTF-8")
	@ApiOperation(value = "新增信用卡主檔資料")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"), })
	public ResponseEntity<GenericResponse> addCreditCard(@RequestBody CreditCardRequest request)
			throws JsonProcessingException {
		log.info("Add one record to master data ...");
		GenericResponse response = new GenericResponse();
		CreditCard entity = CreditCard.builder().annualFee(request.getAnnualFee())
				.bankCardAssociation(request.getBankCardAssociation()).cardName(request.getCardName())
				.domesticRewardPoint(request.getDomesticRewardPoint())
				.foreignRewardPoint(request.getForeignRewardPoint()).issuer(request.getIssuer())
				.otherDiscounts(request.getOtherDiscounts()).build();

		creditCardRepository.save(entity);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * 新增信用卡主檔資料
	 * 
	 * @param id
	 * @return
	 * @throws JsonProcessingException
	 */
	@PutMapping(path = "/credit-card/{id}", produces = "application/json; charset=UTF-8")
	@ApiOperation(value = "更新信用卡主檔資料")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"), })
	public ResponseEntity<GenericResponse> updateCreditCard(@PathVariable String id,
			@RequestBody CreditCardRequest request) throws JsonProcessingException {
		log.info("Update one credit card record ...");
		GenericResponse response = new GenericResponse();
		CreditCard entity = CreditCard.builder().id(Long.parseLong(id)).annualFee(request.getAnnualFee())
				.bankCardAssociation(request.getBankCardAssociation()).cardName(request.getCardName())
				.domesticRewardPoint(request.getDomesticRewardPoint())
				.foreignRewardPoint(request.getForeignRewardPoint()).issuer(request.getIssuer())
				.otherDiscounts(request.getOtherDiscounts()).build();

		creditCardRepository.save(entity);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * 刪除信用卡主檔資料
	 * 
	 * @param id
	 * @return
	 * @throws JsonProcessingException
	 */
	@DeleteMapping(path = "/credit-card/{id}", produces = "application/json; charset=UTF-8")
	@ApiOperation(value = "刪除信用卡主檔資料")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"), })
	public ResponseEntity<GenericResponse> deleteCreditCard(@PathVariable String id) throws JsonProcessingException {
		log.info("Delete one credit card record ...");
		GenericResponse response = new GenericResponse();
		creditCardRepository.deleteById(Long.parseLong(id));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
