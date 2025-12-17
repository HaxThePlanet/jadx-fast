package androidx.compose.material3.internal;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u001e\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\u0008\u0002\u0010\u0003\u001a\u0004\u0008\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u0008X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"HorizontalSemanticsBoundsPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalSemanticsBoundsPadding$annotations", "()V", "getHorizontalSemanticsBoundsPadding", "()F", "F", "IncreaseHorizontalSemanticsBounds", "Landroidx/compose/ui/Modifier;", "getIncreaseHorizontalSemanticsBounds", "()Landroidx/compose/ui/Modifier;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AccessibilityUtilKt {

    private static final float HorizontalSemanticsBoundsPadding;
    private static final Modifier IncreaseHorizontalSemanticsBounds;
    static {
        int i2 = 0;
        AccessibilityUtilKt.HorizontalSemanticsBoundsPadding = Dp.constructor-impl((float)i);
        AccessibilityUtilKt.IncreaseHorizontalSemanticsBounds = PaddingKt.padding-VpY3zN4$default(SemanticsModifierKt.semantics(LayoutModifierKt.layout((Modifier)Modifier.Companion, (Function3)AccessibilityUtilKt.IncreaseHorizontalSemanticsBounds.1.INSTANCE), true, (Function1)AccessibilityUtilKt.IncreaseHorizontalSemanticsBounds.2.INSTANCE), AccessibilityUtilKt.HorizontalSemanticsBoundsPadding, 0, 2, 0);
    }

    public static final float getHorizontalSemanticsBoundsPadding() {
        return AccessibilityUtilKt.HorizontalSemanticsBoundsPadding;
    }

    public static void getHorizontalSemanticsBoundsPadding$annotations() {
    }

    public static final Modifier getIncreaseHorizontalSemanticsBounds() {
        return AccessibilityUtilKt.IncreaseHorizontalSemanticsBounds;
    }
}
