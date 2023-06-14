package com.pinsoft.challenge.service;

import com.pinsoft.challenge.dto.MinesweeperDTO;
import com.pinsoft.challenge.dto.SquareDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class MinesweeperServiceImplTest {
    @Autowired
    private MinesweeperServiceImpl minesweeperService;


    @Test
    void shouldGetHints() {
        //given
        String[] square =  new String[] {"**...",".....",".*..."};
        SquareDTO squareDTO = new SquareDTO();
        squareDTO.setSquare(square);

        //when
        MinesweeperDTO minesweeperDTO = minesweeperService.getHints(squareDTO);

        //then
        assertThat(minesweeperDTO.getHints()).isEqualTo(new String[] {"**100","33200","1*100"});
    }

    @Test
    void shouldGetHintsWhenMineInCenter() {
        //given
        String[] square =  new String[] {".....","..*..","....."};
        SquareDTO squareDTO = new SquareDTO();
        squareDTO.setSquare(square);

        //when
        MinesweeperDTO minesweeperDTO = minesweeperService.getHints(squareDTO);

        //then
        assertThat(minesweeperDTO.getHints()).isEqualTo(new String[] {"01110","01*10","01110"});
    }

    @Test
    void shouldGetHintsWhenMineInEdge() {
        //given
        String[] square =  new String[] {"*****","*...*","*****"};
        SquareDTO squareDTO = new SquareDTO();
        squareDTO.setSquare(square);

        //when
        MinesweeperDTO minesweeperDTO = minesweeperService.getHints(squareDTO);

        //then
        assertThat(minesweeperDTO.getHints()).isEqualTo(new String[] {"*****","*767*","*****"});
    }

    @Test
    void shouldGetHintsWhenHorizontal() {
        //given
        String[] square =  new String[] {".**.*"};
        SquareDTO squareDTO = new SquareDTO();
        squareDTO.setSquare(square);

        //when
        MinesweeperDTO minesweeperDTO = minesweeperService.getHints(squareDTO);

        //then
        assertThat(minesweeperDTO.getHints()).isEqualTo(new String[] {"1**2*"});
    }

    @Test
    void shouldGetHintsWhenVertical() {
        //given
        String[] square =  new String[] {".","*","*",".","*"};
        SquareDTO squareDTO = new SquareDTO();
        squareDTO.setSquare(square);

        //when
        MinesweeperDTO minesweeperDTO = minesweeperService.getHints(squareDTO);

        //then
        assertThat(minesweeperDTO.getHints()).isEqualTo(new String[] {"1","*","*","2","*"});
    }

    @Test
    void shouldReturnZeroWhenSingleElement() {
        //given
        String[] square =  new String[] {"."};
        SquareDTO squareDTO = new SquareDTO();
        squareDTO.setSquare(square);

        //when
        MinesweeperDTO minesweeperDTO = minesweeperService.getHints(squareDTO);

        //then
        assertThat(minesweeperDTO.getHints()).isEqualTo(new String[] {"0"});
    }
    @Test
    void shouldReturnMineWhenSingleMineElement() {
        //given
        String[] square =  new String[] {"*"};
        SquareDTO squareDTO = new SquareDTO();
        squareDTO.setSquare(square);

        //when
        MinesweeperDTO minesweeperDTO = minesweeperService.getHints(squareDTO);

        //then
        assertThat(minesweeperDTO.getHints()).isEqualTo(square);
    }

    @Test
    void shouldReturnZerosWhenNoMines() {
        //given
        String[] square =  new String[] {".....",".....","....."};
        SquareDTO squareDTO = new SquareDTO();
        squareDTO.setSquare(square);

        //when
        MinesweeperDTO minesweeperDTO = minesweeperService.getHints(squareDTO);

        //then
        assertThat(minesweeperDTO.getHints()).isEqualTo(new String[] {"00000","00000","00000"});
    }

    @Test
    void shouldReturnMinesWhenAllMines() {
        //given
        String[] square =  new String[] {"*****","*****","*****"};
        SquareDTO squareDTO = new SquareDTO();
        squareDTO.setSquare(square);

        //when
        MinesweeperDTO minesweeperDTO = minesweeperService.getHints(squareDTO);

        //then
        assertThat(minesweeperDTO.getHints()).isEqualTo(square);
    }
}