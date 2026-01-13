package org.example.echo.domain.BroadCast.service;

import lombok.RequiredArgsConstructor;
import org.example.echo.domain.BroadCast.entity.BroadCast;
import org.example.echo.domain.BroadCast.entity.repository.BroadCastRepository;
import org.example.echo.domain.BroadCast.exception.BoardLengthOverException;
import org.example.echo.domain.BroadCast.exception.EmptyMessageException;
import org.example.echo.domain.BroadCast.presentation.dto.request.PostBroadCastRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddBroadCastService {

    private final BroadCastRepository repo;

    @Transactional
    public void addBroadCast(PostBroadCastRequestDTO data){
        String correctionMessage = data.correctionMessage();
        String originalMessage = data.originalMessage();

        if(originalMessage == null||correctionMessage == null) throw new EmptyMessageException();
        if(originalMessage.length() > 255 || correctionMessage.length() > 255) throw new BoardLengthOverException();
        BroadCast broadCast = BroadCast.builder()
                .correctionMessage(correctionMessage)
                .originalMessage(originalMessage).build();
        repo.save(broadCast);
    }
}
