package kotlin.i0.z.e.m0.l;

import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public interface r0 {

    public static final class a implements kotlin.i0.z.e.m0.l.r0 {

        public static final kotlin.i0.z.e.m0.l.r0.a a;
        static {
            r0.a aVar = new r0.a();
            r0.a.a = aVar;
        }

        @Override // kotlin.i0.z.e.m0.l.r0
        public void a(kotlin.i0.z.e.m0.l.b0 b0, kotlin.i0.z.e.m0.l.b0 b02, kotlin.i0.z.e.m0.l.b0 b03, z0 z04) {
            n.f(b0, "bound");
            n.f(b02, "unsubstitutedArgument");
            n.f(b03, "argument");
            n.f(z04, "typeParameter");
        }

        @Override // kotlin.i0.z.e.m0.l.r0
        public void b(c c) {
            n.f(c, "annotation");
        }

        @Override // kotlin.i0.z.e.m0.l.r0
        public void c(y0 y0, z0 z02, kotlin.i0.z.e.m0.l.b0 b03) {
            n.f(y0, "typeAlias");
            n.f(b03, "substitutedArgument");
        }

        @Override // kotlin.i0.z.e.m0.l.r0
        public void d(y0 y0) {
            n.f(y0, "typeAlias");
        }
    }
    public abstract void a(kotlin.i0.z.e.m0.l.b0 b0, kotlin.i0.z.e.m0.l.b0 b02, kotlin.i0.z.e.m0.l.b0 b03, z0 z04);

    public abstract void b(c c);

    public abstract void c(y0 y0, z0 z02, kotlin.i0.z.e.m0.l.b0 b03);

    public abstract void d(y0 y0);
}
