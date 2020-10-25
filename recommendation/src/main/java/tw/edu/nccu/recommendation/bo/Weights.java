package tw.edu.nccu.recommendation.bo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Weights {

	/**
	 * 國內消費權重
	 */
	private BigDecimal domesticRewardPointWeight;

	/**
	 * 海外消費回饋權重
	 */
	private BigDecimal foreignRewardPointWeight;

	/**
	 * 年費權重
	 */
	private BigDecimal annualFeeWeight;

	/**
	 * 其他折扣權重
	 */
	private BigDecimal otherDiscountsWeight;

	public BigDecimal getDomesticRewardPointWeight() {
		return domesticRewardPointWeight;
	}

	public void setDomesticRewardPointWeight(BigDecimal domesticRewardPointWeight) {
		this.domesticRewardPointWeight = domesticRewardPointWeight;
	}

	public BigDecimal getForeignRewardPointWeight() {
		return foreignRewardPointWeight;
	}

	public void setForeignRewardPointWeight(BigDecimal foreignRewardPointWeight) {
		this.foreignRewardPointWeight = foreignRewardPointWeight;
	}

	public BigDecimal getAnnualFeeWeight() {
		return annualFeeWeight;
	}

	public void setAnnualFeeWeight(BigDecimal annualFeeWeight) {
		this.annualFeeWeight = annualFeeWeight;
	}

	public BigDecimal getOtherDiscountsWeight() {
		return otherDiscountsWeight;
	}

	public void setOtherDiscountsWeight(BigDecimal otherDiscountsWeight) {
		this.otherDiscountsWeight = otherDiscountsWeight;
	}

}
