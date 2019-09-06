package day0612;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageResourceLocale {

    public static void main(String[] args) throws UnsupportedEncodingException {

        Locale localeEn = new Locale("en", "US");

        Locale localeZh = new Locale("zh", "CN");

        ResourceBundle bundle = ResourceBundle.getBundle("resource", localeZh);//路径问题待研究

        Enumeration<String> keys = bundle.getKeys();

        String test = bundle.getString("test");

        String pattern = bundle.getString("pattern");

        String[] s=new String[]{"3","男男女女"};

        String message = MessageFormat.format(pattern, (Object[]) s);
        String s1 = new String(message.getBytes("ISO-8859-1"), "ISO-8859-1");
        String s2 = new String(message.getBytes("UTF-8"), "UTF-8");
        try {
            if(message.equals(s1))
            {
                message=new String(message.getBytes("ISO-8859-1"),"UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("UnsupportedEncodingException："+e.getMessage());
        }
        System.out.println("test==="+message);

        System.out.println("test==="+test);

    }
}
