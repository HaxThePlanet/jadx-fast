package androidx.compose.ui.platform;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\"\u0017\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\u0005", d2 = {"LocalInspectionMode", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalInspectionMode", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InspectionModeKt {

    private static final ProvidableCompositionLocal<Boolean> LocalInspectionMode;
    static {
        InspectionModeKt.LocalInspectionMode = CompositionLocalKt.staticCompositionLocalOf((Function0)InspectionModeKt.LocalInspectionMode.1.INSTANCE);
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalInspectionMode() {
        return InspectionModeKt.LocalInspectionMode;
    }
}
