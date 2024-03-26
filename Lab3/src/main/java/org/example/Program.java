package org.example;

import org.example.dao.ManufactureDAO;
import org.example.dao.PhoneDAO;
import org.example.database.HibernateUtils;
import org.example.domain.Phone;
import org.example.domain.Manufacture;
import org.hibernate.Session;

import java.io.InvalidObjectException;

public class Program {
    private static Session session = HibernateUtils.getFactory().openSession();
    public static void main(String[] args) {
        var manufactureDAO = new ManufactureDAO(session);
        var phoneDAO = new PhoneDAO(session);

        // Create a manufacture
        var apple = new Manufacture();
        apple.setName("Apple");
        apple.setLocation("US");
        apple.setEmployee(2000);
        manufactureDAO.add(apple);

        var samsung = new Manufacture();
        samsung.setName("Samsung");
        samsung.setLocation("Korea");
        samsung.setEmployee(1500);
        manufactureDAO.add(samsung);

        // Create some phones
        var phone1 = new Phone();
        phone1.setName("iPhone 13 Pro");
        phone1.setPrice(15000000);
        phone1.setColor("Silver");
        phone1.setCountry("USA");
        phone1.setQuantity(10);
        phone1.setManufacture(apple);
        phoneDAO.add(phone1);

        var phone2 = new Phone();
        phone2.setName("iPhone 13 Mini");
        phone2.setPrice(10000000);
        phone2.setColor("Blue");
        phone2.setCountry("USA");
        phone2.setQuantity(5);
        phone2.setManufacture(apple);
        phoneDAO.add(phone2);

        var phone3 = new Phone();
        phone3.setName("Galaxy S21");
        phone3.setPrice(12000000);
        phone3.setColor("Black");
        phone3.setCountry("Korea");
        phone3.setQuantity(8);
        phone3.setManufacture(samsung);
        phoneDAO.add(phone3);


        // PhoneDAO
        // Test the getAll method
        var phones = phoneDAO.getAll();
        System.out.println("All phones:");
        phones.forEach(System.out::println);

        // Test the get method
        var phone = phoneDAO.get(phone1.getId());
        System.out.println("\nPhone with ID " + phone1.getId() + ": " + phone);

        // Test the update method
        phone1.setPrice(17000000);
        phoneDAO.update(phone1);
        phone = phoneDAO.get(phone1.getId());
        System.out.println("\nUpdated phone with ID " + phone1.getId() + ": " + phone);

        // Test the remove method
        phoneDAO.remove(phone3);
        System.out.println("\nAll phones after removing one:");
        phones = phoneDAO.getAll();
        phones.forEach(System.out::println);

        // Test the removeByID method
        phoneDAO.removeById(3);
        System.out.println("\nAll phones after removing one:");
        phones = phoneDAO.getAll();
        phones.forEach(System.out::println);

        // Test the getPhoneWithHighestSellingPrice method
        var phoneWithHighestPrice = phoneDAO.getPhoneWithHighestSellingPrice();
        System.out.println("\nPhone with highest selling price: " + phoneWithHighestPrice);

        // Test the getPhonesSortedByCountryName method
        var phonesSortedByCountry = phoneDAO.getPhonesSortedByCountryName();
        System.out.println("\nPhones sorted by country:");
        phonesSortedByCountry.forEach(System.out::println);

        // Test the hasPhonePricedAbove50Million method
        var hasPhonePricedAbove50Million = phoneDAO.hasPhonePricedAbove50Million();
        System.out.println("\nHas phone priced above 50 million: " + hasPhonePricedAbove50Million);

        // Test the getFirstPinkPhoneOver15Million method
        var firstPinkPhoneOver15Million = phoneDAO.getFirstPinkPhoneOver15Million();
        System.out.println("\nFirst pink phone over 15 million: " + firstPinkPhoneOver15Million);

        System.out.println("--------------------------------------------");

        // ManufactureDAO
        // Test the getAll method
        var manufactures = manufactureDAO.getAll();
        System.out.println("All manufactures:");
        manufactures.forEach(System.out::println);

        // Test the get method
        var manufacture = manufactureDAO.get(apple.getId());
        System.out.println("\nManufacture with ID " + apple.getId() + ": " + manufacture);

        // Test the update method
        apple.setEmployee(2500);
        manufactureDAO.update(apple);
        manufacture = manufactureDAO.get(apple.getId());
        System.out.println("\nUpdated manufacture with ID " + apple.getId() + ": " + manufacture);

        // Test the remove method
        manufactureDAO.remove(samsung);
        System.out.println("\nAll manufactures after removing one:");
        manufactures = manufactureDAO.getAll();
        manufactures.forEach(System.out::println);

        // Test the removeById method
        manufactureDAO.removeById(3);
        System.out.println("\nAll manufactures after removing one:");
        manufactures = manufactureDAO.getAll();
        manufactures.forEach(System.out::println);

        // Test the allManufacturersHaveMoreThan100Employees method
        var allManufacturersHaveMoreThan100Employees = manufactureDAO.allManufacturersHaveMoreThan100Employees();
        System.out.println("\nAll manufacturers have more than 100 employees: " + allManufacturersHaveMoreThan100Employees);

        // Test the sumOfEmployees method
        var sumOfEmployees = manufactureDAO.sumOfEmployees();
        System.out.println("\nSum of employees: " + sumOfEmployees);

        // Test the getLastManufactureInUS method
        Manufacture lastManufactureInUS = null;
        try {
            lastManufactureInUS = manufactureDAO.getLastManufactureInUS();
        } catch (InvalidObjectException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nLast manufacture in USA: " + lastManufactureInUS);
    }
}