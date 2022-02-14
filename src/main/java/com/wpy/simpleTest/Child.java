package com.wpy.simpleTest;

public class Child extends Base{
    public static int s;
    private int a;
    static {
        System.out.println("Child static block, s:" + s);
        s = 10;
    }
    {
        System.out.println("Child instance block, a:" + a);
        a = 10;
    }
    public Child() {
        System.out.println("Child constructor, a:" + a);
        a = 20;
    }
    protected void step() {
        System.out.println("child s: " + s + ", a: " + a);
    }
}
