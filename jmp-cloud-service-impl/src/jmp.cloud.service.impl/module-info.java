/**
 * 12. Add module-info.java which :
 * - requires transitive module with Service interface
 * - requires jmp-dto
 * - exports implementation of Service interface
 */
module jmp.cloud.service.impl {
    requires transitive jmp.service.api;
    requires jmp.dto;
    requires jmp.data.storage;
    exports jmp.cloud.service.impl;
}