package pegasus.jbs.event;

import org.bukkit.event.Cancellable;
import pegasus.jbs.economy.EconomyActor;

/**
 * An event where cash is transferred between economic actors.
 */
public final class CashTransferEvent extends JBSEvent implements Cancellable {
    /**
     * The sender.
     */
    public final EconomyActor sender;

    /**
     * The recipient.
     */
    public final EconomyActor recipient;

    /**
     * The payment amount.
     */
    public final double payment;

    /**
     * Whether this event has been cancelled.
     */
    private boolean cancelled = false;

    /**
     * Creates a new cash transfer event.
     *
     * @param sender    The sender
     * @param recipient The recipient
     * @param payment   The payment amount
     */
    public CashTransferEvent(EconomyActor sender, EconomyActor recipient, double payment) {
        this.sender = sender;
        this.recipient = recipient;
        this.payment = payment;
    }

    /**
     * Returns whether this event has been cancelled.
     *
     * @return {@code true} if this event has been cancelled
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Sets whether this event has been cancelled.
     *
     * @param cancelled {@code true} to cancel this event
     */
    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
