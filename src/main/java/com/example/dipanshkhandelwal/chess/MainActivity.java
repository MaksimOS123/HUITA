package com.example.dipanshkhandelwal.chess;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dipanshkhandelwal.chess.Pieces.Bishop;
import com.example.dipanshkhandelwal.chess.Pieces.King;
import com.example.dipanshkhandelwal.chess.Pieces.Knight;
import com.example.dipanshkhandelwal.chess.Pieces.Pawn;
import com.example.dipanshkhandelwal.chess.Pieces.Piece;
import com.example.dipanshkhandelwal.chess.Pieces.Queen;
import com.example.dipanshkhandelwal.chess.Pieces.Rook;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Boolean WhitePlayerTurn; // гы-гы, нотка расизма

    private Class TAG = this.getClass();
    public ArrayList<Coordinates> listOfCoordinates = new ArrayList<>();
    public Position[][] Board = new Position[8][8];
    public Position[][] Board2 = new Position[8][8];
    public Boolean AnythingSelected = false;
    public Coordinates lastPos = null ;
    public Coordinates clickedPosition = new Coordinates(0, 0);
    public TextView game_over;
    public TextView[][] DisplayBoard = new TextView[8][8];
    public TextView[][] DisplayBoardBackground = new TextView[8][8];
    public ArrayList<Position[][]> LastMoves = new ArrayList<>();
    public LinearLayout pawn_choices;
    public int numberOfMoves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_main);

        initializeBoard();

        game_over = (TextView)findViewById(R.id.game_over);
        pawn_choices = (LinearLayout)findViewById(R.id.pawn_chioces);

        game_over.setVisibility(View.INVISIBLE);
        pawn_choices.setVisibility(View.INVISIBLE);
    }

    private void initializeBoard() {
        for (int board_col = 0; board_col < 8; board_col++) {
            for (int board_row = 0; board_row < 8; board_row++) {
                Board[board_col][board_row] = new Position(null);
                Board2[board_col][board_row] = new Position(null);
            }
        }

        for(int board_row = 0; board_row < 8; board_row += 7) {
            boolean isWhiteColor = board_row == 7;
            Board[0][board_row].setPiece(new Rook(isWhiteColor));
            Board[1][board_row].setPiece(new Knight(isWhiteColor));
            Board[2][board_row].setPiece(new Bishop(isWhiteColor));
            Board[3][board_row].setPiece(new Queen(isWhiteColor));
            Board[4][board_row].setPiece(new King(isWhiteColor));
            Board[5][board_row].setPiece(new Bishop(isWhiteColor));
            Board[6][board_row].setPiece(new Knight(isWhiteColor));
            Board[7][board_row].setPiece(new Rook(isWhiteColor);
        }

        for(int board_col = 0; board_col < 8; board_col++)
             Board[board_col][1].setPiece(new Pawn(false);
             Board[board_col][6].setPiece(new Pawn(true);

        DisplayBoard[0][0] = (TextView) findViewById(R.id.R00);
        DisplayBoardBackground[0][0] = (TextView) findViewById(R.id.R000);
        DisplayBoard[1][0] = (TextView) findViewById(R.id.R10);
        DisplayBoardBackground[1][0] = (TextView) findViewById(R.id.R010);
        DisplayBoard[2][0] = (TextView) findViewById(R.id.R20);
        DisplayBoardBackground[2][0] = (TextView) findViewById(R.id.R020);
        DisplayBoard[3][0] = (TextView) findViewById(R.id.R30);
        DisplayBoardBackground[3][0] = (TextView) findViewById(R.id.R030);
        DisplayBoard[4][0] = (TextView) findViewById(R.id.R40);
        DisplayBoardBackground[4][0] = (TextView) findViewById(R.id.R040);
        DisplayBoard[5][0] = (TextView) findViewById(R.id.R50);
        DisplayBoardBackground[5][0] = (TextView) findViewById(R.id.R050);
        DisplayBoard[6][0] = (TextView) findViewById(R.id.R60);
        DisplayBoardBackground[6][0] = (TextView) findViewById(R.id.R060);
        DisplayBoard[7][0] = (TextView) findViewById(R.id.R70);
        DisplayBoardBackground[7][0] = (TextView) findViewById(R.id.R070);

        DisplayBoard[0][1] = (TextView) findViewById(R.id.R01);
        DisplayBoardBackground[0][1] = (TextView) findViewById(R.id.R001);
        DisplayBoard[1][1] = (TextView) findViewById(R.id.R11);
        DisplayBoardBackground[1][1] = (TextView) findViewById(R.id.R011);
        DisplayBoard[2][1] = (TextView) findViewById(R.id.R21);
        DisplayBoardBackground[2][1] = (TextView) findViewById(R.id.R021);
        DisplayBoard[3][1] = (TextView) findViewById(R.id.R31);
        DisplayBoardBackground[3][1] = (TextView) findViewById(R.id.R031);
        DisplayBoard[4][1] = (TextView) findViewById(R.id.R41);
        DisplayBoardBackground[4][1] = (TextView) findViewById(R.id.R041);
        DisplayBoard[5][1] = (TextView) findViewById(R.id.R51);
        DisplayBoardBackground[5][1] = (TextView) findViewById(R.id.R051);
        DisplayBoard[6][1] = (TextView) findViewById(R.id.R61);
        DisplayBoardBackground[6][1] = (TextView) findViewById(R.id.R061);
        DisplayBoard[7][1] = (TextView) findViewById(R.id.R71);
        DisplayBoardBackground[7][1] = (TextView) findViewById(R.id.R071);

        DisplayBoard[0][2] = (TextView) findViewById(R.id.R02);
        DisplayBoardBackground[0][2] = (TextView) findViewById(R.id.R002);
        DisplayBoard[1][2] = (TextView) findViewById(R.id.R12);
        DisplayBoardBackground[1][2] = (TextView) findViewById(R.id.R012);
        DisplayBoard[2][2] = (TextView) findViewById(R.id.R22);
        DisplayBoardBackground[2][2] = (TextView) findViewById(R.id.R022);
        DisplayBoard[3][2] = (TextView) findViewById(R.id.R32);
        DisplayBoardBackground[3][2] = (TextView) findViewById(R.id.R032);
        DisplayBoard[4][2] = (TextView) findViewById(R.id.R42);
        DisplayBoardBackground[4][2] = (TextView) findViewById(R.id.R042);
        DisplayBoard[5][2] = (TextView) findViewById(R.id.R52);
        DisplayBoardBackground[5][2] = (TextView) findViewById(R.id.R052);
        DisplayBoard[6][2] = (TextView) findViewById(R.id.R62);
        DisplayBoardBackground[6][2] = (TextView) findViewById(R.id.R062);
        DisplayBoard[7][2] = (TextView) findViewById(R.id.R72);
        DisplayBoardBackground[7][2] = (TextView) findViewById(R.id.R072);

        DisplayBoard[0][3] = (TextView) findViewById(R.id.R03);
        DisplayBoardBackground[0][3] = (TextView) findViewById(R.id.R003);
        DisplayBoard[1][3] = (TextView) findViewById(R.id.R13);
        DisplayBoardBackground[1][3] = (TextView) findViewById(R.id.R013);
        DisplayBoard[2][3] = (TextView) findViewById(R.id.R23);
        DisplayBoardBackground[2][3] = (TextView) findViewById(R.id.R023);
        DisplayBoard[3][3] = (TextView) findViewById(R.id.R33);
        DisplayBoardBackground[3][3] = (TextView) findViewById(R.id.R033);
        DisplayBoard[4][3] = (TextView) findViewById(R.id.R43);
        DisplayBoardBackground[4][3] = (TextView) findViewById(R.id.R043);
        DisplayBoard[5][3] = (TextView) findViewById(R.id.R53);
        DisplayBoardBackground[5][3] = (TextView) findViewById(R.id.R053);
        DisplayBoard[6][3] = (TextView) findViewById(R.id.R63);
        DisplayBoardBackground[6][3] = (TextView) findViewById(R.id.R063);
        DisplayBoard[7][3] = (TextView) findViewById(R.id.R73);
        DisplayBoardBackground[7][3] = (TextView) findViewById(R.id.R073);

        DisplayBoard[0][4] = (TextView) findViewById(R.id.R04);
        DisplayBoardBackground[0][4] = (TextView) findViewById(R.id.R004);
        DisplayBoard[1][4] = (TextView) findViewById(R.id.R14);
        DisplayBoardBackground[1][4] = (TextView) findViewById(R.id.R014);
        DisplayBoard[2][4] = (TextView) findViewById(R.id.R24);
        DisplayBoardBackground[2][4] = (TextView) findViewById(R.id.R024);
        DisplayBoard[3][4] = (TextView) findViewById(R.id.R34);
        DisplayBoardBackground[3][4] = (TextView) findViewById(R.id.R034);
        DisplayBoard[4][4] = (TextView) findViewById(R.id.R44);
        DisplayBoardBackground[4][4] = (TextView) findViewById(R.id.R044);
        DisplayBoard[5][4] = (TextView) findViewById(R.id.R54);
        DisplayBoardBackground[5][4] = (TextView) findViewById(R.id.R054);
        DisplayBoard[6][4] = (TextView) findViewById(R.id.R64);
        DisplayBoardBackground[6][4] = (TextView) findViewById(R.id.R064);
        DisplayBoard[7][4] = (TextView) findViewById(R.id.R74);
        DisplayBoardBackground[7][4] = (TextView) findViewById(R.id.R074);

        DisplayBoard[0][5] = (TextView) findViewById(R.id.R05);
        DisplayBoardBackground[0][5] = (TextView) findViewById(R.id.R005);
        DisplayBoard[1][5] = (TextView) findViewById(R.id.R15);
        DisplayBoardBackground[1][5] = (TextView) findViewById(R.id.R015);
        DisplayBoard[2][5] = (TextView) findViewById(R.id.R25);
        DisplayBoardBackground[2][5] = (TextView) findViewById(R.id.R025);
        DisplayBoard[3][5] = (TextView) findViewById(R.id.R35);
        DisplayBoardBackground[3][5] = (TextView) findViewById(R.id.R035);
        DisplayBoard[4][5] = (TextView) findViewById(R.id.R45);
        DisplayBoardBackground[4][5] = (TextView) findViewById(R.id.R045);
        DisplayBoard[5][5] = (TextView) findViewById(R.id.R55);
        DisplayBoardBackground[5][5] = (TextView) findViewById(R.id.R055);
        DisplayBoard[6][5] = (TextView) findViewById(R.id.R65);
        DisplayBoardBackground[6][5] = (TextView) findViewById(R.id.R065);
        DisplayBoard[7][5] = (TextView) findViewById(R.id.R75);
        DisplayBoardBackground[7][5] = (TextView) findViewById(R.id.R075);

        DisplayBoard[0][6] = (TextView) findViewById(R.id.R06);
        DisplayBoardBackground[0][6] = (TextView) findViewById(R.id.R006);
        DisplayBoard[1][6] = (TextView) findViewById(R.id.R16);
        DisplayBoardBackground[1][6] = (TextView) findViewById(R.id.R016);
        DisplayBoard[2][6] = (TextView) findViewById(R.id.R26);
        DisplayBoardBackground[2][6] = (TextView) findViewById(R.id.R026);
        DisplayBoard[3][6] = (TextView) findViewById(R.id.R36);
        DisplayBoardBackground[3][6] = (TextView) findViewById(R.id.R036);
        DisplayBoard[4][6] = (TextView) findViewById(R.id.R46);
        DisplayBoardBackground[4][6] = (TextView) findViewById(R.id.R046);
        DisplayBoard[5][6] = (TextView) findViewById(R.id.R56);
        DisplayBoardBackground[5][6] = (TextView) findViewById(R.id.R056);
        DisplayBoard[6][6] = (TextView) findViewById(R.id.R66);
        DisplayBoardBackground[6][6] = (TextView) findViewById(R.id.R066);
        DisplayBoard[7][6] = (TextView) findViewById(R.id.R76);
        DisplayBoardBackground[7][6] = (TextView) findViewById(R.id.R076);

        DisplayBoard[0][7] = (TextView) findViewById(R.id.R07);
        DisplayBoardBackground[0][7] = (TextView) findViewById(R.id.R007);
        DisplayBoard[1][7] = (TextView) findViewById(R.id.R17);
        DisplayBoardBackground[1][7] = (TextView) findViewById(R.id.R017);
        DisplayBoard[2][7] = (TextView) findViewById(R.id.R27);
        DisplayBoardBackground[2][7] = (TextView) findViewById(R.id.R027);
        DisplayBoard[3][7] = (TextView) findViewById(R.id.R37);
        DisplayBoardBackground[3][7] = (TextView) findViewById(R.id.R037);
        DisplayBoard[4][7] = (TextView) findViewById(R.id.R47);
        DisplayBoardBackground[4][7] = (TextView) findViewById(R.id.R047);
        DisplayBoard[5][7] = (TextView) findViewById(R.id.R57);
        DisplayBoardBackground[5][7] = (TextView) findViewById(R.id.R057);
        DisplayBoard[6][7] = (TextView) findViewById(R.id.R67);
        DisplayBoardBackground[6][7] = (TextView) findViewById(R.id.R067);
        DisplayBoard[7][7] = (TextView) findViewById(R.id.R77);
        DisplayBoardBackground[7][7] = (TextView) findViewById(R.id.R077);

        for(int board_row = 0; board_row < 8; board_row++)
            for(int board_col = 0; board_col < 8; board_col++)
                Board2[board_row][board_col].setPiece(Board[board_row][board_col].getPiece());

        numberOfMoves = 0;
        AnythingSelected = false;
        WhitePlayerTurn = true;
        drawBoard();
    }

    private void drawBoard() {
        for (int board_col = 0; board_col < 8; board_col++) {
            for (int board_row = 0; board_row < 8; board_row++) {
                Piece pieceAtPosition = Board[board_col][board_row].getPiece();
                int drawable_resource = pieceAtPosition != null ? pieceAtPosition.getDrawableResource() : 0;

                DisplayBoard[board_col][board_row].setBackgroundResource(drawable_resource);
            }
        }
        isKingInDanger();
    }
    
    public void getClickedPos(View v) {
        switch (v.getId()) {
            case R.id.R00:
                clickedPosition = new Coordinates(0, 0);
                break;
            case R.id.R10:
                clickedPosition.setX(1);
                clickedPosition.setY(0);
                break;
            case R.id.R20:
                clickedPosition.setX(2);
                clickedPosition.setY(0);
                break;
            case R.id.R30:
                clickedPosition.setX(3);
                clickedPosition.setY(0);
                break;
            case R.id.R40:
                clickedPosition.setX(4);
                clickedPosition.setY(0);
                break;
            case R.id.R50:
                clickedPosition.setX(5);
                clickedPosition.setY(0);
                break;
            case R.id.R60:
                clickedPosition.setX(6);
                clickedPosition.setY(0);
                break;
            case R.id.R70:
                clickedPosition.setX(7);
                clickedPosition.setY(0);
                break;

            case R.id.R01:
                clickedPosition.setX(0);
                clickedPosition.setY(1);
                break;
            case R.id.R11:
                clickedPosition.setX(1);
                clickedPosition.setY(1);
                break;
            case R.id.R21:
                clickedPosition.setX(2);
                clickedPosition.setY(1);
                break;
            case R.id.R31:
                clickedPosition.setX(3);
                clickedPosition.setY(1);
                break;
            case R.id.R41:
                clickedPosition.setX(4);
                clickedPosition.setY(1);
                break;
            case R.id.R51:
                clickedPosition.setX(5);
                clickedPosition.setY(1);
                break;
            case R.id.R61:
                clickedPosition.setX(6);
                clickedPosition.setY(1);
                break;
            case R.id.R71:
                clickedPosition.setX(7);
                clickedPosition.setY(1);
                break;

            case R.id.R02:
                clickedPosition.setX(0);
                clickedPosition.setY(2);
                break;
            case R.id.R12:
                clickedPosition.setX(1);
                clickedPosition.setY(2);
                break;
            case R.id.R22:
                clickedPosition.setX(2);
                clickedPosition.setY(2);
                break;
            case R.id.R32:
                clickedPosition.setX(3);
                clickedPosition.setY(2);
                break;
            case R.id.R42:
                clickedPosition.setX(4);
                clickedPosition.setY(2);
                break;
            case R.id.R52:
                clickedPosition.setX(5);
                clickedPosition.setY(2);
                break;
            case R.id.R62:
                clickedPosition.setX(6);
                clickedPosition.setY(2);
                break;
            case R.id.R72:
                clickedPosition.setX(7);
                clickedPosition.setY(2);
                break;

            case R.id.R03:
                clickedPosition.setX(0);
                clickedPosition.setY(3);
                break;
            case R.id.R13:
                clickedPosition.setX(1);
                clickedPosition.setY(3);
                break;
            case R.id.R23:
                clickedPosition.setX(2);
                clickedPosition.setY(3);
                break;
            case R.id.R33:
                clickedPosition.setX(3);
                clickedPosition.setY(3);
                break;
            case R.id.R43:
                clickedPosition.setX(4);
                clickedPosition.setY(3);
                break;
            case R.id.R53:
                clickedPosition.setX(5);
                clickedPosition.setY(3);
                break;
            case R.id.R63:
                clickedPosition.setX(6);
                clickedPosition.setY(3);
                break;
            case R.id.R73:
                clickedPosition.setX(7);
                clickedPosition.setY(3);
                break;

            case R.id.R04:
                clickedPosition.setX(0);
                clickedPosition.setY(4);
                break;
            case R.id.R14:
                clickedPosition.setX(1);
                clickedPosition.setY(4);
                break;
            case R.id.R24:
                clickedPosition.setX(2);
                clickedPosition.setY(4);
                break;
            case R.id.R34:
                clickedPosition.setX(3);
                clickedPosition.setY(4);
                break;
            case R.id.R44:
                clickedPosition.setX(4);
                clickedPosition.setY(4);
                break;
            case R.id.R54:
                clickedPosition.setX(5);
                clickedPosition.setY(4);
                break;
            case R.id.R64:
                clickedPosition.setX(6);
                clickedPosition.setY(4);
                break;
            case R.id.R74:
                clickedPosition.setX(7);
                clickedPosition.setY(4);
                break;

            case R.id.R05:
                clickedPosition.setX(0);
                clickedPosition.setY(5);
                break;
            case R.id.R15:
                clickedPosition.setX(1);
                clickedPosition.setY(5);
                break;
            case R.id.R25:
                clickedPosition.setX(2);
                clickedPosition.setY(5);
                break;
            case R.id.R35:
                clickedPosition.setX(3);
                clickedPosition.setY(5);
                break;
            case R.id.R45:
                clickedPosition.setX(4);
                clickedPosition.setY(5);
                break;
            case R.id.R55:
                clickedPosition.setX(5);
                clickedPosition.setY(5);
                break;
            case R.id.R65:
                clickedPosition.setX(6);
                clickedPosition.setY(5);
                break;
            case R.id.R75:
                clickedPosition.setX(7);
                clickedPosition.setY(5);
                break;

            case R.id.R06:
                clickedPosition.setX(0);
                clickedPosition.setY(6);
                break;
            case R.id.R16:
                clickedPosition.setX(1);
                clickedPosition.setY(6);
                break;
            case R.id.R26:
                clickedPosition.setX(2);
                clickedPosition.setY(6);
                break;
            case R.id.R36:
                clickedPosition.setX(3);
                clickedPosition.setY(6);
                break;
            case R.id.R46:
                clickedPosition.setX(4);
                clickedPosition.setY(6);
                break;
            case R.id.R56:
                clickedPosition.setX(5);
                clickedPosition.setY(6);
                break;
            case R.id.R66:
                clickedPosition.setX(6);
                clickedPosition.setY(6);
                break;
            case R.id.R76:
                clickedPosition.setX(7);
                clickedPosition.setY(6);
                break;

            case R.id.R07:
                clickedPosition.setX(0);
                clickedPosition.setY(7);
                break;
            case R.id.R17:
                clickedPosition.setX(1);
                clickedPosition.setY(7);
                break;
            case R.id.R27:
                clickedPosition.setX(2);
                clickedPosition.setY(7);
                break;
            case R.id.R37:
                clickedPosition.setX(3);
                clickedPosition.setY(7);
                break;
            case R.id.R47:
                clickedPosition.setX(4);
                clickedPosition.setY(7);
                break;
            case R.id.R57:
                clickedPosition.setX(5);
                clickedPosition.setY(7);
                break;
            case R.id.R67:
                clickedPosition.setX(6);
                clickedPosition.setY(7);
                break;
            case R.id.R77:
                clickedPosition.setX(7);
                clickedPosition.setY(7);
                break;
        }
    }
    
    @Override
    public void onClick(View v) {
        getClickedPos();
        
        Position clickedPositionOnBoard = Board[clickedPosition.getX()][clickedPosition.getY()];
        Position lastPositionOnBoard = Board[lastPos.getX()][lastPos.getY()];
        Piece pieceOnClickedPos = clickedPositionOnBoard.getPiece();
        TextView clickedPositionOnDisplayBoard = DisplayBoard[clickedPosition.getX()][clickedPosition.getY()];
        TextView lastPositionOnDisplayBoard = DisplayBoard[lastPos.getX()][lastPos.getY()];
        boolean isNotFriendlyFire = pieceOnClickedPos.isWhite() != WhitePlayerTurn;

        if(AnythingSelected) {
            if(pieceOnClickedPos == null) {
                if(tryToMovePiece(lastPositionOnBoard, clickedPositionOnBoard)) {
                    checkForPawn();
                    WhitePlayerTurn = !WhitePlayerTurn;
                }
            }
            else {
                if(isNotFriendlyFire) {
                    boolean moved = tryToMovePiece(lastPositionOnBoard, clickedPositionOnBoard);

                    if(moved) {
                        if(pieceOnClickedPos instanceof King) {
                            game_over.setVisibility(View.VISIBLE);
                        }
                        checkForPawn();
                    }
                    WhitePlayerTurn = !WhitePlayerTurn;
                }
                else {
                    resetColorsOnMove();
                    resetAllowedMoves();
                    return;
                }
            }
            AnythingSelected = false;
        }
        else {
            if(pieceOnClickedPos != null) {
                resetAllowedMoves();
                AnythingSelected = true;
            }
        }

        isKingInDanger();
        lastPos = new Coordinates(clickedPosition.getX(), clickedPosition.getY());
        drawBoard();
    }

    public void resetAllowedMoves() {
        listOfCoordinates.clear();
        listOfCoordinates = pieceOnClickedPos.AllowedMoves(clickedPosition, Board);
        setColorAtPosition(clickedPosition, R.color.colorSelected);
        setColorAtAllowedPosition(listOfCoordinates);
    }

    public boolean tryToMovePiece(Position fromPos, Position toPos) {
        boolean isMoveAllowed = moveIsAllowed(listOfCoordinates, clickedPosition);
        if(isMoveAllowed) {
            saveBoard();
            toPos.setPiece(fromPos.getPiece());
            fromPos.setPiece(null);
        }

        resetColorsOnMove();
        return isMoveAllowed;
    }

    public void saveBoard() {
        numberOfMoves = 1;
        LastMoves.add(numberOfMoves-1, Board2);

        for (int board_row = 0; board_row < 8; board_row++)
            for (int board_col = 0; board_col < 8; board_col++)
                LastMoves.get(numberOfMoves-1)[board_row][board_col] = new Position(null);

        for (int board_row = 0; board_row < 8; board_row++)
            for (int board_col = 0; board_col < 8; board_col++)
                LastMoves.get(numberOfMoves-1)[board_row][board_col].setPiece(
                    Board[board_row][board_col].getPiece()
                );
    }

    public void undo(View v){
        if(numberOfMoves > 0) {
            lastMove = LastMoves.get(--numberOfMoves);
            
            for(int board_row = 0; board_row < 8; board_row++)
                for(int board_col = 0; board_col < 8; board_col++)
                    Board[board_row][board_col].setPiece(
                        lastMove[board_row][board_col].getPiece()
                    );
            
            drawBoard();
            for(int board_row = 0; board_row < 8; board_row++)
                for(int board_col = 0; board_col < 8; board_col++)
                    resetColorAtPosition(new Coordinates(board_row, board_col);

            isKingInDanger();
            WhitePlayerTurn = !WhitePlayerTurn;
            game_over.setVisibility(View.INVISIBLE);
        }
    }

    public void pawnChoice(View v){
        int drawable_resource, x = v.getId();
        Position clickedPositionOnBoard = Board[clickedPosition.getX()][clickedPosition.getY()];
        TextView clickedPositionOnDisplayBoard = DisplayBoard[clickedPosition.getX()][clickedPosition.getY()];
        boolean pawnIsWhite = clickedPosition.getY() == 0;
        
        switch (x){
            case R.id.pawn_queen:
                clickedPositionOnBoard.setPiece(new Queen(pawnIsWhite));
                drawable_resource = pawnIsWhite ? R.drawable.wqueen : R.drawable.bqueen;
                break;
            case R.id.pawn_rook:
                clickedPositionOnBoard.setPiece(new Rook(pawnIsWhite));
                drawable_resource = pawnIsWhite ? R.drawable.wrook : R.drawable.brook;
                break;
            case R.id.pawn_bishop:
                clickedPositionOnBoard.setPiece(new Bishop(pawnIsWhite));
                drawable_resource = pawnIsWhite ? R.drawable.wbishop : R.drawable.bbishop;
                break;
            case R.id.pawn_knight:
                clickedPositionOnBoard.setPiece(new Knight(pawnIsWhite));
                drawable_resource = pawnIsWhite ? R.drawable.wknight : R.drawable.bknight;
                break;
        }
        clickedPositionOnDisplayBoard.setBackgroundResource(drawable_resource);
        pawn_choices.setVisibility(View.INVISIBLE);
    }

    private boolean moveIsAllowed(ArrayList<Coordinates> piece, Coordinates coordinate) {
        for(Coordinates curPiece: piece) {
            if(curPiece.getX() == coordinate.getX()  &&  curPiece.getY() == coordinate.getY())
                return true;
        }
        return false;
    }

    // Board Positions Color Setting Begin

    private void setColorAtPosition(Coordinates position, int color_resource_id) {
        DisplayBoardBackground[position.getX()][position.getY()].setBackgroundResource(color_resource_id);
    }

    private void resetColorAtPosition(Coordinates position){
        int board_color_resource = position.sumIsEven() ? R.color.colorBoardDark : R.color.colorBoardLight;
        setColorAtPosition(position, board_color_resource);
    }

    void setColorAtAllowedPosition(ArrayList<Coordinates> allowedMoves) {
        for(Coordinates curPos: allowedMoves) {
            Piece pieceOnPos = Board[curPos.getX()][curPos.getY()].getPiece();

            int color_resource_id = pieceOnPos == null ? R.color.colorPositionAvailable : R.color.colorDanger;
            setColorAtPosition(curPos, color_resource_id);
        }
    }

    private void resetColorAtAllowedPosition(ArrayList<Coordinates> allowedMoves) {
        for(Coordinates curPos: allowedMoves)
            resetColorAtPosition(curPos);
    }

    private void resetColorsOnMove() {
        resetColorAtPosition(lastPos);
        resetColorAtAllowedPosition(listOfCoordinates);
    }

    // Board Positions Color Setting End

    private void isKingInDanger(){
        for(int board_row = 0; board_row < 8; board_row++) {
            for(int board_col = 0; board_col < 8; board_col++) {
                Piece curPieceOnBoard = Board[board_row][board_col].getPiece();
                
                if(curPieceOnBoard == null)
                    continue;

                ArrayList<Coordinates> CurPieceAllowedMoves = curPieceOnBoard.AllowedMoves(
                    new Coordinates(board_row, board_col),
                    Board
                );

                for (Coordinates allowedMove: CurPieceAllowedMoves) {
                    Piece pieceOnAllowedMove = Board[allowedMove.getX()][allowedMove.getY()].getPiece();

                    if(!(pieceOnAllowedMove instanceof King) || curPieceOnBoard.isFriend(pieceOnAllowedMove))
                        continue;

                    resetColorAtPosition(allowedMove);
                    setColorAtPosition(allowedMove, R.color.colorKingInDanger);
                    return;
                }

            }
        }
    }

    private void checkForPawn(){
        Piece pieceOnClickedPos = Board[clickedPosition.getX()][clickedPosition.getY()].getPiece();
        
        if(!(pieceOnClickedPos instanceof Pawn))
            return;

        boolean pawnIsWhite = pieceOnClickedPos.isWhite();
        int clickedPositionY = clickedPosition.getY();

        if(pawnIsWhite && clickedPositionY == 0)
            pawn_choices.setVisibility(View.VISIBLE)
        else if (!pawnIsWhite && clickedPositionY == 7) {
            pawn_choices.setVisibility(View.VISIBLE);
            pawn_choices.setRotation(180);
        }
        isKingInDanger();
    }
}