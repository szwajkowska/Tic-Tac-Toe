package pl.ania;

public class Board {

    char[][] tab = new char[3][3];
    public Board(){

    }

    public void board() {
        System.out.println("  A       B      C");
        System.out.println("      |      |   ");
        System.out.println("1  " + tab[0][0] + "  |  " + tab[0][1] + "   |  " + tab[0][2] + " ");
        System.out.println("      |      |   ");
        System.out.println("  -----------------");
        System.out.println("      |      |   ");
        System.out.println("2  " + tab[1][0] + "  |  " + tab[1][1] + "   |  " + tab[1][2] + " ");
        System.out.println("      |      |   ");
        System.out.println("  -----------------");
        System.out.println("      |      |   ");
        System.out.println("3  " + tab[2][0] + "  |  " + tab[2][1] + "   |  " + tab[2][2] + " ");
        System.out.println("      |      |   ");

    }
}
