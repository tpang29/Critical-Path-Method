import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

public class TaskNode implements Comparable<TaskNode>
{ 
    private Set<TaskNode> successors;
    private Set<TaskNode> predecessors;
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

    public Set<TaskNode> getSucessors()
    {
        return successors;
    }

    public Set<TaskNode> getPredecessors()
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

    public boolean hasSlack()
    {
        return !(((lateFinish - earlyFinish) == 0) || ((lateStart - earlyStart) == 0));
    }

    public void addSuccessors(TaskNode... successors)
    {
        for (TaskNode successor : successors)
        {
            if (this.successors.add(successor))
            {
                successor.predecessors.add(this);
            }
        }
    }

    public void removeSuccessors(TaskNode... successors)
    {
        for (TaskNode successor : successors)
        {
            if (this.successors.remove(successor))
            {
                successor.predecessors.remove(this);
            }
        }
    }

    public void addPredecessors(TaskNode... predecessors)
    {
        for (TaskNode predecessor : predecessors)
        {
            if (this.predecessors.add(predecessor))
            {
                predecessor.successors.add(this);
            }
        }
    }

    public void removePredecessors(TaskNode... predecessors)
    {
        for (TaskNode predecessor : predecessors)
        {
            if (this.predecessors.remove(predecessor))
            {
                predecessor.successors.remove(this);
            }
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

    @Override
    public int compareTo(TaskNode o)
    {
        return this.getName().compareTo(o.getName());
    }

}