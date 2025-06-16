package com.win.app.ticketera.support.win.client.adapter.out.persistence;

import com.win.app.ticketera.support.win.client.application.port.out.ClientPort;
import com.win.app.ticketera.support.win.client.domain.Client;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClientPersistenceAdapter implements ClientPort {

    private final ClientRepository clientRepository;
    public ClientPersistenceAdapter(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<List<Client>> getClientsByCto(String cto) {
        List<ClientJpaEntity> clientsJpa =   clientRepository.findAllByCto(cto);

        if (clientsJpa.isEmpty()) {
            return Optional.empty();
        }
        List<Client> clients = clientsJpa.stream().map(
                clientJpaEntity -> ClientMapper.toEntity(clientJpaEntity)
        ).collect(Collectors.toList());


        return Optional.of(clients);}

    @Override
    public Optional<Client> getClientById(Long clientId) {
        return Optional.empty();
    }
}
