package com.win.app.ticketera.support.win.managerAt.domain;

import com.win.app.ticketera.support.win.subticket.domain.Subticket;
import lombok.Data;

import java.util.Set;

@Data
public class ManagerAt {
    private Long managerId;
    private String managerUQ;
    private String name;
    private Set<Subticket> subTickets;
}
