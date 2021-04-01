package com.example.simpleandroidproject.util;

public class PageEntity {
    public void setName(String name) {
        this.name = name;
    }

    public void setCls(Class cls) {
        this.cls = cls;
    }

    public String getName() {
        return name;
    }

    public Class getCls() {
        return cls;
    }

    public PageEntity(String name, Class cls) {
        this.name = name;
        this.cls = cls;
    }

    public PageEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PageEntity{" +
                "name='" + name + '\'' +
                ", cls=" + cls +
                '}';
    }

    public String name;
    public Class cls;
}
