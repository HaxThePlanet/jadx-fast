package androidx.compose.foundation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainer.PinnedHandle;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u0008\u0010\u000e\u001a\u00020\rH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0006X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0013", d2 = {"Landroidx/compose/foundation/FocusablePinnableContainerNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "()V", "isFocused", "", "pinnedHandle", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "onObservedReadsChanged", "", "onReset", "retrievePinnableContainer", "Landroidx/compose/ui/layout/PinnableContainer;", "setFocus", "focused", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FocusablePinnableContainerNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, ObserverModifierNode {

    private boolean isFocused;
    private PinnableContainer.PinnedHandle pinnedHandle;
    private final boolean shouldAutoInvalidate;
    private final PinnableContainer retrievePinnableContainer() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        FocusablePinnableContainerNode.retrievePinnableContainer.1 anon = new FocusablePinnableContainerNode.retrievePinnableContainer.1(objectRef, this);
        ObserverModifierNodeKt.observeReads((Modifier.Node)this, (Function0)anon);
        return (PinnableContainer)objectRef.element;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onObservedReadsChanged() {
        boolean isFocused;
        final PinnableContainer retrievePinnableContainer = retrievePinnableContainer();
        PinnableContainer.PinnedHandle pinnedHandle = this.pinnedHandle;
        if (this.isFocused && pinnedHandle != null) {
            pinnedHandle = this.pinnedHandle;
            if (pinnedHandle != null) {
                pinnedHandle.release();
            }
            if (retrievePinnableContainer != null) {
                isFocused = retrievePinnableContainer.pin();
            } else {
                isFocused = 0;
            }
            this.pinnedHandle = isFocused;
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onReset() {
        PinnableContainer.PinnedHandle pinnedHandle = this.pinnedHandle;
        if (pinnedHandle != null) {
            pinnedHandle.release();
        }
        this.pinnedHandle = 0;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setFocus(boolean focused) {
        int i;
        Object retrievePinnableContainer;
        if (focused) {
            retrievePinnableContainer = retrievePinnableContainer();
            if (retrievePinnableContainer != null) {
                i = retrievePinnableContainer.pin();
            }
            this.pinnedHandle = i;
        } else {
            retrievePinnableContainer = this.pinnedHandle;
            if (retrievePinnableContainer != null) {
                retrievePinnableContainer.release();
            }
            this.pinnedHandle = 0;
        }
        this.isFocused = focused;
    }
}
