package mor;


import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int i;
        int j;
        int x;
        int y;
        int data;
        String str;
        boolean onePassage = true;

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
        str = scan.nextLine();// из-за \n после extInt()

        do {
            exit1:
            {
                if (onePassage) break exit1;

                try {
                    i = str.indexOf(" ");
                    j = str.lastIndexOf(" ");
                    x = Integer.parseInt(str.substring(0, i));
                    y = Integer.parseInt(str.substring(i + 1, j));
                    data = Integer.parseInt(str.substring(j + 1, str.length()));

                } catch (Exception e) {
                    System.out.println(" вы ввели неправильно данные , попробуйте снова. Ошибка : " + e);
                    break exit1;
                }

                if (x >= lengthMatrixX) {
                    System.out.println(" индекс х превышает допустимое значение");
                    break exit1;
                }
                if (y >= lengthMatrixY) {
                    System.out.println(" индекс y превышает допустимое значение");
                    break exit1;
                }
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

                try {
                    i = str.indexOf(" ");
                    j = str.lastIndexOf(" ");
                    x = Integer.parseInt(str.substring(0, i));
                    y = Integer.parseInt(str.substring(i + 1, j));
                    data = Integer.parseInt(str.substring(j + 1, str.length()));

                } catch (Exception e) {
                    System.out.println(" вы ввели неправильно данные , попробуйте снова. Ошибка : " + e);
                    break exit2;
                }

                if (x >= lengthMatrixX) {
                    System.out.println(" индекс х превышает допустимое значение");
                    break exit2;
                }
                if (y >= lengthMatrixY) {
                    System.out.println(" индекс y превышает допустимое значение");
                    break exit2;
                }
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


}

/*
1(1)0  1(3)
0   0  0
0   1(2)0

1(3)0   0
1(1)0   1(2)
0   0   0

2 0 1
1 0 1
0 0 0 ???
 */
// 1й способ----
/*int i = 0;
    int j = 0;
        do {       //for (int k = 0; k < kolData1 + kolData2; k++) {
                if ((i < kolData1) && (j < kolData2) && (data1[i].getX() == data2[j].getX())) {
        if (data1[i].getY() < data2[j].getY()) {
        matrix3[data1[i].getX()][data1[i].getY()] = data1[i].getData() + matrix2[data1[i].getX()][data1[i].getY()];
        i++;
        } else {
        if ((data1[i].getY() == data2[j].getY())) {
        matrix3[data1[i].getX()][data1[i].getY()] = data1[i].getData() + data2[j].getData();
        i++;
        j++;
        } else {
        if (data1[i].getY() > data2[j].getY()) {
        matrix3[data2[j].getX()][data2[j].getY()] = matrix1[data2[j].getX()][data2[j].getY()] + data2[j].getData();
        j++;
        }
        }
        }
        }
        if ((i < kolData1) && (j < kolData2) && (data1[i].getX() < data2[j].getX())) {
        matrix3[data1[i].getX()][data1[i].getY()] = data1[i].getData() + matrix2[data1[i].getX()][data1[i].getY()];
        i++;
        }

        if ((i < kolData1) && (j < kolData2) && (data1[i].getX() > data2[j].getX())) {
        matrix3[data2[j].getX()][data2[j].getY()] = matrix1[data2[j].getX()][data2[j].getY()] + data2[j].getData();
        j++;
        }
        if ((i < kolData1) && (j >= kolData2)) {
        matrix3[data1[i].getX()][data1[i].getY()] = data1[i].getData() + matrix2[data1[i].getX()][data1[i].getY()];
        i++;
        }
        if ((i >= kolData1) && (j < kolData2)) {
        matrix3[data2[j].getX()][data2[j].getY()] = matrix1[data2[j].getX()][data2[j].getY()] + data2[j].getData();
        j++;
        }
        } while ((i < kolData1) || (j < kolData2)); */