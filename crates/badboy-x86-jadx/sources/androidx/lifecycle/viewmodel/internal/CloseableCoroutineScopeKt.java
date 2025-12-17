package androidx.lifecycle.viewmodel.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0008\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u000c\u0010\u0004\u001a\u00020\u0003*\u00020\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"VIEW_MODEL_SCOPE_KEY", "", "createViewModelScope", "Landroidx/lifecycle/viewmodel/internal/CloseableCoroutineScope;", "asCloseable", "Lkotlinx/coroutines/CoroutineScope;", "lifecycle-viewmodel_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CloseableCoroutineScopeKt {

    public static final String VIEW_MODEL_SCOPE_KEY = "androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY";
    public static final androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope asCloseable(CoroutineScope $this$asCloseable) {
        Intrinsics.checkNotNullParameter($this$asCloseable, "<this>");
        CloseableCoroutineScope closeableCoroutineScope = new CloseableCoroutineScope($this$asCloseable);
        return closeableCoroutineScope;
    }

    public static final androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope createViewModelScope() {
        MainCoroutineDispatcher immediate;
        EmptyCoroutineContext iNSTANCE;
        immediate = Dispatchers.getMain().getImmediate();
        final int i2 = 0;
        CloseableCoroutineScope closeableCoroutineScope = new CloseableCoroutineScope(immediate.plus((CoroutineContext)SupervisorKt.SupervisorJob$default(i2, 1, i2)));
        return closeableCoroutineScope;
    }
}
