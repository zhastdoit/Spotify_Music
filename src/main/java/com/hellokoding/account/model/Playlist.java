package com.hellokoding.account.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Data
@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pid")
    private Long pid;

    @Column(name = "pname")
    private String pname;

    @Column(name = "pdate")
    private Timestamp timestamp;

    // true stands for OK for everybody
    @Column(name = "public")
    private Boolean canSee;

    @Column(name = "uid")
    private Long uid;

    @ManyToMany(fetch=FetchType.LAZY, cascade= { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name="trackinplaylist", joinColumns=@JoinColumn(name="pid"), inverseJoinColumns=@JoinColumn(name="tid"))
    private List<Track> trackList;

    public Playlist() {}

    public Playlist(String pname, boolean canSee, Long uid) {
        this.pname = pname;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.canSee = canSee;
        this.uid = uid;
    }
    public boolean getCanSee() {
        return this.canSee;
    }
}
