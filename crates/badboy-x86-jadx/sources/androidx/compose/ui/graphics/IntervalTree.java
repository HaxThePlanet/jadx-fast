package androidx.compose.ui.graphics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010(\n\u0002\u0008\n\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002:\u0002)*B\u0005¢\u0006\u0002\u0010\u0003J%\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0008\u0010\u000f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u000bJ\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0086\u0002J\u0017\u0010\u0012\u001a\u00020\u00132\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0016H\u0086\u0002J\u001e\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\rJ\u001a\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00182\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0016J:\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00180\u001a2\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r2\u0014\u0008\u0002\u0010\u001b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00180\u001aJ6\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00180\u001a2\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\r0\u00162\u0014\u0008\u0002\u0010\u001b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00180\u001aJ:\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r2\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0018\u0012\u0004\u0012\u00020\u000b0\u001eH\u0080\u0008¢\u0006\u0002\u0008\u001fJ6\u0010\u001c\u001a\u00020\u000b2\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\r0\u00162\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0018\u0012\u0004\u0012\u00020\u000b0\u001eH\u0080\u0008¢\u0006\u0002\u0008\u001fJ\u0015\u0010 \u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00180!H\u0086\u0002J\u0017\u0010\"\u001a\u00020\u000b2\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0018H\u0086\u0002J\u001a\u0010#\u001a\u00020\u000b2\u0010\u0010$\u001a\u000c0\u0005R\u0008\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u001a\u0010%\u001a\u00020\u000b2\u0010\u0010&\u001a\u000c0\u0005R\u0008\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u001a\u0010'\u001a\u00020\u000b2\u0010\u0010&\u001a\u000c0\u0005R\u0008\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u001a\u0010(\u001a\u00020\u000b2\u0010\u0010&\u001a\u000c0\u0005R\u0008\u0012\u0004\u0012\u00028\u00000\u0000H\u0002R\u0018\u0010\u0004\u001a\u000c0\u0005R\u0008\u0012\u0004\u0012\u00028\u00000\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u0006\u001a&\u0012\u000e\u0012\u000c0\u0005R\u0008\u0012\u0004\u0012\u00028\u00000\u00000\u0007j\u0012\u0012\u000e\u0012\u000c0\u0005R\u0008\u0012\u0004\u0012\u00028\u00000\u0000`\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\u000c0\u0005R\u0008\u0012\u0004\u0012\u00028\u00000\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+", d2 = {"Landroidx/compose/ui/graphics/IntervalTree;", "T", "", "()V", "root", "Landroidx/compose/ui/graphics/IntervalTree$Node;", "stack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "terminator", "addInterval", "", "start", "", "end", "data", "(FFLjava/lang/Object;)V", "clear", "contains", "", "value", "interval", "Lkotlin/ranges/ClosedFloatingPointRange;", "findFirstOverlap", "Landroidx/compose/ui/graphics/Interval;", "findOverlaps", "", "results", "forEach", "block", "Lkotlin/Function1;", "forEach$ui_graphics_release", "iterator", "", "plusAssign", "rebalance", "target", "rotateLeft", "node", "rotateRight", "updateNodeData", "Node", "TreeColor", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntervalTree<T>  {

    private androidx.compose.ui.graphics.IntervalTree.Node<T> root;
    private final ArrayList<androidx.compose.ui.graphics.IntervalTree.Node<T>> stack;
    private final androidx.compose.ui.graphics.IntervalTree.Node<T> terminator;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0015\u0008\u0080\u0004\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0010\u0010!\u001a\u000c0\u0000R\u0008\u0012\u0004\u0012\u00028\u00000\u000eJ\u0010\u0010\"\u001a\u000c0\u0000R\u0008\u0012\u0004\u0012\u00028\u00000\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR$\u0010\r\u001a\u000c0\u0000R\u0008\u0012\u0004\u0012\u00028\u00000\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0019\u0010\u0015\"\u0004\u0008\u001a\u0010\u0017R$\u0010\u001b\u001a\u000c0\u0000R\u0008\u0012\u0004\u0012\u00028\u00000\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001c\u0010\u0010\"\u0004\u0008\u001d\u0010\u0012R$\u0010\u001e\u001a\u000c0\u0000R\u0008\u0012\u0004\u0012\u00028\u00000\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001f\u0010\u0010\"\u0004\u0008 \u0010\u0012¨\u0006#", d2 = {"Landroidx/compose/ui/graphics/IntervalTree$Node;", "Landroidx/compose/ui/graphics/Interval;", "start", "", "end", "data", "color", "Landroidx/compose/ui/graphics/IntervalTree$TreeColor;", "(Landroidx/compose/ui/graphics/IntervalTree;FFLjava/lang/Object;Landroidx/compose/ui/graphics/IntervalTree$TreeColor;)V", "getColor", "()Landroidx/compose/ui/graphics/IntervalTree$TreeColor;", "setColor", "(Landroidx/compose/ui/graphics/IntervalTree$TreeColor;)V", "left", "Landroidx/compose/ui/graphics/IntervalTree;", "getLeft", "()Landroidx/compose/ui/graphics/IntervalTree$Node;", "setLeft", "(Landroidx/compose/ui/graphics/IntervalTree$Node;)V", "max", "getMax", "()F", "setMax", "(F)V", "min", "getMin", "setMin", "parent", "getParent", "setParent", "right", "getRight", "setRight", "lowestNode", "next", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class Node extends androidx.compose.ui.graphics.Interval<T> {

        private androidx.compose.ui.graphics.IntervalTree.TreeColor color;
        private androidx.compose.ui.graphics.IntervalTree.Node<T> left;
        private float max;
        private float min;
        private androidx.compose.ui.graphics.IntervalTree.Node<T> parent;
        private androidx.compose.ui.graphics.IntervalTree.Node<T> right;
        final androidx.compose.ui.graphics.IntervalTree<T> this$0;
        public Node(androidx.compose.ui.graphics.IntervalTree this$0, float start, float end, Object data, androidx.compose.ui.graphics.IntervalTree.TreeColor color) {
            this.this$0 = this$0;
            super(start, end, data);
            this.color = color;
            this.min = start;
            this.max = end;
            this.left = IntervalTree.access$getTerminator$p(this.this$0);
            this.right = IntervalTree.access$getTerminator$p(this.this$0);
            this.parent = IntervalTree.access$getTerminator$p(this.this$0);
        }

        @Override // androidx.compose.ui.graphics.Interval
        public final androidx.compose.ui.graphics.IntervalTree.TreeColor getColor() {
            return this.color;
        }

        public final androidx.compose.ui.graphics.IntervalTree.Node<T> getLeft() {
            return this.left;
        }

        @Override // androidx.compose.ui.graphics.Interval
        public final float getMax() {
            return this.max;
        }

        @Override // androidx.compose.ui.graphics.Interval
        public final float getMin() {
            return this.min;
        }

        public final androidx.compose.ui.graphics.IntervalTree.Node<T> getParent() {
            return this.parent;
        }

        public final androidx.compose.ui.graphics.IntervalTree.Node<T> getRight() {
            return this.right;
        }

        public final androidx.compose.ui.graphics.IntervalTree.Node<T> lowestNode() {
            Object node2;
            androidx.compose.ui.graphics.IntervalTree.Node left;
            androidx.compose.ui.graphics.IntervalTree.Node node;
            node2 = this;
            while (node2.left != IntervalTree.access$getTerminator$p(this.this$0)) {
                node2 = node2.left;
            }
            return node2;
        }

        public final androidx.compose.ui.graphics.IntervalTree.Node<T> next() {
            Object a;
            androidx.compose.ui.graphics.IntervalTree.Node b;
            androidx.compose.ui.graphics.IntervalTree.Node right;
            if (this.right != IntervalTree.access$getTerminator$p(this.this$0)) {
                return this.right.lowestNode();
            }
            a = this;
            b = this.parent;
            while (b != IntervalTree.access$getTerminator$p(this.this$0)) {
                if (a == b.right) {
                }
                a = b;
                b = b.parent;
            }
            return b;
        }

        @Override // androidx.compose.ui.graphics.Interval
        public final void setColor(androidx.compose.ui.graphics.IntervalTree.TreeColor <set-?>) {
            this.color = <set-?>;
        }

        public final void setLeft(androidx.compose.ui.graphics.IntervalTree.Node<T> <set-?>) {
            this.left = <set-?>;
        }

        @Override // androidx.compose.ui.graphics.Interval
        public final void setMax(float <set-?>) {
            this.max = <set-?>;
        }

        @Override // androidx.compose.ui.graphics.Interval
        public final void setMin(float <set-?>) {
            this.min = <set-?>;
        }

        public final void setParent(androidx.compose.ui.graphics.IntervalTree.Node<T> <set-?>) {
            this.parent = <set-?>;
        }

        public final void setRight(androidx.compose.ui.graphics.IntervalTree.Node<T> <set-?>) {
            this.right = <set-?>;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0080\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Landroidx/compose/ui/graphics/IntervalTree$TreeColor;", "", "(Ljava/lang/String;I)V", "Red", "Black", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static enum TreeColor {

        Red,
        Red,
        Red;
        private static final androidx.compose.ui.graphics.IntervalTree.TreeColor[] $values() {
            return /* result */;
        }
    }
    public IntervalTree() {
        super();
        final androidx.compose.ui.graphics.IntervalTree intervalTree = this;
        IntervalTree.Node node = new IntervalTree.Node(intervalTree, 2139095039, 1, 0, IntervalTree.TreeColor.Black);
        intervalTree.terminator = node;
        intervalTree.root = intervalTree.terminator;
        ArrayList arrayList = new ArrayList();
        intervalTree.stack = arrayList;
    }

    public static final androidx.compose.ui.graphics.IntervalTree.Node access$getRoot$p(androidx.compose.ui.graphics.IntervalTree $this) {
        return $this.root;
    }

    public static final ArrayList access$getStack$p(androidx.compose.ui.graphics.IntervalTree $this) {
        return $this.stack;
    }

    public static final androidx.compose.ui.graphics.IntervalTree.Node access$getTerminator$p(androidx.compose.ui.graphics.IntervalTree $this) {
        return $this.terminator;
    }

    public static androidx.compose.ui.graphics.Interval findFirstOverlap$default(androidx.compose.ui.graphics.IntervalTree intervalTree, float f2, float f3, int i4, Object object5) {
        float obj2;
        if (i4 &= 2 != 0) {
            obj2 = f2;
        }
        return intervalTree.findFirstOverlap(f2, obj2);
    }

    public static List findOverlaps$default(androidx.compose.ui.graphics.IntervalTree intervalTree, float f2, float f3, List list4, int i5, Object object6) {
        float obj2;
        ArrayList obj3;
        if (i5 & 2 != 0) {
            obj2 = f2;
        }
        if (i5 &= 4 != 0) {
            obj3 = new ArrayList();
        }
        return intervalTree.findOverlaps(f2, obj2, obj3);
    }

    public static List findOverlaps$default(androidx.compose.ui.graphics.IntervalTree intervalTree, ClosedFloatingPointRange closedFloatingPointRange2, List list3, int i4, Object object5) {
        ArrayList obj2;
        if (i4 &= 2 != 0) {
            obj2 = new ArrayList();
        }
        return intervalTree.findOverlaps(closedFloatingPointRange2, obj2);
    }

    public static void forEach$ui_graphics_release$default(androidx.compose.ui.graphics.IntervalTree $this, float start, float end, Function1 block, int i5, Object object6) {
        androidx.compose.ui.graphics.IntervalTree.Node last;
        androidx.compose.ui.graphics.IntervalTree.Node size;
        androidx.compose.ui.graphics.IntervalTree.Node right;
        androidx.compose.ui.graphics.IntervalTree.Node left;
        androidx.compose.ui.graphics.IntervalTree.Node node;
        float obj5;
        Object obj8;
        if (i5 &= 2 != 0) {
            obj5 = start;
        }
        int obj7 = 0;
        if (IntervalTree.access$getRoot$p($this) != IntervalTree.access$getTerminator$p($this)) {
            obj8 = IntervalTree.access$getStack$p($this);
            obj8.add(IntervalTree.access$getRoot$p($this));
            while (obj8.size() > 0) {
                last = CollectionsKt.removeLast((List)obj8);
                if ((IntervalTree.Node)last.overlaps(start, obj5)) {
                }
                if (last.getLeft() != IntervalTree.access$getTerminator$p($this) && Float.compare(max, start) >= 0) {
                }
                if (last.getRight() != IntervalTree.access$getTerminator$p($this) && Float.compare(min, obj5) <= 0) {
                }
                if (Float.compare(min, obj5) <= 0) {
                }
                obj8.add(last.getRight());
                if (Float.compare(max, start) >= 0) {
                }
                obj8.add(last.getLeft());
                block.invoke(last);
            }
            obj8.clear();
        }
    }

    private final void rebalance(androidx.compose.ui.graphics.IntervalTree.Node<T> target) {
        androidx.compose.ui.graphics.IntervalTree.Node node;
        androidx.compose.ui.graphics.IntervalTree.Node parent;
        Object color;
        androidx.compose.ui.graphics.IntervalTree.Node right;
        androidx.compose.ui.graphics.IntervalTree.TreeColor red;
        androidx.compose.ui.graphics.IntervalTree.TreeColor black;
        node = target;
        while (node != this.root) {
            if (node.getParent().getColor() == IntervalTree.TreeColor.Red) {
            }
            parent = node.getParent().getParent();
            if (node.getParent() == parent.getLeft()) {
            } else {
            }
            right = parent.getLeft();
            if (right.getColor() == IntervalTree.TreeColor.Red) {
            } else {
            }
            if (node == node.getParent().getLeft()) {
            }
            node.getParent().setColor(IntervalTree.TreeColor.Black);
            parent.setColor(IntervalTree.TreeColor.Red);
            rotateLeft(parent);
            rotateRight(node.getParent());
            right.setColor(IntervalTree.TreeColor.Black);
            node.getParent().setColor(IntervalTree.TreeColor.Black);
            parent.setColor(IntervalTree.TreeColor.Red);
            node = parent;
            right = parent.getRight();
            if (right.getColor() == IntervalTree.TreeColor.Red) {
            } else {
            }
            if (node == node.getParent().getRight()) {
            }
            node.getParent().setColor(IntervalTree.TreeColor.Black);
            parent.setColor(IntervalTree.TreeColor.Red);
            rotateRight(parent);
            rotateLeft(node.getParent());
            right.setColor(IntervalTree.TreeColor.Black);
            node.getParent().setColor(IntervalTree.TreeColor.Black);
            parent.setColor(IntervalTree.TreeColor.Red);
            node = parent;
        }
        this.root.setColor(IntervalTree.TreeColor.Black);
    }

    private final void rotateLeft(androidx.compose.ui.graphics.IntervalTree.Node<T> node) {
        androidx.compose.ui.graphics.IntervalTree.Node left;
        androidx.compose.ui.graphics.IntervalTree.Node parent;
        final androidx.compose.ui.graphics.IntervalTree.Node right = node.getRight();
        node.setRight(right.getLeft());
        if (right.getLeft() != this.terminator) {
            right.getLeft().setParent(node);
        }
        right.setParent(node.getParent());
        if (node.getParent() == this.terminator) {
            this.root = right;
        } else {
            if (node.getParent().getLeft() == node) {
                node.getParent().setLeft(right);
            } else {
                node.getParent().setRight(right);
            }
        }
        right.setLeft(node);
        node.setParent(right);
        updateNodeData(node);
    }

    private final void rotateRight(androidx.compose.ui.graphics.IntervalTree.Node<T> node) {
        androidx.compose.ui.graphics.IntervalTree.Node right;
        androidx.compose.ui.graphics.IntervalTree.Node parent;
        final androidx.compose.ui.graphics.IntervalTree.Node left = node.getLeft();
        node.setLeft(left.getRight());
        if (left.getRight() != this.terminator) {
            left.getRight().setParent(node);
        }
        left.setParent(node.getParent());
        if (node.getParent() == this.terminator) {
            this.root = left;
        } else {
            if (node.getParent().getRight() == node) {
                node.getParent().setRight(left);
            } else {
                node.getParent().setLeft(left);
            }
        }
        left.setRight(node);
        node.setParent(left);
        updateNodeData(node);
    }

    private final void updateNodeData(androidx.compose.ui.graphics.IntervalTree.Node<T> node) {
        androidx.compose.ui.graphics.IntervalTree.Node current;
        float f;
        float f2;
        float max;
        current = node;
        while (current != this.terminator) {
            current.setMin(Math.min(current.getStart(), Math.min(current.getLeft().getMin(), current.getRight().getMin())));
            current.setMax(Math.max(current.getEnd(), Math.max(current.getLeft().getMax(), current.getRight().getMax())));
            current = current.getParent();
        }
    }

    public final void addInterval(float start, float end, T data) {
        androidx.compose.ui.graphics.IntervalTree.TreeColor start2;
        androidx.compose.ui.graphics.IntervalTree.Node obj7;
        androidx.compose.ui.graphics.IntervalTree.Node obj8;
        Object obj9;
        final androidx.compose.ui.graphics.IntervalTree intervalTree = this;
        IntervalTree.Node node = new IntervalTree.Node(intervalTree, start, end, data, IntervalTree.TreeColor.Red);
        obj7 = intervalTree.root;
        obj8 = intervalTree.terminator;
        while (obj7 != intervalTree.terminator) {
            obj8 = obj7;
            if (Float.compare(obj9, start2) <= 0) {
            } else {
            }
            obj9 = obj7.getRight();
            obj7 = obj9;
            obj9 = obj7.getLeft();
        }
        node.setParent(obj8);
        if (obj8 == intervalTree.terminator) {
            intervalTree.root = node;
        } else {
            if (Float.compare(obj9, start2) <= 0) {
                obj8.setLeft(node);
            } else {
                obj8.setRight(node);
            }
        }
        updateNodeData(node);
        rebalance(node);
    }

    public final void clear() {
        this.root = this.terminator;
    }

    public final boolean contains(float value) {
        int i;
        i = findFirstOverlap(value, value) != IntervalTreeKt.getEmptyInterval() ? 1 : 0;
        return i;
    }

    public final boolean contains(ClosedFloatingPointRange<Float> interval) {
        int i;
        i = findFirstOverlap((Number)interval.getStart().floatValue(), (Number)interval.getEndInclusive().floatValue()) != IntervalTreeKt.getEmptyInterval() ? 1 : 0;
        return i;
    }

    public final androidx.compose.ui.graphics.Interval<T> findFirstOverlap(float start, float end) {
        Object root;
        androidx.compose.ui.graphics.IntervalTree.Node terminator;
        Object obj;
        androidx.compose.ui.graphics.IntervalTree.Node size;
        androidx.compose.ui.graphics.IntervalTree.Node last;
        androidx.compose.ui.graphics.IntervalTree.Node right;
        androidx.compose.ui.graphics.IntervalTree.Node left;
        androidx.compose.ui.graphics.IntervalTree.Node node;
        root = this;
        terminator = 0;
        if (this.root != this.terminator && IntervalTree.access$getRoot$p(root) != IntervalTree.access$getTerminator$p(root)) {
            root = this;
            terminator = 0;
            if (IntervalTree.access$getRoot$p(root) != IntervalTree.access$getTerminator$p(root)) {
                obj = IntervalTree.access$getStack$p(root);
                obj.add(IntervalTree.access$getRoot$p(root));
                while (obj.size() > 0) {
                    last = CollectionsKt.removeLast((List)obj);
                    if (last.getLeft() != IntervalTree.access$getTerminator$p(root) && Float.compare(max, start) >= 0) {
                    }
                    if (last.getRight() != IntervalTree.access$getTerminator$p(root) && Float.compare(min, end) <= 0) {
                    }
                    if (Float.compare(min, end) <= 0) {
                    }
                    obj.add(last.getRight());
                    if (Float.compare(max, start) >= 0) {
                    }
                    obj.add(last.getLeft());
                }
                obj.clear();
            }
        }
        androidx.compose.ui.graphics.Interval emptyInterval = IntervalTreeKt.getEmptyInterval();
        Intrinsics.checkNotNull(emptyInterval, "null cannot be cast to non-null type androidx.compose.ui.graphics.Interval<T of androidx.compose.ui.graphics.IntervalTree>");
        return emptyInterval;
    }

    public final androidx.compose.ui.graphics.Interval<T> findFirstOverlap(ClosedFloatingPointRange<Float> interval) {
        return findFirstOverlap((Number)interval.getStart().floatValue(), (Number)interval.getEndInclusive().floatValue());
    }

    public final List<androidx.compose.ui.graphics.Interval<T>> findOverlaps(float start, float end, List<androidx.compose.ui.graphics.Interval<T>> results) {
        Object node2;
        androidx.compose.ui.graphics.IntervalTree.Node last;
        androidx.compose.ui.graphics.IntervalTree.Node size;
        androidx.compose.ui.graphics.IntervalTree.Node right;
        boolean overlaps;
        androidx.compose.ui.graphics.IntervalTree.Node left;
        androidx.compose.ui.graphics.IntervalTree.Node node;
        final androidx.compose.ui.graphics.IntervalTree intervalTree = this;
        final int i = 0;
        if (IntervalTree.access$getRoot$p(intervalTree) != IntervalTree.access$getTerminator$p(intervalTree)) {
            node2 = IntervalTree.access$getStack$p(intervalTree);
            node2.add(IntervalTree.access$getRoot$p(intervalTree));
            while (node2.size() > 0) {
                last = CollectionsKt.removeLast((List)node2);
                if ((IntervalTree.Node)last.overlaps(start, end)) {
                }
                if (last.getLeft() != IntervalTree.access$getTerminator$p(intervalTree) && Float.compare(max, start) >= 0) {
                }
                if (last.getRight() != IntervalTree.access$getTerminator$p(intervalTree) && Float.compare(min, end) <= 0) {
                }
                if (Float.compare(min, end) <= 0) {
                }
                node2.add(last.getRight());
                if (Float.compare(max, start) >= 0) {
                }
                node2.add(last.getLeft());
                node = 0;
                results.add((Interval)last);
            }
            node2.clear();
        }
        return results;
    }

    public final List<androidx.compose.ui.graphics.Interval<T>> findOverlaps(ClosedFloatingPointRange<Float> interval, List<androidx.compose.ui.graphics.Interval<T>> results) {
        return findOverlaps((Number)interval.getStart().floatValue(), (Number)interval.getEndInclusive().floatValue(), results);
    }

    public final void forEach$ui_graphics_release(float start, float end, Function1<? super androidx.compose.ui.graphics.Interval<T>, Unit> block) {
        Object node;
        androidx.compose.ui.graphics.IntervalTree.Node last;
        androidx.compose.ui.graphics.IntervalTree.Node size;
        androidx.compose.ui.graphics.IntervalTree.Node right;
        androidx.compose.ui.graphics.IntervalTree.Node left;
        androidx.compose.ui.graphics.IntervalTree.Node node2;
        final int i = 0;
        if (IntervalTree.access$getRoot$p(this) != IntervalTree.access$getTerminator$p(this)) {
            node = IntervalTree.access$getStack$p(this);
            node.add(IntervalTree.access$getRoot$p(this));
            while (node.size() > 0) {
                last = CollectionsKt.removeLast((List)node);
                if ((IntervalTree.Node)last.overlaps(start, end)) {
                }
                if (last.getLeft() != IntervalTree.access$getTerminator$p(this) && Float.compare(max, start) >= 0) {
                }
                if (last.getRight() != IntervalTree.access$getTerminator$p(this) && Float.compare(min, end) <= 0) {
                }
                if (Float.compare(min, end) <= 0) {
                }
                node.add(last.getRight());
                if (Float.compare(max, start) >= 0) {
                }
                node.add(last.getLeft());
                block.invoke(last);
            }
            node.clear();
        }
    }

    public final void forEach$ui_graphics_release(ClosedFloatingPointRange<Float> interval, Function1<? super androidx.compose.ui.graphics.Interval<T>, Unit> block) {
        Object node2;
        androidx.compose.ui.graphics.IntervalTree.Node last;
        androidx.compose.ui.graphics.IntervalTree.Node size;
        androidx.compose.ui.graphics.IntervalTree.Node right;
        androidx.compose.ui.graphics.IntervalTree.Node left;
        androidx.compose.ui.graphics.IntervalTree.Node node;
        final int i = 0;
        float floatValue = (Number)interval.getStart().floatValue();
        float floatValue2 = (Number)interval.getEndInclusive().floatValue();
        final androidx.compose.ui.graphics.IntervalTree intervalTree = this;
        final int i2 = 0;
        if (IntervalTree.access$getRoot$p(intervalTree) != IntervalTree.access$getTerminator$p(intervalTree)) {
            node2 = IntervalTree.access$getStack$p(intervalTree);
            node2.add(IntervalTree.access$getRoot$p(intervalTree));
            while (node2.size() > 0) {
                last = CollectionsKt.removeLast((List)node2);
                if ((IntervalTree.Node)last.overlaps(floatValue, floatValue2)) {
                }
                if (last.getLeft() != IntervalTree.access$getTerminator$p(intervalTree) && Float.compare(max, floatValue) >= 0) {
                }
                if (last.getRight() != IntervalTree.access$getTerminator$p(intervalTree) && Float.compare(min, floatValue2) <= 0) {
                }
                if (Float.compare(min, floatValue2) <= 0) {
                }
                node2.add(last.getRight());
                if (Float.compare(max, floatValue) >= 0) {
                }
                node2.add(last.getLeft());
                block.invoke(last);
            }
            node2.clear();
        }
    }

    public final Iterator<androidx.compose.ui.graphics.Interval<T>> iterator() {
        IntervalTree.iterator.1 anon = new IntervalTree.iterator.1(this);
        return (Iterator)anon;
    }

    public final void plusAssign(androidx.compose.ui.graphics.Interval<T> interval) {
        addInterval(interval.getStart(), interval.getEnd(), interval.getData());
    }
}
