package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlin.b0.g;
import kotlin.d0.d.g;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.j2;
import kotlinx.coroutines.w0;
import kotlinx.coroutines.w0.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0001\u0001\u0007¨\u0006\u0008", d2 = {"Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/android/HandlerContext;", "kotlinx-coroutines-android"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class b extends j2 implements w0 {
    public b(g g) {
        super();
    }

    @Override // kotlinx.coroutines.j2
    public e1 x(long l, Runnable runnable2, g g3) {
        return w0.a.a(this, l, runnable2, g3);
    }
}
