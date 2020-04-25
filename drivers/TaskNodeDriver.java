package cpm.drivers;

import cpm.src.TaskNode;

public class TaskNodeDriver
{
    public static void main(String[] args)
    {
        TaskNode taskA = new TaskNode("A", 8);
        TaskNode taskB = new TaskNode("B", 6);
        TaskNode taskD = new TaskNode("D", 7);
        TaskNode[] tasks = {taskA, taskB, taskD};
    }
}