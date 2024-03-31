package pegasus.jbs.economy;

import pegasus.jbs.JBS;
import pegasus.jbs.component.JBSComponent;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

/**
 * Represents the economy of the server.
 */
public final class Economy implements JBSComponent {
    //
    // Variables
    //

    /**
     * The set of economic actors.
     */
    private final Set<EconomyActor> actors;

    //
    // Constructors
    //

    /**
     * Creates an empty economy.
     */
    public Economy() {
        this.actors = new HashSet<>();
    }

    //
    // Actors
    //

    /**
     * Returns a stream of the economic actors.
     *
     * @return A stream of the economic actors
     */
    public Stream<EconomyActor> getActors() {
        return actors.stream();
    }

    /**
     * Adds an actor to this economy.
     *
     * @param actor The actor to add
     * @throws NullPointerException     When the provided actor is {@code null}
     * @throws IllegalArgumentException When the actor is already registered
     */
    public void addActor(EconomyActor actor) {
        if (!actors.add(
                Objects.requireNonNull(actor, "Cannot add null actor."))
        ) throw new IllegalArgumentException("Actor already registered.");
    }

    /**
     * Removes an actor from this economy.
     *
     * @param actor The actor to remove
     * @throws NoSuchElementException When the actor is not registered
     */
    public void removeActor(EconomyActor actor) {
        if (!actors.remove(actor)) throw new NoSuchElementException("Actor not found.");
    }

    //
    // IO
    //

    private static final String path = JBS.savePath + "/economy.yml";

    @Override
    public void load() throws IOException {
        var file = new File(path);

        if (!file.exists()) {
            // Default economy state

            var server = new ServerActor(
                    UUID.randomUUID(),
                    "자본주의서버",
                    1000000000000d
            );

            addActor(server);
        }
    }

    @Override
    public void save() throws IOException {

    }
}
