package androidx.compose.runtime.collection;

import androidx.collection.ScatterSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u00020\u0001*\u0008\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005H\u0080\u0008\u001a1\u0010\u0006\u001a\u00020\u0007\"\u0008\u0008\u0000\u0010\u0008*\u00020\u0003*\u0008\u0012\u0004\u0012\u0002H\u00080\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\u0008\u001a\u001e\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0002\"\u0004\u0008\u0000\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\u00080\nH\u0000¨\u0006\u000b", d2 = {"fastAny", "", "", "", "block", "Lkotlin/Function1;", "fastForEach", "", "T", "wrapIntoSet", "Landroidx/collection/ScatterSet;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScatterSetWrapperKt {
    public static final boolean fastAny(Set<? extends Object> $this$fastAny, Function1<Object, Boolean> block) {
        Object $i$f$fastAny2;
        int set$runtime_release;
        int j$iv$iv$iv;
        boolean empty;
        long j$iv$iv$iv2;
        Object $i$f$isFull;
        boolean booleanValue;
        ScatterSet set;
        int i3;
        Object[] elements;
        ScatterSet set3;
        int i5;
        long[] metadata;
        int i4;
        int i$iv$iv$iv;
        long slot$iv$iv$iv;
        int $i$f$fastAny;
        ScatterSet set2;
        int cmp;
        long l;
        int i;
        int i2;
        boolean booleanValue2;
        final Object obj = $this$fastAny;
        final Object obj2 = block;
        $i$f$fastAny2 = 0;
        if (obj instanceof ScatterSetWrapper) {
            set$runtime_release = (ScatterSetWrapper)obj.getSet$runtime_release();
            booleanValue = 0;
            set = set$runtime_release;
            i3 = 0;
            i5 = 0;
            metadata = set3.metadata;
            length += -2;
            if (0 <= i4) {
            } else {
                $i$f$fastAny = $i$f$fastAny2;
                set2 = set$runtime_release;
                j$iv$iv$iv = 0;
            }
        } else {
            $i$f$fastAny = $i$f$fastAny2;
            $i$f$fastAny2 = obj;
            set$runtime_release = 0;
            if ($i$f$fastAny2 instanceof Collection != null && (Collection)(Iterable)$i$f$fastAny2.isEmpty()) {
                if ((Collection)$i$f$fastAny2.isEmpty()) {
                    j$iv$iv$iv = 0;
                } else {
                    Iterator iterator = $i$f$fastAny2.iterator();
                    for (Object $i$f$isFull : iterator) {
                    }
                    j$iv$iv$iv = 0;
                }
            } else {
            }
        }
        return j$iv$iv$iv;
    }

    public static final <T> void fastForEach(Set<? extends T> $this$fastForEach, Function1<? super T, Unit> block) {
        int $i$f$fastForEach2;
        int set$runtime_release;
        int iterator;
        Object[] elements;
        Object next;
        ScatterSet set;
        int i2;
        long[] metadata;
        int i5;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i6;
        int i4;
        int $i$f$fastForEach;
        ScatterSet set2;
        long l;
        int i;
        int i3;
        final Object obj = $this$fastForEach;
        final Object obj2 = block;
        $i$f$fastForEach2 = 0;
        if (obj instanceof ScatterSetWrapper) {
            set$runtime_release = (ScatterSetWrapper)obj.getSet$runtime_release();
            iterator = 0;
            i2 = 0;
            metadata = set.metadata;
            length += -2;
            if (0 <= i5) {
            } else {
                $i$f$fastForEach = $i$f$fastForEach2;
                set2 = set$runtime_release;
            }
        } else {
            $i$f$fastForEach = $i$f$fastForEach2;
            set$runtime_release = 0;
            iterator = (Iterable)obj.iterator();
            for (Object next : iterator) {
                obj2.invoke(next);
            }
        }
    }

    public static final <T> Set<T> wrapIntoSet(ScatterSet<T> $this$wrapIntoSet) {
        ScatterSetWrapper scatterSetWrapper = new ScatterSetWrapper($this$wrapIntoSet);
        return (Set)scatterSetWrapper;
    }
}
