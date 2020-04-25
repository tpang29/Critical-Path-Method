package cpm.src;

import cpm.src.TaskNode;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
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
    public static void calculate(TaskNode start, TaskNode end)
    {
        List<TaskNode> tasks = getUniqueTasks(start);

        // 1. calculate all ES
        calculateES(start);

        // 2. calculate all EF
        calculateEF(tasks);

        // 3.0 give LF to all nodes
        setLateFinishUpperBound(tasks, end);

        // 3.1 calcuate all LF
        calculateLF(end);

        // 4. calculate all LS
        calculateLS(tasks);

        // Print final matrix
        printProjectMatrix(tasks);
    }

    private static void calculateLS(List<TaskNode> tasks)
    {
        for (TaskNode task : tasks)
        {
            task.setLateStart(task.getLateFinish() - task.getValue());
        }      
    }

    private static void setLateFinishUpperBound(List<TaskNode> tasks, TaskNode end)
    {
        int lateFinish = end.getEarlyStart() + end.getValue();

        for (TaskNode task : tasks)
        {
            task.setLateFinish(lateFinish);
        }
    }

    private static void calculateLF(TaskNode end)
    {
        Queue<TaskNode> queue = new LinkedList<TaskNode>();

        queue.add(end);

        while (!queue.isEmpty())
        {
            TaskNode current = queue.remove();
            Iterator<TaskNode> neighbors = current.getPredecessors().iterator();

            while (neighbors.hasNext())
            {
                TaskNode neighbor = neighbors.next();
                queue.add(neighbor);

                int lateFinish = current.getLateFinish() - current.getValue();

                if (neighbor.getLateFinish() > lateFinish)
                {
                    neighbor.setLateFinish(lateFinish);
                }
            }
        }
    }

    private static void calculateEF(List<TaskNode> tasks)
    {
        for (TaskNode task : tasks)
        {
            task.setEarlyFinish(task.getEarlyStart() + task.getValue());
        }
    }



    private static void calculateES(TaskNode start)
    {
        Queue<TaskNode> queue = new LinkedList<TaskNode>();

        start.setEarlyFinish(0);
        queue.add(start);

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
                }
            }
        }
    }

    /* Prints a project matrix */
    private static void printProjectMatrix(List<TaskNode> tasks)
    {
        // Table format and row separators
        String dottedLine = "-----------------------------------------------------------------";
        String lineFormat = ("%c%6s\t%c%6s\t%c%6s\t%c%6s\t%c%6s\t%c%6s\t%c%6s\t%c%6s\t%c\n").replace("%c", "|"); 

        // Print header
        System.out.println(dottedLine);
        System.out.printf(lineFormat, "Task", "Value", "ES", "EF", "LF", "LS", "LS-ES", "LF-EF");
        System.out.println(dottedLine);


        // print table body
        for (TaskNode task : tasks)
        {
            System.out.printf(lineFormat, 
                task.getName(), task.getValue(),
                task.getEarlyStart(), task.getEarlyFinish(), 
                task.getLateFinish(), task.getLateStart(), 
                (task.getLateStart() - task.getEarlyStart()),
                (task.getLateFinish() - task.getEarlyFinish()));

            System.out.println(dottedLine);
        }
    }

    private static List<TaskNode> getUniqueTasks(TaskNode start)
    {
        // Store unique tasks
        Set<TaskNode> tasks = new HashSet<TaskNode>();

        // Hold all successors to add to set
        Queue<TaskNode> queue = new LinkedList<TaskNode>();
        
        tasks.add(start);
        queue.add(start);
        
        // Add successors to queue and set
        while (!queue.isEmpty())
        {
            TaskNode current = queue.remove();
            tasks.addAll(current.getSucessors());
            queue.addAll(current.getSucessors());
        }
        
        // Create and sort list of unique tasks
        List<TaskNode> sortedTasks = new ArrayList<TaskNode>(tasks);
        Collections.sort(sortedTasks);
        
        return sortedTasks;
    }

    
}