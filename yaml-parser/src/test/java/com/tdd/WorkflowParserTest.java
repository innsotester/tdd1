package com.tdd;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tdd.model.WorkflowParser;

class WorkflowParserTest {
	@Test
	void test_fromYaml() {
		var workflowParser = new WorkflowParser();
		var workflow = workflowParser.fromYaml("workflow.yaml");
		Assertions.assertThat(workflow).hasSize(4);
	}
}
