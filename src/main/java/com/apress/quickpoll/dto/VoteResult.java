package com.apress.quickpoll.dto;

import java.util.Collection;

public class VoteResult {
    private int totalvalues;
    private Collection<OptionCount> results;

    public VoteResult(){}

    public int getTotalvalues() {
        return totalvalues;
    }

    public void setTotalvalues(int totalvalues) {
        this.totalvalues = totalvalues;
    }

    public Collection<OptionCount> getResults() {
        return results;
    }

    public void setResults(Collection<OptionCount> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "VoteResult{" +
                "totalvalues=" + totalvalues +
                ", results=" + results +
                '}';
    }
}