package jmp.data.storage.impl;

import jmp.data.storage.api.DataProvider;
import jmp.dto.models.BankCard;
import jmp.dto.models.Subscription;
import jmp.dto.models.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDataProvider implements DataProvider {

    private static List<User> users = new ArrayList<>();
    private static List<BankCard> bankCards = new ArrayList<>();
    private static List<Subscription> subscriptions = new ArrayList<>();

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public List<BankCard> getBankCards() {
        return bankCards;
    }

    @Override
    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    @Override
    public void putUser(User user) {
        users.add(user);
    }

    @Override
    public void putBankCard(BankCard bankCard) {
        bankCards.add(bankCard);
    }

    @Override
    public void putSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

}
