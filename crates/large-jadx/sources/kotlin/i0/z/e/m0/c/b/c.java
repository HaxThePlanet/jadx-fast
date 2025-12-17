package kotlin.i0.z.e.m0.c.b;

import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public interface c {

    public static final class a implements kotlin.i0.z.e.m0.c.b.c {

        public static final kotlin.i0.z.e.m0.c.b.c.a a;
        static {
            c.a aVar = new c.a();
            c.a.a = aVar;
        }

        @Override // kotlin.i0.z.e.m0.c.b.c
        public boolean a() {
            return 0;
        }

        @Override // kotlin.i0.z.e.m0.c.b.c
        public void b(String string, kotlin.i0.z.e.m0.c.b.e e2, String string3, kotlin.i0.z.e.m0.c.b.f f4, String string5) {
            n.f(string, "filePath");
            n.f(e2, "position");
            n.f(string3, "scopeFqName");
            n.f(f4, "scopeKind");
            n.f(string5, "name");
        }
    }
    public abstract boolean a();

    public abstract void b(String string, kotlin.i0.z.e.m0.c.b.e e2, String string3, kotlin.i0.z.e.m0.c.b.f f4, String string5);
}
