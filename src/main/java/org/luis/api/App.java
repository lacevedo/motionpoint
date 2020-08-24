/**
 * @(#)App.java        1.0  08/24/2020
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

package org.luis.api;

import org.luis.api.data.TranslateRequestDao;
import org.luis.api.domain.TranslateRequest;
import org.luis.api.domain.User;
import org.luis.api.service.YahooTranslate;
import org.luis.api.service.Translate;
import org.luis.api.util.Language;

import java.util.List;

/**
 * Client class to generate a demo of the luis-api-translate without a test runner.
 * @version 1.0
 */
public class App {

    /**
     * Main method to test luis-api-translate. It calls test().
     * @param args is empty as  no paramter is passed at runtime.
     */
    public static void main(String[] args) {
        App app=new App();
        app.test();
    }
    /**
     * test method to test luis-api-translate.
     */
    public void test(){
        Translate googleTranslate=new YahooTranslate();
        User user=new User("luis");
        googleTranslate.setLoggedUser(user);
        googleTranslate.translate("me gusta ir al cine", Language.SPANISH,Language.ENGLISH);
        googleTranslate.translate("I like to go to the movies", Language.ENGLISH,Language.SPANISH);
        googleTranslate.translate("I like to go to the house", Language.ENGLISH,Language.SPANISH);
        try {
            googleTranslate.translate("I like to go the movieso", Language.ENGLISH, Language.FRENCH);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
