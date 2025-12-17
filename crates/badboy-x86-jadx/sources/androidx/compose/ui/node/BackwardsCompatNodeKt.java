package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0001\u001a\u000c\u0010\u0008\u001a\u00020\t*\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"DetachedModifierLocalReadScope", "androidx/compose/ui/node/BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1", "Landroidx/compose/ui/node/BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1;", "onDrawCacheReadsChanged", "Lkotlin/Function1;", "Landroidx/compose/ui/node/BackwardsCompatNode;", "", "updateModifierLocalConsumer", "isChainUpdate", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BackwardsCompatNodeKt {

    private static final androidx.compose.ui.node.BackwardsCompatNodeKt.DetachedModifierLocalReadScope.1 DetachedModifierLocalReadScope;
    private static final Function1<androidx.compose.ui.node.BackwardsCompatNode, Unit> onDrawCacheReadsChanged;
    private static final Function1<androidx.compose.ui.node.BackwardsCompatNode, Unit> updateModifierLocalConsumer;
    static {
        BackwardsCompatNodeKt.DetachedModifierLocalReadScope.1 anon = new BackwardsCompatNodeKt.DetachedModifierLocalReadScope.1();
        BackwardsCompatNodeKt.DetachedModifierLocalReadScope = anon;
        BackwardsCompatNodeKt.onDrawCacheReadsChanged = (Function1)BackwardsCompatNodeKt.onDrawCacheReadsChanged.1.INSTANCE;
        BackwardsCompatNodeKt.updateModifierLocalConsumer = (Function1)BackwardsCompatNodeKt.updateModifierLocalConsumer.1.INSTANCE;
    }

    public static final androidx.compose.ui.node.BackwardsCompatNodeKt.DetachedModifierLocalReadScope.1 access$getDetachedModifierLocalReadScope$p() {
        return BackwardsCompatNodeKt.DetachedModifierLocalReadScope;
    }

    public static final Function1 access$getOnDrawCacheReadsChanged$p() {
        return BackwardsCompatNodeKt.onDrawCacheReadsChanged;
    }

    public static final Function1 access$getUpdateModifierLocalConsumer$p() {
        return BackwardsCompatNodeKt.updateModifierLocalConsumer;
    }

    public static final boolean access$isChainUpdate(androidx.compose.ui.node.BackwardsCompatNode $receiver) {
        return BackwardsCompatNodeKt.isChainUpdate($receiver);
    }

    private static final boolean isChainUpdate(androidx.compose.ui.node.BackwardsCompatNode $this$isChainUpdate) {
        androidx.compose.ui.Modifier.Node tail$ui_release = DelegatableNodeKt.requireLayoutNode((DelegatableNode)$this$isChainUpdate).getNodes$ui_release().getTail$ui_release();
        Intrinsics.checkNotNull(tail$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.TailModifierNode");
        return (TailModifierNode)tail$ui_release.getAttachHasBeenRun();
    }
}
