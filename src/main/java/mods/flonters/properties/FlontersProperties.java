package mods.flonters.properties;

import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import static mods.flonters.Flonters.LOGGER;

public class FlontersProperties {
    public static boolean logFlonterPropertiesParse;
    public static int flonterPatchSize, flonterPatchChance, flonterPatchDensity, flonterPatchQuantity;
    public static double tallFlonterChance;

    private static void handleConfig(Map<String, String> cfg) {
        logFlonterPropertiesParse = getBool("logFlonterPropertiesParse", cfg);
        flonterPatchSize = getInt("flonterPatchSize", cfg);
        flonterPatchChance = getInt("flonterPatchChance", cfg);
        flonterPatchDensity = getInt("flonterPatchDensity", cfg);
        flonterPatchQuantity = getInt("flonterPatchDensity", cfg);
        tallFlonterChance = getDouble("tallFlonterChance", cfg);
        if (logFlonterPropertiesParse) {
            LOGGER.info("Flonters should be working as intended, the values are: Chance " + flonterPatchChance + ", Size " + flonterPatchSize + ",Density " + flonterPatchDensity + ",Quantity " + flonterPatchQuantity + ",Tall Chance " + tallFlonterChance + "");
        }
    }

    public static void init() {
        Map<String, String> cfg = new Object2ObjectOpenHashMap<>();
        ImmutableSet<Entry<?>> entries = ImmutableSet.of(
                Entry.of("logFlonterPropertiesParse", false,
                        "logFlonterPropertiesParse: Prints the Flonter Patch properties during initialization. [Side: BOTH | Default: false]"),
                Entry.of("flonterPatchSize", 6,
                        "flonterPatchSize: The larger this is, the farther each Patch can spread. [Side: SERVER | Default: 6]"),
                Entry.of("flonterPatchChance", 16,
                        "flonterPatchChance: Higher values result in less patches, but more Flonters per Patch. [Side: SERVER | Default: 16]"),
                Entry.of("flonterPatchDensity", 2,
                        "flonterPatchDensity: Lower values produce less Flonters per Patch. [Side: SERVER | Default: 2]"),
                Entry.of("flonterPatchQuantity", 2,
                        "flonterPatchQuantity: Lower values generate less Flonter Patches. [Side: SERVER | Default: 2]"),
                Entry.of("tallFlonterChance", 0.05D,
                        "tallFlonterChance: The chance for individual Flonters to generate as their Tall variant. 0.1 is 10%, 1 is 100%. [Side: SERVER | Default: 0.05D]")
        );
        Path configPath = FabricLoader.getInstance().getConfigDir().resolve("flonters.properties");
        try {
            boolean changed = false;
            File configurationFile = configPath.toFile();
            if (Files.notExists(configPath) && !configPath.toFile().createNewFile()) {
                LOGGER.error("[Flonters] Error creating config file \"" + configurationFile + "\".");
            }
            Properties config = new Properties();
            StringBuilder content = new StringBuilder().append("#Flonters Configuration.\n");
            content.append("#Last generated at: ").append(new Date()).append("\n\n");
            FileInputStream input = new FileInputStream(configurationFile);
            config.load(input);
            for (Entry<?> entry : entries) {
                String key = entry.key;
                Object value = entry.value;
                Class<?> cls = entry.cls;
                if (!config.containsKey(key)) {
                    changed = true;
                    config.setProperty(key, value.toString());
                }
                if (config.containsKey(key)) {
                    Object obj = config.getProperty(key);
                    String s = String.valueOf(obj);
                    if (s.equals("")) {
                        LOGGER.error("[Flonters] Error processing configuration file \"" + configurationFile + "\".");
                        LOGGER.error("[Flonters] Expected configuration value for " + key + " to be present, found nothing. Using default value \"" + value + "\" instead.");
                        cfg.put(key, value.toString());
                    } else if (cls.equals(Integer.class)) {
                        try {
                            Integer.parseInt(s);
                            cfg.put(key, s);
                        } catch (NumberFormatException e) {
                            LOGGER.error("[Flonters] Error processing configuration file \"" + configurationFile + "\".");
                            LOGGER.error("[Flonters] Expected configuration value for " + key + " to be an integer, found \"" + s + "\". Using default value \"" + value + "\" instead.");
                            cfg.put(key, value.toString());
                        }
                    } else if (cls.equals(Float.class)) {
                        try {
                            Float.parseFloat(s);
                            cfg.put(key, s);
                        } catch (NumberFormatException e) {
                            LOGGER.error("[Flonters] Error processing configuration file \"" + configurationFile + "\".");
                            LOGGER.error("[Flonters] Expected configuration value for " + key + " to be a float, found \"" + s + "\". Using default value \"" + value + "\" instead.");
                            cfg.put(key, value.toString());
                        }
                    } else if (cls.equals(Double.class)) {
                        try {
                            Double.parseDouble(s);
                            cfg.put(key, s);
                        } catch (NumberFormatException e) {
                            LOGGER.error("[Flonters] Error processing configuration file \"" + configurationFile + "\".");
                            LOGGER.error("[Flonters] Expected configuration value for " + key + " to be a double, found \"" + s + "\". Using default value \"" + value + "\" instead.");
                            cfg.put(key, value.toString());
                        }
                    } else if (cls.equals(Boolean.class)) {
                        if (!"true".equalsIgnoreCase(s) && !"false".equalsIgnoreCase(s)) {
                            LOGGER.error("[Flonters] Error processing configuration file \"" + configurationFile + "\".");
                            LOGGER.error("[Flonters] Expected configuration value for " + key + " to be a boolean, found \"" + s + "\". Using default value \"" + value + "\" instead.");
                            cfg.put(key, value.toString());
                        } else cfg.put(key, s);
                    }
                }
                content.append("#").append(entry.comment.get()).append("\n");
                content.append(key).append("=").append(cfg.get(key)).append("\n");
            }
            if (changed) {
                FileWriter fw = new FileWriter(configurationFile, false);
                fw.write(content.toString());
                fw.close();
            }
            handleConfig(cfg);
        } catch (IOException e) {
            LOGGER.error("[Flonters] Could not read/write config! Stacktrace: " + e);
        }
    }

    private static int getInt(String s, Map<String, String> cfg) {
        return Integer.parseInt(cfg.get(s));
    }

    private static double getDouble(String s, Map<String, String> cfg) {
        return Double.parseDouble(cfg.get(s));
    }

    private static boolean getBool(String s, Map<String, String> cfg) {
        return Boolean.parseBoolean(cfg.get(s));
    }

    private static class Entry<T> {
        private final String key;
        private final T value;
        private final WeakReference<String> comment;
        private final Class<T> cls;

        private Entry(String key, T value, String comment, Class<T> cls) {
            this.key = key;
            this.value = value;
            this.comment = new WeakReference<>(comment);
            this.cls = cls;
        }

        public static Entry<Integer> of(String key, int value, String comment) {
            return new Entry<>(key, value, comment, Integer.class);
        }

        public static Entry<Double> of(String key, double value, String comment) {
            return new Entry<>(key, value, comment, Double.class);
        }

        public static Entry<Boolean> of(String key, boolean value, String comment) {
            return new Entry<>(key, value, comment, Boolean.class);
        }
    }
}
