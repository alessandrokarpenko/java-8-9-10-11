package jmp.dto.impls;

import jmp.dto.BankCardType;
import jmp.dto.models.BankCard;
import jmp.dto.models.User;

/**
 * 3. Extend BankCard class with :
 * - CreditBankCard
 * - DebitBankCard
 */
public class DebitBankCard extends BankCard {

    public DebitBankCard(String number, User user) {
        super(number, user);
    }

    public BankCardType getBankCardType() {
        return BankCardType.DEBIT;
    }
}
