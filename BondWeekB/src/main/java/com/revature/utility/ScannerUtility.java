package com.revature.utility;

import java.util.Scanner;

import com.revature.bean.Cat;

public class ScannerUtility {
public static Scanner input = new Scanner (System.in);


public static void getCat() {
	String name;
	int lives;
	String color;
	String type;
	System.out.println(" name:");
	name = input.nextLine();
	System.out.println("Please enter number of lives.");
	lives= Integer.parseInt(input.nextLine());
	System.out.println("Please enter Color.");
	color = input.nextLine();
	System.out.println("Please enter Type.");
	type = input.nextLine();
	Cat c = new Cat(lives,type,color,name);
	System.out.println("You have added a Cat\n" + c);
}
public static void choice() {
	String choice = "y";
	
	do {
	getCat();
	System.out.println("Would you like to add another cat?");
	System.out.println("[y] = yes \n[N] = no");
	choice = input.nextLine();}
	while(choice.equalsIgnoreCase("y"));
	System.out.println("GoodBye! \nCrazyoleCatLady");
	}
}


