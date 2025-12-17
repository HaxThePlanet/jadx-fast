package androidx.lifecycle.viewmodel.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a/\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0004\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0005H\u0080\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0007", d2 = {"synchronizedImpl", "T", "lock", "Landroidx/lifecycle/viewmodel/internal/SynchronizedObject;", "action", "Lkotlin/Function0;", "(Landroidx/lifecycle/viewmodel/internal/SynchronizedObject;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "lifecycle-viewmodel_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SynchronizedObject_jvmKt {
    public static final <T> T synchronizedImpl(androidx.lifecycle.viewmodel.internal.SynchronizedObject lock, Function0<? extends T> action) {
        Intrinsics.checkNotNullParameter(lock, "lock");
        Intrinsics.checkNotNullParameter(action, "action");
        int i = 0;
        return action.invoke();
        synchronized (lock) {
            Intrinsics.checkNotNullParameter(lock, "lock");
            Intrinsics.checkNotNullParameter(action, "action");
            i = 0;
            return action.invoke();
        }
    }
}
