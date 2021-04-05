package jmp.service.api;

import jmp.dto.models.BankCard;
import jmp.dto.models.Subscription;
import jmp.dto.models.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * 9. Add Service interface to jmp-service-api with :
 * - void subscribe(BankCard)
 * - Optional<Subscription> getSubscriptionByBankCardNumber(String)
 * - List<User> getAllUsers();
 */
public interface Service {

    int ADULT_AGE = 18;

    void subscribe(BankCard bankCard);

    Subscription getSubscriptionByBankCardNumber(String bankCardNumber);

    List<User> getAllUsers();

    /**
     22. Add a new method for Service interface and implement it. Demonstrate this method ino application module:
     - List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription>);
     */
    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> subscriptionPredicate);

    /**
     13. Use var for definition of local variables wherever it’s applicable.
     14. Use lambdas and Java 8 features wherever it’s applicable.
     18. Add a new default method for Service interface, which uses getAllUsers. Use LocalDate.now(), ChronoUnit и mapToLong.
     - double getAverageUsersAge();
     */
    default double getAverageUsersAge() {
        List<User> users = getAllUsers();
        var average = users.stream().mapToLong(x->(ChronoUnit.YEARS.between(x.getBirthday(), LocalDate.now())))
                .average();
        return average.isPresent() ? average.getAsDouble() : Double.NaN;
    }

    /**
     19. Add a new static method for Service interface, which returns true, if the user is over 18 years old.
     - boolean isPayableUser(User);
     */
    static boolean isPayableUser(User user) {
        return ChronoUnit.YEARS.between(LocalDate.now(), user.getBirthday()) >= ADULT_AGE;
    }

}
