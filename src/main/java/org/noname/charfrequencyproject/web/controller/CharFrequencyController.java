package org.noname.charfrequencyproject.web.controller;

import org.noname.charfrequencyproject.entity.common.Result;
import org.noname.charfrequencyproject.service.CharFrequencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/charFrequency")
public class CharFrequencyController {
    private final CharFrequencyService frequencyService;

    public CharFrequencyController(CharFrequencyService frequencyService) {
        this.frequencyService = frequencyService;
    }

    @PostMapping("/calculateFrequency")
    public ResponseEntity<Result<Map<Character, Integer>>> getCharFrequencyFromString(
            @RequestBody Map<String, String> body) {
        String inputString = body.get("inputString");

        if (inputString == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "'inputString' parameter must be passed in request body.");
        }

        var map = frequencyService.getCharFrequencyFromString(inputString).entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return ResponseEntity.ok(Result.ok(map));
    }
}
