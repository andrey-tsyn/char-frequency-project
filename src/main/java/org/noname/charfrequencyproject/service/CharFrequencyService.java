package org.noname.charfrequencyproject.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CharFrequencyService {

    public HashMap<Character, Integer> getCharFrequencyFromString(String str) {
        if (str == null) return new HashMap<>();

        HashMap<Character, Integer> map = new HashMap<>();

        for (Character ch : str.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        return map;
    }
}
