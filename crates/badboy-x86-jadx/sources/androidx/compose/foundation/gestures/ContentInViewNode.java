package androidx.compose.foundation.gestures;

import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineStart;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001EB'\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c¢\u0006\u0002\u0010\rJ\u001e\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\"H\u0096@¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0013H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u000b\u001a\u00020\u000cH\u0002J\"\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+J\n\u0010,\u001a\u0004\u0018\u00010\u0013H\u0002J\n\u0010-\u001a\u0004\u0018\u00010\u0013H\u0002J\u0008\u0010.\u001a\u00020 H\u0002J\u0010\u0010/\u001a\u00020 2\u0008\u00100\u001a\u0004\u0018\u00010\u0011J\u001a\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\u001aH\u0016ø\u0001\u0000¢\u0006\u0004\u00083\u00104J\"\u00105\u001a\u0002062\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\u00087\u00108J\u0008\u00109\u001a\u00020\u000cH\u0002J \u0010:\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cJ\u001f\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020=H\u0082\u0002ø\u0001\u0000¢\u0006\u0004\u0008?\u0010@J\u001f\u0010;\u001a\u00020<*\u00020\u001a2\u0006\u0010>\u001a\u00020\u001aH\u0082\u0002ø\u0001\u0000¢\u0006\u0004\u0008A\u0010@J \u0010B\u001a\u00020\n*\u00020\u00132\u0008\u0008\u0002\u00102\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\u0008C\u0010DR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\nX\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@BX\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\u0008\u001c\u0010\u001d\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006F", d2 = {"Landroidx/compose/foundation/gestures/ContentInViewNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "reverseDirection", "", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "(Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/ScrollingLogic;ZLandroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "bringIntoViewRequests", "Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "focusedChild", "Landroidx/compose/ui/layout/LayoutCoordinates;", "focusedChildBoundsFromPreviousRemeasure", "Landroidx/compose/ui/geometry/Rect;", "isAnimationRunning", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "trackingFocusedChild", "<set-?>", "Landroidx/compose/ui/unit/IntSize;", "viewportSize", "getViewportSize-YbymL2g$foundation_release", "()J", "J", "bringChildIntoView", "", "localRect", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateRectForParent", "calculateScrollDelta", "", "computeDestination", "childBounds", "containerSize", "computeDestination-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/Rect;", "findBringIntoViewRequest", "getFocusedChildBounds", "launchAnimation", "onFocusBoundsChanged", "newBounds", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "relocationOffset", "Landroidx/compose/ui/geometry/Offset;", "relocationOffset-BMxPBkI", "(Landroidx/compose/ui/geometry/Rect;J)J", "requireBringIntoViewSpec", "update", "compareTo", "", "Landroidx/compose/ui/geometry/Size;", "other", "compareTo-iLBOSCw", "(JJ)I", "compareTo-TemP2vQ", "isMaxVisible", "isMaxVisible-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Z", "Request", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContentInViewNode extends Modifier.Node implements BringIntoViewResponder, LayoutAwareModifierNode, CompositionLocalConsumerModifierNode {

    public static final int $stable = 8;
    private final androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue bringIntoViewRequests;
    private androidx.compose.foundation.gestures.BringIntoViewSpec bringIntoViewSpec;
    private LayoutCoordinates focusedChild;
    private Rect focusedChildBoundsFromPreviousRemeasure;
    private boolean isAnimationRunning;
    private androidx.compose.foundation.gestures.Orientation orientation;
    private boolean reverseDirection;
    private final androidx.compose.foundation.gestures.ScrollingLogic scrollingLogic;
    private final boolean shouldAutoInvalidate;
    private boolean trackingFocusedChild;
    private long viewportSize;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B#\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\u0008J\u0008\u0010\r\u001a\u00020\u000eH\u0016R\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u000f", d2 = {"Landroidx/compose/foundation/gestures/ContentInViewNode$Request;", "", "currentBounds", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CancellableContinuation;)V", "getContinuation", "()Lkotlinx/coroutines/CancellableContinuation;", "getCurrentBounds", "()Lkotlin/jvm/functions/Function0;", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Request {

        public static final int $stable = 8;
        private final CancellableContinuation<Unit> continuation;
        private final Function0<Rect> currentBounds;
        static {
            final int i = 8;
        }

        public Request(Function0<Rect> currentBounds, CancellableContinuation<? super Unit> continuation) {
            super();
            this.currentBounds = currentBounds;
            this.continuation = continuation;
        }

        public final CancellableContinuation<Unit> getContinuation() {
            return this.continuation;
        }

        public final Function0<Rect> getCurrentBounds() {
            return this.currentBounds;
        }

        public String toString() {
            String name;
            String it;
            String str;
            StringBuilder append;
            String str2;
            kotlin.coroutines.CoroutineContext.Element context2 = this.continuation.getContext().get((CoroutineContext.Key)CoroutineName.Key);
            if ((CoroutineName)context2 != null) {
                name = (CoroutineName)context2.getName();
            } else {
                name = 0;
            }
            StringBuilder stringBuilder = new StringBuilder();
            it = Integer.toString(hashCode(), CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(it, "toString(this, checkRadix(radix))");
            if (name != null) {
                str = 0;
                StringBuilder stringBuilder2 = new StringBuilder();
                if (stringBuilder2.append('[').append(name).append("](").toString() == null) {
                    it = "(";
                }
            } else {
            }
            return stringBuilder.append("Request@").append(it).append(it).append("currentBounds()=").append(this.currentBounds.invoke()).append(", continuation=").append(this.continuation).append(')').toString();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal2;
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[Orientation.Vertical.ordinal()] = 1;
            iArr[Orientation.Horizontal.ordinal()] = 2;
            ContentInViewNode.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        final int i = 8;
    }

    public ContentInViewNode(androidx.compose.foundation.gestures.Orientation orientation, androidx.compose.foundation.gestures.ScrollingLogic scrollingLogic, boolean reverseDirection, androidx.compose.foundation.gestures.BringIntoViewSpec bringIntoViewSpec) {
        super();
        this.orientation = orientation;
        this.scrollingLogic = scrollingLogic;
        this.reverseDirection = reverseDirection;
        this.bringIntoViewSpec = bringIntoViewSpec;
        BringIntoViewRequestPriorityQueue bringIntoViewRequestPriorityQueue = new BringIntoViewRequestPriorityQueue();
        this.bringIntoViewRequests = bringIntoViewRequestPriorityQueue;
        this.viewportSize = IntSize.Companion.getZero-YbymL2g();
    }

    public static final float access$calculateScrollDelta(androidx.compose.foundation.gestures.ContentInViewNode $this, androidx.compose.foundation.gestures.BringIntoViewSpec bringIntoViewSpec) {
        return $this.calculateScrollDelta(bringIntoViewSpec);
    }

    public static final androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue access$getBringIntoViewRequests$p(androidx.compose.foundation.gestures.ContentInViewNode $this) {
        return $this.bringIntoViewRequests;
    }

    public static final Rect access$getFocusedChildBounds(androidx.compose.foundation.gestures.ContentInViewNode $this) {
        return $this.getFocusedChildBounds();
    }

    public static final boolean access$getReverseDirection$p(androidx.compose.foundation.gestures.ContentInViewNode $this) {
        return $this.reverseDirection;
    }

    public static final androidx.compose.foundation.gestures.ScrollingLogic access$getScrollingLogic$p(androidx.compose.foundation.gestures.ContentInViewNode $this) {
        return $this.scrollingLogic;
    }

    public static final boolean access$getTrackingFocusedChild$p(androidx.compose.foundation.gestures.ContentInViewNode $this) {
        return $this.trackingFocusedChild;
    }

    public static final boolean access$isAnimationRunning$p(androidx.compose.foundation.gestures.ContentInViewNode $this) {
        return $this.isAnimationRunning;
    }

    public static final void access$launchAnimation(androidx.compose.foundation.gestures.ContentInViewNode $this) {
        $this.launchAnimation();
    }

    public static final void access$setAnimationRunning$p(androidx.compose.foundation.gestures.ContentInViewNode $this, boolean <set-?>) {
        $this.isAnimationRunning = <set-?>;
    }

    public static final void access$setTrackingFocusedChild$p(androidx.compose.foundation.gestures.ContentInViewNode $this, boolean <set-?>) {
        $this.trackingFocusedChild = <set-?>;
    }

    private final float calculateScrollDelta(androidx.compose.foundation.gestures.BringIntoViewSpec bringIntoViewSpec) {
        int bringIntoViewRequest;
        float scrollDistance;
        int i;
        float height-impl;
        long zero-YbymL2g = IntSize.Companion.getZero-YbymL2g();
        int i2 = 0;
        if (IntSize.equals-impl0(this.viewportSize, obj1)) {
            return i2;
        }
        if (findBringIntoViewRequest() == null) {
            if (this.trackingFocusedChild) {
                bringIntoViewRequest = getFocusedChildBounds();
            } else {
                bringIntoViewRequest = 0;
            }
            if (bringIntoViewRequest == null) {
                return i2;
            }
        }
        long size-ozmzZPI = IntSizeKt.toSize-ozmzZPI(this.viewportSize);
        switch (i3) {
            case 1:
                scrollDistance = bringIntoViewSpec.calculateScrollDistance(bringIntoViewRequest.getTop(), bottom -= top2, Size.getHeight-impl(size-ozmzZPI));
                break;
            case 2:
                scrollDistance = bringIntoViewSpec.calculateScrollDistance(bringIntoViewRequest.getLeft(), right -= left2, Size.getWidth-impl(size-ozmzZPI));
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return scrollDistance;
    }

    private final int compareTo-TemP2vQ(long $this$compareTo_u2dTemP2vQ, long other) {
        int compare;
        int height-impl;
        switch (i2) {
            case 1:
                compare = Intrinsics.compare(IntSize.getHeight-impl($this$compareTo_u2dTemP2vQ), IntSize.getHeight-impl(obj5));
                break;
            case 2:
                compare = Intrinsics.compare(IntSize.getWidth-impl($this$compareTo_u2dTemP2vQ), IntSize.getWidth-impl(obj5));
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return compare;
    }

    private final int compareTo-iLBOSCw(long $this$compareTo_u2diLBOSCw, long other) {
        int compare;
        float height-impl;
        switch (i2) {
            case 1:
                compare = Float.compare(Size.getHeight-impl($this$compareTo_u2diLBOSCw), Size.getHeight-impl(obj5));
                break;
            case 2:
                compare = Float.compare(Size.getWidth-impl($this$compareTo_u2diLBOSCw), Size.getWidth-impl(obj5));
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return compare;
    }

    private final Rect computeDestination-O0kMr_c(Rect childBounds, long containerSize) {
        return childBounds.translate-k-4lQ0M(Offset.unaryMinus-F1C5BW0(relocationOffset-BMxPBkI(childBounds, containerSize)));
    }

    private final Rect findBringIntoViewRequest() {
        int i2;
        Object obj;
        androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue bringIntoViewRequests;
        int i$iv$iv;
        Object[] content;
        Object obj2;
        int i;
        Object invoke;
        int i3;
        long size-NH-jbRc;
        androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue this_$iv;
        int rectangleToMakeVisible;
        final Object obj3 = this;
        i2 = 0;
        bringIntoViewRequests = obj3.bringIntoViewRequests;
        final int i4 = 0;
        final MutableVector mutableVector = BringIntoViewRequestPriorityQueue.access$getRequests$p(bringIntoViewRequests);
        final int i5 = 0;
        final int size = mutableVector.getSize();
        if (size > 0) {
            i$iv$iv = size + -1;
            i = 0;
            invoke = (ContentInViewNode.Request)mutableVector.getContent()[i$iv$iv].getCurrentBounds().invoke();
            i3 = 0;
            while ((Rect)invoke != null) {
                rectangleToMakeVisible = i2;
                this_$iv = bringIntoViewRequests;
                i2 = invoke;
                bringIntoViewRequests = this_$iv;
                i = 0;
                invoke = (ContentInViewNode.Request)content[i$iv$iv].getCurrentBounds().invoke();
                i3 = 0;
                rectangleToMakeVisible = i2;
                this_$iv = bringIntoViewRequests;
            }
            obj = rectangleToMakeVisible == 0 ? invoke : rectangleToMakeVisible;
            return obj;
        }
        this_$iv = bringIntoViewRequests;
        return i2;
    }

    private final Rect getFocusedChildBounds() {
        int focusedChild;
        boolean it;
        int i;
        int i2 = 0;
        if (!isAttached()) {
            return i2;
        }
        focusedChild = this.focusedChild;
        if (focusedChild != null) {
            i = 0;
            if (focusedChild.isAttached()) {
            } else {
                focusedChild = i2;
            }
            if (focusedChild == 0) {
            }
            return DelegatableNodeKt.requireLayoutCoordinates((DelegatableNode)this).localBoundingBoxOf(focusedChild, false);
        }
        return i2;
    }

    private final boolean isMaxVisible-O0kMr_c(Rect $this$isMaxVisible_u2dO0kMr_c, long size) {
        int cmp;
        int i;
        final long relocationOffset-BMxPBkI = relocationOffset-BMxPBkI($this$isMaxVisible_u2dO0kMr_c, size);
        final int i2 = 1056964608;
        if (Float.compare(f, i2) <= 0 && Float.compare(f2, i2) <= 0) {
            i = Float.compare(f2, i2) <= 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    static boolean isMaxVisible-O0kMr_c$default(androidx.compose.foundation.gestures.ContentInViewNode contentInViewNode, Rect rect2, long l3, int i4, Object object5) {
        long obj2;
        if (object5 &= 1 != 0) {
            obj2 = contentInViewNode.viewportSize;
        }
        return contentInViewNode.isMaxVisible-O0kMr_c(rect2, obj2);
    }

    private final void launchAnimation() {
        final androidx.compose.foundation.gestures.BringIntoViewSpec requireBringIntoViewSpec = requireBringIntoViewSpec();
        if (this.isAnimationRunning) {
        } else {
            UpdatableAnimationState updatableAnimationState = new UpdatableAnimationState(requireBringIntoViewSpec.getScrollAnimationSpec());
            ContentInViewNode.launchAnimation.2 anon = new ContentInViewNode.launchAnimation.2(this, updatableAnimationState, requireBringIntoViewSpec, 0);
            BuildersKt.launch$default(getCoroutineScope(), 0, CoroutineStart.UNDISPATCHED, (Function2)anon, 1, 0);
        }
        int animationState = 0;
        IllegalStateException $i$a$CheckContentInViewNode$launchAnimation$1 = new IllegalStateException("launchAnimation called when previous animation was running".toString());
        throw $i$a$CheckContentInViewNode$launchAnimation$1;
    }

    private final long relocationOffset-BMxPBkI(Rect childBounds, long containerSize) {
        long l;
        float left;
        int i;
        float height-impl;
        final long size-ozmzZPI = IntSizeKt.toSize-ozmzZPI(containerSize);
        int i3 = 0;
        switch (i2) {
            case 1:
                l = OffsetKt.Offset(i3, requireBringIntoViewSpec().calculateScrollDistance(childBounds.getTop(), bottom -= top, Size.getHeight-impl(size-ozmzZPI)));
                break;
            case 2:
                l = OffsetKt.Offset(requireBringIntoViewSpec().calculateScrollDistance(childBounds.getLeft(), right -= left2, Size.getWidth-impl(size-ozmzZPI)), i3);
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return l;
    }

    private final androidx.compose.foundation.gestures.BringIntoViewSpec requireBringIntoViewSpec() {
        Object bringIntoViewSpec;
        androidx.compose.runtime.ProvidableCompositionLocal localBringIntoViewSpec;
        if (this.bringIntoViewSpec == null) {
            bringIntoViewSpec = CompositionLocalConsumerModifierNodeKt.currentValueOf((CompositionLocalConsumerModifierNode)this, (CompositionLocal)BringIntoViewSpec_androidKt.getLocalBringIntoViewSpec());
        }
        return bringIntoViewSpec;
    }

    public Object bringChildIntoView(Function0<Rect> localRect, Continuation<? super Unit> $completion) {
        androidx.compose.foundation.gestures.ContentInViewNode view;
        Object maxVisible-O0kMr_c$default;
        int i2;
        int i4;
        int i;
        int i3;
        boolean enqueue;
        maxVisible-O0kMr_c$default = invoke;
        int i5 = 1;
        i3 = 0;
        if (maxVisible-O0kMr_c$default != null && !ContentInViewNode.isMaxVisible-O0kMr_c$default(this, (Rect)maxVisible-O0kMr_c$default, 0, obj4, 1)) {
            if (!ContentInViewNode.isMaxVisible-O0kMr_c$default(this, maxVisible-O0kMr_c$default, 0, obj4, 1)) {
                i3 = i5;
            }
        }
        if (i3 == 0) {
            return Unit.INSTANCE;
        }
        int i6 = 0;
        int i7 = 0;
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), i5);
        cancellableContinuationImpl2.initCancellability();
        int i8 = 0;
        ContentInViewNode.Request request = new ContentInViewNode.Request(localRect, (CancellableContinuation)cancellableContinuationImpl2);
        if (ContentInViewNode.access$getBringIntoViewRequests$p(this).enqueue(request) && !ContentInViewNode.access$isAnimationRunning$p(this)) {
            if (!ContentInViewNode.access$isAnimationRunning$p(this)) {
                ContentInViewNode.access$launchAnimation(this);
            }
        }
        Object result = cancellableContinuationImpl2.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public Rect calculateRectForParent(Rect localRect) {
        if (IntSize.equals-impl0(this.viewportSize, obj1)) {
        } else {
            return computeDestination-O0kMr_c(localRect, this.viewportSize);
        }
        int i = 0;
        IllegalStateException $i$a$CheckContentInViewNode$calculateRectForParent$1 = new IllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.".toString());
        throw $i$a$CheckContentInViewNode$calculateRectForParent$1;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final long getViewportSize-YbymL2g$foundation_release() {
        return this.viewportSize;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void onFocusBoundsChanged(LayoutCoordinates newBounds) {
        this.focusedChild = newBounds;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onRemeasured-ozmzZPI(long size) {
        int i;
        Rect focusedChildBoundsFromPreviousRemeasure;
        boolean trackingFocusedChild;
        final long viewportSize = this.viewportSize;
        this.viewportSize = size;
        if (compareTo-TemP2vQ(size, obj8) >= 0) {
        }
        Rect focusedChildBounds = getFocusedChildBounds();
        i = 0;
        if (focusedChildBounds != null && this.focusedChildBoundsFromPreviousRemeasure == null) {
            i = 0;
            if (this.focusedChildBoundsFromPreviousRemeasure == null) {
                focusedChildBoundsFromPreviousRemeasure = focusedChildBounds;
            }
            if (!this.isAnimationRunning && !this.trackingFocusedChild && isMaxVisible-O0kMr_c(focusedChildBoundsFromPreviousRemeasure, viewportSize) && !isMaxVisible-O0kMr_c(focusedChildBounds, size)) {
                if (!this.trackingFocusedChild) {
                    if (isMaxVisible-O0kMr_c(focusedChildBoundsFromPreviousRemeasure, viewportSize)) {
                        if (!isMaxVisible-O0kMr_c(focusedChildBounds, size)) {
                            this.trackingFocusedChild = true;
                            launchAnimation();
                        }
                    }
                }
            }
            this.focusedChildBoundsFromPreviousRemeasure = focusedChildBounds;
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void update(androidx.compose.foundation.gestures.Orientation orientation, boolean reverseDirection, androidx.compose.foundation.gestures.BringIntoViewSpec bringIntoViewSpec) {
        this.orientation = orientation;
        this.reverseDirection = reverseDirection;
        this.bringIntoViewSpec = bringIntoViewSpec;
    }
}
