package com.tdd;

import com.tdd.model.Person;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class YamlParser {
    public static void main(String[] args) {
        Yaml yaml = new Yaml();
        try (InputStream in = YamlParser.class.getClassLoader().getResourceAsStream("test.yaml")) {
            Map<String, Object> obj = yaml.load(in);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        yaml = new Yaml();
        try (InputStream in = YamlParser.class.getClassLoader().getResourceAsStream("person.yaml")) {
            Person p = yaml.loadAs(in, Person.class);
            System.out.println(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
