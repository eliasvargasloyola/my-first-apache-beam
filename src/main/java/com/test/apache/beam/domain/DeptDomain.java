package com.test.apache.beam.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DeptDomain implements Serializable {

    private static final long serialVersionUID = 1011956660505575931L;

    private String code;
    private String name;
    private String sector;
    private String type;
    private String date;

    public DeptDomain(String line) {
        List<String> obj = Arrays.asList(line.split(","));
        this.code = obj.get(0);
        this.name = obj.get(1);
        this.sector = obj.get(2);
        this.type = obj.get(3);
        this.date = obj.get(4);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSector() {
        return sector;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "[" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", sector='" + sector + '\'' +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeptDomain)) return false;
        DeptDomain that = (DeptDomain) o;
        return Objects.equals(getCode(), that.getCode()) && Objects.equals(getName(), that.getName()) && Objects.equals(getSector(), that.getSector()) && Objects.equals(getType(), that.getType()) && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getName(), getSector(), getType(), getDate());
    }
}

