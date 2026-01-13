package org.example.echo.domain.Broadcast.service;

import lombok.RequiredArgsConstructor;
import org.example.echo.domain.Broadcast.entity.Broadcast;
import org.example.echo.domain.Broadcast.entity.repository.BroadcastRepository;
import org.example.echo.domain.Broadcast.exception.BroadcastLengthOverException;
import org.example.echo.domain.Broadcast.exception.EmptyMessageException;
import org.example.echo.domain.Broadcast.presentation.dto.request.PostBroadcastRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddBroadcastService {

    private final BroadcastRepository repo;

    @Transactional
    public void addBroadcast(PostBroadcastRequestDTO data){
        if(data.originalMessage() == null
                || data.correctionMessage() == null)
            throw new EmptyMessageException();

        if(data.originalMessage().length() > 255
                || data.correctionMessage().length() > 255)
            throw new EmptyMessageException();


            Broadcast broadcast = Broadcast.builder()
                .correctionMessage(data.correctionMessage())
                .originalMessage(data.originalMessage())
                .build();
        repo.save(broadcast);
    }
}
