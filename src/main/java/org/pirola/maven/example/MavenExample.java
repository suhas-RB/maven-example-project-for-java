package org.pirola.maven.example;

import java.io.IOException;

/*
 * Maven test example.
 * Copyright (C) 2015 Fabio Pirola <fabio@pirola.org>

 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */

/**
 * Test main class.
 * @author Fabio Pirola <fabio@pirola.org>
 * @version 1.0
 * @since 2015-07-15
 */
public final class MavenExample {
    /** Class name. */
    private static final String CLASS_NAME = MavenExample.class.getName();

    /**
     * Constructor.
     * @since 2015-07-15
     */
    private MavenExample() {

    }

    /**
     * Main class.
     * @since 2015-07-15
     * @param args
     *            Arguments.
     * @throws IOException IO error occurred (read MANIFEST file).
     */
    public static void main(final String[] args) throws IOException {
        System.out.println("Begin "
            + ReadManifest.getBuildInfo(CLASS_NAME));
        System.out.println(getGreeting());
        ReadManifest.printAllAttributes();
    }

    /**
     * Create and get greeting.
     * @since 2015-07-15
     * @return Greeting.
     */
    public static String getGreeting() {
        return "Hello World!!!";
    }
}
