package com.hellokoding.account.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Data
@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "alid")
    private Long alid;

    @Column(name = "atitle")
    private String atitle;

    @Column(name = "adate")
    private Timestamp timestamp;

    @ManyToMany(fetch=FetchType.LAZY, cascade= { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name="trackinalbum", joinColumns=@JoinColumn(name="alid"), inverseJoinColumns=@JoinColumn(name="tid"))
    private List<Track> trackList;

    @Column(name="alimage")
    private String alimage;

    public Album() {}

    public Album(String atitle) {
        this.atitle = atitle;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
}
