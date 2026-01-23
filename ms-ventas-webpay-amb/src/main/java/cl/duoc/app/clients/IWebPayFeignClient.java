package cl.duoc.app.clients;


import cl.duoc.app.model.dto.InitTransaction;
import cl.duoc.app.model.dto.InitTransactionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "svc-webpay", url="https://webpay3gint.transbank.cl")
public interface IWebPayFeignClient {
    @PostMapping(path =
    "/rswebpaytransaction/api/webpay/v1.2/transactions")
    InitTransactionResponse initTransaction(@RequestHeader ("Tbk-Api-Key-Id")
                                            String apiKeyId,
                                            @RequestHeader ("tbk-Api-Key-Secret")
                                            String apiKeySecret,
                                            @RequestBody InitTransaction initTransaction);





}
