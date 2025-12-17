package androidx.activity.compose;

import android.content.ContextWrapper;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0086\u0004R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058G¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u000c", d2 = {"Landroidx/activity/compose/LocalActivityResultRegistryOwner;", "", "()V", "LocalComposition", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/activity/result/ActivityResultRegistryOwner;", "current", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Landroidx/activity/result/ActivityResultRegistryOwner;", "provides", "Landroidx/compose/runtime/ProvidedValue;", "registryOwner", "activity-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LocalActivityResultRegistryOwner {

    public static final int $stable;
    public static final androidx.activity.compose.LocalActivityResultRegistryOwner INSTANCE;
    private static final ProvidableCompositionLocal<ActivityResultRegistryOwner> LocalComposition;
    static {
        LocalActivityResultRegistryOwner localActivityResultRegistryOwner = new LocalActivityResultRegistryOwner();
        LocalActivityResultRegistryOwner.INSTANCE = localActivityResultRegistryOwner;
        final int i2 = 0;
        LocalActivityResultRegistryOwner.LocalComposition = CompositionLocalKt.compositionLocalOf$default(i2, (Function0)LocalActivityResultRegistryOwner.LocalComposition.1.INSTANCE, 1, i2);
    }

    public final ActivityResultRegistryOwner getCurrent(Composer $composer, int $changed) {
        int i3;
        boolean traceInProgress;
        Object innerContext$iv;
        String str;
        int i2;
        boolean i;
        Object consume2;
        Object consume;
        int i4 = 1418020823;
        ComposerKt.sourceInformationMarkerStart($composer, i4, "C(<get-current>)48@1959L7:ActivityResultRegistry.kt#q1dkbc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.activity.compose.LocalActivityResultRegistryOwner.<get-current> (ActivityResultRegistry.kt:48)");
        }
        innerContext$iv = 0;
        i = 0;
        consume2 = 2023513938;
        final String str4 = "CC:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, consume2, str4);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if ((ActivityResultRegistryOwner)$composer.consume((CompositionLocal)LocalActivityResultRegistryOwner.LocalComposition) == null) {
            $composer.startReplaceGroup(1006590171);
            ComposerKt.sourceInformation($composer, "*48@2022L7");
            int i6 = 0;
            i2 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, consume2, str4);
            ComposerKt.sourceInformationMarkerEnd($composer);
            i3 = 0;
            innerContext$iv = consume2;
            while (innerContext$iv instanceof ContextWrapper) {
                innerContext$iv = (ContextWrapper)innerContext$iv.getBaseContext();
            }
            innerContext$iv = i;
            consume = innerContext$iv;
        } else {
            $composer.startReplaceGroup(1006589303);
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return consume;
    }

    public final ProvidedValue<ActivityResultRegistryOwner> provides(ActivityResultRegistryOwner registryOwner) {
        return LocalActivityResultRegistryOwner.LocalComposition.provides(registryOwner);
    }
}
