package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.DragInteraction.Cancel;
import androidx.compose.foundation.interaction.DragInteraction.Start;
import androidx.compose.foundation.interaction.DragInteraction.Stop;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.Velocity.Companion;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.channels.Channel;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008 \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B5\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0007\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c¢\u0006\u0002\u0010\rJ\u0006\u0010\u001e\u001a\u00020\u001fJM\u0010 \u001a\u00020\u001f2=\u0010!\u001a9\u0008\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110#¢\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(&\u0012\u0004\u0012\u00020\u001f0\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001f0'\u0012\u0006\u0012\u0004\u0018\u00010(0\"H¦@¢\u0006\u0002\u0010)J\u0008\u0010*\u001a\u00020\u001dH\u0002J\u0008\u0010+\u001a\u00020\u001fH\u0016J\u0008\u0010,\u001a\u00020\u001fH\u0016J\u001a\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/H&ø\u0001\u0000¢\u0006\u0004\u00080\u00101J\u001a\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u000204H&ø\u0001\u0000¢\u0006\u0004\u00085\u00101J*\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016ø\u0001\u0000¢\u0006\u0004\u0008=\u0010>J\u000e\u0010?\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010@J\u0016\u0010A\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020CH\u0082@¢\u0006\u0002\u0010DJ\u0016\u0010E\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020FH\u0082@¢\u0006\u0002\u0010GJ\u0008\u0010H\u001a\u00020\u0007H&J\u0008\u0010I\u001a\u00020\u001fH\u0002JH\u0010J\u001a\u00020\u001f2\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00072\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0008\u0008\u0002\u0010K\u001a\u00020\u0007R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005@BX\u0084\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007@BX\u0084\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\"\u0010\t\u001a\u0004\u0018\u00010\n2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\n@BX\u0084\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006L", d2 = {"Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "orientationLock", "Landroidx/compose/foundation/gestures/Orientation;", "(Lkotlin/jvm/functions/Function1;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/Orientation;)V", "_canDrag", "<set-?>", "getCanDrag", "()Lkotlin/jvm/functions/Function1;", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/DragEvent;", "dragInteraction", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "getEnabled", "()Z", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isListeningForEvents", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "disposeInteractionSource", "", "drag", "forEachDelta", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializePointerInputNode", "onCancelPointerInput", "onDetach", "onDragStarted", "startedPosition", "Landroidx/compose/ui/geometry/Offset;", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-TH1AsA0", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "processDragCancel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStart", "event", "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "(Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStop", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "(Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startDragImmediately", "startListeningForEvents", "update", "shouldResetPointerInputHandling", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class DragGestureNode extends DelegatingNode implements PointerInputModifierNode, CompositionLocalConsumerModifierNode {

    public static final int $stable = 8;
    private final Function1<PointerInputChange, Boolean> _canDrag;
    private Function1<? super PointerInputChange, Boolean> canDrag;
    private Channel<androidx.compose.foundation.gestures.DragEvent> channel;
    private DragInteraction.Start dragInteraction;
    private boolean enabled;
    private MutableInteractionSource interactionSource;
    private boolean isListeningForEvents;
    private androidx.compose.foundation.gestures.Orientation orientationLock;
    private SuspendingPointerInputModifierNode pointerInputNode;
    static {
        final int i = 8;
    }

    public DragGestureNode(Function1<? super PointerInputChange, Boolean> canDrag, boolean enabled, MutableInteractionSource interactionSource, androidx.compose.foundation.gestures.Orientation orientationLock) {
        super();
        this.orientationLock = orientationLock;
        this.canDrag = canDrag;
        this.enabled = enabled;
        this.interactionSource = interactionSource;
        DragGestureNode._canDrag.1 anon = new DragGestureNode._canDrag.1(this);
        this._canDrag = (Function1)anon;
    }

    public static final Channel access$getChannel$p(androidx.compose.foundation.gestures.DragGestureNode $this) {
        return $this.channel;
    }

    public static final androidx.compose.foundation.gestures.Orientation access$getOrientationLock$p(androidx.compose.foundation.gestures.DragGestureNode $this) {
        return $this.orientationLock;
    }

    public static final boolean access$isListeningForEvents$p(androidx.compose.foundation.gestures.DragGestureNode $this) {
        return $this.isListeningForEvents;
    }

    public static final Object access$processDragCancel(androidx.compose.foundation.gestures.DragGestureNode $this, Continuation $completion) {
        return $this.processDragCancel($completion);
    }

    public static final Object access$processDragStart(androidx.compose.foundation.gestures.DragGestureNode $this, androidx.compose.foundation.gestures.DragEvent.DragStarted event, Continuation $completion) {
        return $this.processDragStart(event, $completion);
    }

    public static final Object access$processDragStop(androidx.compose.foundation.gestures.DragGestureNode $this, androidx.compose.foundation.gestures.DragEvent.DragStopped event, Continuation $completion) {
        return $this.processDragStop(event, $completion);
    }

    public static final void access$setChannel$p(androidx.compose.foundation.gestures.DragGestureNode $this, Channel <set-?>) {
        $this.channel = <set-?>;
    }

    public static final void access$startListeningForEvents(androidx.compose.foundation.gestures.DragGestureNode $this) {
        $this.startListeningForEvents();
    }

    private final SuspendingPointerInputModifierNode initializePointerInputNode() {
        DragGestureNode.initializePointerInputNode.1 anon = new DragGestureNode.initializePointerInputNode.1(this, 0);
        return SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode((Function2)anon);
    }

    private final Object processDragCancel(Continuation<? super Unit> continuation) {
        boolean anon;
        int i;
        Object $i$a$LetDragGestureNode$processDragCancel$2;
        int i3;
        Object l$0;
        Object interaction;
        int $i$a$LetDragGestureNode$processDragCancel$22;
        MutableInteractionSource interactionSource;
        DragInteraction.Cancel cancel;
        int i2;
        Object obj9;
        anon = continuation;
        i3 = Integer.MIN_VALUE;
        if (continuation instanceof DragGestureNode.processDragCancel.1 && label &= i3 != 0) {
            anon = continuation;
            i3 = Integer.MIN_VALUE;
            if (label &= i3 != 0) {
                anon.label = obj9 -= i3;
            } else {
                anon = new DragGestureNode.processDragCancel.1(this, continuation);
            }
        } else {
        }
        obj9 = anon.result;
        $i$a$LetDragGestureNode$processDragCancel$2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj9);
                l$0 = this;
                interaction = l$0.dragInteraction;
                interactionSource = l$0.interactionSource;
                cancel = new DragInteraction.Cancel(interaction);
                anon.L$0 = l$0;
                anon.label = 1;
                return $i$a$LetDragGestureNode$processDragCancel$2;
                $i$a$LetDragGestureNode$processDragCancel$2 = $i$a$LetDragGestureNode$processDragCancel$22;
                l$0.dragInteraction = 0;
                l$0.onDragStopped-TH1AsA0(Velocity.Companion.getZero-9UxMQ8M());
                return Unit.INSTANCE;
            case 1:
                $i$a$LetDragGestureNode$processDragCancel$2 = 0;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj9);
                break;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        $i$a$LetDragGestureNode$processDragCancel$22 = $i$a$LetDragGestureNode$processDragCancel$2;
    }

    private final Object processDragStart(androidx.compose.foundation.gestures.DragEvent.DragStarted dragEvent$DragStarted, Continuation<? super Unit> continuation2) {
        boolean anon;
        int i2;
        Object cOROUTINE_SUSPENDED;
        int i;
        Object _this2;
        Object event;
        Object _this;
        int interactionSource2;
        MutableInteractionSource interactionSource;
        DragInteraction.Cancel cancel;
        int i3;
        int obj9;
        Object obj10;
        anon = continuation2;
        i = Integer.MIN_VALUE;
        if (continuation2 instanceof DragGestureNode.processDragStart.1 && label &= i != 0) {
            anon = continuation2;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj10 -= i;
            } else {
                anon = new DragGestureNode.processDragStart.1(this, continuation2);
            }
        } else {
        }
        obj10 = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj10);
                _this = this;
                obj9 = _this.dragInteraction;
                interactionSource = _this.interactionSource;
                cancel = new DragInteraction.Cancel(obj9);
                anon.L$0 = _this;
                anon.L$1 = dragStarted;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj9 = interactionSource2;
                obj9 = new DragInteraction.Start();
                interactionSource2 = _this.interactionSource;
                anon.L$0 = _this;
                anon.L$1 = _this2;
                anon.L$2 = obj9;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                cOROUTINE_SUSPENDED = _this2;
                event = _this;
                _this = event;
                _this2 = cOROUTINE_SUSPENDED;
                _this.dragInteraction = obj9;
                _this.onDragStarted-k-4lQ0M(_this2.getStartPoint-F1C5BW0());
                return Unit.INSTANCE;
            case 1:
                obj9 = 0;
                _this2 = anon.L$1;
                _this = anon.L$0;
                ResultKt.throwOnFailure(obj10);
                break;
            case 2:
                obj9 = anon.L$2;
                cOROUTINE_SUSPENDED = anon.L$1;
                event = anon.L$0;
                ResultKt.throwOnFailure(obj10);
                _this = event;
                _this2 = cOROUTINE_SUSPENDED;
                _this.dragInteraction = obj9;
                _this.onDragStarted-k-4lQ0M(_this2.getStartPoint-F1C5BW0());
                return Unit.INSTANCE;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
    }

    private final Object processDragStop(androidx.compose.foundation.gestures.DragEvent.DragStopped dragEvent$DragStopped, Continuation<? super Unit> continuation2) {
        boolean anon;
        int i;
        Object event;
        int i2;
        Object l$0;
        Object interaction;
        int $i$a$LetDragGestureNode$processDragStop$2;
        MutableInteractionSource interactionSource;
        DragInteraction.Stop stop;
        int i3;
        Object obj9;
        Object obj10;
        anon = continuation2;
        i2 = Integer.MIN_VALUE;
        if (continuation2 instanceof DragGestureNode.processDragStop.1 && label &= i2 != 0) {
            anon = continuation2;
            i2 = Integer.MIN_VALUE;
            if (label &= i2 != 0) {
                anon.label = obj10 -= i2;
            } else {
                anon = new DragGestureNode.processDragStop.1(this, continuation2);
            }
        } else {
        }
        obj10 = anon.result;
        event = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj10);
                l$0 = this;
                interaction = l$0.dragInteraction;
                interactionSource = l$0.interactionSource;
                stop = new DragInteraction.Stop(interaction);
                anon.L$0 = l$0;
                anon.L$1 = dragStopped;
                anon.label = 1;
                return event;
                event = dragStopped;
                obj9 = $i$a$LetDragGestureNode$processDragStop$2;
                l$0.dragInteraction = 0;
                l$0.onDragStopped-TH1AsA0(obj9.getVelocity-9UxMQ8M());
                return Unit.INSTANCE;
            case 1:
                obj9 = 0;
                event = anon.L$1;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj10);
                break;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        $i$a$LetDragGestureNode$processDragStop$2 = obj9;
        obj9 = event;
    }

    private final void startListeningForEvents() {
        this.isListeningForEvents = true;
        final int i2 = 0;
        DragGestureNode.startListeningForEvents.1 anon = new DragGestureNode.startListeningForEvents.1(this, i2);
        BuildersKt.launch$default(getCoroutineScope(), i2, 0, (Function2)anon, 3, 0);
    }

    public static void update$default(androidx.compose.foundation.gestures.DragGestureNode dragGestureNode, Function1 function12, boolean z3, MutableInteractionSource mutableInteractionSource4, androidx.compose.foundation.gestures.Orientation orientation5, boolean z6, int i7, Object object8) {
        Function1 obj1;
        boolean obj2;
        MutableInteractionSource obj3;
        androidx.compose.foundation.gestures.Orientation obj4;
        int obj5;
        int obj7;
        if (object8 != null) {
        } else {
            if (i7 & 1 != 0) {
                obj1 = dragGestureNode.canDrag;
            }
            if (i7 & 2 != 0) {
                obj2 = dragGestureNode.enabled;
            }
            if (i7 & 4 != 0) {
                obj3 = dragGestureNode.interactionSource;
            }
            if (i7 & 8 != 0) {
                obj4 = dragGestureNode.orientationLock;
            }
            obj7 = i7 &= 16 != 0 ? obj5 : z6;
            dragGestureNode.update(obj1, obj2, obj3, obj4, obj7);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
        throw obj0;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void disposeInteractionSource() {
        int i2;
        int i;
        DragInteraction.Cancel cancel;
        final DragInteraction.Start dragInteraction = this.dragInteraction;
        i2 = 0;
        MutableInteractionSource interactionSource = this.interactionSource;
        if (dragInteraction != null && interactionSource != null) {
            i2 = 0;
            interactionSource = this.interactionSource;
            if (interactionSource != null) {
                cancel = new DragInteraction.Cancel(dragInteraction);
                interactionSource.tryEmit((Interaction)cancel);
            }
            this.dragInteraction = 0;
        }
    }

    public abstract Object drag(Function2<? super Function1<? super androidx.compose.foundation.gestures.DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation2);

    protected final Function1<PointerInputChange, Boolean> getCanDrag() {
        return this.canDrag;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    protected final boolean getEnabled() {
        return this.enabled;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    protected final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onCancelPointerInput() {
        final SuspendingPointerInputModifierNode pointerInputNode = this.pointerInputNode;
        if (pointerInputNode != null) {
            pointerInputNode.onCancelPointerInput();
        }
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onDetach() {
        this.isListeningForEvents = false;
        disposeInteractionSource();
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public abstract void onDragStarted-k-4lQ0M(long l);

    @Override // androidx.compose.ui.node.DelegatingNode
    public abstract void onDragStopped-TH1AsA0(long l);

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onPointerEvent-H0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        boolean pointerInputNode;
        if (this.enabled && this.pointerInputNode == null) {
            if (this.pointerInputNode == null) {
                this.pointerInputNode = (SuspendingPointerInputModifierNode)delegate((DelegatableNode)initializePointerInputNode());
            }
        }
        SuspendingPointerInputModifierNode pointerInputNode2 = this.pointerInputNode;
        if (pointerInputNode2 != null) {
            pointerInputNode2.onPointerEvent-H0pRuoY(pointerEvent, pass, bounds);
        }
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public abstract boolean startDragImmediately();

    public final void update(Function1<? super PointerInputChange, Boolean> canDrag, boolean enabled, MutableInteractionSource interactionSource, androidx.compose.foundation.gestures.Orientation orientationLock, boolean shouldResetPointerInputHandling) {
        int resetPointerInputHandling;
        boolean it;
        Object pointerInputNode;
        int i;
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode;
        resetPointerInputHandling = shouldResetPointerInputHandling;
        this.canDrag = canDrag;
        this.enabled = enabled;
        disposeInteractionSource();
        SuspendingPointerInputModifierNode pointerInputNode2 = this.pointerInputNode;
        if (this.enabled != enabled && !enabled && pointerInputNode2 != null) {
            this.enabled = enabled;
            if (!enabled) {
                disposeInteractionSource();
                pointerInputNode2 = this.pointerInputNode;
                if (pointerInputNode2 != null) {
                    i = 0;
                    undelegate((DelegatableNode)pointerInputNode2);
                }
                this.pointerInputNode = 0;
            }
            resetPointerInputHandling = 1;
        }
        if (!Intrinsics.areEqual(this.interactionSource, interactionSource)) {
            disposeInteractionSource();
            this.interactionSource = interactionSource;
        }
        if (this.orientationLock != orientationLock) {
            this.orientationLock = orientationLock;
            resetPointerInputHandling = 1;
        }
        pointerInputNode = this.pointerInputNode;
        if (resetPointerInputHandling != 0 && pointerInputNode != null) {
            pointerInputNode = this.pointerInputNode;
            if (pointerInputNode != null) {
                pointerInputNode.resetPointerInputHandler();
            }
        }
    }
}
