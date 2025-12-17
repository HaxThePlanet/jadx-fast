package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u0003J\u0006\u0010\u000e\u001a\u00020\u0003J\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u000bJC\u0010\u0011\u001a\u00020\t28\u0008\u0004\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u0014\u0012\u0008\u0008\u0015\u0012\u0004\u0008\u0008(\n\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u0014\u0012\u0008\u0008\u0015\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u00020\t0\u0013H\u0086\u0008J\u000e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u0003R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Landroidx/compose/ui/node/DepthSortedSetsForDifferentPasses;", "", "extraAssertions", "", "(Z)V", "lookaheadSet", "Landroidx/compose/ui/node/DepthSortedSet;", "set", "add", "", "node", "Landroidx/compose/ui/node/LayoutNode;", "affectsLookahead", "contains", "isEmpty", "isNotEmpty", "pop", "popEach", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "remove", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DepthSortedSetsForDifferentPasses {

    public static final int $stable = 8;
    private final androidx.compose.ui.node.DepthSortedSet lookaheadSet;
    private final androidx.compose.ui.node.DepthSortedSet set;
    static {
        final int i = 8;
    }

    public DepthSortedSetsForDifferentPasses(boolean extraAssertions) {
        super();
        DepthSortedSet depthSortedSet = new DepthSortedSet(extraAssertions);
        this.lookaheadSet = depthSortedSet;
        DepthSortedSet depthSortedSet2 = new DepthSortedSet(extraAssertions);
        this.set = depthSortedSet2;
    }

    public static final androidx.compose.ui.node.DepthSortedSet access$getLookaheadSet$p(androidx.compose.ui.node.DepthSortedSetsForDifferentPasses $this) {
        return $this.lookaheadSet;
    }

    public static final androidx.compose.ui.node.DepthSortedSet access$getSet$p(androidx.compose.ui.node.DepthSortedSetsForDifferentPasses $this) {
        return $this.set;
    }

    public final void add(androidx.compose.ui.node.LayoutNode node, boolean affectsLookahead) {
        androidx.compose.ui.node.DepthSortedSet contains;
        if (affectsLookahead) {
            this.lookaheadSet.add(node);
            this.set.add(node);
        } else {
            if (!this.lookaheadSet.contains(node)) {
                this.set.add(node);
            }
        }
    }

    public final boolean contains(androidx.compose.ui.node.LayoutNode node) {
        int i;
        boolean contains;
        if (!this.lookaheadSet.contains(node)) {
            if (this.set.contains(node)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final boolean contains(androidx.compose.ui.node.LayoutNode node, boolean affectsLookahead) {
        int i;
        boolean contains;
        boolean contains2 = this.lookaheadSet.contains(node);
        if (affectsLookahead) {
            i = contains2;
        } else {
            if (!contains2) {
                if (this.set.contains(node)) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        }
        return i;
    }

    public final boolean isEmpty() {
        boolean empty;
        int i;
        if (this.set.isEmpty() && this.lookaheadSet.isEmpty()) {
            i = this.lookaheadSet.isEmpty() ? 1 : 0;
        } else {
        }
        return i;
    }

    public final boolean isEmpty(boolean affectsLookahead) {
        androidx.compose.ui.node.DepthSortedSet lookaheadSet;
        lookaheadSet = affectsLookahead ? this.lookaheadSet : this.set;
        return lookaheadSet.isEmpty();
    }

    public final boolean isNotEmpty() {
        return empty ^= 1;
    }

    public final androidx.compose.ui.node.LayoutNode pop() {
        final int i = 0;
        if (!this.lookaheadSet.isEmpty()) {
            return this.lookaheadSet.pop();
        }
        return this.set.pop();
    }

    public final void popEach(Function2<? super androidx.compose.ui.node.LayoutNode, ? super Boolean, Unit> block) {
        int this_$iv;
        androidx.compose.ui.node.LayoutNode layoutNode;
        androidx.compose.ui.node.DepthSortedSet set;
        Boolean valueOf;
        final int i = 0;
        while (isNotEmpty()) {
            int i2 = 0;
            this_$iv = empty ^ 1;
            if (this_$iv != 0) {
            } else {
            }
            set = DepthSortedSetsForDifferentPasses.access$getSet$p(this);
            block.invoke(set.pop(), Boolean.valueOf(this_$iv));
            set = DepthSortedSetsForDifferentPasses.access$getLookaheadSet$p(this);
        }
    }

    public final boolean remove(androidx.compose.ui.node.LayoutNode node) {
        int i;
        if (!this.set.remove(node)) {
            if (this.lookaheadSet.remove(node)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final boolean remove(androidx.compose.ui.node.LayoutNode node, boolean affectsLookahead) {
        boolean remove;
        if (affectsLookahead) {
            remove = this.lookaheadSet.remove(node);
        } else {
            remove = this.set.remove(node);
        }
        return remove;
    }
}
