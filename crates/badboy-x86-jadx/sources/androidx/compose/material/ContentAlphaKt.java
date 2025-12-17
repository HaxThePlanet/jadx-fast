package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\"\u0017\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\u0005", d2 = {"LocalContentAlpha", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalContentAlpha", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContentAlphaKt {

    private static final ProvidableCompositionLocal<Float> LocalContentAlpha;
    static {
        final int i2 = 0;
        ContentAlphaKt.LocalContentAlpha = CompositionLocalKt.compositionLocalOf$default(i2, (Function0)ContentAlphaKt.LocalContentAlpha.1.INSTANCE, 1, i2);
    }

    public static final ProvidableCompositionLocal<Float> getLocalContentAlpha() {
        return ContentAlphaKt.LocalContentAlpha;
    }
}
