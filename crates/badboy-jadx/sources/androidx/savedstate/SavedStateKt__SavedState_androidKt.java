package androidx.savedstate;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001aC\u0010\u0002\u001a\u00060\u0001j\u0002`\u00032\u0016\u0008\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0019\u0008\u0002\u0010\u0008\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0008\u000cH\u0086\u0008ø\u0001\u0000\u001a7\u0010\u0002\u001a\u00060\u0001j\u0002`\u00032\n\u0010\u0004\u001a\u00060\u0001j\u0002`\u00032\u0019\u0008\u0002\u0010\u0008\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0008\u000cH\u0086\u0008ø\u0001\u0000*\n\u0010\u0000\"\u00020\u00012\u00020\u0001\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\r", d2 = {"SavedState", "Landroid/os/Bundle;", "savedState", "Landroidx/savedstate/SavedState;", "initialState", "", "", "", "builderAction", "Lkotlin/Function1;", "Landroidx/savedstate/SavedStateWriter;", "", "Lkotlin/ExtensionFunctionType;", "savedstate_release"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/savedstate/SavedStateKt")
final class SavedStateKt__SavedState_androidKt {
    public static final Bundle savedState(Bundle initialState, Function1<? super androidx.savedstate.SavedStateWriter, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        int i = 0;
        Bundle bundle = new Bundle(initialState);
        final int i2 = 0;
        final int i3 = 0;
        builderAction.invoke(SavedStateWriter.box-impl(SavedStateWriter.constructor-impl(bundle)));
        return bundle;
    }

    public static final Bundle savedState(Map<String, ? extends Object> initialState, Function1<? super androidx.savedstate.SavedStateWriter, Unit> builderAction) {
        kotlin.Pair[] $i$f$toTypedArray;
        int arr;
        ArrayList list;
        ArrayList arrayList;
        Object obj;
        int i;
        Iterator iterator;
        boolean next;
        kotlin.Pair $i$a$MapSavedStateKt__SavedState_androidKt$savedState$pairs$1;
        Object key;
        Object value;
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        int i2 = 0;
        arr = 0;
        if (initialState.isEmpty()) {
            $i$f$toTypedArray = new Pair[arr];
        } else {
            Object obj2 = initialState;
            int i4 = 0;
            arrayList = new ArrayList(obj2.size());
            i = 0;
            iterator = obj2.entrySet().iterator();
            for (Map.Entry next : iterator) {
                int i7 = 0;
                (Collection)arrayList.add(TuplesKt.to((String)next.getKey(), next.getValue()));
            }
            int i3 = 0;
            $i$f$toTypedArray = (Collection)(List)arrayList.toArray(new Pair[arr]);
        }
        Bundle bundleOf = BundleKt.bundleOf((Pair[])Arrays.copyOf($i$f$toTypedArray, $i$f$toTypedArray.length));
        int i5 = 0;
        int i6 = 0;
        builderAction.invoke(SavedStateWriter.box-impl(SavedStateWriter.constructor-impl(bundleOf)));
        return bundleOf;
    }

    public static Bundle savedState$default(Bundle initialState, Function1 builderAction, int i3, Object object4) {
        androidx.savedstate.SavedStateKt__SavedState_androidKt.savedState.3 obj6;
        int obj7;
        if (i3 &= 2 != 0) {
            obj6 = obj7;
        }
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(obj6, "builderAction");
        obj7 = 0;
        Bundle obj8 = new Bundle(initialState);
        final int i = 0;
        final int i2 = 0;
        obj6.invoke(SavedStateWriter.box-impl(SavedStateWriter.constructor-impl(obj8)));
        return obj8;
    }

    public static Bundle savedState$default(Map initialState, Function1 builderAction, int i3, Object object4) {
        kotlin.Pair[] arr;
        ArrayList list;
        ArrayList arrayList;
        Map map;
        int i;
        Iterator iterator;
        boolean next;
        kotlin.Pair $i$a$MapSavedStateKt__SavedState_androidKt$savedState$pairs$1;
        Object key;
        Object value;
        Map obj10;
        androidx.savedstate.SavedStateKt__SavedState_androidKt.savedState.1 obj11;
        int obj12;
        Object[] obj13;
        if (i3 & 1 != 0) {
            obj10 = MapsKt.emptyMap();
        }
        if (i3 &= 2 != 0) {
            obj11 = obj12;
        }
        Intrinsics.checkNotNullParameter(obj10, "initialState");
        Intrinsics.checkNotNullParameter(obj11, "builderAction");
        obj12 = 0;
        arr = 0;
        if (obj10.isEmpty()) {
            obj13 = new Pair[arr];
        } else {
            obj13 = obj10;
            int i2 = 0;
            arrayList = new ArrayList(obj13.size());
            i = 0;
            iterator = obj13.entrySet().iterator();
            for (Map.Entry next : iterator) {
                int i6 = 0;
                (Collection)arrayList.add(TuplesKt.to((String)next.getKey(), next.getValue()));
            }
            obj13 = 0;
            obj13 = (Collection)(List)arrayList.toArray(new Pair[arr]);
        }
        Bundle bundleOf = BundleKt.bundleOf((Pair[])Arrays.copyOf(obj13, obj13.length));
        int i4 = 0;
        int i5 = 0;
        obj11.invoke(SavedStateWriter.box-impl(SavedStateWriter.constructor-impl(bundleOf)));
        return bundleOf;
    }
}
