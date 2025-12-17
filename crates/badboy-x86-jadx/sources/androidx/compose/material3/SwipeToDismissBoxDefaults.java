package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\u0004\u0012\u00020\u00050\u00048G¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Landroidx/compose/material3/SwipeToDismissBoxDefaults;", "", "()V", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "totalDistance", "getPositionalThreshold", "(Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function1;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwipeToDismissBoxDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.SwipeToDismissBoxDefaults INSTANCE;
    static {
        SwipeToDismissBoxDefaults swipeToDismissBoxDefaults = new SwipeToDismissBoxDefaults();
        SwipeToDismissBoxDefaults.INSTANCE = swipeToDismissBoxDefaults;
    }

    public final Function1<Float, Float> getPositionalThreshold(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object empty;
        Object anon;
        int i = 1545861529;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C:SwipeToDismissBox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SwipeToDismissBoxDefaults.<get-positionalThreshold> (SwipeToDismissBox.kt:261)");
        }
        $composer.startReplaceGroup(-1853326336);
        ComposerKt.sourceInformation($composer, "*261@10762L7,261@10773L16");
        int i3 = 0;
        int i5 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        Object this_$iv = consume;
        int i4 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 963645440, "CC(remember):SwipeToDismissBox.kt#9igjgp");
        Composer composer = $composer;
        int i8 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i9 = 0;
        if (!$composer.changed((Density)this_$iv)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new SwipeToDismissBoxDefaults.positionalThreshold.1.1.1(this_$iv);
                composer.updateRememberedValue((Function1)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Function1)anon;
    }
}
