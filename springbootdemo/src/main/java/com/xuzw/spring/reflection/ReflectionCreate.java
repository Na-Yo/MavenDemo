package com.xuzw.spring.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author xuziwen
 */
public class ReflectionCreate {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> studentClass = Class.forName("com.xuzw.spring.model.Student");
        Object student = studentClass.newInstance();
        Field[] studentClassDeclaredFields = studentClass.getDeclaredFields();
        Arrays.stream(studentClassDeclaredFields).forEach(field -> {
            Class<?> fieldType = field.getType();
            try {
                Object newInstance = fieldType.newInstance();
                field.setAccessible(true);
                field.set(student,newInstance);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        });
        System.out.println(student);
    }
}
