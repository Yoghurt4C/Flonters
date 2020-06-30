package mods.flonters.properties;

import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class FlontersProperties {
    public static final Logger LOGGER = LogManager.getLogger("flonters");

    public static boolean logFlonterPropertiesParse = false;
    public static int flonterPatchSize = 6;
    public static int flonterPatchChance = 16;
    public static int flonterPatchDensity = 2;
    public static int flonterPatchQuantity = 2;
    public static double tallFlonterChance = 0.05D;

    public static void init() {
        Properties configuration = new Properties();
        configuration.setProperty("logFlonterPropertiesParse", String.valueOf(logFlonterPropertiesParse));
        configuration.setProperty("flonterPatchSize", String.valueOf(flonterPatchSize));
        configuration.setProperty("flonterPatchChance", String.valueOf(flonterPatchChance));
        configuration.setProperty("flonterPatchDensity", String.valueOf(flonterPatchDensity));
        configuration.setProperty("flonterPatchQuantity", String.valueOf(flonterPatchQuantity));
        configuration.setProperty("tallFlonterChance", String.valueOf(tallFlonterChance));
        File configurationFile = new File(FabricLoader.getInstance().getConfigDirectory(), "flonters.properties");

        if (configurationFile.exists()) {
            try (InputStream in = new FileInputStream(configurationFile)) {
                configuration.load(in);
                LOGGER.info("Loaded configuration file \"" + configurationFile + "\"");
            } catch (IOException e) {
                LOGGER.error("Could not read configuration file \"" + configurationFile + "\"", e);
            }
        } else {
            try (OutputStream out = new FileOutputStream(configurationFile)) {
                configuration.store(out, "Flonters configuration");
                LOGGER.info("Generated configuration file \"" + configurationFile + "\"");
            } catch (IOException e) {
                LOGGER.error("Could not write configuration file \"" + configurationFile + "\"", e);
            }
        }

        try {
            logFlonterPropertiesParse = Boolean.parseBoolean(configuration.getProperty("logFlonterPropertiesParse"));
            if (logFlonterPropertiesParse) {
                LOGGER.info("Flonters is working as intended, the values are: Chance " + flonterPatchChance + ", Size " + flonterPatchSize + ",Density " + flonterPatchDensity + ",Quantity " + flonterPatchQuantity + ",Tall Chance " + tallFlonterChance + "");
            }
        } catch (NumberFormatException e) {
            LOGGER.error("Error processing configuration file \"" + configurationFile + "\".");
            LOGGER.error("Expected configuration value for logFlonterPropertiesParse to be a boolean (true/false), found \"" + configuration.getProperty("logFlonterPropertiesParse") + "\".");
            LOGGER.error("Using default value \"" + logFlonterPropertiesParse + "\" instead.");
        }
        try {
            flonterPatchChance = Integer.parseInt(configuration.getProperty("flonterPatchChance"));
        } catch (NumberFormatException e) {
            LOGGER.error("Error processing configuration file \"" + configurationFile + "\".");
            LOGGER.error("Expected configuration value for flonterPatchChance to be a number (int), found \"" + configuration.getProperty("flonterPatchChance") + "\".");
            LOGGER.error("Using default value \"" + flonterPatchChance + "\" instead.");
        }
        try {
            flonterPatchSize = Integer.parseInt(configuration.getProperty("flonterPatchSize"));
        } catch (NumberFormatException e) {
            LOGGER.error("Error processing configuration file \"" + configurationFile + "\".");
            LOGGER.error("Expected configuration value for flonterPatchSize to be a number (int), found \"" + configuration.getProperty("flonterPatchSize") + "\".");
            LOGGER.error("Using default value \"" + flonterPatchSize + "\" instead.");
        }
        try {
            flonterPatchDensity = Integer.parseInt(configuration.getProperty("flonterPatchDensity"));
        } catch (NumberFormatException e) {
            LOGGER.error("Error processing configuration file \"" + configurationFile + "\".");
            LOGGER.error("Expected configuration value for flonterPatchDensity to be a number (int), found \"" + configuration.getProperty("flonterPatchDensity") + "\".");
            LOGGER.error("Using default value \"" + flonterPatchDensity + "\" instead.");
        }
        try {
            flonterPatchQuantity = Integer.parseInt(configuration.getProperty("flonterPatchQuantity"));
        } catch (NumberFormatException e) {
            LOGGER.error("Error processing configuration file \"" + configurationFile + "\".");
            LOGGER.error("Expected configuration value for flonterPatchQuantity to be a number (int), found \"" + configuration.getProperty("flonterPatchQuantity") + "\".");
            LOGGER.error("Using default value \"" + flonterPatchQuantity + "\" instead.");
        }
        try {
            tallFlonterChance = Double.parseDouble(configuration.getProperty("tallFlonterChance"));
        } catch (NumberFormatException e) {
            LOGGER.error("Error processing configuration file \"" + configurationFile + "\".");
            LOGGER.error("Expected configuration value for tallFlowerChance to be a number (double), found \"" + configuration.getProperty("tallFlowerChance") + "\".");
            LOGGER.error("Using default value \"" + tallFlonterChance + "\" instead.");
        }
    }
}

