package cl.duoc.app.services;

import cl.duoc.app.clients.IWebPayFeignClient;
import cl.duoc.app.model.InitTransaction;
import cl.duoc.app.model.InitTransactionResponse;
import cl.duoc.app.model.dto.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebPayService {

    @Autowired
    IWebPayFeignClient iWebPayFeignClient;

    private final String apiKeyId = "597055555532";
    private final String apiKeySecret =
            "579B532A7440BB0C9079DED94D31EA1615BACEB56610332264630D42D0A36B1C";

    // 🔵 Iniciar pago
    public InitTransactionResponse iniciarTransaccion(InitTransaction initTransaction) {

        return iWebPayFeignClient.initTransaction(
                apiKeyId,
                apiKeySecret,
                initTransaction
        );
    }

    // 🟢 Confirmar pago (commit)
    public TransactionDTO confirmarTransaccion(String token) {

        return iWebPayFeignClient.commitTransaction(
                apiKeyId,
                apiKeySecret,
                token
        );
    }
    // 🟡 Obtener estado de la transacción
    public TransactionDTO obtenerEstado(String token) {
        return iWebPayFeignClient.getTransactionStatus(
                apiKeyId,
                apiKeySecret,
                token
        );
    }







}
