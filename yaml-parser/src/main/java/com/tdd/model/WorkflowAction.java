package com.tdd.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class WorkflowAction {
	private ActionEnum action;
	private TicketEnum initialState;
	private TicketEnum finalState;
	private List<String> rights;
}
