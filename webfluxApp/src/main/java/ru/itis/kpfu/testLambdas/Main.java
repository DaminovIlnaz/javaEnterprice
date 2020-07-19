package ru.itis.kpfu.testLambdas;

public class Main {
    public static void main(String[] args) {
        /*Operationable1*/
        Operationable1 operation1 = (int x, int y)-> x + y;
        Operationable1 operation2 = (int x, int y)-> x - y;
        Operationable1 operation3 = (int x, int y)-> x * y;

        System.out.println(operation1.calculate(20, 10)); //30
        System.out.println(operation2.calculate(20, 10)); //10
        System.out.println(operation3.calculate(20, 10)); //200
        /*Operationable1*/

        /*Operationable2*/
        Operationable2 operation4 = (x,y,z) -> {
            if(x>y){
                if(x>z){
                    return x;
                }else{
                    return z;
                }
            }else{
                if(y>z){
                    return y;
                }
            }
            return z;
        };
        System.out.println(operation4.calculate(10,20,30));
        /*Operationable2*/
    }
}

interface Operationable1{
    int calculate(int x, int y);
}

interface Operationable2{
    int calculate(int x, int y, int z);
}