package com.isaiasvera;

import java.util.HashSet;

public class SetIssueManager implements IssueManager{
    HashSet<Issue> issues = new HashSet<>();

    @Override
    public void addIssue(Issue issue) {
        issues.add(issue);
    }

    @Override
    public void manageIssue(int id, int sistema) {
        issues.removeIf(n -> (n.getIdIncidencia() == id && n.getSistemaAfectado() == sistema));
    }

    @Override
    public String toString() {
        return "SetIssueManager{" +
                "issues=" + issues +
                '}';
    }
}
