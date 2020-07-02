/**
 * @author : cuipingping
 * create at:  2020/7/2
 * @description: 统计占用时间和内存消耗
 */
public class BaseSolution {

    /**
     * 统计内存消耗
     * @return
     */
    public static long used() {
        long total = Runtime.getRuntime().totalMemory();
        long free = Runtime.getRuntime().freeMemory();
        return (total - free);
    }
}