package org.example.echo.domain.Broadcast.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.echo.domain.Broadcast.presentation.dto.request.PostBroadcastRequestDTO;
import org.example.echo.domain.Broadcast.service.AddBroadcastService;
import org.example.echo.domain.Broadcast.service.GetBroadcastService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BroadcastController {
    private final AddBroadcastService addBoardService;
    private final GetBroadcastService getBoardService;

    @PostMapping("/upload")
    public ResponseEntity<?> add(@RequestBody PostBroadcastRequestDTO data) {
        addBoardService.addBroadcast(data);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("add BroadCast successfully");
    }

    @GetMapping("/getBroadCast")
    public ResponseEntity<?> getBroadCast(@RequestParam(name="page", defaultValue = "0") int page) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(getBoardService.getBroadcast(page));
    }
}