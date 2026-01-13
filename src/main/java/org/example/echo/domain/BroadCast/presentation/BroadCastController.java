package org.example.echo.domain.BroadCast.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.echo.domain.BroadCast.presentation.dto.request.PostBroadCastRequestDTO;
import org.example.echo.domain.BroadCast.service.AddBroadCastService;
import org.example.echo.domain.BroadCast.service.GetBroadCastService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BroadCastController {
    private final AddBroadCastService addBoardService;
    private final GetBroadCastService getBoardService;

    @PostMapping("/upload")
    public ResponseEntity<?> add(@RequestBody @Valid PostBroadCastRequestDTO data) {
        addBoardService.addBroadCast(data);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("add BroadCast successfully");
    }

    @GetMapping("/getBroadCast")
    public ResponseEntity<?> getBroadCast(@RequestParam(name="page", defaultValue = "0") int page) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(getBoardService.getBroadCast(page));
    }
}