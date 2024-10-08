package com.example.dipanshkhandelwal.chess.Pieces;

import com.example.dipanshkhandelwal.chess.Coordinates;
import com.example.dipanshkhandelwal.chess.Position;
import com.example.dipanshkhandelwal.chess.R;

import java.util.ArrayList;

/**
 * Created by DIPANSH KHANDELWAL on 03-06-2017
 */

public class Piece {

    private boolean white;

    Piece(boolean white) {
        this.white = white;
    }

    public ArrayList<Coordinates> AllowedMoves(Coordinates coordinates , Position[][] board){
        ArrayList<Coordinates> allowedMoves = new ArrayList<>();
        Coordinates c;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                c = new Coordinates(i,j);
                allowedMoves.add(c);
            }
        }
        return allowedMoves;
    }

    public int getDrawableResource() {
        return 0;
    }

    public boolean isFriend(Piece otherPiece) {
        return isWhite() == otherPiece.isWhite();
    }

    public boolean isWhite() {
        return white;
    }
}
