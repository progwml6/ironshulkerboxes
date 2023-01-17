package com.progwml6.ironshulkerbox.common;

import net.minecraftforge.common.ForgeI18n;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class Util {

  public static String toEnglishName(String internalName) {
    return Arrays.stream(internalName.toLowerCase(Locale.ROOT).split("_"))
      .map(StringUtils::capitalize)
      .collect(Collectors.joining(" "));
  }

  /**
   * Checks if a key can be translated
   *
   * @param key Key to check
   * @return True if its translatable
   */
  public static boolean canTranslate(String key) {
    return !key.equals(ForgeI18n.getPattern(key));
  }

  /**
   * Better documented way to check if something is translated, use instead of {@link #canTranslate(String)} if you want to reuse the result.
   *
   * @param key       Key to check
   * @param attempted Attempted translation result
   * @return True if its translatable
   */
  public static boolean canTranslate(String key, String attempted) {
    return !key.equals(attempted);
  }
}
