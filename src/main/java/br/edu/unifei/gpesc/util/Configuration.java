/*
 * Copyright (C) 2015 - GPESC - Universidade Federal de Itajuba
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

/**
 *
 * @author Isaac Caldas Ferreira
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Isaac Caldas Ferreira
 */
public class Configuration {

    /**
     * Properties with the file parameters.
     */
    private final Properties mConfigurations = new Properties();

    /**
     * @param filePath The file with the properties.
     * @throws IOException
     */
    public Configuration(String filePath) throws IOException {
        FileReader reader = new FileReader(new File(filePath));
        mConfigurations.load(reader);
        reader.close();
    }

    public Configuration() {

    }

    public void put(String key, String value) {
        mConfigurations.put(key, value);
    }

    /**
     * Gets a String property.
     * @param key The property key.
     * @return The property.
     * @throws IllegalArgumentException if the property does not exists.
     */
    public String getProperty(String key) {
        String value = mConfigurations.getProperty(key);
        if (value == null) {
            throw new IllegalArgumentException("Missing property: " + key);
        } else {
            return value;
        }
    }

    /**
     * Gets a int property.
     * @param key The property key.
     * @return The property.
     * @throws IllegalArgumentException if the property does not exists.
     */
    public int getIntegerProperty(String key) {
        return Integer.parseInt(getProperty(key));
    }

    /**
     * Gets a double property.
     * @param key The property key.
     * @return The property.
     * @throws IllegalArgumentException if the property does not exists.
     */
    public double getDoubleProperty(String key) {
        return Double.parseDouble(getProperty(key));
    }

    /**
     * Gets a String property, if it does not contains, the defualt value is
     * returned.
     *
     * @param key The property key.
     * @param defaultValue The default value.
     * @return The property.
     */
    public String getProperty(String key, String defaultValue) {
        return mConfigurations.getProperty(key, defaultValue);
    }

    /**
     * Gets a int property, if it does not contains, the defualt value is
     * returned.
     *
     * @param key The property key.
     * @param defaultValue The default value.
     * @return The property.
     */
    public int getIntegerProperty(String key, int defaultValue) {
        String value = mConfigurations.getProperty(key);
        return (value != null) ? Integer.parseInt(value) : defaultValue;
    }

    /**
     * Gets a double property, if it does not contains, the defualt value is
     * returned.
     *
     * @param key The property key.
     * @param defaultValue The default value.
     * @return The property.
     */
    public double getDoubleProperty(String key, double defaultValue) {
        String value = mConfigurations.getProperty(key);
        return (value != null) ? Double.parseDouble(value) : defaultValue;
    }

    /**
     * Gets a boolean property, if it does not contains, the defualt value is
     * returned.
     *
     * @param key The property key.
     * @param defaultValue The default value.
     * @return The property.
     */
    public boolean getBooleanProperty(String key, boolean defaultValue) {
        String value = mConfigurations.getProperty(key);
        return (value != null) ? Boolean.parseBoolean(value) : defaultValue;
    }
}