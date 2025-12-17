package androidx.compose.material3;

import android.content.res.Configuration;
import android.os.LocaleList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004", d2 = {"Landroidx/compose/material3/Locale24;", "", "()V", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class Locale24 {

    public static final androidx.compose.material3.Locale24.Companion Companion;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/material3/Locale24$Companion;", "", "()V", "defaultLocale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Landroidx/compose/runtime/Composer;I)Ljava/util/Locale;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Locale defaultLocale(Composer $composer, int $changed) {
            boolean traceInProgress;
            String str;
            int i = 317587697;
            ComposerKt.sourceInformationMarkerStart($composer, i, "C(defaultLocale)44@1519L7:CalendarLocale.android.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.Locale24.Companion.defaultLocale (CalendarLocale.android.kt:43)");
            }
            int i2 = 0;
            int i4 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            return (Configuration)$composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalConfiguration()).getLocales().get(0);
        }
    }
    static {
        Locale24.Companion companion = new Locale24.Companion(0);
        Locale24.Companion = companion;
    }
}
