package androidx.activity.compose;

import android.content.ContextWrapper;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0086\u0004R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058G¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u000c", d2 = {"Landroidx/activity/compose/LocalOnBackPressedDispatcherOwner;", "", "()V", "LocalOnBackPressedDispatcherOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/activity/OnBackPressedDispatcherOwner;", "current", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Landroidx/activity/OnBackPressedDispatcherOwner;", "provides", "Landroidx/compose/runtime/ProvidedValue;", "dispatcherOwner", "activity-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LocalOnBackPressedDispatcherOwner {

    public static final int $stable;
    public static final androidx.activity.compose.LocalOnBackPressedDispatcherOwner INSTANCE;
    private static final ProvidableCompositionLocal<OnBackPressedDispatcherOwner> LocalOnBackPressedDispatcherOwner;
    static {
        LocalOnBackPressedDispatcherOwner localOnBackPressedDispatcherOwner = new LocalOnBackPressedDispatcherOwner();
        LocalOnBackPressedDispatcherOwner.INSTANCE = localOnBackPressedDispatcherOwner;
        final int i2 = 0;
        LocalOnBackPressedDispatcherOwner.LocalOnBackPressedDispatcherOwner = CompositionLocalKt.compositionLocalOf$default(i2, (Function0)LocalOnBackPressedDispatcherOwner.LocalOnBackPressedDispatcherOwner.1.INSTANCE, 1, i2);
    }

    public final OnBackPressedDispatcherOwner getCurrent(Composer $composer, int $changed) {
        ProvidableCompositionLocal localView;
        int i2;
        boolean traceInProgress;
        int innerContext$iv;
        String str;
        int i;
        int i3;
        Object consume2;
        Object consume;
        int i4 = -2068013981;
        ComposerKt.sourceInformationMarkerStart($composer, i4, "C(<get-current>)50@2099L7:BackHandler.kt#q1dkbc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.activity.compose.LocalOnBackPressedDispatcherOwner.<get-current> (BackHandler.kt:50)");
        }
        innerContext$iv = 0;
        i = 0;
        consume2 = 2023513938;
        final String str5 = "CC:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, consume2, str5);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if ((OnBackPressedDispatcherOwner)$composer.consume((CompositionLocal)LocalOnBackPressedDispatcherOwner.LocalOnBackPressedDispatcherOwner) == null) {
            $composer.startReplaceGroup(544166745);
            ComposerKt.sourceInformation($composer, "51@2136L7");
            innerContext$iv = 0;
            i = 0;
            ComposerKt.sourceInformationMarkerStart($composer, consume2, str5);
            ComposerKt.sourceInformationMarkerEnd($composer);
            consume = ViewTreeOnBackPressedDispatcherOwner.get((View)$composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalView()));
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(544164296);
            $composer.endReplaceGroup();
        }
        if (consume == null) {
            $composer.startReplaceGroup(544168748);
            ComposerKt.sourceInformation($composer, "*52@2259L7");
            int i7 = 0;
            i3 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, consume2, str5);
            ComposerKt.sourceInformationMarkerEnd($composer);
            i2 = 0;
            innerContext$iv = consume2;
            while (innerContext$iv instanceof ContextWrapper) {
                innerContext$iv = (ContextWrapper)innerContext$iv.getBaseContext();
            }
            innerContext$iv = i;
            consume = innerContext$iv;
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(544164377);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return consume;
    }

    public final ProvidedValue<OnBackPressedDispatcherOwner> provides(OnBackPressedDispatcherOwner dispatcherOwner) {
        return LocalOnBackPressedDispatcherOwner.LocalOnBackPressedDispatcherOwner.provides(dispatcherOwner);
    }
}
