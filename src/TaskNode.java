package cpm.src;

import java.util.Iterator;
import java.util.HashSet;

public class TaskNode
{
    private HashSet<TaskNode> successors;
    private HashSet<TaskNode> predecessors;
    private String name;
    private int value;
    private int earlyStart;
    private int earlyFinish;
    private int lateFinish;
    private int lateStart;

    public TaskNode()
    {
        super();
        successors = new HashSet<TaskNode>();
        predecessors = new HashSet<TaskNode>();
    }

    public TaskNode(String name, int value)
    {
        this.name = name;
        this.value = value;
        successors = new HashSet<TaskNode>();
        predecessors = new HashSet<TaskNode>();
    }

    public HashSet<TaskNode> getSucessors()
    {
        return successors;
    }

    public HashSet<TaskNode> getPredecessors()
    {
        return predecessors;
    }

    public String getName()
    {
        return name;
    }

    public int getValue()
    {
        return value;
    }

    public int getEarlyStart()
    {
        return earlyStart;
    }

    public int getEarlyFinish()
    {
        return earlyFinish;
    }

    public int getLateFinish()
    {
        return lateFinish;
    }

    public int getLateStart()
    {
        return lateStart;
    }

    public boolean addSuccessor(TaskNode successors)
    {
        if (successors.add(successor))
        {
            successor.addPredecessor(this);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean addPredecessor(TaskNode predecessor)
    {
        if (predecessors.add(predecessor))
        {
            predecessor.addSuccessor(this);
            return true;
        }
        else
        {
            return false;
        }
        
    }

    public boolean removeSuccessor(TaskNode successor)
    {
        if (successors.remove(successor))
        {
            successor.removePredecessor(this);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean removePredecessor(TaskNode predecessor)
    {
        if (predecessors.remove(predecessor))
        {
            predecessor.removeSuccessor(this);
            return true;
        }
        else
        {
            return false;
        }
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public void setEarlyStart(int earlyStart)
    {
        this.earlyStart = earlyStart;
    }

    public void setEarlyFinish(int earlyFinish)
    {
        this.earlyFinish = earlyFinish;
    }

    public void setLateFinish(int lateFinish)
    {
        this.lateFinish = lateFinish;
    }

    public void setLateStart(int lateStart)
    {
        this.lateStart = lateStart;
    }

    public void printSuccessors()
    {
        Iterator<TaskNode> iterator = successors.iterator();
        while (iterator.hasNext())
        {
            TaskNode neighbor = iterator.next();
            System.out.printf("Name:\t%s\tValue:\t%s\n", neighbor.getName(), neighbor.getValue());
        }
    }

    public void printPredecessors()
    {
        Iterator<TaskNode> iterator = predecessors.iterator();
        while (iterator.hasNext())
        {
            TaskNode neighbor = iterator.next();
            System.out.printf("Name:\t%s\tValue:\t%s\n", neighbor.getName(), neighbor.getValue());
        }
    }

}