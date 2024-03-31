package pegasus.jbs;

import org.bukkit.plugin.java.JavaPlugin;
import pegasus.jbs.economy.Economy;

import java.io.File;
import java.io.IOException;

public final class JBS extends JavaPlugin {
    //
    // Constants
    //

    /**
     * The path to save data.
     */
    public static final String savePath = "plugins/jbs";

    /**
     * The minimum credit score.
     */
    public static final long minimumCreditScore = 0;

    /**
     * The maximum credit score.
     */
    public static final long maximumCreditScore = 1000;

    //
    // Components
    //

    /**
     * The economy.
     */
    private static final Economy economy = new Economy();

    //
    // Logic
    //

    /**
     * Plugin startup.
     */
    @Override
    public void onEnable() {
        getLogger().info("Loading JBS...");

        createPluginDirectory();

        loadEconomy();
    }

    /**
     * Plugin shutdown.
     */
    @Override
    public void onDisable() {

    }

    //
    // Getters
    //

    /**
     * Returns the economy.
     *
     * @return The economy
     */
    public static Economy getEconomy() {
        return economy;
    }

    //
    // Inline
    //

    private void createPluginDirectory() {
        var path = new File(savePath);

        if (path.exists()) return;
        if (!path.mkdirs()) throw new RuntimeException("Failed to create plugin directory.");
    }

    private void loadEconomy() {
        try {
            economy.load();
        } catch (IOException e) {
            getLogger().warning("Error loading economy: " + e.getMessage());
        }
    }
}
