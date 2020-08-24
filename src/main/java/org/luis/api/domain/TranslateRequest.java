/**
 * @(#)TranslateRequest.java        1.0  08/24/2020
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

package org.luis.api.domain;

import org.luis.api.util.Language;

/**
 * the Translate Request is persisted to the database this is the transfer object.
 * @version 1.0
 */

public class TranslateRequest {

    /**
     * Represents the language to translate from.
     */
    private Language languageFrom;

    /**
     * Represents the language to translate to.
     */
    private Language languageTo;

    /**
     * Represents the user submitting the translation request.
     */
    private User user;

    /**
     * Represents the text to translate.
     */
    private String originalText;

    /**
     * Represents the translated text.
     */
    private String translatedText;

    /**
     * @return  object of type language representing the "from" language.
     */
    public Language getLanguageFrom() {
        return languageFrom;
    }

    /**
     * Getter.
     * @param planguageFrom setter for the languageFrom Field.
     */
    public void setLanguageFrom(Language planguageFrom) {
        this.languageFrom = planguageFrom;
    }
    /**
     * Setter.
     * @return  object of type language representing the "to" language.
     */
    public Language getLanguageTo() {
        return languageTo;
    }

    /**
     * Getter.
     * @param planguageto setter for the planguageto Field.
     */
    public void setLanguageTo(Language planguageto) {
        this.languageTo = planguageto;
    }

    /**
     * Setter.
     * @return  object of type User representing the "to" language.
     */
    public User getUser() {
        return user;
    }

    /**
     * Getter.
     * @param puser setter for the User Field.
     */
    public void setUser(User puser) {
        this.user = puser;
    }

    /**
     * Setter.
     * @return Getter returns String with the original text to translate.
     */
    public String getOriginalText() {
        return originalText;
    }

    /**
     * Getter.
     * @param poriginalText setter for the originalText Field
     */
    public void setOriginalText(String poriginalText) {
        this.originalText = poriginalText;
    }

    /**
     * Setter.
     * @return Getter returns String with the translated text.
     */
    public String getTranslatedText() {
        return translatedText;
    }

    /**
     * Getter.
     * @param ptranslatedText setter for the translatedText Field
     */
    public void setTranslatedText(String ptranslatedText) {
        this.translatedText = ptranslatedText;
    }

}
