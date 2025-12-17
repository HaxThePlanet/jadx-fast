package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0008\u001a\u00020\t*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"IndicationInstanceDeprecationMessage", "", "LocalIndication", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/Indication;", "getLocalIndication", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "RememberUpdatedInstanceDeprecationMessage", "indication", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IndicationKt {

    private static final String IndicationInstanceDeprecationMessage = "IndicationInstance has been deprecated along with the rememberUpdatedInstance that returns it. Indication implementations should instead use Modifier.Node APIs, and should be returned from IndicationNodeFactory#create. For a migration guide and background information, please visit developer.android.com";
    private static final ProvidableCompositionLocal<androidx.compose.foundation.Indication> LocalIndication = null;
    private static final String RememberUpdatedInstanceDeprecationMessage = "rememberUpdatedInstance has been deprecated - implementers should instead implement IndicationNodeFactory#create for improved performance and efficiency. Callers should check if the Indication is an IndicationNodeFactory, and call that API instead. For a migration guide and background information, please visit developer.android.com";
    static {
        IndicationKt.LocalIndication = CompositionLocalKt.staticCompositionLocalOf((Function0)IndicationKt.LocalIndication.1.INSTANCE);
    }

    public static final ProvidableCompositionLocal<androidx.compose.foundation.Indication> getLocalIndication() {
        return IndicationKt.LocalIndication;
    }

    public static final Modifier indication(Modifier $this$indication, InteractionSource interactionSource, androidx.compose.foundation.Indication indication) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        if (indication == null) {
            return $this$indication;
        }
        if (indication instanceof IndicationNodeFactory != null) {
            IndicationModifierElement indicationModifierElement = new IndicationModifierElement(interactionSource, (IndicationNodeFactory)indication);
            return $this$indication.then((Modifier)indicationModifierElement);
        }
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new IndicationKt.indication$$inlined.debugInspectorInfo.1(interactionSource, indication);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        IndicationKt.indication.2 anon = new IndicationKt.indication.2(indication, interactionSource);
        return ComposedModifierKt.composed($this$indication, noInspectorInfo, (Function3)anon);
    }
}
