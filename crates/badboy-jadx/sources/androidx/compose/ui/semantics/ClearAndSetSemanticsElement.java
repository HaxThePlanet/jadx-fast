package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0080\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001e\u0012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0008\u0008¢\u0006\u0002\u0010\tJ\u001a\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0008\u0008HÆ\u0003J$\u0010\u0011\u001a\u00020\u00002\u0019\u0008\u0002\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0008\u0008HÆ\u0001J\u0008\u0010\u0012\u001a\u00020\u0002H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u000c\u0010\u001d\u001a\u00020\u0007*\u00020\u001eH\u0016R\"\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0008\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u000c\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\u001f", d2 = {"Landroidx/compose/ui/semantics/ClearAndSetSemanticsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/semantics/CoreSemanticsModifierNode;", "Landroidx/compose/ui/semantics/SemanticsModifier;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "getProperties", "()Lkotlin/jvm/functions/Function1;", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "component1", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClearAndSetSemanticsElement extends ModifierNodeElement<androidx.compose.ui.semantics.CoreSemanticsModifierNode> implements androidx.compose.ui.semantics.SemanticsModifier {

    public static final int $stable;
    private final Function1<androidx.compose.ui.semantics.SemanticsPropertyReceiver, Unit> properties;
    static {
    }

    public ClearAndSetSemanticsElement(Function1<? super androidx.compose.ui.semantics.SemanticsPropertyReceiver, Unit> properties) {
        super();
        this.properties = properties;
    }

    public static androidx.compose.ui.semantics.ClearAndSetSemanticsElement copy$default(androidx.compose.ui.semantics.ClearAndSetSemanticsElement clearAndSetSemanticsElement, Function1 function12, int i3, Object object4) {
        Function1 obj1;
        if (i3 &= 1 != 0) {
            obj1 = clearAndSetSemanticsElement.properties;
        }
        return clearAndSetSemanticsElement.copy(obj1);
    }

    public final Function1<androidx.compose.ui.semantics.SemanticsPropertyReceiver, Unit> component1() {
        return this.properties;
    }

    public final androidx.compose.ui.semantics.ClearAndSetSemanticsElement copy(Function1<? super androidx.compose.ui.semantics.SemanticsPropertyReceiver, Unit> function1) {
        ClearAndSetSemanticsElement clearAndSetSemanticsElement = new ClearAndSetSemanticsElement(function1);
        return clearAndSetSemanticsElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.semantics.CoreSemanticsModifierNode create() {
        CoreSemanticsModifierNode coreSemanticsModifierNode = new CoreSemanticsModifierNode(0, 1, this.properties);
        return coreSemanticsModifierNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ClearAndSetSemanticsElement) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.properties, obj.properties)) {
            return i2;
        }
        return i;
    }

    public final Function1<androidx.compose.ui.semantics.SemanticsPropertyReceiver, Unit> getProperties() {
        return this.properties;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.semantics.SemanticsConfiguration getSemanticsConfiguration() {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        final androidx.compose.ui.semantics.SemanticsConfiguration semanticsConfiguration2 = semanticsConfiguration;
        final int i = 0;
        semanticsConfiguration2.setMergingSemanticsOfDescendants(false);
        semanticsConfiguration2.setClearingSemantics(true);
        this.properties.invoke(semanticsConfiguration2);
        return semanticsConfiguration;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.properties.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("clearAndSetSemantics");
        SemanticsModifierKt.access$addSemanticsPropertiesFrom($this$inspectableProperties, getSemanticsConfiguration());
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ClearAndSetSemanticsElement(properties=").append(this.properties).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((CoreSemanticsModifierNode)node);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.ui.semantics.CoreSemanticsModifierNode node) {
        node.setProperties(this.properties);
    }
}
