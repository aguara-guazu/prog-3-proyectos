package com.whisky.whiskyServer.data;

import java.util.concurrent.atomic.AtomicInteger;

public class Whisky {
  private static final AtomicInteger COUNTER = new AtomicInteger();
  private  int id;
  private String name;
  private String origin;

  public Whisky(String name, String origin){
    this.id = COUNTER.getAndIncrement();
    this.name = name;
    this.origin = origin;
  }

  public Whisky(){
    this.id = COUNTER.getAndIncrement();
  }


  public int getId() {
    return id;
  }
  public void setId(int id){ this.id = id;}

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getOrigin() {
    return origin;
  }
  public void setOrigin(String origin) {
    this.origin = origin;
  }
}
