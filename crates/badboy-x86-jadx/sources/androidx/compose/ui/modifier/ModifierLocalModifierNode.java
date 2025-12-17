package androidx.compose.ui.modifier;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008f\u0018\u00002\u00020\u00012\u00020\u0002J)\u0010\u000c\u001a\u00020\r\"\u0004\u0008\u0000\u0010\u00082\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\t2\u0006\u0010\u000f\u001a\u0002H\u0008H\u0016¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R$\u0010\u0007\u001a\u0002H\u0008\"\u0004\u0008\u0000\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\u00080\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0011À\u0006\u0001", d2 = {"Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/DelegatableNode;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "current", "T", "Landroidx/compose/ui/modifier/ModifierLocal;", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "provide", "", "key", "value", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ModifierLocalModifierNode extends androidx.compose.ui.modifier.ModifierLocalReadScope, DelegatableNode {
    public <T> T getCurrent(androidx.compose.ui.modifier.ModifierLocal<T> $this$current) {
        androidx.compose.ui.modifier.ModifierLocal value$iv;
        int capacity$iv$iv$iv$iv;
        Modifier.Node next$iv$iv;
        int tail$ui_release;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        int node$iv$iv4;
        String $i$a$RequirePreconditionModifierLocalModifierNode$current$1;
        int $i$f$getLocalsOLwlOKw;
        boolean count$iv$iv;
        int node$iv$iv;
        Modifier.Node node$iv$iv5;
        LayoutNode layout$iv$iv;
        Modifier.Node head$ui_release;
        int i7;
        int i6;
        Modifier.Node node3;
        int i4;
        int stack$iv$iv;
        DelegatableNode node$iv$iv2;
        int i;
        int i8;
        Modifier.Node node;
        androidx.compose.ui.modifier.ModifierLocal key;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node4;
        int i2;
        int this_$iv$iv$iv;
        int i3;
        int i10;
        Modifier.Node node$iv$iv3;
        int i5;
        int i9;
        Modifier.Node node2;
        int i12 = 0;
        if (!getNode().isAttached()) {
            int i14 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("ModifierLocal accessed from an unattached node");
        }
        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = this;
        int i13 = 0;
        int i16 = 0;
        final int i17 = 0;
        final int i18 = $i$f$getLocalsOLwlOKw;
        final DelegatableNode delegatableNode = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        final int i19 = 0;
        if (!delegatableNode.getNode().isAttached()) {
        } else {
            node$iv$iv5 = delegatableNode.getNode().getParent$ui_release();
            layout$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode);
            while (layout$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= i18 != 0) {
                } else {
                }
                key = value$iv;
                node$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                i = $i$f$getLocalsOLwlOKw;
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                value$iv = layout$iv$iv.getNodes$ui_release();
                if (layout$iv$iv != null && value$iv != null) {
                } else {
                }
                tail$ui_release = 0;
                node$iv$iv5 = tail$ui_release;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv2;
                $i$f$getLocalsOLwlOKw = i;
                value$iv = key;
                value$iv = layout$iv$iv.getNodes$ui_release();
                if (value$iv != null) {
                } else {
                }
                tail$ui_release = value$iv.getTail$ui_release();
                while (node$iv$iv5 != null) {
                    if (kindSet$ui_release &= i18 == 0) {
                        break loop_6;
                    } else {
                    }
                    key = value$iv;
                    node$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    i = $i$f$getLocalsOLwlOKw;
                    node$iv$iv5 = node$iv$iv5.getParent$ui_release();
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv2;
                    $i$f$getLocalsOLwlOKw = i;
                    value$iv = key;
                    i6 = 0;
                    i4 = 0;
                    stack$iv$iv = 0;
                    int i20 = 0;
                    node$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node2;
                    while ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv != null) {
                        i = $i$f$getLocalsOLwlOKw;
                        i8 = 0;
                        if (kindSet$ui_release2 &= i != 0) {
                        } else {
                        }
                        count$iv$iv = 0;
                        if (count$iv$iv != 0 && $this$visitAncestors_u2dY_u2dYKmho_u24default$iv instanceof DelegatingNode) {
                        } else {
                        }
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                        $i$f$getLocalsOLwlOKw = i;
                        value$iv = key;
                        if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv = 0;
                        node = 0;
                        node$iv$iv$iv = (DelegatingNode)$this$visitAncestors_u2dY_u2dYKmho_u24default$iv.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node4 = node$iv$iv$iv;
                            i2 = 0;
                            i3 = 0;
                            if (kindSet$ui_release3 &= i != 0) {
                            } else {
                            }
                            this_$iv$iv$iv = 0;
                            if (this_$iv$iv$iv != 0) {
                            } else {
                            }
                            node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                            next$iv$iv = node4;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            value$iv = 1;
                            count$iv$iv++;
                            if (count$iv$iv == value$iv) {
                            } else {
                            }
                            if (stack$iv$iv == 0) {
                            } else {
                            }
                            node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                            i5 = count$iv$iv;
                            capacity$iv$iv$iv$iv = 0;
                            node$iv$iv4 = stack$iv$iv;
                            stack$iv$iv = node$iv$iv4;
                            Modifier.Node node6 = node$iv$iv3;
                            if (node6 != null) {
                            } else {
                            }
                            node$iv$iv = node$iv$iv3;
                            if (stack$iv$iv != 0) {
                            } else {
                            }
                            next$iv$iv = node4;
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv;
                            count$iv$iv = i5;
                            stack$iv$iv.add(node4);
                            if (stack$iv$iv != 0) {
                            }
                            node$iv$iv = 0;
                            stack$iv$iv.add(node6);
                            this_$iv$iv$iv = 0;
                            int i11 = 16;
                            i10 = 0;
                            node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                            i5 = count$iv$iv;
                            i9 = i11;
                            node$iv$iv4 = new MutableVector(new Modifier.Node[i11], 0);
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node4;
                            next$iv$iv = node4;
                            this_$iv$iv$iv = value$iv;
                        }
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv3;
                        $i$f$getLocalsOLwlOKw = i;
                        value$iv = key;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv3;
                        node4 = node$iv$iv$iv;
                        i2 = 0;
                        i3 = 0;
                        if (kindSet$ui_release3 &= i != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        next$iv$iv = node4;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        value$iv = 1;
                        count$iv$iv++;
                        if (count$iv$iv == value$iv) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        i5 = count$iv$iv;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv4 = stack$iv$iv;
                        stack$iv$iv = node$iv$iv4;
                        node6 = node$iv$iv3;
                        if (node6 != null) {
                        } else {
                        }
                        node$iv$iv = node$iv$iv3;
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node4;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv;
                        count$iv$iv = i5;
                        stack$iv$iv.add(node4);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv = 0;
                        stack$iv$iv.add(node6);
                        this_$iv$iv$iv = 0;
                        i11 = 16;
                        i10 = 0;
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        i5 = count$iv$iv;
                        i9 = i11;
                        node$iv$iv4 = new MutableVector(new Modifier.Node[i11], 0);
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node4;
                        next$iv$iv = node4;
                        this_$iv$iv$iv = value$iv;
                        count$iv$iv = value$iv;
                        i8 = 0;
                        node = node7;
                        key = value$iv;
                    }
                    key = value$iv;
                    i = $i$f$getLocalsOLwlOKw;
                    i = $i$f$getLocalsOLwlOKw;
                    i8 = 0;
                    if (kindSet$ui_release2 &= i != 0) {
                    } else {
                    }
                    count$iv$iv = 0;
                    if (count$iv$iv != 0 && $this$visitAncestors_u2dY_u2dYKmho_u24default$iv instanceof DelegatingNode) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                    $i$f$getLocalsOLwlOKw = i;
                    value$iv = key;
                    if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    node = 0;
                    node$iv$iv$iv = (DelegatingNode)$this$visitAncestors_u2dY_u2dYKmho_u24default$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node4 = node$iv$iv$iv;
                        i2 = 0;
                        i3 = 0;
                        if (kindSet$ui_release3 &= i != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        next$iv$iv = node4;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        value$iv = 1;
                        count$iv$iv++;
                        if (count$iv$iv == value$iv) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        i5 = count$iv$iv;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv4 = stack$iv$iv;
                        stack$iv$iv = node$iv$iv4;
                        node6 = node$iv$iv3;
                        if (node6 != null) {
                        } else {
                        }
                        node$iv$iv = node$iv$iv3;
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node4;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv;
                        count$iv$iv = i5;
                        stack$iv$iv.add(node4);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv = 0;
                        stack$iv$iv.add(node6);
                        this_$iv$iv$iv = 0;
                        i11 = 16;
                        i10 = 0;
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        i5 = count$iv$iv;
                        i9 = i11;
                        node$iv$iv4 = new MutableVector(new Modifier.Node[i11], 0);
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node4;
                        next$iv$iv = node4;
                        this_$iv$iv$iv = value$iv;
                    }
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv3;
                    $i$f$getLocalsOLwlOKw = i;
                    value$iv = key;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv3;
                    node4 = node$iv$iv$iv;
                    i2 = 0;
                    i3 = 0;
                    if (kindSet$ui_release3 &= i != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    next$iv$iv = node4;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    value$iv = 1;
                    count$iv$iv++;
                    if (count$iv$iv == value$iv) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    i5 = count$iv$iv;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv4 = stack$iv$iv;
                    stack$iv$iv = node$iv$iv4;
                    node6 = node$iv$iv3;
                    if (node6 != null) {
                    } else {
                    }
                    node$iv$iv = node$iv$iv3;
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node4;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv;
                    count$iv$iv = i5;
                    stack$iv$iv.add(node4);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv = 0;
                    stack$iv$iv.add(node6);
                    this_$iv$iv$iv = 0;
                    i11 = 16;
                    i10 = 0;
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    i5 = count$iv$iv;
                    i9 = i11;
                    node$iv$iv4 = new MutableVector(new Modifier.Node[i11], 0);
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node4;
                    next$iv$iv = node4;
                    this_$iv$iv$iv = value$iv;
                    count$iv$iv = value$iv;
                    i8 = 0;
                    node = node7;
                    key = value$iv;
                }
                key = value$iv;
                node$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                i = $i$f$getLocalsOLwlOKw;
                if (kindSet$ui_release &= i18 != 0) {
                } else {
                }
                key = value$iv;
                node$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                i = $i$f$getLocalsOLwlOKw;
                node$iv$iv5 = node$iv$iv5.getParent$ui_release();
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv2;
                $i$f$getLocalsOLwlOKw = i;
                value$iv = key;
                i6 = 0;
                i4 = 0;
                stack$iv$iv = 0;
                i20 = 0;
                node$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node2;
                while ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv != null) {
                    i = $i$f$getLocalsOLwlOKw;
                    i8 = 0;
                    if (kindSet$ui_release2 &= i != 0) {
                    } else {
                    }
                    count$iv$iv = 0;
                    if (count$iv$iv != 0 && $this$visitAncestors_u2dY_u2dYKmho_u24default$iv instanceof DelegatingNode) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                    $i$f$getLocalsOLwlOKw = i;
                    value$iv = key;
                    if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    node = 0;
                    node$iv$iv$iv = (DelegatingNode)$this$visitAncestors_u2dY_u2dYKmho_u24default$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node4 = node$iv$iv$iv;
                        i2 = 0;
                        i3 = 0;
                        if (kindSet$ui_release3 &= i != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        next$iv$iv = node4;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        value$iv = 1;
                        count$iv$iv++;
                        if (count$iv$iv == value$iv) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        i5 = count$iv$iv;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv4 = stack$iv$iv;
                        stack$iv$iv = node$iv$iv4;
                        node6 = node$iv$iv3;
                        if (node6 != null) {
                        } else {
                        }
                        node$iv$iv = node$iv$iv3;
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node4;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv;
                        count$iv$iv = i5;
                        stack$iv$iv.add(node4);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv = 0;
                        stack$iv$iv.add(node6);
                        this_$iv$iv$iv = 0;
                        i11 = 16;
                        i10 = 0;
                        node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        i5 = count$iv$iv;
                        i9 = i11;
                        node$iv$iv4 = new MutableVector(new Modifier.Node[i11], 0);
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node4;
                        next$iv$iv = node4;
                        this_$iv$iv$iv = value$iv;
                    }
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv3;
                    $i$f$getLocalsOLwlOKw = i;
                    value$iv = key;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv3;
                    node4 = node$iv$iv$iv;
                    i2 = 0;
                    i3 = 0;
                    if (kindSet$ui_release3 &= i != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    next$iv$iv = node4;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    value$iv = 1;
                    count$iv$iv++;
                    if (count$iv$iv == value$iv) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    i5 = count$iv$iv;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv4 = stack$iv$iv;
                    stack$iv$iv = node$iv$iv4;
                    node6 = node$iv$iv3;
                    if (node6 != null) {
                    } else {
                    }
                    node$iv$iv = node$iv$iv3;
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node4;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv;
                    count$iv$iv = i5;
                    stack$iv$iv.add(node4);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv = 0;
                    stack$iv$iv.add(node6);
                    this_$iv$iv$iv = 0;
                    i11 = 16;
                    i10 = 0;
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    i5 = count$iv$iv;
                    i9 = i11;
                    node$iv$iv4 = new MutableVector(new Modifier.Node[i11], 0);
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node4;
                    next$iv$iv = node4;
                    this_$iv$iv$iv = value$iv;
                    count$iv$iv = value$iv;
                    i8 = 0;
                    node = node7;
                    key = value$iv;
                }
                key = value$iv;
                i = $i$f$getLocalsOLwlOKw;
                i = $i$f$getLocalsOLwlOKw;
                i8 = 0;
                if (kindSet$ui_release2 &= i != 0) {
                } else {
                }
                count$iv$iv = 0;
                if (count$iv$iv != 0 && $this$visitAncestors_u2dY_u2dYKmho_u24default$iv instanceof DelegatingNode) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                $i$f$getLocalsOLwlOKw = i;
                value$iv = key;
                if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                node = 0;
                node$iv$iv$iv = (DelegatingNode)$this$visitAncestors_u2dY_u2dYKmho_u24default$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node4 = node$iv$iv$iv;
                    i2 = 0;
                    i3 = 0;
                    if (kindSet$ui_release3 &= i != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    next$iv$iv = node4;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    value$iv = 1;
                    count$iv$iv++;
                    if (count$iv$iv == value$iv) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    i5 = count$iv$iv;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv4 = stack$iv$iv;
                    stack$iv$iv = node$iv$iv4;
                    node6 = node$iv$iv3;
                    if (node6 != null) {
                    } else {
                    }
                    node$iv$iv = node$iv$iv3;
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node4;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv;
                    count$iv$iv = i5;
                    stack$iv$iv.add(node4);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv = 0;
                    stack$iv$iv.add(node6);
                    this_$iv$iv$iv = 0;
                    i11 = 16;
                    i10 = 0;
                    node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    i5 = count$iv$iv;
                    i9 = i11;
                    node$iv$iv4 = new MutableVector(new Modifier.Node[i11], 0);
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node4;
                    next$iv$iv = node4;
                    this_$iv$iv$iv = value$iv;
                }
                node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                if (count$iv$iv == 1) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv3;
                $i$f$getLocalsOLwlOKw = i;
                value$iv = key;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv3;
                node4 = node$iv$iv$iv;
                i2 = 0;
                i3 = 0;
                if (kindSet$ui_release3 &= i != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                next$iv$iv = node4;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                value$iv = 1;
                count$iv$iv++;
                if (count$iv$iv == value$iv) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                i5 = count$iv$iv;
                capacity$iv$iv$iv$iv = 0;
                node$iv$iv4 = stack$iv$iv;
                stack$iv$iv = node$iv$iv4;
                node6 = node$iv$iv3;
                if (node6 != null) {
                } else {
                }
                node$iv$iv = node$iv$iv3;
                if (stack$iv$iv != 0) {
                } else {
                }
                next$iv$iv = node4;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node$iv$iv;
                count$iv$iv = i5;
                stack$iv$iv.add(node4);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv = 0;
                stack$iv$iv.add(node6);
                this_$iv$iv$iv = 0;
                i11 = 16;
                i10 = 0;
                node$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                i5 = count$iv$iv;
                i9 = i11;
                node$iv$iv4 = new MutableVector(new Modifier.Node[i11], 0);
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = node4;
                next$iv$iv = node4;
                this_$iv$iv$iv = value$iv;
                count$iv$iv = value$iv;
                i8 = 0;
                node = node7;
                key = value$iv;
            }
            return value$iv.getDefaultFactory$ui_release().invoke();
        }
        androidx.compose.ui.modifier.ModifierLocal key3 = value$iv;
        DelegatableNode delegatableNode2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        int key2 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalReadScope
    public androidx.compose.ui.modifier.ModifierLocalMap getProvidedValues() {
        return (ModifierLocalMap)EmptyMap.INSTANCE;
    }

    public <T> void provide(androidx.compose.ui.modifier.ModifierLocal<T> key, T value) {
        int i;
        String $i$a$RequirePreconditionModifierLocalModifierNode$provide$2;
        StringBuilder append;
        String str;
        i = getProvidedValues() != EmptyMap.INSTANCE ? 1 : 0;
        int i2 = 0;
        if (i == 0) {
            int i5 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("In order to provide locals you must override providedValues: ModifierLocalMap");
        }
        int i3 = 0;
        if (!getProvidedValues().contains$ui_release(key)) {
            int i4 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            InlineClassHelperKt.throwIllegalArgumentException(stringBuilder.append("Any provided key must be initially provided in the overridden providedValues: ModifierLocalMap property. Key ").append(key).append(" was not found.").toString());
        }
        getProvidedValues().set$ui_release(key, value);
    }
}
