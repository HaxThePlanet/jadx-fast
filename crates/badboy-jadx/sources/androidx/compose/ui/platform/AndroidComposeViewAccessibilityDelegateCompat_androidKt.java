package androidx.compose.ui.platform;

import androidx.compose.ui.contentcapture.ContentCaptureManager;
import androidx.compose.ui.contentcapture.ContentCaptureManager.Companion;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u000f\u001a\u00020\u0001*\u0006\u0012\u0002\u0008\u00030\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002\u001a\u000c\u0010\u0013\u001a\u00020\u0001*\u00020\nH\u0002\u001a\u000c\u0010\u0014\u001a\u00020\u0001*\u00020\nH\u0002\u001a\"\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0018H\u0002\u001a\u0014\u0010\u0019\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002\"*\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u00018G@GX\u0087\u000e¢\u0006\u0012\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008\"\u0018\u0010\t\u001a\u00020\u0001*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u000b\"\u001e\u0010\u000c\u001a\u00020\u0001*\u00020\n8BX\u0082\u0004¢\u0006\u000c\u0012\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u001c", d2 = {"value", "", "DisableContentCapture", "getDisableContentCapture$annotations", "()V", "getDisableContentCapture", "()Z", "setDisableContentCapture", "(Z)V", "isRtl", "Landroidx/compose/ui/semantics/SemanticsNode;", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "isVisible", "isVisible$annotations", "(Landroidx/compose/ui/semantics/SemanticsNode;)V", "accessibilityEquals", "Landroidx/compose/ui/semantics/AccessibilityAction;", "other", "", "enabled", "excludeLineAndPageGranularities", "findClosestParentNode", "Landroidx/compose/ui/node/LayoutNode;", "selector", "Lkotlin/Function1;", "propertiesDeleted", "oldConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidComposeViewAccessibilityDelegateCompat_androidKt {
    public static final boolean access$accessibilityEquals(AccessibilityAction $receiver, Object other) {
        return AndroidComposeViewAccessibilityDelegateCompat_androidKt.accessibilityEquals($receiver, other);
    }

    public static final boolean access$enabled(SemanticsNode $receiver) {
        return AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled($receiver);
    }

    public static final boolean access$excludeLineAndPageGranularities(SemanticsNode $receiver) {
        return AndroidComposeViewAccessibilityDelegateCompat_androidKt.excludeLineAndPageGranularities($receiver);
    }

    public static final LayoutNode access$findClosestParentNode(LayoutNode $receiver, Function1 selector) {
        return AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode($receiver, selector);
    }

    public static final boolean access$isRtl(SemanticsNode $receiver) {
        return AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl($receiver);
    }

    public static final boolean access$isVisible(SemanticsNode $receiver) {
        return AndroidComposeViewAccessibilityDelegateCompat_androidKt.isVisible($receiver);
    }

    public static final boolean access$propertiesDeleted(SemanticsNode $receiver, SemanticsConfiguration oldConfig) {
        return AndroidComposeViewAccessibilityDelegateCompat_androidKt.propertiesDeleted($receiver, oldConfig);
    }

    private static final boolean accessibilityEquals(AccessibilityAction<?> $this$accessibilityEquals, Object other) {
        kotlin.Function action2;
        kotlin.Function action;
        final int i = 1;
        if ($this$accessibilityEquals == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof AccessibilityAction) {
            return i2;
        }
        if (!Intrinsics.areEqual($this$accessibilityEquals.getLabel(), (AccessibilityAction)other.getLabel())) {
            return i2;
        }
        if ($this$accessibilityEquals.getAction() == null && (AccessibilityAction)other.getAction() != null) {
            if ((AccessibilityAction)other.getAction() != null) {
                return i2;
            }
        }
        if ($this$accessibilityEquals.getAction() != null && (AccessibilityAction)other.getAction() == null) {
            if ((AccessibilityAction)other.getAction() == null) {
                return i2;
            }
        }
        return i;
    }

    private static final boolean enabled(SemanticsNode $this$enabled) {
        return contains ^= 1;
    }

    private static final boolean excludeLineAndPageGranularities(SemanticsNode $this$excludeLineAndPageGranularities) {
        boolean contains;
        int i;
        Boolean valueOf;
        androidx.compose.ui.semantics.SemanticsPropertyKey focused2;
        SemanticsConfiguration collapsedSemantics$ui_release;
        androidx.compose.ui.semantics.SemanticsPropertyKey focused;
        i = 1;
        valueOf = Boolean.valueOf(i);
        if ($this$excludeLineAndPageGranularities.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getEditableText()) && !Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull($this$excludeLineAndPageGranularities.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getFocused()), valueOf)) {
            if (!Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull($this$excludeLineAndPageGranularities.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getFocused()), valueOf)) {
                return i;
            }
        }
        LayoutNode closestParentNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode($this$excludeLineAndPageGranularities.getLayoutNode$ui_release(), (Function1)AndroidComposeViewAccessibilityDelegateCompat_androidKt.excludeLineAndPageGranularities.ancestor.1.INSTANCE);
        int i2 = 0;
        if (closestParentNode != null) {
            collapsedSemantics$ui_release = closestParentNode.getCollapsedSemantics$ui_release();
            if (collapsedSemantics$ui_release != null) {
                valueOf = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(collapsedSemantics$ui_release, SemanticsProperties.INSTANCE.getFocused()), valueOf);
            } else {
                valueOf = i2;
            }
            if (valueOf == 0) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    private static final LayoutNode findClosestParentNode(LayoutNode $this$findClosestParentNode, Function1<? super LayoutNode, Boolean> selector) {
        LayoutNode currentParent;
        boolean booleanValue;
        currentParent = $this$findClosestParentNode.getParent$ui_release();
        while (currentParent != null) {
            currentParent = currentParent.getParent$ui_release();
        }
        return null;
    }

    public static final boolean getDisableContentCapture() {
        return ContentCaptureManager.Companion.isEnabled();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use ContentCapture.isEnabled instead", replaceWith = @ReplaceWith(...))
    public static void getDisableContentCapture$annotations() {
    }

    private static final boolean isRtl(SemanticsNode $this$isRtl) {
        int i;
        i = $this$isRtl.getLayoutInfo().getLayoutDirection() == LayoutDirection.Rtl ? 1 : 0;
        return i;
    }

    private static final boolean isVisible(SemanticsNode $this$isVisible) {
        boolean transparent$ui_release;
        int i;
        androidx.compose.ui.semantics.SemanticsPropertyKey invisibleToUser;
        if (!$this$isVisible.isTransparent$ui_release() && !$this$isVisible.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getInvisibleToUser())) {
            i = !$this$isVisible.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getInvisibleToUser()) ? 1 : 0;
        } else {
        }
        return i;
    }

    private static void isVisible$annotations(SemanticsNode semanticsNode) {
    }

    private static final boolean propertiesDeleted(SemanticsNode $this$propertiesDeleted, SemanticsConfiguration oldConfig) {
        Object next;
        boolean contains;
        Object key;
        Iterator iterator = oldConfig.iterator();
        for (Map.Entry next : iterator) {
        }
        return 0;
    }

    public static final void setDisableContentCapture(boolean value) {
        ContentCaptureManager.Companion.setEnabled(value);
    }
}
