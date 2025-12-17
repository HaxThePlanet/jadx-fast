package androidx.compose.runtime.internal;

import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.PersistentCompositionLocalMap.Builder;
import androidx.compose.runtime.ValueHolder;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0008\u0010\u0000\u001a\u00020\u0001H\u0000\u001aY\u0010\u0000\u001a\u00020\u00022J\u0010\u0003\u001a&\u0012\"\u0008\u0001\u0012\u001e\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00080\u00050\u0004\"\u001e\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00080\u0005H\u0000¢\u0006\u0002\u0010\t¨\u0006\n", d2 = {"persistentCompositionLocalHashMapOf", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "pairs", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/ValueHolder;", "([Lkotlin/Pair;)Landroidx/compose/runtime/PersistentCompositionLocalMap;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PersistentCompositionLocalMapKt {
    public static final PersistentCompositionLocalMap persistentCompositionLocalHashMapOf(Pair<? extends CompositionLocal<Object>, ? extends ValueHolder<Object>>... pairs) {
        final int i = 0;
        final PersistentCompositionLocalMap.Builder builder = (PersistentCompositionLocalMap)PersistentCompositionLocalHashMap.Companion.getEmpty().builder();
        final int i2 = 0;
        MapsKt.putAll((Map)builder, pairs);
        return builder.build();
    }

    public static final androidx.compose.runtime.internal.PersistentCompositionLocalHashMap persistentCompositionLocalHashMapOf() {
        return PersistentCompositionLocalHashMap.Companion.getEmpty();
    }
}
