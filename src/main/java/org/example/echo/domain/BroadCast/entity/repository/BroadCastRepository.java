package org.example.echo.domain.BroadCast.entity.repository;

import jakarta.transaction.Transactional;
import org.example.echo.domain.BroadCast.entity.BroadCast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BroadCastRepository extends JpaRepository<BroadCast, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM BroadCast b")
    void deleteAllBroadCast();

    List<BroadCast> findAll();
}