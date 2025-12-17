package androidx.core.transition;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u000b\u001aÆ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\u0008\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u00042#\u0008\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u00042#\u0008\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u00042#\u0008\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u00042#\u0008\u0006\u0010\u000c\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0004H\u0086\u0008\u001a2\u0010\r\u001a\u00020\u0001*\u00020\u00022#\u0008\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0004H\u0086\u0008\u001a2\u0010\u000f\u001a\u00020\u0001*\u00020\u00022#\u0008\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0004H\u0086\u0008\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\u0008\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0004H\u0086\u0008\u001a2\u0010\u0011\u001a\u00020\u0001*\u00020\u00022#\u0008\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0004H\u0086\u0008\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\u0008\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0004H\u0086\u0008¨\u0006\u0013", d2 = {"addListener", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "transition", "", "onStart", "onCancel", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TransitionKt {
    public static final Transition.TransitionListener addListener(Transition $this$addListener, Function1<? super Transition, Unit> onEnd, Function1<? super Transition, Unit> onStart, Function1<? super Transition, Unit> onCancel, Function1<? super Transition, Unit> onResume, Function1<? super Transition, Unit> onPause) {
        final int i = 0;
        TransitionKt.addListener.listener.1 anon = new TransitionKt.addListener.listener.1(onEnd, onResume, onPause, onCancel, onStart);
        $this$addListener.addListener((Transition.TransitionListener)anon);
        return (Transition.TransitionListener)anon;
    }

    public static Transition.TransitionListener addListener$default(Transition $this$addListener_u24default, Function1 onEnd, Function1 onStart, Function1 onCancel, Function1 onResume, Function1 onPause, int i7, Object object8) {
        androidx.core.transition.TransitionKt.addListener.1 obj2;
        androidx.core.transition.TransitionKt.addListener.2 obj3;
        androidx.core.transition.TransitionKt.addListener.3 obj4;
        androidx.core.transition.TransitionKt.addListener.4 obj5;
        androidx.core.transition.TransitionKt.addListener.5 obj6;
        int obj8;
        if (i7 & 1 != 0) {
            obj2 = obj8;
        }
        if (i7 & 2 != 0) {
            obj8 = obj3;
        } else {
            obj8 = onStart;
        }
        if (i7 & 4 != 0) {
            obj4 = obj3;
        }
        if (i7 & 8 != 0) {
            obj5 = obj3;
        }
        if (i7 & 16 != 0) {
            obj6 = obj3;
        }
        final int i = 0;
        obj3 = new TransitionKt.addListener.listener.1(obj2, obj5, obj6, obj4, obj8);
        $this$addListener_u24default.addListener((Transition.TransitionListener)obj3);
        return (Transition.TransitionListener)obj3;
    }

    public static final Transition.TransitionListener doOnCancel(Transition $this$doOnCancel, Function1<? super Transition, Unit> action) {
        final int i = 0;
        final int i2 = 0;
        TransitionKt.doOnCancel$$inlined.addListener.default.1 anon = new TransitionKt.doOnCancel$$inlined.addListener.default.1(action);
        $this$doOnCancel.addListener((Transition.TransitionListener)anon);
        return (Transition.TransitionListener)anon;
    }

    public static final Transition.TransitionListener doOnEnd(Transition $this$doOnEnd, Function1<? super Transition, Unit> action) {
        final int i = 0;
        final int i2 = 0;
        TransitionKt.doOnEnd$$inlined.addListener.default.1 anon = new TransitionKt.doOnEnd$$inlined.addListener.default.1(action);
        $this$doOnEnd.addListener((Transition.TransitionListener)anon);
        return (Transition.TransitionListener)anon;
    }

    public static final Transition.TransitionListener doOnPause(Transition $this$doOnPause, Function1<? super Transition, Unit> action) {
        final int i = 0;
        final int i2 = 0;
        TransitionKt.doOnPause$$inlined.addListener.default.1 anon = new TransitionKt.doOnPause$$inlined.addListener.default.1(action);
        $this$doOnPause.addListener((Transition.TransitionListener)anon);
        return (Transition.TransitionListener)anon;
    }

    public static final Transition.TransitionListener doOnResume(Transition $this$doOnResume, Function1<? super Transition, Unit> action) {
        final int i = 0;
        final int i2 = 0;
        TransitionKt.doOnResume$$inlined.addListener.default.1 anon = new TransitionKt.doOnResume$$inlined.addListener.default.1(action);
        $this$doOnResume.addListener((Transition.TransitionListener)anon);
        return (Transition.TransitionListener)anon;
    }

    public static final Transition.TransitionListener doOnStart(Transition $this$doOnStart, Function1<? super Transition, Unit> action) {
        final int i = 0;
        final int i2 = 0;
        TransitionKt.doOnStart$$inlined.addListener.default.1 anon = new TransitionKt.doOnStart$$inlined.addListener.default.1(action);
        $this$doOnStart.addListener((Transition.TransitionListener)anon);
        return (Transition.TransitionListener)anon;
    }
}
