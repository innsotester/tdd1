package com.tdd.model;

import java.io.InputStream;
import java.util.List;

import org.yaml.snakeyaml.Yaml;

import com.tdd.YamlParser;
import org.yaml.snakeyaml.constructor.Constructor;

public class WorkflowParser {
	public Workflow fromYaml(String path) {
//		Yaml yaml = new Yaml(new Constructor(Workflow.class));
		Yaml yaml = new Yaml();
		try (InputStream in = YamlParser.class.getClassLoader().getResourceAsStream(path)) {
			return yaml.loadAs(in, Workflow.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
