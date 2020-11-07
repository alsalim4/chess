import java.util.Objects;

public class BoardPosition {
    public Vertical vertical;
    public Horizontal horizontal;
    public BoardPosition(Vertical vertical, Horizontal horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    //    boolean isBlackCell(){
//        return true;
//    } если где-то в какой-то игре нужно знать цвет клетки
    Vertical getVertical(){
        return this.vertical;
    }
    Horizontal getHorizontal(){
        return this.horizontal;
    }
    public int HorizontalTransfer(BoardPosition p){
        return p.horizontal.ordinal();
    }
    public int VerticalTransfer(BoardPosition p){
        return p.vertical.ordinal();
    }
    @Override
    public String toString() {
        return "Boardposition{" +
                "v=" + vertical +
                ", g=" + horizontal +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardPosition that = (BoardPosition) o;
        return vertical == that.vertical &&
                horizontal == that.horizontal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertical, horizontal);
    }


}
