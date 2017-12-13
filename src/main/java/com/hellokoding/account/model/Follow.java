package com.hellokoding.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@IdClass(FollowPrimaryKey.class)
@Table(name="follow")
public class Follow {
    @Id
    private Long fid;

    @Id
    private Long uid;

    @Column(name="ftimestamp")
    private Timestamp timestamp;

    public Follow() {}

    public Follow(Long uid, Long fid) {
        this.uid = uid;
        this.fid = fid;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Long getUid() {
        return uid;
    }

    public Long getFid() {
        return fid;
    }


    public void setUid(Long uid) {
        this.uid = uid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}