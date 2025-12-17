package androidx.compose.material3.internal;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00080\u0007\"\u00020\u0008H\u0001ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\n\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000b", d2 = {"getString", "", "string", "Landroidx/compose/material3/internal/Strings;", "getString-2EP1pXo", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "formatArgs", "", "", "getString-qBjtwXw", "(I[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Strings_androidKt {
    public static final String getString-2EP1pXo(int string, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -907677715;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(getString)P(0:c#material3.internal.Strings)31@1161L7,32@1202L7:Strings.android.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.internal.getString (Strings.android.kt:30)");
        }
        int i2 = 0;
        int i4 = 0;
        int i6 = 2023513938;
        final String str3 = "CC:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, i6, str3);
        $composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalConfiguration());
        ComposerKt.sourceInformationMarkerEnd($composer);
        int i3 = 0;
        int i5 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, i6, str3);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Context)$composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalContext()).getResources().getString(string);
    }

    public static final String getString-qBjtwXw(int string, Object[] formatArgs, Composer $composer, int $changed) {
        boolean traceInProgress;
        Locale default;
        String str;
        int i = -1427268608;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(getString)P(1:c#material3.internal.Strings)39@1395L17,41@1488L7:Strings.android.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.internal.getString (Strings.android.kt:38)");
        }
        int i3 = 0;
        int i5 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ConfigurationCompat.getLocales((Configuration)$composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalConfiguration())).get(0) == null) {
            default = Locale.getDefault();
        }
        StringCompanionObject iNSTANCE = StringCompanionObject.INSTANCE;
        Object[] copyOf = Arrays.copyOf(formatArgs, formatArgs.length);
        String format = String.format(default, Strings_androidKt.getString-2EP1pXo(string, $composer, $changed & 14), Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return format;
    }
}
