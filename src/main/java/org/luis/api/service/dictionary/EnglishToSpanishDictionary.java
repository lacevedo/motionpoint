/**
 * @(#)EnglishToSpanishDictionary.java        1.0  08/24/2020
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

/**
 * Concrete implementation of the dictionary for the translation of english to spanish.
 * @version 1.0
 */
public  class EnglishToSpanishDictionary extends AbstractDictionary {

    @Override
    public void loadDictionary() {
        //In the Future this will load from a file
        addDictionaryItems("I", "me");
        addDictionaryItems("like", "gusta");
        addDictionaryItems("to", "");
        addDictionaryItems("go", "ir");
        addDictionaryItems("to", "");
        addDictionaryItems("the", "al");
        addDictionaryItems("movies", "cine");
    }
}
