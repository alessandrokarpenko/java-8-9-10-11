module jmp.data.storage {
    requires jmp.dto;
    exports jmp.data.storage.factory;
    exports jmp.data.storage.api;
    provides jmp.data.storage.api.DataProvider with jmp.data.storage.impl.InMemoryDataProvider;
}