package org.pirola.maven_example;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/**
 * Read manifest information.
 * @author Fabio Pirola <fabio@pirola.org>
 * @version 1.0
 * @since 2015-07-15
 */
public final class ReadManifest {

    /**
     * Constructor.
     * @since 2015-07-15
     */
    private ReadManifest() {
    }

    /** Manifest path and file name. */
    private static final String MANIFEST = "META-INF/MANIFEST.MF";
    /** Attribute implementation version. */
    private static final String ATTR_VERSION = "Implementation-Version";
    /** Attribute SCM revision. */
    private static final String ATTR_SCM_REVISION = "Scm-Revision";

    /**
     * Return program version and build information.
     * @since 2015-07-15
     * @param programName
     *            Program name.
     * @return String with program version and build information.
     * @throws IOException
     *             Error on opening Manifest file
     */
    public static String getBuildInfo(final String programName)
            throws IOException {
        Manifest mf = new Manifest(Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(MANIFEST));
        Attributes atts = mf.getMainAttributes();
        return String.format("program[%s] version[%s] scm-revision[%s]",
                programName,
                atts.getValue(ATTR_VERSION),
                atts.getValue(ATTR_SCM_REVISION));
    }

    /**
     * Print all manifest attributes.
     * @since 2015-07-15
     * @throws IOException
     *             Error on opening Manifest file
     */
    public static void printAllAttributes()
            throws IOException {
        Manifest mf = new Manifest(Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(MANIFEST));
        Attributes atts = mf.getMainAttributes();
        System.out.println("*******   BEGIN PRINT MANIFEST   *******");
        for (Entry<Object, Object> attribute : atts.entrySet()) {
            System.out.println(String.format("key[%s] value[%s]",
                    attribute.getKey(), attribute.getValue()));
        }
        System.out.println("*******   END PRINT MANIFEST   *******");
    }
}
