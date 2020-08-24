/**
 * @(#)SpanishToEnglishDictionary.java        1.0  08/24/2020
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
 * Concrete implementation of the dictionary for the translation of spanish to english.
 * @version 1.0
 */
public  class SpanishToEnglishDictionary extends AbstractDictionary {
    @Override
    public void loadDictionary() {
        addDictionaryItems("me", "I");
        addDictionaryItems("gusta", "like");
        addDictionaryItems("ir", "to go");
        addDictionaryItems("al", "to the");
        addDictionaryItems("cine", "movies");
    }
}
