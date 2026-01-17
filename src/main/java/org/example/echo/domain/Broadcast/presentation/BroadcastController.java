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
                .body("add Broadcast successfully");
    }

    @GetMapping("/get500")
    public ResponseEntity<?> get500() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("니 500떳음 ㅋ");
    }

    @GetMapping("/broadcast")
    public ResponseEntity<?> broadcast(@RequestParam(name="page", defaultValue = "0") int page) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(getBoardService.getBroadcast(page));
    }
}