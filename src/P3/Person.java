package P3;

import java.util.HashSet;
import java.util.Set;

public class Person {
    // Branch B2-edit code
    // name of current object(Person)
    private final String name;
    // all vertex(person) current person links to in the Friendship Graph.
    private final Set<Person> child = new HashSet<Person>();

    /**
     * Construction Function
     *
     * @param newName string, the initialized name of this new object.
     */
    public Person(String newName){
        this.name = newName;
    }

    /**
     * When adding a directed edge from current object to another object "newPerson",
     * this method functions, add newPerson to hashset "child" of current person.
     *
     * @param newPerson the vertex(person) that current object links to on the directed edge to add.
     */
    public void addChild(Person newPerson){
        child.add(newPerson);
    }

    /**
     * Get all vertex(object) that the current object links to.
     *
     * @return A hashset contains all the vertex(person) current person links to.
     */
    public Set<Person> getChild(){
        return this.child;
    }

    /**
     * Get the name of current object.
     *
     * @return String, the name of current object.
     */
    public String getName(){
        return name;
    }
    public String generateChildList(){
        StringBuilder res = new StringBuilder(getName().trim() + ", link to:");
        if(!getChild().isEmpty())
        {
            for(Person per:getChild()){
                res.append(" ").append(per.getName());
            }
            res.append(".");
        }
        else res.append("NULL");
        return res.toString();
    }
}
