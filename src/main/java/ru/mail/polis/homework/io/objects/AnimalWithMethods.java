package ru.mail.polis.homework.io.objects;


import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Дубль класса Animal, для Serializer.serializeWithMethods
 * 3 балла
 */
public class AnimalWithMethods implements Serializable {
    private Animal.AnimalClassification animalClassification;
    private String name;
    private int age;
    private int weight;
    private boolean isPredator;
    private Owner owner;
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

    public AnimalWithMethods() {

    }

    private void writeObject(ObjectOutput out) throws IOException {
        out.writeObject(animalClassification);
        out.writeUTF(name);
        out.writeInt(age);
        out.writeInt(weight);
        out.writeBoolean(isPredator);
        out.writeObject(owner);
        out.writeObject(areas);
    }

    private void readObject(ObjectInput in) throws IOException, ClassNotFoundException {
        animalClassification = (Animal.AnimalClassification) in.readObject();
        name = in.readUTF();
        age = in.readInt();
        weight = in.readInt();
        isPredator = in.readBoolean();
        owner = (Owner) in.readObject();
        areas = (List<String>) in.readObject();
    }

    public AnimalWithMethods(Animal.AnimalClassification animalClassification, String name, int age, int weight,
                                boolean isPredator, Owner owner, List<String> areas) {
        this.animalClassification = animalClassification;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.isPredator = isPredator;
        this.owner = owner;
        this.areas = areas;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        AnimalWithMethods animal = (AnimalWithMethods) obj;
        return animalClassification == animal.animalClassification &&
                name.equals(animal.name) &&
                age == animal.age &&
                weight == animal.weight &&
                isPredator == animal.isPredator &&
                owner.equals(animal.owner) &&
                Objects.equals(areas, animal.areas);
    }

    @Override
    public String toString() {
        return "AnimalWithMethods{" +
                "animalClassification = " + animalClassification +
                ", name = "  + name +
                ", age = " + age +
                ", weight = " + weight +
                ", isPredator = " + isPredator +
                ", owner = " + owner +
                ", areas = " + areas +
                '}';
    }

    public int hashCode() {
        return Objects.hash(animalClassification, name, age, weight, isPredator, owner, areas);
    }
}
