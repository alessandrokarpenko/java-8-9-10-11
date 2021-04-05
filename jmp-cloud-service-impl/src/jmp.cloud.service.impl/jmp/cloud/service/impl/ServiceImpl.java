package jmp.cloud.service.impl;

import jmp.data.storage.factory.DataProviderFactory;
import jmp.dto.NoSubscriptionException;
import jmp.dto.models.BankCard;
import jmp.dto.models.Subscription;
import jmp.dto.models.User;
import jmp.service.api.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 11. Implement Service into jmp-cloud-service-impl. User Stream API, You can use Memory/DB for data storing :
 */
public class ServiceImpl implements Service {

    @Override
    public void subscribe(BankCard bankCard) {
        Subscription subscription = new Subscription(bankCard, LocalDate.now());
        DataProviderFactory.getDataProvider().getSubscriptions().add(subscription);
    }

    /**
     * 14. Use lambdas and Java 8 features wherever it’s applicable.
     * 21. Create Exception class which will be used into orElseThrow for Optional from getSubscriptionByBankCardNumber().
     */
    @Override
    public Subscription getSubscriptionByBankCardNumber(String bankCardNumber) {
        return DataProviderFactory.getDataProvider().getSubscriptions()
                .stream().filter(x->x.getBankcard().getNumber().equals(bankCardNumber)).findFirst()
                .orElseThrow(NoSubscriptionException::new);
    }

    /**
     * 14. Use lambdas and Java 8 features wherever it’s applicable.
     */
    @Override
    public List<User> getAllUsers() {
        return DataProviderFactory.getDataProvider().getSubscriptions()
                .stream().map(x->x.getBankcard().getUser())
                .distinct().collect(Collectors.toUnmodifiableList());
    }


    /**
     22. Add a new method for Service interface and implement it. Demonstrate this method ino application module:
     - List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription>);
     */
    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> subscriptionPredicate) {
        return DataProviderFactory.getDataProvider().getSubscriptions()
                .stream().filter(subscriptionPredicate).collect(Collectors.toList());
    }

}
