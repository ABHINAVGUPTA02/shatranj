package com.chess_project.thesilentbell.shatranj.piece;

import com.chess_project.thesilentbell.shatranj.Alliance;
import com.chess_project.thesilentbell.shatranj.board.Board;
import com.chess_project.thesilentbell.shatranj.board.BoardUtils;
import com.chess_project.thesilentbell.shatranj.board.Move;
import static com.chess_project.thesilentbell.shatranj.board.Move.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pawn extends Piece{

    private final static int[] CANDIDATE_MOVE_COORDINATE = {8};

    public Pawn(int piecePosition, Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public Collection<Move> calculateLegalMoves(Board board) {
        final List<Move> LegalMoves = new ArrayList<>();

        for(final int currentCandidateOffset: CANDIDATE_MOVE_COORDINATE){
            int candidateDestinationCoordinate = this.piecePosition + (this.getPieceAlliance().getDirection()*currentCandidateOffset);

            if(!BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)){
                continue;
            }

            if(currentCandidateOffset == 8 && !board.getTile(candidateDestinationCoordinate).isTileOccupied()){
                //TODO more work here!!!
                LegalMoves.add(new MajorMove(board,this,candidateDestinationCoordinate));
            }
            
        }

        return LegalMoves;
    }
}
