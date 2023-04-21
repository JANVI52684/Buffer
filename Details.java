//System.out.print("");
package Project;
import java.util.*;
public class Details {
	static LinkedList<Stack> ll = new LinkedList<>();
	static Scanner sc = new Scanner(System.in);
	public static void display(Stack<Integer> bal)
    {
        if(bal.empty())
        return;
        
        int x = bal.peek();
        bal.pop();
        System.out.println(x);
        display(bal);
        bal.push(x);
    }
	public static void features(int n) {
		int InitialBalance = 5000;
        int cho;
        Scanner ob=new Scanner(System.in);
        Stack<Integer> bal = new Stack<Integer>();
        Stack<Integer> history = new Stack<Integer>();
        bal.add(InitialBalance);
        do
        {
        System.out.println("\n**Home Page**");    
        System.out.println("1.Check balance");
        System.out.println("2.Fund Transfer");
        System.out.println("3.Transaction History");    
        System.out.println("4.Loan\n5.Check Bank details");    
        System.out.println("0.Exit\n");
        System.out.println("Enter your Choice");    
        cho=sc.nextInt();
        switch(cho)    
        {
        case 1: 
        	System.out.println("*Check balance*");
        	System.out.println(bal.pop());
        	break;

        case 2:
            System.out.println("*Fund Transfer*");    
            System.out.println("1. Withdraw");    
            System.out.println("2. Deposit");    
            System.out.println("3. Transfer to another account");    
            System.out.println("Enter your choice :");
            int ch3 = sc.nextInt();
            switch(ch3)
            {
            case 1:
                System.out.println("*Withdraw*");    
                System.out.println("Enter the amount");
                int w = ob.nextInt();
                history.add(-w);
                if(w<InitialBalance)
                {
                    InitialBalance=InitialBalance-w;
                    bal.push(InitialBalance);
//                    System.out.println("New Balance : " + InitialBalance);
                }
                else
                {
                    System.out.println("Insuffient Balance\n Money cannot be withdrawn");
                }
                break;
                
            case 2:
                System.out.println("*Deposit*");    
                System.out.println("Enter the amount");
                int d = ob.nextInt();
                history.add(+d);
                InitialBalance=InitialBalance+d;
                bal.push(InitialBalance);
//                System.out.println("New Balance : " + InitialBalance);
                break;
                
            case 3:
                System.out.println("*Transfer to another account*");    
                System.out.println("Enter sender account number : ");    
                System.out.println("Enter receiver account number : ");    
                break;        
            }
            break;
            
        case 3:
            System.out.println("*Transaction History*");
            display(history);
            break;
            
        case 4:
            System.out.println("Loan");
            System.out.println("Enter account number");
            break;
            
        case 5: 
        	for(int i=0;i<ll.size();i++){
               System.out.println("Account "+(i+1)+": "+ll.get(i));
            }
        	break;
            
        case 0:
            System.out.println("Thank you");
            System.exit(0);

          }
        }while(cho!=6);
	}
	public static void main(String[] args) {
        System.out.println("Hello User!!!");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Set MPIN: ");
        String mpin = sc.next();
        System.out.println("No of account to be added: ");
   	    int n= sc.nextInt();
        for(int i=0;i<=n-1;i++){
            System.out.println("Add bank account\n1)Yes\n2)later");
            int ch=sc.nextInt();
            switch(ch){
                case 1: 
                	Stack<String> stk = new Stack<>();
                	System.out.print("IFSC code: ");
                String ifcs = sc.next();
                stk.add(ifcs);
                System.out.print("Account no: ");
                String acc = sc.next();
                stk.add(acc);
                System.out.print("CRN: ");
                String crn = sc.next();
                stk.add(crn);
                ll.add(stk);
                System.out.println("Account added Succefully!!!!");
                break;
                case 2: 
                System.out.println("Home page loading");
                features(n);
                break;
                default: System.out.println("Invalid input");
                break;
            }
        }
        features(n);
	}

}
