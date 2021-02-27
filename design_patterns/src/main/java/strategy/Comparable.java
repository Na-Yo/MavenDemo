package strategy;

/**
 * @author xuziwen
 * @date 2021/2/27 3:21 下午
 */
@FunctionalInterface
public interface Comparable<T> {

    /**
     * 比较大小
     * @param o
     * @return
     */
    public int compareTo(T o);
}
