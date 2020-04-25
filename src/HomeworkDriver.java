public class HomeworkDriver
{
    public static void main(String[] args)
    {
        // Define task nodes presented in diagram
        TaskNode taskA = new TaskNode("A", 8);
        TaskNode taskB = new TaskNode("B", 60);
        TaskNode taskC = new TaskNode("C", 15);
        TaskNode taskD = new TaskNode("D", 60);
        TaskNode taskE = new TaskNode("E", 9);
        TaskNode taskF = new TaskNode("F", 38);
        TaskNode taskG = new TaskNode("G", 4);
        TaskNode taskH = new TaskNode("H", 10);
        TaskNode taskI = new TaskNode("I", 30);
        TaskNode taskJ = new TaskNode("J", 42);

        // Set directional edges
        taskA.addSuccessors(taskB, taskH, taskG);
        taskB.addSuccessors(taskC, taskH);
        taskC.addSuccessors(taskD, taskE);
        taskD.addSuccessors(taskE);
        taskE.addSuccessors(taskF);
        taskG.addSuccessors(taskH, taskI, taskJ);
        taskH.addSuccessors(taskC, taskD, taskI);
        taskI.addSuccessors(taskD, taskE);
        taskJ.addSuccessors(taskI);

        // Calculate the critical path and output table
        CriticalPath.calculate(taskA, taskF);
    }
}