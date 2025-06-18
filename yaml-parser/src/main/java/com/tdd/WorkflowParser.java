package com.tdd;

import java.io.InputStream;

import com.tdd.model.Workflow;
import org.yaml.snakeyaml.Yaml;

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
