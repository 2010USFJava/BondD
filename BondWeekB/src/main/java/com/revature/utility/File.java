package com.revature.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.bean.Cat;
import com.revature.bean.KittyKennel;

public class File {
public static final String file = "catList.txt";

public static void writeCatFile(List<Cat> clist) {
	try { ObjectOutputStream outPut = new ObjectOutputStream (new FileOutputStream(file));
	outPut.writeObject(clist);
	
		outPut.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
@SuppressWarnings("unchecked")
public static void readCatFile() {
	ObjectInputStream inPut;
	try {
		inPut = new ObjectInputStream (new FileInputStream(file));
		KittyKennel.catList= (ArrayList<Cat>)inPut.readObject();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
