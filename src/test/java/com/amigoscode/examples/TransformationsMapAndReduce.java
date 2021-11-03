package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.CarDTO;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
        //map transform de origin object to the other type or object

        // il est tout a fait possible de definir une fonction
        //qui renvoie un objet de type PersonDTO
        //la methode map passe en parametre un objet personn et renvoi bien un objet PersonDTO
        Function<Person,PersonDTO> personDTOFunction = PersonDTO::map;
        //on peut aussi ecrire cela
        Function<Person,PersonDTO> personDTOFunction2= person-> new PersonDTO(person.getId(),person.getFirstName(),person.getAge());

        //on passe ensuite la function a l'objet intermediaire map qui attend une fonction< ?,?>
        List<PersonDTO> personDTOS = people.stream()
                .map(personDTOFunction2)
                .collect(Collectors.toList());

       personDTOS.forEach(System.out::println);

    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();


        //ici j'ai crée un objet de type CarDTO
        //je crée une function qui transforme mon objet Car en ObjetCarDTO

        Function<Car,CarDTO> carCarDTOFunction = car-> new CarDTO(car.getId(),car.getPrice());
        //ensuite je map cette collection dans une liste de type List<CarDTO> ou je ne recupere que les id et price
        List<CarDTO> carsPrice = cars.stream().map(carCarDTOFunction).collect(Collectors.toList());

        //j'affiche la liste
        carsPrice.forEach(System.out::println);

        System.out.println("---------------------------------------------------------");
        //ainsi je map tout les objet de typeDouble , je fais la moyenne si il y a en un je prends sinon 0
        //et j'affiche le resultat de la moyenne.
        double avg = carsPrice.stream()
                .mapToDouble(c->c.getPrice())
                .average()
                .orElse(0);
        System.out.println(avg);



    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
        int result = Arrays.stream(integers).reduce(0,(subtotal,element)-> subtotal+element);
        System.out.println(result);
        assertThat(result).isLessThan(2000);
    }
}

