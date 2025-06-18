package com.tdd.model;

import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;

import com.tdd.YamlParser;

public class WorkflowParser {
	public Workflow fromYaml(String path) {
		Yaml yaml = new Yaml();
		try (InputStream in = YamlParser.class.getClassLoader().getResourceAsStream(path)) {
			return yaml.loadAs(in, Workflow.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
