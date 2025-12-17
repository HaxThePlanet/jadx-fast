package androidx.core.os;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes5.dex */
final class LocaleListCompatWrapper implements androidx.core.os.LocaleListInterface {

    private static final Locale EN_LATN;
    private static final Locale LOCALE_AR_XB;
    private static final Locale LOCALE_EN_XA;
    private static final Locale[] sEmptyList;
    private final Locale[] mList;
    private final String mStringRepresentation;

    static class Api21Impl {
        static String getScript(Locale locale) {
            return locale.getScript();
        }
    }
    static {
        LocaleListCompatWrapper.sEmptyList = new Locale[0];
        Locale locale = new Locale("en", "XA");
        LocaleListCompatWrapper.LOCALE_EN_XA = locale;
        Locale locale2 = new Locale("ar", "XB");
        LocaleListCompatWrapper.LOCALE_AR_XB = locale2;
        LocaleListCompatWrapper.EN_LATN = LocaleListCompat.forLanguageTagCompat("en-Latn");
    }

    LocaleListCompatWrapper(Locale... list) {
        Object arrayList;
        HashSet hashSet;
        StringBuilder stringBuilder;
        int i2;
        String string;
        int length;
        boolean contains;
        int i;
        super();
        if (list.length == 0) {
            this.mList = LocaleListCompatWrapper.sEmptyList;
            this.mStringRepresentation = "";
        } else {
            arrayList = new ArrayList();
            hashSet = new HashSet();
            stringBuilder = new StringBuilder();
            i2 = 0;
            for (Object length : list) {
                contains = length.clone();
                arrayList.add((Locale)contains);
                LocaleListCompatWrapper.toLanguageTag(stringBuilder, contains);
                if (!hashSet.contains(length) && i2 < length3--) {
                }
                contains = length.clone();
                arrayList.add((Locale)contains);
                LocaleListCompatWrapper.toLanguageTag(stringBuilder, contains);
                if (i2 < length3--) {
                }
                hashSet.add(contains);
                stringBuilder.append(',');
            }
            this.mList = (Locale[])arrayList.toArray(new Locale[0]);
            this.mStringRepresentation = stringBuilder.toString();
        }
    }

    private Locale computeFirstMatch(Collection<String> collection, boolean assumeEnglishIsSupported) {
        int i;
        final int firstMatchIndex = computeFirstMatchIndex(collection, assumeEnglishIsSupported);
        i = firstMatchIndex == -1 ? 0 : mList[firstMatchIndex];
        return i;
    }

    private int computeFirstMatchIndex(Collection<String> collection, boolean assumeEnglishIsSupported) {
        int bestIndex;
        int firstMatchIndex;
        Object next;
        Locale forLanguageTagCompat;
        int firstMatchIndex2;
        final int i3 = 0;
        if (mList.length == 1) {
            return i3;
        }
        if (mList2.length == 0) {
            return -1;
        }
        firstMatchIndex = findFirstMatchIndex(LocaleListCompatWrapper.EN_LATN);
        if (assumeEnglishIsSupported && firstMatchIndex == 0) {
            firstMatchIndex = findFirstMatchIndex(LocaleListCompatWrapper.EN_LATN);
            if (firstMatchIndex == 0) {
                return i3;
            }
            if (firstMatchIndex < Integer.MAX_VALUE) {
                bestIndex = firstMatchIndex;
            }
        }
        Iterator iterator = collection.iterator();
        for (String next : iterator) {
            firstMatchIndex2 = findFirstMatchIndex(LocaleListCompat.forLanguageTagCompat(next));
            if (firstMatchIndex2 < bestIndex) {
            }
            bestIndex = firstMatchIndex2;
        }
        if (bestIndex == Integer.MAX_VALUE) {
            return i3;
        }
        return bestIndex;
    }

    private int findFirstMatchIndex(Locale supportedLocale) {
        int idx;
        int matchScore;
        idx = 0;
        for (Object locale : obj1) {
        }
        return Integer.MAX_VALUE;
    }

    private static String getLikelyScript(Locale locale) {
        final String script = LocaleListCompatWrapper.Api21Impl.getScript(locale);
        if (!script.isEmpty()) {
            return script;
        }
        return "";
    }

    private static boolean isPseudoLocale(Locale locale) {
        int i;
        boolean equals;
        if (!LocaleListCompatWrapper.LOCALE_EN_XA.equals(locale)) {
            if (LocaleListCompatWrapper.LOCALE_AR_XB.equals(locale)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static int matchScore(Locale supported, Locale desired) {
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
        if (!LocaleListCompatWrapper.isPseudoLocale(supported)) {
            if (LocaleListCompatWrapper.isPseudoLocale(desired)) {
            } else {
                String likelyScript = LocaleListCompatWrapper.getLikelyScript(supported);
                if (likelyScript.isEmpty()) {
                    String country = supported.getCountry();
                    if (!country.isEmpty()) {
                        if (country.equals(desired.getCountry())) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                    return i;
                }
            }
            return likelyScript.equals(LocaleListCompatWrapper.getLikelyScript(desired));
        }
        return i2;
    }

    static void toLanguageTag(StringBuilder builder, Locale locale) {
        boolean country;
        builder.append(locale.getLanguage());
        String country2 = locale.getCountry();
        if (country2 != null && !country2.isEmpty()) {
            if (!country2.isEmpty()) {
                builder.append('-');
                builder.append(locale.getCountry());
            }
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean equals(Object other) {
        int i;
        int length;
        Locale locale;
        final int i2 = 1;
        if (other == this) {
            return i2;
        }
        final int i3 = 0;
        if (!other instanceof LocaleListCompatWrapper) {
            return i3;
        }
        Locale[] mList = obj.mList;
        if (mList2.length != mList.length) {
            return i3;
        }
        i = 0;
        for (Object locale2 : obj4) {
        }
        return i2;
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int index) {
        int length;
        int i;
        if (index >= 0 && index < mList.length) {
            i = index < mList.length ? mList2[index] : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale getFirstMatch(String[] supportedLocales) {
        return computeFirstMatch(Arrays.asList(supportedLocales), false);
    }

    @Override // androidx.core.os.LocaleListInterface
    public Object getLocaleList() {
        return null;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int hashCode() {
        int result;
        int i;
        Locale locale;
        int i3;
        int i2;
        result = 1;
        final Locale[] mList = this.mList;
        i = 0;
        while (i < mList.length) {
            result = i3 + i2;
            i++;
        }
        return result;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(Locale locale) {
        int i;
        boolean equals;
        i = 0;
        for (Object locale2 : obj1) {
        }
        return -1;
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        int i;
        i = mList.length == 0 ? 1 : 0;
        return i;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return mList.length;
    }

    @Override // androidx.core.os.LocaleListInterface
    public String toLanguageTags() {
        return this.mStringRepresentation;
    }

    @Override // androidx.core.os.LocaleListInterface
    public String toString() {
        int i2;
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        i2 = 0;
        while (i2 < mList.length) {
            stringBuilder.append(this.mList[i2]);
            if (i2 < length2--) {
            }
            i2++;
            stringBuilder.append(',');
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
