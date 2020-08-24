/**
 * @(#)DictionaryFactory.java        1.0  08/24/2020
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
import org.luis.api.util.Language;

/**
 * Factory method to select the suitable concrete implementation of the Dictionary Interface.
 * @version 1.0
 */

public class DictionaryFactory {


    /**
     * Translates text from a given Language to another given Language using Google Translate.
     *
     * @param from The language code to translate from.
     * @param to The language code to translate to.
     * @return an object of type Dictionary that will do the translation
     * @throws DictionaryNotAvailableException if the pair [from-to] is not configured in the factory.
     */
    public Dictionary createDictionary(Language from, Language to) throws DictionaryNotAvailableException {
        if (Language.ENGLISH.equals(from) && Language.SPANISH.equals(to)){
            return new EnglishToSpanishDictionary();
        }else if (Language.SPANISH.equals(from) && Language.ENGLISH.equals(to)){
            return new SpanishToEnglishDictionary();
        }else {
            String error = String.format("Translating from %s to %s not implemented",
                    Language.getDescription(from), Language.getDescription(to));
            throw new DictionaryNotAvailableException(error);
        }
    }

}
