package androidx.compose.ui.modifier;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u00020\u00012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0006H\u0007¨\u0006\u0007", d2 = {"modifierLocalProvider", "Landroidx/compose/ui/Modifier;", "T", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "Lkotlin/Function0;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ModifierLocalProviderKt {
    public static final <T> Modifier modifierLocalProvider(Modifier $this$modifierLocalProvider, androidx.compose.ui.modifier.ProvidableModifierLocal<T> key, Function0<? extends T> value) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new ModifierLocalProviderKt.modifierLocalProvider$$inlined.debugInspectorInfo.1(key, value);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        ModifierLocalProviderKt.modifierLocalProvider.1 anon = new ModifierLocalProviderKt.modifierLocalProvider.1(key, value, noInspectorInfo);
        return $this$modifierLocalProvider.then((Modifier)anon);
    }
}
