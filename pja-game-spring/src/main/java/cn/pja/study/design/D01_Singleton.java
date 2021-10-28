package cn.pja.study.design;

import javax.swing.*;
import java.awt.*;

/**
 * 单例（Singleton）模式：某个类只能生成一个实例，该类提供了一个全局访问点供外部获取该实例，其拓展是有限多例模式。
 *
 * @author 彭金安
 * @DATE 2021/10/28
 */
public class D01_Singleton {

    public static void main(String[] args) {
        JFrame jf = new JFrame("饿汉单例模式测试");
        jf.setLayout(new GridLayout(1, 2));
        Container contentPane = jf.getContentPane();
        Bajie obj1 = Bajie.getInstance();
        contentPane.add(obj1);
        Bajie obj2 = Bajie.getInstance();
        contentPane.add(obj2);
        if (obj1 == obj2) {
            System.out.println("他们是同一人！");
        } else {
            System.out.println("他们不是同一人！");
        }
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Bajie extends JPanel{
    private static Bajie instance = new Bajie();
    private Bajie() {


        JLabel l1 = new JLabel(new ImageIcon("/img.png"));
        this.add(l1);
    }
    public static Bajie getInstance() {
        return instance;
    }

}
