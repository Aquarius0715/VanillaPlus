package com.aquariusuprim.debug;

import struct.Flag;

public class debug {
    public static void main(String[] args) {
        Flag flag = Flag.ON;
        System.out.println(flag);
        flag = flag.toggle();
        System.out.println(flag);
    }
}
