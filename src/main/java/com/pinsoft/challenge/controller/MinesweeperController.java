package com.pinsoft.challenge.controller;

import com.pinsoft.challenge.dto.MinesweeperDTO;
import com.pinsoft.challenge.dto.SquareDTO;
import com.pinsoft.challenge.service.MinesweeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MinesweeperController {

    private final MinesweeperService minesweeperService;

    @Autowired
    public MinesweeperController(MinesweeperService minesweeperService) {
        this.minesweeperService = minesweeperService;
    }

    @PostMapping("/show-hints")
    public ResponseEntity<MinesweeperDTO> showHints(@RequestBody SquareDTO squareDTO){
        return ResponseEntity.ok(minesweeperService.getHints(squareDTO));
    }
}
