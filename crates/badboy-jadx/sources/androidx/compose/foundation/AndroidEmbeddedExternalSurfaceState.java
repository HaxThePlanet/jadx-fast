package androidx.compose.foundation;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0016H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\"\u0010\n\u001a\u00020\u000bX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001f", d2 = {"Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "Landroidx/compose/foundation/BaseAndroidExternalSurfaceState;", "Landroid/view/TextureView$SurfaceTextureListener;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "surfaceSize", "Landroidx/compose/ui/unit/IntSize;", "getSurfaceSize-YbymL2g", "()J", "setSurfaceSize-ozmzZPI", "(J)V", "J", "surfaceTextureSurface", "Landroid/view/Surface;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "surface", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AndroidEmbeddedExternalSurfaceState extends androidx.compose.foundation.BaseAndroidExternalSurfaceState implements TextureView.SurfaceTextureListener {

    private final Matrix matrix;
    private long surfaceSize;
    private Surface surfaceTextureSurface;
    public AndroidEmbeddedExternalSurfaceState(CoroutineScope scope) {
        super(scope);
        this.surfaceSize = IntSize.Companion.getZero-YbymL2g();
        Matrix matrix = new Matrix();
        this.matrix = matrix;
    }

    @Override // androidx.compose.foundation.BaseAndroidExternalSurfaceState
    public final Matrix getMatrix() {
        return this.matrix;
    }

    @Override // androidx.compose.foundation.BaseAndroidExternalSurfaceState
    public final long getSurfaceSize-YbymL2g() {
        return this.surfaceSize;
    }

    @Override // androidx.compose.foundation.BaseAndroidExternalSurfaceState
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
        int w;
        int h;
        boolean surfaceSize;
        w = width;
        h = height;
        if (!IntSize.equals-impl0(this.surfaceSize, obj3)) {
            surfaceTexture.setDefaultBufferSize(IntSize.getWidth-impl(this.surfaceSize), IntSize.getHeight-impl(this.surfaceSize));
        }
        Surface surface = new Surface(surfaceTexture);
        this.surfaceTextureSurface = surface;
        dispatchSurfaceCreated(surface, w, h);
    }

    @Override // androidx.compose.foundation.BaseAndroidExternalSurfaceState
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Surface surfaceTextureSurface = this.surfaceTextureSurface;
        Intrinsics.checkNotNull(surfaceTextureSurface);
        dispatchSurfaceDestroyed(surfaceTextureSurface);
        this.surfaceTextureSurface = 0;
        return 1;
    }

    @Override // androidx.compose.foundation.BaseAndroidExternalSurfaceState
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int width, int height) {
        int w;
        int h;
        boolean surfaceSize;
        w = width;
        h = height;
        if (!IntSize.equals-impl0(this.surfaceSize, obj3)) {
            surfaceTexture.setDefaultBufferSize(IntSize.getWidth-impl(this.surfaceSize), IntSize.getHeight-impl(this.surfaceSize));
        }
        Surface surfaceTextureSurface = this.surfaceTextureSurface;
        Intrinsics.checkNotNull(surfaceTextureSurface);
        dispatchSurfaceChanged(surfaceTextureSurface, w, h);
    }

    @Override // androidx.compose.foundation.BaseAndroidExternalSurfaceState
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
    }

    @Override // androidx.compose.foundation.BaseAndroidExternalSurfaceState
    public final void setSurfaceSize-ozmzZPI(long <set-?>) {
        this.surfaceSize = <set-?>;
    }
}
