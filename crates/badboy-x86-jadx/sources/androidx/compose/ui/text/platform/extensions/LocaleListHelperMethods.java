package androidx.compose.ui.text.platform.extensions;

import android.os.LocaleList;
import android.text.style.LocaleSpan;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\n", d2 = {"Landroidx/compose/ui/text/platform/extensions/LocaleListHelperMethods;", "", "()V", "localeSpan", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "setTextLocales", "", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LocaleListHelperMethods {

    public static final int $stable;
    public static final androidx.compose.ui.text.platform.extensions.LocaleListHelperMethods INSTANCE;
    static {
        LocaleListHelperMethods localeListHelperMethods = new LocaleListHelperMethods();
        LocaleListHelperMethods.INSTANCE = localeListHelperMethods;
    }

    public final Object localeSpan(LocaleList localeList) {
        Object next;
        java.util.Locale it;
        int i;
        Iterable iterable = localeList;
        int i3 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, 10));
        final int i6 = 0;
        final Iterator iterator = iterable.iterator();
        for (Object next : iterator) {
            i = 0;
            (Collection)arrayList.add((Locale)next.getPlatformLocale());
        }
        int i2 = 0;
        Object[] $i$f$toTypedArray = (Collection)(List)arrayList.toArray(new Locale[0]);
        LocaleList localeList2 = new LocaleList((Locale[])Arrays.copyOf((Locale[])$i$f$toTypedArray, $i$f$toTypedArray.length));
        LocaleSpan localeSpan = new LocaleSpan(localeList2);
        return localeSpan;
    }

    public final void setTextLocales(AndroidTextPaint textPaint, LocaleList localeList) {
        Object next;
        java.util.Locale it;
        int i;
        Iterable iterable = localeList;
        int i3 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, 10));
        final int i6 = 0;
        final Iterator iterator = iterable.iterator();
        for (Object next : iterator) {
            i = 0;
            (Collection)arrayList.add((Locale)next.getPlatformLocale());
        }
        int i2 = 0;
        Object[] $i$f$toTypedArray = (Collection)(List)arrayList.toArray(new Locale[0]);
        LocaleList localeList2 = new LocaleList((Locale[])Arrays.copyOf((Locale[])$i$f$toTypedArray, $i$f$toTypedArray.length));
        textPaint.setTextLocales(localeList2);
    }
}
