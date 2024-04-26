package org.example;

import java.util.Scanner;

public abstract class Prison {
    private String name;
    private int capacity;
    private int age;
    private String crime;
    private int prisonerCount;
    protected static Scanner scanner = new Scanner(System.in);
    private String[] prisoners;
    public String crimeSeverity;


    public Prison(String name, int capacity, int age, String crime, String crimeSeverity) {
        this.name = name;
        this.capacity = capacity;
        this.age = age;
        this.crime = crime;
        this.crimeSeverity = crimeSeverity;
        this.prisonerCount = 0;
        this.prisoners = new String[capacity];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    void viewCriminalRecord() {
        System.out.println("Кого заключенного хотите посмотреть?");
        displayPrisoners();
        System.out.print("Введите номер заключенного: ");
        int target = scanner.nextInt();

        if (target >= 0 && target < prisonerCount && prisoners[target] != null) {
            String[] record = prisoners[target].split(" \\(");
            String name = record[0];
            System.out.println("Имя: " + name);
            System.out.println("Степень тяжести преступления: " + crimeSeverity);
        } else {
            System.out.println("Такого заключенного нет.");
        }
    }




    public void workInPrison() {
        System.out.println("Вы работаете в тюрьме.");
    }

    public void assaultPrisoner() {
        System.out.println("Кого Вы хотите избить?");
        displayPrisoners();
        System.out.print("Введите номер заключенного: ");
        int target = scanner.nextInt();

        if (target >= 0 && target < prisonerCount && prisoners[target] != null) {
            System.out.println("Вы избили до полусмерти " + prisoners[target] + ". Он отправлен в карцер.");
        } else {
            System.out.println("Такого заключенного нет.");
        }
    }

    public void visitLibrary() {
        System.out.println("Вы отправились в библиотеку для занятий.");
    }

    public void admitPrisoner() {
        if (prisonerCount < capacity) {
            System.out.print("Введите имя нового заключенного: ");
            String name = scanner.next();
            scanner.nextLine();
            System.out.print("За что сел в тюрьму " + name + ": ");
            String crime = scanner.nextLine();
            prisoners[prisonerCount++] = name + " (" + crime + ")";
            System.out.println(name + " был заключен в тюрьму под номером " + prisonerCount);
        } else {
            System.out.println("Тюрьма заполнена. Невозможно заключить нового заключенного.");
        }
    }
    public void displayPrisoners() {
        System.out.println("Список заключенных:");
        for (int i = 0; i < prisonerCount; i++) {
            System.out.println((i + 1) + ". " + prisoners[i]);
            System.out.println("--------------------------------");
        }
    }

    public void inviteTattooArtist() {
        System.out.print("Введите имя тату мастера: ");
        String artistName = scanner.next();
        System.out.print("За что сидит в тюрьме тату мастер " + artistName + ": ");
        String artistCrime = scanner.next();
        System.out.println("Тату мастер " + artistName + " сидящий за: " + artistCrime + " принят на работу в тюрьму.");
    }

    public void conductParoleHearing() {
        System.out.println("Проводится слушание по условно-досрочному освобождению.");
    }

    public void drugSearch() {
        System.out.println("Проводится обыск в поисках наркотиков.");
    }

    public void organizePrisonRiot() {
        System.out.println("Организуется восстание в тюрьме.");
    }

    public abstract void printMenu();
}

