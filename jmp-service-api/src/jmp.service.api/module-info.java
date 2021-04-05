/**
 * 10. Add module-info.java which :
 * - requires jmp-dto
 * - export Service interface
 */
module jmp.service.api {
    requires jmp.dto;
    exports jmp.service.api;
}