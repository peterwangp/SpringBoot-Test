package com.wpy.simpleTest;

public class Base {
    public static int s;
    private int a;
    static {
        System.out.println("Base static block, s:" + s);
        s = 1;
    }
    {
        System.out.println("Base instance block, a:" + a);
    }
    public Base() {
        System.out.println("Base constructor, a:" + a);
    }
    protected void step() {
        System.out.println("base s:" + s + "a: " + a);
    }
    public void action(){
        System.out.println("start");
        step();
        System.out.println("end");
    }
}
