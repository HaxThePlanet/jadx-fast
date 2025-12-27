package io.grpc.j1;

import io.grpc.o;
import java.io.InputStream;

/* compiled from: Framer.java */
/* loaded from: classes3.dex */
public interface p0 {
    p0 b(boolean z);

    void close();

    p0 d(o oVar);

    void e(InputStream inputStream);

    void flush();

    void g(int i);

    boolean isClosed();
}
