package com.airbnb.lottie.x;

import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.f;
import com.airbnb.lottie.v.j.g;
import com.airbnb.lottie.v.j.j;
import java.util.List;

/* compiled from: AnimatableValueParser.java */
/* loaded from: classes.dex */
public class d {
    private static <T> List<com.airbnb.lottie.z.a<T>> a(com.airbnb.lottie.x.k0.c cVar, float f, com.airbnb.lottie.d dVar, j0<T> j0Var) {
        return r.a(cVar, dVar, f, j0Var, false);
    }

    private static <T> List<com.airbnb.lottie.z.a<T>> b(com.airbnb.lottie.x.k0.c cVar, com.airbnb.lottie.d dVar, j0<T> j0Var) {
        return r.a(cVar, dVar, 1f, j0Var, false);
    }

    static com.airbnb.lottie.v.j.a c(com.airbnb.lottie.x.k0.c cVar, com.airbnb.lottie.d dVar) {
        return new a(d.b(cVar, dVar, f.a));
    }

    static j d(com.airbnb.lottie.x.k0.c cVar, com.airbnb.lottie.d dVar) {
        return new j(d.b(cVar, dVar, h.a));
    }

    public static b e(com.airbnb.lottie.x.k0.c cVar, com.airbnb.lottie.d dVar) {
        return d.f(cVar, dVar, true);
    }

    public static b f(com.airbnb.lottie.x.k0.c cVar, com.airbnb.lottie.d dVar, boolean z) {
        float f = 1065353216;
        if (z) {
            f = h.e();
        } else {
            int i = 1065353216;
        }
        b bVar = new b(d.a(cVar, f, dVar, i.a));
        return bVar;
    }

    static com.airbnb.lottie.v.j.c g(com.airbnb.lottie.x.k0.c cVar, com.airbnb.lottie.d dVar, int i) {
        return new c(d.b(cVar, dVar, new l(i)));
    }

    static com.airbnb.lottie.v.j.d h(com.airbnb.lottie.x.k0.c cVar, com.airbnb.lottie.d dVar) {
        return new d(d.b(cVar, dVar, o.a));
    }

    static f i(com.airbnb.lottie.x.k0.c cVar, com.airbnb.lottie.d dVar) {
        return new f(r.a(cVar, dVar, h.e(), y.a, true));
    }

    static g j(com.airbnb.lottie.x.k0.c cVar, com.airbnb.lottie.d dVar) {
        return new g(d.b(cVar, dVar, c0.a));
    }

    static com.airbnb.lottie.v.j.h k(com.airbnb.lottie.x.k0.c cVar, com.airbnb.lottie.d dVar) {
        return new h(d.a(cVar, h.e(), dVar, d0.a));
    }
}
