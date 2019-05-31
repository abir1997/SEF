package main;

import dataAccess.DataStoreFactory;
import dataAccess.mock.DataStoreMock;
import menu.SuperMarketMenus;

public class Driver {
	public static void main(String[] args) {

		DataStoreFactory.getDataStore().loadData();
		new SuperMarketMenus().mainMenu();
	}
}
