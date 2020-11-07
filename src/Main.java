import java.util.Scanner;

public class Main {
    public static void main(String []args) {
//        Rook r11 = new Rook(new BoardPosition(Vertical.A,Horizontal._8),false,true);
//        Bishop b11 = new Bishop(new BoardPosition(Vertical.C,Horizontal._8),false,true);
//        Queen q11 = new Queen(new BoardPosition(Vertical.D,Horizontal._8),false,true);
//        System.out.println(r11.trace(new BoardPosition(Vertical.A,Horizontal._1)));
//        System.out.println(b11.trace(new BoardPosition(Vertical.A,Horizontal._6)));
//        System.out.println(q11.trace(new BoardPosition(Vertical.H,Horizontal._4)));
        ClassicGame game1 = new ClassicGame();
        Scanner sc = new Scanner(System.in);
        game1.standartChessPosition();
        if(game1.checkAttack(new BoardPosition(Vertical.B,Horizontal._8)))
            System.out.println("YES");
        else
            System.out.println("NO");
        while (0 != 1) {
            GameConsoleGUI.show(game1);
            String input = sc.next();
            game1.handle(Utils.checkMove(game1,input,game1.isWhiteTurn));
        }
    }
}
