package pegasus.jbs.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * JBS event base class.
 */
public abstract class JBSEvent extends Event {
    /**
     * The handler list.
     */
    private static final HandlerList handlers = new HandlerList();

    /**
     * Returns the handler list.
     *
     * @return The handler list
     */
    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    /**
     * Default constructor.
     */
    public JBSEvent() {
    }

    /**
     * Async constructor.
     *
     * @param isAsync {@code true} if this event is async
     */
    public JBSEvent(boolean isAsync) {
        super(isAsync);
    }
}
