package github.areebmalik1989.core.domain;

public class IdGenerator {

    public static long generate(){

        // Sleep to ensure unique value is returned
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return System.currentTimeMillis();
    }
}
