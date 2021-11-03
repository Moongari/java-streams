package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingWithStreams {

    @Test
    void steams(){
    List<String> names = List.of("Amigoscode", "Alex", "Zara");

    //il est possible de definir plusieurs manieres pour creer un stream 1 ou 2
    names.stream();//1
    Stream<String> stringStream= Stream.of("toto","robert","alex"); //2



    }
}
