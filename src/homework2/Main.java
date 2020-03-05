package homework2;

import java.util.Random;

public class Main {
   final static int ARRAY_SIZE = 4;
    public static void main(String[] args) {
        String[][] strings = intiArray(ARRAY_SIZE);
        // Генерация ошибки
        // strings = generateError(strings);
        try {
            System.out.println("Sum: " + checkArray(strings));
        }catch (MyArraySizeException ex){
            System.out.print(ex.getMessage() + " " + ex.getNumber() + " x " + ex.getNumber());
        }catch (MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }

    }

    static String[][] intiArray(int arraySize) {
        String[][] resultArray = new String[arraySize][arraySize];
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                resultArray[i][j] = Integer.toString(getRandom(10,30));
            }
        }
        return resultArray;
    }

    static int checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int result = 0;

        if (array.length > 4 && array.length < 0) {
            throw new MyArraySizeException("Максимальный размер матрицы 4 x 4. Текущий размер ", array.length);
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");

                try {
                    result +=  Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex)
                {
                    System.out.println();
                    throw new MyArrayDataException("Ошибка в строке " + i + " столбце " + j);
                }

            }
            System.out.println();
        }
        return result;
    }

    static int getRandom(int min, int max) {
        Random random = new Random();
        int result = random.nextInt(max - min + 1) + min;
        return result;
    }

    static String[][] generateError(String[][] array) {
        int pos =  getRandom(1,16) - 1;
        int rowNum = pos / ARRAY_SIZE;
        int colNum = pos % ARRAY_SIZE;
        // Генерируем ошибку
        array[rowNum][colNum] = "!";
        return array;
    }
}
