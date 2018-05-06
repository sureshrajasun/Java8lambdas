package com.lamda.workaround;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

interface  Condition {
     boolean test(Person person);
}
public class PersonService {

    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(new Person("Sam", "Peter", 100),
                new Person("Dev", "Kumar", 200),
                new Person("Giri", "Dharan", 100),
                new Person("Name", "Name", 100),
                new Person("Venkat", "Krishnan", 100),
                new Person("Deepak", "Souder", 100));

        printAll(personList);


        Collections.sort(personList, Collections.reverseOrder(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        }));
        System.out.println("########## After Sorting ##########");

        printAll(personList);


        System.out.println("########## After Using Lamdas ##########");

        Collections.sort(personList, (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));

        //Collections.sort(personList, Comparator.comparing(Person :: getFirstName));

        printAll(personList);

        System.out.println("########## After Using Condition ##########");
        Condition condition = (p) -> p.getFirstName().startsWith("D");
        getConditionalList(personList, condition);

    }

     static  void printAll(List<Person> personList){
        for (Person p : personList){
            System.out.println(String.format("FirstName : %s, LastName : %s, ID Number : %d",p.getFirstName(), p.getLastName(), p.getIdNumber()));
        }
    }

    static void getConditionalList (List<Person> personList, Condition condition){
         printAll(personList.stream().filter(p -> condition.test(p)).collect(Collectors.toList()));

    }


}
