package pegasus.jbs.economy;

import pegasus.jbs.JBS;

import java.util.UUID;

/**
 * The actor which represents the server. There is no minimum balance.
 */
public class ServerActor implements EconomyActor {
    protected final UUID uniqueId;
    protected final String name;
    protected double cash;

    /**
     * Creates a new server actor.
     *
     * @param uniqueId The unique identifier of this actor
     * @param name     The name of this actor
     * @param cash     The cash balance of this actor
     */
    public ServerActor(UUID uniqueId, String name, double cash) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.cash = cash;
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
        return JBS.maximumCreditScore;
    }

    /**
     * {@inheritDoc}
     * @param creditScore The credit score of this actor
     */
    @Override
    public void setCreditScore(long creditScore) {
        // Do nothing
    }

    /**
     * Returns the string representation of this server.
     *
     * @return The string representation of this server
     */
    @Override
    public String toString() {
        return "ServerActor{" +
                "uniqueId=" + uniqueId +
                ", name='" + name + '\'' +
                ", cash=" + cash +
                '}';
    }
}
