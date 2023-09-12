package org.noname.charfrequencyproject.web.controller;

import org.noname.charfrequencyproject.service.CharFrequencyService;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/charFrequency")
public class CharFrequencyController {
    private final CharFrequencyService frequencyService;

    public CharFrequencyController(CharFrequencyService frequencyService) {
        this.frequencyService = frequencyService;
    }


}
