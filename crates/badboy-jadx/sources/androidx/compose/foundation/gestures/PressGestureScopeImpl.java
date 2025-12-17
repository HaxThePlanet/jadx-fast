package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.Mutex.DefaultImpls;
import kotlinx.coroutines.sync.MutexKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0015\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\u0017*\u00020\u0018H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u0017\u0010\u0016\u001a\u00020\u0017*\u00020\u001bH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u0018*\u00020\u001bH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 J\u001a\u0010\u001e\u001a\u00020\u0018*\u00020\u0005H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"J\u001a\u0010\u001e\u001a\u00020\u0018*\u00020\u0017H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008!\u0010#J\u0017\u0010$\u001a\u00020%*\u00020&H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(J\u0017\u0010)\u001a\u00020\u0005*\u00020\u0018H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008*\u0010\"J\u0017\u0010)\u001a\u00020\u0005*\u00020\u001bH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008+\u0010 J\r\u0010,\u001a\u00020-*\u00020.H\u0097\u0001J\u0017\u0010/\u001a\u00020&*\u00020%H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u00080\u0010(J\u0017\u00101\u001a\u00020\u001b*\u00020\u0018H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u00082\u00103J\u001a\u00101\u001a\u00020\u001b*\u00020\u0005H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00084\u00103J\u001a\u00101\u001a\u00020\u001b*\u00020\u0017H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00084\u00105R\u0014\u0010\u0003\u001a\u00020\u00058\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u0014\u0010\u0008\u001a\u00020\u00058\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00066", d2 = {"Landroidx/compose/foundation/gestures/PressGestureScopeImpl;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "density", "(Landroidx/compose/ui/unit/Density;)V", "", "getDensity", "()F", "fontScale", "getFontScale", "isCanceled", "", "isReleased", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "release", "reset", "tryAwaitRelease", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PressGestureScopeImpl implements androidx.compose.foundation.gestures.PressGestureScope, Density {

    public static final int $stable;
    private final Density $$delegate_0;
    private boolean isCanceled;
    private boolean isReleased;
    private final Mutex mutex;
    static {
    }

    public PressGestureScopeImpl(Density density) {
        super();
        this.$$delegate_0 = density;
        this.mutex = MutexKt.Mutex(false);
    }

    public Object awaitRelease(Continuation<? super Unit> continuation) {
        boolean anon;
        int i;
        int i3;
        Object _this;
        int i2;
        Object obj5;
        anon = continuation;
        i3 = Integer.MIN_VALUE;
        if (continuation instanceof PressGestureScopeImpl.awaitRelease.1 && label &= i3 != 0) {
            anon = continuation;
            i3 = Integer.MIN_VALUE;
            if (label &= i3 != 0) {
                anon.label = obj5 -= i3;
            } else {
                anon = new PressGestureScopeImpl.awaitRelease.1(this, continuation);
            }
        } else {
        }
        obj5 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj5);
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                ResultKt.throwOnFailure(obj5);
                _this = obj5;
                break;
            default:
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
        }
        if (!(Boolean)_this.booleanValue()) {
        } else {
            return Unit.INSTANCE;
        }
        GestureCancellationException gestureCancellationException = new GestureCancellationException("The press gesture was canceled.");
        throw gestureCancellationException;
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public final void cancel() {
        final int i = 1;
        this.isCanceled = i;
        final int i2 = 0;
        Mutex.DefaultImpls.unlock$default(this.mutex, i2, i, i2);
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public final void release() {
        final int i = 1;
        this.isReleased = i;
        final int i2 = 0;
        Mutex.DefaultImpls.unlock$default(this.mutex, i2, i, i2);
    }

    public final Object reset(Continuation<? super Unit> continuation) {
        boolean anon;
        int i;
        Object l$0;
        int i4;
        androidx.compose.foundation.gestures.PressGestureScopeImpl label;
        Object lock$default;
        int i3;
        int i2;
        Object obj7;
        anon = continuation;
        i4 = Integer.MIN_VALUE;
        if (continuation instanceof PressGestureScopeImpl.reset.1 && label2 &= i4 != 0) {
            anon = continuation;
            i4 = Integer.MIN_VALUE;
            if (label2 &= i4 != 0) {
                anon.label = obj7 -= i4;
            } else {
                anon = new PressGestureScopeImpl.reset.1(this, continuation);
            }
        } else {
        }
        obj7 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj7);
                label = this;
                anon.L$0 = label;
                i3 = 1;
                anon.label = i3;
                i2 = 0;
                return cOROUTINE_SUSPENDED;
                l$0 = label;
                break;
            case 1:
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj7);
                break;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        int _this = 0;
        l$0.isReleased = _this;
        l$0.isCanceled = _this;
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public int roundToPx--R2X_6o(long l) {
        return this.$$delegate_0.roundToPx--R2X_6o(l);
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public int roundToPx-0680j_4(float f) {
        return this.$$delegate_0.roundToPx-0680j_4(f);
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public float toDp-GaN1DYA(long l) {
        return this.$$delegate_0.toDp-GaN1DYA(l);
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public float toDp-u2uoSUM(float f) {
        return this.$$delegate_0.toDp-u2uoSUM(f);
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public float toDp-u2uoSUM(int i) {
        return this.$$delegate_0.toDp-u2uoSUM(i);
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public long toDpSize-k-rfVVM(long l) {
        return this.$$delegate_0.toDpSize-k-rfVVM(l);
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public float toPx--R2X_6o(long l) {
        return this.$$delegate_0.toPx--R2X_6o(l);
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public float toPx-0680j_4(float f) {
        return this.$$delegate_0.toPx-0680j_4(f);
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public Rect toRect(DpRect dpRect) {
        return this.$$delegate_0.toRect(dpRect);
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public long toSize-XkaWNTQ(long l) {
        return this.$$delegate_0.toSize-XkaWNTQ(l);
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public long toSp-0xMU5do(float f) {
        return this.$$delegate_0.toSp-0xMU5do(f);
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public long toSp-kPz2Gy4(float f) {
        return this.$$delegate_0.toSp-kPz2Gy4(f);
    }

    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public long toSp-kPz2Gy4(int i) {
        return this.$$delegate_0.toSp-kPz2Gy4(i);
    }

    public Object tryAwaitRelease(Continuation<? super Boolean> continuation) {
        boolean anon;
        int i;
        Object cOROUTINE_SUSPENDED;
        int i2;
        androidx.compose.foundation.gestures.PressGestureScopeImpl label;
        boolean isReleased;
        Object obj7;
        anon = continuation;
        i2 = Integer.MIN_VALUE;
        if (continuation instanceof PressGestureScopeImpl.tryAwaitRelease.1 && label2 &= i2 != 0) {
            anon = continuation;
            i2 = Integer.MIN_VALUE;
            if (label2 &= i2 != 0) {
                anon.label = obj7 -= i2;
            } else {
                anon = new PressGestureScopeImpl.tryAwaitRelease.1(this, continuation);
            }
        } else {
        }
        obj7 = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        final int i3 = 1;
        final int i4 = 0;
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj7);
                label = this;
                anon.L$0 = label;
                anon.label = i3;
                return cOROUTINE_SUSPENDED;
                cOROUTINE_SUSPENDED = label;
                return Boxing.boxBoolean(label.isReleased);
            case 1:
                cOROUTINE_SUSPENDED = anon.L$0;
                ResultKt.throwOnFailure(obj7);
                break;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        Mutex.DefaultImpls.unlock$default(cOROUTINE_SUSPENDED.mutex, i4, i3, i4);
        label = cOROUTINE_SUSPENDED;
    }
}
