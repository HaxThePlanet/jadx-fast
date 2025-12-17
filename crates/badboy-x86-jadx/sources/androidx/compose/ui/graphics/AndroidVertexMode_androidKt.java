package androidx.compose.ui.graphics;

import android.graphics.Canvas.VertexMode;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0005", d2 = {"toAndroidVertexMode", "Landroid/graphics/Canvas$VertexMode;", "Landroidx/compose/ui/graphics/VertexMode;", "toAndroidVertexMode-JOOmi9M", "(I)Landroid/graphics/Canvas$VertexMode;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidVertexMode_androidKt {
    public static final Canvas.VertexMode toAndroidVertexMode-JOOmi9M(int $this$toAndroidVertexMode_u2dJOOmi9M) {
        Canvas.VertexMode tRIANGLE_STRIP;
        tRIANGLE_STRIP = VertexMode.equals-impl0($this$toAndroidVertexMode_u2dJOOmi9M, VertexMode.Companion.getTriangles-c2xauaI()) ? Canvas.VertexMode.TRIANGLES : equals-impl02 ? Canvas.VertexMode.TRIANGLE_STRIP : equals-impl03 ? Canvas.VertexMode.TRIANGLE_FAN : Canvas.VertexMode.TRIANGLES;
        return tRIANGLE_STRIP;
    }
}
