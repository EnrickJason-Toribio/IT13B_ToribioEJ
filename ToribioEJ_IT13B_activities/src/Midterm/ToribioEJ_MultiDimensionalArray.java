package Midterm;

public class ToribioEJ_MultiDimensionalArray {

    public static void main(String[] args) {
    
    int [][]numbers = {
        
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12}
    }; 

    for(int x = 0; x < numbers.length; x++){
        System.out.print("The Element in Row " + (x + 1) + ": ");
        for(int y = 0; y < numbers[x].length; y++){
        System.out.print(numbers[x][y] + " ");
    }
    System.out.println();
}
}
}
