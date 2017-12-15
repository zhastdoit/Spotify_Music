package com.hellokoding.account.model;

import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.List;

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

    @Column(name="timage")
    private String timage;

    @Column(name="trackurl")
    private String trackurl;


    @ManyToOne(cascade= { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name="aid")
    private Artist artist;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="tid")
    private List<Listen> listens;

	@ManyToMany(fetch=FetchType.LAZY, cascade= { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinTable(name="trackinplaylist", joinColumns=@JoinColumn(name="tid"), inverseJoinColumns=@JoinColumn(name="pid"))
	private List<Playlist> playlists;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="tid")
    private List<Rate> rates;

    public Track() {}

    public Track(String ttile, int tduration, String genre) {
        this.ttitle = ttitle;
        this.tduration = tduration;
        this.genre = genre;
    }


    @Override
    public String toString() {
        return "Track [id=" + id + ", ttitle=" + ttitle + ", tduration=" + tduration + ", genre=" + genre + "]";
    }

}
