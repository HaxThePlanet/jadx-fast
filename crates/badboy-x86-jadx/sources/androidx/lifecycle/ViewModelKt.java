package androidx.lifecycle;

import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScopeKt;
import androidx.lifecycle.viewmodel.internal.SynchronizedObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/lifecycle/ViewModel;", "getViewModelScope", "(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;", "VIEW_MODEL_SCOPE_LOCK", "Landroidx/lifecycle/viewmodel/internal/SynchronizedObject;", "lifecycle-viewmodel_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ViewModelKt {

    private static final SynchronizedObject VIEW_MODEL_SCOPE_LOCK;
    static {
        SynchronizedObject synchronizedObject = new SynchronizedObject();
        ViewModelKt.VIEW_MODEL_SCOPE_LOCK = synchronizedObject;
    }

    public static final CoroutineScope getViewModelScope(androidx.lifecycle.ViewModel $this$viewModelScope) {
        java.lang.AutoCloseable viewModelScope;
        androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope closeableCoroutineScope;
        int i;
        String str;
        androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope closeableCoroutineScope2;
        Intrinsics.checkNotNullParameter($this$viewModelScope, "<this>");
        SynchronizedObject vIEW_MODEL_SCOPE_LOCK = ViewModelKt.VIEW_MODEL_SCOPE_LOCK;
        final int i2 = 0;
        final int i3 = 0;
        final int i4 = 0;
        synchronized (vIEW_MODEL_SCOPE_LOCK) {
            i = 0;
            $this$viewModelScope.addCloseable("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", (AutoCloseable)CloseableCoroutineScopeKt.createViewModelScope());
            return (CoroutineScope)viewModelScope;
        }
    }
}
