package com.revature.beans;

public class Reimbursement {

	private int empID;
	private int r_ID;
	private String eventName;
	
	//Ask Donna how to use this with DateTimeUtility
	private String date;
	private String time;
	
	private String location;
	private String description;
	private double cost;
	private String eventFile;
	private String gradingFormat;
	private String eventType;
	private String justification;
	
	private String approvalFile;
	private int dsApproval;
	private int dhApproval;
	private boolean bcApproval;
	
	private double alteredAmt;
	private String alteredReason;
	private boolean exceedingFunds;
	
	private boolean awarded;
	private String denialReason;

	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public int getR_ID() {
		return r_ID;
	}
	public void setR_ID(int r_ID) {
		this.r_ID = r_ID;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getEventFile() {
		return eventFile;
	}
	public void setEventFile(String eventFile) {
		this.eventFile = eventFile;
	}
	public String getGradingFormat() {
		return gradingFormat;
	}
	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public String getApprovalFile() {
		return approvalFile;
	}
	public void setApprovalFile(String approvalFile) {
		this.approvalFile = approvalFile;
	}
	public int getDsApproval() {
		return dsApproval;
	}
	public void setDsApproval(int dsApproval) {
		this.dsApproval = dsApproval;
	}
	public int getDhApproval() {
		return dhApproval;
	}
	public void setDhApproval(int dhApproval) {
		this.dhApproval = dhApproval;
	}
	public boolean isBcApproval() {
		return bcApproval;
	}
	public void setBcApproval(boolean bcApproval) {
		this.bcApproval = bcApproval;
	}
	public double getAlteredAmt() {
		return alteredAmt;
	}
	public void setAlteredAmt(double alteredAmt) {
		this.alteredAmt = alteredAmt;
	}
	public String getAlteredReason() {
		return alteredReason;
	}
	public void setAlteredReason(String alteredReason) {
		this.alteredReason = alteredReason;
	}
	public boolean isExceedingFunds() {
		return exceedingFunds;
	}
	public void setExceedingFunds(boolean exceedingFunds) {
		this.exceedingFunds = exceedingFunds;
	}
	public boolean isAwarded() {
		return awarded;
	}
	public void setAwarded(boolean awarded) {
		this.awarded = awarded;
	}
	public String getDenialReason() {
		return denialReason;
	}
	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reimbursement(int empID, int r_ID, String eventName, String date, String time, String location,
			String description, double cost, String eventFile, String gradingFormat, String eventType,
			String justification, String approvalFile, int dsApproval, int dhApproval, boolean bcApproval,
			double alteredAmt, String alteredReason, boolean exceedingFunds, boolean awarded, String denialReason) {
		super();
		this.empID = empID;
		this.r_ID = r_ID;
		this.eventName = eventName;
		this.date = date;
		this.time = time;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.eventFile = eventFile;
		this.gradingFormat = gradingFormat;
		this.eventType = eventType;
		this.justification = justification;
		this.approvalFile = approvalFile;
		this.dsApproval = dsApproval;
		this.dhApproval = dhApproval;
		this.bcApproval = bcApproval;
		this.alteredAmt = alteredAmt;
		this.alteredReason = alteredReason;
		this.exceedingFunds = exceedingFunds;
		this.awarded = awarded;
		this.denialReason = denialReason;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [empID=" + empID + ", r_ID=" + r_ID + ", eventName=" + eventName + ", date=" + date
				+ ", time=" + time + ", location=" + location + ", description=" + description + ", cost=" + cost
				+ ", eventFile=" + eventFile + ", gradingFormat=" + gradingFormat + ", eventType=" + eventType
				+ ", justification=" + justification + ", approvalFile=" + approvalFile + ", dsApproval=" + dsApproval
				+ ", dhApproval=" + dhApproval + ", bcApproval=" + bcApproval + ", alteredAmt=" + alteredAmt
				+ ", alteredReason=" + alteredReason + ", exceedingFunds=" + exceedingFunds + ", awarded=" + awarded
				+ ", denialReason=" + denialReason + "]";

	}
	
}
