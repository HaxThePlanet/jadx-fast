package androidx.compose.ui.scrollcapture;

import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.CancellationSignal;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import android.view.Surface;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRect.Companion;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.math.MathKt;
import kotlin.random.Random;
import kotlin.random.Random.Default;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.NonCancellable;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0001\u0018\u00002\u00020\u0001:\u0001\"B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J.\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u001bH\u0016J\u001e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u001bH\u0016J \u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u000c\u0010\u001f\u001a\u00020\u0010*\u00020 H\u0002J\u000c\u0010!\u001a\u00020\u0010*\u00020 H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback;", "Landroid/view/ScrollCaptureCallback;", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "viewportBoundsInWindow", "Landroidx/compose/ui/unit/IntRect;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "listener", "Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroidx/compose/ui/unit/IntRect;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;)V", "requestCount", "", "scrollTracker", "Landroidx/compose/ui/scrollcapture/RelativeScroller;", "onScrollCaptureEnd", "", "onReady", "Ljava/lang/Runnable;", "onScrollCaptureImageRequest", "session", "Landroid/view/ScrollCaptureSession;", "signal", "Landroid/os/CancellationSignal;", "captureArea", "Landroid/graphics/Rect;", "onComplete", "Ljava/util/function/Consumer;", "(Landroid/view/ScrollCaptureSession;Landroidx/compose/ui/unit/IntRect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onScrollCaptureSearch", "onScrollCaptureStart", "drawDebugBackground", "Landroid/graphics/Canvas;", "drawDebugOverlay", "ScrollCaptureSessionListener", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComposeScrollCaptureCallback implements ScrollCaptureCallback {

    public static final int $stable = 8;
    private final CoroutineScope coroutineScope;
    private final androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.ScrollCaptureSessionListener listener;
    private final SemanticsNode node;
    private int requestCount;
    private final androidx.compose.ui.scrollcapture.RelativeScroller scrollTracker;
    private final IntRect viewportBoundsInWindow;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0008\u0010\u0004\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0005À\u0006\u0001", d2 = {"Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;", "", "onSessionEnded", "", "onSessionStarted", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ScrollCaptureSessionListener {
        public abstract void onSessionEnded();

        public abstract void onSessionStarted();
    }
    static {
        final int i = 8;
    }

    public ComposeScrollCaptureCallback(SemanticsNode node, IntRect viewportBoundsInWindow, CoroutineScope coroutineScope, androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.ScrollCaptureSessionListener listener) {
        super();
        this.node = node;
        this.viewportBoundsInWindow = viewportBoundsInWindow;
        this.listener = listener;
        this.coroutineScope = CoroutineScopeKt.plus(coroutineScope, (CoroutineContext)DisableAnimationMotionDurationScale.INSTANCE);
        ComposeScrollCaptureCallback.scrollTracker.1 anon = new ComposeScrollCaptureCallback.scrollTracker.1(this, 0);
        RelativeScroller relativeScroller = new RelativeScroller(this.viewportBoundsInWindow.getHeight(), (Function2)anon);
        this.scrollTracker = relativeScroller;
    }

    public static final androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.ScrollCaptureSessionListener access$getListener$p(androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback $this) {
        return $this.listener;
    }

    public static final SemanticsNode access$getNode$p(androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback $this) {
        return $this.node;
    }

    public static final androidx.compose.ui.scrollcapture.RelativeScroller access$getScrollTracker$p(androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback $this) {
        return $this.scrollTracker;
    }

    public static final Object access$onScrollCaptureImageRequest(androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback $this, ScrollCaptureSession session, IntRect captureArea, Continuation $completion) {
        return $this.onScrollCaptureImageRequest(session, captureArea, $completion);
    }

    private final void drawDebugBackground(Canvas $this$drawDebugBackground) {
        nextFloat *= i2;
        $this$drawDebugBackground.drawColor(ColorKt.toArgb-8_81llA(Color.Companion.hsl-JlNiLsg$default(Color.Companion, i, 1061158912, 1056964608, 1065353216, 0, 16, 0)));
    }

    private final void drawDebugOverlay(Canvas $this$drawDebugOverlay) {
        final int i = 1101004800;
        Paint paint = new Paint();
        Paint paint2 = paint;
        int i4 = 0;
        paint2.setColor(-65536);
        paint2.setTextSize(1111490560);
        int i2 = 0;
        $this$drawDebugOverlay.drawCircle(i2, i2, i, paint);
        $this$drawDebugOverlay.drawCircle((float)width, i2, i, paint);
        $this$drawDebugOverlay.drawCircle((float)width2, (float)height2, i, paint);
        $this$drawDebugOverlay.drawCircle(i2, (float)height, i, paint);
        int i8 = 1073741824;
        $this$drawDebugOverlay.drawText(String.valueOf(this.requestCount), f4 /= i8, f6 /= i8, paint);
        this.requestCount = requestCount2++;
    }

    private final Object onScrollCaptureImageRequest(ScrollCaptureSession scrollCaptureSession, IntRect intRect2, Continuation<? super IntRect> continuation3) {
        boolean anon;
        Object captureArea;
        int i;
        int i3;
        Object session;
        Object targetMin;
        Object targetMax;
        Object scrollRangeIntoView;
        int i2;
        Object obj;
        int i4;
        int obj12;
        int obj13;
        Object obj14;
        anon = continuation3;
        i3 = Integer.MIN_VALUE;
        if (continuation3 instanceof ComposeScrollCaptureCallback.onScrollCaptureImageRequest.2 && label &= i3 != 0) {
            anon = continuation3;
            i3 = Integer.MIN_VALUE;
            if (label &= i3 != 0) {
                anon.label = obj14 -= i3;
            } else {
                anon = new ComposeScrollCaptureCallback.onScrollCaptureImageRequest.2(this, continuation3);
            }
        } else {
        }
        obj14 = anon;
        Object result = obj14.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(result);
                androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback composeScrollCaptureCallback = this;
                int top = intRect2.getTop();
                int bottom = intRect2.getBottom();
                obj14.L$0 = composeScrollCaptureCallback;
                obj14.L$1 = scrollCaptureSession;
                obj14.L$2 = intRect2;
                obj14.I$0 = top;
                obj14.I$1 = bottom;
                obj14.label = 1;
                return cOROUTINE_SUSPENDED;
                targetMin = scrollCaptureSession;
                obj12 = bottom;
                targetMax = composeScrollCaptureCallback;
                session = intRect2;
                obj13 = i4;
                break;
            case 1:
                obj12 = obj14.I$1;
                obj13 = obj14.I$0;
                session = obj14.L$2;
                targetMin = obj14.L$1;
                targetMax = obj14.L$0;
                ResultKt.throwOnFailure(result);
                break;
            case 2:
                obj12 = obj14.I$1;
                obj13 = obj14.I$0;
                ResultKt.throwOnFailure(result);
                obj = l$1;
                session = l$2;
                captureArea = targetMin;
                int mapOffsetToViewport = captureArea.scrollTracker.mapOffsetToViewport(obj13);
                int mapOffsetToViewport2 = captureArea.scrollTracker.mapOffsetToViewport(obj12);
                obj12 = IntRect.copy$default(session, 0, mapOffsetToViewport, 0, mapOffsetToViewport2, 5, 0);
                return IntRect.Companion.getZero();
                obj13 = captureArea.node.findCoordinatorToGetBounds$ui_release();
                Canvas lockHardwareCanvas = obj.getSurface().lockHardwareCanvas();
                int i6 = 0;
                lockHardwareCanvas.drawColor(i6, BlendMode.CLEAR);
                Canvas canvas = AndroidCanvas_androidKt.Canvas(lockHardwareCanvas);
                canvas.translate(-f, -f2);
                obj13.draw(canvas, 0);
                obj.getSurface().unlockCanvasAndPost(lockHardwareCanvas);
                return obj12.translate(i6, MathKt.roundToInt(captureArea.scrollTracker.getScrollAmount()));
                obj12 = 0;
                obj12 = new IllegalStateException("Could not find coordinator for semantics node.".toString());
                throw obj12;
            default:
                obj12 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj12;
        }
        obj14.L$0 = targetMax;
        obj14.L$1 = targetMin;
        obj14.L$2 = session;
        obj14.I$0 = obj13;
        obj14.I$1 = obj12;
        obj14.label = 2;
        if (MonotonicFrameClockKt.withFrameNanos((Function1)ComposeScrollCaptureCallback.onScrollCaptureImageRequest.3.INSTANCE, obj14) == cOROUTINE_SUSPENDED) {
            return cOROUTINE_SUSPENDED;
        }
        obj = targetMin;
        captureArea = targetMax;
    }

    @Override // android.view.ScrollCaptureCallback
    public void onScrollCaptureEnd(Runnable onReady) {
        ComposeScrollCaptureCallback.onScrollCaptureEnd.1 anon = new ComposeScrollCaptureCallback.onScrollCaptureEnd.1(this, onReady, 0);
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext)NonCancellable.INSTANCE, 0, (Function2)anon, 2, 0);
    }

    public void onScrollCaptureImageRequest(ScrollCaptureSession session, CancellationSignal signal, Rect captureArea, Consumer<Rect> onComplete) {
        ComposeScrollCaptureCallback.onScrollCaptureImageRequest.1 anon = new ComposeScrollCaptureCallback.onScrollCaptureImageRequest.1(this, session, captureArea, onComplete, 0);
        ComposeScrollCaptureCallback_androidKt.access$launchWithCancellationSignal(this.coroutineScope, signal, (Function2)anon);
    }

    public void onScrollCaptureSearch(CancellationSignal signal, Consumer<Rect> onReady) {
        onReady.accept(RectHelper_androidKt.toAndroidRect(this.viewportBoundsInWindow));
    }

    @Override // android.view.ScrollCaptureCallback
    public void onScrollCaptureStart(ScrollCaptureSession session, CancellationSignal signal, Runnable onReady) {
        this.scrollTracker.reset();
        this.requestCount = 0;
        this.listener.onSessionStarted();
        onReady.run();
    }
}
