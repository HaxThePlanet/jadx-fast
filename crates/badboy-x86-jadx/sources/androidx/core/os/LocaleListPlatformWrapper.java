package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes5.dex */
final class LocaleListPlatformWrapper implements androidx.core.os.LocaleListInterface {

    private final LocaleList mLocaleList;
    LocaleListPlatformWrapper(Object localeList) {
        super();
        this.mLocaleList = (LocaleList)localeList;
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean equals(Object other) {
        return this.mLocaleList.equals((LocaleListInterface)other.getLocaleList());
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int index) {
        return this.mLocaleList.get(index);
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale getFirstMatch(String[] supportedLocales) {
        return this.mLocaleList.getFirstMatch(supportedLocales);
    }

    @Override // androidx.core.os.LocaleListInterface
    public Object getLocaleList() {
        return this.mLocaleList;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int hashCode() {
        return this.mLocaleList.hashCode();
    }

    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(Locale locale) {
        return this.mLocaleList.indexOf(locale);
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        return this.mLocaleList.isEmpty();
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return this.mLocaleList.size();
    }

    @Override // androidx.core.os.LocaleListInterface
    public String toLanguageTags() {
        return this.mLocaleList.toLanguageTags();
    }

    @Override // androidx.core.os.LocaleListInterface
    public String toString() {
        return this.mLocaleList.toString();
    }
}
