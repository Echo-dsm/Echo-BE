package org.example.echo.domain.Broadcast.service;

import lombok.RequiredArgsConstructor;
import org.example.echo.domain.Broadcast.entity.Broadcast;
import org.example.echo.domain.Broadcast.entity.repository.BroadcastRepository;
import org.example.echo.domain.Broadcast.exception.InvalidApiKeyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class GetBroadcastService {
    private final BroadcastRepository repo;

    @Value("${API_KEY}")
    private String API_KEY;

    public List<Broadcast> getBroadcast(int page, String apikey) {
        if(!API_KEY.equals(apikey)) throw new InvalidApiKeyException();
        Pageable pageable = PageRequest.of(page, 20, Sort.by("createdAt").descending());
        Page<Broadcast> broadcastPage = repo.findAll(pageable);
        return broadcastPage.getContent();
    }
}