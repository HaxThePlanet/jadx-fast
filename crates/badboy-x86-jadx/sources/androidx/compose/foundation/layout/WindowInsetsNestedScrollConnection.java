package androidx.compose.foundation.layout;

import android.os.CancellationSignal;
import android.view.View;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.Velocity.Companion;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.FloatRef;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.Job.DefaultImpls;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019H\u0002J\u0008\u0010#\u001a\u00020!H\u0002J\u0006\u0010$\u001a\u00020!J+\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0017H\u0082@ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+J\u0010\u0010,\u001a\u0004\u0018\u00010\rH\u0082@¢\u0006\u0002\u0010-J\u0012\u0010.\u001a\u00020!2\u0008\u0010/\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u00100\u001a\u00020!2\u0006\u0010/\u001a\u00020\rH\u0016J#\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0096@ø\u0001\u0000¢\u0006\u0004\u00083\u00104J*\u00105\u001a\u0002062\u0006\u00102\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000¢\u0006\u0004\u00089\u0010:J\u001b\u0010;\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0096@ø\u0001\u0000¢\u0006\u0004\u0008<\u0010=J\"\u0010>\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000¢\u0006\u0004\u0008?\u0010@J\u0018\u0010A\u001a\u00020!2\u0006\u0010/\u001a\u00020\r2\u0006\u0010B\u001a\u00020CH\u0016J\u0008\u0010D\u001a\u00020!H\u0002J\"\u0010E\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u0010F\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\u0008G\u0010HR\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001f\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006I", d2 = {"Landroidx/compose/foundation/layout/WindowInsetsNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroid/view/WindowInsetsAnimationControlListener;", "windowInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "view", "Landroid/view/View;", "sideCalculator", "Landroidx/compose/foundation/layout/SideCalculator;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/layout/AndroidWindowInsets;Landroid/view/View;Landroidx/compose/foundation/layout/SideCalculator;Landroidx/compose/ui/unit/Density;)V", "animationController", "Landroid/view/WindowInsetsAnimationController;", "animationJob", "Lkotlinx/coroutines/Job;", "cancellationSignal", "Landroid/os/CancellationSignal;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "isControllerRequested", "", "partialConsumption", "", "getSideCalculator", "()Landroidx/compose/foundation/layout/SideCalculator;", "getView", "()Landroid/view/View;", "getWindowInsets", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "adjustInsets", "", "inset", "animationEnded", "dispose", "fling", "Landroidx/compose/ui/unit/Velocity;", "available", "flingAmount", "towardShown", "fling-huYlsQE", "(JFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnimationController", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCancelled", "controller", "onFinished", "onPostFling", "consumed", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "onReady", "types", "", "requestAnimationController", "scroll", "scrollAmount", "scroll-8S9VItk", "(JF)J", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class WindowInsetsNestedScrollConnection implements NestedScrollConnection, WindowInsetsAnimationControlListener {

    private WindowInsetsAnimationController animationController;
    private Job animationJob;
    private final CancellationSignal cancellationSignal;
    private CancellableContinuation<? super WindowInsetsAnimationController> continuation;
    private final Density density;
    private boolean isControllerRequested;
    private float partialConsumption;
    private final androidx.compose.foundation.layout.SideCalculator sideCalculator;
    private final View view;
    private final androidx.compose.foundation.layout.AndroidWindowInsets windowInsets;
    public WindowInsetsNestedScrollConnection(androidx.compose.foundation.layout.AndroidWindowInsets windowInsets, View view, androidx.compose.foundation.layout.SideCalculator sideCalculator, Density density) {
        super();
        this.windowInsets = windowInsets;
        this.view = view;
        this.sideCalculator = sideCalculator;
        this.density = density;
        CancellationSignal cancellationSignal = new CancellationSignal();
        this.cancellationSignal = cancellationSignal;
    }

    public static final void access$adjustInsets(androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection $this, float inset) {
        $this.adjustInsets(inset);
    }

    public static final Object access$fling-huYlsQE(androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection $this, long available, float flingAmount, boolean towardShown, Continuation $completion) {
        return $this.fling-huYlsQE(available, flingAmount, towardShown, $completion);
    }

    public static final Object access$getAnimationController(androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection $this, Continuation $completion) {
        return $this.getAnimationController($completion);
    }

    public static final Job access$getAnimationJob$p(androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection $this) {
        return $this.animationJob;
    }

    public static final void access$requestAnimationController(androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection $this) {
        $this.requestAnimationController();
    }

    public static final void access$setAnimationController$p(androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection $this, WindowInsetsAnimationController <set-?>) {
        $this.animationController = <set-?>;
    }

    public static final void access$setAnimationJob$p(androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection $this, Job <set-?>) {
        $this.animationJob = <set-?>;
    }

    public static final void access$setContinuation$p(androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection $this, CancellableContinuation <set-?>) {
        $this.continuation = <set-?>;
    }

    private final void adjustInsets(float inset) {
        int i3;
        android.graphics.Insets currentInsets;
        android.graphics.Insets adjustInsets;
        int i;
        int i2;
        final WindowInsetsAnimationController animationController = this.animationController;
        if (animationController != null) {
            i3 = 0;
            int i4 = 0;
            animationController.setInsetsAndAlpha(this.sideCalculator.adjustInsets(animationController.getCurrentInsets(), Math.round(inset)), 1065353216, 0);
        }
    }

    private final void animationEnded() {
        WindowInsetsAnimationController animationController;
        int visible;
        androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.animationEnded.1 windowInsetsAnimationCancelledException;
        animationController = this.animationController;
        final int i3 = 0;
        if (animationController != null && animationController.isReady() == 1) {
            if (animationController.isReady() == 1) {
            } else {
                visible = i3;
            }
        } else {
        }
        animationController = this.animationController;
        if (visible != 0 && animationController != null) {
            animationController = this.animationController;
            if (animationController != null) {
                animationController.finish(this.windowInsets.isVisible());
            }
        }
        int i = 0;
        this.animationController = i;
        CancellableContinuation continuation = this.continuation;
        if (continuation != null) {
            continuation.resume(i, (Function1)WindowInsetsNestedScrollConnection.animationEnded.1.INSTANCE);
        }
        this.continuation = i;
        Job animationJob = this.animationJob;
        if (animationJob != null) {
            windowInsetsAnimationCancelledException = new WindowInsetsAnimationCancelledException();
            animationJob.cancel((CancellationException)windowInsetsAnimationCancelledException);
        }
        this.animationJob = i;
        this.partialConsumption = 0;
        this.isControllerRequested = i3;
    }

    private final Object fling-huYlsQE(long l, float f2, boolean z3, Continuation<? super Velocity> continuation4) {
        Object obj4;
        boolean anon;
        int i6;
        androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection connection;
        Object flingAmount;
        long j$0;
        long available;
        int i5;
        Object _this2;
        Object l$0;
        Object _this;
        int i9;
        Object l$02;
        int i7;
        int endPercent;
        long i;
        int i2;
        long j$02;
        androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.fling.3 available2;
        Object obj;
        int currentInsets;
        int i8;
        int animationController;
        androidx.compose.foundation.layout.WindowInsetsAnimationCancelledException splineBasedFloatDecayAnimationSpec;
        int cmp;
        Object obj3;
        int valueOf;
        int num;
        Object obj2;
        int i4;
        int i3;
        long l2;
        obj4 = obj27;
        anon = obj4;
        i5 = Integer.MIN_VALUE;
        if (obj4 instanceof WindowInsetsNestedScrollConnection.fling.1 && label2 &= i5 != 0) {
            anon = obj4;
            i5 = Integer.MIN_VALUE;
            if (label2 &= i5 != 0) {
                anon.label = label -= i5;
                connection = this;
            } else {
                anon = new WindowInsetsNestedScrollConnection.fling.1(this, obj4);
            }
        } else {
        }
        Object result = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i9 = 0;
        i = 0;
        i2 = 1;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure(result);
                _this2 = this;
                boolean z = continuation4;
                currentInsets = z3;
                Job animationJob = _this2.animationJob;
                splineBasedFloatDecayAnimationSpec = new WindowInsetsAnimationCancelledException();
                animationJob.cancel((CancellationException)splineBasedFloatDecayAnimationSpec);
                _this2.animationJob = i9;
                _this2.partialConsumption = i;
                animationController = i2;
                animationController = 0;
                return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
                anon.L$0 = _this2;
                anon.J$0 = l;
                anon.F$0 = currentInsets;
                anon.label = i2;
                return cOROUTINE_SUSPENDED;
                i8 = currentInsets;
                break;
            case 1:
                j$02 = anon.J$0;
                _this2 = anon.L$0;
                ResultKt.throwOnFailure(result);
                i8 = available3;
                flingAmount = result;
                break;
            case 2:
                available = anon.J$0;
                _this = anon.L$1;
                l$02 = anon.L$0;
                ResultKt.throwOnFailure(result);
                float element = _this.element;
                return Velocity.box-impl(l$02.sideCalculator.consumedVelocity-QWom1Mo(available, cOROUTINE_SUSPENDED));
            case 3:
                j$0 = anon.J$0;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(result);
                int i14 = 0;
                return Velocity.box-impl(l$0.sideCalculator.consumedVelocity-QWom1Mo(j$0, cOROUTINE_SUSPENDED));
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        obj3 = flingAmount;
        if ((WindowInsetsAnimationController)obj3 == null) {
            return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
        }
        int valueOf2 = _this2.sideCalculator.valueOf((WindowInsetsAnimationController)obj3.getHiddenStateInsets());
        valueOf = _this2.sideCalculator.valueOf(obj3.getShownStateInsets());
        currentInsets = _this2.sideCalculator.valueOf(obj3.getCurrentInsets());
        if (Float.compare(i8, i) <= 0) {
            if (currentInsets != valueOf2) {
                if (Float.compare(i8, i) >= 0 && currentInsets == valueOf) {
                    if (currentInsets == valueOf) {
                        i7 = currentInsets == valueOf ? i2 : 0;
                    }
                }
            } else {
            }
            obj3.finish(i7);
            _this2.animationController = i9;
            return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
        } else {
        }
        splineBasedFloatDecayAnimationSpec = new SplineBasedFloatDecayAnimationSpec(_this2.density);
        f += flingDistance;
        endPercent = Float.compare(i13, i16) > 0 ? 1 : 0;
        i2 = endPercent != 0 ? valueOf : valueOf2;
        if (Float.compare(i9, f4) <= 0) {
            if (Float.compare(i9, f5) < 0) {
                i = j$02;
                obj = _this2;
                _this = new Ref.FloatRef();
                i4 = endPercent != 0 ? 1 : 0;
                available2 = new WindowInsetsNestedScrollConnection.fling.2(obj, currentInsets, i8, splineBasedFloatDecayAnimationSpec, valueOf2, valueOf, _this, obj3, i4, 0);
                anon.L$0 = obj;
                anon.L$1 = _this;
                anon.J$0 = i;
                anon.label = 2;
                if (CoroutineScopeKt.coroutineScope((Function2)available2, anon) == cOROUTINE_SUSPENDED) {
                    return cOROUTINE_SUSPENDED;
                }
                available = i;
                l$02 = obj;
            } else {
                valueOf = endPercent != 0 ? 1 : 0;
                obj = _this2;
                i = i4;
                available2 = new WindowInsetsNestedScrollConnection.fling.3(obj, currentInsets, i2, i8, obj3, valueOf, 0);
                anon.L$0 = obj;
                anon.J$0 = i;
                anon.label = 3;
                if (CoroutineScopeKt.coroutineScope((Function2)available2, anon) == cOROUTINE_SUSPENDED) {
                    return cOROUTINE_SUSPENDED;
                }
                j$0 = i;
                l$0 = obj;
            }
        }
        obj = _this2;
        _this2 = i2;
        i = l2;
    }

    private final Object getAnimationController(Continuation<? super WindowInsetsAnimationController> $completion) {
        WindowInsetsAnimationController animationController = this.animationController;
        int i = 0;
        int i2 = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellableContinuationImpl.initCancellability();
        int i4 = 0;
        WindowInsetsNestedScrollConnection.access$setContinuation$p(this, (CancellableContinuation)cancellableContinuationImpl);
        WindowInsetsNestedScrollConnection.access$requestAnimationController(this);
        Object uCont$iv = cancellableContinuationImpl.getResult();
        if (animationController == null && uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            i = 0;
            i2 = 0;
            cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
            cancellableContinuationImpl.initCancellability();
            i4 = 0;
            WindowInsetsNestedScrollConnection.access$setContinuation$p(this, (CancellableContinuation)cancellableContinuationImpl);
            WindowInsetsNestedScrollConnection.access$requestAnimationController(this);
            uCont$iv = cancellableContinuationImpl.getResult();
            if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended($completion);
            }
            return uCont$iv;
        }
        return animationController;
    }

    private final void requestAnimationController() {
        boolean isControllerRequested;
        WindowInsetsController windowInsetsController;
        int type$foundation_layout_release;
        int i2;
        int i;
        CancellationSignal cancellationSignal;
        Object obj;
        this.isControllerRequested = true;
        windowInsetsController = this.view.getWindowInsetsController();
        if (!this.isControllerRequested && windowInsetsController != null) {
            this.isControllerRequested = true;
            windowInsetsController = this.view.getWindowInsetsController();
            if (windowInsetsController != null) {
                windowInsetsController.controlWindowInsetsAnimation(this.windowInsets.getType$foundation_layout_release(), -1, obj4, 0, this.cancellationSignal);
            }
        }
    }

    private final long scroll-8S9VItk(long available, float scrollAmount) {
        int i;
        int i2;
        int visible;
        int i5;
        int cmp;
        int i4;
        int adjustInsets;
        int i3;
        Job animationJob = this.animationJob;
        if (animationJob != null) {
            i = 0;
            WindowInsetsAnimationCancelledException windowInsetsAnimationCancelledException = new WindowInsetsAnimationCancelledException();
            animationJob.cancel((CancellationException)windowInsetsAnimationCancelledException);
            this.animationJob = 0;
        }
        WindowInsetsAnimationController animationController = this.animationController;
        int i6 = 0;
        int i7 = 0;
        visible = Float.compare(obj14, i6) == 0 ? i5 : i7;
        if (visible == 0) {
            if (Float.compare(obj14, i6) > 0) {
            } else {
                i5 = i7;
            }
            if (this.windowInsets.isVisible() == i5 && animationController == null) {
                if (animationController == null) {
                } else {
                    if (animationController == null) {
                        this.partialConsumption = i6;
                        requestAnimationController();
                        return this.sideCalculator.consumedOffsets-MK-Hz9U(available);
                    }
                    int valueOf = this.sideCalculator.valueOf(animationController.getHiddenStateInsets());
                    int valueOf2 = this.sideCalculator.valueOf(animationController.getShownStateInsets());
                    android.graphics.Insets currentInsets = animationController.getCurrentInsets();
                    int valueOf3 = this.sideCalculator.valueOf(currentInsets);
                    i4 = Float.compare(obj14, i6) > 0 ? valueOf2 : valueOf;
                    if (valueOf3 == i4) {
                        this.partialConsumption = i6;
                        return Offset.Companion.getZero-F1C5BW0();
                    }
                    i8 += partialConsumption;
                    int i11 = 0;
                    int coerceIn = RangesKt.coerceIn(Math.round(i9), valueOf, valueOf2);
                    i3 = 0;
                    this.partialConsumption = i9 - $this$fastRoundToInt$iv3;
                    if (coerceIn != valueOf3) {
                        animationController.setInsetsAndAlpha(this.sideCalculator.adjustInsets(currentInsets, coerceIn), 1065353216, i6);
                    }
                }
            } else {
            }
            return this.sideCalculator.consumedOffsets-MK-Hz9U(available);
        }
        return Offset.Companion.getZero-F1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public final void dispose() {
        int i;
        androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.dispose.1 iNSTANCE;
        android.graphics.Insets hiddenStateInsets;
        CancellableContinuation continuation = this.continuation;
        i = 0;
        if (continuation != null) {
            continuation.resume(i, (Function1)WindowInsetsNestedScrollConnection.dispose.1.INSTANCE);
        }
        Job animationJob = this.animationJob;
        int i2 = 1;
        if (animationJob != null) {
            Job.DefaultImpls.cancel$default(animationJob, i, i2, i);
        }
        WindowInsetsAnimationController animationController = this.animationController;
        if (animationController != null) {
            animationController.finish(equal ^= i2);
        }
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public final Density getDensity() {
        return this.density;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public final androidx.compose.foundation.layout.SideCalculator getSideCalculator() {
        return this.sideCalculator;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public final View getView() {
        return this.view;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public final androidx.compose.foundation.layout.AndroidWindowInsets getWindowInsets() {
        return this.windowInsets;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public void onCancelled(WindowInsetsAnimationController controller) {
        animationEnded();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public void onFinished(WindowInsetsAnimationController controller) {
        animationEnded();
    }

    public Object onPostFling-RZ2iAVY(long consumed, long available, Continuation<? super Velocity> $completion) {
        return this.fling-huYlsQE($completion, obj5, this.sideCalculator.showMotion(Velocity.getX-impl($completion), Velocity.getY-impl($completion)), 1);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long onPostScroll-DzOQY0M(long consumed, long available, int source) {
        return scroll-8S9VItk(source, obj7);
    }

    public Object onPreFling-QWom1Mo(long available, Continuation<? super Velocity> $completion) {
        return this.fling-huYlsQE(available, obj5, this.sideCalculator.hideMotion(Velocity.getX-impl(available), Velocity.getY-impl(available)), 0);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long onPreScroll-OzD1aCk(long available, int source) {
        return scroll-8S9VItk(available, source);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public void onReady(WindowInsetsAnimationController controller, int types) {
        androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.onReady.1 iNSTANCE;
        this.animationController = controller;
        this.isControllerRequested = false;
        CancellableContinuation continuation = this.continuation;
        if (continuation != null) {
            continuation.resume(controller, (Function1)WindowInsetsNestedScrollConnection.onReady.1.INSTANCE);
        }
        this.continuation = 0;
    }
}
