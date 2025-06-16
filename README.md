# Ticket workflow TDD

# step1
The following yaml file contains description of a workflow
```yaml
- states:
  - initialState: START
    finalState: INPROGRESS
    rights:
      - TICKET_START
      - TICKET_FULL
  - initialState: INPROGRESS
    finalState: COMPLETED
    rights:
      - TICKET_COMPLETE
      - TICKET_FORCE_COMPLETE
      - TICKET_FULL    
  - initialState: INPROGRESS
    finalState: PENDING
    rights:
      - TICKET_PENDING
      - TICKET_FULL    
  - initialState: INPROGRESS
    finalState: CANCEL
    rights:
      - TICKET_CANCEL
      - TICKET_FULL
```

## Features

- as an Agent (having correct roles) I submit a ticket (of a given state) to final state for this workflow, no error , ticlet status is changed to final state
- if role not correct for the workflow : error is returned (not allowed)
- if a flow not possible (no matching initialState / finalState) : error is returned (unknow flow)
- a ticket can use many flows described for one submit, I want ticket state A to final state C (workflow found A -> B and B -> C)

# step2

yaml file contains also actions (methods called with values) to process when workflow is submitted

```yaml
- states:
  - initialState: START
    finalState: INPROGRESS
    rights:
      - TICKET_START
      - TICKET_FULL
    actions:
      - start
        - ticketId
  - initialState: INPROGRESS
    finalState: COMPLETED
    rights:
      - TICKET_COMPLETE
      - TICKET_FORCE_COMPLETE
      - TICKET_FULL
    actions:
      - complete
        - ticketId
        - date
  - initialState: INPROGRESS
    finalState: PENDING
    rights:
      - TICKET_PENDING
      - TICKET_FULL
    actions:
      - pending
        - ticketId
        - agentId
        - date
  - initialState: INPROGRESS
    finalState: CANCEL
    rights:
      - TICKET_CANCEL
      - TICKET_FULL
    actions:
      - warn
      - cancel
        - ticketId
```

## Features

- actions are executed in the order of the array with given parameter, if an action or value not found, error is returned