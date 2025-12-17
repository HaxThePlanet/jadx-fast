package androidx.compose.material;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/material/ScaffoldDefaults;", "", "()V", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getContentWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScaffoldDefaults {

    public static final int $stable;
    public static final androidx.compose.material.ScaffoldDefaults INSTANCE;
    static {
        ScaffoldDefaults scaffoldDefaults = new ScaffoldDefaults();
        ScaffoldDefaults.INSTANCE = scaffoldDefaults;
    }

    public final WindowInsets getContentWindowInsets(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 423092031;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C362@16537L29:Scaffold.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.ScaffoldDefaults.<get-contentWindowInsets> (Scaffold.kt:362)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, $composer, 6);
    }
}
