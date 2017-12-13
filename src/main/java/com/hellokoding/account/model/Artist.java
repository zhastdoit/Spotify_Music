package com.hellokoding.account.model;



import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@Entity
@Table(name="artist")
public class Artist {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="aid")
    private Long id;

    @Column(name="aname")
    private String aname;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy="artist",cascade = CascadeType.ALL)
    private List<Track> tracks;

    public Artist() {}

    public Artist(String aname, String description) {
        this.aname = aname;
        this.description = description;
    }

    public void addTrack(Track track) {
        if (tracks == null) {
            tracks = new ArrayList<>();
        }
        tracks.add(track);
        track.setArtist(this);
    }

}
