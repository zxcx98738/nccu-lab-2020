package tw.edu.nccu.recommendation.bo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard implements Comparable<CreditCard> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private long id;

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
	 * 國內現金回饋推薦得分(0-100)
	 */
	private BigDecimal domesticRewardPointSocre = BigDecimal.valueOf(0);

	/**
	 * 海外現金回饋
	 */
	private BigDecimal foreignRewardPoint;

	/**
	 * 海外現金回饋推薦得分(0-100)
	 */
	private BigDecimal foreignRewardPointScore = BigDecimal.valueOf(0);

	/**
	 * 其他優惠
	 */
	private String OtherDiscounts;

	/**
	 * 其他優惠推薦得分(0-100)
	 */
	private BigDecimal OtherDiscountsScore = BigDecimal.valueOf(0);

	/**
	 * 年費
	 */
	private BigDecimal annualFee;

	/**
	 * 年費推薦得分(0-100)
	 */
	private BigDecimal annualFeeScore = BigDecimal.valueOf(0);

	/**
	 * 推薦總分
	 */
	private BigDecimal totalScore;

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

	public String getOtherDiscounts() {
		return OtherDiscounts;
	}

	public void setOtherDiscounts(String otherDiscounts) {
		OtherDiscounts = otherDiscounts;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public BigDecimal getAnnualFee() {
		return annualFee;
	}

	public void setAnnualFee(BigDecimal annualFee) {
		this.annualFee = annualFee;
	}

	public BigDecimal getDomesticRewardPointSocre() {
		return domesticRewardPointSocre;
	}

	public void setDomesticRewardPointSocre(BigDecimal domesticRewardPointSocre) {
		this.domesticRewardPointSocre = domesticRewardPointSocre;
	}

	public BigDecimal getForeignRewardPointScore() {
		return foreignRewardPointScore;
	}

	public void setForeignRewardPointScore(BigDecimal foreignRewardPointScore) {
		this.foreignRewardPointScore = foreignRewardPointScore;
	}

	public BigDecimal getAnnualFeeScore() {
		return annualFeeScore;
	}

	public void setAnnualFeeScore(BigDecimal annualFeeScore) {
		this.annualFeeScore = annualFeeScore;
	}

	public BigDecimal getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(BigDecimal totalScore) {
		this.totalScore = totalScore;
	}

	public BigDecimal getOtherDiscountsScore() {
		return OtherDiscountsScore;
	}

	public void setOtherDiscountsScore(BigDecimal otherDiscountsScore) {
		OtherDiscountsScore = otherDiscountsScore;
	}
	

	@Override
	public int compareTo(CreditCard o) {
		return o.getTotalScore().compareTo(this.getTotalScore());
	}

}
