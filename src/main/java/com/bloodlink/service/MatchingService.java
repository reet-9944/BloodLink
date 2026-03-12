package com.bloodlink.service;

import com.bloodlink.model.Donor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class MatchingService {

    public static int calculateScore(Donor donor, String emergencyLevel) {
        int score = 0;

        score += 30;

        if (donor.isAvailability()) score += 30;

        if (donor.getLastDonationDate() != null) {
            LocalDate last = donor.getLastDonationDate().toLocalDate();
            long days = ChronoUnit.DAYS.between(last, LocalDate.now());

            if (days >= 90) score += 20;
            else if (days >= 60) score += 10;
            else score -= 20;
        } else {
            score += 5;
        }

        if (emergencyLevel.equalsIgnoreCase("HIGH")) score += 20;
        else if (emergencyLevel.equalsIgnoreCase("MED")) score += 10;

        return score;
    }

    public static void printRankedDonors(List<Donor> donors, String emergencyLevel) {
        List<Map.Entry<Donor, Integer>> ranked = new ArrayList<>();

        for (Donor d : donors) {
            ranked.add(new AbstractMap.SimpleEntry<>(d, calculateScore(d, emergencyLevel)));
        }

        ranked.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        System.out.println("\nTop Matching Donors (Ranked):");
        if (ranked.isEmpty()) {
            System.out.println("No donors available.");
            return;
        }

        int i = 1;
        for (Map.Entry<Donor, Integer> entry : ranked) {
            Donor d = entry.getKey();
            int score = entry.getValue();

            System.out.println(i + ") " + d.getName() +
                    " | Blood: " + d.getBloodGroup() +
                    " | City: " + d.getCity() +
                    " | Area: " + d.getArea() +
                    " | Phone: " + d.getPhone() +
                    " | Score: " + score);
            i++;
        }
    }
}
