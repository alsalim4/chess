import java.util.HashSet;
import java.util.Set;

public class Rook extends Piece {
    public Rook(BoardPosition currentPosition,boolean hasMoved, boolean isWhite) {
        super(currentPosition,hasMoved,isWhite);
    }
    public Rook(){
        super();
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
    public Set<BoardPosition> trace(BoardPosition endPosition) {
        HashSet<BoardPosition> trace = new HashSet<BoardPosition>();
        if (Utils.enumValue(currentPosition, endPosition).equals("<=")) {
            Vertical[] v = Vertical.values();
            Horizontal[] h = Horizontal.values();
            int currentPosH = currentPosition.HorizontalTransfer(currentPosition);
            int endPosH = endPosition.HorizontalTransfer(endPosition);
            while(endPosH > currentPosH){
                trace.add(new BoardPosition(endPosition.vertical,h[endPosH]));
                --endPosH;
            }
            trace.remove(endPosition);
            return trace;
        }
        if (Utils.enumValue(currentPosition, endPosition).equals(">=")) {
            Vertical[] v = Vertical.values();
            Horizontal[] h = Horizontal.values();
            int currentPosH = currentPosition.HorizontalTransfer(currentPosition);
            int endPosH = endPosition.HorizontalTransfer(endPosition);
            while(endPosH < currentPosH){
                trace.add(new BoardPosition(endPosition.vertical,h[endPosH]));
                ++endPosH;
            }
            trace.remove(endPosition);
            return trace;
        }
        if (Utils.enumValue(currentPosition, endPosition).equals("=<")) {
            Vertical[] v = Vertical.values();
            Horizontal[] h = Horizontal.values();
            int currentPosV = currentPosition.VerticalTransfer(currentPosition);
            int endPosV = endPosition.VerticalTransfer(endPosition);
            while(endPosV > currentPosV){
                trace.add(new BoardPosition(v[endPosV],endPosition.horizontal));
                --endPosV;
            }
            trace.remove(endPosition);
            return trace;
        }
        if (Utils.enumValue(currentPosition, endPosition).equals("=>")) {
            Vertical[] v = Vertical.values();
            Horizontal[] h = Horizontal.values();
            int currentPosV = currentPosition.VerticalTransfer(currentPosition);
            int endPosV = endPosition.VerticalTransfer(endPosition);
            while(endPosV < currentPosV){
                trace.add(new BoardPosition(v[endPosV],endPosition.horizontal));
                ++endPosV;
            }
            trace.remove(endPosition);
            return trace;
        }
        return null;
    }


    @Override
    String unicodeSymbol() {
        if(isWhite==true)
            return "\t♖";
        else
            return "\t♜";
    }
    @Override
    boolean isPossibleMove(BoardPosition endPosition) {
        if((currentPosition.HorizontalTransfer(currentPosition)==endPosition.HorizontalTransfer(endPosition) && currentPosition.VerticalTransfer(currentPosition)!=endPosition.VerticalTransfer(endPosition))
            || (currentPosition.HorizontalTransfer(currentPosition)!=endPosition.HorizontalTransfer(endPosition) && currentPosition.VerticalTransfer(currentPosition)==endPosition.VerticalTransfer(endPosition)))
            return true;
        else
            return false;
    }
}
