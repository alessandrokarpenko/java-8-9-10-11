package jmp.data.storage.api;

import jmp.dto.models.BankCard;
import jmp.dto.models.Subscription;
import jmp.dto.models.User;

import java.util.List;

public interface DataProvider {

    List<User> getUsers();
    List<BankCard> getBankCards();
    List<Subscription> getSubscriptions();

    void putUser(User user);
    void putBankCard(BankCard bankCard);
    void putSubscription(Subscription subscription);

}
