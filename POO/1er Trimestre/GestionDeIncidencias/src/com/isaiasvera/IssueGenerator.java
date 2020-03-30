package com.isaiasvera;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class IssueGenerator {
    final static int ITE = 50;
    public static int random (int desde, int hasta){
        return new Random().ints(desde,hasta+1).findAny().getAsInt();
    }
    public static void main(String[] args) {
        SetIssueManager issueManager = new SetIssueManager();
        AtomicInteger con = new AtomicInteger(1);
        for (int c = 0; c < ITE; c++){
            issueManager.addIssue(new Issue(c, "Eoeoeoeo", con.getAndIncrement()));
        }
        System.out.println(issueManager);

        issueManager.manageIssue(15,16);

        System.out.println(issueManager);
    }
}
