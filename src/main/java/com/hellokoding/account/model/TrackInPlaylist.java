package com.hellokoding.account.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(TrackInPlaylistPrimaryKey.class)
@Table(name="trackinplaylist")
public class TrackInPlaylist {
    @Id
    private Long pid;

    @Id
    private Long tid;

    public TrackInPlaylist() {}

    public TrackInPlaylist(Long pid, Long tid) {
        this.pid = pid;
        this.tid = tid;
    }

}