/* Class: CMSC203 CRN 22297
*Program: Lab 6
*Instructor: Grigoriy Grinberg
*Summary of Description: In this lab, you will be creating new classes that are derived from a 
 class called BankAccount. A checking account is a bank account and a savings account is a bank 
 account as well. This sets up a relationship called inheritance, where BankAccount is the superclass
 and CheckingAccount and SavingsAccount are subclasses. This relationship allows CheckingAccount to 
 inherit attributes from BankAccount (like owner, balance, and accountNumber, but it can have new attributes
 that are specific to a checking account, like a fee for clearing a check. It also allows CheckingAccount 
 to inherit methods from BankAccount, like deposit, that are universal for all bank accounts. You will write
 a withdraw method in CheckingAccount that overrides the withdraw method in BankAccount, in order to do something
 slightly different than the original withdraw method. You will use an instance variable called accountNumber in 
 SavingsAccount to hide the accountNumber variable inherited from BankAccount.  
*Due Date: 08NOV2021
*Integrity Pledge: I pledge that I have completed the programming assignment independently.
*I have not copied the code from a student or any source.
*Student: Daniel Cortes Gratacos
*/

/*
 * This class represents the savings account
 */

public class SavingsAccount extends BankAccount{
    private double rate;
    private int savingsNumber=-1;
    private String accountNumber;
    
    //Constructor for savings account
    public SavingsAccount(String name, double initialBalance)
    {
        super(name,initialBalance);
        accountNumber = "";
        rate = 2.5;
    }
    //Copy constructor for savings account
    public SavingsAccount(SavingsAccount oldAccount, double amount)
    {
        super(oldAccount,amount);
        savingsNumber+=1;
    }
    //Calculate monthly fees
    public void postInterest()
    {
        rate = (rate/100)/12;
        setBalance((getBalance()*rate)+getBalance());
    }
    //Return the account number
    public String getAccountNumber()
    {
        savingsNumber+=1;
        accountNumber = super.getAccountNumber()+"-"+savingsNumber;
        
        return accountNumber;
    }
}