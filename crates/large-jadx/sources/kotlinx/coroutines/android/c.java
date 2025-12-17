package kotlinx.coroutines.android;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.p;
import kotlin.q;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0011\u0010\u0008\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00010\rH\u0002\u001a\u0016\u0010\u000e\u001a\u00020\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00010\rH\u0002\u001a\u001d\u0010\u000f\u001a\u00020\u0003*\u00020\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\u0008\u0013\u001a\u0014\u0010\u0014\u001a\u00020\u0010*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0018", d2 = {"MAX_DELAY", "", "Main", "Lkotlinx/coroutines/android/HandlerDispatcher;", "getMain$annotations", "()V", "choreographer", "Landroid/view/Choreographer;", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postFrameCallback", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "updateChoreographerAndPostFrameCallback", "asCoroutineDispatcher", "Landroid/os/Handler;", "name", "", "from", "asHandler", "Landroid/os/Looper;", "async", "", "kotlinx-coroutines-android"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class c {

    private static volatile Choreographer choreographer;
    static {
        int i;
        kotlinx.coroutines.android.a aVar;
        Handler handler;
        i = 0;
        kotlin.p.a aVar2 = p.a;
        aVar = new a(c.a(Looper.getMainLooper(), true), i, 2, i);
        p.a(aVar);
        if (p.e(aVar)) {
        } else {
            i = aVar;
        }
    }

    public static final Handler a(Looper looper, boolean z2) {
        int i;
        Handler obj8;
        if (z2 != null) {
            obj8 = Build.VERSION.SDK_INT;
            if (obj8 < 16) {
            } else {
                final int i4 = 0;
                final int i5 = 0;
                final int i6 = 1;
                if (obj8 >= 28) {
                    Class[] arr4 = new Class[i6];
                    arr4[i5] = Looper.class;
                    Object[] arr2 = new Object[i6];
                    arr2[i5] = looper;
                    Object obj7 = Handler.class.getDeclaredMethod("createAsync", arr4).invoke(i4, arr2);
                    Objects.requireNonNull(obj7, "null cannot be cast to non-null type android.os.Handler");
                    return (Handler)obj7;
                }
            }
            int i3 = 3;
            Class[] arr3 = new Class[i3];
            arr3[i5] = Looper.class;
            arr3[i6] = Handler.Callback.class;
            final int i7 = 2;
            arr3[i7] = Boolean.TYPE;
            Object[] arr = new Object[i3];
            arr[i5] = looper;
            arr[i6] = i4;
            arr[i7] = Boolean.TRUE;
            return (Handler)Handler.class.getDeclaredConstructor(arr3).newInstance(arr);
        }
        obj8 = new Handler(looper);
        return obj8;
    }
}
