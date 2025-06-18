package com.tdd;

import com.tdd.model.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WorkflowSubmitterTest {

    @Test
    public void submitTicketStart_forAction_WORK() {
        // given
        WorkflowSubmitter workflowSubmitter = new WorkflowSubmitter();
        Ticket ticket = new Ticket();
        ticket.setState(TicketEnum.START);
        Agent agent = new Agent();
        agent.setRole("TICKET_START");
        var action = ActionEnum.WORK;

        WorkflowParser parser = new WorkflowParser();
        var workflow = parser.fromYaml("workflow.yaml");

        // when
        workflowSubmitter.submit(agent, ticket, action, workflow);

        // then
        assertThat(ticket.getState()).isEqualTo(TicketEnum.INPROGRESS);
    }

}