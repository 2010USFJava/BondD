package com.revature.beans;

public class Grade {
	
	private int rID;
	private String fileLocation;
	private String grade;
	private boolean dsApprove;
	private boolean bcApprove;
	
	public int getrID() {
		return rID;
	}
	public void setrID(int rID) {
		this.rID = rID;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public boolean isDsApprove() {
		return dsApprove;
	}
	public void setDsApprove(boolean dsApprove) {
		this.dsApprove = dsApprove;
	}
	public boolean isBcApprove() {
		return bcApprove;
	}
	public void setBcApprove(boolean bcApprove) {
		this.bcApprove = bcApprove;
	}
	
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Grade(int rID, String fileLocation, String grade, boolean dsApprove, boolean bcApprove) {
		super();
		this.rID = rID;
		this.fileLocation = fileLocation;
		this.grade = grade;
		this.dsApprove = dsApprove;
		this.bcApprove = bcApprove;
	}
	
	@Override
	public String toString() {
		return "Grade [rID=" + rID + ", fileLocation=" + fileLocation + ", grade=" + grade + ", dsApprove=" + dsApprove
				+ ", bcApprove=" + bcApprove + "]";
	}
	
}
