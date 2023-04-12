import entity.SummonRift;
import handle.SummonRiftHandle;

public class Main {
    public static void main(String[] args) {
        SummonRiftHandle summonRiftHandle = new SummonRiftHandle();
        SummonRift summonRift = summonRiftHandle.startMatch();
        System.out.println(summonRift);
    }
}
