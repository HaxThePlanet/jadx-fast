package androidx.compose.foundation.content.internal;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u0006H\u0000\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\u0007", d2 = {"ModifierLocalReceiveContent", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "getModifierLocalReceiveContent", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getReceiveContentConfiguration", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ReceiveContentConfigurationKt {

    private static final ProvidableModifierLocal<androidx.compose.foundation.content.internal.ReceiveContentConfiguration> ModifierLocalReceiveContent;
    static {
        ReceiveContentConfigurationKt.ModifierLocalReceiveContent = ModifierLocalKt.modifierLocalOf((Function0)ReceiveContentConfigurationKt.ModifierLocalReceiveContent.1.INSTANCE);
    }

    public static final ProvidableModifierLocal<androidx.compose.foundation.content.internal.ReceiveContentConfiguration> getModifierLocalReceiveContent() {
        return ReceiveContentConfigurationKt.ModifierLocalReceiveContent;
    }

    public static final androidx.compose.foundation.content.internal.ReceiveContentConfiguration getReceiveContentConfiguration(ModifierLocalModifierNode $this$getReceiveContentConfiguration) {
        Object current;
        if ($this$getReceiveContentConfiguration.getNode().isAttached()) {
            current = $this$getReceiveContentConfiguration.getCurrent((ModifierLocal)ReceiveContentConfigurationKt.ModifierLocalReceiveContent);
        } else {
            current = 0;
        }
        return current;
    }
}
