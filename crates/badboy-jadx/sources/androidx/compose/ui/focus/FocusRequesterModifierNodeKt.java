package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.PinnableContainer.PinnedHandle;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0002H\u0000\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a\u000c\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u000c\u0010\u0008\u001a\u00020\u0001*\u00020\u0002H\u0007¨\u0006\t", d2 = {"captureFocus", "", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "freeFocus", "pinFocusedChild", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "requestFocus", "restoreFocusedChild", "saveFocusedChild", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FocusRequesterModifierNodeKt {
    public static final boolean captureFocus(androidx.compose.ui.focus.FocusRequesterModifierNode $this$captureFocus) {
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
        int mask$iv$iv;
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
        int $i$f$getFocusTargetOLwlOKw;
        int i8;
        Modifier.Node $this$visitChildren$iv$iv2;
        int $this$visitChildren$iv$iv;
        int $i$f$visitSelfAndChildren6rFNWt0;
        int stack$iv$iv;
        int node;
        Modifier.Node node$iv$iv3;
        int node$iv$iv;
        int i;
        int i10;
        int count$iv$iv;
        Modifier.Node[] arr;
        Modifier.Node captureFocus;
        int i2;
        Modifier.Node node$iv$iv$iv2;
        Modifier.Node stack$iv$iv2;
        int node$iv$iv2;
        int count$iv$iv2;
        int i7;
        int i9;
        Modifier.Node $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
        int i6;
        int captureFocus2;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i5;
        int this_$iv$iv$iv;
        int mask$iv$iv2;
        int i4;
        int i3;
        int i11;
        int i12;
        int i13 = 0;
        $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
        $i$f$visitSelfAndChildren6rFNWt0 = 0;
        int i16 = 0;
        stack$iv$iv = 0;
        int i18 = 0;
        node$iv$iv3 = node3;
        i = 0;
        i10 = 1;
        while (node$iv$iv3 != null) {
            captureFocus = 0;
            if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
            } else {
            }
            count$iv$iv = i;
            if (count$iv$iv != 0 && node$iv$iv3 instanceof DelegatingNode) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            i6 = $i$f$getFocusTargetOLwlOKw;
            node$iv$iv3 = DelegatableNodeKt.access$pop(stack$iv$iv);
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
            $i$f$getFocusTargetOLwlOKw = i6;
            i = 0;
            i10 = 1;
            if (node$iv$iv3 instanceof DelegatingNode) {
            } else {
            }
            count$iv$iv = 0;
            i2 = 0;
            node$iv$iv$iv2 = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
            while (node$iv$iv$iv2 != null) {
                stack$iv$iv2 = node$iv$iv$iv2;
                node$iv$iv2 = 0;
                i7 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                count$iv$iv2 = i;
                if (count$iv$iv2 != 0) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i6 = $i$f$getFocusTargetOLwlOKw;
                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                $i$f$getFocusTargetOLwlOKw = i6;
                i10 = 1;
                if (count$iv$iv++ == i10) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i6 = $i$f$getFocusTargetOLwlOKw;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = stack$iv$iv;
                stack$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = node$iv$iv3;
                if ($this$visitSelfAndChildren_u2d6rFNWt0$iv != null && stack$iv$iv != 0) {
                }
                if (stack$iv$iv != 0) {
                }
                stack$iv$iv.add(stack$iv$iv2);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv3 = $i$f$getFocusTargetOLwlOKw;
                stack$iv$iv.add($this$visitSelfAndChildren_u2d6rFNWt0$iv);
                count$iv$iv2 = 0;
                i9 = 0;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i6 = $i$f$getFocusTargetOLwlOKw;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = new MutableVector(new Modifier.Node[16], i);
                node$iv$iv3 = stack$iv$iv2;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i6 = $i$f$getFocusTargetOLwlOKw;
                count$iv$iv2 = i10;
            }
            if (count$iv$iv == 1) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
            $i$f$getFocusTargetOLwlOKw = i6;
            stack$iv$iv2 = node$iv$iv$iv2;
            node$iv$iv2 = 0;
            i7 = 0;
            if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
            } else {
            }
            count$iv$iv2 = i;
            if (count$iv$iv2 != 0) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            i6 = $i$f$getFocusTargetOLwlOKw;
            node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
            $i$f$getFocusTargetOLwlOKw = i6;
            i10 = 1;
            if (count$iv$iv++ == i10) {
            } else {
            }
            if (stack$iv$iv == 0) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            i6 = $i$f$getFocusTargetOLwlOKw;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = stack$iv$iv;
            stack$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = node$iv$iv3;
            if ($this$visitSelfAndChildren_u2d6rFNWt0$iv != null && stack$iv$iv != 0) {
            }
            if (stack$iv$iv != 0) {
            }
            stack$iv$iv.add(stack$iv$iv2);
            if (stack$iv$iv != 0) {
            }
            node$iv$iv3 = $i$f$getFocusTargetOLwlOKw;
            stack$iv$iv.add($this$visitSelfAndChildren_u2d6rFNWt0$iv);
            count$iv$iv2 = 0;
            i9 = 0;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            i6 = $i$f$getFocusTargetOLwlOKw;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = new MutableVector(new Modifier.Node[16], i);
            node$iv$iv3 = stack$iv$iv2;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            i6 = $i$f$getFocusTargetOLwlOKw;
            count$iv$iv2 = i10;
            count$iv$iv = i10;
            count$iv$iv = 0;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            i6 = $i$f$getFocusTargetOLwlOKw;
        }
        int i23 = $i$f$getFocusTargetOLwlOKw;
        i8 = $this$visitSelfAndChildren_u2d6rFNWt0$iv5;
        int i15 = 0;
        if (!i8.getNode().isAttached()) {
        } else {
            int i17 = 0;
            node$iv$iv = 0;
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], i);
            Modifier.Node child$ui_release = i8.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, i8.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                int i19 = 0;
                i7 = 1;
                node = mutableVector2.removeAt(size--);
                if (aggregateChildKindSet$ui_release &= $this$visitSelfAndChildren_u2d6rFNWt0$iv4 == 0) {
                } else {
                }
                node$iv$iv = node;
                while (node$iv$iv != 0) {
                    i3 = i8;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    int mask$iv$iv6 = 1;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                    i = 0;
                }
                i3 = i8;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                int mask$iv$iv3 = 1;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                i = 0;
                if (kindSet$ui_release &= $this$visitSelfAndChildren_u2d6rFNWt0$iv4 != null) {
                } else {
                }
                i3 = i8;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv6 = 1;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                i = 0;
                captureFocus = 0;
                node$iv$iv$iv2 = null;
                stack$iv$iv2 = 0;
                int i20 = 0;
                node$iv$iv2 = i2;
                while (node$iv$iv2 != 0) {
                    i9 = 0;
                    if (kindSet$ui_release4 &= i23 != 0) {
                    } else {
                    }
                    count$iv$iv2 = i;
                    if (count$iv$iv2 != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    i3 = i8;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv = 1;
                    node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv2);
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                    i8 = i3;
                    $i$f$visitSelfAndChildren6rFNWt0 = i11;
                    i = 0;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    captureFocus2 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i5 = 0;
                        int i25 = 0;
                        if (kindSet$ui_release5 &= i23 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = i;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                        i3 = i8;
                        i11 = $i$f$visitSelfAndChildren6rFNWt0;
                        $this$visitChildren$iv$iv2 = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                        i8 = i3;
                        $i$f$visitSelfAndChildren6rFNWt0 = i11;
                        i = 0;
                        if (count$iv$iv2++ == 1) {
                        } else {
                        }
                        if (stack$iv$iv2 == 0) {
                        } else {
                        }
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                        i3 = i8;
                        i11 = $i$f$visitSelfAndChildren6rFNWt0;
                        $this$visitChildren$iv$iv = stack$iv$iv2;
                        stack$iv$iv2 = $this$visitChildren$iv$iv;
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = node$iv$iv2;
                        if ($this$visitSelfAndChildren_u2d6rFNWt0$iv4 != 0 && stack$iv$iv2 != 0) {
                        }
                        if (stack$iv$iv2 != 0) {
                        } else {
                        }
                        $this$visitChildren$iv$iv2 = node2;
                        stack$iv$iv2.add(node2);
                        if (stack$iv$iv2 != 0) {
                        }
                        node$iv$iv2 = $this$visitChildren$iv$iv;
                        stack$iv$iv2.add($this$visitSelfAndChildren_u2d6rFNWt0$iv4);
                        i = 0;
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                        int mask$iv$iv5 = 16;
                        i4 = 0;
                        i3 = i8;
                        i11 = $i$f$visitSelfAndChildren6rFNWt0;
                        i12 = mask$iv$iv5;
                        $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv5], 0);
                        node$iv$iv2 = node2;
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                        i3 = i8;
                        i11 = $i$f$visitSelfAndChildren6rFNWt0;
                        $this$visitChildren$iv$iv2 = node2;
                        this_$iv$iv$iv = 1;
                    }
                    if (count$iv$iv2 == 1) {
                    } else {
                    }
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                    i8 = i3;
                    $i$f$visitSelfAndChildren6rFNWt0 = i11;
                    i = 0;
                    node2 = node$iv$iv$iv;
                    i5 = 0;
                    i25 = 0;
                    if (kindSet$ui_release5 &= i23 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = i;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    i3 = i8;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv2 = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                    i8 = i3;
                    $i$f$visitSelfAndChildren6rFNWt0 = i11;
                    i = 0;
                    if (count$iv$iv2++ == 1) {
                    } else {
                    }
                    if (stack$iv$iv2 == 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    i3 = i8;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv = stack$iv$iv2;
                    stack$iv$iv2 = $this$visitChildren$iv$iv;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = node$iv$iv2;
                    if ($this$visitSelfAndChildren_u2d6rFNWt0$iv4 != 0 && stack$iv$iv2 != 0) {
                    }
                    if (stack$iv$iv2 != 0) {
                    } else {
                    }
                    $this$visitChildren$iv$iv2 = node2;
                    stack$iv$iv2.add(node2);
                    if (stack$iv$iv2 != 0) {
                    }
                    node$iv$iv2 = $this$visitChildren$iv$iv;
                    stack$iv$iv2.add($this$visitSelfAndChildren_u2d6rFNWt0$iv4);
                    i = 0;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    mask$iv$iv5 = 16;
                    i4 = 0;
                    i3 = i8;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    i12 = mask$iv$iv5;
                    $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv5], 0);
                    node$iv$iv2 = node2;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    i3 = i8;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv2 = node2;
                    this_$iv$iv$iv = 1;
                    count$iv$iv2 = 1;
                    i9 = 0;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    i3 = i8;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv = 1;
                }
                i3 = i8;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                int mask$iv$iv4 = 1;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                i = 0;
                i9 = 0;
                if (kindSet$ui_release4 &= i23 != 0) {
                } else {
                }
                count$iv$iv2 = i;
                if (count$iv$iv2 != 0 && node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                i3 = i8;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv = 1;
                node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv2);
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                i8 = i3;
                $i$f$visitSelfAndChildren6rFNWt0 = i11;
                i = 0;
                if (node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv2 = 0;
                captureFocus2 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node2 = node$iv$iv$iv;
                    i5 = 0;
                    i25 = 0;
                    if (kindSet$ui_release5 &= i23 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = i;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    i3 = i8;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv2 = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                    i8 = i3;
                    $i$f$visitSelfAndChildren6rFNWt0 = i11;
                    i = 0;
                    if (count$iv$iv2++ == 1) {
                    } else {
                    }
                    if (stack$iv$iv2 == 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    i3 = i8;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv = stack$iv$iv2;
                    stack$iv$iv2 = $this$visitChildren$iv$iv;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = node$iv$iv2;
                    if ($this$visitSelfAndChildren_u2d6rFNWt0$iv4 != 0 && stack$iv$iv2 != 0) {
                    }
                    if (stack$iv$iv2 != 0) {
                    } else {
                    }
                    $this$visitChildren$iv$iv2 = node2;
                    stack$iv$iv2.add(node2);
                    if (stack$iv$iv2 != 0) {
                    }
                    node$iv$iv2 = $this$visitChildren$iv$iv;
                    stack$iv$iv2.add($this$visitSelfAndChildren_u2d6rFNWt0$iv4);
                    i = 0;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    mask$iv$iv5 = 16;
                    i4 = 0;
                    i3 = i8;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    i12 = mask$iv$iv5;
                    $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv5], 0);
                    node$iv$iv2 = node2;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    i3 = i8;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv2 = node2;
                    this_$iv$iv$iv = 1;
                }
                if (count$iv$iv2 == 1) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                i8 = i3;
                $i$f$visitSelfAndChildren6rFNWt0 = i11;
                i = 0;
                node2 = node$iv$iv$iv;
                i5 = 0;
                i25 = 0;
                if (kindSet$ui_release5 &= i23 != 0) {
                } else {
                }
                this_$iv$iv$iv = i;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                i3 = i8;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                $this$visitChildren$iv$iv2 = node2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                i8 = i3;
                $i$f$visitSelfAndChildren6rFNWt0 = i11;
                i = 0;
                if (count$iv$iv2++ == 1) {
                } else {
                }
                if (stack$iv$iv2 == 0) {
                } else {
                }
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                i3 = i8;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                $this$visitChildren$iv$iv = stack$iv$iv2;
                stack$iv$iv2 = $this$visitChildren$iv$iv;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = node$iv$iv2;
                if ($this$visitSelfAndChildren_u2d6rFNWt0$iv4 != 0 && stack$iv$iv2 != 0) {
                }
                if (stack$iv$iv2 != 0) {
                } else {
                }
                $this$visitChildren$iv$iv2 = node2;
                stack$iv$iv2.add(node2);
                if (stack$iv$iv2 != 0) {
                }
                node$iv$iv2 = $this$visitChildren$iv$iv;
                stack$iv$iv2.add($this$visitSelfAndChildren_u2d6rFNWt0$iv4);
                i = 0;
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                mask$iv$iv5 = 16;
                i4 = 0;
                i3 = i8;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                i12 = mask$iv$iv5;
                $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv5], 0);
                node$iv$iv2 = node2;
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                i3 = i8;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                $this$visitChildren$iv$iv2 = node2;
                this_$iv$iv$iv = 1;
                count$iv$iv2 = 1;
                i9 = 0;
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                i3 = i8;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv = 1;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node);
            }
            return 0;
        }
        int i26 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
        int i27 = i8;
        int mask$iv$iv7 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv;
    }

    public static final boolean freeFocus(androidx.compose.ui.focus.FocusRequesterModifierNode $this$freeFocus) {
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
        int mask$iv$iv2;
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
        int $i$f$getFocusTargetOLwlOKw;
        int i4;
        Modifier.Node $this$visitChildren$iv$iv;
        int $this$visitChildren$iv$iv2;
        int $i$f$visitSelfAndChildren6rFNWt0;
        int stack$iv$iv;
        int node;
        Modifier.Node node$iv$iv;
        int node$iv$iv2;
        int i;
        int i12;
        int count$iv$iv;
        Modifier.Node[] arr;
        Modifier.Node freeFocus;
        int i5;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node stack$iv$iv2;
        int node$iv$iv3;
        int count$iv$iv2;
        int i10;
        int i7;
        Modifier.Node $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int i6;
        int freeFocus2;
        Modifier.Node node$iv$iv$iv2;
        Modifier.Node node2;
        int i2;
        int this_$iv$iv$iv;
        int mask$iv$iv;
        int i3;
        int i8;
        int i11;
        int i9;
        int i13 = 0;
        $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
        $i$f$visitSelfAndChildren6rFNWt0 = 0;
        int i16 = 0;
        stack$iv$iv = 0;
        int i18 = 0;
        node$iv$iv = node3;
        i = 0;
        i12 = 1;
        while (node$iv$iv != null) {
            freeFocus = 0;
            if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
            } else {
            }
            count$iv$iv = i;
            if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i6 = $i$f$getFocusTargetOLwlOKw;
            node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            $i$f$getFocusTargetOLwlOKw = i6;
            i = 0;
            i12 = 1;
            if (node$iv$iv instanceof DelegatingNode) {
            } else {
            }
            count$iv$iv = 0;
            i5 = 0;
            node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
            while (node$iv$iv$iv != null) {
                stack$iv$iv2 = node$iv$iv$iv;
                node$iv$iv3 = 0;
                i10 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                count$iv$iv2 = i;
                if (count$iv$iv2 != 0) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i6 = $i$f$getFocusTargetOLwlOKw;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                $i$f$getFocusTargetOLwlOKw = i6;
                i12 = 1;
                if (count$iv$iv++ == i12) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i6 = $i$f$getFocusTargetOLwlOKw;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = stack$iv$iv;
                stack$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = node$iv$iv;
                if ($this$visitSelfAndChildren_u2d6rFNWt0$iv2 != null && stack$iv$iv != 0) {
                }
                if (stack$iv$iv != 0) {
                }
                stack$iv$iv.add(stack$iv$iv2);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv = $i$f$getFocusTargetOLwlOKw;
                stack$iv$iv.add($this$visitSelfAndChildren_u2d6rFNWt0$iv2);
                count$iv$iv2 = 0;
                i7 = 0;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i6 = $i$f$getFocusTargetOLwlOKw;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = new MutableVector(new Modifier.Node[16], i);
                node$iv$iv = stack$iv$iv2;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i6 = $i$f$getFocusTargetOLwlOKw;
                count$iv$iv2 = i12;
            }
            if (count$iv$iv == 1) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            $i$f$getFocusTargetOLwlOKw = i6;
            stack$iv$iv2 = node$iv$iv$iv;
            node$iv$iv3 = 0;
            i10 = 0;
            if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
            } else {
            }
            count$iv$iv2 = i;
            if (count$iv$iv2 != 0) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i6 = $i$f$getFocusTargetOLwlOKw;
            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            $i$f$getFocusTargetOLwlOKw = i6;
            i12 = 1;
            if (count$iv$iv++ == i12) {
            } else {
            }
            if (stack$iv$iv == 0) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i6 = $i$f$getFocusTargetOLwlOKw;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = stack$iv$iv;
            stack$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = node$iv$iv;
            if ($this$visitSelfAndChildren_u2d6rFNWt0$iv2 != null && stack$iv$iv != 0) {
            }
            if (stack$iv$iv != 0) {
            }
            stack$iv$iv.add(stack$iv$iv2);
            if (stack$iv$iv != 0) {
            }
            node$iv$iv = $i$f$getFocusTargetOLwlOKw;
            stack$iv$iv.add($this$visitSelfAndChildren_u2d6rFNWt0$iv2);
            count$iv$iv2 = 0;
            i7 = 0;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i6 = $i$f$getFocusTargetOLwlOKw;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = new MutableVector(new Modifier.Node[16], i);
            node$iv$iv = stack$iv$iv2;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i6 = $i$f$getFocusTargetOLwlOKw;
            count$iv$iv2 = i12;
            count$iv$iv = i12;
            count$iv$iv = 0;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i6 = $i$f$getFocusTargetOLwlOKw;
        }
        int i23 = $i$f$getFocusTargetOLwlOKw;
        i4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv5;
        int i15 = 0;
        if (!i4.getNode().isAttached()) {
        } else {
            int i17 = 0;
            node$iv$iv2 = 0;
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], i);
            Modifier.Node child$ui_release = i4.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, i4.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                int i19 = 0;
                i10 = 1;
                node = mutableVector2.removeAt(size--);
                if (aggregateChildKindSet$ui_release &= $this$visitSelfAndChildren_u2d6rFNWt0$iv3 == 0) {
                } else {
                }
                node$iv$iv2 = node;
                while (node$iv$iv2 != 0) {
                    i8 = i4;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    int mask$iv$iv6 = 1;
                    node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv;
                    i = 0;
                }
                i8 = i4;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                int mask$iv$iv3 = 1;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv;
                i = 0;
                if (kindSet$ui_release &= $this$visitSelfAndChildren_u2d6rFNWt0$iv3 != null) {
                } else {
                }
                i8 = i4;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv6 = 1;
                node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv;
                i = 0;
                freeFocus = 0;
                node$iv$iv$iv = null;
                stack$iv$iv2 = 0;
                int i20 = 0;
                node$iv$iv3 = i5;
                while (node$iv$iv3 != 0) {
                    i7 = 0;
                    if (kindSet$ui_release4 &= i23 != 0) {
                    } else {
                    }
                    count$iv$iv2 = i;
                    if (count$iv$iv2 != 0 && node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i8 = i4;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv2 = 1;
                    node$iv$iv3 = DelegatableNodeKt.access$pop(stack$iv$iv2);
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv;
                    i4 = i8;
                    $i$f$visitSelfAndChildren6rFNWt0 = i11;
                    i = 0;
                    if (node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    freeFocus2 = 0;
                    node$iv$iv$iv2 = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv2 != null) {
                        node2 = node$iv$iv$iv2;
                        i2 = 0;
                        int i25 = 0;
                        if (kindSet$ui_release5 &= i23 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = i;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                        i8 = i4;
                        i11 = $i$f$visitSelfAndChildren6rFNWt0;
                        $this$visitChildren$iv$iv = node2;
                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv;
                        i4 = i8;
                        $i$f$visitSelfAndChildren6rFNWt0 = i11;
                        i = 0;
                        if (count$iv$iv2++ == 1) {
                        } else {
                        }
                        if (stack$iv$iv2 == 0) {
                        } else {
                        }
                        mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                        i8 = i4;
                        i11 = $i$f$visitSelfAndChildren6rFNWt0;
                        $this$visitChildren$iv$iv2 = stack$iv$iv2;
                        stack$iv$iv2 = $this$visitChildren$iv$iv2;
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = node$iv$iv3;
                        if ($this$visitSelfAndChildren_u2d6rFNWt0$iv3 != 0 && stack$iv$iv2 != 0) {
                        }
                        if (stack$iv$iv2 != 0) {
                        } else {
                        }
                        $this$visitChildren$iv$iv = node2;
                        stack$iv$iv2.add(node2);
                        if (stack$iv$iv2 != 0) {
                        }
                        node$iv$iv3 = $this$visitChildren$iv$iv2;
                        stack$iv$iv2.add($this$visitSelfAndChildren_u2d6rFNWt0$iv3);
                        i = 0;
                        mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                        int mask$iv$iv5 = 16;
                        i3 = 0;
                        i8 = i4;
                        i11 = $i$f$visitSelfAndChildren6rFNWt0;
                        i9 = mask$iv$iv5;
                        $this$visitChildren$iv$iv2 = new MutableVector(new Modifier.Node[mask$iv$iv5], 0);
                        node$iv$iv3 = node2;
                        mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                        i8 = i4;
                        i11 = $i$f$visitSelfAndChildren6rFNWt0;
                        $this$visitChildren$iv$iv = node2;
                        this_$iv$iv$iv = 1;
                    }
                    if (count$iv$iv2 == 1) {
                    } else {
                    }
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv;
                    i4 = i8;
                    $i$f$visitSelfAndChildren6rFNWt0 = i11;
                    i = 0;
                    node2 = node$iv$iv$iv2;
                    i2 = 0;
                    i25 = 0;
                    if (kindSet$ui_release5 &= i23 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = i;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i8 = i4;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv = node2;
                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv;
                    i4 = i8;
                    $i$f$visitSelfAndChildren6rFNWt0 = i11;
                    i = 0;
                    if (count$iv$iv2++ == 1) {
                    } else {
                    }
                    if (stack$iv$iv2 == 0) {
                    } else {
                    }
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i8 = i4;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv2 = stack$iv$iv2;
                    stack$iv$iv2 = $this$visitChildren$iv$iv2;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = node$iv$iv3;
                    if ($this$visitSelfAndChildren_u2d6rFNWt0$iv3 != 0 && stack$iv$iv2 != 0) {
                    }
                    if (stack$iv$iv2 != 0) {
                    } else {
                    }
                    $this$visitChildren$iv$iv = node2;
                    stack$iv$iv2.add(node2);
                    if (stack$iv$iv2 != 0) {
                    }
                    node$iv$iv3 = $this$visitChildren$iv$iv2;
                    stack$iv$iv2.add($this$visitSelfAndChildren_u2d6rFNWt0$iv3);
                    i = 0;
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    mask$iv$iv5 = 16;
                    i3 = 0;
                    i8 = i4;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    i9 = mask$iv$iv5;
                    $this$visitChildren$iv$iv2 = new MutableVector(new Modifier.Node[mask$iv$iv5], 0);
                    node$iv$iv3 = node2;
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i8 = i4;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv = node2;
                    this_$iv$iv$iv = 1;
                    count$iv$iv2 = 1;
                    i7 = 0;
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i8 = i4;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv2 = 1;
                }
                i8 = i4;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                int mask$iv$iv4 = 1;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv;
                i = 0;
                i7 = 0;
                if (kindSet$ui_release4 &= i23 != 0) {
                } else {
                }
                count$iv$iv2 = i;
                if (count$iv$iv2 != 0 && node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                i8 = i4;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv2 = 1;
                node$iv$iv3 = DelegatableNodeKt.access$pop(stack$iv$iv2);
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv;
                i4 = i8;
                $i$f$visitSelfAndChildren6rFNWt0 = i11;
                i = 0;
                if (node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv2 = 0;
                freeFocus2 = 0;
                node$iv$iv$iv2 = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                while (node$iv$iv$iv2 != null) {
                    node2 = node$iv$iv$iv2;
                    i2 = 0;
                    i25 = 0;
                    if (kindSet$ui_release5 &= i23 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = i;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i8 = i4;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv = node2;
                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv;
                    i4 = i8;
                    $i$f$visitSelfAndChildren6rFNWt0 = i11;
                    i = 0;
                    if (count$iv$iv2++ == 1) {
                    } else {
                    }
                    if (stack$iv$iv2 == 0) {
                    } else {
                    }
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i8 = i4;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv2 = stack$iv$iv2;
                    stack$iv$iv2 = $this$visitChildren$iv$iv2;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = node$iv$iv3;
                    if ($this$visitSelfAndChildren_u2d6rFNWt0$iv3 != 0 && stack$iv$iv2 != 0) {
                    }
                    if (stack$iv$iv2 != 0) {
                    } else {
                    }
                    $this$visitChildren$iv$iv = node2;
                    stack$iv$iv2.add(node2);
                    if (stack$iv$iv2 != 0) {
                    }
                    node$iv$iv3 = $this$visitChildren$iv$iv2;
                    stack$iv$iv2.add($this$visitSelfAndChildren_u2d6rFNWt0$iv3);
                    i = 0;
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    mask$iv$iv5 = 16;
                    i3 = 0;
                    i8 = i4;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    i9 = mask$iv$iv5;
                    $this$visitChildren$iv$iv2 = new MutableVector(new Modifier.Node[mask$iv$iv5], 0);
                    node$iv$iv3 = node2;
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i8 = i4;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv = node2;
                    this_$iv$iv$iv = 1;
                }
                if (count$iv$iv2 == 1) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv;
                i4 = i8;
                $i$f$visitSelfAndChildren6rFNWt0 = i11;
                i = 0;
                node2 = node$iv$iv$iv2;
                i2 = 0;
                i25 = 0;
                if (kindSet$ui_release5 &= i23 != 0) {
                } else {
                }
                this_$iv$iv$iv = i;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                i8 = i4;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                $this$visitChildren$iv$iv = node2;
                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv;
                i4 = i8;
                $i$f$visitSelfAndChildren6rFNWt0 = i11;
                i = 0;
                if (count$iv$iv2++ == 1) {
                } else {
                }
                if (stack$iv$iv2 == 0) {
                } else {
                }
                mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                i8 = i4;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                $this$visitChildren$iv$iv2 = stack$iv$iv2;
                stack$iv$iv2 = $this$visitChildren$iv$iv2;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = node$iv$iv3;
                if ($this$visitSelfAndChildren_u2d6rFNWt0$iv3 != 0 && stack$iv$iv2 != 0) {
                }
                if (stack$iv$iv2 != 0) {
                } else {
                }
                $this$visitChildren$iv$iv = node2;
                stack$iv$iv2.add(node2);
                if (stack$iv$iv2 != 0) {
                }
                node$iv$iv3 = $this$visitChildren$iv$iv2;
                stack$iv$iv2.add($this$visitSelfAndChildren_u2d6rFNWt0$iv3);
                i = 0;
                mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                mask$iv$iv5 = 16;
                i3 = 0;
                i8 = i4;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                i9 = mask$iv$iv5;
                $this$visitChildren$iv$iv2 = new MutableVector(new Modifier.Node[mask$iv$iv5], 0);
                node$iv$iv3 = node2;
                mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                i8 = i4;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                $this$visitChildren$iv$iv = node2;
                this_$iv$iv$iv = 1;
                count$iv$iv2 = 1;
                i7 = 0;
                mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                i8 = i4;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv2 = 1;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node);
            }
            return 0;
        }
        int i26 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
        int i27 = i4;
        int mask$iv$iv7 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv;
    }

    public static final PinnableContainer.PinnedHandle pinFocusedChild(androidx.compose.ui.focus.FocusRequesterModifierNode $this$pinFocusedChild) {
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int mask$iv$iv3;
        int mask$iv$iv;
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
        int $i$f$getFocusTargetOLwlOKw;
        int i9;
        int $this$visitChildren$iv$iv;
        int $i$f$visitSelfAndChildren6rFNWt0;
        Modifier.Node $i$f$visitSelfAndChildren6rFNWt02;
        int stack$iv$iv;
        int node2;
        Modifier.Node node$iv$iv3;
        int node$iv$iv2;
        int i10;
        int i11;
        int i12;
        int count$iv$iv;
        Modifier.Node[] arr;
        Modifier.Node node;
        int i13;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node stack$iv$iv2;
        int node$iv$iv;
        int count$iv$iv2;
        int i8;
        int i6;
        Modifier.Node $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
        int i3;
        int pinFocusedChild;
        Modifier.Node node$iv$iv$iv2;
        Modifier.Node node3;
        int i4;
        int this_$iv$iv$iv;
        int mask$iv$iv2;
        int i;
        int i5;
        int i2;
        int i7;
        int i15 = 0;
        $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
        $i$f$visitSelfAndChildren6rFNWt0 = 0;
        int i18 = 0;
        stack$iv$iv = 0;
        int i20 = 0;
        node$iv$iv3 = node4;
        i10 = 0;
        while (node$iv$iv3 != null) {
            node = 0;
            if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
            } else {
            }
            count$iv$iv = i10;
            if (count$iv$iv != 0 && node$iv$iv3 instanceof DelegatingNode) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i3 = $i$f$getFocusTargetOLwlOKw;
            node$iv$iv3 = DelegatableNodeKt.access$pop(stack$iv$iv);
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
            $i$f$getFocusTargetOLwlOKw = i3;
            i10 = 0;
            if (node$iv$iv3 instanceof DelegatingNode) {
            } else {
            }
            count$iv$iv = 0;
            i13 = 0;
            node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
            while (node$iv$iv$iv != null) {
                stack$iv$iv2 = node$iv$iv$iv;
                node$iv$iv = 0;
                i8 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                count$iv$iv2 = i10;
                if (count$iv$iv2 != 0) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i3 = $i$f$getFocusTargetOLwlOKw;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                $i$f$getFocusTargetOLwlOKw = i3;
                i12 = 1;
                if (count$iv$iv++ == i12) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i3 = $i$f$getFocusTargetOLwlOKw;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = stack$iv$iv;
                stack$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = node$iv$iv3;
                if ($this$visitSelfAndChildren_u2d6rFNWt0$iv2 != null && stack$iv$iv != 0) {
                }
                if (stack$iv$iv != 0) {
                }
                stack$iv$iv.add(stack$iv$iv2);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv3 = $i$f$getFocusTargetOLwlOKw;
                stack$iv$iv.add($this$visitSelfAndChildren_u2d6rFNWt0$iv2);
                count$iv$iv2 = 0;
                i6 = 0;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i3 = $i$f$getFocusTargetOLwlOKw;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = new MutableVector(new Modifier.Node[16], i10);
                node$iv$iv3 = stack$iv$iv2;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i3 = $i$f$getFocusTargetOLwlOKw;
                count$iv$iv2 = i12;
            }
            if (count$iv$iv == 1) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
            $i$f$getFocusTargetOLwlOKw = i3;
            stack$iv$iv2 = node$iv$iv$iv;
            node$iv$iv = 0;
            i8 = 0;
            if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
            } else {
            }
            count$iv$iv2 = i10;
            if (count$iv$iv2 != 0) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i3 = $i$f$getFocusTargetOLwlOKw;
            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
            $i$f$getFocusTargetOLwlOKw = i3;
            i12 = 1;
            if (count$iv$iv++ == i12) {
            } else {
            }
            if (stack$iv$iv == 0) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i3 = $i$f$getFocusTargetOLwlOKw;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = stack$iv$iv;
            stack$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = node$iv$iv3;
            if ($this$visitSelfAndChildren_u2d6rFNWt0$iv2 != null && stack$iv$iv != 0) {
            }
            if (stack$iv$iv != 0) {
            }
            stack$iv$iv.add(stack$iv$iv2);
            if (stack$iv$iv != 0) {
            }
            node$iv$iv3 = $i$f$getFocusTargetOLwlOKw;
            stack$iv$iv.add($this$visitSelfAndChildren_u2d6rFNWt0$iv2);
            count$iv$iv2 = 0;
            i6 = 0;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i3 = $i$f$getFocusTargetOLwlOKw;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = new MutableVector(new Modifier.Node[16], i10);
            node$iv$iv3 = stack$iv$iv2;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i3 = $i$f$getFocusTargetOLwlOKw;
            count$iv$iv2 = i12;
            count$iv$iv = i12;
            i12 = 0;
            count$iv$iv = FocusRestorerKt.pinFocusedChild((FocusTargetNode)node$iv$iv3);
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i3 = $i$f$getFocusTargetOLwlOKw;
        }
        int i29 = $i$f$getFocusTargetOLwlOKw;
        i9 = $this$visitSelfAndChildren_u2d6rFNWt0$iv5;
        int i17 = 0;
        if (!i9.getNode().isAttached()) {
        } else {
            int i19 = 0;
            node$iv$iv2 = 0;
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], i10);
            Modifier.Node child$ui_release = i9.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, i9.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                int i21 = 0;
                i8 = 1;
                node2 = mutableVector2.removeAt(size--);
                if (aggregateChildKindSet$ui_release &= $this$visitSelfAndChildren_u2d6rFNWt0$iv == 0) {
                } else {
                }
                node$iv$iv2 = node2;
                while (node$iv$iv2 != 0) {
                    i5 = i9;
                    i2 = $i$f$visitSelfAndChildren6rFNWt0;
                    int i25 = 1;
                    node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                    i10 = mask$iv$iv7;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv2;
                }
                i5 = i9;
                i2 = $i$f$visitSelfAndChildren6rFNWt0;
                int i22 = 1;
                i10 = mask$iv$iv4;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv2;
                if (kindSet$ui_release &= $this$visitSelfAndChildren_u2d6rFNWt0$iv != null) {
                } else {
                }
                i5 = i9;
                i2 = $i$f$visitSelfAndChildren6rFNWt0;
                i25 = 1;
                node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                i10 = mask$iv$iv7;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv2;
                node = null;
                node$iv$iv$iv = null;
                stack$iv$iv2 = 0;
                int i27 = 0;
                node$iv$iv = i13;
                while (node$iv$iv != 0) {
                    i6 = 0;
                    if (kindSet$ui_release4 &= i29 != 0) {
                    } else {
                    }
                    count$iv$iv2 = i10;
                    if (count$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    i5 = i9;
                    i2 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv = i10;
                    i11 = 1;
                    node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv2);
                    i10 = mask$iv$iv;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv2;
                    i9 = i5;
                    $i$f$visitSelfAndChildren6rFNWt0 = i2;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    pinFocusedChild = 0;
                    node$iv$iv$iv2 = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv2 != null) {
                        node3 = node$iv$iv$iv2;
                        i4 = 0;
                        int i30 = 0;
                        if (kindSet$ui_release5 &= i29 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = i10;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                        i5 = i9;
                        i2 = $i$f$visitSelfAndChildren6rFNWt0;
                        mask$iv$iv3 = i10;
                        $i$f$visitSelfAndChildren6rFNWt02 = node3;
                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                        i10 = mask$iv$iv3;
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv2;
                        i9 = i5;
                        $i$f$visitSelfAndChildren6rFNWt0 = i2;
                        if (count$iv$iv2++ == 1) {
                        } else {
                        }
                        if (stack$iv$iv2 == 0) {
                        } else {
                        }
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                        i5 = i9;
                        i2 = $i$f$visitSelfAndChildren6rFNWt0;
                        mask$iv$iv3 = 0;
                        $this$visitChildren$iv$iv = stack$iv$iv2;
                        stack$iv$iv2 = $this$visitChildren$iv$iv;
                        i9 = node$iv$iv;
                        if (i9 != 0 && stack$iv$iv2 != 0) {
                        }
                        if (stack$iv$iv2 != 0) {
                        } else {
                        }
                        $i$f$visitSelfAndChildren6rFNWt02 = node3;
                        stack$iv$iv2.add(node3);
                        if (stack$iv$iv2 != 0) {
                        }
                        node$iv$iv = $i$f$visitSelfAndChildren6rFNWt0;
                        stack$iv$iv2.add(i9);
                        i10 = 0;
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                        int mask$iv$iv6 = 16;
                        i = 0;
                        i5 = i9;
                        i2 = $i$f$visitSelfAndChildren6rFNWt0;
                        i7 = mask$iv$iv6;
                        $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv6], 0);
                        node$iv$iv = node3;
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                        i5 = i9;
                        i2 = $i$f$visitSelfAndChildren6rFNWt0;
                        $i$f$visitSelfAndChildren6rFNWt02 = node3;
                        mask$iv$iv3 = 0;
                        this_$iv$iv$iv = 1;
                    }
                    if (count$iv$iv2 == 1) {
                    } else {
                    }
                    i10 = mask$iv$iv;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv2;
                    i9 = i5;
                    $i$f$visitSelfAndChildren6rFNWt0 = i2;
                    node3 = node$iv$iv$iv2;
                    i4 = 0;
                    i30 = 0;
                    if (kindSet$ui_release5 &= i29 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = i10;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    i5 = i9;
                    i2 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv3 = i10;
                    $i$f$visitSelfAndChildren6rFNWt02 = node3;
                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                    i10 = mask$iv$iv3;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv2;
                    i9 = i5;
                    $i$f$visitSelfAndChildren6rFNWt0 = i2;
                    if (count$iv$iv2++ == 1) {
                    } else {
                    }
                    if (stack$iv$iv2 == 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    i5 = i9;
                    i2 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv3 = 0;
                    $this$visitChildren$iv$iv = stack$iv$iv2;
                    stack$iv$iv2 = $this$visitChildren$iv$iv;
                    i9 = node$iv$iv;
                    if (i9 != 0 && stack$iv$iv2 != 0) {
                    }
                    if (stack$iv$iv2 != 0) {
                    } else {
                    }
                    $i$f$visitSelfAndChildren6rFNWt02 = node3;
                    stack$iv$iv2.add(node3);
                    if (stack$iv$iv2 != 0) {
                    }
                    node$iv$iv = $i$f$visitSelfAndChildren6rFNWt0;
                    stack$iv$iv2.add(i9);
                    i10 = 0;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    mask$iv$iv6 = 16;
                    i = 0;
                    i5 = i9;
                    i2 = $i$f$visitSelfAndChildren6rFNWt0;
                    i7 = mask$iv$iv6;
                    $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv6], 0);
                    node$iv$iv = node3;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    i5 = i9;
                    i2 = $i$f$visitSelfAndChildren6rFNWt0;
                    $i$f$visitSelfAndChildren6rFNWt02 = node3;
                    mask$iv$iv3 = 0;
                    this_$iv$iv$iv = 1;
                    count$iv$iv2 = 1;
                    i6 = 0;
                    pinFocusedChild = FocusRestorerKt.pinFocusedChild((FocusTargetNode)node$iv$iv);
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    i5 = i9;
                    i2 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv = i10;
                    i11 = 1;
                }
                i5 = i9;
                i2 = $i$f$visitSelfAndChildren6rFNWt0;
                int i23 = 1;
                i10 = mask$iv$iv5;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv2;
                i6 = 0;
                if (kindSet$ui_release4 &= i29 != 0) {
                } else {
                }
                count$iv$iv2 = i10;
                if (count$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i5 = i9;
                i2 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv = i10;
                i11 = 1;
                node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv2);
                i10 = mask$iv$iv;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv2;
                i9 = i5;
                $i$f$visitSelfAndChildren6rFNWt0 = i2;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv2 = 0;
                pinFocusedChild = 0;
                node$iv$iv$iv2 = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv2 != null) {
                    node3 = node$iv$iv$iv2;
                    i4 = 0;
                    i30 = 0;
                    if (kindSet$ui_release5 &= i29 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = i10;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    i5 = i9;
                    i2 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv3 = i10;
                    $i$f$visitSelfAndChildren6rFNWt02 = node3;
                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                    i10 = mask$iv$iv3;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv2;
                    i9 = i5;
                    $i$f$visitSelfAndChildren6rFNWt0 = i2;
                    if (count$iv$iv2++ == 1) {
                    } else {
                    }
                    if (stack$iv$iv2 == 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    i5 = i9;
                    i2 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv3 = 0;
                    $this$visitChildren$iv$iv = stack$iv$iv2;
                    stack$iv$iv2 = $this$visitChildren$iv$iv;
                    i9 = node$iv$iv;
                    if (i9 != 0 && stack$iv$iv2 != 0) {
                    }
                    if (stack$iv$iv2 != 0) {
                    } else {
                    }
                    $i$f$visitSelfAndChildren6rFNWt02 = node3;
                    stack$iv$iv2.add(node3);
                    if (stack$iv$iv2 != 0) {
                    }
                    node$iv$iv = $i$f$visitSelfAndChildren6rFNWt0;
                    stack$iv$iv2.add(i9);
                    i10 = 0;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    mask$iv$iv6 = 16;
                    i = 0;
                    i5 = i9;
                    i2 = $i$f$visitSelfAndChildren6rFNWt0;
                    i7 = mask$iv$iv6;
                    $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv6], 0);
                    node$iv$iv = node3;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    i5 = i9;
                    i2 = $i$f$visitSelfAndChildren6rFNWt0;
                    $i$f$visitSelfAndChildren6rFNWt02 = node3;
                    mask$iv$iv3 = 0;
                    this_$iv$iv$iv = 1;
                }
                if (count$iv$iv2 == 1) {
                } else {
                }
                i10 = mask$iv$iv;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv2;
                i9 = i5;
                $i$f$visitSelfAndChildren6rFNWt0 = i2;
                node3 = node$iv$iv$iv2;
                i4 = 0;
                i30 = 0;
                if (kindSet$ui_release5 &= i29 != 0) {
                } else {
                }
                this_$iv$iv$iv = i10;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i5 = i9;
                i2 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv3 = i10;
                $i$f$visitSelfAndChildren6rFNWt02 = node3;
                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                i10 = mask$iv$iv3;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv2;
                i9 = i5;
                $i$f$visitSelfAndChildren6rFNWt0 = i2;
                if (count$iv$iv2++ == 1) {
                } else {
                }
                if (stack$iv$iv2 == 0) {
                } else {
                }
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i5 = i9;
                i2 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv3 = 0;
                $this$visitChildren$iv$iv = stack$iv$iv2;
                stack$iv$iv2 = $this$visitChildren$iv$iv;
                i9 = node$iv$iv;
                if (i9 != 0 && stack$iv$iv2 != 0) {
                }
                if (stack$iv$iv2 != 0) {
                } else {
                }
                $i$f$visitSelfAndChildren6rFNWt02 = node3;
                stack$iv$iv2.add(node3);
                if (stack$iv$iv2 != 0) {
                }
                node$iv$iv = $i$f$visitSelfAndChildren6rFNWt0;
                stack$iv$iv2.add(i9);
                i10 = 0;
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                mask$iv$iv6 = 16;
                i = 0;
                i5 = i9;
                i2 = $i$f$visitSelfAndChildren6rFNWt0;
                i7 = mask$iv$iv6;
                $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv6], 0);
                node$iv$iv = node3;
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i5 = i9;
                i2 = $i$f$visitSelfAndChildren6rFNWt0;
                $i$f$visitSelfAndChildren6rFNWt02 = node3;
                mask$iv$iv3 = 0;
                this_$iv$iv$iv = 1;
                count$iv$iv2 = 1;
                i6 = 0;
                pinFocusedChild = FocusRestorerKt.pinFocusedChild((FocusTargetNode)node$iv$iv);
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i5 = i9;
                i2 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv = i10;
                i11 = 1;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node2);
            }
            int mask$iv$iv9 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            return null;
        }
        int i31 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int i32 = i9;
        int mask$iv$iv8 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv;
    }

    public static final boolean requestFocus(androidx.compose.ui.focus.FocusRequesterModifierNode $this$requestFocus) {
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
        int count$iv$iv;
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int $i$f$getFocusTargetOLwlOKw;
        int $this$visitChildren$iv$iv;
        Modifier.Node[] i10;
        Modifier.Node this_$iv$iv$iv5;
        int this_$iv$iv$iv2;
        int $i$f$visitSelfAndChildren6rFNWt0;
        int stack$iv$iv;
        Modifier.Node node;
        Modifier.Node node$iv$iv3;
        int node$iv$iv2;
        int i7;
        int i6;
        int i3;
        int count$iv$iv2;
        Modifier.Node[] arr;
        boolean requestFocus;
        Object iNSTANCE;
        int i2;
        Modifier.Node node$iv$iv$iv2;
        Modifier.Node stack$iv$iv2;
        int node$iv$iv;
        int this_$iv$iv$iv;
        int i12;
        boolean requestFocus2;
        int mask$iv$iv;
        int i4;
        Modifier.Node $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
        int i11;
        int i9;
        int i5;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i8;
        int this_$iv$iv$iv4;
        int count$iv$iv3;
        int i13;
        Modifier.Node[] this_$iv$iv$iv3;
        int $i$f$visitSelfAndChildren6rFNWt02;
        int i;
        int i14 = 0;
        $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
        $i$f$visitSelfAndChildren6rFNWt0 = 0;
        int i17 = 0;
        stack$iv$iv = 0;
        int i19 = 0;
        node$iv$iv3 = node3;
        i7 = 0;
        while (node$iv$iv3 != null) {
            iNSTANCE = 0;
            if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
            } else {
            }
            count$iv$iv2 = i7;
            if (count$iv$iv2 != 0 && node$iv$iv3 instanceof DelegatingNode) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
            i11 = $i$f$getFocusTargetOLwlOKw;
            node$iv$iv3 = DelegatableNodeKt.access$pop(stack$iv$iv);
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
            $i$f$getFocusTargetOLwlOKw = i11;
            i7 = 0;
            if (node$iv$iv3 instanceof DelegatingNode) {
            } else {
            }
            count$iv$iv2 = 0;
            i2 = 0;
            node$iv$iv$iv2 = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
            while (node$iv$iv$iv2 != null) {
                stack$iv$iv2 = node$iv$iv$iv2;
                node$iv$iv = 0;
                i12 = 0;
                if (kindSet$ui_release4 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv = i7;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                i11 = $i$f$getFocusTargetOLwlOKw;
                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                $i$f$getFocusTargetOLwlOKw = i11;
                i3 = 1;
                if (count$iv$iv2++ == i3) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                i11 = $i$f$getFocusTargetOLwlOKw;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = stack$iv$iv;
                stack$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = node$iv$iv3;
                if ($this$visitSelfAndChildren_u2d6rFNWt0$iv4 != null && stack$iv$iv != 0) {
                }
                if (stack$iv$iv != 0) {
                }
                stack$iv$iv.add(stack$iv$iv2);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv3 = $i$f$getFocusTargetOLwlOKw;
                stack$iv$iv.add($this$visitSelfAndChildren_u2d6rFNWt0$iv4);
                this_$iv$iv$iv = 0;
                mask$iv$iv = 0;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                i11 = $i$f$getFocusTargetOLwlOKw;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = new MutableVector(new Modifier.Node[16], i7);
                node$iv$iv3 = stack$iv$iv2;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                i11 = $i$f$getFocusTargetOLwlOKw;
                this_$iv$iv$iv = i3;
            }
            if (count$iv$iv2 == 1) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
            $i$f$getFocusTargetOLwlOKw = i11;
            stack$iv$iv2 = node$iv$iv$iv2;
            node$iv$iv = 0;
            i12 = 0;
            if (kindSet$ui_release4 &= $i$f$getFocusTargetOLwlOKw != 0) {
            } else {
            }
            this_$iv$iv$iv = i7;
            if (this_$iv$iv$iv != 0) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
            i11 = $i$f$getFocusTargetOLwlOKw;
            node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
            $i$f$getFocusTargetOLwlOKw = i11;
            i3 = 1;
            if (count$iv$iv2++ == i3) {
            } else {
            }
            if (stack$iv$iv == 0) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
            i11 = $i$f$getFocusTargetOLwlOKw;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = stack$iv$iv;
            stack$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = node$iv$iv3;
            if ($this$visitSelfAndChildren_u2d6rFNWt0$iv4 != null && stack$iv$iv != 0) {
            }
            if (stack$iv$iv != 0) {
            }
            stack$iv$iv.add(stack$iv$iv2);
            if (stack$iv$iv != 0) {
            }
            node$iv$iv3 = $i$f$getFocusTargetOLwlOKw;
            stack$iv$iv.add($this$visitSelfAndChildren_u2d6rFNWt0$iv4);
            this_$iv$iv$iv = 0;
            mask$iv$iv = 0;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
            i11 = $i$f$getFocusTargetOLwlOKw;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = new MutableVector(new Modifier.Node[16], i7);
            node$iv$iv3 = stack$iv$iv2;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
            i11 = $i$f$getFocusTargetOLwlOKw;
            this_$iv$iv$iv = i3;
            count$iv$iv2 = i3;
        }
        int i28 = $i$f$getFocusTargetOLwlOKw;
        $this$visitChildren$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv5;
        int i16 = 0;
        if (!$this$visitChildren$iv$iv.getNode().isAttached()) {
        } else {
            int i18 = 0;
            node$iv$iv2 = 0;
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], i7);
            Modifier.Node child$ui_release = $this$visitChildren$iv$iv.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, $this$visitChildren$iv$iv.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                int i20 = 0;
                i12 = 1;
                node = mutableVector2.removeAt(size--);
                if (aggregateChildKindSet$ui_release &= $this$visitSelfAndChildren_u2d6rFNWt0$iv2 == 0) {
                } else {
                }
                node$iv$iv2 = node;
                while (node$iv$iv2 != 0) {
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                    i9 = $this$visitChildren$iv$iv;
                    $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                    int i21 = 1;
                    node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                    i7 = 0;
                }
                mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i9 = $this$visitChildren$iv$iv;
                $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                int i23 = 1;
                i7 = 0;
                if (kindSet$ui_release &= $this$visitSelfAndChildren_u2d6rFNWt0$iv2 != null) {
                } else {
                }
                mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i9 = $this$visitChildren$iv$iv;
                $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                i21 = 1;
                node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                i7 = 0;
                iNSTANCE = null;
                node$iv$iv$iv2 = null;
                stack$iv$iv2 = 0;
                int i25 = 0;
                node$iv$iv = i2;
                while (node$iv$iv != null) {
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                    i9 = $this$visitChildren$iv$iv;
                    i10 = 0;
                    if (kindSet$ui_release3 &= i28 != 0) {
                    } else {
                    }
                    count$iv$iv = i7;
                    if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                    i6 = 1;
                    node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv2);
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = mask$iv$iv;
                    $this$visitChildren$iv$iv = i9;
                    $i$f$visitSelfAndChildren6rFNWt0 = $i$f$visitSelfAndChildren6rFNWt02;
                    i7 = 0;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    this_$iv$iv$iv = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i8 = 0;
                        count$iv$iv3 = 0;
                        if (kindSet$ui_release5 &= i28 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv4 = i7;
                        if (this_$iv$iv$iv4 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv3 = i10;
                        $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                        this_$iv$iv$iv5 = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        i10 = this_$iv$iv$iv3;
                        $i$f$visitSelfAndChildren6rFNWt0 = $i$f$visitSelfAndChildren6rFNWt02;
                        i7 = 0;
                        count$iv$iv++;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv2 == 0) {
                        } else {
                        }
                        count$iv$iv3 = count$iv$iv;
                        this_$iv$iv$iv3 = i10;
                        $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                        this_$iv$iv$iv2 = stack$iv$iv2;
                        stack$iv$iv2 = this_$iv$iv$iv2;
                        Modifier.Node[] objArr = node$iv$iv;
                        if (objArr != null && stack$iv$iv2 != 0) {
                        }
                        if (stack$iv$iv2 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv5 = node2;
                        count$iv$iv = count$iv$iv3;
                        stack$iv$iv2.add(node2);
                        if (stack$iv$iv2 != 0) {
                        }
                        node$iv$iv = this_$iv$iv$iv2;
                        stack$iv$iv2.add(objArr);
                        i7 = 0;
                        count$iv$iv3 = count$iv$iv;
                        int count$iv$iv4 = 16;
                        i13 = 0;
                        this_$iv$iv$iv3 = i10;
                        $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                        i = count$iv$iv4;
                        this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[count$iv$iv4], 0);
                        node$iv$iv = node2;
                        this_$iv$iv$iv3 = i10;
                        $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                        this_$iv$iv$iv5 = node2;
                        this_$iv$iv$iv4 = 1;
                    }
                    this_$iv$iv$iv3 = i10;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = mask$iv$iv;
                    $this$visitChildren$iv$iv = i9;
                    $i$f$visitSelfAndChildren6rFNWt0 = $i$f$visitSelfAndChildren6rFNWt02;
                    i7 = 0;
                    node2 = node$iv$iv$iv;
                    i8 = 0;
                    count$iv$iv3 = 0;
                    if (kindSet$ui_release5 &= i28 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv4 = i7;
                    if (this_$iv$iv$iv4 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv3 = i10;
                    $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                    this_$iv$iv$iv5 = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    i10 = this_$iv$iv$iv3;
                    $i$f$visitSelfAndChildren6rFNWt0 = $i$f$visitSelfAndChildren6rFNWt02;
                    i7 = 0;
                    count$iv$iv++;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv2 == 0) {
                    } else {
                    }
                    count$iv$iv3 = count$iv$iv;
                    this_$iv$iv$iv3 = i10;
                    $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                    this_$iv$iv$iv2 = stack$iv$iv2;
                    stack$iv$iv2 = this_$iv$iv$iv2;
                    objArr = node$iv$iv;
                    if (objArr != null && stack$iv$iv2 != 0) {
                    }
                    if (stack$iv$iv2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv5 = node2;
                    count$iv$iv = count$iv$iv3;
                    stack$iv$iv2.add(node2);
                    if (stack$iv$iv2 != 0) {
                    }
                    node$iv$iv = this_$iv$iv$iv2;
                    stack$iv$iv2.add(objArr);
                    i7 = 0;
                    count$iv$iv3 = count$iv$iv;
                    count$iv$iv4 = 16;
                    i13 = 0;
                    this_$iv$iv$iv3 = i10;
                    $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                    i = count$iv$iv4;
                    this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[count$iv$iv4], 0);
                    node$iv$iv = node2;
                    this_$iv$iv$iv3 = i10;
                    $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                    this_$iv$iv$iv5 = node2;
                    this_$iv$iv$iv4 = 1;
                    count$iv$iv = 1;
                }
                mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i9 = $this$visitChildren$iv$iv;
                $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                int i22 = 1;
                i7 = 0;
                mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i9 = $this$visitChildren$iv$iv;
                i10 = 0;
                if (kindSet$ui_release3 &= i28 != 0) {
                } else {
                }
                count$iv$iv = i7;
                if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                i6 = 1;
                node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv2);
                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = mask$iv$iv;
                $this$visitChildren$iv$iv = i9;
                $i$f$visitSelfAndChildren6rFNWt0 = $i$f$visitSelfAndChildren6rFNWt02;
                i7 = 0;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                this_$iv$iv$iv = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node2 = node$iv$iv$iv;
                    i8 = 0;
                    count$iv$iv3 = 0;
                    if (kindSet$ui_release5 &= i28 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv4 = i7;
                    if (this_$iv$iv$iv4 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv3 = i10;
                    $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                    this_$iv$iv$iv5 = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    i10 = this_$iv$iv$iv3;
                    $i$f$visitSelfAndChildren6rFNWt0 = $i$f$visitSelfAndChildren6rFNWt02;
                    i7 = 0;
                    count$iv$iv++;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv2 == 0) {
                    } else {
                    }
                    count$iv$iv3 = count$iv$iv;
                    this_$iv$iv$iv3 = i10;
                    $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                    this_$iv$iv$iv2 = stack$iv$iv2;
                    stack$iv$iv2 = this_$iv$iv$iv2;
                    objArr = node$iv$iv;
                    if (objArr != null && stack$iv$iv2 != 0) {
                    }
                    if (stack$iv$iv2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv5 = node2;
                    count$iv$iv = count$iv$iv3;
                    stack$iv$iv2.add(node2);
                    if (stack$iv$iv2 != 0) {
                    }
                    node$iv$iv = this_$iv$iv$iv2;
                    stack$iv$iv2.add(objArr);
                    i7 = 0;
                    count$iv$iv3 = count$iv$iv;
                    count$iv$iv4 = 16;
                    i13 = 0;
                    this_$iv$iv$iv3 = i10;
                    $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                    i = count$iv$iv4;
                    this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[count$iv$iv4], 0);
                    node$iv$iv = node2;
                    this_$iv$iv$iv3 = i10;
                    $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                    this_$iv$iv$iv5 = node2;
                    this_$iv$iv$iv4 = 1;
                }
                this_$iv$iv$iv3 = i10;
                if (count$iv$iv == 1) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = mask$iv$iv;
                $this$visitChildren$iv$iv = i9;
                $i$f$visitSelfAndChildren6rFNWt0 = $i$f$visitSelfAndChildren6rFNWt02;
                i7 = 0;
                node2 = node$iv$iv$iv;
                i8 = 0;
                count$iv$iv3 = 0;
                if (kindSet$ui_release5 &= i28 != 0) {
                } else {
                }
                this_$iv$iv$iv4 = i7;
                if (this_$iv$iv$iv4 != 0) {
                } else {
                }
                this_$iv$iv$iv3 = i10;
                $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                this_$iv$iv$iv5 = node2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                i10 = this_$iv$iv$iv3;
                $i$f$visitSelfAndChildren6rFNWt0 = $i$f$visitSelfAndChildren6rFNWt02;
                i7 = 0;
                count$iv$iv++;
                if (count$iv$iv == 1) {
                } else {
                }
                if (stack$iv$iv2 == 0) {
                } else {
                }
                count$iv$iv3 = count$iv$iv;
                this_$iv$iv$iv3 = i10;
                $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                this_$iv$iv$iv2 = stack$iv$iv2;
                stack$iv$iv2 = this_$iv$iv$iv2;
                objArr = node$iv$iv;
                if (objArr != null && stack$iv$iv2 != 0) {
                }
                if (stack$iv$iv2 != 0) {
                } else {
                }
                this_$iv$iv$iv5 = node2;
                count$iv$iv = count$iv$iv3;
                stack$iv$iv2.add(node2);
                if (stack$iv$iv2 != 0) {
                }
                node$iv$iv = this_$iv$iv$iv2;
                stack$iv$iv2.add(objArr);
                i7 = 0;
                count$iv$iv3 = count$iv$iv;
                count$iv$iv4 = 16;
                i13 = 0;
                this_$iv$iv$iv3 = i10;
                $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                i = count$iv$iv4;
                this_$iv$iv$iv2 = new MutableVector(new Modifier.Node[count$iv$iv4], 0);
                node$iv$iv = node2;
                this_$iv$iv$iv3 = i10;
                $i$f$visitSelfAndChildren6rFNWt02 = $i$f$visitSelfAndChildren6rFNWt0;
                this_$iv$iv$iv5 = node2;
                this_$iv$iv$iv4 = 1;
                count$iv$iv = 1;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node);
            }
            return 0;
        }
        int i27 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
        int i29 = $this$visitChildren$iv$iv;
        int mask$iv$iv3 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv;
    }

    public static final boolean restoreFocusedChild(androidx.compose.ui.focus.FocusRequesterModifierNode $this$restoreFocusedChild) {
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
        int mask$iv$iv;
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
        int $i$f$getFocusTargetOLwlOKw;
        int i9;
        Modifier.Node $this$visitChildren$iv$iv2;
        int $this$visitChildren$iv$iv;
        int $i$f$visitSelfAndChildren6rFNWt0;
        int stack$iv$iv;
        int node2;
        Modifier.Node node$iv$iv;
        int node$iv$iv3;
        int i4;
        int i6;
        int count$iv$iv2;
        Modifier.Node[] arr;
        Modifier.Node restoreFocusedChild;
        int i7;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node stack$iv$iv2;
        int node$iv$iv2;
        int count$iv$iv;
        int i8;
        int i11;
        Modifier.Node $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
        int i2;
        int restoreFocusedChild2;
        Modifier.Node node$iv$iv$iv2;
        Modifier.Node node;
        int i;
        int this_$iv$iv$iv;
        int mask$iv$iv2;
        int i3;
        int i12;
        int i5;
        int i10;
        int i13 = 0;
        $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
        $i$f$visitSelfAndChildren6rFNWt0 = 0;
        int i16 = 0;
        stack$iv$iv = 0;
        int i18 = 0;
        node$iv$iv = node3;
        i4 = 0;
        i6 = 1;
        while (node$iv$iv != null) {
            restoreFocusedChild = 0;
            if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
            } else {
            }
            count$iv$iv2 = i4;
            if (count$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            i2 = $i$f$getFocusTargetOLwlOKw;
            node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
            $i$f$getFocusTargetOLwlOKw = i2;
            i4 = 0;
            i6 = 1;
            if (node$iv$iv instanceof DelegatingNode) {
            } else {
            }
            count$iv$iv2 = 0;
            i7 = 0;
            node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
            while (node$iv$iv$iv != null) {
                stack$iv$iv2 = node$iv$iv$iv;
                node$iv$iv2 = 0;
                i8 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                count$iv$iv = i4;
                if (count$iv$iv != 0) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i2 = $i$f$getFocusTargetOLwlOKw;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                $i$f$getFocusTargetOLwlOKw = i2;
                i6 = 1;
                if (count$iv$iv2++ == i6) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i2 = $i$f$getFocusTargetOLwlOKw;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = stack$iv$iv;
                stack$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = node$iv$iv;
                if ($this$visitSelfAndChildren_u2d6rFNWt0$iv != null && stack$iv$iv != 0) {
                }
                if (stack$iv$iv != 0) {
                }
                stack$iv$iv.add(stack$iv$iv2);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv = $i$f$getFocusTargetOLwlOKw;
                stack$iv$iv.add($this$visitSelfAndChildren_u2d6rFNWt0$iv);
                count$iv$iv = 0;
                i11 = 0;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i2 = $i$f$getFocusTargetOLwlOKw;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = new MutableVector(new Modifier.Node[16], i4);
                node$iv$iv = stack$iv$iv2;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i2 = $i$f$getFocusTargetOLwlOKw;
                count$iv$iv = i6;
            }
            if (count$iv$iv2 == 1) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
            $i$f$getFocusTargetOLwlOKw = i2;
            stack$iv$iv2 = node$iv$iv$iv;
            node$iv$iv2 = 0;
            i8 = 0;
            if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
            } else {
            }
            count$iv$iv = i4;
            if (count$iv$iv != 0) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            i2 = $i$f$getFocusTargetOLwlOKw;
            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
            $i$f$getFocusTargetOLwlOKw = i2;
            i6 = 1;
            if (count$iv$iv2++ == i6) {
            } else {
            }
            if (stack$iv$iv == 0) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            i2 = $i$f$getFocusTargetOLwlOKw;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = stack$iv$iv;
            stack$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = node$iv$iv;
            if ($this$visitSelfAndChildren_u2d6rFNWt0$iv != null && stack$iv$iv != 0) {
            }
            if (stack$iv$iv != 0) {
            }
            stack$iv$iv.add(stack$iv$iv2);
            if (stack$iv$iv != 0) {
            }
            node$iv$iv = $i$f$getFocusTargetOLwlOKw;
            stack$iv$iv.add($this$visitSelfAndChildren_u2d6rFNWt0$iv);
            count$iv$iv = 0;
            i11 = 0;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            i2 = $i$f$getFocusTargetOLwlOKw;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = new MutableVector(new Modifier.Node[16], i4);
            node$iv$iv = stack$iv$iv2;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            i2 = $i$f$getFocusTargetOLwlOKw;
            count$iv$iv = i6;
            count$iv$iv2 = i6;
            count$iv$iv2 = 0;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            i2 = $i$f$getFocusTargetOLwlOKw;
        }
        int i23 = $i$f$getFocusTargetOLwlOKw;
        i9 = $this$visitSelfAndChildren_u2d6rFNWt0$iv5;
        int i15 = 0;
        if (!i9.getNode().isAttached()) {
        } else {
            int i17 = 0;
            node$iv$iv3 = 0;
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], i4);
            Modifier.Node child$ui_release = i9.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, i9.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                int i19 = 0;
                i8 = 1;
                node2 = mutableVector2.removeAt(size--);
                if (aggregateChildKindSet$ui_release &= $this$visitSelfAndChildren_u2d6rFNWt0$iv3 == 0) {
                } else {
                }
                node$iv$iv3 = node2;
                while (node$iv$iv3 != 0) {
                    i12 = i9;
                    i5 = $i$f$visitSelfAndChildren6rFNWt0;
                    int mask$iv$iv6 = 1;
                    node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                    i4 = 0;
                }
                i12 = i9;
                i5 = $i$f$visitSelfAndChildren6rFNWt0;
                int mask$iv$iv3 = 1;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                i4 = 0;
                if (kindSet$ui_release &= $this$visitSelfAndChildren_u2d6rFNWt0$iv3 != null) {
                } else {
                }
                i12 = i9;
                i5 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv6 = 1;
                node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                i4 = 0;
                restoreFocusedChild = 0;
                node$iv$iv$iv = null;
                stack$iv$iv2 = 0;
                int i20 = 0;
                node$iv$iv2 = i7;
                while (node$iv$iv2 != 0) {
                    i11 = 0;
                    if (kindSet$ui_release4 &= i23 != 0) {
                    } else {
                    }
                    count$iv$iv = i4;
                    if (count$iv$iv != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i12 = i9;
                    i5 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv = 1;
                    node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv2);
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                    i9 = i12;
                    $i$f$visitSelfAndChildren6rFNWt0 = i5;
                    i4 = 0;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    restoreFocusedChild2 = 0;
                    node$iv$iv$iv2 = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv2 != null) {
                        node = node$iv$iv$iv2;
                        i = 0;
                        int i25 = 0;
                        if (kindSet$ui_release5 &= i23 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = i4;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                        i12 = i9;
                        i5 = $i$f$visitSelfAndChildren6rFNWt0;
                        $this$visitChildren$iv$iv2 = node;
                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                        i9 = i12;
                        $i$f$visitSelfAndChildren6rFNWt0 = i5;
                        i4 = 0;
                        if (count$iv$iv++ == 1) {
                        } else {
                        }
                        if (stack$iv$iv2 == 0) {
                        } else {
                        }
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                        i12 = i9;
                        i5 = $i$f$visitSelfAndChildren6rFNWt0;
                        $this$visitChildren$iv$iv = stack$iv$iv2;
                        stack$iv$iv2 = $this$visitChildren$iv$iv;
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = node$iv$iv2;
                        if ($this$visitSelfAndChildren_u2d6rFNWt0$iv3 != 0 && stack$iv$iv2 != 0) {
                        }
                        if (stack$iv$iv2 != 0) {
                        } else {
                        }
                        $this$visitChildren$iv$iv2 = node;
                        stack$iv$iv2.add(node);
                        if (stack$iv$iv2 != 0) {
                        }
                        node$iv$iv2 = $this$visitChildren$iv$iv;
                        stack$iv$iv2.add($this$visitSelfAndChildren_u2d6rFNWt0$iv3);
                        i4 = 0;
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                        int mask$iv$iv5 = 16;
                        i3 = 0;
                        i12 = i9;
                        i5 = $i$f$visitSelfAndChildren6rFNWt0;
                        i10 = mask$iv$iv5;
                        $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv5], 0);
                        node$iv$iv2 = node;
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                        i12 = i9;
                        i5 = $i$f$visitSelfAndChildren6rFNWt0;
                        $this$visitChildren$iv$iv2 = node;
                        this_$iv$iv$iv = 1;
                    }
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                    i9 = i12;
                    $i$f$visitSelfAndChildren6rFNWt0 = i5;
                    i4 = 0;
                    node = node$iv$iv$iv2;
                    i = 0;
                    i25 = 0;
                    if (kindSet$ui_release5 &= i23 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = i4;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i12 = i9;
                    i5 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv2 = node;
                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                    i9 = i12;
                    $i$f$visitSelfAndChildren6rFNWt0 = i5;
                    i4 = 0;
                    if (count$iv$iv++ == 1) {
                    } else {
                    }
                    if (stack$iv$iv2 == 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i12 = i9;
                    i5 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv = stack$iv$iv2;
                    stack$iv$iv2 = $this$visitChildren$iv$iv;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = node$iv$iv2;
                    if ($this$visitSelfAndChildren_u2d6rFNWt0$iv3 != 0 && stack$iv$iv2 != 0) {
                    }
                    if (stack$iv$iv2 != 0) {
                    } else {
                    }
                    $this$visitChildren$iv$iv2 = node;
                    stack$iv$iv2.add(node);
                    if (stack$iv$iv2 != 0) {
                    }
                    node$iv$iv2 = $this$visitChildren$iv$iv;
                    stack$iv$iv2.add($this$visitSelfAndChildren_u2d6rFNWt0$iv3);
                    i4 = 0;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    mask$iv$iv5 = 16;
                    i3 = 0;
                    i12 = i9;
                    i5 = $i$f$visitSelfAndChildren6rFNWt0;
                    i10 = mask$iv$iv5;
                    $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv5], 0);
                    node$iv$iv2 = node;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i12 = i9;
                    i5 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv2 = node;
                    this_$iv$iv$iv = 1;
                    count$iv$iv = 1;
                    i11 = 0;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i12 = i9;
                    i5 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv = 1;
                }
                i12 = i9;
                i5 = $i$f$visitSelfAndChildren6rFNWt0;
                int mask$iv$iv4 = 1;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                i4 = 0;
                i11 = 0;
                if (kindSet$ui_release4 &= i23 != 0) {
                } else {
                }
                count$iv$iv = i4;
                if (count$iv$iv != 0 && node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                i12 = i9;
                i5 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv = 1;
                node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv2);
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                i9 = i12;
                $i$f$visitSelfAndChildren6rFNWt0 = i5;
                i4 = 0;
                if (node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                restoreFocusedChild2 = 0;
                node$iv$iv$iv2 = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv2 != null) {
                    node = node$iv$iv$iv2;
                    i = 0;
                    i25 = 0;
                    if (kindSet$ui_release5 &= i23 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = i4;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i12 = i9;
                    i5 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv2 = node;
                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                    i9 = i12;
                    $i$f$visitSelfAndChildren6rFNWt0 = i5;
                    i4 = 0;
                    if (count$iv$iv++ == 1) {
                    } else {
                    }
                    if (stack$iv$iv2 == 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i12 = i9;
                    i5 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv = stack$iv$iv2;
                    stack$iv$iv2 = $this$visitChildren$iv$iv;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = node$iv$iv2;
                    if ($this$visitSelfAndChildren_u2d6rFNWt0$iv3 != 0 && stack$iv$iv2 != 0) {
                    }
                    if (stack$iv$iv2 != 0) {
                    } else {
                    }
                    $this$visitChildren$iv$iv2 = node;
                    stack$iv$iv2.add(node);
                    if (stack$iv$iv2 != 0) {
                    }
                    node$iv$iv2 = $this$visitChildren$iv$iv;
                    stack$iv$iv2.add($this$visitSelfAndChildren_u2d6rFNWt0$iv3);
                    i4 = 0;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    mask$iv$iv5 = 16;
                    i3 = 0;
                    i12 = i9;
                    i5 = $i$f$visitSelfAndChildren6rFNWt0;
                    i10 = mask$iv$iv5;
                    $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv5], 0);
                    node$iv$iv2 = node;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i12 = i9;
                    i5 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv2 = node;
                    this_$iv$iv$iv = 1;
                }
                if (count$iv$iv == 1) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                i9 = i12;
                $i$f$visitSelfAndChildren6rFNWt0 = i5;
                i4 = 0;
                node = node$iv$iv$iv2;
                i = 0;
                i25 = 0;
                if (kindSet$ui_release5 &= i23 != 0) {
                } else {
                }
                this_$iv$iv$iv = i4;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                i12 = i9;
                i5 = $i$f$visitSelfAndChildren6rFNWt0;
                $this$visitChildren$iv$iv2 = node;
                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                i9 = i12;
                $i$f$visitSelfAndChildren6rFNWt0 = i5;
                i4 = 0;
                if (count$iv$iv++ == 1) {
                } else {
                }
                if (stack$iv$iv2 == 0) {
                } else {
                }
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                i12 = i9;
                i5 = $i$f$visitSelfAndChildren6rFNWt0;
                $this$visitChildren$iv$iv = stack$iv$iv2;
                stack$iv$iv2 = $this$visitChildren$iv$iv;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = node$iv$iv2;
                if ($this$visitSelfAndChildren_u2d6rFNWt0$iv3 != 0 && stack$iv$iv2 != 0) {
                }
                if (stack$iv$iv2 != 0) {
                } else {
                }
                $this$visitChildren$iv$iv2 = node;
                stack$iv$iv2.add(node);
                if (stack$iv$iv2 != 0) {
                }
                node$iv$iv2 = $this$visitChildren$iv$iv;
                stack$iv$iv2.add($this$visitSelfAndChildren_u2d6rFNWt0$iv3);
                i4 = 0;
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                mask$iv$iv5 = 16;
                i3 = 0;
                i12 = i9;
                i5 = $i$f$visitSelfAndChildren6rFNWt0;
                i10 = mask$iv$iv5;
                $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv5], 0);
                node$iv$iv2 = node;
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                i12 = i9;
                i5 = $i$f$visitSelfAndChildren6rFNWt0;
                $this$visitChildren$iv$iv2 = node;
                this_$iv$iv$iv = 1;
                count$iv$iv = 1;
                i11 = 0;
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                i12 = i9;
                i5 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv = 1;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node2);
            }
            return 0;
        }
        int i26 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
        int i27 = i9;
        int mask$iv$iv7 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv;
    }

    public static final boolean saveFocusedChild(androidx.compose.ui.focus.FocusRequesterModifierNode $this$saveFocusedChild) {
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
        int mask$iv$iv;
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
        int $i$f$getFocusTargetOLwlOKw;
        int i12;
        Modifier.Node $this$visitChildren$iv$iv;
        int $this$visitChildren$iv$iv2;
        int $i$f$visitSelfAndChildren6rFNWt0;
        int stack$iv$iv2;
        int node;
        Modifier.Node node$iv$iv;
        int node$iv$iv3;
        int i11;
        int i4;
        int count$iv$iv;
        Modifier.Node[] arr;
        Modifier.Node focusedChild2;
        int i9;
        Modifier.Node node$iv$iv$iv2;
        Modifier.Node stack$iv$iv;
        int node$iv$iv2;
        int count$iv$iv2;
        int i10;
        int i5;
        Modifier.Node $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int i6;
        int focusedChild;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i7;
        int this_$iv$iv$iv;
        int mask$iv$iv2;
        int i3;
        int i;
        int i8;
        int i2;
        int i13 = 0;
        $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
        $i$f$visitSelfAndChildren6rFNWt0 = 0;
        int i16 = 0;
        stack$iv$iv2 = 0;
        int i18 = 0;
        node$iv$iv = node3;
        i11 = 0;
        i4 = 1;
        while (node$iv$iv != null) {
            focusedChild2 = 0;
            if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
            } else {
            }
            count$iv$iv = i11;
            if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i6 = $i$f$getFocusTargetOLwlOKw;
            node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv2);
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            $i$f$getFocusTargetOLwlOKw = i6;
            i11 = 0;
            i4 = 1;
            if (node$iv$iv instanceof DelegatingNode) {
            } else {
            }
            count$iv$iv = 0;
            i9 = 0;
            node$iv$iv$iv2 = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
            while (node$iv$iv$iv2 != null) {
                stack$iv$iv = node$iv$iv$iv2;
                node$iv$iv2 = 0;
                i10 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                count$iv$iv2 = i11;
                if (count$iv$iv2 != 0) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i6 = $i$f$getFocusTargetOLwlOKw;
                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                $i$f$getFocusTargetOLwlOKw = i6;
                i4 = 1;
                if (count$iv$iv++ == i4) {
                } else {
                }
                if (stack$iv$iv2 == 0) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i6 = $i$f$getFocusTargetOLwlOKw;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = stack$iv$iv2;
                stack$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = node$iv$iv;
                if ($this$visitSelfAndChildren_u2d6rFNWt0$iv2 != null && stack$iv$iv2 != 0) {
                }
                if (stack$iv$iv2 != 0) {
                }
                stack$iv$iv2.add(stack$iv$iv);
                if (stack$iv$iv2 != 0) {
                }
                node$iv$iv = $i$f$getFocusTargetOLwlOKw;
                stack$iv$iv2.add($this$visitSelfAndChildren_u2d6rFNWt0$iv2);
                count$iv$iv2 = 0;
                i5 = 0;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i6 = $i$f$getFocusTargetOLwlOKw;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = new MutableVector(new Modifier.Node[16], i11);
                node$iv$iv = stack$iv$iv;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i6 = $i$f$getFocusTargetOLwlOKw;
                count$iv$iv2 = i4;
            }
            if (count$iv$iv == 1) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            $i$f$getFocusTargetOLwlOKw = i6;
            stack$iv$iv = node$iv$iv$iv2;
            node$iv$iv2 = 0;
            i10 = 0;
            if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
            } else {
            }
            count$iv$iv2 = i11;
            if (count$iv$iv2 != 0) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i6 = $i$f$getFocusTargetOLwlOKw;
            node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            $i$f$getFocusTargetOLwlOKw = i6;
            i4 = 1;
            if (count$iv$iv++ == i4) {
            } else {
            }
            if (stack$iv$iv2 == 0) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i6 = $i$f$getFocusTargetOLwlOKw;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = stack$iv$iv2;
            stack$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = node$iv$iv;
            if ($this$visitSelfAndChildren_u2d6rFNWt0$iv2 != null && stack$iv$iv2 != 0) {
            }
            if (stack$iv$iv2 != 0) {
            }
            stack$iv$iv2.add(stack$iv$iv);
            if (stack$iv$iv2 != 0) {
            }
            node$iv$iv = $i$f$getFocusTargetOLwlOKw;
            stack$iv$iv2.add($this$visitSelfAndChildren_u2d6rFNWt0$iv2);
            count$iv$iv2 = 0;
            i5 = 0;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i6 = $i$f$getFocusTargetOLwlOKw;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = new MutableVector(new Modifier.Node[16], i11);
            node$iv$iv = stack$iv$iv;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i6 = $i$f$getFocusTargetOLwlOKw;
            count$iv$iv2 = i4;
            count$iv$iv = i4;
            count$iv$iv = 0;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i6 = $i$f$getFocusTargetOLwlOKw;
        }
        int i23 = $i$f$getFocusTargetOLwlOKw;
        i12 = $this$visitSelfAndChildren_u2d6rFNWt0$iv5;
        int i15 = 0;
        if (!i12.getNode().isAttached()) {
        } else {
            int i17 = 0;
            node$iv$iv3 = 0;
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], i11);
            Modifier.Node child$ui_release = i12.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, i12.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                int i19 = 0;
                i10 = 1;
                node = mutableVector2.removeAt(size--);
                if (aggregateChildKindSet$ui_release &= $this$visitSelfAndChildren_u2d6rFNWt0$iv3 == 0) {
                } else {
                }
                node$iv$iv3 = node;
                while (node$iv$iv3 != 0) {
                    i = i12;
                    i8 = $i$f$visitSelfAndChildren6rFNWt0;
                    int mask$iv$iv6 = 1;
                    node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                    i11 = 0;
                }
                i = i12;
                i8 = $i$f$visitSelfAndChildren6rFNWt0;
                int mask$iv$iv3 = 1;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                i11 = 0;
                if (kindSet$ui_release &= $this$visitSelfAndChildren_u2d6rFNWt0$iv3 != null) {
                } else {
                }
                i = i12;
                i8 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv6 = 1;
                node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                i11 = 0;
                focusedChild2 = 0;
                node$iv$iv$iv2 = null;
                stack$iv$iv = 0;
                int i20 = 0;
                node$iv$iv2 = i9;
                while (node$iv$iv2 != 0) {
                    i5 = 0;
                    if (kindSet$ui_release4 &= i23 != 0) {
                    } else {
                    }
                    count$iv$iv2 = i11;
                    if (count$iv$iv2 != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i = i12;
                    i8 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv = 1;
                    node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                    i12 = i;
                    $i$f$visitSelfAndChildren6rFNWt0 = i8;
                    i11 = 0;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    focusedChild = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i7 = 0;
                        int i25 = 0;
                        if (kindSet$ui_release5 &= i23 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = i11;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                        i = i12;
                        i8 = $i$f$visitSelfAndChildren6rFNWt0;
                        $this$visitChildren$iv$iv = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                        i12 = i;
                        $i$f$visitSelfAndChildren6rFNWt0 = i8;
                        i11 = 0;
                        if (count$iv$iv2++ == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                        i = i12;
                        i8 = $i$f$visitSelfAndChildren6rFNWt0;
                        $this$visitChildren$iv$iv2 = stack$iv$iv;
                        stack$iv$iv = $this$visitChildren$iv$iv2;
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = node$iv$iv2;
                        if ($this$visitSelfAndChildren_u2d6rFNWt0$iv3 != 0 && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        $this$visitChildren$iv$iv = node2;
                        stack$iv$iv.add(node2);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv2 = $this$visitChildren$iv$iv2;
                        stack$iv$iv.add($this$visitSelfAndChildren_u2d6rFNWt0$iv3);
                        i11 = 0;
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                        int mask$iv$iv5 = 16;
                        i3 = 0;
                        i = i12;
                        i8 = $i$f$visitSelfAndChildren6rFNWt0;
                        i2 = mask$iv$iv5;
                        $this$visitChildren$iv$iv2 = new MutableVector(new Modifier.Node[mask$iv$iv5], 0);
                        node$iv$iv2 = node2;
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                        i = i12;
                        i8 = $i$f$visitSelfAndChildren6rFNWt0;
                        $this$visitChildren$iv$iv = node2;
                        this_$iv$iv$iv = 1;
                    }
                    if (count$iv$iv2 == 1) {
                    } else {
                    }
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                    i12 = i;
                    $i$f$visitSelfAndChildren6rFNWt0 = i8;
                    i11 = 0;
                    node2 = node$iv$iv$iv;
                    i7 = 0;
                    i25 = 0;
                    if (kindSet$ui_release5 &= i23 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = i11;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i = i12;
                    i8 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                    i12 = i;
                    $i$f$visitSelfAndChildren6rFNWt0 = i8;
                    i11 = 0;
                    if (count$iv$iv2++ == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i = i12;
                    i8 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv2 = stack$iv$iv;
                    stack$iv$iv = $this$visitChildren$iv$iv2;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = node$iv$iv2;
                    if ($this$visitSelfAndChildren_u2d6rFNWt0$iv3 != 0 && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    $this$visitChildren$iv$iv = node2;
                    stack$iv$iv.add(node2);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv2 = $this$visitChildren$iv$iv2;
                    stack$iv$iv.add($this$visitSelfAndChildren_u2d6rFNWt0$iv3);
                    i11 = 0;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    mask$iv$iv5 = 16;
                    i3 = 0;
                    i = i12;
                    i8 = $i$f$visitSelfAndChildren6rFNWt0;
                    i2 = mask$iv$iv5;
                    $this$visitChildren$iv$iv2 = new MutableVector(new Modifier.Node[mask$iv$iv5], 0);
                    node$iv$iv2 = node2;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i = i12;
                    i8 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv = node2;
                    this_$iv$iv$iv = 1;
                    count$iv$iv2 = 1;
                    i5 = 0;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i = i12;
                    i8 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv = 1;
                }
                i = i12;
                i8 = $i$f$visitSelfAndChildren6rFNWt0;
                int mask$iv$iv4 = 1;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                i11 = 0;
                i5 = 0;
                if (kindSet$ui_release4 &= i23 != 0) {
                } else {
                }
                count$iv$iv2 = i11;
                if (count$iv$iv2 != 0 && node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                i = i12;
                i8 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv = 1;
                node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                i12 = i;
                $i$f$visitSelfAndChildren6rFNWt0 = i8;
                i11 = 0;
                if (node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv2 = 0;
                focusedChild = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node2 = node$iv$iv$iv;
                    i7 = 0;
                    i25 = 0;
                    if (kindSet$ui_release5 &= i23 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = i11;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i = i12;
                    i8 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                    i12 = i;
                    $i$f$visitSelfAndChildren6rFNWt0 = i8;
                    i11 = 0;
                    if (count$iv$iv2++ == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i = i12;
                    i8 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv2 = stack$iv$iv;
                    stack$iv$iv = $this$visitChildren$iv$iv2;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = node$iv$iv2;
                    if ($this$visitSelfAndChildren_u2d6rFNWt0$iv3 != 0 && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    $this$visitChildren$iv$iv = node2;
                    stack$iv$iv.add(node2);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv2 = $this$visitChildren$iv$iv2;
                    stack$iv$iv.add($this$visitSelfAndChildren_u2d6rFNWt0$iv3);
                    i11 = 0;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    mask$iv$iv5 = 16;
                    i3 = 0;
                    i = i12;
                    i8 = $i$f$visitSelfAndChildren6rFNWt0;
                    i2 = mask$iv$iv5;
                    $this$visitChildren$iv$iv2 = new MutableVector(new Modifier.Node[mask$iv$iv5], 0);
                    node$iv$iv2 = node2;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    i = i12;
                    i8 = $i$f$visitSelfAndChildren6rFNWt0;
                    $this$visitChildren$iv$iv = node2;
                    this_$iv$iv$iv = 1;
                }
                if (count$iv$iv2 == 1) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                i12 = i;
                $i$f$visitSelfAndChildren6rFNWt0 = i8;
                i11 = 0;
                node2 = node$iv$iv$iv;
                i7 = 0;
                i25 = 0;
                if (kindSet$ui_release5 &= i23 != 0) {
                } else {
                }
                this_$iv$iv$iv = i11;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                i = i12;
                i8 = $i$f$visitSelfAndChildren6rFNWt0;
                $this$visitChildren$iv$iv = node2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = mask$iv$iv2;
                i12 = i;
                $i$f$visitSelfAndChildren6rFNWt0 = i8;
                i11 = 0;
                if (count$iv$iv2++ == 1) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                i = i12;
                i8 = $i$f$visitSelfAndChildren6rFNWt0;
                $this$visitChildren$iv$iv2 = stack$iv$iv;
                stack$iv$iv = $this$visitChildren$iv$iv2;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = node$iv$iv2;
                if ($this$visitSelfAndChildren_u2d6rFNWt0$iv3 != 0 && stack$iv$iv != 0) {
                }
                if (stack$iv$iv != 0) {
                } else {
                }
                $this$visitChildren$iv$iv = node2;
                stack$iv$iv.add(node2);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv2 = $this$visitChildren$iv$iv2;
                stack$iv$iv.add($this$visitSelfAndChildren_u2d6rFNWt0$iv3);
                i11 = 0;
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                mask$iv$iv5 = 16;
                i3 = 0;
                i = i12;
                i8 = $i$f$visitSelfAndChildren6rFNWt0;
                i2 = mask$iv$iv5;
                $this$visitChildren$iv$iv2 = new MutableVector(new Modifier.Node[mask$iv$iv5], 0);
                node$iv$iv2 = node2;
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                i = i12;
                i8 = $i$f$visitSelfAndChildren6rFNWt0;
                $this$visitChildren$iv$iv = node2;
                this_$iv$iv$iv = 1;
                count$iv$iv2 = 1;
                i5 = 0;
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                i = i12;
                i8 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv = 1;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node);
            }
            return 0;
        }
        int i26 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
        int i27 = i12;
        int mask$iv$iv7 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv;
    }
}
