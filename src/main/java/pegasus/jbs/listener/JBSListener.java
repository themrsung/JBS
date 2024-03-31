package pegasus.jbs.listener;

import org.bukkit.event.Listener;
import pegasus.jbs.JBS;

/**
 * JBS listener base class.
 */
public abstract class JBSListener implements Listener {
    /**
     * The server.
     */
    protected final JBS server;

    /**
     * Creates a new listener.
     *
     * @param server A reference to the parent server
     */
    public JBSListener(JBS server) {
        this.server = server;
    }
}
