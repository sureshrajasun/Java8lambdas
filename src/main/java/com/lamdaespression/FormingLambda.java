package com.lamdaespression;

/*
---------------------------------------------------------------------------------------------------------------------
    aBlockOfCode = public void perform(){
        System.out.print("Hello World");
    }
--------------------------------------------------------------------------------------------------------------------
    Since function is assigned to variable 'aBlockOfCode' and the function is kept as isolation level, also the
    whoever has the access to the variable can have the access to the Function. So We can remove 'Public'

    aBlockOfCode = void perform(){
        System.out.print("Hello World);
    }
---------------------------------------------------------------------------------------------------------------------
    if you assign a value to a variable you can just use tha variable name to access/call it when required, here the
    `aBlockOfCode` just required to call the method perform(), so we can just use `aBlockOfCode` to call method.

    aBlockOfCode = void (){
        System.out.print("Hello World");
    }
----------------------------------------------------------------------------------------------------------------------
    Instead of looking at Return type, you can just simply see the method body to figure out the return type.
    So since java 8, the compiler smart enough to find out what is the return type. So we can eliminate the return type.

    aBlockOfCode = () {
        System.out.print("Hello World");
    }
----------------------------------------------------------------------------------------------------------------------
    So form the above derived code, we just need to tell to compiler its a Lambda by simply specifying '->'

    aBlockOfCode = () -> {
        System.out.print("Hello World");
    }
-----------------------------------------------------------------------------------------------------------------------
    if your method body contains only single line, you can eliminate the curly braces as well, remember it is valid only
    single line of code. if the method body contains multiple line of codes then we need the curly braces.

    aBlockOfCode = () -> System.out.print("Hello World");


    SIMILARLY the below function

            public double doubleNumberFunction(double a) {
                return a * 2;
            }

    Can be rewrite as

            doubleNumberFunction  = (double a) -> a*2;

    we can avoid the return as well in the method body, also its invalid to specify the return keyword in lambda function

    Some More example

                addFunction = (int a, int b) -> a + b;

                safeDivide = (int a, int b) -> {
                    if( b == 0) return 0;
                    return a/b;
                };

                stringLength = (String str) -> str.length();

------------------------------------------------------------------------------------------------------------------------
 */

public class FormingLambda {

    public void doPrint(MyLamda myLamda){
        myLamda.print();
    }

    public static void main(String[] args) {

        FormingLambda lesson1 = new FormingLambda();
        MyLamda myLambda = () -> System.out.println("Hello Lambda 123");
        AddNum addNum = (int a, int b) -> a + b;
        myLambda.print();
        System.out.println(addNum.addNum(20,20));

        MyLamda newMyLambda = () -> System.out.println("Calling Second time");

        lesson1.doPrint(newMyLambda);

        lesson1.doPrint(() -> System.out.println("Lambda as inline example."));


    }
}

interface MyLamda {  void print(); }  // the Lambda method has to be assigned to an interface
// The method name can be anything and there should be only one method in interface
// Ssee the above implementation

interface  AddNum { int addNum (int a, int b); }






