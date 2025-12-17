package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0002H\u0001¢\u0006\u0002\u0010\u0003\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0002*\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a-\u0010\u0007\u001a\u00020\u0008\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\u000c\u001a(\u0010\u0007\u001a\u00020\u0008*\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n\u001a-\u0010\r\u001a\u00020\u0008\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\u000c\u001a(\u0010\r\u001a\u00020\u0008*\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n\u001a-\u0010\u000e\u001a\u00020\u0008\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0002\u0010\u000c\u001a(\u0010\u000e\u001a\u00020\u0008*\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\n¨\u0006\u0010", d2 = {"findNearestAncestor", "T", "Landroidx/compose/ui/node/TraversableNode;", "(Landroidx/compose/ui/node/TraversableNode;)Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/DelegatableNode;", "key", "", "traverseAncestors", "", "block", "Lkotlin/Function1;", "", "(Landroidx/compose/ui/node/TraversableNode;Lkotlin/jvm/functions/Function1;)V", "traverseChildren", "traverseDescendants", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TraversableNodeKt {
    public static final androidx.compose.ui.node.TraversableNode findNearestAncestor(androidx.compose.ui.node.DelegatableNode $this$findNearestAncestor, Object key) {
        int count$iv$iv3;
        Modifier.Node count$iv$iv;
        androidx.compose.ui.node.DelegatableNode delegatableNode;
        Object $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
        Modifier.Node next$iv$iv;
        int $i$f$mutableVectorOf;
        int includeSelf$iv2;
        int i7;
        int i6;
        Modifier.Node node$iv$iv2;
        androidx.compose.ui.node.LayoutNode layout$iv$iv;
        int node$iv$iv;
        Modifier.Node head$ui_release;
        int i3;
        int i;
        Modifier.Node node2;
        int i2;
        int stack$iv$iv;
        int node$iv$iv3;
        int type$iv;
        int i10;
        Modifier.Node node3;
        androidx.compose.ui.node.DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        Modifier.Node node;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node4;
        int i9;
        int count$iv$iv2;
        int i4;
        int i5;
        int includeSelf$iv;
        int i8;
        int i11 = 0;
        count$iv$iv3 = NodeKind.constructor-impl(262144);
        delegatableNode = $this$findNearestAncestor;
        includeSelf$iv2 = 0;
        i7 = 0;
        final int i15 = count$iv$iv3;
        final androidx.compose.ui.node.DelegatableNode delegatableNode2 = delegatableNode;
        final int i16 = 0;
        if (!delegatableNode2.getNode().isAttached()) {
        } else {
            node$iv$iv2 = delegatableNode2.getNode().getParent$ui_release();
            layout$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode2);
            while (layout$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= i15 != 0) {
                } else {
                }
                type$iv = count$iv$iv3;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                includeSelf$iv = includeSelf$iv2;
                i8 = i7;
                node$iv$iv3 = 0;
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                count$iv$iv3 = layout$iv$iv.getNodes$ui_release();
                if (layout$iv$iv != null && count$iv$iv3 != null) {
                } else {
                }
                node$iv$iv = node$iv$iv3;
                node$iv$iv2 = node$iv$iv;
                count$iv$iv3 = type$iv;
                delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                includeSelf$iv2 = includeSelf$iv;
                i7 = i8;
                count$iv$iv3 = layout$iv$iv.getNodes$ui_release();
                if (count$iv$iv3 != null) {
                } else {
                }
                node$iv$iv = count$iv$iv3.getTail$ui_release();
                while (node$iv$iv2 != null) {
                    if (kindSet$ui_release &= i15 == 0) {
                        break loop_4;
                    } else {
                    }
                    type$iv = count$iv$iv3;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                    includeSelf$iv = includeSelf$iv2;
                    i8 = i7;
                    node$iv$iv3 = 0;
                    node$iv$iv2 = node$iv$iv2.getParent$ui_release();
                    count$iv$iv3 = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    includeSelf$iv2 = includeSelf$iv;
                    i7 = i8;
                    i = 0;
                    i2 = 0;
                    stack$iv$iv = 0;
                    int i17 = 0;
                    node$iv$iv = node$iv$iv4;
                    node$iv$iv3 = 0;
                    while (node$iv$iv != null) {
                        type$iv = count$iv$iv3;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                        count$iv$iv = node$iv$iv;
                        int i20 = 0;
                        node = count$iv$iv;
                        if (kindSet$ui_release2 &= type$iv != 0) {
                        } else {
                        }
                        i10 = 0;
                        if (i10 != 0 && node$iv$iv instanceof DelegatingNode) {
                        } else {
                        }
                        includeSelf$iv = includeSelf$iv2;
                        i8 = i7;
                        node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                        count$iv$iv3 = type$iv;
                        delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        includeSelf$iv2 = includeSelf$iv;
                        i7 = i8;
                        if (node$iv$iv instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv = 0;
                        node = 0;
                        node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node4 = node$iv$iv$iv;
                            i9 = 0;
                            i4 = 0;
                            if (kindSet$ui_release3 &= type$iv != 0) {
                            } else {
                            }
                            count$iv$iv2 = 0;
                            if (count$iv$iv2 != 0) {
                            } else {
                            }
                            includeSelf$iv = includeSelf$iv2;
                            i8 = i7;
                            next$iv$iv = node4;
                            i6 = 0;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                            includeSelf$iv2 = includeSelf$iv;
                            i7 = i8;
                            count$iv$iv++;
                            if (count$iv$iv == 1) {
                            } else {
                            }
                            if (stack$iv$iv == 0) {
                            } else {
                            }
                            count$iv$iv2 = count$iv$iv;
                            includeSelf$iv = includeSelf$iv2;
                            i8 = i7;
                            i6 = 0;
                            $i$f$mutableVectorOf = stack$iv$iv;
                            stack$iv$iv = $i$f$mutableVectorOf;
                            Modifier.Node node5 = node$iv$iv;
                            if (node5 != null && stack$iv$iv != 0) {
                            }
                            if (stack$iv$iv != 0) {
                            } else {
                            }
                            next$iv$iv = node4;
                            count$iv$iv = count$iv$iv2;
                            stack$iv$iv.add(node4);
                            if (stack$iv$iv != 0) {
                            }
                            node$iv$iv = $i$f$mutableVectorOf;
                            stack$iv$iv.add(node5);
                            count$iv$iv2 = count$iv$iv;
                            i4 = 0;
                            i5 = i14;
                            includeSelf$iv = includeSelf$iv2;
                            i8 = i7;
                            $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                            node$iv$iv = node4;
                            includeSelf$iv = includeSelf$iv2;
                            i8 = i7;
                            next$iv$iv = node4;
                            i6 = 0;
                            count$iv$iv2 = 1;
                        }
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        count$iv$iv3 = type$iv;
                        delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        includeSelf$iv2 = includeSelf$iv;
                        i7 = i8;
                        node4 = node$iv$iv$iv;
                        i9 = 0;
                        i4 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        count$iv$iv2 = 0;
                        if (count$iv$iv2 != 0) {
                        } else {
                        }
                        includeSelf$iv = includeSelf$iv2;
                        i8 = i7;
                        next$iv$iv = node4;
                        i6 = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                        includeSelf$iv2 = includeSelf$iv;
                        i7 = i8;
                        count$iv$iv++;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv;
                        includeSelf$iv = includeSelf$iv2;
                        i8 = i7;
                        i6 = 0;
                        $i$f$mutableVectorOf = stack$iv$iv;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node5 = node$iv$iv;
                        if (node5 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node4;
                        count$iv$iv = count$iv$iv2;
                        stack$iv$iv.add(node4);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv = $i$f$mutableVectorOf;
                        stack$iv$iv.add(node5);
                        count$iv$iv2 = count$iv$iv;
                        i4 = 0;
                        i5 = i14;
                        includeSelf$iv = includeSelf$iv2;
                        i8 = i7;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv = node4;
                        includeSelf$iv = includeSelf$iv2;
                        i8 = i7;
                        next$iv$iv = node4;
                        i6 = 0;
                        count$iv$iv2 = 1;
                        i10 = 1;
                        i10 = 0;
                        node3 = node6;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                        includeSelf$iv = includeSelf$iv2;
                        i8 = i7;
                    }
                    type$iv = count$iv$iv3;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                    includeSelf$iv = includeSelf$iv2;
                    i8 = i7;
                    type$iv = count$iv$iv3;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                    count$iv$iv = node$iv$iv;
                    i20 = 0;
                    node = count$iv$iv;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    i10 = 0;
                    if (i10 != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    includeSelf$iv = includeSelf$iv2;
                    i8 = i7;
                    node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                    count$iv$iv3 = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    includeSelf$iv2 = includeSelf$iv;
                    i7 = i8;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    node = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node4 = node$iv$iv$iv;
                        i9 = 0;
                        i4 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        count$iv$iv2 = 0;
                        if (count$iv$iv2 != 0) {
                        } else {
                        }
                        includeSelf$iv = includeSelf$iv2;
                        i8 = i7;
                        next$iv$iv = node4;
                        i6 = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                        includeSelf$iv2 = includeSelf$iv;
                        i7 = i8;
                        count$iv$iv++;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv;
                        includeSelf$iv = includeSelf$iv2;
                        i8 = i7;
                        i6 = 0;
                        $i$f$mutableVectorOf = stack$iv$iv;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node5 = node$iv$iv;
                        if (node5 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node4;
                        count$iv$iv = count$iv$iv2;
                        stack$iv$iv.add(node4);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv = $i$f$mutableVectorOf;
                        stack$iv$iv.add(node5);
                        count$iv$iv2 = count$iv$iv;
                        i4 = 0;
                        i5 = i14;
                        includeSelf$iv = includeSelf$iv2;
                        i8 = i7;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv = node4;
                        includeSelf$iv = includeSelf$iv2;
                        i8 = i7;
                        next$iv$iv = node4;
                        i6 = 0;
                        count$iv$iv2 = 1;
                    }
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    count$iv$iv3 = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    includeSelf$iv2 = includeSelf$iv;
                    i7 = i8;
                    node4 = node$iv$iv$iv;
                    i9 = 0;
                    i4 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    if (count$iv$iv2 != 0) {
                    } else {
                    }
                    includeSelf$iv = includeSelf$iv2;
                    i8 = i7;
                    next$iv$iv = node4;
                    i6 = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                    includeSelf$iv2 = includeSelf$iv;
                    i7 = i8;
                    count$iv$iv++;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv;
                    includeSelf$iv = includeSelf$iv2;
                    i8 = i7;
                    i6 = 0;
                    $i$f$mutableVectorOf = stack$iv$iv;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node5 = node$iv$iv;
                    if (node5 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node4;
                    count$iv$iv = count$iv$iv2;
                    stack$iv$iv.add(node4);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv = $i$f$mutableVectorOf;
                    stack$iv$iv.add(node5);
                    count$iv$iv2 = count$iv$iv;
                    i4 = 0;
                    i5 = i14;
                    includeSelf$iv = includeSelf$iv2;
                    i8 = i7;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = node4;
                    includeSelf$iv = includeSelf$iv2;
                    i8 = i7;
                    next$iv$iv = node4;
                    i6 = 0;
                    count$iv$iv2 = 1;
                    i10 = 1;
                    i10 = 0;
                    node3 = node6;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                    includeSelf$iv = includeSelf$iv2;
                    i8 = i7;
                }
                type$iv = count$iv$iv3;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                includeSelf$iv = includeSelf$iv2;
                i8 = i7;
                node$iv$iv3 = 0;
                if (kindSet$ui_release &= i15 != 0) {
                } else {
                }
                type$iv = count$iv$iv3;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                includeSelf$iv = includeSelf$iv2;
                i8 = i7;
                node$iv$iv3 = 0;
                node$iv$iv2 = node$iv$iv2.getParent$ui_release();
                count$iv$iv3 = type$iv;
                delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                includeSelf$iv2 = includeSelf$iv;
                i7 = i8;
                i = 0;
                i2 = 0;
                stack$iv$iv = 0;
                i17 = 0;
                node$iv$iv = node$iv$iv4;
                node$iv$iv3 = 0;
                while (node$iv$iv != null) {
                    type$iv = count$iv$iv3;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                    count$iv$iv = node$iv$iv;
                    i20 = 0;
                    node = count$iv$iv;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    i10 = 0;
                    if (i10 != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    includeSelf$iv = includeSelf$iv2;
                    i8 = i7;
                    node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                    count$iv$iv3 = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    includeSelf$iv2 = includeSelf$iv;
                    i7 = i8;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    node = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node4 = node$iv$iv$iv;
                        i9 = 0;
                        i4 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        count$iv$iv2 = 0;
                        if (count$iv$iv2 != 0) {
                        } else {
                        }
                        includeSelf$iv = includeSelf$iv2;
                        i8 = i7;
                        next$iv$iv = node4;
                        i6 = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                        includeSelf$iv2 = includeSelf$iv;
                        i7 = i8;
                        count$iv$iv++;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv;
                        includeSelf$iv = includeSelf$iv2;
                        i8 = i7;
                        i6 = 0;
                        $i$f$mutableVectorOf = stack$iv$iv;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node5 = node$iv$iv;
                        if (node5 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node4;
                        count$iv$iv = count$iv$iv2;
                        stack$iv$iv.add(node4);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv = $i$f$mutableVectorOf;
                        stack$iv$iv.add(node5);
                        count$iv$iv2 = count$iv$iv;
                        i4 = 0;
                        i5 = i14;
                        includeSelf$iv = includeSelf$iv2;
                        i8 = i7;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv = node4;
                        includeSelf$iv = includeSelf$iv2;
                        i8 = i7;
                        next$iv$iv = node4;
                        i6 = 0;
                        count$iv$iv2 = 1;
                    }
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    count$iv$iv3 = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    includeSelf$iv2 = includeSelf$iv;
                    i7 = i8;
                    node4 = node$iv$iv$iv;
                    i9 = 0;
                    i4 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    if (count$iv$iv2 != 0) {
                    } else {
                    }
                    includeSelf$iv = includeSelf$iv2;
                    i8 = i7;
                    next$iv$iv = node4;
                    i6 = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                    includeSelf$iv2 = includeSelf$iv;
                    i7 = i8;
                    count$iv$iv++;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv;
                    includeSelf$iv = includeSelf$iv2;
                    i8 = i7;
                    i6 = 0;
                    $i$f$mutableVectorOf = stack$iv$iv;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node5 = node$iv$iv;
                    if (node5 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node4;
                    count$iv$iv = count$iv$iv2;
                    stack$iv$iv.add(node4);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv = $i$f$mutableVectorOf;
                    stack$iv$iv.add(node5);
                    count$iv$iv2 = count$iv$iv;
                    i4 = 0;
                    i5 = i14;
                    includeSelf$iv = includeSelf$iv2;
                    i8 = i7;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = node4;
                    includeSelf$iv = includeSelf$iv2;
                    i8 = i7;
                    next$iv$iv = node4;
                    i6 = 0;
                    count$iv$iv2 = 1;
                    i10 = 1;
                    i10 = 0;
                    node3 = node6;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                    includeSelf$iv = includeSelf$iv2;
                    i8 = i7;
                }
                type$iv = count$iv$iv3;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                includeSelf$iv = includeSelf$iv2;
                i8 = i7;
                type$iv = count$iv$iv3;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                count$iv$iv = node$iv$iv;
                i20 = 0;
                node = count$iv$iv;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                i10 = 0;
                if (i10 != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                includeSelf$iv = includeSelf$iv2;
                i8 = i7;
                node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                count$iv$iv3 = type$iv;
                delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                includeSelf$iv2 = includeSelf$iv;
                i7 = i8;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                node = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node4 = node$iv$iv$iv;
                    i9 = 0;
                    i4 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    if (count$iv$iv2 != 0) {
                    } else {
                    }
                    includeSelf$iv = includeSelf$iv2;
                    i8 = i7;
                    next$iv$iv = node4;
                    i6 = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                    includeSelf$iv2 = includeSelf$iv;
                    i7 = i8;
                    count$iv$iv++;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv;
                    includeSelf$iv = includeSelf$iv2;
                    i8 = i7;
                    i6 = 0;
                    $i$f$mutableVectorOf = stack$iv$iv;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node5 = node$iv$iv;
                    if (node5 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node4;
                    count$iv$iv = count$iv$iv2;
                    stack$iv$iv.add(node4);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv = $i$f$mutableVectorOf;
                    stack$iv$iv.add(node5);
                    count$iv$iv2 = count$iv$iv;
                    i4 = 0;
                    i5 = i14;
                    includeSelf$iv = includeSelf$iv2;
                    i8 = i7;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = node4;
                    includeSelf$iv = includeSelf$iv2;
                    i8 = i7;
                    next$iv$iv = node4;
                    i6 = 0;
                    count$iv$iv2 = 1;
                }
                if (count$iv$iv == 1) {
                } else {
                }
                count$iv$iv3 = type$iv;
                delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                includeSelf$iv2 = includeSelf$iv;
                i7 = i8;
                node4 = node$iv$iv$iv;
                i9 = 0;
                i4 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                count$iv$iv2 = 0;
                if (count$iv$iv2 != 0) {
                } else {
                }
                includeSelf$iv = includeSelf$iv2;
                i8 = i7;
                next$iv$iv = node4;
                i6 = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                includeSelf$iv2 = includeSelf$iv;
                i7 = i8;
                count$iv$iv++;
                if (count$iv$iv == 1) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                count$iv$iv2 = count$iv$iv;
                includeSelf$iv = includeSelf$iv2;
                i8 = i7;
                i6 = 0;
                $i$f$mutableVectorOf = stack$iv$iv;
                stack$iv$iv = $i$f$mutableVectorOf;
                node5 = node$iv$iv;
                if (node5 != null && stack$iv$iv != 0) {
                }
                if (stack$iv$iv != 0) {
                } else {
                }
                next$iv$iv = node4;
                count$iv$iv = count$iv$iv2;
                stack$iv$iv.add(node4);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv = $i$f$mutableVectorOf;
                stack$iv$iv.add(node5);
                count$iv$iv2 = count$iv$iv;
                i4 = 0;
                i5 = i14;
                includeSelf$iv = includeSelf$iv2;
                i8 = i7;
                $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv = node4;
                includeSelf$iv = includeSelf$iv2;
                i8 = i7;
                next$iv$iv = node4;
                i6 = 0;
                count$iv$iv2 = 1;
                i10 = 1;
                i10 = 0;
                node3 = node6;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                includeSelf$iv = includeSelf$iv2;
                i8 = i7;
            }
            return null;
        }
        int i19 = count$iv$iv3;
        androidx.compose.ui.node.DelegatableNode delegatableNode3 = delegatableNode;
        int type$iv2 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw illegalStateException;
    }

    public static final <T extends androidx.compose.ui.node.TraversableNode> T findNearestAncestor(T $this$findNearestAncestor) {
        Object nodes$ui_release;
        int capacity$iv$iv$iv$iv;
        Modifier.Node next$iv$iv;
        androidx.compose.ui.node.DelegatableNode count$iv$iv;
        int this_$iv$iv$iv3;
        int count$iv$iv3;
        int constructor-impl;
        boolean this_$iv$iv$iv2;
        int i2;
        Object traverseKey;
        Modifier.Node node$iv$iv;
        androidx.compose.ui.node.LayoutNode layout$iv$iv;
        int node$iv$iv2;
        Modifier.Node head$ui_release;
        int i9;
        int i3;
        Modifier.Node node2;
        int i10;
        int i7;
        int node$iv$iv3;
        androidx.compose.ui.node.DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        int i4;
        int type$iv;
        int i8;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node;
        int i11;
        int this_$iv$iv$iv;
        int i;
        int i5;
        int count$iv$iv2;
        Modifier.Node this_$iv$iv$iv4;
        int i6;
        count$iv$iv = nodes$ui_release;
        int i14 = 0;
        i2 = 0;
        final int i16 = 0;
        final int i17 = constructor-impl;
        final androidx.compose.ui.node.DelegatableNode delegatableNode = count$iv$iv;
        final int i18 = 0;
        if (!delegatableNode.getNode().isAttached()) {
        } else {
            node$iv$iv = delegatableNode.getNode().getParent$ui_release();
            layout$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode);
            while (layout$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= i17 != 0) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                type$iv = constructor-impl;
                i8 = i2;
                node$iv$iv3 = 0;
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                nodes$ui_release = layout$iv$iv.getNodes$ui_release();
                if (layout$iv$iv != null && nodes$ui_release != null) {
                } else {
                }
                node$iv$iv2 = node$iv$iv3;
                node$iv$iv = node$iv$iv2;
                nodes$ui_release = $this$findNearestAncestor;
                count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                constructor-impl = type$iv;
                i2 = i8;
                nodes$ui_release = layout$iv$iv.getNodes$ui_release();
                if (nodes$ui_release != null) {
                } else {
                }
                node$iv$iv2 = nodes$ui_release.getTail$ui_release();
                while (node$iv$iv != null) {
                    if (kindSet$ui_release2 &= i17 == 0) {
                        break loop_4;
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                    type$iv = constructor-impl;
                    i8 = i2;
                    node$iv$iv3 = 0;
                    node$iv$iv = node$iv$iv.getParent$ui_release();
                    nodes$ui_release = $this$findNearestAncestor;
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    constructor-impl = type$iv;
                    i2 = i8;
                    i3 = 0;
                    i10 = 0;
                    i7 = 0;
                    int i19 = 0;
                    node$iv$iv2 = node$iv$iv4;
                    node$iv$iv3 = 0;
                    while (node$iv$iv2 != null) {
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                        type$iv = constructor-impl;
                        this_$iv$iv$iv2 = 0;
                        if (kindSet$ui_release &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv3 = 0;
                        if (this_$iv$iv$iv3 != 0 && node$iv$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        node$iv$iv2 = DelegatableNodeKt.access$pop(i7);
                        nodes$ui_release = $this$findNearestAncestor;
                        count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        constructor-impl = type$iv;
                        i2 = i8;
                        if (node$iv$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        this_$iv$iv$iv3 = 0;
                        traverseKey = 0;
                        node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node = node$iv$iv$iv;
                            i11 = 0;
                            i = 0;
                            if (kindSet$ui_release3 &= type$iv != 0) {
                            } else {
                            }
                            this_$iv$iv$iv = 0;
                            if (this_$iv$iv$iv != 0) {
                            } else {
                            }
                            this_$iv$iv$iv4 = this_$iv$iv$iv2;
                            next$iv$iv = node;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            this_$iv$iv$iv2 = this_$iv$iv$iv4;
                            nodes$ui_release = 1;
                            this_$iv$iv$iv3++;
                            if (this_$iv$iv$iv3 == nodes$ui_release) {
                            } else {
                            }
                            if (i7 == 0) {
                            } else {
                            }
                            count$iv$iv2 = this_$iv$iv$iv3;
                            this_$iv$iv$iv4 = this_$iv$iv$iv2;
                            capacity$iv$iv$iv$iv = 0;
                            count$iv$iv3 = i7;
                            this_$iv$iv$iv2 = node$iv$iv2;
                            if (this_$iv$iv$iv2 != null && count$iv$iv3 != 0) {
                            }
                            if (count$iv$iv3 != 0) {
                            } else {
                            }
                            next$iv$iv = node;
                            i7 = count$iv$iv3;
                            this_$iv$iv$iv3 = count$iv$iv2;
                            count$iv$iv3.add(node);
                            if (count$iv$iv3 != 0) {
                            }
                            node$iv$iv2 = 0;
                            count$iv$iv3.add(this_$iv$iv$iv2);
                            this_$iv$iv$iv = 0;
                            int i13 = 16;
                            i5 = 0;
                            count$iv$iv2 = this_$iv$iv$iv3;
                            this_$iv$iv$iv4 = this_$iv$iv$iv2;
                            i6 = i13;
                            count$iv$iv3 = new MutableVector(new Modifier.Node[i13], 0);
                            node$iv$iv2 = node;
                            this_$iv$iv$iv4 = this_$iv$iv$iv2;
                            next$iv$iv = node;
                            this_$iv$iv$iv = nodes$ui_release;
                        }
                        this_$iv$iv$iv4 = this_$iv$iv$iv2;
                        if (this_$iv$iv$iv3 == 1) {
                        } else {
                        }
                        nodes$ui_release = $this$findNearestAncestor;
                        count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        constructor-impl = type$iv;
                        i2 = i8;
                        node = node$iv$iv$iv;
                        i11 = 0;
                        i = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv4 = this_$iv$iv$iv2;
                        next$iv$iv = node;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        this_$iv$iv$iv2 = this_$iv$iv$iv4;
                        nodes$ui_release = 1;
                        this_$iv$iv$iv3++;
                        if (this_$iv$iv$iv3 == nodes$ui_release) {
                        } else {
                        }
                        if (i7 == 0) {
                        } else {
                        }
                        count$iv$iv2 = this_$iv$iv$iv3;
                        this_$iv$iv$iv4 = this_$iv$iv$iv2;
                        capacity$iv$iv$iv$iv = 0;
                        count$iv$iv3 = i7;
                        this_$iv$iv$iv2 = node$iv$iv2;
                        if (this_$iv$iv$iv2 != null && count$iv$iv3 != 0) {
                        }
                        if (count$iv$iv3 != 0) {
                        } else {
                        }
                        next$iv$iv = node;
                        i7 = count$iv$iv3;
                        this_$iv$iv$iv3 = count$iv$iv2;
                        count$iv$iv3.add(node);
                        if (count$iv$iv3 != 0) {
                        }
                        node$iv$iv2 = 0;
                        count$iv$iv3.add(this_$iv$iv$iv2);
                        this_$iv$iv$iv = 0;
                        i13 = 16;
                        i5 = 0;
                        count$iv$iv2 = this_$iv$iv$iv3;
                        this_$iv$iv$iv4 = this_$iv$iv$iv2;
                        i6 = i13;
                        count$iv$iv3 = new MutableVector(new Modifier.Node[i13], 0);
                        node$iv$iv2 = node;
                        this_$iv$iv$iv4 = this_$iv$iv$iv2;
                        next$iv$iv = node;
                        this_$iv$iv$iv = nodes$ui_release;
                        this_$iv$iv$iv3 = nodes$ui_release;
                        this_$iv$iv$iv3 = node$iv$iv2;
                        i4 = 0;
                        type$iv = constructor-impl;
                        i8 = i2;
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                    type$iv = constructor-impl;
                    i8 = i2;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                    type$iv = constructor-impl;
                    this_$iv$iv$iv2 = 0;
                    if (kindSet$ui_release &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv3 = 0;
                    if (this_$iv$iv$iv3 != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    node$iv$iv2 = DelegatableNodeKt.access$pop(i7);
                    nodes$ui_release = $this$findNearestAncestor;
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    constructor-impl = type$iv;
                    i2 = i8;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv3 = 0;
                    traverseKey = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node = node$iv$iv$iv;
                        i11 = 0;
                        i = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv4 = this_$iv$iv$iv2;
                        next$iv$iv = node;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        this_$iv$iv$iv2 = this_$iv$iv$iv4;
                        nodes$ui_release = 1;
                        this_$iv$iv$iv3++;
                        if (this_$iv$iv$iv3 == nodes$ui_release) {
                        } else {
                        }
                        if (i7 == 0) {
                        } else {
                        }
                        count$iv$iv2 = this_$iv$iv$iv3;
                        this_$iv$iv$iv4 = this_$iv$iv$iv2;
                        capacity$iv$iv$iv$iv = 0;
                        count$iv$iv3 = i7;
                        this_$iv$iv$iv2 = node$iv$iv2;
                        if (this_$iv$iv$iv2 != null && count$iv$iv3 != 0) {
                        }
                        if (count$iv$iv3 != 0) {
                        } else {
                        }
                        next$iv$iv = node;
                        i7 = count$iv$iv3;
                        this_$iv$iv$iv3 = count$iv$iv2;
                        count$iv$iv3.add(node);
                        if (count$iv$iv3 != 0) {
                        }
                        node$iv$iv2 = 0;
                        count$iv$iv3.add(this_$iv$iv$iv2);
                        this_$iv$iv$iv = 0;
                        i13 = 16;
                        i5 = 0;
                        count$iv$iv2 = this_$iv$iv$iv3;
                        this_$iv$iv$iv4 = this_$iv$iv$iv2;
                        i6 = i13;
                        count$iv$iv3 = new MutableVector(new Modifier.Node[i13], 0);
                        node$iv$iv2 = node;
                        this_$iv$iv$iv4 = this_$iv$iv$iv2;
                        next$iv$iv = node;
                        this_$iv$iv$iv = nodes$ui_release;
                    }
                    this_$iv$iv$iv4 = this_$iv$iv$iv2;
                    if (this_$iv$iv$iv3 == 1) {
                    } else {
                    }
                    nodes$ui_release = $this$findNearestAncestor;
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    constructor-impl = type$iv;
                    i2 = i8;
                    node = node$iv$iv$iv;
                    i11 = 0;
                    i = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv4 = this_$iv$iv$iv2;
                    next$iv$iv = node;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv2 = this_$iv$iv$iv4;
                    nodes$ui_release = 1;
                    this_$iv$iv$iv3++;
                    if (this_$iv$iv$iv3 == nodes$ui_release) {
                    } else {
                    }
                    if (i7 == 0) {
                    } else {
                    }
                    count$iv$iv2 = this_$iv$iv$iv3;
                    this_$iv$iv$iv4 = this_$iv$iv$iv2;
                    capacity$iv$iv$iv$iv = 0;
                    count$iv$iv3 = i7;
                    this_$iv$iv$iv2 = node$iv$iv2;
                    if (this_$iv$iv$iv2 != null && count$iv$iv3 != 0) {
                    }
                    if (count$iv$iv3 != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    i7 = count$iv$iv3;
                    this_$iv$iv$iv3 = count$iv$iv2;
                    count$iv$iv3.add(node);
                    if (count$iv$iv3 != 0) {
                    }
                    node$iv$iv2 = 0;
                    count$iv$iv3.add(this_$iv$iv$iv2);
                    this_$iv$iv$iv = 0;
                    i13 = 16;
                    i5 = 0;
                    count$iv$iv2 = this_$iv$iv$iv3;
                    this_$iv$iv$iv4 = this_$iv$iv$iv2;
                    i6 = i13;
                    count$iv$iv3 = new MutableVector(new Modifier.Node[i13], 0);
                    node$iv$iv2 = node;
                    this_$iv$iv$iv4 = this_$iv$iv$iv2;
                    next$iv$iv = node;
                    this_$iv$iv$iv = nodes$ui_release;
                    this_$iv$iv$iv3 = nodes$ui_release;
                    this_$iv$iv$iv3 = node$iv$iv2;
                    i4 = 0;
                    type$iv = constructor-impl;
                    i8 = i2;
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                type$iv = constructor-impl;
                i8 = i2;
                node$iv$iv3 = 0;
                if (kindSet$ui_release2 &= i17 != 0) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                type$iv = constructor-impl;
                i8 = i2;
                node$iv$iv3 = 0;
                node$iv$iv = node$iv$iv.getParent$ui_release();
                nodes$ui_release = $this$findNearestAncestor;
                count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                constructor-impl = type$iv;
                i2 = i8;
                i3 = 0;
                i10 = 0;
                i7 = 0;
                i19 = 0;
                node$iv$iv2 = node$iv$iv4;
                node$iv$iv3 = 0;
                while (node$iv$iv2 != null) {
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                    type$iv = constructor-impl;
                    this_$iv$iv$iv2 = 0;
                    if (kindSet$ui_release &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv3 = 0;
                    if (this_$iv$iv$iv3 != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    node$iv$iv2 = DelegatableNodeKt.access$pop(i7);
                    nodes$ui_release = $this$findNearestAncestor;
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    constructor-impl = type$iv;
                    i2 = i8;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv3 = 0;
                    traverseKey = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node = node$iv$iv$iv;
                        i11 = 0;
                        i = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv4 = this_$iv$iv$iv2;
                        next$iv$iv = node;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        this_$iv$iv$iv2 = this_$iv$iv$iv4;
                        nodes$ui_release = 1;
                        this_$iv$iv$iv3++;
                        if (this_$iv$iv$iv3 == nodes$ui_release) {
                        } else {
                        }
                        if (i7 == 0) {
                        } else {
                        }
                        count$iv$iv2 = this_$iv$iv$iv3;
                        this_$iv$iv$iv4 = this_$iv$iv$iv2;
                        capacity$iv$iv$iv$iv = 0;
                        count$iv$iv3 = i7;
                        this_$iv$iv$iv2 = node$iv$iv2;
                        if (this_$iv$iv$iv2 != null && count$iv$iv3 != 0) {
                        }
                        if (count$iv$iv3 != 0) {
                        } else {
                        }
                        next$iv$iv = node;
                        i7 = count$iv$iv3;
                        this_$iv$iv$iv3 = count$iv$iv2;
                        count$iv$iv3.add(node);
                        if (count$iv$iv3 != 0) {
                        }
                        node$iv$iv2 = 0;
                        count$iv$iv3.add(this_$iv$iv$iv2);
                        this_$iv$iv$iv = 0;
                        i13 = 16;
                        i5 = 0;
                        count$iv$iv2 = this_$iv$iv$iv3;
                        this_$iv$iv$iv4 = this_$iv$iv$iv2;
                        i6 = i13;
                        count$iv$iv3 = new MutableVector(new Modifier.Node[i13], 0);
                        node$iv$iv2 = node;
                        this_$iv$iv$iv4 = this_$iv$iv$iv2;
                        next$iv$iv = node;
                        this_$iv$iv$iv = nodes$ui_release;
                    }
                    this_$iv$iv$iv4 = this_$iv$iv$iv2;
                    if (this_$iv$iv$iv3 == 1) {
                    } else {
                    }
                    nodes$ui_release = $this$findNearestAncestor;
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    constructor-impl = type$iv;
                    i2 = i8;
                    node = node$iv$iv$iv;
                    i11 = 0;
                    i = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv4 = this_$iv$iv$iv2;
                    next$iv$iv = node;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv2 = this_$iv$iv$iv4;
                    nodes$ui_release = 1;
                    this_$iv$iv$iv3++;
                    if (this_$iv$iv$iv3 == nodes$ui_release) {
                    } else {
                    }
                    if (i7 == 0) {
                    } else {
                    }
                    count$iv$iv2 = this_$iv$iv$iv3;
                    this_$iv$iv$iv4 = this_$iv$iv$iv2;
                    capacity$iv$iv$iv$iv = 0;
                    count$iv$iv3 = i7;
                    this_$iv$iv$iv2 = node$iv$iv2;
                    if (this_$iv$iv$iv2 != null && count$iv$iv3 != 0) {
                    }
                    if (count$iv$iv3 != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    i7 = count$iv$iv3;
                    this_$iv$iv$iv3 = count$iv$iv2;
                    count$iv$iv3.add(node);
                    if (count$iv$iv3 != 0) {
                    }
                    node$iv$iv2 = 0;
                    count$iv$iv3.add(this_$iv$iv$iv2);
                    this_$iv$iv$iv = 0;
                    i13 = 16;
                    i5 = 0;
                    count$iv$iv2 = this_$iv$iv$iv3;
                    this_$iv$iv$iv4 = this_$iv$iv$iv2;
                    i6 = i13;
                    count$iv$iv3 = new MutableVector(new Modifier.Node[i13], 0);
                    node$iv$iv2 = node;
                    this_$iv$iv$iv4 = this_$iv$iv$iv2;
                    next$iv$iv = node;
                    this_$iv$iv$iv = nodes$ui_release;
                    this_$iv$iv$iv3 = nodes$ui_release;
                    this_$iv$iv$iv3 = node$iv$iv2;
                    i4 = 0;
                    type$iv = constructor-impl;
                    i8 = i2;
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                type$iv = constructor-impl;
                i8 = i2;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                type$iv = constructor-impl;
                this_$iv$iv$iv2 = 0;
                if (kindSet$ui_release &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv3 = 0;
                if (this_$iv$iv$iv3 != 0 && node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                node$iv$iv2 = DelegatableNodeKt.access$pop(i7);
                nodes$ui_release = $this$findNearestAncestor;
                count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                constructor-impl = type$iv;
                i2 = i8;
                if (node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv3 = 0;
                traverseKey = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node = node$iv$iv$iv;
                    i11 = 0;
                    i = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv4 = this_$iv$iv$iv2;
                    next$iv$iv = node;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv2 = this_$iv$iv$iv4;
                    nodes$ui_release = 1;
                    this_$iv$iv$iv3++;
                    if (this_$iv$iv$iv3 == nodes$ui_release) {
                    } else {
                    }
                    if (i7 == 0) {
                    } else {
                    }
                    count$iv$iv2 = this_$iv$iv$iv3;
                    this_$iv$iv$iv4 = this_$iv$iv$iv2;
                    capacity$iv$iv$iv$iv = 0;
                    count$iv$iv3 = i7;
                    this_$iv$iv$iv2 = node$iv$iv2;
                    if (this_$iv$iv$iv2 != null && count$iv$iv3 != 0) {
                    }
                    if (count$iv$iv3 != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    i7 = count$iv$iv3;
                    this_$iv$iv$iv3 = count$iv$iv2;
                    count$iv$iv3.add(node);
                    if (count$iv$iv3 != 0) {
                    }
                    node$iv$iv2 = 0;
                    count$iv$iv3.add(this_$iv$iv$iv2);
                    this_$iv$iv$iv = 0;
                    i13 = 16;
                    i5 = 0;
                    count$iv$iv2 = this_$iv$iv$iv3;
                    this_$iv$iv$iv4 = this_$iv$iv$iv2;
                    i6 = i13;
                    count$iv$iv3 = new MutableVector(new Modifier.Node[i13], 0);
                    node$iv$iv2 = node;
                    this_$iv$iv$iv4 = this_$iv$iv$iv2;
                    next$iv$iv = node;
                    this_$iv$iv$iv = nodes$ui_release;
                }
                this_$iv$iv$iv4 = this_$iv$iv$iv2;
                if (this_$iv$iv$iv3 == 1) {
                } else {
                }
                nodes$ui_release = $this$findNearestAncestor;
                count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                constructor-impl = type$iv;
                i2 = i8;
                node = node$iv$iv$iv;
                i11 = 0;
                i = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                this_$iv$iv$iv4 = this_$iv$iv$iv2;
                next$iv$iv = node;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                this_$iv$iv$iv2 = this_$iv$iv$iv4;
                nodes$ui_release = 1;
                this_$iv$iv$iv3++;
                if (this_$iv$iv$iv3 == nodes$ui_release) {
                } else {
                }
                if (i7 == 0) {
                } else {
                }
                count$iv$iv2 = this_$iv$iv$iv3;
                this_$iv$iv$iv4 = this_$iv$iv$iv2;
                capacity$iv$iv$iv$iv = 0;
                count$iv$iv3 = i7;
                this_$iv$iv$iv2 = node$iv$iv2;
                if (this_$iv$iv$iv2 != null && count$iv$iv3 != 0) {
                }
                if (count$iv$iv3 != 0) {
                } else {
                }
                next$iv$iv = node;
                i7 = count$iv$iv3;
                this_$iv$iv$iv3 = count$iv$iv2;
                count$iv$iv3.add(node);
                if (count$iv$iv3 != 0) {
                }
                node$iv$iv2 = 0;
                count$iv$iv3.add(this_$iv$iv$iv2);
                this_$iv$iv$iv = 0;
                i13 = 16;
                i5 = 0;
                count$iv$iv2 = this_$iv$iv$iv3;
                this_$iv$iv$iv4 = this_$iv$iv$iv2;
                i6 = i13;
                count$iv$iv3 = new MutableVector(new Modifier.Node[i13], 0);
                node$iv$iv2 = node;
                this_$iv$iv$iv4 = this_$iv$iv$iv2;
                next$iv$iv = node;
                this_$iv$iv$iv = nodes$ui_release;
                this_$iv$iv$iv3 = nodes$ui_release;
                this_$iv$iv$iv3 = node$iv$iv2;
                i4 = 0;
                type$iv = constructor-impl;
                i8 = i2;
            }
            return 0;
        }
        androidx.compose.ui.node.DelegatableNode delegatableNode2 = count$iv$iv;
        int i12 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw illegalStateException;
    }

    public static final void traverseAncestors(androidx.compose.ui.node.DelegatableNode $this$traverseAncestors, Object key, Function1<? super androidx.compose.ui.node.TraversableNode, Boolean> block) {
        int count$iv$iv2;
        int tail$ui_release;
        Modifier.Node count$iv$iv3;
        androidx.compose.ui.node.DelegatableNode delegatableNode;
        int $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        Modifier.Node next$iv$iv;
        int $i$f$mutableVectorOf;
        int i9;
        Object includeSelf$iv;
        int i;
        int i10;
        Modifier.Node node$iv$iv2;
        androidx.compose.ui.node.LayoutNode layout$iv$iv;
        Modifier.Node head$ui_release;
        int i6;
        int i3;
        Modifier.Node node3;
        int i5;
        int stack$iv$iv;
        Modifier.Node node$iv$iv;
        int type$iv;
        int booleanValue;
        int i12;
        androidx.compose.ui.node.DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
        int i11;
        int i13;
        Modifier.Node node2;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node;
        int i4;
        int count$iv$iv;
        int i7;
        int i8;
        int i2;
        int i14 = 0;
        count$iv$iv2 = NodeKind.constructor-impl(262144);
        delegatableNode = $this$traverseAncestors;
        i9 = 0;
        i = 0;
        final int i18 = count$iv$iv2;
        final androidx.compose.ui.node.DelegatableNode delegatableNode2 = delegatableNode;
        final int i19 = 0;
        if (!delegatableNode2.getNode().isAttached()) {
        } else {
            node$iv$iv2 = delegatableNode2.getNode().getParent$ui_release();
            layout$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode2);
            while (layout$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= i18 != 0) {
                } else {
                }
                type$iv = count$iv$iv2;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                i11 = i9;
                i2 = i;
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                count$iv$iv2 = layout$iv$iv.getNodes$ui_release();
                if (layout$iv$iv != null && count$iv$iv2 != null) {
                } else {
                }
                tail$ui_release = 0;
                node$iv$iv2 = tail$ui_release;
                count$iv$iv2 = type$iv;
                delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                i9 = i11;
                i = i2;
                count$iv$iv2 = layout$iv$iv.getNodes$ui_release();
                if (count$iv$iv2 != null) {
                } else {
                }
                tail$ui_release = count$iv$iv2.getTail$ui_release();
                while (node$iv$iv2 != null) {
                    if (kindSet$ui_release &= i18 == 0) {
                        break loop_4;
                    } else {
                    }
                    type$iv = count$iv$iv2;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                    i11 = i9;
                    i2 = i;
                    node$iv$iv2 = node$iv$iv2.getParent$ui_release();
                    count$iv$iv2 = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    i9 = i11;
                    i = i2;
                    i3 = 0;
                    i5 = 0;
                    stack$iv$iv = 0;
                    int i20 = 0;
                    node$iv$iv = node3;
                    while (node$iv$iv != null) {
                        type$iv = count$iv$iv2;
                        includeSelf$iv = key;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                        count$iv$iv3 = node$iv$iv;
                        int i22 = 0;
                        node2 = count$iv$iv3;
                        if (kindSet$ui_release2 &= type$iv != 0) {
                        } else {
                        }
                        i12 = 0;
                        if (i12 != 0 && node$iv$iv instanceof DelegatingNode) {
                        } else {
                        }
                        i2 = i;
                        node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                        count$iv$iv2 = type$iv;
                        delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        i9 = i11;
                        i = i2;
                        if (node$iv$iv instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv3 = 0;
                        node2 = 0;
                        node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node = node$iv$iv$iv;
                            i4 = 0;
                            i7 = 0;
                            if (kindSet$ui_release3 &= type$iv != 0) {
                            } else {
                            }
                            count$iv$iv = 0;
                            if (count$iv$iv != 0) {
                            } else {
                            }
                            i2 = i;
                            next$iv$iv = node;
                            i10 = 0;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            includeSelf$iv = key;
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                            i = i2;
                            count$iv$iv3++;
                            if (count$iv$iv3 == 1) {
                            } else {
                            }
                            if (stack$iv$iv == 0) {
                            } else {
                            }
                            count$iv$iv = count$iv$iv3;
                            i2 = i;
                            i10 = 0;
                            $i$f$mutableVectorOf = stack$iv$iv;
                            stack$iv$iv = $i$f$mutableVectorOf;
                            Modifier.Node node4 = node$iv$iv;
                            if (node4 != null && stack$iv$iv != 0) {
                            }
                            if (stack$iv$iv != 0) {
                            } else {
                            }
                            next$iv$iv = node;
                            count$iv$iv3 = count$iv$iv;
                            stack$iv$iv.add(node);
                            if (stack$iv$iv != 0) {
                            }
                            node$iv$iv = $i$f$mutableVectorOf;
                            stack$iv$iv.add(node4);
                            count$iv$iv = count$iv$iv3;
                            i7 = 0;
                            i8 = i17;
                            i2 = i;
                            $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                            node$iv$iv = node;
                            i2 = i;
                            next$iv$iv = node;
                            i10 = 0;
                            count$iv$iv = 1;
                        }
                        if (count$iv$iv3 == 1) {
                        } else {
                        }
                        count$iv$iv2 = type$iv;
                        delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        i9 = i11;
                        i = i2;
                        node = node$iv$iv$iv;
                        i4 = 0;
                        i7 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        count$iv$iv = 0;
                        if (count$iv$iv != 0) {
                        } else {
                        }
                        i2 = i;
                        next$iv$iv = node;
                        i10 = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        includeSelf$iv = key;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                        i = i2;
                        count$iv$iv3++;
                        if (count$iv$iv3 == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv = count$iv$iv3;
                        i2 = i;
                        i10 = 0;
                        $i$f$mutableVectorOf = stack$iv$iv;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node4 = node$iv$iv;
                        if (node4 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node;
                        count$iv$iv3 = count$iv$iv;
                        stack$iv$iv.add(node);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv = $i$f$mutableVectorOf;
                        stack$iv$iv.add(node4);
                        count$iv$iv = count$iv$iv3;
                        i7 = 0;
                        i8 = i17;
                        i2 = i;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv = node;
                        i2 = i;
                        next$iv$iv = node;
                        i10 = 0;
                        count$iv$iv = 1;
                        i12 = 1;
                        count$iv$iv3 = node$iv$iv;
                        i12 = 0;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                        i11 = i9;
                        if (Intrinsics.areEqual(key, (TraversableNode)count$iv$iv3.getTraverseKey())) {
                        } else {
                        }
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                        booleanValue = 1;
                        i2 = i;
                        booleanValue = (Boolean)block.invoke(count$iv$iv3).booleanValue();
                    }
                    type$iv = count$iv$iv2;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                    i11 = i9;
                    i2 = i;
                    type$iv = count$iv$iv2;
                    includeSelf$iv = key;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                    count$iv$iv3 = node$iv$iv;
                    i22 = 0;
                    node2 = count$iv$iv3;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    i12 = 0;
                    if (i12 != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    i2 = i;
                    node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                    count$iv$iv2 = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    i9 = i11;
                    i = i2;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv3 = 0;
                    node2 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node = node$iv$iv$iv;
                        i4 = 0;
                        i7 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        count$iv$iv = 0;
                        if (count$iv$iv != 0) {
                        } else {
                        }
                        i2 = i;
                        next$iv$iv = node;
                        i10 = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        includeSelf$iv = key;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                        i = i2;
                        count$iv$iv3++;
                        if (count$iv$iv3 == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv = count$iv$iv3;
                        i2 = i;
                        i10 = 0;
                        $i$f$mutableVectorOf = stack$iv$iv;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node4 = node$iv$iv;
                        if (node4 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node;
                        count$iv$iv3 = count$iv$iv;
                        stack$iv$iv.add(node);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv = $i$f$mutableVectorOf;
                        stack$iv$iv.add(node4);
                        count$iv$iv = count$iv$iv3;
                        i7 = 0;
                        i8 = i17;
                        i2 = i;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv = node;
                        i2 = i;
                        next$iv$iv = node;
                        i10 = 0;
                        count$iv$iv = 1;
                    }
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    count$iv$iv2 = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    i9 = i11;
                    i = i2;
                    node = node$iv$iv$iv;
                    i4 = 0;
                    i7 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    count$iv$iv = 0;
                    if (count$iv$iv != 0) {
                    } else {
                    }
                    i2 = i;
                    next$iv$iv = node;
                    i10 = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    includeSelf$iv = key;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                    i = i2;
                    count$iv$iv3++;
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv3;
                    i2 = i;
                    i10 = 0;
                    $i$f$mutableVectorOf = stack$iv$iv;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node4 = node$iv$iv;
                    if (node4 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    count$iv$iv3 = count$iv$iv;
                    stack$iv$iv.add(node);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv = $i$f$mutableVectorOf;
                    stack$iv$iv.add(node4);
                    count$iv$iv = count$iv$iv3;
                    i7 = 0;
                    i8 = i17;
                    i2 = i;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = node;
                    i2 = i;
                    next$iv$iv = node;
                    i10 = 0;
                    count$iv$iv = 1;
                    i12 = 1;
                    count$iv$iv3 = node$iv$iv;
                    i12 = 0;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                    i11 = i9;
                    if (Intrinsics.areEqual(key, (TraversableNode)count$iv$iv3.getTraverseKey())) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                    booleanValue = 1;
                    i2 = i;
                    booleanValue = (Boolean)block.invoke(count$iv$iv3).booleanValue();
                }
                type$iv = count$iv$iv2;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                i11 = i9;
                i2 = i;
                if (kindSet$ui_release &= i18 != 0) {
                } else {
                }
                type$iv = count$iv$iv2;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                i11 = i9;
                i2 = i;
                node$iv$iv2 = node$iv$iv2.getParent$ui_release();
                count$iv$iv2 = type$iv;
                delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                i9 = i11;
                i = i2;
                i3 = 0;
                i5 = 0;
                stack$iv$iv = 0;
                i20 = 0;
                node$iv$iv = node3;
                while (node$iv$iv != null) {
                    type$iv = count$iv$iv2;
                    includeSelf$iv = key;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                    count$iv$iv3 = node$iv$iv;
                    i22 = 0;
                    node2 = count$iv$iv3;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    i12 = 0;
                    if (i12 != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    i2 = i;
                    node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                    count$iv$iv2 = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    i9 = i11;
                    i = i2;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv3 = 0;
                    node2 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node = node$iv$iv$iv;
                        i4 = 0;
                        i7 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        count$iv$iv = 0;
                        if (count$iv$iv != 0) {
                        } else {
                        }
                        i2 = i;
                        next$iv$iv = node;
                        i10 = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        includeSelf$iv = key;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                        i = i2;
                        count$iv$iv3++;
                        if (count$iv$iv3 == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv = count$iv$iv3;
                        i2 = i;
                        i10 = 0;
                        $i$f$mutableVectorOf = stack$iv$iv;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node4 = node$iv$iv;
                        if (node4 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node;
                        count$iv$iv3 = count$iv$iv;
                        stack$iv$iv.add(node);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv = $i$f$mutableVectorOf;
                        stack$iv$iv.add(node4);
                        count$iv$iv = count$iv$iv3;
                        i7 = 0;
                        i8 = i17;
                        i2 = i;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv = node;
                        i2 = i;
                        next$iv$iv = node;
                        i10 = 0;
                        count$iv$iv = 1;
                    }
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    count$iv$iv2 = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    i9 = i11;
                    i = i2;
                    node = node$iv$iv$iv;
                    i4 = 0;
                    i7 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    count$iv$iv = 0;
                    if (count$iv$iv != 0) {
                    } else {
                    }
                    i2 = i;
                    next$iv$iv = node;
                    i10 = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    includeSelf$iv = key;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                    i = i2;
                    count$iv$iv3++;
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv3;
                    i2 = i;
                    i10 = 0;
                    $i$f$mutableVectorOf = stack$iv$iv;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node4 = node$iv$iv;
                    if (node4 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    count$iv$iv3 = count$iv$iv;
                    stack$iv$iv.add(node);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv = $i$f$mutableVectorOf;
                    stack$iv$iv.add(node4);
                    count$iv$iv = count$iv$iv3;
                    i7 = 0;
                    i8 = i17;
                    i2 = i;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = node;
                    i2 = i;
                    next$iv$iv = node;
                    i10 = 0;
                    count$iv$iv = 1;
                    i12 = 1;
                    count$iv$iv3 = node$iv$iv;
                    i12 = 0;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                    i11 = i9;
                    if (Intrinsics.areEqual(key, (TraversableNode)count$iv$iv3.getTraverseKey())) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                    booleanValue = 1;
                    i2 = i;
                    booleanValue = (Boolean)block.invoke(count$iv$iv3).booleanValue();
                }
                type$iv = count$iv$iv2;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                i11 = i9;
                i2 = i;
                type$iv = count$iv$iv2;
                includeSelf$iv = key;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                count$iv$iv3 = node$iv$iv;
                i22 = 0;
                node2 = count$iv$iv3;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                i12 = 0;
                if (i12 != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                i2 = i;
                node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                count$iv$iv2 = type$iv;
                delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                i9 = i11;
                i = i2;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv3 = 0;
                node2 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node = node$iv$iv$iv;
                    i4 = 0;
                    i7 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    count$iv$iv = 0;
                    if (count$iv$iv != 0) {
                    } else {
                    }
                    i2 = i;
                    next$iv$iv = node;
                    i10 = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    includeSelf$iv = key;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                    i = i2;
                    count$iv$iv3++;
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv3;
                    i2 = i;
                    i10 = 0;
                    $i$f$mutableVectorOf = stack$iv$iv;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node4 = node$iv$iv;
                    if (node4 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    count$iv$iv3 = count$iv$iv;
                    stack$iv$iv.add(node);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv = $i$f$mutableVectorOf;
                    stack$iv$iv.add(node4);
                    count$iv$iv = count$iv$iv3;
                    i7 = 0;
                    i8 = i17;
                    i2 = i;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = node;
                    i2 = i;
                    next$iv$iv = node;
                    i10 = 0;
                    count$iv$iv = 1;
                }
                if (count$iv$iv3 == 1) {
                } else {
                }
                count$iv$iv2 = type$iv;
                delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                i9 = i11;
                i = i2;
                node = node$iv$iv$iv;
                i4 = 0;
                i7 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                count$iv$iv = 0;
                if (count$iv$iv != 0) {
                } else {
                }
                i2 = i;
                next$iv$iv = node;
                i10 = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                includeSelf$iv = key;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                i = i2;
                count$iv$iv3++;
                if (count$iv$iv3 == 1) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                count$iv$iv = count$iv$iv3;
                i2 = i;
                i10 = 0;
                $i$f$mutableVectorOf = stack$iv$iv;
                stack$iv$iv = $i$f$mutableVectorOf;
                node4 = node$iv$iv;
                if (node4 != null && stack$iv$iv != 0) {
                }
                if (stack$iv$iv != 0) {
                } else {
                }
                next$iv$iv = node;
                count$iv$iv3 = count$iv$iv;
                stack$iv$iv.add(node);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv = $i$f$mutableVectorOf;
                stack$iv$iv.add(node4);
                count$iv$iv = count$iv$iv3;
                i7 = 0;
                i8 = i17;
                i2 = i;
                $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv = node;
                i2 = i;
                next$iv$iv = node;
                i10 = 0;
                count$iv$iv = 1;
                i12 = 1;
                count$iv$iv3 = node$iv$iv;
                i12 = 0;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                i11 = i9;
                if (Intrinsics.areEqual(key, (TraversableNode)count$iv$iv3.getTraverseKey())) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                booleanValue = 1;
                i2 = i;
                booleanValue = (Boolean)block.invoke(count$iv$iv3).booleanValue();
            }
        }
        int i21 = count$iv$iv2;
        androidx.compose.ui.node.DelegatableNode delegatableNode3 = delegatableNode;
        int type$iv2 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw illegalStateException;
    }

    public static final <T extends androidx.compose.ui.node.TraversableNode> void traverseAncestors(T $this$traverseAncestors, Function1<? super T, Boolean> block) {
        Object next$iv$iv;
        int capacity$iv$iv$iv$iv;
        int tail$ui_release;
        androidx.compose.ui.node.DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
        int node$iv$iv;
        int count$iv$iv;
        int this_$iv$iv$iv;
        Modifier.Node node$iv$iv3;
        int i3;
        boolean objectsOfSameType;
        Object includeSelf$iv2;
        Object includeSelf$iv;
        Object includeSelf$iv4;
        int i7;
        Object booleanValue;
        Modifier.Node node$iv$iv2;
        androidx.compose.ui.node.LayoutNode layout$iv$iv;
        Modifier.Node head$ui_release;
        int i8;
        int i6;
        Modifier.Node node2;
        int i4;
        int stack$iv$iv;
        Modifier.Node $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        int type$iv;
        boolean z;
        int i5;
        int includeSelf$iv3;
        int i11;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node;
        int i12;
        int this_$iv$iv$iv2;
        int i10;
        int i2;
        Modifier.Node node$iv$iv4;
        int i9;
        int i;
        Modifier.Node node3;
        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = next$iv$iv;
        int i16 = 0;
        i3 = 0;
        i7 = 0;
        final int i18 = count$iv$iv;
        final androidx.compose.ui.node.DelegatableNode delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
        final int i19 = 0;
        if (!delegatableNode.getNode().isAttached()) {
        } else {
            node$iv$iv2 = delegatableNode.getNode().getParent$ui_release();
            layout$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode);
            while (layout$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= i18 != 0) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                type$iv = count$iv$iv;
                includeSelf$iv3 = i3;
                i11 = i7;
                includeSelf$iv4 = block;
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                next$iv$iv = layout$iv$iv.getNodes$ui_release();
                if (layout$iv$iv != null && next$iv$iv != null) {
                } else {
                }
                tail$ui_release = 0;
                node$iv$iv2 = tail$ui_release;
                next$iv$iv = $this$traverseAncestors;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                count$iv$iv = type$iv;
                i3 = includeSelf$iv3;
                i7 = i11;
                next$iv$iv = layout$iv$iv.getNodes$ui_release();
                if (next$iv$iv != null) {
                } else {
                }
                tail$ui_release = next$iv$iv.getTail$ui_release();
                while (node$iv$iv2 != null) {
                    if (kindSet$ui_release &= i18 == 0) {
                        break loop_4;
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    type$iv = count$iv$iv;
                    includeSelf$iv3 = i3;
                    i11 = i7;
                    includeSelf$iv = block;
                    node$iv$iv2 = node$iv$iv2.getParent$ui_release();
                    next$iv$iv = $this$traverseAncestors;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    count$iv$iv = type$iv;
                    i3 = includeSelf$iv3;
                    i7 = i11;
                    i6 = 0;
                    i4 = 0;
                    stack$iv$iv = 0;
                    int i20 = 0;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node3;
                    while ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 != null) {
                        type$iv = count$iv$iv;
                        includeSelf$iv2 = block;
                        booleanValue = 0;
                        if (kindSet$ui_release2 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0 && $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                        next$iv$iv = $this$traverseAncestors;
                        count$iv$iv = type$iv;
                        i3 = includeSelf$iv3;
                        i7 = i11;
                        if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        i5 = 0;
                        node$iv$iv$iv = (DelegatingNode)$this$visitAncestors_u2dY_u2dYKmho_u24default$iv2.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node = node$iv$iv$iv;
                            i12 = 0;
                            i10 = 0;
                            if (kindSet$ui_release3 &= type$iv != 0) {
                            } else {
                            }
                            this_$iv$iv$iv2 = 0;
                            if (this_$iv$iv$iv2 != 0) {
                            } else {
                            }
                            node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                            next$iv$iv = node;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            this_$iv$iv$iv++;
                            if (this_$iv$iv$iv == 1) {
                            } else {
                            }
                            if (stack$iv$iv == 0) {
                            } else {
                            }
                            node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                            i9 = this_$iv$iv$iv;
                            capacity$iv$iv$iv$iv = 0;
                            node$iv$iv = stack$iv$iv;
                            stack$iv$iv = node$iv$iv;
                            Modifier.Node node4 = node$iv$iv4;
                            if (node4 != null) {
                            } else {
                            }
                            node$iv$iv3 = node$iv$iv4;
                            if (stack$iv$iv != 0) {
                            } else {
                            }
                            next$iv$iv = node;
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node$iv$iv3;
                            this_$iv$iv$iv = i9;
                            stack$iv$iv.add(node);
                            if (stack$iv$iv != 0) {
                            }
                            node$iv$iv3 = 0;
                            stack$iv$iv.add(node4);
                            i10 = i15;
                            int $i$f$mutableVectorOf = 16;
                            i2 = 0;
                            node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                            i9 = this_$iv$iv$iv;
                            i = $i$f$mutableVectorOf;
                            node$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node;
                            next$iv$iv = node;
                            this_$iv$iv$iv2 = 1;
                        }
                        node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        if (this_$iv$iv$iv == 1) {
                        } else {
                        }
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node$iv$iv4;
                        next$iv$iv = $this$traverseAncestors;
                        count$iv$iv = type$iv;
                        i3 = includeSelf$iv3;
                        i7 = i11;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node$iv$iv4;
                        node = node$iv$iv$iv;
                        i12 = 0;
                        i10 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        next$iv$iv = node;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        this_$iv$iv$iv++;
                        if (this_$iv$iv$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        i9 = this_$iv$iv$iv;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv = stack$iv$iv;
                        stack$iv$iv = node$iv$iv;
                        node4 = node$iv$iv4;
                        if (node4 != null) {
                        } else {
                        }
                        node$iv$iv3 = node$iv$iv4;
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node$iv$iv3;
                        this_$iv$iv$iv = i9;
                        stack$iv$iv.add(node);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv3 = 0;
                        stack$iv$iv.add(node4);
                        i10 = i15;
                        $i$f$mutableVectorOf = 16;
                        i2 = 0;
                        node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        i9 = this_$iv$iv$iv;
                        i = $i$f$mutableVectorOf;
                        node$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node;
                        next$iv$iv = node;
                        this_$iv$iv$iv2 = 1;
                        this_$iv$iv$iv = 1;
                        this_$iv$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        i5 = 0;
                        includeSelf$iv3 = i3;
                        i11 = i7;
                        if (Intrinsics.areEqual(next$iv$iv.getTraverseKey(), (TraversableNode)this_$iv$iv$iv.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(next$iv$iv, this_$iv$iv$iv)) {
                        } else {
                        }
                        includeSelf$iv2 = block;
                        z = 1;
                        if (Actual_jvmKt.areObjectsOfSameType(next$iv$iv, this_$iv$iv$iv)) {
                        } else {
                        }
                        z = booleanValue;
                    }
                    type$iv = count$iv$iv;
                    includeSelf$iv3 = i3;
                    i11 = i7;
                    includeSelf$iv = block;
                    type$iv = count$iv$iv;
                    includeSelf$iv2 = block;
                    booleanValue = 0;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0 && $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                    next$iv$iv = $this$traverseAncestors;
                    count$iv$iv = type$iv;
                    i3 = includeSelf$iv3;
                    i7 = i11;
                    if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    i5 = 0;
                    node$iv$iv$iv = (DelegatingNode)$this$visitAncestors_u2dY_u2dYKmho_u24default$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node = node$iv$iv$iv;
                        i12 = 0;
                        i10 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        next$iv$iv = node;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        this_$iv$iv$iv++;
                        if (this_$iv$iv$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        i9 = this_$iv$iv$iv;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv = stack$iv$iv;
                        stack$iv$iv = node$iv$iv;
                        node4 = node$iv$iv4;
                        if (node4 != null) {
                        } else {
                        }
                        node$iv$iv3 = node$iv$iv4;
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node$iv$iv3;
                        this_$iv$iv$iv = i9;
                        stack$iv$iv.add(node);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv3 = 0;
                        stack$iv$iv.add(node4);
                        i10 = i15;
                        $i$f$mutableVectorOf = 16;
                        i2 = 0;
                        node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        i9 = this_$iv$iv$iv;
                        i = $i$f$mutableVectorOf;
                        node$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node;
                        next$iv$iv = node;
                        this_$iv$iv$iv2 = 1;
                    }
                    node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    if (this_$iv$iv$iv == 1) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node$iv$iv4;
                    next$iv$iv = $this$traverseAncestors;
                    count$iv$iv = type$iv;
                    i3 = includeSelf$iv3;
                    i7 = i11;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node$iv$iv4;
                    node = node$iv$iv$iv;
                    i12 = 0;
                    i10 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    next$iv$iv = node;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv++;
                    if (this_$iv$iv$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    i9 = this_$iv$iv$iv;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv = stack$iv$iv;
                    stack$iv$iv = node$iv$iv;
                    node4 = node$iv$iv4;
                    if (node4 != null) {
                    } else {
                    }
                    node$iv$iv3 = node$iv$iv4;
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node$iv$iv3;
                    this_$iv$iv$iv = i9;
                    stack$iv$iv.add(node);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv3 = 0;
                    stack$iv$iv.add(node4);
                    i10 = i15;
                    $i$f$mutableVectorOf = 16;
                    i2 = 0;
                    node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    i9 = this_$iv$iv$iv;
                    i = $i$f$mutableVectorOf;
                    node$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node;
                    next$iv$iv = node;
                    this_$iv$iv$iv2 = 1;
                    this_$iv$iv$iv = 1;
                    this_$iv$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    i5 = 0;
                    includeSelf$iv3 = i3;
                    i11 = i7;
                    if (Intrinsics.areEqual(next$iv$iv.getTraverseKey(), (TraversableNode)this_$iv$iv$iv.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(next$iv$iv, this_$iv$iv$iv)) {
                    } else {
                    }
                    includeSelf$iv2 = block;
                    z = 1;
                    if (Actual_jvmKt.areObjectsOfSameType(next$iv$iv, this_$iv$iv$iv)) {
                    } else {
                    }
                    z = booleanValue;
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                type$iv = count$iv$iv;
                includeSelf$iv3 = i3;
                i11 = i7;
                includeSelf$iv4 = block;
                if (kindSet$ui_release &= i18 != 0) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                type$iv = count$iv$iv;
                includeSelf$iv3 = i3;
                i11 = i7;
                includeSelf$iv = block;
                node$iv$iv2 = node$iv$iv2.getParent$ui_release();
                next$iv$iv = $this$traverseAncestors;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                count$iv$iv = type$iv;
                i3 = includeSelf$iv3;
                i7 = i11;
                i6 = 0;
                i4 = 0;
                stack$iv$iv = 0;
                i20 = 0;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node3;
                while ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 != null) {
                    type$iv = count$iv$iv;
                    includeSelf$iv2 = block;
                    booleanValue = 0;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0 && $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                    next$iv$iv = $this$traverseAncestors;
                    count$iv$iv = type$iv;
                    i3 = includeSelf$iv3;
                    i7 = i11;
                    if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    i5 = 0;
                    node$iv$iv$iv = (DelegatingNode)$this$visitAncestors_u2dY_u2dYKmho_u24default$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node = node$iv$iv$iv;
                        i12 = 0;
                        i10 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        next$iv$iv = node;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        this_$iv$iv$iv++;
                        if (this_$iv$iv$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        i9 = this_$iv$iv$iv;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv = stack$iv$iv;
                        stack$iv$iv = node$iv$iv;
                        node4 = node$iv$iv4;
                        if (node4 != null) {
                        } else {
                        }
                        node$iv$iv3 = node$iv$iv4;
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node$iv$iv3;
                        this_$iv$iv$iv = i9;
                        stack$iv$iv.add(node);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv3 = 0;
                        stack$iv$iv.add(node4);
                        i10 = i15;
                        $i$f$mutableVectorOf = 16;
                        i2 = 0;
                        node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        i9 = this_$iv$iv$iv;
                        i = $i$f$mutableVectorOf;
                        node$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node;
                        next$iv$iv = node;
                        this_$iv$iv$iv2 = 1;
                    }
                    node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    if (this_$iv$iv$iv == 1) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node$iv$iv4;
                    next$iv$iv = $this$traverseAncestors;
                    count$iv$iv = type$iv;
                    i3 = includeSelf$iv3;
                    i7 = i11;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node$iv$iv4;
                    node = node$iv$iv$iv;
                    i12 = 0;
                    i10 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    next$iv$iv = node;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv++;
                    if (this_$iv$iv$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    i9 = this_$iv$iv$iv;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv = stack$iv$iv;
                    stack$iv$iv = node$iv$iv;
                    node4 = node$iv$iv4;
                    if (node4 != null) {
                    } else {
                    }
                    node$iv$iv3 = node$iv$iv4;
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node$iv$iv3;
                    this_$iv$iv$iv = i9;
                    stack$iv$iv.add(node);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv3 = 0;
                    stack$iv$iv.add(node4);
                    i10 = i15;
                    $i$f$mutableVectorOf = 16;
                    i2 = 0;
                    node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    i9 = this_$iv$iv$iv;
                    i = $i$f$mutableVectorOf;
                    node$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node;
                    next$iv$iv = node;
                    this_$iv$iv$iv2 = 1;
                    this_$iv$iv$iv = 1;
                    this_$iv$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    i5 = 0;
                    includeSelf$iv3 = i3;
                    i11 = i7;
                    if (Intrinsics.areEqual(next$iv$iv.getTraverseKey(), (TraversableNode)this_$iv$iv$iv.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(next$iv$iv, this_$iv$iv$iv)) {
                    } else {
                    }
                    includeSelf$iv2 = block;
                    z = 1;
                    if (Actual_jvmKt.areObjectsOfSameType(next$iv$iv, this_$iv$iv$iv)) {
                    } else {
                    }
                    z = booleanValue;
                }
                type$iv = count$iv$iv;
                includeSelf$iv3 = i3;
                i11 = i7;
                includeSelf$iv = block;
                type$iv = count$iv$iv;
                includeSelf$iv2 = block;
                booleanValue = 0;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0 && $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 instanceof DelegatingNode) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                next$iv$iv = $this$traverseAncestors;
                count$iv$iv = type$iv;
                i3 = includeSelf$iv3;
                i7 = i11;
                if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv = 0;
                i5 = 0;
                node$iv$iv$iv = (DelegatingNode)$this$visitAncestors_u2dY_u2dYKmho_u24default$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node = node$iv$iv$iv;
                    i12 = 0;
                    i10 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    next$iv$iv = node;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv++;
                    if (this_$iv$iv$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    i9 = this_$iv$iv$iv;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv = stack$iv$iv;
                    stack$iv$iv = node$iv$iv;
                    node4 = node$iv$iv4;
                    if (node4 != null) {
                    } else {
                    }
                    node$iv$iv3 = node$iv$iv4;
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node$iv$iv3;
                    this_$iv$iv$iv = i9;
                    stack$iv$iv.add(node);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv3 = 0;
                    stack$iv$iv.add(node4);
                    i10 = i15;
                    $i$f$mutableVectorOf = 16;
                    i2 = 0;
                    node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    i9 = this_$iv$iv$iv;
                    i = $i$f$mutableVectorOf;
                    node$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node;
                    next$iv$iv = node;
                    this_$iv$iv$iv2 = 1;
                }
                node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                if (this_$iv$iv$iv == 1) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node$iv$iv4;
                next$iv$iv = $this$traverseAncestors;
                count$iv$iv = type$iv;
                i3 = includeSelf$iv3;
                i7 = i11;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node$iv$iv4;
                node = node$iv$iv$iv;
                i12 = 0;
                i10 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                next$iv$iv = node;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                this_$iv$iv$iv++;
                if (this_$iv$iv$iv == 1) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                i9 = this_$iv$iv$iv;
                capacity$iv$iv$iv$iv = 0;
                node$iv$iv = stack$iv$iv;
                stack$iv$iv = node$iv$iv;
                node4 = node$iv$iv4;
                if (node4 != null) {
                } else {
                }
                node$iv$iv3 = node$iv$iv4;
                if (stack$iv$iv != 0) {
                } else {
                }
                next$iv$iv = node;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node$iv$iv3;
                this_$iv$iv$iv = i9;
                stack$iv$iv.add(node);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv3 = 0;
                stack$iv$iv.add(node4);
                i10 = i15;
                $i$f$mutableVectorOf = 16;
                i2 = 0;
                node$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                i9 = this_$iv$iv$iv;
                i = $i$f$mutableVectorOf;
                node$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = node;
                next$iv$iv = node;
                this_$iv$iv$iv2 = 1;
                this_$iv$iv$iv = 1;
                this_$iv$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                i5 = 0;
                includeSelf$iv3 = i3;
                i11 = i7;
                if (Intrinsics.areEqual(next$iv$iv.getTraverseKey(), (TraversableNode)this_$iv$iv$iv.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(next$iv$iv, this_$iv$iv$iv)) {
                } else {
                }
                includeSelf$iv2 = block;
                z = 1;
                if (Actual_jvmKt.areObjectsOfSameType(next$iv$iv, this_$iv$iv$iv)) {
                } else {
                }
                z = booleanValue;
            }
        }
        androidx.compose.ui.node.DelegatableNode delegatableNode2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
        int i13 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw illegalStateException;
    }

    public static final void traverseChildren(androidx.compose.ui.node.DelegatableNode $this$traverseChildren, Object key, Function1<? super androidx.compose.ui.node.TraversableNode, Boolean> block) {
        int constructor-impl;
        int i8;
        Object obj;
        Object type$iv2;
        Modifier.Node next$iv$iv;
        int capacity$iv$iv$iv$iv;
        Object obj2;
        Object $this$visitChildren_u2d6rFNWt0$iv;
        int arr2;
        int node2;
        int node$iv$iv3;
        Modifier.Node[] arr;
        int i;
        Modifier.Node[] node$iv$iv;
        int count$iv$iv2;
        Modifier.Node[] count$iv$iv;
        int i6;
        Modifier.Node[] objArr;
        int i10;
        int i3;
        Modifier.Node[] node$iv$iv2;
        int i2;
        int type$iv;
        Object obj5;
        int booleanValue;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node;
        int i9;
        int this_$iv$iv$iv;
        int i4;
        int i5;
        int i7;
        int i11 = 0;
        constructor-impl = NodeKind.constructor-impl(262144);
        obj2 = $this$traverseChildren;
        arr2 = 0;
        final int i15 = constructor-impl;
        final Object obj3 = obj2;
        final int i16 = 0;
        if (!obj3.getNode().isAttached()) {
        } else {
            int i17 = 0;
            node$iv$iv3 = 0;
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = obj3.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, obj3.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                int i18 = 0;
                count$iv$iv2 = 1;
                node2 = mutableVector2.removeAt(size -= count$iv$iv2);
                if (aggregateChildKindSet$ui_release &= i15 == 0) {
                } else {
                }
                node$iv$iv3 = node2;
                while (node$iv$iv3 != 0) {
                    obj5 = obj2;
                    i5 = arr2;
                    int type$iv4 = count$iv$iv2;
                    node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                    constructor-impl = type$iv;
                    i = 0;
                }
                type$iv = constructor-impl;
                obj5 = obj2;
                i5 = arr2;
                i = 0;
                if (kindSet$ui_release &= i15 != null) {
                } else {
                }
                obj5 = obj2;
                i5 = arr2;
                type$iv4 = count$iv$iv2;
                node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                constructor-impl = type$iv;
                i = 0;
                i6 = 0;
                i10 = 0;
                i3 = 0;
                int i19 = 0;
                node$iv$iv = node$iv$iv2;
                while (node$iv$iv != null) {
                    type$iv = constructor-impl;
                    $this$visitChildren_u2d6rFNWt0$iv = key;
                    type$iv2 = block;
                    i2 = 0;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    count$iv$iv = 0;
                    if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    i5 = arr2;
                    i8 = 1;
                    node$iv$iv = DelegatableNodeKt.access$pop(i3);
                    count$iv$iv2 = i8;
                    constructor-impl = type$iv;
                    obj2 = obj5;
                    arr2 = i5;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    booleanValue = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node = node$iv$iv$iv;
                        i9 = 0;
                        i4 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        i5 = arr2;
                        next$iv$iv = node;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $this$visitChildren_u2d6rFNWt0$iv = key;
                        type$iv2 = block;
                        arr2 = i5;
                        if (count$iv$iv++ == 1) {
                        } else {
                        }
                        if (i3 == 0) {
                        } else {
                        }
                        i5 = arr2;
                        capacity$iv$iv$iv$iv = 0;
                        $this$visitChildren_u2d6rFNWt0$iv = i3;
                        arr2 = node$iv$iv;
                        if (arr2 != null && $this$visitChildren_u2d6rFNWt0$iv != 0) {
                        }
                        if ($this$visitChildren_u2d6rFNWt0$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node;
                        i3 = $this$visitChildren_u2d6rFNWt0$iv;
                        $this$visitChildren_u2d6rFNWt0$iv.add(node);
                        if ($this$visitChildren_u2d6rFNWt0$iv != 0) {
                        }
                        node$iv$iv = 0;
                        $this$visitChildren_u2d6rFNWt0$iv.add(arr2);
                        this_$iv$iv$iv = i13;
                        int $i$f$mutableVectorOf = 16;
                        i4 = 0;
                        i5 = arr2;
                        i7 = $i$f$mutableVectorOf;
                        $this$visitChildren_u2d6rFNWt0$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv = node;
                        i5 = arr2;
                        next$iv$iv = node;
                        this_$iv$iv$iv = 1;
                    }
                    i8 = 1;
                    if (count$iv$iv == i8) {
                    } else {
                    }
                    count$iv$iv2 = i8;
                    constructor-impl = type$iv;
                    obj2 = obj5;
                    arr2 = i5;
                    node = node$iv$iv$iv;
                    i9 = 0;
                    i4 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    i5 = arr2;
                    next$iv$iv = node;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitChildren_u2d6rFNWt0$iv = key;
                    type$iv2 = block;
                    arr2 = i5;
                    if (count$iv$iv++ == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    i5 = arr2;
                    capacity$iv$iv$iv$iv = 0;
                    $this$visitChildren_u2d6rFNWt0$iv = i3;
                    arr2 = node$iv$iv;
                    if (arr2 != null && $this$visitChildren_u2d6rFNWt0$iv != 0) {
                    }
                    if ($this$visitChildren_u2d6rFNWt0$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    i3 = $this$visitChildren_u2d6rFNWt0$iv;
                    $this$visitChildren_u2d6rFNWt0$iv.add(node);
                    if ($this$visitChildren_u2d6rFNWt0$iv != 0) {
                    }
                    node$iv$iv = 0;
                    $this$visitChildren_u2d6rFNWt0$iv.add(arr2);
                    this_$iv$iv$iv = i13;
                    $i$f$mutableVectorOf = 16;
                    i4 = 0;
                    i5 = arr2;
                    i7 = $i$f$mutableVectorOf;
                    $this$visitChildren_u2d6rFNWt0$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv = node;
                    i5 = arr2;
                    next$iv$iv = node;
                    this_$iv$iv$iv = 1;
                    count$iv$iv = 1;
                    count$iv$iv = node$iv$iv;
                    i2 = 0;
                    type$iv = constructor-impl;
                    obj5 = obj2;
                    if (Intrinsics.areEqual(key, (TraversableNode)count$iv$iv.getTraverseKey())) {
                    } else {
                    }
                    obj = block;
                    booleanValue = 1;
                    i5 = arr2;
                    i8 = 1;
                    booleanValue = (Boolean)block.invoke(count$iv$iv).booleanValue();
                }
                type$iv = constructor-impl;
                obj5 = obj2;
                i5 = arr2;
                i = 0;
                type$iv = constructor-impl;
                $this$visitChildren_u2d6rFNWt0$iv = key;
                type$iv2 = block;
                i2 = 0;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                count$iv$iv = 0;
                if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                i5 = arr2;
                i8 = 1;
                node$iv$iv = DelegatableNodeKt.access$pop(i3);
                count$iv$iv2 = i8;
                constructor-impl = type$iv;
                obj2 = obj5;
                arr2 = i5;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                booleanValue = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node = node$iv$iv$iv;
                    i9 = 0;
                    i4 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    i5 = arr2;
                    next$iv$iv = node;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitChildren_u2d6rFNWt0$iv = key;
                    type$iv2 = block;
                    arr2 = i5;
                    if (count$iv$iv++ == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    i5 = arr2;
                    capacity$iv$iv$iv$iv = 0;
                    $this$visitChildren_u2d6rFNWt0$iv = i3;
                    arr2 = node$iv$iv;
                    if (arr2 != null && $this$visitChildren_u2d6rFNWt0$iv != 0) {
                    }
                    if ($this$visitChildren_u2d6rFNWt0$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    i3 = $this$visitChildren_u2d6rFNWt0$iv;
                    $this$visitChildren_u2d6rFNWt0$iv.add(node);
                    if ($this$visitChildren_u2d6rFNWt0$iv != 0) {
                    }
                    node$iv$iv = 0;
                    $this$visitChildren_u2d6rFNWt0$iv.add(arr2);
                    this_$iv$iv$iv = i13;
                    $i$f$mutableVectorOf = 16;
                    i4 = 0;
                    i5 = arr2;
                    i7 = $i$f$mutableVectorOf;
                    $this$visitChildren_u2d6rFNWt0$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv = node;
                    i5 = arr2;
                    next$iv$iv = node;
                    this_$iv$iv$iv = 1;
                }
                i8 = 1;
                if (count$iv$iv == i8) {
                } else {
                }
                count$iv$iv2 = i8;
                constructor-impl = type$iv;
                obj2 = obj5;
                arr2 = i5;
                node = node$iv$iv$iv;
                i9 = 0;
                i4 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                i5 = arr2;
                next$iv$iv = node;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $this$visitChildren_u2d6rFNWt0$iv = key;
                type$iv2 = block;
                arr2 = i5;
                if (count$iv$iv++ == 1) {
                } else {
                }
                if (i3 == 0) {
                } else {
                }
                i5 = arr2;
                capacity$iv$iv$iv$iv = 0;
                $this$visitChildren_u2d6rFNWt0$iv = i3;
                arr2 = node$iv$iv;
                if (arr2 != null && $this$visitChildren_u2d6rFNWt0$iv != 0) {
                }
                if ($this$visitChildren_u2d6rFNWt0$iv != 0) {
                } else {
                }
                next$iv$iv = node;
                i3 = $this$visitChildren_u2d6rFNWt0$iv;
                $this$visitChildren_u2d6rFNWt0$iv.add(node);
                if ($this$visitChildren_u2d6rFNWt0$iv != 0) {
                }
                node$iv$iv = 0;
                $this$visitChildren_u2d6rFNWt0$iv.add(arr2);
                this_$iv$iv$iv = i13;
                $i$f$mutableVectorOf = 16;
                i4 = 0;
                i5 = arr2;
                i7 = $i$f$mutableVectorOf;
                $this$visitChildren_u2d6rFNWt0$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv = node;
                i5 = arr2;
                next$iv$iv = node;
                this_$iv$iv$iv = 1;
                count$iv$iv = 1;
                count$iv$iv = node$iv$iv;
                i2 = 0;
                type$iv = constructor-impl;
                obj5 = obj2;
                if (Intrinsics.areEqual(key, (TraversableNode)count$iv$iv.getTraverseKey())) {
                } else {
                }
                obj = block;
                booleanValue = 1;
                i5 = arr2;
                i8 = 1;
                booleanValue = (Boolean)block.invoke(count$iv$iv).booleanValue();
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node2);
            }
        }
        int i20 = constructor-impl;
        Object obj4 = obj2;
        int type$iv3 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw illegalStateException;
    }

    public static final <T extends androidx.compose.ui.node.TraversableNode> void traverseChildren(T $this$traverseChildren, Function1<? super T, Boolean> block) {
        Object obj2;
        int i10;
        int capacity$iv$iv$iv$iv;
        Modifier.Node next$iv$iv;
        Object obj;
        MutableVector $this$visitChildren_u2d6rFNWt0$iv;
        boolean objectsOfSameType;
        int count$iv$iv2;
        int this_$iv$iv$iv2;
        int node2;
        int node$iv$iv3;
        Modifier.Node[] arr;
        int i;
        Modifier.Node[] node$iv$iv;
        int i6;
        Modifier.Node[] objArr2;
        int i2;
        Modifier.Node[] objArr;
        int i8;
        int i7;
        Modifier.Node[] node$iv$iv2;
        int i11;
        Object $this$visitChildren_u2d6rFNWt0$iv2;
        int i4;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node;
        int i9;
        int this_$iv$iv$iv;
        int i3;
        int count$iv$iv;
        int i5;
        obj = obj2;
        int i16 = 0;
        int i18 = 0;
        final int i19 = count$iv$iv2;
        final Object obj3 = obj;
        final int i20 = 0;
        if (!obj3.getNode().isAttached()) {
        } else {
            int i21 = 0;
            node$iv$iv3 = 0;
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = obj3.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, obj3.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                int i22 = 0;
                i6 = 1;
                node2 = mutableVector2.removeAt(size -= i6);
                if (aggregateChildKindSet$ui_release &= i19 == 0) {
                } else {
                }
                node$iv$iv3 = node2;
                while (node$iv$iv3 != 0) {
                    $this$visitChildren_u2d6rFNWt0$iv2 = obj;
                    i4 = count$iv$iv2;
                    int i12 = i6;
                    node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                    i = 0;
                    obj2 = $this$traverseChildren;
                }
                $this$visitChildren_u2d6rFNWt0$iv2 = obj;
                i4 = count$iv$iv2;
                obj2 = $this$traverseChildren;
                i = 0;
                if (kindSet$ui_release &= i19 != null) {
                } else {
                }
                $this$visitChildren_u2d6rFNWt0$iv2 = obj;
                i4 = count$iv$iv2;
                i12 = i6;
                node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                i = 0;
                obj2 = $this$traverseChildren;
                i2 = 0;
                i8 = 0;
                i7 = 0;
                int i23 = 0;
                node$iv$iv = node$iv$iv2;
                while (node$iv$iv != null) {
                    i4 = count$iv$iv2;
                    $this$visitChildren_u2d6rFNWt0$iv = block;
                    objArr2 = 0;
                    if (kindSet$ui_release2 &= i4 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    i10 = 1;
                    node$iv$iv = DelegatableNodeKt.access$pop(i7);
                    i6 = i10;
                    obj = $this$visitChildren_u2d6rFNWt0$iv2;
                    count$iv$iv2 = i4;
                    obj2 = $this$traverseChildren;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    i11 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node = node$iv$iv$iv;
                        i9 = 0;
                        i3 = 0;
                        if (kindSet$ui_release3 &= i4 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        obj2 = $this$traverseChildren;
                        $this$visitChildren_u2d6rFNWt0$iv = block;
                        this_$iv$iv$iv2++;
                        if (this_$iv$iv$iv2 == 1) {
                        } else {
                        }
                        if (i7 == 0) {
                        } else {
                        }
                        count$iv$iv = this_$iv$iv$iv2;
                        capacity$iv$iv$iv$iv = 0;
                        $this$visitChildren_u2d6rFNWt0$iv = i7;
                        Modifier.Node[] objArr3 = node$iv$iv;
                        if (objArr3 != null && $this$visitChildren_u2d6rFNWt0$iv != null) {
                        }
                        if ($this$visitChildren_u2d6rFNWt0$iv != null) {
                        } else {
                        }
                        next$iv$iv = node;
                        i7 = $this$visitChildren_u2d6rFNWt0$iv;
                        this_$iv$iv$iv2 = count$iv$iv;
                        $this$visitChildren_u2d6rFNWt0$iv.add(node);
                        if ($this$visitChildren_u2d6rFNWt0$iv != null) {
                        }
                        node$iv$iv = 0;
                        $this$visitChildren_u2d6rFNWt0$iv.add(objArr3);
                        this_$iv$iv$iv = i14;
                        int $i$f$mutableVectorOf = 16;
                        i3 = 0;
                        count$iv$iv = this_$iv$iv$iv2;
                        i5 = $i$f$mutableVectorOf;
                        $this$visitChildren_u2d6rFNWt0$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv = node;
                        next$iv$iv = node;
                        this_$iv$iv$iv = 1;
                    }
                    i10 = 1;
                    if (this_$iv$iv$iv2 == i10) {
                    } else {
                    }
                    i6 = i10;
                    obj = $this$visitChildren_u2d6rFNWt0$iv2;
                    count$iv$iv2 = i4;
                    obj2 = $this$traverseChildren;
                    node = node$iv$iv$iv;
                    i9 = 0;
                    i3 = 0;
                    if (kindSet$ui_release3 &= i4 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    obj2 = $this$traverseChildren;
                    $this$visitChildren_u2d6rFNWt0$iv = block;
                    this_$iv$iv$iv2++;
                    if (this_$iv$iv$iv2 == 1) {
                    } else {
                    }
                    if (i7 == 0) {
                    } else {
                    }
                    count$iv$iv = this_$iv$iv$iv2;
                    capacity$iv$iv$iv$iv = 0;
                    $this$visitChildren_u2d6rFNWt0$iv = i7;
                    objArr3 = node$iv$iv;
                    if (objArr3 != null && $this$visitChildren_u2d6rFNWt0$iv != null) {
                    }
                    if ($this$visitChildren_u2d6rFNWt0$iv != null) {
                    } else {
                    }
                    next$iv$iv = node;
                    i7 = $this$visitChildren_u2d6rFNWt0$iv;
                    this_$iv$iv$iv2 = count$iv$iv;
                    $this$visitChildren_u2d6rFNWt0$iv.add(node);
                    if ($this$visitChildren_u2d6rFNWt0$iv != null) {
                    }
                    node$iv$iv = 0;
                    $this$visitChildren_u2d6rFNWt0$iv.add(objArr3);
                    this_$iv$iv$iv = i14;
                    $i$f$mutableVectorOf = 16;
                    i3 = 0;
                    count$iv$iv = this_$iv$iv$iv2;
                    i5 = $i$f$mutableVectorOf;
                    $this$visitChildren_u2d6rFNWt0$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv = node;
                    next$iv$iv = node;
                    this_$iv$iv$iv = 1;
                    this_$iv$iv$iv2 = 1;
                    objArr2 = node$iv$iv;
                    i11 = 0;
                    $this$visitChildren_u2d6rFNWt0$iv2 = obj;
                    i4 = count$iv$iv2;
                    if (Intrinsics.areEqual(obj2.getTraverseKey(), (TraversableNode)objArr2.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(obj2, objArr2)) {
                    } else {
                    }
                    $this$visitChildren_u2d6rFNWt0$iv = block;
                    this_$iv$iv$iv2 = 1;
                    i10 = 1;
                    if (Actual_jvmKt.areObjectsOfSameType(obj2, objArr2)) {
                    } else {
                    }
                    this_$iv$iv$iv2 = (Boolean)block.invoke(objArr2).booleanValue();
                }
                $this$visitChildren_u2d6rFNWt0$iv2 = obj;
                i4 = count$iv$iv2;
                obj2 = $this$traverseChildren;
                i = 0;
                i4 = count$iv$iv2;
                $this$visitChildren_u2d6rFNWt0$iv = block;
                objArr2 = 0;
                if (kindSet$ui_release2 &= i4 != 0) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                if (this_$iv$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                i10 = 1;
                node$iv$iv = DelegatableNodeKt.access$pop(i7);
                i6 = i10;
                obj = $this$visitChildren_u2d6rFNWt0$iv2;
                count$iv$iv2 = i4;
                obj2 = $this$traverseChildren;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                i11 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node = node$iv$iv$iv;
                    i9 = 0;
                    i3 = 0;
                    if (kindSet$ui_release3 &= i4 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    obj2 = $this$traverseChildren;
                    $this$visitChildren_u2d6rFNWt0$iv = block;
                    this_$iv$iv$iv2++;
                    if (this_$iv$iv$iv2 == 1) {
                    } else {
                    }
                    if (i7 == 0) {
                    } else {
                    }
                    count$iv$iv = this_$iv$iv$iv2;
                    capacity$iv$iv$iv$iv = 0;
                    $this$visitChildren_u2d6rFNWt0$iv = i7;
                    objArr3 = node$iv$iv;
                    if (objArr3 != null && $this$visitChildren_u2d6rFNWt0$iv != null) {
                    }
                    if ($this$visitChildren_u2d6rFNWt0$iv != null) {
                    } else {
                    }
                    next$iv$iv = node;
                    i7 = $this$visitChildren_u2d6rFNWt0$iv;
                    this_$iv$iv$iv2 = count$iv$iv;
                    $this$visitChildren_u2d6rFNWt0$iv.add(node);
                    if ($this$visitChildren_u2d6rFNWt0$iv != null) {
                    }
                    node$iv$iv = 0;
                    $this$visitChildren_u2d6rFNWt0$iv.add(objArr3);
                    this_$iv$iv$iv = i14;
                    $i$f$mutableVectorOf = 16;
                    i3 = 0;
                    count$iv$iv = this_$iv$iv$iv2;
                    i5 = $i$f$mutableVectorOf;
                    $this$visitChildren_u2d6rFNWt0$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv = node;
                    next$iv$iv = node;
                    this_$iv$iv$iv = 1;
                }
                i10 = 1;
                if (this_$iv$iv$iv2 == i10) {
                } else {
                }
                i6 = i10;
                obj = $this$visitChildren_u2d6rFNWt0$iv2;
                count$iv$iv2 = i4;
                obj2 = $this$traverseChildren;
                node = node$iv$iv$iv;
                i9 = 0;
                i3 = 0;
                if (kindSet$ui_release3 &= i4 != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                next$iv$iv = node;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                obj2 = $this$traverseChildren;
                $this$visitChildren_u2d6rFNWt0$iv = block;
                this_$iv$iv$iv2++;
                if (this_$iv$iv$iv2 == 1) {
                } else {
                }
                if (i7 == 0) {
                } else {
                }
                count$iv$iv = this_$iv$iv$iv2;
                capacity$iv$iv$iv$iv = 0;
                $this$visitChildren_u2d6rFNWt0$iv = i7;
                objArr3 = node$iv$iv;
                if (objArr3 != null && $this$visitChildren_u2d6rFNWt0$iv != null) {
                }
                if ($this$visitChildren_u2d6rFNWt0$iv != null) {
                } else {
                }
                next$iv$iv = node;
                i7 = $this$visitChildren_u2d6rFNWt0$iv;
                this_$iv$iv$iv2 = count$iv$iv;
                $this$visitChildren_u2d6rFNWt0$iv.add(node);
                if ($this$visitChildren_u2d6rFNWt0$iv != null) {
                }
                node$iv$iv = 0;
                $this$visitChildren_u2d6rFNWt0$iv.add(objArr3);
                this_$iv$iv$iv = i14;
                $i$f$mutableVectorOf = 16;
                i3 = 0;
                count$iv$iv = this_$iv$iv$iv2;
                i5 = $i$f$mutableVectorOf;
                $this$visitChildren_u2d6rFNWt0$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv = node;
                next$iv$iv = node;
                this_$iv$iv$iv = 1;
                this_$iv$iv$iv2 = 1;
                objArr2 = node$iv$iv;
                i11 = 0;
                $this$visitChildren_u2d6rFNWt0$iv2 = obj;
                i4 = count$iv$iv2;
                if (Intrinsics.areEqual(obj2.getTraverseKey(), (TraversableNode)objArr2.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(obj2, objArr2)) {
                } else {
                }
                $this$visitChildren_u2d6rFNWt0$iv = block;
                this_$iv$iv$iv2 = 1;
                i10 = 1;
                if (Actual_jvmKt.areObjectsOfSameType(obj2, objArr2)) {
                } else {
                }
                this_$iv$iv$iv2 = (Boolean)block.invoke(objArr2).booleanValue();
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node2);
            }
        }
        Object obj4 = obj;
        int i15 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw illegalStateException;
    }

    public static final void traverseDescendants(androidx.compose.ui.node.DelegatableNode $this$traverseDescendants, Object key, Function1<? super androidx.compose.ui.node.TraversableNode, ? extends androidx.compose.ui.node.TraversableNode.Companion.TraverseDescendantsAction> block) {
        int this_$iv$iv$iv5;
        Object obj5;
        Object this_$iv$iv$iv2;
        int this_$iv$iv$iv4;
        Object obj6;
        int $this$visitSubtreeIf_u2d6rFNWt0$iv;
        int arr;
        Modifier.Node next$iv$iv;
        int i;
        int mask$iv$iv3;
        int mask$iv$iv4;
        int mask$iv$iv5;
        int mask$iv$iv2;
        int node;
        String str;
        int i10;
        Modifier.Node[] node$iv$iv2;
        int node$iv$iv;
        Object obj3;
        int i8;
        Object obj;
        int i9;
        int i6;
        int i5;
        int node$iv$iv$iv;
        int type$iv;
        int i7;
        Object obj8;
        int i2;
        Object obj2;
        Object continueTraversal;
        androidx.compose.ui.node.TraversableNode.Companion.TraverseDescendantsAction this_$iv$iv$iv3;
        int this_$iv$iv$iv;
        int count$iv$iv;
        int i4;
        int i3;
        int mask$iv$iv;
        int i11 = 0;
        arr = 0;
        i = this_$iv$iv$iv5;
        final Object obj7 = obj5;
        final int i15 = 0;
        int i16 = 0;
        if (!obj7.getNode().isAttached()) {
            int i18 = 0;
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        int value$iv$iv$iv = 0;
        i10 = 0;
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = obj7.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, obj7.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            node = mutableVector.removeAt(size -= i10);
            if (aggregateChildKindSet$ui_release &= i != 0) {
            } else {
            }
            type$iv = this_$iv$iv$iv5;
            obj8 = obj5;
            i2 = arr;
            mask$iv$iv = i;
            mask$iv$iv3 = node$iv$iv;
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node);
            node$iv$iv = mask$iv$iv3;
            this_$iv$iv$iv5 = type$iv;
            obj5 = obj8;
            arr = i2;
            i = mask$iv$iv;
            node$iv$iv2 = node;
            while (node$iv$iv2 != null) {
                if (kindSet$ui_release2 &= i == 0) {
                    break loop_8;
                } else {
                }
                type$iv = this_$iv$iv$iv5;
                obj8 = obj5;
                i2 = arr;
                mask$iv$iv = i;
                $this$visitSubtreeIf_u2d6rFNWt0$iv = i10;
                mask$iv$iv2 = node$iv$iv;
                node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                i10 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                node$iv$iv = mask$iv$iv2;
                this_$iv$iv$iv5 = type$iv;
                obj5 = obj8;
                arr = i2;
                i = mask$iv$iv;
                i8 = 0;
                i9 = 0;
                i6 = 0;
                int i19 = 0;
                node$iv$iv = node$iv$iv3;
                while (node$iv$iv != null) {
                    type$iv = this_$iv$iv$iv5;
                    arr = key;
                    int i13 = 0;
                    if (kindSet$ui_release &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv5 = 0;
                    if (this_$iv$iv$iv5 != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv$iv = i;
                    this_$iv$iv$iv4 = 1;
                    mask$iv$iv5 = 0;
                    node$iv$iv = DelegatableNodeKt.access$pop(i6);
                    i10 = this_$iv$iv$iv4;
                    this_$iv$iv$iv5 = type$iv;
                    obj5 = obj8;
                    arr = i2;
                    i = mask$iv$iv;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv5 = 0;
                    i10 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        i7 = node$iv$iv$iv;
                        obj2 = 0;
                        count$iv$iv = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv3 = this_$iv$iv$iv2;
                        mask$iv$iv = i;
                        next$iv$iv = i7;
                        mask$iv$iv4 = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        arr = key;
                        this_$iv$iv$iv2 = this_$iv$iv$iv3;
                        i = mask$iv$iv;
                        this_$iv$iv$iv5++;
                        this_$iv$iv$iv3 = this_$iv$iv$iv2;
                        if (this_$iv$iv$iv5 == 1) {
                        } else {
                        }
                        if (i6 == 0) {
                        } else {
                        }
                        count$iv$iv = this_$iv$iv$iv5;
                        mask$iv$iv = i;
                        mask$iv$iv4 = 0;
                        this_$iv$iv$iv2 = i6;
                        Object obj4 = node$iv$iv;
                        if (obj4 != null && this_$iv$iv$iv2 != 0) {
                        }
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv = i7;
                        i6 = this_$iv$iv$iv2;
                        this_$iv$iv$iv5 = count$iv$iv;
                        this_$iv$iv$iv2.add(i7);
                        if (this_$iv$iv$iv2 != 0) {
                        }
                        node$iv$iv = arr;
                        this_$iv$iv$iv2.add(obj4);
                        count$iv$iv = this_$iv$iv$iv5;
                        i4 = 0;
                        i3 = i14;
                        mask$iv$iv = i;
                        this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv = i7;
                        mask$iv$iv = i;
                        next$iv$iv = i7;
                        mask$iv$iv4 = 0;
                        this_$iv$iv$iv = 1;
                    }
                    this_$iv$iv$iv3 = this_$iv$iv$iv2;
                    mask$iv$iv5 = 0;
                    this_$iv$iv$iv4 = 1;
                    if (this_$iv$iv$iv5 == this_$iv$iv$iv4) {
                    } else {
                    }
                    i10 = this_$iv$iv$iv4;
                    this_$iv$iv$iv5 = type$iv;
                    obj5 = obj8;
                    arr = i2;
                    i = mask$iv$iv;
                    i7 = node$iv$iv$iv;
                    obj2 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv3 = this_$iv$iv$iv2;
                    mask$iv$iv = i;
                    next$iv$iv = i7;
                    mask$iv$iv4 = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    arr = key;
                    this_$iv$iv$iv2 = this_$iv$iv$iv3;
                    i = mask$iv$iv;
                    this_$iv$iv$iv5++;
                    this_$iv$iv$iv3 = this_$iv$iv$iv2;
                    if (this_$iv$iv$iv5 == 1) {
                    } else {
                    }
                    if (i6 == 0) {
                    } else {
                    }
                    count$iv$iv = this_$iv$iv$iv5;
                    mask$iv$iv = i;
                    mask$iv$iv4 = 0;
                    this_$iv$iv$iv2 = i6;
                    obj4 = node$iv$iv;
                    if (obj4 != null && this_$iv$iv$iv2 != 0) {
                    }
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv = i7;
                    i6 = this_$iv$iv$iv2;
                    this_$iv$iv$iv5 = count$iv$iv;
                    this_$iv$iv$iv2.add(i7);
                    if (this_$iv$iv$iv2 != 0) {
                    }
                    node$iv$iv = arr;
                    this_$iv$iv$iv2.add(obj4);
                    count$iv$iv = this_$iv$iv$iv5;
                    i4 = 0;
                    i3 = i14;
                    mask$iv$iv = i;
                    this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = i7;
                    mask$iv$iv = i;
                    next$iv$iv = i7;
                    mask$iv$iv4 = 0;
                    this_$iv$iv$iv = 1;
                    this_$iv$iv$iv5 = 1;
                    node$iv$iv$iv = 0;
                    type$iv = this_$iv$iv$iv5;
                    Object type$iv3 = i10;
                    i7 = 0;
                    obj8 = obj5;
                    i2 = arr;
                    if (Intrinsics.areEqual(key, (TraversableNode)type$iv3.getTraverseKey())) {
                    } else {
                    }
                    obj6 = block;
                    continueTraversal = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                    obj2 = type$iv3;
                    androidx.compose.ui.node.TraversableNode.Companion.TraverseDescendantsAction traverseDescendantsAction = this_$iv$iv$iv3;
                    if (traverseDescendantsAction != TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                    } else {
                    }
                    this_$iv$iv$iv5 = 0;
                    mask$iv$iv = i;
                    this_$iv$iv$iv4 = 1;
                    mask$iv$iv5 = 0;
                    this_$iv$iv$iv5 = 1;
                    continueTraversal = block.invoke(type$iv3);
                }
                type$iv = this_$iv$iv$iv5;
                obj8 = obj5;
                i2 = arr;
                mask$iv$iv = i;
                mask$iv$iv2 = 0;
                i5 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                type$iv = this_$iv$iv$iv5;
                arr = key;
                i13 = 0;
                if (kindSet$ui_release &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv5 = 0;
                if (this_$iv$iv$iv5 != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                mask$iv$iv = i;
                this_$iv$iv$iv4 = 1;
                mask$iv$iv5 = 0;
                node$iv$iv = DelegatableNodeKt.access$pop(i6);
                i10 = this_$iv$iv$iv4;
                this_$iv$iv$iv5 = type$iv;
                obj5 = obj8;
                arr = i2;
                i = mask$iv$iv;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv5 = 0;
                i10 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    i7 = node$iv$iv$iv;
                    obj2 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv3 = this_$iv$iv$iv2;
                    mask$iv$iv = i;
                    next$iv$iv = i7;
                    mask$iv$iv4 = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    arr = key;
                    this_$iv$iv$iv2 = this_$iv$iv$iv3;
                    i = mask$iv$iv;
                    this_$iv$iv$iv5++;
                    this_$iv$iv$iv3 = this_$iv$iv$iv2;
                    if (this_$iv$iv$iv5 == 1) {
                    } else {
                    }
                    if (i6 == 0) {
                    } else {
                    }
                    count$iv$iv = this_$iv$iv$iv5;
                    mask$iv$iv = i;
                    mask$iv$iv4 = 0;
                    this_$iv$iv$iv2 = i6;
                    obj4 = node$iv$iv;
                    if (obj4 != null && this_$iv$iv$iv2 != 0) {
                    }
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv = i7;
                    i6 = this_$iv$iv$iv2;
                    this_$iv$iv$iv5 = count$iv$iv;
                    this_$iv$iv$iv2.add(i7);
                    if (this_$iv$iv$iv2 != 0) {
                    }
                    node$iv$iv = arr;
                    this_$iv$iv$iv2.add(obj4);
                    count$iv$iv = this_$iv$iv$iv5;
                    i4 = 0;
                    i3 = i14;
                    mask$iv$iv = i;
                    this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = i7;
                    mask$iv$iv = i;
                    next$iv$iv = i7;
                    mask$iv$iv4 = 0;
                    this_$iv$iv$iv = 1;
                }
                this_$iv$iv$iv3 = this_$iv$iv$iv2;
                mask$iv$iv5 = 0;
                this_$iv$iv$iv4 = 1;
                if (this_$iv$iv$iv5 == this_$iv$iv$iv4) {
                } else {
                }
                i10 = this_$iv$iv$iv4;
                this_$iv$iv$iv5 = type$iv;
                obj5 = obj8;
                arr = i2;
                i = mask$iv$iv;
                i7 = node$iv$iv$iv;
                obj2 = 0;
                count$iv$iv = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                this_$iv$iv$iv3 = this_$iv$iv$iv2;
                mask$iv$iv = i;
                next$iv$iv = i7;
                mask$iv$iv4 = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                arr = key;
                this_$iv$iv$iv2 = this_$iv$iv$iv3;
                i = mask$iv$iv;
                this_$iv$iv$iv5++;
                this_$iv$iv$iv3 = this_$iv$iv$iv2;
                if (this_$iv$iv$iv5 == 1) {
                } else {
                }
                if (i6 == 0) {
                } else {
                }
                count$iv$iv = this_$iv$iv$iv5;
                mask$iv$iv = i;
                mask$iv$iv4 = 0;
                this_$iv$iv$iv2 = i6;
                obj4 = node$iv$iv;
                if (obj4 != null && this_$iv$iv$iv2 != 0) {
                }
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                next$iv$iv = i7;
                i6 = this_$iv$iv$iv2;
                this_$iv$iv$iv5 = count$iv$iv;
                this_$iv$iv$iv2.add(i7);
                if (this_$iv$iv$iv2 != 0) {
                }
                node$iv$iv = arr;
                this_$iv$iv$iv2.add(obj4);
                count$iv$iv = this_$iv$iv$iv5;
                i4 = 0;
                i3 = i14;
                mask$iv$iv = i;
                this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv = i7;
                mask$iv$iv = i;
                next$iv$iv = i7;
                mask$iv$iv4 = 0;
                this_$iv$iv$iv = 1;
                this_$iv$iv$iv5 = 1;
                node$iv$iv$iv = 0;
                type$iv = this_$iv$iv$iv5;
                type$iv3 = i10;
                i7 = 0;
                obj8 = obj5;
                i2 = arr;
                if (Intrinsics.areEqual(key, (TraversableNode)type$iv3.getTraverseKey())) {
                } else {
                }
                obj6 = block;
                continueTraversal = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                obj2 = type$iv3;
                traverseDescendantsAction = this_$iv$iv$iv3;
                if (traverseDescendantsAction != TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                } else {
                }
                this_$iv$iv$iv5 = 0;
                mask$iv$iv = i;
                this_$iv$iv$iv4 = 1;
                mask$iv$iv5 = 0;
                mask$iv$iv = i;
                $this$visitSubtreeIf_u2d6rFNWt0$iv = 1;
                mask$iv$iv2 = 0;
                i5 = 0;
                this_$iv$iv$iv5 = 1;
                continueTraversal = block.invoke(type$iv3);
            }
            type$iv = this_$iv$iv$iv5;
            obj8 = obj5;
            i2 = arr;
            mask$iv$iv = i;
            mask$iv$iv3 = node$iv$iv;
            if (kindSet$ui_release2 &= i != 0) {
            } else {
            }
            type$iv = this_$iv$iv$iv5;
            obj8 = obj5;
            i2 = arr;
            mask$iv$iv = i;
            $this$visitSubtreeIf_u2d6rFNWt0$iv = i10;
            mask$iv$iv2 = node$iv$iv;
            node$iv$iv2 = node$iv$iv2.getChild$ui_release();
            i10 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            node$iv$iv = mask$iv$iv2;
            this_$iv$iv$iv5 = type$iv;
            obj5 = obj8;
            arr = i2;
            i = mask$iv$iv;
            i8 = 0;
            i9 = 0;
            i6 = 0;
            i19 = 0;
            node$iv$iv = node$iv$iv3;
            while (node$iv$iv != null) {
                type$iv = this_$iv$iv$iv5;
                arr = key;
                i13 = 0;
                if (kindSet$ui_release &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv5 = 0;
                if (this_$iv$iv$iv5 != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                mask$iv$iv = i;
                this_$iv$iv$iv4 = 1;
                mask$iv$iv5 = 0;
                node$iv$iv = DelegatableNodeKt.access$pop(i6);
                i10 = this_$iv$iv$iv4;
                this_$iv$iv$iv5 = type$iv;
                obj5 = obj8;
                arr = i2;
                i = mask$iv$iv;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv5 = 0;
                i10 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    i7 = node$iv$iv$iv;
                    obj2 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv3 = this_$iv$iv$iv2;
                    mask$iv$iv = i;
                    next$iv$iv = i7;
                    mask$iv$iv4 = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    arr = key;
                    this_$iv$iv$iv2 = this_$iv$iv$iv3;
                    i = mask$iv$iv;
                    this_$iv$iv$iv5++;
                    this_$iv$iv$iv3 = this_$iv$iv$iv2;
                    if (this_$iv$iv$iv5 == 1) {
                    } else {
                    }
                    if (i6 == 0) {
                    } else {
                    }
                    count$iv$iv = this_$iv$iv$iv5;
                    mask$iv$iv = i;
                    mask$iv$iv4 = 0;
                    this_$iv$iv$iv2 = i6;
                    obj4 = node$iv$iv;
                    if (obj4 != null && this_$iv$iv$iv2 != 0) {
                    }
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv = i7;
                    i6 = this_$iv$iv$iv2;
                    this_$iv$iv$iv5 = count$iv$iv;
                    this_$iv$iv$iv2.add(i7);
                    if (this_$iv$iv$iv2 != 0) {
                    }
                    node$iv$iv = arr;
                    this_$iv$iv$iv2.add(obj4);
                    count$iv$iv = this_$iv$iv$iv5;
                    i4 = 0;
                    i3 = i14;
                    mask$iv$iv = i;
                    this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = i7;
                    mask$iv$iv = i;
                    next$iv$iv = i7;
                    mask$iv$iv4 = 0;
                    this_$iv$iv$iv = 1;
                }
                this_$iv$iv$iv3 = this_$iv$iv$iv2;
                mask$iv$iv5 = 0;
                this_$iv$iv$iv4 = 1;
                if (this_$iv$iv$iv5 == this_$iv$iv$iv4) {
                } else {
                }
                i10 = this_$iv$iv$iv4;
                this_$iv$iv$iv5 = type$iv;
                obj5 = obj8;
                arr = i2;
                i = mask$iv$iv;
                i7 = node$iv$iv$iv;
                obj2 = 0;
                count$iv$iv = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                this_$iv$iv$iv3 = this_$iv$iv$iv2;
                mask$iv$iv = i;
                next$iv$iv = i7;
                mask$iv$iv4 = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                arr = key;
                this_$iv$iv$iv2 = this_$iv$iv$iv3;
                i = mask$iv$iv;
                this_$iv$iv$iv5++;
                this_$iv$iv$iv3 = this_$iv$iv$iv2;
                if (this_$iv$iv$iv5 == 1) {
                } else {
                }
                if (i6 == 0) {
                } else {
                }
                count$iv$iv = this_$iv$iv$iv5;
                mask$iv$iv = i;
                mask$iv$iv4 = 0;
                this_$iv$iv$iv2 = i6;
                obj4 = node$iv$iv;
                if (obj4 != null && this_$iv$iv$iv2 != 0) {
                }
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                next$iv$iv = i7;
                i6 = this_$iv$iv$iv2;
                this_$iv$iv$iv5 = count$iv$iv;
                this_$iv$iv$iv2.add(i7);
                if (this_$iv$iv$iv2 != 0) {
                }
                node$iv$iv = arr;
                this_$iv$iv$iv2.add(obj4);
                count$iv$iv = this_$iv$iv$iv5;
                i4 = 0;
                i3 = i14;
                mask$iv$iv = i;
                this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv = i7;
                mask$iv$iv = i;
                next$iv$iv = i7;
                mask$iv$iv4 = 0;
                this_$iv$iv$iv = 1;
                this_$iv$iv$iv5 = 1;
                node$iv$iv$iv = 0;
                type$iv = this_$iv$iv$iv5;
                type$iv3 = i10;
                i7 = 0;
                obj8 = obj5;
                i2 = arr;
                if (Intrinsics.areEqual(key, (TraversableNode)type$iv3.getTraverseKey())) {
                } else {
                }
                obj6 = block;
                continueTraversal = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                obj2 = type$iv3;
                traverseDescendantsAction = this_$iv$iv$iv3;
                if (traverseDescendantsAction != TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                } else {
                }
                this_$iv$iv$iv5 = 0;
                mask$iv$iv = i;
                this_$iv$iv$iv4 = 1;
                mask$iv$iv5 = 0;
                this_$iv$iv$iv5 = 1;
                continueTraversal = block.invoke(type$iv3);
            }
            type$iv = this_$iv$iv$iv5;
            obj8 = obj5;
            i2 = arr;
            mask$iv$iv = i;
            mask$iv$iv2 = 0;
            i5 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            if (i5 != 0) {
            } else {
            }
            node$iv$iv = mask$iv$iv2;
            this_$iv$iv$iv5 = type$iv;
            obj5 = obj8;
            arr = i2;
            i = mask$iv$iv;
            type$iv = this_$iv$iv$iv5;
            arr = key;
            i13 = 0;
            if (kindSet$ui_release &= type$iv != 0) {
            } else {
            }
            this_$iv$iv$iv5 = 0;
            if (this_$iv$iv$iv5 != 0 && node$iv$iv instanceof DelegatingNode) {
            } else {
            }
            mask$iv$iv = i;
            this_$iv$iv$iv4 = 1;
            mask$iv$iv5 = 0;
            node$iv$iv = DelegatableNodeKt.access$pop(i6);
            i10 = this_$iv$iv$iv4;
            this_$iv$iv$iv5 = type$iv;
            obj5 = obj8;
            arr = i2;
            i = mask$iv$iv;
            if (node$iv$iv instanceof DelegatingNode) {
            } else {
            }
            this_$iv$iv$iv5 = 0;
            i10 = 0;
            node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
            while (node$iv$iv$iv != null) {
                i7 = node$iv$iv$iv;
                obj2 = 0;
                count$iv$iv = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                this_$iv$iv$iv3 = this_$iv$iv$iv2;
                mask$iv$iv = i;
                next$iv$iv = i7;
                mask$iv$iv4 = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                arr = key;
                this_$iv$iv$iv2 = this_$iv$iv$iv3;
                i = mask$iv$iv;
                this_$iv$iv$iv5++;
                this_$iv$iv$iv3 = this_$iv$iv$iv2;
                if (this_$iv$iv$iv5 == 1) {
                } else {
                }
                if (i6 == 0) {
                } else {
                }
                count$iv$iv = this_$iv$iv$iv5;
                mask$iv$iv = i;
                mask$iv$iv4 = 0;
                this_$iv$iv$iv2 = i6;
                obj4 = node$iv$iv;
                if (obj4 != null && this_$iv$iv$iv2 != 0) {
                }
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                next$iv$iv = i7;
                i6 = this_$iv$iv$iv2;
                this_$iv$iv$iv5 = count$iv$iv;
                this_$iv$iv$iv2.add(i7);
                if (this_$iv$iv$iv2 != 0) {
                }
                node$iv$iv = arr;
                this_$iv$iv$iv2.add(obj4);
                count$iv$iv = this_$iv$iv$iv5;
                i4 = 0;
                i3 = i14;
                mask$iv$iv = i;
                this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv = i7;
                mask$iv$iv = i;
                next$iv$iv = i7;
                mask$iv$iv4 = 0;
                this_$iv$iv$iv = 1;
            }
            this_$iv$iv$iv3 = this_$iv$iv$iv2;
            mask$iv$iv5 = 0;
            this_$iv$iv$iv4 = 1;
            if (this_$iv$iv$iv5 == this_$iv$iv$iv4) {
            } else {
            }
            i10 = this_$iv$iv$iv4;
            this_$iv$iv$iv5 = type$iv;
            obj5 = obj8;
            arr = i2;
            i = mask$iv$iv;
            i7 = node$iv$iv$iv;
            obj2 = 0;
            count$iv$iv = 0;
            if (kindSet$ui_release3 &= type$iv != 0) {
            } else {
            }
            this_$iv$iv$iv = 0;
            if (this_$iv$iv$iv != 0) {
            } else {
            }
            this_$iv$iv$iv3 = this_$iv$iv$iv2;
            mask$iv$iv = i;
            next$iv$iv = i7;
            mask$iv$iv4 = 0;
            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
            arr = key;
            this_$iv$iv$iv2 = this_$iv$iv$iv3;
            i = mask$iv$iv;
            this_$iv$iv$iv5++;
            this_$iv$iv$iv3 = this_$iv$iv$iv2;
            if (this_$iv$iv$iv5 == 1) {
            } else {
            }
            if (i6 == 0) {
            } else {
            }
            count$iv$iv = this_$iv$iv$iv5;
            mask$iv$iv = i;
            mask$iv$iv4 = 0;
            this_$iv$iv$iv2 = i6;
            obj4 = node$iv$iv;
            if (obj4 != null && this_$iv$iv$iv2 != 0) {
            }
            if (this_$iv$iv$iv2 != 0) {
            } else {
            }
            next$iv$iv = i7;
            i6 = this_$iv$iv$iv2;
            this_$iv$iv$iv5 = count$iv$iv;
            this_$iv$iv$iv2.add(i7);
            if (this_$iv$iv$iv2 != 0) {
            }
            node$iv$iv = arr;
            this_$iv$iv$iv2.add(obj4);
            count$iv$iv = this_$iv$iv$iv5;
            i4 = 0;
            i3 = i14;
            mask$iv$iv = i;
            this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], 0);
            node$iv$iv = i7;
            mask$iv$iv = i;
            next$iv$iv = i7;
            mask$iv$iv4 = 0;
            this_$iv$iv$iv = 1;
            this_$iv$iv$iv5 = 1;
            node$iv$iv$iv = 0;
            type$iv = this_$iv$iv$iv5;
            type$iv3 = i10;
            i7 = 0;
            obj8 = obj5;
            i2 = arr;
            if (Intrinsics.areEqual(key, (TraversableNode)type$iv3.getTraverseKey())) {
            } else {
            }
            obj6 = block;
            continueTraversal = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
            obj2 = type$iv3;
            traverseDescendantsAction = this_$iv$iv$iv3;
            if (traverseDescendantsAction != TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
            } else {
            }
            this_$iv$iv$iv5 = 0;
            mask$iv$iv = i;
            this_$iv$iv$iv4 = 1;
            mask$iv$iv5 = 0;
            mask$iv$iv = i;
            $this$visitSubtreeIf_u2d6rFNWt0$iv = 1;
            mask$iv$iv2 = 0;
            i5 = 0;
            this_$iv$iv$iv5 = 1;
            continueTraversal = block.invoke(type$iv3);
        }
    }

    public static final <T extends androidx.compose.ui.node.TraversableNode> void traverseDescendants(T $this$traverseDescendants, Function1<? super T, ? extends androidx.compose.ui.node.TraversableNode.Companion.TraverseDescendantsAction> block) {
        int count$iv$iv2;
        Object obj2;
        Object this_$iv$iv$iv4;
        int this_$iv$iv$iv;
        int $this$visitSubtreeIf_u2d6rFNWt0$iv;
        int type$iv;
        Modifier.Node next$iv$iv;
        boolean objectsOfSameType;
        int i3;
        int i6;
        int $i$f$forEachImmediateDelegate$ui_release;
        int $i$f$forEachImmediateDelegate$ui_release2;
        Object continueTraversal;
        int i15;
        int i12;
        int node;
        String str;
        int node$iv$iv$iv;
        Modifier.Node[] node$iv$iv;
        int node$iv$iv2;
        Object obj3;
        int i7;
        Object obj;
        int i13;
        int i8;
        int i2;
        int i5;
        Object $this$visitSubtreeIf_u2d6rFNWt0$iv2;
        int i10;
        int i14;
        int i4;
        Object this_$iv$iv$iv2;
        int this_$iv$iv$iv3;
        int count$iv$iv;
        int i;
        int i9;
        int i11;
        int i18 = 0;
        i3 = 0;
        final int i21 = type$iv;
        final Object obj6 = obj2;
        final int i22 = 0;
        int i23 = 0;
        if (!obj6.getNode().isAttached()) {
            int i25 = 0;
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        int value$iv$iv$iv = 0;
        node$iv$iv$iv = 0;
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = obj6.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, obj6.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            node = mutableVector.removeAt(size -= node$iv$iv$iv);
            if (aggregateChildKindSet$ui_release &= i21 != 0) {
            } else {
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv2 = obj2;
            i14 = type$iv;
            i4 = i3;
            i12 = node$iv$iv2;
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node);
            count$iv$iv2 = $this$traverseDescendants;
            node$iv$iv2 = i12;
            obj2 = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
            type$iv = i14;
            i3 = i4;
            node$iv$iv = node;
            while (node$iv$iv != null) {
                if (kindSet$ui_release2 &= i21 == 0) {
                    break loop_8;
                } else {
                }
                $this$visitSubtreeIf_u2d6rFNWt0$iv2 = obj2;
                i14 = type$iv;
                i4 = i3;
                $this$visitSubtreeIf_u2d6rFNWt0$iv = node$iv$iv$iv;
                i15 = node$iv$iv2;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                count$iv$iv2 = $this$traverseDescendants;
                node$iv$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                node$iv$iv2 = i15;
                obj2 = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                type$iv = i14;
                i3 = i4;
                i7 = 0;
                i13 = 0;
                i8 = 0;
                int i26 = 0;
                node$iv$iv2 = node$iv$iv3;
                while (node$iv$iv2 != null) {
                    i14 = type$iv;
                    type$iv = block;
                    int i16 = 0;
                    if (kindSet$ui_release &= i14 != 0) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    if (count$iv$iv2 != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv = 1;
                    $i$f$forEachImmediateDelegate$ui_release2 = 0;
                    node$iv$iv2 = DelegatableNodeKt.access$pop(i8);
                    count$iv$iv2 = $this$traverseDescendants;
                    node$iv$iv$iv = this_$iv$iv$iv;
                    obj2 = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                    type$iv = i14;
                    i3 = i4;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    i6 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        i5 = node$iv$iv$iv;
                        i10 = 0;
                        count$iv$iv = 0;
                        if (kindSet$ui_release3 &= i14 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv3 = 0;
                        if (this_$iv$iv$iv3 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = this_$iv$iv$iv4;
                        i11 = i6;
                        next$iv$iv = i5;
                        $i$f$forEachImmediateDelegate$ui_release = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        type$iv = block;
                        this_$iv$iv$iv4 = this_$iv$iv$iv2;
                        i6 = i11;
                        count$iv$iv2++;
                        this_$iv$iv$iv2 = this_$iv$iv$iv4;
                        if (count$iv$iv2 == 1) {
                        } else {
                        }
                        if (i8 == 0) {
                        } else {
                        }
                        count$iv$iv = count$iv$iv2;
                        i11 = i6;
                        $i$f$forEachImmediateDelegate$ui_release = 0;
                        this_$iv$iv$iv4 = i8;
                        Object obj5 = node$iv$iv2;
                        if (obj5 != null && this_$iv$iv$iv4 != 0) {
                        }
                        if (this_$iv$iv$iv4 != 0) {
                        } else {
                        }
                        next$iv$iv = i5;
                        i8 = this_$iv$iv$iv4;
                        count$iv$iv2 = count$iv$iv;
                        this_$iv$iv$iv4.add(i5);
                        if (this_$iv$iv$iv4 != 0) {
                        }
                        node$iv$iv2 = type$iv;
                        this_$iv$iv$iv4.add(obj5);
                        count$iv$iv = count$iv$iv2;
                        i = 0;
                        i9 = i17;
                        i11 = i6;
                        this_$iv$iv$iv4 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv2 = i5;
                        i11 = i6;
                        next$iv$iv = i5;
                        $i$f$forEachImmediateDelegate$ui_release = 0;
                        this_$iv$iv$iv3 = 1;
                    }
                    this_$iv$iv$iv2 = this_$iv$iv$iv4;
                    i11 = i6;
                    $i$f$forEachImmediateDelegate$ui_release2 = 0;
                    this_$iv$iv$iv = 1;
                    if (count$iv$iv2 == this_$iv$iv$iv) {
                    } else {
                    }
                    count$iv$iv2 = $this$traverseDescendants;
                    node$iv$iv$iv = this_$iv$iv$iv;
                    obj2 = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                    type$iv = i14;
                    i3 = i4;
                    i5 = node$iv$iv$iv;
                    i10 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release3 &= i14 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv3 = 0;
                    if (this_$iv$iv$iv3 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = this_$iv$iv$iv4;
                    i11 = i6;
                    next$iv$iv = i5;
                    $i$f$forEachImmediateDelegate$ui_release = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    type$iv = block;
                    this_$iv$iv$iv4 = this_$iv$iv$iv2;
                    i6 = i11;
                    count$iv$iv2++;
                    this_$iv$iv$iv2 = this_$iv$iv$iv4;
                    if (count$iv$iv2 == 1) {
                    } else {
                    }
                    if (i8 == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv2;
                    i11 = i6;
                    $i$f$forEachImmediateDelegate$ui_release = 0;
                    this_$iv$iv$iv4 = i8;
                    obj5 = node$iv$iv2;
                    if (obj5 != null && this_$iv$iv$iv4 != 0) {
                    }
                    if (this_$iv$iv$iv4 != 0) {
                    } else {
                    }
                    next$iv$iv = i5;
                    i8 = this_$iv$iv$iv4;
                    count$iv$iv2 = count$iv$iv;
                    this_$iv$iv$iv4.add(i5);
                    if (this_$iv$iv$iv4 != 0) {
                    }
                    node$iv$iv2 = type$iv;
                    this_$iv$iv$iv4.add(obj5);
                    count$iv$iv = count$iv$iv2;
                    i = 0;
                    i9 = i17;
                    i11 = i6;
                    this_$iv$iv$iv4 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv2 = i5;
                    i11 = i6;
                    next$iv$iv = i5;
                    $i$f$forEachImmediateDelegate$ui_release = 0;
                    this_$iv$iv$iv3 = 1;
                    count$iv$iv2 = 1;
                    i5 = 0;
                    $this$visitSubtreeIf_u2d6rFNWt0$iv2 = obj2;
                    Object $this$visitSubtreeIf_u2d6rFNWt0$iv3 = node$iv$iv$iv;
                    i10 = 0;
                    i14 = type$iv;
                    i4 = i3;
                    if (Intrinsics.areEqual(count$iv$iv2.getTraverseKey(), (TraversableNode)$this$visitSubtreeIf_u2d6rFNWt0$iv3.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(count$iv$iv2, $this$visitSubtreeIf_u2d6rFNWt0$iv3)) {
                    } else {
                    }
                    type$iv = block;
                    continueTraversal = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                    if (continueTraversal != TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    this_$iv$iv$iv = 1;
                    $i$f$forEachImmediateDelegate$ui_release2 = 0;
                    count$iv$iv2 = 1;
                    if (Actual_jvmKt.areObjectsOfSameType(count$iv$iv2, $this$visitSubtreeIf_u2d6rFNWt0$iv3)) {
                    } else {
                    }
                    continueTraversal = block.invoke($this$visitSubtreeIf_u2d6rFNWt0$iv3);
                }
                $this$visitSubtreeIf_u2d6rFNWt0$iv2 = obj2;
                i14 = type$iv;
                i4 = i3;
                i15 = 0;
                i2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                i14 = type$iv;
                type$iv = block;
                i16 = 0;
                if (kindSet$ui_release &= i14 != 0) {
                } else {
                }
                count$iv$iv2 = 0;
                if (count$iv$iv2 != 0 && node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv = 1;
                $i$f$forEachImmediateDelegate$ui_release2 = 0;
                node$iv$iv2 = DelegatableNodeKt.access$pop(i8);
                count$iv$iv2 = $this$traverseDescendants;
                node$iv$iv$iv = this_$iv$iv$iv;
                obj2 = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                type$iv = i14;
                i3 = i4;
                if (node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv2 = 0;
                i6 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    i5 = node$iv$iv$iv;
                    i10 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release3 &= i14 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv3 = 0;
                    if (this_$iv$iv$iv3 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = this_$iv$iv$iv4;
                    i11 = i6;
                    next$iv$iv = i5;
                    $i$f$forEachImmediateDelegate$ui_release = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    type$iv = block;
                    this_$iv$iv$iv4 = this_$iv$iv$iv2;
                    i6 = i11;
                    count$iv$iv2++;
                    this_$iv$iv$iv2 = this_$iv$iv$iv4;
                    if (count$iv$iv2 == 1) {
                    } else {
                    }
                    if (i8 == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv2;
                    i11 = i6;
                    $i$f$forEachImmediateDelegate$ui_release = 0;
                    this_$iv$iv$iv4 = i8;
                    obj5 = node$iv$iv2;
                    if (obj5 != null && this_$iv$iv$iv4 != 0) {
                    }
                    if (this_$iv$iv$iv4 != 0) {
                    } else {
                    }
                    next$iv$iv = i5;
                    i8 = this_$iv$iv$iv4;
                    count$iv$iv2 = count$iv$iv;
                    this_$iv$iv$iv4.add(i5);
                    if (this_$iv$iv$iv4 != 0) {
                    }
                    node$iv$iv2 = type$iv;
                    this_$iv$iv$iv4.add(obj5);
                    count$iv$iv = count$iv$iv2;
                    i = 0;
                    i9 = i17;
                    i11 = i6;
                    this_$iv$iv$iv4 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv2 = i5;
                    i11 = i6;
                    next$iv$iv = i5;
                    $i$f$forEachImmediateDelegate$ui_release = 0;
                    this_$iv$iv$iv3 = 1;
                }
                this_$iv$iv$iv2 = this_$iv$iv$iv4;
                i11 = i6;
                $i$f$forEachImmediateDelegate$ui_release2 = 0;
                this_$iv$iv$iv = 1;
                if (count$iv$iv2 == this_$iv$iv$iv) {
                } else {
                }
                count$iv$iv2 = $this$traverseDescendants;
                node$iv$iv$iv = this_$iv$iv$iv;
                obj2 = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                type$iv = i14;
                i3 = i4;
                i5 = node$iv$iv$iv;
                i10 = 0;
                count$iv$iv = 0;
                if (kindSet$ui_release3 &= i14 != 0) {
                } else {
                }
                this_$iv$iv$iv3 = 0;
                if (this_$iv$iv$iv3 != 0) {
                } else {
                }
                this_$iv$iv$iv2 = this_$iv$iv$iv4;
                i11 = i6;
                next$iv$iv = i5;
                $i$f$forEachImmediateDelegate$ui_release = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                type$iv = block;
                this_$iv$iv$iv4 = this_$iv$iv$iv2;
                i6 = i11;
                count$iv$iv2++;
                this_$iv$iv$iv2 = this_$iv$iv$iv4;
                if (count$iv$iv2 == 1) {
                } else {
                }
                if (i8 == 0) {
                } else {
                }
                count$iv$iv = count$iv$iv2;
                i11 = i6;
                $i$f$forEachImmediateDelegate$ui_release = 0;
                this_$iv$iv$iv4 = i8;
                obj5 = node$iv$iv2;
                if (obj5 != null && this_$iv$iv$iv4 != 0) {
                }
                if (this_$iv$iv$iv4 != 0) {
                } else {
                }
                next$iv$iv = i5;
                i8 = this_$iv$iv$iv4;
                count$iv$iv2 = count$iv$iv;
                this_$iv$iv$iv4.add(i5);
                if (this_$iv$iv$iv4 != 0) {
                }
                node$iv$iv2 = type$iv;
                this_$iv$iv$iv4.add(obj5);
                count$iv$iv = count$iv$iv2;
                i = 0;
                i9 = i17;
                i11 = i6;
                this_$iv$iv$iv4 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv2 = i5;
                i11 = i6;
                next$iv$iv = i5;
                $i$f$forEachImmediateDelegate$ui_release = 0;
                this_$iv$iv$iv3 = 1;
                count$iv$iv2 = 1;
                i5 = 0;
                $this$visitSubtreeIf_u2d6rFNWt0$iv2 = obj2;
                $this$visitSubtreeIf_u2d6rFNWt0$iv3 = node$iv$iv$iv;
                i10 = 0;
                i14 = type$iv;
                i4 = i3;
                if (Intrinsics.areEqual(count$iv$iv2.getTraverseKey(), (TraversableNode)$this$visitSubtreeIf_u2d6rFNWt0$iv3.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(count$iv$iv2, $this$visitSubtreeIf_u2d6rFNWt0$iv3)) {
                } else {
                }
                type$iv = block;
                continueTraversal = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                if (continueTraversal != TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                } else {
                }
                count$iv$iv2 = 0;
                this_$iv$iv$iv = 1;
                $i$f$forEachImmediateDelegate$ui_release2 = 0;
                $this$visitSubtreeIf_u2d6rFNWt0$iv = 1;
                i15 = 0;
                i2 = 0;
                count$iv$iv2 = 1;
                if (Actual_jvmKt.areObjectsOfSameType(count$iv$iv2, $this$visitSubtreeIf_u2d6rFNWt0$iv3)) {
                } else {
                }
                continueTraversal = block.invoke($this$visitSubtreeIf_u2d6rFNWt0$iv3);
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv2 = obj2;
            i14 = type$iv;
            i4 = i3;
            i12 = node$iv$iv2;
            if (kindSet$ui_release2 &= i21 != 0) {
            } else {
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv2 = obj2;
            i14 = type$iv;
            i4 = i3;
            $this$visitSubtreeIf_u2d6rFNWt0$iv = node$iv$iv$iv;
            i15 = node$iv$iv2;
            node$iv$iv = node$iv$iv.getChild$ui_release();
            count$iv$iv2 = $this$traverseDescendants;
            node$iv$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            node$iv$iv2 = i15;
            obj2 = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
            type$iv = i14;
            i3 = i4;
            i7 = 0;
            i13 = 0;
            i8 = 0;
            i26 = 0;
            node$iv$iv2 = node$iv$iv3;
            while (node$iv$iv2 != null) {
                i14 = type$iv;
                type$iv = block;
                i16 = 0;
                if (kindSet$ui_release &= i14 != 0) {
                } else {
                }
                count$iv$iv2 = 0;
                if (count$iv$iv2 != 0 && node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv = 1;
                $i$f$forEachImmediateDelegate$ui_release2 = 0;
                node$iv$iv2 = DelegatableNodeKt.access$pop(i8);
                count$iv$iv2 = $this$traverseDescendants;
                node$iv$iv$iv = this_$iv$iv$iv;
                obj2 = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                type$iv = i14;
                i3 = i4;
                if (node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv2 = 0;
                i6 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    i5 = node$iv$iv$iv;
                    i10 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release3 &= i14 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv3 = 0;
                    if (this_$iv$iv$iv3 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = this_$iv$iv$iv4;
                    i11 = i6;
                    next$iv$iv = i5;
                    $i$f$forEachImmediateDelegate$ui_release = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    type$iv = block;
                    this_$iv$iv$iv4 = this_$iv$iv$iv2;
                    i6 = i11;
                    count$iv$iv2++;
                    this_$iv$iv$iv2 = this_$iv$iv$iv4;
                    if (count$iv$iv2 == 1) {
                    } else {
                    }
                    if (i8 == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv2;
                    i11 = i6;
                    $i$f$forEachImmediateDelegate$ui_release = 0;
                    this_$iv$iv$iv4 = i8;
                    obj5 = node$iv$iv2;
                    if (obj5 != null && this_$iv$iv$iv4 != 0) {
                    }
                    if (this_$iv$iv$iv4 != 0) {
                    } else {
                    }
                    next$iv$iv = i5;
                    i8 = this_$iv$iv$iv4;
                    count$iv$iv2 = count$iv$iv;
                    this_$iv$iv$iv4.add(i5);
                    if (this_$iv$iv$iv4 != 0) {
                    }
                    node$iv$iv2 = type$iv;
                    this_$iv$iv$iv4.add(obj5);
                    count$iv$iv = count$iv$iv2;
                    i = 0;
                    i9 = i17;
                    i11 = i6;
                    this_$iv$iv$iv4 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv2 = i5;
                    i11 = i6;
                    next$iv$iv = i5;
                    $i$f$forEachImmediateDelegate$ui_release = 0;
                    this_$iv$iv$iv3 = 1;
                }
                this_$iv$iv$iv2 = this_$iv$iv$iv4;
                i11 = i6;
                $i$f$forEachImmediateDelegate$ui_release2 = 0;
                this_$iv$iv$iv = 1;
                if (count$iv$iv2 == this_$iv$iv$iv) {
                } else {
                }
                count$iv$iv2 = $this$traverseDescendants;
                node$iv$iv$iv = this_$iv$iv$iv;
                obj2 = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                type$iv = i14;
                i3 = i4;
                i5 = node$iv$iv$iv;
                i10 = 0;
                count$iv$iv = 0;
                if (kindSet$ui_release3 &= i14 != 0) {
                } else {
                }
                this_$iv$iv$iv3 = 0;
                if (this_$iv$iv$iv3 != 0) {
                } else {
                }
                this_$iv$iv$iv2 = this_$iv$iv$iv4;
                i11 = i6;
                next$iv$iv = i5;
                $i$f$forEachImmediateDelegate$ui_release = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                type$iv = block;
                this_$iv$iv$iv4 = this_$iv$iv$iv2;
                i6 = i11;
                count$iv$iv2++;
                this_$iv$iv$iv2 = this_$iv$iv$iv4;
                if (count$iv$iv2 == 1) {
                } else {
                }
                if (i8 == 0) {
                } else {
                }
                count$iv$iv = count$iv$iv2;
                i11 = i6;
                $i$f$forEachImmediateDelegate$ui_release = 0;
                this_$iv$iv$iv4 = i8;
                obj5 = node$iv$iv2;
                if (obj5 != null && this_$iv$iv$iv4 != 0) {
                }
                if (this_$iv$iv$iv4 != 0) {
                } else {
                }
                next$iv$iv = i5;
                i8 = this_$iv$iv$iv4;
                count$iv$iv2 = count$iv$iv;
                this_$iv$iv$iv4.add(i5);
                if (this_$iv$iv$iv4 != 0) {
                }
                node$iv$iv2 = type$iv;
                this_$iv$iv$iv4.add(obj5);
                count$iv$iv = count$iv$iv2;
                i = 0;
                i9 = i17;
                i11 = i6;
                this_$iv$iv$iv4 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv2 = i5;
                i11 = i6;
                next$iv$iv = i5;
                $i$f$forEachImmediateDelegate$ui_release = 0;
                this_$iv$iv$iv3 = 1;
                count$iv$iv2 = 1;
                i5 = 0;
                $this$visitSubtreeIf_u2d6rFNWt0$iv2 = obj2;
                $this$visitSubtreeIf_u2d6rFNWt0$iv3 = node$iv$iv$iv;
                i10 = 0;
                i14 = type$iv;
                i4 = i3;
                if (Intrinsics.areEqual(count$iv$iv2.getTraverseKey(), (TraversableNode)$this$visitSubtreeIf_u2d6rFNWt0$iv3.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(count$iv$iv2, $this$visitSubtreeIf_u2d6rFNWt0$iv3)) {
                } else {
                }
                type$iv = block;
                continueTraversal = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                if (continueTraversal != TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                } else {
                }
                count$iv$iv2 = 0;
                this_$iv$iv$iv = 1;
                $i$f$forEachImmediateDelegate$ui_release2 = 0;
                count$iv$iv2 = 1;
                if (Actual_jvmKt.areObjectsOfSameType(count$iv$iv2, $this$visitSubtreeIf_u2d6rFNWt0$iv3)) {
                } else {
                }
                continueTraversal = block.invoke($this$visitSubtreeIf_u2d6rFNWt0$iv3);
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv2 = obj2;
            i14 = type$iv;
            i4 = i3;
            i15 = 0;
            i2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            if (i2 != 0) {
            } else {
            }
            count$iv$iv2 = $this$traverseDescendants;
            node$iv$iv2 = i15;
            obj2 = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
            type$iv = i14;
            i3 = i4;
            i14 = type$iv;
            type$iv = block;
            i16 = 0;
            if (kindSet$ui_release &= i14 != 0) {
            } else {
            }
            count$iv$iv2 = 0;
            if (count$iv$iv2 != 0 && node$iv$iv2 instanceof DelegatingNode) {
            } else {
            }
            this_$iv$iv$iv = 1;
            $i$f$forEachImmediateDelegate$ui_release2 = 0;
            node$iv$iv2 = DelegatableNodeKt.access$pop(i8);
            count$iv$iv2 = $this$traverseDescendants;
            node$iv$iv$iv = this_$iv$iv$iv;
            obj2 = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
            type$iv = i14;
            i3 = i4;
            if (node$iv$iv2 instanceof DelegatingNode) {
            } else {
            }
            count$iv$iv2 = 0;
            i6 = 0;
            node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
            while (node$iv$iv$iv != null) {
                i5 = node$iv$iv$iv;
                i10 = 0;
                count$iv$iv = 0;
                if (kindSet$ui_release3 &= i14 != 0) {
                } else {
                }
                this_$iv$iv$iv3 = 0;
                if (this_$iv$iv$iv3 != 0) {
                } else {
                }
                this_$iv$iv$iv2 = this_$iv$iv$iv4;
                i11 = i6;
                next$iv$iv = i5;
                $i$f$forEachImmediateDelegate$ui_release = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                type$iv = block;
                this_$iv$iv$iv4 = this_$iv$iv$iv2;
                i6 = i11;
                count$iv$iv2++;
                this_$iv$iv$iv2 = this_$iv$iv$iv4;
                if (count$iv$iv2 == 1) {
                } else {
                }
                if (i8 == 0) {
                } else {
                }
                count$iv$iv = count$iv$iv2;
                i11 = i6;
                $i$f$forEachImmediateDelegate$ui_release = 0;
                this_$iv$iv$iv4 = i8;
                obj5 = node$iv$iv2;
                if (obj5 != null && this_$iv$iv$iv4 != 0) {
                }
                if (this_$iv$iv$iv4 != 0) {
                } else {
                }
                next$iv$iv = i5;
                i8 = this_$iv$iv$iv4;
                count$iv$iv2 = count$iv$iv;
                this_$iv$iv$iv4.add(i5);
                if (this_$iv$iv$iv4 != 0) {
                }
                node$iv$iv2 = type$iv;
                this_$iv$iv$iv4.add(obj5);
                count$iv$iv = count$iv$iv2;
                i = 0;
                i9 = i17;
                i11 = i6;
                this_$iv$iv$iv4 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv2 = i5;
                i11 = i6;
                next$iv$iv = i5;
                $i$f$forEachImmediateDelegate$ui_release = 0;
                this_$iv$iv$iv3 = 1;
            }
            this_$iv$iv$iv2 = this_$iv$iv$iv4;
            i11 = i6;
            $i$f$forEachImmediateDelegate$ui_release2 = 0;
            this_$iv$iv$iv = 1;
            if (count$iv$iv2 == this_$iv$iv$iv) {
            } else {
            }
            count$iv$iv2 = $this$traverseDescendants;
            node$iv$iv$iv = this_$iv$iv$iv;
            obj2 = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
            type$iv = i14;
            i3 = i4;
            i5 = node$iv$iv$iv;
            i10 = 0;
            count$iv$iv = 0;
            if (kindSet$ui_release3 &= i14 != 0) {
            } else {
            }
            this_$iv$iv$iv3 = 0;
            if (this_$iv$iv$iv3 != 0) {
            } else {
            }
            this_$iv$iv$iv2 = this_$iv$iv$iv4;
            i11 = i6;
            next$iv$iv = i5;
            $i$f$forEachImmediateDelegate$ui_release = 0;
            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
            type$iv = block;
            this_$iv$iv$iv4 = this_$iv$iv$iv2;
            i6 = i11;
            count$iv$iv2++;
            this_$iv$iv$iv2 = this_$iv$iv$iv4;
            if (count$iv$iv2 == 1) {
            } else {
            }
            if (i8 == 0) {
            } else {
            }
            count$iv$iv = count$iv$iv2;
            i11 = i6;
            $i$f$forEachImmediateDelegate$ui_release = 0;
            this_$iv$iv$iv4 = i8;
            obj5 = node$iv$iv2;
            if (obj5 != null && this_$iv$iv$iv4 != 0) {
            }
            if (this_$iv$iv$iv4 != 0) {
            } else {
            }
            next$iv$iv = i5;
            i8 = this_$iv$iv$iv4;
            count$iv$iv2 = count$iv$iv;
            this_$iv$iv$iv4.add(i5);
            if (this_$iv$iv$iv4 != 0) {
            }
            node$iv$iv2 = type$iv;
            this_$iv$iv$iv4.add(obj5);
            count$iv$iv = count$iv$iv2;
            i = 0;
            i9 = i17;
            i11 = i6;
            this_$iv$iv$iv4 = new MutableVector(new Modifier.Node[16], 0);
            node$iv$iv2 = i5;
            i11 = i6;
            next$iv$iv = i5;
            $i$f$forEachImmediateDelegate$ui_release = 0;
            this_$iv$iv$iv3 = 1;
            count$iv$iv2 = 1;
            i5 = 0;
            $this$visitSubtreeIf_u2d6rFNWt0$iv2 = obj2;
            $this$visitSubtreeIf_u2d6rFNWt0$iv3 = node$iv$iv$iv;
            i10 = 0;
            i14 = type$iv;
            i4 = i3;
            if (Intrinsics.areEqual(count$iv$iv2.getTraverseKey(), (TraversableNode)$this$visitSubtreeIf_u2d6rFNWt0$iv3.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(count$iv$iv2, $this$visitSubtreeIf_u2d6rFNWt0$iv3)) {
            } else {
            }
            type$iv = block;
            continueTraversal = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
            if (continueTraversal != TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
            } else {
            }
            count$iv$iv2 = 0;
            this_$iv$iv$iv = 1;
            $i$f$forEachImmediateDelegate$ui_release2 = 0;
            $this$visitSubtreeIf_u2d6rFNWt0$iv = 1;
            i15 = 0;
            i2 = 0;
            count$iv$iv2 = 1;
            if (Actual_jvmKt.areObjectsOfSameType(count$iv$iv2, $this$visitSubtreeIf_u2d6rFNWt0$iv3)) {
            } else {
            }
            continueTraversal = block.invoke($this$visitSubtreeIf_u2d6rFNWt0$iv3);
        }
    }
}
