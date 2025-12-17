package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"rememberSaveableStateHolder", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/saveable/SaveableStateHolder;", "runtime-saveable_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SaveableStateHolderKt {
    public static final androidx.compose.runtime.saveable.SaveableStateHolder rememberSaveableStateHolder(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 15454635;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberSaveableStateHolder):SaveableStateHolder.kt#r2ddri");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.runtime.saveable.rememberSaveableStateHolder (SaveableStateHolder.kt:60)");
        }
        $composer.startReplaceGroup(-796080049);
        ComposerKt.sourceInformation($composer, "*60@2434L111,65@2619L7");
        final Composer composer = $composer;
        final Object obj8 = RememberSaveableKt.rememberSaveable(new Object[0], SaveableStateHolderImpl.Companion.getSaver(), 0, (Function0)SaveableStateHolderKt.rememberSaveableStateHolder.1.INSTANCE, composer, 3072, 4);
        int i4 = 0;
        int i6 = 6;
        int i7 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd(composer);
        (SaveableStateHolderImpl)obj8.setParentSaveableStateRegistry((SaveableStateRegistry)composer.consume((CompositionLocal)SaveableStateRegistryKt.getLocalSaveableStateRegistry()));
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (SaveableStateHolder)(SaveableStateHolderImpl)obj8;
    }
}
