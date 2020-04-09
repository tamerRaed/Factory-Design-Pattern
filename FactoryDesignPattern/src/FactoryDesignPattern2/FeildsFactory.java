package FactoryDesignPattern2;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FeildsFactory {

    public static Map<Integer, Class> m = new HashMap<>();

    static {
        File f = new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\DesignPatternAssignments\\src\\designpatternassignments\\FactoryDesignPattern2\\Feilds");
        File[] files = f.listFiles();
        int i = 1;
        for (File file : files) {
            String className = file.getName().split("\\.")[0];
            Class c = null;
            try {
                c = Class.forName("designpatternassignments.FactoryDesignPattern2.Feilds." + className);
                m.put(i, c);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            i++;
        }
    }
}
