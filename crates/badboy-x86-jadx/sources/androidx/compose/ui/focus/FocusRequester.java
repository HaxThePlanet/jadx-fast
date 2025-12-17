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
        int child$iv$iv3;
        Modifier.Node child$iv$iv4;
        int i13;
        int child$iv$iv;
        int i9;
        int i8;
        int success;
        Object success2;
        int node$iv$iv4;
        Object node$iv$iv2;
        Modifier.Node node$iv$iv;
        int node$iv$iv3;
        Object notEmpty;
        int i$iv;
        Object[] content;
        Object obj5;
        int i3;
        Object obj2;
        int $i$f$getFocusTargetOLwlOKw;
        int i5;
        int i;
        Object obj3;
        int i12;
        Object node$iv$iv5;
        int i7;
        Object size;
        int $i$f$findFocusTarget;
        int i6;
        Object obj4;
        int i10;
        int i2;
        Object node$iv$iv6;
        MutableVector branches$iv$iv;
        int i14;
        Modifier.Node child$iv$iv2;
        boolean booleanValue;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node;
        int i15;
        int count$iv$iv;
        int i11;
        int i4;
        int success3;
        Object obj;
        count$iv$iv2 = this;
        child$iv$iv3 = 0;
        node$iv$iv4 = 0;
        i9 = count$iv$iv2 != FocusRequester.Companion.getDefault() ? 1 : node$iv$iv4;
        String str3 = "\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n";
        if (i9 == 0) {
        } else {
            i8 = count$iv$iv2 != FocusRequester.Companion.getCancel() ? 1 : node$iv$iv4;
            if (i8 == 0) {
            } else {
                if (!count$iv$iv2.focusRequesterNodes.isNotEmpty()) {
                } else {
                    success = 0;
                    MutableVector focusRequesterNodes2 = count$iv$iv2.focusRequesterNodes;
                    final int i21 = 0;
                    final int size2 = focusRequesterNodes2.getSize();
                    if (size2 > 0) {
                        i$iv = 0;
                        i3 = 0;
                        int i22 = 0;
                        $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
                        i5 = 0;
                        i = $i$f$getFocusTargetOLwlOKw;
                        obj3 = obj2;
                        i12 = 0;
                        while (obj3.getNode().isAttached()) {
                            node$iv$iv5 = 0;
                            i7 = 1;
                            size = 0;
                            count$iv$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv4);
                            child$iv$iv4 = obj3.getNode().getChild$ui_release();
                            if (child$iv$iv4 == null) {
                            } else {
                            }
                            count$iv$iv2.add(child$iv$iv4);
                            while (count$iv$iv2.isNotEmpty()) {
                                int i24 = 0;
                                notEmpty = count$iv$iv2.removeAt(size + -1);
                                if (aggregateChildKindSet$ui_release &= i == 0) {
                                    break loop_15;
                                } else {
                                }
                                node$iv$iv5 = notEmpty;
                                while (node$iv$iv5 != null) {
                                    branches$iv$iv = count$iv$iv2;
                                    success3 = success;
                                    int child$iv$iv6 = i7;
                                    node$iv$iv5 = node$iv$iv5.getChild$ui_release();
                                    child$iv$iv4 = child$iv$iv2;
                                    node$iv$iv4 = 0;
                                }
                                branches$iv$iv = count$iv$iv2;
                                success3 = success;
                                int child$iv$iv5 = i7;
                                child$iv$iv4 = child$iv$iv2;
                                node$iv$iv4 = 0;
                                if (kindSet$ui_release &= i == 0) {
                                    break loop_15;
                                } else {
                                }
                                branches$iv$iv = count$iv$iv2;
                                success3 = success;
                                child$iv$iv6 = i7;
                                node$iv$iv5 = node$iv$iv5.getChild$ui_release();
                                child$iv$iv4 = child$iv$iv2;
                                node$iv$iv4 = 0;
                                i6 = 0;
                                i10 = 0;
                                i2 = 0;
                                int i25 = 0;
                                node$iv$iv4 = node$iv$iv6;
                                while (node$iv$iv4 != null) {
                                    branches$iv$iv = count$iv$iv2;
                                    child$iv$iv = onFound;
                                    i14 = 0;
                                    if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                    } else {
                                    }
                                    count$iv$iv2 = 0;
                                    if (count$iv$iv2 != 0 && node$iv$iv4 instanceof DelegatingNode) {
                                    } else {
                                    }
                                    success3 = success;
                                    obj = node$iv$iv4;
                                    i13 = i7;
                                    node$iv$iv2 = obj;
                                    node$iv$iv4 = DelegatableNodeKt.access$pop(i2);
                                    i7 = i13;
                                    count$iv$iv2 = branches$iv$iv;
                                    child$iv$iv4 = child$iv$iv2;
                                    success = success3;
                                    if (node$iv$iv4 instanceof DelegatingNode) {
                                    } else {
                                    }
                                    count$iv$iv2 = 0;
                                    booleanValue = 0;
                                    node$iv$iv$iv = (DelegatingNode)node$iv$iv4.getDelegate$ui_release();
                                    while (node$iv$iv$iv != null) {
                                        node = node$iv$iv$iv;
                                        i15 = 0;
                                        i11 = 0;
                                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                        } else {
                                        }
                                        count$iv$iv = 0;
                                        if (count$iv$iv != 0) {
                                        } else {
                                        }
                                        success3 = success;
                                        node$iv$iv = node;
                                        success2 = obj;
                                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                        child$iv$iv = onFound;
                                        node$iv$iv4 = success2;
                                        success = success3;
                                        i7 = 1;
                                        count$iv$iv2++;
                                        if (count$iv$iv2 == i7) {
                                        } else {
                                        }
                                        if (i2 == 0) {
                                        } else {
                                        }
                                        count$iv$iv = count$iv$iv2;
                                        success3 = success;
                                        obj = node$iv$iv4;
                                        node$iv$iv3 = 0;
                                        child$iv$iv = i2;
                                        Object obj7 = obj;
                                        if (obj7 != null) {
                                        } else {
                                        }
                                        success2 = obj;
                                        if (child$iv$iv != 0) {
                                        } else {
                                        }
                                        node$iv$iv = node;
                                        i2 = child$iv$iv;
                                        count$iv$iv2 = count$iv$iv;
                                        child$iv$iv.add(node);
                                        if (child$iv$iv != 0) {
                                        }
                                        success2 = 0;
                                        child$iv$iv.add(obj7);
                                        count$iv$iv = count$iv$iv2;
                                        i11 = 0;
                                        i4 = i20;
                                        success3 = success;
                                        obj = node$iv$iv4;
                                        child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                        success3 = success;
                                        success2 = node$iv$iv;
                                        count$iv$iv = i7;
                                    }
                                    obj = node$iv$iv4;
                                    i13 = 1;
                                    if (count$iv$iv2 == i13) {
                                    } else {
                                    }
                                    node$iv$iv2 = obj;
                                    i7 = i13;
                                    count$iv$iv2 = branches$iv$iv;
                                    child$iv$iv4 = child$iv$iv2;
                                    success = success3;
                                    node$iv$iv4 = obj;
                                    node = node$iv$iv$iv;
                                    i15 = 0;
                                    i11 = 0;
                                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                    } else {
                                    }
                                    count$iv$iv = 0;
                                    if (count$iv$iv != 0) {
                                    } else {
                                    }
                                    success3 = success;
                                    node$iv$iv = node;
                                    success2 = obj;
                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                    child$iv$iv = onFound;
                                    node$iv$iv4 = success2;
                                    success = success3;
                                    i7 = 1;
                                    count$iv$iv2++;
                                    if (count$iv$iv2 == i7) {
                                    } else {
                                    }
                                    if (i2 == 0) {
                                    } else {
                                    }
                                    count$iv$iv = count$iv$iv2;
                                    success3 = success;
                                    obj = node$iv$iv4;
                                    node$iv$iv3 = 0;
                                    child$iv$iv = i2;
                                    obj7 = obj;
                                    if (obj7 != null) {
                                    } else {
                                    }
                                    success2 = obj;
                                    if (child$iv$iv != 0) {
                                    } else {
                                    }
                                    node$iv$iv = node;
                                    i2 = child$iv$iv;
                                    count$iv$iv2 = count$iv$iv;
                                    child$iv$iv.add(node);
                                    if (child$iv$iv != 0) {
                                    }
                                    success2 = 0;
                                    child$iv$iv.add(obj7);
                                    count$iv$iv = count$iv$iv2;
                                    i11 = 0;
                                    i4 = i20;
                                    success3 = success;
                                    obj = node$iv$iv4;
                                    child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                    success3 = success;
                                    success2 = node$iv$iv;
                                    count$iv$iv = i7;
                                    count$iv$iv2 = i7;
                                    i14 = 0;
                                    child$iv$iv2 = child$iv$iv4;
                                    success3 = success;
                                    obj = node$iv$iv4;
                                    i13 = i7;
                                }
                                branches$iv$iv = count$iv$iv2;
                                success3 = success;
                                obj = node$iv$iv4;
                                int child$iv$iv8 = i7;
                                child$iv$iv4 = child$iv$iv2;
                                node$iv$iv4 = 0;
                                branches$iv$iv = count$iv$iv2;
                                child$iv$iv = onFound;
                                i14 = 0;
                                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                count$iv$iv2 = 0;
                                if (count$iv$iv2 != 0 && node$iv$iv4 instanceof DelegatingNode) {
                                } else {
                                }
                                success3 = success;
                                obj = node$iv$iv4;
                                i13 = i7;
                                node$iv$iv2 = obj;
                                node$iv$iv4 = DelegatableNodeKt.access$pop(i2);
                                i7 = i13;
                                count$iv$iv2 = branches$iv$iv;
                                child$iv$iv4 = child$iv$iv2;
                                success = success3;
                                if (node$iv$iv4 instanceof DelegatingNode) {
                                } else {
                                }
                                count$iv$iv2 = 0;
                                booleanValue = 0;
                                node$iv$iv$iv = (DelegatingNode)node$iv$iv4.getDelegate$ui_release();
                                while (node$iv$iv$iv != null) {
                                    node = node$iv$iv$iv;
                                    i15 = 0;
                                    i11 = 0;
                                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                    } else {
                                    }
                                    count$iv$iv = 0;
                                    if (count$iv$iv != 0) {
                                    } else {
                                    }
                                    success3 = success;
                                    node$iv$iv = node;
                                    success2 = obj;
                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                    child$iv$iv = onFound;
                                    node$iv$iv4 = success2;
                                    success = success3;
                                    i7 = 1;
                                    count$iv$iv2++;
                                    if (count$iv$iv2 == i7) {
                                    } else {
                                    }
                                    if (i2 == 0) {
                                    } else {
                                    }
                                    count$iv$iv = count$iv$iv2;
                                    success3 = success;
                                    obj = node$iv$iv4;
                                    node$iv$iv3 = 0;
                                    child$iv$iv = i2;
                                    obj7 = obj;
                                    if (obj7 != null) {
                                    } else {
                                    }
                                    success2 = obj;
                                    if (child$iv$iv != 0) {
                                    } else {
                                    }
                                    node$iv$iv = node;
                                    i2 = child$iv$iv;
                                    count$iv$iv2 = count$iv$iv;
                                    child$iv$iv.add(node);
                                    if (child$iv$iv != 0) {
                                    }
                                    success2 = 0;
                                    child$iv$iv.add(obj7);
                                    count$iv$iv = count$iv$iv2;
                                    i11 = 0;
                                    i4 = i20;
                                    success3 = success;
                                    obj = node$iv$iv4;
                                    child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                    success3 = success;
                                    success2 = node$iv$iv;
                                    count$iv$iv = i7;
                                }
                                obj = node$iv$iv4;
                                i13 = 1;
                                if (count$iv$iv2 == i13) {
                                } else {
                                }
                                node$iv$iv2 = obj;
                                i7 = i13;
                                count$iv$iv2 = branches$iv$iv;
                                child$iv$iv4 = child$iv$iv2;
                                success = success3;
                                node$iv$iv4 = obj;
                                node = node$iv$iv$iv;
                                i15 = 0;
                                i11 = 0;
                                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                count$iv$iv = 0;
                                if (count$iv$iv != 0) {
                                } else {
                                }
                                success3 = success;
                                node$iv$iv = node;
                                success2 = obj;
                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                child$iv$iv = onFound;
                                node$iv$iv4 = success2;
                                success = success3;
                                i7 = 1;
                                count$iv$iv2++;
                                if (count$iv$iv2 == i7) {
                                } else {
                                }
                                if (i2 == 0) {
                                } else {
                                }
                                count$iv$iv = count$iv$iv2;
                                success3 = success;
                                obj = node$iv$iv4;
                                node$iv$iv3 = 0;
                                child$iv$iv = i2;
                                obj7 = obj;
                                if (obj7 != null) {
                                } else {
                                }
                                success2 = obj;
                                if (child$iv$iv != 0) {
                                } else {
                                }
                                node$iv$iv = node;
                                i2 = child$iv$iv;
                                count$iv$iv2 = count$iv$iv;
                                child$iv$iv.add(node);
                                if (child$iv$iv != 0) {
                                }
                                success2 = 0;
                                child$iv$iv.add(obj7);
                                count$iv$iv = count$iv$iv2;
                                i11 = 0;
                                i4 = i20;
                                success3 = success;
                                obj = node$iv$iv4;
                                child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                success3 = success;
                                success2 = node$iv$iv;
                                count$iv$iv = i7;
                                count$iv$iv2 = i7;
                                i14 = 0;
                                child$iv$iv2 = child$iv$iv4;
                                success3 = success;
                                obj = node$iv$iv4;
                                i13 = i7;
                                DelegatableNodeKt.access$addLayoutNodeChildren(count$iv$iv2, notEmpty);
                            }
                            branches$iv$iv = count$iv$iv2;
                            child$iv$iv2 = child$iv$iv4;
                            success3 = success;
                            child$iv$iv3 = i7;
                            node$iv$iv4 = 0;
                            count$iv$iv2 = this;
                            child$iv$iv3 = $i$f$findFocusTarget;
                            i3 = 0;
                            i22 = 0;
                            $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
                            i5 = 0;
                            i = $i$f$getFocusTargetOLwlOKw;
                            obj3 = obj2;
                            i12 = 0;
                            i24 = 0;
                            notEmpty = count$iv$iv2.removeAt(size + -1);
                            if (aggregateChildKindSet$ui_release &= i == 0) {
                            } else {
                            }
                            node$iv$iv5 = notEmpty;
                            while (node$iv$iv5 != null) {
                                branches$iv$iv = count$iv$iv2;
                                success3 = success;
                                child$iv$iv6 = i7;
                                node$iv$iv5 = node$iv$iv5.getChild$ui_release();
                                child$iv$iv4 = child$iv$iv2;
                                node$iv$iv4 = 0;
                            }
                            branches$iv$iv = count$iv$iv2;
                            success3 = success;
                            child$iv$iv5 = i7;
                            child$iv$iv4 = child$iv$iv2;
                            node$iv$iv4 = 0;
                            if (kindSet$ui_release &= i != 0) {
                            } else {
                            }
                            branches$iv$iv = count$iv$iv2;
                            success3 = success;
                            child$iv$iv6 = i7;
                            node$iv$iv5 = node$iv$iv5.getChild$ui_release();
                            child$iv$iv4 = child$iv$iv2;
                            node$iv$iv4 = 0;
                            i6 = 0;
                            i10 = 0;
                            i2 = 0;
                            i25 = 0;
                            node$iv$iv4 = node$iv$iv6;
                            while (node$iv$iv4 != null) {
                                branches$iv$iv = count$iv$iv2;
                                child$iv$iv = onFound;
                                i14 = 0;
                                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                count$iv$iv2 = 0;
                                if (count$iv$iv2 != 0 && node$iv$iv4 instanceof DelegatingNode) {
                                } else {
                                }
                                success3 = success;
                                obj = node$iv$iv4;
                                i13 = i7;
                                node$iv$iv2 = obj;
                                node$iv$iv4 = DelegatableNodeKt.access$pop(i2);
                                i7 = i13;
                                count$iv$iv2 = branches$iv$iv;
                                child$iv$iv4 = child$iv$iv2;
                                success = success3;
                                if (node$iv$iv4 instanceof DelegatingNode) {
                                } else {
                                }
                                count$iv$iv2 = 0;
                                booleanValue = 0;
                                node$iv$iv$iv = (DelegatingNode)node$iv$iv4.getDelegate$ui_release();
                                while (node$iv$iv$iv != null) {
                                    node = node$iv$iv$iv;
                                    i15 = 0;
                                    i11 = 0;
                                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                    } else {
                                    }
                                    count$iv$iv = 0;
                                    if (count$iv$iv != 0) {
                                    } else {
                                    }
                                    success3 = success;
                                    node$iv$iv = node;
                                    success2 = obj;
                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                    child$iv$iv = onFound;
                                    node$iv$iv4 = success2;
                                    success = success3;
                                    i7 = 1;
                                    count$iv$iv2++;
                                    if (count$iv$iv2 == i7) {
                                    } else {
                                    }
                                    if (i2 == 0) {
                                    } else {
                                    }
                                    count$iv$iv = count$iv$iv2;
                                    success3 = success;
                                    obj = node$iv$iv4;
                                    node$iv$iv3 = 0;
                                    child$iv$iv = i2;
                                    obj7 = obj;
                                    if (obj7 != null) {
                                    } else {
                                    }
                                    success2 = obj;
                                    if (child$iv$iv != 0) {
                                    } else {
                                    }
                                    node$iv$iv = node;
                                    i2 = child$iv$iv;
                                    count$iv$iv2 = count$iv$iv;
                                    child$iv$iv.add(node);
                                    if (child$iv$iv != 0) {
                                    }
                                    success2 = 0;
                                    child$iv$iv.add(obj7);
                                    count$iv$iv = count$iv$iv2;
                                    i11 = 0;
                                    i4 = i20;
                                    success3 = success;
                                    obj = node$iv$iv4;
                                    child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                    success3 = success;
                                    success2 = node$iv$iv;
                                    count$iv$iv = i7;
                                }
                                obj = node$iv$iv4;
                                i13 = 1;
                                if (count$iv$iv2 == i13) {
                                } else {
                                }
                                node$iv$iv2 = obj;
                                i7 = i13;
                                count$iv$iv2 = branches$iv$iv;
                                child$iv$iv4 = child$iv$iv2;
                                success = success3;
                                node$iv$iv4 = obj;
                                node = node$iv$iv$iv;
                                i15 = 0;
                                i11 = 0;
                                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                count$iv$iv = 0;
                                if (count$iv$iv != 0) {
                                } else {
                                }
                                success3 = success;
                                node$iv$iv = node;
                                success2 = obj;
                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                child$iv$iv = onFound;
                                node$iv$iv4 = success2;
                                success = success3;
                                i7 = 1;
                                count$iv$iv2++;
                                if (count$iv$iv2 == i7) {
                                } else {
                                }
                                if (i2 == 0) {
                                } else {
                                }
                                count$iv$iv = count$iv$iv2;
                                success3 = success;
                                obj = node$iv$iv4;
                                node$iv$iv3 = 0;
                                child$iv$iv = i2;
                                obj7 = obj;
                                if (obj7 != null) {
                                } else {
                                }
                                success2 = obj;
                                if (child$iv$iv != 0) {
                                } else {
                                }
                                node$iv$iv = node;
                                i2 = child$iv$iv;
                                count$iv$iv2 = count$iv$iv;
                                child$iv$iv.add(node);
                                if (child$iv$iv != 0) {
                                }
                                success2 = 0;
                                child$iv$iv.add(obj7);
                                count$iv$iv = count$iv$iv2;
                                i11 = 0;
                                i4 = i20;
                                success3 = success;
                                obj = node$iv$iv4;
                                child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                success3 = success;
                                success2 = node$iv$iv;
                                count$iv$iv = i7;
                                count$iv$iv2 = i7;
                                i14 = 0;
                                child$iv$iv2 = child$iv$iv4;
                                success3 = success;
                                obj = node$iv$iv4;
                                i13 = i7;
                            }
                            branches$iv$iv = count$iv$iv2;
                            success3 = success;
                            obj = node$iv$iv4;
                            child$iv$iv8 = i7;
                            child$iv$iv4 = child$iv$iv2;
                            node$iv$iv4 = 0;
                            branches$iv$iv = count$iv$iv2;
                            if (node$iv$iv4 instanceof FocusTargetNode) {
                            } else {
                            }
                            child$iv$iv = onFound;
                            i14 = 0;
                            if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                            } else {
                            }
                            count$iv$iv2 = 0;
                            if (count$iv$iv2 != 0 && node$iv$iv4 instanceof DelegatingNode) {
                            } else {
                            }
                            success3 = success;
                            obj = node$iv$iv4;
                            i13 = i7;
                            node$iv$iv2 = obj;
                            node$iv$iv4 = DelegatableNodeKt.access$pop(i2);
                            i7 = i13;
                            count$iv$iv2 = branches$iv$iv;
                            child$iv$iv4 = child$iv$iv2;
                            success = success3;
                            if (node$iv$iv4 instanceof DelegatingNode) {
                            } else {
                            }
                            count$iv$iv2 = 0;
                            booleanValue = 0;
                            node$iv$iv$iv = (DelegatingNode)node$iv$iv4.getDelegate$ui_release();
                            while (node$iv$iv$iv != null) {
                                node = node$iv$iv$iv;
                                i15 = 0;
                                i11 = 0;
                                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                count$iv$iv = 0;
                                if (count$iv$iv != 0) {
                                } else {
                                }
                                success3 = success;
                                node$iv$iv = node;
                                success2 = obj;
                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                child$iv$iv = onFound;
                                node$iv$iv4 = success2;
                                success = success3;
                                i7 = 1;
                                count$iv$iv2++;
                                if (count$iv$iv2 == i7) {
                                } else {
                                }
                                if (i2 == 0) {
                                } else {
                                }
                                count$iv$iv = count$iv$iv2;
                                success3 = success;
                                obj = node$iv$iv4;
                                node$iv$iv3 = 0;
                                child$iv$iv = i2;
                                obj7 = obj;
                                if (obj7 != null) {
                                } else {
                                }
                                success2 = obj;
                                if (child$iv$iv != 0) {
                                } else {
                                }
                                node$iv$iv = node;
                                i2 = child$iv$iv;
                                count$iv$iv2 = count$iv$iv;
                                child$iv$iv.add(node);
                                if (child$iv$iv != 0) {
                                }
                                success2 = 0;
                                child$iv$iv.add(obj7);
                                count$iv$iv = count$iv$iv2;
                                i11 = 0;
                                i4 = i20;
                                success3 = success;
                                obj = node$iv$iv4;
                                child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                success3 = success;
                                success2 = node$iv$iv;
                                count$iv$iv = i7;
                            }
                            obj = node$iv$iv4;
                            i13 = 1;
                            if (count$iv$iv2 == i13) {
                            } else {
                            }
                            node$iv$iv2 = obj;
                            i7 = i13;
                            count$iv$iv2 = branches$iv$iv;
                            child$iv$iv4 = child$iv$iv2;
                            success = success3;
                            node$iv$iv4 = obj;
                            node = node$iv$iv$iv;
                            i15 = 0;
                            i11 = 0;
                            if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                            } else {
                            }
                            count$iv$iv = 0;
                            if (count$iv$iv != 0) {
                            } else {
                            }
                            success3 = success;
                            node$iv$iv = node;
                            success2 = obj;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            child$iv$iv = onFound;
                            node$iv$iv4 = success2;
                            success = success3;
                            i7 = 1;
                            count$iv$iv2++;
                            if (count$iv$iv2 == i7) {
                            } else {
                            }
                            if (i2 == 0) {
                            } else {
                            }
                            count$iv$iv = count$iv$iv2;
                            success3 = success;
                            obj = node$iv$iv4;
                            node$iv$iv3 = 0;
                            child$iv$iv = i2;
                            obj7 = obj;
                            if (obj7 != null) {
                            } else {
                            }
                            success2 = obj;
                            if (child$iv$iv != 0) {
                            } else {
                            }
                            node$iv$iv = node;
                            i2 = child$iv$iv;
                            count$iv$iv2 = count$iv$iv;
                            child$iv$iv.add(node);
                            if (child$iv$iv != 0) {
                            }
                            success2 = 0;
                            child$iv$iv.add(obj7);
                            count$iv$iv = count$iv$iv2;
                            i11 = 0;
                            i4 = i20;
                            success3 = success;
                            obj = node$iv$iv4;
                            child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                            success3 = success;
                            success2 = node$iv$iv;
                            count$iv$iv = i7;
                            count$iv$iv2 = i7;
                            i14 = 0;
                            child$iv$iv2 = child$iv$iv4;
                            if ((Boolean)onFound.invoke((FocusTargetNode)node$iv$iv4).booleanValue()) {
                            } else {
                            }
                            success3 = success;
                            obj = node$iv$iv4;
                            i13 = i7;
                            success = 1;
                            child$iv$iv3 = i7;
                            DelegatableNodeKt.access$addLayoutNodeChildren(count$iv$iv2, notEmpty);
                            DelegatableNodeKt.access$addLayoutNodeChildren(count$iv$iv2, obj3.getNode());
                        }
                        int $i$f$findFocusTarget4 = child$iv$iv3;
                        int i17 = 0;
                        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
                        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv;
                    }
                    $i$f$findFocusTarget = child$iv$iv3;
                    return success;
                }
                int $i$f$findFocusTarget5 = child$iv$iv3;
                int i18 = 0;
                IllegalStateException $i$a$CheckFocusRequester$findFocusTarget$3 = new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
                throw $i$a$CheckFocusRequester$findFocusTarget$3;
            }
            int $i$f$findFocusTarget3 = child$iv$iv3;
            int i16 = 0;
            IllegalStateException $i$a$CheckFocusRequester$findFocusTarget$2 = new IllegalStateException(str3.toString());
            throw $i$a$CheckFocusRequester$findFocusTarget$2;
        }
        int $i$f$findFocusTarget6 = child$iv$iv3;
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
        int i;
        androidx.compose.ui.focus.FocusRequester this_$iv;
        Object it$iv2;
        MutableVector count$iv$iv$iv2;
        int this_$iv$iv$iv$iv2;
        int i6;
        int i3;
        int success$iv;
        int node$iv$iv$iv;
        Object notEmpty;
        int i$iv$iv;
        Object[] content;
        Object obj;
        int i7;
        Object obj2;
        int $i$f$getFocusTargetOLwlOKw;
        int i2;
        int i12;
        Object obj4;
        int i11;
        Object node$iv$iv$iv3;
        int i13;
        Object size;
        androidx.compose.ui.focus.FocusRequester this_$iv2;
        int i8;
        int i9;
        Object obj3;
        int i10;
        int i4;
        Object node$iv$iv$iv2;
        MutableVector branches$iv$iv$iv;
        int i15;
        boolean node$iv$iv$iv$iv;
        int i14;
        Object it$iv;
        Modifier.Node child$iv$iv$iv;
        int this_$iv$iv$iv$iv3;
        int i16;
        int count$iv$iv$iv;
        Object this_$iv$iv$iv$iv;
        int i5;
        function1 = onFound;
        this_$iv = this;
        node$iv$iv$iv = 0;
        i6 = this_$iv != FocusRequester.Companion.getDefault() ? 1 : node$iv$iv$iv;
        String str3 = "\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n";
        if (i6 == 0) {
        } else {
            i3 = this_$iv != FocusRequester.Companion.getCancel() ? 1 : node$iv$iv$iv;
            if (i3 == 0) {
            } else {
                if (!this_$iv.focusRequesterNodes.isNotEmpty()) {
                } else {
                    success$iv = 0;
                    MutableVector focusRequesterNodes2 = this_$iv.focusRequesterNodes;
                    final int i26 = 0;
                    final int size2 = focusRequesterNodes2.getSize();
                    if (size2 > 0) {
                        i$iv$iv = 0;
                        i7 = 0;
                        int i27 = 0;
                        $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
                        i2 = 0;
                        i12 = $i$f$getFocusTargetOLwlOKw;
                        obj4 = obj2;
                        i11 = 0;
                        while (obj4.getNode().isAttached()) {
                            node$iv$iv$iv3 = 0;
                            i13 = 1;
                            size = 0;
                            this_$iv = new MutableVector(new Modifier.Node[16], node$iv$iv$iv);
                            this_$iv$iv$iv$iv2 = obj4.getNode().getChild$ui_release();
                            if (this_$iv$iv$iv$iv2 == null) {
                            } else {
                            }
                            this_$iv.add(this_$iv$iv$iv$iv2);
                            while (this_$iv.isNotEmpty()) {
                                int i29 = 0;
                                notEmpty = this_$iv.removeAt(size + -1);
                                if (aggregateChildKindSet$ui_release &= i12 == 0) {
                                    break loop_15;
                                } else {
                                }
                                node$iv$iv$iv3 = notEmpty;
                                while (node$iv$iv$iv3 != null) {
                                    branches$iv$iv$iv = this_$iv;
                                    child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                    int i19 = i13;
                                    node$iv$iv$iv3 = node$iv$iv$iv3.getChild$ui_release();
                                    node$iv$iv$iv = 0;
                                    function1 = onFound;
                                }
                                branches$iv$iv$iv = this_$iv;
                                child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                int i18 = i13;
                                node$iv$iv$iv = 0;
                                function1 = onFound;
                                if (kindSet$ui_release &= i12 == 0) {
                                    break loop_15;
                                } else {
                                }
                                branches$iv$iv$iv = this_$iv;
                                child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                i19 = i13;
                                node$iv$iv$iv3 = node$iv$iv$iv3.getChild$ui_release();
                                node$iv$iv$iv = 0;
                                function1 = onFound;
                                i9 = 0;
                                i10 = 0;
                                i4 = 0;
                                int i30 = 0;
                                node$iv$iv$iv = node$iv$iv$iv2;
                                while (node$iv$iv$iv != null) {
                                    branches$iv$iv$iv = this_$iv;
                                    this_$iv$iv$iv$iv2 = 0;
                                    if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                    } else {
                                    }
                                    it$iv2 = 0;
                                    if (it$iv2 != 0 && node$iv$iv$iv instanceof DelegatingNode) {
                                    } else {
                                    }
                                    i = i13;
                                    node$iv$iv$iv = DelegatableNodeKt.access$pop(i4);
                                    i13 = i;
                                    this_$iv = branches$iv$iv$iv;
                                    this_$iv$iv$iv$iv2 = child$iv$iv$iv;
                                    function1 = onFound;
                                    if (node$iv$iv$iv instanceof DelegatingNode) {
                                    } else {
                                    }
                                    it$iv2 = 0;
                                    i15 = 0;
                                    node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv.getDelegate$ui_release();
                                    while (node$iv$iv$iv$iv != null) {
                                        i14 = node$iv$iv$iv$iv;
                                        it$iv = 0;
                                        i16 = 0;
                                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv$iv3 = 0;
                                        if (this_$iv$iv$iv$iv3 != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                        next$iv$iv$iv = i14;
                                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                        function1 = onFound;
                                        this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv;
                                        i13 = 1;
                                        it$iv2++;
                                        if (it$iv2 == i13) {
                                        } else {
                                        }
                                        if (i4 == 0) {
                                        } else {
                                        }
                                        count$iv$iv$iv = it$iv2;
                                        this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                        capacity$iv$iv$iv$iv$iv = 0;
                                        count$iv$iv$iv2 = i4;
                                        this_$iv$iv$iv$iv2 = node$iv$iv$iv;
                                        if (this_$iv$iv$iv$iv2 != null && count$iv$iv$iv2 != null) {
                                        }
                                        if (count$iv$iv$iv2 != null) {
                                        } else {
                                        }
                                        next$iv$iv$iv = i14;
                                        i4 = count$iv$iv$iv2;
                                        it$iv2 = count$iv$iv$iv;
                                        count$iv$iv$iv2.add(i14);
                                        if (count$iv$iv$iv2 != null) {
                                        }
                                        node$iv$iv$iv = 0;
                                        count$iv$iv$iv2.add(this_$iv$iv$iv$iv2);
                                        this_$iv$iv$iv$iv3 = i21;
                                        int $i$f$mutableVectorOf = 16;
                                        i16 = 0;
                                        count$iv$iv$iv = it$iv2;
                                        this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                        i5 = $i$f$mutableVectorOf;
                                        count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                        node$iv$iv$iv = i14;
                                        this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                        next$iv$iv$iv = i14;
                                        this_$iv$iv$iv$iv3 = i13;
                                    }
                                    this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                    i = 1;
                                    if (it$iv2 == i) {
                                    } else {
                                    }
                                    i13 = i;
                                    this_$iv = branches$iv$iv$iv;
                                    this_$iv$iv$iv$iv2 = child$iv$iv$iv;
                                    function1 = onFound;
                                    i14 = node$iv$iv$iv$iv;
                                    it$iv = 0;
                                    i16 = 0;
                                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv3 = 0;
                                    if (this_$iv$iv$iv$iv3 != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                    next$iv$iv$iv = i14;
                                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                    function1 = onFound;
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv;
                                    i13 = 1;
                                    it$iv2++;
                                    if (it$iv2 == i13) {
                                    } else {
                                    }
                                    if (i4 == 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv = it$iv2;
                                    this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                    capacity$iv$iv$iv$iv$iv = 0;
                                    count$iv$iv$iv2 = i4;
                                    this_$iv$iv$iv$iv2 = node$iv$iv$iv;
                                    if (this_$iv$iv$iv$iv2 != null && count$iv$iv$iv2 != null) {
                                    }
                                    if (count$iv$iv$iv2 != null) {
                                    } else {
                                    }
                                    next$iv$iv$iv = i14;
                                    i4 = count$iv$iv$iv2;
                                    it$iv2 = count$iv$iv$iv;
                                    count$iv$iv$iv2.add(i14);
                                    if (count$iv$iv$iv2 != null) {
                                    }
                                    node$iv$iv$iv = 0;
                                    count$iv$iv$iv2.add(this_$iv$iv$iv$iv2);
                                    this_$iv$iv$iv$iv3 = i21;
                                    $i$f$mutableVectorOf = 16;
                                    i16 = 0;
                                    count$iv$iv$iv = it$iv2;
                                    this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                    i5 = $i$f$mutableVectorOf;
                                    count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                    node$iv$iv$iv = i14;
                                    this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                    next$iv$iv$iv = i14;
                                    this_$iv$iv$iv$iv3 = i13;
                                    it$iv2 = i13;
                                    Object obj5 = node$iv$iv$iv;
                                    i15 = 0;
                                    Object obj7 = obj5;
                                    i14 = 0;
                                    if (obj7.fetchFocusProperties$ui_release().getCanFocus()) {
                                    } else {
                                    }
                                    it$iv = obj5;
                                    child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                    node$iv$iv$iv$iv = TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(obj7, FocusDirection.Companion.getEnter-dhqQ-8s(), function1);
                                    i = i13;
                                    it$iv = obj5;
                                    node$iv$iv$iv$iv = (Boolean)function1.invoke(obj7).booleanValue();
                                    child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                }
                                branches$iv$iv$iv = this_$iv;
                                child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                int i22 = i13;
                                node$iv$iv$iv = 0;
                                function1 = onFound;
                                branches$iv$iv$iv = this_$iv;
                                this_$iv$iv$iv$iv2 = 0;
                                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                it$iv2 = 0;
                                if (it$iv2 != 0 && node$iv$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                i = i13;
                                node$iv$iv$iv = DelegatableNodeKt.access$pop(i4);
                                i13 = i;
                                this_$iv = branches$iv$iv$iv;
                                this_$iv$iv$iv$iv2 = child$iv$iv$iv;
                                function1 = onFound;
                                if (node$iv$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                it$iv2 = 0;
                                i15 = 0;
                                node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv.getDelegate$ui_release();
                                while (node$iv$iv$iv$iv != null) {
                                    i14 = node$iv$iv$iv$iv;
                                    it$iv = 0;
                                    i16 = 0;
                                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv3 = 0;
                                    if (this_$iv$iv$iv$iv3 != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                    next$iv$iv$iv = i14;
                                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                    function1 = onFound;
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv;
                                    i13 = 1;
                                    it$iv2++;
                                    if (it$iv2 == i13) {
                                    } else {
                                    }
                                    if (i4 == 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv = it$iv2;
                                    this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                    capacity$iv$iv$iv$iv$iv = 0;
                                    count$iv$iv$iv2 = i4;
                                    this_$iv$iv$iv$iv2 = node$iv$iv$iv;
                                    if (this_$iv$iv$iv$iv2 != null && count$iv$iv$iv2 != null) {
                                    }
                                    if (count$iv$iv$iv2 != null) {
                                    } else {
                                    }
                                    next$iv$iv$iv = i14;
                                    i4 = count$iv$iv$iv2;
                                    it$iv2 = count$iv$iv$iv;
                                    count$iv$iv$iv2.add(i14);
                                    if (count$iv$iv$iv2 != null) {
                                    }
                                    node$iv$iv$iv = 0;
                                    count$iv$iv$iv2.add(this_$iv$iv$iv$iv2);
                                    this_$iv$iv$iv$iv3 = i21;
                                    $i$f$mutableVectorOf = 16;
                                    i16 = 0;
                                    count$iv$iv$iv = it$iv2;
                                    this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                    i5 = $i$f$mutableVectorOf;
                                    count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                    node$iv$iv$iv = i14;
                                    this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                    next$iv$iv$iv = i14;
                                    this_$iv$iv$iv$iv3 = i13;
                                }
                                this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                i = 1;
                                if (it$iv2 == i) {
                                } else {
                                }
                                i13 = i;
                                this_$iv = branches$iv$iv$iv;
                                this_$iv$iv$iv$iv2 = child$iv$iv$iv;
                                function1 = onFound;
                                i14 = node$iv$iv$iv$iv;
                                it$iv = 0;
                                i16 = 0;
                                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv3 = 0;
                                if (this_$iv$iv$iv$iv3 != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                next$iv$iv$iv = i14;
                                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                function1 = onFound;
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv;
                                i13 = 1;
                                it$iv2++;
                                if (it$iv2 == i13) {
                                } else {
                                }
                                if (i4 == 0) {
                                } else {
                                }
                                count$iv$iv$iv = it$iv2;
                                this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                capacity$iv$iv$iv$iv$iv = 0;
                                count$iv$iv$iv2 = i4;
                                this_$iv$iv$iv$iv2 = node$iv$iv$iv;
                                if (this_$iv$iv$iv$iv2 != null && count$iv$iv$iv2 != null) {
                                }
                                if (count$iv$iv$iv2 != null) {
                                } else {
                                }
                                next$iv$iv$iv = i14;
                                i4 = count$iv$iv$iv2;
                                it$iv2 = count$iv$iv$iv;
                                count$iv$iv$iv2.add(i14);
                                if (count$iv$iv$iv2 != null) {
                                }
                                node$iv$iv$iv = 0;
                                count$iv$iv$iv2.add(this_$iv$iv$iv$iv2);
                                this_$iv$iv$iv$iv3 = i21;
                                $i$f$mutableVectorOf = 16;
                                i16 = 0;
                                count$iv$iv$iv = it$iv2;
                                this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                i5 = $i$f$mutableVectorOf;
                                count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                node$iv$iv$iv = i14;
                                this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                next$iv$iv$iv = i14;
                                this_$iv$iv$iv$iv3 = i13;
                                it$iv2 = i13;
                                obj5 = node$iv$iv$iv;
                                i15 = 0;
                                obj7 = obj5;
                                i14 = 0;
                                if (obj7.fetchFocusProperties$ui_release().getCanFocus()) {
                                } else {
                                }
                                it$iv = obj5;
                                child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                node$iv$iv$iv$iv = TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(obj7, FocusDirection.Companion.getEnter-dhqQ-8s(), function1);
                                i = i13;
                                it$iv = obj5;
                                node$iv$iv$iv$iv = (Boolean)function1.invoke(obj7).booleanValue();
                                child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                DelegatableNodeKt.access$addLayoutNodeChildren(this_$iv, notEmpty);
                            }
                            branches$iv$iv$iv = this_$iv;
                            child$iv$iv$iv = this_$iv$iv$iv$iv2;
                            function1 = i13;
                            function1 = onFound;
                            this_$iv = this_$iv2;
                            this_$iv$iv$iv$iv2 = i8;
                            node$iv$iv$iv = 0;
                            i7 = 0;
                            i27 = 0;
                            $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
                            i2 = 0;
                            i12 = $i$f$getFocusTargetOLwlOKw;
                            obj4 = obj2;
                            i11 = 0;
                            i29 = 0;
                            notEmpty = this_$iv.removeAt(size + -1);
                            if (aggregateChildKindSet$ui_release &= i12 == 0) {
                            } else {
                            }
                            node$iv$iv$iv3 = notEmpty;
                            while (node$iv$iv$iv3 != null) {
                                branches$iv$iv$iv = this_$iv;
                                child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                i19 = i13;
                                node$iv$iv$iv3 = node$iv$iv$iv3.getChild$ui_release();
                                node$iv$iv$iv = 0;
                                function1 = onFound;
                            }
                            branches$iv$iv$iv = this_$iv;
                            child$iv$iv$iv = this_$iv$iv$iv$iv2;
                            i18 = i13;
                            node$iv$iv$iv = 0;
                            function1 = onFound;
                            if (kindSet$ui_release &= i12 != 0) {
                            } else {
                            }
                            branches$iv$iv$iv = this_$iv;
                            child$iv$iv$iv = this_$iv$iv$iv$iv2;
                            i19 = i13;
                            node$iv$iv$iv3 = node$iv$iv$iv3.getChild$ui_release();
                            node$iv$iv$iv = 0;
                            function1 = onFound;
                            i9 = 0;
                            i10 = 0;
                            i4 = 0;
                            i30 = 0;
                            node$iv$iv$iv = node$iv$iv$iv2;
                            while (node$iv$iv$iv != null) {
                                branches$iv$iv$iv = this_$iv;
                                this_$iv$iv$iv$iv2 = 0;
                                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                it$iv2 = 0;
                                if (it$iv2 != 0 && node$iv$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                i = i13;
                                node$iv$iv$iv = DelegatableNodeKt.access$pop(i4);
                                i13 = i;
                                this_$iv = branches$iv$iv$iv;
                                this_$iv$iv$iv$iv2 = child$iv$iv$iv;
                                function1 = onFound;
                                if (node$iv$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                it$iv2 = 0;
                                i15 = 0;
                                node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv.getDelegate$ui_release();
                                while (node$iv$iv$iv$iv != null) {
                                    i14 = node$iv$iv$iv$iv;
                                    it$iv = 0;
                                    i16 = 0;
                                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv3 = 0;
                                    if (this_$iv$iv$iv$iv3 != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                    next$iv$iv$iv = i14;
                                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                    function1 = onFound;
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv;
                                    i13 = 1;
                                    it$iv2++;
                                    if (it$iv2 == i13) {
                                    } else {
                                    }
                                    if (i4 == 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv = it$iv2;
                                    this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                    capacity$iv$iv$iv$iv$iv = 0;
                                    count$iv$iv$iv2 = i4;
                                    this_$iv$iv$iv$iv2 = node$iv$iv$iv;
                                    if (this_$iv$iv$iv$iv2 != null && count$iv$iv$iv2 != null) {
                                    }
                                    if (count$iv$iv$iv2 != null) {
                                    } else {
                                    }
                                    next$iv$iv$iv = i14;
                                    i4 = count$iv$iv$iv2;
                                    it$iv2 = count$iv$iv$iv;
                                    count$iv$iv$iv2.add(i14);
                                    if (count$iv$iv$iv2 != null) {
                                    }
                                    node$iv$iv$iv = 0;
                                    count$iv$iv$iv2.add(this_$iv$iv$iv$iv2);
                                    this_$iv$iv$iv$iv3 = i21;
                                    $i$f$mutableVectorOf = 16;
                                    i16 = 0;
                                    count$iv$iv$iv = it$iv2;
                                    this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                    i5 = $i$f$mutableVectorOf;
                                    count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                    node$iv$iv$iv = i14;
                                    this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                    next$iv$iv$iv = i14;
                                    this_$iv$iv$iv$iv3 = i13;
                                }
                                this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                i = 1;
                                if (it$iv2 == i) {
                                } else {
                                }
                                i13 = i;
                                this_$iv = branches$iv$iv$iv;
                                this_$iv$iv$iv$iv2 = child$iv$iv$iv;
                                function1 = onFound;
                                i14 = node$iv$iv$iv$iv;
                                it$iv = 0;
                                i16 = 0;
                                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv3 = 0;
                                if (this_$iv$iv$iv$iv3 != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                next$iv$iv$iv = i14;
                                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                function1 = onFound;
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv;
                                i13 = 1;
                                it$iv2++;
                                if (it$iv2 == i13) {
                                } else {
                                }
                                if (i4 == 0) {
                                } else {
                                }
                                count$iv$iv$iv = it$iv2;
                                this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                capacity$iv$iv$iv$iv$iv = 0;
                                count$iv$iv$iv2 = i4;
                                this_$iv$iv$iv$iv2 = node$iv$iv$iv;
                                if (this_$iv$iv$iv$iv2 != null && count$iv$iv$iv2 != null) {
                                }
                                if (count$iv$iv$iv2 != null) {
                                } else {
                                }
                                next$iv$iv$iv = i14;
                                i4 = count$iv$iv$iv2;
                                it$iv2 = count$iv$iv$iv;
                                count$iv$iv$iv2.add(i14);
                                if (count$iv$iv$iv2 != null) {
                                }
                                node$iv$iv$iv = 0;
                                count$iv$iv$iv2.add(this_$iv$iv$iv$iv2);
                                this_$iv$iv$iv$iv3 = i21;
                                $i$f$mutableVectorOf = 16;
                                i16 = 0;
                                count$iv$iv$iv = it$iv2;
                                this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                i5 = $i$f$mutableVectorOf;
                                count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                node$iv$iv$iv = i14;
                                this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                next$iv$iv$iv = i14;
                                this_$iv$iv$iv$iv3 = i13;
                                it$iv2 = i13;
                                obj5 = node$iv$iv$iv;
                                i15 = 0;
                                obj7 = obj5;
                                i14 = 0;
                                if (obj7.fetchFocusProperties$ui_release().getCanFocus()) {
                                } else {
                                }
                                it$iv = obj5;
                                child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                node$iv$iv$iv$iv = TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(obj7, FocusDirection.Companion.getEnter-dhqQ-8s(), function1);
                                i = i13;
                                it$iv = obj5;
                                node$iv$iv$iv$iv = (Boolean)function1.invoke(obj7).booleanValue();
                                child$iv$iv$iv = this_$iv$iv$iv$iv2;
                            }
                            branches$iv$iv$iv = this_$iv;
                            child$iv$iv$iv = this_$iv$iv$iv$iv2;
                            i22 = i13;
                            node$iv$iv$iv = 0;
                            function1 = onFound;
                            branches$iv$iv$iv = this_$iv;
                            if (node$iv$iv$iv instanceof FocusTargetNode) {
                            } else {
                            }
                            this_$iv$iv$iv$iv2 = 0;
                            if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                            } else {
                            }
                            it$iv2 = 0;
                            if (it$iv2 != 0 && node$iv$iv$iv instanceof DelegatingNode) {
                            } else {
                            }
                            i = i13;
                            node$iv$iv$iv = DelegatableNodeKt.access$pop(i4);
                            i13 = i;
                            this_$iv = branches$iv$iv$iv;
                            this_$iv$iv$iv$iv2 = child$iv$iv$iv;
                            function1 = onFound;
                            if (node$iv$iv$iv instanceof DelegatingNode) {
                            } else {
                            }
                            it$iv2 = 0;
                            i15 = 0;
                            node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv.getDelegate$ui_release();
                            while (node$iv$iv$iv$iv != null) {
                                i14 = node$iv$iv$iv$iv;
                                it$iv = 0;
                                i16 = 0;
                                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv3 = 0;
                                if (this_$iv$iv$iv$iv3 != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                next$iv$iv$iv = i14;
                                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                function1 = onFound;
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv;
                                i13 = 1;
                                it$iv2++;
                                if (it$iv2 == i13) {
                                } else {
                                }
                                if (i4 == 0) {
                                } else {
                                }
                                count$iv$iv$iv = it$iv2;
                                this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                capacity$iv$iv$iv$iv$iv = 0;
                                count$iv$iv$iv2 = i4;
                                this_$iv$iv$iv$iv2 = node$iv$iv$iv;
                                if (this_$iv$iv$iv$iv2 != null && count$iv$iv$iv2 != null) {
                                }
                                if (count$iv$iv$iv2 != null) {
                                } else {
                                }
                                next$iv$iv$iv = i14;
                                i4 = count$iv$iv$iv2;
                                it$iv2 = count$iv$iv$iv;
                                count$iv$iv$iv2.add(i14);
                                if (count$iv$iv$iv2 != null) {
                                }
                                node$iv$iv$iv = 0;
                                count$iv$iv$iv2.add(this_$iv$iv$iv$iv2);
                                this_$iv$iv$iv$iv3 = i21;
                                $i$f$mutableVectorOf = 16;
                                i16 = 0;
                                count$iv$iv$iv = it$iv2;
                                this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                i5 = $i$f$mutableVectorOf;
                                count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                node$iv$iv$iv = i14;
                                this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                                next$iv$iv$iv = i14;
                                this_$iv$iv$iv$iv3 = i13;
                            }
                            this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                            i = 1;
                            if (it$iv2 == i) {
                            } else {
                            }
                            i13 = i;
                            this_$iv = branches$iv$iv$iv;
                            this_$iv$iv$iv$iv2 = child$iv$iv$iv;
                            function1 = onFound;
                            i14 = node$iv$iv$iv$iv;
                            it$iv = 0;
                            i16 = 0;
                            if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                            } else {
                            }
                            this_$iv$iv$iv$iv3 = 0;
                            if (this_$iv$iv$iv$iv3 != 0) {
                            } else {
                            }
                            this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                            next$iv$iv$iv = i14;
                            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                            function1 = onFound;
                            this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv;
                            i13 = 1;
                            it$iv2++;
                            if (it$iv2 == i13) {
                            } else {
                            }
                            if (i4 == 0) {
                            } else {
                            }
                            count$iv$iv$iv = it$iv2;
                            this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                            capacity$iv$iv$iv$iv$iv = 0;
                            count$iv$iv$iv2 = i4;
                            this_$iv$iv$iv$iv2 = node$iv$iv$iv;
                            if (this_$iv$iv$iv$iv2 != null && count$iv$iv$iv2 != null) {
                            }
                            if (count$iv$iv$iv2 != null) {
                            } else {
                            }
                            next$iv$iv$iv = i14;
                            i4 = count$iv$iv$iv2;
                            it$iv2 = count$iv$iv$iv;
                            count$iv$iv$iv2.add(i14);
                            if (count$iv$iv$iv2 != null) {
                            }
                            node$iv$iv$iv = 0;
                            count$iv$iv$iv2.add(this_$iv$iv$iv$iv2);
                            this_$iv$iv$iv$iv3 = i21;
                            $i$f$mutableVectorOf = 16;
                            i16 = 0;
                            count$iv$iv$iv = it$iv2;
                            this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                            i5 = $i$f$mutableVectorOf;
                            count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                            node$iv$iv$iv = i14;
                            this_$iv$iv$iv$iv = this_$iv$iv$iv$iv2;
                            next$iv$iv$iv = i14;
                            this_$iv$iv$iv$iv3 = i13;
                            it$iv2 = i13;
                            obj5 = node$iv$iv$iv;
                            i15 = 0;
                            obj7 = obj5;
                            i14 = 0;
                            if (obj7.fetchFocusProperties$ui_release().getCanFocus()) {
                            } else {
                            }
                            it$iv = obj5;
                            child$iv$iv$iv = this_$iv$iv$iv$iv2;
                            node$iv$iv$iv$iv = TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(obj7, FocusDirection.Companion.getEnter-dhqQ-8s(), function1);
                            if (node$iv$iv$iv$iv) {
                            } else {
                            }
                            i = i13;
                            success$iv = this_$iv;
                            function1 = i13;
                            it$iv = obj5;
                            node$iv$iv$iv$iv = (Boolean)function1.invoke(obj7).booleanValue();
                            child$iv$iv$iv = this_$iv$iv$iv$iv2;
                            DelegatableNodeKt.access$addLayoutNodeChildren(this_$iv, notEmpty);
                            DelegatableNodeKt.access$addLayoutNodeChildren(this_$iv, obj4.getNode());
                        }
                        androidx.compose.ui.focus.FocusRequester this_$iv4 = this_$iv;
                        int i23 = 0;
                        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
                        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv$iv;
                    }
                    this_$iv2 = this_$iv;
                    i8 = this_$iv$iv$iv$iv2;
                    return success$iv;
                }
                androidx.compose.ui.focus.FocusRequester request = this_$iv;
                int i24 = 0;
                IllegalStateException $i$a$CheckFocusRequester$findFocusTarget$3$iv = new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
                throw $i$a$CheckFocusRequester$findFocusTarget$3$iv;
            }
            androidx.compose.ui.focus.FocusRequester this_$iv3 = this_$iv;
            int i17 = 0;
            IllegalStateException $i$a$CheckFocusRequester$findFocusTarget$2$iv = new IllegalStateException(str3.toString());
            throw $i$a$CheckFocusRequester$findFocusTarget$2$iv;
        }
        androidx.compose.ui.focus.FocusRequester this_$iv5 = this_$iv;
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
