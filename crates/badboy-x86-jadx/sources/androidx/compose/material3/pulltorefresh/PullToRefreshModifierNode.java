package androidx.compose.material3.pulltorefresh;

import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B3\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u00106\u001a\u00020\u0008H\u0082@¢\u0006\u0002\u00107J\u000e\u00108\u001a\u00020\u0008H\u0082@¢\u0006\u0002\u00107J\u0008\u00109\u001a\u00020\u0010H\u0002J\u001a\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;H\u0002ø\u0001\u0000¢\u0006\u0004\u0008=\u0010>J\u0008\u0010?\u001a\u00020\u0008H\u0016J*\u0010@\u001a\u00020;2\u0006\u0010A\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\u0006\u0010B\u001a\u00020CH\u0016ø\u0001\u0000¢\u0006\u0004\u0008D\u0010EJ\u001b\u0010F\u001a\u00020G2\u0006\u0010<\u001a\u00020GH\u0096@ø\u0001\u0000¢\u0006\u0004\u0008H\u0010IJ\"\u0010J\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\u0006\u0010B\u001a\u00020CH\u0016ø\u0001\u0000¢\u0006\u0004\u0008K\u0010LJ\u0016\u0010M\u001a\u00020\u00102\u0006\u0010N\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010OJ\u0006\u0010P\u001a\u00020\u0008R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R+\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00108B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0018\u0010\u0019\u001a\u0004\u0008\u0015\u0010\u0012\"\u0004\u0008\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b\"\u0004\u0008\u001c\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0004\u0010\u001b\"\u0004\u0008\u001e\u0010\u001dR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\"\"\u0004\u0008#\u0010$R\u0014\u0010%\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008&\u0010\u0012R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008'\u0010(\"\u0004\u0008)\u0010*R\"\u0010\u000c\u001a\u00020\rX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\u0008+\u0010\u0012\"\u0004\u0008,\u0010\u0017R\u0014\u0010.\u001a\u00020/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00080\u00101R+\u00102\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00108B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u00085\u0010\u0019\u001a\u0004\u00083\u0010\u0012\"\u0004\u00084\u0010\u0017\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006Q", d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "isRefreshing", "", "onRefresh", "Lkotlin/Function0;", "", "enabled", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "threshold", "Landroidx/compose/ui/unit/Dp;", "(ZLkotlin/jvm/functions/Function0;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "adjustedDistancePulled", "", "getAdjustedDistancePulled", "()F", "<set-?>", "distancePulled", "getDistancePulled", "setDistancePulled", "(F)V", "distancePulled$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getEnabled", "()Z", "setEnabled", "(Z)V", "setRefreshing", "nestedScrollNode", "Landroidx/compose/ui/node/DelegatableNode;", "getOnRefresh", "()Lkotlin/jvm/functions/Function0;", "setOnRefresh", "(Lkotlin/jvm/functions/Function0;)V", "progress", "getProgress", "getState", "()Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "setState", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;)V", "getThreshold-D9Ej5fM", "setThreshold-0680j_4", "F", "thresholdPx", "", "getThresholdPx", "()I", "verticalOffset", "getVerticalOffset", "setVerticalOffset", "verticalOffset$delegate", "animateToHidden", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToThreshold", "calculateVerticalOffset", "consumeAvailableOffset", "Landroidx/compose/ui/geometry/Offset;", "available", "consumeAvailableOffset-MK-Hz9U", "(J)J", "onAttach", "onPostScroll", "consumed", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "onRelease", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PullToRefreshModifierNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, NestedScrollConnection {

    public static final int $stable = 8;
    private final MutableFloatState distancePulled$delegate;
    private boolean enabled;
    private boolean isRefreshing;
    private DelegatableNode nestedScrollNode;
    private Function0<Unit> onRefresh;
    private androidx.compose.material3.pulltorefresh.PullToRefreshState state;
    private float threshold;
    private final MutableFloatState verticalOffset$delegate;
    static {
        final int i = 8;
    }

    private PullToRefreshModifierNode(boolean isRefreshing, Function0<Unit> onRefresh, boolean enabled, androidx.compose.material3.pulltorefresh.PullToRefreshState state, float threshold) {
        super();
        this.isRefreshing = isRefreshing;
        this.onRefresh = onRefresh;
        this.enabled = enabled;
        this.state = state;
        this.threshold = threshold;
        this.nestedScrollNode = NestedScrollNodeKt.nestedScrollModifierNode((NestedScrollConnection)this, 0);
        int i = 0;
        this.verticalOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i);
        this.distancePulled$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i);
    }

    public PullToRefreshModifierNode(boolean z, Function0 function02, boolean z3, androidx.compose.material3.pulltorefresh.PullToRefreshState pullToRefreshState4, float f5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(z, function02, z3, pullToRefreshState4, f5);
    }

    public static final Object access$animateToHidden(androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode $this, Continuation $completion) {
        return $this.animateToHidden($completion);
    }

    public static final Object access$animateToThreshold(androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode $this, Continuation $completion) {
        return $this.animateToThreshold($completion);
    }

    public static final int access$getThresholdPx(androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode $this) {
        return $this.getThresholdPx();
    }

    public static final float access$getVerticalOffset(androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode $this) {
        return $this.getVerticalOffset();
    }

    public static final Object access$onRelease(androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode $this, float velocity, Continuation $completion) {
        return $this.onRelease(velocity, $completion);
    }

    private final Object animateToHidden(Continuation<? super Unit> continuation) {
        boolean anon;
        int i;
        Object l$0;
        int i3;
        androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode label;
        Object animateToHidden;
        int i2;
        Object obj6;
        anon = continuation;
        i3 = Integer.MIN_VALUE;
        if (continuation instanceof PullToRefreshModifierNode.animateToHidden.1 && label2 &= i3 != 0) {
            anon = continuation;
            i3 = Integer.MIN_VALUE;
            if (label2 &= i3 != 0) {
                anon.label = obj6 -= i3;
            } else {
                anon = new PullToRefreshModifierNode.animateToHidden.1(this, continuation);
            }
        } else {
        }
        obj6 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj6);
                label = this;
                anon.L$0 = label;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                l$0 = label;
                break;
            case 1:
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj6);
                break;
            default:
                obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj6;
        }
        int i4 = 0;
        l$0.setDistancePulled(i4);
        l$0.setVerticalOffset(i4);
        return Unit.INSTANCE;
    }

    private final Object animateToThreshold(Continuation<? super Unit> continuation) {
        boolean anon;
        int i;
        Object l$0;
        int i2;
        androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode label;
        Object animateToThreshold;
        int i3;
        Object obj6;
        anon = continuation;
        i2 = Integer.MIN_VALUE;
        if (continuation instanceof PullToRefreshModifierNode.animateToThreshold.1 && label2 &= i2 != 0) {
            anon = continuation;
            i2 = Integer.MIN_VALUE;
            if (label2 &= i2 != 0) {
                anon.label = obj6 -= i2;
            } else {
                anon = new PullToRefreshModifierNode.animateToThreshold.1(this, continuation);
            }
        } else {
        }
        obj6 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj6);
                label = this;
                anon.L$0 = label;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                l$0 = label;
                break;
            case 1:
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj6);
                break;
            default:
                obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj6;
        }
        l$0.setDistancePulled((float)thresholdPx);
        l$0.setVerticalOffset((float)thresholdPx2);
        return Unit.INSTANCE;
    }

    private final float calculateVerticalOffset() {
        float overshootPercent;
        float coerceIn;
        int i2;
        double d;
        int i;
        if (Float.compare(adjustedDistancePulled, coerceIn) <= 0) {
            overshootPercent = getAdjustedDistancePulled();
        } else {
            coerceIn = RangesKt.coerceIn(f -= i4, 0, 1073741824);
            overshootPercent = i;
        }
        return overshootPercent;
    }

    private final long consumeAvailableOffset-MK-Hz9U(long available) {
        boolean coerceAtLeast;
        int i;
        float verticalOffset;
        final int i3 = 0;
        if (this.isRefreshing) {
            i = i3;
        } else {
            coerceAtLeast = RangesKt.coerceAtLeast(distancePulled += y-impl, i3);
            i = coerceAtLeast - distancePulled2;
            setDistancePulled(coerceAtLeast);
            setVerticalOffset(calculateVerticalOffset());
        }
        return OffsetKt.Offset(i3, i);
    }

    private final float getAdjustedDistancePulled() {
        return distancePulled *= i2;
    }

    private final float getDistancePulled() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.distancePulled$delegate.getFloatValue();
    }

    private final float getProgress() {
        return adjustedDistancePulled /= f;
    }

    private final int getThresholdPx() {
        int i = 0;
        return (Density)CompositionLocalConsumerModifierNodeKt.currentValueOf((CompositionLocalConsumerModifierNode)this, (CompositionLocal)CompositionLocalsKt.getLocalDensity()).roundToPx-0680j_4(this.threshold);
    }

    private final float getVerticalOffset() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.verticalOffset$delegate.getFloatValue();
    }

    private final Object onRelease(float f, Continuation<? super Float> continuation2) {
        boolean anon;
        int i;
        Object l$0;
        int i3;
        int onRefresh;
        int cmp;
        int i2;
        Object animateToThreshold;
        float f2;
        float obj8;
        Object obj9;
        anon = continuation2;
        i3 = Integer.MIN_VALUE;
        if (continuation2 instanceof PullToRefreshModifierNode.onRelease.1 && label &= i3 != 0) {
            anon = continuation2;
            i3 = Integer.MIN_VALUE;
            if (label &= i3 != 0) {
                anon.label = obj9 -= i3;
            } else {
                anon = new PullToRefreshModifierNode.onRelease.1(this, continuation2);
            }
        } else {
        }
        obj9 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        final int i4 = 0;
        switch (onRefresh) {
            case 0:
                ResultKt.throwOnFailure(obj9);
                onRefresh = this;
                return Boxing.boxFloat(i4);
                anon.L$0 = onRefresh;
                anon.F$0 = f;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                l$0 = onRefresh;
                anon.L$0 = onRefresh;
                anon.F$0 = f;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                l$0 = onRefresh;
                i2 = 0;
                obj8 = i4;
                obj8 = i4;
                l$0.setDistancePulled(i4);
                return Boxing.boxFloat(obj8);
            case 1:
                obj8 = anon.F$0;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj9);
                break;
            case 2:
                obj8 = anon.F$0;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj9);
                i2 = 0;
                obj8 = i4;
                obj8 = i4;
                l$0.setDistancePulled(i4);
                return Boxing.boxFloat(obj8);
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        l$0.onRefresh.invoke();
    }

    private final void setDistancePulled(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.distancePulled$delegate.setFloatValue(<set-?>);
    }

    private final void setVerticalOffset(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.verticalOffset$delegate.setFloatValue(<set-?>);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Function0<Unit> getOnRefresh() {
        return this.onRefresh;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final androidx.compose.material3.pulltorefresh.PullToRefreshState getState() {
        return this.state;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final float getThreshold-D9Ej5fM() {
        return this.threshold;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final boolean isRefreshing() {
        return this.isRefreshing;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onAttach() {
        delegate(this.nestedScrollNode);
        final int i = 0;
        PullToRefreshModifierNode.onAttach.1 anon = new PullToRefreshModifierNode.onAttach.1(this, i);
        BuildersKt.launch$default(getCoroutineScope(), i, 0, (Function2)anon, 3, 0);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public long onPostScroll-DzOQY0M(long consumed, long available, int source) {
        long consumeAvailableOffset-MK-Hz9U;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i2;
        int i;
        androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.onPostScroll.1 anon;
        int i3;
        int i4;
        if (this.state.isAnimating()) {
            consumeAvailableOffset-MK-Hz9U = Offset.Companion.getZero-F1C5BW0();
        } else {
            if (!this.enabled) {
                consumeAvailableOffset-MK-Hz9U = Offset.Companion.getZero-F1C5BW0();
            } else {
                if (NestedScrollSource.equals-impl0(obj13, NestedScrollSource.Companion.getUserInput-WNlRxjI())) {
                    consumeAvailableOffset-MK-Hz9U = consumeAvailableOffset-MK-Hz9U(source);
                    i = 0;
                    PullToRefreshModifierNode.onPostScroll.1 anon2 = new PullToRefreshModifierNode.onPostScroll.1(this, i);
                    BuildersKt.launch$default(getCoroutineScope(), 0, i, (Function2)anon2, 3, 0);
                } else {
                    consumeAvailableOffset-MK-Hz9U = Offset.Companion.getZero-F1C5BW0();
                }
            }
        }
        return consumeAvailableOffset-MK-Hz9U;
    }

    public Object onPreFling-QWom1Mo(long l, Continuation<? super Velocity> continuation2) {
        boolean anon;
        int i4;
        int i2;
        androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode label;
        float y-impl;
        int i3;
        int i;
        Object obj7;
        Object obj9;
        anon = obj9;
        i2 = Integer.MIN_VALUE;
        if (obj9 instanceof PullToRefreshModifierNode.onPreFling.1 && label2 &= i2 != 0) {
            anon = obj9;
            i2 = Integer.MIN_VALUE;
            if (label2 &= i2 != 0) {
                anon.label = obj9 -= i2;
            } else {
                anon = new PullToRefreshModifierNode.onPreFling.1(this, obj9);
            }
        } else {
        }
        obj9 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj9);
                anon.F$0 = 0;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                ResultKt.throwOnFailure(obj9);
                i3 = obj7;
                obj7 = obj9;
                break;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        return Velocity.box-impl(VelocityKt.Velocity(i3, (Number)obj7.floatValue()));
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public long onPreScroll-OzD1aCk(long available, int source) {
        boolean cmp;
        long consumeAvailableOffset-MK-Hz9U;
        int i;
        if (this.state.isAnimating()) {
            consumeAvailableOffset-MK-Hz9U = Offset.Companion.getZero-F1C5BW0();
        } else {
            if (!this.enabled) {
                consumeAvailableOffset-MK-Hz9U = Offset.Companion.getZero-F1C5BW0();
            } else {
                if (NestedScrollSource.equals-impl0(obj5, NestedScrollSource.Companion.getUserInput-WNlRxjI()) && Float.compare(y-impl, i) < 0) {
                    if (Float.compare(y-impl, i) < 0) {
                        consumeAvailableOffset-MK-Hz9U = consumeAvailableOffset-MK-Hz9U(available);
                    } else {
                        consumeAvailableOffset-MK-Hz9U = Offset.Companion.getZero-F1C5BW0();
                    }
                } else {
                }
            }
        }
        return consumeAvailableOffset-MK-Hz9U;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void setEnabled(boolean <set-?>) {
        this.enabled = <set-?>;
    }

    public final void setOnRefresh(Function0<Unit> <set-?>) {
        this.onRefresh = <set-?>;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void setRefreshing(boolean <set-?>) {
        this.isRefreshing = <set-?>;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void setState(androidx.compose.material3.pulltorefresh.PullToRefreshState <set-?>) {
        this.state = <set-?>;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void setThreshold-0680j_4(float <set-?>) {
        this.threshold = <set-?>;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void update() {
        final int i2 = 0;
        PullToRefreshModifierNode.update.1 anon = new PullToRefreshModifierNode.update.1(this, i2);
        BuildersKt.launch$default(getCoroutineScope(), 0, i2, (Function2)anon, 3, 0);
    }
}
