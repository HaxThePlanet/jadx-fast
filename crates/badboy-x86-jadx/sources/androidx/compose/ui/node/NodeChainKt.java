package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.CombinedModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier.Element;
import androidx.compose.ui.Modifier.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00007\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0005\u001a\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000\u001a \u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000c*\u00020\r2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000cH\u0002\u001a$\u0010\u000f\u001a\u00020\u0010\"\u0008\u0008\u0000\u0010\u0011*\u00020\u0012*\u0008\u0012\u0004\u0012\u0002H\u00110\u00132\u0006\u0010\u0014\u001a\u00020\u0012H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0015", d2 = {"ActionReplace", "", "ActionReuse", "ActionUpdate", "SentinelHead", "androidx/compose/ui/node/NodeChainKt$SentinelHead$1", "Landroidx/compose/ui/node/NodeChainKt$SentinelHead$1;", "actionForModifiers", "prev", "Landroidx/compose/ui/Modifier$Element;", "next", "fillVector", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier;", "result", "updateUnsafe", "", "T", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ModifierNodeElement;", "node", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NodeChainKt {

    private static final int ActionReplace = 0;
    private static final int ActionReuse = 2;
    private static final int ActionUpdate = 1;
    private static final androidx.compose.ui.node.NodeChainKt.SentinelHead.1 SentinelHead;
    static {
        NodeChainKt.SentinelHead.1 anon = new NodeChainKt.SentinelHead.1();
        final int i = 0;
        anon.setAggregateChildKindSet$ui_release(-1);
        NodeChainKt.SentinelHead = anon;
    }

    public static final MutableVector access$fillVector(Modifier $receiver, MutableVector result) {
        return NodeChainKt.fillVector($receiver, result);
    }

    public static final androidx.compose.ui.node.NodeChainKt.SentinelHead.1 access$getSentinelHead$p() {
        return NodeChainKt.SentinelHead;
    }

    public static final void access$updateUnsafe(androidx.compose.ui.node.ModifierNodeElement $receiver, Modifier.Node node) {
        NodeChainKt.updateUnsafe($receiver, node);
    }

    public static final int actionForModifiers(Modifier.Element prev, Modifier.Element next) {
        int i;
        i = Intrinsics.areEqual(prev, next) ? 2 : objectsOfSameType ? 1 : 0;
        return i;
    }

    private static final MutableVector<Modifier.Element> fillVector(Modifier $this$fillVector, MutableVector<Modifier.Element> result) {
        int it;
        int i2;
        int outer$ui_release;
        androidx.compose.ui.node.NodeChainKt.fillVector.1 predicate;
        int i;
        int i4 = 0;
        MutableVector mutableVector = new MutableVector(new Modifier[RangesKt.coerceAtLeast(result.getSize(), 16)], 0);
        i2 = 0;
        mutableVector.add($this$fillVector);
        it = 0;
        while (mutableVector.isNotEmpty()) {
            i2 = mutableVector.removeAt(size2--);
            if (i2 instanceof CombinedModifier) {
            } else {
            }
            if (i2 instanceof Modifier.Element != 0) {
            } else {
            }
            if (it == 0) {
            } else {
            }
            predicate = it;
            (Modifier)i2.all(it);
            it = predicate;
            outer$ui_release = new NodeChainKt.fillVector.1(result);
            predicate = outer$ui_release;
            i = 0;
            it = outer$ui_release;
            result.add(i2);
            mutableVector.add((CombinedModifier)i2.getInner$ui_release());
            mutableVector.add((CombinedModifier)i2.getOuter$ui_release());
        }
        return result;
    }

    private static final <T extends Modifier.Node> void updateUnsafe(androidx.compose.ui.node.ModifierNodeElement<T> $this$updateUnsafe, Modifier.Node node) {
        Intrinsics.checkNotNull(node, "null cannot be cast to non-null type T of androidx.compose.ui.node.NodeChainKt.updateUnsafe");
        $this$updateUnsafe.update(node);
    }
}
