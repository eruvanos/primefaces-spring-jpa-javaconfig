package de.siemering.example.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloWorldBean {
   public HelloWorldBean() {
      System.out.println("HelloWorld started!");
   }
   public String getMessage() {
      return "Hello World!";
   }
}