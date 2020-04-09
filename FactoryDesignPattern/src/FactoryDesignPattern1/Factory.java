package FactoryDesignPattern1;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

public class Factory {

    public static Map<Integer, Class<? extends JPanel>> m = new HashMap<>();

    static {
        File f = new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\DesignPatternAssignments\\src\\designpatternassignments\\FactoryDesignPattern1\\Tabs");
        File[] files = f.listFiles();
        int i = 1;
        for (File file : files) {

            String className = file.getName();
            if (className.contains(".java")) {
                String name = className.split("\\.")[0];
                Class<? extends JPanel> c = null;
                try {
                    c = Class.forName("designpatternassignments.FactoryDesignPattern1.Tabs." + name).asSubclass(javax.swing.JPanel.class);
                    m.put(i, c);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }

            i++;
        }
    }

    public static JPanel createPanel(int type) {
        Class<? extends JPanel> c = m.get(type);
        try {
            JPanel panel = (JPanel) c.getConstructor().newInstance();
            return panel;
        } catch (NoSuchMethodException | SecurityException
                | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
