package com.hellokoding.account.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ListenPrimaryKey implements Serializable {
    private Long uid;
    private Long tid;
    private Timestamp timestamp;
}