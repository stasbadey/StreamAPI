package by.badey;

import by.badey.model.Animal;
import by.badey.model.Car;
import by.badey.model.Flower;
import by.badey.model.House;
import by.badey.model.Person;
import by.badey.util.Util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;
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
        animals.stream()
                .filter(animal -> animal.getAge() > 10 && animal.getAge() < 20)
                .sorted()
                .skip(21)
                .limit(7)
                .forEach(System.out::println);
    }

    private static void task2() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getOrigin().equals("Japanese"))
                .map(animal -> animal.getGender().equals("Female")
                        ? animal.getBread().toUpperCase()
                        : animal.getBread())
                .forEach(System.out::println);

    }

    private static void task3() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .filter(origin -> origin.startsWith("A"))
                .distinct()
                .forEach(System.out::println);
    }

    private static void task4() throws IOException {
        List<Animal> animals = Util.getAnimals();
        long count = animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();
        System.out.println(count);

    }

    private static void task5() throws IOException {
        List<Animal> animals = Util.getAnimals();
        boolean hungarian = animals.stream()
                .filter(animal -> animal.getAge() > 20 && animal.getAge() < 30)
                .anyMatch(animal -> animal.getOrigin().equals("Hungarian"));
        System.out.println(hungarian);
    }

    private static void task6() throws IOException {
        List<Animal> animals = Util.getAnimals();
        boolean Gender = animals.stream()
                .allMatch(animal -> animal.getGender().equals("Male")
                        && animal.getGender().equals("Female"));
        System.out.println(Gender);
    }

    private static void task7() throws IOException {
        List<Animal> animals = Util.getAnimals();
        boolean oceania = animals.stream()
                .anyMatch(animal -> !(animal.getOrigin().equals("Oceania")));
        System.out.println(oceania);
    }

    private static void task8() throws IOException {
        List<Animal> animals = Util.getAnimals();
        Animal animal = animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .max(Comparator.comparing(Animal::getAge))
                .orElse(null);
        System.out.println(animal.getAge());
    }

    private static void task9() throws IOException {
        List<Animal> animals = Util.getAnimals();
        char[] result = animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .min(Comparator.comparing(chars -> chars.length))
                .orElse(null);
        System.out.println(result.length);
    }

    private static void task10() throws IOException {
        List<Animal> animals = Util.getAnimals();
        int sum = animals.stream()
                .mapToInt(Animal::getAge)
                .sum();
        System.out.println(sum);
    }

    private static void task11() throws IOException {
        List<Animal> animals = Util.getAnimals();
        double average = animals.stream()
                .filter(animal -> animal.getOrigin().equals("Indonesian"))
                .mapToInt(Animal::getAge)
                .average()
                .getAsDouble();
        System.out.println(average);
    }

    private static void task12() throws IOException {
        List<Person> people = Util.getPersons();
        people.stream()
                .filter(person -> person.getGender().equals("Male"))
                .filter(person -> ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()) > 18
                        && ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()) < 27)
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(200)
                .forEach(System.out::println);
    }

    private static void task13() throws IOException {
        List<House> houses = Util.getHouses();
        List<Person> all = new ArrayList<>(
                houses.stream()
                        .flatMap(house -> house.getPersonList().stream())
                        .toList()
        );

        List<Person> hospital = houses.stream()
                .filter(house -> house.getBuildingType().equals("Hospital"))
                .flatMap(house -> house.getPersonList().stream())
                .toList();


        List<Person> age = all.stream()
                .filter(person -> ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()) < 18
                        || ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()) > 58
                        && person.getGender().equals("Female")
                        || ChronoUnit.YEARS.between(person.getDateOfBirth(), LocalDate.now()) > 63
                        && person.getGender().equals("Male"))
                .toList();

        List<Person> evacuation = Stream.of(hospital, age, all)
                .flatMap(Collection::stream)
                .distinct()
                .limit(500)
                .toList();

        evacuation.forEach(System.out::println);
    }

    private static void task14() throws IOException {
        List<Car> cars = Util.getCars();
        //        Продолжить...
    }

    private static void task15() throws IOException {
        List<Flower> flowers = Util.getFlowers();
        //        Продолжить...
    }
}