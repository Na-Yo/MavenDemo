package day0612;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageResourceLocale {

    public static void main(String[] args) {

        Locale localeEn = new Locale("en", "US");

        Locale localeZh = new Locale("zh", "CN");

        ResourceBundle bundle = ResourceBundle.getBundle("resource", localeEn);//路径问题待研究

        Enumeration<String> keys = bundle.getKeys();

        String test = bundle.getString("test");

        System.out.println("test==="+test);

    }
}
