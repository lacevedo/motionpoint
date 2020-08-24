/**
 * AppTest.java
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

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TestName;
import org.luis.api.data.TranslateRequestDao;
import org.luis.api.domain.TranslateRequest;
import org.luis.api.domain.User;
import org.luis.api.service.Translate;
import org.luis.api.service.YahooTranslate;
import org.luis.api.service.exception.DictionaryNotAvailableException;
import org.luis.api.util.Language;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Full user cases Junit Test for the luis-api-translate service.
 */
public class AppTest{
    /**
     * Rule to inject method name.
     */
    @Rule
    public final TestName name = new TestName();

    /**
     * Dummy method to represent a call to register an api key.
     */
    @BeforeClass
    public static void onceExecutedBeforeAll() {
        System.out.println("Register the  yahoo api key one time and before tests are executed");
    }
    /**
     * Clear the database before every test.
     */
    @Before
    public void executedBeforeEach() {
        TranslateRequestDao translateRequestDao =new TranslateRequestDao();
        translateRequestDao.deleteAll();
    }

    /**
     * Test a succesful translation Spanish to English.
     */
    @Test
    public void testTranslateSpanishEnglish(){
        System.out.println("Inside "+name.getMethodName());
        Translate googleTranslate=new YahooTranslate();
        User user=new User("luis");
        googleTranslate.setLoggedUser(user);
        googleTranslate.translate("me gusta ir al cine", Language.SPANISH,Language.ENGLISH);
        TranslateRequestDao translateRequestDao =new TranslateRequestDao();
        assertEquals(translateRequestDao.findAll().get(0).getTranslatedText(),"I like to go to the movies");
    }

    /**
     * Test a succesful translation English  to Spanish.
     */
    @Test
    public void testTranslateEnglishSpanish(){
        System.out.println("Inside "+name.getMethodName());
        Translate googleTranslate=new YahooTranslate();
        User user=new User("luis");
        googleTranslate.setLoggedUser(user);
        googleTranslate.translate("I like to go to the movies", Language.ENGLISH,Language.SPANISH);
        TranslateRequestDao translateRequestDao =new TranslateRequestDao();
        assertEquals(translateRequestDao.findAll().get(0).getTranslatedText(),"me gusta ir al cine");
    }

    /**
     * Test a partial translation, similar to google translate if word is not in dictionary,
     * the translation returns the same word.
     */
    @Test
    public void testTranslateWordNotInDictionary(){
        System.out.println("Inside "+name.getMethodName());
        Translate googleTranslate=new YahooTranslate();
        User user=new User("luis");
        googleTranslate.setLoggedUser(user);
        googleTranslate.translate("I like to go to the house", Language.ENGLISH,Language.SPANISH);
        TranslateRequestDao translateRequestDao =new TranslateRequestDao();
        assertEquals(translateRequestDao.findAll().get(0).getTranslatedText(),"me gusta ir al house");
    }

    /**
     * Test DictionaryNotAvailableException is thrown when no suitable factory found.
     */
    @Test(expected = DictionaryNotAvailableException.class)
    public void testDictionaryNotAvailableExceptio() {
        System.out.println("Inside "+name.getMethodName());
        Translate googleTranslate=new YahooTranslate();
        User user=new User("luis");
        googleTranslate.setLoggedUser(user);
        googleTranslate.translate("I like to go to the house", Language.ENGLISH,Language.FRENCH);
    }

    /**
     * Rule to collect all validations of Dao properties in one run.
     */
    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    /**
     * Test that all properties of TranslateRequest have values.
     */
    @Test
    public void testAllPropertiesSetforRequest() {
        System.out.println("Inside "+name.getMethodName());
        Translate googleTranslate=new YahooTranslate();
        User user=new User("luis");
        googleTranslate.setLoggedUser(user);
        googleTranslate.translate("I like to go to the house", Language.ENGLISH,Language.SPANISH);
        TranslateRequestDao translateRequestDao =new TranslateRequestDao();
        collector.checkThat(translateRequestDao.findAll().get(0).getUser(), notNullValue());
        collector.checkThat(translateRequestDao.findAll().get(0).getLanguageFrom(), notNullValue());
        collector.checkThat(translateRequestDao.findAll().get(0).getLanguageTo(), notNullValue());
    }


}
