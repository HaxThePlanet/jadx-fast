# Agent Task Claims

This directory is used for multi-agent coordination.

## How It Works

Before starting a task, agents create a claim file:
```
TASK_NAME.claim
```

Contents should be:
```
CLAIMED by agent-TIMESTAMP at DATE
Working on: Brief description
```

## Rules

1. **Check before claiming** - If `.claim` file exists, pick different task
2. **Claim before working** - Prevents duplicate work
3. **Remove when done** - Delete claim file after task complete
4. **Commit claims** - Push claim/unclaim to git immediately

## Current Claims

Check with: `ls *.claim`
