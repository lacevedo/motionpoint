/**
 * @(#)YahooTranslate.java        1.0  08/24/2020
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
package org.luis.api.service;

import org.luis.api.data.Dao;
import org.luis.api.data.TranslateRequestDao;
import org.luis.api.data.UserDao;
import org.luis.api.domain.TranslateRequest;
import org.luis.api.domain.User;
import org.luis.api.service.dictionary.Dictionary;
import org.luis.api.service.dictionary.DictionaryFactory;
import org.luis.api.service.exception.DictionaryNotAvailableException;
import org.luis.api.util.Language;

/**
 * Yahoo Concrete Implementation of the Traslate Interface.
 * @version 1.0
 */

public class YahooTranslate implements Translate{
    /**
     * Holds the current session user.
     */
    private User currentUser;

    /**
     * {@inheritDoc}
     */
    @Override
    public void translate(String text, Language from, Language to) throws DictionaryNotAvailableException {

        Dao dao=new TranslateRequestDao();
        TranslateRequest translateRequest=new TranslateRequest();
        DictionaryFactory dictionaryFactory=new DictionaryFactory();
        translateRequest.setOriginalText(text);
        translateRequest.setLanguageFrom(from);
        translateRequest.setLanguageTo(to);
        translateRequest.setUser(currentUser);

        try {
            Dictionary dictionary=dictionaryFactory.createDictionary(from,to);
            dictionary.loadDictionary();
            String translatedText=dictionary.getTranslatedText(text);
            translateRequest.setTranslatedText(translatedText);
        }catch (DictionaryNotAvailableException e){
            throw e;
        }catch (Exception e){
            throw new DictionaryNotAvailableException("Unknown Service Error");
        }
        dao.add(translateRequest);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void translate(String[] texts, Language from, Language to) {
        for (String text:texts){
            translate(text,from,to);
        }
    }


    @Override
    public void setLoggedUser(User user) {
        this.currentUser=user;
    }
}
