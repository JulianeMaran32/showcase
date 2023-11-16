package com.juhmaran.showcase.normalize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Setup;

import java.text.Collator;

import static java.lang.Character.toChars;
import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CollatorUnitTest {

    private final Collator collator = Collator.getInstance();

    @Setup
    public void setup() {
        collator.setDecomposition(2);
    }

    @Test
    @DisplayName(value = "String acentuada e a força do agrupamento primário " +
            "quando comparada com a String ASCII e então retornar True")
    void givenAccentedStringAndPrimaryCollatorStrength_whenCompareWithASCIIString_thenReturnTrue() {
        var collator = Collator.getInstance();
        collator.setDecomposition(2);
        collator.setStrength(0);
        assertEquals(0, collator.compare("a", "a"));
        assertEquals(0, collator.compare("ä", "a"));
        assertEquals(0, collator.compare("A", "a"));
        assertEquals(1, collator.compare("b", "a"));
        assertEquals(0, collator.compare(valueOf(toChars(0x0001)), valueOf(toChars(0x0002))));
    }

    @Test
    @DisplayName(value = "String acentuada e a força do agrupamento secundário " +
            "quando comparada com a String ASCII e então retornar True")
    void givenAccentedStringAndSecondaryCollatorStrength_whenCompareWithASCIIString_thenReturnTrue() {
        collator.setStrength(1);
        assertEquals(1, collator.compare("ä", "a"));
        assertEquals(1, collator.compare("b", "a"));
        assertEquals(0, collator.compare("A", "a"));
        assertEquals(0, collator.compare("a", "a"));
        assertEquals(0, collator.compare(valueOf(toChars(0x0001)), valueOf(toChars(0x0002))));

    }

    @Test
    @DisplayName(value = "String acentuada e a força do agrupamento ternário " +
            "quando comparada com a String ASCII e então retornar True")
    void givenAccentedStringAndTeriaryCollatorStrength_whenCompareWithASCIIString_thenReturnTrue() {
        collator.setStrength(2);
        assertEquals(1, collator.compare("A", "a"));
        assertEquals(1, collator.compare("ä", "a"));
        assertEquals(1, collator.compare("b", "a"));
        assertEquals(0, collator.compare("a", "a"));
        assertEquals(0, collator.compare(valueOf(toChars(0x0001)), valueOf(toChars(0x0002))));
    }

    @Test
    @DisplayName(value = "String acentuada e a força do agrupamento idêntica " +
            "quando comparada com a String ASCII e então retornar True")
    void givenAccentedStringAndIdenticalCollatorStrength_whenCompareWithASCIIString_thenReturnTrue() {
        collator.setStrength(3);
        assertEquals(1, collator.compare("A", "a"));
        assertEquals(1, collator.compare("ä", "a"));
        assertEquals(1, collator.compare("b", "a"));
        assertEquals(-1, collator.compare(valueOf(toChars(0x0001)), valueOf(toChars(0x0002))));
        assertEquals(0, collator.compare("a", "a"));
    }

    @Test
    @DisplayName(value = "String acentuada NÃO combinável e força de agrupamento idêntica " +
            "quando comparada com a String ASCII e então retornar True")
    void givenNondecomposableAccentedStringAndIdenticalCollatorStrength_whenCompareWithASCIIString_thenReturnTrue() {
        collator.setStrength(0);
        assertEquals(1, collator.compare("ł", "l"));
        assertEquals(1, collator.compare("ø", "o"));
    }

}
