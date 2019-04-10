package com.example.bmicalculation;

public class BMIModel {
    private String height, weight;

    public BMIModel(String height, String weight) {
        this.height = height;
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }


}
