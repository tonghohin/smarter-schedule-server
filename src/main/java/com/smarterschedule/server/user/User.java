package com.smarterschedule.server.user;

import java.util.List;

import com.smarterschedule.server.availability.Availability;
import com.smarterschedule.server.student.Student;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Column(name = "user_id")
    private @Id @GeneratedValue Long id;

    @Column(name = "uid", nullable = false, unique = true, updatable = false)
    private String uid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @OrderBy("day ASC")
    private List<Availability> availability;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Student> students;

    User() {
    }

    User(String uid, String name, String phone) {
        this.uid = uid;
        this.name = name;
        this.phone = phone;
    }

    public Long getId() {
        return this.id;
    }

    public String getUid() {
        return this.uid;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public List<Availability> getAvailability() {
        return this.availability;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAvailability(List<Availability> availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", uid=" + uid + ", name=" + name + ", phone=" + phone + "]";
    }

}
