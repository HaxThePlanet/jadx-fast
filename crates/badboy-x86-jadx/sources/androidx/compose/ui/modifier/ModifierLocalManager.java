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
        int i;
        int i8;
        int count$iv$iv2;
        int count$iv$iv3;
        int count$iv$iv4;
        int type$iv2;
        boolean type$iv;
        int node2;
        String str;
        int i2;
        Modifier.Node[] node$iv$iv2;
        int node$iv$iv;
        Object obj4;
        int i5;
        Object obj;
        int i6;
        int i10;
        Object node$iv$iv3;
        int i7;
        int $this$visitSubtreeIf_u2d6rFNWt0$iv;
        int node$iv$iv$iv;
        int i3;
        Object obj2;
        int i11;
        int this_$iv$iv$iv;
        int i9;
        int count$iv$iv;
        int i4;
        obj3 = key;
        int i14 = 0;
        int i16 = 0;
        final int i17 = type$iv2;
        final int i18 = count$iv$iv2;
        final int i19 = 0;
        int i20 = 0;
        if (!i18.getNode().isAttached()) {
            int i22 = 0;
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        int value$iv$iv$iv = 0;
        i2 = 0;
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = i18.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, i18.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            node2 = mutableVector.removeAt(size -= i2);
            if (aggregateChildKindSet$ui_release &= i17 != 0) {
            } else {
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv2;
            i3 = type$iv2;
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node2);
            obj3 = key;
            count$iv$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            type$iv2 = i3;
            node$iv$iv = 0;
            node$iv$iv2 = node2;
            while (node$iv$iv2 != null) {
                if (kindSet$ui_release &= i17 == 0) {
                    break loop_8;
                } else {
                }
                $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv2;
                i3 = type$iv2;
                i8 = i2;
                node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                i2 = i8;
                count$iv$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                type$iv2 = i3;
                node$iv$iv = 0;
                obj3 = key;
                i5 = 0;
                i6 = 0;
                i10 = 0;
                int i23 = 0;
                node$iv$iv = node$iv$iv3;
                while (node$iv$iv != null) {
                    i3 = type$iv2;
                    type$iv2 = set;
                    i2 = 0;
                    if (kindSet$ui_release2 &= i3 != 0) {
                    } else {
                    }
                    count$iv$iv3 = 0;
                    if (count$iv$iv3 != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    i = 1;
                    node$iv$iv = DelegatableNodeKt.access$pop(i10);
                    i2 = i;
                    count$iv$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                    type$iv2 = i3;
                    obj3 = key;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv3 = 0;
                    i7 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        obj2 = node$iv$iv$iv;
                        i11 = 0;
                        i9 = 0;
                        if (kindSet$ui_release3 &= i3 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = obj2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        obj3 = key;
                        type$iv2 = set;
                        count$iv$iv3++;
                        if (count$iv$iv3 == 1) {
                        } else {
                        }
                        if (i10 == 0) {
                        } else {
                        }
                        count$iv$iv = count$iv$iv3;
                        capacity$iv$iv$iv$iv = 0;
                        count$iv$iv4 = i10;
                        type$iv2 = node$iv$iv;
                        if (type$iv2 != null && count$iv$iv4 != 0) {
                        }
                        if (count$iv$iv4 != 0) {
                        } else {
                        }
                        next$iv$iv = obj2;
                        i10 = count$iv$iv4;
                        count$iv$iv3 = count$iv$iv;
                        count$iv$iv4.add(obj2);
                        if (count$iv$iv4 != 0) {
                        }
                        node$iv$iv = 0;
                        count$iv$iv4.add(type$iv2);
                        this_$iv$iv$iv = i13;
                        int $i$f$mutableVectorOf = 16;
                        i9 = 0;
                        count$iv$iv = count$iv$iv3;
                        i4 = $i$f$mutableVectorOf;
                        count$iv$iv4 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv = obj2;
                        next$iv$iv = obj2;
                        this_$iv$iv$iv = 1;
                    }
                    i = 1;
                    if (count$iv$iv3 == i) {
                    } else {
                    }
                    i2 = i;
                    count$iv$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                    type$iv2 = i3;
                    obj3 = key;
                    obj2 = node$iv$iv$iv;
                    i11 = 0;
                    i9 = 0;
                    if (kindSet$ui_release3 &= i3 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = obj2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    obj3 = key;
                    type$iv2 = set;
                    count$iv$iv3++;
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    if (i10 == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv3;
                    capacity$iv$iv$iv$iv = 0;
                    count$iv$iv4 = i10;
                    type$iv2 = node$iv$iv;
                    if (type$iv2 != null && count$iv$iv4 != 0) {
                    }
                    if (count$iv$iv4 != 0) {
                    } else {
                    }
                    next$iv$iv = obj2;
                    i10 = count$iv$iv4;
                    count$iv$iv3 = count$iv$iv;
                    count$iv$iv4.add(obj2);
                    if (count$iv$iv4 != 0) {
                    }
                    node$iv$iv = 0;
                    count$iv$iv4.add(type$iv2);
                    this_$iv$iv$iv = i13;
                    $i$f$mutableVectorOf = 16;
                    i9 = 0;
                    count$iv$iv = count$iv$iv3;
                    i4 = $i$f$mutableVectorOf;
                    count$iv$iv4 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv = obj2;
                    next$iv$iv = obj2;
                    this_$iv$iv$iv = 1;
                    count$iv$iv3 = 1;
                    i7 = 0;
                    $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv2;
                    Object $this$visitSubtreeIf_u2d6rFNWt0$iv3 = i2;
                    node$iv$iv$iv = 0;
                    i3 = type$iv2;
                    if ($this$visitSubtreeIf_u2d6rFNWt0$iv3 instanceof BackwardsCompatNode && element instanceof ModifierLocalConsumer) {
                    } else {
                    }
                    type$iv2 = set;
                    i = 1;
                    if (element instanceof ModifierLocalConsumer) {
                    } else {
                    }
                    if ((BackwardsCompatNode)$this$visitSubtreeIf_u2d6rFNWt0$iv3.getReadValues().contains(obj3)) {
                    } else {
                    }
                    type$iv2 = set;
                    set.add($this$visitSubtreeIf_u2d6rFNWt0$iv3);
                }
                $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv2;
                i3 = type$iv2;
                count$iv$iv2 = i8;
                if (node$iv$iv instanceof ModifierLocalModifierNode) {
                } else {
                }
                i3 = type$iv2;
                type$iv2 = set;
                i2 = 0;
                if (kindSet$ui_release2 &= i3 != 0) {
                } else {
                }
                count$iv$iv3 = 0;
                if (count$iv$iv3 != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                i = 1;
                node$iv$iv = DelegatableNodeKt.access$pop(i10);
                i2 = i;
                count$iv$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                type$iv2 = i3;
                obj3 = key;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv3 = 0;
                i7 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    obj2 = node$iv$iv$iv;
                    i11 = 0;
                    i9 = 0;
                    if (kindSet$ui_release3 &= i3 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = obj2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    obj3 = key;
                    type$iv2 = set;
                    count$iv$iv3++;
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    if (i10 == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv3;
                    capacity$iv$iv$iv$iv = 0;
                    count$iv$iv4 = i10;
                    type$iv2 = node$iv$iv;
                    if (type$iv2 != null && count$iv$iv4 != 0) {
                    }
                    if (count$iv$iv4 != 0) {
                    } else {
                    }
                    next$iv$iv = obj2;
                    i10 = count$iv$iv4;
                    count$iv$iv3 = count$iv$iv;
                    count$iv$iv4.add(obj2);
                    if (count$iv$iv4 != 0) {
                    }
                    node$iv$iv = 0;
                    count$iv$iv4.add(type$iv2);
                    this_$iv$iv$iv = i13;
                    $i$f$mutableVectorOf = 16;
                    i9 = 0;
                    count$iv$iv = count$iv$iv3;
                    i4 = $i$f$mutableVectorOf;
                    count$iv$iv4 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv = obj2;
                    next$iv$iv = obj2;
                    this_$iv$iv$iv = 1;
                }
                i = 1;
                if (count$iv$iv3 == i) {
                } else {
                }
                i2 = i;
                count$iv$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                type$iv2 = i3;
                obj3 = key;
                obj2 = node$iv$iv$iv;
                i11 = 0;
                i9 = 0;
                if (kindSet$ui_release3 &= i3 != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                next$iv$iv = obj2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                obj3 = key;
                type$iv2 = set;
                count$iv$iv3++;
                if (count$iv$iv3 == 1) {
                } else {
                }
                if (i10 == 0) {
                } else {
                }
                count$iv$iv = count$iv$iv3;
                capacity$iv$iv$iv$iv = 0;
                count$iv$iv4 = i10;
                type$iv2 = node$iv$iv;
                if (type$iv2 != null && count$iv$iv4 != 0) {
                }
                if (count$iv$iv4 != 0) {
                } else {
                }
                next$iv$iv = obj2;
                i10 = count$iv$iv4;
                count$iv$iv3 = count$iv$iv;
                count$iv$iv4.add(obj2);
                if (count$iv$iv4 != 0) {
                }
                node$iv$iv = 0;
                count$iv$iv4.add(type$iv2);
                this_$iv$iv$iv = i13;
                $i$f$mutableVectorOf = 16;
                i9 = 0;
                count$iv$iv = count$iv$iv3;
                i4 = $i$f$mutableVectorOf;
                count$iv$iv4 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv = obj2;
                next$iv$iv = obj2;
                this_$iv$iv$iv = 1;
                count$iv$iv3 = 1;
                i7 = 0;
                $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv2;
                $this$visitSubtreeIf_u2d6rFNWt0$iv3 = i2;
                node$iv$iv$iv = 0;
                i3 = type$iv2;
                if ($this$visitSubtreeIf_u2d6rFNWt0$iv3 instanceof BackwardsCompatNode && element instanceof ModifierLocalConsumer) {
                } else {
                }
                type$iv2 = set;
                if ($this$visitSubtreeIf_u2d6rFNWt0$iv3.getProvidedValues().contains$ui_release(obj3)) {
                } else {
                }
                i = 1;
                i8 = 1;
                count$iv$iv2 = 0;
                if (element instanceof ModifierLocalConsumer) {
                } else {
                }
                if ((BackwardsCompatNode)$this$visitSubtreeIf_u2d6rFNWt0$iv3.getReadValues().contains(obj3)) {
                } else {
                }
                type$iv2 = set;
                set.add($this$visitSubtreeIf_u2d6rFNWt0$iv3);
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv2;
            i3 = type$iv2;
            if (kindSet$ui_release &= i17 != 0) {
            } else {
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv2;
            i3 = type$iv2;
            i8 = i2;
            node$iv$iv2 = node$iv$iv2.getChild$ui_release();
            i2 = i8;
            count$iv$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            type$iv2 = i3;
            node$iv$iv = 0;
            obj3 = key;
            i5 = 0;
            i6 = 0;
            i10 = 0;
            i23 = 0;
            node$iv$iv = node$iv$iv3;
            while (node$iv$iv != null) {
                i3 = type$iv2;
                type$iv2 = set;
                i2 = 0;
                if (kindSet$ui_release2 &= i3 != 0) {
                } else {
                }
                count$iv$iv3 = 0;
                if (count$iv$iv3 != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                i = 1;
                node$iv$iv = DelegatableNodeKt.access$pop(i10);
                i2 = i;
                count$iv$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                type$iv2 = i3;
                obj3 = key;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv3 = 0;
                i7 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    obj2 = node$iv$iv$iv;
                    i11 = 0;
                    i9 = 0;
                    if (kindSet$ui_release3 &= i3 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = obj2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    obj3 = key;
                    type$iv2 = set;
                    count$iv$iv3++;
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    if (i10 == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv3;
                    capacity$iv$iv$iv$iv = 0;
                    count$iv$iv4 = i10;
                    type$iv2 = node$iv$iv;
                    if (type$iv2 != null && count$iv$iv4 != 0) {
                    }
                    if (count$iv$iv4 != 0) {
                    } else {
                    }
                    next$iv$iv = obj2;
                    i10 = count$iv$iv4;
                    count$iv$iv3 = count$iv$iv;
                    count$iv$iv4.add(obj2);
                    if (count$iv$iv4 != 0) {
                    }
                    node$iv$iv = 0;
                    count$iv$iv4.add(type$iv2);
                    this_$iv$iv$iv = i13;
                    $i$f$mutableVectorOf = 16;
                    i9 = 0;
                    count$iv$iv = count$iv$iv3;
                    i4 = $i$f$mutableVectorOf;
                    count$iv$iv4 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv = obj2;
                    next$iv$iv = obj2;
                    this_$iv$iv$iv = 1;
                }
                i = 1;
                if (count$iv$iv3 == i) {
                } else {
                }
                i2 = i;
                count$iv$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                type$iv2 = i3;
                obj3 = key;
                obj2 = node$iv$iv$iv;
                i11 = 0;
                i9 = 0;
                if (kindSet$ui_release3 &= i3 != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                next$iv$iv = obj2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                obj3 = key;
                type$iv2 = set;
                count$iv$iv3++;
                if (count$iv$iv3 == 1) {
                } else {
                }
                if (i10 == 0) {
                } else {
                }
                count$iv$iv = count$iv$iv3;
                capacity$iv$iv$iv$iv = 0;
                count$iv$iv4 = i10;
                type$iv2 = node$iv$iv;
                if (type$iv2 != null && count$iv$iv4 != 0) {
                }
                if (count$iv$iv4 != 0) {
                } else {
                }
                next$iv$iv = obj2;
                i10 = count$iv$iv4;
                count$iv$iv3 = count$iv$iv;
                count$iv$iv4.add(obj2);
                if (count$iv$iv4 != 0) {
                }
                node$iv$iv = 0;
                count$iv$iv4.add(type$iv2);
                this_$iv$iv$iv = i13;
                $i$f$mutableVectorOf = 16;
                i9 = 0;
                count$iv$iv = count$iv$iv3;
                i4 = $i$f$mutableVectorOf;
                count$iv$iv4 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv = obj2;
                next$iv$iv = obj2;
                this_$iv$iv$iv = 1;
                count$iv$iv3 = 1;
                i7 = 0;
                $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv2;
                $this$visitSubtreeIf_u2d6rFNWt0$iv3 = i2;
                node$iv$iv$iv = 0;
                i3 = type$iv2;
                if ($this$visitSubtreeIf_u2d6rFNWt0$iv3 instanceof BackwardsCompatNode && element instanceof ModifierLocalConsumer) {
                } else {
                }
                type$iv2 = set;
                i = 1;
                if (element instanceof ModifierLocalConsumer) {
                } else {
                }
                if ((BackwardsCompatNode)$this$visitSubtreeIf_u2d6rFNWt0$iv3.getReadValues().contains(obj3)) {
                } else {
                }
                type$iv2 = set;
                set.add($this$visitSubtreeIf_u2d6rFNWt0$iv3);
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv2;
            i3 = type$iv2;
            count$iv$iv2 = i8;
            if (count$iv$iv2 != 0) {
            } else {
            }
            obj3 = key;
            count$iv$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            type$iv2 = i3;
            node$iv$iv = 0;
            if (node$iv$iv instanceof ModifierLocalModifierNode) {
            } else {
            }
            i3 = type$iv2;
            type$iv2 = set;
            i2 = 0;
            if (kindSet$ui_release2 &= i3 != 0) {
            } else {
            }
            count$iv$iv3 = 0;
            if (count$iv$iv3 != 0 && node$iv$iv instanceof DelegatingNode) {
            } else {
            }
            i = 1;
            node$iv$iv = DelegatableNodeKt.access$pop(i10);
            i2 = i;
            count$iv$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            type$iv2 = i3;
            obj3 = key;
            if (node$iv$iv instanceof DelegatingNode) {
            } else {
            }
            count$iv$iv3 = 0;
            i7 = 0;
            node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
            while (node$iv$iv$iv != null) {
                obj2 = node$iv$iv$iv;
                i11 = 0;
                i9 = 0;
                if (kindSet$ui_release3 &= i3 != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                next$iv$iv = obj2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                obj3 = key;
                type$iv2 = set;
                count$iv$iv3++;
                if (count$iv$iv3 == 1) {
                } else {
                }
                if (i10 == 0) {
                } else {
                }
                count$iv$iv = count$iv$iv3;
                capacity$iv$iv$iv$iv = 0;
                count$iv$iv4 = i10;
                type$iv2 = node$iv$iv;
                if (type$iv2 != null && count$iv$iv4 != 0) {
                }
                if (count$iv$iv4 != 0) {
                } else {
                }
                next$iv$iv = obj2;
                i10 = count$iv$iv4;
                count$iv$iv3 = count$iv$iv;
                count$iv$iv4.add(obj2);
                if (count$iv$iv4 != 0) {
                }
                node$iv$iv = 0;
                count$iv$iv4.add(type$iv2);
                this_$iv$iv$iv = i13;
                $i$f$mutableVectorOf = 16;
                i9 = 0;
                count$iv$iv = count$iv$iv3;
                i4 = $i$f$mutableVectorOf;
                count$iv$iv4 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv = obj2;
                next$iv$iv = obj2;
                this_$iv$iv$iv = 1;
            }
            i = 1;
            if (count$iv$iv3 == i) {
            } else {
            }
            i2 = i;
            count$iv$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            type$iv2 = i3;
            obj3 = key;
            obj2 = node$iv$iv$iv;
            i11 = 0;
            i9 = 0;
            if (kindSet$ui_release3 &= i3 != 0) {
            } else {
            }
            this_$iv$iv$iv = 0;
            if (this_$iv$iv$iv != 0) {
            } else {
            }
            next$iv$iv = obj2;
            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
            obj3 = key;
            type$iv2 = set;
            count$iv$iv3++;
            if (count$iv$iv3 == 1) {
            } else {
            }
            if (i10 == 0) {
            } else {
            }
            count$iv$iv = count$iv$iv3;
            capacity$iv$iv$iv$iv = 0;
            count$iv$iv4 = i10;
            type$iv2 = node$iv$iv;
            if (type$iv2 != null && count$iv$iv4 != 0) {
            }
            if (count$iv$iv4 != 0) {
            } else {
            }
            next$iv$iv = obj2;
            i10 = count$iv$iv4;
            count$iv$iv3 = count$iv$iv;
            count$iv$iv4.add(obj2);
            if (count$iv$iv4 != 0) {
            }
            node$iv$iv = 0;
            count$iv$iv4.add(type$iv2);
            this_$iv$iv$iv = i13;
            $i$f$mutableVectorOf = 16;
            i9 = 0;
            count$iv$iv = count$iv$iv3;
            i4 = $i$f$mutableVectorOf;
            count$iv$iv4 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
            node$iv$iv = obj2;
            next$iv$iv = obj2;
            this_$iv$iv$iv = 1;
            count$iv$iv3 = 1;
            i7 = 0;
            $this$visitSubtreeIf_u2d6rFNWt0$iv = count$iv$iv2;
            $this$visitSubtreeIf_u2d6rFNWt0$iv3 = i2;
            node$iv$iv$iv = 0;
            i3 = type$iv2;
            if ($this$visitSubtreeIf_u2d6rFNWt0$iv3 instanceof BackwardsCompatNode && element instanceof ModifierLocalConsumer) {
            } else {
            }
            type$iv2 = set;
            if ($this$visitSubtreeIf_u2d6rFNWt0$iv3.getProvidedValues().contains$ui_release(obj3)) {
            } else {
            }
            i = 1;
            i8 = 1;
            count$iv$iv2 = 0;
            if (element instanceof ModifierLocalConsumer) {
            } else {
            }
            if ((BackwardsCompatNode)$this$visitSubtreeIf_u2d6rFNWt0$iv3.getReadValues().contains(obj3)) {
            } else {
            }
            type$iv2 = set;
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
