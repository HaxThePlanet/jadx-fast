package androidx.core.text;

import android.icu.util.ULocale;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes5.dex */
public final class ICUCompat {

    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    static class Api21Impl {
        static String getScript(Locale locale) {
            return locale.getScript();
        }
    }

    static class Api24Impl {
        static ULocale addLikelySubtags(Object loc) {
            return ULocale.addLikelySubtags((ULocale)loc);
        }

        static ULocale forLocale(Locale loc) {
            return ULocale.forLocale(loc);
        }

        static String getScript(Object uLocale) {
            return (ULocale)uLocale.getScript();
        }
    }
    static {
    }

    private static String addLikelySubtagsBelowApi21(Locale locale) {
        Method sAddLikelySubtagsMethod;
        final String str = "ICUCompat";
        final String string = locale.toString();
        if (ICUCompat.sAddLikelySubtagsMethod != null) {
            return (String)ICUCompat.sAddLikelySubtagsMethod.invoke(0, /* result */);
        }
        return string;
    }

    private static String getScriptBelowApi21(String localeStr) {
        Method sGetScriptMethod;
        final String str = "ICUCompat";
        final int i = 0;
        if (ICUCompat.sGetScriptMethod != null) {
            return (String)ICUCompat.sGetScriptMethod.invoke(i, /* result */);
        }
        return i;
    }

    public static String maximizeAndGetScript(Locale locale) {
        return ICUCompat.Api24Impl.getScript(ICUCompat.Api24Impl.addLikelySubtags(ICUCompat.Api24Impl.forLocale(locale)));
    }
}
