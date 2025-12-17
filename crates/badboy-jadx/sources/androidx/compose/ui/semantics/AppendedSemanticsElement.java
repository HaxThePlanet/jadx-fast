package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0080\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B&\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001a\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\nHÆ\u0003J.\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0019\u0008\u0002\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\nHÆ\u0001J\u0008\u0010\u0017\u001a\u00020\u0002H\u0016J\u0013\u0010\u0018\u001a\u00020\u00052\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0002H\u0016J\u000c\u0010!\u001a\u00020\t*\u00020\"H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\"\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006#", d2 = {"Landroidx/compose/ui/semantics/AppendedSemanticsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/semantics/CoreSemanticsModifierNode;", "Landroidx/compose/ui/semantics/SemanticsModifier;", "mergeDescendants", "", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;)V", "getMergeDescendants", "()Z", "getProperties", "()Lkotlin/jvm/functions/Function1;", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "component1", "component2", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AppendedSemanticsElement extends ModifierNodeElement<androidx.compose.ui.semantics.CoreSemanticsModifierNode> implements androidx.compose.ui.semantics.SemanticsModifier {

    public static final int $stable;
    private final boolean mergeDescendants;
    private final Function1<androidx.compose.ui.semantics.SemanticsPropertyReceiver, Unit> properties;
    static {
    }

    public AppendedSemanticsElement(boolean mergeDescendants, Function1<? super androidx.compose.ui.semantics.SemanticsPropertyReceiver, Unit> properties) {
        super();
        this.mergeDescendants = mergeDescendants;
        this.properties = properties;
    }

    public static androidx.compose.ui.semantics.AppendedSemanticsElement copy$default(androidx.compose.ui.semantics.AppendedSemanticsElement appendedSemanticsElement, boolean z2, Function1 function13, int i4, Object object5) {
        boolean obj1;
        Function1 obj2;
        if (i4 & 1 != 0) {
            obj1 = appendedSemanticsElement.mergeDescendants;
        }
        if (i4 &= 2 != 0) {
            obj2 = appendedSemanticsElement.properties;
        }
        return appendedSemanticsElement.copy(obj1, obj2);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean component1() {
        return this.mergeDescendants;
    }

    public final Function1<androidx.compose.ui.semantics.SemanticsPropertyReceiver, Unit> component2() {
        return this.properties;
    }

    public final androidx.compose.ui.semantics.AppendedSemanticsElement copy(boolean z, Function1<? super androidx.compose.ui.semantics.SemanticsPropertyReceiver, Unit> function12) {
        AppendedSemanticsElement appendedSemanticsElement = new AppendedSemanticsElement(z, function12);
        return appendedSemanticsElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.semantics.CoreSemanticsModifierNode create() {
        CoreSemanticsModifierNode coreSemanticsModifierNode = new CoreSemanticsModifierNode(this.mergeDescendants, 0, this.properties);
        return coreSemanticsModifierNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof AppendedSemanticsElement) {
            return i2;
        }
        Object obj = object;
        if (this.mergeDescendants != obj.mergeDescendants) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.properties, obj.properties)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean getMergeDescendants() {
        return this.mergeDescendants;
    }

    public final Function1<androidx.compose.ui.semantics.SemanticsPropertyReceiver, Unit> getProperties() {
        return this.properties;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.semantics.SemanticsConfiguration getSemanticsConfiguration() {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        final androidx.compose.ui.semantics.SemanticsConfiguration semanticsConfiguration2 = semanticsConfiguration;
        final int i = 0;
        semanticsConfiguration2.setMergingSemanticsOfDescendants(this.mergeDescendants);
        this.properties.invoke(semanticsConfiguration2);
        return semanticsConfiguration;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("semantics");
        $this$inspectableProperties.getProperties().set("mergeDescendants", Boolean.valueOf(this.mergeDescendants));
        SemanticsModifierKt.access$addSemanticsPropertiesFrom($this$inspectableProperties, getSemanticsConfiguration());
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("AppendedSemanticsElement(mergeDescendants=").append(this.mergeDescendants).append(", properties=").append(this.properties).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((CoreSemanticsModifierNode)node);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.ui.semantics.CoreSemanticsModifierNode node) {
        node.setMergeDescendants(this.mergeDescendants);
        node.setProperties(this.properties);
    }
}
