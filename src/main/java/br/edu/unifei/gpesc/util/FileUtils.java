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

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 *
 * @author Isaac Caldas Ferreira
 */
public class FileUtils {

    /**
     * Filter if a {@link File} is a just a file (not a directory and exists).
     */
    public static class IsFileFilter implements FileFilter {
        @Override
        public boolean accept(File file) {
            return file.isFile();
        }
    }

    /**
     * Filter files by extension.
     */
    public static class ExtensionFilter implements FilenameFilter {

        /**
         * The extension.
         */
        private final String mExt;

        /**
         * Creates a filter
         * @param ext The extension to be filtered.
         */
        public ExtensionFilter(String ext) {
            mExt = ext.toLowerCase();
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(mExt);
        }
    }

    public static File[] listFiles(File folder, String ext) {
        File[] subFiles = folder.listFiles(new ExtensionFilter(ext));
        return (subFiles != null) ? subFiles : new File[0];
    }
}