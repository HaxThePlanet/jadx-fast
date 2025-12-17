package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008g\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'¢\u0006\u0002\u0010\u0007J\u001b\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0006H'¢\u0006\u0002\u0010\u0007J+\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000cH'¢\u0006\u0002\u0010\rJ+\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000cH'¢\u0006\u0002\u0010\rJ#\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H'¢\u0006\u0002\u0010\u0011J+\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000cH\u0017¢\u0006\u0002\u0010\rJ\u001b\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'¢\u0006\u0002\u0010\u0007J\u001b\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'¢\u0006\u0002\u0010\u0007J#\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H'¢\u0006\u0002\u0010\u0011J+\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000cH\u0017¢\u0006\u0002\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0015À\u0006\u0001", d2 = {"Landroidx/compose/material/TextFieldColors;", "", "backgroundColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "cursorColor", "isError", "indicatorColor", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "labelColor", "error", "leadingIconColor", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "placeholderColor", "textColor", "trailingIconColor", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface TextFieldColors {
    public abstract State<Color> backgroundColor(boolean z, Composer composer2, int i3);

    public abstract State<Color> cursorColor(boolean z, Composer composer2, int i3);

    public abstract State<Color> indicatorColor(boolean z, boolean z2, InteractionSource interactionSource3, Composer composer4, int i5);

    public abstract State<Color> labelColor(boolean z, boolean z2, InteractionSource interactionSource3, Composer composer4, int i5);

    public State<Color> leadingIconColor(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1036335134;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(leadingIconColor)P(!1,2)130@5098L34:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.TextFieldColors.leadingIconColor (TextFieldDefaults.kt:128)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return leadingIconColor(enabled, isError, $composer, i3 |= i7);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use/implement overload with interactionSource parameter", replaceWith = @ReplaceWith(...))
    public abstract State<Color> leadingIconColor(boolean z, boolean z2, Composer composer3, int i4);

    public abstract State<Color> placeholderColor(boolean z, Composer composer2, int i3);

    public abstract State<Color> textColor(boolean z, Composer composer2, int i3);

    public State<Color> trailingIconColor(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 454310320;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(trailingIconColor)P(!1,2)163@6284L35:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.TextFieldColors.trailingIconColor (TextFieldDefaults.kt:161)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return trailingIconColor(enabled, isError, $composer, i3 |= i7);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use/implement overload with interactionSource parameter", replaceWith = @ReplaceWith(...))
    public abstract State<Color> trailingIconColor(boolean z, boolean z2, Composer composer3, int i4);
}
