package com.tdd;

import com.tdd.model.*;

public class WorkflowSubmitter {


    public void submit(Agent agent, Ticket ticket, ActionEnum action, Workflow workflow) {
        workflow.getWorkflowAction().forEach(workflowAction -> {
            if (workflowAction.getAction().equals(action)) {
                ticket.setState(workflowAction.getFinalState());
            }
        });
    }
}
