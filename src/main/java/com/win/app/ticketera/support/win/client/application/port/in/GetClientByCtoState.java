package com.win.app.ticketera.support.win.client.application.port.in;

import lombok.Data;
import lombok.Getter;

@Data
public class GetClientByCtoState {

    private String status;
    private String documentCi;
    private String serialNumber;
    private String orderCode;
    private String portGpon;
    private String descriptionDepartament;
    private String descriptionUbigeo;
    private String descriptionBox;
    private String codeBox;
    private String service;

}
