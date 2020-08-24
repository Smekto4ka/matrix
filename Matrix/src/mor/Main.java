package mor;


import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int x;
        int y;
        int data;


        System.out.println("сторона матрицы X :");
        Scanner scan = new Scanner(System.in);
        int lengthMatrixX = scan.nextInt();
        System.out.println("сторона матрицы Y :");
        int lengthMatrixY = scan.nextInt();

        LinkedList<Data> data1 = new LinkedList<>();
        LinkedList<Data> data2 = new LinkedList<>();


        int[][] matrix1 = new int[lengthMatrixX][lengthMatrixY];
        int[][] matrix2 = new int[lengthMatrixX][lengthMatrixY];
        int[][] matrix3 = new int[lengthMatrixX][lengthMatrixY];
        System.out.println("введите элементы для матрицы 1; вводить :x y data");


        do {
            try {
                System.out.println("введите элементы:");
                x = scan.nextInt();
                y = scan.nextInt();
                data = scan.nextInt();

            } catch (Exception e) {
                System.out.println(" вы ввели неправильно данные , попробуйте снова. Ошибка : " + e);
                continue;
            }

            if (x >= lengthMatrixX) {
                System.out.println(" индекс х превышает допустимое значение");
                continue;
            }
            if (y >= lengthMatrixY) {
                System.out.println(" индекс y превышает допустимое значение");
                continue;
            }
            if (x < 0) {
                break;
            }
            exit1:
            {
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

        } while (true);

        System.out.println("введите элементы для матрицы 2; вводить :x y data");
        do {
            try {
                System.out.println("введите элементы:");
                x = scan.nextInt();
                y = scan.nextInt();
                data = scan.nextInt();

            } catch (Exception e) {
                System.out.println(" вы ввели неправильно данные , попробуйте снова. Ошибка : " + e);
                continue;
            }

            if (x >= lengthMatrixX) {
                System.out.println(" индекс х превышает допустимое значение");
                continue;
            }
            if (y >= lengthMatrixY) {
                System.out.println(" индекс y превышает допустимое значение");
                continue;
            }
            if (x < 0) {
                break;
            }
            exit2:
            {
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

        } while (true);

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


}
