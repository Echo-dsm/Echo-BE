package org.example.echo.domain.BroadCast.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class BroadCast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "correction_message", length = 255)
    private String correctionMessage;

    @Column(name = "original_message", length = 255)
    private String originalMessage;

    @Column(name = "time")
    private LocalDateTime createdAt;

    @Builder
    public BroadCast(String correctionMessage, String originalMessage) {
        this.correctionMessage = correctionMessage;
        this.originalMessage = originalMessage;
        this.createdAt = LocalDateTime.now();
    }

}
