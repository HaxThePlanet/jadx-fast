package kotlin.i0.z.e.m0.j.b.c0;

import java.io.InputStream;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class d {
    public final InputStream a(String string) {
        int systemResourceAsStream;
        n.f(string, "path");
        java.lang.ClassLoader classLoader = d.class.getClassLoader();
        if (classLoader == null) {
            systemResourceAsStream = 0;
        } else {
            systemResourceAsStream = classLoader.getResourceAsStream(string);
        }
        if (systemResourceAsStream == null) {
            systemResourceAsStream = ClassLoader.getSystemResourceAsStream(string);
        }
        return systemResourceAsStream;
    }
}
