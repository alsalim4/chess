import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Math.abs;

public class ClassicGame implements Game {
    boolean isWhiteTurn = true;
    BoardPosition king1 = new BoardPosition(Vertical.E, Horizontal._1);
    BoardPosition king0 = new BoardPosition(Vertical.E, Horizontal._8);
    HashSet<Piece> pieces = new HashSet<Piece>();

    public void switchTurn() {
        isWhiteTurn = !isWhiteTurn;
    }

    @Override
    public boolean isWhiteTurn() {
        return false;
    }

    @Override
    public Set<Piece> getPieces() {
        return null;
    }

    @Override
    public List<Move> moveHistory() {
        return null;
    }

    public void standartChessPosition() {
        Pawn p11 = new Pawn(new BoardPosition(Vertical.F, Horizontal._2), false, true);
        Pawn p21 = new Pawn(new BoardPosition(Vertical.B, Horizontal._2), false, true);
        Pawn p31 = new Pawn(new BoardPosition(Vertical.C, Horizontal._2), false, true);
        Pawn p41 = new Pawn(new BoardPosition(Vertical.D, Horizontal._2), false, true);
        Pawn p51 = new Pawn(new BoardPosition(Vertical.E, Horizontal._2), false, true);
        Pawn p61 = new Pawn(new BoardPosition(Vertical.A, Horizontal._2), false, true);
        Pawn p71 = new Pawn(new BoardPosition(Vertical.G, Horizontal._2), false, true);
        Pawn p81 = new Pawn(new BoardPosition(Vertical.H, Horizontal._2), false, true);
//        Pawn p10 = new Pawn(new BoardPosition(Vertical.A, Horizontal._7), false, false);
        Pawn p20 = new Pawn(new BoardPosition(Vertical.B, Horizontal._7), false, false);
        Pawn p30 = new Pawn(new BoardPosition(Vertical.C, Horizontal._7), false, false);
        Pawn p40 = new Pawn(new BoardPosition(Vertical.D, Horizontal._7), false, false);
        Pawn p50 = new Pawn(new BoardPosition(Vertical.E, Horizontal._7), false, false);
        Pawn p60 = new Pawn(new BoardPosition(Vertical.F, Horizontal._7), false, false);
        Pawn p70 = new Pawn(new BoardPosition(Vertical.G, Horizontal._7), false, false);
        Pawn p80 = new Pawn(new BoardPosition(Vertical.H, Horizontal._7), false, false);
        Rook r11 = new Rook(new BoardPosition(Vertical.A, Horizontal._1), false, true);
        Rook r12 = new Rook(new BoardPosition(Vertical.H, Horizontal._1), false, true);
        Rook r01 = new Rook(new BoardPosition(Vertical.A, Horizontal._8), false, false);
        Rook r02 = new Rook(new BoardPosition(Vertical.H, Horizontal._8), false, false);
        Bishop b11 = new Bishop(new BoardPosition(Vertical.C, Horizontal._1), false, true);
        Bishop b12 = new Bishop(new BoardPosition(Vertical.F, Horizontal._1), false, true);
        Bishop b01 = new Bishop(new BoardPosition(Vertical.C, Horizontal._8), false, false);
        Bishop b02 = new Bishop(new BoardPosition(Vertical.F, Horizontal._8), false, false);
        Knight n11 = new Knight(new BoardPosition(Vertical.B, Horizontal._1), false, true);
        Knight n12 = new Knight(new BoardPosition(Vertical.G, Horizontal._1), false, true);
        Knight n01 = new Knight(new BoardPosition(Vertical.B, Horizontal._8), false, false);
        Knight n02 = new Knight(new BoardPosition(Vertical.G, Horizontal._8), false, false);
        Queen q1 = new Queen(new BoardPosition(Vertical.D, Horizontal._1), false, true);
        Queen q0 = new Queen(new BoardPosition(Vertical.D, Horizontal._8), false, false);
        King k1 = new King(new BoardPosition(Vertical.E, Horizontal._1), false, true);
        King k0 = new King(new BoardPosition(Vertical.E, Horizontal._8), false, false);
        pieces.add(p11);
        pieces.add(p21);
        pieces.add(p31);
        pieces.add(p41);
        pieces.add(p51);
        pieces.add(p61);
        pieces.add(p71);
        pieces.add(p81);
//        pieces.add(p10);
        pieces.add(p20);
        pieces.add(p30);
        pieces.add(p40);
        pieces.add(p50);
        pieces.add(p60);
        pieces.add(p70);
        pieces.add(p80);
        pieces.add(r11);
        pieces.add(r12);
        pieces.add(r01);
        pieces.add(r02);
        pieces.add(b11);
        pieces.add(b12);
        pieces.add(b01);
        pieces.add(b02);
        pieces.add(n11);
        pieces.add(n12);
        pieces.add(n01);
        pieces.add(n02);
        pieces.add(q1);
        pieces.add(k1);
        pieces.add(q0);
        pieces.add(k0);


    }

    //    public  HashSet<Piece> piecePos(){
//        return pieces;
//    }
    public void handle(Move move) {
        if (move.getClass().getName() == "SimpleChessMove")
            handleSimpleMove((SimpleChessMove) move);
        if (move.getClass().getName() == "PawnTransformationMove")
            handlePawnTransform((PawnTransformationMove) move);
        if (move.getClass().getName() == "ShortCastlingMove")
            handleShortCastlingMove((ShortCastlingMove) move);
        if (move.getClass().getName() == "LongCastlingMove")
            handleLongCastlingMvoe((LongCastlingMove) move);
    }

    private void handleSimpleMove(SimpleChessMove simpleChessMove) {
        Piece p1 = getPiece(simpleChessMove.getPosition().vertical, simpleChessMove.getPosition().horizontal);
        if (p1.getClass().getName().equals("Pawn")) {
            if (getPiece(simpleChessMove.getTarget().vertical, simpleChessMove.getTarget().horizontal) == null)
                if (isWhiteTurn == p1.isWhite && p1.isPossibleMove(simpleChessMove.getTarget()) && getPiece(simpleChessMove.getTarget().vertical, simpleChessMove.getTarget().horizontal) == null /*&& p1.currentPosition проверка trace*/) {
                    this.movingFigure(p1, simpleChessMove.getTarget());
                    switchTurn();
                } else {
                    System.out.println("Impossible move");
                    return;
                }
            else if (getPiece(simpleChessMove.getTarget().vertical, simpleChessMove.getTarget().horizontal).isWhite != isWhiteTurn && isWhiteTurn == p1.isWhite && abs(p1.currentPosition.VerticalTransfer(p1.currentPosition) - simpleChessMove.getTarget().VerticalTransfer(simpleChessMove.getTarget())) == 1
                    && ((p1.isWhite == true && simpleChessMove.getTarget().HorizontalTransfer(simpleChessMove.getTarget()) - p1.currentPosition.HorizontalTransfer(p1.currentPosition) == 1)
                    || (p1.isWhite == false && simpleChessMove.getTarget().HorizontalTransfer(simpleChessMove.getTarget()) - p1.currentPosition.HorizontalTransfer(p1.currentPosition) == -1))) {
                this.movingFigure(p1, simpleChessMove.getTarget());
                switchTurn();
            } else {
                System.out.println("Impossible move");
                return;
            }

        } else if (isWhiteTurn == p1.isWhite && p1.isPossibleMove(simpleChessMove.getTarget())
                && (getPiece(simpleChessMove.getTarget().vertical, simpleChessMove.getTarget().horizontal) == null || getPiece(simpleChessMove.getTarget().vertical, simpleChessMove.getTarget().horizontal).isWhite != isWhiteTurn)) {
            if (p1.trace(simpleChessMove.getTarget()) != null)
                for (BoardPosition traceCell : p1.trace(simpleChessMove.getTarget())) {
                    if (getPiece(traceCell.vertical, traceCell.horizontal) != null) {
                        System.out.println("Impossible move");
                        return;
                    }
                }
            this.movingFigure(p1, simpleChessMove.getTarget());
            switchTurn();
        } else {
            System.out.println("Impossible move");
            return;
        }
    }

    private void handlePawnTransform(PawnTransformationMove pawnTransformationMove) {

    }

    private void handleShortCastlingMove(ShortCastlingMove shortCastlingMove) {
//        if((isWhiteTurn==false && getPiece(Vertical.F,Horizontal._8)==null && getPiece(Vertical.G,Horizontal._8)==null && getPiece(king0.vertical,king0.horizontal).hasMoved==false && getPiece(Vertical.H,Horizontal._8).hasMoved==false)
//        || isWhiteTurn==true)
    }

    private void handleLongCastlingMvoe(LongCastlingMove longCastlingMove) {

    }

    public Piece getPiece(Vertical v, Horizontal h) {
        for (Piece p1 : pieces) {
            if (p1.getPosition().equals(new BoardPosition(v, h)))
                return p1;
        }
        return null;
    }

    public void movingFigure(Piece piece, BoardPosition boardPosition) {
        Piece piece1;
        piece1 = piece;
        piece1.hasMoved = true;
        piece1.setPosition(boardPosition);
        pieces.remove(piece);
        pieces.add(piece1);
    }

    public boolean checkAttack(BoardPosition target) {
        boolean WhiteTurn = !isWhiteTurn;
        boolean possibility=false;
        for(Piece p1:pieces){
            boolean traceEmpty=true;
                    if (p1.getClass().getName().equals("Pawn")) {
                         if (WhiteTurn == p1.isWhite && abs(p1.currentPosition.VerticalTransfer(p1.currentPosition) - target.VerticalTransfer(target)) == 1
                                && ((p1.isWhite == true && target.HorizontalTransfer(target) - p1.currentPosition.HorizontalTransfer(p1.currentPosition) == 1)
                                || (p1.isWhite == false && target.HorizontalTransfer(target) - p1.currentPosition.HorizontalTransfer(p1.currentPosition) == -1))) {
                            return true;
                        } else {
                            possibility = false;
                        }

                    } else if (WhiteTurn == p1.isWhite && p1.isPossibleMove(target)
                            && (getPiece(target.vertical, target.horizontal) == null || getPiece(target.vertical, target.horizontal).isWhite != WhiteTurn)) {
                        if (p1.trace(target) != null)
                            for (BoardPosition traceCell : p1.trace(target)) {
                                if (getPiece(traceCell.vertical, traceCell.horizontal) != null) {
                                    traceEmpty=false;
                                    break;
                                }
                            }
                        if(traceEmpty)
                            return true;
                        else
                            possibility = false;
                    } else {
                        possibility = false;
                    }
                }
            return possibility;
    }
}

