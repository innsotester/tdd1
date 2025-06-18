package com.tdd;


import com.tdd.model.ActionEnum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tdd.model.WorkflowParser;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class WorkflowParserTest {
	@Test
	void test_fromYaml() {
		var workflowParser = new WorkflowParser();
		var workflow = workflowParser.fromYaml("workflow.yaml");
		assertThat(workflow.getWorkflowAction()).hasSize(4);

		var action1 = workflow.getWorkflowAction().get(0);

		assertThat(action1.getAction()).isEqualTo(ActionEnum.WORK);
		assertThat(action1.getInitialState()).isEqualTo("START");
		assertThat(action1.getFinalState()).isEqualTo("INPROGRESS");
		assertThat(action1.getRights()).hasSize(2);
		assertThat(action1.getRights()).first().isEqualTo("TICKET_START");
		assertThat(action1.getRights()).last().isEqualTo("TICKET_FULL");

	}
}
