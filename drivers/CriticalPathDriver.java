package cpm.drivers;

import cpm.src.CriticalPath;
import cpm.src.TaskNode;
// 8 6 4 7 3 2 5 
public class CriticalPathDriver
{
    public static void main(String[] args)
    {
        // Create project tasks
        TaskNode taskA = new TaskNode("A", 8);
        TaskNode taskB = new TaskNode("B", 6);
        TaskNode taskC = new TaskNode("D", 4);
        TaskNode taskD = new TaskNode("A", 7);
        TaskNode taskE = new TaskNode("B", 3);
        TaskNode taskF = new TaskNode("D", 2);
        TaskNode taskG = new TaskNode("G", 5);

        // Add successors for each task
        taskA.addSuccessor(taskB);
        taskA.addSuccessor(taskD);

        taskB.addSuccessor(taskG)

        // CriticalPath.calculateES(taskA);
    }
}