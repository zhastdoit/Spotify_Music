package com.hellokoding.account.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "pid")
    private Long pid;

    @Column(name = "pname")
    private String pname;

    @Column(name = "pdate")
    private Date date;

    // true stands for OK for everybody
    @Column(name = "public")
    private boolean isPublic;

    @ManyToOne(cascade= { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "uid")
    private User owner;



    public Playlist() {}

    public Playlist(Date date, boolean isPublic, String pname) {
        this.pname = pname;
        this.date = date;
        this.isPublic = isPublic;
    }
}
