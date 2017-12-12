package com.hellokoding.account.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="track")
public class Track {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="tid")
    private Long id;

    @Column(name="ttitle")
    private String ttitle;

    @Column(name="tduration")
    private int tduration;

    @Column(name="tgenre")
    private String genre;

    @ManyToOne(cascade= { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name="aid")
    private Artist artist;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="tid")
//    private List<Rate> rates;

//	@ManyToMany(fetch=FetchType.LAZY, cascade= { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
//	@JoinTable(name="trackinplaylist", joinColumns=@JoinColumn(name="tid"), inverseJoinColumns=@JoinColumn(name="pid"))
//	private List<Playlist> playlists;

    public Track() {}

    public Track(String ttile, int tduration, String genre) {
        this.ttitle = ttitle;
        this.tduration = tduration;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTtitle() {
        return ttitle;
    }

    public void setTtitle(String ttitle) {
        this.ttitle = ttitle;
    }

    public int getTduration() {
        return tduration;
    }

    public void setTduration(int tduration) {
        this.tduration = tduration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Track [id=" + id + ", ttile=" + ttitle + ", tduration=" + tduration + ", genre=" + genre + "]";
    }

}
