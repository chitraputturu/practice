package com.learning.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingData {

	public static void main(String[] args) {
		File file = new File("voting.dat");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			 sc.useDelimiter("/");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		while(sc.hasNextLine()){
		   String region = sc.next();
		   String contestants = sc.next(); 
		   System.out.println(region+" "+contestants);
		}

	}

}
