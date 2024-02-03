package src;
import java.util.UUID;

/**
 * Base Activity Class Constructors
 */
public class Activity {

    private UUID id;
    public String name;
    public String description;

    public Activity(String name, String description) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
    }

    public Activity(UUID id, String name, String description)
    {
        this.id = id;
        this.name = name; 
        this.description = description;
    }
    
    /**
     * returns the value in the name attribute
     * @return
     */
    public String getName()
    {
        return this.name;
    }

    
    /** 
     * Get Name Method
     * Grabs name from camp to utillize activities
     * @return String
     */
    public String getDescription()
    {
        return this.description;
    }
    
    
    /** 
     * Get ID Method
     * Gets user ID to identify user for activity
     * @return UUID
     */
    public UUID getID()
    {
        return this.id;
    }

    /**
     * Setter method for the activity name
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    
    /** 
     * Set Description Method
     * @param description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**
     * returns the name of the activity
     */
    public String toString()
    {
        return getName();
    }
}
