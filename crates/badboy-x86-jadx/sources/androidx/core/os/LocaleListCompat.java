package androidx.core.os;

import android.os.Build.VERSION;
import android.os.LocaleList;
import androidx.core.text.ICUCompat;
import java.util.Locale;

/* loaded from: classes5.dex */
public final class LocaleListCompat {

    private static final androidx.core.os.LocaleListCompat sEmptyLocaleList;
    private final androidx.core.os.LocaleListInterface mImpl;

    static class Api21Impl {

        private static final Locale[] PSEUDO_LOCALE;
        static {
            Locale[] arr = new Locale[2];
            Locale locale = new Locale("en", "XA");
            Locale locale2 = new Locale("ar", "XB");
            LocaleListCompat.Api21Impl.PSEUDO_LOCALE = arr;
        }

        static Locale forLanguageTag(String languageTag) {
            return Locale.forLanguageTag(languageTag);
        }

        private static boolean isPseudoLocale(Locale locale) {
            int i;
            Locale locale2;
            boolean equals;
            Locale[] pSEUDO_LOCALE = LocaleListCompat.Api21Impl.PSEUDO_LOCALE;
            final int i3 = 0;
            i = i3;
            while (i < pSEUDO_LOCALE.length) {
                i++;
            }
            return i3;
        }

        static boolean matchesLanguageAndScript(Locale supported, Locale desired) {
            boolean pseudoLocale;
            int i;
            boolean equals;
            if (supported.equals(desired)) {
                return 1;
            }
            int i2 = 0;
            if (!supported.getLanguage().equals(desired.getLanguage())) {
                return i2;
            }
            if (!LocaleListCompat.Api21Impl.isPseudoLocale(supported)) {
                if (LocaleListCompat.Api21Impl.isPseudoLocale(desired)) {
                } else {
                    String maximizeAndGetScript = ICUCompat.maximizeAndGetScript(supported);
                    String country = supported.getCountry();
                    if (maximizeAndGetScript.isEmpty() && !country.isEmpty()) {
                        country = supported.getCountry();
                        if (!country.isEmpty()) {
                            if (country.equals(desired.getCountry())) {
                            } else {
                                i = i2;
                            }
                        }
                        return i;
                    }
                }
                return maximizeAndGetScript.equals(ICUCompat.maximizeAndGetScript(desired));
            }
            return i2;
        }
    }

    static class Api24Impl {
        static LocaleList createLocaleList(Locale... list) {
            LocaleList localeList = new LocaleList(list);
            return localeList;
        }

        static LocaleList getAdjustedDefault() {
            return LocaleList.getAdjustedDefault();
        }

        static LocaleList getDefault() {
            return LocaleList.getDefault();
        }
    }
    static {
        LocaleListCompat.sEmptyLocaleList = LocaleListCompat.create(new Locale[0]);
    }

    private LocaleListCompat(androidx.core.os.LocaleListInterface impl) {
        super();
        this.mImpl = impl;
    }

    public static androidx.core.os.LocaleListCompat create(Locale... localeList) {
        return LocaleListCompat.wrap(LocaleListCompat.Api24Impl.createLocaleList(localeList));
    }

    static Locale forLanguageTagCompat(String str) {
        String[] split;
        int length;
        String str2 = "-";
        int i = -1;
        int i2 = 2;
        int i3 = 0;
        final int i4 = 1;
        if (str.contains(str2)) {
            split = str.split(str2, i);
            if (split.length > i2) {
                Locale locale4 = new Locale(split[i3], split[i4], split[i2]);
                return locale4;
            }
            if (split.length > i4) {
                Locale locale2 = new Locale(split[i3], split[i4]);
                return locale2;
            }
            if (split.length == i4) {
                Locale locale3 = new Locale(split[i3]);
                return locale3;
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Can not parse language tag: [").append(str).append("]").toString());
            throw illegalArgumentException;
        } else {
            String str3 = "_";
            split = str.split(str3, i);
            if (str.contains(str3) && split.length > i2) {
                split = str.split(str3, i);
                if (split.length > i2) {
                    Locale locale7 = new Locale(split[i3], split[i4], split[i2]);
                    return locale7;
                }
                if (split.length > i4) {
                    Locale locale5 = new Locale(split[i3], split[i4]);
                    return locale5;
                }
                if (split.length == i4) {
                    Locale locale6 = new Locale(split[i3]);
                    return locale6;
                }
            }
        }
        Locale locale = new Locale(str);
        return locale;
    }

    public static androidx.core.os.LocaleListCompat forLanguageTags(String list) {
        boolean empty;
        int i;
        Locale forLanguageTag;
        if (list != null) {
            if (list.isEmpty()) {
            } else {
                String[] split = list.split(",", -1);
                Locale[] arr = new Locale[split.length];
                i = 0;
                while (i < arr.length) {
                    arr[i] = LocaleListCompat.Api21Impl.forLanguageTag(split[i]);
                    i++;
                }
            }
            return LocaleListCompat.create(arr);
        }
        return LocaleListCompat.getEmptyLocaleList();
    }

    public static androidx.core.os.LocaleListCompat getAdjustedDefault() {
        return LocaleListCompat.wrap(LocaleListCompat.Api24Impl.getAdjustedDefault());
    }

    public static androidx.core.os.LocaleListCompat getDefault() {
        return LocaleListCompat.wrap(LocaleListCompat.Api24Impl.getDefault());
    }

    public static androidx.core.os.LocaleListCompat getEmptyLocaleList() {
        return LocaleListCompat.sEmptyLocaleList;
    }

    public static boolean matchesLanguageAndScript(Locale supported, Locale desired) {
        if (Build.VERSION.SDK_INT >= 33) {
            return LocaleList.matchesLanguageAndScript(supported, desired);
        }
        return LocaleListCompat.Api21Impl.matchesLanguageAndScript(supported, desired);
    }

    public static androidx.core.os.LocaleListCompat wrap(LocaleList localeList) {
        LocaleListPlatformWrapper localeListPlatformWrapper = new LocaleListPlatformWrapper(localeList);
        LocaleListCompat localeListCompat = new LocaleListCompat(localeListPlatformWrapper);
        return localeListCompat;
    }

    @Deprecated
    public static androidx.core.os.LocaleListCompat wrap(Object localeList) {
        return LocaleListCompat.wrap((LocaleList)localeList);
    }

    public boolean equals(Object other) {
        boolean equals;
        int i;
        androidx.core.os.LocaleListInterface mImpl;
        if (other instanceof LocaleListCompat && this.mImpl.equals(obj.mImpl)) {
            i = this.mImpl.equals(obj.mImpl) ? 1 : 0;
        } else {
        }
        return i;
    }

    public Locale get(int index) {
        return this.mImpl.get(index);
    }

    public Locale getFirstMatch(String[] supportedLocales) {
        return this.mImpl.getFirstMatch(supportedLocales);
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public int indexOf(Locale locale) {
        return this.mImpl.indexOf(locale);
    }

    public boolean isEmpty() {
        return this.mImpl.isEmpty();
    }

    public int size() {
        return this.mImpl.size();
    }

    public String toLanguageTags() {
        return this.mImpl.toLanguageTags();
    }

    public String toString() {
        return this.mImpl.toString();
    }

    public Object unwrap() {
        return this.mImpl.getLocaleList();
    }
}
