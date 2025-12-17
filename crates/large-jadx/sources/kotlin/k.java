package kotlin;

import kotlin.d0.c.a;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u001a*\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u001a(\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u0007\u001a\u00020\u00082\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\t", d2 = {"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/LazyKt")
class k {
    public static <T> kotlin.h<T> a(kotlin.m m, a<? extends T> a2) {
        int i;
        Object obj2;
        n.f(m, "mode");
        n.f(a2, "initializer");
        obj2 = i.a[m.ordinal()];
        final int i2 = 2;
        if (obj2 != 1) {
            if (obj2 != i2) {
                if (obj2 != 3) {
                } else {
                    obj2 = new x(a2);
                }
                obj2 = new NoWhenBranchMatchedException();
                throw obj2;
            }
            obj2 = new r(a2);
        } else {
            i = 0;
            obj2 = new s(a2, i, i2, i);
        }
        return obj2;
    }

    public static <T> kotlin.h<T> b(a<? extends T> a) {
        n.f(a, "initializer");
        final int i = 0;
        s sVar = new s(a, i, 2, i);
        return sVar;
    }
}
