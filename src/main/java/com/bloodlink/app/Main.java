package com.bloodlink.app;

import com.bloodlink.dao.BloodBankDAO;
import com.bloodlink.dao.DonorDAO;
import com.bloodlink.dao.RequestDAO;
import com.bloodlink.dao.StockDAO;
import com.bloodlink.model.Donor;
import com.bloodlink.service.MatchingService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DonorDAO donorDAO = new DonorDAO();
        BloodBankDAO bloodBankDAO = new BloodBankDAO();
        StockDAO stockDAO = new StockDAO();
        RequestDAO requestDAO = new RequestDAO();

        while (true) {
            System.out.println("\n===== BloodLink: Blood Bank Emergency System =====");
            System.out.println("1) Register Donor");
            System.out.println("2) Add Blood Bank");
            System.out.println("3) Add/Update Blood Stock");
            System.out.println("4) Create Blood Request");
            System.out.println("5) Find Best Donors (Ranked)");
            System.out.println("6) View Blood Stock (by City + Group)");
            System.out.println("0) Exit");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 0) {
                System.out.println("Exiting... Thank you!");
                break;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Donor Name: ");
                    String name = sc.nextLine();

                    System.out.print("Blood Group (e.g. O+): ");
                    String bg = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("City: ");
                    String city = sc.nextLine();

                    System.out.print("Area: ");
                    String area = sc.nextLine();

                    System.out.print("Last Donation Date (YYYY-MM-DD) or leave empty: ");
                    String date = sc.nextLine();

                    System.out.print("Available? (true/false): ");
                    boolean available = Boolean.parseBoolean(sc.nextLine());

                    boolean ok = donorDAO.addDonor(name, bg, phone, city, area, date, available);
                    System.out.println(ok ? "Donor Registered Successfully!" : "Failed to register donor.");
                }

                case 2 -> {
                    System.out.print("Blood Bank Name: ");
                    String bankName = sc.nextLine();

                    System.out.print("City: ");
                    String city = sc.nextLine();

                    System.out.print("Contact: ");
                    String contact = sc.nextLine();

                    boolean ok = bloodBankDAO.addBloodBank(bankName, city, contact);
                    System.out.println(ok ? "Blood Bank Added Successfully!" : "Failed to add blood bank.");
                }

                case 3 -> {
                    System.out.print("Bank ID: ");
                    int bankId = Integer.parseInt(sc.nextLine());

                    System.out.print("Blood Group: ");
                    String bg = sc.nextLine();

                    System.out.print("Units Available: ");
                    int units = Integer.parseInt(sc.nextLine());

                    boolean ok = stockDAO.addOrUpdateStock(bankId, bg, units);
                    System.out.println(ok ? "Stock Updated Successfully!" : "Failed to update stock.");
                }

                case 4 -> {
                    System.out.print("Patient Name: ");
                    String patient = sc.nextLine();

                    System.out.print("Blood Group Needed: ");
                    String bg = sc.nextLine();

                    System.out.print("Units Needed: ");
                    int units = Integer.parseInt(sc.nextLine());

                    System.out.print("City: ");
                    String city = sc.nextLine();

                    System.out.print("Emergency Level (LOW/MED/HIGH): ");
                    String level = sc.nextLine();

                    boolean ok = requestDAO.createRequest(patient, bg, units, city, level);
                    System.out.println(ok ? "Blood Request Created Successfully!" : "Failed to create request.");
                }

                case 5 -> {
                    System.out.print("Blood Group Needed: ");
                    String bg = sc.nextLine();

                    System.out.print("City: ");
                    String city = sc.nextLine();

                    System.out.print("Emergency Level (LOW/MED/HIGH): ");
                    String level = sc.nextLine();

                    ArrayList<Donor> donors = donorDAO.getAvailableDonorsByBloodAndCity(bg, city);
                    MatchingService.printRankedDonors(donors, level);
                }

                case 6 -> {
                    System.out.print("City: ");
                    String city = sc.nextLine();

                    System.out.print("Blood Group: ");
                    String bg = sc.nextLine();

                    stockDAO.viewStockByCityAndGroup(city, bg);
                }

                default -> System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
