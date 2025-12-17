package androidx.activity;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0002\u0008\n¨\u0006\u000b", d2 = {"addCallback", "Landroidx/activity/OnBackPressedCallback;", "Landroidx/activity/OnBackPressedDispatcher;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "enabled", "", "onBackPressed", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OnBackPressedDispatcherKt {
    public static final androidx.activity.OnBackPressedCallback addCallback(androidx.activity.OnBackPressedDispatcher $this$addCallback, LifecycleOwner owner, boolean enabled, Function1<? super androidx.activity.OnBackPressedCallback, Unit> onBackPressed) {
        androidx.activity.OnBackPressedDispatcherKt.addCallback.callback.1 anon;
        Intrinsics.checkNotNullParameter($this$addCallback, "<this>");
        Intrinsics.checkNotNullParameter(onBackPressed, "onBackPressed");
        OnBackPressedDispatcherKt.addCallback.callback.1 anon2 = new OnBackPressedDispatcherKt.addCallback.callback.1(enabled, onBackPressed);
        if (owner != null) {
            $this$addCallback.addCallback(owner, (OnBackPressedCallback)anon2);
        } else {
            $this$addCallback.addCallback((OnBackPressedCallback)anon2);
        }
        return (OnBackPressedCallback)anon2;
    }

    public static androidx.activity.OnBackPressedCallback addCallback$default(androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner2, boolean z3, Function1 function14, int i5, Object object6) {
        int obj1;
        int obj2;
        if (i5 & 1 != 0) {
            obj1 = 0;
        }
        if (i5 &= 2 != 0) {
            obj2 = 1;
        }
        return OnBackPressedDispatcherKt.addCallback(onBackPressedDispatcher, obj1, obj2, function14);
    }
}
