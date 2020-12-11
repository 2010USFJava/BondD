package com.revature.beans;

public class Log {
	
	private int logID;
	private int rID;
	private String logLevel;
	private String logmessage;
	
	public int getLogID() {
		return logID;
	}
	public void setLogID(int logID) {
		this.logID = logID;
	}
	public int getrID() {
		return rID;
	}
	public void setrID(int rID) {
		this.rID = rID;
	}
	public String getLogLevel() {
		return logLevel;
	}
	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}
	public String getLogmessage() {
		return logmessage;
	}
	public void setLogmessage(String logmessage) {
		this.logmessage = logmessage;
	}
	
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Log(int logID, int rID, String logLevel, String logmessage) {
		super();
		this.logID = logID;
		this.rID = rID;
		this.logLevel = logLevel;
		this.logmessage = logmessage;
	}
	
	@Override
	public String toString() {
		return "Log [logID=" + logID + ", rID=" + rID + ", logLevel=" + logLevel + ", logmessage=" + logmessage + "]";
	}
}
