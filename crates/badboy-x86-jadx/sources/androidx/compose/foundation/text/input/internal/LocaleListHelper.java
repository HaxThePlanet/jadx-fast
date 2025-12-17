package androidx.compose.foundation.text.input.internal;

import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.LocaleList.Companion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0007¨\u0006\t", d2 = {"Landroidx/compose/foundation/text/input/internal/LocaleListHelper;", "", "()V", "setHintLocales", "", "editorInfo", "Landroid/view/inputmethod/EditorInfo;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LocaleListHelper {

    public static final int $stable;
    public static final androidx.compose.foundation.text.input.internal.LocaleListHelper INSTANCE;
    static {
        LocaleListHelper localeListHelper = new LocaleListHelper();
        LocaleListHelper.INSTANCE = localeListHelper;
    }

    public final void setHintLocales(EditorInfo editorInfo, LocaleList localeList) {
        int copyOf;
        LocaleList localeList2;
        ArrayList arrayList;
        java.util.Locale[] arr;
        int i2;
        Iterator iterator;
        boolean next;
        java.util.Locale it;
        int i;
        if (Intrinsics.areEqual(localeList, LocaleList.Companion.getEmpty())) {
            editorInfo.hintLocales = 0;
        } else {
            Object obj = localeList;
            int i4 = 0;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)obj, 10));
            i2 = 0;
            iterator = obj.iterator();
            for (Object next : iterator) {
                i = 0;
                (Collection)arrayList.add((Locale)next.getPlatformLocale());
            }
            int i3 = 0;
            Object[] $i$f$toTypedArray = (Collection)(List)arrayList.toArray(new Locale[0]);
            localeList2 = new LocaleList((Locale[])Arrays.copyOf((Locale[])$i$f$toTypedArray, $i$f$toTypedArray.length));
            editorInfo.hintLocales = localeList2;
        }
    }
}
