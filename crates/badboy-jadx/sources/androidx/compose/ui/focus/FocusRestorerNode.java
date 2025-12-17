package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.PinnableContainer.PinnedHandle;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\u0008J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0008\u0010\u0018\u001a\u00020\u0015H\u0016R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\nX\u0082\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000c\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0008R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Landroidx/compose/ui/focus/FocusRestorerNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "onRestoreFailed", "Lkotlin/Function0;", "Landroidx/compose/ui/focus/FocusRequester;", "(Lkotlin/jvm/functions/Function0;)V", "onEnter", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "getOnEnter$annotations", "()V", "onExit", "getOnRestoreFailed", "()Lkotlin/jvm/functions/Function0;", "setOnRestoreFailed", "pinnedHandle", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "onDetach", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FocusRestorerNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, androidx.compose.ui.focus.FocusPropertiesModifierNode, androidx.compose.ui.focus.FocusRequesterModifierNode {

    public static final int $stable = 8;
    private final Function1<androidx.compose.ui.focus.FocusDirection, androidx.compose.ui.focus.FocusRequester> onEnter;
    private final Function1<androidx.compose.ui.focus.FocusDirection, androidx.compose.ui.focus.FocusRequester> onExit;
    private Function0<androidx.compose.ui.focus.FocusRequester> onRestoreFailed;
    private PinnableContainer.PinnedHandle pinnedHandle;
    static {
        final int i = 8;
    }

    public FocusRestorerNode(Function0<androidx.compose.ui.focus.FocusRequester> onRestoreFailed) {
        super();
        this.onRestoreFailed = onRestoreFailed;
        FocusRestorerNode.onExit.1 anon = new FocusRestorerNode.onExit.1(this);
        this.onExit = (Function1)anon;
        FocusRestorerNode.onEnter.1 anon2 = new FocusRestorerNode.onEnter.1(this);
        this.onEnter = (Function1)anon2;
    }

    public static final PinnableContainer.PinnedHandle access$getPinnedHandle$p(androidx.compose.ui.focus.FocusRestorerNode $this) {
        return $this.pinnedHandle;
    }

    public static final void access$setPinnedHandle$p(androidx.compose.ui.focus.FocusRestorerNode $this, PinnableContainer.PinnedHandle <set-?>) {
        $this.pinnedHandle = <set-?>;
    }

    private static void getOnEnter$annotations() {
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void applyFocusProperties(androidx.compose.ui.focus.FocusProperties focusProperties) {
        focusProperties.setEnter(this.onEnter);
        focusProperties.setExit(this.onExit);
    }

    public final Function0<androidx.compose.ui.focus.FocusRequester> getOnRestoreFailed() {
        return this.onRestoreFailed;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        PinnableContainer.PinnedHandle pinnedHandle = this.pinnedHandle;
        if (pinnedHandle != null) {
            pinnedHandle.release();
        }
        this.pinnedHandle = 0;
        super.onDetach();
    }

    public final void setOnRestoreFailed(Function0<androidx.compose.ui.focus.FocusRequester> <set-?>) {
        this.onRestoreFailed = <set-?>;
    }
}
