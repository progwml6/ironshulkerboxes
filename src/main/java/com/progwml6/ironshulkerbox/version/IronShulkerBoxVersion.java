package com.progwml6.ironshulkerbox.version;

import net.minecraftforge.fml.loading.JarVersionLookupHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.minecraftforge.fml.Logging.CORE;

public class IronShulkerBoxVersion
{
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String ironShulkerBoxVersion;

    static {
        LOGGER.debug(CORE, "Iron Shulker Box Version package {} from {}", IronShulkerBoxVersion.class.getPackage(), IronShulkerBoxVersion.class.getClassLoader());

        String vers = JarVersionLookupHandler.getImplementationVersion(IronShulkerBoxVersion.class).orElse("null");
        if (vers == null || vers == "null") throw new RuntimeException("Missing Iron Shulker Box version, cannot continue");
        ironShulkerBoxVersion = vers;
        LOGGER.debug(CORE, "Found Iron Shulker Box version {}", ironShulkerBoxVersion);
    }

    public static String getVersion()
    {
        return ironShulkerBoxVersion;
    }
}
