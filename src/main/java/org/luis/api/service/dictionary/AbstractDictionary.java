/**
 * @(#)AbstractDictionary.java        1.0  08/24/2020
 *
 * Copyright (C) 2020,  Luis Acevedo
 *
 * This file is part of luis-api-translate.
 *
 * luis-api-translate is a free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation
 *
 * There is not liability or WARRANTY forthe use of this code.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with luis-api-translate. If not, see <http://www.luis.org/licenses/>.
 */

package org.luis.api.service.dictionary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Abstraction of getTranslatedText method to separate the changing from the non-changing.
 * @version 1.0
 */
public abstract class AbstractDictionary implements Dictionary {
    /**
     * Map of words with one language with the translation to another language.
     * All classes implementing this interface know the from language and the to language
     */
    private  Map<String,String> dictionaryItems=new HashMap<String,String>();

    /**
     * Construct a map of words in the "from" language with their equivalent translation in the "to" language.
     *
     * @param key Represents a word in the "from" language.
     * @param value Represents the translated word in the "to" language.
     */
    public  void addDictionaryItems(String key, String value) {
        dictionaryItems.put(key, value);
    }

    @Override
    public String getTranslatedText(String text) {
        String[] words = text.split(" ");
        return Arrays.asList(words)
                .stream()
                .map(elem->dictionaryItems.getOrDefault(elem,elem))
                .filter(elem -> elem.length()>0)
                .collect(Collectors.joining(" "));
    }

    @Override
    public abstract void loadDictionary();




}
