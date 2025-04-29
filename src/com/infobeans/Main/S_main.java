package com.infobeans.Main;
import com.infobeans.model.*;
import com.infobeans.Service.*;
import java.util.*;
import java.sql.*;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
  public class S_main {
	

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			boolean flag=false;
		//----------------------------------------------------------------------LOGIN DONE
		
		
			String login;
			while(true) { 
				Scanner sc1 = new Scanner(System.in);
			System.out.println("----------------------------ADMIN DASHBOARD-----------------------------\n"
					          + "|--------------------------Enter your credential-------------------------");
			 login =sc1.nextLine();
			for(int i=0;i<5;i++) {
			if(login.equals("admin") || login.equals("user")||login.equals("fee")) {
				System.out.println("LOGIN SUCCESSFLLY");
				flag= true;
				
				break;
			}
			else 
				System.out.println("---LOGIN FAILED");
			break;
			
			}
			if(flag==true)
			break; }
		
				while(true) {
			//=========================================================================
					if(login.equals("admin")) {
						System.out.println("|------------------------------------------------------|");
						System.out.println("WELCOME ADMIN");
						System.out.println(" AVAILABLE FUNCTIONS FOR OUR SCHOOL  MANAGEMENT  SYSTEM.");
						System.out.println("|------------------------------------------------------|");
				System.out.println("  1 for Inserting data \n "
						+ 																     "2 for Fetching  \n "
						+ 																	 "3 for Find to check fees \n"
						+ 																	 "4 for Update by id /n"
						+ 																	 "5 for deletion by id \n"
						+ 																	 "6 number of student \n"
						+ 																	 "7 for teacher and class \n"
						+ 																	 "8 for best perorming students \n"
						+ 																	 "9 for find highest attendencce \n"
						+ 																	 "10 for adding teacher details \n"
						+ 																	 "11 for deleting teacher \n"
						+ 																	 "12 for finding best performing teacher \n"
						+ 																	 "13 for finding fees infomation \n"
						+ 																	 "14 for updating teacher id \n"
						+ 																	 "16 for depsoting the fees  \n"
						+ 																	  "0 for log out");
				
					}
					if(login.equals("user")) {  
						System.out.println("|------------------------------------------------------|");
						System.out.println("|-------------------WELCOME USER-----------------------|");
						System.out.println(" AVAILABLE FUNCTIONS FOR OUR SCHOOL  MANAGEMENT  SYSTEM.");
						System.out.println("|------------------------------------------------------|");
				System.out.println( "1 number of student \n"
						+ 			"7 for teacher and class \n"
						+ 		    "8 for best perorming students \n"
						+ 		    "9 for find highest attendencce \n"
						+			"0 for log out ");
				
					}
				
			if(login.equals("fee")) {
				System.out.println("|------------------------------------------------------|");
				System.out.println("|--------------WELCOME TO THE FEES DEPARTMENT----------|");
				System.out.println(" AVAILABLE FUNCTIONS FOR OUR SCHOOL  MANAGEMENT  SYSTEM.");
				System.out.println("|------------------------------------------------------|");
		System.out.println( 
				 																     "1 for Fetching  \n "
				+ 																	 "3 for Find to check fees \n"
				+ 																	 "6 number of student \n"
				+ 																	 "13 for finding fees infomation \n"
				+ 																	 "16 for depositing fees \n"
				+ 																	 "0 for log out ");
		
			}
			 		         
			int choice =Integer.parseInt(sc.nextLine());
			S_service objofservice = new S_service();
			Teacher ts = new Teacher(0,"","");
			Fianance fs = new Fianance(0,0,0);
			fee objoffee = new fee("",0);
			List<Integer>nn = new ArrayList<Integer>();
			switch(choice) {	 
			
				case 1:
					try {
						if(login.equals("admin")) {
				System.out.println("Enter id ");
				int id =Integer.parseInt(sc.nextLine());
				System.out.println("Enter your  name ");
				String name = sc.nextLine();
				// System.out.println("Enter your father name ");
			// 	String f_name=sc.nextLine();
				System.out.println("Enter class");
				int s_class = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter t_id");
				int t_id = Integer.parseInt(sc.nextLine());
					Student obj = new Student(id,name,s_class,t_id);
					objofservice.getAdd(obj);
					break;
			}
						else {
							System.out.println("Yoc cannot insert ");
							break;
						}
					}
				catch(NumberFormatException r) {
					System.out.println("Entered name in place ofc class");
				}
			catch(Exception E){
				System.out.println("An error occured ");
			}
					//--------------------------------------------------second functionality
				case 2: 		
			try {
				List<Student> newlist = objofservice.getAll();
				if(newlist.isEmpty())
					System.out.println("No record found");
				for(Student S: newlist) {
					System.out.print(S.getS_id()+"| ");
					System.out.print(S.getS_name()+"| ");
					System.out.print(S.getS_class()+"| ");
					System.out.print(S.getT_id()+"| ");
					System.out.println();
					
				}
				break;
			}
				catch(Exception e ) {
					System.out.println("Error occured");
				}
			
			
				case 3:
					try {
						if(login.equals("admin")||login.equals("fee")) {
					System.out.println("Enter s_id");
					int s_id = Integer.parseInt(sc.nextLine());
//					System.out.println("Enter f_id");
//					int f_id = Integer.parseInt(sc.nextLine());
					List<Fianance> newlist = objofservice.getbyfees(s_id);
					if(newlist.isEmpty())
						System.out.println("no record  found");
					for(Fianance A : newlist) {
						System.out.print(A.getS_id()+"  ");
						System.out.print(A.getFee_id()+"  ");
						System.out.print(A.getFees()+"  ");
						System.out.println();
						System.out.print("the remaining fees is :"+(A.getFees()-A.getFixed()));
					// 	System.out.print(S.getT_id());
//						System.out.print(fs.getFee_id());
						System.out.println();
						
					}
					break;
						}
						else {
							System.out.println("You cannot acces the record");
						}
			} 
			catch(Exception E) {
				System.out.println("error occured");
			}
			//-----------------------------==fourth function update and delte 
				case 4:
					try{
						System.out.println("enter id to update name");
						int id =Integer.parseInt(sc.nextLine());
						System.out.println("Enter new name ");
						String name = sc.nextLine();
						objofservice.getUpdate(id,name);
					break;
					}
					catch(Exception e) {
						System.out.println("Error occured");
					}
			
				case 5:
					try {
						if(login.equals("admin")){
					System.out.println("Enter id to delete");
					int id = Integer.parseInt(sc.nextLine());
					objofservice.getDelete(id);
					break;
					} 
						else {
							System.out.println("You canot delete record");
							break;
						}
					}
					catch(Exception e) {
						System.out.println("Error occured");
					}
				case 6:
					if(login.equals("admin")||login.equals("fee")) {
					System.out.println("Enter class to find no.of student");
					int cl =Integer.parseInt(sc.nextLine());
					objofservice.getClass1(cl);
					break;
					}
					else {
						System.out.println("You cannot access the record");
						break;
					}
				case 7:
					try {
						if(login.equals("admin")||login.equals("user")){
					System.out.println("Enter teacher _id to find student tought");
					int id = Integer.parseInt(sc.nextLine());
					List<Student>newList = objofservice.getbyt(id);
					if(newList.isEmpty()) {
						System.out.println("No record found");
					}
					else {
						System.out.println("The teacher teachces the following students");
						for(Student S: newList) {
							System.out.print(S.getS_class()+"  ");
							System.out.print(S.getS_name()+"  ");
							System.out.print(S.getS_class()+"  ");
							System.out.println();
						}
					}}
						else {
							System.out.println("You cannot access the record");
							break;
						}
					 break ;}
					catch(Exception e) {
						System.out.println("An error occured");
					}
					//---------------------
				case 8:
					if(login.equals("admin")||login.equals("fee")) {
					List<Student>newList = objofservice.gett1();
					if(newList.isEmpty()) {
						System.out.println("No record found");
						break;
					}
					else {
						System.out.println("The best  students");
						for(Student S: newList) {
						//	System.out.print(S.getS_class()+"  ");
							System.out.print(S.getS_name()+"  ");
						//	System.out.print(S.getS_class()+"  ");
							System.out.println();
						}
					} break;}
					else {
						System.out.println("You can not access the record");
						break;
					}
					
					//--------------------------------------------nith function
				case 9:
					try {
						if(login.equals("admin")||login.equals("fee")) {
					System.out.println("Enter day as cut of ");
					int day = Integer.parseInt(sc.nextLine());
					List<Student>newList1 = objofservice.gett2(day);
					if(newList1.isEmpty()) {
						System.out.println("No record found");
					}
					else {
						System.out.println("The best  students");
						for(Student S: newList1) {
						//	System.out.print(S.getS_class()+"  ");
							System.out.print(S.getS_name()+"  ");
						//	System.out.print(S.getS_class()+"  ");
							System.out.println();
						}
					} break; }
					break ;}
					catch(Exception e) {
						System.out.println("error occured ");
					}
					//---------------------------------------------------------10
				case 10:
					try { 
					if(login.equals("admin")){
					System.out.println("Enter teacher t_id");
					int id = Integer.parseInt(sc.nextLine());
					System.out.println("Enter name ");
					String name = sc.nextLine();
					System.out.println("Enter your expertise");
					String exp = sc.nextLine();
					Teacher obj = new Teacher(id,name,exp);
					objofservice.addTeacher(obj);
					break;
			}
			else 
				System.out.println("You cannot enter teacher details");
					}
					catch(Exception e) {
						System.out.println("An error occured ");
						break;
					}
				case 11:
					try {
						if(login.equals("admin")){
					System.out.println("Enter id to delete");
					int id = Integer.parseInt(sc.nextLine());
					objofservice.getDelete(id);
					break;
					} 
						else {
							System.out.println("You canot delete record");
							break;
						}
					}
					catch(Exception e) {
						System.out.println("Error occured");
						break;
					}
					
				case 12:
						if(login.equals("admin")) {
						System.out.println("Enter the percentage criteria please  ");
						int day = Integer.parseInt(sc.nextLine());
						List<Student>newList1 = objofservice.testper(day);
						if(newList1.isEmpty()) {
							System.out.println("No record found");
						}
						else {
							System.out.println("The best performing teacher ");
							for(Student S: newList1) {
							//	System.out.print(S.getS_class()+"  ");
								System.out.print(S.getT_id());
							//	System.out.print(S.getS_class()+"  ");
								// nn.add(S.getT_id());
								System.out.println();
							}
						}}
						else {
							System.out.println("you can not view the details");
							break;
						}
						break ;
						//-------------------------------------------------------------13
				case 13:
					if(login.equals("admin")||login.equals("fee")) {
					objofservice.feeMethod();
					 break;
					}
					else {
						System.out.println("you can not view the details");
						break;
					}
					//----------------------------------------------------------------14
				case 14:
					
					try{
						if(login.equals("admin")){
						System.out.println("enter your teacher id");
						int old_id =Integer.parseInt(sc.nextLine());
						System.out.println("enter your new id ");
						int new_id = Integer.parseInt(sc.nextLine());
						objofservice.getUpdateteacher(old_id,new_id);
					break;
					}
			else {
				System.out.println("you can not edit the data");
				break;
			}}
					
							catch(Exception e) {
						System.out.println("Error occured");
						break;
					}
					//------------------------------------------------------------------16
				case 15:
					if(login.equals("admin")||login.equals("fee")) {
					List<Teacher>newList12 = objofservice.allteacher();
					if(newList12.isEmpty()) {
						System.out.println("No record found");
						break;
					}
					else {
						System.out.println("The teacher teachces the following students");
						for(Teacher S: newList12) {
							System.out.print(S.getT_id()+"   ");
							System.out.print(S.getT_name()+"  ");
							System.out.print(S.getExpert()+"  ");
							System.out.println();
						}
					}
					break; }
					else {
						System.out.println("You cannot access the record");
						break;
					}
				case 16:
					try {
						if(login.equals("admin")|| login.equals("fee")) {
				System.out.println("Enter fees  id ");
				int id =Integer.parseInt(sc.nextLine());
				System.out.println("Enter your  s_id ");
				int id1 =Integer.parseInt(sc.nextLine());
				 System.out.println("Enter your fees amount ");
				 int fees =Integer.parseInt(sc.nextLine());
				 Fianance obj = new Fianance(id,id1,fees);
					objofservice.depositfee(obj);
					break;
			}
						else {
							System.out.println("Yoc cannot insert ");
							break;
						}
					}
				catch(NumberFormatException r) {
					System.out.println("Entered name in place ofc class");
					break;
				}
				
				default:
						System.out.println("Log out");
						System.exit(0);
			}// swithch
			
			
			//String s=sc.nextLine();
				//=======================================
			
					// sunday ko or function bhi add karna he 
				//=================================
	
	

		
		
	
	}
  }
  
  }
