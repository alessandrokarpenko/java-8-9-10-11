/**
 * 16. Add module-info.java which :
 * - use interfaces-------------------------------------------------------???
 * - requires module with Bank implementation
 * - requires module with Service implementation
 * - requires jmp.dto;
 */
module jmp.application {
    requires jmp.cloud.service.impl;
    requires jmp.cloud.bank.impl;
    requires jmp.dto;
    requires jmp.data.storage;
}