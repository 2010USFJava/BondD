package com.revature.MainDriver;

import com.revature.bean.KittyKennel;
import com.revature.utility.File;
import com.revature.utility.ScannerUtility;

public class Driver {
	static {File.readCatFile();}
public static void main(String[] args) {
	KittyKennel.catList.forEach((i)-> System.out.println(i.toString()));
	System.out.println("Please enter a cat.");
     
       ScannerUtility.choice();
       
       
}
}
