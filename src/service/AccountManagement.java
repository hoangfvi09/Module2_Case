package service;

import model.Account;
import model.User;

import java.util.ArrayList;

public class AccountManagement {
    private static final AccountManagement INSTANCE= new AccountManagement();
    private ArrayList<Account> accounts;

    public AccountManagement() {
        accounts = new ArrayList<>();
    }

    public static AccountManagement getInstance(){
        return INSTANCE;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    // 2: verify OK, 1: username Ok, wrong password, 0: can't find username
    public int verifyAccount(String username, String password) {
        if (accounts ==null){
            return 0;
        }
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return 2;
            } else if (account.getUsername().equals(username) && !account.getPassword().equals(password)) {
                return 1;
            }
        }
        return 0;
    }

    public boolean addNewAccount(String username, String password, User user) {
        int existingUsername = verifyAccount(username, password);
        if (existingUsername == 0 ) {
            Account newAccount = new Account(username, password, user);
            accounts.add(newAccount);
            return true;
        }
        return false;
    }

    public Account findAccountByUsername(String username) {
        for (Account account:accounts){
            if(account.getUsername().equals(username)){
                return account;
            }
        }
        return null;
    }

    public boolean changePassword(String username, String newPassword){
        for (Account account:accounts){
            if (account.getUsername()==username){
                account.setPassword(newPassword);
                return true;
            }
        }
        return false;
    }

    public String getUsername(User user){

        for (Account account:accounts){
            if (account.getUser()==user){
                return account.getUsername();
            }
        }
        return null;
    }






}
