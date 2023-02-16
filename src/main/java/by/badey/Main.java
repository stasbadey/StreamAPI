package by.badey;

import by.badey.model.Animal;
import by.badey.model.Car;
import by.badey.model.Flower;
import by.badey.model.House;
import by.badey.model.Person;
import by.badey.util.Util;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
    }

    private static void task1() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task2() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...

    }

    private static void task3() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task4() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...

    }

    private static void task5() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task6() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task7() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task8() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task9() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task10() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task11() throws IOException {
        List<Animal> animals = Util.getAnimals();
        //        animals.stream() Продолжить ...
    }

    private static void task12() throws IOException {
        List<Person> people = Util.getPersons();
//        Продолжить...
    }

    private static void task13() throws IOException {
        List<House> houses = Util.getHouses();
        //        Продолжить...
    }

    public static double transportCosts(List<Car> country) {
        return country.stream()
                .mapToDouble(Car::getMass)
                .reduce(Double::sum)
                .getAsDouble() / 1000 * 7.14;
    }

    private static void task14() throws IOException {
        List<Car> cars = Util.getCars();


        List<Car> turkmenCars = cars.stream()
                .filter(car -> car.getCarMake().equals("Jaguar")
                        || car.getColor().equals("White"))
                .toList();
        cars.removeAll(turkmenCars);

        List<Car> uzbCars = cars.stream()
                .filter(car -> car.getMass() < 1500
                        || car.getCarMake().equals("BMW")
                        || car.getCarMake().equals("Lexus")
                        || car.getCarMake().equals("Chrysler")
                        || car.getCarMake().equals("Toyota"))
                .toList();
        cars.removeAll(uzbCars);

        List<Car> kazCars = cars.stream()
                .filter(car -> car.getColor().equals("Black")
                        || car.getMass() > 4000
                        || car.getCarMake().equals("GMC")
                        || car.getCarMake().equals("Dodge"))
                .toList();
        cars.removeAll(kazCars);

        List<Car> kyrCars = cars.stream()
                .filter(car -> car.getReleaseYear() < 1982
                        || car.getCarMake().equals("Civic")
                        || car.getCarMake().equals("Cherokee"))
                .toList();
        cars.removeAll(kyrCars);

        List<Car> rusCars = cars.stream()
                .filter(car -> !car.getColor().equals("Yellow")
                        || car.getColor().equals("Red")
                        || car.getColor().equals("Green")
                        || car.getColor().equals("Blue")
                        || car.getPrice() > 40000
                )
                .toList();
        cars.removeAll(rusCars);

        List<Car> mongolCars = cars.stream()
                .filter(car -> car.getVin().contains("59"))
                .toList();
        cars.removeAll(mongolCars);

        double sumTurkmenCars = transportCosts(turkmenCars);
        System.out.println("Transport costs in Turkmenistan = " + sumTurkmenCars);

        double sumUzbCars = transportCosts(uzbCars);
        System.out.println("Transport costs in Uzbekistan = " + sumUzbCars);

        double sumKazCars = transportCosts(kazCars);
        System.out.println("Transport costs in Kazahstan= " + sumKazCars);

        double sumKyrCars = transportCosts(kyrCars);
        System.out.println("Transport costs in Kyrgistan = " + sumKyrCars);

        double sumRusCars = transportCosts(rusCars);
        System.out.println("Transport costs in Russia = " + sumRusCars);

        double sumMongolCars = transportCosts(mongolCars);
        System.out.println("Transport costs in Mongolia = " + sumMongolCars);

        int revenue = Stream.of(turkmenCars, uzbCars, kazCars, kyrCars, rusCars, mongolCars)
                .flatMap(Collection::stream)
                .mapToInt(Car::getPrice)
                .sum();
        System.out.println("Total revenue = " + revenue);
    }

    private static void task15() throws IOException {
        List<Flower> flowers = Util.getFlowers();
        //        Продолжить...
    }
}