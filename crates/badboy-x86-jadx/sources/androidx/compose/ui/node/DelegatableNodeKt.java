package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000|\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0018\u001a\u001a\u0010\u0004\u001a\u00020\u0005*\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0008\u001a\u00020\u0007H\u0002\u001a5\u0010\t\u001a\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\n\"\u0006\u0008\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\rH\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000f\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u0007H\u0000\u001aA\u0010\u0012\u001a\u00020\u0005\"\u0006\u0008\u0000\u0010\u000b\u0018\u0001*\u00020\u00072\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017\u001a\"\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\n\u0010\u000c\u001a\u0006\u0012\u0002\u0008\u00030\rH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001a\u001a\n\u0010\u001b\u001a\u00020\u0005*\u00020\u0002\u001a3\u0010\u001c\u001a\u0004\u0018\u0001H\u000b\"\n\u0008\u0000\u0010\u000b\u0018\u0001*\u00020\u001d*\u00020\u00022\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\rH\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001f\u001a\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010 \u001a\u00020!H\u0000\u001a\u0016\u0010\"\u001a\u0004\u0018\u00010\u0007*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002\u001a\"\u0010#\u001a\u00020$*\u00020\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\u0008\u00030\rH\u0000ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&\u001a\n\u0010'\u001a\u00020(*\u00020\u0002\u001a\n\u0010)\u001a\u00020**\u00020\u0002\u001a\n\u0010+\u001a\u00020,*\u00020\u0002\u001a\n\u0010-\u001a\u00020.*\u00020\u0002\u001a\u000c\u0010/\u001a\u000200*\u00020\u0002H\u0000\u001a\u000c\u00101\u001a\u000202*\u00020\u0002H\u0000\u001aK\u00103\u001a\u00020\u0005\"\u0006\u0008\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\r2\u0008\u0008\u0002\u00104\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u00085\u00106\u001a3\u00103\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0008\u0008\u0002\u00104\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\u0008\u001aA\u00107\u001a\u00020\u0005\"\u0006\u0008\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u00088\u00109\u001a)\u00107\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\u0008\u001aA\u0010:\u001a\u00020\u0005\"\u0006\u0008\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008;\u00109\u001a)\u0010:\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\u0008\u001aA\u0010<\u001a\u00020\u0005\"\u0006\u0008\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008=\u00109\u001a)\u0010<\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\u0008\u001a3\u0010<\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0008\u0008\u0002\u00104\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\u0008\u001aM\u0010>\u001a\u00020\u0005\"\u0006\u0008\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\r2\n\u0010?\u001a\u0006\u0012\u0002\u0008\u00030\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008@\u0010A\u001aA\u0010B\u001a\u00020\u0005\"\u0006\u0008\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008C\u00109\u001aA\u0010D\u001a\u00020\u0005\"\u0006\u0008\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008E\u00109\u001aA\u0010F\u001a\u00020\u0005\"\u0006\u0008\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008G\u00109\u001a)\u0010F\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\u0080\u0008\u001aA\u0010H\u001a\u00020\u0005\"\u0006\u0008\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00010\u0015H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008I\u00109\u001a)\u0010H\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0015H\u0080\u0008\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0000\u0010\u0003\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006J", d2 = {"isDelegationRoot", "", "Landroidx/compose/ui/node/DelegatableNode;", "(Landroidx/compose/ui/node/DelegatableNode;)Z", "addLayoutNodeChildren", "", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Node;", "node", "ancestors", "", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "ancestors-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/util/List;", "asLayoutModifierNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "dispatchForKind", "kind", "block", "Lkotlin/Function1;", "dispatchForKind-6rFNWt0", "(Landroidx/compose/ui/Modifier$Node;ILkotlin/jvm/functions/Function1;)V", "has", "has-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Z", "invalidateSubtree", "nearestAncestor", "", "nearestAncestor-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "mask", "", "pop", "requireCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "requireCoordinator-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Landroidx/compose/ui/node/NodeCoordinator;", "requireDensity", "Landroidx/compose/ui/unit/Density;", "requireGraphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "requireLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "requireLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "requireLayoutNode", "Landroidx/compose/ui/node/LayoutNode;", "requireOwner", "Landroidx/compose/ui/node/Owner;", "visitAncestors", "includeSelf", "visitAncestors-Y-YKmho", "(Landroidx/compose/ui/node/DelegatableNode;IZLkotlin/jvm/functions/Function1;)V", "visitChildren", "visitChildren-6rFNWt0", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;)V", "visitLocalAncestors", "visitLocalAncestors-6rFNWt0", "visitLocalDescendants", "visitLocalDescendants-6rFNWt0", "visitSelfAndAncestors", "untilType", "visitSelfAndAncestors-5BbP62I", "(Landroidx/compose/ui/node/DelegatableNode;IILkotlin/jvm/functions/Function1;)V", "visitSelfAndChildren", "visitSelfAndChildren-6rFNWt0", "visitSelfAndLocalDescendants", "visitSelfAndLocalDescendants-6rFNWt0", "visitSubtree", "visitSubtree-6rFNWt0", "visitSubtreeIf", "visitSubtreeIf-6rFNWt0", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DelegatableNodeKt {
    public static final void access$addLayoutNodeChildren(MutableVector $receiver, Modifier.Node node) {
        DelegatableNodeKt.addLayoutNodeChildren($receiver, node);
    }

    public static final Modifier.Node access$pop(MutableVector $receiver) {
        return DelegatableNodeKt.pop($receiver);
    }

    private static final void addLayoutNodeChildren(MutableVector<Modifier.Node> $this$addLayoutNodeChildren, Modifier.Node node) {
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        Modifier.Node head$ui_release;
        MutableVector mutableVector = DelegatableNodeKt.requireLayoutNode((DelegatableNode)node).get_children$ui_release();
        final int i2 = 0;
        final int size = mutableVector.getSize();
        if (size > 0) {
            i$iv = size + -1;
            i = 0;
            $this$addLayoutNodeChildren.add((LayoutNode)mutableVector.getContent()[i$iv].getNodes$ui_release().getHead$ui_release());
            while (i$iv-- < 0) {
                i = 0;
                $this$addLayoutNodeChildren.add((LayoutNode)content[i$iv].getNodes$ui_release().getHead$ui_release());
            }
        }
    }

    public static final <T> List<T> ancestors-64DMado(androidx.compose.ui.node.DelegatableNode $this$ancestors_u2d64DMado, int type) {
        int $i$f$ancestors64DMado2;
        int capacity$iv$iv$iv$iv;
        Modifier.Node tail$ui_release;
        int i6;
        Modifier.Node node4;
        androidx.compose.ui.node.DelegatableNode count$iv$iv2;
        int count$iv$iv4;
        int count$iv$iv;
        int node$iv$iv2;
        Modifier.Node node$iv$iv;
        androidx.compose.ui.node.LayoutNode layout$iv$iv;
        Modifier.Node head$ui_release;
        int i2;
        int i7;
        Modifier.Node node3;
        int i9;
        int stack$iv$iv;
        int $i$f$ancestors64DMado;
        int result;
        androidx.compose.ui.node.DelegatableNode delegatableNode;
        Modifier.Node arrayList;
        int i4;
        Modifier.Node node$iv$iv$iv;
        int i5;
        Modifier.Node node2;
        int this_$iv$iv$iv;
        int i8;
        int i3;
        int count$iv$iv3;
        int includeSelf$iv;
        int i;
        Modifier.Node node;
        i6 = 0;
        count$iv$iv2 = $this$ancestors_u2d64DMado;
        node$iv$iv2 = 0;
        final int i17 = 0;
        final Object obj = type;
        final androidx.compose.ui.node.DelegatableNode delegatableNode2 = count$iv$iv2;
        final int i18 = 0;
        if (!delegatableNode2.getNode().isAttached()) {
        } else {
            node$iv$iv = delegatableNode2.getNode().getParent$ui_release();
            layout$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode2);
            while (layout$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= obj != 0) {
                } else {
                }
                $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                delegatableNode = count$iv$iv2;
                includeSelf$iv = node$iv$iv2;
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                $i$f$ancestors64DMado2 = layout$iv$iv.getNodes$ui_release();
                if (layout$iv$iv != null && $i$f$ancestors64DMado2 != null) {
                } else {
                }
                tail$ui_release = 0;
                node$iv$iv = tail$ui_release;
                $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                count$iv$iv2 = delegatableNode;
                node$iv$iv2 = includeSelf$iv;
                $i$f$ancestors64DMado2 = layout$iv$iv.getNodes$ui_release();
                if ($i$f$ancestors64DMado2 != null) {
                } else {
                }
                tail$ui_release = $i$f$ancestors64DMado2.getTail$ui_release();
                while (node$iv$iv != null) {
                    if (kindSet$ui_release &= obj != 0) {
                    } else {
                    }
                    $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                    delegatableNode = count$iv$iv2;
                    includeSelf$iv = node$iv$iv2;
                    node$iv$iv = node$iv$iv.getParent$ui_release();
                    $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                    count$iv$iv2 = delegatableNode;
                    node$iv$iv2 = includeSelf$iv;
                    i7 = 0;
                    i9 = 0;
                    stack$iv$iv = 0;
                    int i19 = 0;
                    $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                    $i$f$ancestors64DMado2 = node;
                    while ($i$f$ancestors64DMado2 != null) {
                        result = i6;
                        delegatableNode = count$iv$iv2;
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if ($i$f$ancestors64DMado2 instanceof Object != null) {
                        } else {
                        }
                        node4 = $i$f$ancestors64DMado2;
                        int i13 = 0;
                        i4 = node4;
                        if (kindSet$ui_release2 &= type != 0) {
                        } else {
                        }
                        count$iv$iv4 = 0;
                        if (count$iv$iv4 != 0 && $i$f$ancestors64DMado2 instanceof DelegatingNode) {
                        } else {
                        }
                        includeSelf$iv = node$iv$iv2;
                        i6 = result;
                        $i$f$ancestors64DMado2 = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv);
                        count$iv$iv2 = delegatableNode;
                        node$iv$iv2 = includeSelf$iv;
                        if ($i$f$ancestors64DMado2 instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv4 = 0;
                        i4 = 0;
                        node$iv$iv$iv = (DelegatingNode)$i$f$ancestors64DMado2.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node4 = node$iv$iv$iv;
                            i5 = 0;
                            i8 = 0;
                            if (kindSet$ui_release3 &= type != 0) {
                            } else {
                            }
                            this_$iv$iv$iv = 0;
                            if (this_$iv$iv$iv != 0) {
                            } else {
                            }
                            node2 = $i$f$ancestors64DMado2;
                            includeSelf$iv = node$iv$iv2;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            node$iv$iv2 = includeSelf$iv;
                            count$iv$iv4++;
                            node2 = $i$f$ancestors64DMado2;
                            if (count$iv$iv4 == 1) {
                            } else {
                            }
                            int node$iv$iv5 = stack$iv$iv;
                            if ((MutableVector)node$iv$iv5 == 0) {
                            } else {
                            }
                            count$iv$iv3 = count$iv$iv4;
                            includeSelf$iv = node$iv$iv2;
                            count$iv$iv = node$iv$iv5;
                            capacity$iv$iv$iv$iv = 0;
                            stack$iv$iv = count$iv$iv;
                            Modifier.Node node6 = node2;
                            if ((Modifier.Node)node6 != null) {
                            } else {
                            }
                            node$iv$iv2 = node2;
                            int i10 = stack$iv$iv;
                            if ((MutableVector)i10 != 0) {
                            }
                            $i$f$ancestors64DMado2 = node$iv$iv2;
                            count$iv$iv4 = count$iv$iv3;
                            (MutableVector)i10.add(node4);
                            int i16 = stack$iv$iv;
                            if ((MutableVector)i16 != 0) {
                            }
                            node$iv$iv2 = 0;
                            (MutableVector)i16.add((Modifier.Node)node6);
                            i8 = i11;
                            int $i$f$mutableVectorOf = 16;
                            i3 = 0;
                            count$iv$iv3 = count$iv$iv4;
                            includeSelf$iv = node$iv$iv2;
                            i = $i$f$mutableVectorOf;
                            count$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                            node$iv$iv2 = count$iv$iv;
                            $i$f$ancestors64DMado2 = node4;
                            includeSelf$iv = node$iv$iv2;
                            this_$iv$iv$iv = 1;
                        }
                        node2 = $i$f$ancestors64DMado2;
                        if (count$iv$iv4 == 1) {
                        } else {
                        }
                        i6 = result;
                        $i$f$ancestors64DMado2 = node2;
                        i6 = result;
                        count$iv$iv2 = delegatableNode;
                        $i$f$ancestors64DMado2 = node2;
                        node$iv$iv2 = includeSelf$iv;
                        node4 = node$iv$iv$iv;
                        i5 = 0;
                        i8 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        node2 = $i$f$ancestors64DMado2;
                        includeSelf$iv = node$iv$iv2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        node$iv$iv2 = includeSelf$iv;
                        count$iv$iv4++;
                        node2 = $i$f$ancestors64DMado2;
                        if (count$iv$iv4 == 1) {
                        } else {
                        }
                        node$iv$iv5 = stack$iv$iv;
                        if ((MutableVector)(MutableVector)node$iv$iv5 == 0) {
                        } else {
                        }
                        count$iv$iv3 = count$iv$iv4;
                        includeSelf$iv = node$iv$iv2;
                        count$iv$iv = node$iv$iv5;
                        capacity$iv$iv$iv$iv = 0;
                        stack$iv$iv = count$iv$iv;
                        node6 = node2;
                        if ((Modifier.Node)node6 != null) {
                        } else {
                        }
                        node$iv$iv2 = node2;
                        i10 = stack$iv$iv;
                        if ((MutableVector)i10 != 0) {
                        }
                        $i$f$ancestors64DMado2 = node$iv$iv2;
                        count$iv$iv4 = count$iv$iv3;
                        (MutableVector)i10.add(node4);
                        i16 = stack$iv$iv;
                        if ((MutableVector)i16 != 0) {
                        }
                        node$iv$iv2 = 0;
                        (MutableVector)i16.add((Modifier.Node)node6);
                        i8 = i11;
                        $i$f$mutableVectorOf = 16;
                        i3 = 0;
                        count$iv$iv3 = count$iv$iv4;
                        includeSelf$iv = node$iv$iv2;
                        i = $i$f$mutableVectorOf;
                        count$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv2 = count$iv$iv;
                        $i$f$ancestors64DMado2 = node4;
                        includeSelf$iv = node$iv$iv2;
                        this_$iv$iv$iv = 1;
                        count$iv$iv4 = 1;
                        if (result == null) {
                        }
                        arrayList = i14;
                        (List)result.add($i$f$ancestors64DMado2);
                        includeSelf$iv = node$iv$iv2;
                        i6 = result;
                        arrayList = new ArrayList();
                        result = arrayList;
                    }
                    result = i6;
                    delegatableNode = count$iv$iv2;
                    includeSelf$iv = node$iv$iv2;
                    result = i6;
                    delegatableNode = count$iv$iv2;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if ($i$f$ancestors64DMado2 instanceof Object != null) {
                    } else {
                    }
                    node4 = $i$f$ancestors64DMado2;
                    i13 = 0;
                    i4 = node4;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    count$iv$iv4 = 0;
                    if (count$iv$iv4 != 0 && $i$f$ancestors64DMado2 instanceof DelegatingNode) {
                    } else {
                    }
                    includeSelf$iv = node$iv$iv2;
                    i6 = result;
                    $i$f$ancestors64DMado2 = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv);
                    count$iv$iv2 = delegatableNode;
                    node$iv$iv2 = includeSelf$iv;
                    if ($i$f$ancestors64DMado2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv4 = 0;
                    i4 = 0;
                    node$iv$iv$iv = (DelegatingNode)$i$f$ancestors64DMado2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node4 = node$iv$iv$iv;
                        i5 = 0;
                        i8 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        node2 = $i$f$ancestors64DMado2;
                        includeSelf$iv = node$iv$iv2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        node$iv$iv2 = includeSelf$iv;
                        count$iv$iv4++;
                        node2 = $i$f$ancestors64DMado2;
                        if (count$iv$iv4 == 1) {
                        } else {
                        }
                        node$iv$iv5 = stack$iv$iv;
                        if ((MutableVector)(MutableVector)(MutableVector)node$iv$iv5 == 0) {
                        } else {
                        }
                        count$iv$iv3 = count$iv$iv4;
                        includeSelf$iv = node$iv$iv2;
                        count$iv$iv = node$iv$iv5;
                        capacity$iv$iv$iv$iv = 0;
                        stack$iv$iv = count$iv$iv;
                        node6 = node2;
                        if ((Modifier.Node)node6 != null) {
                        } else {
                        }
                        node$iv$iv2 = node2;
                        i10 = stack$iv$iv;
                        if ((MutableVector)i10 != 0) {
                        }
                        $i$f$ancestors64DMado2 = node$iv$iv2;
                        count$iv$iv4 = count$iv$iv3;
                        (MutableVector)i10.add(node4);
                        i16 = stack$iv$iv;
                        if ((MutableVector)i16 != 0) {
                        }
                        node$iv$iv2 = 0;
                        (MutableVector)i16.add((Modifier.Node)node6);
                        i8 = i11;
                        $i$f$mutableVectorOf = 16;
                        i3 = 0;
                        count$iv$iv3 = count$iv$iv4;
                        includeSelf$iv = node$iv$iv2;
                        i = $i$f$mutableVectorOf;
                        count$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv2 = count$iv$iv;
                        $i$f$ancestors64DMado2 = node4;
                        includeSelf$iv = node$iv$iv2;
                        this_$iv$iv$iv = 1;
                    }
                    node2 = $i$f$ancestors64DMado2;
                    if (count$iv$iv4 == 1) {
                    } else {
                    }
                    i6 = result;
                    $i$f$ancestors64DMado2 = node2;
                    i6 = result;
                    count$iv$iv2 = delegatableNode;
                    $i$f$ancestors64DMado2 = node2;
                    node$iv$iv2 = includeSelf$iv;
                    node4 = node$iv$iv$iv;
                    i5 = 0;
                    i8 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    node2 = $i$f$ancestors64DMado2;
                    includeSelf$iv = node$iv$iv2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    node$iv$iv2 = includeSelf$iv;
                    count$iv$iv4++;
                    node2 = $i$f$ancestors64DMado2;
                    if (count$iv$iv4 == 1) {
                    } else {
                    }
                    node$iv$iv5 = stack$iv$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)node$iv$iv5 == 0) {
                    } else {
                    }
                    count$iv$iv3 = count$iv$iv4;
                    includeSelf$iv = node$iv$iv2;
                    count$iv$iv = node$iv$iv5;
                    capacity$iv$iv$iv$iv = 0;
                    stack$iv$iv = count$iv$iv;
                    node6 = node2;
                    if ((Modifier.Node)node6 != null) {
                    } else {
                    }
                    node$iv$iv2 = node2;
                    i10 = stack$iv$iv;
                    if ((MutableVector)i10 != 0) {
                    }
                    $i$f$ancestors64DMado2 = node$iv$iv2;
                    count$iv$iv4 = count$iv$iv3;
                    (MutableVector)i10.add(node4);
                    i16 = stack$iv$iv;
                    if ((MutableVector)i16 != 0) {
                    }
                    node$iv$iv2 = 0;
                    (MutableVector)i16.add((Modifier.Node)node6);
                    i8 = i11;
                    $i$f$mutableVectorOf = 16;
                    i3 = 0;
                    count$iv$iv3 = count$iv$iv4;
                    includeSelf$iv = node$iv$iv2;
                    i = $i$f$mutableVectorOf;
                    count$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv2 = count$iv$iv;
                    $i$f$ancestors64DMado2 = node4;
                    includeSelf$iv = node$iv$iv2;
                    this_$iv$iv$iv = 1;
                    count$iv$iv4 = 1;
                    if (result == null) {
                    }
                    arrayList = i14;
                    (List)result.add($i$f$ancestors64DMado2);
                    includeSelf$iv = node$iv$iv2;
                    i6 = result;
                    arrayList = new ArrayList();
                    result = arrayList;
                }
                $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                delegatableNode = count$iv$iv2;
                includeSelf$iv = node$iv$iv2;
                if (kindSet$ui_release &= obj != 0) {
                } else {
                }
                $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                delegatableNode = count$iv$iv2;
                includeSelf$iv = node$iv$iv2;
                node$iv$iv = node$iv$iv.getParent$ui_release();
                $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                count$iv$iv2 = delegatableNode;
                node$iv$iv2 = includeSelf$iv;
                i7 = 0;
                i9 = 0;
                stack$iv$iv = 0;
                i19 = 0;
                $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                $i$f$ancestors64DMado2 = node;
                while ($i$f$ancestors64DMado2 != null) {
                    result = i6;
                    delegatableNode = count$iv$iv2;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if ($i$f$ancestors64DMado2 instanceof Object != null) {
                    } else {
                    }
                    node4 = $i$f$ancestors64DMado2;
                    i13 = 0;
                    i4 = node4;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    count$iv$iv4 = 0;
                    if (count$iv$iv4 != 0 && $i$f$ancestors64DMado2 instanceof DelegatingNode) {
                    } else {
                    }
                    includeSelf$iv = node$iv$iv2;
                    i6 = result;
                    $i$f$ancestors64DMado2 = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv);
                    count$iv$iv2 = delegatableNode;
                    node$iv$iv2 = includeSelf$iv;
                    if ($i$f$ancestors64DMado2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv4 = 0;
                    i4 = 0;
                    node$iv$iv$iv = (DelegatingNode)$i$f$ancestors64DMado2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node4 = node$iv$iv$iv;
                        i5 = 0;
                        i8 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        node2 = $i$f$ancestors64DMado2;
                        includeSelf$iv = node$iv$iv2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        node$iv$iv2 = includeSelf$iv;
                        count$iv$iv4++;
                        node2 = $i$f$ancestors64DMado2;
                        if (count$iv$iv4 == 1) {
                        } else {
                        }
                        node$iv$iv5 = stack$iv$iv;
                        if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)node$iv$iv5 == 0) {
                        } else {
                        }
                        count$iv$iv3 = count$iv$iv4;
                        includeSelf$iv = node$iv$iv2;
                        count$iv$iv = node$iv$iv5;
                        capacity$iv$iv$iv$iv = 0;
                        stack$iv$iv = count$iv$iv;
                        node6 = node2;
                        if ((Modifier.Node)node6 != null) {
                        } else {
                        }
                        node$iv$iv2 = node2;
                        i10 = stack$iv$iv;
                        if ((MutableVector)i10 != 0) {
                        }
                        $i$f$ancestors64DMado2 = node$iv$iv2;
                        count$iv$iv4 = count$iv$iv3;
                        (MutableVector)i10.add(node4);
                        i16 = stack$iv$iv;
                        if ((MutableVector)i16 != 0) {
                        }
                        node$iv$iv2 = 0;
                        (MutableVector)i16.add((Modifier.Node)node6);
                        i8 = i11;
                        $i$f$mutableVectorOf = 16;
                        i3 = 0;
                        count$iv$iv3 = count$iv$iv4;
                        includeSelf$iv = node$iv$iv2;
                        i = $i$f$mutableVectorOf;
                        count$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv2 = count$iv$iv;
                        $i$f$ancestors64DMado2 = node4;
                        includeSelf$iv = node$iv$iv2;
                        this_$iv$iv$iv = 1;
                    }
                    node2 = $i$f$ancestors64DMado2;
                    if (count$iv$iv4 == 1) {
                    } else {
                    }
                    i6 = result;
                    $i$f$ancestors64DMado2 = node2;
                    i6 = result;
                    count$iv$iv2 = delegatableNode;
                    $i$f$ancestors64DMado2 = node2;
                    node$iv$iv2 = includeSelf$iv;
                    node4 = node$iv$iv$iv;
                    i5 = 0;
                    i8 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    node2 = $i$f$ancestors64DMado2;
                    includeSelf$iv = node$iv$iv2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    node$iv$iv2 = includeSelf$iv;
                    count$iv$iv4++;
                    node2 = $i$f$ancestors64DMado2;
                    if (count$iv$iv4 == 1) {
                    } else {
                    }
                    node$iv$iv5 = stack$iv$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)node$iv$iv5 == 0) {
                    } else {
                    }
                    count$iv$iv3 = count$iv$iv4;
                    includeSelf$iv = node$iv$iv2;
                    count$iv$iv = node$iv$iv5;
                    capacity$iv$iv$iv$iv = 0;
                    stack$iv$iv = count$iv$iv;
                    node6 = node2;
                    if ((Modifier.Node)node6 != null) {
                    } else {
                    }
                    node$iv$iv2 = node2;
                    i10 = stack$iv$iv;
                    if ((MutableVector)i10 != 0) {
                    }
                    $i$f$ancestors64DMado2 = node$iv$iv2;
                    count$iv$iv4 = count$iv$iv3;
                    (MutableVector)i10.add(node4);
                    i16 = stack$iv$iv;
                    if ((MutableVector)i16 != 0) {
                    }
                    node$iv$iv2 = 0;
                    (MutableVector)i16.add((Modifier.Node)node6);
                    i8 = i11;
                    $i$f$mutableVectorOf = 16;
                    i3 = 0;
                    count$iv$iv3 = count$iv$iv4;
                    includeSelf$iv = node$iv$iv2;
                    i = $i$f$mutableVectorOf;
                    count$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv2 = count$iv$iv;
                    $i$f$ancestors64DMado2 = node4;
                    includeSelf$iv = node$iv$iv2;
                    this_$iv$iv$iv = 1;
                    count$iv$iv4 = 1;
                    if (result == null) {
                    }
                    arrayList = i14;
                    (List)result.add($i$f$ancestors64DMado2);
                    includeSelf$iv = node$iv$iv2;
                    i6 = result;
                    arrayList = new ArrayList();
                    result = arrayList;
                }
                result = i6;
                delegatableNode = count$iv$iv2;
                includeSelf$iv = node$iv$iv2;
                result = i6;
                delegatableNode = count$iv$iv2;
                Intrinsics.reifiedOperationMarker(3, "T");
                if ($i$f$ancestors64DMado2 instanceof Object != null) {
                } else {
                }
                node4 = $i$f$ancestors64DMado2;
                i13 = 0;
                i4 = node4;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                count$iv$iv4 = 0;
                if (count$iv$iv4 != 0 && $i$f$ancestors64DMado2 instanceof DelegatingNode) {
                } else {
                }
                includeSelf$iv = node$iv$iv2;
                i6 = result;
                $i$f$ancestors64DMado2 = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv);
                count$iv$iv2 = delegatableNode;
                node$iv$iv2 = includeSelf$iv;
                if ($i$f$ancestors64DMado2 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv4 = 0;
                i4 = 0;
                node$iv$iv$iv = (DelegatingNode)$i$f$ancestors64DMado2.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node4 = node$iv$iv$iv;
                    i5 = 0;
                    i8 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    node2 = $i$f$ancestors64DMado2;
                    includeSelf$iv = node$iv$iv2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    node$iv$iv2 = includeSelf$iv;
                    count$iv$iv4++;
                    node2 = $i$f$ancestors64DMado2;
                    if (count$iv$iv4 == 1) {
                    } else {
                    }
                    node$iv$iv5 = stack$iv$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)node$iv$iv5 == 0) {
                    } else {
                    }
                    count$iv$iv3 = count$iv$iv4;
                    includeSelf$iv = node$iv$iv2;
                    count$iv$iv = node$iv$iv5;
                    capacity$iv$iv$iv$iv = 0;
                    stack$iv$iv = count$iv$iv;
                    node6 = node2;
                    if ((Modifier.Node)node6 != null) {
                    } else {
                    }
                    node$iv$iv2 = node2;
                    i10 = stack$iv$iv;
                    if ((MutableVector)i10 != 0) {
                    }
                    $i$f$ancestors64DMado2 = node$iv$iv2;
                    count$iv$iv4 = count$iv$iv3;
                    (MutableVector)i10.add(node4);
                    i16 = stack$iv$iv;
                    if ((MutableVector)i16 != 0) {
                    }
                    node$iv$iv2 = 0;
                    (MutableVector)i16.add((Modifier.Node)node6);
                    i8 = i11;
                    $i$f$mutableVectorOf = 16;
                    i3 = 0;
                    count$iv$iv3 = count$iv$iv4;
                    includeSelf$iv = node$iv$iv2;
                    i = $i$f$mutableVectorOf;
                    count$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv2 = count$iv$iv;
                    $i$f$ancestors64DMado2 = node4;
                    includeSelf$iv = node$iv$iv2;
                    this_$iv$iv$iv = 1;
                }
                node2 = $i$f$ancestors64DMado2;
                if (count$iv$iv4 == 1) {
                } else {
                }
                i6 = result;
                $i$f$ancestors64DMado2 = node2;
                i6 = result;
                count$iv$iv2 = delegatableNode;
                $i$f$ancestors64DMado2 = node2;
                node$iv$iv2 = includeSelf$iv;
                node4 = node$iv$iv$iv;
                i5 = 0;
                i8 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                node2 = $i$f$ancestors64DMado2;
                includeSelf$iv = node$iv$iv2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                node$iv$iv2 = includeSelf$iv;
                count$iv$iv4++;
                node2 = $i$f$ancestors64DMado2;
                if (count$iv$iv4 == 1) {
                } else {
                }
                node$iv$iv5 = stack$iv$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)node$iv$iv5 == 0) {
                } else {
                }
                count$iv$iv3 = count$iv$iv4;
                includeSelf$iv = node$iv$iv2;
                count$iv$iv = node$iv$iv5;
                capacity$iv$iv$iv$iv = 0;
                stack$iv$iv = count$iv$iv;
                node6 = node2;
                if ((Modifier.Node)node6 != null) {
                } else {
                }
                node$iv$iv2 = node2;
                i10 = stack$iv$iv;
                if ((MutableVector)i10 != 0) {
                }
                $i$f$ancestors64DMado2 = node$iv$iv2;
                count$iv$iv4 = count$iv$iv3;
                (MutableVector)i10.add(node4);
                i16 = stack$iv$iv;
                if ((MutableVector)i16 != 0) {
                }
                node$iv$iv2 = 0;
                (MutableVector)i16.add((Modifier.Node)node6);
                i8 = i11;
                $i$f$mutableVectorOf = 16;
                i3 = 0;
                count$iv$iv3 = count$iv$iv4;
                includeSelf$iv = node$iv$iv2;
                i = $i$f$mutableVectorOf;
                count$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv2 = count$iv$iv;
                $i$f$ancestors64DMado2 = node4;
                includeSelf$iv = node$iv$iv2;
                this_$iv$iv$iv = 1;
                count$iv$iv4 = 1;
                if (result == null) {
                }
                arrayList = i14;
                (List)result.add($i$f$ancestors64DMado2);
                includeSelf$iv = node$iv$iv2;
                i6 = result;
                arrayList = new ArrayList();
                result = arrayList;
            }
            int $i$f$ancestors64DMado4 = $i$f$ancestors64DMado2;
            return (List)i6;
        }
        int $i$f$ancestors64DMado5 = $i$f$ancestors64DMado2;
        androidx.compose.ui.node.DelegatableNode delegatableNode3 = count$iv$iv2;
        int $i$f$ancestors64DMado3 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv;
    }

    public static final androidx.compose.ui.node.LayoutModifierNode asLayoutModifierNode(Modifier.Node $this$asLayoutModifierNode) {
        int kind$iv2;
        boolean node;
        int delegate$ui_release;
        boolean kind$iv;
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 2;
        delegate$ui_release = 0;
        final int i7 = 1;
        final int i8 = 0;
        kind$iv2 = kindSet$ui_release &= $i$f$getLayoutOLwlOKw != 0 ? i7 : i8;
        int this_$iv = 0;
        if (kind$iv2 == 0) {
            return this_$iv;
        }
        if ($this$asLayoutModifierNode instanceof LayoutModifierNode) {
            return (LayoutModifierNode)$this$asLayoutModifierNode;
        }
        if ($this$asLayoutModifierNode instanceof DelegatingNode) {
            node = (DelegatingNode)$this$asLayoutModifierNode.getDelegate$ui_release();
            while (node != null) {
                if (node instanceof DelegatingNode) {
                } else {
                }
                delegate$ui_release = node.getChild$ui_release();
                node = delegate$ui_release;
                int i6 = 0;
                i2 = 0;
                if (kindSet$ui_release2 &= $i$f$getLayoutOLwlOKw2 != 0) {
                } else {
                }
                kind$iv = i8;
                if (kind$iv != 0) {
                } else {
                }
                delegate$ui_release = (DelegatingNode)node.getDelegate$ui_release();
                kind$iv = i7;
            }
        }
        return this_$iv;
    }

    public static final <T> void dispatchForKind-6rFNWt0(Modifier.Node $this$dispatchForKind_u2d6rFNWt0, int kind, Function1<? super T, Unit> block) {
        int stack;
        Object node;
        Object obj;
        int count;
        int this_$iv2;
        int i;
        int i2;
        int i7;
        Modifier.Node node$iv;
        Modifier.Node node2;
        int i4;
        int this_$iv;
        int i6;
        int i5;
        int i3;
        MutableVector mutableVector;
        final int i8 = 0;
        stack = 0;
        int i9 = 0;
        node = $this$dispatchForKind_u2d6rFNWt0;
        while (node != null) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (node instanceof Object != null) {
            } else {
            }
            obj = block;
            this_$iv2 = 0;
            i2 = 0;
            if (kindSet$ui_release &= kind != 0) {
            } else {
            }
            count = i2;
            if (count != 0 && node instanceof DelegatingNode) {
            } else {
            }
            node = DelegatableNodeKt.access$pop((MutableVector)stack);
            if (node instanceof DelegatingNode) {
            } else {
            }
            count = 0;
            i = 0;
            node$iv = (DelegatingNode)node.getDelegate$ui_release();
            while (node$iv != null) {
                node2 = node$iv;
                i4 = 0;
                i5 = 0;
                if (kindSet$ui_release2 &= kind != 0) {
                } else {
                }
                this_$iv = i2;
                if (this_$iv != 0) {
                }
                node$iv = node$iv.getChild$ui_release();
                i7 = 1;
                if (count++ == i7) {
                } else {
                }
                if ((MutableVector)stack == 0) {
                }
                stack = i6;
                i7 = node;
                i6 = stack;
                if ((Modifier.Node)i7 != null && (MutableVector)i6 != 0) {
                }
                this_$iv = stack;
                if ((MutableVector)this_$iv != 0) {
                }
                (MutableVector)this_$iv.add(node2);
                i6 = stack;
                if ((MutableVector)(MutableVector)i6 != 0) {
                }
                node = 0;
                (MutableVector)(MutableVector)i6.add((Modifier.Node)i7);
                int i11 = 0;
                i3 = 0;
                mutableVector = new MutableVector(new Modifier.Node[16], i2);
                i7 = mutableVector;
                i6 = mutableVector;
                node = node2;
                this_$iv = i7;
            }
            if (count == 1) {
            } else {
            }
            node2 = node$iv;
            i4 = 0;
            i5 = 0;
            if (kindSet$ui_release2 &= kind != 0) {
            } else {
            }
            this_$iv = i2;
            if (this_$iv != 0) {
            }
            node$iv = node$iv.getChild$ui_release();
            i7 = 1;
            if (count++ == i7) {
            } else {
            }
            if ((MutableVector)stack == 0) {
            }
            stack = i6;
            i7 = node;
            i6 = stack;
            if ((Modifier.Node)i7 != null && (MutableVector)i6 != 0) {
            }
            this_$iv = stack;
            if ((MutableVector)this_$iv != 0) {
            }
            (MutableVector)this_$iv.add(node2);
            i6 = stack;
            if ((MutableVector)(MutableVector)i6 != 0) {
            }
            node = 0;
            (MutableVector)(MutableVector)i6.add((Modifier.Node)i7);
            i11 = 0;
            i3 = 0;
            mutableVector = new MutableVector(new Modifier.Node[16], i2);
            i7 = mutableVector;
            i6 = mutableVector;
            node = node2;
            this_$iv = i7;
            count = i7;
            block.invoke(node);
        }
        Object obj2 = block;
    }

    public static final boolean has-64DMado(androidx.compose.ui.node.DelegatableNode $this$has_u2d64DMado, int type) {
        int i;
        i = aggregateChildKindSet$ui_release &= type != 0 ? 1 : 0;
        return i;
    }

    public static final void invalidateSubtree(androidx.compose.ui.node.DelegatableNode $this$invalidateSubtree) {
        boolean requireLayoutNode;
        int i3;
        int i;
        int i2;
        if ($this$invalidateSubtree.getNode().isAttached()) {
            LayoutNode.invalidateSubtree$default(DelegatableNodeKt.requireLayoutNode($this$invalidateSubtree), false, 1, 0);
        }
    }

    public static final boolean isDelegationRoot(androidx.compose.ui.node.DelegatableNode $this$isDelegationRoot) {
        int i;
        i = $this$isDelegationRoot.getNode() == $this$isDelegationRoot ? 1 : 0;
        return i;
    }

    public static final Modifier.Node nearestAncestor(androidx.compose.ui.node.DelegatableNode $this$nearestAncestor, int mask) {
        Modifier.Node node;
        androidx.compose.ui.node.LayoutNode layout;
        String $i$a$CheckPreconditionDelegatableNodeKt$nearestAncestor$1;
        Modifier.Node head$ui_release;
        int nodes$ui_release;
        int i = 0;
        if (!$this$nearestAncestor.getNode().isAttached()) {
            int i2 = 0;
            InlineClassHelperKt.throwIllegalStateException("nearestAncestor called on an unattached node");
        }
        node = $this$nearestAncestor.getNode().getParent$ui_release();
        layout = DelegatableNodeKt.requireLayoutNode($this$nearestAncestor);
        while (layout != null) {
            if (aggregateChildKindSet$ui_release &= mask != 0) {
            } else {
            }
            layout = layout.getParent$ui_release();
            nodes$ui_release = layout.getNodes$ui_release();
            if (layout != null && nodes$ui_release != null) {
            }
            node = $i$a$CheckPreconditionDelegatableNodeKt$nearestAncestor$1;
            nodes$ui_release = layout.getNodes$ui_release();
            if (nodes$ui_release != null) {
            }
            $i$a$CheckPreconditionDelegatableNodeKt$nearestAncestor$1 = nodes$ui_release.getTail$ui_release();
            while (node != null) {
                node = node.getParent$ui_release();
            }
            node = node.getParent$ui_release();
        }
        return null;
    }

    public static final <T> T nearestAncestor-64DMado(androidx.compose.ui.node.DelegatableNode $this$nearestAncestor_u2d64DMado, int type) {
        int nodes$ui_release;
        Modifier.Node it;
        androidx.compose.ui.node.DelegatableNode count$iv$iv;
        int $i$f$isKindH91voCI$ui_release;
        int includeSelf$iv;
        int $i$f$mutableVectorOf;
        int $i$f$visitAncestorsYYKmho;
        Object obj;
        int mask$iv$iv;
        Modifier.Node node$iv$iv;
        androidx.compose.ui.node.LayoutNode layout$iv$iv;
        int node$iv$iv2;
        Modifier.Node head$ui_release;
        int i3;
        int i;
        Modifier.Node node;
        int i7;
        int stack$iv$iv;
        int node$iv$iv3;
        int $i$f$nearestAncestor64DMado;
        androidx.compose.ui.node.DelegatableNode delegatableNode;
        Modifier.Node node2;
        int i2;
        Modifier.Node node$iv$iv$iv;
        int i5;
        int includeSelf$iv2;
        int this_$iv$iv$iv;
        int count$iv$iv2;
        int i4;
        int i6;
        int i8;
        Object obj2;
        count$iv$iv = $this$nearestAncestor_u2d64DMado;
        includeSelf$iv = 0;
        $i$f$visitAncestorsYYKmho = 0;
        obj = type;
        final androidx.compose.ui.node.DelegatableNode delegatableNode2 = count$iv$iv;
        final int i14 = 0;
        if (!delegatableNode2.getNode().isAttached()) {
        } else {
            node$iv$iv = delegatableNode2.getNode().getParent$ui_release();
            layout$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode2);
            while (layout$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= obj != 0) {
                } else {
                }
                $i$f$nearestAncestor64DMado = nodes$ui_release;
                delegatableNode = count$iv$iv;
                includeSelf$iv2 = includeSelf$iv;
                i8 = $i$f$visitAncestorsYYKmho;
                obj2 = obj;
                node$iv$iv3 = 0;
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                nodes$ui_release = layout$iv$iv.getNodes$ui_release();
                if (layout$iv$iv != null && nodes$ui_release != null) {
                } else {
                }
                node$iv$iv2 = node$iv$iv3;
                node$iv$iv = node$iv$iv2;
                nodes$ui_release = $i$f$nearestAncestor64DMado;
                count$iv$iv = delegatableNode;
                includeSelf$iv = includeSelf$iv2;
                $i$f$visitAncestorsYYKmho = i8;
                obj = obj2;
                nodes$ui_release = layout$iv$iv.getNodes$ui_release();
                if (nodes$ui_release != null) {
                } else {
                }
                node$iv$iv2 = nodes$ui_release.getTail$ui_release();
                while (node$iv$iv != null) {
                    if (kindSet$ui_release &= obj == 0) {
                        break loop_4;
                    } else {
                    }
                    $i$f$nearestAncestor64DMado = nodes$ui_release;
                    delegatableNode = count$iv$iv;
                    includeSelf$iv2 = includeSelf$iv;
                    i8 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    node$iv$iv3 = 0;
                    node$iv$iv = node$iv$iv.getParent$ui_release();
                    nodes$ui_release = $i$f$nearestAncestor64DMado;
                    count$iv$iv = delegatableNode;
                    includeSelf$iv = includeSelf$iv2;
                    $i$f$visitAncestorsYYKmho = i8;
                    obj = obj2;
                    i = 0;
                    i7 = 0;
                    stack$iv$iv = 0;
                    int i15 = 0;
                    node$iv$iv2 = node$iv$iv4;
                    node$iv$iv3 = 0;
                    while (node$iv$iv2 != null) {
                        $i$f$nearestAncestor64DMado = nodes$ui_release;
                        delegatableNode = count$iv$iv;
                        Intrinsics.reifiedOperationMarker(3, "T");
                        it = node$iv$iv2;
                        int i11 = 0;
                        i2 = it;
                        if (kindSet$ui_release2 &= type != 0) {
                        } else {
                        }
                        $i$f$isKindH91voCI$ui_release = 0;
                        if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        includeSelf$iv2 = includeSelf$iv;
                        i8 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        node$iv$iv2 = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv);
                        nodes$ui_release = $i$f$nearestAncestor64DMado;
                        count$iv$iv = delegatableNode;
                        includeSelf$iv = includeSelf$iv2;
                        $i$f$visitAncestorsYYKmho = i8;
                        obj = obj2;
                        if (node$iv$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        $i$f$isKindH91voCI$ui_release = 0;
                        i2 = 0;
                        node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            it = node$iv$iv$iv;
                            i5 = 0;
                            count$iv$iv2 = 0;
                            if (kindSet$ui_release3 &= type != 0) {
                            } else {
                            }
                            this_$iv$iv$iv = 0;
                            if (this_$iv$iv$iv != 0) {
                            } else {
                            }
                            includeSelf$iv2 = includeSelf$iv;
                            i8 = $i$f$visitAncestorsYYKmho;
                            obj2 = obj;
                            mask$iv$iv = 0;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            includeSelf$iv = includeSelf$iv2;
                            $i$f$visitAncestorsYYKmho = i8;
                            obj = obj2;
                            $i$f$isKindH91voCI$ui_release++;
                            includeSelf$iv2 = includeSelf$iv;
                            if ($i$f$isKindH91voCI$ui_release == 1) {
                            } else {
                            }
                            if ((MutableVector)stack$iv$iv == 0) {
                            } else {
                            }
                            count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                            i8 = $i$f$visitAncestorsYYKmho;
                            obj2 = obj;
                            mask$iv$iv = 0;
                            stack$iv$iv = $i$f$mutableVectorOf;
                            Modifier.Node node4 = node$iv$iv2;
                            int i13 = stack$iv$iv;
                            if ((Modifier.Node)node4 != null && (MutableVector)i13 != 0) {
                            }
                            includeSelf$iv = stack$iv$iv;
                            if ((MutableVector)includeSelf$iv != 0) {
                            }
                            $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                            (MutableVector)includeSelf$iv.add(it);
                            i13 = stack$iv$iv;
                            if ((MutableVector)(MutableVector)i13 != 0) {
                            }
                            node$iv$iv2 = $i$f$mutableVectorOf;
                            (MutableVector)(MutableVector)i13.add((Modifier.Node)node4);
                            count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                            i4 = 0;
                            i6 = i12;
                            i8 = $i$f$visitAncestorsYYKmho;
                            obj2 = obj;
                            $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                            $i$f$isKindH91voCI$ui_release = $i$f$mutableVectorOf;
                            node$iv$iv2 = it;
                            i8 = $i$f$visitAncestorsYYKmho;
                            obj2 = obj;
                            mask$iv$iv = 0;
                            this_$iv$iv$iv = 1;
                        }
                        if ($i$f$isKindH91voCI$ui_release == 1) {
                        } else {
                        }
                        nodes$ui_release = $i$f$nearestAncestor64DMado;
                        count$iv$iv = delegatableNode;
                        includeSelf$iv = includeSelf$iv2;
                        $i$f$visitAncestorsYYKmho = i8;
                        obj = obj2;
                        it = node$iv$iv$iv;
                        i5 = 0;
                        count$iv$iv2 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        includeSelf$iv2 = includeSelf$iv;
                        i8 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        mask$iv$iv = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        includeSelf$iv = includeSelf$iv2;
                        $i$f$visitAncestorsYYKmho = i8;
                        obj = obj2;
                        $i$f$isKindH91voCI$ui_release++;
                        includeSelf$iv2 = includeSelf$iv;
                        if ($i$f$isKindH91voCI$ui_release == 1) {
                        } else {
                        }
                        if ((MutableVector)stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                        i8 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        mask$iv$iv = 0;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node4 = node$iv$iv2;
                        i13 = stack$iv$iv;
                        if ((Modifier.Node)node4 != null && (MutableVector)i13 != 0) {
                        }
                        includeSelf$iv = stack$iv$iv;
                        if ((MutableVector)includeSelf$iv != 0) {
                        }
                        $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                        (MutableVector)includeSelf$iv.add(it);
                        i13 = stack$iv$iv;
                        if ((MutableVector)(MutableVector)i13 != 0) {
                        }
                        node$iv$iv2 = $i$f$mutableVectorOf;
                        (MutableVector)(MutableVector)i13.add((Modifier.Node)node4);
                        count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                        i4 = 0;
                        i6 = i12;
                        i8 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        $i$f$isKindH91voCI$ui_release = $i$f$mutableVectorOf;
                        node$iv$iv2 = it;
                        i8 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        mask$iv$iv = 0;
                        this_$iv$iv$iv = 1;
                        $i$f$isKindH91voCI$ui_release = 1;
                    }
                    $i$f$nearestAncestor64DMado = nodes$ui_release;
                    delegatableNode = count$iv$iv;
                    includeSelf$iv2 = includeSelf$iv;
                    i8 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    $i$f$nearestAncestor64DMado = nodes$ui_release;
                    delegatableNode = count$iv$iv;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    it = node$iv$iv2;
                    i11 = 0;
                    i2 = it;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    includeSelf$iv2 = includeSelf$iv;
                    i8 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    node$iv$iv2 = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv);
                    nodes$ui_release = $i$f$nearestAncestor64DMado;
                    count$iv$iv = delegatableNode;
                    includeSelf$iv = includeSelf$iv2;
                    $i$f$visitAncestorsYYKmho = i8;
                    obj = obj2;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    i2 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        it = node$iv$iv$iv;
                        i5 = 0;
                        count$iv$iv2 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        includeSelf$iv2 = includeSelf$iv;
                        i8 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        mask$iv$iv = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        includeSelf$iv = includeSelf$iv2;
                        $i$f$visitAncestorsYYKmho = i8;
                        obj = obj2;
                        $i$f$isKindH91voCI$ui_release++;
                        includeSelf$iv2 = includeSelf$iv;
                        if ($i$f$isKindH91voCI$ui_release == 1) {
                        } else {
                        }
                        if ((MutableVector)stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                        i8 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        mask$iv$iv = 0;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node4 = node$iv$iv2;
                        i13 = stack$iv$iv;
                        if ((Modifier.Node)node4 != null && (MutableVector)i13 != 0) {
                        }
                        includeSelf$iv = stack$iv$iv;
                        if ((MutableVector)includeSelf$iv != 0) {
                        }
                        $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                        (MutableVector)includeSelf$iv.add(it);
                        i13 = stack$iv$iv;
                        if ((MutableVector)(MutableVector)i13 != 0) {
                        }
                        node$iv$iv2 = $i$f$mutableVectorOf;
                        (MutableVector)(MutableVector)i13.add((Modifier.Node)node4);
                        count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                        i4 = 0;
                        i6 = i12;
                        i8 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        $i$f$isKindH91voCI$ui_release = $i$f$mutableVectorOf;
                        node$iv$iv2 = it;
                        i8 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        mask$iv$iv = 0;
                        this_$iv$iv$iv = 1;
                    }
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    nodes$ui_release = $i$f$nearestAncestor64DMado;
                    count$iv$iv = delegatableNode;
                    includeSelf$iv = includeSelf$iv2;
                    $i$f$visitAncestorsYYKmho = i8;
                    obj = obj2;
                    it = node$iv$iv$iv;
                    i5 = 0;
                    count$iv$iv2 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    includeSelf$iv2 = includeSelf$iv;
                    i8 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    mask$iv$iv = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    includeSelf$iv = includeSelf$iv2;
                    $i$f$visitAncestorsYYKmho = i8;
                    obj = obj2;
                    $i$f$isKindH91voCI$ui_release++;
                    includeSelf$iv2 = includeSelf$iv;
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    if ((MutableVector)stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                    i8 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    mask$iv$iv = 0;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node4 = node$iv$iv2;
                    i13 = stack$iv$iv;
                    if ((Modifier.Node)node4 != null && (MutableVector)i13 != 0) {
                    }
                    includeSelf$iv = stack$iv$iv;
                    if ((MutableVector)includeSelf$iv != 0) {
                    }
                    $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                    (MutableVector)includeSelf$iv.add(it);
                    i13 = stack$iv$iv;
                    if ((MutableVector)(MutableVector)i13 != 0) {
                    }
                    node$iv$iv2 = $i$f$mutableVectorOf;
                    (MutableVector)(MutableVector)i13.add((Modifier.Node)node4);
                    count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                    i4 = 0;
                    i6 = i12;
                    i8 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    $i$f$isKindH91voCI$ui_release = $i$f$mutableVectorOf;
                    node$iv$iv2 = it;
                    i8 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    mask$iv$iv = 0;
                    this_$iv$iv$iv = 1;
                    $i$f$isKindH91voCI$ui_release = 1;
                }
                $i$f$nearestAncestor64DMado = nodes$ui_release;
                delegatableNode = count$iv$iv;
                includeSelf$iv2 = includeSelf$iv;
                i8 = $i$f$visitAncestorsYYKmho;
                obj2 = obj;
                node$iv$iv3 = 0;
                if (kindSet$ui_release &= obj != 0) {
                } else {
                }
                $i$f$nearestAncestor64DMado = nodes$ui_release;
                delegatableNode = count$iv$iv;
                includeSelf$iv2 = includeSelf$iv;
                i8 = $i$f$visitAncestorsYYKmho;
                obj2 = obj;
                node$iv$iv3 = 0;
                node$iv$iv = node$iv$iv.getParent$ui_release();
                nodes$ui_release = $i$f$nearestAncestor64DMado;
                count$iv$iv = delegatableNode;
                includeSelf$iv = includeSelf$iv2;
                $i$f$visitAncestorsYYKmho = i8;
                obj = obj2;
                i = 0;
                i7 = 0;
                stack$iv$iv = 0;
                i15 = 0;
                node$iv$iv2 = node$iv$iv4;
                node$iv$iv3 = 0;
                while (node$iv$iv2 != null) {
                    $i$f$nearestAncestor64DMado = nodes$ui_release;
                    delegatableNode = count$iv$iv;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    it = node$iv$iv2;
                    i11 = 0;
                    i2 = it;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    includeSelf$iv2 = includeSelf$iv;
                    i8 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    node$iv$iv2 = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv);
                    nodes$ui_release = $i$f$nearestAncestor64DMado;
                    count$iv$iv = delegatableNode;
                    includeSelf$iv = includeSelf$iv2;
                    $i$f$visitAncestorsYYKmho = i8;
                    obj = obj2;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    i2 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        it = node$iv$iv$iv;
                        i5 = 0;
                        count$iv$iv2 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        includeSelf$iv2 = includeSelf$iv;
                        i8 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        mask$iv$iv = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        includeSelf$iv = includeSelf$iv2;
                        $i$f$visitAncestorsYYKmho = i8;
                        obj = obj2;
                        $i$f$isKindH91voCI$ui_release++;
                        includeSelf$iv2 = includeSelf$iv;
                        if ($i$f$isKindH91voCI$ui_release == 1) {
                        } else {
                        }
                        if ((MutableVector)stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                        i8 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        mask$iv$iv = 0;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node4 = node$iv$iv2;
                        i13 = stack$iv$iv;
                        if ((Modifier.Node)node4 != null && (MutableVector)i13 != 0) {
                        }
                        includeSelf$iv = stack$iv$iv;
                        if ((MutableVector)includeSelf$iv != 0) {
                        }
                        $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                        (MutableVector)includeSelf$iv.add(it);
                        i13 = stack$iv$iv;
                        if ((MutableVector)(MutableVector)i13 != 0) {
                        }
                        node$iv$iv2 = $i$f$mutableVectorOf;
                        (MutableVector)(MutableVector)i13.add((Modifier.Node)node4);
                        count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                        i4 = 0;
                        i6 = i12;
                        i8 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        $i$f$isKindH91voCI$ui_release = $i$f$mutableVectorOf;
                        node$iv$iv2 = it;
                        i8 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        mask$iv$iv = 0;
                        this_$iv$iv$iv = 1;
                    }
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    nodes$ui_release = $i$f$nearestAncestor64DMado;
                    count$iv$iv = delegatableNode;
                    includeSelf$iv = includeSelf$iv2;
                    $i$f$visitAncestorsYYKmho = i8;
                    obj = obj2;
                    it = node$iv$iv$iv;
                    i5 = 0;
                    count$iv$iv2 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    includeSelf$iv2 = includeSelf$iv;
                    i8 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    mask$iv$iv = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    includeSelf$iv = includeSelf$iv2;
                    $i$f$visitAncestorsYYKmho = i8;
                    obj = obj2;
                    $i$f$isKindH91voCI$ui_release++;
                    includeSelf$iv2 = includeSelf$iv;
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    if ((MutableVector)stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                    i8 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    mask$iv$iv = 0;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node4 = node$iv$iv2;
                    i13 = stack$iv$iv;
                    if ((Modifier.Node)node4 != null && (MutableVector)i13 != 0) {
                    }
                    includeSelf$iv = stack$iv$iv;
                    if ((MutableVector)includeSelf$iv != 0) {
                    }
                    $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                    (MutableVector)includeSelf$iv.add(it);
                    i13 = stack$iv$iv;
                    if ((MutableVector)(MutableVector)i13 != 0) {
                    }
                    node$iv$iv2 = $i$f$mutableVectorOf;
                    (MutableVector)(MutableVector)i13.add((Modifier.Node)node4);
                    count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                    i4 = 0;
                    i6 = i12;
                    i8 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    $i$f$isKindH91voCI$ui_release = $i$f$mutableVectorOf;
                    node$iv$iv2 = it;
                    i8 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    mask$iv$iv = 0;
                    this_$iv$iv$iv = 1;
                    $i$f$isKindH91voCI$ui_release = 1;
                }
                $i$f$nearestAncestor64DMado = nodes$ui_release;
                delegatableNode = count$iv$iv;
                includeSelf$iv2 = includeSelf$iv;
                i8 = $i$f$visitAncestorsYYKmho;
                obj2 = obj;
                $i$f$nearestAncestor64DMado = nodes$ui_release;
                delegatableNode = count$iv$iv;
                Intrinsics.reifiedOperationMarker(3, "T");
                it = node$iv$iv2;
                i11 = 0;
                i2 = it;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                $i$f$isKindH91voCI$ui_release = 0;
                if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                includeSelf$iv2 = includeSelf$iv;
                i8 = $i$f$visitAncestorsYYKmho;
                obj2 = obj;
                node$iv$iv2 = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv);
                nodes$ui_release = $i$f$nearestAncestor64DMado;
                count$iv$iv = delegatableNode;
                includeSelf$iv = includeSelf$iv2;
                $i$f$visitAncestorsYYKmho = i8;
                obj = obj2;
                if (node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                $i$f$isKindH91voCI$ui_release = 0;
                i2 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    it = node$iv$iv$iv;
                    i5 = 0;
                    count$iv$iv2 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    includeSelf$iv2 = includeSelf$iv;
                    i8 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    mask$iv$iv = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    includeSelf$iv = includeSelf$iv2;
                    $i$f$visitAncestorsYYKmho = i8;
                    obj = obj2;
                    $i$f$isKindH91voCI$ui_release++;
                    includeSelf$iv2 = includeSelf$iv;
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    if ((MutableVector)stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                    i8 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    mask$iv$iv = 0;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node4 = node$iv$iv2;
                    i13 = stack$iv$iv;
                    if ((Modifier.Node)node4 != null && (MutableVector)i13 != 0) {
                    }
                    includeSelf$iv = stack$iv$iv;
                    if ((MutableVector)includeSelf$iv != 0) {
                    }
                    $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                    (MutableVector)includeSelf$iv.add(it);
                    i13 = stack$iv$iv;
                    if ((MutableVector)(MutableVector)i13 != 0) {
                    }
                    node$iv$iv2 = $i$f$mutableVectorOf;
                    (MutableVector)(MutableVector)i13.add((Modifier.Node)node4);
                    count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                    i4 = 0;
                    i6 = i12;
                    i8 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    $i$f$isKindH91voCI$ui_release = $i$f$mutableVectorOf;
                    node$iv$iv2 = it;
                    i8 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    mask$iv$iv = 0;
                    this_$iv$iv$iv = 1;
                }
                if ($i$f$isKindH91voCI$ui_release == 1) {
                } else {
                }
                nodes$ui_release = $i$f$nearestAncestor64DMado;
                count$iv$iv = delegatableNode;
                includeSelf$iv = includeSelf$iv2;
                $i$f$visitAncestorsYYKmho = i8;
                obj = obj2;
                it = node$iv$iv$iv;
                i5 = 0;
                count$iv$iv2 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                includeSelf$iv2 = includeSelf$iv;
                i8 = $i$f$visitAncestorsYYKmho;
                obj2 = obj;
                mask$iv$iv = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                includeSelf$iv = includeSelf$iv2;
                $i$f$visitAncestorsYYKmho = i8;
                obj = obj2;
                $i$f$isKindH91voCI$ui_release++;
                includeSelf$iv2 = includeSelf$iv;
                if ($i$f$isKindH91voCI$ui_release == 1) {
                } else {
                }
                if ((MutableVector)stack$iv$iv == 0) {
                } else {
                }
                count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                i8 = $i$f$visitAncestorsYYKmho;
                obj2 = obj;
                mask$iv$iv = 0;
                stack$iv$iv = $i$f$mutableVectorOf;
                node4 = node$iv$iv2;
                i13 = stack$iv$iv;
                if ((Modifier.Node)node4 != null && (MutableVector)i13 != 0) {
                }
                includeSelf$iv = stack$iv$iv;
                if ((MutableVector)includeSelf$iv != 0) {
                }
                $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                (MutableVector)includeSelf$iv.add(it);
                i13 = stack$iv$iv;
                if ((MutableVector)(MutableVector)i13 != 0) {
                }
                node$iv$iv2 = $i$f$mutableVectorOf;
                (MutableVector)(MutableVector)i13.add((Modifier.Node)node4);
                count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                i4 = 0;
                i6 = i12;
                i8 = $i$f$visitAncestorsYYKmho;
                obj2 = obj;
                $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                $i$f$isKindH91voCI$ui_release = $i$f$mutableVectorOf;
                node$iv$iv2 = it;
                i8 = $i$f$visitAncestorsYYKmho;
                obj2 = obj;
                mask$iv$iv = 0;
                this_$iv$iv$iv = 1;
                $i$f$isKindH91voCI$ui_release = 1;
            }
            return 0;
        }
        int i17 = nodes$ui_release;
        androidx.compose.ui.node.DelegatableNode delegatableNode3 = count$iv$iv;
        int $i$f$nearestAncestor64DMado2 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv;
    }

    private static final Modifier.Node pop(MutableVector<Modifier.Node> $this$pop) {
        Object obj;
        boolean empty;
        if ($this$pop != null) {
            if ($this$pop.isEmpty()) {
                obj = 0;
            } else {
                obj = $this$pop.removeAt(size--);
            }
        } else {
        }
        return obj;
    }

    public static final androidx.compose.ui.node.NodeCoordinator requireCoordinator-64DMado(androidx.compose.ui.node.DelegatableNode $this$requireCoordinator_u2d64DMado, int kind) {
        Modifier.Node includeSelfInTraversal-H91voCI;
        androidx.compose.ui.node.NodeCoordinator wrapped$ui_release;
        androidx.compose.ui.node.NodeCoordinator coordinator$ui_release = $this$requireCoordinator_u2d64DMado.getNode().getCoordinator$ui_release();
        Intrinsics.checkNotNull(coordinator$ui_release);
        if (coordinator$ui_release.getTail() != $this$requireCoordinator_u2d64DMado) {
            wrapped$ui_release = coordinator$ui_release;
        } else {
            if (NodeKindKt.getIncludeSelfInTraversal-H91voCI(kind)) {
                Intrinsics.checkNotNull(coordinator$ui_release.getWrapped$ui_release());
            } else {
            }
        }
        return wrapped$ui_release;
    }

    public static final Density requireDensity(androidx.compose.ui.node.DelegatableNode $this$requireDensity) {
        return DelegatableNodeKt.requireLayoutNode($this$requireDensity).getDensity();
    }

    public static final GraphicsContext requireGraphicsContext(androidx.compose.ui.node.DelegatableNode $this$requireGraphicsContext) {
        return DelegatableNodeKt.requireOwner($this$requireGraphicsContext).getGraphicsContext();
    }

    public static final LayoutCoordinates requireLayoutCoordinates(androidx.compose.ui.node.DelegatableNode $this$requireLayoutCoordinates) {
        String $i$a$CheckPreconditionDelegatableNodeKt$requireLayoutCoordinates$1;
        String $i$a$CheckPreconditionDelegatableNodeKt$requireLayoutCoordinates$2;
        int i = 0;
        if (!$this$requireLayoutCoordinates.getNode().isAttached()) {
            int i3 = 0;
            InlineClassHelperKt.throwIllegalStateException("Cannot get LayoutCoordinates, Modifier.Node is not attached.");
        }
        int value$iv = 0;
        LayoutCoordinates coordinates = DelegatableNodeKt.requireCoordinator-64DMado($this$requireLayoutCoordinates, NodeKind.constructor-impl(2)).getCoordinates();
        int i4 = 0;
        if (!coordinates.isAttached()) {
            int i5 = 0;
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates is not attached.");
        }
        return coordinates;
    }

    public static final LayoutDirection requireLayoutDirection(androidx.compose.ui.node.DelegatableNode $this$requireLayoutDirection) {
        return DelegatableNodeKt.requireLayoutNode($this$requireLayoutDirection).getLayoutDirection();
    }

    public static final androidx.compose.ui.node.LayoutNode requireLayoutNode(androidx.compose.ui.node.DelegatableNode $this$requireLayoutNode) {
        androidx.compose.ui.node.NodeCoordinator coordinator$ui_release = $this$requireLayoutNode.getNode().getCoordinator$ui_release();
        final int i = 0;
        if (coordinator$ui_release == null) {
        } else {
            return coordinator$ui_release.getLayoutNode();
        }
        int i2 = 0;
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Cannot obtain node coordinator. Is the Modifier.Node attached?");
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final androidx.compose.ui.node.Owner requireOwner(androidx.compose.ui.node.DelegatableNode $this$requireOwner) {
        androidx.compose.ui.node.Owner owner$ui_release = DelegatableNodeKt.requireLayoutNode($this$requireOwner).getOwner$ui_release();
        final int i = 0;
        if (owner$ui_release == null) {
        } else {
            return owner$ui_release;
        }
        int i2 = 0;
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("This node does not have an owner.");
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final void visitAncestors(androidx.compose.ui.node.DelegatableNode $this$visitAncestors, int mask, boolean includeSelf, Function1<? super Modifier.Node, Unit> block) {
        Modifier.Node node;
        androidx.compose.ui.node.LayoutNode layout;
        Modifier.Node head$ui_release;
        int tail$ui_release;
        int nodes$ui_release;
        final int i = 0;
        if (!$this$visitAncestors.getNode().isAttached()) {
        } else {
            if (includeSelf) {
            } else {
                node = $this$visitAncestors.getNode().getParent$ui_release();
            }
            layout = DelegatableNodeKt.requireLayoutNode($this$visitAncestors);
            while (layout != null) {
                if (aggregateChildKindSet$ui_release &= mask != 0) {
                }
                layout = layout.getParent$ui_release();
                nodes$ui_release = layout.getNodes$ui_release();
                if (layout != null && nodes$ui_release != null) {
                } else {
                }
                tail$ui_release = 0;
                node = tail$ui_release;
                nodes$ui_release = layout.getNodes$ui_release();
                if (nodes$ui_release != null) {
                } else {
                }
                tail$ui_release = nodes$ui_release.getTail$ui_release();
                while (node != null) {
                    if (kindSet$ui_release &= mask != 0) {
                    }
                    node = node.getParent$ui_release();
                    block.invoke(node);
                }
                if (kindSet$ui_release &= mask != 0) {
                }
                node = node.getParent$ui_release();
                block.invoke(node);
            }
        }
        int node3 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1 = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1;
    }

    public static void visitAncestors$default(androidx.compose.ui.node.DelegatableNode $this$visitAncestors_u24default, int mask, boolean includeSelf, Function1 block, int i5, Object object6) {
        androidx.compose.ui.node.LayoutNode layout;
        Modifier.Node head$ui_release;
        Modifier.Node tail$ui_release;
        int nodes$ui_release;
        int obj5;
        Modifier.Node obj8;
        if (i5 &= 2 != 0) {
            obj5 = 0;
        }
        int obj7 = 0;
        if (!$this$visitAncestors_u24default.getNode().isAttached()) {
        } else {
            if (obj5 != null) {
            } else {
                obj8 = $this$visitAncestors_u24default.getNode().getParent$ui_release();
            }
            layout = DelegatableNodeKt.requireLayoutNode($this$visitAncestors_u24default);
            while (layout != null) {
                if (aggregateChildKindSet$ui_release &= mask != 0) {
                }
                layout = layout.getParent$ui_release();
                nodes$ui_release = layout.getNodes$ui_release();
                if (layout != null && nodes$ui_release != null) {
                } else {
                }
                tail$ui_release = 0;
                obj8 = tail$ui_release;
                nodes$ui_release = layout.getNodes$ui_release();
                if (nodes$ui_release != null) {
                } else {
                }
                tail$ui_release = nodes$ui_release.getTail$ui_release();
                while (obj8 != null) {
                    if (kindSet$ui_release &= mask != 0) {
                    }
                    obj8 = obj8.getParent$ui_release();
                    block.invoke(obj8);
                }
                if (kindSet$ui_release &= mask != 0) {
                }
                obj8 = obj8.getParent$ui_release();
                block.invoke(obj8);
            }
        }
        obj8 = 0;
        obj8 = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw obj8;
    }

    public static final <T> void visitAncestors-Y-YKmho(androidx.compose.ui.node.DelegatableNode $this$visitAncestors_u2dY_u2dYKmho, int type, boolean includeSelf, Function1<? super T, Unit> block) {
        int nodes$ui_release;
        Modifier.Node tail$ui_release;
        int mask$iv2;
        int capacity$iv$iv$iv;
        androidx.compose.ui.node.DelegatableNode delegatableNode;
        int $this$visitAncestors$iv2;
        int i7;
        Modifier.Node node$iv2;
        androidx.compose.ui.node.LayoutNode layout$iv;
        Modifier.Node head$ui_release;
        int i10;
        int i6;
        Modifier.Node node2;
        int i9;
        int stack$iv;
        Modifier.Node node$iv;
        Object obj;
        String this_$iv$iv2;
        Modifier.Node node;
        int i;
        int i11;
        Modifier.Node node$iv$iv;
        int i3;
        int mask$iv;
        int this_$iv$iv;
        int i2;
        int i5;
        androidx.compose.ui.node.DelegatableNode $this$visitAncestors$iv;
        int i4;
        int i8;
        delegatableNode = $this$visitAncestors_u2dY_u2dYKmho;
        i7 = 0;
        if (!delegatableNode.getNode().isAttached()) {
        } else {
            if (includeSelf) {
            } else {
                node$iv2 = delegatableNode.getNode().getParent$ui_release();
            }
            layout$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode);
            while (layout$iv != null) {
                if (aggregateChildKindSet$ui_release &= mask$iv2 != 0) {
                } else {
                }
                obj = block;
                i11 = nodes$ui_release;
                mask$iv = mask$iv2;
                $this$visitAncestors$iv = delegatableNode;
                i4 = i7;
                layout$iv = layout$iv.getParent$ui_release();
                nodes$ui_release = layout$iv.getNodes$ui_release();
                if (layout$iv != null && nodes$ui_release != null) {
                } else {
                }
                tail$ui_release = 0;
                node$iv2 = tail$ui_release;
                nodes$ui_release = i11;
                mask$iv2 = mask$iv;
                delegatableNode = $this$visitAncestors$iv;
                i7 = i4;
                nodes$ui_release = layout$iv.getNodes$ui_release();
                if (nodes$ui_release != null) {
                } else {
                }
                tail$ui_release = nodes$ui_release.getTail$ui_release();
                while (node$iv2 != null) {
                    if (kindSet$ui_release &= mask$iv2 != 0) {
                    } else {
                    }
                    obj = block;
                    i11 = nodes$ui_release;
                    mask$iv = mask$iv2;
                    $this$visitAncestors$iv = delegatableNode;
                    i4 = i7;
                    node$iv2 = node$iv2.getParent$ui_release();
                    nodes$ui_release = i11;
                    mask$iv2 = mask$iv;
                    delegatableNode = $this$visitAncestors$iv;
                    i7 = i4;
                    i6 = 0;
                    i9 = 0;
                    stack$iv = 0;
                    int i16 = 0;
                    node$iv = node2;
                    while (node$iv != null) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (node$iv instanceof Object != null) {
                        } else {
                        }
                        obj = block;
                        node = 0;
                        if (kindSet$ui_release2 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv2 = 0;
                        if (this_$iv$iv2 != 0 && node$iv instanceof DelegatingNode) {
                        } else {
                        }
                        mask$iv = mask$iv2;
                        $this$visitAncestors$iv = delegatableNode;
                        i4 = i7;
                        node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                        nodes$ui_release = i11;
                        mask$iv2 = mask$iv;
                        delegatableNode = $this$visitAncestors$iv;
                        i7 = i4;
                        if (node$iv instanceof DelegatingNode) {
                        } else {
                        }
                        this_$iv$iv2 = 0;
                        i = 0;
                        node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                        while (node$iv$iv != null) {
                            nodes$ui_release = node$iv$iv;
                            i3 = 0;
                            i2 = 0;
                            if (kindSet$ui_release3 &= type != 0) {
                            } else {
                            }
                            this_$iv$iv = 0;
                            if (this_$iv$iv != 0) {
                            } else {
                            }
                            mask$iv = mask$iv2;
                            $this$visitAncestors$iv = delegatableNode;
                            i4 = i7;
                            capacity$iv$iv$iv = 0;
                            node$iv$iv = node$iv$iv.getChild$ui_release();
                            mask$iv2 = mask$iv;
                            delegatableNode = $this$visitAncestors$iv;
                            i7 = i4;
                            mask$iv = mask$iv2;
                            if (this_$iv$iv2++ == 1) {
                            } else {
                            }
                            int i13 = stack$iv;
                            if ((MutableVector)i13 == 0) {
                            } else {
                            }
                            $this$visitAncestors$iv = delegatableNode;
                            i4 = i7;
                            $this$visitAncestors$iv2 = i13;
                            capacity$iv$iv$iv = 0;
                            stack$iv = $this$visitAncestors$iv2;
                            delegatableNode = node$iv;
                            int i15 = stack$iv;
                            if ((Modifier.Node)delegatableNode != null && (MutableVector)i15 != 0) {
                            }
                            i7 = stack$iv;
                            if ((MutableVector)i7 != 0) {
                            }
                            (MutableVector)i7.add(nodes$ui_release);
                            i15 = stack$iv;
                            if ((MutableVector)(MutableVector)i15 != 0) {
                            }
                            node$iv = i7;
                            (MutableVector)(MutableVector)i15.add((Modifier.Node)delegatableNode);
                            i2 = i14;
                            int $i$f$mutableVectorOf = 16;
                            i5 = 0;
                            $this$visitAncestors$iv = delegatableNode;
                            i4 = i7;
                            i8 = $i$f$mutableVectorOf;
                            $this$visitAncestors$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                            i7 = $this$visitAncestors$iv2;
                            node$iv = nodes$ui_release;
                            $this$visitAncestors$iv = delegatableNode;
                            i4 = i7;
                            capacity$iv$iv$iv = 0;
                            this_$iv$iv = 1;
                        }
                        if (this_$iv$iv2 == 1) {
                        } else {
                        }
                        nodes$ui_release = i11;
                        mask$iv2 = mask$iv;
                        delegatableNode = $this$visitAncestors$iv;
                        i7 = i4;
                        nodes$ui_release = node$iv$iv;
                        i3 = 0;
                        i2 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv = 0;
                        if (this_$iv$iv != 0) {
                        } else {
                        }
                        mask$iv = mask$iv2;
                        $this$visitAncestors$iv = delegatableNode;
                        i4 = i7;
                        capacity$iv$iv$iv = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        mask$iv2 = mask$iv;
                        delegatableNode = $this$visitAncestors$iv;
                        i7 = i4;
                        mask$iv = mask$iv2;
                        if (this_$iv$iv2++ == 1) {
                        } else {
                        }
                        i13 = stack$iv;
                        if ((MutableVector)(MutableVector)i13 == 0) {
                        } else {
                        }
                        $this$visitAncestors$iv = delegatableNode;
                        i4 = i7;
                        $this$visitAncestors$iv2 = i13;
                        capacity$iv$iv$iv = 0;
                        stack$iv = $this$visitAncestors$iv2;
                        delegatableNode = node$iv;
                        i15 = stack$iv;
                        if ((Modifier.Node)delegatableNode != null && (MutableVector)i15 != 0) {
                        }
                        i7 = stack$iv;
                        if ((MutableVector)i7 != 0) {
                        }
                        (MutableVector)i7.add(nodes$ui_release);
                        i15 = stack$iv;
                        if ((MutableVector)(MutableVector)i15 != 0) {
                        }
                        node$iv = i7;
                        (MutableVector)(MutableVector)i15.add((Modifier.Node)delegatableNode);
                        i2 = i14;
                        $i$f$mutableVectorOf = 16;
                        i5 = 0;
                        $this$visitAncestors$iv = delegatableNode;
                        i4 = i7;
                        i8 = $i$f$mutableVectorOf;
                        $this$visitAncestors$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        i7 = $this$visitAncestors$iv2;
                        node$iv = nodes$ui_release;
                        $this$visitAncestors$iv = delegatableNode;
                        i4 = i7;
                        capacity$iv$iv$iv = 0;
                        this_$iv$iv = 1;
                        this_$iv$iv2 = 1;
                        block.invoke(node$iv);
                        i11 = nodes$ui_release;
                        mask$iv = mask$iv2;
                        $this$visitAncestors$iv = delegatableNode;
                        i4 = i7;
                    }
                    obj = block;
                    i11 = nodes$ui_release;
                    mask$iv = mask$iv2;
                    $this$visitAncestors$iv = delegatableNode;
                    i4 = i7;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (node$iv instanceof Object != null) {
                    } else {
                    }
                    obj = block;
                    node = 0;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    if (this_$iv$iv2 != 0 && node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv = mask$iv2;
                    $this$visitAncestors$iv = delegatableNode;
                    i4 = i7;
                    node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                    nodes$ui_release = i11;
                    mask$iv2 = mask$iv;
                    delegatableNode = $this$visitAncestors$iv;
                    i7 = i4;
                    if (node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    i = 0;
                    node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        nodes$ui_release = node$iv$iv;
                        i3 = 0;
                        i2 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv = 0;
                        if (this_$iv$iv != 0) {
                        } else {
                        }
                        mask$iv = mask$iv2;
                        $this$visitAncestors$iv = delegatableNode;
                        i4 = i7;
                        capacity$iv$iv$iv = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        mask$iv2 = mask$iv;
                        delegatableNode = $this$visitAncestors$iv;
                        i7 = i4;
                        mask$iv = mask$iv2;
                        if (this_$iv$iv2++ == 1) {
                        } else {
                        }
                        i13 = stack$iv;
                        if ((MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                        } else {
                        }
                        $this$visitAncestors$iv = delegatableNode;
                        i4 = i7;
                        $this$visitAncestors$iv2 = i13;
                        capacity$iv$iv$iv = 0;
                        stack$iv = $this$visitAncestors$iv2;
                        delegatableNode = node$iv;
                        i15 = stack$iv;
                        if ((Modifier.Node)delegatableNode != null && (MutableVector)i15 != 0) {
                        }
                        i7 = stack$iv;
                        if ((MutableVector)i7 != 0) {
                        }
                        (MutableVector)i7.add(nodes$ui_release);
                        i15 = stack$iv;
                        if ((MutableVector)(MutableVector)i15 != 0) {
                        }
                        node$iv = i7;
                        (MutableVector)(MutableVector)i15.add((Modifier.Node)delegatableNode);
                        i2 = i14;
                        $i$f$mutableVectorOf = 16;
                        i5 = 0;
                        $this$visitAncestors$iv = delegatableNode;
                        i4 = i7;
                        i8 = $i$f$mutableVectorOf;
                        $this$visitAncestors$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        i7 = $this$visitAncestors$iv2;
                        node$iv = nodes$ui_release;
                        $this$visitAncestors$iv = delegatableNode;
                        i4 = i7;
                        capacity$iv$iv$iv = 0;
                        this_$iv$iv = 1;
                    }
                    if (this_$iv$iv2 == 1) {
                    } else {
                    }
                    nodes$ui_release = i11;
                    mask$iv2 = mask$iv;
                    delegatableNode = $this$visitAncestors$iv;
                    i7 = i4;
                    nodes$ui_release = node$iv$iv;
                    i3 = 0;
                    i2 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    mask$iv = mask$iv2;
                    $this$visitAncestors$iv = delegatableNode;
                    i4 = i7;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    mask$iv2 = mask$iv;
                    delegatableNode = $this$visitAncestors$iv;
                    i7 = i4;
                    mask$iv = mask$iv2;
                    if (this_$iv$iv2++ == 1) {
                    } else {
                    }
                    i13 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                    } else {
                    }
                    $this$visitAncestors$iv = delegatableNode;
                    i4 = i7;
                    $this$visitAncestors$iv2 = i13;
                    capacity$iv$iv$iv = 0;
                    stack$iv = $this$visitAncestors$iv2;
                    delegatableNode = node$iv;
                    i15 = stack$iv;
                    if ((Modifier.Node)delegatableNode != null && (MutableVector)i15 != 0) {
                    }
                    i7 = stack$iv;
                    if ((MutableVector)i7 != 0) {
                    }
                    (MutableVector)i7.add(nodes$ui_release);
                    i15 = stack$iv;
                    if ((MutableVector)(MutableVector)i15 != 0) {
                    }
                    node$iv = i7;
                    (MutableVector)(MutableVector)i15.add((Modifier.Node)delegatableNode);
                    i2 = i14;
                    $i$f$mutableVectorOf = 16;
                    i5 = 0;
                    $this$visitAncestors$iv = delegatableNode;
                    i4 = i7;
                    i8 = $i$f$mutableVectorOf;
                    $this$visitAncestors$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i7 = $this$visitAncestors$iv2;
                    node$iv = nodes$ui_release;
                    $this$visitAncestors$iv = delegatableNode;
                    i4 = i7;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv = 1;
                    this_$iv$iv2 = 1;
                    block.invoke(node$iv);
                    i11 = nodes$ui_release;
                    mask$iv = mask$iv2;
                    $this$visitAncestors$iv = delegatableNode;
                    i4 = i7;
                }
                obj = block;
                i11 = nodes$ui_release;
                mask$iv = mask$iv2;
                $this$visitAncestors$iv = delegatableNode;
                i4 = i7;
                if (kindSet$ui_release &= mask$iv2 != 0) {
                } else {
                }
                obj = block;
                i11 = nodes$ui_release;
                mask$iv = mask$iv2;
                $this$visitAncestors$iv = delegatableNode;
                i4 = i7;
                node$iv2 = node$iv2.getParent$ui_release();
                nodes$ui_release = i11;
                mask$iv2 = mask$iv;
                delegatableNode = $this$visitAncestors$iv;
                i7 = i4;
                i6 = 0;
                i9 = 0;
                stack$iv = 0;
                i16 = 0;
                node$iv = node2;
                while (node$iv != null) {
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (node$iv instanceof Object != null) {
                    } else {
                    }
                    obj = block;
                    node = 0;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    if (this_$iv$iv2 != 0 && node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv = mask$iv2;
                    $this$visitAncestors$iv = delegatableNode;
                    i4 = i7;
                    node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                    nodes$ui_release = i11;
                    mask$iv2 = mask$iv;
                    delegatableNode = $this$visitAncestors$iv;
                    i7 = i4;
                    if (node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    i = 0;
                    node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        nodes$ui_release = node$iv$iv;
                        i3 = 0;
                        i2 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv = 0;
                        if (this_$iv$iv != 0) {
                        } else {
                        }
                        mask$iv = mask$iv2;
                        $this$visitAncestors$iv = delegatableNode;
                        i4 = i7;
                        capacity$iv$iv$iv = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        mask$iv2 = mask$iv;
                        delegatableNode = $this$visitAncestors$iv;
                        i7 = i4;
                        mask$iv = mask$iv2;
                        if (this_$iv$iv2++ == 1) {
                        } else {
                        }
                        i13 = stack$iv;
                        if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                        } else {
                        }
                        $this$visitAncestors$iv = delegatableNode;
                        i4 = i7;
                        $this$visitAncestors$iv2 = i13;
                        capacity$iv$iv$iv = 0;
                        stack$iv = $this$visitAncestors$iv2;
                        delegatableNode = node$iv;
                        i15 = stack$iv;
                        if ((Modifier.Node)delegatableNode != null && (MutableVector)i15 != 0) {
                        }
                        i7 = stack$iv;
                        if ((MutableVector)i7 != 0) {
                        }
                        (MutableVector)i7.add(nodes$ui_release);
                        i15 = stack$iv;
                        if ((MutableVector)(MutableVector)i15 != 0) {
                        }
                        node$iv = i7;
                        (MutableVector)(MutableVector)i15.add((Modifier.Node)delegatableNode);
                        i2 = i14;
                        $i$f$mutableVectorOf = 16;
                        i5 = 0;
                        $this$visitAncestors$iv = delegatableNode;
                        i4 = i7;
                        i8 = $i$f$mutableVectorOf;
                        $this$visitAncestors$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        i7 = $this$visitAncestors$iv2;
                        node$iv = nodes$ui_release;
                        $this$visitAncestors$iv = delegatableNode;
                        i4 = i7;
                        capacity$iv$iv$iv = 0;
                        this_$iv$iv = 1;
                    }
                    if (this_$iv$iv2 == 1) {
                    } else {
                    }
                    nodes$ui_release = i11;
                    mask$iv2 = mask$iv;
                    delegatableNode = $this$visitAncestors$iv;
                    i7 = i4;
                    nodes$ui_release = node$iv$iv;
                    i3 = 0;
                    i2 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    mask$iv = mask$iv2;
                    $this$visitAncestors$iv = delegatableNode;
                    i4 = i7;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    mask$iv2 = mask$iv;
                    delegatableNode = $this$visitAncestors$iv;
                    i7 = i4;
                    mask$iv = mask$iv2;
                    if (this_$iv$iv2++ == 1) {
                    } else {
                    }
                    i13 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                    } else {
                    }
                    $this$visitAncestors$iv = delegatableNode;
                    i4 = i7;
                    $this$visitAncestors$iv2 = i13;
                    capacity$iv$iv$iv = 0;
                    stack$iv = $this$visitAncestors$iv2;
                    delegatableNode = node$iv;
                    i15 = stack$iv;
                    if ((Modifier.Node)delegatableNode != null && (MutableVector)i15 != 0) {
                    }
                    i7 = stack$iv;
                    if ((MutableVector)i7 != 0) {
                    }
                    (MutableVector)i7.add(nodes$ui_release);
                    i15 = stack$iv;
                    if ((MutableVector)(MutableVector)i15 != 0) {
                    }
                    node$iv = i7;
                    (MutableVector)(MutableVector)i15.add((Modifier.Node)delegatableNode);
                    i2 = i14;
                    $i$f$mutableVectorOf = 16;
                    i5 = 0;
                    $this$visitAncestors$iv = delegatableNode;
                    i4 = i7;
                    i8 = $i$f$mutableVectorOf;
                    $this$visitAncestors$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i7 = $this$visitAncestors$iv2;
                    node$iv = nodes$ui_release;
                    $this$visitAncestors$iv = delegatableNode;
                    i4 = i7;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv = 1;
                    this_$iv$iv2 = 1;
                    block.invoke(node$iv);
                    i11 = nodes$ui_release;
                    mask$iv = mask$iv2;
                    $this$visitAncestors$iv = delegatableNode;
                    i4 = i7;
                }
                obj = block;
                i11 = nodes$ui_release;
                mask$iv = mask$iv2;
                $this$visitAncestors$iv = delegatableNode;
                i4 = i7;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (node$iv instanceof Object != null) {
                } else {
                }
                obj = block;
                node = 0;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                this_$iv$iv2 = 0;
                if (this_$iv$iv2 != 0 && node$iv instanceof DelegatingNode) {
                } else {
                }
                mask$iv = mask$iv2;
                $this$visitAncestors$iv = delegatableNode;
                i4 = i7;
                node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                nodes$ui_release = i11;
                mask$iv2 = mask$iv;
                delegatableNode = $this$visitAncestors$iv;
                i7 = i4;
                if (node$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv2 = 0;
                i = 0;
                node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                while (node$iv$iv != null) {
                    nodes$ui_release = node$iv$iv;
                    i3 = 0;
                    i2 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    mask$iv = mask$iv2;
                    $this$visitAncestors$iv = delegatableNode;
                    i4 = i7;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    mask$iv2 = mask$iv;
                    delegatableNode = $this$visitAncestors$iv;
                    i7 = i4;
                    mask$iv = mask$iv2;
                    if (this_$iv$iv2++ == 1) {
                    } else {
                    }
                    i13 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                    } else {
                    }
                    $this$visitAncestors$iv = delegatableNode;
                    i4 = i7;
                    $this$visitAncestors$iv2 = i13;
                    capacity$iv$iv$iv = 0;
                    stack$iv = $this$visitAncestors$iv2;
                    delegatableNode = node$iv;
                    i15 = stack$iv;
                    if ((Modifier.Node)delegatableNode != null && (MutableVector)i15 != 0) {
                    }
                    i7 = stack$iv;
                    if ((MutableVector)i7 != 0) {
                    }
                    (MutableVector)i7.add(nodes$ui_release);
                    i15 = stack$iv;
                    if ((MutableVector)(MutableVector)i15 != 0) {
                    }
                    node$iv = i7;
                    (MutableVector)(MutableVector)i15.add((Modifier.Node)delegatableNode);
                    i2 = i14;
                    $i$f$mutableVectorOf = 16;
                    i5 = 0;
                    $this$visitAncestors$iv = delegatableNode;
                    i4 = i7;
                    i8 = $i$f$mutableVectorOf;
                    $this$visitAncestors$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i7 = $this$visitAncestors$iv2;
                    node$iv = nodes$ui_release;
                    $this$visitAncestors$iv = delegatableNode;
                    i4 = i7;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv = 1;
                }
                if (this_$iv$iv2 == 1) {
                } else {
                }
                nodes$ui_release = i11;
                mask$iv2 = mask$iv;
                delegatableNode = $this$visitAncestors$iv;
                i7 = i4;
                nodes$ui_release = node$iv$iv;
                i3 = 0;
                i2 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0) {
                } else {
                }
                mask$iv = mask$iv2;
                $this$visitAncestors$iv = delegatableNode;
                i4 = i7;
                capacity$iv$iv$iv = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                mask$iv2 = mask$iv;
                delegatableNode = $this$visitAncestors$iv;
                i7 = i4;
                mask$iv = mask$iv2;
                if (this_$iv$iv2++ == 1) {
                } else {
                }
                i13 = stack$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                } else {
                }
                $this$visitAncestors$iv = delegatableNode;
                i4 = i7;
                $this$visitAncestors$iv2 = i13;
                capacity$iv$iv$iv = 0;
                stack$iv = $this$visitAncestors$iv2;
                delegatableNode = node$iv;
                i15 = stack$iv;
                if ((Modifier.Node)delegatableNode != null && (MutableVector)i15 != 0) {
                }
                i7 = stack$iv;
                if ((MutableVector)i7 != 0) {
                }
                (MutableVector)i7.add(nodes$ui_release);
                i15 = stack$iv;
                if ((MutableVector)(MutableVector)i15 != 0) {
                }
                node$iv = i7;
                (MutableVector)(MutableVector)i15.add((Modifier.Node)delegatableNode);
                i2 = i14;
                $i$f$mutableVectorOf = 16;
                i5 = 0;
                $this$visitAncestors$iv = delegatableNode;
                i4 = i7;
                i8 = $i$f$mutableVectorOf;
                $this$visitAncestors$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i7 = $this$visitAncestors$iv2;
                node$iv = nodes$ui_release;
                $this$visitAncestors$iv = delegatableNode;
                i4 = i7;
                capacity$iv$iv$iv = 0;
                this_$iv$iv = 1;
                this_$iv$iv2 = 1;
                block.invoke(node$iv);
                i11 = nodes$ui_release;
                mask$iv = mask$iv2;
                $this$visitAncestors$iv = delegatableNode;
                i4 = i7;
            }
        }
        int i18 = nodes$ui_release;
        int i19 = mask$iv2;
        int $i$f$visitAncestorsYYKmho = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv;
    }

    public static void visitAncestors-Y-YKmho$default(androidx.compose.ui.node.DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default, int type, boolean includeSelf, Function1 block, int i5, Object object6) {
        int includeSelf2;
        Modifier.Node tail$ui_release;
        int $i$f$visitAncestorsYYKmho;
        int capacity$iv$iv$iv;
        Modifier.Node node;
        int mask$iv2;
        androidx.compose.ui.node.DelegatableNode delegatableNode;
        Modifier.Node node$iv2;
        androidx.compose.ui.node.LayoutNode layout$iv;
        Modifier.Node head$ui_release;
        int i7;
        int i8;
        Modifier.Node node3;
        int i9;
        int stack$iv;
        Modifier.Node node$iv;
        Object obj;
        String this_$iv$iv;
        Modifier.Node node2;
        int i2;
        Modifier.Node node$iv$iv;
        int i6;
        int $i$f$visitAncestorsYYKmho2;
        int this_$iv$iv2;
        int i4;
        int i;
        Modifier.Node mask$iv;
        androidx.compose.ui.node.DelegatableNode delegatableNode2;
        int i3;
        int obj28;
        includeSelf2 = i5 & 2 != 0 ? 0 : includeSelf;
        node = type;
        delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default;
        final int i15 = 0;
        if (!delegatableNode.getNode().isAttached()) {
        } else {
            if (includeSelf2 != 0) {
            } else {
                node$iv2 = delegatableNode.getNode().getParent$ui_release();
            }
            layout$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode);
            while (layout$iv != null) {
                if (aggregateChildKindSet$ui_release &= node != 0) {
                } else {
                }
                obj = block;
                obj28 = includeSelf2;
                $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                mask$iv = node;
                delegatableNode2 = delegatableNode;
                layout$iv = layout$iv.getParent$ui_release();
                includeSelf2 = layout$iv.getNodes$ui_release();
                if (layout$iv != null && includeSelf2 != null) {
                } else {
                }
                tail$ui_release = 0;
                node$iv2 = tail$ui_release;
                includeSelf2 = obj28;
                $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                node = mask$iv;
                delegatableNode = delegatableNode2;
                includeSelf2 = layout$iv.getNodes$ui_release();
                if (includeSelf2 != null) {
                } else {
                }
                tail$ui_release = includeSelf2.getTail$ui_release();
                while (node$iv2 != null) {
                    if (kindSet$ui_release &= node != 0) {
                    } else {
                    }
                    obj = block;
                    obj28 = includeSelf2;
                    $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                    mask$iv = node;
                    delegatableNode2 = delegatableNode;
                    node$iv2 = node$iv2.getParent$ui_release();
                    includeSelf2 = obj28;
                    $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                    node = mask$iv;
                    delegatableNode = delegatableNode2;
                    i8 = 0;
                    i9 = 0;
                    stack$iv = 0;
                    int i16 = 0;
                    node$iv = node3;
                    while (node$iv != null) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (node$iv instanceof Object != null) {
                        } else {
                        }
                        obj = block;
                        node2 = 0;
                        if (kindSet$ui_release2 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv = 0;
                        if (this_$iv$iv != 0 && node$iv instanceof DelegatingNode) {
                        } else {
                        }
                        $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                        mask$iv = node;
                        delegatableNode2 = delegatableNode;
                        node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                        includeSelf2 = obj28;
                        $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                        node = mask$iv;
                        delegatableNode = delegatableNode2;
                        if (node$iv instanceof DelegatingNode) {
                        } else {
                        }
                        this_$iv$iv = 0;
                        i2 = 0;
                        node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                        while (node$iv$iv != null) {
                            includeSelf2 = node$iv$iv;
                            i6 = 0;
                            i4 = 0;
                            if (kindSet$ui_release3 &= type != 0) {
                            } else {
                            }
                            this_$iv$iv2 = 0;
                            if (this_$iv$iv2 != 0) {
                            } else {
                            }
                            $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                            mask$iv = node;
                            delegatableNode2 = delegatableNode;
                            capacity$iv$iv$iv = 0;
                            node$iv$iv = node$iv$iv.getChild$ui_release();
                            $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                            node = mask$iv;
                            delegatableNode = delegatableNode2;
                            $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                            if (this_$iv$iv++ == 1) {
                            } else {
                            }
                            int i12 = stack$iv;
                            if ((MutableVector)i12 == 0) {
                            } else {
                            }
                            mask$iv = node;
                            delegatableNode2 = delegatableNode;
                            mask$iv2 = i12;
                            capacity$iv$iv$iv = 0;
                            stack$iv = mask$iv2;
                            node = node$iv;
                            int i14 = stack$iv;
                            if ((Modifier.Node)node != null && (MutableVector)i14 != 0) {
                            }
                            delegatableNode = stack$iv;
                            if ((MutableVector)delegatableNode != 0) {
                            }
                            (MutableVector)delegatableNode.add(includeSelf2);
                            i14 = stack$iv;
                            if ((MutableVector)(MutableVector)i14 != 0) {
                            }
                            node$iv = delegatableNode;
                            (MutableVector)(MutableVector)i14.add((Modifier.Node)node);
                            i4 = i13;
                            int $i$f$mutableVectorOf = 16;
                            i = 0;
                            mask$iv = node;
                            delegatableNode2 = delegatableNode;
                            i3 = $i$f$mutableVectorOf;
                            mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                            delegatableNode = mask$iv2;
                            node$iv = includeSelf2;
                            mask$iv = node;
                            delegatableNode2 = delegatableNode;
                            capacity$iv$iv$iv = 0;
                            this_$iv$iv2 = 1;
                        }
                        if (this_$iv$iv == 1) {
                        } else {
                        }
                        includeSelf2 = obj28;
                        $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                        node = mask$iv;
                        delegatableNode = delegatableNode2;
                        includeSelf2 = node$iv$iv;
                        i6 = 0;
                        i4 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv2 = 0;
                        if (this_$iv$iv2 != 0) {
                        } else {
                        }
                        $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                        mask$iv = node;
                        delegatableNode2 = delegatableNode;
                        capacity$iv$iv$iv = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                        node = mask$iv;
                        delegatableNode = delegatableNode2;
                        $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                        if (this_$iv$iv++ == 1) {
                        } else {
                        }
                        i12 = stack$iv;
                        if ((MutableVector)(MutableVector)i12 == 0) {
                        } else {
                        }
                        mask$iv = node;
                        delegatableNode2 = delegatableNode;
                        mask$iv2 = i12;
                        capacity$iv$iv$iv = 0;
                        stack$iv = mask$iv2;
                        node = node$iv;
                        i14 = stack$iv;
                        if ((Modifier.Node)node != null && (MutableVector)i14 != 0) {
                        }
                        delegatableNode = stack$iv;
                        if ((MutableVector)delegatableNode != 0) {
                        }
                        (MutableVector)delegatableNode.add(includeSelf2);
                        i14 = stack$iv;
                        if ((MutableVector)(MutableVector)i14 != 0) {
                        }
                        node$iv = delegatableNode;
                        (MutableVector)(MutableVector)i14.add((Modifier.Node)node);
                        i4 = i13;
                        $i$f$mutableVectorOf = 16;
                        i = 0;
                        mask$iv = node;
                        delegatableNode2 = delegatableNode;
                        i3 = $i$f$mutableVectorOf;
                        mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        delegatableNode = mask$iv2;
                        node$iv = includeSelf2;
                        mask$iv = node;
                        delegatableNode2 = delegatableNode;
                        capacity$iv$iv$iv = 0;
                        this_$iv$iv2 = 1;
                        this_$iv$iv = 1;
                        block.invoke(node$iv);
                        obj28 = includeSelf2;
                        $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                        mask$iv = node;
                        delegatableNode2 = delegatableNode;
                    }
                    obj = block;
                    obj28 = includeSelf2;
                    $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                    mask$iv = node;
                    delegatableNode2 = delegatableNode;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (node$iv instanceof Object != null) {
                    } else {
                    }
                    obj = block;
                    node2 = 0;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0 && node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                    mask$iv = node;
                    delegatableNode2 = delegatableNode;
                    node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                    includeSelf2 = obj28;
                    $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                    node = mask$iv;
                    delegatableNode = delegatableNode2;
                    if (node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    i2 = 0;
                    node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        includeSelf2 = node$iv$iv;
                        i6 = 0;
                        i4 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv2 = 0;
                        if (this_$iv$iv2 != 0) {
                        } else {
                        }
                        $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                        mask$iv = node;
                        delegatableNode2 = delegatableNode;
                        capacity$iv$iv$iv = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                        node = mask$iv;
                        delegatableNode = delegatableNode2;
                        $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                        if (this_$iv$iv++ == 1) {
                        } else {
                        }
                        i12 = stack$iv;
                        if ((MutableVector)(MutableVector)(MutableVector)i12 == 0) {
                        } else {
                        }
                        mask$iv = node;
                        delegatableNode2 = delegatableNode;
                        mask$iv2 = i12;
                        capacity$iv$iv$iv = 0;
                        stack$iv = mask$iv2;
                        node = node$iv;
                        i14 = stack$iv;
                        if ((Modifier.Node)node != null && (MutableVector)i14 != 0) {
                        }
                        delegatableNode = stack$iv;
                        if ((MutableVector)delegatableNode != 0) {
                        }
                        (MutableVector)delegatableNode.add(includeSelf2);
                        i14 = stack$iv;
                        if ((MutableVector)(MutableVector)i14 != 0) {
                        }
                        node$iv = delegatableNode;
                        (MutableVector)(MutableVector)i14.add((Modifier.Node)node);
                        i4 = i13;
                        $i$f$mutableVectorOf = 16;
                        i = 0;
                        mask$iv = node;
                        delegatableNode2 = delegatableNode;
                        i3 = $i$f$mutableVectorOf;
                        mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        delegatableNode = mask$iv2;
                        node$iv = includeSelf2;
                        mask$iv = node;
                        delegatableNode2 = delegatableNode;
                        capacity$iv$iv$iv = 0;
                        this_$iv$iv2 = 1;
                    }
                    if (this_$iv$iv == 1) {
                    } else {
                    }
                    includeSelf2 = obj28;
                    $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                    node = mask$iv;
                    delegatableNode = delegatableNode2;
                    includeSelf2 = node$iv$iv;
                    i6 = 0;
                    i4 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    if (this_$iv$iv2 != 0) {
                    } else {
                    }
                    $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                    mask$iv = node;
                    delegatableNode2 = delegatableNode;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                    node = mask$iv;
                    delegatableNode = delegatableNode2;
                    $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                    if (this_$iv$iv++ == 1) {
                    } else {
                    }
                    i12 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)i12 == 0) {
                    } else {
                    }
                    mask$iv = node;
                    delegatableNode2 = delegatableNode;
                    mask$iv2 = i12;
                    capacity$iv$iv$iv = 0;
                    stack$iv = mask$iv2;
                    node = node$iv;
                    i14 = stack$iv;
                    if ((Modifier.Node)node != null && (MutableVector)i14 != 0) {
                    }
                    delegatableNode = stack$iv;
                    if ((MutableVector)delegatableNode != 0) {
                    }
                    (MutableVector)delegatableNode.add(includeSelf2);
                    i14 = stack$iv;
                    if ((MutableVector)(MutableVector)i14 != 0) {
                    }
                    node$iv = delegatableNode;
                    (MutableVector)(MutableVector)i14.add((Modifier.Node)node);
                    i4 = i13;
                    $i$f$mutableVectorOf = 16;
                    i = 0;
                    mask$iv = node;
                    delegatableNode2 = delegatableNode;
                    i3 = $i$f$mutableVectorOf;
                    mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    delegatableNode = mask$iv2;
                    node$iv = includeSelf2;
                    mask$iv = node;
                    delegatableNode2 = delegatableNode;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv2 = 1;
                    this_$iv$iv = 1;
                    block.invoke(node$iv);
                    obj28 = includeSelf2;
                    $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                    mask$iv = node;
                    delegatableNode2 = delegatableNode;
                }
                obj = block;
                obj28 = includeSelf2;
                $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                mask$iv = node;
                delegatableNode2 = delegatableNode;
                if (kindSet$ui_release &= node != 0) {
                } else {
                }
                obj = block;
                obj28 = includeSelf2;
                $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                mask$iv = node;
                delegatableNode2 = delegatableNode;
                node$iv2 = node$iv2.getParent$ui_release();
                includeSelf2 = obj28;
                $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                node = mask$iv;
                delegatableNode = delegatableNode2;
                i8 = 0;
                i9 = 0;
                stack$iv = 0;
                i16 = 0;
                node$iv = node3;
                while (node$iv != null) {
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (node$iv instanceof Object != null) {
                    } else {
                    }
                    obj = block;
                    node2 = 0;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0 && node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                    mask$iv = node;
                    delegatableNode2 = delegatableNode;
                    node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                    includeSelf2 = obj28;
                    $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                    node = mask$iv;
                    delegatableNode = delegatableNode2;
                    if (node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    i2 = 0;
                    node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        includeSelf2 = node$iv$iv;
                        i6 = 0;
                        i4 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv2 = 0;
                        if (this_$iv$iv2 != 0) {
                        } else {
                        }
                        $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                        mask$iv = node;
                        delegatableNode2 = delegatableNode;
                        capacity$iv$iv$iv = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                        node = mask$iv;
                        delegatableNode = delegatableNode2;
                        $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                        if (this_$iv$iv++ == 1) {
                        } else {
                        }
                        i12 = stack$iv;
                        if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i12 == 0) {
                        } else {
                        }
                        mask$iv = node;
                        delegatableNode2 = delegatableNode;
                        mask$iv2 = i12;
                        capacity$iv$iv$iv = 0;
                        stack$iv = mask$iv2;
                        node = node$iv;
                        i14 = stack$iv;
                        if ((Modifier.Node)node != null && (MutableVector)i14 != 0) {
                        }
                        delegatableNode = stack$iv;
                        if ((MutableVector)delegatableNode != 0) {
                        }
                        (MutableVector)delegatableNode.add(includeSelf2);
                        i14 = stack$iv;
                        if ((MutableVector)(MutableVector)i14 != 0) {
                        }
                        node$iv = delegatableNode;
                        (MutableVector)(MutableVector)i14.add((Modifier.Node)node);
                        i4 = i13;
                        $i$f$mutableVectorOf = 16;
                        i = 0;
                        mask$iv = node;
                        delegatableNode2 = delegatableNode;
                        i3 = $i$f$mutableVectorOf;
                        mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        delegatableNode = mask$iv2;
                        node$iv = includeSelf2;
                        mask$iv = node;
                        delegatableNode2 = delegatableNode;
                        capacity$iv$iv$iv = 0;
                        this_$iv$iv2 = 1;
                    }
                    if (this_$iv$iv == 1) {
                    } else {
                    }
                    includeSelf2 = obj28;
                    $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                    node = mask$iv;
                    delegatableNode = delegatableNode2;
                    includeSelf2 = node$iv$iv;
                    i6 = 0;
                    i4 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    if (this_$iv$iv2 != 0) {
                    } else {
                    }
                    $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                    mask$iv = node;
                    delegatableNode2 = delegatableNode;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                    node = mask$iv;
                    delegatableNode = delegatableNode2;
                    $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                    if (this_$iv$iv++ == 1) {
                    } else {
                    }
                    i12 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i12 == 0) {
                    } else {
                    }
                    mask$iv = node;
                    delegatableNode2 = delegatableNode;
                    mask$iv2 = i12;
                    capacity$iv$iv$iv = 0;
                    stack$iv = mask$iv2;
                    node = node$iv;
                    i14 = stack$iv;
                    if ((Modifier.Node)node != null && (MutableVector)i14 != 0) {
                    }
                    delegatableNode = stack$iv;
                    if ((MutableVector)delegatableNode != 0) {
                    }
                    (MutableVector)delegatableNode.add(includeSelf2);
                    i14 = stack$iv;
                    if ((MutableVector)(MutableVector)i14 != 0) {
                    }
                    node$iv = delegatableNode;
                    (MutableVector)(MutableVector)i14.add((Modifier.Node)node);
                    i4 = i13;
                    $i$f$mutableVectorOf = 16;
                    i = 0;
                    mask$iv = node;
                    delegatableNode2 = delegatableNode;
                    i3 = $i$f$mutableVectorOf;
                    mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    delegatableNode = mask$iv2;
                    node$iv = includeSelf2;
                    mask$iv = node;
                    delegatableNode2 = delegatableNode;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv2 = 1;
                    this_$iv$iv = 1;
                    block.invoke(node$iv);
                    obj28 = includeSelf2;
                    $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                    mask$iv = node;
                    delegatableNode2 = delegatableNode;
                }
                obj = block;
                obj28 = includeSelf2;
                $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                mask$iv = node;
                delegatableNode2 = delegatableNode;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (node$iv instanceof Object != null) {
                } else {
                }
                obj = block;
                node2 = 0;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0 && node$iv instanceof DelegatingNode) {
                } else {
                }
                $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                mask$iv = node;
                delegatableNode2 = delegatableNode;
                node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                includeSelf2 = obj28;
                $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                node = mask$iv;
                delegatableNode = delegatableNode2;
                if (node$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv = 0;
                i2 = 0;
                node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                while (node$iv$iv != null) {
                    includeSelf2 = node$iv$iv;
                    i6 = 0;
                    i4 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    if (this_$iv$iv2 != 0) {
                    } else {
                    }
                    $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                    mask$iv = node;
                    delegatableNode2 = delegatableNode;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                    node = mask$iv;
                    delegatableNode = delegatableNode2;
                    $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                    if (this_$iv$iv++ == 1) {
                    } else {
                    }
                    i12 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i12 == 0) {
                    } else {
                    }
                    mask$iv = node;
                    delegatableNode2 = delegatableNode;
                    mask$iv2 = i12;
                    capacity$iv$iv$iv = 0;
                    stack$iv = mask$iv2;
                    node = node$iv;
                    i14 = stack$iv;
                    if ((Modifier.Node)node != null && (MutableVector)i14 != 0) {
                    }
                    delegatableNode = stack$iv;
                    if ((MutableVector)delegatableNode != 0) {
                    }
                    (MutableVector)delegatableNode.add(includeSelf2);
                    i14 = stack$iv;
                    if ((MutableVector)(MutableVector)i14 != 0) {
                    }
                    node$iv = delegatableNode;
                    (MutableVector)(MutableVector)i14.add((Modifier.Node)node);
                    i4 = i13;
                    $i$f$mutableVectorOf = 16;
                    i = 0;
                    mask$iv = node;
                    delegatableNode2 = delegatableNode;
                    i3 = $i$f$mutableVectorOf;
                    mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    delegatableNode = mask$iv2;
                    node$iv = includeSelf2;
                    mask$iv = node;
                    delegatableNode2 = delegatableNode;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv2 = 1;
                }
                if (this_$iv$iv == 1) {
                } else {
                }
                includeSelf2 = obj28;
                $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                node = mask$iv;
                delegatableNode = delegatableNode2;
                includeSelf2 = node$iv$iv;
                i6 = 0;
                i4 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv2 = 0;
                if (this_$iv$iv2 != 0) {
                } else {
                }
                $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                mask$iv = node;
                delegatableNode2 = delegatableNode;
                capacity$iv$iv$iv = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                $i$f$visitAncestorsYYKmho = $i$f$visitAncestorsYYKmho2;
                node = mask$iv;
                delegatableNode = delegatableNode2;
                $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                if (this_$iv$iv++ == 1) {
                } else {
                }
                i12 = stack$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i12 == 0) {
                } else {
                }
                mask$iv = node;
                delegatableNode2 = delegatableNode;
                mask$iv2 = i12;
                capacity$iv$iv$iv = 0;
                stack$iv = mask$iv2;
                node = node$iv;
                i14 = stack$iv;
                if ((Modifier.Node)node != null && (MutableVector)i14 != 0) {
                }
                delegatableNode = stack$iv;
                if ((MutableVector)delegatableNode != 0) {
                }
                (MutableVector)delegatableNode.add(includeSelf2);
                i14 = stack$iv;
                if ((MutableVector)(MutableVector)i14 != 0) {
                }
                node$iv = delegatableNode;
                (MutableVector)(MutableVector)i14.add((Modifier.Node)node);
                i4 = i13;
                $i$f$mutableVectorOf = 16;
                i = 0;
                mask$iv = node;
                delegatableNode2 = delegatableNode;
                i3 = $i$f$mutableVectorOf;
                mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                delegatableNode = mask$iv2;
                node$iv = includeSelf2;
                mask$iv = node;
                delegatableNode2 = delegatableNode;
                capacity$iv$iv$iv = 0;
                this_$iv$iv2 = 1;
                this_$iv$iv = 1;
                block.invoke(node$iv);
                obj28 = includeSelf2;
                $i$f$visitAncestorsYYKmho2 = $i$f$visitAncestorsYYKmho;
                mask$iv = node;
                delegatableNode2 = delegatableNode;
            }
        }
        obj28 = includeSelf2;
        int i18 = $i$f$visitAncestorsYYKmho;
        int includeSelf3 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv;
    }

    public static final void visitChildren(androidx.compose.ui.node.DelegatableNode $this$visitChildren, int mask, Function1<? super Modifier.Node, Unit> block) {
        int node;
        int node2;
        Modifier.Node[] arr;
        final int i = 0;
        if (!$this$visitChildren.getNode().isAttached()) {
        } else {
            int i2 = 0;
            node2 = 0;
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = $this$visitChildren.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, $this$visitChildren.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                int i3 = 0;
                node = mutableVector2.removeAt(size--);
                if (aggregateChildKindSet$ui_release &= mask == 0) {
                } else {
                }
                node2 = node;
                while (node2 != null) {
                    if (kindSet$ui_release &= mask != null) {
                        break loop_8;
                    } else {
                    }
                    node2 = node2.getChild$ui_release();
                }
                if (kindSet$ui_release &= mask != null) {
                } else {
                }
                node2 = node2.getChild$ui_release();
                block.invoke(node2);
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node);
            }
        }
        int child = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1 = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitChildren$1;
    }

    public static final <T> void visitChildren-6rFNWt0(androidx.compose.ui.node.DelegatableNode $this$visitChildren_u2d6rFNWt0, int type, Function1<? super T, Unit> block) {
        int i2;
        int $i$f$visitChildren6rFNWt0;
        Object obj;
        int capacity$iv$iv$iv;
        int mask$iv;
        Modifier.Node[] objArr2;
        MutableVector $this$visitChildren$iv2;
        int i;
        int node;
        int node$iv2;
        Modifier.Node[] arr;
        int i3;
        Object obj4;
        int count$iv;
        int this_$iv$iv2;
        int i5;
        Modifier.Node[] objArr;
        int i8;
        int stack$iv;
        Modifier.Node[] node$iv;
        Modifier.Node[] objArr3;
        int i4;
        Modifier.Node node$iv$iv;
        int $i$f$visitChildren6rFNWt02;
        int i6;
        Object mask$iv2;
        int this_$iv$iv;
        int i9;
        int i7;
        Modifier.Node[] $this$visitChildren$iv;
        int i11;
        int i10;
        objArr2 = $this$visitChildren_u2d6rFNWt0;
        i = 0;
        if (!objArr2.getNode().isAttached()) {
        } else {
            int i14 = 0;
            node$iv2 = 0;
            MutableVector mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = objArr2.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector3, objArr2.getNode());
            } else {
                mutableVector3.add(child$ui_release);
            }
            while (mutableVector3.isNotEmpty()) {
                int i15 = 0;
                count$iv = 1;
                node = mutableVector3.removeAt(size -= count$iv);
                if (aggregateChildKindSet$ui_release &= obj == 0) {
                } else {
                }
                node$iv2 = node;
                while (node$iv2 != 0) {
                    $this$visitChildren$iv = objArr2;
                    i11 = i;
                    int $i$f$visitChildren6rFNWt04 = count$iv;
                    Object obj3 = block;
                    node$iv2 = node$iv2.getChild$ui_release();
                    i3 = mask$iv4;
                    i2 = $i$f$visitChildren6rFNWt02;
                    obj = mask$iv2;
                }
                $i$f$visitChildren6rFNWt02 = i2;
                $this$visitChildren$iv = objArr2;
                i11 = i;
                Object obj2 = block;
                i3 = mask$iv3;
                obj = mask$iv2;
                if (kindSet$ui_release &= obj != null) {
                } else {
                }
                $this$visitChildren$iv = objArr2;
                i11 = i;
                $i$f$visitChildren6rFNWt04 = count$iv;
                obj3 = block;
                node$iv2 = node$iv2.getChild$ui_release();
                i3 = mask$iv4;
                i2 = $i$f$visitChildren6rFNWt02;
                obj = mask$iv2;
                i5 = 0;
                i8 = 0;
                stack$iv = 0;
                int i17 = 0;
                node$iv = objArr;
                while (node$iv != null) {
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (node$iv instanceof Object != null) {
                    } else {
                    }
                    obj4 = block;
                    objArr3 = 0;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    if (this_$iv$iv2 != 0 && node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$visitChildren6rFNWt02 = i2;
                    mask$iv2 = obj;
                    $this$visitChildren$iv = objArr2;
                    i11 = i;
                    $i$f$visitChildren6rFNWt0 = 1;
                    mask$iv = 0;
                    node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                    count$iv = $i$f$visitChildren6rFNWt0;
                    i3 = mask$iv;
                    i2 = $i$f$visitChildren6rFNWt02;
                    obj = mask$iv2;
                    objArr2 = $this$visitChildren$iv;
                    i = i11;
                    if (node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    i4 = 0;
                    node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        Modifier.Node $i$f$visitChildren6rFNWt05 = node$iv$iv;
                        i6 = 0;
                        i9 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv = 0;
                        if (this_$iv$iv != 0) {
                        } else {
                        }
                        mask$iv2 = obj;
                        $this$visitChildren$iv = objArr2;
                        i11 = i;
                        capacity$iv$iv$iv = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        i2 = $i$f$visitChildren6rFNWt02;
                        obj = mask$iv2;
                        objArr2 = $this$visitChildren$iv;
                        i = i11;
                        mask$iv2 = obj;
                        if (this_$iv$iv2++ == 1) {
                        } else {
                        }
                        int i12 = stack$iv;
                        if ((MutableVector)i12 == 0) {
                        } else {
                        }
                        $this$visitChildren$iv = objArr2;
                        i11 = i;
                        $this$visitChildren$iv2 = i12;
                        capacity$iv$iv$iv = 0;
                        stack$iv = $this$visitChildren$iv2;
                        objArr2 = node$iv;
                        MutableVector mutableVector = stack$iv;
                        if ((Modifier.Node)objArr2 != null && (MutableVector)mutableVector != null) {
                        }
                        i = stack$iv;
                        if ((MutableVector)i != null) {
                        }
                        (MutableVector)i.add($i$f$visitChildren6rFNWt05);
                        mutableVector = stack$iv;
                        if ((MutableVector)(MutableVector)mutableVector != null) {
                        }
                        node$iv = i;
                        (MutableVector)(MutableVector)mutableVector.add((Modifier.Node)objArr2);
                        i9 = i13;
                        int $i$f$mutableVectorOf = 16;
                        i7 = 0;
                        $this$visitChildren$iv = objArr2;
                        i11 = i;
                        i10 = $i$f$mutableVectorOf;
                        $this$visitChildren$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        i = $this$visitChildren$iv2;
                        node$iv = $i$f$visitChildren6rFNWt05;
                        $this$visitChildren$iv = objArr2;
                        i11 = i;
                        capacity$iv$iv$iv = 0;
                        this_$iv$iv = 1;
                    }
                    $i$f$visitChildren6rFNWt0 = 1;
                    if (this_$iv$iv2 == $i$f$visitChildren6rFNWt0) {
                    } else {
                    }
                    count$iv = $i$f$visitChildren6rFNWt0;
                    i3 = mask$iv;
                    i2 = $i$f$visitChildren6rFNWt02;
                    obj = mask$iv2;
                    objArr2 = $this$visitChildren$iv;
                    i = i11;
                    $i$f$visitChildren6rFNWt05 = node$iv$iv;
                    i6 = 0;
                    i9 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    mask$iv2 = obj;
                    $this$visitChildren$iv = objArr2;
                    i11 = i;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    i2 = $i$f$visitChildren6rFNWt02;
                    obj = mask$iv2;
                    objArr2 = $this$visitChildren$iv;
                    i = i11;
                    mask$iv2 = obj;
                    if (this_$iv$iv2++ == 1) {
                    } else {
                    }
                    i12 = stack$iv;
                    if ((MutableVector)(MutableVector)i12 == 0) {
                    } else {
                    }
                    $this$visitChildren$iv = objArr2;
                    i11 = i;
                    $this$visitChildren$iv2 = i12;
                    capacity$iv$iv$iv = 0;
                    stack$iv = $this$visitChildren$iv2;
                    objArr2 = node$iv;
                    mutableVector = stack$iv;
                    if ((Modifier.Node)objArr2 != null && (MutableVector)mutableVector != null) {
                    }
                    i = stack$iv;
                    if ((MutableVector)i != null) {
                    }
                    (MutableVector)i.add($i$f$visitChildren6rFNWt05);
                    mutableVector = stack$iv;
                    if ((MutableVector)(MutableVector)mutableVector != null) {
                    }
                    node$iv = i;
                    (MutableVector)(MutableVector)mutableVector.add((Modifier.Node)objArr2);
                    i9 = i13;
                    $i$f$mutableVectorOf = 16;
                    i7 = 0;
                    $this$visitChildren$iv = objArr2;
                    i11 = i;
                    i10 = $i$f$mutableVectorOf;
                    $this$visitChildren$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i = $this$visitChildren$iv2;
                    node$iv = $i$f$visitChildren6rFNWt05;
                    $this$visitChildren$iv = objArr2;
                    i11 = i;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv = 1;
                    this_$iv$iv2 = 1;
                    block.invoke(node$iv);
                    $i$f$visitChildren6rFNWt02 = i2;
                    mask$iv2 = obj;
                    $this$visitChildren$iv = objArr2;
                    i11 = i;
                    $i$f$visitChildren6rFNWt0 = 1;
                    mask$iv = 0;
                }
                $i$f$visitChildren6rFNWt02 = i2;
                $this$visitChildren$iv = objArr2;
                i11 = i;
                Object obj5 = block;
                i3 = mask$iv6;
                obj = mask$iv2;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (node$iv instanceof Object != null) {
                } else {
                }
                obj4 = block;
                objArr3 = 0;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                this_$iv$iv2 = 0;
                if (this_$iv$iv2 != 0 && node$iv instanceof DelegatingNode) {
                } else {
                }
                $i$f$visitChildren6rFNWt02 = i2;
                mask$iv2 = obj;
                $this$visitChildren$iv = objArr2;
                i11 = i;
                $i$f$visitChildren6rFNWt0 = 1;
                mask$iv = 0;
                node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                count$iv = $i$f$visitChildren6rFNWt0;
                i3 = mask$iv;
                i2 = $i$f$visitChildren6rFNWt02;
                obj = mask$iv2;
                objArr2 = $this$visitChildren$iv;
                i = i11;
                if (node$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv2 = 0;
                i4 = 0;
                node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                while (node$iv$iv != null) {
                    $i$f$visitChildren6rFNWt05 = node$iv$iv;
                    i6 = 0;
                    i9 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    mask$iv2 = obj;
                    $this$visitChildren$iv = objArr2;
                    i11 = i;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    i2 = $i$f$visitChildren6rFNWt02;
                    obj = mask$iv2;
                    objArr2 = $this$visitChildren$iv;
                    i = i11;
                    mask$iv2 = obj;
                    if (this_$iv$iv2++ == 1) {
                    } else {
                    }
                    i12 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)i12 == 0) {
                    } else {
                    }
                    $this$visitChildren$iv = objArr2;
                    i11 = i;
                    $this$visitChildren$iv2 = i12;
                    capacity$iv$iv$iv = 0;
                    stack$iv = $this$visitChildren$iv2;
                    objArr2 = node$iv;
                    mutableVector = stack$iv;
                    if ((Modifier.Node)objArr2 != null && (MutableVector)mutableVector != null) {
                    }
                    i = stack$iv;
                    if ((MutableVector)i != null) {
                    }
                    (MutableVector)i.add($i$f$visitChildren6rFNWt05);
                    mutableVector = stack$iv;
                    if ((MutableVector)(MutableVector)mutableVector != null) {
                    }
                    node$iv = i;
                    (MutableVector)(MutableVector)mutableVector.add((Modifier.Node)objArr2);
                    i9 = i13;
                    $i$f$mutableVectorOf = 16;
                    i7 = 0;
                    $this$visitChildren$iv = objArr2;
                    i11 = i;
                    i10 = $i$f$mutableVectorOf;
                    $this$visitChildren$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i = $this$visitChildren$iv2;
                    node$iv = $i$f$visitChildren6rFNWt05;
                    $this$visitChildren$iv = objArr2;
                    i11 = i;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv = 1;
                }
                $i$f$visitChildren6rFNWt0 = 1;
                if (this_$iv$iv2 == $i$f$visitChildren6rFNWt0) {
                } else {
                }
                count$iv = $i$f$visitChildren6rFNWt0;
                i3 = mask$iv;
                i2 = $i$f$visitChildren6rFNWt02;
                obj = mask$iv2;
                objArr2 = $this$visitChildren$iv;
                i = i11;
                $i$f$visitChildren6rFNWt05 = node$iv$iv;
                i6 = 0;
                i9 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0) {
                } else {
                }
                mask$iv2 = obj;
                $this$visitChildren$iv = objArr2;
                i11 = i;
                capacity$iv$iv$iv = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                i2 = $i$f$visitChildren6rFNWt02;
                obj = mask$iv2;
                objArr2 = $this$visitChildren$iv;
                i = i11;
                mask$iv2 = obj;
                if (this_$iv$iv2++ == 1) {
                } else {
                }
                i12 = stack$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)i12 == 0) {
                } else {
                }
                $this$visitChildren$iv = objArr2;
                i11 = i;
                $this$visitChildren$iv2 = i12;
                capacity$iv$iv$iv = 0;
                stack$iv = $this$visitChildren$iv2;
                objArr2 = node$iv;
                mutableVector = stack$iv;
                if ((Modifier.Node)objArr2 != null && (MutableVector)mutableVector != null) {
                }
                i = stack$iv;
                if ((MutableVector)i != null) {
                }
                (MutableVector)i.add($i$f$visitChildren6rFNWt05);
                mutableVector = stack$iv;
                if ((MutableVector)(MutableVector)mutableVector != null) {
                }
                node$iv = i;
                (MutableVector)(MutableVector)mutableVector.add((Modifier.Node)objArr2);
                i9 = i13;
                $i$f$mutableVectorOf = 16;
                i7 = 0;
                $this$visitChildren$iv = objArr2;
                i11 = i;
                i10 = $i$f$mutableVectorOf;
                $this$visitChildren$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i = $this$visitChildren$iv2;
                node$iv = $i$f$visitChildren6rFNWt05;
                $this$visitChildren$iv = objArr2;
                i11 = i;
                capacity$iv$iv$iv = 0;
                this_$iv$iv = 1;
                this_$iv$iv2 = 1;
                block.invoke(node$iv);
                $i$f$visitChildren6rFNWt02 = i2;
                mask$iv2 = obj;
                $this$visitChildren$iv = objArr2;
                i11 = i;
                $i$f$visitChildren6rFNWt0 = 1;
                mask$iv = 0;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector3, node);
            }
        }
        int i18 = i2;
        Object obj6 = obj;
        int $i$f$visitChildren6rFNWt03 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv;
    }

    public static final void visitLocalAncestors(androidx.compose.ui.node.DelegatableNode $this$visitLocalAncestors, int mask, Function1<? super Modifier.Node, Unit> block) {
        Modifier.Node next;
        int i;
        String $i$a$CheckPreconditionDelegatableNodeKt$visitLocalAncestors$1;
        final int i2 = 0;
        i = 0;
        if (!$this$visitLocalAncestors.getNode().isAttached()) {
            int i3 = 0;
            InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
        }
        next = $this$visitLocalAncestors.getNode().getParent$ui_release();
        while (next != null) {
            if (kindSet$ui_release &= mask != 0) {
            }
            next = next.getParent$ui_release();
            block.invoke(next);
        }
    }

    public static final <T> void visitLocalAncestors-6rFNWt0(androidx.compose.ui.node.DelegatableNode $this$visitLocalAncestors_u2d6rFNWt0, int type, Function1<? super T, Unit> block) {
        int $i$f$visitLocalAncestors6rFNWt02;
        int $i$f$visitLocalAncestors6rFNWt03;
        Modifier.Node node2;
        int mask$iv2;
        int i4;
        Modifier.Node next$iv;
        int i5;
        String $i$a$CheckPreconditionDelegatableNodeKt$visitLocalAncestors$1$iv;
        String str;
        int i7;
        int stack$iv;
        Modifier.Node node$iv;
        Object obj;
        int count$iv;
        Modifier.Node node3;
        int i8;
        Modifier.Node node;
        Modifier.Node node$iv$iv;
        int i9;
        int $i$f$visitLocalAncestors6rFNWt0;
        int this_$iv$iv;
        int i;
        int i6;
        Modifier.Node mask$iv;
        int i2;
        int i3;
        $i$f$visitLocalAncestors6rFNWt02 = 0;
        node2 = type;
        i4 = $this$visitLocalAncestors_u2d6rFNWt0;
        final int i13 = 0;
        i5 = 0;
        if (!i4.getNode().isAttached()) {
            int i14 = 0;
            $i$a$CheckPreconditionDelegatableNodeKt$visitLocalAncestors$1$iv = "visitLocalAncestors called on an unattached node";
            str = $i$a$CheckPreconditionDelegatableNodeKt$visitLocalAncestors$1$iv;
            InlineClassHelperKt.throwIllegalStateException($i$a$CheckPreconditionDelegatableNodeKt$visitLocalAncestors$1$iv);
        }
        next$iv = i4.getNode().getParent$ui_release();
        while (next$iv != null) {
            if (kindSet$ui_release &= node2 != 0) {
            } else {
            }
            obj = block;
            $i$f$visitLocalAncestors6rFNWt0 = $i$f$visitLocalAncestors6rFNWt02;
            mask$iv = node2;
            i2 = i4;
            next$iv = next$iv.getParent$ui_release();
            $i$f$visitLocalAncestors6rFNWt02 = $i$f$visitLocalAncestors6rFNWt0;
            node2 = mask$iv;
            i4 = i2;
            $i$a$CheckPreconditionDelegatableNodeKt$visitLocalAncestors$1$iv = 0;
            i7 = 0;
            stack$iv = 0;
            int i15 = 0;
            node$iv = str;
            while (node$iv != null) {
                Intrinsics.reifiedOperationMarker(3, "T");
                if (node$iv instanceof Object != null) {
                } else {
                }
                obj = block;
                node3 = 0;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                count$iv = 0;
                if (count$iv != 0 && node$iv instanceof DelegatingNode) {
                } else {
                }
                $i$f$visitLocalAncestors6rFNWt0 = $i$f$visitLocalAncestors6rFNWt02;
                mask$iv = node2;
                i2 = i4;
                node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                $i$f$visitLocalAncestors6rFNWt02 = $i$f$visitLocalAncestors6rFNWt0;
                node2 = mask$iv;
                i4 = i2;
                if (node$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv = 0;
                i8 = 0;
                node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                while (node$iv$iv != null) {
                    node = node$iv$iv;
                    i9 = 0;
                    i = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    $i$f$visitLocalAncestors6rFNWt0 = $i$f$visitLocalAncestors6rFNWt02;
                    mask$iv = node2;
                    i2 = i4;
                    $i$f$visitLocalAncestors6rFNWt03 = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    $i$f$visitLocalAncestors6rFNWt02 = $i$f$visitLocalAncestors6rFNWt0;
                    node2 = mask$iv;
                    i4 = i2;
                    $i$f$visitLocalAncestors6rFNWt0 = $i$f$visitLocalAncestors6rFNWt02;
                    if (count$iv++ == 1) {
                    } else {
                    }
                    int i10 = stack$iv;
                    if ((MutableVector)i10 == 0) {
                    } else {
                    }
                    mask$iv = node2;
                    i2 = i4;
                    mask$iv2 = i10;
                    $i$f$visitLocalAncestors6rFNWt03 = 0;
                    stack$iv = mask$iv2;
                    node2 = node$iv;
                    int i12 = stack$iv;
                    if ((Modifier.Node)node2 != null && (MutableVector)i12 != 0) {
                    }
                    i4 = stack$iv;
                    if ((MutableVector)i4 != 0) {
                    }
                    (MutableVector)i4.add(node);
                    i12 = stack$iv;
                    if ((MutableVector)(MutableVector)i12 != 0) {
                    }
                    node$iv = i4;
                    (MutableVector)(MutableVector)i12.add((Modifier.Node)node2);
                    i = i11;
                    int $i$f$mutableVectorOf = 16;
                    i6 = 0;
                    mask$iv = node2;
                    i2 = i4;
                    i3 = $i$f$mutableVectorOf;
                    mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i4 = mask$iv2;
                    node$iv = node;
                    mask$iv = node2;
                    i2 = i4;
                    $i$f$visitLocalAncestors6rFNWt03 = 0;
                    this_$iv$iv = 1;
                }
                if (count$iv == 1) {
                } else {
                }
                $i$f$visitLocalAncestors6rFNWt02 = $i$f$visitLocalAncestors6rFNWt0;
                node2 = mask$iv;
                i4 = i2;
                node = node$iv$iv;
                i9 = 0;
                i = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0) {
                } else {
                }
                $i$f$visitLocalAncestors6rFNWt0 = $i$f$visitLocalAncestors6rFNWt02;
                mask$iv = node2;
                i2 = i4;
                $i$f$visitLocalAncestors6rFNWt03 = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                $i$f$visitLocalAncestors6rFNWt02 = $i$f$visitLocalAncestors6rFNWt0;
                node2 = mask$iv;
                i4 = i2;
                $i$f$visitLocalAncestors6rFNWt0 = $i$f$visitLocalAncestors6rFNWt02;
                if (count$iv++ == 1) {
                } else {
                }
                i10 = stack$iv;
                if ((MutableVector)(MutableVector)i10 == 0) {
                } else {
                }
                mask$iv = node2;
                i2 = i4;
                mask$iv2 = i10;
                $i$f$visitLocalAncestors6rFNWt03 = 0;
                stack$iv = mask$iv2;
                node2 = node$iv;
                i12 = stack$iv;
                if ((Modifier.Node)node2 != null && (MutableVector)i12 != 0) {
                }
                i4 = stack$iv;
                if ((MutableVector)i4 != 0) {
                }
                (MutableVector)i4.add(node);
                i12 = stack$iv;
                if ((MutableVector)(MutableVector)i12 != 0) {
                }
                node$iv = i4;
                (MutableVector)(MutableVector)i12.add((Modifier.Node)node2);
                i = i11;
                $i$f$mutableVectorOf = 16;
                i6 = 0;
                mask$iv = node2;
                i2 = i4;
                i3 = $i$f$mutableVectorOf;
                mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i4 = mask$iv2;
                node$iv = node;
                mask$iv = node2;
                i2 = i4;
                $i$f$visitLocalAncestors6rFNWt03 = 0;
                this_$iv$iv = 1;
                count$iv = 1;
                block.invoke(node$iv);
                $i$f$visitLocalAncestors6rFNWt0 = $i$f$visitLocalAncestors6rFNWt02;
                mask$iv = node2;
                i2 = i4;
            }
            obj = block;
            $i$f$visitLocalAncestors6rFNWt0 = $i$f$visitLocalAncestors6rFNWt02;
            mask$iv = node2;
            i2 = i4;
            Intrinsics.reifiedOperationMarker(3, "T");
            if (node$iv instanceof Object != null) {
            } else {
            }
            obj = block;
            node3 = 0;
            if (kindSet$ui_release2 &= type != 0) {
            } else {
            }
            count$iv = 0;
            if (count$iv != 0 && node$iv instanceof DelegatingNode) {
            } else {
            }
            $i$f$visitLocalAncestors6rFNWt0 = $i$f$visitLocalAncestors6rFNWt02;
            mask$iv = node2;
            i2 = i4;
            node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
            $i$f$visitLocalAncestors6rFNWt02 = $i$f$visitLocalAncestors6rFNWt0;
            node2 = mask$iv;
            i4 = i2;
            if (node$iv instanceof DelegatingNode) {
            } else {
            }
            count$iv = 0;
            i8 = 0;
            node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
            while (node$iv$iv != null) {
                node = node$iv$iv;
                i9 = 0;
                i = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0) {
                } else {
                }
                $i$f$visitLocalAncestors6rFNWt0 = $i$f$visitLocalAncestors6rFNWt02;
                mask$iv = node2;
                i2 = i4;
                $i$f$visitLocalAncestors6rFNWt03 = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                $i$f$visitLocalAncestors6rFNWt02 = $i$f$visitLocalAncestors6rFNWt0;
                node2 = mask$iv;
                i4 = i2;
                $i$f$visitLocalAncestors6rFNWt0 = $i$f$visitLocalAncestors6rFNWt02;
                if (count$iv++ == 1) {
                } else {
                }
                i10 = stack$iv;
                if ((MutableVector)(MutableVector)(MutableVector)i10 == 0) {
                } else {
                }
                mask$iv = node2;
                i2 = i4;
                mask$iv2 = i10;
                $i$f$visitLocalAncestors6rFNWt03 = 0;
                stack$iv = mask$iv2;
                node2 = node$iv;
                i12 = stack$iv;
                if ((Modifier.Node)node2 != null && (MutableVector)i12 != 0) {
                }
                i4 = stack$iv;
                if ((MutableVector)i4 != 0) {
                }
                (MutableVector)i4.add(node);
                i12 = stack$iv;
                if ((MutableVector)(MutableVector)i12 != 0) {
                }
                node$iv = i4;
                (MutableVector)(MutableVector)i12.add((Modifier.Node)node2);
                i = i11;
                $i$f$mutableVectorOf = 16;
                i6 = 0;
                mask$iv = node2;
                i2 = i4;
                i3 = $i$f$mutableVectorOf;
                mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i4 = mask$iv2;
                node$iv = node;
                mask$iv = node2;
                i2 = i4;
                $i$f$visitLocalAncestors6rFNWt03 = 0;
                this_$iv$iv = 1;
            }
            if (count$iv == 1) {
            } else {
            }
            $i$f$visitLocalAncestors6rFNWt02 = $i$f$visitLocalAncestors6rFNWt0;
            node2 = mask$iv;
            i4 = i2;
            node = node$iv$iv;
            i9 = 0;
            i = 0;
            if (kindSet$ui_release3 &= type != 0) {
            } else {
            }
            this_$iv$iv = 0;
            if (this_$iv$iv != 0) {
            } else {
            }
            $i$f$visitLocalAncestors6rFNWt0 = $i$f$visitLocalAncestors6rFNWt02;
            mask$iv = node2;
            i2 = i4;
            $i$f$visitLocalAncestors6rFNWt03 = 0;
            node$iv$iv = node$iv$iv.getChild$ui_release();
            $i$f$visitLocalAncestors6rFNWt02 = $i$f$visitLocalAncestors6rFNWt0;
            node2 = mask$iv;
            i4 = i2;
            $i$f$visitLocalAncestors6rFNWt0 = $i$f$visitLocalAncestors6rFNWt02;
            if (count$iv++ == 1) {
            } else {
            }
            i10 = stack$iv;
            if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)i10 == 0) {
            } else {
            }
            mask$iv = node2;
            i2 = i4;
            mask$iv2 = i10;
            $i$f$visitLocalAncestors6rFNWt03 = 0;
            stack$iv = mask$iv2;
            node2 = node$iv;
            i12 = stack$iv;
            if ((Modifier.Node)node2 != null && (MutableVector)i12 != 0) {
            }
            i4 = stack$iv;
            if ((MutableVector)i4 != 0) {
            }
            (MutableVector)i4.add(node);
            i12 = stack$iv;
            if ((MutableVector)(MutableVector)i12 != 0) {
            }
            node$iv = i4;
            (MutableVector)(MutableVector)i12.add((Modifier.Node)node2);
            i = i11;
            $i$f$mutableVectorOf = 16;
            i6 = 0;
            mask$iv = node2;
            i2 = i4;
            i3 = $i$f$mutableVectorOf;
            mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
            i4 = mask$iv2;
            node$iv = node;
            mask$iv = node2;
            i2 = i4;
            $i$f$visitLocalAncestors6rFNWt03 = 0;
            this_$iv$iv = 1;
            count$iv = 1;
            block.invoke(node$iv);
            $i$f$visitLocalAncestors6rFNWt0 = $i$f$visitLocalAncestors6rFNWt02;
            mask$iv = node2;
            i2 = i4;
        }
    }

    public static final void visitLocalDescendants(androidx.compose.ui.node.DelegatableNode $this$visitLocalDescendants, int mask, Function1<? super Modifier.Node, Unit> block) {
        Modifier.Node next$iv;
        String $i$a$CheckPreconditionDelegatableNodeKt$visitLocalDescendants$1$iv;
        final int i = 0;
        final Object obj = $this$visitLocalDescendants;
        final int i2 = 0;
        final int i3 = 0;
        int i4 = 0;
        if (!obj.getNode().isAttached()) {
            int i5 = 0;
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node2 = obj.getNode();
        if (aggregateChildKindSet$ui_release &= mask != 0) {
            next$iv = node2.getChild$ui_release();
            while (next$iv != null) {
                if (kindSet$ui_release &= mask != null) {
                }
                next$iv = next$iv.getChild$ui_release();
                block.invoke(next$iv);
            }
        }
    }

    public static final void visitLocalDescendants(androidx.compose.ui.node.DelegatableNode $this$visitLocalDescendants, int mask, boolean includeSelf, Function1<? super Modifier.Node, Unit> block) {
        Modifier.Node next;
        String $i$a$CheckPreconditionDelegatableNodeKt$visitLocalDescendants$1;
        final int i = 0;
        int i2 = 0;
        if (!$this$visitLocalDescendants.getNode().isAttached()) {
            int i4 = 0;
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node2 = $this$visitLocalDescendants.getNode();
        if (aggregateChildKindSet$ui_release &= mask == 0) {
        }
        if (includeSelf) {
            next = node2;
        } else {
            next = node2.getChild$ui_release();
        }
        while (next != null) {
            if (kindSet$ui_release &= mask != 0) {
            }
            next = next.getChild$ui_release();
            block.invoke(next);
        }
    }

    public static void visitLocalDescendants$default(androidx.compose.ui.node.DelegatableNode $this$visitLocalDescendants_u24default, int mask, boolean includeSelf, Function1 block, int i5, Object object6) {
        Modifier.Node next;
        String $i$a$CheckPreconditionDelegatableNodeKt$visitLocalDescendants$1;
        int obj4;
        if (i5 &= 2 != 0) {
            obj4 = 0;
        }
        int obj6 = 0;
        int i = 0;
        if (!$this$visitLocalDescendants_u24default.getNode().isAttached()) {
            int i3 = 0;
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node obj7 = $this$visitLocalDescendants_u24default.getNode();
        if (aggregateChildKindSet$ui_release &= mask == 0) {
        }
        if (obj4 != null) {
            next = obj7;
        } else {
            next = obj7.getChild$ui_release();
        }
        while (next != null) {
            if (kindSet$ui_release &= mask != null) {
            }
            next = next.getChild$ui_release();
            block.invoke(next);
        }
    }

    public static final <T> void visitLocalDescendants-6rFNWt0(androidx.compose.ui.node.DelegatableNode $this$visitLocalDescendants_u2d6rFNWt0, int type, Function1<? super T, Unit> block) {
        int i9;
        int i5;
        Object obj;
        int mask$iv2;
        int capacity$iv$iv$iv;
        int mask$iv3;
        Modifier.Node node2;
        int $this$visitLocalDescendants$iv2;
        int i10;
        int count$iv;
        int this_$iv$iv2;
        Modifier.Node next$iv$iv;
        String $i$a$CheckPreconditionDelegatableNodeKt$visitLocalDescendants$1$iv$iv;
        String str;
        Modifier.Node node;
        int i11;
        int stack$iv;
        Modifier.Node node$iv;
        int $i$f$visitLocalDescendants6rFNWt0;
        int $i$f$visitLocalDescendants6rFNWt02;
        Modifier.Node node4;
        int i4;
        Modifier.Node node$iv$iv;
        int i8;
        Object mask$iv;
        int this_$iv$iv;
        Object obj2;
        int i7;
        int i3;
        Modifier.Node $this$visitLocalDescendants$iv;
        Modifier.Node node3;
        int i;
        int i6;
        int i2;
        obj = type;
        node2 = $this$visitLocalDescendants_u2d6rFNWt0;
        final int i16 = count$iv;
        final Modifier.Node node6 = node2;
        final int i17 = 0;
        int i18 = 0;
        if (!node6.getNode().isAttached()) {
            int i19 = 0;
            $i$a$CheckPreconditionDelegatableNodeKt$visitLocalDescendants$1$iv$iv = "visitLocalDescendants called on an unattached node";
            str = $i$a$CheckPreconditionDelegatableNodeKt$visitLocalDescendants$1$iv$iv;
            InlineClassHelperKt.throwIllegalStateException($i$a$CheckPreconditionDelegatableNodeKt$visitLocalDescendants$1$iv$iv);
        }
        Modifier.Node node8 = node6.getNode();
        if (aggregateChildKindSet$ui_release &= obj != 0) {
            next$iv$iv = node8.getChild$ui_release();
            while (next$iv$iv != null) {
                if (kindSet$ui_release &= obj != 0) {
                } else {
                }
                $i$f$visitLocalDescendants6rFNWt0 = i9;
                mask$iv = obj;
                $this$visitLocalDescendants$iv = node2;
                i = i10;
                mask$iv3 = count$iv;
                next$iv$iv = next$iv$iv.getChild$ui_release();
                count$iv = mask$iv3;
                i9 = $i$f$visitLocalDescendants6rFNWt0;
                obj = mask$iv;
                node2 = $this$visitLocalDescendants$iv;
                i10 = i;
                str = 0;
                i11 = 0;
                stack$iv = 0;
                int i20 = 0;
                node$iv = node;
                while (node$iv != null) {
                    $i$f$visitLocalDescendants6rFNWt0 = i9;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (node$iv instanceof Object != null) {
                    } else {
                    }
                    i5 = block;
                    node4 = 0;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    if (this_$iv$iv2 != 0 && node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv = obj;
                    $this$visitLocalDescendants$iv = node2;
                    i = i10;
                    mask$iv2 = 0;
                    node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                    count$iv = mask$iv2;
                    i9 = $i$f$visitLocalDescendants6rFNWt0;
                    obj = mask$iv;
                    node2 = $this$visitLocalDescendants$iv;
                    i10 = i;
                    if (node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    i4 = 0;
                    node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        i5 = node$iv$iv;
                        i8 = 0;
                        i7 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv = 0;
                        if (this_$iv$iv != 0) {
                        } else {
                        }
                        mask$iv = obj;
                        $this$visitLocalDescendants$iv = node2;
                        i = i10;
                        capacity$iv$iv$iv = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        obj = mask$iv;
                        node2 = $this$visitLocalDescendants$iv;
                        i10 = i;
                        mask$iv = obj;
                        if (this_$iv$iv2++ == 1) {
                        } else {
                        }
                        int i13 = stack$iv;
                        if ((MutableVector)i13 == 0) {
                        } else {
                        }
                        $this$visitLocalDescendants$iv = node2;
                        i = i10;
                        $this$visitLocalDescendants$iv2 = i13;
                        capacity$iv$iv$iv = 0;
                        stack$iv = $this$visitLocalDescendants$iv2;
                        node2 = node$iv;
                        int i15 = stack$iv;
                        if ((Modifier.Node)node2 != null && (MutableVector)i15 != 0) {
                        }
                        i10 = stack$iv;
                        if ((MutableVector)i10 != 0) {
                        }
                        (MutableVector)i10.add(i5);
                        i15 = stack$iv;
                        if ((MutableVector)(MutableVector)i15 != 0) {
                        }
                        node$iv = i10;
                        (MutableVector)(MutableVector)i15.add((Modifier.Node)node2);
                        i7 = i14;
                        int $i$f$mutableVectorOf = 16;
                        i3 = 0;
                        $this$visitLocalDescendants$iv = node2;
                        i = i10;
                        i2 = $i$f$mutableVectorOf;
                        $this$visitLocalDescendants$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        i10 = $this$visitLocalDescendants$iv2;
                        node$iv = i5;
                        $this$visitLocalDescendants$iv = node2;
                        i = i10;
                        capacity$iv$iv$iv = 0;
                        this_$iv$iv = 1;
                    }
                    if (this_$iv$iv2 == 1) {
                    } else {
                    }
                    count$iv = mask$iv2;
                    i9 = $i$f$visitLocalDescendants6rFNWt0;
                    obj = mask$iv;
                    node2 = $this$visitLocalDescendants$iv;
                    i10 = i;
                    i5 = node$iv$iv;
                    i8 = 0;
                    i7 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    mask$iv = obj;
                    $this$visitLocalDescendants$iv = node2;
                    i = i10;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    obj = mask$iv;
                    node2 = $this$visitLocalDescendants$iv;
                    i10 = i;
                    mask$iv = obj;
                    if (this_$iv$iv2++ == 1) {
                    } else {
                    }
                    i13 = stack$iv;
                    if ((MutableVector)(MutableVector)i13 == 0) {
                    } else {
                    }
                    $this$visitLocalDescendants$iv = node2;
                    i = i10;
                    $this$visitLocalDescendants$iv2 = i13;
                    capacity$iv$iv$iv = 0;
                    stack$iv = $this$visitLocalDescendants$iv2;
                    node2 = node$iv;
                    i15 = stack$iv;
                    if ((Modifier.Node)node2 != null && (MutableVector)i15 != 0) {
                    }
                    i10 = stack$iv;
                    if ((MutableVector)i10 != 0) {
                    }
                    (MutableVector)i10.add(i5);
                    i15 = stack$iv;
                    if ((MutableVector)(MutableVector)i15 != 0) {
                    }
                    node$iv = i10;
                    (MutableVector)(MutableVector)i15.add((Modifier.Node)node2);
                    i7 = i14;
                    $i$f$mutableVectorOf = 16;
                    i3 = 0;
                    $this$visitLocalDescendants$iv = node2;
                    i = i10;
                    i2 = $i$f$mutableVectorOf;
                    $this$visitLocalDescendants$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i10 = $this$visitLocalDescendants$iv2;
                    node$iv = i5;
                    $this$visitLocalDescendants$iv = node2;
                    i = i10;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv = 1;
                    this_$iv$iv2 = 1;
                    block.invoke(node$iv);
                    mask$iv = obj;
                    $this$visitLocalDescendants$iv = node2;
                    i = i10;
                    mask$iv2 = 0;
                }
                $i$f$visitLocalDescendants6rFNWt0 = i9;
                mask$iv = obj;
                $this$visitLocalDescendants$iv = node2;
                i = i10;
                mask$iv3 = count$iv;
                $i$f$visitLocalDescendants6rFNWt0 = i9;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (node$iv instanceof Object != null) {
                } else {
                }
                i5 = block;
                node4 = 0;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                this_$iv$iv2 = 0;
                if (this_$iv$iv2 != 0 && node$iv instanceof DelegatingNode) {
                } else {
                }
                mask$iv = obj;
                $this$visitLocalDescendants$iv = node2;
                i = i10;
                mask$iv2 = 0;
                node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                count$iv = mask$iv2;
                i9 = $i$f$visitLocalDescendants6rFNWt0;
                obj = mask$iv;
                node2 = $this$visitLocalDescendants$iv;
                i10 = i;
                if (node$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv2 = 0;
                i4 = 0;
                node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                while (node$iv$iv != null) {
                    i5 = node$iv$iv;
                    i8 = 0;
                    i7 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    mask$iv = obj;
                    $this$visitLocalDescendants$iv = node2;
                    i = i10;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    obj = mask$iv;
                    node2 = $this$visitLocalDescendants$iv;
                    i10 = i;
                    mask$iv = obj;
                    if (this_$iv$iv2++ == 1) {
                    } else {
                    }
                    i13 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                    } else {
                    }
                    $this$visitLocalDescendants$iv = node2;
                    i = i10;
                    $this$visitLocalDescendants$iv2 = i13;
                    capacity$iv$iv$iv = 0;
                    stack$iv = $this$visitLocalDescendants$iv2;
                    node2 = node$iv;
                    i15 = stack$iv;
                    if ((Modifier.Node)node2 != null && (MutableVector)i15 != 0) {
                    }
                    i10 = stack$iv;
                    if ((MutableVector)i10 != 0) {
                    }
                    (MutableVector)i10.add(i5);
                    i15 = stack$iv;
                    if ((MutableVector)(MutableVector)i15 != 0) {
                    }
                    node$iv = i10;
                    (MutableVector)(MutableVector)i15.add((Modifier.Node)node2);
                    i7 = i14;
                    $i$f$mutableVectorOf = 16;
                    i3 = 0;
                    $this$visitLocalDescendants$iv = node2;
                    i = i10;
                    i2 = $i$f$mutableVectorOf;
                    $this$visitLocalDescendants$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i10 = $this$visitLocalDescendants$iv2;
                    node$iv = i5;
                    $this$visitLocalDescendants$iv = node2;
                    i = i10;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv = 1;
                }
                if (this_$iv$iv2 == 1) {
                } else {
                }
                count$iv = mask$iv2;
                i9 = $i$f$visitLocalDescendants6rFNWt0;
                obj = mask$iv;
                node2 = $this$visitLocalDescendants$iv;
                i10 = i;
                i5 = node$iv$iv;
                i8 = 0;
                i7 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0) {
                } else {
                }
                mask$iv = obj;
                $this$visitLocalDescendants$iv = node2;
                i = i10;
                capacity$iv$iv$iv = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                obj = mask$iv;
                node2 = $this$visitLocalDescendants$iv;
                i10 = i;
                mask$iv = obj;
                if (this_$iv$iv2++ == 1) {
                } else {
                }
                i13 = stack$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                } else {
                }
                $this$visitLocalDescendants$iv = node2;
                i = i10;
                $this$visitLocalDescendants$iv2 = i13;
                capacity$iv$iv$iv = 0;
                stack$iv = $this$visitLocalDescendants$iv2;
                node2 = node$iv;
                i15 = stack$iv;
                if ((Modifier.Node)node2 != null && (MutableVector)i15 != 0) {
                }
                i10 = stack$iv;
                if ((MutableVector)i10 != 0) {
                }
                (MutableVector)i10.add(i5);
                i15 = stack$iv;
                if ((MutableVector)(MutableVector)i15 != 0) {
                }
                node$iv = i10;
                (MutableVector)(MutableVector)i15.add((Modifier.Node)node2);
                i7 = i14;
                $i$f$mutableVectorOf = 16;
                i3 = 0;
                $this$visitLocalDescendants$iv = node2;
                i = i10;
                i2 = $i$f$mutableVectorOf;
                $this$visitLocalDescendants$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i10 = $this$visitLocalDescendants$iv2;
                node$iv = i5;
                $this$visitLocalDescendants$iv = node2;
                i = i10;
                capacity$iv$iv$iv = 0;
                this_$iv$iv = 1;
                this_$iv$iv2 = 1;
                block.invoke(node$iv);
                mask$iv = obj;
                $this$visitLocalDescendants$iv = node2;
                i = i10;
                mask$iv2 = 0;
            }
            $i$f$visitLocalDescendants6rFNWt02 = i9;
            obj2 = obj;
            node3 = node2;
            i6 = i10;
        } else {
            $i$f$visitLocalDescendants6rFNWt02 = i9;
            obj2 = obj;
            node3 = node2;
            i6 = i10;
        }
    }

    public static final <T> void visitSelfAndAncestors-5BbP62I(androidx.compose.ui.node.DelegatableNode $this$visitSelfAndAncestors_u2d5BbP62I, int type, int untilType, Function1<? super T, Unit> block) {
        int nodes$ui_release;
        Modifier.Node tail$ui_release;
        int i2;
        Object obj;
        Modifier.Node node2;
        int self2;
        int capacity$iv$iv$iv;
        int i;
        int mask$iv2;
        int i6;
        Modifier.Node node$iv;
        androidx.compose.ui.node.LayoutNode layout$iv;
        Modifier.Node head$ui_release;
        int i11;
        int i5;
        Modifier.Node node$iv3;
        int count$iv;
        int this_$iv;
        int i4;
        int stack$iv;
        Modifier.Node node$iv2;
        int $i$f$visitSelfAndAncestors5BbP62I;
        Modifier.Node node;
        int i7;
        Modifier.Node node$iv$iv;
        int i8;
        Modifier.Node self;
        int this_$iv$iv;
        int i9;
        int i3;
        int mask$iv;
        int i10;
        int i12;
        i = type | untilType;
        i6 = 1;
        final androidx.compose.ui.node.DelegatableNode delegatableNode = $this$visitSelfAndAncestors_u2d5BbP62I;
        final int i16 = 0;
        if (!delegatableNode.getNode().isAttached()) {
        } else {
            node$iv = delegatableNode.getNode();
            layout$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode);
            while (layout$iv != null) {
                if (aggregateChildKindSet$ui_release &= i != 0) {
                } else {
                }
                $i$f$visitSelfAndAncestors5BbP62I = nodes$ui_release;
                self = node2;
                mask$iv = i;
                i10 = i6;
                layout$iv = layout$iv.getParent$ui_release();
                nodes$ui_release = layout$iv.getNodes$ui_release();
                if (layout$iv != null && nodes$ui_release != null) {
                } else {
                }
                tail$ui_release = 0;
                node$iv = tail$ui_release;
                nodes$ui_release = $i$f$visitSelfAndAncestors5BbP62I;
                node2 = self;
                i = mask$iv;
                i6 = i10;
                nodes$ui_release = layout$iv.getNodes$ui_release();
                if (nodes$ui_release != null) {
                } else {
                }
                tail$ui_release = nodes$ui_release.getTail$ui_release();
                while (node$iv != null) {
                    $i$f$visitSelfAndAncestors5BbP62I = nodes$ui_release;
                    self = node2;
                    mask$iv = i;
                    i10 = i6;
                    node$iv = node$iv.getParent$ui_release();
                    nodes$ui_release = $i$f$visitSelfAndAncestors5BbP62I;
                    node2 = self;
                    i = mask$iv;
                    i6 = i10;
                    i11 = node$iv;
                    i5 = 0;
                    i4 = 0;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    this_$iv = 0;
                    if (this_$iv != 0) {
                    } else {
                    }
                    $i$f$visitSelfAndAncestors5BbP62I = nodes$ui_release;
                    self = node2;
                    mask$iv = i;
                    i10 = i6;
                    i4 = 0;
                    stack$iv = 0;
                    int i17 = 0;
                    node$iv3 = node$iv2;
                    while (node$iv3 != null) {
                        $i$f$visitSelfAndAncestors5BbP62I = nodes$ui_release;
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (node$iv3 instanceof Object != null) {
                        } else {
                        }
                        obj = block;
                        node = 0;
                        if (kindSet$ui_release4 &= type != 0) {
                        } else {
                        }
                        count$iv = 0;
                        if (count$iv != 0 && node$iv3 instanceof DelegatingNode) {
                        } else {
                        }
                        self = node2;
                        mask$iv = i;
                        i10 = i6;
                        i2 = 1;
                        self2 = 0;
                        node$iv3 = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                        nodes$ui_release = $i$f$visitSelfAndAncestors5BbP62I;
                        node2 = self;
                        i = mask$iv;
                        i6 = i10;
                        if (node$iv3 instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv = 0;
                        i7 = 0;
                        node$iv$iv = (DelegatingNode)node$iv3.getDelegate$ui_release();
                        while (node$iv$iv != null) {
                            Modifier.Node node3 = node$iv$iv;
                            i8 = 0;
                            i9 = 0;
                            if (kindSet$ui_release5 &= type != 0) {
                            } else {
                            }
                            this_$iv$iv = 0;
                            if (this_$iv$iv != 0) {
                            } else {
                            }
                            self = node2;
                            mask$iv = i;
                            i10 = i6;
                            capacity$iv$iv$iv = 0;
                            node$iv$iv = node$iv$iv.getChild$ui_release();
                            obj = block;
                            node2 = self;
                            i = mask$iv;
                            i6 = i10;
                            self = node2;
                            if (count$iv++ == 1) {
                            } else {
                            }
                            int i13 = stack$iv;
                            if ((MutableVector)i13 == 0) {
                            } else {
                            }
                            mask$iv = i;
                            i10 = i6;
                            mask$iv2 = i13;
                            capacity$iv$iv$iv = 0;
                            stack$iv = mask$iv2;
                            i = node$iv3;
                            int i15 = stack$iv;
                            if ((Modifier.Node)i != null && (MutableVector)i15 != 0) {
                            }
                            i6 = stack$iv;
                            if ((MutableVector)i6 != 0) {
                            }
                            (MutableVector)i6.add(node3);
                            i15 = stack$iv;
                            if ((MutableVector)(MutableVector)i15 != 0) {
                            }
                            node$iv3 = i6;
                            (MutableVector)(MutableVector)i15.add((Modifier.Node)i);
                            i9 = i14;
                            int $i$f$mutableVectorOf = 16;
                            i3 = 0;
                            mask$iv = i;
                            i10 = i6;
                            i12 = $i$f$mutableVectorOf;
                            mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                            i6 = mask$iv2;
                            node$iv3 = node3;
                            mask$iv = i;
                            i10 = i6;
                            capacity$iv$iv$iv = 0;
                            this_$iv$iv = 1;
                        }
                        self2 = 0;
                        if (count$iv == 1) {
                        } else {
                        }
                        nodes$ui_release = $i$f$visitSelfAndAncestors5BbP62I;
                        node2 = self;
                        i = mask$iv;
                        i6 = i10;
                        node3 = node$iv$iv;
                        i8 = 0;
                        i9 = 0;
                        if (kindSet$ui_release5 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv = 0;
                        if (this_$iv$iv != 0) {
                        } else {
                        }
                        self = node2;
                        mask$iv = i;
                        i10 = i6;
                        capacity$iv$iv$iv = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        obj = block;
                        node2 = self;
                        i = mask$iv;
                        i6 = i10;
                        self = node2;
                        if (count$iv++ == 1) {
                        } else {
                        }
                        i13 = stack$iv;
                        if ((MutableVector)(MutableVector)i13 == 0) {
                        } else {
                        }
                        mask$iv = i;
                        i10 = i6;
                        mask$iv2 = i13;
                        capacity$iv$iv$iv = 0;
                        stack$iv = mask$iv2;
                        i = node$iv3;
                        i15 = stack$iv;
                        if ((Modifier.Node)i != null && (MutableVector)i15 != 0) {
                        }
                        i6 = stack$iv;
                        if ((MutableVector)i6 != 0) {
                        }
                        (MutableVector)i6.add(node3);
                        i15 = stack$iv;
                        if ((MutableVector)(MutableVector)i15 != 0) {
                        }
                        node$iv3 = i6;
                        (MutableVector)(MutableVector)i15.add((Modifier.Node)i);
                        i9 = i14;
                        $i$f$mutableVectorOf = 16;
                        i3 = 0;
                        mask$iv = i;
                        i10 = i6;
                        i12 = $i$f$mutableVectorOf;
                        mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        i6 = mask$iv2;
                        node$iv3 = node3;
                        mask$iv = i;
                        i10 = i6;
                        capacity$iv$iv$iv = 0;
                        this_$iv$iv = 1;
                        count$iv = 1;
                        block.invoke(node$iv3);
                        self = node2;
                        mask$iv = i;
                        i10 = i6;
                        i2 = 1;
                        self2 = 0;
                    }
                    $i$f$visitSelfAndAncestors5BbP62I = nodes$ui_release;
                    self = node2;
                    mask$iv = i;
                    i10 = i6;
                    $i$f$visitSelfAndAncestors5BbP62I = nodes$ui_release;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (node$iv3 instanceof Object != null) {
                    } else {
                    }
                    obj = block;
                    node = 0;
                    if (kindSet$ui_release4 &= type != 0) {
                    } else {
                    }
                    count$iv = 0;
                    if (count$iv != 0 && node$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    self = node2;
                    mask$iv = i;
                    i10 = i6;
                    i2 = 1;
                    self2 = 0;
                    node$iv3 = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                    nodes$ui_release = $i$f$visitSelfAndAncestors5BbP62I;
                    node2 = self;
                    i = mask$iv;
                    i6 = i10;
                    if (node$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv = 0;
                    i7 = 0;
                    node$iv$iv = (DelegatingNode)node$iv3.getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        node3 = node$iv$iv;
                        i8 = 0;
                        i9 = 0;
                        if (kindSet$ui_release5 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv = 0;
                        if (this_$iv$iv != 0) {
                        } else {
                        }
                        self = node2;
                        mask$iv = i;
                        i10 = i6;
                        capacity$iv$iv$iv = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        obj = block;
                        node2 = self;
                        i = mask$iv;
                        i6 = i10;
                        self = node2;
                        if (count$iv++ == 1) {
                        } else {
                        }
                        i13 = stack$iv;
                        if ((MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                        } else {
                        }
                        mask$iv = i;
                        i10 = i6;
                        mask$iv2 = i13;
                        capacity$iv$iv$iv = 0;
                        stack$iv = mask$iv2;
                        i = node$iv3;
                        i15 = stack$iv;
                        if ((Modifier.Node)i != null && (MutableVector)i15 != 0) {
                        }
                        i6 = stack$iv;
                        if ((MutableVector)i6 != 0) {
                        }
                        (MutableVector)i6.add(node3);
                        i15 = stack$iv;
                        if ((MutableVector)(MutableVector)i15 != 0) {
                        }
                        node$iv3 = i6;
                        (MutableVector)(MutableVector)i15.add((Modifier.Node)i);
                        i9 = i14;
                        $i$f$mutableVectorOf = 16;
                        i3 = 0;
                        mask$iv = i;
                        i10 = i6;
                        i12 = $i$f$mutableVectorOf;
                        mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        i6 = mask$iv2;
                        node$iv3 = node3;
                        mask$iv = i;
                        i10 = i6;
                        capacity$iv$iv$iv = 0;
                        this_$iv$iv = 1;
                    }
                    self2 = 0;
                    if (count$iv == 1) {
                    } else {
                    }
                    nodes$ui_release = $i$f$visitSelfAndAncestors5BbP62I;
                    node2 = self;
                    i = mask$iv;
                    i6 = i10;
                    node3 = node$iv$iv;
                    i8 = 0;
                    i9 = 0;
                    if (kindSet$ui_release5 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    self = node2;
                    mask$iv = i;
                    i10 = i6;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    obj = block;
                    node2 = self;
                    i = mask$iv;
                    i6 = i10;
                    self = node2;
                    if (count$iv++ == 1) {
                    } else {
                    }
                    i13 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                    } else {
                    }
                    mask$iv = i;
                    i10 = i6;
                    mask$iv2 = i13;
                    capacity$iv$iv$iv = 0;
                    stack$iv = mask$iv2;
                    i = node$iv3;
                    i15 = stack$iv;
                    if ((Modifier.Node)i != null && (MutableVector)i15 != 0) {
                    }
                    i6 = stack$iv;
                    if ((MutableVector)i6 != 0) {
                    }
                    (MutableVector)i6.add(node3);
                    i15 = stack$iv;
                    if ((MutableVector)(MutableVector)i15 != 0) {
                    }
                    node$iv3 = i6;
                    (MutableVector)(MutableVector)i15.add((Modifier.Node)i);
                    i9 = i14;
                    $i$f$mutableVectorOf = 16;
                    i3 = 0;
                    mask$iv = i;
                    i10 = i6;
                    i12 = $i$f$mutableVectorOf;
                    mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i6 = mask$iv2;
                    node$iv3 = node3;
                    mask$iv = i;
                    i10 = i6;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv = 1;
                    count$iv = 1;
                    block.invoke(node$iv3);
                    self = node2;
                    mask$iv = i;
                    i10 = i6;
                    i2 = 1;
                    self2 = 0;
                    this_$iv = 1;
                    i4 = 0;
                    if (kindSet$ui_release3 &= untilType != 0) {
                    } else {
                    }
                    this_$iv = 0;
                    this_$iv = 1;
                }
                $i$f$visitSelfAndAncestors5BbP62I = nodes$ui_release;
                self = node2;
                mask$iv = i;
                i10 = i6;
                $i$f$visitSelfAndAncestors5BbP62I = nodes$ui_release;
                self = node2;
                mask$iv = i;
                i10 = i6;
                node$iv = node$iv.getParent$ui_release();
                nodes$ui_release = $i$f$visitSelfAndAncestors5BbP62I;
                node2 = self;
                i = mask$iv;
                i6 = i10;
                i11 = node$iv;
                i5 = 0;
                i4 = 0;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                this_$iv = 0;
                if (this_$iv != 0) {
                } else {
                }
                $i$f$visitSelfAndAncestors5BbP62I = nodes$ui_release;
                self = node2;
                mask$iv = i;
                i10 = i6;
                i4 = 0;
                stack$iv = 0;
                i17 = 0;
                node$iv3 = node$iv2;
                while (node$iv3 != null) {
                    $i$f$visitSelfAndAncestors5BbP62I = nodes$ui_release;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (node$iv3 instanceof Object != null) {
                    } else {
                    }
                    obj = block;
                    node = 0;
                    if (kindSet$ui_release4 &= type != 0) {
                    } else {
                    }
                    count$iv = 0;
                    if (count$iv != 0 && node$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    self = node2;
                    mask$iv = i;
                    i10 = i6;
                    i2 = 1;
                    self2 = 0;
                    node$iv3 = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                    nodes$ui_release = $i$f$visitSelfAndAncestors5BbP62I;
                    node2 = self;
                    i = mask$iv;
                    i6 = i10;
                    if (node$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv = 0;
                    i7 = 0;
                    node$iv$iv = (DelegatingNode)node$iv3.getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        node3 = node$iv$iv;
                        i8 = 0;
                        i9 = 0;
                        if (kindSet$ui_release5 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv = 0;
                        if (this_$iv$iv != 0) {
                        } else {
                        }
                        self = node2;
                        mask$iv = i;
                        i10 = i6;
                        capacity$iv$iv$iv = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        obj = block;
                        node2 = self;
                        i = mask$iv;
                        i6 = i10;
                        self = node2;
                        if (count$iv++ == 1) {
                        } else {
                        }
                        i13 = stack$iv;
                        if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                        } else {
                        }
                        mask$iv = i;
                        i10 = i6;
                        mask$iv2 = i13;
                        capacity$iv$iv$iv = 0;
                        stack$iv = mask$iv2;
                        i = node$iv3;
                        i15 = stack$iv;
                        if ((Modifier.Node)i != null && (MutableVector)i15 != 0) {
                        }
                        i6 = stack$iv;
                        if ((MutableVector)i6 != 0) {
                        }
                        (MutableVector)i6.add(node3);
                        i15 = stack$iv;
                        if ((MutableVector)(MutableVector)i15 != 0) {
                        }
                        node$iv3 = i6;
                        (MutableVector)(MutableVector)i15.add((Modifier.Node)i);
                        i9 = i14;
                        $i$f$mutableVectorOf = 16;
                        i3 = 0;
                        mask$iv = i;
                        i10 = i6;
                        i12 = $i$f$mutableVectorOf;
                        mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        i6 = mask$iv2;
                        node$iv3 = node3;
                        mask$iv = i;
                        i10 = i6;
                        capacity$iv$iv$iv = 0;
                        this_$iv$iv = 1;
                    }
                    self2 = 0;
                    if (count$iv == 1) {
                    } else {
                    }
                    nodes$ui_release = $i$f$visitSelfAndAncestors5BbP62I;
                    node2 = self;
                    i = mask$iv;
                    i6 = i10;
                    node3 = node$iv$iv;
                    i8 = 0;
                    i9 = 0;
                    if (kindSet$ui_release5 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    self = node2;
                    mask$iv = i;
                    i10 = i6;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    obj = block;
                    node2 = self;
                    i = mask$iv;
                    i6 = i10;
                    self = node2;
                    if (count$iv++ == 1) {
                    } else {
                    }
                    i13 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                    } else {
                    }
                    mask$iv = i;
                    i10 = i6;
                    mask$iv2 = i13;
                    capacity$iv$iv$iv = 0;
                    stack$iv = mask$iv2;
                    i = node$iv3;
                    i15 = stack$iv;
                    if ((Modifier.Node)i != null && (MutableVector)i15 != 0) {
                    }
                    i6 = stack$iv;
                    if ((MutableVector)i6 != 0) {
                    }
                    (MutableVector)i6.add(node3);
                    i15 = stack$iv;
                    if ((MutableVector)(MutableVector)i15 != 0) {
                    }
                    node$iv3 = i6;
                    (MutableVector)(MutableVector)i15.add((Modifier.Node)i);
                    i9 = i14;
                    $i$f$mutableVectorOf = 16;
                    i3 = 0;
                    mask$iv = i;
                    i10 = i6;
                    i12 = $i$f$mutableVectorOf;
                    mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i6 = mask$iv2;
                    node$iv3 = node3;
                    mask$iv = i;
                    i10 = i6;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv = 1;
                    count$iv = 1;
                    block.invoke(node$iv3);
                    self = node2;
                    mask$iv = i;
                    i10 = i6;
                    i2 = 1;
                    self2 = 0;
                }
                $i$f$visitSelfAndAncestors5BbP62I = nodes$ui_release;
                self = node2;
                mask$iv = i;
                i10 = i6;
                $i$f$visitSelfAndAncestors5BbP62I = nodes$ui_release;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (node$iv3 instanceof Object != null) {
                } else {
                }
                obj = block;
                node = 0;
                if (kindSet$ui_release4 &= type != 0) {
                } else {
                }
                count$iv = 0;
                if (count$iv != 0 && node$iv3 instanceof DelegatingNode) {
                } else {
                }
                self = node2;
                mask$iv = i;
                i10 = i6;
                i2 = 1;
                self2 = 0;
                node$iv3 = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                nodes$ui_release = $i$f$visitSelfAndAncestors5BbP62I;
                node2 = self;
                i = mask$iv;
                i6 = i10;
                if (node$iv3 instanceof DelegatingNode) {
                } else {
                }
                count$iv = 0;
                i7 = 0;
                node$iv$iv = (DelegatingNode)node$iv3.getDelegate$ui_release();
                while (node$iv$iv != null) {
                    node3 = node$iv$iv;
                    i8 = 0;
                    i9 = 0;
                    if (kindSet$ui_release5 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    self = node2;
                    mask$iv = i;
                    i10 = i6;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    obj = block;
                    node2 = self;
                    i = mask$iv;
                    i6 = i10;
                    self = node2;
                    if (count$iv++ == 1) {
                    } else {
                    }
                    i13 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                    } else {
                    }
                    mask$iv = i;
                    i10 = i6;
                    mask$iv2 = i13;
                    capacity$iv$iv$iv = 0;
                    stack$iv = mask$iv2;
                    i = node$iv3;
                    i15 = stack$iv;
                    if ((Modifier.Node)i != null && (MutableVector)i15 != 0) {
                    }
                    i6 = stack$iv;
                    if ((MutableVector)i6 != 0) {
                    }
                    (MutableVector)i6.add(node3);
                    i15 = stack$iv;
                    if ((MutableVector)(MutableVector)i15 != 0) {
                    }
                    node$iv3 = i6;
                    (MutableVector)(MutableVector)i15.add((Modifier.Node)i);
                    i9 = i14;
                    $i$f$mutableVectorOf = 16;
                    i3 = 0;
                    mask$iv = i;
                    i10 = i6;
                    i12 = $i$f$mutableVectorOf;
                    mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i6 = mask$iv2;
                    node$iv3 = node3;
                    mask$iv = i;
                    i10 = i6;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv = 1;
                }
                self2 = 0;
                if (count$iv == 1) {
                } else {
                }
                nodes$ui_release = $i$f$visitSelfAndAncestors5BbP62I;
                node2 = self;
                i = mask$iv;
                i6 = i10;
                node3 = node$iv$iv;
                i8 = 0;
                i9 = 0;
                if (kindSet$ui_release5 &= type != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0) {
                } else {
                }
                self = node2;
                mask$iv = i;
                i10 = i6;
                capacity$iv$iv$iv = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                obj = block;
                node2 = self;
                i = mask$iv;
                i6 = i10;
                self = node2;
                if (count$iv++ == 1) {
                } else {
                }
                i13 = stack$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                } else {
                }
                mask$iv = i;
                i10 = i6;
                mask$iv2 = i13;
                capacity$iv$iv$iv = 0;
                stack$iv = mask$iv2;
                i = node$iv3;
                i15 = stack$iv;
                if ((Modifier.Node)i != null && (MutableVector)i15 != 0) {
                }
                i6 = stack$iv;
                if ((MutableVector)i6 != 0) {
                }
                (MutableVector)i6.add(node3);
                i15 = stack$iv;
                if ((MutableVector)(MutableVector)i15 != 0) {
                }
                node$iv3 = i6;
                (MutableVector)(MutableVector)i15.add((Modifier.Node)i);
                i9 = i14;
                $i$f$mutableVectorOf = 16;
                i3 = 0;
                mask$iv = i;
                i10 = i6;
                i12 = $i$f$mutableVectorOf;
                mask$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i6 = mask$iv2;
                node$iv3 = node3;
                mask$iv = i;
                i10 = i6;
                capacity$iv$iv$iv = 0;
                this_$iv$iv = 1;
                count$iv = 1;
                block.invoke(node$iv3);
                self = node2;
                mask$iv = i;
                i10 = i6;
                i2 = 1;
                self2 = 0;
                this_$iv = 1;
                i4 = 0;
                if (kindSet$ui_release3 &= untilType != 0) {
                } else {
                }
                this_$iv = 0;
                this_$iv = 1;
            }
        }
        int i18 = nodes$ui_release;
        Modifier.Node node8 = node2;
        int $i$f$visitSelfAndAncestors5BbP62I2 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv;
    }

    public static final <T> void visitSelfAndChildren-6rFNWt0(androidx.compose.ui.node.DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0, int type, Function1<? super T, Unit> block) {
        Object obj3;
        int i2;
        int $i$f$visitSelfAndChildren6rFNWt02;
        Object $i$f$visitSelfAndChildren6rFNWt0;
        int mask$iv;
        int mask$iv3;
        Object obj;
        int $this$visitChildren$iv;
        int i3;
        int stack$iv2;
        Modifier.Node node$iv4;
        int node2;
        int this_$iv$iv2;
        int count$iv2;
        int count$iv;
        int i7;
        Object node$iv;
        int mutableVector;
        int node$iv3;
        int i9;
        Modifier.Node node$iv$iv2;
        Modifier.Node[] arr;
        Modifier.Node node;
        int i8;
        MutableVector this_$iv$iv3;
        int stack$iv;
        int node$iv2;
        int i11;
        int $i$f$visitSelfAndChildren6rFNWt03;
        Object obj2;
        int i10;
        Modifier.Node node$iv$iv;
        int i4;
        Object mask$iv2;
        int this_$iv$iv;
        int i5;
        int i6;
        Object $this$visitChildren$iv2;
        int i;
        int i12;
        $i$f$visitSelfAndChildren6rFNWt02 = 0;
        int i19 = 0;
        stack$iv2 = 0;
        int i22 = 0;
        node$iv4 = node4;
        String str2 = "T";
        i7 = 0;
        while (node$iv4 != null) {
            Intrinsics.reifiedOperationMarker(3, str2);
            if (node$iv4 instanceof Object != null) {
            } else {
            }
            count$iv2 = 0;
            if (kindSet$ui_release &= type != 0) {
            } else {
            }
            this_$iv$iv2 = i7;
            if (this_$iv$iv2 != 0 && node$iv4 instanceof DelegatingNode) {
            } else {
            }
            $i$f$visitSelfAndChildren6rFNWt03 = $i$f$visitSelfAndChildren6rFNWt02;
            node$iv4 = DelegatableNodeKt.access$pop((MutableVector)stack$iv2);
            $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt03;
            str2 = "T";
            i7 = 0;
            if (node$iv4 instanceof DelegatingNode) {
            } else {
            }
            this_$iv$iv2 = 0;
            i9 = 0;
            node$iv$iv2 = (DelegatingNode)node$iv4.getDelegate$ui_release();
            while (node$iv$iv2 != null) {
                node = node$iv$iv2;
                i8 = 0;
                stack$iv = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv3 = i7;
                if (this_$iv$iv3 != 0) {
                } else {
                }
                $i$f$visitSelfAndChildren6rFNWt03 = $i$f$visitSelfAndChildren6rFNWt02;
                node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt03;
                mutableVector = 1;
                if (this_$iv$iv2++ == mutableVector) {
                } else {
                }
                if ((MutableVector)stack$iv2 == 0) {
                } else {
                }
                $i$f$visitSelfAndChildren6rFNWt03 = $i$f$visitSelfAndChildren6rFNWt02;
                stack$iv2 = this_$iv$iv3;
                $i$f$visitSelfAndChildren6rFNWt02 = node$iv4;
                mutableVector = stack$iv2;
                if ((Modifier.Node)$i$f$visitSelfAndChildren6rFNWt02 != null && (MutableVector)mutableVector != null) {
                }
                mutableVector = stack$iv2;
                if ((MutableVector)mutableVector != null) {
                }
                (MutableVector)mutableVector.add(node);
                mutableVector = stack$iv2;
                if ((MutableVector)(MutableVector)mutableVector != null) {
                }
                node$iv4 = 0;
                (MutableVector)(MutableVector)mutableVector.add((Modifier.Node)$i$f$visitSelfAndChildren6rFNWt02);
                int i24 = 0;
                node$iv2 = 0;
                $i$f$visitSelfAndChildren6rFNWt03 = $i$f$visitSelfAndChildren6rFNWt02;
                mutableVector = new MutableVector(new Modifier.Node[16], i7);
                $i$f$visitSelfAndChildren6rFNWt02 = mutableVector;
                this_$iv$iv3 = mutableVector;
                node$iv4 = node;
                $i$f$visitSelfAndChildren6rFNWt03 = $i$f$visitSelfAndChildren6rFNWt02;
                this_$iv$iv3 = mutableVector;
            }
            if (this_$iv$iv2 == 1) {
            } else {
            }
            $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt03;
            node = node$iv$iv2;
            i8 = 0;
            stack$iv = 0;
            if (kindSet$ui_release3 &= type != 0) {
            } else {
            }
            this_$iv$iv3 = i7;
            if (this_$iv$iv3 != 0) {
            } else {
            }
            $i$f$visitSelfAndChildren6rFNWt03 = $i$f$visitSelfAndChildren6rFNWt02;
            node$iv$iv2 = node$iv$iv2.getChild$ui_release();
            $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt03;
            mutableVector = 1;
            if (this_$iv$iv2++ == mutableVector) {
            } else {
            }
            if ((MutableVector)stack$iv2 == 0) {
            } else {
            }
            $i$f$visitSelfAndChildren6rFNWt03 = $i$f$visitSelfAndChildren6rFNWt02;
            stack$iv2 = this_$iv$iv3;
            $i$f$visitSelfAndChildren6rFNWt02 = node$iv4;
            mutableVector = stack$iv2;
            if ((Modifier.Node)$i$f$visitSelfAndChildren6rFNWt02 != null && (MutableVector)mutableVector != null) {
            }
            mutableVector = stack$iv2;
            if ((MutableVector)mutableVector != null) {
            }
            (MutableVector)mutableVector.add(node);
            mutableVector = stack$iv2;
            if ((MutableVector)(MutableVector)mutableVector != null) {
            }
            node$iv4 = 0;
            (MutableVector)(MutableVector)mutableVector.add((Modifier.Node)$i$f$visitSelfAndChildren6rFNWt02);
            i24 = 0;
            node$iv2 = 0;
            $i$f$visitSelfAndChildren6rFNWt03 = $i$f$visitSelfAndChildren6rFNWt02;
            mutableVector = new MutableVector(new Modifier.Node[16], i7);
            $i$f$visitSelfAndChildren6rFNWt02 = mutableVector;
            this_$iv$iv3 = mutableVector;
            node$iv4 = node;
            $i$f$visitSelfAndChildren6rFNWt03 = $i$f$visitSelfAndChildren6rFNWt02;
            this_$iv$iv3 = mutableVector;
            this_$iv$iv2 = mutableVector;
            block.invoke(node$iv4);
            $i$f$visitSelfAndChildren6rFNWt03 = $i$f$visitSelfAndChildren6rFNWt02;
        }
        int $i$f$visitSelfAndChildren6rFNWt06 = $i$f$visitSelfAndChildren6rFNWt02;
        obj = $this$visitSelfAndChildren_u2d6rFNWt0;
        i3 = 0;
        if (!obj.getNode().isAttached()) {
        } else {
            int i21 = 0;
            node$iv3 = 0;
            MutableVector mutableVector3 = new MutableVector(new Modifier.Node[16], i7);
            Modifier.Node child$ui_release = obj.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector3, obj.getNode());
            } else {
                mutableVector3.add(child$ui_release);
            }
            while (mutableVector3.isNotEmpty()) {
                int i23 = 0;
                i11 = 1;
                node2 = mutableVector3.removeAt(size--);
                if (aggregateChildKindSet$ui_release &= $i$f$visitSelfAndChildren6rFNWt0 == 0) {
                } else {
                }
                node$iv3 = node2;
                while (node$iv3 != null) {
                    $this$visitChildren$iv2 = obj;
                    i = i3;
                    int mask$iv4 = i7;
                    int i14 = 1;
                    node$iv3 = node$iv3.getChild$ui_release();
                    obj3 = block;
                    $i$f$visitSelfAndChildren6rFNWt0 = mask$iv2;
                    count$iv2 = 3;
                }
                $this$visitChildren$iv2 = obj;
                i = i3;
                int mask$iv7 = i7;
                int i16 = 1;
                obj3 = block;
                $i$f$visitSelfAndChildren6rFNWt0 = mask$iv2;
                count$iv2 = 3;
                if (kindSet$ui_release2 &= $i$f$visitSelfAndChildren6rFNWt0 != 0) {
                } else {
                }
                $this$visitChildren$iv2 = obj;
                i = i3;
                mask$iv4 = i7;
                i14 = 1;
                node$iv3 = node$iv3.getChild$ui_release();
                obj3 = block;
                $i$f$visitSelfAndChildren6rFNWt0 = mask$iv2;
                count$iv2 = 3;
                node = 0;
                this_$iv$iv3 = 0;
                stack$iv = 0;
                int i25 = 0;
                node$iv = node$iv2;
                while (node$iv != null) {
                    Intrinsics.reifiedOperationMarker(count$iv2, str2);
                    if (node$iv instanceof Object != null) {
                    } else {
                    }
                    obj2 = 0;
                    if (kindSet$ui_release4 &= type != 0) {
                    } else {
                    }
                    count$iv = 0;
                    if (count$iv != 0 && node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv2 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv2 = obj;
                    i = i3;
                    i2 = 1;
                    mask$iv = 0;
                    node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                    obj3 = block;
                    $i$f$visitSelfAndChildren6rFNWt0 = mask$iv2;
                    obj = $this$visitChildren$iv2;
                    i3 = i;
                    count$iv2 = 3;
                    if (node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv = 0;
                    i10 = 0;
                    node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        Modifier.Node node3 = node$iv$iv;
                        i4 = 0;
                        i5 = 0;
                        if (kindSet$ui_release5 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv = 0;
                        if (this_$iv$iv != 0) {
                        } else {
                        }
                        mask$iv2 = $i$f$visitSelfAndChildren6rFNWt0;
                        $this$visitChildren$iv2 = obj;
                        i = i3;
                        mask$iv3 = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        obj3 = block;
                        $i$f$visitSelfAndChildren6rFNWt0 = mask$iv2;
                        obj = $this$visitChildren$iv2;
                        i3 = i;
                        mask$iv2 = $i$f$visitSelfAndChildren6rFNWt0;
                        if (count$iv++ == 1) {
                        } else {
                        }
                        int i17 = stack$iv;
                        if ((MutableVector)i17 == 0) {
                        } else {
                        }
                        $this$visitChildren$iv2 = obj;
                        i = i3;
                        $this$visitChildren$iv = i17;
                        mask$iv3 = 0;
                        stack$iv = $this$visitChildren$iv;
                        obj = node$iv;
                        int i20 = stack$iv;
                        if ((Modifier.Node)obj != null && (MutableVector)i20 != 0) {
                        }
                        i3 = stack$iv;
                        if ((MutableVector)i3 != 0) {
                        }
                        (MutableVector)i3.add(node3);
                        i20 = stack$iv;
                        if ((MutableVector)(MutableVector)i20 != 0) {
                        }
                        node$iv = i3;
                        (MutableVector)(MutableVector)i20.add((Modifier.Node)obj);
                        i5 = i18;
                        int $i$f$mutableVectorOf = 16;
                        i6 = 0;
                        $this$visitChildren$iv2 = obj;
                        i = i3;
                        i12 = $i$f$mutableVectorOf;
                        $this$visitChildren$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        i3 = $this$visitChildren$iv;
                        node$iv = node3;
                        $this$visitChildren$iv2 = obj;
                        i = i3;
                        mask$iv3 = 0;
                        this_$iv$iv = 1;
                    }
                    mask$iv = 0;
                    if (count$iv == 1) {
                    } else {
                    }
                    obj3 = block;
                    $i$f$visitSelfAndChildren6rFNWt0 = mask$iv2;
                    obj = $this$visitChildren$iv2;
                    i3 = i;
                    count$iv2 = 3;
                    node3 = node$iv$iv;
                    i4 = 0;
                    i5 = 0;
                    if (kindSet$ui_release5 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    mask$iv2 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv2 = obj;
                    i = i3;
                    mask$iv3 = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    obj3 = block;
                    $i$f$visitSelfAndChildren6rFNWt0 = mask$iv2;
                    obj = $this$visitChildren$iv2;
                    i3 = i;
                    mask$iv2 = $i$f$visitSelfAndChildren6rFNWt0;
                    if (count$iv++ == 1) {
                    } else {
                    }
                    i17 = stack$iv;
                    if ((MutableVector)(MutableVector)i17 == 0) {
                    } else {
                    }
                    $this$visitChildren$iv2 = obj;
                    i = i3;
                    $this$visitChildren$iv = i17;
                    mask$iv3 = 0;
                    stack$iv = $this$visitChildren$iv;
                    obj = node$iv;
                    i20 = stack$iv;
                    if ((Modifier.Node)obj != null && (MutableVector)i20 != 0) {
                    }
                    i3 = stack$iv;
                    if ((MutableVector)i3 != 0) {
                    }
                    (MutableVector)i3.add(node3);
                    i20 = stack$iv;
                    if ((MutableVector)(MutableVector)i20 != 0) {
                    }
                    node$iv = i3;
                    (MutableVector)(MutableVector)i20.add((Modifier.Node)obj);
                    i5 = i18;
                    $i$f$mutableVectorOf = 16;
                    i6 = 0;
                    $this$visitChildren$iv2 = obj;
                    i = i3;
                    i12 = $i$f$mutableVectorOf;
                    $this$visitChildren$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i3 = $this$visitChildren$iv;
                    node$iv = node3;
                    $this$visitChildren$iv2 = obj;
                    i = i3;
                    mask$iv3 = 0;
                    this_$iv$iv = 1;
                    count$iv = 1;
                    obj3.invoke(node$iv);
                    mask$iv2 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv2 = obj;
                    i = i3;
                    i2 = 1;
                    mask$iv = 0;
                }
                $this$visitChildren$iv2 = obj;
                i = i3;
                int i15 = 1;
                obj3 = block;
                i7 = mask$iv6;
                $i$f$visitSelfAndChildren6rFNWt0 = mask$iv2;
                count$iv2 = 3;
                Intrinsics.reifiedOperationMarker(count$iv2, str2);
                if (node$iv instanceof Object != null) {
                } else {
                }
                obj2 = 0;
                if (kindSet$ui_release4 &= type != 0) {
                } else {
                }
                count$iv = 0;
                if (count$iv != 0 && node$iv instanceof DelegatingNode) {
                } else {
                }
                mask$iv2 = $i$f$visitSelfAndChildren6rFNWt0;
                $this$visitChildren$iv2 = obj;
                i = i3;
                i2 = 1;
                mask$iv = 0;
                node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                obj3 = block;
                $i$f$visitSelfAndChildren6rFNWt0 = mask$iv2;
                obj = $this$visitChildren$iv2;
                i3 = i;
                count$iv2 = 3;
                if (node$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv = 0;
                i10 = 0;
                node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                while (node$iv$iv != null) {
                    node3 = node$iv$iv;
                    i4 = 0;
                    i5 = 0;
                    if (kindSet$ui_release5 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    mask$iv2 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv2 = obj;
                    i = i3;
                    mask$iv3 = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    obj3 = block;
                    $i$f$visitSelfAndChildren6rFNWt0 = mask$iv2;
                    obj = $this$visitChildren$iv2;
                    i3 = i;
                    mask$iv2 = $i$f$visitSelfAndChildren6rFNWt0;
                    if (count$iv++ == 1) {
                    } else {
                    }
                    i17 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)i17 == 0) {
                    } else {
                    }
                    $this$visitChildren$iv2 = obj;
                    i = i3;
                    $this$visitChildren$iv = i17;
                    mask$iv3 = 0;
                    stack$iv = $this$visitChildren$iv;
                    obj = node$iv;
                    i20 = stack$iv;
                    if ((Modifier.Node)obj != null && (MutableVector)i20 != 0) {
                    }
                    i3 = stack$iv;
                    if ((MutableVector)i3 != 0) {
                    }
                    (MutableVector)i3.add(node3);
                    i20 = stack$iv;
                    if ((MutableVector)(MutableVector)i20 != 0) {
                    }
                    node$iv = i3;
                    (MutableVector)(MutableVector)i20.add((Modifier.Node)obj);
                    i5 = i18;
                    $i$f$mutableVectorOf = 16;
                    i6 = 0;
                    $this$visitChildren$iv2 = obj;
                    i = i3;
                    i12 = $i$f$mutableVectorOf;
                    $this$visitChildren$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i3 = $this$visitChildren$iv;
                    node$iv = node3;
                    $this$visitChildren$iv2 = obj;
                    i = i3;
                    mask$iv3 = 0;
                    this_$iv$iv = 1;
                }
                mask$iv = 0;
                if (count$iv == 1) {
                } else {
                }
                obj3 = block;
                $i$f$visitSelfAndChildren6rFNWt0 = mask$iv2;
                obj = $this$visitChildren$iv2;
                i3 = i;
                count$iv2 = 3;
                node3 = node$iv$iv;
                i4 = 0;
                i5 = 0;
                if (kindSet$ui_release5 &= type != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0) {
                } else {
                }
                mask$iv2 = $i$f$visitSelfAndChildren6rFNWt0;
                $this$visitChildren$iv2 = obj;
                i = i3;
                mask$iv3 = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                obj3 = block;
                $i$f$visitSelfAndChildren6rFNWt0 = mask$iv2;
                obj = $this$visitChildren$iv2;
                i3 = i;
                mask$iv2 = $i$f$visitSelfAndChildren6rFNWt0;
                if (count$iv++ == 1) {
                } else {
                }
                i17 = stack$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)i17 == 0) {
                } else {
                }
                $this$visitChildren$iv2 = obj;
                i = i3;
                $this$visitChildren$iv = i17;
                mask$iv3 = 0;
                stack$iv = $this$visitChildren$iv;
                obj = node$iv;
                i20 = stack$iv;
                if ((Modifier.Node)obj != null && (MutableVector)i20 != 0) {
                }
                i3 = stack$iv;
                if ((MutableVector)i3 != 0) {
                }
                (MutableVector)i3.add(node3);
                i20 = stack$iv;
                if ((MutableVector)(MutableVector)i20 != 0) {
                }
                node$iv = i3;
                (MutableVector)(MutableVector)i20.add((Modifier.Node)obj);
                i5 = i18;
                $i$f$mutableVectorOf = 16;
                i6 = 0;
                $this$visitChildren$iv2 = obj;
                i = i3;
                i12 = $i$f$mutableVectorOf;
                $this$visitChildren$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i3 = $this$visitChildren$iv;
                node$iv = node3;
                $this$visitChildren$iv2 = obj;
                i = i3;
                mask$iv3 = 0;
                this_$iv$iv = 1;
                count$iv = 1;
                obj3.invoke(node$iv);
                mask$iv2 = $i$f$visitSelfAndChildren6rFNWt0;
                $this$visitChildren$iv2 = obj;
                i = i3;
                i2 = 1;
                mask$iv = 0;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector3, node2);
            }
        }
        Object obj5 = $i$f$visitSelfAndChildren6rFNWt0;
        int i13 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv;
    }

    public static final <T> void visitSelfAndLocalDescendants-6rFNWt0(androidx.compose.ui.node.DelegatableNode $this$visitSelfAndLocalDescendants_u2d6rFNWt0, int type, Function1<? super T, Unit> block) {
        int i;
        int includeSelf$iv;
        int capacity$iv$iv$iv;
        Modifier.Node node4;
        int $this$visitLocalDescendants$iv2;
        int i13;
        Modifier.Node next$iv;
        String $i$a$CheckPreconditionDelegatableNodeKt$visitLocalDescendants$1$iv;
        String str;
        Modifier.Node node;
        int i2;
        int stack$iv;
        Modifier.Node node$iv;
        Object obj;
        Object obj2;
        String this_$iv$iv2;
        Modifier.Node node2;
        int i5;
        int i9;
        int i6;
        Modifier.Node node$iv$iv;
        int i4;
        int includeSelf$iv2;
        int this_$iv$iv;
        int i3;
        int i10;
        int i11;
        Modifier.Node $this$visitLocalDescendants$iv;
        Modifier.Node node3;
        int i12;
        int i7;
        int i8;
        node4 = $this$visitSelfAndLocalDescendants_u2d6rFNWt0;
        i13 = type;
        final int i18 = 0;
        int i19 = 0;
        if (!node4.getNode().isAttached()) {
            int i20 = 0;
            $i$a$CheckPreconditionDelegatableNodeKt$visitLocalDescendants$1$iv = "visitLocalDescendants called on an unattached node";
            str = $i$a$CheckPreconditionDelegatableNodeKt$visitLocalDescendants$1$iv;
            InlineClassHelperKt.throwIllegalStateException($i$a$CheckPreconditionDelegatableNodeKt$visitLocalDescendants$1$iv);
        }
        Modifier.Node node6 = node4.getNode();
        if (aggregateChildKindSet$ui_release &= i13 != 0) {
            next$iv = node6;
            while (next$iv != null) {
                if (kindSet$ui_release &= i13 != 0) {
                } else {
                }
                obj = block;
                i9 = i;
                includeSelf$iv2 = includeSelf$iv;
                $this$visitLocalDescendants$iv = node4;
                i12 = i13;
                next$iv = next$iv.getChild$ui_release();
                i = i9;
                includeSelf$iv = includeSelf$iv2;
                node4 = $this$visitLocalDescendants$iv;
                i13 = i12;
                str = 0;
                i2 = 0;
                stack$iv = 0;
                int i21 = 0;
                node$iv = node;
                while (node$iv != null) {
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (node$iv instanceof Object != null) {
                    } else {
                    }
                    obj = block;
                    node2 = 0;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    if (this_$iv$iv2 != 0 && node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    includeSelf$iv2 = includeSelf$iv;
                    $this$visitLocalDescendants$iv = node4;
                    i12 = i13;
                    node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                    i = i9;
                    includeSelf$iv = includeSelf$iv2;
                    node4 = $this$visitLocalDescendants$iv;
                    i13 = i12;
                    if (node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    i5 = 0;
                    node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        i = node$iv$iv;
                        i4 = 0;
                        i10 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv = 0;
                        if (this_$iv$iv != 0) {
                        } else {
                        }
                        includeSelf$iv2 = includeSelf$iv;
                        $this$visitLocalDescendants$iv = node4;
                        i12 = i13;
                        capacity$iv$iv$iv = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        includeSelf$iv = includeSelf$iv2;
                        node4 = $this$visitLocalDescendants$iv;
                        i13 = i12;
                        includeSelf$iv2 = includeSelf$iv;
                        if (this_$iv$iv2++ == 1) {
                        } else {
                        }
                        int i15 = stack$iv;
                        if ((MutableVector)i15 == 0) {
                        } else {
                        }
                        $this$visitLocalDescendants$iv = node4;
                        i12 = i13;
                        $this$visitLocalDescendants$iv2 = i15;
                        capacity$iv$iv$iv = 0;
                        stack$iv = $this$visitLocalDescendants$iv2;
                        node4 = node$iv;
                        int i17 = stack$iv;
                        if ((Modifier.Node)node4 != null && (MutableVector)i17 != 0) {
                        }
                        i13 = stack$iv;
                        if ((MutableVector)i13 != 0) {
                        }
                        (MutableVector)i13.add(i);
                        i17 = stack$iv;
                        if ((MutableVector)(MutableVector)i17 != 0) {
                        }
                        node$iv = i13;
                        (MutableVector)(MutableVector)i17.add((Modifier.Node)node4);
                        i10 = i16;
                        int $i$f$mutableVectorOf = 16;
                        i11 = 0;
                        $this$visitLocalDescendants$iv = node4;
                        i12 = i13;
                        i8 = $i$f$mutableVectorOf;
                        $this$visitLocalDescendants$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        i13 = $this$visitLocalDescendants$iv2;
                        node$iv = i;
                        $this$visitLocalDescendants$iv = node4;
                        i12 = i13;
                        capacity$iv$iv$iv = 0;
                        this_$iv$iv = 1;
                    }
                    if (this_$iv$iv2 == 1) {
                    } else {
                    }
                    i = i9;
                    includeSelf$iv = includeSelf$iv2;
                    node4 = $this$visitLocalDescendants$iv;
                    i13 = i12;
                    i = node$iv$iv;
                    i4 = 0;
                    i10 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    includeSelf$iv2 = includeSelf$iv;
                    $this$visitLocalDescendants$iv = node4;
                    i12 = i13;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    includeSelf$iv = includeSelf$iv2;
                    node4 = $this$visitLocalDescendants$iv;
                    i13 = i12;
                    includeSelf$iv2 = includeSelf$iv;
                    if (this_$iv$iv2++ == 1) {
                    } else {
                    }
                    i15 = stack$iv;
                    if ((MutableVector)(MutableVector)i15 == 0) {
                    } else {
                    }
                    $this$visitLocalDescendants$iv = node4;
                    i12 = i13;
                    $this$visitLocalDescendants$iv2 = i15;
                    capacity$iv$iv$iv = 0;
                    stack$iv = $this$visitLocalDescendants$iv2;
                    node4 = node$iv;
                    i17 = stack$iv;
                    if ((Modifier.Node)node4 != null && (MutableVector)i17 != 0) {
                    }
                    i13 = stack$iv;
                    if ((MutableVector)i13 != 0) {
                    }
                    (MutableVector)i13.add(i);
                    i17 = stack$iv;
                    if ((MutableVector)(MutableVector)i17 != 0) {
                    }
                    node$iv = i13;
                    (MutableVector)(MutableVector)i17.add((Modifier.Node)node4);
                    i10 = i16;
                    $i$f$mutableVectorOf = 16;
                    i11 = 0;
                    $this$visitLocalDescendants$iv = node4;
                    i12 = i13;
                    i8 = $i$f$mutableVectorOf;
                    $this$visitLocalDescendants$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i13 = $this$visitLocalDescendants$iv2;
                    node$iv = i;
                    $this$visitLocalDescendants$iv = node4;
                    i12 = i13;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv = 1;
                    this_$iv$iv2 = 1;
                    block.invoke(node$iv);
                    i9 = i;
                    includeSelf$iv2 = includeSelf$iv;
                    $this$visitLocalDescendants$iv = node4;
                    i12 = i13;
                }
                obj = block;
                i9 = i;
                includeSelf$iv2 = includeSelf$iv;
                $this$visitLocalDescendants$iv = node4;
                i12 = i13;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (node$iv instanceof Object != null) {
                } else {
                }
                obj = block;
                node2 = 0;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                this_$iv$iv2 = 0;
                if (this_$iv$iv2 != 0 && node$iv instanceof DelegatingNode) {
                } else {
                }
                includeSelf$iv2 = includeSelf$iv;
                $this$visitLocalDescendants$iv = node4;
                i12 = i13;
                node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                i = i9;
                includeSelf$iv = includeSelf$iv2;
                node4 = $this$visitLocalDescendants$iv;
                i13 = i12;
                if (node$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv2 = 0;
                i5 = 0;
                node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                while (node$iv$iv != null) {
                    i = node$iv$iv;
                    i4 = 0;
                    i10 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    includeSelf$iv2 = includeSelf$iv;
                    $this$visitLocalDescendants$iv = node4;
                    i12 = i13;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    includeSelf$iv = includeSelf$iv2;
                    node4 = $this$visitLocalDescendants$iv;
                    i13 = i12;
                    includeSelf$iv2 = includeSelf$iv;
                    if (this_$iv$iv2++ == 1) {
                    } else {
                    }
                    i15 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)i15 == 0) {
                    } else {
                    }
                    $this$visitLocalDescendants$iv = node4;
                    i12 = i13;
                    $this$visitLocalDescendants$iv2 = i15;
                    capacity$iv$iv$iv = 0;
                    stack$iv = $this$visitLocalDescendants$iv2;
                    node4 = node$iv;
                    i17 = stack$iv;
                    if ((Modifier.Node)node4 != null && (MutableVector)i17 != 0) {
                    }
                    i13 = stack$iv;
                    if ((MutableVector)i13 != 0) {
                    }
                    (MutableVector)i13.add(i);
                    i17 = stack$iv;
                    if ((MutableVector)(MutableVector)i17 != 0) {
                    }
                    node$iv = i13;
                    (MutableVector)(MutableVector)i17.add((Modifier.Node)node4);
                    i10 = i16;
                    $i$f$mutableVectorOf = 16;
                    i11 = 0;
                    $this$visitLocalDescendants$iv = node4;
                    i12 = i13;
                    i8 = $i$f$mutableVectorOf;
                    $this$visitLocalDescendants$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i13 = $this$visitLocalDescendants$iv2;
                    node$iv = i;
                    $this$visitLocalDescendants$iv = node4;
                    i12 = i13;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv = 1;
                }
                if (this_$iv$iv2 == 1) {
                } else {
                }
                i = i9;
                includeSelf$iv = includeSelf$iv2;
                node4 = $this$visitLocalDescendants$iv;
                i13 = i12;
                i = node$iv$iv;
                i4 = 0;
                i10 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0) {
                } else {
                }
                includeSelf$iv2 = includeSelf$iv;
                $this$visitLocalDescendants$iv = node4;
                i12 = i13;
                capacity$iv$iv$iv = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                includeSelf$iv = includeSelf$iv2;
                node4 = $this$visitLocalDescendants$iv;
                i13 = i12;
                includeSelf$iv2 = includeSelf$iv;
                if (this_$iv$iv2++ == 1) {
                } else {
                }
                i15 = stack$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)i15 == 0) {
                } else {
                }
                $this$visitLocalDescendants$iv = node4;
                i12 = i13;
                $this$visitLocalDescendants$iv2 = i15;
                capacity$iv$iv$iv = 0;
                stack$iv = $this$visitLocalDescendants$iv2;
                node4 = node$iv;
                i17 = stack$iv;
                if ((Modifier.Node)node4 != null && (MutableVector)i17 != 0) {
                }
                i13 = stack$iv;
                if ((MutableVector)i13 != 0) {
                }
                (MutableVector)i13.add(i);
                i17 = stack$iv;
                if ((MutableVector)(MutableVector)i17 != 0) {
                }
                node$iv = i13;
                (MutableVector)(MutableVector)i17.add((Modifier.Node)node4);
                i10 = i16;
                $i$f$mutableVectorOf = 16;
                i11 = 0;
                $this$visitLocalDescendants$iv = node4;
                i12 = i13;
                i8 = $i$f$mutableVectorOf;
                $this$visitLocalDescendants$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i13 = $this$visitLocalDescendants$iv2;
                node$iv = i;
                $this$visitLocalDescendants$iv = node4;
                i12 = i13;
                capacity$iv$iv$iv = 0;
                this_$iv$iv = 1;
                this_$iv$iv2 = 1;
                block.invoke(node$iv);
                i9 = i;
                includeSelf$iv2 = includeSelf$iv;
                $this$visitLocalDescendants$iv = node4;
                i12 = i13;
            }
            obj2 = block;
            i6 = i;
            i3 = includeSelf$iv;
            node3 = node4;
            i7 = i13;
        } else {
            obj2 = block;
            i6 = i;
            i3 = includeSelf$iv;
            node3 = node4;
            i7 = i13;
        }
    }

    public static final void visitSubtree(androidx.compose.ui.node.DelegatableNode $this$visitSubtree, int mask, Function1<? super Modifier.Node, Unit> block) {
        Modifier.Node child$ui_release;
        int i2;
        androidx.compose.ui.node.LayoutNode layout;
        String $i$a$CheckPreconditionDelegatableNodeKt$visitSubtree$1;
        int i;
        Modifier.Node node;
        final int i3 = 0;
        int i4 = 0;
        if (!$this$visitSubtree.getNode().isAttached()) {
            int i5 = 0;
            InlineClassHelperKt.throwIllegalStateException("visitSubtree called on an unattached node");
        }
        child$ui_release = $this$visitSubtree.getNode().getChild$ui_release();
        layout = DelegatableNodeKt.requireLayoutNode($this$visitSubtree);
        NestedVectorStack nestedVectorStack = new NestedVectorStack();
        while (layout != null) {
            if (child$ui_release == null) {
            } else {
            }
            node = child$ui_release;
            if (aggregateChildKindSet$ui_release &= mask != 0) {
            }
            child$ui_release = null;
            nestedVectorStack.push(layout.get_children$ui_release());
            if (nestedVectorStack.isNotEmpty()) {
            } else {
            }
            i = 0;
            layout = i;
            i = nestedVectorStack.pop();
            while (node != null) {
                if (kindSet$ui_release &= mask != 0) {
                }
                node = node.getChild$ui_release();
                block.invoke(node);
            }
            if (kindSet$ui_release &= mask != 0) {
            }
            node = node.getChild$ui_release();
            block.invoke(node);
            node = layout.getNodes$ui_release().getHead$ui_release();
        }
    }

    public static final <T> void visitSubtree-6rFNWt0(androidx.compose.ui.node.DelegatableNode $this$visitSubtree_u2d6rFNWt0, int type, Function1<? super T, Unit> block) {
        int i13;
        int i7;
        int mask$iv;
        int capacity$iv$iv$iv;
        androidx.compose.ui.node.DelegatableNode delegatableNode;
        MutableVector $this$visitSubtree$iv;
        int i2;
        Modifier.Node child$ui_release;
        int i9;
        androidx.compose.ui.node.LayoutNode layout$iv;
        String $i$a$CheckPreconditionDelegatableNodeKt$visitSubtree$1$iv;
        String node$iv;
        int i5;
        Modifier.Node node2;
        int i6;
        int stack$iv;
        Modifier.Node node$iv2;
        Object obj;
        int this_$iv$iv2;
        Modifier.Node node;
        int i12;
        int i11;
        Modifier.Node node$iv$iv;
        int i4;
        int mask$iv2;
        int this_$iv$iv;
        int i10;
        int i3;
        androidx.compose.ui.node.DelegatableNode $this$visitSubtree$iv2;
        int i8;
        int i;
        i13 = 0;
        mask$iv = type;
        delegatableNode = $this$visitSubtree_u2d6rFNWt0;
        i2 = 0;
        int i17 = 0;
        if (!delegatableNode.getNode().isAttached()) {
            int i18 = 0;
            $i$a$CheckPreconditionDelegatableNodeKt$visitSubtree$1$iv = "visitSubtree called on an unattached node";
            node$iv = $i$a$CheckPreconditionDelegatableNodeKt$visitSubtree$1$iv;
            InlineClassHelperKt.throwIllegalStateException($i$a$CheckPreconditionDelegatableNodeKt$visitSubtree$1$iv);
        }
        child$ui_release = delegatableNode.getNode().getChild$ui_release();
        layout$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        NestedVectorStack nestedVectorStack = new NestedVectorStack();
        while (layout$iv != null) {
            if (child$ui_release == null) {
            } else {
            }
            node$iv = child$ui_release;
            if (aggregateChildKindSet$ui_release &= mask$iv != 0) {
            } else {
            }
            obj = block;
            i11 = i13;
            mask$iv2 = mask$iv;
            $this$visitSubtree$iv2 = delegatableNode;
            i8 = i2;
            child$ui_release = null;
            nestedVectorStack.push(layout$iv.get_children$ui_release());
            if (nestedVectorStack.isNotEmpty()) {
            } else {
            }
            i7 = 0;
            layout$iv = i7;
            i13 = i11;
            mask$iv = mask$iv2;
            delegatableNode = $this$visitSubtree$iv2;
            i2 = i8;
            i7 = nestedVectorStack.pop();
            while (node$iv != null) {
                if (kindSet$ui_release &= mask$iv != 0) {
                } else {
                }
                obj = block;
                i11 = i13;
                mask$iv2 = mask$iv;
                $this$visitSubtree$iv2 = delegatableNode;
                i8 = i2;
                node$iv = node$iv.getChild$ui_release();
                i13 = i11;
                mask$iv = mask$iv2;
                delegatableNode = $this$visitSubtree$iv2;
                i2 = i8;
                i5 = 0;
                i6 = 0;
                stack$iv = 0;
                int i19 = 0;
                node$iv2 = node2;
                while (node$iv2 != null) {
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (node$iv2 instanceof Object != null) {
                    } else {
                    }
                    obj = block;
                    node = 0;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    if (this_$iv$iv2 != 0 && node$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv2 = mask$iv;
                    $this$visitSubtree$iv2 = delegatableNode;
                    i8 = i2;
                    node$iv2 = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                    i13 = i11;
                    mask$iv = mask$iv2;
                    delegatableNode = $this$visitSubtree$iv2;
                    i2 = i8;
                    if (node$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    i12 = 0;
                    node$iv$iv = (DelegatingNode)node$iv2.getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        i13 = node$iv$iv;
                        i4 = 0;
                        i10 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv = 0;
                        if (this_$iv$iv != 0) {
                        } else {
                        }
                        mask$iv2 = mask$iv;
                        $this$visitSubtree$iv2 = delegatableNode;
                        i8 = i2;
                        capacity$iv$iv$iv = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        mask$iv = mask$iv2;
                        delegatableNode = $this$visitSubtree$iv2;
                        i2 = i8;
                        mask$iv2 = mask$iv;
                        if (this_$iv$iv2++ == 1) {
                        } else {
                        }
                        int i15 = stack$iv;
                        if ((MutableVector)i15 == 0) {
                        } else {
                        }
                        $this$visitSubtree$iv2 = delegatableNode;
                        i8 = i2;
                        $this$visitSubtree$iv = i15;
                        capacity$iv$iv$iv = 0;
                        stack$iv = $this$visitSubtree$iv;
                        delegatableNode = node$iv2;
                        MutableVector mutableVector2 = stack$iv;
                        if ((Modifier.Node)delegatableNode != null && (MutableVector)mutableVector2 != null) {
                        }
                        i2 = stack$iv;
                        if ((MutableVector)i2 != null) {
                        }
                        (MutableVector)i2.add(i13);
                        mutableVector2 = stack$iv;
                        if ((MutableVector)(MutableVector)mutableVector2 != null) {
                        }
                        node$iv2 = i2;
                        (MutableVector)(MutableVector)mutableVector2.add((Modifier.Node)delegatableNode);
                        i10 = i16;
                        int $i$f$mutableVectorOf = 16;
                        i3 = 0;
                        $this$visitSubtree$iv2 = delegatableNode;
                        i8 = i2;
                        i = $i$f$mutableVectorOf;
                        $this$visitSubtree$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        i2 = $this$visitSubtree$iv;
                        node$iv2 = i13;
                        $this$visitSubtree$iv2 = delegatableNode;
                        i8 = i2;
                        capacity$iv$iv$iv = 0;
                        this_$iv$iv = 1;
                    }
                    if (this_$iv$iv2 == 1) {
                    } else {
                    }
                    i13 = i11;
                    mask$iv = mask$iv2;
                    delegatableNode = $this$visitSubtree$iv2;
                    i2 = i8;
                    i13 = node$iv$iv;
                    i4 = 0;
                    i10 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    mask$iv2 = mask$iv;
                    $this$visitSubtree$iv2 = delegatableNode;
                    i8 = i2;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    mask$iv = mask$iv2;
                    delegatableNode = $this$visitSubtree$iv2;
                    i2 = i8;
                    mask$iv2 = mask$iv;
                    if (this_$iv$iv2++ == 1) {
                    } else {
                    }
                    i15 = stack$iv;
                    if ((MutableVector)(MutableVector)i15 == 0) {
                    } else {
                    }
                    $this$visitSubtree$iv2 = delegatableNode;
                    i8 = i2;
                    $this$visitSubtree$iv = i15;
                    capacity$iv$iv$iv = 0;
                    stack$iv = $this$visitSubtree$iv;
                    delegatableNode = node$iv2;
                    mutableVector2 = stack$iv;
                    if ((Modifier.Node)delegatableNode != null && (MutableVector)mutableVector2 != null) {
                    }
                    i2 = stack$iv;
                    if ((MutableVector)i2 != null) {
                    }
                    (MutableVector)i2.add(i13);
                    mutableVector2 = stack$iv;
                    if ((MutableVector)(MutableVector)mutableVector2 != null) {
                    }
                    node$iv2 = i2;
                    (MutableVector)(MutableVector)mutableVector2.add((Modifier.Node)delegatableNode);
                    i10 = i16;
                    $i$f$mutableVectorOf = 16;
                    i3 = 0;
                    $this$visitSubtree$iv2 = delegatableNode;
                    i8 = i2;
                    i = $i$f$mutableVectorOf;
                    $this$visitSubtree$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i2 = $this$visitSubtree$iv;
                    node$iv2 = i13;
                    $this$visitSubtree$iv2 = delegatableNode;
                    i8 = i2;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv = 1;
                    this_$iv$iv2 = 1;
                    block.invoke(node$iv2);
                    i11 = i13;
                    mask$iv2 = mask$iv;
                    $this$visitSubtree$iv2 = delegatableNode;
                    i8 = i2;
                }
                obj = block;
                i11 = i13;
                mask$iv2 = mask$iv;
                $this$visitSubtree$iv2 = delegatableNode;
                i8 = i2;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (node$iv2 instanceof Object != null) {
                } else {
                }
                obj = block;
                node = 0;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                this_$iv$iv2 = 0;
                if (this_$iv$iv2 != 0 && node$iv2 instanceof DelegatingNode) {
                } else {
                }
                mask$iv2 = mask$iv;
                $this$visitSubtree$iv2 = delegatableNode;
                i8 = i2;
                node$iv2 = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                i13 = i11;
                mask$iv = mask$iv2;
                delegatableNode = $this$visitSubtree$iv2;
                i2 = i8;
                if (node$iv2 instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv2 = 0;
                i12 = 0;
                node$iv$iv = (DelegatingNode)node$iv2.getDelegate$ui_release();
                while (node$iv$iv != null) {
                    i13 = node$iv$iv;
                    i4 = 0;
                    i10 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    mask$iv2 = mask$iv;
                    $this$visitSubtree$iv2 = delegatableNode;
                    i8 = i2;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    mask$iv = mask$iv2;
                    delegatableNode = $this$visitSubtree$iv2;
                    i2 = i8;
                    mask$iv2 = mask$iv;
                    if (this_$iv$iv2++ == 1) {
                    } else {
                    }
                    i15 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)i15 == 0) {
                    } else {
                    }
                    $this$visitSubtree$iv2 = delegatableNode;
                    i8 = i2;
                    $this$visitSubtree$iv = i15;
                    capacity$iv$iv$iv = 0;
                    stack$iv = $this$visitSubtree$iv;
                    delegatableNode = node$iv2;
                    mutableVector2 = stack$iv;
                    if ((Modifier.Node)delegatableNode != null && (MutableVector)mutableVector2 != null) {
                    }
                    i2 = stack$iv;
                    if ((MutableVector)i2 != null) {
                    }
                    (MutableVector)i2.add(i13);
                    mutableVector2 = stack$iv;
                    if ((MutableVector)(MutableVector)mutableVector2 != null) {
                    }
                    node$iv2 = i2;
                    (MutableVector)(MutableVector)mutableVector2.add((Modifier.Node)delegatableNode);
                    i10 = i16;
                    $i$f$mutableVectorOf = 16;
                    i3 = 0;
                    $this$visitSubtree$iv2 = delegatableNode;
                    i8 = i2;
                    i = $i$f$mutableVectorOf;
                    $this$visitSubtree$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i2 = $this$visitSubtree$iv;
                    node$iv2 = i13;
                    $this$visitSubtree$iv2 = delegatableNode;
                    i8 = i2;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv = 1;
                }
                if (this_$iv$iv2 == 1) {
                } else {
                }
                i13 = i11;
                mask$iv = mask$iv2;
                delegatableNode = $this$visitSubtree$iv2;
                i2 = i8;
                i13 = node$iv$iv;
                i4 = 0;
                i10 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0) {
                } else {
                }
                mask$iv2 = mask$iv;
                $this$visitSubtree$iv2 = delegatableNode;
                i8 = i2;
                capacity$iv$iv$iv = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                mask$iv = mask$iv2;
                delegatableNode = $this$visitSubtree$iv2;
                i2 = i8;
                mask$iv2 = mask$iv;
                if (this_$iv$iv2++ == 1) {
                } else {
                }
                i15 = stack$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)i15 == 0) {
                } else {
                }
                $this$visitSubtree$iv2 = delegatableNode;
                i8 = i2;
                $this$visitSubtree$iv = i15;
                capacity$iv$iv$iv = 0;
                stack$iv = $this$visitSubtree$iv;
                delegatableNode = node$iv2;
                mutableVector2 = stack$iv;
                if ((Modifier.Node)delegatableNode != null && (MutableVector)mutableVector2 != null) {
                }
                i2 = stack$iv;
                if ((MutableVector)i2 != null) {
                }
                (MutableVector)i2.add(i13);
                mutableVector2 = stack$iv;
                if ((MutableVector)(MutableVector)mutableVector2 != null) {
                }
                node$iv2 = i2;
                (MutableVector)(MutableVector)mutableVector2.add((Modifier.Node)delegatableNode);
                i10 = i16;
                $i$f$mutableVectorOf = 16;
                i3 = 0;
                $this$visitSubtree$iv2 = delegatableNode;
                i8 = i2;
                i = $i$f$mutableVectorOf;
                $this$visitSubtree$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i2 = $this$visitSubtree$iv;
                node$iv2 = i13;
                $this$visitSubtree$iv2 = delegatableNode;
                i8 = i2;
                capacity$iv$iv$iv = 0;
                this_$iv$iv = 1;
                this_$iv$iv2 = 1;
                block.invoke(node$iv2);
                i11 = i13;
                mask$iv2 = mask$iv;
                $this$visitSubtree$iv2 = delegatableNode;
                i8 = i2;
            }
            obj = block;
            i11 = i13;
            mask$iv2 = mask$iv;
            $this$visitSubtree$iv2 = delegatableNode;
            i8 = i2;
            if (kindSet$ui_release &= mask$iv != 0) {
            } else {
            }
            obj = block;
            i11 = i13;
            mask$iv2 = mask$iv;
            $this$visitSubtree$iv2 = delegatableNode;
            i8 = i2;
            node$iv = node$iv.getChild$ui_release();
            i13 = i11;
            mask$iv = mask$iv2;
            delegatableNode = $this$visitSubtree$iv2;
            i2 = i8;
            i5 = 0;
            i6 = 0;
            stack$iv = 0;
            i19 = 0;
            node$iv2 = node2;
            while (node$iv2 != null) {
                Intrinsics.reifiedOperationMarker(3, "T");
                if (node$iv2 instanceof Object != null) {
                } else {
                }
                obj = block;
                node = 0;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                this_$iv$iv2 = 0;
                if (this_$iv$iv2 != 0 && node$iv2 instanceof DelegatingNode) {
                } else {
                }
                mask$iv2 = mask$iv;
                $this$visitSubtree$iv2 = delegatableNode;
                i8 = i2;
                node$iv2 = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                i13 = i11;
                mask$iv = mask$iv2;
                delegatableNode = $this$visitSubtree$iv2;
                i2 = i8;
                if (node$iv2 instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv2 = 0;
                i12 = 0;
                node$iv$iv = (DelegatingNode)node$iv2.getDelegate$ui_release();
                while (node$iv$iv != null) {
                    i13 = node$iv$iv;
                    i4 = 0;
                    i10 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    mask$iv2 = mask$iv;
                    $this$visitSubtree$iv2 = delegatableNode;
                    i8 = i2;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    mask$iv = mask$iv2;
                    delegatableNode = $this$visitSubtree$iv2;
                    i2 = i8;
                    mask$iv2 = mask$iv;
                    if (this_$iv$iv2++ == 1) {
                    } else {
                    }
                    i15 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i15 == 0) {
                    } else {
                    }
                    $this$visitSubtree$iv2 = delegatableNode;
                    i8 = i2;
                    $this$visitSubtree$iv = i15;
                    capacity$iv$iv$iv = 0;
                    stack$iv = $this$visitSubtree$iv;
                    delegatableNode = node$iv2;
                    mutableVector2 = stack$iv;
                    if ((Modifier.Node)delegatableNode != null && (MutableVector)mutableVector2 != null) {
                    }
                    i2 = stack$iv;
                    if ((MutableVector)i2 != null) {
                    }
                    (MutableVector)i2.add(i13);
                    mutableVector2 = stack$iv;
                    if ((MutableVector)(MutableVector)mutableVector2 != null) {
                    }
                    node$iv2 = i2;
                    (MutableVector)(MutableVector)mutableVector2.add((Modifier.Node)delegatableNode);
                    i10 = i16;
                    $i$f$mutableVectorOf = 16;
                    i3 = 0;
                    $this$visitSubtree$iv2 = delegatableNode;
                    i8 = i2;
                    i = $i$f$mutableVectorOf;
                    $this$visitSubtree$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i2 = $this$visitSubtree$iv;
                    node$iv2 = i13;
                    $this$visitSubtree$iv2 = delegatableNode;
                    i8 = i2;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv = 1;
                }
                if (this_$iv$iv2 == 1) {
                } else {
                }
                i13 = i11;
                mask$iv = mask$iv2;
                delegatableNode = $this$visitSubtree$iv2;
                i2 = i8;
                i13 = node$iv$iv;
                i4 = 0;
                i10 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0) {
                } else {
                }
                mask$iv2 = mask$iv;
                $this$visitSubtree$iv2 = delegatableNode;
                i8 = i2;
                capacity$iv$iv$iv = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                mask$iv = mask$iv2;
                delegatableNode = $this$visitSubtree$iv2;
                i2 = i8;
                mask$iv2 = mask$iv;
                if (this_$iv$iv2++ == 1) {
                } else {
                }
                i15 = stack$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i15 == 0) {
                } else {
                }
                $this$visitSubtree$iv2 = delegatableNode;
                i8 = i2;
                $this$visitSubtree$iv = i15;
                capacity$iv$iv$iv = 0;
                stack$iv = $this$visitSubtree$iv;
                delegatableNode = node$iv2;
                mutableVector2 = stack$iv;
                if ((Modifier.Node)delegatableNode != null && (MutableVector)mutableVector2 != null) {
                }
                i2 = stack$iv;
                if ((MutableVector)i2 != null) {
                }
                (MutableVector)i2.add(i13);
                mutableVector2 = stack$iv;
                if ((MutableVector)(MutableVector)mutableVector2 != null) {
                }
                node$iv2 = i2;
                (MutableVector)(MutableVector)mutableVector2.add((Modifier.Node)delegatableNode);
                i10 = i16;
                $i$f$mutableVectorOf = 16;
                i3 = 0;
                $this$visitSubtree$iv2 = delegatableNode;
                i8 = i2;
                i = $i$f$mutableVectorOf;
                $this$visitSubtree$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i2 = $this$visitSubtree$iv;
                node$iv2 = i13;
                $this$visitSubtree$iv2 = delegatableNode;
                i8 = i2;
                capacity$iv$iv$iv = 0;
                this_$iv$iv = 1;
                this_$iv$iv2 = 1;
                block.invoke(node$iv2);
                i11 = i13;
                mask$iv2 = mask$iv;
                $this$visitSubtree$iv2 = delegatableNode;
                i8 = i2;
            }
            obj = block;
            i11 = i13;
            mask$iv2 = mask$iv;
            $this$visitSubtree$iv2 = delegatableNode;
            i8 = i2;
            Intrinsics.reifiedOperationMarker(3, "T");
            if (node$iv2 instanceof Object != null) {
            } else {
            }
            obj = block;
            node = 0;
            if (kindSet$ui_release2 &= type != 0) {
            } else {
            }
            this_$iv$iv2 = 0;
            if (this_$iv$iv2 != 0 && node$iv2 instanceof DelegatingNode) {
            } else {
            }
            mask$iv2 = mask$iv;
            $this$visitSubtree$iv2 = delegatableNode;
            i8 = i2;
            node$iv2 = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
            i13 = i11;
            mask$iv = mask$iv2;
            delegatableNode = $this$visitSubtree$iv2;
            i2 = i8;
            if (node$iv2 instanceof DelegatingNode) {
            } else {
            }
            this_$iv$iv2 = 0;
            i12 = 0;
            node$iv$iv = (DelegatingNode)node$iv2.getDelegate$ui_release();
            while (node$iv$iv != null) {
                i13 = node$iv$iv;
                i4 = 0;
                i10 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0) {
                } else {
                }
                mask$iv2 = mask$iv;
                $this$visitSubtree$iv2 = delegatableNode;
                i8 = i2;
                capacity$iv$iv$iv = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                mask$iv = mask$iv2;
                delegatableNode = $this$visitSubtree$iv2;
                i2 = i8;
                mask$iv2 = mask$iv;
                if (this_$iv$iv2++ == 1) {
                } else {
                }
                i15 = stack$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i15 == 0) {
                } else {
                }
                $this$visitSubtree$iv2 = delegatableNode;
                i8 = i2;
                $this$visitSubtree$iv = i15;
                capacity$iv$iv$iv = 0;
                stack$iv = $this$visitSubtree$iv;
                delegatableNode = node$iv2;
                mutableVector2 = stack$iv;
                if ((Modifier.Node)delegatableNode != null && (MutableVector)mutableVector2 != null) {
                }
                i2 = stack$iv;
                if ((MutableVector)i2 != null) {
                }
                (MutableVector)i2.add(i13);
                mutableVector2 = stack$iv;
                if ((MutableVector)(MutableVector)mutableVector2 != null) {
                }
                node$iv2 = i2;
                (MutableVector)(MutableVector)mutableVector2.add((Modifier.Node)delegatableNode);
                i10 = i16;
                $i$f$mutableVectorOf = 16;
                i3 = 0;
                $this$visitSubtree$iv2 = delegatableNode;
                i8 = i2;
                i = $i$f$mutableVectorOf;
                $this$visitSubtree$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i2 = $this$visitSubtree$iv;
                node$iv2 = i13;
                $this$visitSubtree$iv2 = delegatableNode;
                i8 = i2;
                capacity$iv$iv$iv = 0;
                this_$iv$iv = 1;
            }
            if (this_$iv$iv2 == 1) {
            } else {
            }
            i13 = i11;
            mask$iv = mask$iv2;
            delegatableNode = $this$visitSubtree$iv2;
            i2 = i8;
            i13 = node$iv$iv;
            i4 = 0;
            i10 = 0;
            if (kindSet$ui_release3 &= type != 0) {
            } else {
            }
            this_$iv$iv = 0;
            if (this_$iv$iv != 0) {
            } else {
            }
            mask$iv2 = mask$iv;
            $this$visitSubtree$iv2 = delegatableNode;
            i8 = i2;
            capacity$iv$iv$iv = 0;
            node$iv$iv = node$iv$iv.getChild$ui_release();
            mask$iv = mask$iv2;
            delegatableNode = $this$visitSubtree$iv2;
            i2 = i8;
            mask$iv2 = mask$iv;
            if (this_$iv$iv2++ == 1) {
            } else {
            }
            i15 = stack$iv;
            if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i15 == 0) {
            } else {
            }
            $this$visitSubtree$iv2 = delegatableNode;
            i8 = i2;
            $this$visitSubtree$iv = i15;
            capacity$iv$iv$iv = 0;
            stack$iv = $this$visitSubtree$iv;
            delegatableNode = node$iv2;
            mutableVector2 = stack$iv;
            if ((Modifier.Node)delegatableNode != null && (MutableVector)mutableVector2 != null) {
            }
            i2 = stack$iv;
            if ((MutableVector)i2 != null) {
            }
            (MutableVector)i2.add(i13);
            mutableVector2 = stack$iv;
            if ((MutableVector)(MutableVector)mutableVector2 != null) {
            }
            node$iv2 = i2;
            (MutableVector)(MutableVector)mutableVector2.add((Modifier.Node)delegatableNode);
            i10 = i16;
            $i$f$mutableVectorOf = 16;
            i3 = 0;
            $this$visitSubtree$iv2 = delegatableNode;
            i8 = i2;
            i = $i$f$mutableVectorOf;
            $this$visitSubtree$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
            i2 = $this$visitSubtree$iv;
            node$iv2 = i13;
            $this$visitSubtree$iv2 = delegatableNode;
            i8 = i2;
            capacity$iv$iv$iv = 0;
            this_$iv$iv = 1;
            this_$iv$iv2 = 1;
            block.invoke(node$iv2);
            i11 = i13;
            mask$iv2 = mask$iv;
            $this$visitSubtree$iv2 = delegatableNode;
            i8 = i2;
            node$iv = layout$iv.getNodes$ui_release().getHead$ui_release();
        }
    }

    public static final void visitSubtreeIf(androidx.compose.ui.node.DelegatableNode $this$visitSubtreeIf, int mask, Function1<? super Modifier.Node, Boolean> block) {
        Modifier.Node node2;
        String $i$a$CheckPreconditionDelegatableNodeKt$visitSubtreeIf$1;
        int node;
        Modifier.Node[] booleanValue;
        final int i = 0;
        int i2 = 0;
        if (!$this$visitSubtreeIf.getNode().isAttached()) {
            int i4 = 0;
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        int value$iv = 0;
        node = 0;
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = $this$visitSubtreeIf.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, $this$visitSubtreeIf.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            node2 = mutableVector.removeAt(size--);
            if (aggregateChildKindSet$ui_release &= mask != 0) {
            } else {
            }
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node2);
            node = node2;
            while (node != null) {
                node = node.getChild$ui_release();
                if ((Boolean)block.invoke(node).booleanValue() != null) {
                    break loop_8;
                }
            }
            if (kindSet$ui_release &= mask != 0) {
            } else {
            }
            node = node.getChild$ui_release();
            if ((Boolean)block.invoke(node).booleanValue() != null) {
            }
        }
    }

    public static final <T> void visitSubtreeIf-6rFNWt0(androidx.compose.ui.node.DelegatableNode $this$visitSubtreeIf_u2d6rFNWt0, int type, Function1<? super T, Boolean> block) {
        int i7;
        int $i$f$visitSubtreeIf6rFNWt03;
        int i3;
        Object $i$f$visitSubtreeIf6rFNWt02;
        Object obj;
        int mask$iv;
        int mask$iv4;
        int mask$iv3;
        int capacity$iv$iv$iv;
        Modifier.Node[] objArr;
        int $this$visitSubtreeIf$iv2;
        int i;
        Modifier.Node node;
        String $i$a$CheckPreconditionDelegatableNodeKt$visitSubtreeIf$1$iv;
        int this_$iv$iv;
        String str;
        Modifier.Node[] node$iv2;
        int i9;
        Modifier.Node[] objArr2;
        int i6;
        Modifier.Node[] objArr3;
        int i2;
        int stack$iv;
        Modifier.Node[] node$iv;
        int i8;
        int $i$f$visitSubtreeIf6rFNWt0;
        boolean booleanValue;
        Modifier.Node node$iv$iv;
        int i4;
        Object mask$iv2;
        int this_$iv$iv2;
        int i12;
        int i5;
        Modifier.Node[] $this$visitSubtreeIf$iv;
        int i10;
        int i11;
        i7 = 0;
        obj = type;
        objArr = $this$visitSubtreeIf_u2d6rFNWt0;
        i = 0;
        int i16 = 0;
        if (!objArr.getNode().isAttached()) {
            int i18 = 0;
            $i$a$CheckPreconditionDelegatableNodeKt$visitSubtreeIf$1$iv = "visitSubtreeIf called on an unattached node";
            str = $i$a$CheckPreconditionDelegatableNodeKt$visitSubtreeIf$1$iv;
            InlineClassHelperKt.throwIllegalStateException($i$a$CheckPreconditionDelegatableNodeKt$visitSubtreeIf$1$iv);
        }
        int value$iv$iv = 0;
        this_$iv$iv = 0;
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = objArr.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, objArr.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            node = mutableVector.removeAt(size -= this_$iv$iv);
            if (aggregateChildKindSet$ui_release &= obj != 0) {
            } else {
            }
            $i$f$visitSubtreeIf6rFNWt0 = i7;
            mask$iv2 = obj;
            $this$visitSubtreeIf$iv = objArr;
            i10 = i;
            mask$iv = i9;
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node);
            i9 = mask$iv;
            i7 = $i$f$visitSubtreeIf6rFNWt0;
            obj = mask$iv2;
            objArr = $this$visitSubtreeIf$iv;
            i = i10;
            node$iv2 = node;
            while (node$iv2 != null) {
                if (kindSet$ui_release &= obj == 0) {
                    break loop_8;
                } else {
                }
                $i$f$visitSubtreeIf6rFNWt0 = i7;
                mask$iv2 = obj;
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                $i$f$visitSubtreeIf6rFNWt03 = this_$iv$iv;
                mask$iv4 = i9;
                node$iv2 = node$iv2.getChild$ui_release();
                this_$iv$iv = $i$f$visitSubtreeIf6rFNWt03;
                i9 = mask$iv4;
                i7 = $i$f$visitSubtreeIf6rFNWt0;
                obj = mask$iv2;
                objArr = $this$visitSubtreeIf$iv;
                i = i10;
                i6 = 0;
                i2 = 0;
                stack$iv = 0;
                int i20 = 0;
                node$iv = objArr3;
                while (node$iv != null) {
                    Intrinsics.reifiedOperationMarker(3, "T");
                    $i$f$visitSubtreeIf6rFNWt02 = block;
                    i9 = 0;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0 && node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv2 = obj;
                    $this$visitSubtreeIf$iv = objArr;
                    i10 = i;
                    i3 = 1;
                    mask$iv3 = 0;
                    node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                    this_$iv$iv = i3;
                    i9 = mask$iv3;
                    i7 = $i$f$visitSubtreeIf6rFNWt0;
                    obj = mask$iv2;
                    objArr = $this$visitSubtreeIf$iv;
                    i = i10;
                    if (node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    booleanValue = 0;
                    node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        Modifier.Node node2 = node$iv$iv;
                        i4 = 0;
                        i12 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv2 = 0;
                        if (this_$iv$iv2 != 0) {
                        } else {
                        }
                        mask$iv2 = obj;
                        $this$visitSubtreeIf$iv = objArr;
                        i10 = i;
                        capacity$iv$iv$iv = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        $i$f$visitSubtreeIf6rFNWt02 = block;
                        obj = mask$iv2;
                        objArr = $this$visitSubtreeIf$iv;
                        i = i10;
                        mask$iv2 = obj;
                        if (this_$iv$iv++ == 1) {
                        } else {
                        }
                        int i13 = stack$iv;
                        if ((MutableVector)i13 == 0) {
                        } else {
                        }
                        $this$visitSubtreeIf$iv = objArr;
                        i10 = i;
                        $this$visitSubtreeIf$iv2 = i13;
                        capacity$iv$iv$iv = 0;
                        stack$iv = $this$visitSubtreeIf$iv2;
                        objArr = node$iv;
                        int i15 = stack$iv;
                        if ((Modifier.Node)objArr != null && (MutableVector)i15 != 0) {
                        }
                        i = stack$iv;
                        if ((MutableVector)i != 0) {
                        }
                        (MutableVector)i.add(node2);
                        i15 = stack$iv;
                        if ((MutableVector)(MutableVector)i15 != 0) {
                        }
                        node$iv = i;
                        (MutableVector)(MutableVector)i15.add((Modifier.Node)objArr);
                        i12 = i14;
                        int $i$f$mutableVectorOf = 16;
                        i5 = 0;
                        $this$visitSubtreeIf$iv = objArr;
                        i10 = i;
                        i11 = $i$f$mutableVectorOf;
                        $this$visitSubtreeIf$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        i = $this$visitSubtreeIf$iv2;
                        node$iv = node2;
                        $this$visitSubtreeIf$iv = objArr;
                        i10 = i;
                        capacity$iv$iv$iv = 0;
                        this_$iv$iv2 = 1;
                    }
                    i3 = 1;
                    if (this_$iv$iv == i3) {
                    } else {
                    }
                    this_$iv$iv = i3;
                    i9 = mask$iv3;
                    i7 = $i$f$visitSubtreeIf6rFNWt0;
                    obj = mask$iv2;
                    objArr = $this$visitSubtreeIf$iv;
                    i = i10;
                    node2 = node$iv$iv;
                    i4 = 0;
                    i12 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    if (this_$iv$iv2 != 0) {
                    } else {
                    }
                    mask$iv2 = obj;
                    $this$visitSubtreeIf$iv = objArr;
                    i10 = i;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    $i$f$visitSubtreeIf6rFNWt02 = block;
                    obj = mask$iv2;
                    objArr = $this$visitSubtreeIf$iv;
                    i = i10;
                    mask$iv2 = obj;
                    if (this_$iv$iv++ == 1) {
                    } else {
                    }
                    i13 = stack$iv;
                    if ((MutableVector)(MutableVector)i13 == 0) {
                    } else {
                    }
                    $this$visitSubtreeIf$iv = objArr;
                    i10 = i;
                    $this$visitSubtreeIf$iv2 = i13;
                    capacity$iv$iv$iv = 0;
                    stack$iv = $this$visitSubtreeIf$iv2;
                    objArr = node$iv;
                    i15 = stack$iv;
                    if ((Modifier.Node)objArr != null && (MutableVector)i15 != 0) {
                    }
                    i = stack$iv;
                    if ((MutableVector)i != 0) {
                    }
                    (MutableVector)i.add(node2);
                    i15 = stack$iv;
                    if ((MutableVector)(MutableVector)i15 != 0) {
                    }
                    node$iv = i;
                    (MutableVector)(MutableVector)i15.add((Modifier.Node)objArr);
                    i12 = i14;
                    $i$f$mutableVectorOf = 16;
                    i5 = 0;
                    $this$visitSubtreeIf$iv = objArr;
                    i10 = i;
                    i11 = $i$f$mutableVectorOf;
                    $this$visitSubtreeIf$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i = $this$visitSubtreeIf$iv2;
                    node$iv = node2;
                    $this$visitSubtreeIf$iv = objArr;
                    i10 = i;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv2 = 1;
                    this_$iv$iv = 1;
                    i9 = 0;
                    $i$f$visitSubtreeIf6rFNWt0 = i7;
                    mask$iv2 = obj;
                    $this$visitSubtreeIf$iv = objArr;
                    i10 = i;
                    i3 = 1;
                    mask$iv3 = 0;
                }
                $i$f$visitSubtreeIf6rFNWt0 = i7;
                mask$iv2 = obj;
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                mask$iv4 = i9;
                i8 = $i$f$visitSubtreeIf6rFNWt03;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (node$iv instanceof Object != null) {
                } else {
                }
                $i$f$visitSubtreeIf6rFNWt02 = block;
                i9 = 0;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0 && node$iv instanceof DelegatingNode) {
                } else {
                }
                mask$iv2 = obj;
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                i3 = 1;
                mask$iv3 = 0;
                node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                this_$iv$iv = i3;
                i9 = mask$iv3;
                i7 = $i$f$visitSubtreeIf6rFNWt0;
                obj = mask$iv2;
                objArr = $this$visitSubtreeIf$iv;
                i = i10;
                if (node$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv = 0;
                booleanValue = 0;
                node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                while (node$iv$iv != null) {
                    node2 = node$iv$iv;
                    i4 = 0;
                    i12 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    if (this_$iv$iv2 != 0) {
                    } else {
                    }
                    mask$iv2 = obj;
                    $this$visitSubtreeIf$iv = objArr;
                    i10 = i;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    $i$f$visitSubtreeIf6rFNWt02 = block;
                    obj = mask$iv2;
                    objArr = $this$visitSubtreeIf$iv;
                    i = i10;
                    mask$iv2 = obj;
                    if (this_$iv$iv++ == 1) {
                    } else {
                    }
                    i13 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                    } else {
                    }
                    $this$visitSubtreeIf$iv = objArr;
                    i10 = i;
                    $this$visitSubtreeIf$iv2 = i13;
                    capacity$iv$iv$iv = 0;
                    stack$iv = $this$visitSubtreeIf$iv2;
                    objArr = node$iv;
                    i15 = stack$iv;
                    if ((Modifier.Node)objArr != null && (MutableVector)i15 != 0) {
                    }
                    i = stack$iv;
                    if ((MutableVector)i != 0) {
                    }
                    (MutableVector)i.add(node2);
                    i15 = stack$iv;
                    if ((MutableVector)(MutableVector)i15 != 0) {
                    }
                    node$iv = i;
                    (MutableVector)(MutableVector)i15.add((Modifier.Node)objArr);
                    i12 = i14;
                    $i$f$mutableVectorOf = 16;
                    i5 = 0;
                    $this$visitSubtreeIf$iv = objArr;
                    i10 = i;
                    i11 = $i$f$mutableVectorOf;
                    $this$visitSubtreeIf$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i = $this$visitSubtreeIf$iv2;
                    node$iv = node2;
                    $this$visitSubtreeIf$iv = objArr;
                    i10 = i;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv2 = 1;
                }
                i3 = 1;
                if (this_$iv$iv == i3) {
                } else {
                }
                this_$iv$iv = i3;
                i9 = mask$iv3;
                i7 = $i$f$visitSubtreeIf6rFNWt0;
                obj = mask$iv2;
                objArr = $this$visitSubtreeIf$iv;
                i = i10;
                node2 = node$iv$iv;
                i4 = 0;
                i12 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv2 = 0;
                if (this_$iv$iv2 != 0) {
                } else {
                }
                mask$iv2 = obj;
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                capacity$iv$iv$iv = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                $i$f$visitSubtreeIf6rFNWt02 = block;
                obj = mask$iv2;
                objArr = $this$visitSubtreeIf$iv;
                i = i10;
                mask$iv2 = obj;
                if (this_$iv$iv++ == 1) {
                } else {
                }
                i13 = stack$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                } else {
                }
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                $this$visitSubtreeIf$iv2 = i13;
                capacity$iv$iv$iv = 0;
                stack$iv = $this$visitSubtreeIf$iv2;
                objArr = node$iv;
                i15 = stack$iv;
                if ((Modifier.Node)objArr != null && (MutableVector)i15 != 0) {
                }
                i = stack$iv;
                if ((MutableVector)i != 0) {
                }
                (MutableVector)i.add(node2);
                i15 = stack$iv;
                if ((MutableVector)(MutableVector)i15 != 0) {
                }
                node$iv = i;
                (MutableVector)(MutableVector)i15.add((Modifier.Node)objArr);
                i12 = i14;
                $i$f$mutableVectorOf = 16;
                i5 = 0;
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                i11 = $i$f$mutableVectorOf;
                $this$visitSubtreeIf$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i = $this$visitSubtreeIf$iv2;
                node$iv = node2;
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                capacity$iv$iv$iv = 0;
                this_$iv$iv2 = 1;
                this_$iv$iv = 1;
                i9 = 0;
                $i$f$visitSubtreeIf6rFNWt0 = i7;
                if (!(Boolean)block.invoke(node$iv).booleanValue()) {
                } else {
                }
                mask$iv2 = obj;
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                i3 = 1;
                mask$iv3 = 0;
                mask$iv2 = obj;
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                $i$f$visitSubtreeIf6rFNWt03 = 1;
                mask$iv4 = 0;
                i8 = 0;
            }
            $i$f$visitSubtreeIf6rFNWt0 = i7;
            mask$iv2 = obj;
            $this$visitSubtreeIf$iv = objArr;
            i10 = i;
            mask$iv = i9;
            if (kindSet$ui_release &= obj != 0) {
            } else {
            }
            $i$f$visitSubtreeIf6rFNWt0 = i7;
            mask$iv2 = obj;
            $this$visitSubtreeIf$iv = objArr;
            i10 = i;
            $i$f$visitSubtreeIf6rFNWt03 = this_$iv$iv;
            mask$iv4 = i9;
            node$iv2 = node$iv2.getChild$ui_release();
            this_$iv$iv = $i$f$visitSubtreeIf6rFNWt03;
            i9 = mask$iv4;
            i7 = $i$f$visitSubtreeIf6rFNWt0;
            obj = mask$iv2;
            objArr = $this$visitSubtreeIf$iv;
            i = i10;
            i6 = 0;
            i2 = 0;
            stack$iv = 0;
            i20 = 0;
            node$iv = objArr3;
            while (node$iv != null) {
                Intrinsics.reifiedOperationMarker(3, "T");
                $i$f$visitSubtreeIf6rFNWt02 = block;
                i9 = 0;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0 && node$iv instanceof DelegatingNode) {
                } else {
                }
                mask$iv2 = obj;
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                i3 = 1;
                mask$iv3 = 0;
                node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                this_$iv$iv = i3;
                i9 = mask$iv3;
                i7 = $i$f$visitSubtreeIf6rFNWt0;
                obj = mask$iv2;
                objArr = $this$visitSubtreeIf$iv;
                i = i10;
                if (node$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv = 0;
                booleanValue = 0;
                node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                while (node$iv$iv != null) {
                    node2 = node$iv$iv;
                    i4 = 0;
                    i12 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    if (this_$iv$iv2 != 0) {
                    } else {
                    }
                    mask$iv2 = obj;
                    $this$visitSubtreeIf$iv = objArr;
                    i10 = i;
                    capacity$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    $i$f$visitSubtreeIf6rFNWt02 = block;
                    obj = mask$iv2;
                    objArr = $this$visitSubtreeIf$iv;
                    i = i10;
                    mask$iv2 = obj;
                    if (this_$iv$iv++ == 1) {
                    } else {
                    }
                    i13 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                    } else {
                    }
                    $this$visitSubtreeIf$iv = objArr;
                    i10 = i;
                    $this$visitSubtreeIf$iv2 = i13;
                    capacity$iv$iv$iv = 0;
                    stack$iv = $this$visitSubtreeIf$iv2;
                    objArr = node$iv;
                    i15 = stack$iv;
                    if ((Modifier.Node)objArr != null && (MutableVector)i15 != 0) {
                    }
                    i = stack$iv;
                    if ((MutableVector)i != 0) {
                    }
                    (MutableVector)i.add(node2);
                    i15 = stack$iv;
                    if ((MutableVector)(MutableVector)i15 != 0) {
                    }
                    node$iv = i;
                    (MutableVector)(MutableVector)i15.add((Modifier.Node)objArr);
                    i12 = i14;
                    $i$f$mutableVectorOf = 16;
                    i5 = 0;
                    $this$visitSubtreeIf$iv = objArr;
                    i10 = i;
                    i11 = $i$f$mutableVectorOf;
                    $this$visitSubtreeIf$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i = $this$visitSubtreeIf$iv2;
                    node$iv = node2;
                    $this$visitSubtreeIf$iv = objArr;
                    i10 = i;
                    capacity$iv$iv$iv = 0;
                    this_$iv$iv2 = 1;
                }
                i3 = 1;
                if (this_$iv$iv == i3) {
                } else {
                }
                this_$iv$iv = i3;
                i9 = mask$iv3;
                i7 = $i$f$visitSubtreeIf6rFNWt0;
                obj = mask$iv2;
                objArr = $this$visitSubtreeIf$iv;
                i = i10;
                node2 = node$iv$iv;
                i4 = 0;
                i12 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv2 = 0;
                if (this_$iv$iv2 != 0) {
                } else {
                }
                mask$iv2 = obj;
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                capacity$iv$iv$iv = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                $i$f$visitSubtreeIf6rFNWt02 = block;
                obj = mask$iv2;
                objArr = $this$visitSubtreeIf$iv;
                i = i10;
                mask$iv2 = obj;
                if (this_$iv$iv++ == 1) {
                } else {
                }
                i13 = stack$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                } else {
                }
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                $this$visitSubtreeIf$iv2 = i13;
                capacity$iv$iv$iv = 0;
                stack$iv = $this$visitSubtreeIf$iv2;
                objArr = node$iv;
                i15 = stack$iv;
                if ((Modifier.Node)objArr != null && (MutableVector)i15 != 0) {
                }
                i = stack$iv;
                if ((MutableVector)i != 0) {
                }
                (MutableVector)i.add(node2);
                i15 = stack$iv;
                if ((MutableVector)(MutableVector)i15 != 0) {
                }
                node$iv = i;
                (MutableVector)(MutableVector)i15.add((Modifier.Node)objArr);
                i12 = i14;
                $i$f$mutableVectorOf = 16;
                i5 = 0;
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                i11 = $i$f$mutableVectorOf;
                $this$visitSubtreeIf$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i = $this$visitSubtreeIf$iv2;
                node$iv = node2;
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                capacity$iv$iv$iv = 0;
                this_$iv$iv2 = 1;
                this_$iv$iv = 1;
                i9 = 0;
                $i$f$visitSubtreeIf6rFNWt0 = i7;
                mask$iv2 = obj;
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                i3 = 1;
                mask$iv3 = 0;
            }
            $i$f$visitSubtreeIf6rFNWt0 = i7;
            mask$iv2 = obj;
            $this$visitSubtreeIf$iv = objArr;
            i10 = i;
            mask$iv4 = i9;
            i8 = $i$f$visitSubtreeIf6rFNWt03;
            if (i8 != 0) {
            } else {
            }
            i9 = mask$iv4;
            i7 = $i$f$visitSubtreeIf6rFNWt0;
            obj = mask$iv2;
            objArr = $this$visitSubtreeIf$iv;
            i = i10;
            Intrinsics.reifiedOperationMarker(3, "T");
            if (node$iv instanceof Object != null) {
            } else {
            }
            $i$f$visitSubtreeIf6rFNWt02 = block;
            i9 = 0;
            if (kindSet$ui_release2 &= type != 0) {
            } else {
            }
            this_$iv$iv = 0;
            if (this_$iv$iv != 0 && node$iv instanceof DelegatingNode) {
            } else {
            }
            mask$iv2 = obj;
            $this$visitSubtreeIf$iv = objArr;
            i10 = i;
            i3 = 1;
            mask$iv3 = 0;
            node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
            this_$iv$iv = i3;
            i9 = mask$iv3;
            i7 = $i$f$visitSubtreeIf6rFNWt0;
            obj = mask$iv2;
            objArr = $this$visitSubtreeIf$iv;
            i = i10;
            if (node$iv instanceof DelegatingNode) {
            } else {
            }
            this_$iv$iv = 0;
            booleanValue = 0;
            node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
            while (node$iv$iv != null) {
                node2 = node$iv$iv;
                i4 = 0;
                i12 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv2 = 0;
                if (this_$iv$iv2 != 0) {
                } else {
                }
                mask$iv2 = obj;
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                capacity$iv$iv$iv = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                $i$f$visitSubtreeIf6rFNWt02 = block;
                obj = mask$iv2;
                objArr = $this$visitSubtreeIf$iv;
                i = i10;
                mask$iv2 = obj;
                if (this_$iv$iv++ == 1) {
                } else {
                }
                i13 = stack$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i13 == 0) {
                } else {
                }
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                $this$visitSubtreeIf$iv2 = i13;
                capacity$iv$iv$iv = 0;
                stack$iv = $this$visitSubtreeIf$iv2;
                objArr = node$iv;
                i15 = stack$iv;
                if ((Modifier.Node)objArr != null && (MutableVector)i15 != 0) {
                }
                i = stack$iv;
                if ((MutableVector)i != 0) {
                }
                (MutableVector)i.add(node2);
                i15 = stack$iv;
                if ((MutableVector)(MutableVector)i15 != 0) {
                }
                node$iv = i;
                (MutableVector)(MutableVector)i15.add((Modifier.Node)objArr);
                i12 = i14;
                $i$f$mutableVectorOf = 16;
                i5 = 0;
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                i11 = $i$f$mutableVectorOf;
                $this$visitSubtreeIf$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i = $this$visitSubtreeIf$iv2;
                node$iv = node2;
                $this$visitSubtreeIf$iv = objArr;
                i10 = i;
                capacity$iv$iv$iv = 0;
                this_$iv$iv2 = 1;
            }
            i3 = 1;
            if (this_$iv$iv == i3) {
            } else {
            }
            this_$iv$iv = i3;
            i9 = mask$iv3;
            i7 = $i$f$visitSubtreeIf6rFNWt0;
            obj = mask$iv2;
            objArr = $this$visitSubtreeIf$iv;
            i = i10;
            node2 = node$iv$iv;
            i4 = 0;
            i12 = 0;
            if (kindSet$ui_release3 &= type != 0) {
            } else {
            }
            this_$iv$iv2 = 0;
            if (this_$iv$iv2 != 0) {
            } else {
            }
            mask$iv2 = obj;
            $this$visitSubtreeIf$iv = objArr;
            i10 = i;
            capacity$iv$iv$iv = 0;
            node$iv$iv = node$iv$iv.getChild$ui_release();
            $i$f$visitSubtreeIf6rFNWt02 = block;
            obj = mask$iv2;
            objArr = $this$visitSubtreeIf$iv;
            i = i10;
            mask$iv2 = obj;
            if (this_$iv$iv++ == 1) {
            } else {
            }
            i13 = stack$iv;
            if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)(MutableVector)i13 == 0) {
            } else {
            }
            $this$visitSubtreeIf$iv = objArr;
            i10 = i;
            $this$visitSubtreeIf$iv2 = i13;
            capacity$iv$iv$iv = 0;
            stack$iv = $this$visitSubtreeIf$iv2;
            objArr = node$iv;
            i15 = stack$iv;
            if ((Modifier.Node)objArr != null && (MutableVector)i15 != 0) {
            }
            i = stack$iv;
            if ((MutableVector)i != 0) {
            }
            (MutableVector)i.add(node2);
            i15 = stack$iv;
            if ((MutableVector)(MutableVector)i15 != 0) {
            }
            node$iv = i;
            (MutableVector)(MutableVector)i15.add((Modifier.Node)objArr);
            i12 = i14;
            $i$f$mutableVectorOf = 16;
            i5 = 0;
            $this$visitSubtreeIf$iv = objArr;
            i10 = i;
            i11 = $i$f$mutableVectorOf;
            $this$visitSubtreeIf$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
            i = $this$visitSubtreeIf$iv2;
            node$iv = node2;
            $this$visitSubtreeIf$iv = objArr;
            i10 = i;
            capacity$iv$iv$iv = 0;
            this_$iv$iv2 = 1;
            this_$iv$iv = 1;
            i9 = 0;
            $i$f$visitSubtreeIf6rFNWt0 = i7;
            if (!(Boolean)block.invoke(node$iv).booleanValue()) {
            } else {
            }
            mask$iv2 = obj;
            $this$visitSubtreeIf$iv = objArr;
            i10 = i;
            i3 = 1;
            mask$iv3 = 0;
            mask$iv2 = obj;
            $this$visitSubtreeIf$iv = objArr;
            i10 = i;
            $i$f$visitSubtreeIf6rFNWt03 = 1;
            mask$iv4 = 0;
            i8 = 0;
        }
    }
}
