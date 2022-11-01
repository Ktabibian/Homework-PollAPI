package com.apress.quickpoll.dto;

public class OptionCount {
    private Long optionId;
    private int count;
    // Getters and Setters omitted for brevity

    // Creating DDO objects to transfer data
    public OptionCount() {
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OptionCount{" +
                "optionId=" + optionId +
                ", count=" + count +
                '}';
    }
}
