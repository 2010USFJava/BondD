package com.revature.beans;

public class Warrior {
 private String name;
 private int attackPower;
 private int hp;
public Warrior() {
	super();
	// TODO Auto-generated constructor stub
}
public Warrior(String name, int attackPower, int hp) {
	super();
	this.name = name;
	this.attackPower = attackPower;
	this.hp = hp;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAttackPower() {
	return attackPower;
}
public void setAttackPower(int attackPower) {
	this.attackPower = attackPower;
}
public int getHp() {
	return hp;
}
public void setHp(int hp) {
	this.hp = hp;
}
@Override
public String toString() {
	return "warrior [name=" + name + ", attackPower=" + attackPower + ", hp=" + hp + "]";
}
 
}
