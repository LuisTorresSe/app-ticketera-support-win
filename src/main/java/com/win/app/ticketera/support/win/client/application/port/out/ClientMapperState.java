package com.win.app.ticketera.support.win.client.application.port.out;

import com.win.app.ticketera.support.win.client.application.port.in.GetClientByCtoState;
import com.win.app.ticketera.support.win.client.domain.Client;

public class ClientMapperState {

    public static GetClientByCtoState toClientByCtoState(Client client ){
        GetClientByCtoState toclientByCto = new GetClientByCtoState();

        toclientByCto.setStatus(client.getStatus());
        toclientByCto.setDocumentCi(client.getDocumentCi());
        toclientByCto.setDescriptionBox(client.getDescriptionBox());
        toclientByCto.setOrderCode(client.getOrderCode());
        toclientByCto.setDescriptionUbigeo(client.getDescriptionUbigeo());
        toclientByCto.setPortGpon(client.getPortGpon());
        toclientByCto.setCodeBox(client.getCto());
        toclientByCto.setService(client.getContrata());
        toclientByCto.setSerialNumber(client.getSerialNumber());
        toclientByCto.setDescriptionDepartament(client.getDescriptionDepartament());

        return toclientByCto;
    }



}
