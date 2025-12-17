package kotlinx.coroutines.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0081@\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0016\u0012\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ$\u0010\u000b\u001a\u00020\u000c2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000c0\u000eH\u0086\u0008¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\u0008\u0013\u0010\u0014J'\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0086\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\u0008\u001b\u0010\u001cR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0003\u0092\u0001\u0004\u0018\u00010\u0002ø\u0001\u0000\u0082\u0002\u000f\n\u0002\u0008\u0019\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001d", d2 = {"Lkotlinx/coroutines/internal/InlineList;", "E", "", "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "equals", "", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "forEachReversed", "", "action", "Lkotlin/Function1;", "forEachReversed-impl", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "plus", "element", "plus-FjFbRPM", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class InlineList<E>  {

    private final Object holder;
    private InlineList(Object holder) {
        super();
        this.holder = holder;
    }

    public static final kotlinx.coroutines.internal.InlineList box-impl(Object object) {
        InlineList inlineList = new InlineList(object);
        return inlineList;
    }

    public static <E> Object constructor-impl(Object object) {
        return object;
    }

    public static Object constructor-impl$default(Object object, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj0;
        if (i2 &= 1 != 0) {
            obj0 = 0;
        }
        return InlineList.constructor-impl(obj0);
    }

    public static boolean equals-impl(Object object, Object object2) {
        final int i2 = 0;
        if (object2 instanceof InlineList == null) {
            return i2;
        }
        if (!Intrinsics.areEqual(object, (InlineList)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(Object object, Object object2) {
        return Intrinsics.areEqual(object, object2);
    }

    public static final void forEachReversed-impl(Object arg0, Function1<? super E, Unit> action) {
        boolean z;
        int i;
        int i2;
        final int i3 = 0;
        if (arg0 == null) {
        }
        if (arg0 instanceof ArrayList == null) {
            action.invoke(arg0);
        } else {
            Intrinsics.checkNotNull(arg0, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            z = arg0;
            size--;
            while (-1 < i) {
                action.invoke(z.get(i));
                i--;
            }
        }
    }

    public static int hashCode-impl(Object object) {
        int i;
        if (object == null) {
            i = 0;
        } else {
            i = object.hashCode();
        }
        return i;
    }

    public static final Object plus-FjFbRPM(Object arg0, E element) {
        boolean aSSERTIONS_ENABLED;
        Object list;
        boolean constructor-impl;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            if (element instanceof List != null) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        if (arg0 == null) {
            list = InlineList.constructor-impl(element);
        } else {
            if (arg0 instanceof ArrayList != null) {
                Intrinsics.checkNotNull(arg0, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                (ArrayList)arg0.add(element);
                list = InlineList.constructor-impl(arg0);
            } else {
                ArrayList arrayList = new ArrayList(4);
                arrayList.add(arg0);
                arrayList.add(element);
                list = constructor-impl;
            }
        }
        return list;
    }

    public static String toString-impl(Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("InlineList(holder=").append(object).append(')').toString();
    }

    public boolean equals(Object object) {
        return InlineList.equals-impl(this.holder, object);
    }

    public int hashCode() {
        return InlineList.hashCode-impl(this.holder);
    }

    public String toString() {
        return InlineList.toString-impl(this.holder);
    }

    public final Object unbox-impl() {
        return this.holder;
    }
}
