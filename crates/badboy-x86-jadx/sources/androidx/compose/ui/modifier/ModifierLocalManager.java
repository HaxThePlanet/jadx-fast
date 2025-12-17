package androidx.compose.ui.modifier;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.BackwardsCompatNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\n\u0010\u0014\u001a\u0006\u0012\u0002\u0008\u00030\tJ\u0006\u0010\u0015\u001a\u00020\u0012J*\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00172\n\u0010\u0014\u001a\u0006\u0012\u0002\u0008\u00030\t2\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\n\u0010\u0014\u001a\u0006\u0012\u0002\u0008\u00030\tJ\u0006\u0010\u001b\u001a\u00020\u0012J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\n\u0010\u0014\u001a\u0006\u0012\u0002\u0008\u00030\tR\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0008\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0014\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"Landroidx/compose/ui/modifier/ModifierLocalManager;", "", "owner", "Landroidx/compose/ui/node/Owner;", "(Landroidx/compose/ui/node/Owner;)V", "inserted", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/BackwardsCompatNode;", "insertedLocal", "Landroidx/compose/ui/modifier/ModifierLocal;", "invalidated", "", "getOwner", "()Landroidx/compose/ui/node/Owner;", "removed", "Landroidx/compose/ui/node/LayoutNode;", "removedLocal", "insertedProvider", "", "node", "key", "invalidate", "invalidateConsumersOfNodeForKey", "Landroidx/compose/ui/Modifier$Node;", "set", "", "removedProvider", "triggerUpdates", "updatedProvider", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ModifierLocalManager {

    public static final int $stable = 8;
    private final MutableVector<BackwardsCompatNode> inserted;
    private final MutableVector<androidx.compose.ui.modifier.ModifierLocal<?>> insertedLocal;
    private boolean invalidated;
    private final Owner owner;
    private final MutableVector<LayoutNode> removed;
    private final MutableVector<androidx.compose.ui.modifier.ModifierLocal<?>> removedLocal;
    static {
        final int i = 8;
    }

    public ModifierLocalManager(Owner owner) {
        super();
        this.owner = owner;
        int i = 0;
        int i9 = 0;
        final int i13 = 0;
        MutableVector mutableVector = new MutableVector(new BackwardsCompatNode[16], i13);
        this.inserted = mutableVector;
        int i2 = 0;
        int i10 = 0;
        MutableVector mutableVector2 = new MutableVector(new ModifierLocal[16], i13);
        this.insertedLocal = mutableVector2;
        int i3 = 0;
        int i11 = 0;
        MutableVector mutableVector3 = new MutableVector(new LayoutNode[16], i13);
        this.removed = mutableVector3;
        int i4 = 0;
        int i12 = 0;
        MutableVector mutableVector4 = new MutableVector(new ModifierLocal[16], i13);
        this.removedLocal = mutableVector4;
    }

    private final void invalidateConsumersOfNodeForKey(Modifier.Node node, androidx.compose.ui.modifier.ModifierLocal<?> key, Set<BackwardsCompatNode> set) {
        Object obj3;
        Modifier.Node next$iv$iv;
        int capacity$iv$iv$iv$iv;
        int i9;
        int i2;
        int count$iv$iv3;
        int count$iv$iv4;
        int count$iv$iv2;
        int $i$f$getLocalsOLwlOKw;
        boolean type$iv;
        int node2;
        String $i$a$CheckPreconditionDelegatableNodeKt$visitSubtreeIf$1$iv$iv;
        int i10;
        Modifier.Node[] node$iv$iv;
        int node$iv$iv3;
        Object obj4;
        int i6;
        Object obj;
        int i11;
        int i3;
        Object node$iv$iv2;
        int i;
        int $this$visitSubtreeIf_u2d6rFNWt0$iv;
        int node$iv$iv$iv;
        int i4;
        Object obj2;
        int i8;
        int this_$iv$iv$iv;
        int i5;
        int count$iv$iv;
        int i7;
        obj3 = key;
        int i14 = 0;
        int i16 = 0;
        final int i17 = $i$f$getLocalsOLwlOKw;
        final int i18 = count$iv$iv3;
        final int i19 = 0;
        int i20 = 0;
        if (!i18.getNode().isAttached()) {
            int i22 = 0;
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        int value$iv$iv$iv = 0;
        i10 = 0;
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = i18.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, i18.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            node2 = mutableVector.removeAt(size -= i10);
            if (aggregateChildKindSet$ui_release &= i17 != 0) {
            } else {
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv3;
            i4 = $i$f$getLocalsOLwlOKw;
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node2);
            obj3 = key;
            count$iv$iv3 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            $i$f$getLocalsOLwlOKw = i4;
            node$iv$iv3 = 0;
            node$iv$iv = node2;
            while (node$iv$iv != null) {
                if (kindSet$ui_release &= i17 == 0) {
                    break loop_8;
                } else {
                }
                $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv3;
                i4 = $i$f$getLocalsOLwlOKw;
                i2 = i10;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                i10 = i2;
                count$iv$iv3 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                $i$f$getLocalsOLwlOKw = i4;
                node$iv$iv3 = 0;
                obj3 = key;
                i6 = 0;
                i11 = 0;
                i3 = 0;
                int i23 = 0;
                node$iv$iv3 = node$iv$iv2;
                while (node$iv$iv3 != null) {
                    i4 = $i$f$getLocalsOLwlOKw;
                    $i$f$getLocalsOLwlOKw = set;
                    i10 = 0;
                    if (kindSet$ui_release2 &= i4 != 0) {
                    } else {
                    }
                    count$iv$iv4 = 0;
                    if (count$iv$iv4 != 0 && node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    i9 = 1;
                    node$iv$iv3 = DelegatableNodeKt.access$pop(i3);
                    i10 = i9;
                    count$iv$iv3 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                    $i$f$getLocalsOLwlOKw = i4;
                    obj3 = key;
                    if (node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv4 = 0;
                    i = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        obj2 = node$iv$iv$iv;
                        i8 = 0;
                        i5 = 0;
                        if (kindSet$ui_release3 &= i4 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = obj2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        obj3 = key;
                        $i$f$getLocalsOLwlOKw = set;
                        count$iv$iv4++;
                        if (count$iv$iv4 == 1) {
                        } else {
                        }
                        if (i3 == 0) {
                        } else {
                        }
                        count$iv$iv = count$iv$iv4;
                        capacity$iv$iv$iv$iv = 0;
                        count$iv$iv2 = i3;
                        $i$f$getLocalsOLwlOKw = node$iv$iv3;
                        if ($i$f$getLocalsOLwlOKw != null && count$iv$iv2 != 0) {
                        }
                        if (count$iv$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv = obj2;
                        i3 = count$iv$iv2;
                        count$iv$iv4 = count$iv$iv;
                        count$iv$iv2.add(obj2);
                        if (count$iv$iv2 != 0) {
                        }
                        node$iv$iv3 = 0;
                        count$iv$iv2.add($i$f$getLocalsOLwlOKw);
                        this_$iv$iv$iv = i13;
                        int $i$f$mutableVectorOf = 16;
                        i5 = 0;
                        count$iv$iv = count$iv$iv4;
                        i7 = $i$f$mutableVectorOf;
                        count$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv3 = obj2;
                        next$iv$iv = obj2;
                        this_$iv$iv$iv = 1;
                    }
                    i9 = 1;
                    if (count$iv$iv4 == i9) {
                    } else {
                    }
                    i10 = i9;
                    count$iv$iv3 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                    $i$f$getLocalsOLwlOKw = i4;
                    obj3 = key;
                    obj2 = node$iv$iv$iv;
                    i8 = 0;
                    i5 = 0;
                    if (kindSet$ui_release3 &= i4 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = obj2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    obj3 = key;
                    $i$f$getLocalsOLwlOKw = set;
                    count$iv$iv4++;
                    if (count$iv$iv4 == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv4;
                    capacity$iv$iv$iv$iv = 0;
                    count$iv$iv2 = i3;
                    $i$f$getLocalsOLwlOKw = node$iv$iv3;
                    if ($i$f$getLocalsOLwlOKw != null && count$iv$iv2 != 0) {
                    }
                    if (count$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv = obj2;
                    i3 = count$iv$iv2;
                    count$iv$iv4 = count$iv$iv;
                    count$iv$iv2.add(obj2);
                    if (count$iv$iv2 != 0) {
                    }
                    node$iv$iv3 = 0;
                    count$iv$iv2.add($i$f$getLocalsOLwlOKw);
                    this_$iv$iv$iv = i13;
                    $i$f$mutableVectorOf = 16;
                    i5 = 0;
                    count$iv$iv = count$iv$iv4;
                    i7 = $i$f$mutableVectorOf;
                    count$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv3 = obj2;
                    next$iv$iv = obj2;
                    this_$iv$iv$iv = 1;
                    count$iv$iv4 = 1;
                    i = 0;
                    $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv3;
                    Object $this$visitSubtreeIf_u2d6rFNWt0$iv3 = i10;
                    node$iv$iv$iv = 0;
                    i4 = $i$f$getLocalsOLwlOKw;
                    if ($this$visitSubtreeIf_u2d6rFNWt0$iv3 instanceof BackwardsCompatNode && element instanceof ModifierLocalConsumer) {
                    } else {
                    }
                    $i$f$getLocalsOLwlOKw = set;
                    i9 = 1;
                    if (element instanceof ModifierLocalConsumer) {
                    } else {
                    }
                    if ((BackwardsCompatNode)$this$visitSubtreeIf_u2d6rFNWt0$iv3.getReadValues().contains(obj3)) {
                    } else {
                    }
                    $i$f$getLocalsOLwlOKw = set;
                    set.add($this$visitSubtreeIf_u2d6rFNWt0$iv3);
                }
                $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv3;
                i4 = $i$f$getLocalsOLwlOKw;
                count$iv$iv3 = i2;
                if (node$iv$iv3 instanceof ModifierLocalModifierNode) {
                } else {
                }
                i4 = $i$f$getLocalsOLwlOKw;
                $i$f$getLocalsOLwlOKw = set;
                i10 = 0;
                if (kindSet$ui_release2 &= i4 != 0) {
                } else {
                }
                count$iv$iv4 = 0;
                if (count$iv$iv4 != 0 && node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                i9 = 1;
                node$iv$iv3 = DelegatableNodeKt.access$pop(i3);
                i10 = i9;
                count$iv$iv3 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                $i$f$getLocalsOLwlOKw = i4;
                obj3 = key;
                if (node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv4 = 0;
                i = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    obj2 = node$iv$iv$iv;
                    i8 = 0;
                    i5 = 0;
                    if (kindSet$ui_release3 &= i4 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = obj2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    obj3 = key;
                    $i$f$getLocalsOLwlOKw = set;
                    count$iv$iv4++;
                    if (count$iv$iv4 == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv4;
                    capacity$iv$iv$iv$iv = 0;
                    count$iv$iv2 = i3;
                    $i$f$getLocalsOLwlOKw = node$iv$iv3;
                    if ($i$f$getLocalsOLwlOKw != null && count$iv$iv2 != 0) {
                    }
                    if (count$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv = obj2;
                    i3 = count$iv$iv2;
                    count$iv$iv4 = count$iv$iv;
                    count$iv$iv2.add(obj2);
                    if (count$iv$iv2 != 0) {
                    }
                    node$iv$iv3 = 0;
                    count$iv$iv2.add($i$f$getLocalsOLwlOKw);
                    this_$iv$iv$iv = i13;
                    $i$f$mutableVectorOf = 16;
                    i5 = 0;
                    count$iv$iv = count$iv$iv4;
                    i7 = $i$f$mutableVectorOf;
                    count$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv3 = obj2;
                    next$iv$iv = obj2;
                    this_$iv$iv$iv = 1;
                }
                i9 = 1;
                if (count$iv$iv4 == i9) {
                } else {
                }
                i10 = i9;
                count$iv$iv3 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                $i$f$getLocalsOLwlOKw = i4;
                obj3 = key;
                obj2 = node$iv$iv$iv;
                i8 = 0;
                i5 = 0;
                if (kindSet$ui_release3 &= i4 != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                next$iv$iv = obj2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                obj3 = key;
                $i$f$getLocalsOLwlOKw = set;
                count$iv$iv4++;
                if (count$iv$iv4 == 1) {
                } else {
                }
                if (i3 == 0) {
                } else {
                }
                count$iv$iv = count$iv$iv4;
                capacity$iv$iv$iv$iv = 0;
                count$iv$iv2 = i3;
                $i$f$getLocalsOLwlOKw = node$iv$iv3;
                if ($i$f$getLocalsOLwlOKw != null && count$iv$iv2 != 0) {
                }
                if (count$iv$iv2 != 0) {
                } else {
                }
                next$iv$iv = obj2;
                i3 = count$iv$iv2;
                count$iv$iv4 = count$iv$iv;
                count$iv$iv2.add(obj2);
                if (count$iv$iv2 != 0) {
                }
                node$iv$iv3 = 0;
                count$iv$iv2.add($i$f$getLocalsOLwlOKw);
                this_$iv$iv$iv = i13;
                $i$f$mutableVectorOf = 16;
                i5 = 0;
                count$iv$iv = count$iv$iv4;
                i7 = $i$f$mutableVectorOf;
                count$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv3 = obj2;
                next$iv$iv = obj2;
                this_$iv$iv$iv = 1;
                count$iv$iv4 = 1;
                i = 0;
                $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv3;
                $this$visitSubtreeIf_u2d6rFNWt0$iv3 = i10;
                node$iv$iv$iv = 0;
                i4 = $i$f$getLocalsOLwlOKw;
                if ($this$visitSubtreeIf_u2d6rFNWt0$iv3 instanceof BackwardsCompatNode && element instanceof ModifierLocalConsumer) {
                } else {
                }
                $i$f$getLocalsOLwlOKw = set;
                if ($this$visitSubtreeIf_u2d6rFNWt0$iv3.getProvidedValues().contains$ui_release(obj3)) {
                } else {
                }
                i9 = 1;
                i2 = 1;
                count$iv$iv3 = 0;
                if (element instanceof ModifierLocalConsumer) {
                } else {
                }
                if ((BackwardsCompatNode)$this$visitSubtreeIf_u2d6rFNWt0$iv3.getReadValues().contains(obj3)) {
                } else {
                }
                $i$f$getLocalsOLwlOKw = set;
                set.add($this$visitSubtreeIf_u2d6rFNWt0$iv3);
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv3;
            i4 = $i$f$getLocalsOLwlOKw;
            if (kindSet$ui_release &= i17 != 0) {
            } else {
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv3;
            i4 = $i$f$getLocalsOLwlOKw;
            i2 = i10;
            node$iv$iv = node$iv$iv.getChild$ui_release();
            i10 = i2;
            count$iv$iv3 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            $i$f$getLocalsOLwlOKw = i4;
            node$iv$iv3 = 0;
            obj3 = key;
            i6 = 0;
            i11 = 0;
            i3 = 0;
            i23 = 0;
            node$iv$iv3 = node$iv$iv2;
            while (node$iv$iv3 != null) {
                i4 = $i$f$getLocalsOLwlOKw;
                $i$f$getLocalsOLwlOKw = set;
                i10 = 0;
                if (kindSet$ui_release2 &= i4 != 0) {
                } else {
                }
                count$iv$iv4 = 0;
                if (count$iv$iv4 != 0 && node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                i9 = 1;
                node$iv$iv3 = DelegatableNodeKt.access$pop(i3);
                i10 = i9;
                count$iv$iv3 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                $i$f$getLocalsOLwlOKw = i4;
                obj3 = key;
                if (node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv4 = 0;
                i = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    obj2 = node$iv$iv$iv;
                    i8 = 0;
                    i5 = 0;
                    if (kindSet$ui_release3 &= i4 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = obj2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    obj3 = key;
                    $i$f$getLocalsOLwlOKw = set;
                    count$iv$iv4++;
                    if (count$iv$iv4 == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv4;
                    capacity$iv$iv$iv$iv = 0;
                    count$iv$iv2 = i3;
                    $i$f$getLocalsOLwlOKw = node$iv$iv3;
                    if ($i$f$getLocalsOLwlOKw != null && count$iv$iv2 != 0) {
                    }
                    if (count$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv = obj2;
                    i3 = count$iv$iv2;
                    count$iv$iv4 = count$iv$iv;
                    count$iv$iv2.add(obj2);
                    if (count$iv$iv2 != 0) {
                    }
                    node$iv$iv3 = 0;
                    count$iv$iv2.add($i$f$getLocalsOLwlOKw);
                    this_$iv$iv$iv = i13;
                    $i$f$mutableVectorOf = 16;
                    i5 = 0;
                    count$iv$iv = count$iv$iv4;
                    i7 = $i$f$mutableVectorOf;
                    count$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv3 = obj2;
                    next$iv$iv = obj2;
                    this_$iv$iv$iv = 1;
                }
                i9 = 1;
                if (count$iv$iv4 == i9) {
                } else {
                }
                i10 = i9;
                count$iv$iv3 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                $i$f$getLocalsOLwlOKw = i4;
                obj3 = key;
                obj2 = node$iv$iv$iv;
                i8 = 0;
                i5 = 0;
                if (kindSet$ui_release3 &= i4 != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                next$iv$iv = obj2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                obj3 = key;
                $i$f$getLocalsOLwlOKw = set;
                count$iv$iv4++;
                if (count$iv$iv4 == 1) {
                } else {
                }
                if (i3 == 0) {
                } else {
                }
                count$iv$iv = count$iv$iv4;
                capacity$iv$iv$iv$iv = 0;
                count$iv$iv2 = i3;
                $i$f$getLocalsOLwlOKw = node$iv$iv3;
                if ($i$f$getLocalsOLwlOKw != null && count$iv$iv2 != 0) {
                }
                if (count$iv$iv2 != 0) {
                } else {
                }
                next$iv$iv = obj2;
                i3 = count$iv$iv2;
                count$iv$iv4 = count$iv$iv;
                count$iv$iv2.add(obj2);
                if (count$iv$iv2 != 0) {
                }
                node$iv$iv3 = 0;
                count$iv$iv2.add($i$f$getLocalsOLwlOKw);
                this_$iv$iv$iv = i13;
                $i$f$mutableVectorOf = 16;
                i5 = 0;
                count$iv$iv = count$iv$iv4;
                i7 = $i$f$mutableVectorOf;
                count$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv3 = obj2;
                next$iv$iv = obj2;
                this_$iv$iv$iv = 1;
                count$iv$iv4 = 1;
                i = 0;
                $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv3;
                $this$visitSubtreeIf_u2d6rFNWt0$iv3 = i10;
                node$iv$iv$iv = 0;
                i4 = $i$f$getLocalsOLwlOKw;
                if ($this$visitSubtreeIf_u2d6rFNWt0$iv3 instanceof BackwardsCompatNode && element instanceof ModifierLocalConsumer) {
                } else {
                }
                $i$f$getLocalsOLwlOKw = set;
                i9 = 1;
                if (element instanceof ModifierLocalConsumer) {
                } else {
                }
                if ((BackwardsCompatNode)$this$visitSubtreeIf_u2d6rFNWt0$iv3.getReadValues().contains(obj3)) {
                } else {
                }
                $i$f$getLocalsOLwlOKw = set;
                set.add($this$visitSubtreeIf_u2d6rFNWt0$iv3);
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv3;
            i4 = $i$f$getLocalsOLwlOKw;
            count$iv$iv3 = i2;
            if (count$iv$iv3 != 0) {
            } else {
            }
            obj3 = key;
            count$iv$iv3 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            $i$f$getLocalsOLwlOKw = i4;
            node$iv$iv3 = 0;
            if (node$iv$iv3 instanceof ModifierLocalModifierNode) {
            } else {
            }
            i4 = $i$f$getLocalsOLwlOKw;
            $i$f$getLocalsOLwlOKw = set;
            i10 = 0;
            if (kindSet$ui_release2 &= i4 != 0) {
            } else {
            }
            count$iv$iv4 = 0;
            if (count$iv$iv4 != 0 && node$iv$iv3 instanceof DelegatingNode) {
            } else {
            }
            i9 = 1;
            node$iv$iv3 = DelegatableNodeKt.access$pop(i3);
            i10 = i9;
            count$iv$iv3 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            $i$f$getLocalsOLwlOKw = i4;
            obj3 = key;
            if (node$iv$iv3 instanceof DelegatingNode) {
            } else {
            }
            count$iv$iv4 = 0;
            i = 0;
            node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
            while (node$iv$iv$iv != null) {
                obj2 = node$iv$iv$iv;
                i8 = 0;
                i5 = 0;
                if (kindSet$ui_release3 &= i4 != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                next$iv$iv = obj2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                obj3 = key;
                $i$f$getLocalsOLwlOKw = set;
                count$iv$iv4++;
                if (count$iv$iv4 == 1) {
                } else {
                }
                if (i3 == 0) {
                } else {
                }
                count$iv$iv = count$iv$iv4;
                capacity$iv$iv$iv$iv = 0;
                count$iv$iv2 = i3;
                $i$f$getLocalsOLwlOKw = node$iv$iv3;
                if ($i$f$getLocalsOLwlOKw != null && count$iv$iv2 != 0) {
                }
                if (count$iv$iv2 != 0) {
                } else {
                }
                next$iv$iv = obj2;
                i3 = count$iv$iv2;
                count$iv$iv4 = count$iv$iv;
                count$iv$iv2.add(obj2);
                if (count$iv$iv2 != 0) {
                }
                node$iv$iv3 = 0;
                count$iv$iv2.add($i$f$getLocalsOLwlOKw);
                this_$iv$iv$iv = i13;
                $i$f$mutableVectorOf = 16;
                i5 = 0;
                count$iv$iv = count$iv$iv4;
                i7 = $i$f$mutableVectorOf;
                count$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv3 = obj2;
                next$iv$iv = obj2;
                this_$iv$iv$iv = 1;
            }
            i9 = 1;
            if (count$iv$iv4 == i9) {
            } else {
            }
            i10 = i9;
            count$iv$iv3 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            $i$f$getLocalsOLwlOKw = i4;
            obj3 = key;
            obj2 = node$iv$iv$iv;
            i8 = 0;
            i5 = 0;
            if (kindSet$ui_release3 &= i4 != 0) {
            } else {
            }
            this_$iv$iv$iv = 0;
            if (this_$iv$iv$iv != 0) {
            } else {
            }
            next$iv$iv = obj2;
            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
            obj3 = key;
            $i$f$getLocalsOLwlOKw = set;
            count$iv$iv4++;
            if (count$iv$iv4 == 1) {
            } else {
            }
            if (i3 == 0) {
            } else {
            }
            count$iv$iv = count$iv$iv4;
            capacity$iv$iv$iv$iv = 0;
            count$iv$iv2 = i3;
            $i$f$getLocalsOLwlOKw = node$iv$iv3;
            if ($i$f$getLocalsOLwlOKw != null && count$iv$iv2 != 0) {
            }
            if (count$iv$iv2 != 0) {
            } else {
            }
            next$iv$iv = obj2;
            i3 = count$iv$iv2;
            count$iv$iv4 = count$iv$iv;
            count$iv$iv2.add(obj2);
            if (count$iv$iv2 != 0) {
            }
            node$iv$iv3 = 0;
            count$iv$iv2.add($i$f$getLocalsOLwlOKw);
            this_$iv$iv$iv = i13;
            $i$f$mutableVectorOf = 16;
            i5 = 0;
            count$iv$iv = count$iv$iv4;
            i7 = $i$f$mutableVectorOf;
            count$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
            node$iv$iv3 = obj2;
            next$iv$iv = obj2;
            this_$iv$iv$iv = 1;
            count$iv$iv4 = 1;
            i = 0;
            $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv3;
            $this$visitSubtreeIf_u2d6rFNWt0$iv3 = i10;
            node$iv$iv$iv = 0;
            i4 = $i$f$getLocalsOLwlOKw;
            if ($this$visitSubtreeIf_u2d6rFNWt0$iv3 instanceof BackwardsCompatNode && element instanceof ModifierLocalConsumer) {
            } else {
            }
            $i$f$getLocalsOLwlOKw = set;
            if ($this$visitSubtreeIf_u2d6rFNWt0$iv3.getProvidedValues().contains$ui_release(obj3)) {
            } else {
            }
            i9 = 1;
            i2 = 1;
            count$iv$iv3 = 0;
            if (element instanceof ModifierLocalConsumer) {
            } else {
            }
            if ((BackwardsCompatNode)$this$visitSubtreeIf_u2d6rFNWt0$iv3.getReadValues().contains(obj3)) {
            } else {
            }
            $i$f$getLocalsOLwlOKw = set;
            set.add($this$visitSubtreeIf_u2d6rFNWt0$iv3);
        }
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final void insertedProvider(BackwardsCompatNode node, androidx.compose.ui.modifier.ModifierLocal<?> key) {
        int i = 0;
        this.inserted.add(node);
        int i2 = 0;
        this.insertedLocal.add(key);
        invalidate();
    }

    public final void invalidate() {
        boolean invalidated;
        androidx.compose.ui.modifier.ModifierLocalManager.invalidate.1 anon;
        if (!this.invalidated) {
            this.invalidated = true;
            anon = new ModifierLocalManager.invalidate.1(this);
            this.owner.registerOnEndApplyChangesListener((Function0)anon);
        }
    }

    public final void removedProvider(BackwardsCompatNode node, androidx.compose.ui.modifier.ModifierLocal<?> key) {
        final int i2 = 0;
        this.removed.add(DelegatableNodeKt.requireLayoutNode((DelegatableNode)node));
        int i = 0;
        this.removedLocal.add(key);
        invalidate();
    }

    public final void triggerUpdates() {
        int i$iv;
        Object[] content;
        Object obj;
        int i2;
        int i;
        Object this_$iv;
        boolean head$ui_release;
        Object[] content2;
        this.invalidated = false;
        HashSet hashSet = new HashSet();
        MutableVector removed = this.removed;
        int i4 = 0;
        int size = removed.getSize();
        if (size > 0) {
            i$iv = 0;
            obj = removed.getContent()[i$iv];
            i = 0;
            int i8 = 0;
            do {
                obj = content[i$iv];
                i = 0;
                i8 = 0;
                if (i$iv++ < size) {
                }
                invalidateConsumersOfNodeForKey(obj.getNodes$ui_release().getHead$ui_release(), (ModifierLocal)this.removedLocal.getContent()[i$iv], (Set)hashSet);
            } while ((LayoutNode)obj.getNodes$ui_release().getHead$ui_release().isAttached());
        }
        this.removed.clear();
        this.removedLocal.clear();
        MutableVector inserted = this.inserted;
        int i5 = 0;
        int size2 = inserted.getSize();
        if (size2 > 0) {
            i$iv = 0;
            obj = inserted.getContent()[i$iv];
            i = 0;
            int i7 = 0;
            do {
                obj = content[i$iv];
                i = 0;
                i7 = 0;
                if (i$iv++ < size2) {
                }
                invalidateConsumersOfNodeForKey((Modifier.Node)obj, (ModifierLocal)this.insertedLocal.getContent()[i$iv], (Set)hashSet);
            } while ((BackwardsCompatNode)obj.isAttached());
        }
        this.inserted.clear();
        this.insertedLocal.clear();
        int i6 = 0;
        Iterator iterator = (Iterable)hashSet.iterator();
        for (Object i$iv : iterator) {
            obj = null;
            (BackwardsCompatNode)i$iv.updateModifierLocalConsumer();
        }
    }

    public final void updatedProvider(BackwardsCompatNode node, androidx.compose.ui.modifier.ModifierLocal<?> key) {
        int i = 0;
        this.inserted.add(node);
        int i2 = 0;
        this.insertedLocal.add(key);
        invalidate();
    }
}
