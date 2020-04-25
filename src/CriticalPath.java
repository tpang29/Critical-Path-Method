package cpm.src;

import cpm.src.TaskNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CriticalPath
{

    public CriticalPath()
    {
        super();
    }

    /* Prints the critical path for a given start node */
    public static void printCriticalPath(TaskNode startNode)
    {
        // 1. calculate all ES
        // calculateES(startNode);

        // 2. calculate all EF
        // 3. calcuate all LF
        // 4. calculate all LS
    }

    public static void calculateES(TaskNode startNode)
    {
        Queue<TaskNode> queue = new LinkedList<TaskNode>();

        startNode.setEarlyFinish(0);
        queue.add(startNode);

        while (!queue.isEmpty())
        {
            TaskNode current = queue.remove();
            Iterator<TaskNode> neighbors = current.getSucessors().iterator();

            while (neighbors.hasNext())
            {
                TaskNode neighbor = neighbors.next();
                queue.add(neighbor);

                int earlyStart = current.getEarlyStart() + current.getValue();

                if (neighbor.getEarlyStart() < earlyStart)
                {
                    neighbor.setEarlyStart(earlyStart);
                    System.out.printf("Early Start for Task %s: %d\n", neighbor.getName(), neighbor.getEarlyStart());
                }
            }
        }
    }

    /* Prints a project matrix */
    public static void printProjectMatrix()
    {
        return;
    }

    
}