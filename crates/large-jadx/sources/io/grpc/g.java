package io.grpc;

/* compiled from: ChannelLogger.java */
/* loaded from: classes2.dex */
public abstract class g {

    public enum a {

        DEBUG,
        ERROR,
        INFO,
        WARNING;
    }
    public abstract void a(g.a aVar, String str);

    public abstract void b(g.a aVar, String str, Object... objectArr);
}
