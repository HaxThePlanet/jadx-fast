package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0004H\u0001¢\u0006\u0002\u0010\u0005¨\u0006\u0006", d2 = {"PlatformMaterialTheme", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MaterialTheme_androidKt {
    public static final void PlatformMaterialTheme(Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress2;
        int $dirty;
        int i;
        int traceInProgress;
        int str;
        traceInProgress2 = -1322912246;
        final Composer obj5 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj5, "C(PlatformMaterialTheme)22@789L9:MaterialTheme.android.kt#jmzs0o");
        str = 2;
        if ($changed & 6 == 0) {
            i = obj5.changedInstance(content) ? 4 : str;
            $dirty |= i;
        }
        if ($dirty & 3 == str) {
            if (!obj5.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.PlatformMaterialTheme (MaterialTheme.android.kt:21)");
                }
                content.invoke(obj5, Integer.valueOf($dirty & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj5.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj5.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new MaterialTheme_androidKt.PlatformMaterialTheme.1(content, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }
}
