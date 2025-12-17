package androidx.compose.foundation.gestures;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\"\"\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00018GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\"\u001a\u0010\u0007\u001a\u00020\u0002X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0008\u0010\u0004\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"LocalBringIntoViewSpec", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "getLocalBringIntoViewSpec$annotations", "()V", "getLocalBringIntoViewSpec", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "PivotBringIntoViewSpec", "getPivotBringIntoViewSpec$annotations", "getPivotBringIntoViewSpec", "()Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BringIntoViewSpec_androidKt {

    private static final ProvidableCompositionLocal<androidx.compose.foundation.gestures.BringIntoViewSpec> LocalBringIntoViewSpec;
    private static final androidx.compose.foundation.gestures.BringIntoViewSpec PivotBringIntoViewSpec;
    static {
        BringIntoViewSpec_androidKt.LocalBringIntoViewSpec = CompositionLocalKt.compositionLocalWithComputedDefaultOf((Function1)BringIntoViewSpec_androidKt.LocalBringIntoViewSpec.1.INSTANCE);
        BringIntoViewSpec_androidKt.PivotBringIntoViewSpec.1 anon = new BringIntoViewSpec_androidKt.PivotBringIntoViewSpec.1();
        BringIntoViewSpec_androidKt.PivotBringIntoViewSpec = (BringIntoViewSpec)anon;
    }

    public static final ProvidableCompositionLocal<androidx.compose.foundation.gestures.BringIntoViewSpec> getLocalBringIntoViewSpec() {
        return BringIntoViewSpec_androidKt.LocalBringIntoViewSpec;
    }

    public static void getLocalBringIntoViewSpec$annotations() {
    }

    public static final androidx.compose.foundation.gestures.BringIntoViewSpec getPivotBringIntoViewSpec() {
        return BringIntoViewSpec_androidKt.PivotBringIntoViewSpec;
    }

    public static void getPivotBringIntoViewSpec$annotations() {
    }
}
