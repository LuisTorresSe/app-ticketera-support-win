package com.win.app.ticketera.support.win.client.adapter.out.persistence;

import com.win.app.ticketera.support.win.client.domain.Client;

public class ClientMapper {

    public static ClientJpaEntity toJpaEntity(Client client){
        ClientJpaEntity clientJpaEntity = new ClientJpaEntity();
        clientJpaEntity.setClientId(client.getClientId());
        clientJpaEntity.setTypeDocument(client.getTypeDocument());
        clientJpaEntity.setDocumentCi(client.getDocumentCi());
        clientJpaEntity.setSerialNumber(client.getSerialNumber());
        clientJpaEntity.setPortGpon(client.getPortGpon());
        clientJpaEntity.setOlt(client.getOlt());
        clientJpaEntity.setCto(client.getCto());
        clientJpaEntity.setOrderCode(client.getOrderCode());
        clientJpaEntity.setStatus(client.getStatus());
        clientJpaEntity.setDescriptionBox(client.getDescriptionBox());
        clientJpaEntity.setContrata(client.getContrata());

        clientJpaEntity.setDescriptionTypeBox(client.getDescriptionTypeBox());
        clientJpaEntity.setCodeBoxWin(client.getCodeBoxWin());
        clientJpaEntity.setCodeBoxOpti(client.getCodeBoxOpti());
        clientJpaEntity.setDescriptionPlan(client.getDescriptionPlan());
        clientJpaEntity.setDescriptionLatitudeBox(client.getDescriptionLatitudeBox());
        clientJpaEntity.setDescriptionLongitudeBox(client.getDescriptionLongitudeBox());
        clientJpaEntity.setDescriptionDirectionBox(client.getDescriptionDirectionBox());
        clientJpaEntity.setDescriptionDirectionClient(client.getDescriptionDirectionClient());
        clientJpaEntity.setDescriptionDepartament(client.getDescriptionDepartament());
        clientJpaEntity.setDescriptionProvince(client.getDescriptionProvince());
        clientJpaEntity.setDescriptionUbigeo(client.getDescriptionUbigeo());
        clientJpaEntity.setDescriptionDistrict(client.getDescriptionDistrict());
        clientJpaEntity.setDescriptionProvinceSite(client.getDescriptionProvinceSite());
        clientJpaEntity.setDescriptionDepartamentSite(client.getDescriptionDepartamentSite());

        return clientJpaEntity;

    }


    public static Client toEntity(ClientJpaEntity clientJpaEntity){
        Client client = new Client();
        client.setClientId(clientJpaEntity.getClientId());
        client.setTypeDocument(clientJpaEntity.getTypeDocument());
        client.setDocumentCi(clientJpaEntity.getDocumentCi());
        client.setSerialNumber(clientJpaEntity.getSerialNumber());
        client.setPortGpon(clientJpaEntity.getPortGpon());
        client.setOlt(clientJpaEntity.getOlt());
        client.setCto(clientJpaEntity.getCto());
        client.setOrderCode(clientJpaEntity.getOrderCode());
        client.setStatus(clientJpaEntity.getStatus());
        client.setDescriptionBox(clientJpaEntity.getDescriptionBox());
        client.setContrata(clientJpaEntity.getContrata());
        client.setDescriptionTypeBox(clientJpaEntity.getDescriptionTypeBox());
        client.setCodeBoxWin(clientJpaEntity.getCodeBoxWin());
        client.setCodeBoxOpti(clientJpaEntity.getCodeBoxOpti());
        client.setDescriptionPlan(clientJpaEntity.getDescriptionPlan());
        client.setDescriptionLatitudeBox(clientJpaEntity.getDescriptionLatitudeBox());
        client.setDescriptionLongitudeBox(clientJpaEntity.getDescriptionLongitudeBox());
        client.setDescriptionDirectionBox(clientJpaEntity.getDescriptionDirectionBox());
        client.setDescriptionDirectionClient(clientJpaEntity.getDescriptionDirectionClient());
        client.setDescriptionDepartament(clientJpaEntity.getDescriptionDepartament());
        client.setDescriptionProvince(clientJpaEntity.getDescriptionProvince());
        client.setDescriptionUbigeo(clientJpaEntity.getDescriptionUbigeo());
        client.setDescriptionDistrict(clientJpaEntity.getDescriptionDistrict());
        client.setDescriptionProvinceSite(clientJpaEntity.getDescriptionProvinceSite());
        client.setDescriptionDepartamentSite(clientJpaEntity.getDescriptionDepartamentSite());
        return client;


    }
}
