package com.hin.controller;

public class HelloC {
    public HelloC() {
        System.out.println("HelloC");
    }

    { System.out.println("I'm C class"); }

    static { System.out.println("static C"); }
}
