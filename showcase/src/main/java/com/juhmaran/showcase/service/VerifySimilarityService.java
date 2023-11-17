package com.juhmaran.showcase.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.similarity.JaroWinklerSimilarity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class VerifySimilarityService {

    private final JaroWinklerSimilarity jaroWinklerSimilarity = new JaroWinklerSimilarity();

    public boolean isSimilar(String addressRequest, String addressElastic) {
        return jaroWinklerSimilarity.apply(addressRequest, addressElastic) >= 0.8;
    }

}
