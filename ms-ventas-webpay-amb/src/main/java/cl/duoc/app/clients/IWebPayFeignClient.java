package cl.duoc.app.clients;

import cl.duoc.app.model.InitTransaction;
import cl.duoc.app.model.InitTransactionResponse;
import cl.duoc.app.model.dto.TransactionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "svc-webpay", url = "https://webpay3gint.transbank.cl")
public interface IWebPayFeignClient {

    // 🔵 Iniciar transacción
    @PostMapping("/rswebpaytransaction/api/webpay/v1.2/transactions")
    InitTransactionResponse initTransaction(
            @RequestHeader("Tbk-Api-Key-Id") String apiKeyId,
            @RequestHeader("Tbk-Api-Key-Secret") String apiKeySecret,
            @RequestBody InitTransaction initTransaction
    );

    // 🟢 Confirmar (commit) transacción
    @PutMapping("/rswebpaytransaction/api/webpay/v1.2/transactions/{token}")
    TransactionDTO commitTransaction(
            @RequestHeader("Tbk-Api-Key-Id") String apiKeyId,
            @RequestHeader("Tbk-Api-Key-Secret") String apiKeySecret,
            @PathVariable("token") String token
    );



    // 🟡 Obtener el estado de una transacción (Status)
    @GetMapping("/rswebpaytransaction/api/webpay/v1.2/transactions/{token}")
    TransactionDTO getTransactionStatus(
            @RequestHeader("Tbk-Api-Key-Id") String apiKeyId,
            @RequestHeader("Tbk-Api-Key-Secret") String apiKeySecret,
            @PathVariable("token") String token
    );





}
