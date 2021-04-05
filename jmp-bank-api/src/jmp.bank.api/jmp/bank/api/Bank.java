package jmp.bank.api;

import jmp.dto.BankCardType;
import jmp.dto.models.BankCard;
import jmp.dto.models.User;

/**
 * 5. Add Bank interface to jmp-bank-api with :
 * - BankCard createBankCard(User, BankCardType);
 */
public interface Bank {

    BankCard createBankCard(User user, BankCardType bankCardType);

}
