package androidx.core.os;

import android.content.res.Configuration;
import android.os.LocaleList;

/* loaded from: classes5.dex */
public final class ConfigurationCompat {

    static class Api24Impl {
        static LocaleList getLocales(Configuration configuration) {
            return configuration.getLocales();
        }

        static void setLocales(Configuration configuration, androidx.core.os.LocaleListCompat locales) {
            configuration.setLocales((LocaleList)locales.unwrap());
        }
    }
    public static androidx.core.os.LocaleListCompat getLocales(Configuration configuration) {
        return LocaleListCompat.wrap(ConfigurationCompat.Api24Impl.getLocales(configuration));
    }

    public static void setLocales(Configuration configuration, androidx.core.os.LocaleListCompat locales) {
        ConfigurationCompat.Api24Impl.setLocales(configuration, locales);
    }
}
