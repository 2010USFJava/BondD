package AllTheFun;

public class Clown {
 private String name;
 private Party party;
 private int ballonCount;
 
 public Clown() {
	 
 }
  
 public Clown(String name, Party party, int balloonCount) {
	this.name = name;
	this.party = party;	
	this.ballonCount = balloonCount;
	
	
	 
 }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Party getParty() {
	return party;
}

public void setParty(Party party) {
	this.party = party;
}

public int getBallonCount() {
	return ballonCount;
}

public void setBallonCount(int ballonCount) {
	this.ballonCount = ballonCount;
}

@Override
public String toString() {
	return "Clown [name=" + name + ", party=" + party + ", ballonCount=" + ballonCount + "]";
}


}
