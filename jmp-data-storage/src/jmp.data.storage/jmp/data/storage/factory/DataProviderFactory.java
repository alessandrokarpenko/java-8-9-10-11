package jmp.data.storage.factory;

import jmp.data.storage.DataProviderType;
import jmp.data.storage.api.DataProvider;
import jmp.data.storage.impl.InMemoryDataProvider;

public class DataProviderFactory {

    private static DataProvider dataProvider;

    public static DataProvider getDataProvider() {
        return getDataProvider(DataProviderType.IN_MEMORY);
    }

    private static DataProvider getDataProvider(DataProviderType type) {
        switch (type) {
            case IN_MEMORY:
                dataProvider = new InMemoryDataProvider();
                break;
            default:
                throw new RuntimeException("Not supported DataProviderType");
        }
        return dataProvider;
    }

}
