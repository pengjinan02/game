package cn.pja.study.test;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApplication {
    public static void main(String[] args) {
        // 1.spring容器初始化
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(App.class);
        // 2.获取bean
        System.out.println(ac.getBean(App.class));
        System.out.println(ac.getBean(Y.class));
        // 2.1 X类未添加注解，不可获取
        //System.out.println(ac.getBean(X.class));


    }

    // spring容器初始化模拟（伪代码）
    public void initSpring(){
        // 1.扫描带有注解的类，获取其class
        List<Class> list = null; // z.class y.class
        Map<String , GenericBeanDefinition> map = new HashMap<>();

        // 2.构建扫描到的class的属性
        for (Class aClass : list) {
            GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
            genericBeanDefinition.setScope("singleton");
            genericBeanDefinition.setLazyInit(false);
            genericBeanDefinition.setDependsOn("x");
            genericBeanDefinition.setBeanClass(aClass);
            genericBeanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
            //......代码省略
            map.put(aClass.getSimpleName(), genericBeanDefinition);
        }

        for (String s : map.keySet()){
            GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition)map.get(s);
            if (genericBeanDefinition.getScope().equals("singleton")) {
                //......代码省略
                //Object o = genericBeanDefinition.getBeanClass().newInstance();
            }
            //放入到spring容器
            //put(o);
        }
    }
}
