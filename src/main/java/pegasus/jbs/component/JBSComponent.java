package pegasus.jbs.component;

import java.io.IOException;

/**
 * A JBS Component.
 */
public interface JBSComponent {
    /**
     * Attempts to load data.
     */
    void load() throws IOException;

    /**
     * Attempts to save data.
     */
    void save() throws IOException;
}
