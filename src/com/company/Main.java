package com.company;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Haircut hairBeardCut = new Haircut("HairBeardCut", "Man", 300);
        Haircut haircut = new Haircut("Haircut", "Man", 200);
        Haircut beardTrim = new Haircut("BeardTrim", "Man", 100);
        System.out.println(hairBeardCut);
        System.out.println(haircut);
        System.out.println(beardTrim);
        System.out.println();

        Client ivan = new Client("1", "Ivan Bremen Petrovich", "Man", false);
        Client ivan2 = new Client("2", "Ivan Bremen Petrovich", "Man", false);
        System.out.println(ivan);
        System.out.println(ivan2);

        int ivanVisit = 2;
        if (ivanVisit > 5) {
            System.out.println("regularClient");
        } else {
            System.out.println("NoregularClient");
        }
        System.out.println();

        Job r1 = new Job(hairBeardCut, ivan, LocalDateTime.of(2020, Month.SEPTEMBER, 15, 12, 10, 45));
        Job r2 = new Job(hairBeardCut, ivan, LocalDateTime.of(2020, Month.OCTOBER, 01, 12, 10, 45));
        System.out.println(r1);
        System.out.println(r2);
        System.out.println();

        List<Job> jobs = new ArrayList<>();
        jobs.add(r1);
        jobs.add(r2);
        System.out.println(jobs);


    }
}
