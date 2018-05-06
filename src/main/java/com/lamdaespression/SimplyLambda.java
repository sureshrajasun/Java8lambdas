package com.lamdaespression;

public class SimplyLambda {

    public int doAdd(NumAdder myLamda){
        return myLamda.addNum(20, 30);
    }

    public int getStrLength(LengthFinder len){
        return len.findLength("Welcome!");
    }



    public static void main(String[] args) {

        SimplyLambda lesson2 = new SimplyLambda();

        NumAdder addNum = (int a, int b) -> a + b;

        System.out.println(lesson2.doAdd(addNum));

        NumAdder numAdder = (a, b) -> a * 2 + b * 2 ;  // no need to mention the type  in the params, as the interface knows already

        System.out.println(lesson2.doAdd( numAdder));

        LengthFinder lengthFinder = s -> s.length(); // in case of single argument we can avoid the bracket as well.
        System.out.println(lesson2.getStrLength(lengthFinder));

        System.out.println(lesson2.getStrLength(s -> s.length() * 2));

    }
}

interface NumAdder { int addNum (int a, int b); }

interface LengthFinder { int findLength(String s); }