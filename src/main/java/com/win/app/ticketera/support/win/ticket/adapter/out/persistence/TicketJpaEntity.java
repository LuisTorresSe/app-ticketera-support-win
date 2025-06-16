package com.win.app.ticketera.support.win.ticket.adapter.out.persistence;

import com.win.app.ticketera.support.win.subticket.adapter.out.persistence.SubticketJpaEntity;
import com.win.app.ticketera.support.win.ticket.domain.Type;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "tickets")
@Data
public class TicketJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;
    private String ticketCode;
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<SubticketJpaEntity> subtickets;
}
