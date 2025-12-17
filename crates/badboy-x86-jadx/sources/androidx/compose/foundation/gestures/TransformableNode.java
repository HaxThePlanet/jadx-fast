package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ2\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Landroidx/compose/foundation/gestures/TransformableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "lockRotationOnZoomPan", "enabled", "(Landroidx/compose/foundation/gestures/TransformableState;Lkotlin/jvm/functions/Function1;ZZ)V", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "updatedCanPan", "update", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TransformableNode extends DelegatingNode {

    private Function1<? super Offset, Boolean> canPan;
    private final Channel<androidx.compose.foundation.gestures.TransformEvent> channel;
    private boolean enabled;
    private boolean lockRotationOnZoomPan;
    private final SuspendingPointerInputModifierNode pointerInputNode;
    private androidx.compose.foundation.gestures.TransformableState state;
    private final Function1<Offset, Boolean> updatedCanPan;
    public TransformableNode(androidx.compose.foundation.gestures.TransformableState state, Function1<? super Offset, Boolean> canPan, boolean lockRotationOnZoomPan, boolean enabled) {
        super();
        this.state = state;
        this.canPan = canPan;
        this.lockRotationOnZoomPan = lockRotationOnZoomPan;
        this.enabled = enabled;
        TransformableNode.updatedCanPan.1 anon = new TransformableNode.updatedCanPan.1(this);
        this.updatedCanPan = (Function1)anon;
        final int i3 = 0;
        this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, i3, i3, 6, i3);
        TransformableNode.pointerInputNode.1 anon2 = new TransformableNode.pointerInputNode.1(this, i3);
        this.pointerInputNode = (SuspendingPointerInputModifierNode)delegate((DelegatableNode)SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode((Function2)anon2));
    }

    public static final Function1 access$getCanPan$p(androidx.compose.foundation.gestures.TransformableNode $this) {
        return $this.canPan;
    }

    public static final Channel access$getChannel$p(androidx.compose.foundation.gestures.TransformableNode $this) {
        return $this.channel;
    }

    public static final boolean access$getEnabled$p(androidx.compose.foundation.gestures.TransformableNode $this) {
        return $this.enabled;
    }

    public static final boolean access$getLockRotationOnZoomPan$p(androidx.compose.foundation.gestures.TransformableNode $this) {
        return $this.lockRotationOnZoomPan;
    }

    public static final androidx.compose.foundation.gestures.TransformableState access$getState$p(androidx.compose.foundation.gestures.TransformableNode $this) {
        return $this.state;
    }

    public static final Function1 access$getUpdatedCanPan$p(androidx.compose.foundation.gestures.TransformableNode $this) {
        return $this.updatedCanPan;
    }

    public final void update(androidx.compose.foundation.gestures.TransformableState state, Function1<? super Offset, Boolean> canPan, boolean lockRotationOnZoomPan, boolean enabled) {
        int i;
        boolean lockRotationOnZoomPan2;
        SuspendingPointerInputModifierNode pointerInputNode;
        this.canPan = canPan;
        if (Intrinsics.areEqual(this.state, state) && this.enabled == enabled) {
            if (this.enabled == enabled) {
                if (this.lockRotationOnZoomPan != lockRotationOnZoomPan) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        if (i != 0) {
            this.state = state;
            this.enabled = enabled;
            this.lockRotationOnZoomPan = lockRotationOnZoomPan;
            this.pointerInputNode.resetPointerInputHandler();
        }
    }
}
