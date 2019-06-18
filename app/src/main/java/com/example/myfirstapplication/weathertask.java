package com.example.myfirstapplication;

public class weathertask {
    private String mainwea;
    private String deswea;
    private Double temp;
    private Double tempmin;
    private Double tempmax;
    private String city;


    public weathertask(String mainwea, String deswea, Double tempmin, Double tempmax, Double temp, String city) {
        this.mainwea = mainwea;
        this.deswea = deswea;
        this.tempmin = tempmin;
        this.tempmax = tempmax;
        this.city = city;
        this.temp=temp;
    }


    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public String getMainwea() {
        return mainwea;
    }

    public void setMainwea(String mainwea) {
        this.mainwea = mainwea;
    }

    public String getDeswea() {
        return deswea;
    }

    public void setDeswea(String deswea) {
        this.deswea = deswea;
    }

    public Double getTempmin() {
        return tempmin;
    }

    public void setTempmin(Double tempmin) {
        this.tempmin = tempmin;
    }

    public Double getTempmax() {
        return tempmax;
    }

    public void setTempmax(Double tempmax) {
        this.tempmax = tempmax;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
