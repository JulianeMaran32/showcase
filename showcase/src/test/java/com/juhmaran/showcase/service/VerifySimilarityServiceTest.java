package com.juhmaran.showcase.service;

import org.apache.commons.text.similarity.JaroWinklerSimilarity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VerifySimilarityServiceTest {

    static JaroWinklerSimilarity similarity;

    @BeforeAll
    static void setUp() {
        similarity = new JaroWinklerSimilarity();
    }

    @Test
    void testIsSimilarShouldReturnTrue() {

        var service = new VerifySimilarityService();

        String addressRequest = "Rua Xpto, 123";
        String addressElastic = "Rua Xpto, 123";

        boolean similar = service.isSimilar(addressRequest, addressElastic);
        assertTrue(similar);

    }

    @Test
    void testIsSimilarShouldReturnFalse() {

        var service = new VerifySimilarityService();

        String addressRequest = "Rua Xpto, 123";
        String addressElastic = "Xpto, 89";

        boolean similar = service.isSimilar(addressRequest, addressElastic);
        assertFalse(similar);

    }

}