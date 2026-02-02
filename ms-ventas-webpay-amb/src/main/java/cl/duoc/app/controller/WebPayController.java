package cl.duoc.app.controller;

import cl.duoc.app.model.InitTransaction;
import cl.duoc.app.model.InitTransactionResponse;
import cl.duoc.app.model.dto.TransactionDTO;
import cl.duoc.app.services.WebPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebPayController {

    @Autowired
    WebPayService webPayService;

    // 🔵 iniciar pago
    @PostMapping("/init-transaction")
    public InitTransactionResponse initTransaction(
            @RequestBody InitTransaction initTransaction
    ) {
        return webPayService.iniciarTransaccion(initTransaction);
    }

    // 🟢 retorno desde Transbank → commit
    @PostMapping("/webpay/retorno")
    public TransactionDTO retorno(
            @RequestParam("token_ws") String token
    ) {
        return webPayService.confirmarTransaccion(token);
    }
}
