package com.techelevator.view;

public class VendingMachine {
    private Inventory inventory;
    private CoinBox coinBox;
    private FileReader fileReader;
    private Logger logger;

    public VendingMachine(Inventory inventory) {
        this.inventory = inventory;
        fileReader = new FileReader();
        coinBox = new CoinBox();
        logger = new Logger();
    }

    public void feedMoney(Double billInserted) {
        coinBox.addMoney(billInserted);
        String billInsertedAsString = "$" + billInserted + ".00";
        logger.logEvent("FEED MONEY:", billInsertedAsString, getBalanceAsString());
    }

    public Double getBalanceInPennies() {
        Double balance = coinBox.getBalanceInPennies();
        return balance;
    }

    public String getBalanceAsString() {
        String returnString = coinBox.getBalanceAsString();
        return returnString;
    }

    public String returnChangeInCoins()  {
        logger.logEvent("GIVE CHANGE:", getBalanceAsString(), "$0.00");
        String returnString = coinBox.returnChangeAsCoins(getBalanceInPennies());
        return returnString;
    }

    public String purchaseItem(String slotLocation) {
        try {
            if (inventory.returnCurrentQty(slotLocation) == 0) {
                return inventory.stock().get(slotLocation).getName() + " Sold Out \n";
            } else if (coinBox.getBalanceInPennies() <
                    inventory.stock().get(slotLocation).getPriceInPennies()) {
                return "Please Insert Additional Funds \n";
            } else {
                String balanceBeforePurchase = getBalanceAsString();
                // SUBSTRACT Quantity in ItemMap qty=qty-1
                inventory.stock().get(slotLocation).substractQuantity();

                // SUBTRACT MONEY from CoinBox class
                // price from item map
                Double debit = inventory.stock().get(slotLocation).getPriceInPennies();
                coinBox.withdrawMoney(debit);

                // print message
                String successfulPurchase = "Dispensing --> "
                        + inventory.stock().get(slotLocation).getName() + " "
                        + "$ "+inventory.stock().get(slotLocation).getPriceAsString()+" "
                        + inventory.stock().get(slotLocation).getSound()+"\n";
                // print file log.txt
                logger.logEvent(
                        inventory.stock().get(slotLocation).getName() + "  " + slotLocation,
                        balanceBeforePurchase, getBalanceAsString());
                return successfulPurchase;
            }

        } catch (NullPointerException e) {
            return "Please Make A Valid Selection \n";
        }
    }
}
