package androidx.compose.foundation;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\"$\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"LocalOverscrollConfiguration", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/OverscrollConfiguration;", "getLocalOverscrollConfiguration$annotations", "()V", "getLocalOverscrollConfiguration", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OverscrollConfiguration_androidKt {

    private static final ProvidableCompositionLocal<androidx.compose.foundation.OverscrollConfiguration> LocalOverscrollConfiguration;
    static {
        final int i2 = 0;
        OverscrollConfiguration_androidKt.LocalOverscrollConfiguration = CompositionLocalKt.compositionLocalOf$default(i2, (Function0)OverscrollConfiguration_androidKt.LocalOverscrollConfiguration.1.INSTANCE, 1, i2);
    }

    public static final ProvidableCompositionLocal<androidx.compose.foundation.OverscrollConfiguration> getLocalOverscrollConfiguration() {
        return OverscrollConfiguration_androidKt.LocalOverscrollConfiguration;
    }

    public static void getLocalOverscrollConfiguration$annotations() {
    }
}
