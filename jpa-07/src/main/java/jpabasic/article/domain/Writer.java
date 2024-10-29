package jpabasic.article.domain;

import jakarta.persistence.*;


public class Writer {
    
    private Long id;
    private String name;

    
    private Address address;

   
    private Intro intro;

    protected Writer() {
    }

    public Writer(String name, Address address, Intro intro) {
        this.name = name;
        this.address = address;
        this.intro = intro;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Intro getIntro() {
        return intro;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Writer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", intro=" + intro +
                '}';
    }
}
