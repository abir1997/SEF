package dataAccess;

import dataAccess.mock.DataStoreMock;
import enums.DataStoreMode;
import main.Const;

public class DataStoreFactory {
	
	public static DataStoreInterface getDataStore() {
		if (Const.DATA_STORE_MODE == DataStoreMode.FILE) {
			return new DataStore();
		} else {
			return new DataStoreMock();
		}
	}
}
