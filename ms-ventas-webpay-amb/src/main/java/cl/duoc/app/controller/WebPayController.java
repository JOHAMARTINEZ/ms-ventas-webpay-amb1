package cl.duoc.app.controller;


import cl.duoc.app.model.dto.InitTransaction;
import cl.duoc.app.model.dto.InitTransactionResponse;
import cl.duoc.app.services.WebPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebPayController {
    @Autowired
    WebPayService webPayService;
    @PostMapping("/init-transaction")
    public InitTransactionResponse initTransaction(@RequestBody InitTransaction initTransaction){
        return webPayService.iniciarTransaccion(initTransaction);
    }
    




}
