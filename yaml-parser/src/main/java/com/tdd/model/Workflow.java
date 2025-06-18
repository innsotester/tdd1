package com.tdd.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class Workflow {
	private List<WorkflowAction> workflowAction;
}
