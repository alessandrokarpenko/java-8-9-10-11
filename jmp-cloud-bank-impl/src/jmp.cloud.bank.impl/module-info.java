/**
 * 8. Add module-info.java which :
 * - requires transitive module with Bank interface
 * - requires jmp-dto
 * - exports implementation of Bank interface
 */
module jmp.cloud.bank.impl {
    requires transitive jmp.bank.api;
    requires jmp.dto;
    requires jmp.data.storage;
    exports jmp.cloud.bank.impl;
}