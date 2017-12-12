package com.hellokoding.account.model;



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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public void add(Track track) {
        if (tracks == null) {
            tracks = new ArrayList<>();
        }
        tracks.add(track);
        track.setArtist(this);
    }

}
