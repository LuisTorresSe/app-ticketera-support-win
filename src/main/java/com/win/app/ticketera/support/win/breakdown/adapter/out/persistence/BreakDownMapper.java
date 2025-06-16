package com.win.app.ticketera.support.win.breakdown.adapter.out.persistence;

import com.win.app.ticketera.support.win.breakdown.domain.BreakDown;
import com.win.app.ticketera.support.win.client.adapter.out.persistence.ClientMapper;

public class BreakDownMapper {

    public static BreakDownJpaEntity toEntity(BreakDown breakDown) {
        BreakDownJpaEntity breakDownJpaEntity = new BreakDownJpaEntity();
        breakDownJpaEntity.setBreakDownId(breakDown.getBreakDownId());
        breakDownJpaEntity.setBreakDownStatus(breakDown.getBreakDownStatus());
        breakDownJpaEntity.setClient(
                ClientMapper.toJpaEntity(breakDown.getClient())
        );

        return new BreakDownJpaEntity();
    }

    public static BreakDown toDomain(BreakDownJpaEntity breakDownJpaEntity){
        BreakDown breakDown = new BreakDown();
        breakDown.setBreakDownId(breakDownJpaEntity.getBreakDownId());
        breakDown.setBreakDownStatus(breakDownJpaEntity.getBreakDownStatus());
        breakDown.setClient(
                ClientMapper.toEntity(breakDownJpaEntity.getClient())
        );
        return new BreakDown();
    }
}
