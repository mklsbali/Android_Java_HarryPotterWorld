package com.example.harrypotterworld;

public class Question {
    private String q, a1, a2, a3, a4,a5;
    private int a1p, a2p, a3p, a4p, a5p;
    public Question(String q, String a1,String a2,String a3,String a4,String a5){
        this.q=q;
        this.a1=a1;
        this.a2=a2;
        this.a3=a3;
        this.a4=a4;
        this.a5=a5;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }

    public String getA5() {
        return a5;
    }

    public void setA5(String a5) {
        this.a5 = a5;
    }

    public int getA1p() {
        return a1p;
    }

    public void setA1p(int a1p) {
        this.a1p = a1p;
    }

    public int getA2p() {
        return a2p;
    }

    public void setA2p(int a2p) {
        this.a2p = a2p;
    }

    public int getA3p() {
        return a3p;
    }

    public void setA3p(int a3p) {
        this.a3p = a3p;
    }

    public int getA4p() {
        return a4p;
    }

    public void setA4p(int a4p) {
        this.a4p = a4p;
    }

    public int getA5p() {
        return a5p;
    }

    public void setA5p(int a5p) {
        this.a5p = a5p;
    }
}
