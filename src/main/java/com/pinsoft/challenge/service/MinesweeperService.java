package com.pinsoft.challenge.service;

import com.pinsoft.challenge.dto.MinesweeperDTO;
import com.pinsoft.challenge.dto.SquareDTO;

public interface MinesweeperService {
    public MinesweeperDTO getHints(SquareDTO square);
}
