package com.tdd.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class WorkflowAction {
	private String action;
	private String initialState;
	private String finalState;
	private List<String> rights;
}
