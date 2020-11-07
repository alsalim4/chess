import java.util.Objects;

public class SimpleChessMove extends Move {
    private BoardPosition position;
    private BoardPosition target;
    private Class<? extends Piece> pieceClass;

    public void setPosition(BoardPosition position) {
        this.position = position;
    }

    public void setPieceClass(Class<? extends Piece> pieceClass) {
        this.pieceClass = pieceClass;
    }

    public void setTarget(BoardPosition target) {
        this.target = target;
    }

    public BoardPosition getPosition() {
        return position;
    }

    public BoardPosition getTarget() {
        return target;
    }

    public Class<? extends Piece> getPieceClass() {
        return pieceClass;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleChessMove that = (SimpleChessMove) o;
        return Objects.equals(position, that.position) &&
                Objects.equals(target, that.target) &&
                Objects.equals(pieceClass, that.pieceClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, target, pieceClass);
    }
}
