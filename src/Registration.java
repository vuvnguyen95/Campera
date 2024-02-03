package src;

import java.util.UUID;

public class Registration {

    private UUID id;
    protected UUID campID;
    protected UUID camperID;
    protected Double price;

    public Registration(UUID campID, UUID camperID, Double price) {
        this.id = UUID.randomUUID();
        this.campID = campID;
        this.camperID = camperID;
        this.price = price;
    }

    /**
     * Default Registration constructor with UUID
     * @param id
     * @param campID
     * @param camperID
     * @param price
     */

    public Registration(UUID id, UUID campID, UUID camperID, Double price)
    {
        this.id = id;
        this.campID = campID;
        this.camperID = camperID;
        this.price = price;
    }  

    /**
     * Getter method for id
     * @return id
     */
    public UUID getID()
    {
        return this.id;
    }

    /**
     * Getter method for campID
     * @return campID
     */
    public UUID getCampID()
    {
        return this.campID;
    }

    /**
     * Getter method for camperID
     * @return camperID
     */
    public UUID getCamperID()
    {
        return this.camperID;
    }

    /**
     * getter method for price of registration
     * @return price
     */
    public Double getPrice()
    {
        return this.price;
    }

}
