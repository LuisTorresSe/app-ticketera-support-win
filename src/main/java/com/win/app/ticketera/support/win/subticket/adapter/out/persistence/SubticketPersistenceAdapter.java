package com.win.app.ticketera.support.win.subticket.adapter.out.persistence;

import com.win.app.ticketera.support.win.subticket.application.port.out.SubticketPort;
import com.win.app.ticketera.support.win.subticket.domain.StatusSubticket;
import com.win.app.ticketera.support.win.subticket.domain.Subticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class SubticketPersistenceAdapter implements SubticketPort {

    private static final Logger logger = LoggerFactory.getLogger(SubticketPersistenceAdapter.class);

    private final SubticketRepository subticketRepository;

    public SubticketPersistenceAdapter(SubticketRepository subticketRepository) {
        this.subticketRepository = subticketRepository;
    }

    @Override
    public Optional<Subticket> getSubticketById(Long id) {
        if (id == null) {
            logger.warn("Attempted to find subticket with null id");
            return Optional.empty();
        }

        try {
            logger.debug("Finding subticket by id: {}", id);
            return subticketRepository.findById(id)
                    .map(SubticketMapper::toDomain);
        } catch (Exception e) {
            logger.error("Error finding subticket by id: {}", id, e);
            return Optional.empty();
        }
    }

    @Override
    public Subticket saveSubticket(Subticket subticket) {
        if (subticket == null) {
            logger.error("Attempted to save null subticket");
            throw new IllegalArgumentException("Subticket cannot be null");
        }

        try {
            logger.debug("Saving subticket with code: {}", subticket.getSubticketCode());

            SubticketJpaEntity entityToSave = SubticketMapper.toJpa(subticket);
            if (entityToSave == null) {
                logger.error("Failed to map subticket to JPA entity");
                throw new IllegalStateException("Failed to convert subticket to entity");
            }

            SubticketJpaEntity savedEntity = subticketRepository.save(entityToSave);
            logger.debug("Successfully saved subticket with id: {}", savedEntity.getSubticketId());

            return SubticketMapper.toDomain(savedEntity);

        } catch (Exception e) {
            logger.error("Error saving subticket with code: {}",
                    subticket.getSubticketCode(), e);
            throw new RuntimeException("Failed to save subticket", e);
        }
    }

    @Override
    public Optional<List<Subticket>> getSubticketByTicketId(Long ticketId) {
        return Optional.empty();
    }

//    @Override
//    public Optional<List<Subticket>> getSubticketByTicketId(Long ticketId) {
//        if (ticketId == null) {
//            logger.warn("Attempted to find subtickets with null ticketId");
//            return Optional.empty();
//        }
//
//        try {
//            logger.debug("Finding subtickets by ticket id: {}", ticketId);
//
//            List<SubticketJpaEntity> entities = subticketRepository.findByTicketTicketId(ticketId);
//
//            if (entities.isEmpty()) {
//                logger.debug("No subtickets found for ticket id: {}", ticketId);
//                return Optional.of(Collections.emptyList());
//            }
//
//            List<Subticket> subtickets = entities.stream()
//                    .map(SubticketMapper::toDomainWithoutTicket)
//                    .collect(Collectors.toList());
//
//            logger.debug("Found {} subtickets for ticket id: {}", subtickets.size(), ticketId);
//            return Optional.of(subtickets);
//
//        } catch (Exception e) {
//            logger.error("Error finding subtickets by ticket id: {}", ticketId, e);
//            return Optional.empty();
//        }
//    }

    @Override
    public Set<Subticket> getSubticketByCtoAndStatusPending(String cto) {
        Set<Subticket> subtickets = subticketRepository.findByCtoAndStatus(cto, StatusSubticket.PENDIENTE)
                .stream()
                .map(SubticketMapper::toDomainWithoutTicket)
                .collect(Collectors.toSet());
        return subtickets;
    }
}