package androidx.core.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.Animator.AnimatorPauseListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\n\u001a¡\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\u0008\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u00042#\u0008\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u00042#\u0008\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u00042#\u0008\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0004H\u0086\u0008\u001aT\u0010\u000c\u001a\u00020\r*\u00020\u00022#\u0008\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u00042#\u0008\u0002\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0004\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\u0008\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0004H\u0086\u0008\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\u0008\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0004H\u0086\u0008\u001a-\u0010\u0013\u001a\u00020\r*\u00020\u00022!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0004\u001a2\u0010\u0014\u001a\u00020\u0001*\u00020\u00022#\u0008\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0004H\u0086\u0008\u001a-\u0010\u0015\u001a\u00020\r*\u00020\u00022!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0004\u001a2\u0010\u0016\u001a\u00020\u0001*\u00020\u00022#\u0008\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0004H\u0086\u0008¨\u0006\u0017", d2 = {"addListener", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animator", "", "onStart", "onCancel", "onRepeat", "addPauseListener", "Landroid/animation/Animator$AnimatorPauseListener;", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnRepeat", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnimatorKt {
    public static final Animator.AnimatorListener addListener(Animator $this$addListener, Function1<? super Animator, Unit> onEnd, Function1<? super Animator, Unit> onStart, Function1<? super Animator, Unit> onCancel, Function1<? super Animator, Unit> onRepeat) {
        final int i = 0;
        AnimatorKt.addListener.listener.1 anon = new AnimatorKt.addListener.listener.1(onRepeat, onEnd, onCancel, onStart);
        $this$addListener.addListener((Animator.AnimatorListener)anon);
        return (Animator.AnimatorListener)anon;
    }

    public static Animator.AnimatorListener addListener$default(Animator $this$addListener_u24default, Function1 onEnd, Function1 onStart, Function1 onCancel, Function1 onRepeat, int i6, Object object7) {
        androidx.core.animation.AnimatorKt.addListener.1 obj2;
        androidx.core.animation.AnimatorKt.addListener.2 obj3;
        androidx.core.animation.AnimatorKt.addListener.3 obj4;
        androidx.core.animation.AnimatorKt.addListener.4 obj5;
        int obj6;
        int obj7;
        if (i6 & 1 != 0) {
            obj2 = obj7;
        }
        if (i6 & 2 != 0) {
            obj3 = obj7;
        }
        if (i6 & 4 != 0) {
            obj4 = obj7;
        }
        if (i6 &= 8 != 0) {
            obj5 = obj6;
        }
        obj6 = 0;
        obj7 = new AnimatorKt.addListener.listener.1(obj5, obj2, obj4, obj3);
        $this$addListener_u24default.addListener((Animator.AnimatorListener)obj7);
        return (Animator.AnimatorListener)obj7;
    }

    public static final Animator.AnimatorPauseListener addPauseListener(Animator $this$addPauseListener, Function1<? super Animator, Unit> onResume, Function1<? super Animator, Unit> onPause) {
        AnimatorKt.addPauseListener.listener.1 anon = new AnimatorKt.addPauseListener.listener.1(onPause, onResume);
        $this$addPauseListener.addPauseListener((Animator.AnimatorPauseListener)anon);
        return (Animator.AnimatorPauseListener)anon;
    }

    public static Animator.AnimatorPauseListener addPauseListener$default(Animator animator, Function1 function12, Function1 function13, int i4, Object object5) {
        androidx.core.animation.AnimatorKt.addPauseListener.1 obj1;
        androidx.core.animation.AnimatorKt.addPauseListener.2 obj2;
        if (i4 & 1 != 0) {
            obj1 = AnimatorKt.addPauseListener.1.INSTANCE;
        }
        if (i4 &= 2 != 0) {
            obj2 = AnimatorKt.addPauseListener.2.INSTANCE;
        }
        return AnimatorKt.addPauseListener(animator, obj1, obj2);
    }

    public static final Animator.AnimatorListener doOnCancel(Animator $this$doOnCancel, Function1<? super Animator, Unit> action) {
        final int i = 0;
        final int i2 = 0;
        AnimatorKt.doOnCancel$$inlined.addListener.default.1 anon = new AnimatorKt.doOnCancel$$inlined.addListener.default.1(action);
        $this$doOnCancel.addListener((Animator.AnimatorListener)anon);
        return (Animator.AnimatorListener)anon;
    }

    public static final Animator.AnimatorListener doOnEnd(Animator $this$doOnEnd, Function1<? super Animator, Unit> action) {
        final int i = 0;
        final int i2 = 0;
        AnimatorKt.doOnEnd$$inlined.addListener.default.1 anon = new AnimatorKt.doOnEnd$$inlined.addListener.default.1(action);
        $this$doOnEnd.addListener((Animator.AnimatorListener)anon);
        return (Animator.AnimatorListener)anon;
    }

    public static final Animator.AnimatorPauseListener doOnPause(Animator $this$doOnPause, Function1<? super Animator, Unit> action) {
        int i = 0;
        return AnimatorKt.addPauseListener$default($this$doOnPause, i, action, 1, i);
    }

    public static final Animator.AnimatorListener doOnRepeat(Animator $this$doOnRepeat, Function1<? super Animator, Unit> action) {
        final int i = 0;
        final int i2 = 0;
        AnimatorKt.doOnRepeat$$inlined.addListener.default.1 anon = new AnimatorKt.doOnRepeat$$inlined.addListener.default.1(action);
        $this$doOnRepeat.addListener((Animator.AnimatorListener)anon);
        return (Animator.AnimatorListener)anon;
    }

    public static final Animator.AnimatorPauseListener doOnResume(Animator $this$doOnResume, Function1<? super Animator, Unit> action) {
        int i = 0;
        return AnimatorKt.addPauseListener$default($this$doOnResume, action, i, 2, i);
    }

    public static final Animator.AnimatorListener doOnStart(Animator $this$doOnStart, Function1<? super Animator, Unit> action) {
        final int i = 0;
        final int i2 = 0;
        AnimatorKt.doOnStart$$inlined.addListener.default.1 anon = new AnimatorKt.doOnStart$$inlined.addListener.default.1(action);
        $this$doOnStart.addListener((Animator.AnimatorListener)anon);
        return (Animator.AnimatorListener)anon;
    }
}
