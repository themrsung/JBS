package pegasus.jbs.economy;

import java.util.UUID;

/**
 * An economic actor.
 */
public interface EconomyActor {
    //
    // ID
    //

    /**
     * Returns the unique identifier of this actor.
     *
     * @return The unique identifier of this actor
     */
    UUID getUniqueId();

    /**
     * Returns the name of this actor.
     *
     * @return The name of this actor
     */
    String getName();

    //
    // Cash
    //

    /**
     * Returns the cash balance of this actor.
     *
     * @return The cash balance of this actor
     */
    double getCash();

    /**
     * Sets the cash balance of this actor.
     *
     * @param cash The cash balance of this actor
     */
    void setCash(double cash);
}
