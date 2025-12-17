package androidx.compose.ui.viewinterop;

import android.view.FocusFinder;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusDirection.Companion;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequester.Companion;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTransactionManager;
import androidx.compose.ui.focus.FocusTransactionsKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J\u0008\u0010\u0012\u001a\u00020\rH\u0016J\u0008\u0010\u0013\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u0019J\u001c\u0010\u001c\u001a\u00020\r2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0007H\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0007H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\"", d2 = {"Landroidx/compose/ui/viewinterop/FocusGroupPropertiesNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "Landroid/view/View$OnAttachStateChangeListener;", "()V", "focusedChild", "Landroid/view/View;", "getFocusedChild", "()Landroid/view/View;", "setFocusedChild", "(Landroid/view/View;)V", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "getFocusTargetOfEmbeddedViewWrapper", "Landroidx/compose/ui/focus/FocusTargetNode;", "onAttach", "onDetach", "onEnter", "Landroidx/compose/ui/focus/FocusRequester;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "onEnter-3ESFkO8", "(I)Landroidx/compose/ui/focus/FocusRequester;", "onExit", "onExit-3ESFkO8", "onGlobalFocusChanged", "oldFocus", "newFocus", "onViewAttachedToWindow", "v", "onViewDetachedFromWindow", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FocusGroupPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode, ViewTreeObserver.OnGlobalFocusChangeListener, View.OnAttachStateChangeListener {

    private View focusedChild;
    private final FocusTargetNode getFocusTargetOfEmbeddedViewWrapper() {
        int count$iv$iv3;
        int count$iv$iv;
        Modifier.Node node3;
        int $this$visitLocalDescendants_u2d6rFNWt0$iv2;
        int type$iv2;
        Modifier.Node type$iv;
        int i14;
        int i11;
        int i4;
        int i2;
        int node$iv$iv;
        Modifier.Node next$iv$iv$iv;
        String str;
        int i8;
        Modifier.Node node;
        int i3;
        int i9;
        Modifier.Node node$iv$iv2;
        int foundFocusTargetOfFocusGroup;
        int i7;
        Modifier.Node node4;
        int i6;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i16;
        int $this$visitLocalDescendants_u2d6rFNWt0$iv;
        int this_$iv$iv$iv;
        int $this$visitLocalDescendants_u2d6rFNWt0$iv3;
        int count$iv$iv2;
        int i10;
        int i;
        int i5;
        int i12;
        int i15;
        int i13;
        count$iv$iv3 = 0;
        $this$visitLocalDescendants_u2d6rFNWt0$iv2 = this;
        int i18 = 0;
        type$iv2 = NodeKind.constructor-impl(1024);
        final int i20 = type$iv2;
        final int i22 = 0;
        final int i23 = i21;
        final int i24 = node$iv$iv;
        final int i25 = 0;
        int i26 = 0;
        if (!i23.getNode().isAttached()) {
            int i27 = 0;
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node8 = i23.getNode();
        if (aggregateChildKindSet$ui_release &= i20 != 0) {
            next$iv$iv$iv = node8.getChild$ui_release();
            while (next$iv$iv$iv != null) {
                if (kindSet$ui_release &= i20 != 0) {
                } else {
                }
                $this$visitLocalDescendants_u2d6rFNWt0$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                i5 = type$iv2;
                i15 = i14;
                i2 = node$iv$iv;
                next$iv$iv$iv = next$iv$iv$iv.getChild$ui_release();
                node$iv$iv = i2;
                $this$visitLocalDescendants_u2d6rFNWt0$iv2 = $this$visitLocalDescendants_u2d6rFNWt0$iv;
                type$iv2 = i5;
                i14 = i15;
                i8 = 0;
                i3 = 0;
                i9 = 0;
                int i28 = 0;
                node$iv$iv = node$iv$iv2;
                while (node$iv$iv != null) {
                    foundFocusTargetOfFocusGroup = count$iv$iv3;
                    node3 = node$iv$iv;
                    int i29 = 0;
                    i6 = node3;
                    if (kindSet$ui_release2 &= type$iv2 != 0) {
                    } else {
                    }
                    i7 = 0;
                    if (i7 != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    $this$visitLocalDescendants_u2d6rFNWt0$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                    i5 = type$iv2;
                    i15 = i14;
                    i4 = 0;
                    count$iv$iv3 = foundFocusTargetOfFocusGroup;
                    node$iv$iv = DelegatableNodeKt.access$pop(i9);
                    $this$visitLocalDescendants_u2d6rFNWt0$iv2 = $this$visitLocalDescendants_u2d6rFNWt0$iv;
                    type$iv2 = i5;
                    i14 = i15;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    i6 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i16 = 0;
                        count$iv$iv2 = 0;
                        if (kindSet$ui_release3 &= type$iv2 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$visitLocalDescendants_u2d6rFNWt0$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                        i5 = type$iv2;
                        i15 = i14;
                        type$iv = node2;
                        i11 = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $this$visitLocalDescendants_u2d6rFNWt0$iv2 = $this$visitLocalDescendants_u2d6rFNWt0$iv;
                        type$iv2 = i5;
                        i14 = i15;
                        count$iv$iv++;
                        $this$visitLocalDescendants_u2d6rFNWt0$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (i9 == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv;
                        i5 = type$iv2;
                        i15 = i14;
                        i11 = 0;
                        $this$visitLocalDescendants_u2d6rFNWt0$iv2 = i9;
                        Modifier.Node node6 = node$iv$iv;
                        if (node6 != null && $this$visitLocalDescendants_u2d6rFNWt0$iv2 != 0) {
                        }
                        if ($this$visitLocalDescendants_u2d6rFNWt0$iv2 != 0) {
                        } else {
                        }
                        type$iv = node2;
                        i9 = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                        count$iv$iv = count$iv$iv2;
                        $this$visitLocalDescendants_u2d6rFNWt0$iv2.add(node2);
                        if ($this$visitLocalDescendants_u2d6rFNWt0$iv2 != 0) {
                        }
                        node$iv$iv = type$iv2;
                        $this$visitLocalDescendants_u2d6rFNWt0$iv2.add(node6);
                        count$iv$iv2 = count$iv$iv;
                        i10 = 0;
                        i = i17;
                        i5 = type$iv2;
                        i15 = i14;
                        $this$visitLocalDescendants_u2d6rFNWt0$iv2 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv = node2;
                        i5 = type$iv2;
                        i15 = i14;
                        type$iv = node2;
                        i11 = 0;
                        this_$iv$iv$iv = 1;
                    }
                    i4 = 0;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    count$iv$iv3 = foundFocusTargetOfFocusGroup;
                    count$iv$iv3 = foundFocusTargetOfFocusGroup;
                    $this$visitLocalDescendants_u2d6rFNWt0$iv2 = $this$visitLocalDescendants_u2d6rFNWt0$iv;
                    type$iv2 = i5;
                    i14 = i15;
                    node2 = node$iv$iv$iv;
                    i16 = 0;
                    count$iv$iv2 = 0;
                    if (kindSet$ui_release3 &= type$iv2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$visitLocalDescendants_u2d6rFNWt0$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                    i5 = type$iv2;
                    i15 = i14;
                    type$iv = node2;
                    i11 = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitLocalDescendants_u2d6rFNWt0$iv2 = $this$visitLocalDescendants_u2d6rFNWt0$iv;
                    type$iv2 = i5;
                    i14 = i15;
                    count$iv$iv++;
                    $this$visitLocalDescendants_u2d6rFNWt0$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (i9 == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv;
                    i5 = type$iv2;
                    i15 = i14;
                    i11 = 0;
                    $this$visitLocalDescendants_u2d6rFNWt0$iv2 = i9;
                    node6 = node$iv$iv;
                    if (node6 != null && $this$visitLocalDescendants_u2d6rFNWt0$iv2 != 0) {
                    }
                    if ($this$visitLocalDescendants_u2d6rFNWt0$iv2 != 0) {
                    } else {
                    }
                    type$iv = node2;
                    i9 = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                    count$iv$iv = count$iv$iv2;
                    $this$visitLocalDescendants_u2d6rFNWt0$iv2.add(node2);
                    if ($this$visitLocalDescendants_u2d6rFNWt0$iv2 != 0) {
                    }
                    node$iv$iv = type$iv2;
                    $this$visitLocalDescendants_u2d6rFNWt0$iv2.add(node6);
                    count$iv$iv2 = count$iv$iv;
                    i10 = 0;
                    i = i17;
                    i5 = type$iv2;
                    i15 = i14;
                    $this$visitLocalDescendants_u2d6rFNWt0$iv2 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = node2;
                    i5 = type$iv2;
                    i15 = i14;
                    type$iv = node2;
                    i11 = 0;
                    this_$iv$iv$iv = 1;
                    i7 = 1;
                    i7 = 0;
                    $this$visitLocalDescendants_u2d6rFNWt0$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                    i5 = type$iv2;
                    i15 = i14;
                    count$iv$iv3 = foundFocusTargetOfFocusGroup;
                    i4 = 0;
                }
                foundFocusTargetOfFocusGroup = count$iv$iv3;
                $this$visitLocalDescendants_u2d6rFNWt0$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                i5 = type$iv2;
                i15 = i14;
                i2 = 0;
                foundFocusTargetOfFocusGroup = count$iv$iv3;
                node3 = node$iv$iv;
                i29 = 0;
                i6 = node3;
                if (kindSet$ui_release2 &= type$iv2 != 0) {
                } else {
                }
                i7 = 0;
                if (i7 != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                $this$visitLocalDescendants_u2d6rFNWt0$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                i5 = type$iv2;
                i15 = i14;
                i4 = 0;
                count$iv$iv3 = foundFocusTargetOfFocusGroup;
                node$iv$iv = DelegatableNodeKt.access$pop(i9);
                $this$visitLocalDescendants_u2d6rFNWt0$iv2 = $this$visitLocalDescendants_u2d6rFNWt0$iv;
                type$iv2 = i5;
                i14 = i15;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                i6 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node2 = node$iv$iv$iv;
                    i16 = 0;
                    count$iv$iv2 = 0;
                    if (kindSet$ui_release3 &= type$iv2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$visitLocalDescendants_u2d6rFNWt0$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                    i5 = type$iv2;
                    i15 = i14;
                    type$iv = node2;
                    i11 = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitLocalDescendants_u2d6rFNWt0$iv2 = $this$visitLocalDescendants_u2d6rFNWt0$iv;
                    type$iv2 = i5;
                    i14 = i15;
                    count$iv$iv++;
                    $this$visitLocalDescendants_u2d6rFNWt0$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (i9 == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv;
                    i5 = type$iv2;
                    i15 = i14;
                    i11 = 0;
                    $this$visitLocalDescendants_u2d6rFNWt0$iv2 = i9;
                    node6 = node$iv$iv;
                    if (node6 != null && $this$visitLocalDescendants_u2d6rFNWt0$iv2 != 0) {
                    }
                    if ($this$visitLocalDescendants_u2d6rFNWt0$iv2 != 0) {
                    } else {
                    }
                    type$iv = node2;
                    i9 = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                    count$iv$iv = count$iv$iv2;
                    $this$visitLocalDescendants_u2d6rFNWt0$iv2.add(node2);
                    if ($this$visitLocalDescendants_u2d6rFNWt0$iv2 != 0) {
                    }
                    node$iv$iv = type$iv2;
                    $this$visitLocalDescendants_u2d6rFNWt0$iv2.add(node6);
                    count$iv$iv2 = count$iv$iv;
                    i10 = 0;
                    i = i17;
                    i5 = type$iv2;
                    i15 = i14;
                    $this$visitLocalDescendants_u2d6rFNWt0$iv2 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = node2;
                    i5 = type$iv2;
                    i15 = i14;
                    type$iv = node2;
                    i11 = 0;
                    this_$iv$iv$iv = 1;
                }
                i4 = 0;
                if (count$iv$iv == 1) {
                } else {
                }
                count$iv$iv3 = foundFocusTargetOfFocusGroup;
                count$iv$iv3 = foundFocusTargetOfFocusGroup;
                $this$visitLocalDescendants_u2d6rFNWt0$iv2 = $this$visitLocalDescendants_u2d6rFNWt0$iv;
                type$iv2 = i5;
                i14 = i15;
                node2 = node$iv$iv$iv;
                i16 = 0;
                count$iv$iv2 = 0;
                if (kindSet$ui_release3 &= type$iv2 != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                $this$visitLocalDescendants_u2d6rFNWt0$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                i5 = type$iv2;
                i15 = i14;
                type$iv = node2;
                i11 = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $this$visitLocalDescendants_u2d6rFNWt0$iv2 = $this$visitLocalDescendants_u2d6rFNWt0$iv;
                type$iv2 = i5;
                i14 = i15;
                count$iv$iv++;
                $this$visitLocalDescendants_u2d6rFNWt0$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                if (count$iv$iv == 1) {
                } else {
                }
                if (i9 == 0) {
                } else {
                }
                count$iv$iv2 = count$iv$iv;
                i5 = type$iv2;
                i15 = i14;
                i11 = 0;
                $this$visitLocalDescendants_u2d6rFNWt0$iv2 = i9;
                node6 = node$iv$iv;
                if (node6 != null && $this$visitLocalDescendants_u2d6rFNWt0$iv2 != 0) {
                }
                if ($this$visitLocalDescendants_u2d6rFNWt0$iv2 != 0) {
                } else {
                }
                type$iv = node2;
                i9 = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                count$iv$iv = count$iv$iv2;
                $this$visitLocalDescendants_u2d6rFNWt0$iv2.add(node2);
                if ($this$visitLocalDescendants_u2d6rFNWt0$iv2 != 0) {
                }
                node$iv$iv = type$iv2;
                $this$visitLocalDescendants_u2d6rFNWt0$iv2.add(node6);
                count$iv$iv2 = count$iv$iv;
                i10 = 0;
                i = i17;
                i5 = type$iv2;
                i15 = i14;
                $this$visitLocalDescendants_u2d6rFNWt0$iv2 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv = node2;
                i5 = type$iv2;
                i15 = i14;
                type$iv = node2;
                i11 = 0;
                this_$iv$iv$iv = 1;
                i7 = 1;
                i7 = 0;
                $this$visitLocalDescendants_u2d6rFNWt0$iv = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
                i5 = type$iv2;
                i15 = i14;
                count$iv$iv3 = foundFocusTargetOfFocusGroup;
                i4 = 0;
            }
            $this$visitLocalDescendants_u2d6rFNWt0$iv3 = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
            i12 = type$iv2;
            i13 = i14;
        } else {
            $this$visitLocalDescendants_u2d6rFNWt0$iv3 = $this$visitLocalDescendants_u2d6rFNWt0$iv2;
            i12 = type$iv2;
            i13 = i14;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Could not find focus target of embedded view wrapper".toString());
        throw illegalStateException;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
        FocusGroupPropertiesNode.applyFocusProperties.1 anon = new FocusGroupPropertiesNode.applyFocusProperties.1(this);
        focusProperties.setEnter((Function1)anon);
        FocusGroupPropertiesNode.applyFocusProperties.2 anon2 = new FocusGroupPropertiesNode.applyFocusProperties.2(this);
        focusProperties.setExit((Function1)anon2);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final View getFocusedChild() {
        return this.focusedChild;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onAttach() {
        super.onAttach();
        FocusGroupNode_androidKt.access$getView((Modifier.Node)this).addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        FocusGroupNode_androidKt.access$getView((Modifier.Node)this).removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        this.focusedChild = 0;
        super.onDetach();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final FocusRequester onEnter-3ESFkO8(int focusDirection) {
        boolean focused;
        FocusRequester default;
        View view = FocusGroupNode_androidKt.access$getView((Modifier.Node)this);
        if (!view.isFocused()) {
            if (view.hasFocus()) {
            } else {
                Owner requireOwner2 = DelegatableNodeKt.requireOwner((DelegatableNode)this);
                Intrinsics.checkNotNull(requireOwner2, "null cannot be cast to non-null type android.view.View");
                FocusRequester.Companion companion = FocusRequester.Companion;
                if (FocusInteropUtils_androidKt.requestInteropFocus(view, FocusInteropUtils_androidKt.toAndroidFocusDirection-3ESFkO8(focusDirection), FocusGroupNode_androidKt.access$getCurrentlyFocusedRect(DelegatableNodeKt.requireOwner((DelegatableNode)this).getFocusOwner(), (View)requireOwner2, view))) {
                    default = companion.getDefault();
                } else {
                    default = companion.getCancel();
                }
            }
            return default;
        }
        return FocusRequester.Companion.getDefault();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final FocusRequester onExit-3ESFkO8(int focusDirection) {
        int intValue;
        FocusFinder instance;
        View nextFocusFromRect;
        View focusedChild;
        View view = FocusGroupNode_androidKt.access$getView((Modifier.Node)this);
        if (!view.hasFocus()) {
            return FocusRequester.Companion.getDefault();
        }
        Owner requireOwner2 = DelegatableNodeKt.requireOwner((DelegatableNode)this);
        Intrinsics.checkNotNull(requireOwner2, "null cannot be cast to non-null type android.view.View");
        String str2 = "host view did not take focus";
        if (!view instanceof ViewGroup) {
            if (!(View)requireOwner2.requestFocus()) {
            } else {
                return FocusRequester.Companion.getDefault();
            }
            int i = 0;
            IllegalStateException illegalStateException = new IllegalStateException(str2.toString());
            throw illegalStateException;
        }
        android.graphics.Rect rect = FocusGroupNode_androidKt.access$getCurrentlyFocusedRect(DelegatableNodeKt.requireOwner((DelegatableNode)this).getFocusOwner(), requireOwner2, view);
        Integer androidFocusDirection-3ESFkO8 = FocusInteropUtils_androidKt.toAndroidFocusDirection-3ESFkO8(focusDirection);
        if (androidFocusDirection-3ESFkO8 != null) {
            intValue = androidFocusDirection-3ESFkO8.intValue();
        } else {
            intValue = 130;
        }
        instance = FocusFinder.getInstance();
        final int i3 = 0;
        if (this.focusedChild != null) {
            nextFocusFromRect = instance.findNextFocus((ViewGroup)requireOwner2, this.focusedChild, intValue);
        } else {
            nextFocusFromRect = instance.findNextFocusFromRect((ViewGroup)requireOwner2, rect, intValue);
        }
        if (nextFocusFromRect != null && FocusGroupNode_androidKt.access$containsDescendant(view, nextFocusFromRect)) {
            if (FocusGroupNode_androidKt.access$containsDescendant(view, nextFocusFromRect)) {
                nextFocusFromRect.requestFocus(intValue, rect);
                return FocusRequester.Companion.getCancel();
            }
        }
        if (!requireOwner2.requestFocus()) {
        } else {
            return FocusRequester.Companion.getDefault();
        }
        int i2 = 0;
        IllegalStateException illegalStateException2 = new IllegalStateException(str2.toString());
        throw illegalStateException2;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        int focusTargetOfEmbeddedViewWrapper;
        int focusTransactionManager;
        boolean equal;
        int i;
        boolean equal2;
        int i2;
        FocusTargetNode onCancelled$iv;
        boolean exit-dhqQ-8s;
        Throwable th;
        if (DelegatableNodeKt.requireLayoutNode((DelegatableNode)this).getOwner$ui_release() == null) {
        }
        View view = FocusGroupNode_androidKt.access$getView((Modifier.Node)this);
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner((DelegatableNode)this).getFocusOwner();
        Owner requireOwner2 = DelegatableNodeKt.requireOwner((DelegatableNode)this);
        focusTargetOfEmbeddedViewWrapper = 1;
        focusTransactionManager = 0;
        if (oldFocus != null && !Intrinsics.areEqual(oldFocus, requireOwner2) && FocusGroupNode_androidKt.access$containsDescendant(view, oldFocus)) {
            if (!Intrinsics.areEqual(oldFocus, requireOwner2)) {
                i = FocusGroupNode_androidKt.access$containsDescendant(view, oldFocus) ? focusTargetOfEmbeddedViewWrapper : focusTransactionManager;
            } else {
            }
        } else {
        }
        if (newFocus != null && !Intrinsics.areEqual(newFocus, requireOwner2) && FocusGroupNode_androidKt.access$containsDescendant(view, newFocus)) {
            if (!Intrinsics.areEqual(newFocus, requireOwner2)) {
                i2 = FocusGroupNode_androidKt.access$containsDescendant(view, newFocus) ? focusTargetOfEmbeddedViewWrapper : focusTransactionManager;
            } else {
            }
        } else {
        }
        if (i != 0 && i2 != 0) {
            if (i2 != 0) {
                this.focusedChild = newFocus;
            } else {
                if (i2 != 0) {
                    this.focusedChild = newFocus;
                    focusTargetOfEmbeddedViewWrapper = getFocusTargetOfEmbeddedViewWrapper();
                    focusTransactionManager = focusOwner.getFocusTransactionManager();
                    onCancelled$iv = 0;
                    exit-dhqQ-8s = 0;
                    if (!focusTargetOfEmbeddedViewWrapper.getFocusState().getHasFocus() && FocusTransactionManager.access$getOngoingTransaction$p(focusTransactionManager)) {
                        focusTransactionManager = focusOwner.getFocusTransactionManager();
                        onCancelled$iv = 0;
                        exit-dhqQ-8s = 0;
                        if (FocusTransactionManager.access$getOngoingTransaction$p(focusTransactionManager)) {
                            FocusTransactionManager.access$cancelTransaction(focusTransactionManager);
                        }
                        FocusTransactionManager.access$beginTransaction(focusTransactionManager);
                        th = 0;
                        FocusTransactionsKt.performRequestFocus(focusTargetOfEmbeddedViewWrapper);
                        FocusTransactionManager.access$commitTransaction(focusTransactionManager);
                    }
                } else {
                    onCancelled$iv = 0;
                    if (i != 0) {
                        this.focusedChild = onCancelled$iv;
                        if (getFocusTargetOfEmbeddedViewWrapper().getFocusState().isFocused()) {
                            focusOwner.clearFocus-I7lrPNg(focusTransactionManager, focusTargetOfEmbeddedViewWrapper, focusTransactionManager, FocusDirection.Companion.getExit-dhqQ-8s());
                        }
                    } else {
                        this.focusedChild = onCancelled$iv;
                    }
                }
            }
        } else {
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onViewAttachedToWindow(View v) {
        v.getViewTreeObserver().addOnGlobalFocusChangeListener((ViewTreeObserver.OnGlobalFocusChangeListener)this);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onViewDetachedFromWindow(View v) {
        v.getViewTreeObserver().removeOnGlobalFocusChangeListener((ViewTreeObserver.OnGlobalFocusChangeListener)this);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setFocusedChild(View <set-?>) {
        this.focusedChild = <set-?>;
    }
}
