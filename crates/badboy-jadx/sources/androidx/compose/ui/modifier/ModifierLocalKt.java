package androidx.compose.ui.modifier;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\u0005", d2 = {"modifierLocalOf", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "T", "defaultFactory", "Lkotlin/Function0;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ModifierLocalKt {
    public static final <T> androidx.compose.ui.modifier.ProvidableModifierLocal<T> modifierLocalOf(Function0<? extends T> defaultFactory) {
        ProvidableModifierLocal providableModifierLocal = new ProvidableModifierLocal(defaultFactory);
        return providableModifierLocal;
    }
}
