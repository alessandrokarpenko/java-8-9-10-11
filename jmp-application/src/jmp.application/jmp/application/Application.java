package jmp.application;

import jmp.bank.api.Bank;
import jmp.cloud.bank.impl.BankImpl;
import jmp.cloud.service.impl.ServiceImpl;
import jmp.data.storage.factory.DataProviderFactory;
import jmp.dto.BankCardType;
import jmp.dto.models.Subscription;
import jmp.dto.models.User;
import jmp.service.api.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 15. Create application module.
 */
public class Application {

    public static void main(String[] args) {

        useBank();

        useService();

    }

    private static void useBank() {

        User userA = new User("A", "Aa", LocalDate.of(1980, 1, 1));
        User userB = new User("B", "Bb", LocalDate.of(1990, 1, 1));
        User userC = new User("C", "Cc", LocalDate.of(2000, 1, 1));
        User userD = new User("D", "Dd", LocalDate.of(2010, 1, 1));

        Arrays.asList(userA, userB, userC, userD).forEach((u) -> DataProviderFactory.getDataProvider().putUser(u));


        Bank bank = new BankImpl();
        bank.createBankCard(userA, BankCardType.CREDIT);
        bank.createBankCard(userB, BankCardType.DEBIT);
        bank.createBankCard(userC, BankCardType.DEBIT);
        bank.createBankCard(userD, BankCardType.CREDIT);

    }

    private static void useService() {

        Service service = new ServiceImpl();

        DataProviderFactory.getDataProvider().getBankCards().forEach(service::subscribe);


        Predicate<Subscription> predicate = s -> s.getBankcard().getUser().getName().equals("A");

        List<Subscription> subscriptionList = service.getAllSubscriptionsByCondition(predicate);

        List<User> users = service.getAllUsers();

        System.out.println("getAverageUsersAge: " + service.getAverageUsersAge());

    }

}
