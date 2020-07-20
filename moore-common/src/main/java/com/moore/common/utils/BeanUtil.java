package com.moore.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanUtil {

    /**
     * JavaBean对象转换成Map
     *
     * @param javaBean
     * @param needLowCase
     * @return
     * @throws Exception
     */
    public static Map java2Map(Object javaBean, boolean needLowCase) throws Exception {
        Map map = new HashMap(16);

        try {
            // 获取javaBean属性
            BeanInfo beanInfo = Introspector.getBeanInfo(javaBean.getClass());

            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            if (propertyDescriptors != null && propertyDescriptors.length > 0) {
                // javaBean属性名
                String propertyName = null;
                // javaBean属性值
                Object propertyValue = null;
                for (PropertyDescriptor pd : propertyDescriptors) {
                    propertyName = needLowCase ? pd.getName().toLowerCase() : pd.getName();
                    if (!"class".equals(propertyName)) {
                        Method readMethod = pd.getReadMethod();
                        propertyValue = readMethod.invoke(javaBean);
                        map.put(propertyName, propertyValue);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return map;
    }

    /**
     * Map转换成JavaBean
     *
     * @param obj
     * @param map
     * @param params
     * @throws Exception
     */
    public static void map2Java(Object obj, Map<String, Object> map, Boolean... params) throws Exception {
        try {
            boolean needLowCase = true;
            if (params.length != 0) {
                needLowCase = params[0];
            }
            //创建 Bean 属性
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            if (propertyDescriptors != null && propertyDescriptors.length > 0) {
                for (PropertyDescriptor pd : propertyDescriptors) {
                    //属性名 小写
                    String propertyName = needLowCase ? pd.getName().toLowerCase() : pd.getName();
                    // 属性值 map也要小写。。。
                    if (map.containsKey(propertyName)) {

                        Object propertyValue = map.get(propertyName);

                        if (propertyValue != null) {
                            pd.getWriteMethod().invoke(obj, propertyValue);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    /**
     * JavaBean转换成JavaBean
     *
     * @param fromBean
     * @param destBean
     */
    public static void Bean2Bean(Object fromBean, Object destBean) {
        try {

            Map map = java2Map(fromBean, true);
            map2Java(destBean, map);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * List集合对象拷贝
     *
     * @param sourceList
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List copyList(List<T> sourceList, Class clazz) {
        List<T> beanList = new ArrayList<T>(sourceList.size());
        if (sourceList != null && !sourceList.isEmpty()) {
            for (int i = 0; i < sourceList.size(); i++) {
                try {
                    Object o = clazz.newInstance();
                    Bean2Bean(sourceList.get(i), o);
                    beanList.add((T) o);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
        return beanList;
    }
}
