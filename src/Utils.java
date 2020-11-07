public class Utils {
        static Move checkMove(ClassicGame classicGame,String turn,boolean isWhite){
        if(turn=="0-0-0")
            return new LongCastlingMove();
        if(turn=="0-0")
            return new ShortCastlingMove();
        if((isWhite==true && turn.charAt(4)=='8') || (isWhite==false && turn.charAt(4)=='1'))
             return new PawnTransformationMove();
        SimpleChessMove move1 = new SimpleChessMove();
        String a = turn.substring(0, 1);
        String b = turn.substring(1, 2);
        String x = turn.substring(3, 4);
        String y = turn.substring(4);
        String _a=a.toUpperCase();
        String _b="_"+b;
        String _x=x.toUpperCase();//возможны ошибки если неправильный ход
        String _y="_"+y;
        try {
            Vertical v1 = Vertical.valueOf(_a);
            Horizontal h1 = Horizontal.valueOf(_b);
            Vertical v2 = Vertical.valueOf(_x);
            Horizontal h2 = Horizontal.valueOf(_y);
            BoardPosition startPos = new BoardPosition(v1, h1);
            BoardPosition endPos = new BoardPosition(v2, h2);
            for (Piece p : classicGame.pieces) {
                if (p.currentPosition.equals(startPos)) {// проверить
                    move1.setPieceClass(p.getClass());
                }
            }
            move1.setTarget(endPos);
            move1.setPosition(startPos);
            if (move1.getPieceClass() == null)
                throw new ChessErrorPiece();
            else
                return move1;
        }
        catch (IllegalArgumentException iae){
            throw new ImpossibleMoveException();
        }
    }
    public static String enumValue(BoardPosition startPosition,BoardPosition target){
        if(startPosition.HorizontalTransfer(startPosition)>target.HorizontalTransfer(target) && startPosition.VerticalTransfer(startPosition) > target.VerticalTransfer(target))
            return ">>";
        else if(startPosition.HorizontalTransfer(startPosition)>target.HorizontalTransfer(target) && startPosition.VerticalTransfer(startPosition) < target.VerticalTransfer(target))
            return "><";
        else if(startPosition.HorizontalTransfer(startPosition)>target.HorizontalTransfer(target) && startPosition.VerticalTransfer(startPosition) == target.VerticalTransfer(target))
            return ">=";
        else if(startPosition.HorizontalTransfer(startPosition)==target.HorizontalTransfer(target) && startPosition.VerticalTransfer(startPosition) < target.VerticalTransfer(target))
            return "=<";
        else if(startPosition.HorizontalTransfer(startPosition)==target.HorizontalTransfer(target) && startPosition.VerticalTransfer(startPosition) == target.VerticalTransfer(target))
            return "==";
        else if(startPosition.HorizontalTransfer(startPosition)==target.HorizontalTransfer(target) && startPosition.VerticalTransfer(startPosition) > target.VerticalTransfer(target))
            return "=>";
        else if(startPosition.HorizontalTransfer(startPosition)<target.HorizontalTransfer(target) && startPosition.VerticalTransfer(startPosition) < target.VerticalTransfer(target))
            return "<<";
        else if(startPosition.HorizontalTransfer(startPosition)<target.HorizontalTransfer(target) && startPosition.VerticalTransfer(startPosition) == target.VerticalTransfer(target))
            return "<=";
        else
            return "<>";
    }

}
