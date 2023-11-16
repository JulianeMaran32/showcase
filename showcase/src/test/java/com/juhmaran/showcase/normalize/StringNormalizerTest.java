package com.juhmaran.showcase.normalize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.Normalizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class StringNormalizerTest {

    @Test
    @DisplayName(value = "Dada uma string não normalizada, quando é normalizada, retorna Falso.")
    void givenNotNormalizedString_whenIsNormalized_thenReturnFalse() {
        assertFalse(Normalizer.isNormalized("āăąēîïĩíĝġńñšŝśûůŷ", Normalizer.Form.NFKD));
    }

    /**
     * "Traduz para Português Brasil: given String With Nondecomposable Unicode Characters
     * when Remove Accents With Apache Commons then Return Modified String"
     */

    @Test
    @DisplayName(value = "Dada uma string com caracteres Unicode decomponíveis, ao remover os acentos, " +
            "será retornada uma string ASCII.")
    void givenStringWithDecomposableUnicodeCharacters_whenRemoveAccents_thenReturnASCIIString() {
        assertEquals("aaaeiiiiggnnsssuuy", StringNormalizer.removeAccents("āăąēîïĩíĝġńñšŝśûůŷ"));
    }

    @Test
    @DisplayName(value = "Dado uma string com caracteres Unicode decomponíveis, ao remover acentos com o " +
            "Apache Commons, retornará uma string ASCII.")
    void givenStringWithDecomposableUnicodeCharacters_whenRemoveAccentsWithApacheCommons_thenReturnASCIIString() {
        assertEquals("aaaeiiiiggnnsssuuy",
                StringNormalizer.removeAccentsWithApacheCommons("āăąēîïĩíĝġńñšŝśûůŷ"));
    }

    @Test
    @DisplayName(value = "dado uma string com caracteres Unicode não decomponíveis quando remover acentos, " +
            "então retornar a string original")
    void givenStringWithNondecomposableUnicodeCharacters_whenRemoveAccents_thenReturnOriginalString() {
        assertEquals("łđħœ", StringNormalizer.removeAccents("łđħœ"));
    }

    @Test
    @DisplayName(value = "")
    void givenStringWithNondecomposableUnicodeCharacters_whenRemoveAccentsWithApacheCommons_thenReturnModifiedString() {
        assertEquals("lđħœ", StringNormalizer.removeAccentsWithApacheCommons("łđħœ"));
    }

    @Test
    @DisplayName(value = "")
    void givenStringWithDecomposableUnicodeCharacters_whenUnicodeValueOfNormalizedString_thenReturnUnicodeValue() {
        assertEquals("\\u0066 \\u0069", StringNormalizer.unicodeValueOfNormalizedString("ﬁ"));
        assertEquals("\\u0061 \\u0304", StringNormalizer.unicodeValueOfNormalizedString("ā"));
        assertEquals("\\u0069 \\u0308", StringNormalizer.unicodeValueOfNormalizedString("ï"));
        assertEquals("\\u006e \\u0301", StringNormalizer.unicodeValueOfNormalizedString("ń"));
    }

    @Test
    @DisplayName(value = "")
    void givenStringWithNonDecomposableUnicodeCharacters_whenUnicodeValueOfNormalizedString_thenReturnOriginalValue() {
        assertEquals("\\u0142", StringNormalizer.unicodeValueOfNormalizedString("ł"));
        assertEquals("\\u0127", StringNormalizer.unicodeValueOfNormalizedString("ħ"));
        assertEquals("\\u0111", StringNormalizer.unicodeValueOfNormalizedString("đ"));
    }

}