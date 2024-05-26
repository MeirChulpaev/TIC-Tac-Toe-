import java.util.Scanner;

public class XO1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] arr = {{'*', '*', '*'},
                        {'*', '*', '*'},
                   {'*', '*', '*'}};
        char c = ' ';
        while (!win(arr, c)) {
            bord(arr);
            if (c== '0') {
                c = 'x';
            } else {
                c = '0';
            }
                System.out.println("enter your row player " + c);
                int a = in.nextInt() - 1;
                System.out.println("enter your column player " + c);
                int b = in.nextInt() - 1;

            acter(arr, a, b, c);
            if (!draw(arr) && !win(arr, c)) {
                System.err.println("it's draw, try the game again");
                break;
            }

        }
        if (win(arr, c)) {
            bord(arr);
            System.out.println(c+" win ");
        }
    }

    public static void bord(char[][] arr) {
        System.out.println("     1   2   3");
        System.out.println("   -------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print((i + 1) + "  | ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " | ");

            }
            System.out.println();
            System.out.print("   -------------");
            System.out.println();
        }
    }

    public static void acter(char[][] arr, int a, int b, char c) {
        Scanner in = new Scanner(System.in);
        while (true) {
            if (a>=0&&a<=2&&b>=0&&b<=2&&arr[a][b] == '*') {
                arr[a][b] = c;
                break;
            }
             else {
                System.out.println("enter your row player " + c+" agn ");
                a = in.nextInt()-1;
                System.out.println("enter your column player " + c+" agn ");
                b=in.nextInt()-1;
            }
        }
    }

    public static boolean win(char[][] arr, char c) {
        boolean test2 = true;
        for (int i = 0; i < 3; i++) {
            boolean testRow=true;
            boolean testColumn = true;
            for (int j = 0; j <3 ; j++) {
                if (arr[i][j]!=c)
                    testRow=false;
                if (arr[j][i]!=c)
                    testColumn=false;
                if (arr[j][j]!=c)
                    test2=false;
            }if (testRow)
                return testRow;
            if (testColumn)
                return testColumn;

            if (test2)
                return test2;
        }
        if (arr[0][2] == (arr[1][1]) && arr[1][1] == (arr[2][0]) && arr[2][0] != '*') {
            return true;
        }
        return false;
    }

    public static boolean draw ( char[][] arr){
        boolean a = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == '*') {
                    a = true;
                }
            }
        }
        return a;
    }
}