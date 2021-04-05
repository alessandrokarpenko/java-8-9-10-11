/**
 * 6. Add module-info.java which :
 * - requires jmp-dto
 * - export Bank interface
 */
module jmp.bank.api {
    requires jmp.dto;
    exports jmp.bank.api;
}