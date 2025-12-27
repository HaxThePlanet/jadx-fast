package app.dogo.com.dogo_android.exam;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: SimpleSurfaceTextureListener.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007H\u0016J\u0010\u0010\u000c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/exam/SimpleSurfaceTextureListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public interface SimpleSurfaceTextureListener extends TextureView.SurfaceTextureListener {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static boolean a(i iVar, SurfaceTexture surfaceTexture) {
            n.f(iVar, "this");
            n.f(surfaceTexture, "surfaceTexture");
            return true;
        }

        public static void b(i iVar, SurfaceTexture surfaceTexture, int i, int i2) {
            n.f(iVar, "this");
            n.f(surfaceTexture, "surfaceTexture");
        }

        public static void c(i iVar, SurfaceTexture surfaceTexture) {
            n.f(iVar, "this");
            n.f(surfaceTexture, "surfaceTexture");
        }
    }
}
