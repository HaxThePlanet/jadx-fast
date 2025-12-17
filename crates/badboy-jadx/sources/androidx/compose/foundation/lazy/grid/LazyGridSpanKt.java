package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005", d2 = {"GridItemSpan", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "currentLineSpan", "", "(I)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyGridSpanKt {
    public static final long GridItemSpan(int currentLineSpan) {
        int i;
        i = currentLineSpan > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            return GridItemSpan.constructor-impl((long)currentLineSpan);
        }
        int i2 = 0;
        IllegalArgumentException $i$a$RequireLazyGridSpanKt$GridItemSpan$1 = new IllegalArgumentException("The span value should be higher than 0".toString());
        throw $i$a$RequireLazyGridSpanKt$GridItemSpan$1;
    }
}
