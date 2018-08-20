/*
 * Copyright (C) 2015 - GEPESC - Universidade Federal de Itajuba
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.edu.unifei.gpesc.util;

import java.util.Properties;

/**
 * This class manages all internationalization string resources and provides
 * convenient print methods.
 *
 * @author Isaac Caldas Ferreira
 */
public final class Messages {

    /**
     * The Resource Bundle for this application.
     */
    private final Properties mProperties;

    /**
     * Creates a Messages with the properties.
     * @param props The properties.
     */
    public Messages(Properties props) {
        mProperties = props;
    }

    /**
     * This method is used to get an internationalization string. <br>
     * All strings messages are in src/main/resources/messages.properties.
     * @param key The key for the message string.
     * @return The internationalization string message.
     */
    public String i18n(String key) {
        return mProperties.getProperty(key);
    }

    /**
     * Same of {@link Messages#i18n(String)} with extra arguments.
     * @param key The key for the message string.
     * @param args The extra arguments.
     * @return The internationalization string message.
     */
    public String i18n(String key, Object... args) {
        return String.format(i18n(key), args);
    }

    /**
     * This method prints an internationalization string with line end
     * on console using {@link System#out}.
     * @param key The key for the message string.
     * @param args The extra arguments.
     */
    public void printlnLog(String key, Object... args) {
        System.out.println(i18n(key, args));
    }

    /**
     * This method prints an internationalization string  on console using
     * {@link System#out}.
     * @param key The key for the message string.
     * @param args The extra arguments.
     */
    public void printLog(String key, Object... args) {
        System.out.print(i18n(key, args));
    }

    /**
     * Has the same effect of calling System.out.print(String).
     * @param text The string to be printed.
     */
    public static void print(String text) {
        System.out.print(text);
    }

    /**
     * Has the same effect of calling System.out.println(String).
     * @param text The string to be printed.
     */
    public static void println(String text) {
        System.out.println(text);
    }
}
