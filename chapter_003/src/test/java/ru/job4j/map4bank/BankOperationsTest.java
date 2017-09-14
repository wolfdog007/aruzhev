package ru.job4j.map4bank;

import org.junit.Test;
import ru.job4j.map4bank.exceptions.AccountFundsException;
import ru.job4j.map4bank.exceptions.AccountNotFoundException;
import ru.job4j.map4bank.exceptions.UserNotFoundException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Test class for BankOperations.
 *
 * @author Ruzhev Alexander
 * @since 13.09.2017
 */
public class BankOperationsTest {
    /**
     * Test addUser.
     */
    @Test
    public void whenAddUser() {
        BankOperations bankOperations = new BankOperations();
        User user = new User("Alexander", "4009858755");
        bankOperations.addUser(user);
        assertThat(bankOperations.getMapBanking().containsKey(user), is(true));
    }

    /**
     * Test deleteUser.
     */
    @Test
    public void whenDeleteUser() {
        BankOperations bankOperations = new BankOperations();
        User user1 = new User("Alexander", "4009858755");
        User user2 = new User("Denis", "4009858788");
        bankOperations.addUser(user1);
        bankOperations.addUser(user2);
        bankOperations.deleteUser(user1);
        assertThat(bankOperations.getMapBanking().containsKey(user1), is(false));
    }

    /**
     * Test deleteUser to UserNotFoundException.
     *
     * @throws UserNotFoundException - user not found
     */
    @Test(expected = UserNotFoundException.class)
    public void whenDeleteUserThenUserNotFoundException() throws UserNotFoundException {
        BankOperations bankOperations = new BankOperations();
        User user1 = new User("Alexander", "4009858755");
        bankOperations.deleteUser(user1);
    }

    /**
     * Test addAccountToUser.
     */
    @Test
    public void whenAddAccountToUser() {
        BankOperations bankOperations = new BankOperations();
        User user1 = new User("Alexander", "4009858755");
        bankOperations.addUser(user1);
        Account account = new Account(123, 500);
        bankOperations.addAccountToUser(user1, account);
        assertThat(bankOperations.getUserAccounts(user1).contains(account), is(true));
    }

    /**
     * Test addAccountToUser to UserNotFoundException.
     *
     * @throws UserNotFoundException - user not found
     */
    @Test(expected = UserNotFoundException.class)
    public void whenAddAccountToUserThenUserNotFoundException() throws UserNotFoundException {
        BankOperations bankOperations = new BankOperations();
        User user1 = new User("Alexander", "4009858755");
        Account account = new Account(123, 500);
        bankOperations.addAccountToUser(user1, account);
    }

    /**
     * Test deleteAccountFromUser.
     */
    @Test
    public void whenDeleteAccountFromUser() {
        BankOperations bankOperations = new BankOperations();
        User user1 = new User("Alexander", "4009858755");
        User user2 = new User("Denis", "4009858788");
        bankOperations.addUser(user1);
        bankOperations.addUser(user2);
        Account account = new Account(500, 123);
        Account account1 = new Account(500, 321);
        bankOperations.addAccountToUser(user1, account);
        bankOperations.addAccountToUser(user2, account1);
        bankOperations.deleteAccountFromUser(user1, account);
        assertThat(bankOperations.getUserAccounts(user1).contains(account1), is(false));
    }

    /**
     * Test deleteAccountFromUser to UserNotFoundException.
     * @throws UserNotFoundException - user not found
     */
    @Test(expected = UserNotFoundException.class)
    public void whenDeleteAccountFromUserThenUserNotFoundException() {
        BankOperations bankOperations = new BankOperations();
        User user1 = new User("Alexander", "4009858755");
        User user2 = new User("Denis", "4009858788");
        bankOperations.addUser(user1);
        Account account = new Account(500, 123);
        bankOperations.addAccountToUser(user1, account);
        bankOperations.deleteAccountFromUser(user2, account);
    }

    /**
     * Test deleteAccountFromUser to AccountNotFoundException.
     * @throws AccountNotFoundException - account not found
     */
    @Test(expected = AccountNotFoundException.class)
    public void whenDeleteAccountFromUserThenAccountFundsException() {
        BankOperations bankOperations = new BankOperations();
        User user1 = new User("Alexander", "4009858755");
        bankOperations.addUser(user1);
        Account account = new Account(123, 500);
        Account account2 = new Account(321, 500);
        bankOperations.addAccountToUser(user1, account);
        bankOperations.deleteAccountFromUser(user1, account2);
    }

    /**
     * Test getUserAccounts.
     */
    @Test
    public void whenGetUserAccounts() {
        BankOperations bankOperations = new BankOperations();
        User user1 = new User("Alexander", "4009858755");
        bankOperations.addUser(user1);
        Account account = new Account(123, 500);
        Account account2 = new Account(321, 500);
        bankOperations.addAccountToUser(user1, account);
        bankOperations.addAccountToUser(user1, account2);
        assertThat(bankOperations.getUserAccounts(user1).contains(account), is(true));
        assertThat(bankOperations.getUserAccounts(user1).contains(account2), is(true));
    }

    /**
     * Test getUserAccounts to UserNotFoundException.
     * @throws UserNotFoundException - user not found
     */
    @Test(expected = UserNotFoundException.class)
    public void whenGetUserAccountsThenUserNotFoundException() {
        BankOperations bankOperations = new BankOperations();
        User user1 = new User("Alexander", "4009858755");
        Account account = new Account(123, 500);
        bankOperations.addAccountToUser(user1, account);
    }

    /**
     * Test TransferMoney.
     */
    @Test
    public void whenTransferMoneyThenValidationTrue() {
        BankOperations bankOperations = new BankOperations();
        User user1 = new User("Alexander", "4009858755");
        User user2 = new User("Denis", "4009858788");
        bankOperations.addUser(user1);
        bankOperations.addUser(user2);
        Account account1 = new Account(500, 123);
        Account account2 = new Account(500, 321);
        bankOperations.addAccountToUser(user1, account1);
        bankOperations.addAccountToUser(user2, account2);
        assertThat(true, is(bankOperations.transferMoney(user1, account1, user2, account2, 100)));
        assertThat(400.0, is(bankOperations.getUserAccounts(user1).get(0).getValue()));
        assertThat(600.0, is(bankOperations.getUserAccounts(user2).get(0).getValue()));
    }

    /**
     * Test TransferMoney to UserNotFoundException.
     * @throws UserNotFoundException - user not found
     */
    @Test(expected = UserNotFoundException.class)
    public void whenTransferMoneyThenUserNotFoundException() {
        BankOperations bankOperations = new BankOperations();
        User user1 = new User("Alexander", "4009858755");
        User user2 = new User("Denis", "4009858788");
        bankOperations.addUser(user1);
        Account account1 = new Account(500, 123);
        Account account2 = new Account(500, 321);
        bankOperations.addAccountToUser(user1, account1);
        assertThat(true, is(bankOperations.transferMoney(user1, account1, user2, account2, 100)));
    }

    /**
     * Test TransferMoney to AccountNotFoundException.
     * @throws AccountNotFoundException - account not found
     */
    @Test(expected = AccountNotFoundException.class)
    public void whenTransferMoneyThenAccountNotFoundException() {
        BankOperations bankOperations = new BankOperations();
        User user1 = new User("Alexander", "4009858755");
        User user2 = new User("Denis", "4009858788");
        bankOperations.addUser(user1);
        bankOperations.addUser(user2);
        Account account1 = new Account(500, 123);
        Account account2 = new Account(500, 321);
        bankOperations.addAccountToUser(user1, account1);
        assertThat(true, is(bankOperations.transferMoney(user1, account1, user2, account2, 100)));
    }

    /**
     * Test TransferMoney to AccountFundsException.
     * @throws AccountFundsException - insufficient funds on account
     */
    @Test(expected = AccountFundsException.class)
    public void whenTransferMoneyThenAccountFundsException() {
        BankOperations bankOperations = new BankOperations();
        User user1 = new User("Alexander", "4009858755");
        User user2 = new User("Denis", "4009858788");
        bankOperations.addUser(user1);
        bankOperations.addUser(user2);
        Account account1 = new Account(0, 123);
        Account account2 = new Account(500, 321);
        bankOperations.addAccountToUser(user1, account1);
        bankOperations.addAccountToUser(user2, account2);
        assertThat(false, is(bankOperations.transferMoney(user1, account1, user2, account2, 10)));
    }
}