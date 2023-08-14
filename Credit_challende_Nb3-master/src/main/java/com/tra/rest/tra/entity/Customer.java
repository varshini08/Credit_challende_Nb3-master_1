package com.tra.rest.tra.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document
public class Customer {
        @Field("Firstname")
        private String first;
        //@Field("Lastname")
        private String last;
        //@Field("Gender")
        private String gender;
        // @Field("Job")
        private String job;
        //@Field("DateOfBirth")
        private String dob;
        @Id
        private long customer_id; //primary key of an entity

    public Customer() {
    }

    public Customer(String first, String last, String gender, String job, String dob, long customer_id) {
        this.first = first;
        this.last = last;
        this.gender = gender;
        this.job = job;
        this.dob = dob;
        this.customer_id = customer_id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                ", dob='" + dob + '\'' +
                ", customer_id=" + customer_id +
                '}';
    }
}
