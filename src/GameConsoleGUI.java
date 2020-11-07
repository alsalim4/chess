public class GameConsoleGUI {
    public static void show(ClassicGame game){
        int i=1;
        System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH");
        for(Horizontal h : Horizontal.values()){
            System.out.print(i++);
            for(Vertical v : Vertical.values()){
                if(game.getPiece(v,h) == null)
                    System.out.print("\t▭");
                else
                    System.out.print(game.getPiece(v,h).unicodeSymbol());
            }
            System.out.println();
        }
    }
}
