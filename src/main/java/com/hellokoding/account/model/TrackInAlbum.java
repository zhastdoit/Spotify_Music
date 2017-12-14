package com.hellokoding.account.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(TrackInAlbumPrimaryKey.class)
@Table(name="trackinalbum")
public class TrackInAlbum {
    @Id
    private Long tid;

    @Id
    private Long alid;

    @Column(name="numberinalbum")
    private int order;

    public TrackInAlbum() {}

    public TrackInAlbum(int order) {
        this.order = order;
    }


}
