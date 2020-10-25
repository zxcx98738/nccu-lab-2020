package tw.edu.nccu.recommendation.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tw.edu.nccu.recommendation.bo.CreditCard;
import tw.edu.nccu.recommendation.bo.CreditCardResponse;
import tw.edu.nccu.recommendation.bo.Weights;

@Slf4j
@Service
public class RuleService {

	@Autowired
	DataService dataService;
	
	/**
	 * 設定評分項目權重
	 * 
	 * @return
	 */
	public Weights getWeight() {
		return Weights.builder()
				.domesticRewardPointWeight(BigDecimal.valueOf(0.25))
				.foreignRewardPointWeight(BigDecimal.valueOf(0.25))
				.annualFeeWeight(BigDecimal.valueOf(0.25))
				.otherDiscountsWeight(BigDecimal.valueOf(0.25))
				.build();
	}


	/**
	 * 合計評分結果回傳前三筆
	 * 
	 * @return
	 */
	public List<CreditCard> aggregateResult() {
		CreditCardResponse masterData = dataService.fetchCreditCardResponse();
		Weights weights = getWeight();
		masterData.getData().stream().forEach(item -> {
			log.info("計算國內回饋分數...");
			item.setDomesticRewardPointSocre(domesticRewardPointRule(item.getDomesticRewardPoint()));
			log.info("計算國外回饋分數...");
			item.setForeignRewardPointScore(foreignRewardPointRule(item.getForeignRewardPoint()));
			log.info("計算國外年費分數...");
			item.setAnnualFeeScore(annualFeeRule((item.getAnnualFee())));
			log.info("計算其他折扣分數...");
			item.setOtherDiscountsScore(otherDiscountsRule(item.getOtherDiscounts()));

			log.info("乘上權重...");
			BigDecimal score1 = item.getDomesticRewardPointSocre().multiply(weights.getDomesticRewardPointWeight());
			BigDecimal score2 = item.getForeignRewardPointScore().multiply(weights.getForeignRewardPointWeight());
			BigDecimal score3 = item.getAnnualFeeScore().multiply(weights.getAnnualFeeWeight());
			BigDecimal score4 = item.getOtherDiscountsScore().multiply(weights.getOtherDiscountsWeight());

			log.info("合計總分 ...");
			BigDecimal result = score1.add(score2).add(score3).add(score4).setScale(1);

			item.setTotalScore(result);
		});
		return masterData.getData();
	}


	/**
	 * 國內回饋算分規則
	 * 
	 * @param domesticRewardPoint
	 * @return
	 */
	public BigDecimal domesticRewardPointRule(BigDecimal domesticRewardPoint) {
		if (domesticRewardPoint.compareTo(BigDecimal.valueOf(1)) <= 0) {
			log.info("國內回饋小於等於 1...");
			return BigDecimal.valueOf(0);
		} else if (domesticRewardPoint.compareTo(BigDecimal.valueOf(2)) <= 0) {
			log.info("國內回饋小於等於 2...");
			return BigDecimal.valueOf(50);
		} else {
			log.info("國內回饋大於2...");
			return BigDecimal.valueOf(100);
		}
	}

	/**
	 * 國外回饋算分規則
	 * 
	 * @param foreignRewardPoint
	 * @return
	 */
	public BigDecimal foreignRewardPointRule(BigDecimal foreignRewardPoint) {
		if (foreignRewardPoint.compareTo(BigDecimal.valueOf(2)) <= 0) {
			log.info("國外回饋小於等於 2...");
			return BigDecimal.valueOf(0);
		} else if (foreignRewardPoint.compareTo(BigDecimal.valueOf(3)) <= 0) {
			log.info("國外回饋小於等於 3...");
			return BigDecimal.valueOf(50);
		} else {
			log.info("國外回饋大於3...");
			return BigDecimal.valueOf(100);
		}
	}

	/**
	 * 年費算分規則
	 * 
	 * @param domesticRewardPoint
	 * @return
	 */
	public BigDecimal annualFeeRule(BigDecimal annualFee) {
		if (annualFee.compareTo(BigDecimal.valueOf(0)) == 0) {
			log.info("年費為0... ");
			return BigDecimal.valueOf(100);
		} else if(annualFee.compareTo(BigDecimal.valueOf(2000))<=0){
			log.info("年費大小等於 2000 ... ");
			return BigDecimal.valueOf(50);
		}else {
			log.info("年費大於 2000 ... ");
			return BigDecimal.valueOf(0);
		}
	}

	/**
	 * 其他折扣算分規則
	 * 
	 * @param domesticRewardPoint
	 * @return
	 */
	public BigDecimal otherDiscountsRule(String otherDiscounts) {
		if(otherDiscounts.equals("無")) {
			return BigDecimal.valueOf(0);
		}
		return BigDecimal.valueOf(100);
	}

}
