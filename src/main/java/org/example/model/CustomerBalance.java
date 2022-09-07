package org.example.model;

import com.opencsv.bean.CsvBindByName;

public class CustomerBalance {

    @CsvBindByName(column = "id")
    private int id;

    @CsvBindByName(column = "Nama")
    private String name;

    @CsvBindByName(column = "Age")
    private int age;

    @CsvBindByName(column = "Balanced")
    private int balanced;

    @CsvBindByName(column = "Previous Balanced")
    private int previousBalanced;

    @CsvBindByName(column = "Average Balanced")
    private int averageBalanced;

    @CsvBindByName(column = "Free Transfer")
    private int freeTransfer;

    @CsvBindByName(column = "No 1 Thread-No")
    private String no1Thread;

    @CsvBindByName(column = "No 2a Thread-No")
    private String no2aThread;

    @CsvBindByName(column = "No 2b Thread-No")
    private String no2bThread;

    @CsvBindByName(column = "No 3 Thread-No")
    private String no3Thread;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBalanced() {
        return balanced;
    }

    public void setBalanced(int balanced) {
        this.balanced = balanced;
    }

    public int getPreviousBalanced() {
        return previousBalanced;
    }

    public void setPreviousBalanced(int previousBalanced) {
        this.previousBalanced = previousBalanced;
    }

    public int getAverageBalanced() {
        return averageBalanced;
    }

    public void setAverageBalanced(int averageBalanced) {
        this.averageBalanced = averageBalanced;
    }

    public int getFreeTransfer() {
        return freeTransfer;
    }

    public void setFreeTransfer(int freeTransfer) {
        this.freeTransfer = freeTransfer;
    }

    public String getNo1Thread() {
        return no1Thread;
    }

    public void setNo1Thread(String no1Thread) {
        this.no1Thread = no1Thread;
    }

    public String getNo2aThread() {
        return no2aThread;
    }

    public void setNo2aThread(String no2aThread) {
        this.no2aThread = no2aThread;
    }

    public String getNo2bThread() {
        return no2bThread;
    }

    public void setNo2bThread(String no2bThread) {
        this.no2bThread = no2bThread;
    }

    public String getNo3Thread() {
        return no3Thread;
    }

    public void setNo3Thread(String no3Thread) {
        this.no3Thread = no3Thread;
    }

    @Override
    public String toString() {
        return "CustomerBalance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", balanced=" + balanced +
                ", previousBalanced=" + previousBalanced +
                ", averageBalanced=" + averageBalanced +
                ", freeTransfer=" + freeTransfer +
                ", no1Thread='" + no1Thread + '\'' +
                ", no2aThread='" + no2aThread + '\'' +
                ", no2bThread='" + no2bThread + '\'' +
                ", no3Thread='" + no3Thread + '\'' +
                '}';
    }
}
