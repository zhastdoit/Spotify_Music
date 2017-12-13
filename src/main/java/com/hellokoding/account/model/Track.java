package com.hellokoding.account.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
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

    @Override
    public String toString() {
        return "Track [id=" + id + ", ttile=" + ttitle + ", tduration=" + tduration + ", genre=" + genre + "]";
    }

}
