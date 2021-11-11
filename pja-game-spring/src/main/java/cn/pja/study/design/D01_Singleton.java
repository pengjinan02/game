package cn.pja.study.design;

import org.springframework.core.io.Resource;
import sun.awt.image.FileImageSource;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;

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
        System.out.println("....");
        URL url = Resource.class.getClassLoader().getResource("");
        System.out.println(url.getPath());
        // 工程路径
        System.out.println(System.getProperty("user.dir"));
        System.out.println(Bajie.class.getResource("Bajie.class"));
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));

        ImageIcon imageIcon = new ImageIcon("main/resources/image/img.png");
        ImageIcon imageIcon2 = new ImageIcon("pja-game-spring/src/main/resources/image/img.png");
        JLabel l1 = new JLabel(imageIcon);
        JLabel l2 = new JLabel(imageIcon2);
        this.add(l2);
    }
    public static Bajie getInstance() {
        return instance;
    }

}
