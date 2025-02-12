public class Lab_act1_Arithmetics {
    public static void main(String[] args){
        
        int first_number = 10;
        int second_number = 4;
        int third_number = 6;
        int x = 3;
        
        System.out.println(first_number + " * " + second_number + " + " + third_number + " = " + (first_number * second_number + third_number));
        System.out.println((first_number + " - " + second_number) + " % " + third_number + " = " + ((first_number - second_number) % third_number));
        System.out.println((first_number + " + " + second_number + " + " + third_number) + " / " + x + " = " + ((first_number + second_number + third_number)/ x));
        System.out.println(first_number + " * " + third_number + " - " + (second_number + " * " + second_number) +  " = " + (first_number * third_number + (second_number * second_number)));
    }
}
