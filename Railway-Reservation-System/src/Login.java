package com.main;

import java.util.Scanner;

public class Login {
	 static Login lo;
	    static User us;
	    static Scanner sc=new Scanner(System.in);
	    public static void main(String[] args) {
	        t:while (true)
	        {
	           
	            System.out.println("1. Ticket Booking \n");
	            System.out.println("2. Exit  \n");
	            System.out.println("Enter the Choice:");
	            
	            int choice=sc.nextInt();
	            sc.nextLine();
	            switch (choice)
	            {
	                case 1:
	                    lo=new Login();
	                    lo.ticketBooking();
	                    break;
	                case 2:
	                    
	                    System.out.println("!!! Thank You !!!");
	                    break t;
	                default:
	                  
	                    System.out.println("Invalid Input");
	                    System.out.println("Press Enter to Continue...");
	                    sc.nextLine();
	            }
	        }
	    }
	    public void ticketBooking() {
	       t: while (true)
	        {
	            
	            System.out.println("1. New User \n");
	            System.out.println("2. Existing User \n");
	            System.out.println("3. Exit \n");
	            System.out.println(" Enter the Choice: ");
	            
	            int choice=sc.nextInt();
	            sc.nextLine();
	            switch (choice)
	            {
	                case 1:
	                    newLogin();
	                    break;
	                case 2:
	                    us=new User();
	                    us.login();
	                    break;
	                case 3:
	                    break t;
	                default:
	                   
	                    System.out.println("Invalid Input");
	                    System.out.println("Press Enter to Continue...");
	                    sc.nextLine();
	            }
	        }
	    }
	    public void newLogin() {
	        
	        System.out.println("**********SIGNING-UP**********\n");
	        System.out.println("Enter User Name: ");
	        String name=sc.nextLine();
	        for(User i:User.uList)
	        {
	            if(i.userName.equals(name))
	            {
	                System.out.println("User Name is Already Exists");
	                System.out.println("Press Enter to Continue...");
	                sc.nextLine();
	                return;
	            }
	        }
	        System.out.println("Enter Pin: ");
	        int pin=sc.nextInt();
	        System.out.println("ReEnter Pin: ");
	        int pin1=sc.nextInt();
	        sc.nextLine();
	        if(pin!=pin1)
	        {
	           
	            System.out.println("Mismatch Pin");
	            System.out.println("Press Enter to Continue...");
	            sc.nextLine();
	            return;
	        }
	        User.uList.add(new User(name, ++User.id, pin, 0));
	        
	        System.out.println("Sign-Up Successfully");
	        System.out.println("Press Enter to Continue...");
	        sc.nextLine();
	        return;
	    }
	}



