package com.hellokoding.account.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(RatePrimaryKey.class)
@Table(name="rate")
public class Rate {
    @Id
    private Long uid;

    @Id
    private Long tid;

    @Column(name="score")
    private int score;

    public Rate() {}

    public Rate(Long uid, Long tid, int score) {
        this.score = score;
        this.uid = uid;
        this.tid = tid;
    }

    public Long getUid() {
        return uid;
    }

    public Long getTid() {
        return tid;
    }

    public int getScore() {
        return score;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public void setScore(int score) {
        this.score = score;
    }

}