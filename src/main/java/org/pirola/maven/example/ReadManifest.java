package org.pirola.maven.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.jar.Attributes;
import java.util.jar.Attributes.Name;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * Read manifest information.
 * @author Fabio Pirola <fabio@pirola.org>
 * @version 2.0
 * @since 2015-07-15
 */
public final class ReadManifest {
    /** Attribute implementation version. */
    private static final String ATTR_VERSION = "Implementation-Version";
    /** Attribute SCM revision. */
    private static final String ATTR_SCM_REVISION = "Scm-Revision";

    /**
     * Constructor.
     * @since 2015-07-15
     */
    private ReadManifest() {
    }

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
        Map<String, String> mainAttributes = getMainAttributes();
        return String.format("program[%s] version[%s] scm-revision[%s]",
                programName, mainAttributes.get(ATTR_VERSION),
                mainAttributes.get(ATTR_SCM_REVISION));
    }

    /**
     * Return main attributes.
     * @since 2015-11-30
     * @return Main attributes.
     * @throws IOException
     *             Error on opening Manifest file.
     */
    public static Map<String, String> getMainAttributes() throws IOException {
        Map<String, String> mainAttributes = new HashMap<>();
        try (JarFile jar =
                new JarFile(System.getProperty("java.class.path"));) {
            final Manifest manifest = jar.getManifest();
            final Attributes attributes = manifest.getMainAttributes();

            for (Entry<Object, Object> attrCycle : attributes.entrySet()) {
                mainAttributes.put(String.valueOf(attrCycle.getKey()),
                        String.valueOf(attrCycle.getValue()));
            }
        }
        return mainAttributes;
    }

    /**
     * Return other attributes.
     * @since 2015-11-30
     * @return Other attributes.
     * @throws IOException
     *             Error on opening Manifest file
     */
    public static Map<String, Map<String, String>> getOtherAttributes()
            throws IOException {
        Map<String, Map<String, String>> otherAttributes = new HashMap<>();
        try (JarFile jar =
                new JarFile(System.getProperty("java.class.path"));) {
            final Manifest manifest = jar.getManifest();

            final Map<String, Attributes> mapAttrs = manifest.getEntries();
            for (Entry<String, Attributes> nameAttrs : mapAttrs.entrySet()) {
                final Map<String, String> otherCycle = new HashMap<>();
                Attributes attrs = nameAttrs.getValue();
                for (Object attrCycle : attrs.keySet()) {
                    otherCycle.put(String.valueOf(attrCycle),
                            String.valueOf(attrs.getValue((Name) attrCycle)));
                }
                otherAttributes.put(nameAttrs.getKey(), otherCycle);
            }
        }
        return otherAttributes;
    }

    /**
     * Print all manifest attributes.
     * @since 2015-07-15
     * @throws IOException
     *             Error on opening Manifest file
     */
    public static void printAllAttributes() throws IOException {
        Map<String, String> mainAttributes = getMainAttributes();
        Map<String, Map<String, String>> otherAttributes = getOtherAttributes();
        System.out.println("*******   BEGIN PRINT MANIFEST   *******");
        System.out.println("Main attributes:");
        for (Entry<String, String> attrCycle : mainAttributes.entrySet()) {
            System.out.println(String.format("key[%s] value[%s]",
                    attrCycle.getKey(), attrCycle.getValue()));
        }
        System.out.println("Other attributes:");
        for (Entry<String, Map<String, String>> otherCycle : otherAttributes
                .entrySet()) {
            System.out.println(String.format("%s:", otherCycle.getKey()));
            for (Entry<String, String> attrCycle : otherCycle.getValue()
                    .entrySet()) {
                System.out.println(String.format("key[%s] value[%s]",
                        attrCycle.getKey(), attrCycle.getValue()));
            }
        }
        System.out.println("*******   END PRINT MANIFEST   *******");
    }
}
