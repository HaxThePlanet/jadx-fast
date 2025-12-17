package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import androidx.core.os.LocaleListCompat;
import java.util.Locale;

/* loaded from: classes5.dex */
public final class LocaleManagerCompat {

    static class Api21Impl {
        static String toLanguageTag(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    static class Api24Impl {
        static LocaleListCompat getLocales(Configuration configuration) {
            return LocaleListCompat.forLanguageTags(configuration.getLocales().toLanguageTags());
        }
    }

    static class Api33Impl {
        static LocaleList localeManagerGetApplicationLocales(Object localeManager) {
            return (LocaleManager)localeManager.getApplicationLocales();
        }

        static LocaleList localeManagerGetSystemLocales(Object localeManager) {
            return (LocaleManager)localeManager.getSystemLocales();
        }
    }
    public static LocaleListCompat getApplicationLocales(Context context) {
        Object localeManagerForApplication = LocaleManagerCompat.getLocaleManagerForApplication(context);
        if (Build.VERSION.SDK_INT >= 33 && localeManagerForApplication != null) {
            localeManagerForApplication = LocaleManagerCompat.getLocaleManagerForApplication(context);
            if (localeManagerForApplication != null) {
                return LocaleListCompat.wrap(LocaleManagerCompat.Api33Impl.localeManagerGetApplicationLocales(localeManagerForApplication));
            }
            return LocaleListCompat.getEmptyLocaleList();
        }
        return LocaleListCompat.forLanguageTags(AppLocalesStorageHelper.readLocales(context));
    }

    static LocaleListCompat getConfigurationLocales(Configuration conf) {
        return LocaleManagerCompat.Api24Impl.getLocales(conf);
    }

    private static Object getLocaleManagerForApplication(Context context) {
        return context.getSystemService("locale");
    }

    public static LocaleListCompat getSystemLocales(Context context) {
        LocaleListCompat systemLocales;
        Object localeManagerForApplication;
        int localeManagerGetSystemLocales;
        systemLocales = LocaleListCompat.getEmptyLocaleList();
        if (Build.VERSION.SDK_INT >= 33) {
            localeManagerForApplication = LocaleManagerCompat.getLocaleManagerForApplication(context);
            if (localeManagerForApplication != null) {
                systemLocales = LocaleListCompat.wrap(LocaleManagerCompat.Api33Impl.localeManagerGetSystemLocales(localeManagerForApplication));
            }
        } else {
            systemLocales = LocaleManagerCompat.getConfigurationLocales(Resources.getSystem().getConfiguration());
        }
        return systemLocales;
    }
}
