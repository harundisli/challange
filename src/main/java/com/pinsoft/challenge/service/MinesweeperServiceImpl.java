package com.pinsoft.challenge.service;

import com.pinsoft.challenge.dto.MinesweeperDTO;
import com.pinsoft.challenge.dto.SquareDTO;
import org.springframework.stereotype.Service;

@Service
public class MinesweeperServiceImpl implements MinesweeperService{
    @Override
    public MinesweeperDTO getHints(SquareDTO squareDTO) {
        String[] square = squareDTO.getSquare();
        char[][] charSquare = new char[square.length][];
        for(int i=0; i<square.length;i++){
            charSquare[i] = square[i].toCharArray();
        }

        getHints(charSquare);


        String[] hints = new String[square.length];
        for(int i=0;i<hints.length;i++){
            hints[i] = new String(charSquare[i]);
        }
        return  new MinesweeperDTO(hints);

    }

    private void  getHints(char[][] square){
        for(int i=0;i<square.length;i++){
            for(int k = 0;k<square[i].length;k++) {
                if (square[i][k] != '*') {
                    square[i][k] = (char) (countAdjacentMines(square,i,k)+ '0');
                }
            }
        }
    }

    private int countAdjacentMines(char[][] square, int rowIndex, int columnIndex){

        int[][] adjacent = new int[][]{
                //upLeft,  up,   upRight, left,  right, downL,  down,  downR
                {-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1} };
        int count = 0;
        for(int[] adj:adjacent){
            int r = rowIndex + adj[0];
            int c = columnIndex + adj[1];
            if(r>=0 && r<square.length && c>=0 && c<square[r].length && square[r][c] =='*')
                count++;
        }
        return count;
    }
}
