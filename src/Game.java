import java.util.List;
import java.util.Set;

public interface Game {
    boolean isWhiteTurn();

    Set<Piece> getPieces();

    List<Move> moveHistory();
}