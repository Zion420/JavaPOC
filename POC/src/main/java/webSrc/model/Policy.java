package webSrc.model;

public class Policy {
	private String lastPremiumPaid;
	private String policyNumber;
	private String role;
	private String status;
	/**
	 * @return the lastPremiumPaid
	 */
	public String getLastPremiumPaid() {
		return lastPremiumPaid;
	}
	/**
	 * @param lastPremiumPaid the lastPremiumPaid to set
	 */
	public void setLastPremiumPaid(String lastPremiumPaid) {
		this.lastPremiumPaid = lastPremiumPaid;
	}
	/**
	 * @return the policyNumber
	 */
	public String getPolicyNumber() {
		return policyNumber;
	}
	/**
	 * @param policyNumber the policyNumber to set
	 */
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
