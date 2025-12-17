package androidx.camera.core;

import androidx.camera.core.impl.e;
import androidx.camera.core.impl.f;
import androidx.camera.core.impl.g;
import androidx.camera.core.impl.g.a;
import androidx.camera.core.impl.j;
import androidx.camera.core.impl.k;
import androidx.camera.core.impl.l;
import androidx.camera.core.impl.n;
import androidx.camera.core.internal.a;
import java.util.UUID;

/* loaded from: classes.dex */
public final class d implements a<androidx.camera.core.c> {

    static final g.a<f> d;
    static final g.a<e> e;
    static final g.a<n> f;
    private final l c;

    public static final class a {

        private final k a;
        public a() {
            super(k.k());
        }

        private a(k k) {
            g.a equals;
            Class<androidx.camera.core.c> obj = c.class;
            super();
            this.a = k;
            Object obj4 = k.f(a.b, 0);
            if ((Class)obj4 != null) {
                if (!(Class)obj4.equals(obj)) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid target class configuration for ");
                stringBuilder.append(this);
                stringBuilder.append(": ");
                stringBuilder.append(obj4);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
            }
            e(obj);
        }

        private j b() {
            return this.a;
        }

        public androidx.camera.core.d a() {
            d dVar = new d(l.h(this.a));
            return dVar;
        }

        public androidx.camera.core.d.a c(f f) {
            b().e(d.d, f);
            return this;
        }

        public androidx.camera.core.d.a d(e e) {
            b().e(d.e, e);
            return this;
        }

        public androidx.camera.core.d.a e(Class<androidx.camera.core.c> class) {
            Object stringBuilder;
            Object obj4;
            b().e(a.b, class);
            if (b().f(a.a, 0) == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(class.getCanonicalName());
                stringBuilder.append("-");
                stringBuilder.append(UUID.randomUUID());
                f(stringBuilder.toString());
            }
            return this;
        }

        public androidx.camera.core.d.a f(String string) {
            b().e(a.a, string);
            return this;
        }

        public androidx.camera.core.d.a g(n n) {
            b().e(d.f, n);
            return this;
        }
    }
    static {
        d.d = g.a.a("camerax.core.appConfig.cameraFactoryProvider", f.class);
        d.e = g.a.a("camerax.core.appConfig.deviceSurfaceManagerProvider", e.class);
        d.f = g.a.a("camerax.core.appConfig.useCaseConfigFactoryProvider", n.class);
        g.a.a("camerax.core.appConfig.cameraExecutor", Executor.class);
        g.a.a("camerax.core.appConfig.schedulerHandler", Handler.class);
        g.a.a("camerax.core.appConfig.minimumLoggingLevel", Integer.TYPE);
        g.a.a("camerax.core.appConfig.availableCamerasLimiter", b.class);
    }

    d(l l) {
        super();
        this.c = l;
    }

    @Override // androidx.camera.core.internal.a
    public g d() {
        return this.c;
    }
}
