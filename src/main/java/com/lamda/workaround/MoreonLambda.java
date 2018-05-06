package com.lamda.workaround;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MoreonLambda{
        public static void main(String[] args) {

            List<Person> personList = Arrays.asList(new Person("Sam", "Peter", 100),
                    new Person("Dev", "Kumar", 200),
                    new Person("Giri", "Dharan", 100),
                    new Person("Name", "Name", 100),
                    new Person("Venkat", "Krishnan", 100),
                    new Person("Deepak", "Souder", 100));


            System.out.println("########## After Using Lamdas ##########");

            Collections.sort(personList, Comparator.comparing(Person::getFirstName));
            printConditionalList(personList, (p) -> true,
                    p -> System.out.println(String.format
                            ("FirstName : %s, LastName : %s, ID Number : %d",
                                    p.getFirstName(), p.getLastName(), p.getIdNumber())));

            System.out.println("########## After Using Condition ##########");

            printConditionalList(personList, (p) -> p.getFirstName().startsWith("D"), p -> System.out.println(String.format
                    ("FirstName : %s",     p.getFirstName()))); // Print only Firstname
        }

    static void printConditionalList (List<Person> personList, Predicate<Person> predicate, Consumer<Person> consumer){

        for (Person p : personList){
            if(predicate.test(p)){
                consumer.accept(p);
            }
        }

    }


}
