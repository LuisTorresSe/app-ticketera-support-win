package com.win.app.ticketera.support.win.client.adapter.in;


import com.win.app.ticketera.support.win.client.application.port.in.GetClientByCtoState;
import com.win.app.ticketera.support.win.client.application.port.in.GetClientsByCtoUseCase;
import com.win.app.ticketera.support.win.client.domain.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {
    private final GetClientsByCtoUseCase getClientsByCtoUseCase;

    public ClientController( GetClientsByCtoUseCase getClientsByCtoUseCase) {
        this.getClientsByCtoUseCase = getClientsByCtoUseCase;
    }


    @GetMapping("cto")
    public ResponseEntity<List<GetClientByCtoState>> getClients(@RequestBody RequestGetClientsByCto request) {
        return new ResponseEntity<>(this.getClientsByCtoUseCase.getClients(request.cto()), HttpStatus.OK
        );
    }
}
