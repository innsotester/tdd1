# Ticket workflow TDD

# step1
The following yaml file contains description of a workflow
```yaml
- states:
  - action : WORK
    initialState: START
    finalState: INPROGRESS
    rights:
      - TICKET_START
      - TICKET_FULL
  - action : COMPLETE      
    initialState: INPROGRESS
    finalState: COMPLETED
    rights:
      - TICKET_COMPLETE
      - TICKET_FORCE_COMPLETE
      - TICKET_FULL  
  - action : ONHOLD        
    initialState: INPROGRESS
    finalState: PENDING
    rights:
      - TICKET_PENDING
      - TICKET_FULL
  - action : CANCEL          
    initialState: INPROGRESS
    finalState: CANCEL
    rights:
      - TICKET_CANCEL
      - TICKET_FULL
```

## Features

- as an Agent (having correct right) I submit an action for a ticket (of a given correct state), ticket status is changed to final state
- if right is not correct for the workflow : error is returned (not allowed)
- if a flow not possible (no matching initialState) : error is returned (cannot execute action)

# step2

yaml file contains also options (check is done if agent has correct options to execute the flows)

```yaml
- states:
  - action : WORK
    initialState: START
    finalState: INPROGRESS
    rights:
      - TICKET_START
      - TICKET_FULL
    options:
      - hasSkill : true
      - hasCaseGroup : false                       
  - action : COMPLETE      
    initialState: INPROGRESS
    finalState: COMPLETED
    rights:
      - TICKET_COMPLETE
      - TICKET_FORCE_COMPLETE
      - TICKET_FULL  
  - action : ONHOLD        
    initialState: INPROGRESS
    finalState: PENDING
    rights:
      - TICKET_PENDING
      - TICKET_FULL
    options:
      - isAssignee : true           
  - action : CANCEL          
    initialState: INPROGRESS
    finalState: CANCEL
    rights:
      - TICKET_CANCEL
      - TICKET_FULL
    options:
      - isCreator : true            
```

## Features

- options are tested and must be valid for the agent executing the action. If option is invalid (or not correct values) error is returned : "agent has not valid option"