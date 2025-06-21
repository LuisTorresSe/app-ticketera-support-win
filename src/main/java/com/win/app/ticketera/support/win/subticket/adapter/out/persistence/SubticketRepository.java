package com.win.app.ticketera.support.win.subticket.adapter.out.persistence;

import com.win.app.ticketera.support.win.subticket.domain.StatusSubticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubticketRepository extends JpaRepository<SubticketJpaEntity, Long> {
    @Query("SELECT s FROM SubticketJpaEntity s WHERE s.ctoAffected = :cto AND s.status = :status")
    List<SubticketJpaEntity> findByCtoAndStatus(@Param("cto")String cto, @Param("status") StatusSubticket status);

    
}
