package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.SemanticsModifierNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000c\u001a\u00020\rH\u0000\u001a\"\u0010\n\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0002H\u0000\u001a\u000c\u0010\u000f\u001a\u00020\u0010*\u00020\u0007H\u0002\u001a\"\u0010\u0011\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0013H\u0000\u001a\u000c\u0010\u0014\u001a\u00020\u0010*\u00020\u0007H\u0002\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u0015", d2 = {"outerMergingSemantics", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/LayoutNode;", "getOuterMergingSemantics", "(Landroidx/compose/ui/node/LayoutNode;)Landroidx/compose/ui/node/SemanticsModifierNode;", "role", "Landroidx/compose/ui/semantics/Role;", "Landroidx/compose/ui/semantics/SemanticsNode;", "getRole", "(Landroidx/compose/ui/semantics/SemanticsNode;)Landroidx/compose/ui/semantics/Role;", "SemanticsNode", "layoutNode", "mergingEnabled", "", "outerSemanticsNode", "contentDescriptionFakeNodeId", "", "findClosestParentNode", "selector", "Lkotlin/Function1;", "roleFakeNodeId", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SemanticsNodeKt {
    public static final androidx.compose.ui.semantics.SemanticsNode SemanticsNode(LayoutNode layoutNode, boolean mergingEnabled) {
        Object this_$iv;
        Modifier.Node node$iv$iv$iv;
        int capacity$iv$iv$iv$iv$iv;
        int i3;
        int $i$f$getSemanticsOLwlOKw;
        int it$iv;
        MutableVector count$iv$iv$iv;
        int stack$iv$iv$iv2;
        int $i$f$headH91voCI$ui_release2;
        NodeChain i7;
        int i8;
        Modifier.Node node$iv$iv$iv$iv2;
        Modifier.Node node3;
        int i5;
        Modifier.Node node5;
        int i6;
        Modifier.Node node2;
        int i;
        int node$iv$iv$iv2;
        Modifier.Node stack$iv$iv$iv;
        NodeChain this_$iv2;
        int type$iv;
        int $i$f$isKindH91voCI$ui_release;
        Modifier.Node node;
        int i11;
        Modifier.Node node$iv$iv$iv$iv;
        Modifier.Node node4;
        int i4;
        Modifier.Node node7;
        int this_$iv$iv$iv$iv;
        int i9;
        int i10;
        int count$iv$iv$iv2;
        int $i$f$headH91voCI$ui_release;
        int i2;
        Modifier.Node node6;
        this_$iv = layoutNode.getNodes$ui_release();
        int i13 = 0;
        $i$f$getSemanticsOLwlOKw = NodeKind.constructor-impl(8);
        int i15 = 0;
        final int i16 = $i$f$getSemanticsOLwlOKw;
        final NodeChain nodeChain2 = nodeChain;
        final int i17 = 0;
        if (i18 &= i16 != 0) {
            i8 = 0;
            node$iv$iv$iv$iv2 = nodeChain2.getHead$ui_release();
            while (node$iv$iv$iv$iv2 != null) {
                node3 = node$iv$iv$iv$iv2;
                i5 = 0;
                if (kindSet$ui_release &= i16 == 0) {
                    break;
                } else {
                }
                this_$iv2 = this_$iv;
                type$iv = $i$f$getSemanticsOLwlOKw;
                $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                this_$iv = this_$iv2;
                $i$f$getSemanticsOLwlOKw = type$iv;
                stack$iv$iv$iv2 = $i$f$headH91voCI$ui_release;
                i6 = 0;
                i = 0;
                node$iv$iv$iv2 = 0;
                int i19 = 0;
                this_$iv2 = this_$iv;
                this_$iv = node6;
                while (this_$iv != null) {
                    type$iv = $i$f$getSemanticsOLwlOKw;
                    it$iv = this_$iv;
                    int i20 = 0;
                    i11 = it$iv;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    if ($i$f$isKindH91voCI$ui_release != 0 && this_$iv instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                    this_$iv = DelegatableNodeKt.access$pop(node$iv$iv$iv2);
                    $i$f$getSemanticsOLwlOKw = type$iv;
                    stack$iv$iv$iv2 = $i$f$headH91voCI$ui_release;
                    if (this_$iv instanceof DelegatingNode) {
                    } else {
                    }
                    it$iv = 0;
                    i11 = 0;
                    node$iv$iv$iv$iv = (DelegatingNode)this_$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv$iv != null) {
                        node4 = node$iv$iv$iv$iv;
                        i4 = 0;
                        i9 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv = 0;
                        if (this_$iv$iv$iv$iv != 0) {
                        } else {
                        }
                        $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                        node$iv$iv$iv = node4;
                        $i$f$headH91voCI$ui_release2 = node$iv$iv$iv2;
                        stack$iv$iv$iv = node7;
                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                        this_$iv = stack$iv$iv$iv;
                        node$iv$iv$iv2 = $i$f$headH91voCI$ui_release2;
                        stack$iv$iv$iv2 = $i$f$headH91voCI$ui_release;
                        it$iv++;
                        node7 = this_$iv;
                        if (it$iv == 1) {
                        } else {
                        }
                        if (node$iv$iv$iv2 == 0) {
                        } else {
                        }
                        count$iv$iv$iv2 = it$iv;
                        $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                        capacity$iv$iv$iv$iv$iv = 0;
                        count$iv$iv$iv = node$iv$iv$iv2;
                        Modifier.Node node9 = node7;
                        if (node9 != null) {
                        } else {
                        }
                        stack$iv$iv$iv = node7;
                        if (count$iv$iv$iv != null) {
                        } else {
                        }
                        node$iv$iv$iv = node4;
                        $i$f$headH91voCI$ui_release2 = count$iv$iv$iv;
                        it$iv = count$iv$iv$iv2;
                        count$iv$iv$iv.add(node4);
                        if (count$iv$iv$iv != null) {
                        }
                        stack$iv$iv$iv = 0;
                        count$iv$iv$iv.add(node9);
                        i9 = i12;
                        int $i$f$mutableVectorOf = 16;
                        i10 = 0;
                        count$iv$iv$iv2 = it$iv;
                        $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                        i2 = $i$f$mutableVectorOf;
                        count$iv$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                        $i$f$headH91voCI$ui_release2 = node$iv$iv$iv2;
                        stack$iv$iv$iv = node$iv$iv$iv;
                        this_$iv$iv$iv$iv = 1;
                    }
                    node7 = this_$iv;
                    if (it$iv == 1) {
                    } else {
                    }
                    this_$iv = node7;
                    $i$f$getSemanticsOLwlOKw = type$iv;
                    this_$iv = node7;
                    stack$iv$iv$iv2 = $i$f$headH91voCI$ui_release;
                    node4 = node$iv$iv$iv$iv;
                    i4 = 0;
                    i9 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                    node$iv$iv$iv = node4;
                    $i$f$headH91voCI$ui_release2 = node$iv$iv$iv2;
                    stack$iv$iv$iv = node7;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    this_$iv = stack$iv$iv$iv;
                    node$iv$iv$iv2 = $i$f$headH91voCI$ui_release2;
                    stack$iv$iv$iv2 = $i$f$headH91voCI$ui_release;
                    it$iv++;
                    node7 = this_$iv;
                    if (it$iv == 1) {
                    } else {
                    }
                    if (node$iv$iv$iv2 == 0) {
                    } else {
                    }
                    count$iv$iv$iv2 = it$iv;
                    $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                    capacity$iv$iv$iv$iv$iv = 0;
                    count$iv$iv$iv = node$iv$iv$iv2;
                    node9 = node7;
                    if (node9 != null) {
                    } else {
                    }
                    stack$iv$iv$iv = node7;
                    if (count$iv$iv$iv != null) {
                    } else {
                    }
                    node$iv$iv$iv = node4;
                    $i$f$headH91voCI$ui_release2 = count$iv$iv$iv;
                    it$iv = count$iv$iv$iv2;
                    count$iv$iv$iv.add(node4);
                    if (count$iv$iv$iv != null) {
                    }
                    stack$iv$iv$iv = 0;
                    count$iv$iv$iv.add(node9);
                    i9 = i12;
                    $i$f$mutableVectorOf = 16;
                    i10 = 0;
                    count$iv$iv$iv2 = it$iv;
                    $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                    i2 = $i$f$mutableVectorOf;
                    count$iv$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                    $i$f$headH91voCI$ui_release2 = node$iv$iv$iv2;
                    stack$iv$iv$iv = node$iv$iv$iv;
                    this_$iv$iv$iv$iv = 1;
                    $i$f$isKindH91voCI$ui_release = 1;
                }
                type$iv = $i$f$getSemanticsOLwlOKw;
                $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                type$iv = $i$f$getSemanticsOLwlOKw;
                it$iv = this_$iv;
                i20 = 0;
                i11 = it$iv;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                $i$f$isKindH91voCI$ui_release = 0;
                if ($i$f$isKindH91voCI$ui_release != 0 && this_$iv instanceof DelegatingNode) {
                } else {
                }
                $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                this_$iv = DelegatableNodeKt.access$pop(node$iv$iv$iv2);
                $i$f$getSemanticsOLwlOKw = type$iv;
                stack$iv$iv$iv2 = $i$f$headH91voCI$ui_release;
                if (this_$iv instanceof DelegatingNode) {
                } else {
                }
                it$iv = 0;
                i11 = 0;
                node$iv$iv$iv$iv = (DelegatingNode)this_$iv.getDelegate$ui_release();
                while (node$iv$iv$iv$iv != null) {
                    node4 = node$iv$iv$iv$iv;
                    i4 = 0;
                    i9 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                    node$iv$iv$iv = node4;
                    $i$f$headH91voCI$ui_release2 = node$iv$iv$iv2;
                    stack$iv$iv$iv = node7;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    this_$iv = stack$iv$iv$iv;
                    node$iv$iv$iv2 = $i$f$headH91voCI$ui_release2;
                    stack$iv$iv$iv2 = $i$f$headH91voCI$ui_release;
                    it$iv++;
                    node7 = this_$iv;
                    if (it$iv == 1) {
                    } else {
                    }
                    if (node$iv$iv$iv2 == 0) {
                    } else {
                    }
                    count$iv$iv$iv2 = it$iv;
                    $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                    capacity$iv$iv$iv$iv$iv = 0;
                    count$iv$iv$iv = node$iv$iv$iv2;
                    node9 = node7;
                    if (node9 != null) {
                    } else {
                    }
                    stack$iv$iv$iv = node7;
                    if (count$iv$iv$iv != null) {
                    } else {
                    }
                    node$iv$iv$iv = node4;
                    $i$f$headH91voCI$ui_release2 = count$iv$iv$iv;
                    it$iv = count$iv$iv$iv2;
                    count$iv$iv$iv.add(node4);
                    if (count$iv$iv$iv != null) {
                    }
                    stack$iv$iv$iv = 0;
                    count$iv$iv$iv.add(node9);
                    i9 = i12;
                    $i$f$mutableVectorOf = 16;
                    i10 = 0;
                    count$iv$iv$iv2 = it$iv;
                    $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                    i2 = $i$f$mutableVectorOf;
                    count$iv$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                    $i$f$headH91voCI$ui_release2 = node$iv$iv$iv2;
                    stack$iv$iv$iv = node$iv$iv$iv;
                    this_$iv$iv$iv$iv = 1;
                }
                node7 = this_$iv;
                if (it$iv == 1) {
                } else {
                }
                this_$iv = node7;
                $i$f$getSemanticsOLwlOKw = type$iv;
                this_$iv = node7;
                stack$iv$iv$iv2 = $i$f$headH91voCI$ui_release;
                node4 = node$iv$iv$iv$iv;
                i4 = 0;
                i9 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv$iv = 0;
                if (this_$iv$iv$iv$iv != 0) {
                } else {
                }
                $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                node$iv$iv$iv = node4;
                $i$f$headH91voCI$ui_release2 = node$iv$iv$iv2;
                stack$iv$iv$iv = node7;
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                this_$iv = stack$iv$iv$iv;
                node$iv$iv$iv2 = $i$f$headH91voCI$ui_release2;
                stack$iv$iv$iv2 = $i$f$headH91voCI$ui_release;
                it$iv++;
                node7 = this_$iv;
                if (it$iv == 1) {
                } else {
                }
                if (node$iv$iv$iv2 == 0) {
                } else {
                }
                count$iv$iv$iv2 = it$iv;
                $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                capacity$iv$iv$iv$iv$iv = 0;
                count$iv$iv$iv = node$iv$iv$iv2;
                node9 = node7;
                if (node9 != null) {
                } else {
                }
                stack$iv$iv$iv = node7;
                if (count$iv$iv$iv != null) {
                } else {
                }
                node$iv$iv$iv = node4;
                $i$f$headH91voCI$ui_release2 = count$iv$iv$iv;
                it$iv = count$iv$iv$iv2;
                count$iv$iv$iv.add(node4);
                if (count$iv$iv$iv != null) {
                }
                stack$iv$iv$iv = 0;
                count$iv$iv$iv.add(node9);
                i9 = i12;
                $i$f$mutableVectorOf = 16;
                i10 = 0;
                count$iv$iv$iv2 = it$iv;
                $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                i2 = $i$f$mutableVectorOf;
                count$iv$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
                $i$f$headH91voCI$ui_release2 = node$iv$iv$iv2;
                stack$iv$iv$iv = node$iv$iv$iv;
                this_$iv$iv$iv$iv = 1;
                $i$f$isKindH91voCI$ui_release = 1;
            }
            this_$iv2 = this_$iv;
            type$iv = $i$f$getSemanticsOLwlOKw;
            $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
            i3 = 0;
        } else {
            this_$iv2 = this_$iv;
            type$iv = $i$f$getSemanticsOLwlOKw;
            $i$f$headH91voCI$ui_release = stack$iv$iv$iv2;
        }
        Intrinsics.checkNotNull(i3);
        androidx.compose.ui.semantics.SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
        Intrinsics.checkNotNull(collapsedSemantics$ui_release);
        SemanticsNode semanticsNode = new SemanticsNode((SemanticsModifierNode)i3.getNode(), mergingEnabled, layoutNode, collapsedSemantics$ui_release);
        return semanticsNode;
    }

    public static final androidx.compose.ui.semantics.SemanticsNode SemanticsNode(SemanticsModifierNode outerSemanticsNode, boolean mergingEnabled, LayoutNode layoutNode) {
        androidx.compose.ui.semantics.SemanticsConfiguration collapsedSemantics$ui_release;
        if (layoutNode.getCollapsedSemantics$ui_release() == null) {
            collapsedSemantics$ui_release = new SemanticsConfiguration();
        }
        SemanticsNode semanticsNode = new SemanticsNode(outerSemanticsNode.getNode(), mergingEnabled, layoutNode, collapsedSemantics$ui_release);
        return semanticsNode;
    }

    public static androidx.compose.ui.semantics.SemanticsNode SemanticsNode$default(SemanticsModifierNode semanticsModifierNode, boolean z2, LayoutNode layoutNode3, int i4, Object object5) {
        LayoutNode obj2;
        if (i4 &= 4 != 0) {
            obj2 = DelegatableNodeKt.requireLayoutNode((DelegatableNode)semanticsModifierNode);
        }
        return SemanticsNodeKt.SemanticsNode(semanticsModifierNode, z2, obj2);
    }

    public static final int access$contentDescriptionFakeNodeId(androidx.compose.ui.semantics.SemanticsNode $receiver) {
        return SemanticsNodeKt.contentDescriptionFakeNodeId($receiver);
    }

    public static final androidx.compose.ui.semantics.Role access$getRole(androidx.compose.ui.semantics.SemanticsNode $receiver) {
        return SemanticsNodeKt.getRole($receiver);
    }

    public static final int access$roleFakeNodeId(androidx.compose.ui.semantics.SemanticsNode $receiver) {
        return SemanticsNodeKt.roleFakeNodeId($receiver);
    }

    private static final int contentDescriptionFakeNodeId(androidx.compose.ui.semantics.SemanticsNode $this$contentDescriptionFakeNodeId) {
        return id += i2;
    }

    public static final LayoutNode findClosestParentNode(LayoutNode $this$findClosestParentNode, Function1<? super LayoutNode, Boolean> selector) {
        LayoutNode currentParent;
        boolean booleanValue;
        currentParent = $this$findClosestParentNode.getParent$ui_release();
        while (currentParent != null) {
            currentParent = currentParent.getParent$ui_release();
        }
        return null;
    }

    public static final SemanticsModifierNode getOuterMergingSemantics(LayoutNode $this$outerMergingSemantics) {
        Object this_$iv2;
        int capacity$iv$iv$iv$iv$iv;
        Modifier.Node next$iv$iv$iv;
        Modifier.Node count$iv$iv$iv;
        int $i$f$getSemanticsOLwlOKw;
        int count$iv$iv$iv2;
        int $i$f$firstFromHeadALcG6gQ$ui_release2;
        int $i$f$firstFromHeadALcG6gQ$ui_release;
        NodeChain i6;
        int i3;
        Modifier.Node node$iv$iv$iv$iv;
        Modifier.Node node5;
        int i2;
        Modifier.Node node4;
        int i;
        Modifier.Node node;
        int i4;
        int node$iv$iv$iv;
        int stack$iv$iv$iv;
        NodeChain this_$iv;
        int type$iv;
        int $i$f$isKindH91voCI$ui_release;
        boolean it;
        int i9;
        Modifier.Node node$iv$iv$iv$iv2;
        Modifier.Node node3;
        int i7;
        Modifier.Node node6;
        int this_$iv$iv$iv$iv;
        int i10;
        int i5;
        int count$iv$iv$iv3;
        int $i$f$firstFromHeadALcG6gQ$ui_release3;
        int i8;
        Modifier.Node node2;
        this_$iv2 = $this$outerMergingSemantics.getNodes$ui_release();
        int i12 = 0;
        $i$f$getSemanticsOLwlOKw = NodeKind.constructor-impl(8);
        final int i14 = 0;
        final int i15 = $i$f$getSemanticsOLwlOKw;
        final NodeChain nodeChain2 = nodeChain;
        final int i16 = 0;
        if (i17 &= i15 != 0) {
            i3 = 0;
            node$iv$iv$iv$iv = nodeChain2.getHead$ui_release();
            while (node$iv$iv$iv$iv != null) {
                node5 = node$iv$iv$iv$iv;
                i2 = 0;
                if (kindSet$ui_release &= i15 == 0) {
                    break;
                } else {
                }
                this_$iv = this_$iv2;
                type$iv = $i$f$getSemanticsOLwlOKw;
                $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                this_$iv2 = this_$iv;
                $i$f$getSemanticsOLwlOKw = type$iv;
                $i$f$firstFromHeadALcG6gQ$ui_release2 = $i$f$firstFromHeadALcG6gQ$ui_release3;
                i = 0;
                i4 = 0;
                node$iv$iv$iv = 0;
                int i18 = 0;
                this_$iv = this_$iv2;
                this_$iv2 = node2;
                while (this_$iv2 != null) {
                    type$iv = $i$f$getSemanticsOLwlOKw;
                    count$iv$iv$iv = this_$iv2;
                    int i19 = 0;
                    i9 = count$iv$iv$iv;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    if ($i$f$isKindH91voCI$ui_release != 0 && this_$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                    this_$iv2 = DelegatableNodeKt.access$pop(node$iv$iv$iv);
                    $i$f$getSemanticsOLwlOKw = type$iv;
                    $i$f$firstFromHeadALcG6gQ$ui_release2 = $i$f$firstFromHeadALcG6gQ$ui_release3;
                    if (this_$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv$iv = 0;
                    i9 = 0;
                    node$iv$iv$iv$iv2 = (DelegatingNode)this_$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv$iv2 != null) {
                        node3 = node$iv$iv$iv$iv2;
                        i7 = 0;
                        i10 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv = 0;
                        if (this_$iv$iv$iv$iv != 0) {
                        } else {
                        }
                        $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                        next$iv$iv$iv = node3;
                        $i$f$firstFromHeadALcG6gQ$ui_release = node$iv$iv$iv;
                        stack$iv$iv$iv = node6;
                        node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                        this_$iv2 = stack$iv$iv$iv;
                        node$iv$iv$iv = $i$f$firstFromHeadALcG6gQ$ui_release;
                        $i$f$firstFromHeadALcG6gQ$ui_release2 = $i$f$firstFromHeadALcG6gQ$ui_release3;
                        count$iv$iv$iv++;
                        node6 = this_$iv2;
                        if (count$iv$iv$iv == 1) {
                        } else {
                        }
                        if (node$iv$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv$iv3 = count$iv$iv$iv;
                        $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                        capacity$iv$iv$iv$iv$iv = 0;
                        count$iv$iv$iv2 = node$iv$iv$iv;
                        Modifier.Node node7 = node6;
                        if (node7 != null) {
                        } else {
                        }
                        stack$iv$iv$iv = node6;
                        if (count$iv$iv$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv$iv = node3;
                        $i$f$firstFromHeadALcG6gQ$ui_release = count$iv$iv$iv2;
                        count$iv$iv$iv = count$iv$iv$iv3;
                        count$iv$iv$iv2.add(node3);
                        if (count$iv$iv$iv2 != 0) {
                        }
                        stack$iv$iv$iv = 0;
                        count$iv$iv$iv2.add(node7);
                        i10 = i11;
                        int $i$f$mutableVectorOf = 16;
                        i5 = 0;
                        count$iv$iv$iv3 = count$iv$iv$iv;
                        $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                        i8 = $i$f$mutableVectorOf;
                        count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                        $i$f$firstFromHeadALcG6gQ$ui_release = node$iv$iv$iv;
                        stack$iv$iv$iv = next$iv$iv$iv;
                        this_$iv$iv$iv$iv = 1;
                    }
                    node6 = this_$iv2;
                    if (count$iv$iv$iv == 1) {
                    } else {
                    }
                    this_$iv2 = node6;
                    $i$f$getSemanticsOLwlOKw = type$iv;
                    this_$iv2 = node6;
                    $i$f$firstFromHeadALcG6gQ$ui_release2 = $i$f$firstFromHeadALcG6gQ$ui_release3;
                    node3 = node$iv$iv$iv$iv2;
                    i7 = 0;
                    i10 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                    next$iv$iv$iv = node3;
                    $i$f$firstFromHeadALcG6gQ$ui_release = node$iv$iv$iv;
                    stack$iv$iv$iv = node6;
                    node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                    this_$iv2 = stack$iv$iv$iv;
                    node$iv$iv$iv = $i$f$firstFromHeadALcG6gQ$ui_release;
                    $i$f$firstFromHeadALcG6gQ$ui_release2 = $i$f$firstFromHeadALcG6gQ$ui_release3;
                    count$iv$iv$iv++;
                    node6 = this_$iv2;
                    if (count$iv$iv$iv == 1) {
                    } else {
                    }
                    if (node$iv$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv$iv3 = count$iv$iv$iv;
                    $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                    capacity$iv$iv$iv$iv$iv = 0;
                    count$iv$iv$iv2 = node$iv$iv$iv;
                    node7 = node6;
                    if (node7 != null) {
                    } else {
                    }
                    stack$iv$iv$iv = node6;
                    if (count$iv$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv$iv = node3;
                    $i$f$firstFromHeadALcG6gQ$ui_release = count$iv$iv$iv2;
                    count$iv$iv$iv = count$iv$iv$iv3;
                    count$iv$iv$iv2.add(node3);
                    if (count$iv$iv$iv2 != 0) {
                    }
                    stack$iv$iv$iv = 0;
                    count$iv$iv$iv2.add(node7);
                    i10 = i11;
                    $i$f$mutableVectorOf = 16;
                    i5 = 0;
                    count$iv$iv$iv3 = count$iv$iv$iv;
                    $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                    i8 = $i$f$mutableVectorOf;
                    count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                    $i$f$firstFromHeadALcG6gQ$ui_release = node$iv$iv$iv;
                    stack$iv$iv$iv = next$iv$iv$iv;
                    this_$iv$iv$iv$iv = 1;
                    $i$f$isKindH91voCI$ui_release = 1;
                    $i$f$isKindH91voCI$ui_release = 0;
                    i9 = 0;
                    $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                }
                type$iv = $i$f$getSemanticsOLwlOKw;
                $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                type$iv = $i$f$getSemanticsOLwlOKw;
                count$iv$iv$iv = this_$iv2;
                i19 = 0;
                i9 = count$iv$iv$iv;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                $i$f$isKindH91voCI$ui_release = 0;
                if ($i$f$isKindH91voCI$ui_release != 0 && this_$iv2 instanceof DelegatingNode) {
                } else {
                }
                $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                this_$iv2 = DelegatableNodeKt.access$pop(node$iv$iv$iv);
                $i$f$getSemanticsOLwlOKw = type$iv;
                $i$f$firstFromHeadALcG6gQ$ui_release2 = $i$f$firstFromHeadALcG6gQ$ui_release3;
                if (this_$iv2 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv$iv = 0;
                i9 = 0;
                node$iv$iv$iv$iv2 = (DelegatingNode)this_$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv$iv2 != null) {
                    node3 = node$iv$iv$iv$iv2;
                    i7 = 0;
                    i10 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                    next$iv$iv$iv = node3;
                    $i$f$firstFromHeadALcG6gQ$ui_release = node$iv$iv$iv;
                    stack$iv$iv$iv = node6;
                    node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                    this_$iv2 = stack$iv$iv$iv;
                    node$iv$iv$iv = $i$f$firstFromHeadALcG6gQ$ui_release;
                    $i$f$firstFromHeadALcG6gQ$ui_release2 = $i$f$firstFromHeadALcG6gQ$ui_release3;
                    count$iv$iv$iv++;
                    node6 = this_$iv2;
                    if (count$iv$iv$iv == 1) {
                    } else {
                    }
                    if (node$iv$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv$iv3 = count$iv$iv$iv;
                    $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                    capacity$iv$iv$iv$iv$iv = 0;
                    count$iv$iv$iv2 = node$iv$iv$iv;
                    node7 = node6;
                    if (node7 != null) {
                    } else {
                    }
                    stack$iv$iv$iv = node6;
                    if (count$iv$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv$iv = node3;
                    $i$f$firstFromHeadALcG6gQ$ui_release = count$iv$iv$iv2;
                    count$iv$iv$iv = count$iv$iv$iv3;
                    count$iv$iv$iv2.add(node3);
                    if (count$iv$iv$iv2 != 0) {
                    }
                    stack$iv$iv$iv = 0;
                    count$iv$iv$iv2.add(node7);
                    i10 = i11;
                    $i$f$mutableVectorOf = 16;
                    i5 = 0;
                    count$iv$iv$iv3 = count$iv$iv$iv;
                    $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                    i8 = $i$f$mutableVectorOf;
                    count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                    $i$f$firstFromHeadALcG6gQ$ui_release = node$iv$iv$iv;
                    stack$iv$iv$iv = next$iv$iv$iv;
                    this_$iv$iv$iv$iv = 1;
                }
                node6 = this_$iv2;
                if (count$iv$iv$iv == 1) {
                } else {
                }
                this_$iv2 = node6;
                $i$f$getSemanticsOLwlOKw = type$iv;
                this_$iv2 = node6;
                $i$f$firstFromHeadALcG6gQ$ui_release2 = $i$f$firstFromHeadALcG6gQ$ui_release3;
                node3 = node$iv$iv$iv$iv2;
                i7 = 0;
                i10 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv$iv = 0;
                if (this_$iv$iv$iv$iv != 0) {
                } else {
                }
                $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                next$iv$iv$iv = node3;
                $i$f$firstFromHeadALcG6gQ$ui_release = node$iv$iv$iv;
                stack$iv$iv$iv = node6;
                node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                this_$iv2 = stack$iv$iv$iv;
                node$iv$iv$iv = $i$f$firstFromHeadALcG6gQ$ui_release;
                $i$f$firstFromHeadALcG6gQ$ui_release2 = $i$f$firstFromHeadALcG6gQ$ui_release3;
                count$iv$iv$iv++;
                node6 = this_$iv2;
                if (count$iv$iv$iv == 1) {
                } else {
                }
                if (node$iv$iv$iv == 0) {
                } else {
                }
                count$iv$iv$iv3 = count$iv$iv$iv;
                $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                capacity$iv$iv$iv$iv$iv = 0;
                count$iv$iv$iv2 = node$iv$iv$iv;
                node7 = node6;
                if (node7 != null) {
                } else {
                }
                stack$iv$iv$iv = node6;
                if (count$iv$iv$iv2 != 0) {
                } else {
                }
                next$iv$iv$iv = node3;
                $i$f$firstFromHeadALcG6gQ$ui_release = count$iv$iv$iv2;
                count$iv$iv$iv = count$iv$iv$iv3;
                count$iv$iv$iv2.add(node3);
                if (count$iv$iv$iv2 != 0) {
                }
                stack$iv$iv$iv = 0;
                count$iv$iv$iv2.add(node7);
                i10 = i11;
                $i$f$mutableVectorOf = 16;
                i5 = 0;
                count$iv$iv$iv3 = count$iv$iv$iv;
                $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                i8 = $i$f$mutableVectorOf;
                count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
                $i$f$firstFromHeadALcG6gQ$ui_release = node$iv$iv$iv;
                stack$iv$iv$iv = next$iv$iv$iv;
                this_$iv$iv$iv$iv = 1;
                $i$f$isKindH91voCI$ui_release = 1;
                $i$f$isKindH91voCI$ui_release = 0;
                i9 = 0;
                $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
            }
            this_$iv = this_$iv2;
            type$iv = $i$f$getSemanticsOLwlOKw;
            $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
            count$iv$iv$iv = 0;
        } else {
            this_$iv = this_$iv2;
            type$iv = $i$f$getSemanticsOLwlOKw;
            $i$f$firstFromHeadALcG6gQ$ui_release3 = $i$f$firstFromHeadALcG6gQ$ui_release2;
        }
        return (SemanticsModifierNode)count$iv$iv$iv;
    }

    private static final androidx.compose.ui.semantics.Role getRole(androidx.compose.ui.semantics.SemanticsNode $this$role) {
        return (Role)SemanticsConfigurationKt.getOrNull($this$role.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
    }

    private static final int roleFakeNodeId(androidx.compose.ui.semantics.SemanticsNode $this$roleFakeNodeId) {
        return id += i2;
    }
}
