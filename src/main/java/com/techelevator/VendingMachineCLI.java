package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.MenuAction;

import java.io.IOException;

public class VendingMachineCLI {
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT ="Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
			MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

	private Menu menu;
	private MenuAction menuAction;


	public VendingMachineCLI(Menu menu, MenuAction menuAction) {
		this.menu = menu;
		this.menuAction=menuAction;
	}

	public void run() throws IOException {
		boolean runAgain = true;
		while (runAgain) {
			System.out.print("*** Vending Machine Vendo-Matic 800 ***");
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			switch(choice) {
				case MAIN_MENU_OPTION_DISPLAY_ITEMS -> menuAction.displayInventory();
				case MAIN_MENU_OPTION_PURCHASE -> {
					boolean runPurchaseAgain = true;
					while (runPurchaseAgain) {
						String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
						System.out.println("Current Money Provided: " + menuAction.displayCurrentBalance());
						switch (choice2) {
							case PURCHASE_MENU_OPTION_FEED_MONEY -> menuAction.feedMoney();
							case PURCHASE_MENU_OPTION_SELECT_PRODUCT -> {
								menuAction.displayInventory();
								menuAction.selectProduct();
							}
							case PURCHASE_MENU_OPTION_FINISH_TRANSACTION -> {
								menuAction.finishTransaction();
								runPurchaseAgain = false;
							}
						}
					}
					break;
				}
				case MAIN_MENU_OPTION_EXIT -> runAgain = false;
			}
		}
	}


	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		MenuAction menuAction = new MenuAction(System.in, System.out);
		VendingMachineCLI CLI = new VendingMachineCLI(menu, menuAction);
		CLI.run();
	}
}
