import java.util.Set;

abstract class Piece {
    public BoardPosition currentPosition;
    public boolean isWhite;
    public boolean hasMoved;
    public Piece(BoardPosition currentPosition, boolean hasMoved, boolean isWhite) {
        this.currentPosition = currentPosition;
        this.hasMoved = hasMoved;
        this.isWhite = isWhite;
    }
    public Piece() {
    }
    abstract boolean getHasMoved();
    abstract void setHasMoved(boolean hasMoved);
    abstract void setPosition(BoardPosition boardPosition);
    abstract BoardPosition getPosition();
    abstract boolean isPossibleMove(BoardPosition endPosition);
    abstract Set<BoardPosition> trace(BoardPosition endPosition);
    abstract String unicodeSymbol();


}
