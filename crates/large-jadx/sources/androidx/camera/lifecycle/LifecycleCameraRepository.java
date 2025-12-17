package androidx.camera.lifecycle;

import androidx.lifecycle.j.b;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;

/* loaded from: classes.dex */
final class LifecycleCameraRepository {

    private static class LifecycleCameraRepositoryObserver implements p {

        private final androidx.camera.lifecycle.LifecycleCameraRepository a;
        @z(j$b.ON_DESTROY)
        public void onDestroy(q q) {
            this.a.c(q);
        }

        @z(j$b.ON_START)
        public void onStart(q q) {
            this.a.a(q);
        }

        @z(j$b.ON_STOP)
        public void onStop(q q) {
            this.a.b(q);
        }
    }
    void a(q q) {
        throw 0;
    }

    void b(q q) {
        throw 0;
    }

    void c(q q) {
        throw 0;
    }
}
