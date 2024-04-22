package ru.sgu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Company implements Comparable<Company> {
    private String surname;
    private String name;
    private String patronymic;
    private String companyName;
    private int rating;

    public Company(String surname, String name, String patronymic, String company, int rating) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.companyName = company;
        this.rating = rating;
    }

    @Override
    public int compareTo(Company other) {
        if (this.rating != other.rating) {
            return Integer.compare(other.rating, this.rating);
        }
        if (!this.surname.equals(other.surname)) {
            return this.surname.compareTo(other.surname);
        }
        if (!this.name.equals(other.name)) {
            return other.name.compareTo(this.name);
        }
        return this.patronymic.compareTo(other.patronymic);
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic + " " + companyName + " " + rating;
    }
}

public class Subtask1 {
    public static void run () {
        List<Company> companies = new ArrayList<>();
        Set<String> uniqueCompanies = new HashSet<>();

        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(" ");
                int lineLen = parts.length;
                String surname = parts[0];
                String name = (lineLen>3) ? parts[1] : "";
                String patronymic = (lineLen>4) ? parts[2] : "";
                String companyName = parts[lineLen-2];
                int rating = Integer.parseInt(parts[lineLen-1]);
                if (!uniqueCompanies.contains(companyName)) {
                    companies.add(new Company(surname, name, patronymic, companyName, rating));
                    uniqueCompanies.add(companyName);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Collections.sort(companies);
        for (Company company : companies) {
            System.out.println(company);
        }
    }
}
