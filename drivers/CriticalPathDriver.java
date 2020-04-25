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
        TaskNode taskC = new TaskNode("C", 4);
        TaskNode taskD = new TaskNode("D", 7);
        TaskNode taskE = new TaskNode("E", 3);
        TaskNode taskF = new TaskNode("F", 2);
        TaskNode taskG = new TaskNode("G", 5);

        // Add successors for each task
        taskA.addSuccessors(taskB, taskD);

        taskB.addSuccessors(taskC, taskG);

        taskC.addSuccessors(taskF);

        taskD.addSuccessors(taskE, taskG);

        taskE.addSuccessors(taskF);

        taskG.addSuccessors(taskC, taskE, taskF);

        CriticalPath.calculate(taskA, taskF);

        TaskNode[] tasks = {taskA, taskB, taskC, taskD, taskE, taskF, taskG};
    }
}