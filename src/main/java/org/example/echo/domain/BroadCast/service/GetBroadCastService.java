package org.example.echo.domain.BroadCast.service;

import lombok.RequiredArgsConstructor;
import org.example.echo.domain.BroadCast.entity.BroadCast;
import org.example.echo.domain.BroadCast.entity.repository.BroadCastRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class GetBroadCastService {
    private final BroadCastRepository repo;

    public List<BroadCast> getBroadCast(int page) {
        Pageable pageable = PageRequest.of(page, 20, Sort.by("createdAt").descending());
        Page<BroadCast> broadCastPage = repo.findAll(pageable);
        return broadCastPage.getContent();
    }
}