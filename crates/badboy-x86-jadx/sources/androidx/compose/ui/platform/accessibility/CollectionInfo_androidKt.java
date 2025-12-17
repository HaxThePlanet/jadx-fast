package androidx.compose.ui.platform.accessibility;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.CollectionItemInfo;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u00012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u001a\u0018\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u000cH\u0000\u001a\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u000cH\u0000\u001a\u000c\u0010\u000e\u001a\u00020\u0001*\u00020\u0007H\u0000\u001a\u0014\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010*\u00020\u0002H\u0002\u001a\u001c\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00130\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0000\u0010\u0003¨\u0006\u0016", d2 = {"isLazyCollection", "", "Landroidx/compose/ui/semantics/CollectionInfo;", "(Landroidx/compose/ui/semantics/CollectionInfo;)Z", "calculateIfHorizontallyStacked", "items", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "setCollectionInfo", "", "node", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "setCollectionItemInfo", "hasCollectionInfo", "toAccessibilityCollectionInfo", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$CollectionInfoCompat;", "kotlin.jvm.PlatformType", "toAccessibilityCollectionItemInfo", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$CollectionItemInfoCompat;", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "itemNode", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CollectionInfo_androidKt {
    private static final boolean calculateIfHorizontallyStacked(List<SemanticsNode> items) {
        long unbox-impl;
        int i;
        int i2;
        int size;
        Object arrayList;
        Object current$iv;
        int i$iv;
        int lastIndex;
        Object box-impl2;
        Offset box-impl;
        Object unbox-impl2;
        int i3;
        float f;
        long l;
        long y-impl;
        i2 = 1;
        if ((Collection)items.size() < 2) {
            return i2;
        }
        List list2 = items;
        i = 0;
        int i5 = 0;
        if (list2.size() != 0) {
            if (list2.size() == i2) {
                arrayList = CollectionsKt.emptyList();
            } else {
                arrayList = new ArrayList();
                current$iv = list2.get(i5);
                i$iv = 0;
                while (i$iv < CollectionsKt.getLastIndex(list2)) {
                    box-impl2 = list2.get(i$iv + 1);
                    Object obj2 = box-impl2;
                    unbox-impl2 = current$iv;
                    i3 = 0;
                    (List)arrayList.add(Offset.box-impl(OffsetKt.Offset(Math.abs(x-impl -= x-impl2), Math.abs(y-impl3 -= y-impl))));
                    current$iv = box-impl2;
                    i$iv++;
                }
            }
        } else {
        }
        if ((Collection)arrayList.size() == i2) {
            unbox-impl = (Offset)CollectionsKt.first(arrayList).unbox-impl();
            int i6 = 0;
            int i7 = 0;
            if (Float.compare(y-impl2, $i$f$component1Impl) < 0) {
            } else {
                i2 = i5;
            }
            return i2;
        } else {
            ArrayList list4 = arrayList;
            i = 0;
            if (list4.isEmpty()) {
            } else {
                current$iv = CollectionsKt.first(list4);
                lastIndex = CollectionsKt.getLastIndex(list4);
                if (1 <= lastIndex) {
                }
                unbox-impl = (Offset)current$iv.unbox-impl();
            }
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Empty collection can't be reduced.");
        throw unsupportedOperationException;
    }

    public static final boolean hasCollectionInfo(SemanticsNode $this$hasCollectionInfo) {
        int i;
        Object orNull;
        androidx.compose.ui.semantics.SemanticsPropertyKey selectableGroup;
        if (SemanticsConfigurationKt.getOrNull($this$hasCollectionInfo.getConfig(), SemanticsProperties.INSTANCE.getCollectionInfo()) == null) {
            if (SemanticsConfigurationKt.getOrNull($this$hasCollectionInfo.getConfig(), SemanticsProperties.INSTANCE.getSelectableGroup()) != null) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static final boolean isLazyCollection(CollectionInfo $this$isLazyCollection) {
        int i;
        int columnCount;
        if ($this$isLazyCollection.getRowCount() >= 0) {
            if ($this$isLazyCollection.getColumnCount() < 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public static final void setCollectionInfo(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        Object replacedChildren$ui_release;
        boolean ifHorizontallyStacked;
        androidx.compose.ui.semantics.SemanticsPropertyKey selectableGroup;
        int size2;
        int index$iv;
        int size;
        Object obj;
        Object obj2;
        int i;
        boolean contains;
        androidx.compose.ui.semantics.SemanticsPropertyKey selected;
        Object orNull = SemanticsConfigurationKt.getOrNull(node.getConfig(), SemanticsProperties.INSTANCE.getCollectionInfo());
        if ((CollectionInfo)orNull != null) {
            info.setCollectionInfo(CollectionInfo_androidKt.toAccessibilityCollectionInfo((CollectionInfo)orNull));
        }
        ArrayList arrayList = new ArrayList();
        if (SemanticsConfigurationKt.getOrNull(node.getConfig(), SemanticsProperties.INSTANCE.getSelectableGroup()) != null) {
            replacedChildren$ui_release = node.getReplacedChildren$ui_release();
            selectableGroup = 0;
            index$iv = 0;
            while (index$iv < replacedChildren$ui_release.size()) {
                obj2 = obj;
                i = 0;
                if ((SemanticsNode)obj2.getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
                }
                index$iv++;
                (List)arrayList.add(obj2);
            }
        }
        if (!(Collection)arrayList.isEmpty()) {
            ifHorizontallyStacked = CollectionInfo_androidKt.calculateIfHorizontallyStacked(arrayList);
            if (ifHorizontallyStacked) {
                index$iv = size2;
            } else {
                index$iv = (Collection)arrayList.size();
            }
            if (ifHorizontallyStacked) {
                size2 = (Collection)arrayList.size();
            }
            size = 0;
            info.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(index$iv, size2, size, size));
        }
    }

    public static final void setCollectionItemInfo(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        Object accessibilityCollectionItemInfo;
        Object orNull;
        Object selectableGroup;
        androidx.compose.ui.semantics.SemanticsPropertyKey collectionInfo;
        int index;
        boolean ifHorizontallyStacked;
        int obtain;
        int index$iv;
        int size;
        int i3;
        int i;
        int i2;
        boolean placeOrder$ui_release2;
        androidx.compose.ui.semantics.SemanticsPropertyKey placeOrder$ui_release;
        Object orNull2 = SemanticsConfigurationKt.getOrNull(node.getConfig(), SemanticsProperties.INSTANCE.getCollectionItemInfo());
        if ((CollectionItemInfo)orNull2 != null) {
            info.setCollectionItemInfo(CollectionInfo_androidKt.toAccessibilityCollectionItemInfo((CollectionItemInfo)orNull2, node));
        }
        SemanticsNode parent = node.getParent();
        if (parent == null) {
        }
        orNull = SemanticsConfigurationKt.getOrNull(parent.getConfig(), SemanticsProperties.INSTANCE.getCollectionInfo());
        if (SemanticsConfigurationKt.getOrNull(parent.getConfig(), SemanticsProperties.INSTANCE.getSelectableGroup()) != null && orNull != null && CollectionInfo_androidKt.isLazyCollection((CollectionInfo)orNull)) {
            orNull = SemanticsConfigurationKt.getOrNull(parent.getConfig(), SemanticsProperties.INSTANCE.getCollectionInfo());
            if ((CollectionInfo)orNull != null) {
                if (CollectionInfo_androidKt.isLazyCollection((CollectionInfo)orNull)) {
                }
            }
            if (!node.getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
            }
            selectableGroup = new ArrayList();
            index = 0;
            List replacedChildren$ui_release = parent.getReplacedChildren$ui_release();
            obtain = 0;
            index$iv = 0;
            while (index$iv < replacedChildren$ui_release.size()) {
                i = i3;
                i2 = 0;
                (List)selectableGroup.add(i);
                if ((SemanticsNode)i.getConfig().contains(SemanticsProperties.INSTANCE.getSelected()) && i.getLayoutNode$ui_release().getPlaceOrder$ui_release() < node.getLayoutNode$ui_release().getPlaceOrder$ui_release()) {
                }
                index$iv++;
                selectableGroup.add(i);
                if (i.getLayoutNode$ui_release().getPlaceOrder$ui_release() < node.getLayoutNode$ui_release().getPlaceOrder$ui_release()) {
                }
                index++;
            }
            if (!(Collection)selectableGroup.isEmpty()) {
                ifHorizontallyStacked = CollectionInfo_androidKt.calculateIfHorizontallyStacked(selectableGroup);
                int i4 = 0;
                index$iv = ifHorizontallyStacked ? i4 : index;
                i3 = ifHorizontallyStacked ? index : i4;
                obtain = AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(index$iv, 1, i3, 1, false, (Boolean)node.getConfig().getOrElse(SemanticsProperties.INSTANCE.getSelected(), (Function0)CollectionInfo_androidKt.setCollectionItemInfo.itemInfo.1.INSTANCE).booleanValue());
                if (obtain != null) {
                    info.setCollectionItemInfo(obtain);
                }
            }
        }
    }

    private static final AccessibilityNodeInfoCompat.CollectionInfoCompat toAccessibilityCollectionInfo(CollectionInfo $this$toAccessibilityCollectionInfo) {
        final int i = 0;
        return AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain($this$toAccessibilityCollectionInfo.getRowCount(), $this$toAccessibilityCollectionInfo.getColumnCount(), i, i);
    }

    private static final AccessibilityNodeInfoCompat.CollectionItemInfoCompat toAccessibilityCollectionItemInfo(CollectionItemInfo $this$toAccessibilityCollectionItemInfo, SemanticsNode itemNode) {
        return AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain($this$toAccessibilityCollectionItemInfo.getRowIndex(), $this$toAccessibilityCollectionItemInfo.getRowSpan(), $this$toAccessibilityCollectionItemInfo.getColumnIndex(), $this$toAccessibilityCollectionItemInfo.getColumnSpan(), false, (Boolean)itemNode.getConfig().getOrElse(SemanticsProperties.INSTANCE.getSelected(), (Function0)CollectionInfo_androidKt.toAccessibilityCollectionItemInfo.1.INSTANCE).booleanValue());
    }
}
