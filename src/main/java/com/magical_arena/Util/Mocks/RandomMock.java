package Util.Mocks;

import java.util.Random;

public class RandomMock extends Random {
    @Override
    public int nextInt(){
        return 5;
    }
}
