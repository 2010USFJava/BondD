package com.revature.bean;

import java.io.Serializable;

import com.revature.utility.File;
import com.revature.utility.LoggingUtility;

public class Cat implements Serializable {

	//private static final long serialVersionUID = 1L;
private int numOfLives;
 private String type;
 private String color;
 private String name;
public Cat() {
	super();
	KittyKennel.catList.add(this);
	File.writeCatFile(KittyKennel.catList);
	
}
public Cat(int numOfLives, String type, String color, String name) {
	super();
	this.numOfLives = numOfLives;
	this.type = type;
	this.color = color;
	this.name = name;
	KittyKennel.catList.add(this);
	File.writeCatFile(KittyKennel.catList);
	LoggingUtility.LogIt("info", "Another Kitty is born!"+ this.getName());
}
public int getNumOfLives() {
	return numOfLives;
}
public void setNumOfLives(int numOfLives) {
	this.numOfLives = numOfLives;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Cat [numOfLives=" + numOfLives + ", type=" + type + ", color=" + color + ", name=" + name + "]";
}
 
}
