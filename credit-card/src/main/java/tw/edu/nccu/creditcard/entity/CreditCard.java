package tw.edu.nccu.creditcard.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CREDIT_CARD")
public class CreditCard implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	 * 海外現金回饋
	 */
	private BigDecimal foreignRewardPoint;

	/**
	 * 其他優惠
	 */
	private String otherDiscounts;

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

	public String getOtherDiscounts() {
		return otherDiscounts;
	}

	public void setOtherDiscounts(String otherDiscounts) {
		this.otherDiscounts = otherDiscounts;
	}

}
