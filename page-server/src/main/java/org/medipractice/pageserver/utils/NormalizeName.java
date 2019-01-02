package org.medipractice.pageserver.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.text.Normalizer;

@AllArgsConstructor(staticName="of")
public class NormalizeName {
    private String text;

    public String toString(){
        text= Normalizer.normalize(text, Normalizer.Form.NFD).toLowerCase();
        text = text.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        text = text.replaceAll("[^a-zA-Z0-9]", "-");
        return text;
    }
}
