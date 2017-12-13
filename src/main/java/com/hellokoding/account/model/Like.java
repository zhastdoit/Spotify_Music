package com.hellokoding.account.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@IdClass(LikePrimaryKey.class)
@Table(name="likes")
public class Like {
    @Id
    private Long uid;

    @Id
    private Long aid;

    @Column(name="lTimestamp")
    private Timestamp timestamp;

    public Like() {}

    public Like(Long uid, Long aid) {
        this.uid = uid;
        this.aid = aid;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
}
