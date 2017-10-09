package prs.business;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class PurchaseRequest implements Serializable {

	// the instance variables
	private int id;
	private int userID;
	private String description;
	private String justification;
	private Date dateNeeded;
	private String deliveryMode;
	private String status;
	private double total;
	private Date submittedDate;
	String reasonForR;

	// the constructors
	public PurchaseRequest() {
	}

	public PurchaseRequest(int id, int userID, String description, String justification, Date dateNeeded,
			String deliveryMode, String status, double total, Date submittedDate) {
		this.id = id;
		this.userID = userID;
		this.description = description;
		this.justification = justification;
		this.dateNeeded = dateNeeded;
		this.deliveryMode = deliveryMode;
		this.status = status;
		this.total = total;
		this.submittedDate = submittedDate;
	}

	public PurchaseRequest(int id, int userID, String description, String justification, Date dateNeeded,
			String deliveryMode, String status, double total, Date submittedDate, String reasonForR) {
		this.id = id;
		this.userID = userID;
		this.description = description;
		this.justification = justification;
		this.dateNeeded = dateNeeded;
		this.deliveryMode = deliveryMode;
		this.status = status;
		this.total = total;
		this.submittedDate = submittedDate;
		this.reasonForR = reasonForR;
	}

	// the set and get methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public Date getDateNeeded() {
		return dateNeeded;
	}

	public void setDateNeeded(Date dateNeeded) {
		this.dateNeeded = dateNeeded;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public String getReasonForR() {
		return reasonForR;
	}

	public void setReasonForR(String reasonForR) {
		this.reasonForR = reasonForR;
	}

	// custom methods

}
