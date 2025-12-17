package androidx.camera.camera2;

import androidx.camera.core.d;
import androidx.camera.core.d.a;

/* loaded from: classes.dex */
public final class Camera2Config {

    public static final class DefaultProvider {
        public d getCameraXConfig() {
            return Camera2Config.a();
        }
    }
    public static d a() {
        d.a aVar2 = new d.a();
        aVar2.c(c.a);
        aVar2.d(b.a);
        aVar2.g(a.a);
        return aVar2.a();
    }
}
