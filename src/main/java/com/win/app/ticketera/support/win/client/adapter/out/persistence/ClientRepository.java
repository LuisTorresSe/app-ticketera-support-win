package com.win.app.ticketera.support.win.client.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<ClientJpaEntity, Long> {


    List<ClientJpaEntity> findByCto(String cto);

    List<ClientJpaEntity> findAllByCto(String cto);
}
