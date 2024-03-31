package pegasus.jbs.economy;

import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * The actor which represents an in-game player.
 */
public class PlayerActor implements EconomyActor {
    protected final UUID uniqueId;
    protected String name;
    protected double cash;

    /**
     * Creates a new player actor.
     *
     * @param uniqueId The unique identifier of this actor
     * @param name     The name of this actor
     * @param cash     The cash balance of this actor
     */
    public PlayerActor(UUID uniqueId, String name, double cash) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.cash = cash;
    }

    /**
     * Creates a new player actor.
     *
     * @param player The player to represent
     * @param cash   The cash balance
     */
    public PlayerActor(Player player, double cash) {
        this(player.getUniqueId(), player.getName(), cash);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public UUID getUniqueId() {
        return uniqueId;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this player.
     *
     * @param name The name of this player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public double getCash() {
        return cash;
    }

    /**
     * {@inheritDoc}
     *
     * @param cash The cash balance of this actor
     */
    @Override
    public void setCash(double cash) {
        this.cash = cash;
    }

    /**
     * Returns the string representation of this player.
     *
     * @return The string representation of this player
     */
    @Override
    public String toString() {
        return "PlayerActor{" +
                "uniqueId=" + uniqueId +
                ", name='" + name + '\'' +
                ", cash=" + cash +
                '}';
    }
}
