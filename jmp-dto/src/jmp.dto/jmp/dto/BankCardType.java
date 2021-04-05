package jmp.dto;

/**
 * 4. Create enum :
 * - [BankCardType]
 *     CREDIT
 *     DEBIT
 */
public enum BankCardType {

    CREDIT(1),
    DEBIT(2);

    private int id;

    BankCardType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
