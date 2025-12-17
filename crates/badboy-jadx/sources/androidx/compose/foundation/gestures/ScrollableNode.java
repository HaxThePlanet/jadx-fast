package androidx.compose.foundation.gestures;

import android.view.KeyEvent;
import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.foundation.FocusedBoundsObserverNode;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusTargetModifierNodeKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.Key.Companion;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEventType.Companion;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerEventType.Companion;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006BM\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0016J\u0008\u00108\u001a\u000205H\u0002JM\u00109\u001a\u0002052=\u0010:\u001a9\u0008\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110<¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008(=\u0012\u0004\u0012\u0002050;\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002050(\u0012\u0006\u0012\u0004\u0018\u00010)0 H\u0096@¢\u0006\u0002\u0010>J\u0008\u0010?\u001a\u000205H\u0016J\u001a\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020'H\u0016ø\u0001\u0000¢\u0006\u0004\u0008B\u0010CJ\u001a\u0010D\u001a\u0002052\u0006\u0010E\u001a\u00020FH\u0016ø\u0001\u0000¢\u0006\u0004\u0008G\u0010CJ\u001a\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020JH\u0016ø\u0001\u0000¢\u0006\u0004\u0008K\u0010LJ\u0008\u0010M\u001a\u000205H\u0016J*\u0010N\u001a\u0002052\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0016ø\u0001\u0000¢\u0006\u0004\u0008U\u0010VJ\u001a\u0010W\u001a\u00020\u00102\u0006\u0010I\u001a\u00020JH\u0016ø\u0001\u0000¢\u0006\u0004\u0008X\u0010LJ\"\u0010Y\u001a\u0002052\u0006\u0010I\u001a\u00020P2\u0006\u0010Z\u001a\u00020TH\u0002ø\u0001\u0000¢\u0006\u0004\u0008[\u0010\\J\u0008\u0010]\u001a\u000205H\u0002J\u0008\u0010^\u001a\u00020\u0010H\u0016JN\u0010_\u001a\u0002052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0008\u0010`\u001a\u000205H\u0002J\u000c\u0010a\u001a\u000205*\u00020bH\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\u001f\u001a4\u0012\u0013\u0012\u00110!¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008($\u0012\u0013\u0012\u00110!¢\u0006\u000c\u0008\"\u0012\u0008\u0008#\u0012\u0004\u0008\u0008(%\u0012\u0004\u0012\u00020\u0010\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010&\u001a \u0008\u0001\u0012\u0004\u0012\u00020'\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020'0(\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\u0010X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u00103\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006c", d2 = {"Landroidx/compose/foundation/gestures/ScrollableNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "contentInViewNode", "Landroidx/compose/foundation/gestures/ContentInViewNode;", "defaultFlingBehavior", "Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "nestedScrollConnection", "Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollByAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "scrollByOffsetAction", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/jvm/functions/Function2;", "scrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "scrollableContainerNode", "Landroidx/compose/foundation/gestures/ScrollableContainerNode;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "clearScrollSemanticsActions", "drag", "forEachDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "dragDelta", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAttach", "onDragStarted", "startedPosition", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-TH1AsA0", "onKeyEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onObservedReadsChanged", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "processMouseWheelEvent", "size", "processMouseWheelEvent-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)V", "setScrollSemanticsActions", "startDragImmediately", "update", "updateDefaultFlingBehavior", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ScrollableNode extends androidx.compose.foundation.gestures.DragGestureNode implements ObserverModifierNode, CompositionLocalConsumerModifierNode, FocusPropertiesModifierNode, KeyInputModifierNode, SemanticsModifierNode {

    private final androidx.compose.foundation.gestures.ContentInViewNode contentInViewNode;
    private final androidx.compose.foundation.gestures.DefaultFlingBehavior defaultFlingBehavior;
    private androidx.compose.foundation.gestures.FlingBehavior flingBehavior;
    private final androidx.compose.foundation.gestures.ScrollableNestedScrollConnection nestedScrollConnection;
    private final NestedScrollDispatcher nestedScrollDispatcher;
    private OverscrollEffect overscrollEffect;
    private Function2<? super Float, ? super Float, Boolean> scrollByAction;
    private Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> scrollByOffsetAction;
    private androidx.compose.foundation.gestures.ScrollConfig scrollConfig;
    private final androidx.compose.foundation.gestures.ScrollableContainerNode scrollableContainerNode;
    private final androidx.compose.foundation.gestures.ScrollingLogic scrollingLogic;
    private final boolean shouldAutoInvalidate;
    public ScrollableNode(androidx.compose.foundation.gestures.ScrollableState state, OverscrollEffect overscrollEffect, androidx.compose.foundation.gestures.FlingBehavior flingBehavior, androidx.compose.foundation.gestures.Orientation orientation, boolean enabled, boolean reverseDirection, MutableInteractionSource interactionSource, androidx.compose.foundation.gestures.BringIntoViewSpec bringIntoViewSpec) {
        androidx.compose.foundation.gestures.FlingBehavior defaultFlingBehavior;
        final boolean z2 = enabled;
        super(ScrollableKt.access$getCanDragCalculation$p(), enabled, interactionSource, orientation);
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        NestedScrollDispatcher nestedScrollDispatcher = new NestedScrollDispatcher();
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        ScrollableContainerNode scrollableContainerNode = new ScrollableContainerNode(enabled);
        this.scrollableContainerNode = (ScrollableContainerNode)delegate((DelegatableNode)scrollableContainerNode);
        int i = 0;
        DefaultFlingBehavior defaultFlingBehavior2 = new DefaultFlingBehavior(SplineBasedDecayKt.splineBasedDecay((Density)ScrollableKt.access$getUnityDensity$p()), i, 2, i);
        this.defaultFlingBehavior = defaultFlingBehavior2;
        if (this.flingBehavior == null) {
            defaultFlingBehavior = this.defaultFlingBehavior;
        }
        ScrollingLogic scrollingLogic = new ScrollingLogic(state, this.overscrollEffect, defaultFlingBehavior, orientation, reverseDirection, this.nestedScrollDispatcher);
        this.scrollingLogic = scrollingLogic;
        ScrollableNestedScrollConnection scrollableNestedScrollConnection = new ScrollableNestedScrollConnection(this.scrollingLogic, enabled);
        this.nestedScrollConnection = scrollableNestedScrollConnection;
        ContentInViewNode contentInViewNode = new ContentInViewNode(orientation, this.scrollingLogic, reverseDirection, bringIntoViewSpec);
        this.contentInViewNode = (ContentInViewNode)delegate((DelegatableNode)contentInViewNode);
        delegate(NestedScrollNodeKt.nestedScrollModifierNode((NestedScrollConnection)this.nestedScrollConnection, this.nestedScrollDispatcher));
        delegate((DelegatableNode)FocusTargetModifierNodeKt.FocusTargetModifierNode());
        BringIntoViewResponderNode bringIntoViewResponderNode = new BringIntoViewResponderNode((BringIntoViewResponder)this.contentInViewNode);
        delegate((DelegatableNode)bringIntoViewResponderNode);
        ScrollableNode.1 anon2 = new ScrollableNode.1(this);
        FocusedBoundsObserverNode focusedBoundsObserverNode = new FocusedBoundsObserverNode((Function1)anon2);
        delegate((DelegatableNode)focusedBoundsObserverNode);
    }

    public static final androidx.compose.foundation.gestures.ContentInViewNode access$getContentInViewNode$p(androidx.compose.foundation.gestures.ScrollableNode $this) {
        return $this.contentInViewNode;
    }

    public static final androidx.compose.foundation.gestures.DefaultFlingBehavior access$getDefaultFlingBehavior$p(androidx.compose.foundation.gestures.ScrollableNode $this) {
        return $this.defaultFlingBehavior;
    }

    public static final androidx.compose.foundation.gestures.ScrollingLogic access$getScrollingLogic$p(androidx.compose.foundation.gestures.ScrollableNode $this) {
        return $this.scrollingLogic;
    }

    private final void clearScrollSemanticsActions() {
        final int i = 0;
        this.scrollByAction = i;
        this.scrollByOffsetAction = i;
    }

    private final void processMouseWheelEvent-O0kMr_c(PointerEvent event, long size) {
        Object scrollConfig;
        int i;
        List mouseWheelScroll-8xgXZGE;
        int index$iv$iv;
        int i3;
        Object index$iv;
        Object size2;
        int i4;
        Object obj;
        int i2;
        boolean consumed;
        i = 0;
        mouseWheelScroll-8xgXZGE = scrollConfig;
        index$iv$iv = 0;
        while (index$iv$iv < mouseWheelScroll-8xgXZGE.size()) {
            i4 = 0;
            i2 = 0;
            index$iv$iv++;
        }
        i3 = 1;
        if (i3 != 0) {
            scrollConfig = this.scrollConfig;
            Intrinsics.checkNotNull(scrollConfig);
            i = 0;
            int i7 = 0;
            ScrollableNode.processMouseWheelEvent.2.1 anon = new ScrollableNode.processMouseWheelEvent.2.1(this, scrollConfig.calculateMouseWheelScroll-8xgXZGE(DelegatableNodeKt.requireDensity((DelegatableNode)this), event, size), 0, i7);
            BuildersKt.launch$default(getCoroutineScope(), 0, i7, (Function2)anon, 3, 0);
            index$iv$iv = event.getChanges();
            i3 = 0;
            index$iv = 0;
            while (index$iv < index$iv$iv.size()) {
                i2 = 0;
                (PointerInputChange)index$iv$iv.get(index$iv).consume();
                index$iv++;
            }
        }
    }

    private final void setScrollSemanticsActions() {
        ScrollableNode.setScrollSemanticsActions.1 anon = new ScrollableNode.setScrollSemanticsActions.1(this);
        this.scrollByAction = (Function2)anon;
        ScrollableNode.setScrollSemanticsActions.2 anon2 = new ScrollableNode.setScrollSemanticsActions.2(this, 0);
        this.scrollByOffsetAction = (Function2)anon2;
    }

    private final void updateDefaultFlingBehavior() {
        ScrollableNode.updateDefaultFlingBehavior.1 anon = new ScrollableNode.updateDefaultFlingBehavior.1(this);
        ObserverModifierNodeKt.observeReads((Modifier.Node)this, (Function0)anon);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        Function2 scrollByOffsetAction;
        int i3;
        int i;
        int i2;
        if (getEnabled()) {
            if (this.scrollByAction != null) {
                if (this.scrollByOffsetAction == null) {
                    setScrollSemanticsActions();
                }
            } else {
            }
        }
        Function2 scrollByAction = this.scrollByAction;
        if (scrollByAction != null) {
            i3 = 0;
            i2 = 0;
            SemanticsPropertiesKt.scrollBy$default($this$applySemantics, i2, scrollByAction, 1, i2);
        }
        Function2 scrollByOffsetAction2 = this.scrollByOffsetAction;
        if (scrollByOffsetAction2 != null) {
            i3 = 0;
            SemanticsPropertiesKt.scrollByOffset($this$applySemantics, scrollByOffsetAction2);
        }
    }

    public Object drag(Function2<? super Function1<? super androidx.compose.foundation.gestures.DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> forEachDelta, Continuation<? super Unit> $completion) {
        androidx.compose.foundation.gestures.ScrollingLogic scrollingLogic = this.scrollingLogic;
        final int i = 0;
        ScrollableNode.drag.2.1 anon = new ScrollableNode.drag.2.1(forEachDelta, scrollingLogic, 0);
        Object scroll = scrollingLogic.scroll(MutatePriority.UserInput, (Function2)anon, $completion);
        if (scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return scroll;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void onAttach() {
        updateDefaultFlingBehavior();
        this.scrollConfig = AndroidScrollable_androidKt.platformScrollConfig((CompositionLocalConsumerModifierNode)this);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void onDragStarted-k-4lQ0M(long startedPosition) {
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void onDragStopped-TH1AsA0(long velocity) {
        final int i = 0;
        ScrollableNode.onDragStopped.1 anon = new ScrollableNode.onDragStopped.1(this, velocity, obj9, i);
        BuildersKt.launch$default(this.nestedScrollDispatcher.getCoroutineScope(), i, 0, (Function2)anon, 3, 0);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public boolean onKeyEvent-ZmokQxo(KeyEvent event) {
        boolean ctrlPressed-ZmokQxo;
        long viewportHeight;
        int scrollAmount;
        long keyDown-CS__XNY;
        long pageDown-EK5gGoQ;
        float f;
        long l;
        long pageUp-EK5gGoQ;
        int i2;
        androidx.compose.foundation.gestures.ScrollableNode.onKeyEvent.1 anon;
        int i3;
        int i;
        if (getEnabled()) {
            if (!Key.equals-impl0(KeyEvent_androidKt.getKey-ZmokQxo(event), obj1)) {
                if (Key.equals-impl0(KeyEvent_androidKt.getKey-ZmokQxo(event), obj1) && KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(event), KeyEventType.Companion.getKeyDown-CS__XNY()) && !KeyEvent_androidKt.isCtrlPressed-ZmokQxo(event)) {
                    if (KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(event), KeyEventType.Companion.getKeyDown-CS__XNY())) {
                        if (!KeyEvent_androidKt.isCtrlPressed-ZmokQxo(event)) {
                            keyDown-CS__XNY = 0;
                            if (this.scrollingLogic.isVertical()) {
                                int height-impl = IntSize.getHeight-impl(this.contentInViewNode.getViewportSize-YbymL2g$foundation_release());
                                f = Key.equals-impl0(KeyEvent_androidKt.getKey-ZmokQxo(event), obj3) ? (float)height-impl : -f2;
                                viewportHeight = OffsetKt.Offset(keyDown-CS__XNY, f);
                            } else {
                                int width-impl = IntSize.getWidth-impl(this.contentInViewNode.getViewportSize-YbymL2g$foundation_release());
                                f = Key.equals-impl0(KeyEvent_androidKt.getKey-ZmokQxo(event), obj3) ? (float)width-impl : -f3;
                                viewportHeight = l;
                            }
                            i2 = 0;
                            ScrollableNode.onKeyEvent.1 anon2 = new ScrollableNode.onKeyEvent.1(this, viewportHeight, keyDown-CS__XNY, i2);
                            BuildersKt.launch$default(getCoroutineScope(), 0, i2, (Function2)anon2, 3, 0);
                            scrollAmount = 1;
                        } else {
                            scrollAmount = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return scrollAmount;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void onObservedReadsChanged() {
        updateDefaultFlingBehavior();
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void onPointerEvent-H0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        PointerEventPass main;
        long l;
        int scroll-7fucELk;
        int index$iv$iv;
        int i;
        Object obj;
        Object obj2;
        int i3;
        boolean it;
        int i2;
        Object invoke;
        scroll-7fucELk = 0;
        final List list = changes;
        final int i4 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list.size()) {
            i3 = 0;
            i2 = 0;
            index$iv$iv++;
        }
        i = 0;
        if (i != 0) {
            super.onPointerEvent-H0pRuoY(pointerEvent, pass, bounds);
        }
        scroll-7fucELk = PointerEventType.Companion.getScroll-7fucELk();
        if (pass == PointerEventPass.Main && PointerEventType.equals-impl0(pointerEvent.getType-7fucELk(), scroll-7fucELk)) {
            scroll-7fucELk = PointerEventType.Companion.getScroll-7fucELk();
            if (PointerEventType.equals-impl0(pointerEvent.getType-7fucELk(), scroll-7fucELk)) {
                processMouseWheelEvent-O0kMr_c(pointerEvent, bounds);
            } else {
                l = bounds;
            }
        } else {
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public boolean onPreKeyEvent-ZmokQxo(KeyEvent event) {
        return 0;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public boolean startDragImmediately() {
        return this.scrollingLogic.shouldScrollImmediately();
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public final void update(androidx.compose.foundation.gestures.ScrollableState state, androidx.compose.foundation.gestures.Orientation orientation, OverscrollEffect overscrollEffect, boolean enabled, boolean reverseDirection, androidx.compose.foundation.gestures.FlingBehavior flingBehavior, MutableInteractionSource interactionSource, androidx.compose.foundation.gestures.BringIntoViewSpec bringIntoViewSpec) {
        int shouldInvalidateSemantics;
        androidx.compose.foundation.gestures.FlingBehavior defaultFlingBehavior;
        androidx.compose.foundation.gestures.Orientation horizontal;
        Object obj;
        boolean scrollableContainerNode;
        int i;
        final boolean z = enabled;
        final androidx.compose.foundation.gestures.FlingBehavior flingBehavior2 = flingBehavior;
        if (getEnabled() != z) {
            this.nestedScrollConnection.setEnabled(z);
            this.scrollableContainerNode.update(z);
            i = shouldInvalidateSemantics;
        } else {
            i = shouldInvalidateSemantics;
        }
        if (flingBehavior2 == null) {
            defaultFlingBehavior = this.defaultFlingBehavior;
        } else {
            defaultFlingBehavior = flingBehavior2;
        }
        final androidx.compose.foundation.gestures.Orientation orientation3 = orientation;
        final OverscrollEffect overscrollEffect2 = overscrollEffect;
        final boolean z2 = reverseDirection;
        this.contentInViewNode.update(orientation3, z2, bringIntoViewSpec);
        this.overscrollEffect = overscrollEffect2;
        this.flingBehavior = flingBehavior2;
        horizontal = this.scrollingLogic.isVertical() ? Orientation.Vertical : Orientation.Horizontal;
        this.update(ScrollableKt.access$getCanDragCalculation$p(), z, interactionSource, horizontal, this.scrollingLogic.update(state, orientation3, overscrollEffect2, z2, defaultFlingBehavior, this.nestedScrollDispatcher));
        if (i != 0) {
            clearScrollSemanticsActions();
            SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)this);
        }
    }
}
