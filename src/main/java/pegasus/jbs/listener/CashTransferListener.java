package pegasus.jbs.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import pegasus.jbs.JBS;
import pegasus.jbs.economy.ServerActor;
import pegasus.jbs.event.CashTransferEvent;

/**
 * Listener for {@link CashTransferEvent}.
 */
public class CashTransferListener extends JBSListener {
    public CashTransferListener(JBS server) {
        super(server);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onCashTransferred(CashTransferEvent event) {
        if (event.isCancelled()) return;

        // Balance check (ignore if sender is server)
        if (event.sender.getCash() < event.payment && !(event.sender instanceof ServerActor)) {
            // Payment failed
            return;
        }

        // Take money from sender
        event.sender.setCash(event.sender.getCash() - event.payment);

        // Give money to recipient
        event.recipient.setCash(event.recipient.getCash() + event.payment);
    }
}
