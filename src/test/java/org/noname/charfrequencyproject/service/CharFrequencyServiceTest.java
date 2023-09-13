package org.noname.charfrequencyproject.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class CharFrequencyServiceTest {
    @Autowired
    private final CharFrequencyService charFrequencyService = null;

    @Test
    public void getCharFrequencyFromString_nullString_emptyMapReturned() {
        Assertions.assertEquals(0, charFrequencyService.getCharFrequencyFromString(null).size());
    }

    @Test
    public void getCharFrequencyFromString_emptyString_emptyMapReturned() {
        Assertions.assertEquals(0, charFrequencyService.getCharFrequencyFromString("").size());
    }

    @Test
    public void getCharFrequencyFromString_fromString_exceptedMapReturned() {
        String value = "aaaaabbbcc122333";

        HashMap<Character, Integer> expectedMap = new HashMap<>();
        expectedMap.put('a', 5);
        expectedMap.put('b', 3);
        expectedMap.put('c', 2);
        expectedMap.put('1', 1);
        expectedMap.put('2', 2);
        expectedMap.put('3', 3);

        var returnedMap = charFrequencyService.getCharFrequencyFromString(value);

        Assertions.assertEquals(returnedMap, expectedMap);
    }
}