package com.win.app.ticketera.support.win.breakdown.adapter.out.persistence;

import com.win.app.ticketera.support.win.client.adapter.out.persistence.ClientJpaEntity;
import com.win.app.ticketera.support.win.subticket.adapter.out.persistence.SubticketJpaEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "breakdowns")
@Data
public class BreakDownJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Mejor usar IDENTITY para consistencia
    private Long breakDownId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private ClientJpaEntity client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subticket_id", nullable = false)
    private SubticketJpaEntity subticket;

    @Column(name = "status", nullable = false, length = 100)
    private String breakDownStatus;
}
