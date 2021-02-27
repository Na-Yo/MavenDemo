package strategy;

/**
 * @author xuziwen
 * @date 2021/2/27 3:37 下午
 */
public class DefaultDogComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.getHeight().compareTo(o2.getHeight());
    }
}
