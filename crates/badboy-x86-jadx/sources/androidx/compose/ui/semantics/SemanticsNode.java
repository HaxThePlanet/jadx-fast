package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0007\u0018\u00002\u00020\u0001B'\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\r\u0010J\u001a\u00020\u0000H\u0000¢\u0006\u0002\u0008KJ\u0016\u0010L\u001a\u00020M2\u000c\u0010N\u001a\u0008\u0012\u0004\u0012\u00020\u00000OH\u0002J3\u0010P\u001a\u00020\u00002\u0008\u0010Q\u001a\u0004\u0018\u00010R2\u0017\u0010S\u001a\u0013\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020M0T¢\u0006\u0002\u0008VH\u0002ø\u0001\u0000¢\u0006\u0002\u0008WJ\u000f\u0010X\u001a\u0004\u0018\u00010YH\u0000¢\u0006\u0002\u0008ZJ\u001e\u0010[\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u00142\u000e\u0008\u0002\u0010\\\u001a\u0008\u0012\u0004\u0012\u00020\u00000OH\u0002J\u000e\u0010]\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020_J1\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u00142\u0008\u0008\u0002\u0010`\u001a\u00020\u00052\u0008\u0008\u0002\u0010a\u001a\u00020\u00052\u0008\u0008\u0002\u0010b\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0008cJ\u0010\u0010d\u001a\u00020M2\u0006\u0010e\u001a\u00020\tH\u0002J'\u0010N\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u00142\u0008\u0008\u0002\u0010a\u001a\u00020\u00052\u0008\u0008\u0002\u0010b\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0008fJ\"\u0010g\u001a\u00020M*\u00020\u00072\u000c\u0010\\\u001a\u0008\u0012\u0004\u0012\u00020\u00000O2\u0006\u0010b\u001a\u00020\u0005H\u0002R\u0014\u0010\u000b\u001a\u00020\u000c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u000eR\u0017\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u00148F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010!\"\u0004\u0008\"\u0010#R\u0014\u0010$\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008$\u0010!R\u0011\u0010%\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008%\u0010!R\u0014\u0010&\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008'\u0010!R\u0014\u0010(\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008)\u0010!R\u0011\u0010*\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\u0008,\u0010-R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010/R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010!R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00102R\u0013\u00103\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\u00084\u00105R\u0017\u00106\u001a\u0002078Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u00088\u00109R\u0017\u0010:\u001a\u0002078Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008;\u00109R\u0017\u0010<\u001a\u0002078Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008=\u00109R\u001a\u0010>\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008?\u0010\u0016R\u0013\u0010@\u001a\u0004\u0018\u00010A8F¢\u0006\u0006\u001a\u0004\u0008B\u0010CR\u0017\u0010D\u001a\u00020E8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008F\u00109R\u0011\u0010G\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008H\u0010\u000eR\u0014\u0010\u0008\u001a\u00020\tX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008I\u0010\u0019\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006h", d2 = {"Landroidx/compose/ui/semantics/SemanticsNode;", "", "outerSemanticsNode", "Landroidx/compose/ui/Modifier$Node;", "mergingEnabled", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "unmergedConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "(Landroidx/compose/ui/Modifier$Node;ZLandroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/semantics/SemanticsConfiguration;)V", "boundsInParent", "Landroidx/compose/ui/geometry/Rect;", "getBoundsInParent$ui_release", "()Landroidx/compose/ui/geometry/Rect;", "boundsInRoot", "getBoundsInRoot", "boundsInWindow", "getBoundsInWindow", "children", "", "getChildren", "()Ljava/util/List;", "config", "getConfig", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "fakeNodeParent", "id", "", "getId", "()I", "isFake", "isFake$ui_release", "()Z", "setFake$ui_release", "(Z)V", "isMergingSemanticsOfDescendants", "isRoot", "isTransparent", "isTransparent$ui_release", "isUnmergedLeafNode", "isUnmergedLeafNode$ui_release", "layoutInfo", "Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutNode$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "getMergingEnabled", "getOuterSemanticsNode$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "parent", "getParent", "()Landroidx/compose/ui/semantics/SemanticsNode;", "positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "getPositionInRoot-F1C5BW0", "()J", "positionInWindow", "getPositionInWindow-F1C5BW0", "positionOnScreen", "getPositionOnScreen-F1C5BW0", "replacedChildren", "getReplacedChildren$ui_release", "root", "Landroidx/compose/ui/node/RootForTest;", "getRoot", "()Landroidx/compose/ui/node/RootForTest;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "touchBoundsInRoot", "getTouchBoundsInRoot", "getUnmergedConfig$ui_release", "copyWithMergingEnabled", "copyWithMergingEnabled$ui_release", "emitFakeNodes", "", "unmergedChildren", "", "fakeSemanticsNode", "role", "Landroidx/compose/ui/semantics/Role;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "Lkotlin/ExtensionFunctionType;", "fakeSemanticsNode-ypyhhiA", "findCoordinatorToGetBounds", "Landroidx/compose/ui/node/NodeCoordinator;", "findCoordinatorToGetBounds$ui_release", "findOneLayerOfMergingSemanticsNodes", "list", "getAlignmentLinePosition", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "includeReplacedSemantics", "includeFakeNodes", "includeDeactivatedNodes", "getChildren$ui_release", "mergeConfig", "mergedConfig", "unmergedChildren$ui_release", "fillOneLayerOfSemanticsWrappers", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SemanticsNode {

    public static final int $stable = 8;
    private androidx.compose.ui.semantics.SemanticsNode fakeNodeParent;
    private final int id;
    private boolean isFake;
    private final LayoutNode layoutNode;
    private final boolean mergingEnabled;
    private final Modifier.Node outerSemanticsNode;
    private final androidx.compose.ui.semantics.SemanticsConfiguration unmergedConfig;
    static {
        final int i = 8;
    }

    public SemanticsNode(Modifier.Node outerSemanticsNode, boolean mergingEnabled, LayoutNode layoutNode, androidx.compose.ui.semantics.SemanticsConfiguration unmergedConfig) {
        super();
        this.outerSemanticsNode = outerSemanticsNode;
        this.mergingEnabled = mergingEnabled;
        this.layoutNode = layoutNode;
        this.unmergedConfig = unmergedConfig;
        this.id = this.layoutNode.getSemanticsId();
    }

    private final void emitFakeNodes(List<androidx.compose.ui.semantics.SemanticsNode> unmergedChildren) {
        boolean mergingSemanticsOfDescendants2;
        int mergingSemanticsOfDescendants;
        androidx.compose.ui.semantics.SemanticsPropertyKey fakeSemanticsNode-ypyhhiA;
        int i;
        final androidx.compose.ui.semantics.Role role = SemanticsNodeKt.access$getRole(this);
        if (role != null && this.unmergedConfig.isMergingSemanticsOfDescendants() && !(Collection)unmergedChildren.isEmpty()) {
            if (this.unmergedConfig.isMergingSemanticsOfDescendants()) {
                if (!(Collection)unmergedChildren.isEmpty()) {
                    SemanticsNode.emitFakeNodes.fakeNode.1 anon = new SemanticsNode.emitFakeNodes.fakeNode.1(role);
                    unmergedChildren.add(fakeSemanticsNode-ypyhhiA(role, (Function1)anon));
                }
            }
        }
        if (this.unmergedConfig.contains(SemanticsProperties.INSTANCE.getContentDescription()) && !(Collection)unmergedChildren.isEmpty() && this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            if (!(Collection)unmergedChildren.isEmpty()) {
                if (this.unmergedConfig.isMergingSemanticsOfDescendants()) {
                    Object orNull = SemanticsConfigurationKt.getOrNull(this.unmergedConfig, SemanticsProperties.INSTANCE.getContentDescription());
                    fakeSemanticsNode-ypyhhiA = 0;
                    if ((List)orNull != null) {
                        mergingSemanticsOfDescendants = CollectionsKt.firstOrNull((List)orNull);
                    } else {
                        mergingSemanticsOfDescendants = fakeSemanticsNode-ypyhhiA;
                    }
                    if (mergingSemanticsOfDescendants != 0) {
                        SemanticsNode.emitFakeNodes.fakeNode.2 anon2 = new SemanticsNode.emitFakeNodes.fakeNode.2(mergingSemanticsOfDescendants);
                        unmergedChildren.add(0, fakeSemanticsNode-ypyhhiA(fakeSemanticsNode-ypyhhiA, (Function1)anon2));
                    }
                }
            }
        }
    }

    private final androidx.compose.ui.semantics.SemanticsNode fakeSemanticsNode-ypyhhiA(androidx.compose.ui.semantics.Role role, Function1<? super androidx.compose.ui.semantics.SemanticsPropertyReceiver, Unit> properties) {
        int i;
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        androidx.compose.ui.semantics.SemanticsConfiguration semanticsConfiguration2 = semanticsConfiguration;
        int i2 = 0;
        final int i3 = 0;
        semanticsConfiguration2.setMergingSemanticsOfDescendants(i3);
        semanticsConfiguration2.setClearingSemantics(i3);
        properties.invoke(semanticsConfiguration2);
        SemanticsNode.fakeSemanticsNode.fakeNode.1 anon = new SemanticsNode.fakeSemanticsNode.fakeNode.1(properties);
        if (role != null) {
            i = SemanticsNodeKt.access$roleFakeNodeId(this);
        } else {
            i = SemanticsNodeKt.access$contentDescriptionFakeNodeId(this);
        }
        final int i4 = 1;
        LayoutNode layoutNode = new LayoutNode(i4, i);
        SemanticsNode semanticsNode = new SemanticsNode((Modifier.Node)anon, i3, layoutNode, semanticsConfiguration);
        semanticsNode.isFake = i4;
        semanticsNode.fakeNodeParent = this;
        return semanticsNode;
    }

    private final void fillOneLayerOfSemanticsWrappers(LayoutNode $this$fillOneLayerOfSemanticsWrappers, List<androidx.compose.ui.semantics.SemanticsNode> list, boolean includeDeactivatedNodes) {
        int i$iv;
        Object[] content;
        Object obj;
        int i2;
        boolean deactivated;
        int constructor-impl;
        int i;
        final MutableVector zSortedChildren = $this$fillOneLayerOfSemanticsWrappers.getZSortedChildren();
        final int i3 = 0;
        final int size = zSortedChildren.getSize();
        if (size > 0) {
            i$iv = 0;
            obj = zSortedChildren.getContent()[i$iv];
            i2 = 0;
            do {
                obj = content[i$iv];
                i2 = 0;
                if (i$iv++ < size) {
                }
                if (!includeDeactivatedNodes) {
                } else {
                }
                int i4 = 0;
                if (obj.getNodes$ui_release().has-H91voCI$ui_release(NodeKind.constructor-impl(8))) {
                } else {
                }
                fillOneLayerOfSemanticsWrappers(obj, list, includeDeactivatedNodes);
                list.add(SemanticsNodeKt.SemanticsNode(obj, this.mergingEnabled));
                if (!obj.isDeactivated()) {
                }
            } while ((LayoutNode)obj.isAttached());
        }
    }

    private final List<androidx.compose.ui.semantics.SemanticsNode> findOneLayerOfMergingSemanticsNodes(List<androidx.compose.ui.semantics.SemanticsNode> list) {
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        boolean mergingSemanticsOfDescendants;
        int i5 = 0;
        List unmergedChildren$ui_release$default = SemanticsNode.unmergedChildren$ui_release$default(this, i5, i5, 3, 0);
        int i4 = 0;
        index$iv = 0;
        while (index$iv < unmergedChildren$ui_release$default.size()) {
            obj2 = obj;
            i = 0;
            if ((SemanticsNode)obj2.isMergingSemanticsOfDescendants()) {
            } else {
            }
            if (!obj2.unmergedConfig.isClearingSemantics()) {
            }
            index$iv++;
            obj2.findOneLayerOfMergingSemanticsNodes(list);
            list.add(obj2);
        }
        return list;
    }

    static List findOneLayerOfMergingSemanticsNodes$default(androidx.compose.ui.semantics.SemanticsNode semanticsNode, List list2, int i3, Object object4) {
        ArrayList obj1;
        if (i3 &= 1 != 0) {
            obj1 = new ArrayList();
        }
        return semanticsNode.findOneLayerOfMergingSemanticsNodes(obj1);
    }

    public static List getChildren$ui_release$default(androidx.compose.ui.semantics.SemanticsNode semanticsNode, boolean z2, boolean z3, boolean z4, int i5, Object object6) {
        int obj2;
        int obj3;
        int obj4;
        if (i5 & 1 != 0) {
            obj2 ^= 1;
        }
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return semanticsNode.getChildren$ui_release(obj2, obj3, obj4);
    }

    private final boolean isMergingSemanticsOfDescendants() {
        boolean mergingSemanticsOfDescendants;
        int i;
        if (this.mergingEnabled && this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            i = this.unmergedConfig.isMergingSemanticsOfDescendants() ? 1 : 0;
        } else {
        }
        return i;
    }

    private final void mergeConfig(androidx.compose.ui.semantics.SemanticsConfiguration mergedConfig) {
        boolean unmergedChildren$ui_release$default;
        int i2;
        int index$iv;
        int size;
        Object obj;
        Object obj2;
        int i;
        boolean mergingSemanticsOfDescendants;
        if (!this.unmergedConfig.isClearingSemantics()) {
            int i5 = 0;
            unmergedChildren$ui_release$default = SemanticsNode.unmergedChildren$ui_release$default(this, i5, i5, 3, 0);
            i2 = 0;
            index$iv = 0;
            while (index$iv < unmergedChildren$ui_release$default.size()) {
                obj2 = obj;
                i = 0;
                if (!(SemanticsNode)obj2.isMergingSemanticsOfDescendants()) {
                }
                index$iv++;
                mergedConfig.mergeChild$ui_release(obj2.unmergedConfig);
                obj2.mergeConfig(mergedConfig);
            }
        }
    }

    public static List unmergedChildren$ui_release$default(androidx.compose.ui.semantics.SemanticsNode semanticsNode, boolean z2, boolean z3, int i4, Object object5) {
        int obj2;
        int obj3;
        final int i = 0;
        if (i4 & 1 != 0) {
            obj2 = i;
        }
        if (i4 &= 2 != 0) {
            obj3 = i;
        }
        return semanticsNode.unmergedChildren$ui_release(obj2, obj3);
    }

    public final androidx.compose.ui.semantics.SemanticsNode copyWithMergingEnabled$ui_release() {
        SemanticsNode semanticsNode = new SemanticsNode(this.outerSemanticsNode, 1, this.layoutNode, this.unmergedConfig);
        return semanticsNode;
    }

    public final NodeCoordinator findCoordinatorToGetBounds$ui_release() {
        Object outerMergingSemantics;
        int coordinatorToGetBounds$ui_release;
        if (this.isFake) {
            androidx.compose.ui.semantics.SemanticsNode parent = getParent();
            if (parent != null) {
                coordinatorToGetBounds$ui_release = parent.findCoordinatorToGetBounds$ui_release();
            } else {
                coordinatorToGetBounds$ui_release = 0;
            }
            return coordinatorToGetBounds$ui_release;
        }
        if (SemanticsNodeKt.getOuterMergingSemantics(this.layoutNode) != null) {
        } else {
            outerMergingSemantics = this.outerSemanticsNode;
        }
        int i = 0;
        return DelegatableNodeKt.requireCoordinator-64DMado((DelegatableNode)outerMergingSemantics, NodeKind.constructor-impl(8));
    }

    public final int getAlignmentLinePosition(AlignmentLine alignmentLine) {
        int i;
        NodeCoordinator coordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (coordinatorToGetBounds$ui_release != null) {
            i = coordinatorToGetBounds$ui_release.get(alignmentLine);
        } else {
            i = Integer.MIN_VALUE;
        }
        return i;
    }

    public final Rect getBoundsInParent$ui_release() {
        int coordinatorToGetBounds$ui_release;
        boolean it;
        int i;
        androidx.compose.ui.semantics.SemanticsNode parent = getParent();
        if (parent == null) {
            return Rect.Companion.getZero();
        }
        coordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (coordinatorToGetBounds$ui_release != null) {
            int i2 = 0;
            i = 0;
            if (coordinatorToGetBounds$ui_release.isAttached()) {
            } else {
                coordinatorToGetBounds$ui_release = i;
            }
            coordinatorToGetBounds$ui_release = coordinatorToGetBounds$ui_release.getCoordinates();
            if (coordinatorToGetBounds$ui_release != 0 && coordinatorToGetBounds$ui_release != null) {
                coordinatorToGetBounds$ui_release = coordinatorToGetBounds$ui_release.getCoordinates();
                if (coordinatorToGetBounds$ui_release != null) {
                    int i3 = 0;
                    return LayoutCoordinates.localBoundingBoxOf$default((LayoutCoordinates)DelegatableNodeKt.requireCoordinator-64DMado((DelegatableNode)parent.outerSemanticsNode, NodeKind.constructor-impl(8)), coordinatorToGetBounds$ui_release, false, 2, i);
                }
            }
        }
        return Rect.Companion.getZero();
    }

    public final Rect getBoundsInRoot() {
        Rect coordinatorToGetBounds$ui_release;
        boolean it;
        int i;
        coordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (coordinatorToGetBounds$ui_release != null) {
            i = 0;
            if (coordinatorToGetBounds$ui_release.isAttached()) {
            } else {
                coordinatorToGetBounds$ui_release = 0;
            }
            if (coordinatorToGetBounds$ui_release != 0) {
                if (LayoutCoordinatesKt.boundsInRoot((LayoutCoordinates)coordinatorToGetBounds$ui_release) == null) {
                    coordinatorToGetBounds$ui_release = Rect.Companion.getZero();
                }
            } else {
            }
        } else {
        }
        return coordinatorToGetBounds$ui_release;
    }

    public final Rect getBoundsInWindow() {
        Rect coordinatorToGetBounds$ui_release;
        boolean it;
        int i;
        coordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (coordinatorToGetBounds$ui_release != null) {
            i = 0;
            if (coordinatorToGetBounds$ui_release.isAttached()) {
            } else {
                coordinatorToGetBounds$ui_release = 0;
            }
            if (coordinatorToGetBounds$ui_release != 0) {
                if (LayoutCoordinatesKt.boundsInWindow((LayoutCoordinates)coordinatorToGetBounds$ui_release) == null) {
                    coordinatorToGetBounds$ui_release = Rect.Companion.getZero();
                }
            } else {
            }
        } else {
        }
        return coordinatorToGetBounds$ui_release;
    }

    public final List<androidx.compose.ui.semantics.SemanticsNode> getChildren() {
        return SemanticsNode.getChildren$ui_release$default(this, false, false, false, 7, 0);
    }

    public final List<androidx.compose.ui.semantics.SemanticsNode> getChildren$ui_release(boolean includeReplacedSemantics, boolean includeFakeNodes, boolean includeDeactivatedNodes) {
        boolean clearingSemantics;
        if (!includeReplacedSemantics && this.unmergedConfig.isClearingSemantics()) {
            if (this.unmergedConfig.isClearingSemantics()) {
                return CollectionsKt.emptyList();
            }
        }
        if (isMergingSemanticsOfDescendants()) {
            final int i2 = 0;
            return SemanticsNode.findOneLayerOfMergingSemanticsNodes$default(this, i2, 1, i2);
        }
        return unmergedChildren$ui_release(includeFakeNodes, includeDeactivatedNodes);
    }

    public final androidx.compose.ui.semantics.SemanticsConfiguration getConfig() {
        if (isMergingSemanticsOfDescendants()) {
            androidx.compose.ui.semantics.SemanticsConfiguration copy = this.unmergedConfig.copy();
            mergeConfig(copy);
            return copy;
        }
        return this.unmergedConfig;
    }

    public final int getId() {
        return this.id;
    }

    public final LayoutInfo getLayoutInfo() {
        return (LayoutInfo)this.layoutNode;
    }

    public final LayoutNode getLayoutNode$ui_release() {
        return this.layoutNode;
    }

    public final boolean getMergingEnabled() {
        return this.mergingEnabled;
    }

    public final Modifier.Node getOuterSemanticsNode$ui_release() {
        return this.outerSemanticsNode;
    }

    public final androidx.compose.ui.semantics.SemanticsNode getParent() {
        int node;
        boolean mergingEnabled;
        androidx.compose.ui.semantics.SemanticsNode.parent.1 iNSTANCE;
        if (this.fakeNodeParent != null) {
            return this.fakeNodeParent;
        }
        node = 0;
        if (this.mergingEnabled) {
            node = SemanticsNodeKt.findClosestParentNode(this.layoutNode, (Function1)SemanticsNode.parent.1.INSTANCE);
        }
        if (node == null) {
            node = SemanticsNodeKt.findClosestParentNode(this.layoutNode, (Function1)SemanticsNode.parent.2.INSTANCE);
        }
        if (node == null) {
            return null;
        }
        return SemanticsNodeKt.SemanticsNode(node, this.mergingEnabled);
    }

    public final long getPositionInRoot-F1C5BW0() {
        long positionInRoot;
        NodeCoordinator coordinatorToGetBounds$ui_release;
        boolean it;
        int i;
        coordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (coordinatorToGetBounds$ui_release != null) {
            i = 0;
            if (coordinatorToGetBounds$ui_release.isAttached()) {
            } else {
                coordinatorToGetBounds$ui_release = 0;
            }
            if (coordinatorToGetBounds$ui_release != 0) {
                positionInRoot = LayoutCoordinatesKt.positionInRoot((LayoutCoordinates)coordinatorToGetBounds$ui_release);
            } else {
                positionInRoot = Offset.Companion.getZero-F1C5BW0();
            }
        } else {
        }
        return positionInRoot;
    }

    public final long getPositionInWindow-F1C5BW0() {
        long positionInWindow;
        NodeCoordinator coordinatorToGetBounds$ui_release;
        boolean it;
        int i;
        coordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (coordinatorToGetBounds$ui_release != null) {
            i = 0;
            if (coordinatorToGetBounds$ui_release.isAttached()) {
            } else {
                coordinatorToGetBounds$ui_release = 0;
            }
            if (coordinatorToGetBounds$ui_release != 0) {
                positionInWindow = LayoutCoordinatesKt.positionInWindow((LayoutCoordinates)coordinatorToGetBounds$ui_release);
            } else {
                positionInWindow = Offset.Companion.getZero-F1C5BW0();
            }
        } else {
        }
        return positionInWindow;
    }

    public final long getPositionOnScreen-F1C5BW0() {
        long positionOnScreen;
        NodeCoordinator coordinatorToGetBounds$ui_release;
        boolean it;
        int i;
        coordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (coordinatorToGetBounds$ui_release != null) {
            i = 0;
            if (coordinatorToGetBounds$ui_release.isAttached()) {
            } else {
                coordinatorToGetBounds$ui_release = 0;
            }
            if (coordinatorToGetBounds$ui_release != 0) {
                positionOnScreen = LayoutCoordinatesKt.positionOnScreen((LayoutCoordinates)coordinatorToGetBounds$ui_release);
            } else {
                positionOnScreen = Offset.Companion.getZero-F1C5BW0();
            }
        } else {
        }
        return positionOnScreen;
    }

    public final List<androidx.compose.ui.semantics.SemanticsNode> getReplacedChildren$ui_release() {
        return SemanticsNode.getChildren$ui_release$default(this, false, true, false, 4, 0);
    }

    public final RootForTest getRoot() {
        RootForTest rootForTest;
        Owner owner$ui_release = this.layoutNode.getOwner$ui_release();
        if (owner$ui_release != null) {
            rootForTest = owner$ui_release.getRootForTest();
        } else {
            rootForTest = 0;
        }
        return rootForTest;
    }

    public final long getSize-YbymL2g() {
        long size-YbymL2g;
        NodeCoordinator coordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (coordinatorToGetBounds$ui_release != null) {
            size-YbymL2g = coordinatorToGetBounds$ui_release.getSize-YbymL2g();
        } else {
            size-YbymL2g = IntSize.Companion.getZero-YbymL2g();
        }
        return size-YbymL2g;
    }

    public final Rect getTouchBoundsInRoot() {
        Object outerMergingSemantics;
        if (this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            if (SemanticsNodeKt.getOuterMergingSemantics(this.layoutNode) != null) {
            } else {
                outerMergingSemantics = this.outerSemanticsNode;
            }
        } else {
            outerMergingSemantics = this.outerSemanticsNode;
        }
        return SemanticsModifierNodeKt.touchBoundsInRoot(outerMergingSemantics.getNode(), SemanticsModifierNodeKt.getUseMinimumTouchTarget(this.unmergedConfig));
    }

    public final androidx.compose.ui.semantics.SemanticsConfiguration getUnmergedConfig$ui_release() {
        return this.unmergedConfig;
    }

    public final boolean isFake$ui_release() {
        return this.isFake;
    }

    public final boolean isRoot() {
        int i;
        i = getParent() == null ? 1 : 0;
        return i;
    }

    public final boolean isTransparent$ui_release() {
        boolean transparent;
        NodeCoordinator coordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (coordinatorToGetBounds$ui_release != null) {
            transparent = coordinatorToGetBounds$ui_release.isTransparent();
        } else {
            transparent = 0;
        }
        return transparent;
    }

    public final boolean isUnmergedLeafNode$ui_release() {
        int i;
        boolean closestParentNode;
        androidx.compose.ui.semantics.SemanticsNode.isUnmergedLeafNode.1 iNSTANCE;
        if (!this.isFake && getReplacedChildren$ui_release().isEmpty() && SemanticsNodeKt.findClosestParentNode(this.layoutNode, (Function1)SemanticsNode.isUnmergedLeafNode.1.INSTANCE) == null) {
            if (getReplacedChildren$ui_release().isEmpty()) {
                i = SemanticsNodeKt.findClosestParentNode(this.layoutNode, (Function1)SemanticsNode.isUnmergedLeafNode.1.INSTANCE) == null ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public final void setFake$ui_release(boolean <set-?>) {
        this.isFake = <set-?>;
    }

    public final List<androidx.compose.ui.semantics.SemanticsNode> unmergedChildren$ui_release(boolean includeFakeNodes, boolean includeDeactivatedNodes) {
        if (this.isFake) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        fillOneLayerOfSemanticsWrappers(this.layoutNode, (List)arrayList, includeDeactivatedNodes);
        if (includeFakeNodes) {
            emitFakeNodes(arrayList);
        }
        return arrayList;
    }
}
