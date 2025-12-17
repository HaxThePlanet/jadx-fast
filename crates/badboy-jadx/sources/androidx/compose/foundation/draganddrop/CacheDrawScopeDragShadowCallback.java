package androidx.compose.foundation.draganddrop;

import android.graphics.Canvas;
import android.graphics.Picture;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Landroidx/compose/foundation/draganddrop/CacheDrawScopeDragShadowCallback;", "", "()V", "cachedPicture", "Landroid/graphics/Picture;", "cachePicture", "Landroidx/compose/ui/draw/DrawResult;", "scope", "Landroidx/compose/ui/draw/CacheDrawScope;", "drawDragShadow", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class CacheDrawScopeDragShadowCallback {

    private Picture cachedPicture;
    public final DrawResult cachePicture(CacheDrawScope scope) {
        Object obj = scope;
        final int i = 0;
        Picture picture = new Picture();
        this.cachedPicture = picture;
        CacheDrawScopeDragShadowCallback.cachePicture.1.1 anon = new CacheDrawScopeDragShadowCallback.cachePicture.1.1(picture, (int)width-impl, (int)height-impl);
        return obj.onDrawWithContent((Function1)anon);
    }

    public final void drawDragShadow(DrawScope drawScope) {
        final int i = 0;
        final Picture cachedPicture = this.cachedPicture;
        if (cachedPicture == null) {
        } else {
            int i2 = 0;
            final int i3 = 0;
            AndroidCanvas_androidKt.getNativeCanvas(drawScope.getDrawContext().getCanvas()).drawPicture(cachedPicture);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No cached drag shadow. Check if Modifier.cacheDragShadow(painter) was called.");
        throw illegalArgumentException;
    }
}
