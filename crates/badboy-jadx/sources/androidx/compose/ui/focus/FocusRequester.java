package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0008\u001a\u00020\tJ\u001d\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u000cH\u0083\u0008J!\u0010\u000e\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u000cH\u0000¢\u0006\u0002\u0008\u000fJ\r\u0010\u0010\u001a\u00020\tH\u0000¢\u0006\u0002\u0008\u0011J\u0006\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0008\u0010\u0015\u001a\u00020\tH\u0007J\u0008\u0010\u0016\u001a\u00020\tH\u0007R\u001a\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0018", d2 = {"Landroidx/compose/ui/focus/FocusRequester;", "", "()V", "focusRequesterNodes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "getFocusRequesterNodes$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "captureFocus", "", "findFocusTarget", "onFound", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusTargetNode;", "findFocusTargetNode", "findFocusTargetNode$ui_release", "focus", "focus$ui_release", "freeFocus", "requestFocus", "", "restoreFocusedChild", "saveFocusedChild", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FocusRequester {

    public static final int $stable;
    private static final androidx.compose.ui.focus.FocusRequester Cancel;
    public static final androidx.compose.ui.focus.FocusRequester.Companion Companion;
    private static final androidx.compose.ui.focus.FocusRequester Default;
    private final MutableVector<androidx.compose.ui.focus.FocusRequesterModifierNode> focusRequesterNodes;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u000cB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bR\u001c\u0010\u0003\u001a\u00020\u00048GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0008\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0007¨\u0006\r", d2 = {"Landroidx/compose/ui/focus/FocusRequester$Companion;", "", "()V", "Cancel", "Landroidx/compose/ui/focus/FocusRequester;", "getCancel$annotations", "getCancel", "()Landroidx/compose/ui/focus/FocusRequester;", "Default", "getDefault", "createRefs", "Landroidx/compose/ui/focus/FocusRequester$Companion$FocusRequesterFactory;", "FocusRequesterFactory", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getCancel$annotations() {
        }

        public final androidx.compose.ui.focus.FocusRequester.Companion.FocusRequesterFactory createRefs() {
            return FocusRequester.Companion.FocusRequesterFactory.INSTANCE;
        }

        public final androidx.compose.ui.focus.FocusRequester getCancel() {
            return FocusRequester.access$getCancel$cp();
        }

        public final androidx.compose.ui.focus.FocusRequester getDefault() {
            return FocusRequester.access$getDefault$cp();
        }
    }
    static {
        FocusRequester.Companion companion = new FocusRequester.Companion(0);
        FocusRequester.Companion = companion;
        FocusRequester focusRequester = new FocusRequester();
        FocusRequester.Default = focusRequester;
        FocusRequester focusRequester2 = new FocusRequester();
        FocusRequester.Cancel = focusRequester2;
    }

    public FocusRequester() {
        super();
        final int i = 0;
        final int i3 = 0;
        MutableVector mutableVector = new MutableVector(new FocusRequesterModifierNode[16], 0);
        this.focusRequesterNodes = mutableVector;
    }

    public static final androidx.compose.ui.focus.FocusRequester access$getCancel$cp() {
        return FocusRequester.Cancel;
    }

    public static final androidx.compose.ui.focus.FocusRequester access$getDefault$cp() {
        return FocusRequester.Default;
    }

    private final boolean findFocusTarget(Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        Object count$iv$iv2;
        int child$iv$iv2;
        Modifier.Node child$iv$iv3;
        int i15;
        int child$iv$iv;
        int i11;
        int i5;
        int success3;
        Object success2;
        int node$iv$iv;
        Object node$iv$iv4;
        Modifier.Node node$iv$iv2;
        int node$iv$iv6;
        Object notEmpty;
        int i$iv;
        Object[] content;
        Object obj2;
        int i3;
        Object obj3;
        int $i$f$getFocusTargetOLwlOKw;
        int i;
        int i9;
        Object obj;
        int i7;
        Object node$iv$iv5;
        int i12;
        Object size;
        int $i$f$findFocusTarget;
        int i2;
        Object obj5;
        int i8;
        int i14;
        Object node$iv$iv3;
        MutableVector branches$iv$iv;
        int i6;
        Modifier.Node child$iv$iv4;
        boolean booleanValue;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node;
        int i13;
        int count$iv$iv;
        int i10;
        int i4;
        int success;
        Object obj4;
        count$iv$iv2 = this;
        child$iv$iv2 = 0;
        node$iv$iv = 0;
        i11 = count$iv$iv2 != FocusRequester.Companion.getDefault() ? 1 : node$iv$iv;
        String str3 = "\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n";
        if (i11 == 0) {
        } else {
            i5 = count$iv$iv2 != FocusRequester.Companion.getCancel() ? 1 : node$iv$iv;
            if (i5 == 0) {
            } else {
                if (!count$iv$iv2.focusRequesterNodes.isNotEmpty()) {
                } else {
                    success3 = 0;
                    MutableVector focusRequesterNodes2 = count$iv$iv2.focusRequesterNodes;
                    final int i21 = 0;
                    final int size2 = focusRequesterNodes2.getSize();
                    if (size2 > 0) {
                        i$iv = 0;
                        i3 = 0;
                        int i22 = 0;
                        $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
                        i = 0;
                        i9 = $i$f$getFocusTargetOLwlOKw;
                        obj = obj3;
                        i7 = 0;
                        while (obj.getNode().isAttached()) {
                            node$iv$iv5 = 0;
                            i12 = 1;
                            size = 0;
                            count$iv$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv);
                            child$iv$iv3 = obj.getNode().getChild$ui_release();
                            if (child$iv$iv3 == null) {
                            } else {
                            }
                            count$iv$iv2.add(child$iv$iv3);
                            while (count$iv$iv2.isNotEmpty()) {
                                int i24 = 0;
                                notEmpty = count$iv$iv2.removeAt(size + -1);
                                if (aggregateChildKindSet$ui_release &= i9 == 0) {
                                    break loop_15;
                                } else {
                                }
                                node$iv$iv5 = notEmpty;
                                while (node$iv$iv5 != null) {
                                    branches$iv$iv = count$iv$iv2;
                                    success = success3;
                                    int child$iv$iv6 = i12;
                                    node$iv$iv5 = node$iv$iv5.getChild$ui_release();
                                    child$iv$iv3 = child$iv$iv4;
                                    node$iv$iv = 0;
                                }
                                branches$iv$iv = count$iv$iv2;
                                success = success3;
                                int child$iv$iv5 = i12;
                                child$iv$iv3 = child$iv$iv4;
                                node$iv$iv = 0;
                                if (kindSet$ui_release &= i9 == 0) {
                                    break loop_15;
                                } else {
                                }
                                branches$iv$iv = count$iv$iv2;
                                success = success3;
                                child$iv$iv6 = i12;
                                node$iv$iv5 = node$iv$iv5.getChild$ui_release();
                                child$iv$iv3 = child$iv$iv4;
                                node$iv$iv = 0;
                                i2 = 0;
                                i8 = 0;
                                i14 = 0;
                                int i25 = 0;
                                node$iv$iv = node$iv$iv3;
                                while (node$iv$iv != null) {
                                    branches$iv$iv = count$iv$iv2;
                                    child$iv$iv = onFound;
                                    i6 = 0;
                                    if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                    } else {
                                    }
                                    count$iv$iv2 = 0;
                                    if (count$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                                    } else {
                                    }
                                    success = success3;
                                    obj4 = node$iv$iv;
                                    i15 = i12;
                                    node$iv$iv4 = obj4;
                                    node$iv$iv = DelegatableNodeKt.access$pop(i14);
                                    i12 = i15;
                                    count$iv$iv2 = branches$iv$iv;
                                    child$iv$iv3 = child$iv$iv4;
                                    success3 = success;
                                    if (node$iv$iv instanceof DelegatingNode) {
                                    } else {
                                    }
                                    count$iv$iv2 = 0;
                                    booleanValue = 0;
                                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                                    while (node$iv$iv$iv != null) {
                                        node = node$iv$iv$iv;
                                        i13 = 0;
                                        i10 = 0;
                                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                        } else {
                                        }
                                        count$iv$iv = 0;
                                        if (count$iv$iv != 0) {
                                        } else {
                                        }
                                        success = success3;
                                        node$iv$iv2 = node;
                                        success2 = obj4;
                                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                        child$iv$iv = onFound;
                                        node$iv$iv = success2;
                                        success3 = success;
                                        i12 = 1;
                                        count$iv$iv2++;
                                        if (count$iv$iv2 == i12) {
                                        } else {
                                        }
                                        if (i14 == 0) {
                                        } else {
                                        }
                                        count$iv$iv = count$iv$iv2;
                                        success = success3;
                                        obj4 = node$iv$iv;
                                        node$iv$iv6 = 0;
                                        child$iv$iv = i14;
                                        Object obj7 = obj4;
                                        if (obj7 != null) {
                                        } else {
                                        }
                                        success2 = obj4;
                                        if (child$iv$iv != 0) {
                                        } else {
                                        }
                                        node$iv$iv2 = node;
                                        i14 = child$iv$iv;
                                        count$iv$iv2 = count$iv$iv;
                                        child$iv$iv.add(node);
                                        if (child$iv$iv != 0) {
                                        }
                                        success2 = 0;
                                        child$iv$iv.add(obj7);
                                        count$iv$iv = count$iv$iv2;
                                        i10 = 0;
                                        i4 = i20;
                                        success = success3;
                                        obj4 = node$iv$iv;
                                        child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                        success = success3;
                                        success2 = node$iv$iv2;
                                        count$iv$iv = i12;
                                    }
                                    obj4 = node$iv$iv;
                                    i15 = 1;
                                    if (count$iv$iv2 == i15) {
                                    } else {
                                    }
                                    node$iv$iv4 = obj4;
                                    i12 = i15;
                                    count$iv$iv2 = branches$iv$iv;
                                    child$iv$iv3 = child$iv$iv4;
                                    success3 = success;
                                    node$iv$iv = obj4;
                                    node = node$iv$iv$iv;
                                    i13 = 0;
                                    i10 = 0;
                                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                    } else {
                                    }
                                    count$iv$iv = 0;
                                    if (count$iv$iv != 0) {
                                    } else {
                                    }
                                    success = success3;
                                    node$iv$iv2 = node;
                                    success2 = obj4;
                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                    child$iv$iv = onFound;
                                    node$iv$iv = success2;
                                    success3 = success;
                                    i12 = 1;
                                    count$iv$iv2++;
                                    if (count$iv$iv2 == i12) {
                                    } else {
                                    }
                                    if (i14 == 0) {
                                    } else {
                                    }
                                    count$iv$iv = count$iv$iv2;
                                    success = success3;
                                    obj4 = node$iv$iv;
                                    node$iv$iv6 = 0;
                                    child$iv$iv = i14;
                                    obj7 = obj4;
                                    if (obj7 != null) {
                                    } else {
                                    }
                                    success2 = obj4;
                                    if (child$iv$iv != 0) {
                                    } else {
                                    }
                                    node$iv$iv2 = node;
                                    i14 = child$iv$iv;
                                    count$iv$iv2 = count$iv$iv;
                                    child$iv$iv.add(node);
                                    if (child$iv$iv != 0) {
                                    }
                                    success2 = 0;
                                    child$iv$iv.add(obj7);
                                    count$iv$iv = count$iv$iv2;
                                    i10 = 0;
                                    i4 = i20;
                                    success = success3;
                                    obj4 = node$iv$iv;
                                    child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                    success = success3;
                                    success2 = node$iv$iv2;
                                    count$iv$iv = i12;
                                    count$iv$iv2 = i12;
                                    i6 = 0;
                                    child$iv$iv4 = child$iv$iv3;
                                    success = success3;
                                    obj4 = node$iv$iv;
                                    i15 = i12;
                                }
                                branches$iv$iv = count$iv$iv2;
                                success = success3;
                                obj4 = node$iv$iv;
                                int child$iv$iv8 = i12;
                                child$iv$iv3 = child$iv$iv4;
                                node$iv$iv = 0;
                                branches$iv$iv = count$iv$iv2;
                                child$iv$iv = onFound;
                                i6 = 0;
                                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                count$iv$iv2 = 0;
                                if (count$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                success = success3;
                                obj4 = node$iv$iv;
                                i15 = i12;
                                node$iv$iv4 = obj4;
                                node$iv$iv = DelegatableNodeKt.access$pop(i14);
                                i12 = i15;
                                count$iv$iv2 = branches$iv$iv;
                                child$iv$iv3 = child$iv$iv4;
                                success3 = success;
                                if (node$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                count$iv$iv2 = 0;
                                booleanValue = 0;
                                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                                while (node$iv$iv$iv != null) {
                                    node = node$iv$iv$iv;
                                    i13 = 0;
                                    i10 = 0;
                                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                    } else {
                                    }
                                    count$iv$iv = 0;
                                    if (count$iv$iv != 0) {
                                    } else {
                                    }
                                    success = success3;
                                    node$iv$iv2 = node;
                                    success2 = obj4;
                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                    child$iv$iv = onFound;
                                    node$iv$iv = success2;
                                    success3 = success;
                                    i12 = 1;
                                    count$iv$iv2++;
                                    if (count$iv$iv2 == i12) {
                                    } else {
                                    }
                                    if (i14 == 0) {
                                    } else {
                                    }
                                    count$iv$iv = count$iv$iv2;
                                    success = success3;
                                    obj4 = node$iv$iv;
                                    node$iv$iv6 = 0;
                                    child$iv$iv = i14;
                                    obj7 = obj4;
                                    if (obj7 != null) {
                                    } else {
                                    }
                                    success2 = obj4;
                                    if (child$iv$iv != 0) {
                                    } else {
                                    }
                                    node$iv$iv2 = node;
                                    i14 = child$iv$iv;
                                    count$iv$iv2 = count$iv$iv;
                                    child$iv$iv.add(node);
                                    if (child$iv$iv != 0) {
                                    }
                                    success2 = 0;
                                    child$iv$iv.add(obj7);
                                    count$iv$iv = count$iv$iv2;
                                    i10 = 0;
                                    i4 = i20;
                                    success = success3;
                                    obj4 = node$iv$iv;
                                    child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                    success = success3;
                                    success2 = node$iv$iv2;
                                    count$iv$iv = i12;
                                }
                                obj4 = node$iv$iv;
                                i15 = 1;
                                if (count$iv$iv2 == i15) {
                                } else {
                                }
                                node$iv$iv4 = obj4;
                                i12 = i15;
                                count$iv$iv2 = branches$iv$iv;
                                child$iv$iv3 = child$iv$iv4;
                                success3 = success;
                                node$iv$iv = obj4;
                                node = node$iv$iv$iv;
                                i13 = 0;
                                i10 = 0;
                                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                count$iv$iv = 0;
                                if (count$iv$iv != 0) {
                                } else {
                                }
                                success = success3;
                                node$iv$iv2 = node;
                                success2 = obj4;
                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                child$iv$iv = onFound;
                                node$iv$iv = success2;
                                success3 = success;
                                i12 = 1;
                                count$iv$iv2++;
                                if (count$iv$iv2 == i12) {
                                } else {
                                }
                                if (i14 == 0) {
                                } else {
                                }
                                count$iv$iv = count$iv$iv2;
                                success = success3;
                                obj4 = node$iv$iv;
                                node$iv$iv6 = 0;
                                child$iv$iv = i14;
                                obj7 = obj4;
                                if (obj7 != null) {
                                } else {
                                }
                                success2 = obj4;
                                if (child$iv$iv != 0) {
                                } else {
                                }
                                node$iv$iv2 = node;
                                i14 = child$iv$iv;
                                count$iv$iv2 = count$iv$iv;
                                child$iv$iv.add(node);
                                if (child$iv$iv != 0) {
                                }
                                success2 = 0;
                                child$iv$iv.add(obj7);
                                count$iv$iv = count$iv$iv2;
                                i10 = 0;
                                i4 = i20;
                                success = success3;
                                obj4 = node$iv$iv;
                                child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                success = success3;
                                success2 = node$iv$iv2;
                                count$iv$iv = i12;
                                count$iv$iv2 = i12;
                                i6 = 0;
                                child$iv$iv4 = child$iv$iv3;
                                success = success3;
                                obj4 = node$iv$iv;
                                i15 = i12;
                                DelegatableNodeKt.access$addLayoutNodeChildren(count$iv$iv2, notEmpty);
                            }
                            branches$iv$iv = count$iv$iv2;
                            child$iv$iv4 = child$iv$iv3;
                            success = success3;
                            child$iv$iv2 = i12;
                            node$iv$iv = 0;
                            count$iv$iv2 = this;
                            child$iv$iv2 = $i$f$findFocusTarget;
                            i3 = 0;
                            i22 = 0;
                            $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
                            i = 0;
                            i9 = $i$f$getFocusTargetOLwlOKw;
                            obj = obj3;
                            i7 = 0;
                            i24 = 0;
                            notEmpty = count$iv$iv2.removeAt(size + -1);
                            if (aggregateChildKindSet$ui_release &= i9 == 0) {
                            } else {
                            }
                            node$iv$iv5 = notEmpty;
                            while (node$iv$iv5 != null) {
                                branches$iv$iv = count$iv$iv2;
                                success = success3;
                                child$iv$iv6 = i12;
                                node$iv$iv5 = node$iv$iv5.getChild$ui_release();
                                child$iv$iv3 = child$iv$iv4;
                                node$iv$iv = 0;
                            }
                            branches$iv$iv = count$iv$iv2;
                            success = success3;
                            child$iv$iv5 = i12;
                            child$iv$iv3 = child$iv$iv4;
                            node$iv$iv = 0;
                            if (kindSet$ui_release &= i9 != 0) {
                            } else {
                            }
                            branches$iv$iv = count$iv$iv2;
                            success = success3;
                            child$iv$iv6 = i12;
                            node$iv$iv5 = node$iv$iv5.getChild$ui_release();
                            child$iv$iv3 = child$iv$iv4;
                            node$iv$iv = 0;
                            i2 = 0;
                            i8 = 0;
                            i14 = 0;
                            i25 = 0;
                            node$iv$iv = node$iv$iv3;
                            while (node$iv$iv != null) {
                                branches$iv$iv = count$iv$iv2;
                                child$iv$iv = onFound;
                                i6 = 0;
                                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                count$iv$iv2 = 0;
                                if (count$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                success = success3;
                                obj4 = node$iv$iv;
                                i15 = i12;
                                node$iv$iv4 = obj4;
                                node$iv$iv = DelegatableNodeKt.access$pop(i14);
                                i12 = i15;
                                count$iv$iv2 = branches$iv$iv;
                                child$iv$iv3 = child$iv$iv4;
                                success3 = success;
                                if (node$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                count$iv$iv2 = 0;
                                booleanValue = 0;
                                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                                while (node$iv$iv$iv != null) {
                                    node = node$iv$iv$iv;
                                    i13 = 0;
                                    i10 = 0;
                                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                    } else {
                                    }
                                    count$iv$iv = 0;
                                    if (count$iv$iv != 0) {
                                    } else {
                                    }
                                    success = success3;
                                    node$iv$iv2 = node;
                                    success2 = obj4;
                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                    child$iv$iv = onFound;
                                    node$iv$iv = success2;
                                    success3 = success;
                                    i12 = 1;
                                    count$iv$iv2++;
                                    if (count$iv$iv2 == i12) {
                                    } else {
                                    }
                                    if (i14 == 0) {
                                    } else {
                                    }
                                    count$iv$iv = count$iv$iv2;
                                    success = success3;
                                    obj4 = node$iv$iv;
                                    node$iv$iv6 = 0;
                                    child$iv$iv = i14;
                                    obj7 = obj4;
                                    if (obj7 != null) {
                                    } else {
                                    }
                                    success2 = obj4;
                                    if (child$iv$iv != 0) {
                                    } else {
                                    }
                                    node$iv$iv2 = node;
                                    i14 = child$iv$iv;
                                    count$iv$iv2 = count$iv$iv;
                                    child$iv$iv.add(node);
                                    if (child$iv$iv != 0) {
                                    }
                                    success2 = 0;
                                    child$iv$iv.add(obj7);
                                    count$iv$iv = count$iv$iv2;
                                    i10 = 0;
                                    i4 = i20;
                                    success = success3;
                                    obj4 = node$iv$iv;
                                    child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                    success = success3;
                                    success2 = node$iv$iv2;
                                    count$iv$iv = i12;
                                }
                                obj4 = node$iv$iv;
                                i15 = 1;
                                if (count$iv$iv2 == i15) {
                                } else {
                                }
                                node$iv$iv4 = obj4;
                                i12 = i15;
                                count$iv$iv2 = branches$iv$iv;
                                child$iv$iv3 = child$iv$iv4;
                                success3 = success;
                                node$iv$iv = obj4;
                                node = node$iv$iv$iv;
                                i13 = 0;
                                i10 = 0;
                                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                count$iv$iv = 0;
                                if (count$iv$iv != 0) {
                                } else {
                                }
                                success = success3;
                                node$iv$iv2 = node;
                                success2 = obj4;
                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                child$iv$iv = onFound;
                                node$iv$iv = success2;
                                success3 = success;
                                i12 = 1;
                                count$iv$iv2++;
                                if (count$iv$iv2 == i12) {
                                } else {
                                }
                                if (i14 == 0) {
                                } else {
                                }
                                count$iv$iv = count$iv$iv2;
                                success = success3;
                                obj4 = node$iv$iv;
                                node$iv$iv6 = 0;
                                child$iv$iv = i14;
                                obj7 = obj4;
                                if (obj7 != null) {
                                } else {
                                }
                                success2 = obj4;
                                if (child$iv$iv != 0) {
                                } else {
                                }
                                node$iv$iv2 = node;
                                i14 = child$iv$iv;
                                count$iv$iv2 = count$iv$iv;
                                child$iv$iv.add(node);
                                if (child$iv$iv != 0) {
                                }
                                success2 = 0;
                                child$iv$iv.add(obj7);
                                count$iv$iv = count$iv$iv2;
                                i10 = 0;
                                i4 = i20;
                                success = success3;
                                obj4 = node$iv$iv;
                                child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                success = success3;
                                success2 = node$iv$iv2;
                                count$iv$iv = i12;
                                count$iv$iv2 = i12;
                                i6 = 0;
                                child$iv$iv4 = child$iv$iv3;
                                success = success3;
                                obj4 = node$iv$iv;
                                i15 = i12;
                            }
                            branches$iv$iv = count$iv$iv2;
                            success = success3;
                            obj4 = node$iv$iv;
                            child$iv$iv8 = i12;
                            child$iv$iv3 = child$iv$iv4;
                            node$iv$iv = 0;
                            branches$iv$iv = count$iv$iv2;
                            if (node$iv$iv instanceof FocusTargetNode) {
                            } else {
                            }
                            child$iv$iv = onFound;
                            i6 = 0;
                            if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                            } else {
                            }
                            count$iv$iv2 = 0;
                            if (count$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                            } else {
                            }
                            success = success3;
                            obj4 = node$iv$iv;
                            i15 = i12;
                            node$iv$iv4 = obj4;
                            node$iv$iv = DelegatableNodeKt.access$pop(i14);
                            i12 = i15;
                            count$iv$iv2 = branches$iv$iv;
                            child$iv$iv3 = child$iv$iv4;
                            success3 = success;
                            if (node$iv$iv instanceof DelegatingNode) {
                            } else {
                            }
                            count$iv$iv2 = 0;
                            booleanValue = 0;
                            node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                            while (node$iv$iv$iv != null) {
                                node = node$iv$iv$iv;
                                i13 = 0;
                                i10 = 0;
                                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                count$iv$iv = 0;
                                if (count$iv$iv != 0) {
                                } else {
                                }
                                success = success3;
                                node$iv$iv2 = node;
                                success2 = obj4;
                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                child$iv$iv = onFound;
                                node$iv$iv = success2;
                                success3 = success;
                                i12 = 1;
                                count$iv$iv2++;
                                if (count$iv$iv2 == i12) {
                                } else {
                                }
                                if (i14 == 0) {
                                } else {
                                }
                                count$iv$iv = count$iv$iv2;
                                success = success3;
                                obj4 = node$iv$iv;
                                node$iv$iv6 = 0;
                                child$iv$iv = i14;
                                obj7 = obj4;
                                if (obj7 != null) {
                                } else {
                                }
                                success2 = obj4;
                                if (child$iv$iv != 0) {
                                } else {
                                }
                                node$iv$iv2 = node;
                                i14 = child$iv$iv;
                                count$iv$iv2 = count$iv$iv;
                                child$iv$iv.add(node);
                                if (child$iv$iv != 0) {
                                }
                                success2 = 0;
                                child$iv$iv.add(obj7);
                                count$iv$iv = count$iv$iv2;
                                i10 = 0;
                                i4 = i20;
                                success = success3;
                                obj4 = node$iv$iv;
                                child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                success = success3;
                                success2 = node$iv$iv2;
                                count$iv$iv = i12;
                            }
                            obj4 = node$iv$iv;
                            i15 = 1;
                            if (count$iv$iv2 == i15) {
                            } else {
                            }
                            node$iv$iv4 = obj4;
                            i12 = i15;
                            count$iv$iv2 = branches$iv$iv;
                            child$iv$iv3 = child$iv$iv4;
                            success3 = success;
                            node$iv$iv = obj4;
                            node = node$iv$iv$iv;
                            i13 = 0;
                            i10 = 0;
                            if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                            } else {
                            }
                            count$iv$iv = 0;
                            if (count$iv$iv != 0) {
                            } else {
                            }
                            success = success3;
                            node$iv$iv2 = node;
                            success2 = obj4;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            child$iv$iv = onFound;
                            node$iv$iv = success2;
                            success3 = success;
                            i12 = 1;
                            count$iv$iv2++;
                            if (count$iv$iv2 == i12) {
                            } else {
                            }
                            if (i14 == 0) {
                            } else {
                            }
                            count$iv$iv = count$iv$iv2;
                            success = success3;
                            obj4 = node$iv$iv;
                            node$iv$iv6 = 0;
                            child$iv$iv = i14;
                            obj7 = obj4;
                            if (obj7 != null) {
                            } else {
                            }
                            success2 = obj4;
                            if (child$iv$iv != 0) {
                            } else {
                            }
                            node$iv$iv2 = node;
                            i14 = child$iv$iv;
                            count$iv$iv2 = count$iv$iv;
                            child$iv$iv.add(node);
                            if (child$iv$iv != 0) {
                            }
                            success2 = 0;
                            child$iv$iv.add(obj7);
                            count$iv$iv = count$iv$iv2;
                            i10 = 0;
                            i4 = i20;
                            success = success3;
                            obj4 = node$iv$iv;
                            child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                            success = success3;
                            success2 = node$iv$iv2;
                            count$iv$iv = i12;
                            count$iv$iv2 = i12;
                            i6 = 0;
                            child$iv$iv4 = child$iv$iv3;
                            if ((Boolean)onFound.invoke((FocusTargetNode)node$iv$iv).booleanValue()) {
                            } else {
                            }
                            success = success3;
                            obj4 = node$iv$iv;
                            i15 = i12;
                            success3 = 1;
                            child$iv$iv2 = i12;
                            DelegatableNodeKt.access$addLayoutNodeChildren(count$iv$iv2, notEmpty);
                            DelegatableNodeKt.access$addLayoutNodeChildren(count$iv$iv2, obj.getNode());
                        }
                        int $i$f$findFocusTarget4 = child$iv$iv2;
                        int i17 = 0;
                        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
                        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv;
                    }
                    $i$f$findFocusTarget = child$iv$iv2;
                    return success3;
                }
                int $i$f$findFocusTarget5 = child$iv$iv2;
                int i18 = 0;
                IllegalStateException $i$a$CheckFocusRequester$findFocusTarget$3 = new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
                throw $i$a$CheckFocusRequester$findFocusTarget$3;
            }
            int $i$f$findFocusTarget3 = child$iv$iv2;
            int i16 = 0;
            IllegalStateException $i$a$CheckFocusRequester$findFocusTarget$2 = new IllegalStateException(str3.toString());
            throw $i$a$CheckFocusRequester$findFocusTarget$2;
        }
        int $i$f$findFocusTarget6 = child$iv$iv2;
        int i19 = 0;
        IllegalStateException $i$a$CheckFocusRequester$findFocusTarget$1 = new IllegalStateException(str3.toString());
        throw $i$a$CheckFocusRequester$findFocusTarget$1;
    }

    public final boolean captureFocus() {
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        boolean captureFocus;
        if (!this.focusRequesterNodes.isNotEmpty()) {
        } else {
            MutableVector focusRequesterNodes2 = this.focusRequesterNodes;
            int i3 = 0;
            final int size = focusRequesterNodes2.getSize();
            if (size > 0) {
                i$iv = 0;
                i = 0;
                while (FocusRequesterModifierNodeKt.captureFocus((FocusRequesterModifierNode)focusRequesterNodes2.getContent()[i$iv])) {
                    i = 0;
                }
                return 1;
            }
            return 0;
        }
        int i2 = 0;
        IllegalStateException $i$a$CheckFocusRequester$captureFocus$1 = new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        throw $i$a$CheckFocusRequester$captureFocus$1;
    }

    public final boolean findFocusTargetNode$ui_release(Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        int function1;
        Modifier.Node next$iv$iv$iv;
        int capacity$iv$iv$iv$iv$iv;
        int i10;
        androidx.compose.ui.focus.FocusRequester this_$iv2;
        Object it$iv2;
        MutableVector count$iv$iv$iv2;
        int this_$iv$iv$iv$iv3;
        int i9;
        int i12;
        int success$iv;
        int node$iv$iv$iv2;
        Object notEmpty;
        int i$iv$iv;
        Object[] content;
        Object obj3;
        int i14;
        Object obj2;
        int $i$f$getFocusTargetOLwlOKw;
        int i3;
        int i2;
        Object obj4;
        int i7;
        Object node$iv$iv$iv;
        int i4;
        Object size;
        androidx.compose.ui.focus.FocusRequester this_$iv;
        int i11;
        int i;
        Object obj;
        int i15;
        int i16;
        Object node$iv$iv$iv3;
        MutableVector branches$iv$iv$iv;
        int i5;
        boolean node$iv$iv$iv$iv;
        int i6;
        Object it$iv;
        Modifier.Node child$iv$iv$iv;
        int this_$iv$iv$iv$iv;
        int i13;
        int count$iv$iv$iv;
        Object this_$iv$iv$iv$iv2;
        int i8;
        function1 = onFound;
        this_$iv2 = this;
        node$iv$iv$iv2 = 0;
        i9 = this_$iv2 != FocusRequester.Companion.getDefault() ? 1 : node$iv$iv$iv2;
        String str3 = "\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n";
        if (i9 == 0) {
        } else {
            i12 = this_$iv2 != FocusRequester.Companion.getCancel() ? 1 : node$iv$iv$iv2;
            if (i12 == 0) {
            } else {
                if (!this_$iv2.focusRequesterNodes.isNotEmpty()) {
                } else {
                    success$iv = 0;
                    MutableVector focusRequesterNodes2 = this_$iv2.focusRequesterNodes;
                    final int i26 = 0;
                    final int size2 = focusRequesterNodes2.getSize();
                    if (size2 > 0) {
                        i$iv$iv = 0;
                        i14 = 0;
                        int i27 = 0;
                        $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
                        i3 = 0;
                        i2 = $i$f$getFocusTargetOLwlOKw;
                        obj4 = obj2;
                        i7 = 0;
                        while (obj4.getNode().isAttached()) {
                            node$iv$iv$iv = 0;
                            i4 = 1;
                            size = 0;
                            this_$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv$iv2);
                            this_$iv$iv$iv$iv3 = obj4.getNode().getChild$ui_release();
                            if (this_$iv$iv$iv$iv3 == null) {
                            } else {
                            }
                            this_$iv2.add(this_$iv$iv$iv$iv3);
                            while (this_$iv2.isNotEmpty()) {
                                int i29 = 0;
                                notEmpty = this_$iv2.removeAt(size + -1);
                                if (aggregateChildKindSet$ui_release &= i2 == 0) {
                                    break loop_15;
                                } else {
                                }
                                node$iv$iv$iv = notEmpty;
                                while (node$iv$iv$iv != null) {
                                    branches$iv$iv$iv = this_$iv2;
                                    child$iv$iv$iv = this_$iv$iv$iv$iv3;
                                    int i19 = i4;
                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                    node$iv$iv$iv2 = 0;
                                    function1 = onFound;
                                }
                                branches$iv$iv$iv = this_$iv2;
                                child$iv$iv$iv = this_$iv$iv$iv$iv3;
                                int i18 = i4;
                                node$iv$iv$iv2 = 0;
                                function1 = onFound;
                                if (kindSet$ui_release &= i2 == 0) {
                                    break loop_15;
                                } else {
                                }
                                branches$iv$iv$iv = this_$iv2;
                                child$iv$iv$iv = this_$iv$iv$iv$iv3;
                                i19 = i4;
                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                node$iv$iv$iv2 = 0;
                                function1 = onFound;
                                i = 0;
                                i15 = 0;
                                i16 = 0;
                                int i30 = 0;
                                node$iv$iv$iv2 = node$iv$iv$iv3;
                                while (node$iv$iv$iv2 != null) {
                                    branches$iv$iv$iv = this_$iv2;
                                    this_$iv$iv$iv$iv3 = 0;
                                    if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                    } else {
                                    }
                                    it$iv2 = 0;
                                    if (it$iv2 != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                                    } else {
                                    }
                                    i10 = i4;
                                    node$iv$iv$iv2 = DelegatableNodeKt.access$pop(i16);
                                    i4 = i10;
                                    this_$iv2 = branches$iv$iv$iv;
                                    this_$iv$iv$iv$iv3 = child$iv$iv$iv;
                                    function1 = onFound;
                                    if (node$iv$iv$iv2 instanceof DelegatingNode) {
                                    } else {
                                    }
                                    it$iv2 = 0;
                                    i5 = 0;
                                    node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                                    while (node$iv$iv$iv$iv != null) {
                                        i6 = node$iv$iv$iv$iv;
                                        it$iv = 0;
                                        i13 = 0;
                                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv$iv = 0;
                                        if (this_$iv$iv$iv$iv != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                        next$iv$iv$iv = i6;
                                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                        function1 = onFound;
                                        this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                        i4 = 1;
                                        it$iv2++;
                                        if (it$iv2 == i4) {
                                        } else {
                                        }
                                        if (i16 == 0) {
                                        } else {
                                        }
                                        count$iv$iv$iv = it$iv2;
                                        this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                        capacity$iv$iv$iv$iv$iv = 0;
                                        count$iv$iv$iv2 = i16;
                                        this_$iv$iv$iv$iv3 = node$iv$iv$iv2;
                                        if (this_$iv$iv$iv$iv3 != null && count$iv$iv$iv2 != null) {
                                        }
                                        if (count$iv$iv$iv2 != null) {
                                        } else {
                                        }
                                        next$iv$iv$iv = i6;
                                        i16 = count$iv$iv$iv2;
                                        it$iv2 = count$iv$iv$iv;
                                        count$iv$iv$iv2.add(i6);
                                        if (count$iv$iv$iv2 != null) {
                                        }
                                        node$iv$iv$iv2 = 0;
                                        count$iv$iv$iv2.add(this_$iv$iv$iv$iv3);
                                        this_$iv$iv$iv$iv = i21;
                                        int $i$f$mutableVectorOf = 16;
                                        i13 = 0;
                                        count$iv$iv$iv = it$iv2;
                                        this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                        i8 = $i$f$mutableVectorOf;
                                        count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                        node$iv$iv$iv2 = i6;
                                        this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                        next$iv$iv$iv = i6;
                                        this_$iv$iv$iv$iv = i4;
                                    }
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                    i10 = 1;
                                    if (it$iv2 == i10) {
                                    } else {
                                    }
                                    i4 = i10;
                                    this_$iv2 = branches$iv$iv$iv;
                                    this_$iv$iv$iv$iv3 = child$iv$iv$iv;
                                    function1 = onFound;
                                    i6 = node$iv$iv$iv$iv;
                                    it$iv = 0;
                                    i13 = 0;
                                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv = 0;
                                    if (this_$iv$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                    next$iv$iv$iv = i6;
                                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                    function1 = onFound;
                                    this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                    i4 = 1;
                                    it$iv2++;
                                    if (it$iv2 == i4) {
                                    } else {
                                    }
                                    if (i16 == 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv = it$iv2;
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                    capacity$iv$iv$iv$iv$iv = 0;
                                    count$iv$iv$iv2 = i16;
                                    this_$iv$iv$iv$iv3 = node$iv$iv$iv2;
                                    if (this_$iv$iv$iv$iv3 != null && count$iv$iv$iv2 != null) {
                                    }
                                    if (count$iv$iv$iv2 != null) {
                                    } else {
                                    }
                                    next$iv$iv$iv = i6;
                                    i16 = count$iv$iv$iv2;
                                    it$iv2 = count$iv$iv$iv;
                                    count$iv$iv$iv2.add(i6);
                                    if (count$iv$iv$iv2 != null) {
                                    }
                                    node$iv$iv$iv2 = 0;
                                    count$iv$iv$iv2.add(this_$iv$iv$iv$iv3);
                                    this_$iv$iv$iv$iv = i21;
                                    $i$f$mutableVectorOf = 16;
                                    i13 = 0;
                                    count$iv$iv$iv = it$iv2;
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                    i8 = $i$f$mutableVectorOf;
                                    count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                    node$iv$iv$iv2 = i6;
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                    next$iv$iv$iv = i6;
                                    this_$iv$iv$iv$iv = i4;
                                    it$iv2 = i4;
                                    Object obj5 = node$iv$iv$iv2;
                                    i5 = 0;
                                    Object obj7 = obj5;
                                    i6 = 0;
                                    if (obj7.fetchFocusProperties$ui_release().getCanFocus()) {
                                    } else {
                                    }
                                    it$iv = obj5;
                                    child$iv$iv$iv = this_$iv$iv$iv$iv3;
                                    node$iv$iv$iv$iv = TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(obj7, FocusDirection.Companion.getEnter-dhqQ-8s(), function1);
                                    i10 = i4;
                                    it$iv = obj5;
                                    node$iv$iv$iv$iv = (Boolean)function1.invoke(obj7).booleanValue();
                                    child$iv$iv$iv = this_$iv$iv$iv$iv3;
                                }
                                branches$iv$iv$iv = this_$iv2;
                                child$iv$iv$iv = this_$iv$iv$iv$iv3;
                                int i22 = i4;
                                node$iv$iv$iv2 = 0;
                                function1 = onFound;
                                branches$iv$iv$iv = this_$iv2;
                                this_$iv$iv$iv$iv3 = 0;
                                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                it$iv2 = 0;
                                if (it$iv2 != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                                } else {
                                }
                                i10 = i4;
                                node$iv$iv$iv2 = DelegatableNodeKt.access$pop(i16);
                                i4 = i10;
                                this_$iv2 = branches$iv$iv$iv;
                                this_$iv$iv$iv$iv3 = child$iv$iv$iv;
                                function1 = onFound;
                                if (node$iv$iv$iv2 instanceof DelegatingNode) {
                                } else {
                                }
                                it$iv2 = 0;
                                i5 = 0;
                                node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                                while (node$iv$iv$iv$iv != null) {
                                    i6 = node$iv$iv$iv$iv;
                                    it$iv = 0;
                                    i13 = 0;
                                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv = 0;
                                    if (this_$iv$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                    next$iv$iv$iv = i6;
                                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                    function1 = onFound;
                                    this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                    i4 = 1;
                                    it$iv2++;
                                    if (it$iv2 == i4) {
                                    } else {
                                    }
                                    if (i16 == 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv = it$iv2;
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                    capacity$iv$iv$iv$iv$iv = 0;
                                    count$iv$iv$iv2 = i16;
                                    this_$iv$iv$iv$iv3 = node$iv$iv$iv2;
                                    if (this_$iv$iv$iv$iv3 != null && count$iv$iv$iv2 != null) {
                                    }
                                    if (count$iv$iv$iv2 != null) {
                                    } else {
                                    }
                                    next$iv$iv$iv = i6;
                                    i16 = count$iv$iv$iv2;
                                    it$iv2 = count$iv$iv$iv;
                                    count$iv$iv$iv2.add(i6);
                                    if (count$iv$iv$iv2 != null) {
                                    }
                                    node$iv$iv$iv2 = 0;
                                    count$iv$iv$iv2.add(this_$iv$iv$iv$iv3);
                                    this_$iv$iv$iv$iv = i21;
                                    $i$f$mutableVectorOf = 16;
                                    i13 = 0;
                                    count$iv$iv$iv = it$iv2;
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                    i8 = $i$f$mutableVectorOf;
                                    count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                    node$iv$iv$iv2 = i6;
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                    next$iv$iv$iv = i6;
                                    this_$iv$iv$iv$iv = i4;
                                }
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                i10 = 1;
                                if (it$iv2 == i10) {
                                } else {
                                }
                                i4 = i10;
                                this_$iv2 = branches$iv$iv$iv;
                                this_$iv$iv$iv$iv3 = child$iv$iv$iv;
                                function1 = onFound;
                                i6 = node$iv$iv$iv$iv;
                                it$iv = 0;
                                i13 = 0;
                                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv = 0;
                                if (this_$iv$iv$iv$iv != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                next$iv$iv$iv = i6;
                                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                function1 = onFound;
                                this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                i4 = 1;
                                it$iv2++;
                                if (it$iv2 == i4) {
                                } else {
                                }
                                if (i16 == 0) {
                                } else {
                                }
                                count$iv$iv$iv = it$iv2;
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                capacity$iv$iv$iv$iv$iv = 0;
                                count$iv$iv$iv2 = i16;
                                this_$iv$iv$iv$iv3 = node$iv$iv$iv2;
                                if (this_$iv$iv$iv$iv3 != null && count$iv$iv$iv2 != null) {
                                }
                                if (count$iv$iv$iv2 != null) {
                                } else {
                                }
                                next$iv$iv$iv = i6;
                                i16 = count$iv$iv$iv2;
                                it$iv2 = count$iv$iv$iv;
                                count$iv$iv$iv2.add(i6);
                                if (count$iv$iv$iv2 != null) {
                                }
                                node$iv$iv$iv2 = 0;
                                count$iv$iv$iv2.add(this_$iv$iv$iv$iv3);
                                this_$iv$iv$iv$iv = i21;
                                $i$f$mutableVectorOf = 16;
                                i13 = 0;
                                count$iv$iv$iv = it$iv2;
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                i8 = $i$f$mutableVectorOf;
                                count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                node$iv$iv$iv2 = i6;
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                next$iv$iv$iv = i6;
                                this_$iv$iv$iv$iv = i4;
                                it$iv2 = i4;
                                obj5 = node$iv$iv$iv2;
                                i5 = 0;
                                obj7 = obj5;
                                i6 = 0;
                                if (obj7.fetchFocusProperties$ui_release().getCanFocus()) {
                                } else {
                                }
                                it$iv = obj5;
                                child$iv$iv$iv = this_$iv$iv$iv$iv3;
                                node$iv$iv$iv$iv = TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(obj7, FocusDirection.Companion.getEnter-dhqQ-8s(), function1);
                                i10 = i4;
                                it$iv = obj5;
                                node$iv$iv$iv$iv = (Boolean)function1.invoke(obj7).booleanValue();
                                child$iv$iv$iv = this_$iv$iv$iv$iv3;
                                DelegatableNodeKt.access$addLayoutNodeChildren(this_$iv2, notEmpty);
                            }
                            branches$iv$iv$iv = this_$iv2;
                            child$iv$iv$iv = this_$iv$iv$iv$iv3;
                            function1 = i4;
                            function1 = onFound;
                            this_$iv2 = this_$iv;
                            this_$iv$iv$iv$iv3 = i11;
                            node$iv$iv$iv2 = 0;
                            i14 = 0;
                            i27 = 0;
                            $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
                            i3 = 0;
                            i2 = $i$f$getFocusTargetOLwlOKw;
                            obj4 = obj2;
                            i7 = 0;
                            i29 = 0;
                            notEmpty = this_$iv2.removeAt(size + -1);
                            if (aggregateChildKindSet$ui_release &= i2 == 0) {
                            } else {
                            }
                            node$iv$iv$iv = notEmpty;
                            while (node$iv$iv$iv != null) {
                                branches$iv$iv$iv = this_$iv2;
                                child$iv$iv$iv = this_$iv$iv$iv$iv3;
                                i19 = i4;
                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                node$iv$iv$iv2 = 0;
                                function1 = onFound;
                            }
                            branches$iv$iv$iv = this_$iv2;
                            child$iv$iv$iv = this_$iv$iv$iv$iv3;
                            i18 = i4;
                            node$iv$iv$iv2 = 0;
                            function1 = onFound;
                            if (kindSet$ui_release &= i2 != 0) {
                            } else {
                            }
                            branches$iv$iv$iv = this_$iv2;
                            child$iv$iv$iv = this_$iv$iv$iv$iv3;
                            i19 = i4;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            node$iv$iv$iv2 = 0;
                            function1 = onFound;
                            i = 0;
                            i15 = 0;
                            i16 = 0;
                            i30 = 0;
                            node$iv$iv$iv2 = node$iv$iv$iv3;
                            while (node$iv$iv$iv2 != null) {
                                branches$iv$iv$iv = this_$iv2;
                                this_$iv$iv$iv$iv3 = 0;
                                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                it$iv2 = 0;
                                if (it$iv2 != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                                } else {
                                }
                                i10 = i4;
                                node$iv$iv$iv2 = DelegatableNodeKt.access$pop(i16);
                                i4 = i10;
                                this_$iv2 = branches$iv$iv$iv;
                                this_$iv$iv$iv$iv3 = child$iv$iv$iv;
                                function1 = onFound;
                                if (node$iv$iv$iv2 instanceof DelegatingNode) {
                                } else {
                                }
                                it$iv2 = 0;
                                i5 = 0;
                                node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                                while (node$iv$iv$iv$iv != null) {
                                    i6 = node$iv$iv$iv$iv;
                                    it$iv = 0;
                                    i13 = 0;
                                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv = 0;
                                    if (this_$iv$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                    next$iv$iv$iv = i6;
                                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                    function1 = onFound;
                                    this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                    i4 = 1;
                                    it$iv2++;
                                    if (it$iv2 == i4) {
                                    } else {
                                    }
                                    if (i16 == 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv = it$iv2;
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                    capacity$iv$iv$iv$iv$iv = 0;
                                    count$iv$iv$iv2 = i16;
                                    this_$iv$iv$iv$iv3 = node$iv$iv$iv2;
                                    if (this_$iv$iv$iv$iv3 != null && count$iv$iv$iv2 != null) {
                                    }
                                    if (count$iv$iv$iv2 != null) {
                                    } else {
                                    }
                                    next$iv$iv$iv = i6;
                                    i16 = count$iv$iv$iv2;
                                    it$iv2 = count$iv$iv$iv;
                                    count$iv$iv$iv2.add(i6);
                                    if (count$iv$iv$iv2 != null) {
                                    }
                                    node$iv$iv$iv2 = 0;
                                    count$iv$iv$iv2.add(this_$iv$iv$iv$iv3);
                                    this_$iv$iv$iv$iv = i21;
                                    $i$f$mutableVectorOf = 16;
                                    i13 = 0;
                                    count$iv$iv$iv = it$iv2;
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                    i8 = $i$f$mutableVectorOf;
                                    count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                    node$iv$iv$iv2 = i6;
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                    next$iv$iv$iv = i6;
                                    this_$iv$iv$iv$iv = i4;
                                }
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                i10 = 1;
                                if (it$iv2 == i10) {
                                } else {
                                }
                                i4 = i10;
                                this_$iv2 = branches$iv$iv$iv;
                                this_$iv$iv$iv$iv3 = child$iv$iv$iv;
                                function1 = onFound;
                                i6 = node$iv$iv$iv$iv;
                                it$iv = 0;
                                i13 = 0;
                                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv = 0;
                                if (this_$iv$iv$iv$iv != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                next$iv$iv$iv = i6;
                                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                function1 = onFound;
                                this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                i4 = 1;
                                it$iv2++;
                                if (it$iv2 == i4) {
                                } else {
                                }
                                if (i16 == 0) {
                                } else {
                                }
                                count$iv$iv$iv = it$iv2;
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                capacity$iv$iv$iv$iv$iv = 0;
                                count$iv$iv$iv2 = i16;
                                this_$iv$iv$iv$iv3 = node$iv$iv$iv2;
                                if (this_$iv$iv$iv$iv3 != null && count$iv$iv$iv2 != null) {
                                }
                                if (count$iv$iv$iv2 != null) {
                                } else {
                                }
                                next$iv$iv$iv = i6;
                                i16 = count$iv$iv$iv2;
                                it$iv2 = count$iv$iv$iv;
                                count$iv$iv$iv2.add(i6);
                                if (count$iv$iv$iv2 != null) {
                                }
                                node$iv$iv$iv2 = 0;
                                count$iv$iv$iv2.add(this_$iv$iv$iv$iv3);
                                this_$iv$iv$iv$iv = i21;
                                $i$f$mutableVectorOf = 16;
                                i13 = 0;
                                count$iv$iv$iv = it$iv2;
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                i8 = $i$f$mutableVectorOf;
                                count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                node$iv$iv$iv2 = i6;
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                next$iv$iv$iv = i6;
                                this_$iv$iv$iv$iv = i4;
                                it$iv2 = i4;
                                obj5 = node$iv$iv$iv2;
                                i5 = 0;
                                obj7 = obj5;
                                i6 = 0;
                                if (obj7.fetchFocusProperties$ui_release().getCanFocus()) {
                                } else {
                                }
                                it$iv = obj5;
                                child$iv$iv$iv = this_$iv$iv$iv$iv3;
                                node$iv$iv$iv$iv = TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(obj7, FocusDirection.Companion.getEnter-dhqQ-8s(), function1);
                                i10 = i4;
                                it$iv = obj5;
                                node$iv$iv$iv$iv = (Boolean)function1.invoke(obj7).booleanValue();
                                child$iv$iv$iv = this_$iv$iv$iv$iv3;
                            }
                            branches$iv$iv$iv = this_$iv2;
                            child$iv$iv$iv = this_$iv$iv$iv$iv3;
                            i22 = i4;
                            node$iv$iv$iv2 = 0;
                            function1 = onFound;
                            branches$iv$iv$iv = this_$iv2;
                            if (node$iv$iv$iv2 instanceof FocusTargetNode) {
                            } else {
                            }
                            this_$iv$iv$iv$iv3 = 0;
                            if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                            } else {
                            }
                            it$iv2 = 0;
                            if (it$iv2 != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                            } else {
                            }
                            i10 = i4;
                            node$iv$iv$iv2 = DelegatableNodeKt.access$pop(i16);
                            i4 = i10;
                            this_$iv2 = branches$iv$iv$iv;
                            this_$iv$iv$iv$iv3 = child$iv$iv$iv;
                            function1 = onFound;
                            if (node$iv$iv$iv2 instanceof DelegatingNode) {
                            } else {
                            }
                            it$iv2 = 0;
                            i5 = 0;
                            node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                            while (node$iv$iv$iv$iv != null) {
                                i6 = node$iv$iv$iv$iv;
                                it$iv = 0;
                                i13 = 0;
                                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv = 0;
                                if (this_$iv$iv$iv$iv != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                next$iv$iv$iv = i6;
                                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                function1 = onFound;
                                this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                i4 = 1;
                                it$iv2++;
                                if (it$iv2 == i4) {
                                } else {
                                }
                                if (i16 == 0) {
                                } else {
                                }
                                count$iv$iv$iv = it$iv2;
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                capacity$iv$iv$iv$iv$iv = 0;
                                count$iv$iv$iv2 = i16;
                                this_$iv$iv$iv$iv3 = node$iv$iv$iv2;
                                if (this_$iv$iv$iv$iv3 != null && count$iv$iv$iv2 != null) {
                                }
                                if (count$iv$iv$iv2 != null) {
                                } else {
                                }
                                next$iv$iv$iv = i6;
                                i16 = count$iv$iv$iv2;
                                it$iv2 = count$iv$iv$iv;
                                count$iv$iv$iv2.add(i6);
                                if (count$iv$iv$iv2 != null) {
                                }
                                node$iv$iv$iv2 = 0;
                                count$iv$iv$iv2.add(this_$iv$iv$iv$iv3);
                                this_$iv$iv$iv$iv = i21;
                                $i$f$mutableVectorOf = 16;
                                i13 = 0;
                                count$iv$iv$iv = it$iv2;
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                i8 = $i$f$mutableVectorOf;
                                count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                node$iv$iv$iv2 = i6;
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                next$iv$iv$iv = i6;
                                this_$iv$iv$iv$iv = i4;
                            }
                            this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                            i10 = 1;
                            if (it$iv2 == i10) {
                            } else {
                            }
                            i4 = i10;
                            this_$iv2 = branches$iv$iv$iv;
                            this_$iv$iv$iv$iv3 = child$iv$iv$iv;
                            function1 = onFound;
                            i6 = node$iv$iv$iv$iv;
                            it$iv = 0;
                            i13 = 0;
                            if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                            } else {
                            }
                            this_$iv$iv$iv$iv = 0;
                            if (this_$iv$iv$iv$iv != 0) {
                            } else {
                            }
                            this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                            next$iv$iv$iv = i6;
                            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                            function1 = onFound;
                            this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                            i4 = 1;
                            it$iv2++;
                            if (it$iv2 == i4) {
                            } else {
                            }
                            if (i16 == 0) {
                            } else {
                            }
                            count$iv$iv$iv = it$iv2;
                            this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                            capacity$iv$iv$iv$iv$iv = 0;
                            count$iv$iv$iv2 = i16;
                            this_$iv$iv$iv$iv3 = node$iv$iv$iv2;
                            if (this_$iv$iv$iv$iv3 != null && count$iv$iv$iv2 != null) {
                            }
                            if (count$iv$iv$iv2 != null) {
                            } else {
                            }
                            next$iv$iv$iv = i6;
                            i16 = count$iv$iv$iv2;
                            it$iv2 = count$iv$iv$iv;
                            count$iv$iv$iv2.add(i6);
                            if (count$iv$iv$iv2 != null) {
                            }
                            node$iv$iv$iv2 = 0;
                            count$iv$iv$iv2.add(this_$iv$iv$iv$iv3);
                            this_$iv$iv$iv$iv = i21;
                            $i$f$mutableVectorOf = 16;
                            i13 = 0;
                            count$iv$iv$iv = it$iv2;
                            this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                            i8 = $i$f$mutableVectorOf;
                            count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                            node$iv$iv$iv2 = i6;
                            this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                            next$iv$iv$iv = i6;
                            this_$iv$iv$iv$iv = i4;
                            it$iv2 = i4;
                            obj5 = node$iv$iv$iv2;
                            i5 = 0;
                            obj7 = obj5;
                            i6 = 0;
                            if (obj7.fetchFocusProperties$ui_release().getCanFocus()) {
                            } else {
                            }
                            it$iv = obj5;
                            child$iv$iv$iv = this_$iv$iv$iv$iv3;
                            node$iv$iv$iv$iv = TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(obj7, FocusDirection.Companion.getEnter-dhqQ-8s(), function1);
                            if (node$iv$iv$iv$iv) {
                            } else {
                            }
                            i10 = i4;
                            success$iv = this_$iv2;
                            function1 = i4;
                            it$iv = obj5;
                            node$iv$iv$iv$iv = (Boolean)function1.invoke(obj7).booleanValue();
                            child$iv$iv$iv = this_$iv$iv$iv$iv3;
                            DelegatableNodeKt.access$addLayoutNodeChildren(this_$iv2, notEmpty);
                            DelegatableNodeKt.access$addLayoutNodeChildren(this_$iv2, obj4.getNode());
                        }
                        androidx.compose.ui.focus.FocusRequester this_$iv4 = this_$iv2;
                        int i23 = 0;
                        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
                        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv$iv;
                    }
                    this_$iv = this_$iv2;
                    i11 = this_$iv$iv$iv$iv3;
                    return success$iv;
                }
                androidx.compose.ui.focus.FocusRequester request = this_$iv2;
                int i24 = 0;
                IllegalStateException $i$a$CheckFocusRequester$findFocusTarget$3$iv = new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
                throw $i$a$CheckFocusRequester$findFocusTarget$3$iv;
            }
            androidx.compose.ui.focus.FocusRequester this_$iv3 = this_$iv2;
            int i17 = 0;
            IllegalStateException $i$a$CheckFocusRequester$findFocusTarget$2$iv = new IllegalStateException(str3.toString());
            throw $i$a$CheckFocusRequester$findFocusTarget$2$iv;
        }
        androidx.compose.ui.focus.FocusRequester this_$iv5 = this_$iv2;
        int i25 = 0;
        IllegalStateException $i$a$CheckFocusRequester$findFocusTarget$1$iv = new IllegalStateException(str3.toString());
        throw $i$a$CheckFocusRequester$findFocusTarget$1$iv;
    }

    public final boolean focus$ui_release() {
        return findFocusTargetNode$ui_release((Function1)FocusRequester.focus.1.INSTANCE);
    }

    public final boolean freeFocus() {
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        boolean freeFocus;
        if (!this.focusRequesterNodes.isNotEmpty()) {
        } else {
            MutableVector focusRequesterNodes2 = this.focusRequesterNodes;
            int i3 = 0;
            final int size = focusRequesterNodes2.getSize();
            if (size > 0) {
                i$iv = 0;
                i = 0;
                while (FocusRequesterModifierNodeKt.freeFocus((FocusRequesterModifierNode)focusRequesterNodes2.getContent()[i$iv])) {
                    i = 0;
                }
                return 1;
            }
            return 0;
        }
        int i2 = 0;
        IllegalStateException $i$a$CheckFocusRequester$freeFocus$1 = new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        throw $i$a$CheckFocusRequester$freeFocus$1;
    }

    public final MutableVector<androidx.compose.ui.focus.FocusRequesterModifierNode> getFocusRequesterNodes$ui_release() {
        return this.focusRequesterNodes;
    }

    public final void requestFocus() {
        focus$ui_release();
    }

    public final boolean restoreFocusedChild() {
        int success;
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        int i2;
        if (!this.focusRequesterNodes.isNotEmpty()) {
        } else {
            success = 0;
            MutableVector focusRequesterNodes2 = this.focusRequesterNodes;
            final int i3 = 0;
            final int size = focusRequesterNodes2.getSize();
            if (size > 0) {
                i$iv = 0;
                i = 0;
                do {
                    i = 0;
                    i2 = 1;
                    success = i2;
                    if (i$iv++ < size) {
                    }
                    if (success != 0) {
                    } else {
                    }
                    i2 = 0;
                } while (!FocusRequesterModifierNodeKt.restoreFocusedChild((FocusRequesterModifierNode)focusRequesterNodes2.getContent()[i$iv]));
            }
            return success;
        }
        int success2 = 0;
        IllegalStateException $i$a$CheckFocusRequester$restoreFocusedChild$1 = new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        throw $i$a$CheckFocusRequester$restoreFocusedChild$1;
    }

    public final boolean saveFocusedChild() {
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        boolean focusedChild;
        if (!this.focusRequesterNodes.isNotEmpty()) {
        } else {
            MutableVector focusRequesterNodes2 = this.focusRequesterNodes;
            int i3 = 0;
            final int size = focusRequesterNodes2.getSize();
            if (size > 0) {
                i$iv = 0;
                i = 0;
                while (FocusRequesterModifierNodeKt.saveFocusedChild((FocusRequesterModifierNode)focusRequesterNodes2.getContent()[i$iv])) {
                    i = 0;
                }
                return 1;
            }
            return 0;
        }
        int i2 = 0;
        IllegalStateException $i$a$CheckFocusRequester$saveFocusedChild$1 = new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        throw $i$a$CheckFocusRequester$saveFocusedChild$1;
    }
}
