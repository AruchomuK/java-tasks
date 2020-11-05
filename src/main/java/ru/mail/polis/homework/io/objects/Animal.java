package ru.mail.polis.homework.io.objects;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс должен содержать несколько полей с примитивами, строками, энамами и некоторыми сапомисными объектами.
 * Хотя бы один из них должен быть в списке! Например список размеров или список имен.
 * Всего должно быть минимум 6 полей с разными типами.
 * 1 балл
 */
public class Animal implements Serializable {
    private AnimalClassification animalClassification;
    private String name;
    private int age;
    private int weight;
    private boolean isPredator;
    private List<String> areas = new ArrayList<>();

    public enum AnimalClassification {
        CRUSTACEANS,
        ARACHNIDS,
        INSECTS,
        MAMMALS,
        BIRDS,
        REPTILES,
        AMPHIBIANS,
        FISH
    }

    public Animal(AnimalClassification animalClassification, String name, int age, int weight,
                  boolean isPredator, List<String> areas) {
        this.animalClassification = animalClassification;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.isPredator = isPredator;
        this.areas = areas;
    }

    public AnimalClassification getAnimalClassification() {
        return animalClassification;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public List<String> getAreas() {
        return areas;
    }

    public boolean isPredator() {
        return isPredator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Animal animal = (Animal) obj;
        return animalClassification == animal.animalClassification &&
                name.equals(animal.name) &&
                age == animal.age &&
                weight == animal.weight &&
                isPredator == animal.isPredator &&
                Objects.equals(areas, animal.areas);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalClassification = " + animalClassification +
                ", name = "  + name +
                ", age = " + age +
                ", weight = " + weight +
                ", isPredator = " + isPredator +
                ", areas = " + areas +
                '}';
    }
}
