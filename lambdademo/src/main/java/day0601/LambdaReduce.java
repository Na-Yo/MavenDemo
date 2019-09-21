package day0601;

import javax.xml.ws.soap.Addressing;
import java.math.BigDecimal;
import java.text.Bidi;
import java.util.ArrayList;

public class LambdaReduce {

    public static void main(String[] args) {
        ArrayList<BigDecimal> bigDecimalArrayList = new ArrayList<>();
        BigDecimal bigDecimal = new BigDecimal("-1.11");
        BigDecimal bigDecimal1 = new BigDecimal("1.12");
        BigDecimal bigDecimal2 = new BigDecimal("1.13");
        BigDecimal bigDecimal3 = new BigDecimal("1.14");
        BigDecimal bigDecimal4 = new BigDecimal("1.15");

        bigDecimalArrayList.add(bigDecimal);
        bigDecimalArrayList.add(bigDecimal1);
        bigDecimalArrayList.add(bigDecimal2);
        bigDecimalArrayList.add(bigDecimal3);
        bigDecimalArrayList.add(bigDecimal4);

        BigDecimal reduce = bigDecimalArrayList.stream().map(item -> {
            return item.compareTo(BigDecimal.ZERO) <=0 ? BigDecimal.ZERO : item;
        }).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(reduce);

    }
}
