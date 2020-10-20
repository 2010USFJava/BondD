package AllTheFun;

import java.util.Date;

public class Party {
	private String location;
	private Date partyTime;
	
 public Party() {
	 
 }
 public Party (String location, Date partyTime) {
	 this.location = location;
	 this.partyTime = partyTime;
 }
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public Date getPartyTime() {
	return partyTime;
}
public void setPartyTime(Date partyTime) {
	this.partyTime = partyTime;
}
@Override
public String toString() {
	return "Party [location=" + location + ", partyTime=" + partyTime + "]";
}
 
 
}
