package org.example.echo.domain.Broadcast.entity.repository;

import jakarta.transaction.Transactional;
import org.example.echo.domain.Broadcast.entity.Broadcast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BroadcastRepository extends JpaRepository<Broadcast, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Broadcast b")
    void deleteAllBroadCast();

    List<Broadcast> findAll();
}