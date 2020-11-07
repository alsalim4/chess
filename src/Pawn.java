import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.abs;

public class Pawn extends Piece {

    public Pawn(BoardPosition currentpos, boolean hasMoved, boolean isWhite) {
        super(currentpos, hasMoved, isWhite);
    }
    public Pawn(){
        super();
    }
    public boolean getHasMoved() {
        return hasMoved;
    }
    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
    public BoardPosition getPosition() {
        return this.currentPosition;
    }

    @Override
    void setPosition(BoardPosition boardPosition) {
        this.currentPosition=boardPosition;
    }

    @Override
    Set<BoardPosition> trace(BoardPosition endPosition) {
        return null;
    }
    String getNotationSymbol(String f){
        if(isWhite==true){
            if(f.equals("Rook"))
                return "♖";
            else if(f.equals("Bishop"))
                return "♗";
            else if(f.equals("Knight"))
                return "♘";
            else if(f.equals("Queen"))
                return "♕";
        }
        else if (isWhite==false){
            if(f.equals("Rook"))
                return "♜";
            else if(f.equals("Bishop"))
                return "♝";
            else if(f.equals("Knight"))
                return "♞";
            else if(f.equals("Queen"))
                return "♛";
        }
        return "E";
    }
    @Override
    String unicodeSymbol(){
        if(this.isWhite==true)
            return "\t♙";
        else
            return "\t♟";
    }
    @Override
    boolean isPossibleMove(BoardPosition endPosition){
        if(this.currentPosition.VerticalTransfer(currentPosition)==endPosition.VerticalTransfer(endPosition) && ((this.isWhite==true && ((this.currentPosition.HorizontalTransfer(currentPosition)+1==endPosition.HorizontalTransfer(endPosition)) || (this.currentPosition.HorizontalTransfer(currentPosition)+2==endPosition.HorizontalTransfer(endPosition) &&  this.hasMoved==false)))
                || (this.isWhite==false && ((this.currentPosition.HorizontalTransfer(currentPosition)-1==endPosition.HorizontalTransfer(endPosition)) || (this.currentPosition.HorizontalTransfer(currentPosition)-2==endPosition.HorizontalTransfer(endPosition) &&  this.hasMoved==false)))))
            return true;
        else
            return false;
    }
}
