package homework2;

public class MyArraySizeException extends Exception{
    private int arraySize;
    public int getNumber(){return arraySize;}
    public MyArraySizeException(String message, int arraySize){

        super(message);
        this.arraySize = arraySize;
    }
}
