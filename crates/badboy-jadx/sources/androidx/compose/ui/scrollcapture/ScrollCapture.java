package androidx.compose.ui.scrollcapture;

import android.graphics.Point;
import android.view.ScrollCaptureTarget;
import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015H\u0007J\u0008\u0010\u0017\u001a\u00020\rH\u0016J\u0008\u0010\u0018\u001a\u00020\rH\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\t¨\u0006\u0019", d2 = {"Landroidx/compose/ui/scrollcapture/ScrollCapture;", "Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;", "()V", "<set-?>", "", "scrollCaptureInProgress", "getScrollCaptureInProgress", "()Z", "setScrollCaptureInProgress", "(Z)V", "scrollCaptureInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "onScrollCaptureSearch", "", "view", "Landroid/view/View;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "targets", "Ljava/util/function/Consumer;", "Landroid/view/ScrollCaptureTarget;", "onSessionEnded", "onSessionStarted", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScrollCapture implements androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.ScrollCaptureSessionListener {

    public static final int $stable;
    private final MutableState scrollCaptureInProgress$delegate;
    static {
    }

    public ScrollCapture() {
        super();
        final int i2 = 0;
        this.scrollCaptureInProgress$delegate = SnapshotStateKt.mutableStateOf$default(false, i2, 2, i2);
    }

    private final void setScrollCaptureInProgress(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.scrollCaptureInProgress$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    @Override // androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$ScrollCaptureSessionListener
    public final boolean getScrollCaptureInProgress() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.scrollCaptureInProgress$delegate.getValue().booleanValue();
    }

    public final void onScrollCaptureSearch(View view, SemanticsOwner semanticsOwner, CoroutineContext coroutineContext, Consumer<ScrollCaptureTarget> targets) {
        int i;
        int $i$f$get;
        boolean empty;
        int i2;
        int i3 = 0;
        int i6 = 0;
        int i9 = 0;
        MutableVector mutableVector2 = new MutableVector(new ScrollCaptureCandidate[16], i9);
        ScrollCapture.onScrollCaptureSearch.1 anon = new ScrollCapture.onScrollCaptureSearch.1(mutableVector2);
        int i7 = 2;
        ScrollCapture_androidKt.visitScrollCaptureCandidates$default(semanticsOwner.getUnmergedRootSemanticsNode(), i9, (Function1)anon, i7, 0);
        kotlin.jvm.functions.Function1[] arr = new Function1[i7];
        arr[i9] = ScrollCapture.onScrollCaptureSearch.2.INSTANCE;
        i = 1;
        arr[i] = ScrollCapture.onScrollCaptureSearch.3.INSTANCE;
        mutableVector2.sortWith(ComparisonsKt.compareBy(arr));
        MutableVector mutableVector = mutableVector2;
        int i5 = 0;
        if (mutableVector.isEmpty()) {
        } else {
            int i10 = 0;
            int i8 = 0;
            $i$f$get = empty;
        }
        if ((ScrollCaptureCandidate)$i$f$get == 0) {
        }
        ComposeScrollCaptureCallback composeScrollCaptureCallback = new ComposeScrollCaptureCallback((ScrollCaptureCandidate)$i$f$get.getNode(), $i$f$get.getViewportBoundsInWindow(), CoroutineScopeKt.CoroutineScope(coroutineContext), (ComposeScrollCaptureCallback.ScrollCaptureSessionListener)this);
        long l = topLeft-nOcc-ac;
        int i12 = 0;
        Point point = new Point(IntOffset.getX-impl(l), IntOffset.getY-impl(l));
        ScrollCaptureTarget scrollCaptureTarget2 = new ScrollCaptureTarget(view, RectHelper_androidKt.toAndroidRect(IntRectKt.roundToIntRect(LayoutCoordinatesKt.boundsInRoot($i$f$get.getCoordinates()))), point, (ScrollCaptureCallback)composeScrollCaptureCallback);
        int i11 = 0;
        scrollCaptureTarget2.setScrollBounds(RectHelper_androidKt.toAndroidRect($i$f$get.getViewportBoundsInWindow()));
        targets.accept(scrollCaptureTarget2);
    }

    @Override // androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$ScrollCaptureSessionListener
    public void onSessionEnded() {
        setScrollCaptureInProgress(false);
    }

    @Override // androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$ScrollCaptureSessionListener
    public void onSessionStarted() {
        setScrollCaptureInProgress(true);
    }
}
