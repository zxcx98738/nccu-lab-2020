package tw.edu.nccu.recommendation.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import lombok.extern.slf4j.Slf4j;
import tw.edu.nccu.recommendation.bo.CreditCard;
import tw.edu.nccu.recommendation.bo.CreditCardResponse;

@Slf4j
@SpringBootTest
@ContextConfiguration(classes = { DataService.class, RuleService.class })
public class RuleServiceTest {

	@MockBean
	DataService dataService;

	@Autowired
	RuleService ruleService;

	@Test
	public void aggregateResultBestCardTest() {
		CreditCardResponse response = new CreditCardResponse();
		List<CreditCard> cardList = new ArrayList<>();
		cardList.add(CreditCard.builder()
						.domesticRewardPoint(BigDecimal.valueOf(2.1))
						.foreignRewardPoint(BigDecimal.valueOf(3.1))
						.annualFee(BigDecimal.valueOf(0))
						.OtherDiscounts("").build());
		response.setData(cardList);
		Mockito.when(dataService.fetchCreditCardResponse()).thenReturn(response);
		assertEquals(BigDecimal.valueOf(100.0), ruleService.aggregateResult().get(0).getTotalScore());	
	}
	
	@Test
	public void aggregateResultWorstCardTest() {
		CreditCardResponse response = new CreditCardResponse();
		List<CreditCard> cardList = new ArrayList<>();
		cardList.add(CreditCard.builder()
						.domesticRewardPoint(BigDecimal.valueOf(0.9))
						.foreignRewardPoint(BigDecimal.valueOf(1.9))
						.annualFee(BigDecimal.valueOf(2001))
						.OtherDiscounts("無").build());
		response.setData(cardList);
		Mockito.when(dataService.fetchCreditCardResponse()).thenReturn(response);
		assertEquals(BigDecimal.valueOf(0.0), ruleService.aggregateResult().get(0).getTotalScore());	
	}

	@Test
	public void domesticRewardPointRuleTest() {
		assertEquals(BigDecimal.valueOf(0), ruleService.domesticRewardPointRule(BigDecimal.valueOf(0.9)));
		assertEquals(BigDecimal.valueOf(0), ruleService.domesticRewardPointRule(BigDecimal.valueOf(1)));
		assertEquals(BigDecimal.valueOf(50), ruleService.domesticRewardPointRule(BigDecimal.valueOf(1.9)));
		assertEquals(BigDecimal.valueOf(50), ruleService.domesticRewardPointRule(BigDecimal.valueOf(2)));
		assertEquals(BigDecimal.valueOf(100), ruleService.domesticRewardPointRule(BigDecimal.valueOf(2.1)));
	}

	@Test
	public void foreignRewardPointRuleTest() {
		assertEquals(BigDecimal.valueOf(0), ruleService.foreignRewardPointRule(BigDecimal.valueOf(1.9)));
		assertEquals(BigDecimal.valueOf(0), ruleService.foreignRewardPointRule(BigDecimal.valueOf(2)));
		assertEquals(BigDecimal.valueOf(50), ruleService.foreignRewardPointRule(BigDecimal.valueOf(2.9)));
		assertEquals(BigDecimal.valueOf(50), ruleService.foreignRewardPointRule(BigDecimal.valueOf(3)));
		assertEquals(BigDecimal.valueOf(100), ruleService.foreignRewardPointRule(BigDecimal.valueOf(3.1)));
	}

	@Test
	public void annualFeeRuleTest() {
		assertEquals(BigDecimal.valueOf(100), ruleService.annualFeeRule(BigDecimal.valueOf(0)));
		assertEquals(BigDecimal.valueOf(50), ruleService.annualFeeRule(BigDecimal.valueOf(1999)));
		assertEquals(BigDecimal.valueOf(0), ruleService.annualFeeRule(BigDecimal.valueOf(2001)));
	}

	@Test
	public void otherDiscountsRuleTest() {
		assertEquals(BigDecimal.valueOf(100), ruleService.otherDiscountsRule(""));
	}

}
