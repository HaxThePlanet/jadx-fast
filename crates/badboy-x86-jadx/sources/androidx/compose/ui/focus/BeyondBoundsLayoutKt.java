package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope;
import androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection;
import androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.Companion;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001aA\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006¢\u0006\u0002\u0008\u0008H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\n\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000b", d2 = {"searchBeyondBounds", "T", "Landroidx/compose/ui/focus/FocusTargetNode;", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "searchBeyondBounds--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BeyondBoundsLayoutKt {
    public static final <T> T searchBeyondBounds--OM-vw8(androidx.compose.ui.focus.FocusTargetNode $this$searchBeyondBounds_u2d_u2dOM_u2dvw8, int direction, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        DelegatableNode count$iv$iv$iv;
        int it$iv;
        int i2;
        int $i$f$getFocusTargetOLwlOKw;
        int $i$f$nearestAncestor64DMado;
        Modifier.Node $i$f$nearestAncestor64DMado2;
        Function1 function1;
        DelegatableNode beyondBoundsLayoutParent;
        int $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv;
        Modifier.Node node$iv$iv$iv;
        LayoutNode layout$iv$iv$iv;
        int node$iv$iv$iv2;
        Object layout-o7g1Pn8;
        Modifier.Node head$ui_release;
        int i6;
        int i;
        Modifier.Node node2;
        int i10;
        int i9;
        int node$iv$iv$iv3;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv;
        int $i$f$isKindH91voCI$ui_release;
        Modifier.Node node3;
        int i5;
        Modifier.Node node$iv$iv$iv$iv;
        Modifier.Node node;
        int i8;
        int type$iv;
        int this_$iv$iv$iv$iv;
        int count$iv$iv$iv2;
        int i7;
        int i4;
        int i3;
        DelegatableNode delegatableNode;
        final int i11 = direction;
        count$iv$iv$iv = $this$searchBeyondBounds_u2d_u2dOM_u2dvw8;
        int i12 = 0;
        $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
        $i$f$nearestAncestor64DMado = 0;
        final int i15 = 0;
        final int i16 = 0;
        final int i17 = $i$f$getFocusTargetOLwlOKw;
        final DelegatableNode delegatableNode2 = beyondBoundsLayoutParent;
        final int i18 = 0;
        if (!delegatableNode2.getNode().isAttached()) {
        } else {
            node$iv$iv$iv = delegatableNode2.getNode().getParent$ui_release();
            layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode2);
            while (layout$iv$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= i17 == 0) {
                    break;
                }
                $this$nearestAncestor_u2d64DMado$iv = count$iv$iv$iv;
                type$iv = $i$f$getFocusTargetOLwlOKw;
                i3 = $i$f$nearestAncestor64DMado;
                delegatableNode = beyondBoundsLayoutParent;
                node$iv$iv$iv3 = 0;
                layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                count$iv$iv$iv = layout$iv$iv$iv.getNodes$ui_release();
                if (layout$iv$iv$iv != null && count$iv$iv$iv != null) {
                } else {
                }
                node$iv$iv$iv2 = node$iv$iv$iv3;
                node$iv$iv$iv = node$iv$iv$iv2;
                count$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv;
                $i$f$getFocusTargetOLwlOKw = type$iv;
                $i$f$nearestAncestor64DMado = i3;
                beyondBoundsLayoutParent = delegatableNode;
                count$iv$iv$iv = layout$iv$iv$iv.getNodes$ui_release();
                if (count$iv$iv$iv != null) {
                } else {
                }
                node$iv$iv$iv2 = count$iv$iv$iv.getTail$ui_release();
                while (node$iv$iv$iv != null) {
                    if (kindSet$ui_release &= i17 == 0) {
                        break loop_4;
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv = count$iv$iv$iv;
                    type$iv = $i$f$getFocusTargetOLwlOKw;
                    i3 = $i$f$nearestAncestor64DMado;
                    delegatableNode = beyondBoundsLayoutParent;
                    node$iv$iv$iv3 = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release();
                    count$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv;
                    $i$f$getFocusTargetOLwlOKw = type$iv;
                    $i$f$nearestAncestor64DMado = i3;
                    beyondBoundsLayoutParent = delegatableNode;
                    i = 0;
                    i10 = 0;
                    i9 = 0;
                    int i19 = 0;
                    node$iv$iv$iv2 = node$iv$iv$iv4;
                    node$iv$iv$iv3 = 0;
                    while (node$iv$iv$iv2 != null) {
                        $this$nearestAncestor_u2d64DMado$iv = count$iv$iv$iv;
                        it$iv = node$iv$iv$iv2;
                        int i20 = 0;
                        i5 = it$iv;
                        if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        $i$f$isKindH91voCI$ui_release = 0;
                        if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        type$iv = $i$f$getFocusTargetOLwlOKw;
                        i3 = $i$f$nearestAncestor64DMado;
                        delegatableNode = beyondBoundsLayoutParent;
                        node$iv$iv$iv2 = DelegatableNodeKt.access$pop(i9);
                        count$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv;
                        $i$f$getFocusTargetOLwlOKw = type$iv;
                        $i$f$nearestAncestor64DMado = i3;
                        beyondBoundsLayoutParent = delegatableNode;
                        if (node$iv$iv$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        it$iv = 0;
                        i5 = 0;
                        node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                        while (node$iv$iv$iv$iv != null) {
                            node = node$iv$iv$iv$iv;
                            i8 = 0;
                            count$iv$iv$iv2 = 0;
                            if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                            } else {
                            }
                            this_$iv$iv$iv$iv = 0;
                            if (this_$iv$iv$iv$iv != 0) {
                            } else {
                            }
                            type$iv = $i$f$getFocusTargetOLwlOKw;
                            i3 = $i$f$nearestAncestor64DMado;
                            delegatableNode = beyondBoundsLayoutParent;
                            $i$f$nearestAncestor64DMado2 = node;
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                            $i$f$getFocusTargetOLwlOKw = type$iv;
                            $i$f$nearestAncestor64DMado = i3;
                            beyondBoundsLayoutParent = delegatableNode;
                            it$iv++;
                            type$iv = $i$f$getFocusTargetOLwlOKw;
                            if (it$iv == 1) {
                            } else {
                            }
                            if (i9 == 0) {
                            } else {
                            }
                            count$iv$iv$iv2 = it$iv;
                            i3 = $i$f$nearestAncestor64DMado;
                            delegatableNode = beyondBoundsLayoutParent;
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                            $i$f$getFocusTargetOLwlOKw = i9;
                            Modifier.Node node4 = node$iv$iv$iv2;
                            if (node4 != null && $i$f$getFocusTargetOLwlOKw != 0) {
                            }
                            if ($i$f$getFocusTargetOLwlOKw != 0) {
                            } else {
                            }
                            $i$f$nearestAncestor64DMado2 = node;
                            i9 = $i$f$getFocusTargetOLwlOKw;
                            it$iv = count$iv$iv$iv2;
                            $i$f$getFocusTargetOLwlOKw.add(node);
                            if ($i$f$getFocusTargetOLwlOKw != 0) {
                            }
                            node$iv$iv$iv2 = $i$f$nearestAncestor64DMado;
                            $i$f$getFocusTargetOLwlOKw.add(node4);
                            count$iv$iv$iv2 = it$iv;
                            i7 = 0;
                            i4 = i13;
                            i3 = $i$f$nearestAncestor64DMado;
                            delegatableNode = beyondBoundsLayoutParent;
                            $i$f$getFocusTargetOLwlOKw = new MutableVector(new Modifier.Node[16], 0);
                            node$iv$iv$iv2 = node;
                            i3 = $i$f$nearestAncestor64DMado;
                            delegatableNode = beyondBoundsLayoutParent;
                            $i$f$nearestAncestor64DMado2 = node;
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                            this_$iv$iv$iv$iv = 1;
                        }
                        if (it$iv == 1) {
                        } else {
                        }
                        count$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv;
                        $i$f$getFocusTargetOLwlOKw = type$iv;
                        $i$f$nearestAncestor64DMado = i3;
                        beyondBoundsLayoutParent = delegatableNode;
                        node = node$iv$iv$iv$iv;
                        i8 = 0;
                        count$iv$iv$iv2 = 0;
                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv = 0;
                        if (this_$iv$iv$iv$iv != 0) {
                        } else {
                        }
                        type$iv = $i$f$getFocusTargetOLwlOKw;
                        i3 = $i$f$nearestAncestor64DMado;
                        delegatableNode = beyondBoundsLayoutParent;
                        $i$f$nearestAncestor64DMado2 = node;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                        $i$f$getFocusTargetOLwlOKw = type$iv;
                        $i$f$nearestAncestor64DMado = i3;
                        beyondBoundsLayoutParent = delegatableNode;
                        it$iv++;
                        type$iv = $i$f$getFocusTargetOLwlOKw;
                        if (it$iv == 1) {
                        } else {
                        }
                        if (i9 == 0) {
                        } else {
                        }
                        count$iv$iv$iv2 = it$iv;
                        i3 = $i$f$nearestAncestor64DMado;
                        delegatableNode = beyondBoundsLayoutParent;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                        $i$f$getFocusTargetOLwlOKw = i9;
                        node4 = node$iv$iv$iv2;
                        if (node4 != null && $i$f$getFocusTargetOLwlOKw != 0) {
                        }
                        if ($i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        $i$f$nearestAncestor64DMado2 = node;
                        i9 = $i$f$getFocusTargetOLwlOKw;
                        it$iv = count$iv$iv$iv2;
                        $i$f$getFocusTargetOLwlOKw.add(node);
                        if ($i$f$getFocusTargetOLwlOKw != 0) {
                        }
                        node$iv$iv$iv2 = $i$f$nearestAncestor64DMado;
                        $i$f$getFocusTargetOLwlOKw.add(node4);
                        count$iv$iv$iv2 = it$iv;
                        i7 = 0;
                        i4 = i13;
                        i3 = $i$f$nearestAncestor64DMado;
                        delegatableNode = beyondBoundsLayoutParent;
                        $i$f$getFocusTargetOLwlOKw = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv$iv2 = node;
                        i3 = $i$f$nearestAncestor64DMado;
                        delegatableNode = beyondBoundsLayoutParent;
                        $i$f$nearestAncestor64DMado2 = node;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                        this_$iv$iv$iv$iv = 1;
                        $i$f$isKindH91voCI$ui_release = 1;
                    }
                    $this$nearestAncestor_u2d64DMado$iv = count$iv$iv$iv;
                    type$iv = $i$f$getFocusTargetOLwlOKw;
                    i3 = $i$f$nearestAncestor64DMado;
                    delegatableNode = beyondBoundsLayoutParent;
                    $this$nearestAncestor_u2d64DMado$iv = count$iv$iv$iv;
                    it$iv = node$iv$iv$iv2;
                    i20 = 0;
                    i5 = it$iv;
                    if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    type$iv = $i$f$getFocusTargetOLwlOKw;
                    i3 = $i$f$nearestAncestor64DMado;
                    delegatableNode = beyondBoundsLayoutParent;
                    node$iv$iv$iv2 = DelegatableNodeKt.access$pop(i9);
                    count$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv;
                    $i$f$getFocusTargetOLwlOKw = type$iv;
                    $i$f$nearestAncestor64DMado = i3;
                    beyondBoundsLayoutParent = delegatableNode;
                    if (node$iv$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    it$iv = 0;
                    i5 = 0;
                    node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv$iv != null) {
                        node = node$iv$iv$iv$iv;
                        i8 = 0;
                        count$iv$iv$iv2 = 0;
                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv = 0;
                        if (this_$iv$iv$iv$iv != 0) {
                        } else {
                        }
                        type$iv = $i$f$getFocusTargetOLwlOKw;
                        i3 = $i$f$nearestAncestor64DMado;
                        delegatableNode = beyondBoundsLayoutParent;
                        $i$f$nearestAncestor64DMado2 = node;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                        $i$f$getFocusTargetOLwlOKw = type$iv;
                        $i$f$nearestAncestor64DMado = i3;
                        beyondBoundsLayoutParent = delegatableNode;
                        it$iv++;
                        type$iv = $i$f$getFocusTargetOLwlOKw;
                        if (it$iv == 1) {
                        } else {
                        }
                        if (i9 == 0) {
                        } else {
                        }
                        count$iv$iv$iv2 = it$iv;
                        i3 = $i$f$nearestAncestor64DMado;
                        delegatableNode = beyondBoundsLayoutParent;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                        $i$f$getFocusTargetOLwlOKw = i9;
                        node4 = node$iv$iv$iv2;
                        if (node4 != null && $i$f$getFocusTargetOLwlOKw != 0) {
                        }
                        if ($i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        $i$f$nearestAncestor64DMado2 = node;
                        i9 = $i$f$getFocusTargetOLwlOKw;
                        it$iv = count$iv$iv$iv2;
                        $i$f$getFocusTargetOLwlOKw.add(node);
                        if ($i$f$getFocusTargetOLwlOKw != 0) {
                        }
                        node$iv$iv$iv2 = $i$f$nearestAncestor64DMado;
                        $i$f$getFocusTargetOLwlOKw.add(node4);
                        count$iv$iv$iv2 = it$iv;
                        i7 = 0;
                        i4 = i13;
                        i3 = $i$f$nearestAncestor64DMado;
                        delegatableNode = beyondBoundsLayoutParent;
                        $i$f$getFocusTargetOLwlOKw = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv$iv2 = node;
                        i3 = $i$f$nearestAncestor64DMado;
                        delegatableNode = beyondBoundsLayoutParent;
                        $i$f$nearestAncestor64DMado2 = node;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                        this_$iv$iv$iv$iv = 1;
                    }
                    if (it$iv == 1) {
                    } else {
                    }
                    count$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv;
                    $i$f$getFocusTargetOLwlOKw = type$iv;
                    $i$f$nearestAncestor64DMado = i3;
                    beyondBoundsLayoutParent = delegatableNode;
                    node = node$iv$iv$iv$iv;
                    i8 = 0;
                    count$iv$iv$iv2 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    type$iv = $i$f$getFocusTargetOLwlOKw;
                    i3 = $i$f$nearestAncestor64DMado;
                    delegatableNode = beyondBoundsLayoutParent;
                    $i$f$nearestAncestor64DMado2 = node;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    $i$f$getFocusTargetOLwlOKw = type$iv;
                    $i$f$nearestAncestor64DMado = i3;
                    beyondBoundsLayoutParent = delegatableNode;
                    it$iv++;
                    type$iv = $i$f$getFocusTargetOLwlOKw;
                    if (it$iv == 1) {
                    } else {
                    }
                    if (i9 == 0) {
                    } else {
                    }
                    count$iv$iv$iv2 = it$iv;
                    i3 = $i$f$nearestAncestor64DMado;
                    delegatableNode = beyondBoundsLayoutParent;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                    $i$f$getFocusTargetOLwlOKw = i9;
                    node4 = node$iv$iv$iv2;
                    if (node4 != null && $i$f$getFocusTargetOLwlOKw != 0) {
                    }
                    if ($i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    $i$f$nearestAncestor64DMado2 = node;
                    i9 = $i$f$getFocusTargetOLwlOKw;
                    it$iv = count$iv$iv$iv2;
                    $i$f$getFocusTargetOLwlOKw.add(node);
                    if ($i$f$getFocusTargetOLwlOKw != 0) {
                    }
                    node$iv$iv$iv2 = $i$f$nearestAncestor64DMado;
                    $i$f$getFocusTargetOLwlOKw.add(node4);
                    count$iv$iv$iv2 = it$iv;
                    i7 = 0;
                    i4 = i13;
                    i3 = $i$f$nearestAncestor64DMado;
                    delegatableNode = beyondBoundsLayoutParent;
                    $i$f$getFocusTargetOLwlOKw = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv$iv2 = node;
                    i3 = $i$f$nearestAncestor64DMado;
                    delegatableNode = beyondBoundsLayoutParent;
                    $i$f$nearestAncestor64DMado2 = node;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                    this_$iv$iv$iv$iv = 1;
                    $i$f$isKindH91voCI$ui_release = 1;
                }
                $this$nearestAncestor_u2d64DMado$iv = count$iv$iv$iv;
                type$iv = $i$f$getFocusTargetOLwlOKw;
                i3 = $i$f$nearestAncestor64DMado;
                delegatableNode = beyondBoundsLayoutParent;
                node$iv$iv$iv3 = 0;
                if (kindSet$ui_release &= i17 == 0) {
                    break;
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv = count$iv$iv$iv;
                type$iv = $i$f$getFocusTargetOLwlOKw;
                i3 = $i$f$nearestAncestor64DMado;
                delegatableNode = beyondBoundsLayoutParent;
                node$iv$iv$iv3 = 0;
                node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release();
                count$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv;
                $i$f$getFocusTargetOLwlOKw = type$iv;
                $i$f$nearestAncestor64DMado = i3;
                beyondBoundsLayoutParent = delegatableNode;
                i = 0;
                i10 = 0;
                i9 = 0;
                i19 = 0;
                node$iv$iv$iv2 = node$iv$iv$iv4;
                node$iv$iv$iv3 = 0;
                while (node$iv$iv$iv2 != null) {
                    $this$nearestAncestor_u2d64DMado$iv = count$iv$iv$iv;
                    it$iv = node$iv$iv$iv2;
                    i20 = 0;
                    i5 = it$iv;
                    if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    type$iv = $i$f$getFocusTargetOLwlOKw;
                    i3 = $i$f$nearestAncestor64DMado;
                    delegatableNode = beyondBoundsLayoutParent;
                    node$iv$iv$iv2 = DelegatableNodeKt.access$pop(i9);
                    count$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv;
                    $i$f$getFocusTargetOLwlOKw = type$iv;
                    $i$f$nearestAncestor64DMado = i3;
                    beyondBoundsLayoutParent = delegatableNode;
                    if (node$iv$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    it$iv = 0;
                    i5 = 0;
                    node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv$iv != null) {
                        node = node$iv$iv$iv$iv;
                        i8 = 0;
                        count$iv$iv$iv2 = 0;
                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv = 0;
                        if (this_$iv$iv$iv$iv != 0) {
                        } else {
                        }
                        type$iv = $i$f$getFocusTargetOLwlOKw;
                        i3 = $i$f$nearestAncestor64DMado;
                        delegatableNode = beyondBoundsLayoutParent;
                        $i$f$nearestAncestor64DMado2 = node;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                        $i$f$getFocusTargetOLwlOKw = type$iv;
                        $i$f$nearestAncestor64DMado = i3;
                        beyondBoundsLayoutParent = delegatableNode;
                        it$iv++;
                        type$iv = $i$f$getFocusTargetOLwlOKw;
                        if (it$iv == 1) {
                        } else {
                        }
                        if (i9 == 0) {
                        } else {
                        }
                        count$iv$iv$iv2 = it$iv;
                        i3 = $i$f$nearestAncestor64DMado;
                        delegatableNode = beyondBoundsLayoutParent;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                        $i$f$getFocusTargetOLwlOKw = i9;
                        node4 = node$iv$iv$iv2;
                        if (node4 != null && $i$f$getFocusTargetOLwlOKw != 0) {
                        }
                        if ($i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        $i$f$nearestAncestor64DMado2 = node;
                        i9 = $i$f$getFocusTargetOLwlOKw;
                        it$iv = count$iv$iv$iv2;
                        $i$f$getFocusTargetOLwlOKw.add(node);
                        if ($i$f$getFocusTargetOLwlOKw != 0) {
                        }
                        node$iv$iv$iv2 = $i$f$nearestAncestor64DMado;
                        $i$f$getFocusTargetOLwlOKw.add(node4);
                        count$iv$iv$iv2 = it$iv;
                        i7 = 0;
                        i4 = i13;
                        i3 = $i$f$nearestAncestor64DMado;
                        delegatableNode = beyondBoundsLayoutParent;
                        $i$f$getFocusTargetOLwlOKw = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv$iv2 = node;
                        i3 = $i$f$nearestAncestor64DMado;
                        delegatableNode = beyondBoundsLayoutParent;
                        $i$f$nearestAncestor64DMado2 = node;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                        this_$iv$iv$iv$iv = 1;
                    }
                    if (it$iv == 1) {
                    } else {
                    }
                    count$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv;
                    $i$f$getFocusTargetOLwlOKw = type$iv;
                    $i$f$nearestAncestor64DMado = i3;
                    beyondBoundsLayoutParent = delegatableNode;
                    node = node$iv$iv$iv$iv;
                    i8 = 0;
                    count$iv$iv$iv2 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    type$iv = $i$f$getFocusTargetOLwlOKw;
                    i3 = $i$f$nearestAncestor64DMado;
                    delegatableNode = beyondBoundsLayoutParent;
                    $i$f$nearestAncestor64DMado2 = node;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    $i$f$getFocusTargetOLwlOKw = type$iv;
                    $i$f$nearestAncestor64DMado = i3;
                    beyondBoundsLayoutParent = delegatableNode;
                    it$iv++;
                    type$iv = $i$f$getFocusTargetOLwlOKw;
                    if (it$iv == 1) {
                    } else {
                    }
                    if (i9 == 0) {
                    } else {
                    }
                    count$iv$iv$iv2 = it$iv;
                    i3 = $i$f$nearestAncestor64DMado;
                    delegatableNode = beyondBoundsLayoutParent;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                    $i$f$getFocusTargetOLwlOKw = i9;
                    node4 = node$iv$iv$iv2;
                    if (node4 != null && $i$f$getFocusTargetOLwlOKw != 0) {
                    }
                    if ($i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    $i$f$nearestAncestor64DMado2 = node;
                    i9 = $i$f$getFocusTargetOLwlOKw;
                    it$iv = count$iv$iv$iv2;
                    $i$f$getFocusTargetOLwlOKw.add(node);
                    if ($i$f$getFocusTargetOLwlOKw != 0) {
                    }
                    node$iv$iv$iv2 = $i$f$nearestAncestor64DMado;
                    $i$f$getFocusTargetOLwlOKw.add(node4);
                    count$iv$iv$iv2 = it$iv;
                    i7 = 0;
                    i4 = i13;
                    i3 = $i$f$nearestAncestor64DMado;
                    delegatableNode = beyondBoundsLayoutParent;
                    $i$f$getFocusTargetOLwlOKw = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv$iv2 = node;
                    i3 = $i$f$nearestAncestor64DMado;
                    delegatableNode = beyondBoundsLayoutParent;
                    $i$f$nearestAncestor64DMado2 = node;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                    this_$iv$iv$iv$iv = 1;
                    $i$f$isKindH91voCI$ui_release = 1;
                }
                $this$nearestAncestor_u2d64DMado$iv = count$iv$iv$iv;
                type$iv = $i$f$getFocusTargetOLwlOKw;
                i3 = $i$f$nearestAncestor64DMado;
                delegatableNode = beyondBoundsLayoutParent;
                $this$nearestAncestor_u2d64DMado$iv = count$iv$iv$iv;
                it$iv = node$iv$iv$iv2;
                i20 = 0;
                i5 = it$iv;
                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                $i$f$isKindH91voCI$ui_release = 0;
                if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                type$iv = $i$f$getFocusTargetOLwlOKw;
                i3 = $i$f$nearestAncestor64DMado;
                delegatableNode = beyondBoundsLayoutParent;
                node$iv$iv$iv2 = DelegatableNodeKt.access$pop(i9);
                count$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv;
                $i$f$getFocusTargetOLwlOKw = type$iv;
                $i$f$nearestAncestor64DMado = i3;
                beyondBoundsLayoutParent = delegatableNode;
                if (node$iv$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                it$iv = 0;
                i5 = 0;
                node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv$iv != null) {
                    node = node$iv$iv$iv$iv;
                    i8 = 0;
                    count$iv$iv$iv2 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    type$iv = $i$f$getFocusTargetOLwlOKw;
                    i3 = $i$f$nearestAncestor64DMado;
                    delegatableNode = beyondBoundsLayoutParent;
                    $i$f$nearestAncestor64DMado2 = node;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    $i$f$getFocusTargetOLwlOKw = type$iv;
                    $i$f$nearestAncestor64DMado = i3;
                    beyondBoundsLayoutParent = delegatableNode;
                    it$iv++;
                    type$iv = $i$f$getFocusTargetOLwlOKw;
                    if (it$iv == 1) {
                    } else {
                    }
                    if (i9 == 0) {
                    } else {
                    }
                    count$iv$iv$iv2 = it$iv;
                    i3 = $i$f$nearestAncestor64DMado;
                    delegatableNode = beyondBoundsLayoutParent;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                    $i$f$getFocusTargetOLwlOKw = i9;
                    node4 = node$iv$iv$iv2;
                    if (node4 != null && $i$f$getFocusTargetOLwlOKw != 0) {
                    }
                    if ($i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    $i$f$nearestAncestor64DMado2 = node;
                    i9 = $i$f$getFocusTargetOLwlOKw;
                    it$iv = count$iv$iv$iv2;
                    $i$f$getFocusTargetOLwlOKw.add(node);
                    if ($i$f$getFocusTargetOLwlOKw != 0) {
                    }
                    node$iv$iv$iv2 = $i$f$nearestAncestor64DMado;
                    $i$f$getFocusTargetOLwlOKw.add(node4);
                    count$iv$iv$iv2 = it$iv;
                    i7 = 0;
                    i4 = i13;
                    i3 = $i$f$nearestAncestor64DMado;
                    delegatableNode = beyondBoundsLayoutParent;
                    $i$f$getFocusTargetOLwlOKw = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv$iv2 = node;
                    i3 = $i$f$nearestAncestor64DMado;
                    delegatableNode = beyondBoundsLayoutParent;
                    $i$f$nearestAncestor64DMado2 = node;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                    this_$iv$iv$iv$iv = 1;
                }
                if (it$iv == 1) {
                } else {
                }
                count$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv;
                $i$f$getFocusTargetOLwlOKw = type$iv;
                $i$f$nearestAncestor64DMado = i3;
                beyondBoundsLayoutParent = delegatableNode;
                node = node$iv$iv$iv$iv;
                i8 = 0;
                count$iv$iv$iv2 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv$iv = 0;
                if (this_$iv$iv$iv$iv != 0) {
                } else {
                }
                type$iv = $i$f$getFocusTargetOLwlOKw;
                i3 = $i$f$nearestAncestor64DMado;
                delegatableNode = beyondBoundsLayoutParent;
                $i$f$nearestAncestor64DMado2 = node;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                $i$f$getFocusTargetOLwlOKw = type$iv;
                $i$f$nearestAncestor64DMado = i3;
                beyondBoundsLayoutParent = delegatableNode;
                it$iv++;
                type$iv = $i$f$getFocusTargetOLwlOKw;
                if (it$iv == 1) {
                } else {
                }
                if (i9 == 0) {
                } else {
                }
                count$iv$iv$iv2 = it$iv;
                i3 = $i$f$nearestAncestor64DMado;
                delegatableNode = beyondBoundsLayoutParent;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                $i$f$getFocusTargetOLwlOKw = i9;
                node4 = node$iv$iv$iv2;
                if (node4 != null && $i$f$getFocusTargetOLwlOKw != 0) {
                }
                if ($i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                $i$f$nearestAncestor64DMado2 = node;
                i9 = $i$f$getFocusTargetOLwlOKw;
                it$iv = count$iv$iv$iv2;
                $i$f$getFocusTargetOLwlOKw.add(node);
                if ($i$f$getFocusTargetOLwlOKw != 0) {
                }
                node$iv$iv$iv2 = $i$f$nearestAncestor64DMado;
                $i$f$getFocusTargetOLwlOKw.add(node4);
                count$iv$iv$iv2 = it$iv;
                i7 = 0;
                i4 = i13;
                i3 = $i$f$nearestAncestor64DMado;
                delegatableNode = beyondBoundsLayoutParent;
                $i$f$getFocusTargetOLwlOKw = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv$iv2 = node;
                i3 = $i$f$nearestAncestor64DMado;
                delegatableNode = beyondBoundsLayoutParent;
                $i$f$nearestAncestor64DMado2 = node;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = 0;
                this_$iv$iv$iv$iv = 1;
                $i$f$isKindH91voCI$ui_release = 1;
            }
            $this$nearestAncestor_u2d64DMado$iv = count$iv$iv$iv;
            type$iv = $i$f$getFocusTargetOLwlOKw;
            i3 = $i$f$nearestAncestor64DMado;
            delegatableNode = beyondBoundsLayoutParent;
            i2 = node$iv$iv$iv3;
            $i$f$getFocusTargetOLwlOKw = 0;
            if (i2 != 0 && Intrinsics.areEqual((FocusTargetNode)i2.getBeyondBoundsLayoutParent(), $this$searchBeyondBounds_u2d_u2dOM_u2dvw8.getBeyondBoundsLayoutParent())) {
                $i$f$getFocusTargetOLwlOKw = 0;
                if (Intrinsics.areEqual(i2.getBeyondBoundsLayoutParent(), $this$searchBeyondBounds_u2d_u2dOM_u2dvw8.getBeyondBoundsLayoutParent())) {
                    return node$iv$iv$iv3;
                }
            }
            BeyondBoundsLayout beyondBoundsLayoutParent2 = $this$searchBeyondBounds_u2d_u2dOM_u2dvw8.getBeyondBoundsLayoutParent();
            if (beyondBoundsLayoutParent2 != null) {
                if (FocusDirection.equals-impl0(i11, FocusDirection.Companion.getUp-dhqQ-8s())) {
                    $i$f$getFocusTargetOLwlOKw = BeyondBoundsLayout.LayoutDirection.Companion.getAbove-hoxUOeE();
                    layout-o7g1Pn8 = beyondBoundsLayoutParent2.layout-o7g1Pn8($i$f$getFocusTargetOLwlOKw, block);
                    return layout-o7g1Pn8;
                } else {
                    if (FocusDirection.equals-impl0(i11, FocusDirection.Companion.getDown-dhqQ-8s())) {
                        $i$f$getFocusTargetOLwlOKw = BeyondBoundsLayout.LayoutDirection.Companion.getBelow-hoxUOeE();
                    } else {
                        if (FocusDirection.equals-impl0(i11, FocusDirection.Companion.getLeft-dhqQ-8s())) {
                            $i$f$getFocusTargetOLwlOKw = BeyondBoundsLayout.LayoutDirection.Companion.getLeft-hoxUOeE();
                        } else {
                            if (FocusDirection.equals-impl0(i11, FocusDirection.Companion.getRight-dhqQ-8s())) {
                                $i$f$getFocusTargetOLwlOKw = BeyondBoundsLayout.LayoutDirection.Companion.getRight-hoxUOeE();
                            } else {
                                if (FocusDirection.equals-impl0(i11, FocusDirection.Companion.getNext-dhqQ-8s())) {
                                    $i$f$getFocusTargetOLwlOKw = BeyondBoundsLayout.LayoutDirection.Companion.getAfter-hoxUOeE();
                                } else {
                                    if (!FocusDirection.equals-impl0(i11, FocusDirection.Companion.getPrevious-dhqQ-8s())) {
                                    } else {
                                        $i$f$getFocusTargetOLwlOKw = BeyondBoundsLayout.LayoutDirection.Companion.getBefore-hoxUOeE();
                                    }
                                }
                            }
                        }
                    }
                }
                Function1 function12 = block;
                IllegalStateException illegalStateException = new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
                throw illegalStateException;
            }
            function1 = block;
            layout-o7g1Pn8 = node$iv$iv$iv3;
        }
        DelegatableNode delegatableNode3 = count$iv$iv$iv;
        int i21 = $i$f$getFocusTargetOLwlOKw;
        int $this$nearestAncestor_u2d64DMado$iv2 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv;
    }
}
