package com.smarterschedule.server.availability;

import java.time.LocalTime;

import com.smarterschedule.server.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "availability")
public class Availability {
    @Column(name = "availability_id")
    private @Id @GeneratedValue Long id;

    @Column(name = "day_of_week", nullable = false)
    private Integer day;

    @Column(name = "from_time")
    private LocalTime from;

    @Column(name = "to_time")
    private LocalTime to;

    @Column(name = "available", nullable = false)
    private Boolean available;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    Availability() {
    }

    Availability(Integer day, LocalTime from, LocalTime to, Boolean available) {
        this.day = day;
        this.from = from;
        this.to = to;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public LocalTime getFrom() {
        return from;
    }

    public void setFrom(LocalTime from) {
        this.from = from;
    }

    public LocalTime getTo() {
        return to;
    }

    public void setTo(LocalTime to) {
        this.to = to;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Availability [id=" + id + ", day=" + day + ", from=" + from + ", to=" + to + ", available=" + available
                + ", userId=" + user.getId() + "]";
    }

}
