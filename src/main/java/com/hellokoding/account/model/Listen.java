package com.hellokoding.account.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Data
@Entity
@IdClass(ListenPrimaryKey.class)
@Table(name = "listen")
public class Listen {
    @Id
    private Long uid;

    @Id
    private Long tid;

    @Column(name = "ltimestamp")
    private Timestamp timestamp;

    public Listen() {}

    public Listen(Long uid, Long tid) {
        this.uid = uid;
        this.tid = tid;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
}
