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
        Modifier.Node node$iv$iv$iv2;
        int capacity$iv$iv$iv$iv$iv;
        int i11;
        int count$iv$iv$iv2;
        int it$iv;
        MutableVector count$iv$iv$iv3;
        int stack$iv$iv$iv2;
        int theNode$iv$iv$iv;
        NodeChain i5;
        int i;
        Modifier.Node node$iv$iv$iv$iv2;
        Modifier.Node node6;
        int i8;
        Modifier.Node node2;
        int i10;
        Modifier.Node node4;
        int i4;
        int node$iv$iv$iv;
        Modifier.Node stack$iv$iv$iv;
        NodeChain this_$iv2;
        int type$iv;
        int i7;
        Modifier.Node node7;
        int i12;
        Modifier.Node node$iv$iv$iv$iv;
        Modifier.Node node3;
        int i13;
        Modifier.Node node;
        int this_$iv$iv$iv$iv;
        int i6;
        int i2;
        int count$iv$iv$iv;
        int i9;
        int i3;
        Modifier.Node node5;
        this_$iv = layoutNode.getNodes$ui_release();
        int i15 = 0;
        count$iv$iv$iv2 = NodeKind.constructor-impl(8);
        int i17 = 0;
        final int i18 = count$iv$iv$iv2;
        final NodeChain nodeChain2 = nodeChain;
        final int i19 = 0;
        if (i20 &= i18 != 0) {
            i = 0;
            node$iv$iv$iv$iv2 = nodeChain2.getHead$ui_release();
            while (node$iv$iv$iv$iv2 != null) {
                node6 = node$iv$iv$iv$iv2;
                i8 = 0;
                if (kindSet$ui_release &= i18 == 0) {
                    break;
                } else {
                }
                this_$iv2 = this_$iv;
                type$iv = count$iv$iv$iv2;
                i9 = stack$iv$iv$iv2;
                node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                this_$iv = this_$iv2;
                count$iv$iv$iv2 = type$iv;
                stack$iv$iv$iv2 = i9;
                i10 = 0;
                i4 = 0;
                node$iv$iv$iv = 0;
                int i21 = 0;
                this_$iv2 = this_$iv;
                this_$iv = node5;
                while (this_$iv != null) {
                    type$iv = count$iv$iv$iv2;
                    it$iv = this_$iv;
                    int i22 = 0;
                    i12 = it$iv;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    i7 = 0;
                    if (i7 != 0 && this_$iv instanceof DelegatingNode) {
                    } else {
                    }
                    i9 = stack$iv$iv$iv2;
                    this_$iv = DelegatableNodeKt.access$pop(node$iv$iv$iv);
                    count$iv$iv$iv2 = type$iv;
                    stack$iv$iv$iv2 = i9;
                    if (this_$iv instanceof DelegatingNode) {
                    } else {
                    }
                    it$iv = 0;
                    i12 = 0;
                    node$iv$iv$iv$iv = (DelegatingNode)this_$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv$iv != null) {
                        node3 = node$iv$iv$iv$iv;
                        i13 = 0;
                        i6 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv = 0;
                        if (this_$iv$iv$iv$iv != 0) {
                        } else {
                        }
                        i9 = stack$iv$iv$iv2;
                        node$iv$iv$iv2 = node3;
                        theNode$iv$iv$iv = node$iv$iv$iv;
                        stack$iv$iv$iv = node;
                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                        this_$iv = stack$iv$iv$iv;
                        node$iv$iv$iv = theNode$iv$iv$iv;
                        stack$iv$iv$iv2 = i9;
                        it$iv++;
                        node = this_$iv;
                        if (it$iv == 1) {
                        } else {
                        }
                        if (node$iv$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv$iv = it$iv;
                        i9 = stack$iv$iv$iv2;
                        capacity$iv$iv$iv$iv$iv = 0;
                        count$iv$iv$iv3 = node$iv$iv$iv;
                        Modifier.Node node9 = node;
                        if (node9 != null) {
                        } else {
                        }
                        stack$iv$iv$iv = node;
                        if (count$iv$iv$iv3 != null) {
                        } else {
                        }
                        node$iv$iv$iv2 = node3;
                        theNode$iv$iv$iv = count$iv$iv$iv3;
                        it$iv = count$iv$iv$iv;
                        count$iv$iv$iv3.add(node3);
                        if (count$iv$iv$iv3 != null) {
                        }
                        stack$iv$iv$iv = 0;
                        count$iv$iv$iv3.add(node9);
                        i6 = i14;
                        int $i$f$mutableVectorOf = 16;
                        i2 = 0;
                        count$iv$iv$iv = it$iv;
                        i9 = stack$iv$iv$iv2;
                        i3 = $i$f$mutableVectorOf;
                        count$iv$iv$iv3 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        i9 = stack$iv$iv$iv2;
                        theNode$iv$iv$iv = node$iv$iv$iv;
                        stack$iv$iv$iv = node$iv$iv$iv2;
                        this_$iv$iv$iv$iv = 1;
                    }
                    node = this_$iv;
                    if (it$iv == 1) {
                    } else {
                    }
                    this_$iv = node;
                    count$iv$iv$iv2 = type$iv;
                    this_$iv = node;
                    stack$iv$iv$iv2 = i9;
                    node3 = node$iv$iv$iv$iv;
                    i13 = 0;
                    i6 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    i9 = stack$iv$iv$iv2;
                    node$iv$iv$iv2 = node3;
                    theNode$iv$iv$iv = node$iv$iv$iv;
                    stack$iv$iv$iv = node;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    this_$iv = stack$iv$iv$iv;
                    node$iv$iv$iv = theNode$iv$iv$iv;
                    stack$iv$iv$iv2 = i9;
                    it$iv++;
                    node = this_$iv;
                    if (it$iv == 1) {
                    } else {
                    }
                    if (node$iv$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv$iv = it$iv;
                    i9 = stack$iv$iv$iv2;
                    capacity$iv$iv$iv$iv$iv = 0;
                    count$iv$iv$iv3 = node$iv$iv$iv;
                    node9 = node;
                    if (node9 != null) {
                    } else {
                    }
                    stack$iv$iv$iv = node;
                    if (count$iv$iv$iv3 != null) {
                    } else {
                    }
                    node$iv$iv$iv2 = node3;
                    theNode$iv$iv$iv = count$iv$iv$iv3;
                    it$iv = count$iv$iv$iv;
                    count$iv$iv$iv3.add(node3);
                    if (count$iv$iv$iv3 != null) {
                    }
                    stack$iv$iv$iv = 0;
                    count$iv$iv$iv3.add(node9);
                    i6 = i14;
                    $i$f$mutableVectorOf = 16;
                    i2 = 0;
                    count$iv$iv$iv = it$iv;
                    i9 = stack$iv$iv$iv2;
                    i3 = $i$f$mutableVectorOf;
                    count$iv$iv$iv3 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i9 = stack$iv$iv$iv2;
                    theNode$iv$iv$iv = node$iv$iv$iv;
                    stack$iv$iv$iv = node$iv$iv$iv2;
                    this_$iv$iv$iv$iv = 1;
                    i7 = 1;
                }
                type$iv = count$iv$iv$iv2;
                i9 = stack$iv$iv$iv2;
                type$iv = count$iv$iv$iv2;
                it$iv = this_$iv;
                i22 = 0;
                i12 = it$iv;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                i7 = 0;
                if (i7 != 0 && this_$iv instanceof DelegatingNode) {
                } else {
                }
                i9 = stack$iv$iv$iv2;
                this_$iv = DelegatableNodeKt.access$pop(node$iv$iv$iv);
                count$iv$iv$iv2 = type$iv;
                stack$iv$iv$iv2 = i9;
                if (this_$iv instanceof DelegatingNode) {
                } else {
                }
                it$iv = 0;
                i12 = 0;
                node$iv$iv$iv$iv = (DelegatingNode)this_$iv.getDelegate$ui_release();
                while (node$iv$iv$iv$iv != null) {
                    node3 = node$iv$iv$iv$iv;
                    i13 = 0;
                    i6 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    i9 = stack$iv$iv$iv2;
                    node$iv$iv$iv2 = node3;
                    theNode$iv$iv$iv = node$iv$iv$iv;
                    stack$iv$iv$iv = node;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    this_$iv = stack$iv$iv$iv;
                    node$iv$iv$iv = theNode$iv$iv$iv;
                    stack$iv$iv$iv2 = i9;
                    it$iv++;
                    node = this_$iv;
                    if (it$iv == 1) {
                    } else {
                    }
                    if (node$iv$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv$iv = it$iv;
                    i9 = stack$iv$iv$iv2;
                    capacity$iv$iv$iv$iv$iv = 0;
                    count$iv$iv$iv3 = node$iv$iv$iv;
                    node9 = node;
                    if (node9 != null) {
                    } else {
                    }
                    stack$iv$iv$iv = node;
                    if (count$iv$iv$iv3 != null) {
                    } else {
                    }
                    node$iv$iv$iv2 = node3;
                    theNode$iv$iv$iv = count$iv$iv$iv3;
                    it$iv = count$iv$iv$iv;
                    count$iv$iv$iv3.add(node3);
                    if (count$iv$iv$iv3 != null) {
                    }
                    stack$iv$iv$iv = 0;
                    count$iv$iv$iv3.add(node9);
                    i6 = i14;
                    $i$f$mutableVectorOf = 16;
                    i2 = 0;
                    count$iv$iv$iv = it$iv;
                    i9 = stack$iv$iv$iv2;
                    i3 = $i$f$mutableVectorOf;
                    count$iv$iv$iv3 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i9 = stack$iv$iv$iv2;
                    theNode$iv$iv$iv = node$iv$iv$iv;
                    stack$iv$iv$iv = node$iv$iv$iv2;
                    this_$iv$iv$iv$iv = 1;
                }
                node = this_$iv;
                if (it$iv == 1) {
                } else {
                }
                this_$iv = node;
                count$iv$iv$iv2 = type$iv;
                this_$iv = node;
                stack$iv$iv$iv2 = i9;
                node3 = node$iv$iv$iv$iv;
                i13 = 0;
                i6 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv$iv = 0;
                if (this_$iv$iv$iv$iv != 0) {
                } else {
                }
                i9 = stack$iv$iv$iv2;
                node$iv$iv$iv2 = node3;
                theNode$iv$iv$iv = node$iv$iv$iv;
                stack$iv$iv$iv = node;
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                this_$iv = stack$iv$iv$iv;
                node$iv$iv$iv = theNode$iv$iv$iv;
                stack$iv$iv$iv2 = i9;
                it$iv++;
                node = this_$iv;
                if (it$iv == 1) {
                } else {
                }
                if (node$iv$iv$iv == 0) {
                } else {
                }
                count$iv$iv$iv = it$iv;
                i9 = stack$iv$iv$iv2;
                capacity$iv$iv$iv$iv$iv = 0;
                count$iv$iv$iv3 = node$iv$iv$iv;
                node9 = node;
                if (node9 != null) {
                } else {
                }
                stack$iv$iv$iv = node;
                if (count$iv$iv$iv3 != null) {
                } else {
                }
                node$iv$iv$iv2 = node3;
                theNode$iv$iv$iv = count$iv$iv$iv3;
                it$iv = count$iv$iv$iv;
                count$iv$iv$iv3.add(node3);
                if (count$iv$iv$iv3 != null) {
                }
                stack$iv$iv$iv = 0;
                count$iv$iv$iv3.add(node9);
                i6 = i14;
                $i$f$mutableVectorOf = 16;
                i2 = 0;
                count$iv$iv$iv = it$iv;
                i9 = stack$iv$iv$iv2;
                i3 = $i$f$mutableVectorOf;
                count$iv$iv$iv3 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i9 = stack$iv$iv$iv2;
                theNode$iv$iv$iv = node$iv$iv$iv;
                stack$iv$iv$iv = node$iv$iv$iv2;
                this_$iv$iv$iv$iv = 1;
                i7 = 1;
            }
            this_$iv2 = this_$iv;
            type$iv = count$iv$iv$iv2;
            i9 = stack$iv$iv$iv2;
            i11 = 0;
        } else {
            this_$iv2 = this_$iv;
            type$iv = count$iv$iv$iv2;
            i9 = stack$iv$iv$iv2;
        }
        Intrinsics.checkNotNull(i11);
        androidx.compose.ui.semantics.SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
        Intrinsics.checkNotNull(collapsedSemantics$ui_release);
        SemanticsNode semanticsNode = new SemanticsNode((SemanticsModifierNode)i11.getNode(), mergingEnabled, layoutNode, collapsedSemantics$ui_release);
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
        Modifier.Node count$iv$iv$iv2;
        int count$iv$iv$iv;
        int count$iv$iv$iv3;
        int stack$iv$iv$iv;
        int theNode$iv$iv$iv;
        NodeChain i11;
        int i6;
        Modifier.Node node$iv$iv$iv$iv;
        Modifier.Node node3;
        int i9;
        Modifier.Node node2;
        int i12;
        Modifier.Node node;
        int i5;
        int node$iv$iv$iv;
        int stack$iv$iv$iv2;
        NodeChain this_$iv;
        int type$iv;
        int i3;
        boolean it;
        int i8;
        Modifier.Node node$iv$iv$iv$iv2;
        Modifier.Node node4;
        int i;
        Modifier.Node node6;
        int this_$iv$iv$iv$iv;
        int i2;
        int i10;
        int count$iv$iv$iv4;
        int i7;
        int i4;
        Modifier.Node node5;
        this_$iv2 = $this$outerMergingSemantics.getNodes$ui_release();
        int i14 = 0;
        count$iv$iv$iv = NodeKind.constructor-impl(8);
        final int i16 = 0;
        final int i17 = count$iv$iv$iv;
        final NodeChain nodeChain2 = nodeChain;
        final int i18 = 0;
        if (i19 &= i17 != 0) {
            i6 = 0;
            node$iv$iv$iv$iv = nodeChain2.getHead$ui_release();
            while (node$iv$iv$iv$iv != null) {
                node3 = node$iv$iv$iv$iv;
                i9 = 0;
                if (kindSet$ui_release &= i17 == 0) {
                    break;
                } else {
                }
                this_$iv = this_$iv2;
                type$iv = count$iv$iv$iv;
                i7 = stack$iv$iv$iv;
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                this_$iv2 = this_$iv;
                count$iv$iv$iv = type$iv;
                stack$iv$iv$iv = i7;
                i12 = 0;
                i5 = 0;
                node$iv$iv$iv = 0;
                int i20 = 0;
                this_$iv = this_$iv2;
                this_$iv2 = node5;
                while (this_$iv2 != null) {
                    type$iv = count$iv$iv$iv;
                    count$iv$iv$iv2 = this_$iv2;
                    int i21 = 0;
                    i8 = count$iv$iv$iv2;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    i3 = 0;
                    if (i3 != 0 && this_$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    i7 = stack$iv$iv$iv;
                    this_$iv2 = DelegatableNodeKt.access$pop(node$iv$iv$iv);
                    count$iv$iv$iv = type$iv;
                    stack$iv$iv$iv = i7;
                    if (this_$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv$iv2 = 0;
                    i8 = 0;
                    node$iv$iv$iv$iv2 = (DelegatingNode)this_$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv$iv2 != null) {
                        node4 = node$iv$iv$iv$iv2;
                        i = 0;
                        i2 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv = 0;
                        if (this_$iv$iv$iv$iv != 0) {
                        } else {
                        }
                        i7 = stack$iv$iv$iv;
                        next$iv$iv$iv = node4;
                        theNode$iv$iv$iv = node$iv$iv$iv;
                        stack$iv$iv$iv2 = node6;
                        node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                        this_$iv2 = stack$iv$iv$iv2;
                        node$iv$iv$iv = theNode$iv$iv$iv;
                        stack$iv$iv$iv = i7;
                        count$iv$iv$iv2++;
                        node6 = this_$iv2;
                        if (count$iv$iv$iv2 == 1) {
                        } else {
                        }
                        if (node$iv$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv$iv4 = count$iv$iv$iv2;
                        i7 = stack$iv$iv$iv;
                        capacity$iv$iv$iv$iv$iv = 0;
                        count$iv$iv$iv3 = node$iv$iv$iv;
                        Modifier.Node node7 = node6;
                        if (node7 != null) {
                        } else {
                        }
                        stack$iv$iv$iv2 = node6;
                        if (count$iv$iv$iv3 != 0) {
                        } else {
                        }
                        next$iv$iv$iv = node4;
                        theNode$iv$iv$iv = count$iv$iv$iv3;
                        count$iv$iv$iv2 = count$iv$iv$iv4;
                        count$iv$iv$iv3.add(node4);
                        if (count$iv$iv$iv3 != 0) {
                        }
                        stack$iv$iv$iv2 = 0;
                        count$iv$iv$iv3.add(node7);
                        i2 = i13;
                        int $i$f$mutableVectorOf = 16;
                        i10 = 0;
                        count$iv$iv$iv4 = count$iv$iv$iv2;
                        i7 = stack$iv$iv$iv;
                        i4 = $i$f$mutableVectorOf;
                        count$iv$iv$iv3 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        i7 = stack$iv$iv$iv;
                        theNode$iv$iv$iv = node$iv$iv$iv;
                        stack$iv$iv$iv2 = next$iv$iv$iv;
                        this_$iv$iv$iv$iv = 1;
                    }
                    node6 = this_$iv2;
                    if (count$iv$iv$iv2 == 1) {
                    } else {
                    }
                    this_$iv2 = node6;
                    count$iv$iv$iv = type$iv;
                    this_$iv2 = node6;
                    stack$iv$iv$iv = i7;
                    node4 = node$iv$iv$iv$iv2;
                    i = 0;
                    i2 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    i7 = stack$iv$iv$iv;
                    next$iv$iv$iv = node4;
                    theNode$iv$iv$iv = node$iv$iv$iv;
                    stack$iv$iv$iv2 = node6;
                    node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                    this_$iv2 = stack$iv$iv$iv2;
                    node$iv$iv$iv = theNode$iv$iv$iv;
                    stack$iv$iv$iv = i7;
                    count$iv$iv$iv2++;
                    node6 = this_$iv2;
                    if (count$iv$iv$iv2 == 1) {
                    } else {
                    }
                    if (node$iv$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv$iv4 = count$iv$iv$iv2;
                    i7 = stack$iv$iv$iv;
                    capacity$iv$iv$iv$iv$iv = 0;
                    count$iv$iv$iv3 = node$iv$iv$iv;
                    node7 = node6;
                    if (node7 != null) {
                    } else {
                    }
                    stack$iv$iv$iv2 = node6;
                    if (count$iv$iv$iv3 != 0) {
                    } else {
                    }
                    next$iv$iv$iv = node4;
                    theNode$iv$iv$iv = count$iv$iv$iv3;
                    count$iv$iv$iv2 = count$iv$iv$iv4;
                    count$iv$iv$iv3.add(node4);
                    if (count$iv$iv$iv3 != 0) {
                    }
                    stack$iv$iv$iv2 = 0;
                    count$iv$iv$iv3.add(node7);
                    i2 = i13;
                    $i$f$mutableVectorOf = 16;
                    i10 = 0;
                    count$iv$iv$iv4 = count$iv$iv$iv2;
                    i7 = stack$iv$iv$iv;
                    i4 = $i$f$mutableVectorOf;
                    count$iv$iv$iv3 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i7 = stack$iv$iv$iv;
                    theNode$iv$iv$iv = node$iv$iv$iv;
                    stack$iv$iv$iv2 = next$iv$iv$iv;
                    this_$iv$iv$iv$iv = 1;
                    i3 = 1;
                    i3 = 0;
                    i8 = 0;
                    i7 = stack$iv$iv$iv;
                }
                type$iv = count$iv$iv$iv;
                i7 = stack$iv$iv$iv;
                type$iv = count$iv$iv$iv;
                count$iv$iv$iv2 = this_$iv2;
                i21 = 0;
                i8 = count$iv$iv$iv2;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                i3 = 0;
                if (i3 != 0 && this_$iv2 instanceof DelegatingNode) {
                } else {
                }
                i7 = stack$iv$iv$iv;
                this_$iv2 = DelegatableNodeKt.access$pop(node$iv$iv$iv);
                count$iv$iv$iv = type$iv;
                stack$iv$iv$iv = i7;
                if (this_$iv2 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv$iv2 = 0;
                i8 = 0;
                node$iv$iv$iv$iv2 = (DelegatingNode)this_$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv$iv2 != null) {
                    node4 = node$iv$iv$iv$iv2;
                    i = 0;
                    i2 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    i7 = stack$iv$iv$iv;
                    next$iv$iv$iv = node4;
                    theNode$iv$iv$iv = node$iv$iv$iv;
                    stack$iv$iv$iv2 = node6;
                    node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                    this_$iv2 = stack$iv$iv$iv2;
                    node$iv$iv$iv = theNode$iv$iv$iv;
                    stack$iv$iv$iv = i7;
                    count$iv$iv$iv2++;
                    node6 = this_$iv2;
                    if (count$iv$iv$iv2 == 1) {
                    } else {
                    }
                    if (node$iv$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv$iv4 = count$iv$iv$iv2;
                    i7 = stack$iv$iv$iv;
                    capacity$iv$iv$iv$iv$iv = 0;
                    count$iv$iv$iv3 = node$iv$iv$iv;
                    node7 = node6;
                    if (node7 != null) {
                    } else {
                    }
                    stack$iv$iv$iv2 = node6;
                    if (count$iv$iv$iv3 != 0) {
                    } else {
                    }
                    next$iv$iv$iv = node4;
                    theNode$iv$iv$iv = count$iv$iv$iv3;
                    count$iv$iv$iv2 = count$iv$iv$iv4;
                    count$iv$iv$iv3.add(node4);
                    if (count$iv$iv$iv3 != 0) {
                    }
                    stack$iv$iv$iv2 = 0;
                    count$iv$iv$iv3.add(node7);
                    i2 = i13;
                    $i$f$mutableVectorOf = 16;
                    i10 = 0;
                    count$iv$iv$iv4 = count$iv$iv$iv2;
                    i7 = stack$iv$iv$iv;
                    i4 = $i$f$mutableVectorOf;
                    count$iv$iv$iv3 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i7 = stack$iv$iv$iv;
                    theNode$iv$iv$iv = node$iv$iv$iv;
                    stack$iv$iv$iv2 = next$iv$iv$iv;
                    this_$iv$iv$iv$iv = 1;
                }
                node6 = this_$iv2;
                if (count$iv$iv$iv2 == 1) {
                } else {
                }
                this_$iv2 = node6;
                count$iv$iv$iv = type$iv;
                this_$iv2 = node6;
                stack$iv$iv$iv = i7;
                node4 = node$iv$iv$iv$iv2;
                i = 0;
                i2 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv$iv = 0;
                if (this_$iv$iv$iv$iv != 0) {
                } else {
                }
                i7 = stack$iv$iv$iv;
                next$iv$iv$iv = node4;
                theNode$iv$iv$iv = node$iv$iv$iv;
                stack$iv$iv$iv2 = node6;
                node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                this_$iv2 = stack$iv$iv$iv2;
                node$iv$iv$iv = theNode$iv$iv$iv;
                stack$iv$iv$iv = i7;
                count$iv$iv$iv2++;
                node6 = this_$iv2;
                if (count$iv$iv$iv2 == 1) {
                } else {
                }
                if (node$iv$iv$iv == 0) {
                } else {
                }
                count$iv$iv$iv4 = count$iv$iv$iv2;
                i7 = stack$iv$iv$iv;
                capacity$iv$iv$iv$iv$iv = 0;
                count$iv$iv$iv3 = node$iv$iv$iv;
                node7 = node6;
                if (node7 != null) {
                } else {
                }
                stack$iv$iv$iv2 = node6;
                if (count$iv$iv$iv3 != 0) {
                } else {
                }
                next$iv$iv$iv = node4;
                theNode$iv$iv$iv = count$iv$iv$iv3;
                count$iv$iv$iv2 = count$iv$iv$iv4;
                count$iv$iv$iv3.add(node4);
                if (count$iv$iv$iv3 != 0) {
                }
                stack$iv$iv$iv2 = 0;
                count$iv$iv$iv3.add(node7);
                i2 = i13;
                $i$f$mutableVectorOf = 16;
                i10 = 0;
                count$iv$iv$iv4 = count$iv$iv$iv2;
                i7 = stack$iv$iv$iv;
                i4 = $i$f$mutableVectorOf;
                count$iv$iv$iv3 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i7 = stack$iv$iv$iv;
                theNode$iv$iv$iv = node$iv$iv$iv;
                stack$iv$iv$iv2 = next$iv$iv$iv;
                this_$iv$iv$iv$iv = 1;
                i3 = 1;
                i3 = 0;
                i8 = 0;
                i7 = stack$iv$iv$iv;
            }
            this_$iv = this_$iv2;
            type$iv = count$iv$iv$iv;
            i7 = stack$iv$iv$iv;
            count$iv$iv$iv2 = 0;
        } else {
            this_$iv = this_$iv2;
            type$iv = count$iv$iv$iv;
            i7 = stack$iv$iv$iv;
        }
        return (SemanticsModifierNode)count$iv$iv$iv2;
    }

    private static final androidx.compose.ui.semantics.Role getRole(androidx.compose.ui.semantics.SemanticsNode $this$role) {
        return (Role)SemanticsConfigurationKt.getOrNull($this$role.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
    }

    private static final int roleFakeNodeId(androidx.compose.ui.semantics.SemanticsNode $this$roleFakeNodeId) {
        return id += i2;
    }
}
