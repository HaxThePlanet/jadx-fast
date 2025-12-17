package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier.Element;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.ModifierInfo;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u001c\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0000\u0018\u00002\u00020\u0001:\u0002mnB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0010H\u0002J\u0018\u0010(\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0010H\u0002J\u0010\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0010H\u0002J?\u0010,\u001a\u0004\u0018\u0001H-\"\u0006\u0008\u0000\u0010-\u0018\u00012\u000c\u0010.\u001a\u0008\u0012\u0004\u0012\u0002H-0/2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u001901H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u00082\u00103J@\u00104\u001a\u00060\rR\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u00062\u000c\u00106\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u000c\u00107\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u00108\u001a\u00020\u0019H\u0002J\u000c\u00109\u001a\u0008\u0012\u0004\u0012\u00020;0:J\u001e\u0010<\u001a\u00020\u00192\n\u0010.\u001a\u0006\u0012\u0002\u0008\u00030/H\u0000ø\u0001\u0000¢\u0006\u0004\u0008=\u0010>J\u0015\u0010<\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\u0006H\u0000¢\u0006\u0002\u0008@J+\u0010\u0011\u001a\u0004\u0018\u0001H-\"\u0006\u0008\u0000\u0010-\u0018\u00012\u000c\u0010.\u001a\u0008\u0012\u0004\u0012\u0002H-0/H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008A\u0010BJ\"\u0010C\u001a\u00020D2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\u0080\u0008¢\u0006\u0002\u0008EJ=\u0010C\u001a\u00020D\"\u0006\u0008\u0000\u0010-\u0018\u00012\u000c\u0010.\u001a\u0008\u0012\u0004\u0012\u0002H-0/2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020D01H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008F\u0010GJ*\u0010C\u001a\u00020D2\u0006\u0010?\u001a\u00020\u00062\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\u0080\u0008¢\u0006\u0002\u0008EJ\"\u0010H\u001a\u00020D2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\u0080\u0008¢\u0006\u0002\u0008IJ\u0018\u0010J\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0010H\u0002J\u0018\u0010K\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010H\u0002J\u0006\u0010L\u001a\u00020DJ\r\u0010M\u001a\u00020DH\u0000¢\u0006\u0002\u0008NJ\u0008\u0010O\u001a\u00020\u0010H\u0002J\u0018\u0010P\u001a\u00020D2\u0006\u0010Q\u001a\u00020\u00102\u0006\u0010R\u001a\u00020\u001fH\u0002J\u0010\u0010S\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0010H\u0002J\r\u0010T\u001a\u00020DH\u0000¢\u0006\u0002\u0008UJ\u0006\u0010V\u001a\u00020DJ\r\u0010W\u001a\u00020DH\u0000¢\u0006\u0002\u0008XJ<\u0010Y\u001a\u00020D2\u0006\u00105\u001a\u00020\u00062\u000c\u00106\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u000c\u00107\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010#\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0019H\u0002J\u0008\u0010Z\u001a\u00020DH\u0002J\u0006\u0010[\u001a\u00020DJ+\u0010#\u001a\u0004\u0018\u0001H-\"\u0006\u0008\u0000\u0010-\u0018\u00012\u000c\u0010.\u001a\u0008\u0012\u0004\u0012\u0002H-0/H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008\\\u0010BJ\"\u0010]\u001a\u00020D2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\u0080\u0008¢\u0006\u0002\u0008^J=\u0010]\u001a\u00020D\"\u0006\u0008\u0000\u0010-\u0018\u00012\u000c\u0010.\u001a\u0008\u0012\u0004\u0012\u0002H-0/2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020D01H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008_\u0010GJ*\u0010]\u001a\u00020D2\u0006\u0010?\u001a\u00020\u00062\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\u0080\u0008¢\u0006\u0002\u0008^J\u0008\u0010`\u001a\u00020aH\u0016J\u0010\u0010b\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\u0010H\u0002J\u0015\u0010d\u001a\u00020D2\u0006\u0010e\u001a\u00020fH\u0000¢\u0006\u0002\u0008gJ \u0010h\u001a\u00020D2\u0006\u0010i\u001a\u00020\u000b2\u0006\u0010j\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0010H\u0002J\u0017\u0010k\u001a\u00020D2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0002\u0008lR\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u0008\u0018\u00010\rR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u001f@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0014\u0010#\u001a\u00020\u0010X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u0013\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006o", d2 = {"Landroidx/compose/ui/node/NodeChain;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "aggregateChildKindSet", "", "getAggregateChildKindSet", "()I", "buffer", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "cachedDiffer", "Landroidx/compose/ui/node/NodeChain$Differ;", "current", "<set-?>", "Landroidx/compose/ui/Modifier$Node;", "head", "getHead$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "innerCoordinator", "Landroidx/compose/ui/node/InnerNodeCoordinator;", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/InnerNodeCoordinator;", "isUpdating", "", "()Z", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "logger", "Landroidx/compose/ui/node/NodeChain$Logger;", "Landroidx/compose/ui/node/NodeCoordinator;", "outerCoordinator", "getOuterCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "tail", "getTail$ui_release", "createAndInsertNodeAsChild", "element", "parent", "createAndInsertNodeAsParent", "child", "detachAndRemoveNode", "node", "firstFromHead", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "block", "Lkotlin/Function1;", "firstFromHead-aLcG6gQ$ui_release", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getDiffer", "offset", "before", "after", "shouldAttachOnInsert", "getModifierInfo", "", "Landroidx/compose/ui/layout/ModifierInfo;", "has", "has-H91voCI$ui_release", "(I)Z", "mask", "has$ui_release", "head-H91voCI$ui_release", "(I)Ljava/lang/Object;", "headToTail", "", "headToTail$ui_release", "headToTail-aLcG6gQ$ui_release", "(ILkotlin/jvm/functions/Function1;)V", "headToTailExclusive", "headToTailExclusive$ui_release", "insertChild", "insertParent", "markAsAttached", "markAsDetached", "markAsDetached$ui_release", "padChain", "propagateCoordinator", "start", "coordinator", "removeNode", "resetState", "resetState$ui_release", "runAttachLifecycle", "runDetachLifecycle", "runDetachLifecycle$ui_release", "structuralUpdate", "syncAggregateChildKindSet", "syncCoordinators", "tail-H91voCI$ui_release", "tailToHead", "tailToHead$ui_release", "tailToHead-aLcG6gQ$ui_release", "toString", "", "trimChain", "paddedHead", "updateFrom", "m", "Landroidx/compose/ui/Modifier;", "updateFrom$ui_release", "updateNode", "prev", "next", "useLogger", "useLogger$ui_release", "Differ", "Logger", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NodeChain {

    public static final int $stable = 8;
    private MutableVector<Modifier.Element> buffer;
    private androidx.compose.ui.node.NodeChain.Differ cachedDiffer;
    private MutableVector<Modifier.Element> current;
    private Modifier.Node head;
    private final androidx.compose.ui.node.InnerNodeCoordinator innerCoordinator;
    private final androidx.compose.ui.node.LayoutNode layoutNode;
    private androidx.compose.ui.node.NodeChain.Logger logger;
    private androidx.compose.ui.node.NodeCoordinator outerCoordinator;
    private final Modifier.Node tail;

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0017\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0082\u0004\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0018\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0018\u0010&\u001a\u00020#2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016R \u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R \u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u000e\"\u0004\u0008\u0012\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001e¨\u0006'", d2 = {"Landroidx/compose/ui/node/NodeChain$Differ;", "Landroidx/compose/ui/node/DiffCallback;", "node", "Landroidx/compose/ui/Modifier$Node;", "offset", "", "before", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "after", "shouldAttachOnInsert", "", "(Landroidx/compose/ui/node/NodeChain;Landroidx/compose/ui/Modifier$Node;ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/runtime/collection/MutableVector;Z)V", "getAfter", "()Landroidx/compose/runtime/collection/MutableVector;", "setAfter", "(Landroidx/compose/runtime/collection/MutableVector;)V", "getBefore", "setBefore", "getNode", "()Landroidx/compose/ui/Modifier$Node;", "setNode", "(Landroidx/compose/ui/Modifier$Node;)V", "getOffset", "()I", "setOffset", "(I)V", "getShouldAttachOnInsert", "()Z", "setShouldAttachOnInsert", "(Z)V", "areItemsTheSame", "oldIndex", "newIndex", "insert", "", "remove", "atIndex", "same", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class Differ implements androidx.compose.ui.node.DiffCallback {

        private MutableVector<Modifier.Element> after;
        private MutableVector<Modifier.Element> before;
        private Modifier.Node node;
        private int offset;
        private boolean shouldAttachOnInsert;
        final androidx.compose.ui.node.NodeChain this$0;
        public Differ(androidx.compose.ui.node.NodeChain this$0, Modifier.Node node, int offset, MutableVector before, MutableVector after, boolean shouldAttachOnInsert) {
            this.this$0 = this$0;
            super();
            this.node = node;
            this.offset = offset;
            this.before = before;
            this.after = after;
            this.shouldAttachOnInsert = shouldAttachOnInsert;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public boolean areItemsTheSame(int oldIndex, int newIndex) {
            int i;
            int i3 = 0;
            int i5 = 0;
            i = NodeChainKt.actionForModifiers((Modifier.Element)this.before.getContent()[offset += oldIndex], (Modifier.Element)this.after.getContent()[offset2 += newIndex]) != 0 ? 1 : 0;
            return i;
        }

        public final MutableVector<Modifier.Element> getAfter() {
            return this.after;
        }

        public final MutableVector<Modifier.Element> getBefore() {
            return this.before;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public final Modifier.Node getNode() {
            return this.node;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public final int getOffset() {
            return this.offset;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public final boolean getShouldAttachOnInsert() {
            return this.shouldAttachOnInsert;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void insert(int newIndex) {
            Object this_$iv;
            Object coordinator$ui_release;
            int layoutModifierNode;
            int node2;
            Object layoutModifierNodeCoordinator;
            Object[] content;
            Modifier.Node node;
            androidx.compose.ui.node.LayoutModifierNodeCoordinator layoutModifierNodeCoordinator2;
            final int i = offset + newIndex;
            final Modifier.Node node9 = this.node;
            node2 = 0;
            this.node = NodeChain.access$createAndInsertNodeAsChild(this.this$0, (Modifier.Element)this.after.getContent()[i], node9);
            androidx.compose.ui.node.NodeChain.Logger logger = NodeChain.access$getLogger$p(this.this$0);
            if (logger != null) {
                int i2 = 0;
                logger.nodeInserted(i, i, (Modifier.Element)this.after.getContent()[i], node9, this.node);
            }
            if (this.shouldAttachOnInsert) {
                Modifier.Node child$ui_release = this.node.getChild$ui_release();
                Intrinsics.checkNotNull(child$ui_release);
                coordinator$ui_release = child$ui_release.getCoordinator$ui_release();
                Intrinsics.checkNotNull(coordinator$ui_release);
                layoutModifierNode = DelegatableNodeKt.asLayoutModifierNode(this.node);
                if (layoutModifierNode != null) {
                    layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(this.this$0.getLayoutNode(), layoutModifierNode);
                    this.node.updateCoordinator$ui_release((NodeCoordinator)layoutModifierNodeCoordinator);
                    NodeChain.access$propagateCoordinator(this.this$0, this.node, (NodeCoordinator)layoutModifierNodeCoordinator);
                    layoutModifierNodeCoordinator.setWrappedBy$ui_release(coordinator$ui_release.getWrappedBy$ui_release());
                    layoutModifierNodeCoordinator.setWrapped$ui_release(coordinator$ui_release);
                    coordinator$ui_release.setWrappedBy$ui_release((NodeCoordinator)layoutModifierNodeCoordinator);
                } else {
                    this.node.updateCoordinator$ui_release(coordinator$ui_release);
                }
                this.node.markAsAttached$ui_release();
                this.node.runAttachLifecycle$ui_release();
                NodeKindKt.autoInvalidateInsertedNode(this.node);
            } else {
                this.node.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
            }
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void remove(int atIndex, int oldIndex) {
            int $i$f$getLayoutOLwlOKw;
            Object this_$iv;
            Object wrappedBy$ui_release;
            int i;
            int wrapped$ui_release;
            int i2;
            int this$0;
            Object[] content;
            Modifier.Node child$ui_release = this.node.getChild$ui_release();
            Intrinsics.checkNotNull(child$ui_release);
            androidx.compose.ui.node.NodeChain.Logger logger = NodeChain.access$getLogger$p(this.this$0);
            if (logger != null) {
                i2 = 0;
                logger.nodeRemoved(oldIndex, (Modifier.Element)this.before.getContent()[offset += oldIndex], child$ui_release);
            }
            int i3 = 0;
            wrapped$ui_release = 0;
            this$0 = kindSet$ui_release &= $i$f$getLayoutOLwlOKw != 0 ? 1 : 0;
            if (this$0 != 0) {
                $i$f$getLayoutOLwlOKw = child$ui_release.getCoordinator$ui_release();
                Intrinsics.checkNotNull($i$f$getLayoutOLwlOKw);
                wrappedBy$ui_release = $i$f$getLayoutOLwlOKw.getWrappedBy$ui_release();
                wrapped$ui_release = $i$f$getLayoutOLwlOKw.getWrapped$ui_release();
                Intrinsics.checkNotNull(wrapped$ui_release);
                if (wrappedBy$ui_release == null) {
                } else {
                    wrappedBy$ui_release.setWrapped$ui_release(wrapped$ui_release);
                }
                wrapped$ui_release.setWrappedBy$ui_release(wrappedBy$ui_release);
                NodeChain.access$propagateCoordinator(this.this$0, this.node, wrapped$ui_release);
            }
            this.node = NodeChain.access$detachAndRemoveNode(this.this$0, child$ui_release);
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void same(int oldIndex, int newIndex) {
            androidx.compose.ui.node.NodeChain offset;
            androidx.compose.ui.node.NodeChain.Logger logger;
            int i;
            Object[] content;
            Modifier.Node node;
            Modifier.Node child$ui_release = this.node.getChild$ui_release();
            Intrinsics.checkNotNull(child$ui_release);
            this.node = child$ui_release;
            int i4 = 0;
            final Object obj = this_$iv;
            i = 0;
            final Object obj2 = this_$iv2;
            if (!Intrinsics.areEqual((Modifier.Element)obj, (Modifier.Element)obj2)) {
                NodeChain.access$updateNode(this.this$0, obj, obj2, this.node);
                logger = NodeChain.access$getLogger$p(this.this$0);
                if (logger != null) {
                    logger.nodeUpdated(offset3 + oldIndex, offset + newIndex, obj, obj2, this.node);
                }
            } else {
                logger = NodeChain.access$getLogger$p(this.this$0);
                if (logger != null) {
                    logger.nodeReused(offset2 + oldIndex, offset + newIndex, obj, obj2, this.node);
                }
            }
        }

        public final void setAfter(MutableVector<Modifier.Element> <set-?>) {
            this.after = <set-?>;
        }

        public final void setBefore(MutableVector<Modifier.Element> <set-?>) {
            this.before = <set-?>;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public final void setNode(Modifier.Node <set-?>) {
            this.node = <set-?>;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public final void setOffset(int <set-?>) {
            this.offset = <set-?>;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public final void setShouldAttachOnInsert(boolean <set-?>) {
            this.shouldAttachOnInsert = <set-?>;
        }
    }

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0015À\u0006\u0001", d2 = {"Landroidx/compose/ui/node/NodeChain$Logger;", "", "linearDiffAborted", "", "index", "", "prev", "Landroidx/compose/ui/Modifier$Element;", "next", "node", "Landroidx/compose/ui/Modifier$Node;", "nodeInserted", "atIndex", "newIndex", "element", "child", "inserted", "nodeRemoved", "oldIndex", "nodeReused", "nodeUpdated", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Logger {
        public abstract void linearDiffAborted(int i, Modifier.Element modifier$Element2, Modifier.Element modifier$Element3, Modifier.Node modifier$Node4);

        public abstract void nodeInserted(int i, int i2, Modifier.Element modifier$Element3, Modifier.Node modifier$Node4, Modifier.Node modifier$Node5);

        public abstract void nodeRemoved(int i, Modifier.Element modifier$Element2, Modifier.Node modifier$Node3);

        public abstract void nodeReused(int i, int i2, Modifier.Element modifier$Element3, Modifier.Element modifier$Element4, Modifier.Node modifier$Node5);

        public abstract void nodeUpdated(int i, int i2, Modifier.Element modifier$Element3, Modifier.Element modifier$Element4, Modifier.Node modifier$Node5);
    }
    static {
        final int i = 8;
    }

    public NodeChain(androidx.compose.ui.node.LayoutNode layoutNode) {
        super();
        this.layoutNode = layoutNode;
        InnerNodeCoordinator innerNodeCoordinator = new InnerNodeCoordinator(this.layoutNode);
        this.innerCoordinator = innerNodeCoordinator;
        this.outerCoordinator = (NodeCoordinator)this.innerCoordinator;
        this.tail = (Modifier.Node)this.innerCoordinator.getTail();
        this.head = this.tail;
    }

    public static final Modifier.Node access$createAndInsertNodeAsChild(androidx.compose.ui.node.NodeChain $this, Modifier.Element element, Modifier.Node parent) {
        return $this.createAndInsertNodeAsChild(element, parent);
    }

    public static final Modifier.Node access$detachAndRemoveNode(androidx.compose.ui.node.NodeChain $this, Modifier.Node node) {
        return $this.detachAndRemoveNode(node);
    }

    public static final int access$getAggregateChildKindSet(androidx.compose.ui.node.NodeChain $this) {
        return $this.getAggregateChildKindSet();
    }

    public static final androidx.compose.ui.node.NodeChain.Logger access$getLogger$p(androidx.compose.ui.node.NodeChain $this) {
        return $this.logger;
    }

    public static final void access$propagateCoordinator(androidx.compose.ui.node.NodeChain $this, Modifier.Node start, androidx.compose.ui.node.NodeCoordinator coordinator) {
        $this.propagateCoordinator(start, coordinator);
    }

    public static final void access$updateNode(androidx.compose.ui.node.NodeChain $this, Modifier.Element prev, Modifier.Element next, Modifier.Node node) {
        $this.updateNode(prev, next, node);
    }

    private final Modifier.Node createAndInsertNodeAsChild(Modifier.Element element, Modifier.Node parent) {
        Modifier.Node backwardsCompatNode;
        Modifier.Node node;
        int i;
        int nodeKindSetFromIncludingDelegates;
        String $i$a$CheckPreconditionNodeChain$createAndInsertNodeAsChild$1;
        if (element instanceof ModifierNodeElement) {
            node = backwardsCompatNode;
            i = 0;
            node.setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node));
        } else {
            backwardsCompatNode = new BackwardsCompatNode(element);
        }
        int i3 = 1;
        int i4 = 0;
        if (attached ^= i3 == 0) {
            int i5 = 0;
            InlineClassHelperKt.throwIllegalStateException("A ModifierNodeElement cannot return an already attached node from create() ");
        }
        backwardsCompatNode.setInsertedNodeAwaitingAttachForInvalidation$ui_release(i3);
        return insertChild(backwardsCompatNode, parent);
    }

    private final Modifier.Node createAndInsertNodeAsParent(Modifier.Element element, Modifier.Node child) {
        Modifier.Node backwardsCompatNode;
        Modifier.Node node;
        int i;
        int nodeKindSetFromIncludingDelegates;
        String $i$a$CheckPreconditionNodeChain$createAndInsertNodeAsParent$1;
        if (element instanceof ModifierNodeElement) {
            node = backwardsCompatNode;
            i = 0;
            node.setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node));
        } else {
            backwardsCompatNode = new BackwardsCompatNode(element);
        }
        int i3 = 1;
        int i4 = 0;
        if (attached ^= i3 == 0) {
            int i5 = 0;
            InlineClassHelperKt.throwIllegalStateException("createAndInsertNodeAsParent called on an attached node");
        }
        backwardsCompatNode.setInsertedNodeAwaitingAttachForInvalidation$ui_release(i3);
        return insertParent(backwardsCompatNode, child);
    }

    private final Modifier.Node detachAndRemoveNode(Modifier.Node node) {
        if (node.isAttached()) {
            NodeKindKt.autoInvalidateRemovedNode(node);
            node.runDetachLifecycle$ui_release();
            node.markAsDetached$ui_release();
        }
        return removeNode(node);
    }

    private final int getAggregateChildKindSet() {
        return this.head.getAggregateChildKindSet$ui_release();
    }

    private final androidx.compose.ui.node.NodeChain.Differ getDiffer(Modifier.Node head, int offset, MutableVector<Modifier.Element> before, MutableVector<Modifier.Element> after, boolean shouldAttachOnInsert) {
        androidx.compose.ui.node.NodeChain.Differ differ;
        Object obj;
        Modifier.Node node;
        int i;
        MutableVector mutableVector2;
        MutableVector mutableVector;
        boolean z;
        androidx.compose.ui.node.NodeChain.Differ obj9;
        int obj10;
        final androidx.compose.ui.node.NodeChain.Differ cachedDiffer = this.cachedDiffer;
        if (cachedDiffer == null) {
            obj = this;
            differ = new NodeChain.Differ(obj, head, offset, before, after, shouldAttachOnInsert);
            obj10 = 0;
            obj.cachedDiffer = differ;
        } else {
            obj = this;
            obj9 = cachedDiffer;
            obj10 = 0;
            obj9.setNode(head);
            obj9.setOffset(offset);
            obj9.setBefore(before);
            obj9.setAfter(after);
            obj9.setShouldAttachOnInsert(shouldAttachOnInsert);
            differ = cachedDiffer;
        }
        return differ;
    }

    private final Modifier.Node insertChild(Modifier.Node node, Modifier.Node parent) {
        final Modifier.Node child$ui_release = parent.getChild$ui_release();
        if (child$ui_release != null) {
            child$ui_release.setParent$ui_release(node);
            node.setChild$ui_release(child$ui_release);
        }
        parent.setChild$ui_release(node);
        node.setParent$ui_release(parent);
        return node;
    }

    private final Modifier.Node insertParent(Modifier.Node node, Modifier.Node child) {
        final Modifier.Node parent$ui_release = child.getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.setChild$ui_release(node);
            node.setParent$ui_release(parent$ui_release);
        }
        child.setParent$ui_release(node);
        node.setChild$ui_release(child);
        return node;
    }

    private final boolean isUpdating() {
        int i;
        i = this.head == NodeChainKt.access$getSentinelHead$p() ? 1 : 0;
        return i;
    }

    private final Modifier.Node padChain() {
        int i;
        String $i$a$CheckPreconditionNodeChain$padChain$1;
        i = this.head != NodeChainKt.access$getSentinelHead$p() ? 1 : 0;
        int i2 = 0;
        if (i == 0) {
            int i3 = 0;
            InlineClassHelperKt.throwIllegalStateException("padChain called on already padded chain");
        }
        Modifier.Node value$iv = this.head;
        value$iv.setParent$ui_release((Modifier.Node)NodeChainKt.access$getSentinelHead$p());
        NodeChainKt.access$getSentinelHead$p().setChild$ui_release(value$iv);
        return (Modifier.Node)NodeChainKt.access$getSentinelHead$p();
    }

    private final void propagateCoordinator(Modifier.Node start, androidx.compose.ui.node.NodeCoordinator coordinator) {
        Modifier.Node node;
        int $i$f$getLayoutOLwlOKw;
        Modifier.Node node2;
        int i2;
        int i;
        node = start.getParent$ui_release();
        while (node != null) {
            if (node == NodeChainKt.access$getSentinelHead$p()) {
                break;
            } else {
            }
            int i3 = 0;
            i2 = 0;
            if (kindSet$ui_release &= $i$f$getLayoutOLwlOKw != 0) {
            } else {
            }
            i = 0;
            if (i == 0) {
                break;
            }
            node.updateCoordinator$ui_release(coordinator);
            node = node.getParent$ui_release();
            i = 1;
        }
    }

    private final Modifier.Node removeNode(Modifier.Node node) {
        final Modifier.Node child$ui_release = node.getChild$ui_release();
        final Modifier.Node parent$ui_release = node.getParent$ui_release();
        final int i = 0;
        if (child$ui_release != null) {
            child$ui_release.setParent$ui_release(parent$ui_release);
            node.setChild$ui_release(i);
        }
        if (parent$ui_release != null) {
            parent$ui_release.setChild$ui_release(child$ui_release);
            node.setParent$ui_release(i);
        }
        Intrinsics.checkNotNull(parent$ui_release);
        return parent$ui_release;
    }

    private final void structuralUpdate(int offset, MutableVector<Modifier.Element> before, MutableVector<Modifier.Element> after, Modifier.Node tail, boolean shouldAttachOnInsert) {
        final int i = offset;
        final MutableVector mutableVector = before;
        final MutableVector mutableVector2 = after;
        MyersDiffKt.executeDiff(obj8 -= i, obj9 -= i, (DiffCallback)this.getDiffer(tail, i, mutableVector, mutableVector2, shouldAttachOnInsert));
        syncAggregateChildKindSet();
    }

    private final void syncAggregateChildKindSet() {
        Modifier.Node node;
        int aggregateChildKindSet;
        int kindSet$ui_release;
        node = this.tail.getParent$ui_release();
        aggregateChildKindSet = 0;
        while (node != null) {
            if (node != NodeChainKt.access$getSentinelHead$p()) {
            }
            node.setAggregateChildKindSet$ui_release(aggregateChildKindSet |= kindSet$ui_release);
            node = node.getParent$ui_release();
        }
    }

    private final Modifier.Node trimChain(Modifier.Node paddedHead) {
        int i;
        Modifier.Node child$ui_release;
        int i2;
        Object $i$a$CheckPreconditionNodeChain$trimChain$2;
        String $i$a$CheckPreconditionNodeChain$trimChain$1;
        int i3 = 0;
        i = paddedHead == NodeChainKt.access$getSentinelHead$p() ? i2 : i3;
        int i5 = 0;
        if (i == 0) {
            int i8 = 0;
            InlineClassHelperKt.throwIllegalStateException("trimChain called on already trimmed chain");
        }
        if (NodeChainKt.access$getSentinelHead$p().getChild$ui_release() == null) {
            child$ui_release = this.tail;
        }
        int i6 = 0;
        child$ui_release.setParent$ui_release(i6);
        NodeChainKt.access$getSentinelHead$p().setChild$ui_release(i6);
        NodeChainKt.access$getSentinelHead$p().setAggregateChildKindSet$ui_release(-1);
        NodeChainKt.access$getSentinelHead$p().updateCoordinator$ui_release(i6);
        if (child$ui_release != NodeChainKt.access$getSentinelHead$p()) {
        } else {
            i2 = i3;
        }
        int i4 = 0;
        if (i2 == 0) {
            int i7 = 0;
            InlineClassHelperKt.throwIllegalStateException("trimChain did not update the head");
        }
        return child$ui_release;
    }

    private final void updateNode(Modifier.Element prev, Modifier.Element next, Modifier.Node node) {
        boolean attached;
        boolean z;
        int i = 1;
        if (prev instanceof ModifierNodeElement && next instanceof ModifierNodeElement) {
            if (next instanceof ModifierNodeElement) {
                NodeChainKt.access$updateUnsafe((ModifierNodeElement)next, node);
                if (node.isAttached()) {
                    NodeKindKt.autoInvalidateUpdatedNode(node);
                } else {
                    node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(i);
                }
            } else {
                if (!node instanceof BackwardsCompatNode) {
                } else {
                    (BackwardsCompatNode)node.setElement(next);
                    if (node.isAttached()) {
                        NodeKindKt.autoInvalidateUpdatedNode(node);
                    } else {
                        node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(i);
                    }
                }
            }
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Unknown Modifier.Node type".toString());
        throw illegalStateException;
    }

    public final <T> T firstFromHead-aLcG6gQ$ui_release(int type, Function1<? super T, Boolean> block) {
        int $i$f$firstFromHeadALcG6gQ$ui_release2;
        androidx.compose.ui.node.NodeChain count$iv$iv2;
        Modifier.Node count$iv$iv;
        int i12;
        int $i$a$HeadToTailALcG6gQ$ui_releaseNodeChain$firstFromHead$1;
        int node$iv$iv;
        int node$iv$iv2;
        Modifier.Node[] mask$iv$iv;
        androidx.compose.ui.node.NodeChain nodeChain2;
        int this_$iv$iv;
        int i11;
        int i2;
        Modifier.Node node$iv$iv$iv2;
        Modifier.Node node;
        int i3;
        int i8;
        int i7;
        Modifier.Node node3;
        int i;
        int stack$iv$iv;
        int $i$f$firstFromHeadALcG6gQ$ui_release;
        androidx.compose.ui.node.NodeChain this_$iv;
        int i5;
        int $i$f$isKindH91voCI$ui_release;
        boolean booleanValue;
        int i9;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i6;
        int this_$iv$iv$iv;
        int i10;
        int i4;
        Modifier.Node[] mask$iv$iv2;
        androidx.compose.ui.node.NodeChain nodeChain;
        Modifier.Node node4;
        count$iv$iv2 = this;
        mask$iv$iv = type;
        nodeChain2 = count$iv$iv2;
        final int i19 = 0;
        if (i20 &= mask$iv$iv != 0) {
            i2 = 0;
            node$iv$iv$iv2 = nodeChain2.getHead$ui_release();
            while (node$iv$iv$iv2 != null) {
                node = node$iv$iv$iv2;
                i3 = 0;
                if (kindSet$ui_release &= mask$iv$iv == 0) {
                    break;
                } else {
                }
                $i$f$firstFromHeadALcG6gQ$ui_release = $i$f$firstFromHeadALcG6gQ$ui_release2;
                this_$iv = count$iv$iv2;
                i5 = i12;
                mask$iv$iv2 = mask$iv$iv;
                nodeChain = nodeChain2;
                if (aggregateChildKindSet$ui_release &= mask$iv$iv2 != 0) {
                    break;
                }
                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                $i$f$firstFromHeadALcG6gQ$ui_release2 = $i$f$firstFromHeadALcG6gQ$ui_release;
                count$iv$iv2 = this_$iv;
                i12 = i5;
                mask$iv$iv = mask$iv$iv2;
                nodeChain2 = nodeChain;
                i7 = 0;
                i = 0;
                stack$iv$iv = 0;
                int i21 = 0;
                $i$f$firstFromHeadALcG6gQ$ui_release = $i$f$firstFromHeadALcG6gQ$ui_release2;
                $i$f$firstFromHeadALcG6gQ$ui_release2 = node4;
                while ($i$f$firstFromHeadALcG6gQ$ui_release2 != null) {
                    this_$iv = count$iv$iv2;
                    i5 = i12;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    $i$a$HeadToTailALcG6gQ$ui_releaseNodeChain$firstFromHead$1 = block;
                    count$iv$iv = $i$f$firstFromHeadALcG6gQ$ui_release2;
                    int i22 = 0;
                    i9 = count$iv$iv;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    if ($i$f$isKindH91voCI$ui_release != 0 && $i$f$firstFromHeadALcG6gQ$ui_release2 instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv$iv2 = mask$iv$iv;
                    nodeChain = nodeChain2;
                    $i$f$firstFromHeadALcG6gQ$ui_release2 = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv);
                    count$iv$iv2 = this_$iv;
                    i12 = i5;
                    mask$iv$iv = mask$iv$iv2;
                    nodeChain2 = nodeChain;
                    if ($i$f$firstFromHeadALcG6gQ$ui_release2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    i9 = 0;
                    node$iv$iv$iv = (DelegatingNode)$i$f$firstFromHeadALcG6gQ$ui_release2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                        Modifier.Node node$iv$iv3 = node$iv$iv$iv;
                        i6 = 0;
                        i10 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        mask$iv$iv2 = mask$iv$iv;
                        nodeChain = nodeChain2;
                        this_$iv$iv = 0;
                        node$iv$iv2 = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $i$f$firstFromHeadALcG6gQ$ui_release2 = node$iv$iv2;
                        mask$iv$iv = mask$iv$iv2;
                        nodeChain2 = nodeChain;
                        $i$a$HeadToTailALcG6gQ$ui_releaseNodeChain$firstFromHead$1 = block;
                        count$iv$iv++;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if ((MutableVector)stack$iv$iv == 0) {
                        } else {
                        }
                        this_$iv$iv$iv = count$iv$iv;
                        mask$iv$iv2 = mask$iv$iv;
                        nodeChain = nodeChain2;
                        this_$iv$iv = 0;
                        stack$iv$iv = node$iv$iv;
                        Modifier.Node node5 = node2;
                        if ((Modifier.Node)node5 != null) {
                        } else {
                        }
                        node$iv$iv2 = node2;
                        mask$iv$iv = stack$iv$iv;
                        if ((MutableVector)mask$iv$iv != 0) {
                        }
                        count$iv$iv = this_$iv$iv$iv;
                        (MutableVector)mask$iv$iv.add(node$iv$iv3);
                        int i18 = stack$iv$iv;
                        if ((MutableVector)i18 != 0) {
                        }
                        node$iv$iv2 = 0;
                        (MutableVector)i18.add((Modifier.Node)node5);
                        this_$iv$iv$iv = count$iv$iv;
                        i10 = 0;
                        i4 = i17;
                        mask$iv$iv2 = mask$iv$iv;
                        nodeChain = nodeChain2;
                        node$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                        count$iv$iv = node$iv$iv;
                        node$iv$iv2 = node$iv$iv3;
                        mask$iv$iv2 = mask$iv$iv;
                        nodeChain = nodeChain2;
                        this_$iv$iv = 0;
                        this_$iv$iv$iv = 1;
                    }
                    node2 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    $i$f$firstFromHeadALcG6gQ$ui_release2 = node2;
                    count$iv$iv2 = this_$iv;
                    i12 = i5;
                    $i$f$firstFromHeadALcG6gQ$ui_release2 = node2;
                    mask$iv$iv = mask$iv$iv2;
                    nodeChain2 = nodeChain;
                    node2 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                    node$iv$iv3 = node$iv$iv$iv;
                    i6 = 0;
                    i10 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    mask$iv$iv2 = mask$iv$iv;
                    nodeChain = nodeChain2;
                    this_$iv$iv = 0;
                    node$iv$iv2 = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $i$f$firstFromHeadALcG6gQ$ui_release2 = node$iv$iv2;
                    mask$iv$iv = mask$iv$iv2;
                    nodeChain2 = nodeChain;
                    $i$a$HeadToTailALcG6gQ$ui_releaseNodeChain$firstFromHead$1 = block;
                    count$iv$iv++;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if ((MutableVector)stack$iv$iv == 0) {
                    } else {
                    }
                    this_$iv$iv$iv = count$iv$iv;
                    mask$iv$iv2 = mask$iv$iv;
                    nodeChain = nodeChain2;
                    this_$iv$iv = 0;
                    stack$iv$iv = node$iv$iv;
                    node5 = node2;
                    if ((Modifier.Node)node5 != null) {
                    } else {
                    }
                    node$iv$iv2 = node2;
                    mask$iv$iv = stack$iv$iv;
                    if ((MutableVector)mask$iv$iv != 0) {
                    }
                    count$iv$iv = this_$iv$iv$iv;
                    (MutableVector)mask$iv$iv.add(node$iv$iv3);
                    i18 = stack$iv$iv;
                    if ((MutableVector)i18 != 0) {
                    }
                    node$iv$iv2 = 0;
                    (MutableVector)i18.add((Modifier.Node)node5);
                    this_$iv$iv$iv = count$iv$iv;
                    i10 = 0;
                    i4 = i17;
                    mask$iv$iv2 = mask$iv$iv;
                    nodeChain = nodeChain2;
                    node$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                    count$iv$iv = node$iv$iv;
                    node$iv$iv2 = node$iv$iv3;
                    mask$iv$iv2 = mask$iv$iv;
                    nodeChain = nodeChain2;
                    this_$iv$iv = 0;
                    this_$iv$iv$iv = 1;
                    $i$f$isKindH91voCI$ui_release = 1;
                    count$iv$iv = $i$f$firstFromHeadALcG6gQ$ui_release2;
                    $i$f$isKindH91voCI$ui_release = i15;
                    mask$iv$iv2 = mask$iv$iv;
                    nodeChain = nodeChain2;
                }
                this_$iv = count$iv$iv2;
                i5 = i12;
                mask$iv$iv2 = mask$iv$iv;
                nodeChain = nodeChain2;
                this_$iv = count$iv$iv2;
                i5 = i12;
                Intrinsics.reifiedOperationMarker(3, "T");
                $i$a$HeadToTailALcG6gQ$ui_releaseNodeChain$firstFromHead$1 = block;
                count$iv$iv = $i$f$firstFromHeadALcG6gQ$ui_release2;
                i22 = 0;
                i9 = count$iv$iv;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                $i$f$isKindH91voCI$ui_release = 0;
                if ($i$f$isKindH91voCI$ui_release != 0 && $i$f$firstFromHeadALcG6gQ$ui_release2 instanceof DelegatingNode) {
                } else {
                }
                mask$iv$iv2 = mask$iv$iv;
                nodeChain = nodeChain2;
                $i$f$firstFromHeadALcG6gQ$ui_release2 = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv);
                count$iv$iv2 = this_$iv;
                i12 = i5;
                mask$iv$iv = mask$iv$iv2;
                nodeChain2 = nodeChain;
                if ($i$f$firstFromHeadALcG6gQ$ui_release2 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                i9 = 0;
                node$iv$iv$iv = (DelegatingNode)$i$f$firstFromHeadALcG6gQ$ui_release2.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node2 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                    node$iv$iv3 = node$iv$iv$iv;
                    i6 = 0;
                    i10 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    mask$iv$iv2 = mask$iv$iv;
                    nodeChain = nodeChain2;
                    this_$iv$iv = 0;
                    node$iv$iv2 = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $i$f$firstFromHeadALcG6gQ$ui_release2 = node$iv$iv2;
                    mask$iv$iv = mask$iv$iv2;
                    nodeChain2 = nodeChain;
                    $i$a$HeadToTailALcG6gQ$ui_releaseNodeChain$firstFromHead$1 = block;
                    count$iv$iv++;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if ((MutableVector)stack$iv$iv == 0) {
                    } else {
                    }
                    this_$iv$iv$iv = count$iv$iv;
                    mask$iv$iv2 = mask$iv$iv;
                    nodeChain = nodeChain2;
                    this_$iv$iv = 0;
                    stack$iv$iv = node$iv$iv;
                    node5 = node2;
                    if ((Modifier.Node)node5 != null) {
                    } else {
                    }
                    node$iv$iv2 = node2;
                    mask$iv$iv = stack$iv$iv;
                    if ((MutableVector)mask$iv$iv != 0) {
                    }
                    count$iv$iv = this_$iv$iv$iv;
                    (MutableVector)mask$iv$iv.add(node$iv$iv3);
                    i18 = stack$iv$iv;
                    if ((MutableVector)i18 != 0) {
                    }
                    node$iv$iv2 = 0;
                    (MutableVector)i18.add((Modifier.Node)node5);
                    this_$iv$iv$iv = count$iv$iv;
                    i10 = 0;
                    i4 = i17;
                    mask$iv$iv2 = mask$iv$iv;
                    nodeChain = nodeChain2;
                    node$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                    count$iv$iv = node$iv$iv;
                    node$iv$iv2 = node$iv$iv3;
                    mask$iv$iv2 = mask$iv$iv;
                    nodeChain = nodeChain2;
                    this_$iv$iv = 0;
                    this_$iv$iv$iv = 1;
                }
                node2 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                if (count$iv$iv == 1) {
                } else {
                }
                $i$f$firstFromHeadALcG6gQ$ui_release2 = node2;
                count$iv$iv2 = this_$iv;
                i12 = i5;
                $i$f$firstFromHeadALcG6gQ$ui_release2 = node2;
                mask$iv$iv = mask$iv$iv2;
                nodeChain2 = nodeChain;
                node2 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                node$iv$iv3 = node$iv$iv$iv;
                i6 = 0;
                i10 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                mask$iv$iv2 = mask$iv$iv;
                nodeChain = nodeChain2;
                this_$iv$iv = 0;
                node$iv$iv2 = node2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $i$f$firstFromHeadALcG6gQ$ui_release2 = node$iv$iv2;
                mask$iv$iv = mask$iv$iv2;
                nodeChain2 = nodeChain;
                $i$a$HeadToTailALcG6gQ$ui_releaseNodeChain$firstFromHead$1 = block;
                count$iv$iv++;
                if (count$iv$iv == 1) {
                } else {
                }
                if ((MutableVector)stack$iv$iv == 0) {
                } else {
                }
                this_$iv$iv$iv = count$iv$iv;
                mask$iv$iv2 = mask$iv$iv;
                nodeChain = nodeChain2;
                this_$iv$iv = 0;
                stack$iv$iv = node$iv$iv;
                node5 = node2;
                if ((Modifier.Node)node5 != null) {
                } else {
                }
                node$iv$iv2 = node2;
                mask$iv$iv = stack$iv$iv;
                if ((MutableVector)mask$iv$iv != 0) {
                }
                count$iv$iv = this_$iv$iv$iv;
                (MutableVector)mask$iv$iv.add(node$iv$iv3);
                i18 = stack$iv$iv;
                if ((MutableVector)i18 != 0) {
                }
                node$iv$iv2 = 0;
                (MutableVector)i18.add((Modifier.Node)node5);
                this_$iv$iv$iv = count$iv$iv;
                i10 = 0;
                i4 = i17;
                mask$iv$iv2 = mask$iv$iv;
                nodeChain = nodeChain2;
                node$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                count$iv$iv = node$iv$iv;
                node$iv$iv2 = node$iv$iv3;
                mask$iv$iv2 = mask$iv$iv;
                nodeChain = nodeChain2;
                this_$iv$iv = 0;
                this_$iv$iv$iv = 1;
                $i$f$isKindH91voCI$ui_release = 1;
                count$iv$iv = $i$f$firstFromHeadALcG6gQ$ui_release2;
                $i$f$isKindH91voCI$ui_release = i15;
                mask$iv$iv2 = mask$iv$iv;
                nodeChain = nodeChain2;
            }
            $i$f$firstFromHeadALcG6gQ$ui_release = $i$f$firstFromHeadALcG6gQ$ui_release2;
            this_$iv = count$iv$iv2;
            i5 = i12;
            mask$iv$iv2 = mask$iv$iv;
            nodeChain = nodeChain2;
        } else {
            $i$f$firstFromHeadALcG6gQ$ui_release = $i$f$firstFromHeadALcG6gQ$ui_release2;
            this_$iv = count$iv$iv2;
            i5 = i12;
            mask$iv$iv2 = mask$iv$iv;
            nodeChain = nodeChain2;
        }
        return 0;
    }

    public final Modifier.Node getHead$ui_release() {
        return this.head;
    }

    public final androidx.compose.ui.node.InnerNodeCoordinator getInnerCoordinator$ui_release() {
        return this.innerCoordinator;
    }

    public final androidx.compose.ui.node.LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public final List<ModifierInfo> getModifierInfo() {
        Object coordinator$ui_release2;
        int i4;
        androidx.compose.ui.node.OwnedLayer ownedLayer;
        int i3;
        int i7;
        Object coordinator$ui_release3;
        Modifier.Node node$iv;
        Modifier.Node tail$ui_release;
        int i5;
        androidx.compose.ui.node.NodeCoordinator coordinator$ui_release;
        androidx.compose.ui.node.OwnedLayer layer;
        androidx.compose.ui.node.OwnedLayer layer2;
        int i2;
        int i;
        int i6;
        Object[] content;
        MutableVector current = coordinator$ui_release2.current;
        if (current == null) {
            return CollectionsKt.emptyList();
        }
        int i9 = 0;
        MutableVector mutableVector2 = new MutableVector(new ModifierInfo[current.getSize()], 0);
        i3 = 0;
        Object obj = this;
        int i10 = 0;
        node$iv = obj.getHead$ui_release();
        while (node$iv != null) {
            tail$ui_release = node$iv;
            i5 = 0;
            coordinator$ui_release = tail$ui_release.getCoordinator$ui_release();
            layer = coordinator$ui_release.getLayer();
            androidx.compose.ui.node.OwnedLayer ownedLayer2 = layer2;
            int i11 = 0;
            Modifier.Node child$ui_release = tail$ui_release.getChild$ui_release();
            if (child$ui_release == coordinator$ui_release2.tail && tail$ui_release.getCoordinator$ui_release() != child$ui_release.getCoordinator$ui_release()) {
            } else {
            }
            i4 = 0;
            if (i4 != 0) {
            } else {
            }
            layer2 = 0;
            if (layer == null) {
            } else {
            }
            ownedLayer = layer;
            i6 = 0;
            ModifierInfo modifierInfo = new ModifierInfo((Modifier)current.getContent()[i3], (LayoutCoordinates)coordinator$ui_release, ownedLayer);
            i = 0;
            mutableVector2.add(modifierInfo);
            node$iv = node$iv.getChild$ui_release();
            i7 = 0;
            coordinator$ui_release2 = this;
            i3 = i2;
            ownedLayer = layer2;
            if (tail$ui_release.getCoordinator$ui_release() != child$ui_release.getCoordinator$ui_release()) {
            } else {
            }
            i4 = 1;
        }
        return mutableVector2.asMutableList();
    }

    public final androidx.compose.ui.node.NodeCoordinator getOuterCoordinator$ui_release() {
        return this.outerCoordinator;
    }

    public final Modifier.Node getTail$ui_release() {
        return this.tail;
    }

    public final boolean has$ui_release(int mask) {
        int i;
        i = aggregateChildKindSet &= mask != 0 ? 1 : 0;
        return i;
    }

    public final boolean has-H91voCI$ui_release(int type) {
        int i;
        i = aggregateChildKindSet &= type != 0 ? 1 : 0;
        return i;
    }

    public final <T> T head-H91voCI$ui_release(int type) {
        int $i$f$headH91voCI$ui_release;
        int capacity$iv$iv$iv$iv;
        androidx.compose.ui.node.NodeChain nodeChain;
        Modifier.Node it;
        int count$iv$iv3;
        int $i$f$isKindH91voCI$ui_release;
        MutableVector count$iv$iv2;
        MutableVector node$iv$iv;
        int i4;
        int i5;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i10;
        int i2;
        int i11;
        Modifier.Node node;
        int i;
        int stack$iv$iv;
        int $i$f$headH91voCI$ui_release2;
        androidx.compose.ui.node.NodeChain this_$iv;
        int i7;
        Modifier.Node node3;
        int i3;
        Modifier.Node node$iv$iv$iv2;
        int i8;
        Modifier.Node node5;
        int this_$iv$iv$iv;
        int i9;
        int i6;
        int count$iv$iv;
        MutableVector mask$iv$iv;
        int i12;
        Modifier.Node node4;
        nodeChain = this;
        node$iv$iv = type;
        final androidx.compose.ui.node.NodeChain nodeChain2 = nodeChain;
        final int i18 = 0;
        if (i19 &= node$iv$iv != 0) {
            i5 = 0;
            node$iv$iv$iv = nodeChain2.getHead$ui_release();
            while (node$iv$iv$iv != null) {
                node2 = node$iv$iv$iv;
                i10 = 0;
                if (kindSet$ui_release &= node$iv$iv == 0) {
                    break;
                } else {
                }
                $i$f$headH91voCI$ui_release2 = $i$f$headH91voCI$ui_release;
                this_$iv = nodeChain;
                i7 = count$iv$iv3;
                mask$iv$iv = node$iv$iv;
                if (aggregateChildKindSet$ui_release &= mask$iv$iv != 0) {
                    break;
                }
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $i$f$headH91voCI$ui_release = $i$f$headH91voCI$ui_release2;
                nodeChain = this_$iv;
                count$iv$iv3 = i7;
                node$iv$iv = mask$iv$iv;
                i11 = 0;
                i = 0;
                stack$iv$iv = 0;
                int i20 = 0;
                $i$f$headH91voCI$ui_release2 = $i$f$headH91voCI$ui_release;
                $i$f$headH91voCI$ui_release = node4;
                while ($i$f$headH91voCI$ui_release != null) {
                    this_$iv = nodeChain;
                    i7 = count$iv$iv3;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    it = $i$f$headH91voCI$ui_release;
                    int i16 = 0;
                    i3 = it;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    if ($i$f$isKindH91voCI$ui_release != 0 && $i$f$headH91voCI$ui_release instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv$iv = node$iv$iv;
                    $i$f$headH91voCI$ui_release = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv);
                    nodeChain = this_$iv;
                    count$iv$iv3 = i7;
                    node$iv$iv = mask$iv$iv;
                    if ($i$f$headH91voCI$ui_release instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    i3 = 0;
                    node$iv$iv$iv2 = (DelegatingNode)$i$f$headH91voCI$ui_release.getDelegate$ui_release();
                    while (node$iv$iv$iv2 != null) {
                        it = node$iv$iv$iv2;
                        i8 = 0;
                        i9 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        node5 = $i$f$headH91voCI$ui_release;
                        mask$iv$iv = node$iv$iv;
                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                        node$iv$iv = mask$iv$iv;
                        $i$f$isKindH91voCI$ui_release++;
                        node5 = $i$f$headH91voCI$ui_release;
                        if ($i$f$isKindH91voCI$ui_release == 1) {
                        } else {
                        }
                        int node$iv$iv4 = stack$iv$iv;
                        if ((MutableVector)node$iv$iv4 == 0) {
                        } else {
                        }
                        count$iv$iv = $i$f$isKindH91voCI$ui_release;
                        mask$iv$iv = node$iv$iv;
                        count$iv$iv2 = node$iv$iv4;
                        capacity$iv$iv$iv$iv = 0;
                        stack$iv$iv = count$iv$iv2;
                        Modifier.Node node7 = node5;
                        if ((Modifier.Node)node7 != null) {
                        } else {
                        }
                        node$iv$iv = node5;
                        MutableVector mutableVector = stack$iv$iv;
                        if ((MutableVector)mutableVector != null) {
                        }
                        $i$f$headH91voCI$ui_release = node$iv$iv;
                        $i$f$isKindH91voCI$ui_release = count$iv$iv;
                        (MutableVector)mutableVector.add(it);
                        MutableVector mutableVector2 = stack$iv$iv;
                        if ((MutableVector)mutableVector2 != null) {
                        }
                        node$iv$iv = 0;
                        (MutableVector)mutableVector2.add((Modifier.Node)node7);
                        i9 = i13;
                        int $i$f$mutableVectorOf = 16;
                        i6 = 0;
                        count$iv$iv = $i$f$isKindH91voCI$ui_release;
                        mask$iv$iv = node$iv$iv;
                        i12 = $i$f$mutableVectorOf;
                        count$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv = count$iv$iv2;
                        $i$f$headH91voCI$ui_release = it;
                        mask$iv$iv = node$iv$iv;
                        this_$iv$iv$iv = 1;
                    }
                    node5 = $i$f$headH91voCI$ui_release;
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    $i$f$headH91voCI$ui_release = node5;
                    nodeChain = this_$iv;
                    count$iv$iv3 = i7;
                    $i$f$headH91voCI$ui_release = node5;
                    node$iv$iv = mask$iv$iv;
                    it = node$iv$iv$iv2;
                    i8 = 0;
                    i9 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    node5 = $i$f$headH91voCI$ui_release;
                    mask$iv$iv = node$iv$iv;
                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                    node$iv$iv = mask$iv$iv;
                    $i$f$isKindH91voCI$ui_release++;
                    node5 = $i$f$headH91voCI$ui_release;
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    node$iv$iv4 = stack$iv$iv;
                    if ((MutableVector)(MutableVector)node$iv$iv4 == 0) {
                    } else {
                    }
                    count$iv$iv = $i$f$isKindH91voCI$ui_release;
                    mask$iv$iv = node$iv$iv;
                    count$iv$iv2 = node$iv$iv4;
                    capacity$iv$iv$iv$iv = 0;
                    stack$iv$iv = count$iv$iv2;
                    node7 = node5;
                    if ((Modifier.Node)node7 != null) {
                    } else {
                    }
                    node$iv$iv = node5;
                    mutableVector = stack$iv$iv;
                    if ((MutableVector)mutableVector != null) {
                    }
                    $i$f$headH91voCI$ui_release = node$iv$iv;
                    $i$f$isKindH91voCI$ui_release = count$iv$iv;
                    (MutableVector)mutableVector.add(it);
                    mutableVector2 = stack$iv$iv;
                    if ((MutableVector)mutableVector2 != null) {
                    }
                    node$iv$iv = 0;
                    (MutableVector)mutableVector2.add((Modifier.Node)node7);
                    i9 = i13;
                    $i$f$mutableVectorOf = 16;
                    i6 = 0;
                    count$iv$iv = $i$f$isKindH91voCI$ui_release;
                    mask$iv$iv = node$iv$iv;
                    i12 = $i$f$mutableVectorOf;
                    count$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv = count$iv$iv2;
                    $i$f$headH91voCI$ui_release = it;
                    mask$iv$iv = node$iv$iv;
                    this_$iv$iv$iv = 1;
                    $i$f$isKindH91voCI$ui_release = 1;
                }
                this_$iv = nodeChain;
                i7 = count$iv$iv3;
                mask$iv$iv = node$iv$iv;
                this_$iv = nodeChain;
                i7 = count$iv$iv3;
                Intrinsics.reifiedOperationMarker(3, "T");
                it = $i$f$headH91voCI$ui_release;
                i16 = 0;
                i3 = it;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                $i$f$isKindH91voCI$ui_release = 0;
                if ($i$f$isKindH91voCI$ui_release != 0 && $i$f$headH91voCI$ui_release instanceof DelegatingNode) {
                } else {
                }
                mask$iv$iv = node$iv$iv;
                $i$f$headH91voCI$ui_release = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv);
                nodeChain = this_$iv;
                count$iv$iv3 = i7;
                node$iv$iv = mask$iv$iv;
                if ($i$f$headH91voCI$ui_release instanceof DelegatingNode) {
                } else {
                }
                $i$f$isKindH91voCI$ui_release = 0;
                i3 = 0;
                node$iv$iv$iv2 = (DelegatingNode)$i$f$headH91voCI$ui_release.getDelegate$ui_release();
                while (node$iv$iv$iv2 != null) {
                    it = node$iv$iv$iv2;
                    i8 = 0;
                    i9 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    node5 = $i$f$headH91voCI$ui_release;
                    mask$iv$iv = node$iv$iv;
                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                    node$iv$iv = mask$iv$iv;
                    $i$f$isKindH91voCI$ui_release++;
                    node5 = $i$f$headH91voCI$ui_release;
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    node$iv$iv4 = stack$iv$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)node$iv$iv4 == 0) {
                    } else {
                    }
                    count$iv$iv = $i$f$isKindH91voCI$ui_release;
                    mask$iv$iv = node$iv$iv;
                    count$iv$iv2 = node$iv$iv4;
                    capacity$iv$iv$iv$iv = 0;
                    stack$iv$iv = count$iv$iv2;
                    node7 = node5;
                    if ((Modifier.Node)node7 != null) {
                    } else {
                    }
                    node$iv$iv = node5;
                    mutableVector = stack$iv$iv;
                    if ((MutableVector)mutableVector != null) {
                    }
                    $i$f$headH91voCI$ui_release = node$iv$iv;
                    $i$f$isKindH91voCI$ui_release = count$iv$iv;
                    (MutableVector)mutableVector.add(it);
                    mutableVector2 = stack$iv$iv;
                    if ((MutableVector)mutableVector2 != null) {
                    }
                    node$iv$iv = 0;
                    (MutableVector)mutableVector2.add((Modifier.Node)node7);
                    i9 = i13;
                    $i$f$mutableVectorOf = 16;
                    i6 = 0;
                    count$iv$iv = $i$f$isKindH91voCI$ui_release;
                    mask$iv$iv = node$iv$iv;
                    i12 = $i$f$mutableVectorOf;
                    count$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv = count$iv$iv2;
                    $i$f$headH91voCI$ui_release = it;
                    mask$iv$iv = node$iv$iv;
                    this_$iv$iv$iv = 1;
                }
                node5 = $i$f$headH91voCI$ui_release;
                if ($i$f$isKindH91voCI$ui_release == 1) {
                } else {
                }
                $i$f$headH91voCI$ui_release = node5;
                nodeChain = this_$iv;
                count$iv$iv3 = i7;
                $i$f$headH91voCI$ui_release = node5;
                node$iv$iv = mask$iv$iv;
                it = node$iv$iv$iv2;
                i8 = 0;
                i9 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                node5 = $i$f$headH91voCI$ui_release;
                mask$iv$iv = node$iv$iv;
                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                node$iv$iv = mask$iv$iv;
                $i$f$isKindH91voCI$ui_release++;
                node5 = $i$f$headH91voCI$ui_release;
                if ($i$f$isKindH91voCI$ui_release == 1) {
                } else {
                }
                node$iv$iv4 = stack$iv$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)node$iv$iv4 == 0) {
                } else {
                }
                count$iv$iv = $i$f$isKindH91voCI$ui_release;
                mask$iv$iv = node$iv$iv;
                count$iv$iv2 = node$iv$iv4;
                capacity$iv$iv$iv$iv = 0;
                stack$iv$iv = count$iv$iv2;
                node7 = node5;
                if ((Modifier.Node)node7 != null) {
                } else {
                }
                node$iv$iv = node5;
                mutableVector = stack$iv$iv;
                if ((MutableVector)mutableVector != null) {
                }
                $i$f$headH91voCI$ui_release = node$iv$iv;
                $i$f$isKindH91voCI$ui_release = count$iv$iv;
                (MutableVector)mutableVector.add(it);
                mutableVector2 = stack$iv$iv;
                if ((MutableVector)mutableVector2 != null) {
                }
                node$iv$iv = 0;
                (MutableVector)mutableVector2.add((Modifier.Node)node7);
                i9 = i13;
                $i$f$mutableVectorOf = 16;
                i6 = 0;
                count$iv$iv = $i$f$isKindH91voCI$ui_release;
                mask$iv$iv = node$iv$iv;
                i12 = $i$f$mutableVectorOf;
                count$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv = count$iv$iv2;
                $i$f$headH91voCI$ui_release = it;
                mask$iv$iv = node$iv$iv;
                this_$iv$iv$iv = 1;
                $i$f$isKindH91voCI$ui_release = 1;
            }
            $i$f$headH91voCI$ui_release2 = $i$f$headH91voCI$ui_release;
            this_$iv = nodeChain;
            i7 = count$iv$iv3;
            mask$iv$iv = node$iv$iv;
        } else {
            $i$f$headH91voCI$ui_release2 = $i$f$headH91voCI$ui_release;
            this_$iv = nodeChain;
            i7 = count$iv$iv3;
            mask$iv$iv = node$iv$iv;
        }
        return 0;
    }

    public final void headToTail$ui_release(int mask, Function1<? super Modifier.Node, Unit> block) {
        Modifier.Node node$iv;
        Modifier.Node node;
        int i2;
        int i;
        final int i3 = 0;
        if (i4 &= mask == 0) {
        }
        final int i6 = 0;
        node$iv = this.getHead$ui_release();
        while (node$iv != null) {
            node = node$iv;
            i2 = 0;
            if (kindSet$ui_release &= mask != 0) {
            }
            node$iv = node$iv.getChild$ui_release();
            block.invoke(node);
        }
    }

    public final void headToTail$ui_release(Function1<? super Modifier.Node, Unit> block) {
        Modifier.Node node;
        final int i = 0;
        node = getHead$ui_release();
        while (node != null) {
            block.invoke(node);
            node = node.getChild$ui_release();
        }
    }

    public final <T> void headToTail-aLcG6gQ$ui_release(int type, Function1<? super T, Unit> block) {
        int i5;
        Modifier.Node node2;
        int mask$iv2;
        int mask$iv3;
        androidx.compose.ui.node.NodeChain nodeChain;
        MutableVector this_$iv2;
        int i10;
        androidx.compose.ui.node.NodeChain i13;
        int i14;
        Modifier.Node node$iv$iv2;
        Modifier.Node node;
        int i2;
        int i3;
        int i;
        Modifier.Node node4;
        int i11;
        int stack$iv;
        Modifier.Node node$iv;
        int this_$iv$iv2;
        int $i$f$headToTailALcG6gQ$ui_release;
        Modifier.Node node3;
        int i9;
        Modifier.Node node$iv$iv;
        int i6;
        int mask$iv;
        int this_$iv$iv;
        int i8;
        int i12;
        androidx.compose.ui.node.NodeChain this_$iv;
        int i7;
        int i4;
        mask$iv2 = type;
        nodeChain = this;
        if (i18 &= mask$iv2 != 0) {
            i14 = 0;
            node$iv$iv2 = nodeChain.getHead$ui_release();
            while (node$iv$iv2 != null) {
                node = node$iv$iv2;
                i2 = 0;
                if (kindSet$ui_release &= mask$iv2 != 0) {
                } else {
                }
                $i$f$headToTailALcG6gQ$ui_release = i5;
                mask$iv = mask$iv2;
                this_$iv = nodeChain;
                i7 = i10;
                if (aggregateChildKindSet$ui_release &= mask$iv != 0) {
                    break;
                }
                node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                i5 = $i$f$headToTailALcG6gQ$ui_release;
                mask$iv2 = mask$iv;
                nodeChain = this_$iv;
                i10 = i7;
                i = 0;
                i11 = 0;
                stack$iv = 0;
                int i19 = 0;
                node$iv = node4;
                while (node$iv != null) {
                    $i$f$headToTailALcG6gQ$ui_release = i5;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (node$iv instanceof Object != null) {
                    } else {
                    }
                    node2 = block;
                    node3 = 0;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    if (this_$iv$iv2 != 0 && node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv = mask$iv2;
                    this_$iv = nodeChain;
                    i7 = i10;
                    node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                    i5 = $i$f$headToTailALcG6gQ$ui_release;
                    mask$iv2 = mask$iv;
                    nodeChain = this_$iv;
                    i10 = i7;
                    if (node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    i9 = 0;
                    node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        node2 = node$iv$iv;
                        i6 = 0;
                        i8 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv = 0;
                        if (this_$iv$iv != 0) {
                        } else {
                        }
                        mask$iv = mask$iv2;
                        this_$iv = nodeChain;
                        i7 = i10;
                        mask$iv3 = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        mask$iv2 = mask$iv;
                        nodeChain = this_$iv;
                        i10 = i7;
                        mask$iv = mask$iv2;
                        if (this_$iv$iv2++ == 1) {
                        } else {
                        }
                        int i16 = stack$iv;
                        if ((MutableVector)i16 == 0) {
                        } else {
                        }
                        this_$iv = nodeChain;
                        i7 = i10;
                        this_$iv2 = i16;
                        mask$iv3 = 0;
                        stack$iv = this_$iv2;
                        nodeChain = node$iv;
                        MutableVector mutableVector = stack$iv;
                        if ((Modifier.Node)nodeChain != null && (MutableVector)mutableVector != null) {
                        }
                        i10 = stack$iv;
                        if ((MutableVector)i10 != null) {
                        }
                        (MutableVector)i10.add(node2);
                        mutableVector = stack$iv;
                        if ((MutableVector)(MutableVector)mutableVector != null) {
                        }
                        node$iv = i10;
                        (MutableVector)(MutableVector)mutableVector.add((Modifier.Node)nodeChain);
                        i8 = i17;
                        int $i$f$mutableVectorOf = 16;
                        i12 = 0;
                        this_$iv = nodeChain;
                        i7 = i10;
                        i4 = $i$f$mutableVectorOf;
                        this_$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        i10 = this_$iv2;
                        node$iv = node2;
                        this_$iv = nodeChain;
                        i7 = i10;
                        mask$iv3 = 0;
                        this_$iv$iv = 1;
                    }
                    if (this_$iv$iv2 == 1) {
                    } else {
                    }
                    i5 = $i$f$headToTailALcG6gQ$ui_release;
                    mask$iv2 = mask$iv;
                    nodeChain = this_$iv;
                    i10 = i7;
                    node2 = node$iv$iv;
                    i6 = 0;
                    i8 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    mask$iv = mask$iv2;
                    this_$iv = nodeChain;
                    i7 = i10;
                    mask$iv3 = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    mask$iv2 = mask$iv;
                    nodeChain = this_$iv;
                    i10 = i7;
                    mask$iv = mask$iv2;
                    if (this_$iv$iv2++ == 1) {
                    } else {
                    }
                    i16 = stack$iv;
                    if ((MutableVector)(MutableVector)i16 == 0) {
                    } else {
                    }
                    this_$iv = nodeChain;
                    i7 = i10;
                    this_$iv2 = i16;
                    mask$iv3 = 0;
                    stack$iv = this_$iv2;
                    nodeChain = node$iv;
                    mutableVector = stack$iv;
                    if ((Modifier.Node)nodeChain != null && (MutableVector)mutableVector != null) {
                    }
                    i10 = stack$iv;
                    if ((MutableVector)i10 != null) {
                    }
                    (MutableVector)i10.add(node2);
                    mutableVector = stack$iv;
                    if ((MutableVector)(MutableVector)mutableVector != null) {
                    }
                    node$iv = i10;
                    (MutableVector)(MutableVector)mutableVector.add((Modifier.Node)nodeChain);
                    i8 = i17;
                    $i$f$mutableVectorOf = 16;
                    i12 = 0;
                    this_$iv = nodeChain;
                    i7 = i10;
                    i4 = $i$f$mutableVectorOf;
                    this_$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i10 = this_$iv2;
                    node$iv = node2;
                    this_$iv = nodeChain;
                    i7 = i10;
                    mask$iv3 = 0;
                    this_$iv$iv = 1;
                    this_$iv$iv2 = 1;
                    block.invoke(node$iv);
                    mask$iv = mask$iv2;
                    this_$iv = nodeChain;
                    i7 = i10;
                }
                $i$f$headToTailALcG6gQ$ui_release = i5;
                mask$iv = mask$iv2;
                this_$iv = nodeChain;
                i7 = i10;
                $i$f$headToTailALcG6gQ$ui_release = i5;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (node$iv instanceof Object != null) {
                } else {
                }
                node2 = block;
                node3 = 0;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                this_$iv$iv2 = 0;
                if (this_$iv$iv2 != 0 && node$iv instanceof DelegatingNode) {
                } else {
                }
                mask$iv = mask$iv2;
                this_$iv = nodeChain;
                i7 = i10;
                node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                i5 = $i$f$headToTailALcG6gQ$ui_release;
                mask$iv2 = mask$iv;
                nodeChain = this_$iv;
                i10 = i7;
                if (node$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv2 = 0;
                i9 = 0;
                node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                while (node$iv$iv != null) {
                    node2 = node$iv$iv;
                    i6 = 0;
                    i8 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    mask$iv = mask$iv2;
                    this_$iv = nodeChain;
                    i7 = i10;
                    mask$iv3 = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    mask$iv2 = mask$iv;
                    nodeChain = this_$iv;
                    i10 = i7;
                    mask$iv = mask$iv2;
                    if (this_$iv$iv2++ == 1) {
                    } else {
                    }
                    i16 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)i16 == 0) {
                    } else {
                    }
                    this_$iv = nodeChain;
                    i7 = i10;
                    this_$iv2 = i16;
                    mask$iv3 = 0;
                    stack$iv = this_$iv2;
                    nodeChain = node$iv;
                    mutableVector = stack$iv;
                    if ((Modifier.Node)nodeChain != null && (MutableVector)mutableVector != null) {
                    }
                    i10 = stack$iv;
                    if ((MutableVector)i10 != null) {
                    }
                    (MutableVector)i10.add(node2);
                    mutableVector = stack$iv;
                    if ((MutableVector)(MutableVector)mutableVector != null) {
                    }
                    node$iv = i10;
                    (MutableVector)(MutableVector)mutableVector.add((Modifier.Node)nodeChain);
                    i8 = i17;
                    $i$f$mutableVectorOf = 16;
                    i12 = 0;
                    this_$iv = nodeChain;
                    i7 = i10;
                    i4 = $i$f$mutableVectorOf;
                    this_$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i10 = this_$iv2;
                    node$iv = node2;
                    this_$iv = nodeChain;
                    i7 = i10;
                    mask$iv3 = 0;
                    this_$iv$iv = 1;
                }
                if (this_$iv$iv2 == 1) {
                } else {
                }
                i5 = $i$f$headToTailALcG6gQ$ui_release;
                mask$iv2 = mask$iv;
                nodeChain = this_$iv;
                i10 = i7;
                node2 = node$iv$iv;
                i6 = 0;
                i8 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0) {
                } else {
                }
                mask$iv = mask$iv2;
                this_$iv = nodeChain;
                i7 = i10;
                mask$iv3 = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                mask$iv2 = mask$iv;
                nodeChain = this_$iv;
                i10 = i7;
                mask$iv = mask$iv2;
                if (this_$iv$iv2++ == 1) {
                } else {
                }
                i16 = stack$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)i16 == 0) {
                } else {
                }
                this_$iv = nodeChain;
                i7 = i10;
                this_$iv2 = i16;
                mask$iv3 = 0;
                stack$iv = this_$iv2;
                nodeChain = node$iv;
                mutableVector = stack$iv;
                if ((Modifier.Node)nodeChain != null && (MutableVector)mutableVector != null) {
                }
                i10 = stack$iv;
                if ((MutableVector)i10 != null) {
                }
                (MutableVector)i10.add(node2);
                mutableVector = stack$iv;
                if ((MutableVector)(MutableVector)mutableVector != null) {
                }
                node$iv = i10;
                (MutableVector)(MutableVector)mutableVector.add((Modifier.Node)nodeChain);
                i8 = i17;
                $i$f$mutableVectorOf = 16;
                i12 = 0;
                this_$iv = nodeChain;
                i7 = i10;
                i4 = $i$f$mutableVectorOf;
                this_$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i10 = this_$iv2;
                node$iv = node2;
                this_$iv = nodeChain;
                i7 = i10;
                mask$iv3 = 0;
                this_$iv$iv = 1;
                this_$iv$iv2 = 1;
                block.invoke(node$iv);
                mask$iv = mask$iv2;
                this_$iv = nodeChain;
                i7 = i10;
            }
            $i$f$headToTailALcG6gQ$ui_release = i5;
            mask$iv = mask$iv2;
            this_$iv = nodeChain;
            i7 = i10;
        } else {
            $i$f$headToTailALcG6gQ$ui_release = i5;
            mask$iv = mask$iv2;
            this_$iv = nodeChain;
            i7 = i10;
        }
    }

    public final void headToTailExclusive$ui_release(Function1<? super Modifier.Node, Unit> block) {
        Modifier.Node node;
        Modifier.Node tail$ui_release;
        final int i = 0;
        node = getHead$ui_release();
        while (node != null) {
            if (node != getTail$ui_release()) {
            }
            block.invoke(node);
            node = node.getChild$ui_release();
        }
    }

    public final void markAsAttached() {
        Modifier.Node node$iv;
        Modifier.Node node;
        int i;
        final int i2 = 0;
        node$iv = this.getHead$ui_release();
        while (node$iv != null) {
            i = 0;
            node$iv.markAsAttached$ui_release();
            node$iv = node$iv.getChild$ui_release();
        }
    }

    public final void markAsDetached$ui_release() {
        Modifier.Node node$iv;
        Modifier.Node node;
        int i;
        boolean attached;
        final int i2 = 0;
        node$iv = this.getTail$ui_release();
        while (node$iv != null) {
            node = node$iv;
            i = 0;
            if (node.isAttached()) {
            }
            node$iv = node$iv.getParent$ui_release();
            node.markAsDetached$ui_release();
        }
    }

    public final void resetState$ui_release() {
        Modifier.Node node$iv;
        Modifier.Node node;
        int i;
        boolean attached;
        final int i2 = 0;
        node$iv = this.getTail$ui_release();
        while (node$iv != null) {
            node = node$iv;
            i = 0;
            if (node.isAttached()) {
            }
            node$iv = node$iv.getParent$ui_release();
            node.reset$ui_release();
        }
        runDetachLifecycle$ui_release();
        markAsDetached$ui_release();
    }

    public final void runAttachLifecycle() {
        Modifier.Node node$iv;
        Modifier.Node node;
        int i2;
        int i;
        final int i3 = 0;
        node$iv = this.getHead$ui_release();
        while (node$iv != null) {
            node = node$iv;
            i2 = 0;
            node.runAttachLifecycle$ui_release();
            if (node.getInsertedNodeAwaitingAttachForInvalidation$ui_release()) {
            }
            if (node.getUpdatedNodeAwaitingAttachForInvalidation$ui_release()) {
            }
            i = 0;
            node.setInsertedNodeAwaitingAttachForInvalidation$ui_release(i);
            node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(i);
            node$iv = node$iv.getChild$ui_release();
            NodeKindKt.autoInvalidateUpdatedNode(node);
            NodeKindKt.autoInvalidateInsertedNode(node);
        }
    }

    public final void runDetachLifecycle$ui_release() {
        Modifier.Node node$iv;
        Modifier.Node node;
        int i;
        boolean attached;
        final int i2 = 0;
        node$iv = this.getTail$ui_release();
        while (node$iv != null) {
            node = node$iv;
            i = 0;
            if (node.isAttached()) {
            }
            node$iv = node$iv.getParent$ui_release();
            node.runDetachLifecycle$ui_release();
        }
    }

    public final void syncCoordinators() {
        androidx.compose.ui.node.InnerNodeCoordinator coordinator;
        Modifier.Node node;
        androidx.compose.ui.node.LayoutModifierNode layoutModifierNode;
        androidx.compose.ui.node.NodeCoordinator innerCoordinator$ui_release;
        androidx.compose.ui.node.NodeCoordinator layoutModifierNodeCoordinator;
        androidx.compose.ui.node.NodeCoordinator nodeCoordinator;
        Object layoutModifierNode2;
        coordinator = this.innerCoordinator;
        node = this.tail.getParent$ui_release();
        while (node != null) {
            layoutModifierNode = DelegatableNodeKt.asLayoutModifierNode(node);
            if (layoutModifierNode != null) {
            } else {
            }
            node.updateCoordinator$ui_release(coordinator);
            node = node.getParent$ui_release();
            if (node.getCoordinator$ui_release() != null) {
            } else {
            }
            layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(this.layoutNode, layoutModifierNode);
            node.updateCoordinator$ui_release((NodeCoordinator)layoutModifierNodeCoordinator);
            coordinator.setWrappedBy$ui_release((NodeCoordinator)layoutModifierNodeCoordinator);
            layoutModifierNodeCoordinator.setWrapped$ui_release(coordinator);
            coordinator = layoutModifierNodeCoordinator;
            layoutModifierNodeCoordinator = node.getCoordinator$ui_release();
            Intrinsics.checkNotNull(layoutModifierNodeCoordinator, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            layoutModifierNodeCoordinator.setLayoutModifierNode$ui_release(layoutModifierNode);
            if ((LayoutModifierNodeCoordinator)layoutModifierNodeCoordinator.getLayoutModifierNode() != node) {
            }
            layoutModifierNodeCoordinator.onLayoutModifierNodeChanged();
        }
        androidx.compose.ui.node.LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        if (parent$ui_release != null) {
            innerCoordinator$ui_release = parent$ui_release.getInnerCoordinator$ui_release();
        } else {
            innerCoordinator$ui_release = 0;
        }
        coordinator.setWrappedBy$ui_release(innerCoordinator$ui_release);
        this.outerCoordinator = coordinator;
    }

    public final <T> T tail-H91voCI$ui_release(int type) {
        int $i$f$tailH91voCI$ui_release;
        int capacity$iv$iv$iv$iv;
        androidx.compose.ui.node.NodeChain nodeChain;
        Modifier.Node it;
        int count$iv$iv3;
        int $i$f$isKindH91voCI$ui_release;
        MutableVector count$iv$iv;
        MutableVector node$iv$iv;
        int i12;
        int i;
        Modifier.Node node$iv$iv$iv2;
        Modifier.Node node2;
        int i9;
        int i8;
        int i2;
        Modifier.Node node4;
        int i13;
        int stack$iv$iv;
        int $i$f$tailH91voCI$ui_release2;
        int $i$f$tailH91voCI$ui_release3;
        androidx.compose.ui.node.NodeChain nodeChain2;
        androidx.compose.ui.node.NodeChain this_$iv;
        int i4;
        int i11;
        Modifier.Node node;
        int i3;
        Modifier.Node node$iv$iv$iv;
        int i6;
        Modifier.Node node3;
        int this_$iv$iv$iv;
        int i5;
        int i7;
        int count$iv$iv2;
        MutableVector mutableVector;
        MutableVector mask$iv$iv;
        int i10;
        Modifier.Node node5;
        nodeChain = this;
        node$iv$iv = type;
        final androidx.compose.ui.node.NodeChain nodeChain3 = nodeChain;
        final int i19 = 0;
        if (i20 &= node$iv$iv != 0) {
            i = 0;
            node$iv$iv$iv2 = nodeChain3.getTail$ui_release();
            while (node$iv$iv$iv2 != null) {
                node2 = node$iv$iv$iv2;
                i9 = 0;
                if (kindSet$ui_release &= node$iv$iv != 0) {
                } else {
                }
                $i$f$tailH91voCI$ui_release3 = $i$f$tailH91voCI$ui_release;
                this_$iv = nodeChain;
                i11 = count$iv$iv3;
                mask$iv$iv = node$iv$iv;
                node$iv$iv$iv2 = node$iv$iv$iv2.getParent$ui_release();
                $i$f$tailH91voCI$ui_release = $i$f$tailH91voCI$ui_release3;
                nodeChain = this_$iv;
                count$iv$iv3 = i11;
                node$iv$iv = mask$iv$iv;
                i2 = 0;
                i13 = 0;
                stack$iv$iv = 0;
                int i21 = 0;
                $i$f$tailH91voCI$ui_release3 = $i$f$tailH91voCI$ui_release;
                $i$f$tailH91voCI$ui_release = node5;
                while ($i$f$tailH91voCI$ui_release != null) {
                    this_$iv = nodeChain;
                    i11 = count$iv$iv3;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    it = $i$f$tailH91voCI$ui_release;
                    int i17 = 0;
                    i3 = it;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    if ($i$f$isKindH91voCI$ui_release != 0 && $i$f$tailH91voCI$ui_release instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv$iv = node$iv$iv;
                    $i$f$tailH91voCI$ui_release = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv);
                    nodeChain = this_$iv;
                    count$iv$iv3 = i11;
                    node$iv$iv = mask$iv$iv;
                    if ($i$f$tailH91voCI$ui_release instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    i3 = 0;
                    node$iv$iv$iv = (DelegatingNode)$i$f$tailH91voCI$ui_release.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        it = node$iv$iv$iv;
                        i6 = 0;
                        i5 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        node3 = $i$f$tailH91voCI$ui_release;
                        mask$iv$iv = node$iv$iv;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        node$iv$iv = mask$iv$iv;
                        $i$f$isKindH91voCI$ui_release++;
                        node3 = $i$f$tailH91voCI$ui_release;
                        if ($i$f$isKindH91voCI$ui_release == 1) {
                        } else {
                        }
                        int node$iv$iv4 = stack$iv$iv;
                        if ((MutableVector)node$iv$iv4 == 0) {
                        } else {
                        }
                        count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                        mask$iv$iv = node$iv$iv;
                        count$iv$iv = node$iv$iv4;
                        capacity$iv$iv$iv$iv = 0;
                        stack$iv$iv = count$iv$iv;
                        Modifier.Node node7 = node3;
                        if ((Modifier.Node)node7 != null) {
                        } else {
                        }
                        node$iv$iv = node3;
                        MutableVector mutableVector2 = stack$iv$iv;
                        if ((MutableVector)mutableVector2 != null) {
                        }
                        $i$f$tailH91voCI$ui_release = node$iv$iv;
                        $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                        (MutableVector)mutableVector2.add(it);
                        MutableVector mutableVector3 = stack$iv$iv;
                        if ((MutableVector)mutableVector3 != null) {
                        }
                        node$iv$iv = 0;
                        (MutableVector)mutableVector3.add((Modifier.Node)node7);
                        i5 = i15;
                        int $i$f$mutableVectorOf = 16;
                        i7 = 0;
                        count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                        mask$iv$iv = node$iv$iv;
                        i10 = $i$f$mutableVectorOf;
                        count$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv = count$iv$iv;
                        $i$f$tailH91voCI$ui_release = it;
                        mask$iv$iv = node$iv$iv;
                        this_$iv$iv$iv = 1;
                    }
                    node3 = $i$f$tailH91voCI$ui_release;
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    $i$f$tailH91voCI$ui_release = node3;
                    nodeChain = this_$iv;
                    count$iv$iv3 = i11;
                    $i$f$tailH91voCI$ui_release = node3;
                    node$iv$iv = mask$iv$iv;
                    it = node$iv$iv$iv;
                    i6 = 0;
                    i5 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    node3 = $i$f$tailH91voCI$ui_release;
                    mask$iv$iv = node$iv$iv;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    node$iv$iv = mask$iv$iv;
                    $i$f$isKindH91voCI$ui_release++;
                    node3 = $i$f$tailH91voCI$ui_release;
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    node$iv$iv4 = stack$iv$iv;
                    if ((MutableVector)(MutableVector)node$iv$iv4 == 0) {
                    } else {
                    }
                    count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                    mask$iv$iv = node$iv$iv;
                    count$iv$iv = node$iv$iv4;
                    capacity$iv$iv$iv$iv = 0;
                    stack$iv$iv = count$iv$iv;
                    node7 = node3;
                    if ((Modifier.Node)node7 != null) {
                    } else {
                    }
                    node$iv$iv = node3;
                    mutableVector2 = stack$iv$iv;
                    if ((MutableVector)mutableVector2 != null) {
                    }
                    $i$f$tailH91voCI$ui_release = node$iv$iv;
                    $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                    (MutableVector)mutableVector2.add(it);
                    mutableVector3 = stack$iv$iv;
                    if ((MutableVector)mutableVector3 != null) {
                    }
                    node$iv$iv = 0;
                    (MutableVector)mutableVector3.add((Modifier.Node)node7);
                    i5 = i15;
                    $i$f$mutableVectorOf = 16;
                    i7 = 0;
                    count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                    mask$iv$iv = node$iv$iv;
                    i10 = $i$f$mutableVectorOf;
                    count$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv = count$iv$iv;
                    $i$f$tailH91voCI$ui_release = it;
                    mask$iv$iv = node$iv$iv;
                    this_$iv$iv$iv = 1;
                    $i$f$isKindH91voCI$ui_release = 1;
                }
                this_$iv = nodeChain;
                i11 = count$iv$iv3;
                mask$iv$iv = node$iv$iv;
                this_$iv = nodeChain;
                i11 = count$iv$iv3;
                Intrinsics.reifiedOperationMarker(3, "T");
                it = $i$f$tailH91voCI$ui_release;
                i17 = 0;
                i3 = it;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                $i$f$isKindH91voCI$ui_release = 0;
                if ($i$f$isKindH91voCI$ui_release != 0 && $i$f$tailH91voCI$ui_release instanceof DelegatingNode) {
                } else {
                }
                mask$iv$iv = node$iv$iv;
                $i$f$tailH91voCI$ui_release = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv);
                nodeChain = this_$iv;
                count$iv$iv3 = i11;
                node$iv$iv = mask$iv$iv;
                if ($i$f$tailH91voCI$ui_release instanceof DelegatingNode) {
                } else {
                }
                $i$f$isKindH91voCI$ui_release = 0;
                i3 = 0;
                node$iv$iv$iv = (DelegatingNode)$i$f$tailH91voCI$ui_release.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    it = node$iv$iv$iv;
                    i6 = 0;
                    i5 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    node3 = $i$f$tailH91voCI$ui_release;
                    mask$iv$iv = node$iv$iv;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    node$iv$iv = mask$iv$iv;
                    $i$f$isKindH91voCI$ui_release++;
                    node3 = $i$f$tailH91voCI$ui_release;
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    node$iv$iv4 = stack$iv$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)node$iv$iv4 == 0) {
                    } else {
                    }
                    count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                    mask$iv$iv = node$iv$iv;
                    count$iv$iv = node$iv$iv4;
                    capacity$iv$iv$iv$iv = 0;
                    stack$iv$iv = count$iv$iv;
                    node7 = node3;
                    if ((Modifier.Node)node7 != null) {
                    } else {
                    }
                    node$iv$iv = node3;
                    mutableVector2 = stack$iv$iv;
                    if ((MutableVector)mutableVector2 != null) {
                    }
                    $i$f$tailH91voCI$ui_release = node$iv$iv;
                    $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                    (MutableVector)mutableVector2.add(it);
                    mutableVector3 = stack$iv$iv;
                    if ((MutableVector)mutableVector3 != null) {
                    }
                    node$iv$iv = 0;
                    (MutableVector)mutableVector3.add((Modifier.Node)node7);
                    i5 = i15;
                    $i$f$mutableVectorOf = 16;
                    i7 = 0;
                    count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                    mask$iv$iv = node$iv$iv;
                    i10 = $i$f$mutableVectorOf;
                    count$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv = count$iv$iv;
                    $i$f$tailH91voCI$ui_release = it;
                    mask$iv$iv = node$iv$iv;
                    this_$iv$iv$iv = 1;
                }
                node3 = $i$f$tailH91voCI$ui_release;
                if ($i$f$isKindH91voCI$ui_release == 1) {
                } else {
                }
                $i$f$tailH91voCI$ui_release = node3;
                nodeChain = this_$iv;
                count$iv$iv3 = i11;
                $i$f$tailH91voCI$ui_release = node3;
                node$iv$iv = mask$iv$iv;
                it = node$iv$iv$iv;
                i6 = 0;
                i5 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                node3 = $i$f$tailH91voCI$ui_release;
                mask$iv$iv = node$iv$iv;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                node$iv$iv = mask$iv$iv;
                $i$f$isKindH91voCI$ui_release++;
                node3 = $i$f$tailH91voCI$ui_release;
                if ($i$f$isKindH91voCI$ui_release == 1) {
                } else {
                }
                node$iv$iv4 = stack$iv$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)node$iv$iv4 == 0) {
                } else {
                }
                count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                mask$iv$iv = node$iv$iv;
                count$iv$iv = node$iv$iv4;
                capacity$iv$iv$iv$iv = 0;
                stack$iv$iv = count$iv$iv;
                node7 = node3;
                if ((Modifier.Node)node7 != null) {
                } else {
                }
                node$iv$iv = node3;
                mutableVector2 = stack$iv$iv;
                if ((MutableVector)mutableVector2 != null) {
                }
                $i$f$tailH91voCI$ui_release = node$iv$iv;
                $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                (MutableVector)mutableVector2.add(it);
                mutableVector3 = stack$iv$iv;
                if ((MutableVector)mutableVector3 != null) {
                }
                node$iv$iv = 0;
                (MutableVector)mutableVector3.add((Modifier.Node)node7);
                i5 = i15;
                $i$f$mutableVectorOf = 16;
                i7 = 0;
                count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                mask$iv$iv = node$iv$iv;
                i10 = $i$f$mutableVectorOf;
                count$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv = count$iv$iv;
                $i$f$tailH91voCI$ui_release = it;
                mask$iv$iv = node$iv$iv;
                this_$iv$iv$iv = 1;
                $i$f$isKindH91voCI$ui_release = 1;
            }
            $i$f$tailH91voCI$ui_release2 = $i$f$tailH91voCI$ui_release;
            nodeChain2 = nodeChain;
            i4 = count$iv$iv3;
            mutableVector = node$iv$iv;
        } else {
            $i$f$tailH91voCI$ui_release2 = $i$f$tailH91voCI$ui_release;
            nodeChain2 = nodeChain;
            i4 = count$iv$iv3;
            mutableVector = node$iv$iv;
        }
        return 0;
    }

    public final void tailToHead$ui_release(int mask, Function1<? super Modifier.Node, Unit> block) {
        Modifier.Node node$iv;
        Modifier.Node node;
        int i2;
        int i;
        final int i3 = 0;
        if (i4 &= mask == 0) {
        }
        final int i6 = 0;
        node$iv = this.getTail$ui_release();
        while (node$iv != null) {
            node = node$iv;
            i2 = 0;
            if (kindSet$ui_release &= mask != 0) {
            }
            node$iv = node$iv.getParent$ui_release();
            block.invoke(node);
        }
    }

    public final void tailToHead$ui_release(Function1<? super Modifier.Node, Unit> block) {
        Modifier.Node node;
        final int i = 0;
        node = getTail$ui_release();
        while (node != null) {
            block.invoke(node);
            node = node.getParent$ui_release();
        }
    }

    public final <T> void tailToHead-aLcG6gQ$ui_release(int type, Function1<? super T, Unit> block) {
        int i9;
        Modifier.Node node;
        int mask$iv;
        int mask$iv3;
        androidx.compose.ui.node.NodeChain nodeChain;
        MutableVector this_$iv2;
        int i;
        int i11;
        int i15;
        Modifier.Node node$iv$iv2;
        Modifier.Node node3;
        int i6;
        int i16;
        int i5;
        Modifier.Node node2;
        int i4;
        int stack$iv;
        Modifier.Node node$iv;
        int this_$iv$iv;
        int $i$f$tailToHeadALcG6gQ$ui_release;
        int $i$f$tailToHeadALcG6gQ$ui_release2;
        Modifier.Node node4;
        int i14;
        Modifier.Node node$iv$iv;
        int i2;
        int mask$iv2;
        int this_$iv$iv2;
        int i13;
        int i10;
        int i12;
        androidx.compose.ui.node.NodeChain this_$iv;
        androidx.compose.ui.node.NodeChain nodeChain2;
        int i8;
        int i7;
        int i3;
        mask$iv = type;
        nodeChain = this;
        if (i20 &= mask$iv != 0) {
            i15 = 0;
            node$iv$iv2 = nodeChain.getTail$ui_release();
            while (node$iv$iv2 != null) {
                node3 = node$iv$iv2;
                i6 = 0;
                if (kindSet$ui_release &= mask$iv != 0) {
                } else {
                }
                $i$f$tailToHeadALcG6gQ$ui_release = i9;
                mask$iv2 = mask$iv;
                this_$iv = nodeChain;
                i8 = i;
                node$iv$iv2 = node$iv$iv2.getParent$ui_release();
                i9 = $i$f$tailToHeadALcG6gQ$ui_release;
                mask$iv = mask$iv2;
                nodeChain = this_$iv;
                i = i8;
                i5 = 0;
                i4 = 0;
                stack$iv = 0;
                int i21 = 0;
                node$iv = node2;
                while (node$iv != null) {
                    $i$f$tailToHeadALcG6gQ$ui_release = i9;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (node$iv instanceof Object != null) {
                    } else {
                    }
                    node = block;
                    node4 = 0;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0 && node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv2 = mask$iv;
                    this_$iv = nodeChain;
                    i8 = i;
                    node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                    i9 = $i$f$tailToHeadALcG6gQ$ui_release;
                    mask$iv = mask$iv2;
                    nodeChain = this_$iv;
                    i = i8;
                    if (node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    i14 = 0;
                    node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        node = node$iv$iv;
                        i2 = 0;
                        i10 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv2 = 0;
                        if (this_$iv$iv2 != 0) {
                        } else {
                        }
                        mask$iv2 = mask$iv;
                        this_$iv = nodeChain;
                        i8 = i;
                        mask$iv3 = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        mask$iv = mask$iv2;
                        nodeChain = this_$iv;
                        i = i8;
                        mask$iv2 = mask$iv;
                        if (this_$iv$iv++ == 1) {
                        } else {
                        }
                        int i18 = stack$iv;
                        if ((MutableVector)i18 == 0) {
                        } else {
                        }
                        this_$iv = nodeChain;
                        i8 = i;
                        this_$iv2 = i18;
                        mask$iv3 = 0;
                        stack$iv = this_$iv2;
                        nodeChain = node$iv;
                        MutableVector mutableVector = stack$iv;
                        if ((Modifier.Node)nodeChain != null && (MutableVector)mutableVector != null) {
                        }
                        i = stack$iv;
                        if ((MutableVector)i != null) {
                        }
                        (MutableVector)i.add(node);
                        mutableVector = stack$iv;
                        if ((MutableVector)(MutableVector)mutableVector != null) {
                        }
                        node$iv = i;
                        (MutableVector)(MutableVector)mutableVector.add((Modifier.Node)nodeChain);
                        i10 = i19;
                        int $i$f$mutableVectorOf = 16;
                        i12 = 0;
                        this_$iv = nodeChain;
                        i8 = i;
                        i3 = $i$f$mutableVectorOf;
                        this_$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        i = this_$iv2;
                        node$iv = node;
                        this_$iv = nodeChain;
                        i8 = i;
                        mask$iv3 = 0;
                        this_$iv$iv2 = 1;
                    }
                    if (this_$iv$iv == 1) {
                    } else {
                    }
                    i9 = $i$f$tailToHeadALcG6gQ$ui_release;
                    mask$iv = mask$iv2;
                    nodeChain = this_$iv;
                    i = i8;
                    node = node$iv$iv;
                    i2 = 0;
                    i10 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    if (this_$iv$iv2 != 0) {
                    } else {
                    }
                    mask$iv2 = mask$iv;
                    this_$iv = nodeChain;
                    i8 = i;
                    mask$iv3 = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    mask$iv = mask$iv2;
                    nodeChain = this_$iv;
                    i = i8;
                    mask$iv2 = mask$iv;
                    if (this_$iv$iv++ == 1) {
                    } else {
                    }
                    i18 = stack$iv;
                    if ((MutableVector)(MutableVector)i18 == 0) {
                    } else {
                    }
                    this_$iv = nodeChain;
                    i8 = i;
                    this_$iv2 = i18;
                    mask$iv3 = 0;
                    stack$iv = this_$iv2;
                    nodeChain = node$iv;
                    mutableVector = stack$iv;
                    if ((Modifier.Node)nodeChain != null && (MutableVector)mutableVector != null) {
                    }
                    i = stack$iv;
                    if ((MutableVector)i != null) {
                    }
                    (MutableVector)i.add(node);
                    mutableVector = stack$iv;
                    if ((MutableVector)(MutableVector)mutableVector != null) {
                    }
                    node$iv = i;
                    (MutableVector)(MutableVector)mutableVector.add((Modifier.Node)nodeChain);
                    i10 = i19;
                    $i$f$mutableVectorOf = 16;
                    i12 = 0;
                    this_$iv = nodeChain;
                    i8 = i;
                    i3 = $i$f$mutableVectorOf;
                    this_$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i = this_$iv2;
                    node$iv = node;
                    this_$iv = nodeChain;
                    i8 = i;
                    mask$iv3 = 0;
                    this_$iv$iv2 = 1;
                    this_$iv$iv = 1;
                    block.invoke(node$iv);
                    mask$iv2 = mask$iv;
                    this_$iv = nodeChain;
                    i8 = i;
                }
                $i$f$tailToHeadALcG6gQ$ui_release = i9;
                mask$iv2 = mask$iv;
                this_$iv = nodeChain;
                i8 = i;
                $i$f$tailToHeadALcG6gQ$ui_release = i9;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (node$iv instanceof Object != null) {
                } else {
                }
                node = block;
                node4 = 0;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0 && node$iv instanceof DelegatingNode) {
                } else {
                }
                mask$iv2 = mask$iv;
                this_$iv = nodeChain;
                i8 = i;
                node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                i9 = $i$f$tailToHeadALcG6gQ$ui_release;
                mask$iv = mask$iv2;
                nodeChain = this_$iv;
                i = i8;
                if (node$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv = 0;
                i14 = 0;
                node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                while (node$iv$iv != null) {
                    node = node$iv$iv;
                    i2 = 0;
                    i10 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    if (this_$iv$iv2 != 0) {
                    } else {
                    }
                    mask$iv2 = mask$iv;
                    this_$iv = nodeChain;
                    i8 = i;
                    mask$iv3 = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    mask$iv = mask$iv2;
                    nodeChain = this_$iv;
                    i = i8;
                    mask$iv2 = mask$iv;
                    if (this_$iv$iv++ == 1) {
                    } else {
                    }
                    i18 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)i18 == 0) {
                    } else {
                    }
                    this_$iv = nodeChain;
                    i8 = i;
                    this_$iv2 = i18;
                    mask$iv3 = 0;
                    stack$iv = this_$iv2;
                    nodeChain = node$iv;
                    mutableVector = stack$iv;
                    if ((Modifier.Node)nodeChain != null && (MutableVector)mutableVector != null) {
                    }
                    i = stack$iv;
                    if ((MutableVector)i != null) {
                    }
                    (MutableVector)i.add(node);
                    mutableVector = stack$iv;
                    if ((MutableVector)(MutableVector)mutableVector != null) {
                    }
                    node$iv = i;
                    (MutableVector)(MutableVector)mutableVector.add((Modifier.Node)nodeChain);
                    i10 = i19;
                    $i$f$mutableVectorOf = 16;
                    i12 = 0;
                    this_$iv = nodeChain;
                    i8 = i;
                    i3 = $i$f$mutableVectorOf;
                    this_$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i = this_$iv2;
                    node$iv = node;
                    this_$iv = nodeChain;
                    i8 = i;
                    mask$iv3 = 0;
                    this_$iv$iv2 = 1;
                }
                if (this_$iv$iv == 1) {
                } else {
                }
                i9 = $i$f$tailToHeadALcG6gQ$ui_release;
                mask$iv = mask$iv2;
                nodeChain = this_$iv;
                i = i8;
                node = node$iv$iv;
                i2 = 0;
                i10 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv2 = 0;
                if (this_$iv$iv2 != 0) {
                } else {
                }
                mask$iv2 = mask$iv;
                this_$iv = nodeChain;
                i8 = i;
                mask$iv3 = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                mask$iv = mask$iv2;
                nodeChain = this_$iv;
                i = i8;
                mask$iv2 = mask$iv;
                if (this_$iv$iv++ == 1) {
                } else {
                }
                i18 = stack$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)i18 == 0) {
                } else {
                }
                this_$iv = nodeChain;
                i8 = i;
                this_$iv2 = i18;
                mask$iv3 = 0;
                stack$iv = this_$iv2;
                nodeChain = node$iv;
                mutableVector = stack$iv;
                if ((Modifier.Node)nodeChain != null && (MutableVector)mutableVector != null) {
                }
                i = stack$iv;
                if ((MutableVector)i != null) {
                }
                (MutableVector)i.add(node);
                mutableVector = stack$iv;
                if ((MutableVector)(MutableVector)mutableVector != null) {
                }
                node$iv = i;
                (MutableVector)(MutableVector)mutableVector.add((Modifier.Node)nodeChain);
                i10 = i19;
                $i$f$mutableVectorOf = 16;
                i12 = 0;
                this_$iv = nodeChain;
                i8 = i;
                i3 = $i$f$mutableVectorOf;
                this_$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i = this_$iv2;
                node$iv = node;
                this_$iv = nodeChain;
                i8 = i;
                mask$iv3 = 0;
                this_$iv$iv2 = 1;
                this_$iv$iv = 1;
                block.invoke(node$iv);
                mask$iv2 = mask$iv;
                this_$iv = nodeChain;
                i8 = i;
            }
            $i$f$tailToHeadALcG6gQ$ui_release2 = i9;
            i13 = mask$iv;
            nodeChain2 = nodeChain;
            i7 = i;
        } else {
            $i$f$tailToHeadALcG6gQ$ui_release2 = i9;
            i13 = mask$iv;
            nodeChain2 = nodeChain;
            i7 = i;
        }
    }

    public String toString() {
        Object head;
        int tail;
        Modifier.Node node$iv;
        Modifier.Node tail$ui_release;
        int i;
        Object child$ui_release;
        Modifier.Node tail2;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = stringBuilder;
        final int i2 = 0;
        sb.append("[");
        final String str3 = "]";
        if (this.head == this.tail) {
            sb.append(str3);
        } else {
            head = this;
            tail = 0;
            node$iv = head.getHead$ui_release();
            while (node$iv != null) {
                tail$ui_release = node$iv;
                i = 0;
                sb.append(String.valueOf(tail$ui_release));
                sb.append(",");
                node$iv = node$iv.getChild$ui_release();
            }
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final void updateFrom$ui_release(Modifier m) {
        int i2;
        MutableVector before;
        Modifier.Node this_$iv2;
        Modifier.Node node6;
        Modifier.Node node;
        MutableVector node2;
        int size;
        MutableVector $i$f$mutableVectorOf;
        Modifier.Node node3;
        int i4;
        int next;
        Modifier.Node node4;
        int detachAndRemoveNode;
        boolean this_$iv3;
        Modifier.Node padChain;
        int i6;
        MutableVector mutableVector;
        int coordinatorSyncNeeded;
        Modifier.Element[] arr;
        int i3;
        String this_$iv;
        androidx.compose.ui.node.NodeChain.Logger mutableVector2;
        int i;
        int i5;
        Object obj2;
        Object andInsertNodeAsChild;
        Modifier.Node child$ui_release;
        Modifier.Node node5;
        Object obj;
        final Object obj4 = this;
        i2 = 0;
        padChain = obj4.padChain();
        before = obj4.current;
        int i9 = 0;
        if (before != null) {
            size = before.getSize();
        } else {
            size = i9;
        }
        final int i18 = size;
        if (obj4.buffer == null) {
            int i14 = 0;
            i6 = 0;
            mutableVector = new MutableVector(new Modifier.Element[16], i9);
            $i$f$mutableVectorOf = mutableVector;
        }
        MutableVector mutableVector4 = NodeChainKt.access$fillVector(m, $i$f$mutableVectorOf);
        coordinatorSyncNeeded = 0;
        this_$iv = "expected prior modifier list to be non-empty";
        if (mutableVector4.getSize() == i18) {
            child$ui_release = this_$iv2;
            i = coordinatorSyncNeeded;
            while (child$ui_release != null) {
                int i12 = 0;
                int i15 = 0;
                obj2 = this_$iv4;
                int i16 = 0;
                this_$iv2 = mutableVector4.getContent()[i];
                next = child$ui_release;
                child$ui_release = next.getChild$ui_release();
                i++;
                mutableVector2 = obj4.logger;
                if (mutableVector2 != null) {
                } else {
                }
                next = next2;
                this_$iv2 = obj;
                mutableVector2.nodeReused(i, i, obj2, this_$iv2, child$ui_release);
                next = child$ui_release;
                Object next5 = this_$iv2;
                Modifier.Node next3 = child$ui_release;
                obj4.updateNode(obj2, next5, next3);
                mutableVector2 = obj4.logger;
                if (mutableVector2 != null) {
                } else {
                }
                next = next3;
                this_$iv2 = obj;
                child$ui_release = next3;
                andInsertNodeAsChild = next5;
                mutableVector2.nodeUpdated(i, i, obj2, andInsertNodeAsChild, child$ui_release);
                this_$iv2 = andInsertNodeAsChild;
                next = child$ui_release;
            }
            node5 = node4;
            if (i < i18) {
                int coordinatorSyncNeeded2 = 0;
                if (before == null) {
                } else {
                    int $i$f$checkPreconditionNotNull = 0;
                    if (node5 == null) {
                    } else {
                        obj4.structuralUpdate(i, before, mutableVector4, node5, applyingModifierOnAttach$ui_release ^ 1);
                        node3 = padChain;
                        i2 = i19;
                        coordinatorSyncNeeded = i;
                    }
                    int i11 = 0;
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("structuralUpdate requires a non-null tail");
                    KotlinNothingValueException kotlinNothingValueException2 = new KotlinNothingValueException();
                    throw kotlinNothingValueException2;
                }
                int i10 = 0;
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(this_$iv);
                KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
                throw kotlinNothingValueException;
            }
            node2 = mutableVector4;
            node3 = padChain;
            coordinatorSyncNeeded = i;
        } else {
            if (obj4.layoutNode.getApplyingModifierOnAttach$ui_release() && i18 == 0) {
                if (i18 == 0) {
                    i2 = 1;
                    node = padChain;
                    i = coordinatorSyncNeeded;
                    while (i < mutableVector4.getSize()) {
                        coordinatorSyncNeeded = 0;
                        i5 = this_$iv3;
                        obj2 = node;
                        andInsertNodeAsChild = obj4.createAndInsertNodeAsChild((Modifier.Element)i5, obj2);
                        this_$iv = obj4.logger;
                        if (this_$iv != null) {
                        }
                        i++;
                        node = andInsertNodeAsChild;
                        this_$iv.nodeInserted(0, i, i5, obj2, andInsertNodeAsChild);
                    }
                    obj4.syncAggregateChildKindSet();
                    node2 = mutableVector4;
                    node3 = padChain;
                    coordinatorSyncNeeded = i;
                } else {
                    if (mutableVector4.getSize() == 0) {
                        int i13 = 0;
                        if (before == null) {
                        } else {
                            node6 = padChain.getChild$ui_release();
                            while (node6 != null) {
                                if (coordinatorSyncNeeded < before.getSize()) {
                                }
                                androidx.compose.ui.node.NodeChain.Logger logger = obj4.logger;
                                if (logger != null) {
                                }
                                node6 = obj4.detachAndRemoveNode(node6).getChild$ui_release();
                                coordinatorSyncNeeded++;
                                mutableVector2 = 0;
                                logger.nodeRemoved(coordinatorSyncNeeded, (Modifier.Element)before.getContent()[coordinatorSyncNeeded], node6);
                            }
                            androidx.compose.ui.node.LayoutNode parent$ui_release = obj4.layoutNode.getParent$ui_release();
                            if (parent$ui_release != null) {
                                this_$iv = parent$ui_release.getInnerCoordinator$ui_release();
                            } else {
                                this_$iv = i3;
                            }
                            obj4.innerCoordinator.setWrappedBy$ui_release(this_$iv);
                            obj4.outerCoordinator = (NodeCoordinator)obj4.innerCoordinator;
                            node2 = mutableVector4;
                            node3 = padChain;
                        }
                        int i17 = 0;
                        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(this_$iv);
                        KotlinNothingValueException kotlinNothingValueException3 = new KotlinNothingValueException();
                        throw kotlinNothingValueException3;
                    }
                    if (before == null) {
                        detachAndRemoveNode = 0;
                        mutableVector2 = new MutableVector(new Modifier.Element[16], i9);
                    } else {
                        mutableVector2 = before;
                    }
                    obj4.structuralUpdate(0, mutableVector2, mutableVector4, padChain, applyingModifierOnAttach$ui_release2 ^ 1);
                    i2 = this_$iv;
                }
            } else {
            }
        }
        obj4.current = node2;
        if (before != null) {
            padChain = 0;
            before.clear();
            i3 = before;
        }
        obj4.buffer = i3;
        obj4.head = obj4.trimChain(node3);
        if (i2 != 0) {
            obj4.syncCoordinators();
        }
    }

    public final void useLogger$ui_release(androidx.compose.ui.node.NodeChain.Logger logger) {
        this.logger = logger;
    }
}
