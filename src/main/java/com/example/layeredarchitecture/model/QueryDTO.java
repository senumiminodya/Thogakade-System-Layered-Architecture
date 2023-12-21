package com.example.layeredarchitecture.model;

public class QueryDTO {
    private String id;
    private String name;
    private String oid;
    private String date;

    public QueryDTO(String id, String name, String oid, String date) {
        this.id = id;
        this.name = name;
        this.oid = oid;
        this.date = date;
    }

    public QueryDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "QueryDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", oid='" + oid + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

