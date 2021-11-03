package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Filtering {

    @Test
    public void filter() throws Exception {
        List<Car> cars = MockData.getCars();

        Predicate<Car> carPredicate= c-> c.getPrice()<20_000.00;
        Predicate<Car> CarColor = colorCar->colorCar.getColor().equals("Yellow");
        Predicate<Car> yearCar = car-> car.getYear()<2013;


        List<Car> carsLessThan20K = cars.stream().filter(carPredicate)
                .filter(yearCar)
                .filter(CarColor)
                .collect(Collectors.toList());

        carsLessThan20K.forEach(System.out::println);

    }

    @Test
    public void dropWhile() throws Exception {
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("using dropWhile");

        Stream<Integer> stream = Stream.of(2, 4, 6, 8, 9, 10, 12);
        List<Integer> list= stream.dropWhile(n->n%2 ==0).collect(Collectors.toList());
        System.out.println(list);


    }

    @Test
    public void takeWhile() throws Exception {
        // using filter
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
        System.out.println("using take while");
        Stream<Integer> stream = Stream.of(2, 4, 6, 8, 9, 10, 12);
        List<Integer> list= stream.takeWhile(n->n%2 ==0).collect(Collectors.toList());
        System.out.println(list);

    }

    @Test
    public void findFirst() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        OptionalInt response = Arrays.stream(numbers).findFirst();

        if(response.isPresent()){
            System.out.println(response.getAsInt());
        }else{
            System.out.println("no value");
        }

    }

    @Test
    public void findAny() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
        OptionalInt response = Arrays.stream(numbers).findAny();

        if(response.isPresent()){
            System.out.println(response.getAsInt());
        }else{
            System.out.println("no value");
        }
    }

    @Test
    public void allMatch() throws Exception {
        int[] even = {2, 4, 6, 8, 10};

        boolean response = Arrays.stream(even).allMatch(n->n %2 ==0);

        System.out.println(response);
    }

    @Test
    public void anyMatch() throws Exception {
        int[] evenAndOneOdd = {3, 5, 7, 9, 13, 11};

        boolean response = Arrays.stream(evenAndOneOdd).anyMatch(n->n%2==0);

        System.out.println(response);
        assertThat(response).isFalse();

    }

}



