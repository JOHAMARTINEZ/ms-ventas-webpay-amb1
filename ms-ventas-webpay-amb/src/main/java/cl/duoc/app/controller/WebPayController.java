package cl.duoc.app.controller;

import cl.duoc.app.model.InitTransaction;
import cl.duoc.app.model.InitTransactionResponse;
import cl.duoc.app.model.dto.TransactionDTO;
import cl.duoc.app.services.WebPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webpay")
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


    // 🟡 Consultar estado de la transacción
    @GetMapping("/estado/{token}")
    public TransactionDTO obtenerEstado(
            @PathVariable("token") String token
    ) {
        return webPayService.obtenerEstado(token);
    }


    //  retorno desde Transbank → commit
    @RequestMapping(value = "/retorno", method = {RequestMethod.GET, RequestMethod.POST})
    public TransactionDTO retorno(@RequestParam("token_ws") String token) {
        return webPayService.confirmarTransaccion(token);
    }

}
