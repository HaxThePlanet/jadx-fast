package app.dogo.com.dogo_android.exam;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007H\u0016J\u0010\u0010\u000c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/exam/SimpleSurfaceTextureListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface i extends TextureView.SurfaceTextureListener {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static boolean a(app.dogo.com.dogo_android.exam.i i, SurfaceTexture surfaceTexture2) {
            n.f(i, "this");
            n.f(surfaceTexture2, "surfaceTexture");
            return 1;
        }

        public static void b(app.dogo.com.dogo_android.exam.i i, SurfaceTexture surfaceTexture2, int i3, int i4) {
            n.f(i, "this");
            n.f(surfaceTexture2, "surfaceTexture");
        }

        public static void c(app.dogo.com.dogo_android.exam.i i, SurfaceTexture surfaceTexture2) {
            n.f(i, "this");
            n.f(surfaceTexture2, "surfaceTexture");
        }
    }
}
