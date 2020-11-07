import java.util.Set;

import static java.lang.Math.abs;

public class Knight extends Piece {
    public Knight(BoardPosition currentPosition,boolean hasMoved, boolean isWhite) {
        super(currentPosition,hasMoved,isWhite);
    }
    public boolean getHasMoved() {
        return this.hasMoved;
    }

    void setHasMoved(boolean hasMoved) {
        this.hasMoved=hasMoved;
    }
    void setPosition(BoardPosition boardPosition) {
        this.currentPosition=boardPosition;
    }
    BoardPosition getPosition() {
        return this.currentPosition;
    }

    @Override
    Set<BoardPosition> trace(BoardPosition endPosition) {
        return null;
    }

    @Override
    String unicodeSymbol() {
        if(this.isWhite==true)
            return "\t♘";
        else
            return "\t♞";
    }

    @Override
    boolean isPossibleMove(BoardPosition endPosition) {
        if((abs(currentPosition.VerticalTransfer(currentPosition)-endPosition.VerticalTransfer(endPosition))==2 && abs(currentPosition.HorizontalTransfer(currentPosition)-endPosition.HorizontalTransfer(endPosition))==1)
        || (abs(currentPosition.VerticalTransfer(currentPosition)-endPosition.VerticalTransfer(endPosition))==1 && abs(currentPosition.HorizontalTransfer(currentPosition)-endPosition.HorizontalTransfer(endPosition))==2))
            return true;
        else
            return false;
    }
}
