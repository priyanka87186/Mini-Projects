package com.main;

import java.util.ArrayList;
import java.util.List;

public class User {
	String userName;
    int userId;
    int pin;
    int amount;

    static int id=100;
    static List<User> uList=new ArrayList<>();
    static {
        uList.add(new User("Komal", 564, 5678, 0));
        uList.add(new User("Priya", 865, 3421, 0));
    }

    static int ticket[][]=new int[10][6];
    static int waitingList[][]=new int[5][3];

    User(String userName, int userId, int pin, int amount){
        this.userName=userName;
        this.userId=userId;
        this.pin=pin;
        this.amount=amount;
    }

    User(){}

    public void login() {
        
        System.out.println("**********SIGNING-IN*******\n");
        System.out.println("Enter User Name: ");
        String name=Login.sc.nextLine();
        int pos=0;
        for(User i:User.uList)
        {
            if(i.userName.equals(name))
            {
                System.out.println("Enter Pin: ");
                int pin=Login.sc.nextInt();
                Login.sc.nextLine();
                if(pin==i.pin)
                {
                    
                    System.out.println("Sign-In Successfully");
                    System.out.println("Press Enter to Continue...");
                    Login.sc.nextLine();
                    logged(i.userId, pos);
                    return;
                }
                
                System.out.println("Wrong Pin");
                System.out.println("Press Enter to Continue...");
                Login.sc.nextLine();
                return;
            }
            pos++;
        }
        System.out.println("User Name is Not Exists");
        System.out.println("Press Enter to Continue...");
        Login.sc.nextLine();
        return;
    }

    public void logged(int user, int pos){
        t:while (true)
        {
            
            System.out.println("1. Book Ticket\n");
            System.out.println("2. Cancel Ticket\n");         
            System.out.println("3. Wallet Amount\n");         
            System.out.println("5. Exit\n");                  
            System.out.println(" Enter the Choice: ");
            
            int choice=Login.sc.nextInt();
            Login.sc.nextLine();
            switch (choice)
            {
                case 1:
                    book(user, pos);
                    break;
                case 2:
                    cancel(user, pos);
                    break;
                case 3:
                    walletAmount(pos);
                    break;
              
                case 5:
                    break t;
                default:
                    
                    System.out.println("Invalid Input\n");
                    System.out.println("Press Enter to Continue...");
                    Login.sc.nextLine();
            }
        }
    }

    public void book(int user, int pos) {
    	
        String arr[]={"City1", "City2", "City3", "City4", "City5", "City6"};
        System.out.println("Select City");
        System.out.println("********TICKET*********\n\nFrom: ");
        for(int i=0;i<6;i++)
        {
            System.out.print(arr[i]+" ("+(i+1)+") ");
        }
        System.out.println("\n\nEnter the Choice: ");
        int choice=Login.sc.nextInt();
        System.out.println("\nTo: ");
        for(int i=choice;i<6;i++)
        {
            System.out.println(arr[i]+" ("+(i+1)+") ");
        }
        System.out.println("\n\nEnter the Choice: ");
        int toChoice=Login.sc.nextInt();
        Login.sc.nextLine();
        
        if(choice>=toChoice)
        {
            System.out.println("Wrong Selection");
            System.out.println("Press Enter to Continue...");
            Login.sc.nextLine();
            return;
        }
        switch(toChoice-choice)
        {
            case 5:
                System.out.println("Your Ticket Amount: RS.240/-");
                if(uList.get(pos).amount>=240)
                {
                    uList.get(pos).amount-=240;
                }
                else
                {
                    System.out.println("\nNot Enough Wallet Balance");
                    System.out.println("Press Enter to Continue...");
                    Login.sc.nextLine();
                    return;
                }
                break;

            case 4:
                System.out.println("Your Ticket Amount: RS.120/-");
                if(uList.get(pos).amount>=120)
                {
                    uList.get(pos).amount-=120;
                }
                else
                {
                    System.out.println("\nNot Enough Wallet Balance");
                    System.out.println("Press Enter to Continue...");
                    Login.sc.nextLine();
                    return;
                }
                break;

            case 3:
                System.out.println("Your Ticket Amount: RS.60/-");
                if(uList.get(pos).amount>=60)
                {
                    uList.get(pos).amount-=60;
                }
                else
                {
                    System.out.println("\nNot Enough Wallet Balance");
                    System.out.println("Press Enter to Continue...");
                    Login.sc.nextLine();
                    return;
                }
                break;

            case 2:
                System.out.println("Your Ticket Amount: RS.40/-");
                if(uList.get(pos).amount>=40)
                {
                    uList.get(pos).amount-=40;
                }
                else
                {
                    System.out.println("\nNot Enough Wallet Balance");
                    System.out.println("Press Enter to Continue...");
                    Login.sc.nextLine();
                    return;
                }
                break;

            case 1:
                System.out.println("Your Ticket Amount: RS.20/-");
                if(uList.get(pos).amount>=20)
                {
                    uList.get(pos).amount-=20;
                }
                else
                {
                    System.out.println("\nNot Enough Wallet Balance");
                    System.out.println("Press Enter to Continue...");
                    Login.sc.nextLine();
                    return;
                }
                break;
        }
        booked(choice-1, toChoice-2, user);
    }

    public void booked(int from, int to, int user) {
        boolean flag=true;
        for(int i=0; i<10; i++)
        {
            int count=0;
            for(int j=from; j<=to; j++)
            {
                if(ticket[i][j]==0)
                {
                    count++;
                }
            }
            if(count==(to-from)+1)
            {
                flag=false;
                for(int j=from; j<=to; j++)
                {
                    ticket[i][j]=user;
                }
                System.out.println("Ticket was Booked Successfully");
                System.out.println("Press Enter to Continue...");
                Login.sc.nextLine();
                break;
            }
        }}
      
    public void cancel(int user, int pos) {
       
        System.out.println("**********CANCEL-TICKET***********\n(Please Note: Cancellation Fees: Rs.10/-)\n");
        System.out.println("Continue (1)/Cancel (0): ");
        int a=Login.sc.nextInt();
        if(a==0)
        {
            return;
        }
        Login.sc.nextLine();
        boolean flag=false;
        int count=0;
        for(int i=0; i<10; i++)
        {
            for(int j=0; j<6; j++)
            {
                if(ticket[i][j]==user)
                {
                    ++count;
                    flag=true;
                    ticket[i][j]=0;
                }
            }
            if(flag)
            {
                switch (count) {
                    case 6:
                        uList.get(pos).amount+=230;
                        break;
                    case 5:
                        uList.get(pos).amount+=110;
                        break;
                    case 4:
                        uList.get(pos).amount+=50;
                        break;
                    case 3:
                        uList.get(pos).amount+=30;
                        break;
                    case 2:
                        uList.get(pos).amount+=10;
                        break;
                }
                System.out.println("\nTicket has Been Canceled\nAmount has been Refunded");
                System.out.println("\n\nPress Enter to Continue...");
                Login.sc.nextLine();
               // waiting();
                return;
            }
        }
        for(int i=0; i<5; i++)
        {
            if(waitingList[i][2]==user)
            {
                int total=waitingList[i][1]-waitingList[i][0];
                waitingList[i][0]=0;
                waitingList[i][1]=0;
                waitingList[i][2]=0;
                switch (total+1) {
                    case 6:
                        uList.get(pos).amount+=230;
                        break;
                    case 5:
                        uList.get(pos).amount+=110;
                        break;
                    case 4:
                        uList.get(pos).amount+=50;
                        break;
                    case 3:
                        uList.get(pos).amount+=30;
                        break;
                    case 2:
                        uList.get(pos).amount+=10;
                        break;
                }
                System.out.println("\nTicket has Been Canceled\nAmount has been Refunded");
                System.out.println("\n\nPress Enter to Continue...");
                Login.sc.nextLine();
                return;
            }

        System.out.println("No Tickets has been Booked");
        System.out.println("Press Enter to Continue...");
        Login.sc.nextLine();
        }
    }

  
    public void walletAmount(int user) {
        t:while(true)
        {
            
            System.out.println(" **********WALLET**********");

            System.out.println("1. Add Wallet Amount\n");
             System.out.println("2. Show Wallet Amount\n");
            System.out.println("3. Exit\n");
            System.out.println(" Enter Your Choice:");
            int choice=Login.sc.nextInt();
            Login.sc.nextLine();

            switch (choice) {
                case 1:
                    
                    System.out.println("*******ADD-WALLET-AMOUNT*******\n");
                    System.out.println("Enter Amount: ");
                    uList.get(user).amount+=Login.sc.nextInt();
                    Login.sc.nextLine();
                    System.out.println("\nAmount Added Successfully\nPress Enter to Continue...");
                    Login.sc.nextLine();
                    break;
                case 2:
                   
                    System.out.println("********WALLET-AMOUNT******\n");
                    System.out.println("Wallet Balance: "+uList.get(user).amount);
                    System.out.println("\nPress Enter to Continue...");
                    Login.sc.nextLine();
                    break;
                case 3:
                    break t;
                default:
                  
                    System.out.println("Invalid Input\nPress Enter to Continue...");
                    Login.sc.nextLine();
                    break;
            }
        }
    }
    }

 


