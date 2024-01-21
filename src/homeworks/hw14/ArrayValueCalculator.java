package homeworks.hw14;

import homeworks.hw14.exceptions.ArrayDataException;
import homeworks.hw14.exceptions.ArraySizeException;

public class ArrayValueCalculator{
    public int doCalc(String[][] array) throws ArraySizeException, ArrayDataException{
        if(array.length != 4 || array[0].length != 4) throw new ArraySizeException("Wrong size of array");

        int result = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(isNumeric(array[i][j])){
                    result += Integer.parseInt(array[i][j]);
                }else{
                    throw new ArrayDataException("Wrong type of data: array[%d][%d] - %s".formatted(i, j, array[i][j]));
                }
            }
        }

        return result;
    }

    public boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
