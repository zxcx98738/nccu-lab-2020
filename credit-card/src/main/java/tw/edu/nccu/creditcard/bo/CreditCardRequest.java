package tw.edu.nccu.creditcard.bo;

import java.math.BigDecimal;

public class CreditCardRequest {

	/**
	 * 產品名稱
	 */
	private String cardName;

	/**
	 * 發卡銀行
	 */
	private String issuer;

	/**
	 * 國際信用卡組織
	 */
	private String bankCardAssociation;

	/**
	 * 國內現金回饋
	 */
	private BigDecimal domesticRewardPoint;

	/**
	 * 海外現金回饋
	 */
	private BigDecimal foreignRewardPoint;

	/**
	 * 其他優惠
	 */
	private String OtherDiscounts;

	/**
	 * 年費
	 */
	private BigDecimal annualFee;

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getBankCardAssociation() {
		return bankCardAssociation;
	}

	public void setBankCardAssociation(String bankCardAssociation) {
		this.bankCardAssociation = bankCardAssociation;
	}

	public BigDecimal getDomesticRewardPoint() {
		return domesticRewardPoint;
	}

	public void setDomesticRewardPoint(BigDecimal domesticRewardPoint) {
		this.domesticRewardPoint = domesticRewardPoint;
	}

	public BigDecimal getForeignRewardPoint() {
		return foreignRewardPoint;
	}

	public void setForeignRewardPoint(BigDecimal foreignRewardPoint) {
		this.foreignRewardPoint = foreignRewardPoint;
	}

	public String getOtherDiscounts() {
		return OtherDiscounts;
	}

	public void setOtherDiscounts(String otherDiscounts) {
		OtherDiscounts = otherDiscounts;
	}

	public BigDecimal getAnnualFee() {
		return annualFee;
	}

	public void setAnnualFee(BigDecimal annualFee) {
		this.annualFee = annualFee;
	}

}
