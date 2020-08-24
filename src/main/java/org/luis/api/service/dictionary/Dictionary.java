/**
 * @(#)Dictionary.java        1.0  08/24/2020
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

import org.luis.api.service.exception.DictionaryNotAvailableException;

/**
 * Interface Dictionary exposes getTranslatedText and a method to load the map of dictionary containing,
 * a key,value pair corresponding to words translations ex. house-casa,
 * Separating the changing from the non-changing we have abstracted getTranslatedText in the,
 * AbstractDictionary abstract class,
 * @version 1.0
 */
public interface Dictionary {
    /**
     * Translates text from a given Language to another given Language using Google Translate.
     * This method is implemented in the provided AbstractDictionary since this implementation
     * will never change.
     *
     * @param text String with the text to translate
     * @return String with the translated text
     */
    String getTranslatedText(String text);

    /**
     * Initial load of the dictionary for each particula  Object of type Dictionary,
     * this interface must be implemented by all classes using the dictionary.
     */
     void loadDictionary();
}
