package io.seven4x.hz2020;

public class LongCaclErrorDemo {

    public static void main(String[] args) {
        LongCaclErrorDemo demo = new LongCaclErrorDemo();
        demo.test(3, 25);
        System.out.println((long) 25 * 1024 * 1024 * 1024 * 8);
        System.out.println(25 * 1024 * 1024 * 1024 * 8);
    }


    public String test(long test, int limit) {
        if (test > (long)limit * 1024 * 1024 * 1024 * 8) {
            System.out.println("mock if ");
        } else {
            System.out.println("mock else");
        }
        return "";
    }
}
