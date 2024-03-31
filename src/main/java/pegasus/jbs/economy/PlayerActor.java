package pegasus.jbs.economy;

import org.bukkit.entity.Player;
import pegasus.jbs.JBS;

import java.util.UUID;

/**
 * The actor which represents an in-game player.
 */
public class PlayerActor implements EconomyActor {
    protected final UUID uniqueId;
    protected String name;
    protected double cash;
    protected long creditScore;

    /**
     * Creates a new player actor.
     *
     * @param uniqueId    The unique identifier of this actor
     * @param name        The name of this actor
     * @param cash        The cash balance of this actor
     * @param creditScore The credit score
     */
    public PlayerActor(UUID uniqueId, String name, double cash, long creditScore) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.cash = cash;
    }

    /**
     * Creates a new player actor.
     *
     * @param player The player to represent
     * @param cash   The cash balance
     * @param creditScore The credit score
     */
    public PlayerActor(Player player, double cash, long creditScore) {
        this(player.getUniqueId(), player.getName(), cash, creditScore);
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
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public long getCreditScore() {
        return creditScore;
    }

    /**
     * {@inheritDoc}
     * @param creditScore The credit score of this actor
     */
    @Override
    public void setCreditScore(long creditScore) {
        this.creditScore = creditScore;
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
                ", creditScore=" + creditScore +
                '}';
    }
}
