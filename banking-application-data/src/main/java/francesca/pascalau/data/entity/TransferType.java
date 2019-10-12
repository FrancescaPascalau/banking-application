package francesca.pascalau.data.entity;

/**
 * There are two types of transfers:
 * - INTRA-BANK for transactions between accounts at the same bank.
 * - INTER-BANK for transactions between accounts at different banks.
 */

public enum TransferType {
    INTRABANK, INTERBANK;

    private double comission;
    private double limit;
    private int chanceOfFailure;

    static {
        INTRABANK.comission = 0;
        INTRABANK.limit = 0;
        INTRABANK.chanceOfFailure = 0;

        INTERBANK.comission = 5;
        INTERBANK.limit = 1000;
        INTERBANK.chanceOfFailure = 30;
    }

    public double getComission() {
        return comission;
    }

    public double getLimit() {
        return limit;
    }

    public int getChanceOfFailure() {
        return chanceOfFailure;
    }
}
