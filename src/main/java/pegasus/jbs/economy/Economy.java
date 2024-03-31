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
    // Logic
    //

    private static final long creditScoreRange = JBS.maximumCreditScore - JBS.minimumCreditScore;

    private static final long creditScore90 = Math.round((double) creditScoreRange * 0.9);
    private static final long creditScore80 = Math.round((double) creditScoreRange * 0.8);
    private static final long creditScore60 = Math.round((double) creditScoreRange * 0.6);
    private static final long creditScore40 = Math.round((double) creditScoreRange * 0.4);
    private static final long creditScore20 = Math.round((double) creditScoreRange * 0.2);

    /**
     * Clamps the credit score of the provided actor.
     * @param actor The actor
     */
    public static void clampCreditScore(EconomyActor actor) {
        var score = actor.getCreditScore();
        var min = JBS.minimumCreditScore;
        var max = JBS.maximumCreditScore;

        if (score > max) actor.setCreditScore(max);
        if (score < min) actor.setCreditScore(min);
    }

    /**
     * Increments the credit score of the provided actor.
     * @param actor The actor
     */
    public static void incrementCreditScore(EconomyActor actor) {
        var score = actor.getCreditScore();

        if (score >= creditScore90) {
            actor.setCreditScore(score + 1);
        } else if (score >= creditScore80) {
            actor.setCreditScore(score + 3);
        } else if (score >= creditScore60) {
            actor.setCreditScore(score + 4);
        } else if (score >= creditScore40) {
            actor.setCreditScore(score + 3);
        } else if (score >= creditScore20) {
            actor.setCreditScore(score + 2);
        } else {
            actor.setCreditScore(score + 1);
        }

        clampCreditScore(actor);
    }

    /**
     * Decrements the credit score of the provided actor.
     * @param actor The actor
     */
    public static void decrementCreditScore(EconomyActor actor) {
        var score = actor.getCreditScore();

        if (score >= creditScore90) {
            actor.setCreditScore(score - 1);
        } else if (score >= creditScore80) {
            actor.setCreditScore(score - 2);
        } else if (score >= creditScore60) {
            actor.setCreditScore(score - 4);
        } else if (score >= creditScore40) {
            actor.setCreditScore(score - 8);
        } else if (score >= creditScore20) {
            actor.setCreditScore(score - 10);
        } else {
            actor.setCreditScore(score - 50);
        }

        clampCreditScore(actor);
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
