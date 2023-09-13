package org.noname.charfrequencyproject.web.controller;

import org.noname.charfrequencyproject.entity.common.Result;
import org.noname.charfrequencyproject.service.CharFrequencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
