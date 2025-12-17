package androidx.compose.ui.modifier;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0007¨\u0006\u0007", d2 = {"modifierLocalConsumer", "Landroidx/compose/ui/Modifier;", "consumer", "Lkotlin/Function1;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "", "Lkotlin/ExtensionFunctionType;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ModifierLocalConsumerKt {
    public static final Modifier modifierLocalConsumer(Modifier $this$modifierLocalConsumer, Function1<? super androidx.compose.ui.modifier.ModifierLocalReadScope, Unit> consumer) {
        Function1 noInspectorInfo;
        final int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new ModifierLocalConsumerKt.modifierLocalConsumer$$inlined.debugInspectorInfo.1(consumer);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        ModifierLocalConsumerImpl modifierLocalConsumerImpl = new ModifierLocalConsumerImpl(consumer, noInspectorInfo);
        return $this$modifierLocalConsumer.then((Modifier)modifierLocalConsumerImpl);
    }
}
