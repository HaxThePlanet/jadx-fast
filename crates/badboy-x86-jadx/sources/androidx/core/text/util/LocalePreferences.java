package androidx.core.text.util;

import android.icu.number.FormattedNumber;
import android.icu.number.LocalizedNumberFormatter;
import android.icu.number.NumberFormatter;
import android.icu.number.UnlocalizedNumberFormatter;
import android.icu.text.DateFormat.HourCycle;
import android.icu.text.DateTimePatternGenerator;
import android.icu.util.Calendar;
import android.icu.util.MeasureUnit;
import android.os.Build.VERSION;
import android.text.format.DateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.Locale.Category;

/* loaded from: classes5.dex */
public final class LocalePreferences {

    private static final String TAG;
    private static final String[] WEATHER_FAHRENHEIT_COUNTRIES;

    private static class Api24Impl {
        static String getCalendarType(Locale locale) {
            return Calendar.getInstance(locale).getType();
        }

        static Locale getDefaultLocale() {
            return Locale.getDefault(Locale.Category.FORMAT);
        }
    }

    private static class Api33Impl {
        static String getHourCycle(Locale locale) {
            return LocalePreferences.Api33Impl.getHourCycleType(DateTimePatternGenerator.getInstance(locale).getDefaultHourCycle());
        }

        private static String getHourCycleType(DateFormat.HourCycle hourCycle) {
            switch (i) {
                case 1:
                    return "h11";
                case 2:
                    return "h12";
                case 3:
                    return "h23";
                case 4:
                    return "h24";
                default:
                    return "";
            }
        }

        static String getResolvedTemperatureUnit(Locale locale) {
            String identifier = (UnlocalizedNumberFormatter)(UnlocalizedNumberFormatter)NumberFormatter.with().usage("weather").unit(MeasureUnit.CELSIUS).locale(locale).format(1).getOutputUnit().getIdentifier();
            final String str2 = "fahrenhe";
            if (identifier.startsWith(str2)) {
                return str2;
            }
            return identifier;
        }
    }

    public static class CalendarType {

        public static final String CHINESE = "chinese";
        public static final String DANGI = "dangi";
        public static final String DEFAULT = "";
        public static final String GREGORIAN = "gregorian";
        public static final String HEBREW = "hebrew";
        public static final String INDIAN = "indian";
        public static final String ISLAMIC = "islamic";
        public static final String ISLAMIC_CIVIL = "islamic-civil";
        public static final String ISLAMIC_RGSA = "islamic-rgsa";
        public static final String ISLAMIC_TBLA = "islamic-tbla";
        public static final String ISLAMIC_UMALQURA = "islamic-umalqura";
        public static final String PERSIAN = "persian";
        private static final String U_EXTENSION_TAG = "ca";
    }

    public static class FirstDayOfWeek {

        public static final String DEFAULT = "";
        public static final String FRIDAY = "fri";
        public static final String MONDAY = "mon";
        public static final String SATURDAY = "sat";
        public static final String SUNDAY = "sun";
        public static final String THURSDAY = "thu";
        public static final String TUESDAY = "tue";
        private static final String U_EXTENSION_TAG = "fw";
        public static final String WEDNESDAY = "wed";
    }

    public static class HourCycle {

        public static final String DEFAULT = "";
        public static final String H11 = "h11";
        public static final String H12 = "h12";
        public static final String H23 = "h23";
        public static final String H24 = "h24";
        private static final String U_EXTENSION_TAG = "hc";
    }

    public static class TemperatureUnit {

        public static final String CELSIUS = "celsius";
        public static final String DEFAULT = "";
        public static final String FAHRENHEIT = "fahrenhe";
        public static final String KELVIN = "kelvin";
        private static final String U_EXTENSION_TAG = "mu";
    }
    static {
        LocalePreferences.TAG = LocalePreferences.class.getSimpleName();
        String[] strArr = new String[6];
        LocalePreferences.WEATHER_FAHRENHEIT_COUNTRIES = strArr;
    }

    private static String getBaseFirstDayOfWeek(Locale locale) {
        return LocalePreferences.getStringOfFirstDayOfWeek(Calendar.getInstance(locale).getFirstDayOfWeek());
    }

    private static String getBaseHourCycle(Locale locale) {
        String str;
        str = DateFormat.getBestDateTimePattern(locale, "jm").contains("H") ? "h23" : "h12";
        return str;
    }

    public static String getCalendarType() {
        return LocalePreferences.getCalendarType(true);
    }

    public static String getCalendarType(Locale locale) {
        return LocalePreferences.getCalendarType(locale, true);
    }

    public static String getCalendarType(Locale locale, boolean resolved) {
        String unicodeLocaleType = LocalePreferences.getUnicodeLocaleType("ca", "", locale, resolved);
        if (unicodeLocaleType != null) {
            return unicodeLocaleType;
        }
        return LocalePreferences.Api24Impl.getCalendarType(locale);
    }

    public static String getCalendarType(boolean resolved) {
        return LocalePreferences.getCalendarType(LocalePreferences.Api24Impl.getDefaultLocale(), resolved);
    }

    private static Locale getDefaultLocale() {
        return Locale.getDefault();
    }

    public static String getFirstDayOfWeek() {
        return LocalePreferences.getFirstDayOfWeek(true);
    }

    public static String getFirstDayOfWeek(Locale locale) {
        return LocalePreferences.getFirstDayOfWeek(locale, true);
    }

    public static String getFirstDayOfWeek(Locale locale, boolean resolved) {
        String baseFirstDayOfWeek;
        String unicodeLocaleType = LocalePreferences.getUnicodeLocaleType("fw", "", locale, resolved);
        if (unicodeLocaleType != null) {
            baseFirstDayOfWeek = unicodeLocaleType;
        } else {
            baseFirstDayOfWeek = LocalePreferences.getBaseFirstDayOfWeek(locale);
        }
        return baseFirstDayOfWeek;
    }

    public static String getFirstDayOfWeek(boolean resolved) {
        return LocalePreferences.getFirstDayOfWeek(LocalePreferences.Api24Impl.getDefaultLocale(), resolved);
    }

    public static String getHourCycle() {
        return LocalePreferences.getHourCycle(true);
    }

    public static String getHourCycle(Locale locale) {
        return LocalePreferences.getHourCycle(locale, true);
    }

    public static String getHourCycle(Locale locale, boolean resolved) {
        String unicodeLocaleType = LocalePreferences.getUnicodeLocaleType("hc", "", locale, resolved);
        if (unicodeLocaleType != null) {
            return unicodeLocaleType;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return LocalePreferences.Api33Impl.getHourCycle(locale);
        }
        return LocalePreferences.getBaseHourCycle(locale);
    }

    public static String getHourCycle(boolean resolved) {
        return LocalePreferences.getHourCycle(LocalePreferences.Api24Impl.getDefaultLocale(), resolved);
    }

    private static String getStringOfFirstDayOfWeek(int fw) {
        String str;
        int i = 7;
        final String[] strArr = new String[i];
        strArr[0] = "sun";
        int i9 = 1;
        strArr[i9] = "mon";
        strArr[2] = "tue";
        strArr[3] = "wed";
        strArr[4] = "thu";
        strArr[5] = "fri";
        strArr[6] = "sat";
        if (fw >= i9 && fw <= i) {
            str = fw <= i ? strArr[i2] : "";
        } else {
        }
        return str;
    }

    private static String getTemperatureHardCoded(Locale locale) {
        String str;
        str = Arrays.binarySearch(LocalePreferences.WEATHER_FAHRENHEIT_COUNTRIES, locale.getCountry()) >= 0 ? "fahrenhe" : "celsius";
        return str;
    }

    public static String getTemperatureUnit() {
        return LocalePreferences.getTemperatureUnit(true);
    }

    public static String getTemperatureUnit(Locale locale) {
        return LocalePreferences.getTemperatureUnit(locale, true);
    }

    public static String getTemperatureUnit(Locale locale, boolean resolved) {
        String unicodeLocaleType = LocalePreferences.getUnicodeLocaleType("mu", "", locale, resolved);
        if (unicodeLocaleType != null) {
            return unicodeLocaleType;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return LocalePreferences.Api33Impl.getResolvedTemperatureUnit(locale);
        }
        return LocalePreferences.getTemperatureHardCoded(locale);
    }

    public static String getTemperatureUnit(boolean resolved) {
        return LocalePreferences.getTemperatureUnit(LocalePreferences.Api24Impl.getDefaultLocale(), resolved);
    }

    private static String getUnicodeLocaleType(String tag, String defaultValue, Locale locale, boolean resolved) {
        final String unicodeLocaleType = locale.getUnicodeLocaleType(tag);
        if (unicodeLocaleType != null) {
            return unicodeLocaleType;
        }
        if (!resolved) {
            return defaultValue;
        }
        return null;
    }
}
