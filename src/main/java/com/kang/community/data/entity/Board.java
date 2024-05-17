package com.kang.community.data.entity;

public class Board {

    int id;
    String name;
    private static int idCnt = 1;

    public Board() {
        id = idCnt++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
