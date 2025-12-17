package androidx.compose.foundation;

import android.content.Context;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.Velocity.Companion;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0007\n\u0002\u0008\u0012\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010#\u001a\u00020\u001fH\u0002J?\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&2\"\u0010'\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u00020&\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020&0)\u0012\u0006\u0012\u0004\u0018\u00010*0(H\u0096@ø\u0001\u0000¢\u0006\u0004\u0008+\u0010,J6\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c02H\u0016ø\u0001\u0000¢\u0006\u0004\u00083\u00104J\u0015\u00105\u001a\u00020\u001cH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00086\u00107J\r\u00108\u001a\u00020\u001fH\u0000¢\u0006\u0002\u00089J\u001a\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\u0008=\u0010>J\u001a\u0010?\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\u0008@\u0010>J\u001a\u0010A\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\u0008B\u0010>J\u001a\u0010C\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\u0008D\u0010>J\u001a\u0010E\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\u0008F\u0010GJ\u0008\u0010H\u001a\u00020\u0011H\u0002J\u001a\u0010I\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020\u0008H\u0000ø\u0001\u0000¢\u0006\u0004\u0008K\u0010LR\u0016\u0010\u0007\u001a\u00020\u0008X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u00020\rX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00118\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u001eX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u000e\u0010\"\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006M", d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", "overscrollConfig", "Landroidx/compose/foundation/OverscrollConfiguration;", "(Landroid/content/Context;Landroidx/compose/foundation/OverscrollConfiguration;)V", "containerSize", "Landroidx/compose/ui/geometry/Size;", "J", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "invalidationEnabled", "", "getInvalidationEnabled$foundation_release$annotations", "()V", "getInvalidationEnabled$foundation_release", "()Z", "setInvalidationEnabled$foundation_release", "(Z)V", "isInProgress", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "redrawSignal", "Landroidx/compose/runtime/MutableState;", "", "getRedrawSignal$foundation_release", "()Landroidx/compose/runtime/MutableState;", "scrollCycleInProgress", "animateToRelease", "applyToFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyToScroll", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "Lkotlin/Function1;", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "displacement", "displacement-F1C5BW0$foundation_release", "()J", "invalidateOverscroll", "invalidateOverscroll$foundation_release", "pullBottom", "", "scroll", "pullBottom-k-4lQ0M", "(J)F", "pullLeft", "pullLeft-k-4lQ0M", "pullRight", "pullRight-k-4lQ0M", "pullTop", "pullTop-k-4lQ0M", "releaseOppositeOverscroll", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "stopOverscrollAnimation", "updateSize", "size", "updateSize-uvyYCjk$foundation_release", "(J)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidEdgeEffectOverscrollEffect implements androidx.compose.foundation.OverscrollEffect {

    public static final int $stable;
    private long containerSize;
    private final androidx.compose.foundation.EdgeEffectWrapper edgeEffectWrapper;
    private final Modifier effectModifier;
    private boolean invalidationEnabled = true;
    private PointerId pointerId;
    private Offset pointerPosition;
    private final MutableState<Unit> redrawSignal;
    private boolean scrollCycleInProgress;
    static {
    }

    public AndroidEdgeEffectOverscrollEffect(Context context, androidx.compose.foundation.OverscrollConfiguration overscrollConfig) {
        androidx.compose.ui.platform.InspectorValueInfo drawGlowOverscrollModifier;
        androidx.compose.foundation.EdgeEffectWrapper edgeEffectWrapper;
        int i;
        Function1 noInspectorInfo;
        super();
        EdgeEffectWrapper edgeEffectWrapper2 = new EdgeEffectWrapper(context, ColorKt.toArgb-8_81llA(overscrollConfig.getGlowColor-0d7_KjU()));
        this.edgeEffectWrapper = edgeEffectWrapper2;
        this.redrawSignal = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        int i2 = 1;
        this.containerSize = Size.Companion.getZero-NH-jbRc();
        AndroidEdgeEffectOverscrollEffect.effectModifier.1 anon = new AndroidEdgeEffectOverscrollEffect.effectModifier.1(this, 0);
        if (Build.VERSION.SDK_INT >= 31) {
            i = 0;
            if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
                noInspectorInfo = new AndroidEdgeEffectOverscrollEffect.special$$inlined.debugInspectorInfo.1(this);
            } else {
                noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
            }
            drawGlowOverscrollModifier = new DrawStretchOverscrollModifier(this, this.edgeEffectWrapper, noInspectorInfo);
        } else {
            i = 0;
            if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
                noInspectorInfo = new AndroidEdgeEffectOverscrollEffect.special$$inlined.debugInspectorInfo.2(this);
            } else {
                noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
            }
            drawGlowOverscrollModifier = new DrawGlowOverscrollModifier(this, this.edgeEffectWrapper, overscrollConfig, noInspectorInfo);
        }
        this.effectModifier = SuspendingPointerInputFilterKt.pointerInput((Modifier)Modifier.Companion, Unit.INSTANCE, (Function2)anon).then((Modifier)drawGlowOverscrollModifier);
    }

    public static final PointerId access$getPointerId$p(androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect $this) {
        return $this.pointerId;
    }

    public static final void access$setPointerId$p(androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect $this, PointerId <set-?>) {
        $this.pointerId = <set-?>;
    }

    public static final void access$setPointerPosition$p(androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect $this, Offset <set-?>) {
        $this.pointerPosition = <set-?>;
    }

    private final void animateToRelease() {
        int needsInvalidation;
        int i;
        int i3;
        boolean finished;
        int i2;
        int finished2;
        needsInvalidation = 0;
        final androidx.compose.foundation.EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        final int i4 = 0;
        EdgeEffect edgeEffect = EdgeEffectWrapper.access$getTopEffect$p(edgeEffectWrapper);
        if (edgeEffect != null) {
            i = 0;
            edgeEffect.onRelease();
            needsInvalidation = finished;
        }
        EdgeEffect edgeEffect2 = EdgeEffectWrapper.access$getBottomEffect$p(edgeEffectWrapper);
        i3 = 0;
        int i5 = 1;
        if (edgeEffect2 != null) {
            i2 = 0;
            edgeEffect2.onRelease();
            if (!edgeEffect2.isFinished()) {
                if (needsInvalidation != 0) {
                    finished2 = i5;
                } else {
                    finished2 = i3;
                }
            } else {
            }
            needsInvalidation = finished2;
        }
        EdgeEffect edgeEffect3 = EdgeEffectWrapper.access$getLeftEffect$p(edgeEffectWrapper);
        if (edgeEffect3 != null) {
            i2 = 0;
            edgeEffect3.onRelease();
            if (!edgeEffect3.isFinished()) {
                if (needsInvalidation != 0) {
                    finished2 = i5;
                } else {
                    finished2 = i3;
                }
            } else {
            }
            needsInvalidation = finished2;
        }
        EdgeEffect edgeEffect4 = EdgeEffectWrapper.access$getRightEffect$p(edgeEffectWrapper);
        if (edgeEffect4 != null) {
            i2 = 0;
            edgeEffect4.onRelease();
            if (!edgeEffect4.isFinished()) {
                if (needsInvalidation != 0) {
                    i3 = i5;
                }
            } else {
            }
            needsInvalidation = i3;
        }
        if (needsInvalidation != 0) {
            invalidateOverscroll$foundation_release();
        }
    }

    public static void getInvalidationEnabled$foundation_release$annotations() {
    }

    private final float pullBottom-k-4lQ0M(long scroll) {
        int y-impl;
        int i;
        EdgeEffect orCreateBottomEffect = this.edgeEffectWrapper.getOrCreateBottomEffect();
        if (Float.compare(distanceCompat, i7) == 0) {
        } else {
            i = 0;
        }
        if (i == 0) {
            y-impl = Offset.getY-impl(scroll);
        } else {
            y-impl = i4;
        }
        return y-impl;
    }

    private final float pullLeft-k-4lQ0M(long scroll) {
        int i;
        int x-impl;
        EdgeEffect orCreateLeftEffect = this.edgeEffectWrapper.getOrCreateLeftEffect();
        if (Float.compare(distanceCompat, i5) == 0) {
        } else {
            i = 0;
        }
        if (i == 0) {
            x-impl = Offset.getX-impl(scroll);
        } else {
            x-impl = i3;
        }
        return x-impl;
    }

    private final float pullRight-k-4lQ0M(long scroll) {
        int i;
        int x-impl;
        EdgeEffect orCreateRightEffect = this.edgeEffectWrapper.getOrCreateRightEffect();
        i = Float.compare(distanceCompat, i6) == 0 ? 1 : 0;
        if (i == 0) {
            x-impl = Offset.getX-impl(scroll);
        } else {
            x-impl = i4;
        }
        return x-impl;
    }

    private final float pullTop-k-4lQ0M(long scroll) {
        int i;
        int y-impl;
        EdgeEffect orCreateTopEffect = this.edgeEffectWrapper.getOrCreateTopEffect();
        i = Float.compare(distanceCompat, i4) == 0 ? 1 : 0;
        if (i == 0) {
            y-impl = Offset.getY-impl(scroll);
        } else {
            y-impl = i3;
        }
        return y-impl;
    }

    private final boolean releaseOppositeOverscroll-k-4lQ0M(long delta) {
        int needsInvalidation;
        boolean leftAnimating;
        boolean rightAnimating;
        androidx.compose.foundation.EdgeEffectCompat topAnimating2;
        int topAnimating;
        androidx.compose.foundation.EdgeEffectCompat bottomAnimating;
        androidx.compose.foundation.EdgeEffectCompat rightAnimating2;
        int i;
        int orCreateBottomEffect;
        EdgeEffect orCreateLeftEffect;
        float orCreateRightEffect;
        float y-impl;
        needsInvalidation = 0;
        i = 1;
        orCreateBottomEffect = 0;
        if (this.edgeEffectWrapper.isLeftAnimating() && Float.compare(x-impl2, orCreateBottomEffect) < 0) {
            if (Float.compare(x-impl2, orCreateBottomEffect) < 0) {
                EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateLeftEffect(), Offset.getX-impl(delta));
                needsInvalidation = leftAnimating;
            }
        }
        int i2 = 0;
        if (this.edgeEffectWrapper.isRightAnimating() && Float.compare(x-impl, orCreateBottomEffect) > 0) {
            if (Float.compare(x-impl, orCreateBottomEffect) > 0) {
                EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateRightEffect(), Offset.getX-impl(delta));
                if (needsInvalidation == 0) {
                    if (!this.edgeEffectWrapper.isRightAnimating()) {
                        rightAnimating = i;
                    } else {
                        rightAnimating = i2;
                    }
                } else {
                }
                needsInvalidation = rightAnimating;
            }
        }
        if (this.edgeEffectWrapper.isTopAnimating() && Float.compare(y-impl2, orCreateBottomEffect) < 0) {
            if (Float.compare(y-impl2, orCreateBottomEffect) < 0) {
                EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateTopEffect(), Offset.getY-impl(delta));
                if (needsInvalidation == 0) {
                    if (!this.edgeEffectWrapper.isTopAnimating()) {
                        topAnimating = i;
                    } else {
                        topAnimating = i2;
                    }
                } else {
                }
                needsInvalidation = topAnimating;
            }
        }
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateBottomEffect(), Offset.getY-impl(delta));
        if (this.edgeEffectWrapper.isBottomAnimating() && Float.compare(y-impl3, orCreateBottomEffect) > 0 && needsInvalidation == 0) {
            if (Float.compare(y-impl3, orCreateBottomEffect) > 0) {
                EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateBottomEffect(), Offset.getY-impl(delta));
                if (needsInvalidation == 0) {
                    if (!this.edgeEffectWrapper.isBottomAnimating()) {
                    } else {
                        i = i2;
                    }
                }
                needsInvalidation = i;
            }
        }
        return needsInvalidation;
    }

    private final boolean stopOverscrollAnimation() {
        int stopped;
        boolean leftStretched;
        boolean rightStretched;
        boolean topStretched;
        boolean bottomStretched;
        stopped = 0;
        if (this.edgeEffectWrapper.isLeftStretched()) {
            pullLeft-k-4lQ0M(Offset.Companion.getZero-F1C5BW0());
            stopped = 1;
        }
        if (this.edgeEffectWrapper.isRightStretched()) {
            pullRight-k-4lQ0M(Offset.Companion.getZero-F1C5BW0());
            stopped = 1;
        }
        if (this.edgeEffectWrapper.isTopStretched()) {
            pullTop-k-4lQ0M(Offset.Companion.getZero-F1C5BW0());
            stopped = 1;
        }
        if (this.edgeEffectWrapper.isBottomStretched()) {
            pullBottom-k-4lQ0M(Offset.Companion.getZero-F1C5BW0());
            stopped = 1;
        }
        return stopped;
    }

    public Object applyToFling-BMRW4eQ(long l, Function2<? super Velocity, ? super Continuation<? super Velocity>, ? extends Object> function22, Continuation<? super Unit> continuation3) {
        boolean anon;
        int i2;
        Object orCreateBottomEffect;
        int i;
        Object obj;
        Velocity box-impl;
        int roundToInt2;
        int leftStretched;
        int rightStretched;
        int x-impl;
        boolean empty-impl;
        int roundToInt3;
        long orCreateRightEffect;
        int topStretched;
        int bottomStretched;
        int y-impl;
        int orCreateBottomEffect2;
        int roundToInt;
        long obj9;
        Object obj11;
        Object obj12;
        anon = obj12;
        i = Integer.MIN_VALUE;
        if (obj12 instanceof AndroidEdgeEffectOverscrollEffect.applyToFling.1 && label &= i != 0) {
            anon = obj12;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj12 -= i;
            } else {
                anon = new AndroidEdgeEffectOverscrollEffect.applyToFling.1(this, obj12);
            }
        } else {
        }
        obj12 = anon.result;
        orCreateBottomEffect = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        roundToInt2 = 0;
        switch (box-impl) {
            case 0:
                ResultKt.throwOnFailure(obj12);
                obj = this;
                anon.label = 1;
                return orCreateBottomEffect;
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(obj.edgeEffectWrapper.getOrCreateLeftEffect(), MathKt.roundToInt(Velocity.getX-impl(l)));
                x-impl = Velocity.getX-impl(l);
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(obj.edgeEffectWrapper.getOrCreateRightEffect(), -roundToInt6);
                x-impl = Velocity.getX-impl(l);
                x-impl = roundToInt2;
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(obj.edgeEffectWrapper.getOrCreateTopEffect(), MathKt.roundToInt(Velocity.getY-impl(l)));
                y-impl = Velocity.getY-impl(l);
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(obj.edgeEffectWrapper.getOrCreateBottomEffect(), -roundToInt7);
                y-impl = Velocity.getY-impl(l);
                y-impl = roundToInt2;
                long consumedX = VelocityKt.Velocity(x-impl, y-impl);
                obj.invalidateOverscroll$foundation_release();
                obj9 = Velocity.minus-AH228Gc(l, function22);
                anon.L$0 = obj;
                anon.J$0 = obj9;
                anon.label = 2;
                return orCreateBottomEffect;
                obj9 = Velocity.minus-AH228Gc(obj9, function22);
                obj.scrollCycleInProgress = false;
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(obj.edgeEffectWrapper.getOrCreateLeftEffect(), MathKt.roundToInt(Velocity.getX-impl(obj9)));
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(obj.edgeEffectWrapper.getOrCreateRightEffect(), -roundToInt5);
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(obj.edgeEffectWrapper.getOrCreateTopEffect(), MathKt.roundToInt(Velocity.getY-impl(obj9)));
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(obj.edgeEffectWrapper.getOrCreateBottomEffect(), -roundToInt4);
                obj.invalidateOverscroll$foundation_release();
                obj.animateToRelease();
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure(obj12);
                break;
            case 2:
                obj9 = anon.J$0;
                ResultKt.throwOnFailure(obj12);
                obj = obj11;
                obj11 = obj12;
                obj9 = Velocity.minus-AH228Gc(obj9, function22);
                obj.scrollCycleInProgress = false;
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(obj.edgeEffectWrapper.getOrCreateLeftEffect(), MathKt.roundToInt(Velocity.getX-impl(obj9)));
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(obj.edgeEffectWrapper.getOrCreateRightEffect(), -roundToInt5);
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(obj.edgeEffectWrapper.getOrCreateTopEffect(), MathKt.roundToInt(Velocity.getY-impl(obj9)));
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(obj.edgeEffectWrapper.getOrCreateBottomEffect(), -roundToInt4);
                obj.invalidateOverscroll$foundation_release();
                obj.animateToRelease();
                return Unit.INSTANCE;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        return Unit.INSTANCE;
    }

    public long applyToScroll-Rhakbz0(long delta, int source, Function1<? super Offset, Offset> performScroll) {
        int i5;
        float pullBottom-k-4lQ0M;
        int equals-impl0;
        int i3;
        float pullRight-k-4lQ0M;
        float f;
        int rightStretched;
        int i2;
        boolean orCreateBottomEffect;
        int needsInvalidation;
        int i;
        int i4;
        float y-impl;
        final Object obj = this;
        final Object obj2 = obj25;
        if (Size.isEmpty-impl(obj.containerSize)) {
            return (Offset)obj2.invoke(Offset.box-impl(delta)).unbox-impl();
        }
        int i6 = 1;
        if (!obj.scrollCycleInProgress) {
            obj.stopOverscrollAnimation();
            obj.scrollCycleInProgress = i6;
        }
        pullRight-k-4lQ0M = 0;
        i5 = Float.compare(y-impl2, pullRight-k-4lQ0M) == 0 ? i6 : 0;
        if (i5 != 0) {
            pullBottom-k-4lQ0M = pullRight-k-4lQ0M;
        } else {
            if (obj.edgeEffectWrapper.isTopStretched()) {
                f = pullBottom-k-4lQ0M;
                i2 = 0;
                if (!obj.edgeEffectWrapper.isTopStretched()) {
                    obj.edgeEffectWrapper.getOrCreateTopEffect().onRelease();
                }
            } else {
                if (obj.edgeEffectWrapper.isBottomStretched()) {
                    f = pullBottom-k-4lQ0M;
                    i2 = 0;
                    if (!obj.edgeEffectWrapper.isBottomStretched()) {
                        obj.edgeEffectWrapper.getOrCreateBottomEffect().onRelease();
                    }
                } else {
                    pullBottom-k-4lQ0M = pullRight-k-4lQ0M;
                }
            }
        }
        rightStretched = Float.compare(x-impl3, pullRight-k-4lQ0M) == 0 ? i6 : 0;
        if (rightStretched != 0) {
        } else {
            if (obj.edgeEffectWrapper.isLeftStretched()) {
                rightStretched = pullRight-k-4lQ0M;
                i2 = 0;
                if (!obj.edgeEffectWrapper.isLeftStretched()) {
                    obj.edgeEffectWrapper.getOrCreateLeftEffect().onRelease();
                }
            } else {
                if (obj.edgeEffectWrapper.isRightStretched()) {
                    rightStretched = pullRight-k-4lQ0M;
                    i2 = 0;
                    if (!obj.edgeEffectWrapper.isRightStretched()) {
                        obj.edgeEffectWrapper.getOrCreateRightEffect().onRelease();
                    }
                } else {
                }
            }
        }
        long l = OffsetKt.Offset(pullRight-k-4lQ0M, pullBottom-k-4lQ0M);
        if (!Offset.equals-impl0(l, i2)) {
            obj.invalidateOverscroll$foundation_release();
        }
        final long minus-MK-Hz9U = Offset.minus-MK-Hz9U(delta, obj9);
        long unbox-impl2 = (Offset)obj2.invoke(Offset.box-impl(minus-MK-Hz9U)).unbox-impl();
        final long minus-MK-Hz9U2 = Offset.minus-MK-Hz9U(minus-MK-Hz9U, obj11);
        needsInvalidation = 0;
        if (NestedScrollSource.equals-impl0(performScroll, NestedScrollSource.Companion.getUserInput-WNlRxjI())) {
            int i8 = 1056964608;
            int i9 = -1090519040;
            equals-impl0 = Float.compare(x-impl, i8) > 0 ? 1 : cmp3 < 0 ? 1 : 0;
            i = Float.compare(y-impl, i8) > 0 ? 1 : cmp6 < 0 ? 1 : 0;
            if (equals-impl0 == 0) {
                if (i != 0) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
            } else {
            }
            needsInvalidation = i4;
        }
        if (!releaseOppositeOverscroll-k-4lQ0M(delta)) {
            if (needsInvalidation != 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
        } else {
        }
        if (i3 != 0) {
            obj.invalidateOverscroll$foundation_release();
        }
        return Offset.plus-MK-Hz9U(l, i2);
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public final long displacement-F1C5BW0$foundation_release() {
        long center-uvyYCjk;
        Offset pointerPosition = this.pointerPosition;
        if (pointerPosition != null) {
            center-uvyYCjk = pointerPosition.unbox-impl();
        } else {
            center-uvyYCjk = SizeKt.getCenter-uvyYCjk(this.containerSize);
        }
        return OffsetKt.Offset(x-impl /= width-impl, y-impl /= height-impl);
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public final boolean getInvalidationEnabled$foundation_release() {
        return this.invalidationEnabled;
    }

    public final MutableState<Unit> getRedrawSignal$foundation_release() {
        return this.redrawSignal;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public final void invalidateOverscroll$foundation_release() {
        boolean invalidationEnabled;
        Unit iNSTANCE;
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        int i2;
        int i;
        int distanceCompat;
        final androidx.compose.foundation.EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        final int i3 = 0;
        EdgeEffect edgeEffect = EdgeEffectWrapper.access$getTopEffect$p(edgeEffectWrapper);
        i2 = 0;
        final int i4 = 0;
        final int i5 = 1;
        if (edgeEffect != null) {
            i = 0;
            distanceCompat = Float.compare(distanceCompat2, i2) == 0 ? i5 : i4;
            if (distanceCompat == 0) {
                return i5;
            }
        }
        EdgeEffect edgeEffect2 = EdgeEffectWrapper.access$getBottomEffect$p(edgeEffectWrapper);
        if (edgeEffect2 != null) {
            i = 0;
            distanceCompat = Float.compare(distanceCompat3, i2) == 0 ? i5 : i4;
            if (distanceCompat == 0) {
                return i5;
            }
        }
        EdgeEffect edgeEffect3 = EdgeEffectWrapper.access$getLeftEffect$p(edgeEffectWrapper);
        if (edgeEffect3 != null) {
            i = 0;
            distanceCompat = Float.compare(distanceCompat4, i2) == 0 ? i5 : i4;
            if (distanceCompat == 0) {
                return i5;
            }
        }
        EdgeEffect edgeEffect4 = EdgeEffectWrapper.access$getRightEffect$p(edgeEffectWrapper);
        if (edgeEffect4 != null) {
            i = 0;
            i2 = Float.compare(distanceCompat, i2) == 0 ? i5 : i4;
            if (i2 == 0) {
                return i5;
            }
        }
        return i4;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public final void setInvalidationEnabled$foundation_release(boolean <set-?>) {
        this.invalidationEnabled = <set-?>;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public final void updateSize-uvyYCjk$foundation_release(long size) {
        long edgeEffectWrapper;
        long l;
        int roundToInt;
        edgeEffectWrapper = Size.Companion.getZero-NH-jbRc();
        equals-impl02 ^= 1;
        this.containerSize = size;
        if (i != 0) {
            roundToInt = MathKt.roundToInt(Size.getHeight-impl(size));
            this.edgeEffectWrapper.setSize-ozmzZPI(IntSizeKt.IntSize(MathKt.roundToInt(Size.getWidth-impl(size)), roundToInt));
        }
        if (!Size.equals-impl0(this.containerSize, obj1) && i != 0) {
            if (i != 0) {
                invalidateOverscroll$foundation_release();
                animateToRelease();
            }
        }
    }
}
