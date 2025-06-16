package com.win.app.ticketera.support.win.client.domain;

import lombok.Data;

@Data
public class Client {

    private Long clientId;
    private String typeDocument;
    private String documentCi;
    private String serialNumber;
    private String portGpon;
    private String olt;
    private String cto;
    private String orderCode;
    private String status;
    private String descriptionBox;
    private String contrata;
    private String descriptionTypeBox;

    private String codeBoxWin;
    private String codeBoxOpti;
    private String descriptionPlan;
    private String descriptionLatitudeBox;
    private String descriptionLongitudeBox;
    private String descriptionDirectionBox;
    private String descriptionDirectionClient;
    private String descriptionDepartament;
    private String descriptionProvince;
    private String descriptionUbigeo;
    private String descriptionDistrict;
    private String descriptionProvinceSite;
    private String descriptionDepartamentSite;

}
