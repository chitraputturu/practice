package com.learning.java;
import java.util.*;

public class electionsystem {

	public static void main(String[] args) {
		//R1 R2 initialization
		Map<String, Integer> R1_conts = new HashMap<>();
		R1_conts.put("A", 0);
		R1_conts.put("B", 0);
		R1_conts.put("C", 0);
		R1_conts.put("D", 0);
		
		Map<String, Integer> R2_conts = new HashMap<>();
		R2_conts.put("G", 0);
		R2_conts.put("A", 0);
		R2_conts.put("D", 0);
		R2_conts.put("B", 0);
		
		//Voters preferences
		Map<Integer, List<String>> R1_voters = new HashMap<>();
		R1_voters.put(1, new ArrayList<String>());
		R1_voters.get(1).addAll(Arrays.asList("A", "C", "D"));
		R1_voters.put(2, new ArrayList<String>());
		R1_voters.get(2).addAll(Arrays.asList("C", "A"));
		R1_voters.put(3, new ArrayList<String>());
		R1_voters.get(3).addAll(Arrays.asList("A", "C", "Z"));
		R1_voters.put(4, new ArrayList<String>());
		R1_voters.get(4).addAll(Arrays.asList("A", "D", "H"));
		R1_voters.put(5, new ArrayList<String>());
		R1_voters.get(5).addAll(Arrays.asList("A", "D", "D"));
		
		Map<Integer, List<String>> R2_voters = new HashMap<>();
		R2_voters.put(4, new ArrayList<String>());
		R2_voters.get(4).addAll(Arrays.asList("A", "G", "D", "F"));
		R2_voters.put(5, new ArrayList<String>());
		R2_voters.get(5).addAll(Arrays.asList("D", "B", "A"));
		R2_voters.put(1, new ArrayList<String>());
		R2_voters.get(1).addAll(Arrays.asList("D", "B", "A", "D"));
		
		//To know duplicate voter
		Set<Integer> S = new HashSet<Integer>(R1_voters.keySet());
		S.retainAll(R2_voters.keySet());
		//System.out.println(S);
		Iterator<Integer> iter = S.iterator();
		
		//removing duplicate voters from R2
		while(iter.hasNext())
		{
			//System.out.println(iter.next());
			R2_voters.remove(iter.next());
		}
		//System.out.println(R2_voters);
		
		//finding invalid voter
		
		/*for(int key : R1_voters.keySet())
		{
			//System.out.println(key);
			//System.out.println(R1_voters.get(key));
			List<String> al = R1_voters.get(key);
			if(al.size()==0 || al.size()>3)
			{
				System.out.println(key);
				R1_voters.remove(key);
			}
		}*/
		Iterator itr_R1 = R1_voters.entrySet().iterator();
	    while (itr_R1.hasNext()) {
	        Map.Entry pair = (Map.Entry)itr_R1.next();
	        //System.out.println(pair.getKey() + " = " + pair.getValue());
	        List<String> al_R1 = (List<String>) pair.getValue();
			if(al_R1.size()==0 || al_R1.size()>3)
			{
				System.out.println(pair.getKey());
				itr_R1.remove(); // avoids a ConcurrentModificationException
			}
	    }
		//System.out.println(R1_voters);
		
		Iterator itr_R2 = R2_voters.entrySet().iterator();
	    while (itr_R2.hasNext()) {
	        Map.Entry pair = (Map.Entry)itr_R2.next();
	        //System.out.println(pair.getKey() + " = " + pair.getValue());
	        List<String> al_R2 = (List<String>) pair.getValue();
			if(al_R2.size()==0 || al_R2.size()>3)
			{
				System.out.println(pair.getKey());
				itr_R2.remove(); // avoids a ConcurrentModificationException
			}
	    }
	    //System.out.println(R2_voters);
	    
	    //allot votes to the contestants
	    Iterator itr_R1_map = R1_voters.entrySet().iterator();
	   while(itr_R1_map.hasNext())
	   {
		   Map.Entry pair1 = (Map.Entry)itr_R1_map.next();
	       //System.out.println(pair1.getKey() + " = " + pair1.getValue());
	       List<String> al_R1 = (List<String>) pair1.getValue();
	       //System.out.println(al_R1);
	       for(int i=0;i<al_R1.size();i++)
	       {
	    	 //System.out.println(al_R1.get(i));
	    	 if(R1_conts.containsKey(al_R1.get(i)))
	    	 {
			    	 if(i==0)
			    	 {
			    		// int val = R1_conts.get(al_R1.get(i));
			    		 //System.out.println(val);
			    		 R1_conts.put(al_R1.get(i), R1_conts.get(al_R1.get(i)) + 3);
			    		 //System.out.println(R1_conts.get(al_R1.get(i)));
			    	 }
			    	 if(i==1)
			    	 {
			    		 R1_conts.put(al_R1.get(i), R1_conts.get(al_R1.get(i)) + 2);
			    	 }
			    	 if(i==2)
			    	 {
			    		 R1_conts.put(al_R1.get(i), R1_conts.get(al_R1.get(i)) + 1);
			    	 }
	    	 }
	       }
	       //System.out.println(R1_conts);
	   }
	   System.out.println(R1_conts);
	   
	   Iterator itr_R2_map = R2_voters.entrySet().iterator();
	   while(itr_R2_map.hasNext())
	   {
		   Map.Entry pair2 = (Map.Entry)itr_R2_map.next();
	       List<String> al_R2 = (List<String>) pair2.getValue();
	       for(int i=0;i<al_R2.size();i++)
	       {
	    	 if(R2_conts.containsKey(al_R2.get(i)))
	    	 {
			    	 if(i==0)
			    	 {
			    		 R2_conts.put(al_R2.get(i), R2_conts.get(al_R2.get(i)) + 3);
			    	 }
			    	 if(i==1)
			    	 {
			    		 R2_conts.put(al_R2.get(i), R2_conts.get(al_R2.get(i)) + 2);
			    	 }
			    	 if(i==2)
			    	 {
			    		 R2_conts.put(al_R2.get(i), R2_conts.get(al_R2.get(i)) + 1);
			    	 }
	    	 }
	       } 
	   }
	   System.out.println(R2_conts);
	   
	   //getting the highest votes contestant
	   
	   Collection c = R1_conts.values();
	   int max_val = (int) Collections.max(c);
	   //System.out.println(Collections.max(c));
	   //String Contestant = R2_conts.get(max_val);
	   Iterator itr_R1_conts = R1_conts.entrySet().iterator();
	   while(itr_R1_conts.hasNext())
	   {
		   Map.Entry pair = (Map.Entry)itr_R1_conts.next();
	       //System.out.println(pair.getKey() + " = " + pair.getValue());
		   String contestant = (String) pair.getKey();
		   int votes = (int) pair.getValue();
		   if(votes!= 0 && votes == max_val)
		   {
			   if(contestant!= null)
			   {
				   System.out.println("The winner of Region 1 is : "+contestant);
			   }
			   else if(contestant== null)
			   {
				   System.out.println("There is no winner");
			   }
		   }
	        
	   }
	   
	   Collection c1 = R2_conts.values();
	   int max_val1 = (int) Collections.max(c1);
	   //System.out.println(Collections.max(c1));
	   Iterator itr_R2_conts = R2_conts.entrySet().iterator();
	   while(itr_R2_conts.hasNext())
	   {
		   Map.Entry pair = (Map.Entry)itr_R2_conts.next();
		   String contestant = null;
		   contestant = (String) pair.getKey();
		   //System.out.println(contestant);
		   int votes = (int) pair.getValue();
		   if(votes!= 0 && votes == max_val1)
		   {
			   if(contestant!= null)
			   {
				   System.out.println("The winner of Region 2 is : "+contestant);
			   }
		   }
		   else if(max_val1== 0)
		   {
			   System.out.println("There is no winner in Region 2");
		   }
	        
	   }
	}

}
