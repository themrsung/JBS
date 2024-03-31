package pegasus.jbs.event;

/**
 * Event initiated when payment is failed.
 */
public class CashTransferFailedEvent extends JBSEvent {
    /**
     * The payment event which has failed.
     */
    public final CashTransferEvent paymentEvent;

    /**
     * Creates a new payment failed event.
     *
     * @param paymentEvent The event which has failed
     */
    public CashTransferFailedEvent(CashTransferEvent paymentEvent) {
        this.paymentEvent = paymentEvent;
    }
}
