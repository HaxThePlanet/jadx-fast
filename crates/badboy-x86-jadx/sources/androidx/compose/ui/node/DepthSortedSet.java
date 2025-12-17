package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import java.util.Comparator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u0086\u0008J\u0006\u0010\u0018\u001a\u00020\u0007J\u001f\u0010\u0019\u001a\u00020\u00132\u0014\u0008\u0004\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u001bH\u0086\u0008J\u000e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0007J\u0008\u0010\u001d\u001a\u00020\u001eH\u0016R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\u0008\u0012\u0004\u0012\u00020\u0007`\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u0014\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Landroidx/compose/ui/node/DepthSortedSet;", "", "extraAssertions", "", "(Z)V", "DepthComparator", "Ljava/util/Comparator;", "Landroidx/compose/ui/node/LayoutNode;", "Lkotlin/Comparator;", "mapOfOriginalDepth", "", "", "getMapOfOriginalDepth", "()Ljava/util/Map;", "mapOfOriginalDepth$delegate", "Lkotlin/Lazy;", "set", "Landroidx/compose/ui/node/TreeSet;", "add", "", "node", "contains", "isEmpty", "isNotEmpty", "pop", "popEach", "block", "Lkotlin/Function1;", "remove", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DepthSortedSet {

    public static final int $stable = 8;
    private final Comparator<androidx.compose.ui.node.LayoutNode> DepthComparator;
    private final boolean extraAssertions;
    private final Lazy mapOfOriginalDepth$delegate;
    private final androidx.compose.ui.node.TreeSet<androidx.compose.ui.node.LayoutNode> set;
    static {
        final int i = 8;
    }

    public DepthSortedSet(boolean extraAssertions) {
        super();
        this.extraAssertions = extraAssertions;
        this.mapOfOriginalDepth$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0)DepthSortedSet.mapOfOriginalDepth.2.INSTANCE);
        DepthSortedSet.DepthComparator.1 anon = new DepthSortedSet.DepthComparator.1();
        this.DepthComparator = (Comparator)anon;
        TreeSet treeSet = new TreeSet(this.DepthComparator);
        this.set = treeSet;
    }

    private final Map<androidx.compose.ui.node.LayoutNode, Integer> getMapOfOriginalDepth() {
        return (Map)this.mapOfOriginalDepth$delegate.getValue();
    }

    public final void add(androidx.compose.ui.node.LayoutNode node) {
        boolean value$iv;
        int mapOfOriginalDepth;
        String valueOf;
        String str;
        mapOfOriginalDepth = 0;
        if (!node.isAttached()) {
            int i = 0;
            InlineClassHelperKt.throwIllegalStateException("DepthSortedSet.add called on an unattached node");
        }
        if (this.extraAssertions) {
            value$iv = getMapOfOriginalDepth().get(node);
            if ((Integer)value$iv == null) {
                getMapOfOriginalDepth().put(node, Integer.valueOf(node.getDepth$ui_release()));
            } else {
                mapOfOriginalDepth = (Integer)value$iv.intValue() == node.getDepth$ui_release() ? 1 : 0;
                valueOf = 0;
                if (mapOfOriginalDepth == 0) {
                    int i2 = 0;
                    InlineClassHelperKt.throwIllegalStateException("invalid node depth");
                }
            }
        }
        this.set.add(node);
    }

    public final boolean contains(androidx.compose.ui.node.LayoutNode node) {
        boolean extraAssertions;
        int i;
        String str;
        boolean contains = this.set.contains(node);
        if (this.extraAssertions) {
            extraAssertions = contains == getMapOfOriginalDepth().containsKey(node) ? 1 : 0;
            i = 0;
            if (extraAssertions == 0) {
                int i2 = 0;
                InlineClassHelperKt.throwIllegalStateException("inconsistency in TreeSet");
            }
        }
        return contains;
    }

    public final boolean isEmpty() {
        return this.set.isEmpty();
    }

    public final boolean isNotEmpty() {
        final int i = 0;
        return empty ^= 1;
    }

    public final androidx.compose.ui.node.LayoutNode pop() {
        Object first = this.set.first();
        remove((LayoutNode)first);
        return first;
    }

    public final void popEach(Function1<? super androidx.compose.ui.node.LayoutNode, Unit> block) {
        androidx.compose.ui.node.LayoutNode layoutNode;
        int i;
        boolean empty;
        final int i2 = 0;
        i = 0;
        while (!this.isEmpty()) {
            block.invoke(pop());
            i = 0;
        }
    }

    public final boolean remove(androidx.compose.ui.node.LayoutNode node) {
        boolean extraAssertions;
        String equal;
        int valueOf;
        int i;
        String str;
        int i2 = 0;
        if (!node.isAttached()) {
            int i3 = 0;
            InlineClassHelperKt.throwIllegalStateException("DepthSortedSet.remove called on an unattached node");
        }
        boolean remove = this.set.remove(node);
        if (this.extraAssertions) {
            if (remove) {
                valueOf = Integer.valueOf(node.getDepth$ui_release());
            } else {
                valueOf = 0;
            }
            i = 0;
            if (!Intrinsics.areEqual((Integer)getMapOfOriginalDepth().remove(node), valueOf)) {
                int i4 = 0;
                InlineClassHelperKt.throwIllegalStateException("invalid node depth");
            }
        }
        return remove;
    }

    public String toString() {
        return this.set.toString();
    }
}
