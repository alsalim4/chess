import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.abs;

public class Bishop extends Piece {
    public Bishop(BoardPosition currentPosition,boolean hasMoved, boolean isWhite) {
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
    String unicodeSymbol() {
        if (isWhite == true)
            return "\t♗";
        else
            return "\t♝";
    }

    @Override
    boolean isPossibleMove(BoardPosition endPosition) {
        if (abs(currentPosition.HorizontalTransfer(currentPosition) - endPosition.HorizontalTransfer(endPosition)) == abs(currentPosition.VerticalTransfer(currentPosition)) - endPosition.VerticalTransfer(endPosition))
            return true;
        else
            return false;
    }

    @Override
    public Set<BoardPosition> trace(BoardPosition endPosition) {
        HashSet<BoardPosition> trace = new HashSet<BoardPosition>();
        if (Utils.enumValue(currentPosition, endPosition).equals("<>")) {
            Horizontal[] g = Horizontal.values();
            Vertical[] v = Vertical.values();
            int endh = endPosition.horizontal.ordinal();
            int currenth = currentPosition.horizontal.ordinal();
            int endv = endPosition.vertical.ordinal();
            int currentv = currentPosition.vertical.ordinal();
            while (endh > currenth && endv < currentv) {
                trace.add(new BoardPosition(v[endv], g[endh]));
                endh--;
                endv++;
            }
            trace.remove(endPosition);
            return trace;
        } else if (Utils.enumValue(currentPosition, endPosition).equals("><")) {
            Horizontal[] g = Horizontal.values();
            Vertical[] v = Vertical.values();
            int endh = endPosition.horizontal.ordinal();
            int currenth = currentPosition.horizontal.ordinal();
            int endv = endPosition.vertical.ordinal();
            int currentv = currentPosition.vertical.ordinal();
            while (endh < currenth && endv > currentv) {
                trace.add(new BoardPosition(v[endv], g[endh]));
                endh++;
                endv--;
            }
            trace.remove(endPosition);
            return trace;
        } else if (Utils.enumValue(currentPosition, endPosition).equals("<<")) {
            Horizontal[] g = Horizontal.values();
            Vertical[] v = Vertical.values();
            int endh = endPosition.horizontal.ordinal();
            int currenth = currentPosition.horizontal.ordinal();
            int endv = endPosition.vertical.ordinal();
            int currentv = currentPosition.vertical.ordinal();
            while (endh > currenth && endv > currentv) {
                trace.add(new BoardPosition(v[endv], g[endh]));
                endh--;
                endv--;
            }
            trace.remove(endPosition);
            return trace;
        } else if (Utils.enumValue(currentPosition, endPosition).equals(">>")) {
            Horizontal[] g = Horizontal.values();
            Vertical[] v = Vertical.values();
            int endh = endPosition.horizontal.ordinal();
            int currenth = currentPosition.horizontal.ordinal();
            int endv = endPosition.vertical.ordinal();
            int currentv = currentPosition.vertical.ordinal();
            while (endh < currenth && endv < currentv) {
                trace.add(new BoardPosition(v[endv], g[endh]));
                endh++;
                endv++;
            }
            trace.remove(endPosition);
            return trace;
        }
        return null;
    }
}
