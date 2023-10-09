package com.smarterschedule.server.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Column(name = "user_id")
    private @Id @GeneratedValue Long id;

    @Column(name = "uid", nullable = false, unique = true)
    private String uid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

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

    @Override
    public String toString() {
        return "User [id=" + id + ", uid=" + uid + ", name=" + name + ", phone=" + phone + "]";
    }

}
