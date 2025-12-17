package androidx.activity.compose;

import android.content.ContextWrapper;
import androidx.activity.FullyDrawnReporterOwner;
import androidx.activity.ViewTreeFullyDrawnReporterOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0086\u0004R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058G¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u000c", d2 = {"Landroidx/activity/compose/LocalFullyDrawnReporterOwner;", "", "()V", "LocalFullyDrawnReporterOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/activity/FullyDrawnReporterOwner;", "current", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Landroidx/activity/FullyDrawnReporterOwner;", "provides", "Landroidx/compose/runtime/ProvidedValue;", "fullyDrawnReporterOwner", "activity-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LocalFullyDrawnReporterOwner {

    public static final int $stable;
    public static final androidx.activity.compose.LocalFullyDrawnReporterOwner INSTANCE;
    private static final ProvidableCompositionLocal<FullyDrawnReporterOwner> LocalFullyDrawnReporterOwner;
    static {
        LocalFullyDrawnReporterOwner localFullyDrawnReporterOwner = new LocalFullyDrawnReporterOwner();
        LocalFullyDrawnReporterOwner.INSTANCE = localFullyDrawnReporterOwner;
        final int i2 = 0;
        LocalFullyDrawnReporterOwner.LocalFullyDrawnReporterOwner = CompositionLocalKt.compositionLocalOf$default(i2, (Function0)LocalFullyDrawnReporterOwner.LocalFullyDrawnReporterOwner.1.INSTANCE, 1, i2);
    }

    public final FullyDrawnReporterOwner getCurrent(Composer $composer, int $changed) {
        ProvidableCompositionLocal localView;
        int i3;
        boolean traceInProgress;
        int innerContext$iv;
        String str;
        int i;
        int i2;
        Object consume;
        Object consume2;
        int i4 = 540186968;
        ComposerKt.sourceInformationMarkerStart($composer, i4, "C(<get-current>)95@3549L7:ReportDrawn.kt#q1dkbc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.activity.compose.LocalFullyDrawnReporterOwner.<get-current> (ReportDrawn.kt:95)");
        }
        innerContext$iv = 0;
        i = 0;
        consume = 2023513938;
        final String str5 = "CC:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, consume, str5);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if ((FullyDrawnReporterOwner)$composer.consume((CompositionLocal)LocalFullyDrawnReporterOwner.LocalFullyDrawnReporterOwner) == null) {
            $composer.startReplaceGroup(-1738308180);
            ComposerKt.sourceInformation($composer, "96@3586L7");
            innerContext$iv = 0;
            i = 0;
            ComposerKt.sourceInformationMarkerStart($composer, consume, str5);
            ComposerKt.sourceInformationMarkerEnd($composer);
            consume2 = ViewTreeFullyDrawnReporterOwner.get((View)$composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalView()));
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-1738310474);
            $composer.endReplaceGroup();
        }
        if (consume2 == null) {
            $composer.startReplaceGroup(-1738306337);
            ComposerKt.sourceInformation($composer, "*97@3699L7");
            int i7 = 0;
            i2 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, consume, str5);
            ComposerKt.sourceInformationMarkerEnd($composer);
            i3 = 0;
            innerContext$iv = consume;
            while (innerContext$iv instanceof ContextWrapper) {
                innerContext$iv = (ContextWrapper)innerContext$iv.getBaseContext();
            }
            innerContext$iv = i;
            consume2 = innerContext$iv;
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-1738310398);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return consume2;
    }

    public final ProvidedValue<FullyDrawnReporterOwner> provides(FullyDrawnReporterOwner fullyDrawnReporterOwner) {
        return LocalFullyDrawnReporterOwner.LocalFullyDrawnReporterOwner.provides(fullyDrawnReporterOwner);
    }
}
