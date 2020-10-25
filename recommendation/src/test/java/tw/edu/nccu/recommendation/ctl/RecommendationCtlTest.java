package tw.edu.nccu.recommendation.ctl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import tw.edu.nccu.recommendation.bo.CreditCard;
import tw.edu.nccu.recommendation.service.RuleService;

@WebMvcTest
public class RecommendationCtlTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	RuleService ruleService;

	@Test
	public void getRecommandateCreditCard() throws Exception {
		Mockito.when(ruleService.aggregateResult()).thenReturn(new ArrayList<CreditCard>());
		mvc.perform(get("/api/recommendation").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

}
