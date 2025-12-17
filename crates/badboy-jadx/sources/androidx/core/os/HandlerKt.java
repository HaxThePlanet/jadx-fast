package androidx.core.os;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0008\u0004\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008H\u0086\u0008\u001a1\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0008\u0004\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008H\u0086\u0008¨\u0006\u000c", d2 = {"postAtTime", "Ljava/lang/Runnable;", "Landroid/os/Handler;", "uptimeMillis", "", "token", "", "action", "Lkotlin/Function0;", "", "postDelayed", "delayInMillis", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HandlerKt {
    public static final Runnable postAtTime(Handler $this$postAtTime, long uptimeMillis, Object token, Function0<Unit> action) {
        final int i = 0;
        HandlerKt.postAtTime.runnable.1 anon = new HandlerKt.postAtTime.runnable.1(obj6);
        $this$postAtTime.postAtTime((Runnable)anon, action, uptimeMillis);
        return anon;
    }

    public static Runnable postAtTime$default(Handler $this$postAtTime_u24default, long uptimeMillis, Object token, Function0 action, int i5, Object object6) {
        int obj3;
        if (object6 &= 2 != 0) {
            obj3 = 0;
        }
        int obj5 = 0;
        HandlerKt.postAtTime.runnable.1 obj6 = new HandlerKt.postAtTime.runnable.1(i5);
        $this$postAtTime_u24default.postAtTime((Runnable)obj6, obj3, uptimeMillis);
        return obj6;
    }

    public static final Runnable postDelayed(Handler $this$postDelayed, long delayInMillis, Object token, Function0<Unit> action) {
        final int i = 0;
        HandlerKt.postDelayed.runnable.1 anon = new HandlerKt.postDelayed.runnable.1(obj6);
        if (action == null) {
            $this$postDelayed.postDelayed((Runnable)anon, delayInMillis);
        } else {
            HandlerCompat.postDelayed($this$postDelayed, anon, action, delayInMillis);
        }
        return anon;
    }

    public static Runnable postDelayed$default(Handler $this$postDelayed_u24default, long delayInMillis, Object token, Function0 action, int i5, Object object6) {
        int obj3;
        if (object6 &= 2 != 0) {
            obj3 = 0;
        }
        int obj5 = 0;
        HandlerKt.postDelayed.runnable.1 obj6 = new HandlerKt.postDelayed.runnable.1(i5);
        if (obj3 == null) {
            $this$postDelayed_u24default.postDelayed((Runnable)obj6, delayInMillis);
        } else {
            HandlerCompat.postDelayed($this$postDelayed_u24default, obj6, obj3, delayInMillis);
        }
        return obj6;
    }
}
