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
        int $i$f$getTraversableOLwlOKw;
        Modifier.Node count$iv$iv;
        androidx.compose.ui.node.DelegatableNode delegatableNode;
        Object $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
        Modifier.Node next$iv$iv;
        int $i$f$mutableVectorOf;
        int includeSelf$iv;
        int i7;
        int $i$f$visitAncestorsYYKmho;
        Modifier.Node node$iv$iv;
        androidx.compose.ui.node.LayoutNode layout$iv$iv;
        int node$iv$iv2;
        Modifier.Node head$ui_release;
        int i6;
        int i2;
        Modifier.Node node4;
        int i3;
        int stack$iv$iv;
        int node$iv$iv3;
        int type$iv;
        int $i$f$isKindH91voCI$ui_release;
        Modifier.Node node2;
        androidx.compose.ui.node.DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        Modifier.Node node3;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node;
        int i4;
        int count$iv$iv2;
        int i8;
        int i;
        int includeSelf$iv2;
        int i5;
        int i9 = 0;
        $i$f$getTraversableOLwlOKw = NodeKind.constructor-impl(262144);
        delegatableNode = $this$findNearestAncestor;
        includeSelf$iv = 0;
        i7 = 0;
        final int i13 = $i$f$getTraversableOLwlOKw;
        final androidx.compose.ui.node.DelegatableNode delegatableNode2 = delegatableNode;
        final int i14 = 0;
        if (!delegatableNode2.getNode().isAttached()) {
        } else {
            node$iv$iv = delegatableNode2.getNode().getParent$ui_release();
            layout$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode2);
            while (layout$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= i13 != 0) {
                } else {
                }
                type$iv = $i$f$getTraversableOLwlOKw;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                includeSelf$iv2 = includeSelf$iv;
                i5 = i7;
                node$iv$iv3 = 0;
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                $i$f$getTraversableOLwlOKw = layout$iv$iv.getNodes$ui_release();
                if (layout$iv$iv != null && $i$f$getTraversableOLwlOKw != null) {
                } else {
                }
                node$iv$iv2 = node$iv$iv3;
                node$iv$iv = node$iv$iv2;
                $i$f$getTraversableOLwlOKw = type$iv;
                delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                includeSelf$iv = includeSelf$iv2;
                i7 = i5;
                $i$f$getTraversableOLwlOKw = layout$iv$iv.getNodes$ui_release();
                if ($i$f$getTraversableOLwlOKw != null) {
                } else {
                }
                node$iv$iv2 = $i$f$getTraversableOLwlOKw.getTail$ui_release();
                while (node$iv$iv != null) {
                    if (kindSet$ui_release &= i13 == 0) {
                        break loop_4;
                    } else {
                    }
                    type$iv = $i$f$getTraversableOLwlOKw;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                    includeSelf$iv2 = includeSelf$iv;
                    i5 = i7;
                    node$iv$iv3 = 0;
                    node$iv$iv = node$iv$iv.getParent$ui_release();
                    $i$f$getTraversableOLwlOKw = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    includeSelf$iv = includeSelf$iv2;
                    i7 = i5;
                    i2 = 0;
                    i3 = 0;
                    stack$iv$iv = 0;
                    int i15 = 0;
                    node$iv$iv2 = node$iv$iv4;
                    node$iv$iv3 = 0;
                    while (node$iv$iv2 != null) {
                        type$iv = $i$f$getTraversableOLwlOKw;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                        count$iv$iv = node$iv$iv2;
                        int i18 = 0;
                        node3 = count$iv$iv;
                        if (kindSet$ui_release2 &= type$iv != 0) {
                        } else {
                        }
                        $i$f$isKindH91voCI$ui_release = 0;
                        if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        includeSelf$iv2 = includeSelf$iv;
                        i5 = i7;
                        node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                        $i$f$getTraversableOLwlOKw = type$iv;
                        delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        includeSelf$iv = includeSelf$iv2;
                        i7 = i5;
                        if (node$iv$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv = 0;
                        node3 = 0;
                        node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node = node$iv$iv$iv;
                            i4 = 0;
                            i8 = 0;
                            if (kindSet$ui_release3 &= type$iv != 0) {
                            } else {
                            }
                            count$iv$iv2 = 0;
                            if (count$iv$iv2 != 0) {
                            } else {
                            }
                            includeSelf$iv2 = includeSelf$iv;
                            i5 = i7;
                            next$iv$iv = node;
                            $i$f$visitAncestorsYYKmho = 0;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                            includeSelf$iv = includeSelf$iv2;
                            i7 = i5;
                            count$iv$iv++;
                            if (count$iv$iv == 1) {
                            } else {
                            }
                            if (stack$iv$iv == 0) {
                            } else {
                            }
                            count$iv$iv2 = count$iv$iv;
                            includeSelf$iv2 = includeSelf$iv;
                            i5 = i7;
                            $i$f$visitAncestorsYYKmho = 0;
                            $i$f$mutableVectorOf = stack$iv$iv;
                            stack$iv$iv = $i$f$mutableVectorOf;
                            Modifier.Node node5 = node$iv$iv2;
                            if (node5 != null && stack$iv$iv != 0) {
                            }
                            if (stack$iv$iv != 0) {
                            } else {
                            }
                            next$iv$iv = node;
                            count$iv$iv = count$iv$iv2;
                            stack$iv$iv.add(node);
                            if (stack$iv$iv != 0) {
                            }
                            node$iv$iv2 = $i$f$mutableVectorOf;
                            stack$iv$iv.add(node5);
                            count$iv$iv2 = count$iv$iv;
                            i8 = 0;
                            i = i12;
                            includeSelf$iv2 = includeSelf$iv;
                            i5 = i7;
                            $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                            node$iv$iv2 = node;
                            includeSelf$iv2 = includeSelf$iv;
                            i5 = i7;
                            next$iv$iv = node;
                            $i$f$visitAncestorsYYKmho = 0;
                            count$iv$iv2 = 1;
                        }
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        $i$f$getTraversableOLwlOKw = type$iv;
                        delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        includeSelf$iv = includeSelf$iv2;
                        i7 = i5;
                        node = node$iv$iv$iv;
                        i4 = 0;
                        i8 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        count$iv$iv2 = 0;
                        if (count$iv$iv2 != 0) {
                        } else {
                        }
                        includeSelf$iv2 = includeSelf$iv;
                        i5 = i7;
                        next$iv$iv = node;
                        $i$f$visitAncestorsYYKmho = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                        includeSelf$iv = includeSelf$iv2;
                        i7 = i5;
                        count$iv$iv++;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv;
                        includeSelf$iv2 = includeSelf$iv;
                        i5 = i7;
                        $i$f$visitAncestorsYYKmho = 0;
                        $i$f$mutableVectorOf = stack$iv$iv;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node5 = node$iv$iv2;
                        if (node5 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node;
                        count$iv$iv = count$iv$iv2;
                        stack$iv$iv.add(node);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv2 = $i$f$mutableVectorOf;
                        stack$iv$iv.add(node5);
                        count$iv$iv2 = count$iv$iv;
                        i8 = 0;
                        i = i12;
                        includeSelf$iv2 = includeSelf$iv;
                        i5 = i7;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv2 = node;
                        includeSelf$iv2 = includeSelf$iv;
                        i5 = i7;
                        next$iv$iv = node;
                        $i$f$visitAncestorsYYKmho = 0;
                        count$iv$iv2 = 1;
                        $i$f$isKindH91voCI$ui_release = 1;
                        $i$f$isKindH91voCI$ui_release = 0;
                        node2 = node6;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                        includeSelf$iv2 = includeSelf$iv;
                        i5 = i7;
                    }
                    type$iv = $i$f$getTraversableOLwlOKw;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                    includeSelf$iv2 = includeSelf$iv;
                    i5 = i7;
                    type$iv = $i$f$getTraversableOLwlOKw;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                    count$iv$iv = node$iv$iv2;
                    i18 = 0;
                    node3 = count$iv$iv;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    includeSelf$iv2 = includeSelf$iv;
                    i5 = i7;
                    node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                    $i$f$getTraversableOLwlOKw = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    includeSelf$iv = includeSelf$iv2;
                    i7 = i5;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    node3 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node = node$iv$iv$iv;
                        i4 = 0;
                        i8 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        count$iv$iv2 = 0;
                        if (count$iv$iv2 != 0) {
                        } else {
                        }
                        includeSelf$iv2 = includeSelf$iv;
                        i5 = i7;
                        next$iv$iv = node;
                        $i$f$visitAncestorsYYKmho = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                        includeSelf$iv = includeSelf$iv2;
                        i7 = i5;
                        count$iv$iv++;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv;
                        includeSelf$iv2 = includeSelf$iv;
                        i5 = i7;
                        $i$f$visitAncestorsYYKmho = 0;
                        $i$f$mutableVectorOf = stack$iv$iv;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node5 = node$iv$iv2;
                        if (node5 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node;
                        count$iv$iv = count$iv$iv2;
                        stack$iv$iv.add(node);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv2 = $i$f$mutableVectorOf;
                        stack$iv$iv.add(node5);
                        count$iv$iv2 = count$iv$iv;
                        i8 = 0;
                        i = i12;
                        includeSelf$iv2 = includeSelf$iv;
                        i5 = i7;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv2 = node;
                        includeSelf$iv2 = includeSelf$iv;
                        i5 = i7;
                        next$iv$iv = node;
                        $i$f$visitAncestorsYYKmho = 0;
                        count$iv$iv2 = 1;
                    }
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    $i$f$getTraversableOLwlOKw = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    includeSelf$iv = includeSelf$iv2;
                    i7 = i5;
                    node = node$iv$iv$iv;
                    i4 = 0;
                    i8 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    if (count$iv$iv2 != 0) {
                    } else {
                    }
                    includeSelf$iv2 = includeSelf$iv;
                    i5 = i7;
                    next$iv$iv = node;
                    $i$f$visitAncestorsYYKmho = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                    includeSelf$iv = includeSelf$iv2;
                    i7 = i5;
                    count$iv$iv++;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv;
                    includeSelf$iv2 = includeSelf$iv;
                    i5 = i7;
                    $i$f$visitAncestorsYYKmho = 0;
                    $i$f$mutableVectorOf = stack$iv$iv;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node5 = node$iv$iv2;
                    if (node5 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    count$iv$iv = count$iv$iv2;
                    stack$iv$iv.add(node);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv2 = $i$f$mutableVectorOf;
                    stack$iv$iv.add(node5);
                    count$iv$iv2 = count$iv$iv;
                    i8 = 0;
                    i = i12;
                    includeSelf$iv2 = includeSelf$iv;
                    i5 = i7;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv2 = node;
                    includeSelf$iv2 = includeSelf$iv;
                    i5 = i7;
                    next$iv$iv = node;
                    $i$f$visitAncestorsYYKmho = 0;
                    count$iv$iv2 = 1;
                    $i$f$isKindH91voCI$ui_release = 1;
                    $i$f$isKindH91voCI$ui_release = 0;
                    node2 = node6;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                    includeSelf$iv2 = includeSelf$iv;
                    i5 = i7;
                }
                type$iv = $i$f$getTraversableOLwlOKw;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                includeSelf$iv2 = includeSelf$iv;
                i5 = i7;
                node$iv$iv3 = 0;
                if (kindSet$ui_release &= i13 != 0) {
                } else {
                }
                type$iv = $i$f$getTraversableOLwlOKw;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                includeSelf$iv2 = includeSelf$iv;
                i5 = i7;
                node$iv$iv3 = 0;
                node$iv$iv = node$iv$iv.getParent$ui_release();
                $i$f$getTraversableOLwlOKw = type$iv;
                delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                includeSelf$iv = includeSelf$iv2;
                i7 = i5;
                i2 = 0;
                i3 = 0;
                stack$iv$iv = 0;
                i15 = 0;
                node$iv$iv2 = node$iv$iv4;
                node$iv$iv3 = 0;
                while (node$iv$iv2 != null) {
                    type$iv = $i$f$getTraversableOLwlOKw;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                    count$iv$iv = node$iv$iv2;
                    i18 = 0;
                    node3 = count$iv$iv;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    includeSelf$iv2 = includeSelf$iv;
                    i5 = i7;
                    node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                    $i$f$getTraversableOLwlOKw = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    includeSelf$iv = includeSelf$iv2;
                    i7 = i5;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    node3 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node = node$iv$iv$iv;
                        i4 = 0;
                        i8 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        count$iv$iv2 = 0;
                        if (count$iv$iv2 != 0) {
                        } else {
                        }
                        includeSelf$iv2 = includeSelf$iv;
                        i5 = i7;
                        next$iv$iv = node;
                        $i$f$visitAncestorsYYKmho = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                        includeSelf$iv = includeSelf$iv2;
                        i7 = i5;
                        count$iv$iv++;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv;
                        includeSelf$iv2 = includeSelf$iv;
                        i5 = i7;
                        $i$f$visitAncestorsYYKmho = 0;
                        $i$f$mutableVectorOf = stack$iv$iv;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node5 = node$iv$iv2;
                        if (node5 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node;
                        count$iv$iv = count$iv$iv2;
                        stack$iv$iv.add(node);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv2 = $i$f$mutableVectorOf;
                        stack$iv$iv.add(node5);
                        count$iv$iv2 = count$iv$iv;
                        i8 = 0;
                        i = i12;
                        includeSelf$iv2 = includeSelf$iv;
                        i5 = i7;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv2 = node;
                        includeSelf$iv2 = includeSelf$iv;
                        i5 = i7;
                        next$iv$iv = node;
                        $i$f$visitAncestorsYYKmho = 0;
                        count$iv$iv2 = 1;
                    }
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    $i$f$getTraversableOLwlOKw = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    includeSelf$iv = includeSelf$iv2;
                    i7 = i5;
                    node = node$iv$iv$iv;
                    i4 = 0;
                    i8 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    if (count$iv$iv2 != 0) {
                    } else {
                    }
                    includeSelf$iv2 = includeSelf$iv;
                    i5 = i7;
                    next$iv$iv = node;
                    $i$f$visitAncestorsYYKmho = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                    includeSelf$iv = includeSelf$iv2;
                    i7 = i5;
                    count$iv$iv++;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv;
                    includeSelf$iv2 = includeSelf$iv;
                    i5 = i7;
                    $i$f$visitAncestorsYYKmho = 0;
                    $i$f$mutableVectorOf = stack$iv$iv;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node5 = node$iv$iv2;
                    if (node5 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    count$iv$iv = count$iv$iv2;
                    stack$iv$iv.add(node);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv2 = $i$f$mutableVectorOf;
                    stack$iv$iv.add(node5);
                    count$iv$iv2 = count$iv$iv;
                    i8 = 0;
                    i = i12;
                    includeSelf$iv2 = includeSelf$iv;
                    i5 = i7;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv2 = node;
                    includeSelf$iv2 = includeSelf$iv;
                    i5 = i7;
                    next$iv$iv = node;
                    $i$f$visitAncestorsYYKmho = 0;
                    count$iv$iv2 = 1;
                    $i$f$isKindH91voCI$ui_release = 1;
                    $i$f$isKindH91voCI$ui_release = 0;
                    node2 = node6;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                    includeSelf$iv2 = includeSelf$iv;
                    i5 = i7;
                }
                type$iv = $i$f$getTraversableOLwlOKw;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                includeSelf$iv2 = includeSelf$iv;
                i5 = i7;
                type$iv = $i$f$getTraversableOLwlOKw;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                count$iv$iv = node$iv$iv2;
                i18 = 0;
                node3 = count$iv$iv;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                $i$f$isKindH91voCI$ui_release = 0;
                if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                includeSelf$iv2 = includeSelf$iv;
                i5 = i7;
                node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                $i$f$getTraversableOLwlOKw = type$iv;
                delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                includeSelf$iv = includeSelf$iv2;
                i7 = i5;
                if (node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                node3 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node = node$iv$iv$iv;
                    i4 = 0;
                    i8 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    if (count$iv$iv2 != 0) {
                    } else {
                    }
                    includeSelf$iv2 = includeSelf$iv;
                    i5 = i7;
                    next$iv$iv = node;
                    $i$f$visitAncestorsYYKmho = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                    includeSelf$iv = includeSelf$iv2;
                    i7 = i5;
                    count$iv$iv++;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv;
                    includeSelf$iv2 = includeSelf$iv;
                    i5 = i7;
                    $i$f$visitAncestorsYYKmho = 0;
                    $i$f$mutableVectorOf = stack$iv$iv;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node5 = node$iv$iv2;
                    if (node5 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    count$iv$iv = count$iv$iv2;
                    stack$iv$iv.add(node);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv2 = $i$f$mutableVectorOf;
                    stack$iv$iv.add(node5);
                    count$iv$iv2 = count$iv$iv;
                    i8 = 0;
                    i = i12;
                    includeSelf$iv2 = includeSelf$iv;
                    i5 = i7;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv2 = node;
                    includeSelf$iv2 = includeSelf$iv;
                    i5 = i7;
                    next$iv$iv = node;
                    $i$f$visitAncestorsYYKmho = 0;
                    count$iv$iv2 = 1;
                }
                if (count$iv$iv == 1) {
                } else {
                }
                $i$f$getTraversableOLwlOKw = type$iv;
                delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                includeSelf$iv = includeSelf$iv2;
                i7 = i5;
                node = node$iv$iv$iv;
                i4 = 0;
                i8 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                count$iv$iv2 = 0;
                if (count$iv$iv2 != 0) {
                } else {
                }
                includeSelf$iv2 = includeSelf$iv;
                i5 = i7;
                next$iv$iv = node;
                $i$f$visitAncestorsYYKmho = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = key;
                includeSelf$iv = includeSelf$iv2;
                i7 = i5;
                count$iv$iv++;
                if (count$iv$iv == 1) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                count$iv$iv2 = count$iv$iv;
                includeSelf$iv2 = includeSelf$iv;
                i5 = i7;
                $i$f$visitAncestorsYYKmho = 0;
                $i$f$mutableVectorOf = stack$iv$iv;
                stack$iv$iv = $i$f$mutableVectorOf;
                node5 = node$iv$iv2;
                if (node5 != null && stack$iv$iv != 0) {
                }
                if (stack$iv$iv != 0) {
                } else {
                }
                next$iv$iv = node;
                count$iv$iv = count$iv$iv2;
                stack$iv$iv.add(node);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv2 = $i$f$mutableVectorOf;
                stack$iv$iv.add(node5);
                count$iv$iv2 = count$iv$iv;
                i8 = 0;
                i = i12;
                includeSelf$iv2 = includeSelf$iv;
                i5 = i7;
                $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv2 = node;
                includeSelf$iv2 = includeSelf$iv;
                i5 = i7;
                next$iv$iv = node;
                $i$f$visitAncestorsYYKmho = 0;
                count$iv$iv2 = 1;
                $i$f$isKindH91voCI$ui_release = 1;
                $i$f$isKindH91voCI$ui_release = 0;
                node2 = node6;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = delegatableNode;
                includeSelf$iv2 = includeSelf$iv;
                i5 = i7;
            }
            return null;
        }
        int i17 = $i$f$getTraversableOLwlOKw;
        androidx.compose.ui.node.DelegatableNode delegatableNode3 = delegatableNode;
        int type$iv2 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv;
    }

    public static final <T extends androidx.compose.ui.node.TraversableNode> T findNearestAncestor(T $this$findNearestAncestor) {
        Object nodes$ui_release;
        int capacity$iv$iv$iv$iv;
        Modifier.Node next$iv$iv;
        androidx.compose.ui.node.DelegatableNode count$iv$iv;
        int this_$iv$iv$iv2;
        int count$iv$iv2;
        int $i$f$getTraversableOLwlOKw;
        boolean this_$iv$iv$iv3;
        int i7;
        Object traverseKey;
        Modifier.Node node$iv$iv2;
        androidx.compose.ui.node.LayoutNode layout$iv$iv;
        int node$iv$iv;
        Modifier.Node head$ui_release;
        int i11;
        int i6;
        Modifier.Node node;
        int i3;
        int i2;
        int node$iv$iv3;
        androidx.compose.ui.node.DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        int i8;
        int type$iv;
        int i5;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i9;
        int this_$iv$iv$iv;
        int i10;
        int i4;
        int count$iv$iv3;
        Modifier.Node this_$iv$iv$iv4;
        int i;
        count$iv$iv = nodes$ui_release;
        int i14 = 0;
        i7 = 0;
        final int i16 = 0;
        final int i17 = $i$f$getTraversableOLwlOKw;
        final androidx.compose.ui.node.DelegatableNode delegatableNode = count$iv$iv;
        final int i18 = 0;
        if (!delegatableNode.getNode().isAttached()) {
        } else {
            node$iv$iv2 = delegatableNode.getNode().getParent$ui_release();
            layout$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode);
            while (layout$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= i17 != 0) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                type$iv = $i$f$getTraversableOLwlOKw;
                i5 = i7;
                node$iv$iv3 = 0;
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                nodes$ui_release = layout$iv$iv.getNodes$ui_release();
                if (layout$iv$iv != null && nodes$ui_release != null) {
                } else {
                }
                node$iv$iv = node$iv$iv3;
                node$iv$iv2 = node$iv$iv;
                nodes$ui_release = $this$findNearestAncestor;
                count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                $i$f$getTraversableOLwlOKw = type$iv;
                i7 = i5;
                nodes$ui_release = layout$iv$iv.getNodes$ui_release();
                if (nodes$ui_release != null) {
                } else {
                }
                node$iv$iv = nodes$ui_release.getTail$ui_release();
                while (node$iv$iv2 != null) {
                    if (kindSet$ui_release2 &= i17 == 0) {
                        break loop_4;
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                    type$iv = $i$f$getTraversableOLwlOKw;
                    i5 = i7;
                    node$iv$iv3 = 0;
                    node$iv$iv2 = node$iv$iv2.getParent$ui_release();
                    nodes$ui_release = $this$findNearestAncestor;
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    $i$f$getTraversableOLwlOKw = type$iv;
                    i7 = i5;
                    i6 = 0;
                    i3 = 0;
                    i2 = 0;
                    int i19 = 0;
                    node$iv$iv = node$iv$iv4;
                    node$iv$iv3 = 0;
                    while (node$iv$iv != null) {
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                        type$iv = $i$f$getTraversableOLwlOKw;
                        this_$iv$iv$iv3 = 0;
                        if (kindSet$ui_release &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                        } else {
                        }
                        node$iv$iv = DelegatableNodeKt.access$pop(i2);
                        nodes$ui_release = $this$findNearestAncestor;
                        count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        $i$f$getTraversableOLwlOKw = type$iv;
                        i7 = i5;
                        if (node$iv$iv instanceof DelegatingNode) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        traverseKey = 0;
                        node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node2 = node$iv$iv$iv;
                            i9 = 0;
                            i10 = 0;
                            if (kindSet$ui_release3 &= type$iv != 0) {
                            } else {
                            }
                            this_$iv$iv$iv = 0;
                            if (this_$iv$iv$iv != 0) {
                            } else {
                            }
                            this_$iv$iv$iv4 = this_$iv$iv$iv3;
                            next$iv$iv = node2;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            this_$iv$iv$iv3 = this_$iv$iv$iv4;
                            nodes$ui_release = 1;
                            this_$iv$iv$iv2++;
                            if (this_$iv$iv$iv2 == nodes$ui_release) {
                            } else {
                            }
                            if (i2 == 0) {
                            } else {
                            }
                            count$iv$iv3 = this_$iv$iv$iv2;
                            this_$iv$iv$iv4 = this_$iv$iv$iv3;
                            capacity$iv$iv$iv$iv = 0;
                            count$iv$iv2 = i2;
                            this_$iv$iv$iv3 = node$iv$iv;
                            if (this_$iv$iv$iv3 != null && count$iv$iv2 != 0) {
                            }
                            if (count$iv$iv2 != 0) {
                            } else {
                            }
                            next$iv$iv = node2;
                            i2 = count$iv$iv2;
                            this_$iv$iv$iv2 = count$iv$iv3;
                            count$iv$iv2.add(node2);
                            if (count$iv$iv2 != 0) {
                            }
                            node$iv$iv = 0;
                            count$iv$iv2.add(this_$iv$iv$iv3);
                            this_$iv$iv$iv = 0;
                            int i13 = 16;
                            i4 = 0;
                            count$iv$iv3 = this_$iv$iv$iv2;
                            this_$iv$iv$iv4 = this_$iv$iv$iv3;
                            i = i13;
                            count$iv$iv2 = new MutableVector(new Modifier.Node[i13], 0);
                            node$iv$iv = node2;
                            this_$iv$iv$iv4 = this_$iv$iv$iv3;
                            next$iv$iv = node2;
                            this_$iv$iv$iv = nodes$ui_release;
                        }
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        if (this_$iv$iv$iv2 == 1) {
                        } else {
                        }
                        nodes$ui_release = $this$findNearestAncestor;
                        count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        $i$f$getTraversableOLwlOKw = type$iv;
                        i7 = i5;
                        node2 = node$iv$iv$iv;
                        i9 = 0;
                        i10 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        next$iv$iv = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        this_$iv$iv$iv3 = this_$iv$iv$iv4;
                        nodes$ui_release = 1;
                        this_$iv$iv$iv2++;
                        if (this_$iv$iv$iv2 == nodes$ui_release) {
                        } else {
                        }
                        if (i2 == 0) {
                        } else {
                        }
                        count$iv$iv3 = this_$iv$iv$iv2;
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        capacity$iv$iv$iv$iv = 0;
                        count$iv$iv2 = i2;
                        this_$iv$iv$iv3 = node$iv$iv;
                        if (this_$iv$iv$iv3 != null && count$iv$iv2 != 0) {
                        }
                        if (count$iv$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv = node2;
                        i2 = count$iv$iv2;
                        this_$iv$iv$iv2 = count$iv$iv3;
                        count$iv$iv2.add(node2);
                        if (count$iv$iv2 != 0) {
                        }
                        node$iv$iv = 0;
                        count$iv$iv2.add(this_$iv$iv$iv3);
                        this_$iv$iv$iv = 0;
                        i13 = 16;
                        i4 = 0;
                        count$iv$iv3 = this_$iv$iv$iv2;
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        i = i13;
                        count$iv$iv2 = new MutableVector(new Modifier.Node[i13], 0);
                        node$iv$iv = node2;
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        next$iv$iv = node2;
                        this_$iv$iv$iv = nodes$ui_release;
                        this_$iv$iv$iv2 = nodes$ui_release;
                        this_$iv$iv$iv2 = node$iv$iv;
                        i8 = 0;
                        type$iv = $i$f$getTraversableOLwlOKw;
                        i5 = i7;
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                    type$iv = $i$f$getTraversableOLwlOKw;
                    i5 = i7;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                    type$iv = $i$f$getTraversableOLwlOKw;
                    this_$iv$iv$iv3 = 0;
                    if (kindSet$ui_release &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    node$iv$iv = DelegatableNodeKt.access$pop(i2);
                    nodes$ui_release = $this$findNearestAncestor;
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    $i$f$getTraversableOLwlOKw = type$iv;
                    i7 = i5;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    traverseKey = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i9 = 0;
                        i10 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        next$iv$iv = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        this_$iv$iv$iv3 = this_$iv$iv$iv4;
                        nodes$ui_release = 1;
                        this_$iv$iv$iv2++;
                        if (this_$iv$iv$iv2 == nodes$ui_release) {
                        } else {
                        }
                        if (i2 == 0) {
                        } else {
                        }
                        count$iv$iv3 = this_$iv$iv$iv2;
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        capacity$iv$iv$iv$iv = 0;
                        count$iv$iv2 = i2;
                        this_$iv$iv$iv3 = node$iv$iv;
                        if (this_$iv$iv$iv3 != null && count$iv$iv2 != 0) {
                        }
                        if (count$iv$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv = node2;
                        i2 = count$iv$iv2;
                        this_$iv$iv$iv2 = count$iv$iv3;
                        count$iv$iv2.add(node2);
                        if (count$iv$iv2 != 0) {
                        }
                        node$iv$iv = 0;
                        count$iv$iv2.add(this_$iv$iv$iv3);
                        this_$iv$iv$iv = 0;
                        i13 = 16;
                        i4 = 0;
                        count$iv$iv3 = this_$iv$iv$iv2;
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        i = i13;
                        count$iv$iv2 = new MutableVector(new Modifier.Node[i13], 0);
                        node$iv$iv = node2;
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        next$iv$iv = node2;
                        this_$iv$iv$iv = nodes$ui_release;
                    }
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    if (this_$iv$iv$iv2 == 1) {
                    } else {
                    }
                    nodes$ui_release = $this$findNearestAncestor;
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    $i$f$getTraversableOLwlOKw = type$iv;
                    i7 = i5;
                    node2 = node$iv$iv$iv;
                    i9 = 0;
                    i10 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    next$iv$iv = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv3 = this_$iv$iv$iv4;
                    nodes$ui_release = 1;
                    this_$iv$iv$iv2++;
                    if (this_$iv$iv$iv2 == nodes$ui_release) {
                    } else {
                    }
                    if (i2 == 0) {
                    } else {
                    }
                    count$iv$iv3 = this_$iv$iv$iv2;
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    capacity$iv$iv$iv$iv = 0;
                    count$iv$iv2 = i2;
                    this_$iv$iv$iv3 = node$iv$iv;
                    if (this_$iv$iv$iv3 != null && count$iv$iv2 != 0) {
                    }
                    if (count$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    i2 = count$iv$iv2;
                    this_$iv$iv$iv2 = count$iv$iv3;
                    count$iv$iv2.add(node2);
                    if (count$iv$iv2 != 0) {
                    }
                    node$iv$iv = 0;
                    count$iv$iv2.add(this_$iv$iv$iv3);
                    this_$iv$iv$iv = 0;
                    i13 = 16;
                    i4 = 0;
                    count$iv$iv3 = this_$iv$iv$iv2;
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    i = i13;
                    count$iv$iv2 = new MutableVector(new Modifier.Node[i13], 0);
                    node$iv$iv = node2;
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    next$iv$iv = node2;
                    this_$iv$iv$iv = nodes$ui_release;
                    this_$iv$iv$iv2 = nodes$ui_release;
                    this_$iv$iv$iv2 = node$iv$iv;
                    i8 = 0;
                    type$iv = $i$f$getTraversableOLwlOKw;
                    i5 = i7;
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                type$iv = $i$f$getTraversableOLwlOKw;
                i5 = i7;
                node$iv$iv3 = 0;
                if (kindSet$ui_release2 &= i17 != 0) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                type$iv = $i$f$getTraversableOLwlOKw;
                i5 = i7;
                node$iv$iv3 = 0;
                node$iv$iv2 = node$iv$iv2.getParent$ui_release();
                nodes$ui_release = $this$findNearestAncestor;
                count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                $i$f$getTraversableOLwlOKw = type$iv;
                i7 = i5;
                i6 = 0;
                i3 = 0;
                i2 = 0;
                i19 = 0;
                node$iv$iv = node$iv$iv4;
                node$iv$iv3 = 0;
                while (node$iv$iv != null) {
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                    type$iv = $i$f$getTraversableOLwlOKw;
                    this_$iv$iv$iv3 = 0;
                    if (kindSet$ui_release &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    node$iv$iv = DelegatableNodeKt.access$pop(i2);
                    nodes$ui_release = $this$findNearestAncestor;
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    $i$f$getTraversableOLwlOKw = type$iv;
                    i7 = i5;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    traverseKey = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i9 = 0;
                        i10 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        next$iv$iv = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        this_$iv$iv$iv3 = this_$iv$iv$iv4;
                        nodes$ui_release = 1;
                        this_$iv$iv$iv2++;
                        if (this_$iv$iv$iv2 == nodes$ui_release) {
                        } else {
                        }
                        if (i2 == 0) {
                        } else {
                        }
                        count$iv$iv3 = this_$iv$iv$iv2;
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        capacity$iv$iv$iv$iv = 0;
                        count$iv$iv2 = i2;
                        this_$iv$iv$iv3 = node$iv$iv;
                        if (this_$iv$iv$iv3 != null && count$iv$iv2 != 0) {
                        }
                        if (count$iv$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv = node2;
                        i2 = count$iv$iv2;
                        this_$iv$iv$iv2 = count$iv$iv3;
                        count$iv$iv2.add(node2);
                        if (count$iv$iv2 != 0) {
                        }
                        node$iv$iv = 0;
                        count$iv$iv2.add(this_$iv$iv$iv3);
                        this_$iv$iv$iv = 0;
                        i13 = 16;
                        i4 = 0;
                        count$iv$iv3 = this_$iv$iv$iv2;
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        i = i13;
                        count$iv$iv2 = new MutableVector(new Modifier.Node[i13], 0);
                        node$iv$iv = node2;
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        next$iv$iv = node2;
                        this_$iv$iv$iv = nodes$ui_release;
                    }
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    if (this_$iv$iv$iv2 == 1) {
                    } else {
                    }
                    nodes$ui_release = $this$findNearestAncestor;
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    $i$f$getTraversableOLwlOKw = type$iv;
                    i7 = i5;
                    node2 = node$iv$iv$iv;
                    i9 = 0;
                    i10 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    next$iv$iv = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv3 = this_$iv$iv$iv4;
                    nodes$ui_release = 1;
                    this_$iv$iv$iv2++;
                    if (this_$iv$iv$iv2 == nodes$ui_release) {
                    } else {
                    }
                    if (i2 == 0) {
                    } else {
                    }
                    count$iv$iv3 = this_$iv$iv$iv2;
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    capacity$iv$iv$iv$iv = 0;
                    count$iv$iv2 = i2;
                    this_$iv$iv$iv3 = node$iv$iv;
                    if (this_$iv$iv$iv3 != null && count$iv$iv2 != 0) {
                    }
                    if (count$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    i2 = count$iv$iv2;
                    this_$iv$iv$iv2 = count$iv$iv3;
                    count$iv$iv2.add(node2);
                    if (count$iv$iv2 != 0) {
                    }
                    node$iv$iv = 0;
                    count$iv$iv2.add(this_$iv$iv$iv3);
                    this_$iv$iv$iv = 0;
                    i13 = 16;
                    i4 = 0;
                    count$iv$iv3 = this_$iv$iv$iv2;
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    i = i13;
                    count$iv$iv2 = new MutableVector(new Modifier.Node[i13], 0);
                    node$iv$iv = node2;
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    next$iv$iv = node2;
                    this_$iv$iv$iv = nodes$ui_release;
                    this_$iv$iv$iv2 = nodes$ui_release;
                    this_$iv$iv$iv2 = node$iv$iv;
                    i8 = 0;
                    type$iv = $i$f$getTraversableOLwlOKw;
                    i5 = i7;
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                type$iv = $i$f$getTraversableOLwlOKw;
                i5 = i7;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                type$iv = $i$f$getTraversableOLwlOKw;
                this_$iv$iv$iv3 = 0;
                if (kindSet$ui_release &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                if (this_$iv$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                node$iv$iv = DelegatableNodeKt.access$pop(i2);
                nodes$ui_release = $this$findNearestAncestor;
                count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                $i$f$getTraversableOLwlOKw = type$iv;
                i7 = i5;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                traverseKey = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node2 = node$iv$iv$iv;
                    i9 = 0;
                    i10 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    next$iv$iv = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv3 = this_$iv$iv$iv4;
                    nodes$ui_release = 1;
                    this_$iv$iv$iv2++;
                    if (this_$iv$iv$iv2 == nodes$ui_release) {
                    } else {
                    }
                    if (i2 == 0) {
                    } else {
                    }
                    count$iv$iv3 = this_$iv$iv$iv2;
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    capacity$iv$iv$iv$iv = 0;
                    count$iv$iv2 = i2;
                    this_$iv$iv$iv3 = node$iv$iv;
                    if (this_$iv$iv$iv3 != null && count$iv$iv2 != 0) {
                    }
                    if (count$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    i2 = count$iv$iv2;
                    this_$iv$iv$iv2 = count$iv$iv3;
                    count$iv$iv2.add(node2);
                    if (count$iv$iv2 != 0) {
                    }
                    node$iv$iv = 0;
                    count$iv$iv2.add(this_$iv$iv$iv3);
                    this_$iv$iv$iv = 0;
                    i13 = 16;
                    i4 = 0;
                    count$iv$iv3 = this_$iv$iv$iv2;
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    i = i13;
                    count$iv$iv2 = new MutableVector(new Modifier.Node[i13], 0);
                    node$iv$iv = node2;
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    next$iv$iv = node2;
                    this_$iv$iv$iv = nodes$ui_release;
                }
                this_$iv$iv$iv4 = this_$iv$iv$iv3;
                if (this_$iv$iv$iv2 == 1) {
                } else {
                }
                nodes$ui_release = $this$findNearestAncestor;
                count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                $i$f$getTraversableOLwlOKw = type$iv;
                i7 = i5;
                node2 = node$iv$iv$iv;
                i9 = 0;
                i10 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                this_$iv$iv$iv4 = this_$iv$iv$iv3;
                next$iv$iv = node2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                this_$iv$iv$iv3 = this_$iv$iv$iv4;
                nodes$ui_release = 1;
                this_$iv$iv$iv2++;
                if (this_$iv$iv$iv2 == nodes$ui_release) {
                } else {
                }
                if (i2 == 0) {
                } else {
                }
                count$iv$iv3 = this_$iv$iv$iv2;
                this_$iv$iv$iv4 = this_$iv$iv$iv3;
                capacity$iv$iv$iv$iv = 0;
                count$iv$iv2 = i2;
                this_$iv$iv$iv3 = node$iv$iv;
                if (this_$iv$iv$iv3 != null && count$iv$iv2 != 0) {
                }
                if (count$iv$iv2 != 0) {
                } else {
                }
                next$iv$iv = node2;
                i2 = count$iv$iv2;
                this_$iv$iv$iv2 = count$iv$iv3;
                count$iv$iv2.add(node2);
                if (count$iv$iv2 != 0) {
                }
                node$iv$iv = 0;
                count$iv$iv2.add(this_$iv$iv$iv3);
                this_$iv$iv$iv = 0;
                i13 = 16;
                i4 = 0;
                count$iv$iv3 = this_$iv$iv$iv2;
                this_$iv$iv$iv4 = this_$iv$iv$iv3;
                i = i13;
                count$iv$iv2 = new MutableVector(new Modifier.Node[i13], 0);
                node$iv$iv = node2;
                this_$iv$iv$iv4 = this_$iv$iv$iv3;
                next$iv$iv = node2;
                this_$iv$iv$iv = nodes$ui_release;
                this_$iv$iv$iv2 = nodes$ui_release;
                this_$iv$iv$iv2 = node$iv$iv;
                i8 = 0;
                type$iv = $i$f$getTraversableOLwlOKw;
                i5 = i7;
            }
            return 0;
        }
        androidx.compose.ui.node.DelegatableNode delegatableNode2 = count$iv$iv;
        int i12 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv;
    }

    public static final void traverseAncestors(androidx.compose.ui.node.DelegatableNode $this$traverseAncestors, Object key, Function1<? super androidx.compose.ui.node.TraversableNode, Boolean> block) {
        int $i$f$getTraversableOLwlOKw;
        int tail$ui_release;
        Modifier.Node count$iv$iv;
        androidx.compose.ui.node.DelegatableNode delegatableNode;
        int $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        Modifier.Node next$iv$iv;
        int $i$f$mutableVectorOf;
        int i2;
        Object includeSelf$iv;
        int i5;
        int $i$f$visitAncestorsYYKmho;
        Modifier.Node node$iv$iv;
        androidx.compose.ui.node.LayoutNode layout$iv$iv;
        Modifier.Node head$ui_release;
        int i8;
        int i9;
        Modifier.Node node;
        int i7;
        int stack$iv$iv;
        Modifier.Node node$iv$iv2;
        int type$iv;
        int booleanValue;
        int $i$f$isKindH91voCI$ui_release;
        androidx.compose.ui.node.DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
        int i;
        int i6;
        Modifier.Node node3;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i4;
        int count$iv$iv2;
        int i3;
        int i10;
        int $i$f$visitAncestorsYYKmho2;
        int i11 = 0;
        $i$f$getTraversableOLwlOKw = NodeKind.constructor-impl(262144);
        delegatableNode = $this$traverseAncestors;
        i2 = 0;
        i5 = 0;
        final int i15 = $i$f$getTraversableOLwlOKw;
        final androidx.compose.ui.node.DelegatableNode delegatableNode2 = delegatableNode;
        final int i16 = 0;
        if (!delegatableNode2.getNode().isAttached()) {
        } else {
            node$iv$iv = delegatableNode2.getNode().getParent$ui_release();
            layout$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode2);
            while (layout$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= i15 != 0) {
                } else {
                }
                type$iv = $i$f$getTraversableOLwlOKw;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                i = i2;
                $i$f$visitAncestorsYYKmho2 = i5;
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                $i$f$getTraversableOLwlOKw = layout$iv$iv.getNodes$ui_release();
                if (layout$iv$iv != null && $i$f$getTraversableOLwlOKw != null) {
                } else {
                }
                tail$ui_release = 0;
                node$iv$iv = tail$ui_release;
                $i$f$getTraversableOLwlOKw = type$iv;
                delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                i2 = i;
                i5 = $i$f$visitAncestorsYYKmho2;
                $i$f$getTraversableOLwlOKw = layout$iv$iv.getNodes$ui_release();
                if ($i$f$getTraversableOLwlOKw != null) {
                } else {
                }
                tail$ui_release = $i$f$getTraversableOLwlOKw.getTail$ui_release();
                while (node$iv$iv != null) {
                    if (kindSet$ui_release &= i15 == 0) {
                        break loop_4;
                    } else {
                    }
                    type$iv = $i$f$getTraversableOLwlOKw;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                    i = i2;
                    $i$f$visitAncestorsYYKmho2 = i5;
                    node$iv$iv = node$iv$iv.getParent$ui_release();
                    $i$f$getTraversableOLwlOKw = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    i2 = i;
                    i5 = $i$f$visitAncestorsYYKmho2;
                    i9 = 0;
                    i7 = 0;
                    stack$iv$iv = 0;
                    int i17 = 0;
                    node$iv$iv2 = node;
                    while (node$iv$iv2 != null) {
                        type$iv = $i$f$getTraversableOLwlOKw;
                        includeSelf$iv = key;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                        count$iv$iv = node$iv$iv2;
                        int i19 = 0;
                        node3 = count$iv$iv;
                        if (kindSet$ui_release2 &= type$iv != 0) {
                        } else {
                        }
                        $i$f$isKindH91voCI$ui_release = 0;
                        if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        $i$f$visitAncestorsYYKmho2 = i5;
                        node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                        $i$f$getTraversableOLwlOKw = type$iv;
                        delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        i2 = i;
                        i5 = $i$f$visitAncestorsYYKmho2;
                        if (node$iv$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv = 0;
                        node3 = 0;
                        node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node2 = node$iv$iv$iv;
                            i4 = 0;
                            i3 = 0;
                            if (kindSet$ui_release3 &= type$iv != 0) {
                            } else {
                            }
                            count$iv$iv2 = 0;
                            if (count$iv$iv2 != 0) {
                            } else {
                            }
                            $i$f$visitAncestorsYYKmho2 = i5;
                            next$iv$iv = node2;
                            $i$f$visitAncestorsYYKmho = 0;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            includeSelf$iv = key;
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                            i5 = $i$f$visitAncestorsYYKmho2;
                            count$iv$iv++;
                            if (count$iv$iv == 1) {
                            } else {
                            }
                            if (stack$iv$iv == 0) {
                            } else {
                            }
                            count$iv$iv2 = count$iv$iv;
                            $i$f$visitAncestorsYYKmho2 = i5;
                            $i$f$visitAncestorsYYKmho = 0;
                            $i$f$mutableVectorOf = stack$iv$iv;
                            stack$iv$iv = $i$f$mutableVectorOf;
                            Modifier.Node node4 = node$iv$iv2;
                            if (node4 != null && stack$iv$iv != 0) {
                            }
                            if (stack$iv$iv != 0) {
                            } else {
                            }
                            next$iv$iv = node2;
                            count$iv$iv = count$iv$iv2;
                            stack$iv$iv.add(node2);
                            if (stack$iv$iv != 0) {
                            }
                            node$iv$iv2 = $i$f$mutableVectorOf;
                            stack$iv$iv.add(node4);
                            count$iv$iv2 = count$iv$iv;
                            i3 = 0;
                            i10 = i14;
                            $i$f$visitAncestorsYYKmho2 = i5;
                            $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                            node$iv$iv2 = node2;
                            $i$f$visitAncestorsYYKmho2 = i5;
                            next$iv$iv = node2;
                            $i$f$visitAncestorsYYKmho = 0;
                            count$iv$iv2 = 1;
                        }
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        $i$f$getTraversableOLwlOKw = type$iv;
                        delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        i2 = i;
                        i5 = $i$f$visitAncestorsYYKmho2;
                        node2 = node$iv$iv$iv;
                        i4 = 0;
                        i3 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        count$iv$iv2 = 0;
                        if (count$iv$iv2 != 0) {
                        } else {
                        }
                        $i$f$visitAncestorsYYKmho2 = i5;
                        next$iv$iv = node2;
                        $i$f$visitAncestorsYYKmho = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        includeSelf$iv = key;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                        i5 = $i$f$visitAncestorsYYKmho2;
                        count$iv$iv++;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv;
                        $i$f$visitAncestorsYYKmho2 = i5;
                        $i$f$visitAncestorsYYKmho = 0;
                        $i$f$mutableVectorOf = stack$iv$iv;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node4 = node$iv$iv2;
                        if (node4 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node2;
                        count$iv$iv = count$iv$iv2;
                        stack$iv$iv.add(node2);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv2 = $i$f$mutableVectorOf;
                        stack$iv$iv.add(node4);
                        count$iv$iv2 = count$iv$iv;
                        i3 = 0;
                        i10 = i14;
                        $i$f$visitAncestorsYYKmho2 = i5;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv2 = node2;
                        $i$f$visitAncestorsYYKmho2 = i5;
                        next$iv$iv = node2;
                        $i$f$visitAncestorsYYKmho = 0;
                        count$iv$iv2 = 1;
                        $i$f$isKindH91voCI$ui_release = 1;
                        count$iv$iv = node$iv$iv2;
                        $i$f$isKindH91voCI$ui_release = 0;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                        i = i2;
                        if (Intrinsics.areEqual(key, (TraversableNode)count$iv$iv.getTraverseKey())) {
                        } else {
                        }
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                        booleanValue = 1;
                        $i$f$visitAncestorsYYKmho2 = i5;
                        booleanValue = (Boolean)block.invoke(count$iv$iv).booleanValue();
                    }
                    type$iv = $i$f$getTraversableOLwlOKw;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                    i = i2;
                    $i$f$visitAncestorsYYKmho2 = i5;
                    type$iv = $i$f$getTraversableOLwlOKw;
                    includeSelf$iv = key;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                    count$iv$iv = node$iv$iv2;
                    i19 = 0;
                    node3 = count$iv$iv;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$visitAncestorsYYKmho2 = i5;
                    node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                    $i$f$getTraversableOLwlOKw = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    i2 = i;
                    i5 = $i$f$visitAncestorsYYKmho2;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    node3 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i4 = 0;
                        i3 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        count$iv$iv2 = 0;
                        if (count$iv$iv2 != 0) {
                        } else {
                        }
                        $i$f$visitAncestorsYYKmho2 = i5;
                        next$iv$iv = node2;
                        $i$f$visitAncestorsYYKmho = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        includeSelf$iv = key;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                        i5 = $i$f$visitAncestorsYYKmho2;
                        count$iv$iv++;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv;
                        $i$f$visitAncestorsYYKmho2 = i5;
                        $i$f$visitAncestorsYYKmho = 0;
                        $i$f$mutableVectorOf = stack$iv$iv;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node4 = node$iv$iv2;
                        if (node4 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node2;
                        count$iv$iv = count$iv$iv2;
                        stack$iv$iv.add(node2);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv2 = $i$f$mutableVectorOf;
                        stack$iv$iv.add(node4);
                        count$iv$iv2 = count$iv$iv;
                        i3 = 0;
                        i10 = i14;
                        $i$f$visitAncestorsYYKmho2 = i5;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv2 = node2;
                        $i$f$visitAncestorsYYKmho2 = i5;
                        next$iv$iv = node2;
                        $i$f$visitAncestorsYYKmho = 0;
                        count$iv$iv2 = 1;
                    }
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    $i$f$getTraversableOLwlOKw = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    i2 = i;
                    i5 = $i$f$visitAncestorsYYKmho2;
                    node2 = node$iv$iv$iv;
                    i4 = 0;
                    i3 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    if (count$iv$iv2 != 0) {
                    } else {
                    }
                    $i$f$visitAncestorsYYKmho2 = i5;
                    next$iv$iv = node2;
                    $i$f$visitAncestorsYYKmho = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    includeSelf$iv = key;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                    i5 = $i$f$visitAncestorsYYKmho2;
                    count$iv$iv++;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv;
                    $i$f$visitAncestorsYYKmho2 = i5;
                    $i$f$visitAncestorsYYKmho = 0;
                    $i$f$mutableVectorOf = stack$iv$iv;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node4 = node$iv$iv2;
                    if (node4 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    count$iv$iv = count$iv$iv2;
                    stack$iv$iv.add(node2);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv2 = $i$f$mutableVectorOf;
                    stack$iv$iv.add(node4);
                    count$iv$iv2 = count$iv$iv;
                    i3 = 0;
                    i10 = i14;
                    $i$f$visitAncestorsYYKmho2 = i5;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv2 = node2;
                    $i$f$visitAncestorsYYKmho2 = i5;
                    next$iv$iv = node2;
                    $i$f$visitAncestorsYYKmho = 0;
                    count$iv$iv2 = 1;
                    $i$f$isKindH91voCI$ui_release = 1;
                    count$iv$iv = node$iv$iv2;
                    $i$f$isKindH91voCI$ui_release = 0;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                    i = i2;
                    if (Intrinsics.areEqual(key, (TraversableNode)count$iv$iv.getTraverseKey())) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                    booleanValue = 1;
                    $i$f$visitAncestorsYYKmho2 = i5;
                    booleanValue = (Boolean)block.invoke(count$iv$iv).booleanValue();
                }
                type$iv = $i$f$getTraversableOLwlOKw;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                i = i2;
                $i$f$visitAncestorsYYKmho2 = i5;
                if (kindSet$ui_release &= i15 != 0) {
                } else {
                }
                type$iv = $i$f$getTraversableOLwlOKw;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                i = i2;
                $i$f$visitAncestorsYYKmho2 = i5;
                node$iv$iv = node$iv$iv.getParent$ui_release();
                $i$f$getTraversableOLwlOKw = type$iv;
                delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                i2 = i;
                i5 = $i$f$visitAncestorsYYKmho2;
                i9 = 0;
                i7 = 0;
                stack$iv$iv = 0;
                i17 = 0;
                node$iv$iv2 = node;
                while (node$iv$iv2 != null) {
                    type$iv = $i$f$getTraversableOLwlOKw;
                    includeSelf$iv = key;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                    count$iv$iv = node$iv$iv2;
                    i19 = 0;
                    node3 = count$iv$iv;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$visitAncestorsYYKmho2 = i5;
                    node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                    $i$f$getTraversableOLwlOKw = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    i2 = i;
                    i5 = $i$f$visitAncestorsYYKmho2;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    node3 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i4 = 0;
                        i3 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        count$iv$iv2 = 0;
                        if (count$iv$iv2 != 0) {
                        } else {
                        }
                        $i$f$visitAncestorsYYKmho2 = i5;
                        next$iv$iv = node2;
                        $i$f$visitAncestorsYYKmho = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        includeSelf$iv = key;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                        i5 = $i$f$visitAncestorsYYKmho2;
                        count$iv$iv++;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv;
                        $i$f$visitAncestorsYYKmho2 = i5;
                        $i$f$visitAncestorsYYKmho = 0;
                        $i$f$mutableVectorOf = stack$iv$iv;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node4 = node$iv$iv2;
                        if (node4 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node2;
                        count$iv$iv = count$iv$iv2;
                        stack$iv$iv.add(node2);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv2 = $i$f$mutableVectorOf;
                        stack$iv$iv.add(node4);
                        count$iv$iv2 = count$iv$iv;
                        i3 = 0;
                        i10 = i14;
                        $i$f$visitAncestorsYYKmho2 = i5;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv2 = node2;
                        $i$f$visitAncestorsYYKmho2 = i5;
                        next$iv$iv = node2;
                        $i$f$visitAncestorsYYKmho = 0;
                        count$iv$iv2 = 1;
                    }
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    $i$f$getTraversableOLwlOKw = type$iv;
                    delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    i2 = i;
                    i5 = $i$f$visitAncestorsYYKmho2;
                    node2 = node$iv$iv$iv;
                    i4 = 0;
                    i3 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    if (count$iv$iv2 != 0) {
                    } else {
                    }
                    $i$f$visitAncestorsYYKmho2 = i5;
                    next$iv$iv = node2;
                    $i$f$visitAncestorsYYKmho = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    includeSelf$iv = key;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                    i5 = $i$f$visitAncestorsYYKmho2;
                    count$iv$iv++;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv;
                    $i$f$visitAncestorsYYKmho2 = i5;
                    $i$f$visitAncestorsYYKmho = 0;
                    $i$f$mutableVectorOf = stack$iv$iv;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node4 = node$iv$iv2;
                    if (node4 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    count$iv$iv = count$iv$iv2;
                    stack$iv$iv.add(node2);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv2 = $i$f$mutableVectorOf;
                    stack$iv$iv.add(node4);
                    count$iv$iv2 = count$iv$iv;
                    i3 = 0;
                    i10 = i14;
                    $i$f$visitAncestorsYYKmho2 = i5;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv2 = node2;
                    $i$f$visitAncestorsYYKmho2 = i5;
                    next$iv$iv = node2;
                    $i$f$visitAncestorsYYKmho = 0;
                    count$iv$iv2 = 1;
                    $i$f$isKindH91voCI$ui_release = 1;
                    count$iv$iv = node$iv$iv2;
                    $i$f$isKindH91voCI$ui_release = 0;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                    i = i2;
                    if (Intrinsics.areEqual(key, (TraversableNode)count$iv$iv.getTraverseKey())) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                    booleanValue = 1;
                    $i$f$visitAncestorsYYKmho2 = i5;
                    booleanValue = (Boolean)block.invoke(count$iv$iv).booleanValue();
                }
                type$iv = $i$f$getTraversableOLwlOKw;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                i = i2;
                $i$f$visitAncestorsYYKmho2 = i5;
                type$iv = $i$f$getTraversableOLwlOKw;
                includeSelf$iv = key;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                count$iv$iv = node$iv$iv2;
                i19 = 0;
                node3 = count$iv$iv;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                $i$f$isKindH91voCI$ui_release = 0;
                if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                $i$f$visitAncestorsYYKmho2 = i5;
                node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                $i$f$getTraversableOLwlOKw = type$iv;
                delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                i2 = i;
                i5 = $i$f$visitAncestorsYYKmho2;
                if (node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                node3 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node2 = node$iv$iv$iv;
                    i4 = 0;
                    i3 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    if (count$iv$iv2 != 0) {
                    } else {
                    }
                    $i$f$visitAncestorsYYKmho2 = i5;
                    next$iv$iv = node2;
                    $i$f$visitAncestorsYYKmho = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    includeSelf$iv = key;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                    i5 = $i$f$visitAncestorsYYKmho2;
                    count$iv$iv++;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv;
                    $i$f$visitAncestorsYYKmho2 = i5;
                    $i$f$visitAncestorsYYKmho = 0;
                    $i$f$mutableVectorOf = stack$iv$iv;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node4 = node$iv$iv2;
                    if (node4 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    count$iv$iv = count$iv$iv2;
                    stack$iv$iv.add(node2);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv2 = $i$f$mutableVectorOf;
                    stack$iv$iv.add(node4);
                    count$iv$iv2 = count$iv$iv;
                    i3 = 0;
                    i10 = i14;
                    $i$f$visitAncestorsYYKmho2 = i5;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv2 = node2;
                    $i$f$visitAncestorsYYKmho2 = i5;
                    next$iv$iv = node2;
                    $i$f$visitAncestorsYYKmho = 0;
                    count$iv$iv2 = 1;
                }
                if (count$iv$iv == 1) {
                } else {
                }
                $i$f$getTraversableOLwlOKw = type$iv;
                delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                i2 = i;
                i5 = $i$f$visitAncestorsYYKmho2;
                node2 = node$iv$iv$iv;
                i4 = 0;
                i3 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                count$iv$iv2 = 0;
                if (count$iv$iv2 != 0) {
                } else {
                }
                $i$f$visitAncestorsYYKmho2 = i5;
                next$iv$iv = node2;
                $i$f$visitAncestorsYYKmho = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                includeSelf$iv = key;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                i5 = $i$f$visitAncestorsYYKmho2;
                count$iv$iv++;
                if (count$iv$iv == 1) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                count$iv$iv2 = count$iv$iv;
                $i$f$visitAncestorsYYKmho2 = i5;
                $i$f$visitAncestorsYYKmho = 0;
                $i$f$mutableVectorOf = stack$iv$iv;
                stack$iv$iv = $i$f$mutableVectorOf;
                node4 = node$iv$iv2;
                if (node4 != null && stack$iv$iv != 0) {
                }
                if (stack$iv$iv != 0) {
                } else {
                }
                next$iv$iv = node2;
                count$iv$iv = count$iv$iv2;
                stack$iv$iv.add(node2);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv2 = $i$f$mutableVectorOf;
                stack$iv$iv.add(node4);
                count$iv$iv2 = count$iv$iv;
                i3 = 0;
                i10 = i14;
                $i$f$visitAncestorsYYKmho2 = i5;
                $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv2 = node2;
                $i$f$visitAncestorsYYKmho2 = i5;
                next$iv$iv = node2;
                $i$f$visitAncestorsYYKmho = 0;
                count$iv$iv2 = 1;
                $i$f$isKindH91voCI$ui_release = 1;
                count$iv$iv = node$iv$iv2;
                $i$f$isKindH91voCI$ui_release = 0;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = delegatableNode;
                i = i2;
                if (Intrinsics.areEqual(key, (TraversableNode)count$iv$iv.getTraverseKey())) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = block;
                booleanValue = 1;
                $i$f$visitAncestorsYYKmho2 = i5;
                booleanValue = (Boolean)block.invoke(count$iv$iv).booleanValue();
            }
        }
        int i18 = $i$f$getTraversableOLwlOKw;
        androidx.compose.ui.node.DelegatableNode delegatableNode3 = delegatableNode;
        int type$iv2 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv;
    }

    public static final <T extends androidx.compose.ui.node.TraversableNode> void traverseAncestors(T $this$traverseAncestors, Function1<? super T, Boolean> block) {
        Object next$iv$iv;
        int capacity$iv$iv$iv$iv;
        int tail$ui_release;
        androidx.compose.ui.node.DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        int node$iv$iv2;
        int $i$f$getTraversableOLwlOKw;
        int this_$iv$iv$iv;
        Modifier.Node node$iv$iv4;
        int i6;
        boolean objectsOfSameType;
        Object includeSelf$iv3;
        Object includeSelf$iv;
        Object includeSelf$iv2;
        int i9;
        Object booleanValue;
        Modifier.Node node$iv$iv;
        androidx.compose.ui.node.LayoutNode layout$iv$iv;
        Modifier.Node head$ui_release;
        int i8;
        int i10;
        Modifier.Node node2;
        int i12;
        int stack$iv$iv;
        Modifier.Node $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
        int type$iv;
        boolean z;
        int i5;
        int includeSelf$iv4;
        int i4;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node3;
        int i11;
        int this_$iv$iv$iv2;
        int i3;
        int i;
        Modifier.Node node$iv$iv3;
        int i2;
        int i7;
        Modifier.Node node;
        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = next$iv$iv;
        int i16 = 0;
        i6 = 0;
        i9 = 0;
        final int i18 = $i$f$getTraversableOLwlOKw;
        final androidx.compose.ui.node.DelegatableNode delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        final int i19 = 0;
        if (!delegatableNode.getNode().isAttached()) {
        } else {
            node$iv$iv = delegatableNode.getNode().getParent$ui_release();
            layout$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode);
            while (layout$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= i18 != 0) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                type$iv = $i$f$getTraversableOLwlOKw;
                includeSelf$iv4 = i6;
                i4 = i9;
                includeSelf$iv2 = block;
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                next$iv$iv = layout$iv$iv.getNodes$ui_release();
                if (layout$iv$iv != null && next$iv$iv != null) {
                } else {
                }
                tail$ui_release = 0;
                node$iv$iv = tail$ui_release;
                next$iv$iv = $this$traverseAncestors;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                $i$f$getTraversableOLwlOKw = type$iv;
                i6 = includeSelf$iv4;
                i9 = i4;
                next$iv$iv = layout$iv$iv.getNodes$ui_release();
                if (next$iv$iv != null) {
                } else {
                }
                tail$ui_release = next$iv$iv.getTail$ui_release();
                while (node$iv$iv != null) {
                    if (kindSet$ui_release &= i18 == 0) {
                        break loop_4;
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    type$iv = $i$f$getTraversableOLwlOKw;
                    includeSelf$iv4 = i6;
                    i4 = i9;
                    includeSelf$iv = block;
                    node$iv$iv = node$iv$iv.getParent$ui_release();
                    next$iv$iv = $this$traverseAncestors;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    $i$f$getTraversableOLwlOKw = type$iv;
                    i6 = includeSelf$iv4;
                    i9 = i4;
                    i10 = 0;
                    i12 = 0;
                    stack$iv$iv = 0;
                    int i20 = 0;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node;
                    while ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv != null) {
                        type$iv = $i$f$getTraversableOLwlOKw;
                        includeSelf$iv3 = block;
                        booleanValue = 0;
                        if (kindSet$ui_release2 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0 && $this$visitAncestors_u2dY_u2dYKmho_u24default$iv instanceof DelegatingNode) {
                        } else {
                        }
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                        next$iv$iv = $this$traverseAncestors;
                        $i$f$getTraversableOLwlOKw = type$iv;
                        i6 = includeSelf$iv4;
                        i9 = i4;
                        if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv instanceof DelegatingNode) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        i5 = 0;
                        node$iv$iv$iv = (DelegatingNode)$this$visitAncestors_u2dY_u2dYKmho_u24default$iv.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node3 = node$iv$iv$iv;
                            i11 = 0;
                            i3 = 0;
                            if (kindSet$ui_release3 &= type$iv != 0) {
                            } else {
                            }
                            this_$iv$iv$iv2 = 0;
                            if (this_$iv$iv$iv2 != 0) {
                            } else {
                            }
                            node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                            next$iv$iv = node3;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            this_$iv$iv$iv++;
                            if (this_$iv$iv$iv == 1) {
                            } else {
                            }
                            if (stack$iv$iv == 0) {
                            } else {
                            }
                            node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                            i2 = this_$iv$iv$iv;
                            capacity$iv$iv$iv$iv = 0;
                            node$iv$iv2 = stack$iv$iv;
                            stack$iv$iv = node$iv$iv2;
                            Modifier.Node node4 = node$iv$iv3;
                            if (node4 != null) {
                            } else {
                            }
                            node$iv$iv4 = node$iv$iv3;
                            if (stack$iv$iv != 0) {
                            } else {
                            }
                            next$iv$iv = node3;
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv4;
                            this_$iv$iv$iv = i2;
                            stack$iv$iv.add(node3);
                            if (stack$iv$iv != 0) {
                            }
                            node$iv$iv4 = 0;
                            stack$iv$iv.add(node4);
                            i3 = i15;
                            int $i$f$mutableVectorOf = 16;
                            i = 0;
                            node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                            i2 = this_$iv$iv$iv;
                            i7 = $i$f$mutableVectorOf;
                            node$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node3;
                            next$iv$iv = node3;
                            this_$iv$iv$iv2 = 1;
                        }
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        if (this_$iv$iv$iv == 1) {
                        } else {
                        }
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv3;
                        next$iv$iv = $this$traverseAncestors;
                        $i$f$getTraversableOLwlOKw = type$iv;
                        i6 = includeSelf$iv4;
                        i9 = i4;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv3;
                        node3 = node$iv$iv$iv;
                        i11 = 0;
                        i3 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        next$iv$iv = node3;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        this_$iv$iv$iv++;
                        if (this_$iv$iv$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        i2 = this_$iv$iv$iv;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv2 = stack$iv$iv;
                        stack$iv$iv = node$iv$iv2;
                        node4 = node$iv$iv3;
                        if (node4 != null) {
                        } else {
                        }
                        node$iv$iv4 = node$iv$iv3;
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node3;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv4;
                        this_$iv$iv$iv = i2;
                        stack$iv$iv.add(node3);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv4 = 0;
                        stack$iv$iv.add(node4);
                        i3 = i15;
                        $i$f$mutableVectorOf = 16;
                        i = 0;
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        i2 = this_$iv$iv$iv;
                        i7 = $i$f$mutableVectorOf;
                        node$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node3;
                        next$iv$iv = node3;
                        this_$iv$iv$iv2 = 1;
                        this_$iv$iv$iv = 1;
                        this_$iv$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        i5 = 0;
                        includeSelf$iv4 = i6;
                        i4 = i9;
                        if (Intrinsics.areEqual(next$iv$iv.getTraverseKey(), (TraversableNode)this_$iv$iv$iv.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(next$iv$iv, this_$iv$iv$iv)) {
                        } else {
                        }
                        includeSelf$iv3 = block;
                        z = 1;
                        if (Actual_jvmKt.areObjectsOfSameType(next$iv$iv, this_$iv$iv$iv)) {
                        } else {
                        }
                        z = booleanValue;
                    }
                    type$iv = $i$f$getTraversableOLwlOKw;
                    includeSelf$iv4 = i6;
                    i4 = i9;
                    includeSelf$iv = block;
                    type$iv = $i$f$getTraversableOLwlOKw;
                    includeSelf$iv3 = block;
                    booleanValue = 0;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0 && $this$visitAncestors_u2dY_u2dYKmho_u24default$iv instanceof DelegatingNode) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                    next$iv$iv = $this$traverseAncestors;
                    $i$f$getTraversableOLwlOKw = type$iv;
                    i6 = includeSelf$iv4;
                    i9 = i4;
                    if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    i5 = 0;
                    node$iv$iv$iv = (DelegatingNode)$this$visitAncestors_u2dY_u2dYKmho_u24default$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node3 = node$iv$iv$iv;
                        i11 = 0;
                        i3 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        next$iv$iv = node3;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        this_$iv$iv$iv++;
                        if (this_$iv$iv$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        i2 = this_$iv$iv$iv;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv2 = stack$iv$iv;
                        stack$iv$iv = node$iv$iv2;
                        node4 = node$iv$iv3;
                        if (node4 != null) {
                        } else {
                        }
                        node$iv$iv4 = node$iv$iv3;
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node3;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv4;
                        this_$iv$iv$iv = i2;
                        stack$iv$iv.add(node3);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv4 = 0;
                        stack$iv$iv.add(node4);
                        i3 = i15;
                        $i$f$mutableVectorOf = 16;
                        i = 0;
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        i2 = this_$iv$iv$iv;
                        i7 = $i$f$mutableVectorOf;
                        node$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node3;
                        next$iv$iv = node3;
                        this_$iv$iv$iv2 = 1;
                    }
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    if (this_$iv$iv$iv == 1) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv3;
                    next$iv$iv = $this$traverseAncestors;
                    $i$f$getTraversableOLwlOKw = type$iv;
                    i6 = includeSelf$iv4;
                    i9 = i4;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv3;
                    node3 = node$iv$iv$iv;
                    i11 = 0;
                    i3 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    next$iv$iv = node3;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv++;
                    if (this_$iv$iv$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    i2 = this_$iv$iv$iv;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv2 = stack$iv$iv;
                    stack$iv$iv = node$iv$iv2;
                    node4 = node$iv$iv3;
                    if (node4 != null) {
                    } else {
                    }
                    node$iv$iv4 = node$iv$iv3;
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node3;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv4;
                    this_$iv$iv$iv = i2;
                    stack$iv$iv.add(node3);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv4 = 0;
                    stack$iv$iv.add(node4);
                    i3 = i15;
                    $i$f$mutableVectorOf = 16;
                    i = 0;
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    i2 = this_$iv$iv$iv;
                    i7 = $i$f$mutableVectorOf;
                    node$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node3;
                    next$iv$iv = node3;
                    this_$iv$iv$iv2 = 1;
                    this_$iv$iv$iv = 1;
                    this_$iv$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    i5 = 0;
                    includeSelf$iv4 = i6;
                    i4 = i9;
                    if (Intrinsics.areEqual(next$iv$iv.getTraverseKey(), (TraversableNode)this_$iv$iv$iv.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(next$iv$iv, this_$iv$iv$iv)) {
                    } else {
                    }
                    includeSelf$iv3 = block;
                    z = 1;
                    if (Actual_jvmKt.areObjectsOfSameType(next$iv$iv, this_$iv$iv$iv)) {
                    } else {
                    }
                    z = booleanValue;
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                type$iv = $i$f$getTraversableOLwlOKw;
                includeSelf$iv4 = i6;
                i4 = i9;
                includeSelf$iv2 = block;
                if (kindSet$ui_release &= i18 != 0) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                type$iv = $i$f$getTraversableOLwlOKw;
                includeSelf$iv4 = i6;
                i4 = i9;
                includeSelf$iv = block;
                node$iv$iv = node$iv$iv.getParent$ui_release();
                next$iv$iv = $this$traverseAncestors;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                $i$f$getTraversableOLwlOKw = type$iv;
                i6 = includeSelf$iv4;
                i9 = i4;
                i10 = 0;
                i12 = 0;
                stack$iv$iv = 0;
                i20 = 0;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node;
                while ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv != null) {
                    type$iv = $i$f$getTraversableOLwlOKw;
                    includeSelf$iv3 = block;
                    booleanValue = 0;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0 && $this$visitAncestors_u2dY_u2dYKmho_u24default$iv instanceof DelegatingNode) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                    next$iv$iv = $this$traverseAncestors;
                    $i$f$getTraversableOLwlOKw = type$iv;
                    i6 = includeSelf$iv4;
                    i9 = i4;
                    if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    i5 = 0;
                    node$iv$iv$iv = (DelegatingNode)$this$visitAncestors_u2dY_u2dYKmho_u24default$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node3 = node$iv$iv$iv;
                        i11 = 0;
                        i3 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        next$iv$iv = node3;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        this_$iv$iv$iv++;
                        if (this_$iv$iv$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        i2 = this_$iv$iv$iv;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv2 = stack$iv$iv;
                        stack$iv$iv = node$iv$iv2;
                        node4 = node$iv$iv3;
                        if (node4 != null) {
                        } else {
                        }
                        node$iv$iv4 = node$iv$iv3;
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node3;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv4;
                        this_$iv$iv$iv = i2;
                        stack$iv$iv.add(node3);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv4 = 0;
                        stack$iv$iv.add(node4);
                        i3 = i15;
                        $i$f$mutableVectorOf = 16;
                        i = 0;
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        i2 = this_$iv$iv$iv;
                        i7 = $i$f$mutableVectorOf;
                        node$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node3;
                        next$iv$iv = node3;
                        this_$iv$iv$iv2 = 1;
                    }
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    if (this_$iv$iv$iv == 1) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv3;
                    next$iv$iv = $this$traverseAncestors;
                    $i$f$getTraversableOLwlOKw = type$iv;
                    i6 = includeSelf$iv4;
                    i9 = i4;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv3;
                    node3 = node$iv$iv$iv;
                    i11 = 0;
                    i3 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    next$iv$iv = node3;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv++;
                    if (this_$iv$iv$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    i2 = this_$iv$iv$iv;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv2 = stack$iv$iv;
                    stack$iv$iv = node$iv$iv2;
                    node4 = node$iv$iv3;
                    if (node4 != null) {
                    } else {
                    }
                    node$iv$iv4 = node$iv$iv3;
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node3;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv4;
                    this_$iv$iv$iv = i2;
                    stack$iv$iv.add(node3);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv4 = 0;
                    stack$iv$iv.add(node4);
                    i3 = i15;
                    $i$f$mutableVectorOf = 16;
                    i = 0;
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    i2 = this_$iv$iv$iv;
                    i7 = $i$f$mutableVectorOf;
                    node$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node3;
                    next$iv$iv = node3;
                    this_$iv$iv$iv2 = 1;
                    this_$iv$iv$iv = 1;
                    this_$iv$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    i5 = 0;
                    includeSelf$iv4 = i6;
                    i4 = i9;
                    if (Intrinsics.areEqual(next$iv$iv.getTraverseKey(), (TraversableNode)this_$iv$iv$iv.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(next$iv$iv, this_$iv$iv$iv)) {
                    } else {
                    }
                    includeSelf$iv3 = block;
                    z = 1;
                    if (Actual_jvmKt.areObjectsOfSameType(next$iv$iv, this_$iv$iv$iv)) {
                    } else {
                    }
                    z = booleanValue;
                }
                type$iv = $i$f$getTraversableOLwlOKw;
                includeSelf$iv4 = i6;
                i4 = i9;
                includeSelf$iv = block;
                type$iv = $i$f$getTraversableOLwlOKw;
                includeSelf$iv3 = block;
                booleanValue = 0;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0 && $this$visitAncestors_u2dY_u2dYKmho_u24default$iv instanceof DelegatingNode) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                next$iv$iv = $this$traverseAncestors;
                $i$f$getTraversableOLwlOKw = type$iv;
                i6 = includeSelf$iv4;
                i9 = i4;
                if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv = 0;
                i5 = 0;
                node$iv$iv$iv = (DelegatingNode)$this$visitAncestors_u2dY_u2dYKmho_u24default$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node3 = node$iv$iv$iv;
                    i11 = 0;
                    i3 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    next$iv$iv = node3;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv++;
                    if (this_$iv$iv$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    i2 = this_$iv$iv$iv;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv2 = stack$iv$iv;
                    stack$iv$iv = node$iv$iv2;
                    node4 = node$iv$iv3;
                    if (node4 != null) {
                    } else {
                    }
                    node$iv$iv4 = node$iv$iv3;
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node3;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv4;
                    this_$iv$iv$iv = i2;
                    stack$iv$iv.add(node3);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv4 = 0;
                    stack$iv$iv.add(node4);
                    i3 = i15;
                    $i$f$mutableVectorOf = 16;
                    i = 0;
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    i2 = this_$iv$iv$iv;
                    i7 = $i$f$mutableVectorOf;
                    node$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node3;
                    next$iv$iv = node3;
                    this_$iv$iv$iv2 = 1;
                }
                node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                if (this_$iv$iv$iv == 1) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv3;
                next$iv$iv = $this$traverseAncestors;
                $i$f$getTraversableOLwlOKw = type$iv;
                i6 = includeSelf$iv4;
                i9 = i4;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv3;
                node3 = node$iv$iv$iv;
                i11 = 0;
                i3 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                next$iv$iv = node3;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                this_$iv$iv$iv++;
                if (this_$iv$iv$iv == 1) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                i2 = this_$iv$iv$iv;
                capacity$iv$iv$iv$iv = 0;
                node$iv$iv2 = stack$iv$iv;
                stack$iv$iv = node$iv$iv2;
                node4 = node$iv$iv3;
                if (node4 != null) {
                } else {
                }
                node$iv$iv4 = node$iv$iv3;
                if (stack$iv$iv != 0) {
                } else {
                }
                next$iv$iv = node3;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv4;
                this_$iv$iv$iv = i2;
                stack$iv$iv.add(node3);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv4 = 0;
                stack$iv$iv.add(node4);
                i3 = i15;
                $i$f$mutableVectorOf = 16;
                i = 0;
                node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                i2 = this_$iv$iv$iv;
                i7 = $i$f$mutableVectorOf;
                node$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node3;
                next$iv$iv = node3;
                this_$iv$iv$iv2 = 1;
                this_$iv$iv$iv = 1;
                this_$iv$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                i5 = 0;
                includeSelf$iv4 = i6;
                i4 = i9;
                if (Intrinsics.areEqual(next$iv$iv.getTraverseKey(), (TraversableNode)this_$iv$iv$iv.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(next$iv$iv, this_$iv$iv$iv)) {
                } else {
                }
                includeSelf$iv3 = block;
                z = 1;
                if (Actual_jvmKt.areObjectsOfSameType(next$iv$iv, this_$iv$iv$iv)) {
                } else {
                }
                z = booleanValue;
            }
        }
        androidx.compose.ui.node.DelegatableNode delegatableNode2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        int i13 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv;
    }

    public static final void traverseChildren(androidx.compose.ui.node.DelegatableNode $this$traverseChildren, Object key, Function1<? super androidx.compose.ui.node.TraversableNode, Boolean> block) {
        int $i$f$getTraversableOLwlOKw;
        int i7;
        Object obj;
        Object type$iv2;
        Modifier.Node next$iv$iv;
        int capacity$iv$iv$iv$iv;
        Object obj2;
        Object $this$visitChildren_u2d6rFNWt0$iv;
        int $i$f$visitChildren6rFNWt02;
        int node2;
        int node$iv$iv2;
        Modifier.Node[] arr;
        int i2;
        Modifier.Node[] node$iv$iv;
        int count$iv$iv2;
        Modifier.Node[] count$iv$iv;
        int i5;
        Modifier.Node[] objArr;
        int i;
        int i3;
        Modifier.Node[] node$iv$iv3;
        int i8;
        int type$iv;
        Object obj5;
        int booleanValue;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node;
        int i4;
        int this_$iv$iv$iv;
        int i6;
        int $i$f$visitChildren6rFNWt0;
        int i9;
        int i10 = 0;
        $i$f$getTraversableOLwlOKw = NodeKind.constructor-impl(262144);
        obj2 = $this$traverseChildren;
        $i$f$visitChildren6rFNWt02 = 0;
        final int i14 = $i$f$getTraversableOLwlOKw;
        final Object obj3 = obj2;
        final int i15 = 0;
        if (!obj3.getNode().isAttached()) {
        } else {
            int i16 = 0;
            node$iv$iv2 = 0;
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = obj3.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, obj3.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                int i17 = 0;
                count$iv$iv2 = 1;
                node2 = mutableVector2.removeAt(size -= count$iv$iv2);
                if (aggregateChildKindSet$ui_release &= i14 == 0) {
                } else {
                }
                node$iv$iv2 = node2;
                while (node$iv$iv2 != 0) {
                    obj5 = obj2;
                    $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                    int type$iv4 = count$iv$iv2;
                    node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                    $i$f$getTraversableOLwlOKw = type$iv;
                    i2 = 0;
                }
                type$iv = $i$f$getTraversableOLwlOKw;
                obj5 = obj2;
                $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                i2 = 0;
                if (kindSet$ui_release &= i14 != null) {
                } else {
                }
                obj5 = obj2;
                $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                type$iv4 = count$iv$iv2;
                node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                $i$f$getTraversableOLwlOKw = type$iv;
                i2 = 0;
                i5 = 0;
                i = 0;
                i3 = 0;
                int i18 = 0;
                node$iv$iv = node$iv$iv3;
                while (node$iv$iv != null) {
                    type$iv = $i$f$getTraversableOLwlOKw;
                    $this$visitChildren_u2d6rFNWt0$iv = key;
                    type$iv2 = block;
                    i8 = 0;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    count$iv$iv = 0;
                    if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                    i7 = 1;
                    node$iv$iv = DelegatableNodeKt.access$pop(i3);
                    count$iv$iv2 = i7;
                    $i$f$getTraversableOLwlOKw = type$iv;
                    obj2 = obj5;
                    $i$f$visitChildren6rFNWt02 = $i$f$visitChildren6rFNWt0;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    booleanValue = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node = node$iv$iv$iv;
                        i4 = 0;
                        i6 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                        next$iv$iv = node;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $this$visitChildren_u2d6rFNWt0$iv = key;
                        type$iv2 = block;
                        $i$f$visitChildren6rFNWt02 = $i$f$visitChildren6rFNWt0;
                        if (count$iv$iv++ == 1) {
                        } else {
                        }
                        if (i3 == 0) {
                        } else {
                        }
                        $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                        capacity$iv$iv$iv$iv = 0;
                        $this$visitChildren_u2d6rFNWt0$iv = i3;
                        $i$f$visitChildren6rFNWt02 = node$iv$iv;
                        if ($i$f$visitChildren6rFNWt02 != null && $this$visitChildren_u2d6rFNWt0$iv != 0) {
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
                        $this$visitChildren_u2d6rFNWt0$iv.add($i$f$visitChildren6rFNWt02);
                        this_$iv$iv$iv = i12;
                        int $i$f$mutableVectorOf = 16;
                        i6 = 0;
                        $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                        i9 = $i$f$mutableVectorOf;
                        $this$visitChildren_u2d6rFNWt0$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv = node;
                        $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                        next$iv$iv = node;
                        this_$iv$iv$iv = 1;
                    }
                    i7 = 1;
                    if (count$iv$iv == i7) {
                    } else {
                    }
                    count$iv$iv2 = i7;
                    $i$f$getTraversableOLwlOKw = type$iv;
                    obj2 = obj5;
                    $i$f$visitChildren6rFNWt02 = $i$f$visitChildren6rFNWt0;
                    node = node$iv$iv$iv;
                    i4 = 0;
                    i6 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                    next$iv$iv = node;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitChildren_u2d6rFNWt0$iv = key;
                    type$iv2 = block;
                    $i$f$visitChildren6rFNWt02 = $i$f$visitChildren6rFNWt0;
                    if (count$iv$iv++ == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                    capacity$iv$iv$iv$iv = 0;
                    $this$visitChildren_u2d6rFNWt0$iv = i3;
                    $i$f$visitChildren6rFNWt02 = node$iv$iv;
                    if ($i$f$visitChildren6rFNWt02 != null && $this$visitChildren_u2d6rFNWt0$iv != 0) {
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
                    $this$visitChildren_u2d6rFNWt0$iv.add($i$f$visitChildren6rFNWt02);
                    this_$iv$iv$iv = i12;
                    $i$f$mutableVectorOf = 16;
                    i6 = 0;
                    $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                    i9 = $i$f$mutableVectorOf;
                    $this$visitChildren_u2d6rFNWt0$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv = node;
                    $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                    next$iv$iv = node;
                    this_$iv$iv$iv = 1;
                    count$iv$iv = 1;
                    count$iv$iv = node$iv$iv;
                    i8 = 0;
                    type$iv = $i$f$getTraversableOLwlOKw;
                    obj5 = obj2;
                    if (Intrinsics.areEqual(key, (TraversableNode)count$iv$iv.getTraverseKey())) {
                    } else {
                    }
                    obj = block;
                    booleanValue = 1;
                    $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                    i7 = 1;
                    booleanValue = (Boolean)block.invoke(count$iv$iv).booleanValue();
                }
                type$iv = $i$f$getTraversableOLwlOKw;
                obj5 = obj2;
                $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                i2 = 0;
                type$iv = $i$f$getTraversableOLwlOKw;
                $this$visitChildren_u2d6rFNWt0$iv = key;
                type$iv2 = block;
                i8 = 0;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                count$iv$iv = 0;
                if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                i7 = 1;
                node$iv$iv = DelegatableNodeKt.access$pop(i3);
                count$iv$iv2 = i7;
                $i$f$getTraversableOLwlOKw = type$iv;
                obj2 = obj5;
                $i$f$visitChildren6rFNWt02 = $i$f$visitChildren6rFNWt0;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                booleanValue = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node = node$iv$iv$iv;
                    i4 = 0;
                    i6 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                    next$iv$iv = node;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitChildren_u2d6rFNWt0$iv = key;
                    type$iv2 = block;
                    $i$f$visitChildren6rFNWt02 = $i$f$visitChildren6rFNWt0;
                    if (count$iv$iv++ == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                    capacity$iv$iv$iv$iv = 0;
                    $this$visitChildren_u2d6rFNWt0$iv = i3;
                    $i$f$visitChildren6rFNWt02 = node$iv$iv;
                    if ($i$f$visitChildren6rFNWt02 != null && $this$visitChildren_u2d6rFNWt0$iv != 0) {
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
                    $this$visitChildren_u2d6rFNWt0$iv.add($i$f$visitChildren6rFNWt02);
                    this_$iv$iv$iv = i12;
                    $i$f$mutableVectorOf = 16;
                    i6 = 0;
                    $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                    i9 = $i$f$mutableVectorOf;
                    $this$visitChildren_u2d6rFNWt0$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv = node;
                    $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                    next$iv$iv = node;
                    this_$iv$iv$iv = 1;
                }
                i7 = 1;
                if (count$iv$iv == i7) {
                } else {
                }
                count$iv$iv2 = i7;
                $i$f$getTraversableOLwlOKw = type$iv;
                obj2 = obj5;
                $i$f$visitChildren6rFNWt02 = $i$f$visitChildren6rFNWt0;
                node = node$iv$iv$iv;
                i4 = 0;
                i6 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                next$iv$iv = node;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $this$visitChildren_u2d6rFNWt0$iv = key;
                type$iv2 = block;
                $i$f$visitChildren6rFNWt02 = $i$f$visitChildren6rFNWt0;
                if (count$iv$iv++ == 1) {
                } else {
                }
                if (i3 == 0) {
                } else {
                }
                $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                capacity$iv$iv$iv$iv = 0;
                $this$visitChildren_u2d6rFNWt0$iv = i3;
                $i$f$visitChildren6rFNWt02 = node$iv$iv;
                if ($i$f$visitChildren6rFNWt02 != null && $this$visitChildren_u2d6rFNWt0$iv != 0) {
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
                $this$visitChildren_u2d6rFNWt0$iv.add($i$f$visitChildren6rFNWt02);
                this_$iv$iv$iv = i12;
                $i$f$mutableVectorOf = 16;
                i6 = 0;
                $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                i9 = $i$f$mutableVectorOf;
                $this$visitChildren_u2d6rFNWt0$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv = node;
                $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                next$iv$iv = node;
                this_$iv$iv$iv = 1;
                count$iv$iv = 1;
                count$iv$iv = node$iv$iv;
                i8 = 0;
                type$iv = $i$f$getTraversableOLwlOKw;
                obj5 = obj2;
                if (Intrinsics.areEqual(key, (TraversableNode)count$iv$iv.getTraverseKey())) {
                } else {
                }
                obj = block;
                booleanValue = 1;
                $i$f$visitChildren6rFNWt0 = $i$f$visitChildren6rFNWt02;
                i7 = 1;
                booleanValue = (Boolean)block.invoke(count$iv$iv).booleanValue();
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node2);
            }
        }
        int i19 = $i$f$getTraversableOLwlOKw;
        Object obj4 = obj2;
        int type$iv3 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv;
    }

    public static final <T extends androidx.compose.ui.node.TraversableNode> void traverseChildren(T $this$traverseChildren, Function1<? super T, Boolean> block) {
        Object obj;
        int i7;
        int capacity$iv$iv$iv$iv;
        Modifier.Node next$iv$iv;
        Object obj2;
        MutableVector $this$visitChildren_u2d6rFNWt0$iv2;
        boolean objectsOfSameType;
        int $i$f$getTraversableOLwlOKw;
        int this_$iv$iv$iv2;
        int node;
        int node$iv$iv2;
        Modifier.Node[] arr;
        int i5;
        Modifier.Node[] node$iv$iv3;
        int i10;
        Modifier.Node[] objArr;
        int i9;
        Modifier.Node[] objArr2;
        int i6;
        int i3;
        Modifier.Node[] node$iv$iv;
        int i;
        Object $this$visitChildren_u2d6rFNWt0$iv;
        int i2;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i11;
        int this_$iv$iv$iv;
        int i8;
        int count$iv$iv;
        int i4;
        obj2 = obj;
        int i16 = 0;
        int i18 = 0;
        final int i19 = $i$f$getTraversableOLwlOKw;
        final Object obj3 = obj2;
        final int i20 = 0;
        if (!obj3.getNode().isAttached()) {
        } else {
            int i21 = 0;
            node$iv$iv2 = 0;
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = obj3.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, obj3.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                int i22 = 0;
                i10 = 1;
                node = mutableVector2.removeAt(size -= i10);
                if (aggregateChildKindSet$ui_release &= i19 == 0) {
                } else {
                }
                node$iv$iv2 = node;
                while (node$iv$iv2 != 0) {
                    $this$visitChildren_u2d6rFNWt0$iv = obj2;
                    i2 = $i$f$getTraversableOLwlOKw;
                    int i12 = i10;
                    node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                    i5 = 0;
                    obj = $this$traverseChildren;
                }
                $this$visitChildren_u2d6rFNWt0$iv = obj2;
                i2 = $i$f$getTraversableOLwlOKw;
                obj = $this$traverseChildren;
                i5 = 0;
                if (kindSet$ui_release &= i19 != null) {
                } else {
                }
                $this$visitChildren_u2d6rFNWt0$iv = obj2;
                i2 = $i$f$getTraversableOLwlOKw;
                i12 = i10;
                node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                i5 = 0;
                obj = $this$traverseChildren;
                i9 = 0;
                i6 = 0;
                i3 = 0;
                int i23 = 0;
                node$iv$iv3 = node$iv$iv;
                while (node$iv$iv3 != null) {
                    i2 = $i$f$getTraversableOLwlOKw;
                    $this$visitChildren_u2d6rFNWt0$iv2 = block;
                    objArr = 0;
                    if (kindSet$ui_release2 &= i2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0 && node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    i7 = 1;
                    node$iv$iv3 = DelegatableNodeKt.access$pop(i3);
                    i10 = i7;
                    obj2 = $this$visitChildren_u2d6rFNWt0$iv;
                    $i$f$getTraversableOLwlOKw = i2;
                    obj = $this$traverseChildren;
                    if (node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    i = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i11 = 0;
                        i8 = 0;
                        if (kindSet$ui_release3 &= i2 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        obj = $this$traverseChildren;
                        $this$visitChildren_u2d6rFNWt0$iv2 = block;
                        this_$iv$iv$iv2++;
                        if (this_$iv$iv$iv2 == 1) {
                        } else {
                        }
                        if (i3 == 0) {
                        } else {
                        }
                        count$iv$iv = this_$iv$iv$iv2;
                        capacity$iv$iv$iv$iv = 0;
                        $this$visitChildren_u2d6rFNWt0$iv2 = i3;
                        Modifier.Node[] objArr3 = node$iv$iv3;
                        if (objArr3 != null && $this$visitChildren_u2d6rFNWt0$iv2 != null) {
                        }
                        if ($this$visitChildren_u2d6rFNWt0$iv2 != null) {
                        } else {
                        }
                        next$iv$iv = node2;
                        i3 = $this$visitChildren_u2d6rFNWt0$iv2;
                        this_$iv$iv$iv2 = count$iv$iv;
                        $this$visitChildren_u2d6rFNWt0$iv2.add(node2);
                        if ($this$visitChildren_u2d6rFNWt0$iv2 != null) {
                        }
                        node$iv$iv3 = 0;
                        $this$visitChildren_u2d6rFNWt0$iv2.add(objArr3);
                        this_$iv$iv$iv = i14;
                        int $i$f$mutableVectorOf = 16;
                        i8 = 0;
                        count$iv$iv = this_$iv$iv$iv2;
                        i4 = $i$f$mutableVectorOf;
                        $this$visitChildren_u2d6rFNWt0$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv3 = node2;
                        next$iv$iv = node2;
                        this_$iv$iv$iv = 1;
                    }
                    i7 = 1;
                    if (this_$iv$iv$iv2 == i7) {
                    } else {
                    }
                    i10 = i7;
                    obj2 = $this$visitChildren_u2d6rFNWt0$iv;
                    $i$f$getTraversableOLwlOKw = i2;
                    obj = $this$traverseChildren;
                    node2 = node$iv$iv$iv;
                    i11 = 0;
                    i8 = 0;
                    if (kindSet$ui_release3 &= i2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    obj = $this$traverseChildren;
                    $this$visitChildren_u2d6rFNWt0$iv2 = block;
                    this_$iv$iv$iv2++;
                    if (this_$iv$iv$iv2 == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    count$iv$iv = this_$iv$iv$iv2;
                    capacity$iv$iv$iv$iv = 0;
                    $this$visitChildren_u2d6rFNWt0$iv2 = i3;
                    objArr3 = node$iv$iv3;
                    if (objArr3 != null && $this$visitChildren_u2d6rFNWt0$iv2 != null) {
                    }
                    if ($this$visitChildren_u2d6rFNWt0$iv2 != null) {
                    } else {
                    }
                    next$iv$iv = node2;
                    i3 = $this$visitChildren_u2d6rFNWt0$iv2;
                    this_$iv$iv$iv2 = count$iv$iv;
                    $this$visitChildren_u2d6rFNWt0$iv2.add(node2);
                    if ($this$visitChildren_u2d6rFNWt0$iv2 != null) {
                    }
                    node$iv$iv3 = 0;
                    $this$visitChildren_u2d6rFNWt0$iv2.add(objArr3);
                    this_$iv$iv$iv = i14;
                    $i$f$mutableVectorOf = 16;
                    i8 = 0;
                    count$iv$iv = this_$iv$iv$iv2;
                    i4 = $i$f$mutableVectorOf;
                    $this$visitChildren_u2d6rFNWt0$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv3 = node2;
                    next$iv$iv = node2;
                    this_$iv$iv$iv = 1;
                    this_$iv$iv$iv2 = 1;
                    objArr = node$iv$iv3;
                    i = 0;
                    $this$visitChildren_u2d6rFNWt0$iv = obj2;
                    i2 = $i$f$getTraversableOLwlOKw;
                    if (Intrinsics.areEqual(obj.getTraverseKey(), (TraversableNode)objArr.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(obj, objArr)) {
                    } else {
                    }
                    $this$visitChildren_u2d6rFNWt0$iv2 = block;
                    this_$iv$iv$iv2 = 1;
                    i7 = 1;
                    if (Actual_jvmKt.areObjectsOfSameType(obj, objArr)) {
                    } else {
                    }
                    this_$iv$iv$iv2 = (Boolean)block.invoke(objArr).booleanValue();
                }
                $this$visitChildren_u2d6rFNWt0$iv = obj2;
                i2 = $i$f$getTraversableOLwlOKw;
                obj = $this$traverseChildren;
                i5 = 0;
                i2 = $i$f$getTraversableOLwlOKw;
                $this$visitChildren_u2d6rFNWt0$iv2 = block;
                objArr = 0;
                if (kindSet$ui_release2 &= i2 != 0) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                if (this_$iv$iv$iv2 != 0 && node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                i7 = 1;
                node$iv$iv3 = DelegatableNodeKt.access$pop(i3);
                i10 = i7;
                obj2 = $this$visitChildren_u2d6rFNWt0$iv;
                $i$f$getTraversableOLwlOKw = i2;
                obj = $this$traverseChildren;
                if (node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                i = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node2 = node$iv$iv$iv;
                    i11 = 0;
                    i8 = 0;
                    if (kindSet$ui_release3 &= i2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    obj = $this$traverseChildren;
                    $this$visitChildren_u2d6rFNWt0$iv2 = block;
                    this_$iv$iv$iv2++;
                    if (this_$iv$iv$iv2 == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    count$iv$iv = this_$iv$iv$iv2;
                    capacity$iv$iv$iv$iv = 0;
                    $this$visitChildren_u2d6rFNWt0$iv2 = i3;
                    objArr3 = node$iv$iv3;
                    if (objArr3 != null && $this$visitChildren_u2d6rFNWt0$iv2 != null) {
                    }
                    if ($this$visitChildren_u2d6rFNWt0$iv2 != null) {
                    } else {
                    }
                    next$iv$iv = node2;
                    i3 = $this$visitChildren_u2d6rFNWt0$iv2;
                    this_$iv$iv$iv2 = count$iv$iv;
                    $this$visitChildren_u2d6rFNWt0$iv2.add(node2);
                    if ($this$visitChildren_u2d6rFNWt0$iv2 != null) {
                    }
                    node$iv$iv3 = 0;
                    $this$visitChildren_u2d6rFNWt0$iv2.add(objArr3);
                    this_$iv$iv$iv = i14;
                    $i$f$mutableVectorOf = 16;
                    i8 = 0;
                    count$iv$iv = this_$iv$iv$iv2;
                    i4 = $i$f$mutableVectorOf;
                    $this$visitChildren_u2d6rFNWt0$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv3 = node2;
                    next$iv$iv = node2;
                    this_$iv$iv$iv = 1;
                }
                i7 = 1;
                if (this_$iv$iv$iv2 == i7) {
                } else {
                }
                i10 = i7;
                obj2 = $this$visitChildren_u2d6rFNWt0$iv;
                $i$f$getTraversableOLwlOKw = i2;
                obj = $this$traverseChildren;
                node2 = node$iv$iv$iv;
                i11 = 0;
                i8 = 0;
                if (kindSet$ui_release3 &= i2 != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                next$iv$iv = node2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                obj = $this$traverseChildren;
                $this$visitChildren_u2d6rFNWt0$iv2 = block;
                this_$iv$iv$iv2++;
                if (this_$iv$iv$iv2 == 1) {
                } else {
                }
                if (i3 == 0) {
                } else {
                }
                count$iv$iv = this_$iv$iv$iv2;
                capacity$iv$iv$iv$iv = 0;
                $this$visitChildren_u2d6rFNWt0$iv2 = i3;
                objArr3 = node$iv$iv3;
                if (objArr3 != null && $this$visitChildren_u2d6rFNWt0$iv2 != null) {
                }
                if ($this$visitChildren_u2d6rFNWt0$iv2 != null) {
                } else {
                }
                next$iv$iv = node2;
                i3 = $this$visitChildren_u2d6rFNWt0$iv2;
                this_$iv$iv$iv2 = count$iv$iv;
                $this$visitChildren_u2d6rFNWt0$iv2.add(node2);
                if ($this$visitChildren_u2d6rFNWt0$iv2 != null) {
                }
                node$iv$iv3 = 0;
                $this$visitChildren_u2d6rFNWt0$iv2.add(objArr3);
                this_$iv$iv$iv = i14;
                $i$f$mutableVectorOf = 16;
                i8 = 0;
                count$iv$iv = this_$iv$iv$iv2;
                i4 = $i$f$mutableVectorOf;
                $this$visitChildren_u2d6rFNWt0$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv3 = node2;
                next$iv$iv = node2;
                this_$iv$iv$iv = 1;
                this_$iv$iv$iv2 = 1;
                objArr = node$iv$iv3;
                i = 0;
                $this$visitChildren_u2d6rFNWt0$iv = obj2;
                i2 = $i$f$getTraversableOLwlOKw;
                if (Intrinsics.areEqual(obj.getTraverseKey(), (TraversableNode)objArr.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(obj, objArr)) {
                } else {
                }
                $this$visitChildren_u2d6rFNWt0$iv2 = block;
                this_$iv$iv$iv2 = 1;
                i7 = 1;
                if (Actual_jvmKt.areObjectsOfSameType(obj, objArr)) {
                } else {
                }
                this_$iv$iv$iv2 = (Boolean)block.invoke(objArr).booleanValue();
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node);
            }
        }
        Object obj4 = obj2;
        int i15 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv;
    }

    public static final void traverseDescendants(androidx.compose.ui.node.DelegatableNode $this$traverseDescendants, Object key, Function1<? super androidx.compose.ui.node.TraversableNode, ? extends androidx.compose.ui.node.TraversableNode.Companion.TraverseDescendantsAction> block) {
        int $i$f$getTraversableOLwlOKw;
        Object obj5;
        Object this_$iv$iv$iv3;
        int this_$iv$iv$iv2;
        Object obj6;
        int $this$visitSubtreeIf_u2d6rFNWt0$iv;
        int $i$f$visitSubtreeIf6rFNWt0;
        Modifier.Node next$iv$iv;
        int i8;
        int mask$iv$iv4;
        int mask$iv$iv;
        int mask$iv$iv5;
        int mask$iv$iv2;
        int node;
        String $i$a$CheckPreconditionDelegatableNodeKt$visitSubtreeIf$1$iv$iv;
        int i10;
        Modifier.Node[] node$iv$iv2;
        int node$iv$iv;
        Object obj3;
        int i9;
        Object obj;
        int i7;
        int i3;
        int i4;
        int node$iv$iv$iv;
        int type$iv;
        int i2;
        Object obj8;
        int i;
        Object obj2;
        Object continueTraversal;
        androidx.compose.ui.node.TraversableNode.Companion.TraverseDescendantsAction this_$iv$iv$iv;
        int this_$iv$iv$iv4;
        int count$iv$iv;
        int i6;
        int i5;
        int mask$iv$iv3;
        int i11 = 0;
        $i$f$visitSubtreeIf6rFNWt0 = 0;
        i8 = $i$f$getTraversableOLwlOKw;
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
            if (aggregateChildKindSet$ui_release &= i8 != 0) {
            } else {
            }
            type$iv = $i$f$getTraversableOLwlOKw;
            obj8 = obj5;
            i = $i$f$visitSubtreeIf6rFNWt0;
            mask$iv$iv3 = i8;
            mask$iv$iv4 = node$iv$iv;
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node);
            node$iv$iv = mask$iv$iv4;
            $i$f$getTraversableOLwlOKw = type$iv;
            obj5 = obj8;
            $i$f$visitSubtreeIf6rFNWt0 = i;
            i8 = mask$iv$iv3;
            node$iv$iv2 = node;
            while (node$iv$iv2 != null) {
                if (kindSet$ui_release2 &= i8 == 0) {
                    break loop_8;
                } else {
                }
                type$iv = $i$f$getTraversableOLwlOKw;
                obj8 = obj5;
                i = $i$f$visitSubtreeIf6rFNWt0;
                mask$iv$iv3 = i8;
                $this$visitSubtreeIf_u2d6rFNWt0$iv = i10;
                mask$iv$iv2 = node$iv$iv;
                node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                i10 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                node$iv$iv = mask$iv$iv2;
                $i$f$getTraversableOLwlOKw = type$iv;
                obj5 = obj8;
                $i$f$visitSubtreeIf6rFNWt0 = i;
                i8 = mask$iv$iv3;
                i9 = 0;
                i7 = 0;
                i3 = 0;
                int i19 = 0;
                node$iv$iv = node$iv$iv3;
                while (node$iv$iv != null) {
                    type$iv = $i$f$getTraversableOLwlOKw;
                    $i$f$visitSubtreeIf6rFNWt0 = key;
                    int i13 = 0;
                    if (kindSet$ui_release &= type$iv != 0) {
                    } else {
                    }
                    $i$f$getTraversableOLwlOKw = 0;
                    if ($i$f$getTraversableOLwlOKw != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv$iv3 = i8;
                    this_$iv$iv$iv2 = 1;
                    mask$iv$iv5 = 0;
                    node$iv$iv = DelegatableNodeKt.access$pop(i3);
                    i10 = this_$iv$iv$iv2;
                    $i$f$getTraversableOLwlOKw = type$iv;
                    obj5 = obj8;
                    $i$f$visitSubtreeIf6rFNWt0 = i;
                    i8 = mask$iv$iv3;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$getTraversableOLwlOKw = 0;
                    i10 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        i2 = node$iv$iv$iv;
                        obj2 = 0;
                        count$iv$iv = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv4 = 0;
                        if (this_$iv$iv$iv4 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = this_$iv$iv$iv3;
                        mask$iv$iv3 = i8;
                        next$iv$iv = i2;
                        mask$iv$iv = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $i$f$visitSubtreeIf6rFNWt0 = key;
                        this_$iv$iv$iv3 = this_$iv$iv$iv;
                        i8 = mask$iv$iv3;
                        $i$f$getTraversableOLwlOKw++;
                        this_$iv$iv$iv = this_$iv$iv$iv3;
                        if ($i$f$getTraversableOLwlOKw == 1) {
                        } else {
                        }
                        if (i3 == 0) {
                        } else {
                        }
                        count$iv$iv = $i$f$getTraversableOLwlOKw;
                        mask$iv$iv3 = i8;
                        mask$iv$iv = 0;
                        this_$iv$iv$iv3 = i3;
                        Object obj4 = node$iv$iv;
                        if (obj4 != null && this_$iv$iv$iv3 != 0) {
                        }
                        if (this_$iv$iv$iv3 != 0) {
                        } else {
                        }
                        next$iv$iv = i2;
                        i3 = this_$iv$iv$iv3;
                        $i$f$getTraversableOLwlOKw = count$iv$iv;
                        this_$iv$iv$iv3.add(i2);
                        if (this_$iv$iv$iv3 != 0) {
                        }
                        node$iv$iv = $i$f$visitSubtreeIf6rFNWt0;
                        this_$iv$iv$iv3.add(obj4);
                        count$iv$iv = $i$f$getTraversableOLwlOKw;
                        i6 = 0;
                        i5 = i14;
                        mask$iv$iv3 = i8;
                        this_$iv$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv = i2;
                        mask$iv$iv3 = i8;
                        next$iv$iv = i2;
                        mask$iv$iv = 0;
                        this_$iv$iv$iv4 = 1;
                    }
                    this_$iv$iv$iv = this_$iv$iv$iv3;
                    mask$iv$iv5 = 0;
                    this_$iv$iv$iv2 = 1;
                    if ($i$f$getTraversableOLwlOKw == this_$iv$iv$iv2) {
                    } else {
                    }
                    i10 = this_$iv$iv$iv2;
                    $i$f$getTraversableOLwlOKw = type$iv;
                    obj5 = obj8;
                    $i$f$visitSubtreeIf6rFNWt0 = i;
                    i8 = mask$iv$iv3;
                    i2 = node$iv$iv$iv;
                    obj2 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv4 = 0;
                    if (this_$iv$iv$iv4 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = this_$iv$iv$iv3;
                    mask$iv$iv3 = i8;
                    next$iv$iv = i2;
                    mask$iv$iv = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $i$f$visitSubtreeIf6rFNWt0 = key;
                    this_$iv$iv$iv3 = this_$iv$iv$iv;
                    i8 = mask$iv$iv3;
                    $i$f$getTraversableOLwlOKw++;
                    this_$iv$iv$iv = this_$iv$iv$iv3;
                    if ($i$f$getTraversableOLwlOKw == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    count$iv$iv = $i$f$getTraversableOLwlOKw;
                    mask$iv$iv3 = i8;
                    mask$iv$iv = 0;
                    this_$iv$iv$iv3 = i3;
                    obj4 = node$iv$iv;
                    if (obj4 != null && this_$iv$iv$iv3 != 0) {
                    }
                    if (this_$iv$iv$iv3 != 0) {
                    } else {
                    }
                    next$iv$iv = i2;
                    i3 = this_$iv$iv$iv3;
                    $i$f$getTraversableOLwlOKw = count$iv$iv;
                    this_$iv$iv$iv3.add(i2);
                    if (this_$iv$iv$iv3 != 0) {
                    }
                    node$iv$iv = $i$f$visitSubtreeIf6rFNWt0;
                    this_$iv$iv$iv3.add(obj4);
                    count$iv$iv = $i$f$getTraversableOLwlOKw;
                    i6 = 0;
                    i5 = i14;
                    mask$iv$iv3 = i8;
                    this_$iv$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = i2;
                    mask$iv$iv3 = i8;
                    next$iv$iv = i2;
                    mask$iv$iv = 0;
                    this_$iv$iv$iv4 = 1;
                    $i$f$getTraversableOLwlOKw = 1;
                    node$iv$iv$iv = 0;
                    type$iv = $i$f$getTraversableOLwlOKw;
                    Object type$iv3 = i10;
                    i2 = 0;
                    obj8 = obj5;
                    i = $i$f$visitSubtreeIf6rFNWt0;
                    if (Intrinsics.areEqual(key, (TraversableNode)type$iv3.getTraverseKey())) {
                    } else {
                    }
                    obj6 = block;
                    continueTraversal = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                    obj2 = type$iv3;
                    androidx.compose.ui.node.TraversableNode.Companion.TraverseDescendantsAction traverseDescendantsAction = this_$iv$iv$iv;
                    if (traverseDescendantsAction != TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                    } else {
                    }
                    $i$f$getTraversableOLwlOKw = 0;
                    mask$iv$iv3 = i8;
                    this_$iv$iv$iv2 = 1;
                    mask$iv$iv5 = 0;
                    $i$f$getTraversableOLwlOKw = 1;
                    continueTraversal = block.invoke(type$iv3);
                }
                type$iv = $i$f$getTraversableOLwlOKw;
                obj8 = obj5;
                i = $i$f$visitSubtreeIf6rFNWt0;
                mask$iv$iv3 = i8;
                mask$iv$iv2 = 0;
                i4 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                type$iv = $i$f$getTraversableOLwlOKw;
                $i$f$visitSubtreeIf6rFNWt0 = key;
                i13 = 0;
                if (kindSet$ui_release &= type$iv != 0) {
                } else {
                }
                $i$f$getTraversableOLwlOKw = 0;
                if ($i$f$getTraversableOLwlOKw != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                mask$iv$iv3 = i8;
                this_$iv$iv$iv2 = 1;
                mask$iv$iv5 = 0;
                node$iv$iv = DelegatableNodeKt.access$pop(i3);
                i10 = this_$iv$iv$iv2;
                $i$f$getTraversableOLwlOKw = type$iv;
                obj5 = obj8;
                $i$f$visitSubtreeIf6rFNWt0 = i;
                i8 = mask$iv$iv3;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                $i$f$getTraversableOLwlOKw = 0;
                i10 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    i2 = node$iv$iv$iv;
                    obj2 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv4 = 0;
                    if (this_$iv$iv$iv4 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = this_$iv$iv$iv3;
                    mask$iv$iv3 = i8;
                    next$iv$iv = i2;
                    mask$iv$iv = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $i$f$visitSubtreeIf6rFNWt0 = key;
                    this_$iv$iv$iv3 = this_$iv$iv$iv;
                    i8 = mask$iv$iv3;
                    $i$f$getTraversableOLwlOKw++;
                    this_$iv$iv$iv = this_$iv$iv$iv3;
                    if ($i$f$getTraversableOLwlOKw == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    count$iv$iv = $i$f$getTraversableOLwlOKw;
                    mask$iv$iv3 = i8;
                    mask$iv$iv = 0;
                    this_$iv$iv$iv3 = i3;
                    obj4 = node$iv$iv;
                    if (obj4 != null && this_$iv$iv$iv3 != 0) {
                    }
                    if (this_$iv$iv$iv3 != 0) {
                    } else {
                    }
                    next$iv$iv = i2;
                    i3 = this_$iv$iv$iv3;
                    $i$f$getTraversableOLwlOKw = count$iv$iv;
                    this_$iv$iv$iv3.add(i2);
                    if (this_$iv$iv$iv3 != 0) {
                    }
                    node$iv$iv = $i$f$visitSubtreeIf6rFNWt0;
                    this_$iv$iv$iv3.add(obj4);
                    count$iv$iv = $i$f$getTraversableOLwlOKw;
                    i6 = 0;
                    i5 = i14;
                    mask$iv$iv3 = i8;
                    this_$iv$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = i2;
                    mask$iv$iv3 = i8;
                    next$iv$iv = i2;
                    mask$iv$iv = 0;
                    this_$iv$iv$iv4 = 1;
                }
                this_$iv$iv$iv = this_$iv$iv$iv3;
                mask$iv$iv5 = 0;
                this_$iv$iv$iv2 = 1;
                if ($i$f$getTraversableOLwlOKw == this_$iv$iv$iv2) {
                } else {
                }
                i10 = this_$iv$iv$iv2;
                $i$f$getTraversableOLwlOKw = type$iv;
                obj5 = obj8;
                $i$f$visitSubtreeIf6rFNWt0 = i;
                i8 = mask$iv$iv3;
                i2 = node$iv$iv$iv;
                obj2 = 0;
                count$iv$iv = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv4 = 0;
                if (this_$iv$iv$iv4 != 0) {
                } else {
                }
                this_$iv$iv$iv = this_$iv$iv$iv3;
                mask$iv$iv3 = i8;
                next$iv$iv = i2;
                mask$iv$iv = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $i$f$visitSubtreeIf6rFNWt0 = key;
                this_$iv$iv$iv3 = this_$iv$iv$iv;
                i8 = mask$iv$iv3;
                $i$f$getTraversableOLwlOKw++;
                this_$iv$iv$iv = this_$iv$iv$iv3;
                if ($i$f$getTraversableOLwlOKw == 1) {
                } else {
                }
                if (i3 == 0) {
                } else {
                }
                count$iv$iv = $i$f$getTraversableOLwlOKw;
                mask$iv$iv3 = i8;
                mask$iv$iv = 0;
                this_$iv$iv$iv3 = i3;
                obj4 = node$iv$iv;
                if (obj4 != null && this_$iv$iv$iv3 != 0) {
                }
                if (this_$iv$iv$iv3 != 0) {
                } else {
                }
                next$iv$iv = i2;
                i3 = this_$iv$iv$iv3;
                $i$f$getTraversableOLwlOKw = count$iv$iv;
                this_$iv$iv$iv3.add(i2);
                if (this_$iv$iv$iv3 != 0) {
                }
                node$iv$iv = $i$f$visitSubtreeIf6rFNWt0;
                this_$iv$iv$iv3.add(obj4);
                count$iv$iv = $i$f$getTraversableOLwlOKw;
                i6 = 0;
                i5 = i14;
                mask$iv$iv3 = i8;
                this_$iv$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv = i2;
                mask$iv$iv3 = i8;
                next$iv$iv = i2;
                mask$iv$iv = 0;
                this_$iv$iv$iv4 = 1;
                $i$f$getTraversableOLwlOKw = 1;
                node$iv$iv$iv = 0;
                type$iv = $i$f$getTraversableOLwlOKw;
                type$iv3 = i10;
                i2 = 0;
                obj8 = obj5;
                i = $i$f$visitSubtreeIf6rFNWt0;
                if (Intrinsics.areEqual(key, (TraversableNode)type$iv3.getTraverseKey())) {
                } else {
                }
                obj6 = block;
                continueTraversal = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                obj2 = type$iv3;
                traverseDescendantsAction = this_$iv$iv$iv;
                if (traverseDescendantsAction != TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                } else {
                }
                $i$f$getTraversableOLwlOKw = 0;
                mask$iv$iv3 = i8;
                this_$iv$iv$iv2 = 1;
                mask$iv$iv5 = 0;
                mask$iv$iv3 = i8;
                $this$visitSubtreeIf_u2d6rFNWt0$iv = 1;
                mask$iv$iv2 = 0;
                i4 = 0;
                $i$f$getTraversableOLwlOKw = 1;
                continueTraversal = block.invoke(type$iv3);
            }
            type$iv = $i$f$getTraversableOLwlOKw;
            obj8 = obj5;
            i = $i$f$visitSubtreeIf6rFNWt0;
            mask$iv$iv3 = i8;
            mask$iv$iv4 = node$iv$iv;
            if (kindSet$ui_release2 &= i8 != 0) {
            } else {
            }
            type$iv = $i$f$getTraversableOLwlOKw;
            obj8 = obj5;
            i = $i$f$visitSubtreeIf6rFNWt0;
            mask$iv$iv3 = i8;
            $this$visitSubtreeIf_u2d6rFNWt0$iv = i10;
            mask$iv$iv2 = node$iv$iv;
            node$iv$iv2 = node$iv$iv2.getChild$ui_release();
            i10 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            node$iv$iv = mask$iv$iv2;
            $i$f$getTraversableOLwlOKw = type$iv;
            obj5 = obj8;
            $i$f$visitSubtreeIf6rFNWt0 = i;
            i8 = mask$iv$iv3;
            i9 = 0;
            i7 = 0;
            i3 = 0;
            i19 = 0;
            node$iv$iv = node$iv$iv3;
            while (node$iv$iv != null) {
                type$iv = $i$f$getTraversableOLwlOKw;
                $i$f$visitSubtreeIf6rFNWt0 = key;
                i13 = 0;
                if (kindSet$ui_release &= type$iv != 0) {
                } else {
                }
                $i$f$getTraversableOLwlOKw = 0;
                if ($i$f$getTraversableOLwlOKw != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                mask$iv$iv3 = i8;
                this_$iv$iv$iv2 = 1;
                mask$iv$iv5 = 0;
                node$iv$iv = DelegatableNodeKt.access$pop(i3);
                i10 = this_$iv$iv$iv2;
                $i$f$getTraversableOLwlOKw = type$iv;
                obj5 = obj8;
                $i$f$visitSubtreeIf6rFNWt0 = i;
                i8 = mask$iv$iv3;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                $i$f$getTraversableOLwlOKw = 0;
                i10 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    i2 = node$iv$iv$iv;
                    obj2 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv4 = 0;
                    if (this_$iv$iv$iv4 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = this_$iv$iv$iv3;
                    mask$iv$iv3 = i8;
                    next$iv$iv = i2;
                    mask$iv$iv = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $i$f$visitSubtreeIf6rFNWt0 = key;
                    this_$iv$iv$iv3 = this_$iv$iv$iv;
                    i8 = mask$iv$iv3;
                    $i$f$getTraversableOLwlOKw++;
                    this_$iv$iv$iv = this_$iv$iv$iv3;
                    if ($i$f$getTraversableOLwlOKw == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    count$iv$iv = $i$f$getTraversableOLwlOKw;
                    mask$iv$iv3 = i8;
                    mask$iv$iv = 0;
                    this_$iv$iv$iv3 = i3;
                    obj4 = node$iv$iv;
                    if (obj4 != null && this_$iv$iv$iv3 != 0) {
                    }
                    if (this_$iv$iv$iv3 != 0) {
                    } else {
                    }
                    next$iv$iv = i2;
                    i3 = this_$iv$iv$iv3;
                    $i$f$getTraversableOLwlOKw = count$iv$iv;
                    this_$iv$iv$iv3.add(i2);
                    if (this_$iv$iv$iv3 != 0) {
                    }
                    node$iv$iv = $i$f$visitSubtreeIf6rFNWt0;
                    this_$iv$iv$iv3.add(obj4);
                    count$iv$iv = $i$f$getTraversableOLwlOKw;
                    i6 = 0;
                    i5 = i14;
                    mask$iv$iv3 = i8;
                    this_$iv$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = i2;
                    mask$iv$iv3 = i8;
                    next$iv$iv = i2;
                    mask$iv$iv = 0;
                    this_$iv$iv$iv4 = 1;
                }
                this_$iv$iv$iv = this_$iv$iv$iv3;
                mask$iv$iv5 = 0;
                this_$iv$iv$iv2 = 1;
                if ($i$f$getTraversableOLwlOKw == this_$iv$iv$iv2) {
                } else {
                }
                i10 = this_$iv$iv$iv2;
                $i$f$getTraversableOLwlOKw = type$iv;
                obj5 = obj8;
                $i$f$visitSubtreeIf6rFNWt0 = i;
                i8 = mask$iv$iv3;
                i2 = node$iv$iv$iv;
                obj2 = 0;
                count$iv$iv = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv4 = 0;
                if (this_$iv$iv$iv4 != 0) {
                } else {
                }
                this_$iv$iv$iv = this_$iv$iv$iv3;
                mask$iv$iv3 = i8;
                next$iv$iv = i2;
                mask$iv$iv = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $i$f$visitSubtreeIf6rFNWt0 = key;
                this_$iv$iv$iv3 = this_$iv$iv$iv;
                i8 = mask$iv$iv3;
                $i$f$getTraversableOLwlOKw++;
                this_$iv$iv$iv = this_$iv$iv$iv3;
                if ($i$f$getTraversableOLwlOKw == 1) {
                } else {
                }
                if (i3 == 0) {
                } else {
                }
                count$iv$iv = $i$f$getTraversableOLwlOKw;
                mask$iv$iv3 = i8;
                mask$iv$iv = 0;
                this_$iv$iv$iv3 = i3;
                obj4 = node$iv$iv;
                if (obj4 != null && this_$iv$iv$iv3 != 0) {
                }
                if (this_$iv$iv$iv3 != 0) {
                } else {
                }
                next$iv$iv = i2;
                i3 = this_$iv$iv$iv3;
                $i$f$getTraversableOLwlOKw = count$iv$iv;
                this_$iv$iv$iv3.add(i2);
                if (this_$iv$iv$iv3 != 0) {
                }
                node$iv$iv = $i$f$visitSubtreeIf6rFNWt0;
                this_$iv$iv$iv3.add(obj4);
                count$iv$iv = $i$f$getTraversableOLwlOKw;
                i6 = 0;
                i5 = i14;
                mask$iv$iv3 = i8;
                this_$iv$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv = i2;
                mask$iv$iv3 = i8;
                next$iv$iv = i2;
                mask$iv$iv = 0;
                this_$iv$iv$iv4 = 1;
                $i$f$getTraversableOLwlOKw = 1;
                node$iv$iv$iv = 0;
                type$iv = $i$f$getTraversableOLwlOKw;
                type$iv3 = i10;
                i2 = 0;
                obj8 = obj5;
                i = $i$f$visitSubtreeIf6rFNWt0;
                if (Intrinsics.areEqual(key, (TraversableNode)type$iv3.getTraverseKey())) {
                } else {
                }
                obj6 = block;
                continueTraversal = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                obj2 = type$iv3;
                traverseDescendantsAction = this_$iv$iv$iv;
                if (traverseDescendantsAction != TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                } else {
                }
                $i$f$getTraversableOLwlOKw = 0;
                mask$iv$iv3 = i8;
                this_$iv$iv$iv2 = 1;
                mask$iv$iv5 = 0;
                $i$f$getTraversableOLwlOKw = 1;
                continueTraversal = block.invoke(type$iv3);
            }
            type$iv = $i$f$getTraversableOLwlOKw;
            obj8 = obj5;
            i = $i$f$visitSubtreeIf6rFNWt0;
            mask$iv$iv3 = i8;
            mask$iv$iv2 = 0;
            i4 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            if (i4 != 0) {
            } else {
            }
            node$iv$iv = mask$iv$iv2;
            $i$f$getTraversableOLwlOKw = type$iv;
            obj5 = obj8;
            $i$f$visitSubtreeIf6rFNWt0 = i;
            i8 = mask$iv$iv3;
            type$iv = $i$f$getTraversableOLwlOKw;
            $i$f$visitSubtreeIf6rFNWt0 = key;
            i13 = 0;
            if (kindSet$ui_release &= type$iv != 0) {
            } else {
            }
            $i$f$getTraversableOLwlOKw = 0;
            if ($i$f$getTraversableOLwlOKw != 0 && node$iv$iv instanceof DelegatingNode) {
            } else {
            }
            mask$iv$iv3 = i8;
            this_$iv$iv$iv2 = 1;
            mask$iv$iv5 = 0;
            node$iv$iv = DelegatableNodeKt.access$pop(i3);
            i10 = this_$iv$iv$iv2;
            $i$f$getTraversableOLwlOKw = type$iv;
            obj5 = obj8;
            $i$f$visitSubtreeIf6rFNWt0 = i;
            i8 = mask$iv$iv3;
            if (node$iv$iv instanceof DelegatingNode) {
            } else {
            }
            $i$f$getTraversableOLwlOKw = 0;
            i10 = 0;
            node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
            while (node$iv$iv$iv != null) {
                i2 = node$iv$iv$iv;
                obj2 = 0;
                count$iv$iv = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv4 = 0;
                if (this_$iv$iv$iv4 != 0) {
                } else {
                }
                this_$iv$iv$iv = this_$iv$iv$iv3;
                mask$iv$iv3 = i8;
                next$iv$iv = i2;
                mask$iv$iv = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $i$f$visitSubtreeIf6rFNWt0 = key;
                this_$iv$iv$iv3 = this_$iv$iv$iv;
                i8 = mask$iv$iv3;
                $i$f$getTraversableOLwlOKw++;
                this_$iv$iv$iv = this_$iv$iv$iv3;
                if ($i$f$getTraversableOLwlOKw == 1) {
                } else {
                }
                if (i3 == 0) {
                } else {
                }
                count$iv$iv = $i$f$getTraversableOLwlOKw;
                mask$iv$iv3 = i8;
                mask$iv$iv = 0;
                this_$iv$iv$iv3 = i3;
                obj4 = node$iv$iv;
                if (obj4 != null && this_$iv$iv$iv3 != 0) {
                }
                if (this_$iv$iv$iv3 != 0) {
                } else {
                }
                next$iv$iv = i2;
                i3 = this_$iv$iv$iv3;
                $i$f$getTraversableOLwlOKw = count$iv$iv;
                this_$iv$iv$iv3.add(i2);
                if (this_$iv$iv$iv3 != 0) {
                }
                node$iv$iv = $i$f$visitSubtreeIf6rFNWt0;
                this_$iv$iv$iv3.add(obj4);
                count$iv$iv = $i$f$getTraversableOLwlOKw;
                i6 = 0;
                i5 = i14;
                mask$iv$iv3 = i8;
                this_$iv$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv = i2;
                mask$iv$iv3 = i8;
                next$iv$iv = i2;
                mask$iv$iv = 0;
                this_$iv$iv$iv4 = 1;
            }
            this_$iv$iv$iv = this_$iv$iv$iv3;
            mask$iv$iv5 = 0;
            this_$iv$iv$iv2 = 1;
            if ($i$f$getTraversableOLwlOKw == this_$iv$iv$iv2) {
            } else {
            }
            i10 = this_$iv$iv$iv2;
            $i$f$getTraversableOLwlOKw = type$iv;
            obj5 = obj8;
            $i$f$visitSubtreeIf6rFNWt0 = i;
            i8 = mask$iv$iv3;
            i2 = node$iv$iv$iv;
            obj2 = 0;
            count$iv$iv = 0;
            if (kindSet$ui_release3 &= type$iv != 0) {
            } else {
            }
            this_$iv$iv$iv4 = 0;
            if (this_$iv$iv$iv4 != 0) {
            } else {
            }
            this_$iv$iv$iv = this_$iv$iv$iv3;
            mask$iv$iv3 = i8;
            next$iv$iv = i2;
            mask$iv$iv = 0;
            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
            $i$f$visitSubtreeIf6rFNWt0 = key;
            this_$iv$iv$iv3 = this_$iv$iv$iv;
            i8 = mask$iv$iv3;
            $i$f$getTraversableOLwlOKw++;
            this_$iv$iv$iv = this_$iv$iv$iv3;
            if ($i$f$getTraversableOLwlOKw == 1) {
            } else {
            }
            if (i3 == 0) {
            } else {
            }
            count$iv$iv = $i$f$getTraversableOLwlOKw;
            mask$iv$iv3 = i8;
            mask$iv$iv = 0;
            this_$iv$iv$iv3 = i3;
            obj4 = node$iv$iv;
            if (obj4 != null && this_$iv$iv$iv3 != 0) {
            }
            if (this_$iv$iv$iv3 != 0) {
            } else {
            }
            next$iv$iv = i2;
            i3 = this_$iv$iv$iv3;
            $i$f$getTraversableOLwlOKw = count$iv$iv;
            this_$iv$iv$iv3.add(i2);
            if (this_$iv$iv$iv3 != 0) {
            }
            node$iv$iv = $i$f$visitSubtreeIf6rFNWt0;
            this_$iv$iv$iv3.add(obj4);
            count$iv$iv = $i$f$getTraversableOLwlOKw;
            i6 = 0;
            i5 = i14;
            mask$iv$iv3 = i8;
            this_$iv$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
            node$iv$iv = i2;
            mask$iv$iv3 = i8;
            next$iv$iv = i2;
            mask$iv$iv = 0;
            this_$iv$iv$iv4 = 1;
            $i$f$getTraversableOLwlOKw = 1;
            node$iv$iv$iv = 0;
            type$iv = $i$f$getTraversableOLwlOKw;
            type$iv3 = i10;
            i2 = 0;
            obj8 = obj5;
            i = $i$f$visitSubtreeIf6rFNWt0;
            if (Intrinsics.areEqual(key, (TraversableNode)type$iv3.getTraverseKey())) {
            } else {
            }
            obj6 = block;
            continueTraversal = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
            obj2 = type$iv3;
            traverseDescendantsAction = this_$iv$iv$iv;
            if (traverseDescendantsAction != TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
            } else {
            }
            $i$f$getTraversableOLwlOKw = 0;
            mask$iv$iv3 = i8;
            this_$iv$iv$iv2 = 1;
            mask$iv$iv5 = 0;
            mask$iv$iv3 = i8;
            $this$visitSubtreeIf_u2d6rFNWt0$iv = 1;
            mask$iv$iv2 = 0;
            i4 = 0;
            $i$f$getTraversableOLwlOKw = 1;
            continueTraversal = block.invoke(type$iv3);
        }
    }

    public static final <T extends androidx.compose.ui.node.TraversableNode> void traverseDescendants(T $this$traverseDescendants, Function1<? super T, ? extends androidx.compose.ui.node.TraversableNode.Companion.TraverseDescendantsAction> block) {
        int count$iv$iv2;
        Object obj;
        Object this_$iv$iv$iv2;
        int this_$iv$iv$iv4;
        int $this$visitSubtreeIf_u2d6rFNWt0$iv2;
        int $i$f$getTraversableOLwlOKw;
        Modifier.Node next$iv$iv;
        boolean objectsOfSameType;
        int i10;
        int i9;
        int $i$f$forEachImmediateDelegate$ui_release;
        int $i$f$forEachImmediateDelegate$ui_release2;
        Object continueTraversal;
        int $i$f$visitSubtreeIf6rFNWt02;
        int $i$f$visitSubtreeIf6rFNWt0;
        int node;
        String $i$a$CheckPreconditionDelegatableNodeKt$visitSubtreeIf$1$iv$iv;
        int node$iv$iv$iv;
        Modifier.Node[] node$iv$iv2;
        int node$iv$iv;
        Object obj2;
        int i13;
        Object obj3;
        int i11;
        int i3;
        int i5;
        int i6;
        Object $this$visitSubtreeIf_u2d6rFNWt0$iv;
        int i4;
        int i12;
        int i7;
        Object this_$iv$iv$iv3;
        int this_$iv$iv$iv;
        int count$iv$iv;
        int i;
        int i8;
        int i2;
        int i16 = 0;
        i10 = 0;
        final int i19 = $i$f$getTraversableOLwlOKw;
        final Object obj6 = obj;
        final int i20 = 0;
        int i21 = 0;
        if (!obj6.getNode().isAttached()) {
            int i23 = 0;
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
            if (aggregateChildKindSet$ui_release &= i19 != 0) {
            } else {
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv = obj;
            i12 = $i$f$getTraversableOLwlOKw;
            i7 = i10;
            $i$f$visitSubtreeIf6rFNWt0 = node$iv$iv;
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node);
            count$iv$iv2 = $this$traverseDescendants;
            node$iv$iv = $i$f$visitSubtreeIf6rFNWt0;
            obj = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            $i$f$getTraversableOLwlOKw = i12;
            i10 = i7;
            node$iv$iv2 = node;
            while (node$iv$iv2 != null) {
                if (kindSet$ui_release2 &= i19 == 0) {
                    break loop_8;
                } else {
                }
                $this$visitSubtreeIf_u2d6rFNWt0$iv = obj;
                i12 = $i$f$getTraversableOLwlOKw;
                i7 = i10;
                $this$visitSubtreeIf_u2d6rFNWt0$iv2 = node$iv$iv$iv;
                $i$f$visitSubtreeIf6rFNWt02 = node$iv$iv;
                node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                count$iv$iv2 = $this$traverseDescendants;
                node$iv$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                node$iv$iv = $i$f$visitSubtreeIf6rFNWt02;
                obj = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                $i$f$getTraversableOLwlOKw = i12;
                i10 = i7;
                i13 = 0;
                i11 = 0;
                i3 = 0;
                int i24 = 0;
                node$iv$iv = node$iv$iv3;
                while (node$iv$iv != null) {
                    i12 = $i$f$getTraversableOLwlOKw;
                    $i$f$getTraversableOLwlOKw = block;
                    int i14 = 0;
                    if (kindSet$ui_release &= i12 != 0) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    if (count$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv4 = 1;
                    $i$f$forEachImmediateDelegate$ui_release2 = 0;
                    node$iv$iv = DelegatableNodeKt.access$pop(i3);
                    count$iv$iv2 = $this$traverseDescendants;
                    node$iv$iv$iv = this_$iv$iv$iv4;
                    obj = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                    $i$f$getTraversableOLwlOKw = i12;
                    i10 = i7;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    i9 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        i6 = node$iv$iv$iv;
                        i4 = 0;
                        count$iv$iv = 0;
                        if (kindSet$ui_release3 &= i12 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv3 = this_$iv$iv$iv2;
                        i2 = i9;
                        next$iv$iv = i6;
                        $i$f$forEachImmediateDelegate$ui_release = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $i$f$getTraversableOLwlOKw = block;
                        this_$iv$iv$iv2 = this_$iv$iv$iv3;
                        i9 = i2;
                        count$iv$iv2++;
                        this_$iv$iv$iv3 = this_$iv$iv$iv2;
                        if (count$iv$iv2 == 1) {
                        } else {
                        }
                        if (i3 == 0) {
                        } else {
                        }
                        count$iv$iv = count$iv$iv2;
                        i2 = i9;
                        $i$f$forEachImmediateDelegate$ui_release = 0;
                        this_$iv$iv$iv2 = i3;
                        Object obj5 = node$iv$iv;
                        if (obj5 != null && this_$iv$iv$iv2 != 0) {
                        }
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv = i6;
                        i3 = this_$iv$iv$iv2;
                        count$iv$iv2 = count$iv$iv;
                        this_$iv$iv$iv2.add(i6);
                        if (this_$iv$iv$iv2 != 0) {
                        }
                        node$iv$iv = $i$f$getTraversableOLwlOKw;
                        this_$iv$iv$iv2.add(obj5);
                        count$iv$iv = count$iv$iv2;
                        i = 0;
                        i8 = i15;
                        i2 = i9;
                        this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv = i6;
                        i2 = i9;
                        next$iv$iv = i6;
                        $i$f$forEachImmediateDelegate$ui_release = 0;
                        this_$iv$iv$iv = 1;
                    }
                    this_$iv$iv$iv3 = this_$iv$iv$iv2;
                    i2 = i9;
                    $i$f$forEachImmediateDelegate$ui_release2 = 0;
                    this_$iv$iv$iv4 = 1;
                    if (count$iv$iv2 == this_$iv$iv$iv4) {
                    } else {
                    }
                    count$iv$iv2 = $this$traverseDescendants;
                    node$iv$iv$iv = this_$iv$iv$iv4;
                    obj = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                    $i$f$getTraversableOLwlOKw = i12;
                    i10 = i7;
                    i6 = node$iv$iv$iv;
                    i4 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release3 &= i12 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv3 = this_$iv$iv$iv2;
                    i2 = i9;
                    next$iv$iv = i6;
                    $i$f$forEachImmediateDelegate$ui_release = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $i$f$getTraversableOLwlOKw = block;
                    this_$iv$iv$iv2 = this_$iv$iv$iv3;
                    i9 = i2;
                    count$iv$iv2++;
                    this_$iv$iv$iv3 = this_$iv$iv$iv2;
                    if (count$iv$iv2 == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv2;
                    i2 = i9;
                    $i$f$forEachImmediateDelegate$ui_release = 0;
                    this_$iv$iv$iv2 = i3;
                    obj5 = node$iv$iv;
                    if (obj5 != null && this_$iv$iv$iv2 != 0) {
                    }
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv = i6;
                    i3 = this_$iv$iv$iv2;
                    count$iv$iv2 = count$iv$iv;
                    this_$iv$iv$iv2.add(i6);
                    if (this_$iv$iv$iv2 != 0) {
                    }
                    node$iv$iv = $i$f$getTraversableOLwlOKw;
                    this_$iv$iv$iv2.add(obj5);
                    count$iv$iv = count$iv$iv2;
                    i = 0;
                    i8 = i15;
                    i2 = i9;
                    this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = i6;
                    i2 = i9;
                    next$iv$iv = i6;
                    $i$f$forEachImmediateDelegate$ui_release = 0;
                    this_$iv$iv$iv = 1;
                    count$iv$iv2 = 1;
                    i6 = 0;
                    $this$visitSubtreeIf_u2d6rFNWt0$iv = obj;
                    Object $this$visitSubtreeIf_u2d6rFNWt0$iv3 = node$iv$iv$iv;
                    i4 = 0;
                    i12 = $i$f$getTraversableOLwlOKw;
                    i7 = i10;
                    if (Intrinsics.areEqual(count$iv$iv2.getTraverseKey(), (TraversableNode)$this$visitSubtreeIf_u2d6rFNWt0$iv3.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(count$iv$iv2, $this$visitSubtreeIf_u2d6rFNWt0$iv3)) {
                    } else {
                    }
                    $i$f$getTraversableOLwlOKw = block;
                    continueTraversal = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                    if (continueTraversal != TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    this_$iv$iv$iv4 = 1;
                    $i$f$forEachImmediateDelegate$ui_release2 = 0;
                    count$iv$iv2 = 1;
                    if (Actual_jvmKt.areObjectsOfSameType(count$iv$iv2, $this$visitSubtreeIf_u2d6rFNWt0$iv3)) {
                    } else {
                    }
                    continueTraversal = block.invoke($this$visitSubtreeIf_u2d6rFNWt0$iv3);
                }
                $this$visitSubtreeIf_u2d6rFNWt0$iv = obj;
                i12 = $i$f$getTraversableOLwlOKw;
                i7 = i10;
                $i$f$visitSubtreeIf6rFNWt02 = 0;
                i5 = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                i12 = $i$f$getTraversableOLwlOKw;
                $i$f$getTraversableOLwlOKw = block;
                i14 = 0;
                if (kindSet$ui_release &= i12 != 0) {
                } else {
                }
                count$iv$iv2 = 0;
                if (count$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv4 = 1;
                $i$f$forEachImmediateDelegate$ui_release2 = 0;
                node$iv$iv = DelegatableNodeKt.access$pop(i3);
                count$iv$iv2 = $this$traverseDescendants;
                node$iv$iv$iv = this_$iv$iv$iv4;
                obj = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                $i$f$getTraversableOLwlOKw = i12;
                i10 = i7;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv2 = 0;
                i9 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    i6 = node$iv$iv$iv;
                    i4 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release3 &= i12 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv3 = this_$iv$iv$iv2;
                    i2 = i9;
                    next$iv$iv = i6;
                    $i$f$forEachImmediateDelegate$ui_release = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $i$f$getTraversableOLwlOKw = block;
                    this_$iv$iv$iv2 = this_$iv$iv$iv3;
                    i9 = i2;
                    count$iv$iv2++;
                    this_$iv$iv$iv3 = this_$iv$iv$iv2;
                    if (count$iv$iv2 == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv2;
                    i2 = i9;
                    $i$f$forEachImmediateDelegate$ui_release = 0;
                    this_$iv$iv$iv2 = i3;
                    obj5 = node$iv$iv;
                    if (obj5 != null && this_$iv$iv$iv2 != 0) {
                    }
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv = i6;
                    i3 = this_$iv$iv$iv2;
                    count$iv$iv2 = count$iv$iv;
                    this_$iv$iv$iv2.add(i6);
                    if (this_$iv$iv$iv2 != 0) {
                    }
                    node$iv$iv = $i$f$getTraversableOLwlOKw;
                    this_$iv$iv$iv2.add(obj5);
                    count$iv$iv = count$iv$iv2;
                    i = 0;
                    i8 = i15;
                    i2 = i9;
                    this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = i6;
                    i2 = i9;
                    next$iv$iv = i6;
                    $i$f$forEachImmediateDelegate$ui_release = 0;
                    this_$iv$iv$iv = 1;
                }
                this_$iv$iv$iv3 = this_$iv$iv$iv2;
                i2 = i9;
                $i$f$forEachImmediateDelegate$ui_release2 = 0;
                this_$iv$iv$iv4 = 1;
                if (count$iv$iv2 == this_$iv$iv$iv4) {
                } else {
                }
                count$iv$iv2 = $this$traverseDescendants;
                node$iv$iv$iv = this_$iv$iv$iv4;
                obj = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                $i$f$getTraversableOLwlOKw = i12;
                i10 = i7;
                i6 = node$iv$iv$iv;
                i4 = 0;
                count$iv$iv = 0;
                if (kindSet$ui_release3 &= i12 != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                this_$iv$iv$iv3 = this_$iv$iv$iv2;
                i2 = i9;
                next$iv$iv = i6;
                $i$f$forEachImmediateDelegate$ui_release = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $i$f$getTraversableOLwlOKw = block;
                this_$iv$iv$iv2 = this_$iv$iv$iv3;
                i9 = i2;
                count$iv$iv2++;
                this_$iv$iv$iv3 = this_$iv$iv$iv2;
                if (count$iv$iv2 == 1) {
                } else {
                }
                if (i3 == 0) {
                } else {
                }
                count$iv$iv = count$iv$iv2;
                i2 = i9;
                $i$f$forEachImmediateDelegate$ui_release = 0;
                this_$iv$iv$iv2 = i3;
                obj5 = node$iv$iv;
                if (obj5 != null && this_$iv$iv$iv2 != 0) {
                }
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                next$iv$iv = i6;
                i3 = this_$iv$iv$iv2;
                count$iv$iv2 = count$iv$iv;
                this_$iv$iv$iv2.add(i6);
                if (this_$iv$iv$iv2 != 0) {
                }
                node$iv$iv = $i$f$getTraversableOLwlOKw;
                this_$iv$iv$iv2.add(obj5);
                count$iv$iv = count$iv$iv2;
                i = 0;
                i8 = i15;
                i2 = i9;
                this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv = i6;
                i2 = i9;
                next$iv$iv = i6;
                $i$f$forEachImmediateDelegate$ui_release = 0;
                this_$iv$iv$iv = 1;
                count$iv$iv2 = 1;
                i6 = 0;
                $this$visitSubtreeIf_u2d6rFNWt0$iv = obj;
                $this$visitSubtreeIf_u2d6rFNWt0$iv3 = node$iv$iv$iv;
                i4 = 0;
                i12 = $i$f$getTraversableOLwlOKw;
                i7 = i10;
                if (Intrinsics.areEqual(count$iv$iv2.getTraverseKey(), (TraversableNode)$this$visitSubtreeIf_u2d6rFNWt0$iv3.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(count$iv$iv2, $this$visitSubtreeIf_u2d6rFNWt0$iv3)) {
                } else {
                }
                $i$f$getTraversableOLwlOKw = block;
                continueTraversal = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                if (continueTraversal != TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                } else {
                }
                count$iv$iv2 = 0;
                this_$iv$iv$iv4 = 1;
                $i$f$forEachImmediateDelegate$ui_release2 = 0;
                $this$visitSubtreeIf_u2d6rFNWt0$iv2 = 1;
                $i$f$visitSubtreeIf6rFNWt02 = 0;
                i5 = 0;
                count$iv$iv2 = 1;
                if (Actual_jvmKt.areObjectsOfSameType(count$iv$iv2, $this$visitSubtreeIf_u2d6rFNWt0$iv3)) {
                } else {
                }
                continueTraversal = block.invoke($this$visitSubtreeIf_u2d6rFNWt0$iv3);
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv = obj;
            i12 = $i$f$getTraversableOLwlOKw;
            i7 = i10;
            $i$f$visitSubtreeIf6rFNWt0 = node$iv$iv;
            if (kindSet$ui_release2 &= i19 != 0) {
            } else {
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv = obj;
            i12 = $i$f$getTraversableOLwlOKw;
            i7 = i10;
            $this$visitSubtreeIf_u2d6rFNWt0$iv2 = node$iv$iv$iv;
            $i$f$visitSubtreeIf6rFNWt02 = node$iv$iv;
            node$iv$iv2 = node$iv$iv2.getChild$ui_release();
            count$iv$iv2 = $this$traverseDescendants;
            node$iv$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
            node$iv$iv = $i$f$visitSubtreeIf6rFNWt02;
            obj = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            $i$f$getTraversableOLwlOKw = i12;
            i10 = i7;
            i13 = 0;
            i11 = 0;
            i3 = 0;
            i24 = 0;
            node$iv$iv = node$iv$iv3;
            while (node$iv$iv != null) {
                i12 = $i$f$getTraversableOLwlOKw;
                $i$f$getTraversableOLwlOKw = block;
                i14 = 0;
                if (kindSet$ui_release &= i12 != 0) {
                } else {
                }
                count$iv$iv2 = 0;
                if (count$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv4 = 1;
                $i$f$forEachImmediateDelegate$ui_release2 = 0;
                node$iv$iv = DelegatableNodeKt.access$pop(i3);
                count$iv$iv2 = $this$traverseDescendants;
                node$iv$iv$iv = this_$iv$iv$iv4;
                obj = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                $i$f$getTraversableOLwlOKw = i12;
                i10 = i7;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv2 = 0;
                i9 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    i6 = node$iv$iv$iv;
                    i4 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release3 &= i12 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv3 = this_$iv$iv$iv2;
                    i2 = i9;
                    next$iv$iv = i6;
                    $i$f$forEachImmediateDelegate$ui_release = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $i$f$getTraversableOLwlOKw = block;
                    this_$iv$iv$iv2 = this_$iv$iv$iv3;
                    i9 = i2;
                    count$iv$iv2++;
                    this_$iv$iv$iv3 = this_$iv$iv$iv2;
                    if (count$iv$iv2 == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv2;
                    i2 = i9;
                    $i$f$forEachImmediateDelegate$ui_release = 0;
                    this_$iv$iv$iv2 = i3;
                    obj5 = node$iv$iv;
                    if (obj5 != null && this_$iv$iv$iv2 != 0) {
                    }
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv = i6;
                    i3 = this_$iv$iv$iv2;
                    count$iv$iv2 = count$iv$iv;
                    this_$iv$iv$iv2.add(i6);
                    if (this_$iv$iv$iv2 != 0) {
                    }
                    node$iv$iv = $i$f$getTraversableOLwlOKw;
                    this_$iv$iv$iv2.add(obj5);
                    count$iv$iv = count$iv$iv2;
                    i = 0;
                    i8 = i15;
                    i2 = i9;
                    this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = i6;
                    i2 = i9;
                    next$iv$iv = i6;
                    $i$f$forEachImmediateDelegate$ui_release = 0;
                    this_$iv$iv$iv = 1;
                }
                this_$iv$iv$iv3 = this_$iv$iv$iv2;
                i2 = i9;
                $i$f$forEachImmediateDelegate$ui_release2 = 0;
                this_$iv$iv$iv4 = 1;
                if (count$iv$iv2 == this_$iv$iv$iv4) {
                } else {
                }
                count$iv$iv2 = $this$traverseDescendants;
                node$iv$iv$iv = this_$iv$iv$iv4;
                obj = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                $i$f$getTraversableOLwlOKw = i12;
                i10 = i7;
                i6 = node$iv$iv$iv;
                i4 = 0;
                count$iv$iv = 0;
                if (kindSet$ui_release3 &= i12 != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                this_$iv$iv$iv3 = this_$iv$iv$iv2;
                i2 = i9;
                next$iv$iv = i6;
                $i$f$forEachImmediateDelegate$ui_release = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $i$f$getTraversableOLwlOKw = block;
                this_$iv$iv$iv2 = this_$iv$iv$iv3;
                i9 = i2;
                count$iv$iv2++;
                this_$iv$iv$iv3 = this_$iv$iv$iv2;
                if (count$iv$iv2 == 1) {
                } else {
                }
                if (i3 == 0) {
                } else {
                }
                count$iv$iv = count$iv$iv2;
                i2 = i9;
                $i$f$forEachImmediateDelegate$ui_release = 0;
                this_$iv$iv$iv2 = i3;
                obj5 = node$iv$iv;
                if (obj5 != null && this_$iv$iv$iv2 != 0) {
                }
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                next$iv$iv = i6;
                i3 = this_$iv$iv$iv2;
                count$iv$iv2 = count$iv$iv;
                this_$iv$iv$iv2.add(i6);
                if (this_$iv$iv$iv2 != 0) {
                }
                node$iv$iv = $i$f$getTraversableOLwlOKw;
                this_$iv$iv$iv2.add(obj5);
                count$iv$iv = count$iv$iv2;
                i = 0;
                i8 = i15;
                i2 = i9;
                this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv = i6;
                i2 = i9;
                next$iv$iv = i6;
                $i$f$forEachImmediateDelegate$ui_release = 0;
                this_$iv$iv$iv = 1;
                count$iv$iv2 = 1;
                i6 = 0;
                $this$visitSubtreeIf_u2d6rFNWt0$iv = obj;
                $this$visitSubtreeIf_u2d6rFNWt0$iv3 = node$iv$iv$iv;
                i4 = 0;
                i12 = $i$f$getTraversableOLwlOKw;
                i7 = i10;
                if (Intrinsics.areEqual(count$iv$iv2.getTraverseKey(), (TraversableNode)$this$visitSubtreeIf_u2d6rFNWt0$iv3.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(count$iv$iv2, $this$visitSubtreeIf_u2d6rFNWt0$iv3)) {
                } else {
                }
                $i$f$getTraversableOLwlOKw = block;
                continueTraversal = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                if (continueTraversal != TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                } else {
                }
                count$iv$iv2 = 0;
                this_$iv$iv$iv4 = 1;
                $i$f$forEachImmediateDelegate$ui_release2 = 0;
                count$iv$iv2 = 1;
                if (Actual_jvmKt.areObjectsOfSameType(count$iv$iv2, $this$visitSubtreeIf_u2d6rFNWt0$iv3)) {
                } else {
                }
                continueTraversal = block.invoke($this$visitSubtreeIf_u2d6rFNWt0$iv3);
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv = obj;
            i12 = $i$f$getTraversableOLwlOKw;
            i7 = i10;
            $i$f$visitSubtreeIf6rFNWt02 = 0;
            i5 = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
            if (i5 != 0) {
            } else {
            }
            count$iv$iv2 = $this$traverseDescendants;
            node$iv$iv = $i$f$visitSubtreeIf6rFNWt02;
            obj = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            $i$f$getTraversableOLwlOKw = i12;
            i10 = i7;
            i12 = $i$f$getTraversableOLwlOKw;
            $i$f$getTraversableOLwlOKw = block;
            i14 = 0;
            if (kindSet$ui_release &= i12 != 0) {
            } else {
            }
            count$iv$iv2 = 0;
            if (count$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
            } else {
            }
            this_$iv$iv$iv4 = 1;
            $i$f$forEachImmediateDelegate$ui_release2 = 0;
            node$iv$iv = DelegatableNodeKt.access$pop(i3);
            count$iv$iv2 = $this$traverseDescendants;
            node$iv$iv$iv = this_$iv$iv$iv4;
            obj = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            $i$f$getTraversableOLwlOKw = i12;
            i10 = i7;
            if (node$iv$iv instanceof DelegatingNode) {
            } else {
            }
            count$iv$iv2 = 0;
            i9 = 0;
            node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
            while (node$iv$iv$iv != null) {
                i6 = node$iv$iv$iv;
                i4 = 0;
                count$iv$iv = 0;
                if (kindSet$ui_release3 &= i12 != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                this_$iv$iv$iv3 = this_$iv$iv$iv2;
                i2 = i9;
                next$iv$iv = i6;
                $i$f$forEachImmediateDelegate$ui_release = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $i$f$getTraversableOLwlOKw = block;
                this_$iv$iv$iv2 = this_$iv$iv$iv3;
                i9 = i2;
                count$iv$iv2++;
                this_$iv$iv$iv3 = this_$iv$iv$iv2;
                if (count$iv$iv2 == 1) {
                } else {
                }
                if (i3 == 0) {
                } else {
                }
                count$iv$iv = count$iv$iv2;
                i2 = i9;
                $i$f$forEachImmediateDelegate$ui_release = 0;
                this_$iv$iv$iv2 = i3;
                obj5 = node$iv$iv;
                if (obj5 != null && this_$iv$iv$iv2 != 0) {
                }
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                next$iv$iv = i6;
                i3 = this_$iv$iv$iv2;
                count$iv$iv2 = count$iv$iv;
                this_$iv$iv$iv2.add(i6);
                if (this_$iv$iv$iv2 != 0) {
                }
                node$iv$iv = $i$f$getTraversableOLwlOKw;
                this_$iv$iv$iv2.add(obj5);
                count$iv$iv = count$iv$iv2;
                i = 0;
                i8 = i15;
                i2 = i9;
                this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv = i6;
                i2 = i9;
                next$iv$iv = i6;
                $i$f$forEachImmediateDelegate$ui_release = 0;
                this_$iv$iv$iv = 1;
            }
            this_$iv$iv$iv3 = this_$iv$iv$iv2;
            i2 = i9;
            $i$f$forEachImmediateDelegate$ui_release2 = 0;
            this_$iv$iv$iv4 = 1;
            if (count$iv$iv2 == this_$iv$iv$iv4) {
            } else {
            }
            count$iv$iv2 = $this$traverseDescendants;
            node$iv$iv$iv = this_$iv$iv$iv4;
            obj = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            $i$f$getTraversableOLwlOKw = i12;
            i10 = i7;
            i6 = node$iv$iv$iv;
            i4 = 0;
            count$iv$iv = 0;
            if (kindSet$ui_release3 &= i12 != 0) {
            } else {
            }
            this_$iv$iv$iv = 0;
            if (this_$iv$iv$iv != 0) {
            } else {
            }
            this_$iv$iv$iv3 = this_$iv$iv$iv2;
            i2 = i9;
            next$iv$iv = i6;
            $i$f$forEachImmediateDelegate$ui_release = 0;
            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
            $i$f$getTraversableOLwlOKw = block;
            this_$iv$iv$iv2 = this_$iv$iv$iv3;
            i9 = i2;
            count$iv$iv2++;
            this_$iv$iv$iv3 = this_$iv$iv$iv2;
            if (count$iv$iv2 == 1) {
            } else {
            }
            if (i3 == 0) {
            } else {
            }
            count$iv$iv = count$iv$iv2;
            i2 = i9;
            $i$f$forEachImmediateDelegate$ui_release = 0;
            this_$iv$iv$iv2 = i3;
            obj5 = node$iv$iv;
            if (obj5 != null && this_$iv$iv$iv2 != 0) {
            }
            if (this_$iv$iv$iv2 != 0) {
            } else {
            }
            next$iv$iv = i6;
            i3 = this_$iv$iv$iv2;
            count$iv$iv2 = count$iv$iv;
            this_$iv$iv$iv2.add(i6);
            if (this_$iv$iv$iv2 != 0) {
            }
            node$iv$iv = $i$f$getTraversableOLwlOKw;
            this_$iv$iv$iv2.add(obj5);
            count$iv$iv = count$iv$iv2;
            i = 0;
            i8 = i15;
            i2 = i9;
            this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], 0);
            node$iv$iv = i6;
            i2 = i9;
            next$iv$iv = i6;
            $i$f$forEachImmediateDelegate$ui_release = 0;
            this_$iv$iv$iv = 1;
            count$iv$iv2 = 1;
            i6 = 0;
            $this$visitSubtreeIf_u2d6rFNWt0$iv = obj;
            $this$visitSubtreeIf_u2d6rFNWt0$iv3 = node$iv$iv$iv;
            i4 = 0;
            i12 = $i$f$getTraversableOLwlOKw;
            i7 = i10;
            if (Intrinsics.areEqual(count$iv$iv2.getTraverseKey(), (TraversableNode)$this$visitSubtreeIf_u2d6rFNWt0$iv3.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(count$iv$iv2, $this$visitSubtreeIf_u2d6rFNWt0$iv3)) {
            } else {
            }
            $i$f$getTraversableOLwlOKw = block;
            continueTraversal = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
            if (continueTraversal != TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
            } else {
            }
            count$iv$iv2 = 0;
            this_$iv$iv$iv4 = 1;
            $i$f$forEachImmediateDelegate$ui_release2 = 0;
            $this$visitSubtreeIf_u2d6rFNWt0$iv2 = 1;
            $i$f$visitSubtreeIf6rFNWt02 = 0;
            i5 = 0;
            count$iv$iv2 = 1;
            if (Actual_jvmKt.areObjectsOfSameType(count$iv$iv2, $this$visitSubtreeIf_u2d6rFNWt0$iv3)) {
            } else {
            }
            continueTraversal = block.invoke($this$visitSubtreeIf_u2d6rFNWt0$iv3);
        }
    }
}
