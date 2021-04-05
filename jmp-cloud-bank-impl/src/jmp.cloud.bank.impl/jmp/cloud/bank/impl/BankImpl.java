package jmp.cloud.bank.impl;

import jmp.bank.api.Bank;
import jmp.data.storage.factory.DataProviderFactory;
import jmp.dto.BankCardType;
import jmp.dto.impls.CreditBankCard;
import jmp.dto.impls.DebitBankCard;
import jmp.dto.models.BankCard;
import jmp.dto.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiFunction;

/**
 * 7. Implement Bank into jmp-cloud-bank-impl. Method should create a new class depending on the type:
 */
public class BankImpl implements Bank {

    public static List<String> usedCardNumbers = new ArrayList<>();
    private static AtomicLong idCounter = new AtomicLong();

    /**
     13. Use var for definition of local variables wherever it’s applicable.
     23. Reimplement createBankCard with method reference (ex: CreditBankCard::new).
     */
    @Override
    public BankCard createBankCard(User user, BankCardType bankCardType) {
        var number = generateCardId(bankCardType);
        usedCardNumbers.add(number);
        BankCard card;
        BiFunction<String, User, BankCard> cardCreator;
        if (bankCardType == BankCardType.CREDIT) {
            cardCreator = CreditBankCard::new;
        } else if (bankCardType == BankCardType.DEBIT) {
            cardCreator = DebitBankCard::new;
        } else {
            throw new RuntimeException("Invalid bank card type");
        }
        card =  cardCreator.apply(number, user);
        DataProviderFactory.getDataProvider().getBankCards().add(card);
        return card;
    }

    /**
        13. Use var for definition of local variables wherever it’s applicable.
     */
    private static String generateCardId(BankCardType bankCardType) {
        var idLong = generateLongValue();
        var idString = String.format("%04d", idLong);
        return String.format("%s%s", bankCardType.getId(), idString);
    }

    private static long generateLongValue() {
        return idCounter.getAndIncrement();
    }

}
