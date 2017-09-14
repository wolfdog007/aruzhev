package ru.job4j.map4bank;

import ru.job4j.map4bank.exceptions.AccountFundsException;
import ru.job4j.map4bank.exceptions.AccountNotFoundException;
import ru.job4j.map4bank.exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class start Banking - method for for working with user payments, User and Account.
 *
 * @author Ruzhev Alexander
 * @since 13.09.2017
 */
public class BankOperations {
    /**
     * Storage Users and Accounts.
     */
    private Map<User, List<Account>> userListMap = new HashMap<>();

    /**
     * Getter for userListMap.
     *
     * @return userListMap
     */
    public Map<User, List<Account>> getMapBanking() {
        return this.userListMap;
    }

    /**
     * Add new user to userListMap.
     *
     * @param user - new user
     */
    public void addUser(User user) {
        this.userListMap.put(user, new ArrayList<>());
    }

    /**
     * Remove user.
     *
     * @param user - user for delete
     * @throws UserNotFoundException - not find User in userListMap
     */
    public void deleteUser(User user) throws UserNotFoundException {
        if (this.userListMap.containsKey(user)) {
            this.userListMap.remove(user);
        } else {
            throw new UserNotFoundException("User is not found.");
        }
    }

    /**
     * Adds a new account for user.
     *
     * @param user    - key for userListMap
     * @param account - new account
     * @throws UserNotFoundException - not find User in userListMap
     */
    public void addAccountToUser(User user, Account account) throws UserNotFoundException {
        if (account != null) {
            if (this.userListMap.containsKey(user)) {
                this.userListMap.get(user).add(account);
            } else {
                throw new UserNotFoundException("User is not found.");
            }
        }
    }

    /**
     * Delete account from user.
     *
     * @param user    - key for userListMap
     * @param account - account deletion
     * @throws UserNotFoundException - not find User in userListMap
     * @throws AccountFundsException - not find account in userListMap
     */
    public void deleteAccountFromUser(User user, Account account) throws UserNotFoundException, AccountFundsException {
        if (this.userListMap.containsKey(user)) {
            if (this.getUserAccounts(user).contains(account)) {
                this.userListMap.get(user).remove(account);
            } else {
                throw new AccountNotFoundException("Account is not found.");
            }
        } else {
            throw new UserNotFoundException("User is not found.");
        }
    }

    /**
     * Get the list of accounts.
     *
     * @param user - key for userListMap
     * @return list of accounts
     * @throws UserNotFoundException - not find User in userListMap
     */
    public List<Account> getUserAccounts(User user) throws UserNotFoundException {
        List resultList;
        if (this.userListMap.containsKey(user)) {
            resultList = this.userListMap.get(user);
        } else {
            throw new UserNotFoundException("User is not found.");
        }
        return resultList;
    }

    /**
     * Calculates possible transfer of money from one account to another.
     *
     * @param srcUser    - user from account
     * @param srcAccount - account to be transferred
     * @param dstUser    - the user whose account is to be paid
     * @param dstAccount - account to be transfer for
     * @param amount     -  transfer amount
     * @return validate - true transfer is possible, false is not possible
     * @throws UserNotFoundException    - not find User in userListMap
     * @throws AccountNotFoundException - not find account in userListMap
     * @throws AccountFundsException    - insufficient funds on account
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) throws UserNotFoundException, AccountNotFoundException, AccountFundsException {
        boolean validate = false;
        if (this.userListMap.containsKey(srcUser) && this.userListMap.containsKey(dstUser)) {
            if (this.userListMap.get(srcUser).contains(srcAccount) && this.userListMap.get(dstUser).contains(dstAccount)) {
                if (srcAccount.getValue() - amount >= 0) {
                    validate = true;
                    srcAccount.setValue(srcAccount.getValue() - amount);
                    dstAccount.setValue(dstAccount.getValue() + amount);
                } else {
                    throw new AccountFundsException("Insufficient account funds.");
                }
            } else {
                throw new AccountNotFoundException("Account is not found.");
            }
        } else {
            throw new UserNotFoundException("Translation is not possible, one of the users is not found.");
        }
        return validate;
    }
}
