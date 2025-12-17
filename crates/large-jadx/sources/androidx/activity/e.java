package androidx.activity;

import androidx.lifecycle.q;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0002\u0008\n¨\u0006\u000b", d2 = {"addCallback", "Landroidx/activity/OnBackPressedCallback;", "Landroidx/activity/OnBackPressedDispatcher;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "enabled", "", "onBackPressed", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "activity-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class e {

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"androidx/activity/OnBackPressedDispatcherKt$addCallback$callback$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "activity-ktx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends androidx.activity.d {

        final l<androidx.activity.d, w> c;
        a(l<? super androidx.activity.d, w> l, boolean z2) {
            this.c = l;
            super(z2);
        }

        @Override // androidx.activity.d
        public void b() {
            this.c.invoke(this);
        }
    }
    public static final androidx.activity.d a(androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher, q q2, boolean z3, l<? super androidx.activity.d, w> l4) {
        n.f(onBackPressedDispatcher, "<this>");
        n.f(l4, "onBackPressed");
        e.a aVar = new e.a(l4, z3);
        if (q2 != null) {
            onBackPressedDispatcher.b(q2, aVar);
        } else {
            onBackPressedDispatcher.a(aVar);
        }
        return aVar;
    }

    public static androidx.activity.d b(androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher, q q2, boolean z3, l l4, int i5, Object object6) {
        int obj1;
        int obj2;
        if (i5 & 1 != 0) {
            obj1 = 0;
        }
        if (i5 &= 2 != 0) {
            obj2 = 1;
        }
        return e.a(onBackPressedDispatcher, obj1, obj2, l4);
    }
}
