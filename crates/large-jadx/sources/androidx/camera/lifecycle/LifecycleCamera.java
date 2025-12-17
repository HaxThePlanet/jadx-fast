package androidx.camera.lifecycle;

import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.lifecycle.j.b;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;

/* loaded from: classes.dex */
final class LifecycleCamera implements p {

    private final Object a;
    private final CameraUseCaseAdapter b;
    private boolean c;
    private boolean v;
    @z(j$b.ON_DESTROY)
    public void onDestroy(q q) {
        final Object obj3 = this.a;
        final CameraUseCaseAdapter cameraUseCaseAdapter = this.b;
        cameraUseCaseAdapter.d(cameraUseCaseAdapter.c());
        return;
        synchronized (obj3) {
            obj3 = this.a;
            cameraUseCaseAdapter = this.b;
            cameraUseCaseAdapter.d(cameraUseCaseAdapter.c());
        }
    }

    @z(j$b.ON_START)
    public void onStart(q q) {
        boolean z;
        final Object obj2 = this.a;
        synchronized (obj2) {
            if (!this.v) {
                this.b.a();
            }
            try {
                throw th;
            }
        }
    }

    @z(j$b.ON_STOP)
    public void onStop(q q) {
        boolean z;
        final Object obj2 = this.a;
        synchronized (obj2) {
            if (!this.v) {
                this.b.b();
            }
            try {
                throw th;
            }
        }
    }
}
