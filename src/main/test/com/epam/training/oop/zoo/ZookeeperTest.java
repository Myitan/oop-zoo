package com.epam.training.oop.zoo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import com.epam.training.oop.zoo.animals.Animal;
import com.epam.training.oop.zoo.animals.Antelope;
import com.epam.training.oop.zoo.animals.Hippo;
import com.epam.training.oop.zoo.animals.Lion;
import com.epam.training.oop.zoo.animals.Mandrill;
import com.epam.training.oop.zoo.animals.Rhino;
import com.epam.training.oop.zoo.animals.Zebra;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ZookeeperTest {

    private static final Zookeeper JOHN = new Zookeeper("John", Consumption.HERBIVORES);
    private static final Zookeeper JANE = new Zookeeper("Jane", Consumption.CARNIVORES, Consumption.OMNIVORES);

    private static final Animal ANTELOPE = new Antelope("Luna");
    private static final Animal HIPPO = new Hippo("Bubbles");
    private static final Animal LION = new Lion("Leo");
    private static final Animal MANDRILL = new Mandrill("Kaya");
    private static final Animal RHINO = new Rhino("Brutus");
    private static final Animal ZEBRA = new Zebra("Stripes");
    private static final String LEO_LION_ROAR = "Leo the Lion roars.";
    private static final String JANE_LEO_FEEDING = "Jane is feeding Leo the Lion";

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private Zookeeper underTest;

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Testing any zookeeper, when an empty array is given")
    void testFeedShouldProduceNoResultWhenGivenAnimalsArrayIsEmpty() {
        //GIVEN
        underTest = JANE;
        var animals = new Animal[]{};

        //WHEN
        underTest.feed(animals);
        var systemOutput = outputStreamCaptor.toString().trim();

        //THEN
        assertTrue(systemOutput.isEmpty());
    }

    @Test
    @DisplayName("Testing zookeeper John by giving food to [ Antelope, Hippo, Hippo, Lion ]")
    void testFeedShouldGiveFoodToAnimalsWithCorrectConsumptionType() {
        //GIVEN
        underTest = JOHN;
        var expectedOutput = "Luna the Antelope snorts." + System.lineSeparator() +
                "John is feeding Luna the Antelope" + System.lineSeparator() +
                "Bubbles the Hippo barks." + System.lineSeparator() +
                "John is feeding Bubbles the Hippo" + System.lineSeparator() +
                "Bubbles the Hippo barks." + System.lineSeparator() +
                "John is feeding Bubbles the Hippo";
        var animals = new Animal[]{ANTELOPE, HIPPO, HIPPO, LION};

        //WHEN
        underTest.feed(animals);
        var systemOutput = outputStreamCaptor.toString().trim();

        //THEN
        assertTrue(systemOutput.contains("John is feeding Luna the Antelope"),
                "Luna the Antelope wasn't given food");
        assertTrue(systemOutput.contains("Luna the Antelope snorts."),
                "Luna the Antelope didn't snort after being given food");
        assertTrue(systemOutput.contains("John is feeding Bubbles the Hippo"),
                "Bubbles the Hippo wasn't given food");
        assertTrue(systemOutput.contains("Bubbles the Hippo barks."),
                "Bubbles the Hippo didn't bark after being given food");
        assertFalse(systemOutput.contains("John is feeding Leo the Lion"),
                "Leo the Lion was given food");
        assertFalse(systemOutput.contains(LEO_LION_ROAR),
                "Leo the Lion roared when it didn't receive food");
        assertEquals(expectedOutput, systemOutput,
                "Output not in correct format, or feeding not ordered same as input");
    }

    @Test
    @DisplayName("Testing zookeeper Jane by giving food to multiple animals of same type [Lion, Lion, Lion]")
    void testFeedShouldGiveFoodToEachAnimalOfSameTypeAsWell() {
        //GIVEN
        underTest = JANE;
        var animals = new Animal[]{LION, LION, LION};
        var expectedOutput = LEO_LION_ROAR + System.lineSeparator() +
                JANE_LEO_FEEDING + System.lineSeparator() +
                LEO_LION_ROAR + System.lineSeparator() +
                JANE_LEO_FEEDING + System.lineSeparator() +
                LEO_LION_ROAR + System.lineSeparator() +
                JANE_LEO_FEEDING;

        //WHEN
        underTest.feed(animals);
        var systemOutput = outputStreamCaptor.toString().trim();

        //THEN
        assertTrue(systemOutput.contains("Jane is feeding Leo the Lion"),
                "Leo the Lion was not given food");
        assertTrue(systemOutput.contains("Leo the Lion roars."),
                "Leo the Lion did not roar after receiving food");
        assertEquals(expectedOutput, systemOutput,
                "Output not in correct format, or feeding did not happen as many times as expected");
    }

    @Test
    @DisplayName("Testing zookeeper John by trying to give food carnivores and omnivores [Lion, Lion, Mandrill]")
    void testFeedShouldNotGiveFoodToAnimalWithIncompatibleConsumptionType() {
        //GIVEN
        underTest = JOHN;
        var animals = new Animal[]{LION, LION, MANDRILL};

        //WHEN
        underTest.feed(animals);
        var systemOutput = outputStreamCaptor.toString().trim();

        //THEN
        assertFalse(systemOutput.contains("John is feeding Leo the Lion"),
                "Leo the Lion was given food");
        assertFalse(systemOutput.contains("Leo the Lion roars."),
                "Leo the Lion roared when it didn't receive food");
        assertEquals("", systemOutput,
                "Output not in correct format, or feeding not ordered same as input");
    }

    @ParameterizedTest
    @MethodSource("getZookeeperAndAnimalPairs")
    @DisplayName("Testing John and Jane separately by them giving food to different animals")
    void testFeedZookeeperShouldGiveFoodToSpecificAnimalWhenConsumptionMatches(
            Zookeeper testedZookeeper,
            Animal animal,
            boolean shouldReceiveFoodFromZookeeper
    ) {
        //GIVEN
        var singletonAnimal = new Animal[]{animal};
        //WHEN
        testedZookeeper.feed(singletonAnimal);
        var systemOutput = outputStreamCaptor.toString().trim();

        //THEN
        if (shouldReceiveFoodFromZookeeper) {
            assertReceivedFood(testedZookeeper, animal, systemOutput);
        } else {
            assertDidNotReceiveFood(testedZookeeper, animal, systemOutput);
        }
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    private void assertReceivedFood(Zookeeper testedZookeeper, Animal animal, String systemOutput) {
        var animalType = animal.getClass().getSimpleName();
        assertTrue(systemOutput.contains(testedZookeeper.getName() + " is feeding " + animal.getName() + " the " + animalType),
                animal.getName() + " the " + animalType + " was not given food by " + testedZookeeper.getName());
    }

    private void assertDidNotReceiveFood(Zookeeper testedZookeeper, Animal animal, String systemOutput) {
        var animalType = animal.getClass().getSimpleName();
        assertFalse(systemOutput.contains(animalType),
                animal.getName() + " the " + animalType + " was given food by " + testedZookeeper.getName());
    }

    static Stream<Arguments> getZookeeperAndAnimalPairs() {
        return Stream.of(
                Arguments.of(JOHN, ANTELOPE, true),
                Arguments.of(JOHN, HIPPO, true),
                Arguments.of(JOHN, LION, false),
                Arguments.of(JOHN, MANDRILL, false),
                Arguments.of(JOHN, RHINO, true),
                Arguments.of(JOHN, ZEBRA, true),
                Arguments.of(JANE, ANTELOPE, false),
                Arguments.of(JANE, HIPPO, false),
                Arguments.of(JANE, LION, true),
                Arguments.of(JANE, MANDRILL, true),
                Arguments.of(JANE, RHINO, false),
                Arguments.of(JANE, ZEBRA, false)
        );
    }
}
