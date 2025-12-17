package androidx.core.os;

import java.util.Locale;

/* loaded from: classes5.dex */
interface LocaleListInterface {
    public abstract Locale get(int i);

    public abstract Locale getFirstMatch(String[] stringArr);

    public abstract Object getLocaleList();

    public abstract int indexOf(Locale locale);

    public abstract boolean isEmpty();

    public abstract int size();

    public abstract String toLanguageTags();
}
