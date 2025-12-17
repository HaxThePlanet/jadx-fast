package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction.Enter;
import androidx.compose.foundation.interaction.HoverInteraction.Exit;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerEventType.Companion;
import androidx.compose.ui.node.PointerInputModifierNode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0008\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\nJ\u0008\u0010\u000c\u001a\u00020\tH\u0016J\u0008\u0010\r\u001a\u00020\tH\u0016J*\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0008\u0010\u0017\u001a\u00020\tH\u0002J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0019", d2 = {"Landroidx/compose/foundation/HoverableNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "hoverInteraction", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "emitEnter", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitExit", "onCancelPointerInput", "onDetach", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "tryEmitExit", "updateInteractionSource", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class HoverableNode extends Modifier.Node implements PointerInputModifierNode {

    private HoverInteraction.Enter hoverInteraction;
    private MutableInteractionSource interactionSource;
    public HoverableNode(MutableInteractionSource interactionSource) {
        super();
        this.interactionSource = interactionSource;
    }

    public static final Object access$emitEnter(androidx.compose.foundation.HoverableNode $this, Continuation $completion) {
        return $this.emitEnter($completion);
    }

    public static final Object access$emitExit(androidx.compose.foundation.HoverableNode $this, Continuation $completion) {
        return $this.emitExit($completion);
    }

    private final Object emitEnter(Continuation<? super Unit> continuation) {
        boolean anon;
        int i3;
        Object cOROUTINE_SUSPENDED;
        int i;
        Object l$0;
        HoverInteraction.Enter hoverInteraction;
        Object emit;
        HoverInteraction.Enter enter;
        int i2;
        Object obj8;
        anon = continuation;
        i = Integer.MIN_VALUE;
        if (continuation instanceof HoverableNode.emitEnter.1 && label &= i != 0) {
            anon = continuation;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj8 -= i;
            } else {
                anon = new HoverableNode.emitEnter.1(this, continuation);
            }
        } else {
        }
        obj8 = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj8);
                l$0 = this;
                hoverInteraction = new HoverInteraction.Enter();
                anon.L$0 = l$0;
                anon.L$1 = hoverInteraction;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                cOROUTINE_SUSPENDED = hoverInteraction;
                return Unit.INSTANCE;
            case 1:
                cOROUTINE_SUSPENDED = anon.L$1;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj8);
                break;
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        l$0.hoverInteraction = cOROUTINE_SUSPENDED;
    }

    private final Object emitExit(Continuation<? super Unit> continuation) {
        boolean anon;
        int i4;
        int cOROUTINE_SUSPENDED;
        int i;
        Object l$0;
        Object emit;
        HoverInteraction.Enter hoverInteraction;
        int i3;
        HoverInteraction.Exit exit2;
        HoverInteraction.Exit exit;
        int i2;
        Object obj9;
        anon = continuation;
        i = Integer.MIN_VALUE;
        if (continuation instanceof HoverableNode.emitExit.1 && label &= i != 0) {
            anon = continuation;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj9 -= i;
            } else {
                anon = new HoverableNode.emitExit.1(this, continuation);
            }
        } else {
        }
        obj9 = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj9);
                l$0 = this;
                hoverInteraction = l$0.hoverInteraction;
                exit2 = new HoverInteraction.Exit(hoverInteraction);
                anon.L$0 = l$0;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                cOROUTINE_SUSPENDED = i3;
                return Unit.INSTANCE;
            case 1:
                cOROUTINE_SUSPENDED = 0;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj9);
                break;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        l$0.hoverInteraction = 0;
    }

    private final void tryEmitExit() {
        int i;
        HoverInteraction.Exit exit2;
        int i2;
        HoverInteraction.Exit exit;
        final HoverInteraction.Enter hoverInteraction = this.hoverInteraction;
        if (hoverInteraction != null) {
            i = 0;
            exit2 = new HoverInteraction.Exit(hoverInteraction);
            this.interactionSource.tryEmit((Interaction)exit2);
            this.hoverInteraction = 0;
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onCancelPointerInput() {
        tryEmitExit();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        tryEmitExit();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onPointerEvent-H0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        PointerEventPass main;
        int exit-7fucELk;
        int i4;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i;
        int i3;
        kotlin.coroutines.jvm.internal.SuspendLambda anon;
        int i5;
        int i2;
        if (pass == PointerEventPass.Main) {
            int type-7fucELk = pointerEvent.getType-7fucELk();
            i4 = 0;
            if (PointerEventType.equals-impl0(type-7fucELk, PointerEventType.Companion.getEnter-7fucELk())) {
                main = new HoverableNode.onPointerEvent.1(this, i4);
                BuildersKt.launch$default(getCoroutineScope(), 0, 0, (Function2)main, 3, 0);
            } else {
                if (PointerEventType.equals-impl0(type-7fucELk, PointerEventType.Companion.getExit-7fucELk())) {
                    main = new HoverableNode.onPointerEvent.2(this, i4);
                    BuildersKt.launch$default(getCoroutineScope(), 0, 0, (Function2)main, 3, 0);
                }
            }
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void updateInteractionSource(MutableInteractionSource interactionSource) {
        if (!Intrinsics.areEqual(this.interactionSource, interactionSource)) {
            tryEmitExit();
            this.interactionSource = interactionSource;
        }
    }
}
