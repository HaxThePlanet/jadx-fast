package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0006\u0008'\u0018\u00002\u00020\u0001B\u001e\u0012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006¢\u0006\u0002\u0010\u0007R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018¨\u0006\u0019", d2 = {"Landroidx/compose/ui/platform/InspectorValueInfo;", "Landroidx/compose/ui/platform/InspectableValue;", "info", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "_values", "inspectableElements", "Lkotlin/sequences/Sequence;", "Landroidx/compose/ui/platform/ValueElement;", "getInspectableElements", "()Lkotlin/sequences/Sequence;", "nameFallback", "", "getNameFallback", "()Ljava/lang/String;", "valueOverride", "", "getValueOverride", "()Ljava/lang/Object;", "values", "getValues", "()Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class InspectorValueInfo implements androidx.compose.ui.platform.InspectableValue {

    public static final int $stable = 8;
    private androidx.compose.ui.platform.InspectorInfo _values;
    private final Function1<androidx.compose.ui.platform.InspectorInfo, Unit> info;
    static {
        final int i = 8;
    }

    public InspectorValueInfo(Function1<? super androidx.compose.ui.platform.InspectorInfo, Unit> info) {
        super();
        this.info = info;
    }

    private final androidx.compose.ui.platform.InspectorInfo getValues() {
        androidx.compose.ui.platform.InspectorInfo inspectorInfo;
        Function1 info;
        if (this._values == null) {
            inspectorInfo = new InspectorInfo();
            this.info.invoke(inspectorInfo);
        }
        this._values = inspectorInfo;
        return inspectorInfo;
    }

    public Sequence<androidx.compose.ui.platform.ValueElement> getInspectableElements() {
        return (Sequence)getValues().getProperties();
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public String getNameFallback() {
        return getValues().getName();
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public Object getValueOverride() {
        return getValues().getValue();
    }
}
