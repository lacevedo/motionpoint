/**
 * @(#)Language.java        1.0  08/24/2020
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

package org.luis.api.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines language information for the Yahoo Translate API.
 *
 * @version 1.0
 * @author Luis  Acevedo
 */

public enum Language {

    /**
     * Spanish is represented as es for yahoo compatibility.
     */
    SPANISH("es"),

    /**
     * English is represented en es for yahoo compatibility.
     */
    ENGLISH("en"),

    /**
     * French is represented as fr for yahoo compatibility.
     */
    FRENCH("fr");

    /**
     * Map to get a pretty print representation of the Language Enum type.
     * For logging and error message porpuse
     */
    private static Map<Language,String> languageMap=new HashMap<Language,String>();

    /**
     * Api's String representation of this language.
     * for compatibility if you want to use third party google service
     */
    private final String language;

    static {
        languageMap.put(Language.ENGLISH,"English");
        languageMap.put(Language.SPANISH,"Spanish");
        languageMap.put(Language.FRENCH,"French");
    }

    /**
     * Enum constructor.
     * @param strlanguage The language identifier.
     */

    private Language(final String strlanguage) {
        this.language = strlanguage;
    }

    /**
     * Creates a l.
     *
     * @param language String with the language.
     * @return The Language object
     */

    public static Language fromString(final String language) {
        for (Language l : values()) {
            if (l.toString().equals(language)) {
                return l;
            }
        }
        return null;
    }

    /**
     * Returns a string description of a Language Enum Type.
     *
     * @param language Language Enum tyoe.
     * @return A string description of the Languate Enum Type
     */

    public  static String getDescription(Language language){
        return languageMap.get(language);

    }

    /**
     * Returns the String representation of this language.
     * @return The String representation of this language.
     */

    @Override
    public String toString() {
        return language;
    }


}