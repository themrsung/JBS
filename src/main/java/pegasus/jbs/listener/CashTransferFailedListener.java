package pegasus.jbs.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import pegasus.jbs.JBS;
import pegasus.jbs.event.CashTransferFailedEvent;

/**
 * Listener for {@link CashTransferFailedEvent}.
 */
public class CashTransferFailedListener extends JBSListener {
    public CashTransferFailedListener(JBS server) {
        super(server);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPaymentFailed(CashTransferFailedEvent event) {

    }
}
