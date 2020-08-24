package mor;


import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static int i;
    static int j;
    static int x;
    static int y;
    static int data;
    static String str;
    static boolean onePassage;
    static int lengthMatrixX;
    static  int lengthMatrixY;
    static  int[][] matrix1;
    static  int[][] matrix2;
    static int[][] matrix3;
    static  LinkedList<Data> data1;
    static  LinkedList<Data> data2;
    public static void main(String[] args) {
      onePassage = true;

        System.out.println("сторона матрицы X :");
        Scanner scan = new Scanner(System.in);
        lengthMatrixX = scan.nextInt();
        System.out.println("сторона матрицы Y :");
        lengthMatrixY = scan.nextInt();

         data1 = new LinkedList<>();
         data2 = new LinkedList<>();


         matrix1 = new int[lengthMatrixX][lengthMatrixY];
        matrix2 = new int[lengthMatrixX][lengthMatrixY];
        matrix3 = new int[lengthMatrixX][lengthMatrixY];
        System.out.println("введите элементы для матрицы 1; вводить :x y data");
        str = scan.nextLine();// из-за \n после extInt()

        do {
            exit1:
            {

            if (onePassage)
                break exit1;
            if (proverka())
                break exit1;

            for (Data dat1 : data1) {
                if ((x == dat1.getX()) && (y == dat1.getY())) {
                    dat1.setData(data);
                    matrix1[x][y] = data;
                    break exit1;
                }
            }
            matrix1[x][y] = data;
            data1.add(new Data(x, y, data));
        }
            if (onePassage) onePassage = false;
            System.out.println("введите элементы:");
            str = scan.nextLine();
            str = str.trim();
        } while (!str.equals("stop"));
        onePassage = true;
        System.out.println("введите элементы для матрицы 2; вводить :x y data");
        do {
            exit2:
            {
                if (onePassage) break exit2;

                if (proverka())
                    break exit2;

                for (Data dat2 : data2) {
                    if ((x == dat2.getX()) && (y == dat2.getY())) {
                        dat2.setData(data);
                        matrix2[x][y] = data;
                        break exit2;
                    }
                }
                matrix2[x][y] = data;
                data2.add(new Data(x, y, data));
            }
            if (onePassage) onePassage = false;
            System.out.println("введите элементы:");
            str = scan.nextLine();
            str = str.trim();
        } while (!str.equals("stop"));

        //2й способ----

        for (Data dat1 : data1)
            matrix3[dat1.getX()][dat1.getY()] += dat1.getData();

        for (Data dat2 : data2)
            matrix3[dat2.getX()][dat2.getY()] += dat2.getData();
        //-------
        System.out.println("matrix1 :");
        for (int[] a : matrix1) {
            for (int b : a)
                System.out.print(b);
            System.out.print("\n");
        }
        System.out.println("matrix2 :");
        for (int[] a : matrix2) {
            for (int b : a)
                System.out.print(b);
            System.out.print("\n");
        }
        System.out.println("matrix3 :");
        for (int[] a : matrix3) {
            for (int b : a)
                System.out.print(b);
            System.out.print("\n");
        }
    }


    private static boolean proverka (){
        try {
            i = str.indexOf(" ");
            j = str.lastIndexOf(" ");
            x = Integer.parseInt(str.substring(0, i));
            y = Integer.parseInt(str.substring(i + 1, j));
            data = Integer.parseInt(str.substring(j + 1, str.length()));

        } catch (Exception e) {
            System.out.println(" вы ввели неправильно данные , попробуйте снова. Ошибка : " + e);
            return true;
        }

        if (x >= lengthMatrixX) {
            System.out.println(" индекс х превышает допустимое значение");
            return true;
        }
        if (y >= lengthMatrixY) {
            System.out.println(" индекс y превышает допустимое значение");
            return true;
        }
        return false;
    }

}
