package io.grpc.l1.a;

import com.google.common.base.n;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.k;
import com.google.protobuf.q;
import com.google.protobuf.t0;
import io.grpc.u0.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* compiled from: ProtoLiteUtils.java */
/* loaded from: classes3.dex */
public final class b {

    static volatile q a;

    private static final class a<T extends t0> implements u0.c {

        private static final java.lang.ThreadLocal<Reference<byte[]>> c = new ThreadLocal<>();
        private final com.google.protobuf.d1<T> a;
        private final T b;

        a(T t) {
            super();
            this.b = t;
            this.a = t.getParserForType();
        }

        private T d(k kVar) {
            try {
                kVar.a(0);
            } catch (com.google.protobuf.InvalidProtocolBufferException invalidProtocolBuffer) {
                invalidProtocolBuffer.k(t0Var);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) invalidProtocolBuffer;
            }
            return (t0)this.a.c(kVar, b.a);
        }

        public T c(InputStream inputStream) {
            int available;
            int i = 0;
            k kVar;
            int i2 = 4194304;
            byte[] bArr;
            WeakReference weakReference;
            int i3 = -1;
            z = inputStream instanceof a;
            if (inputStream instanceof a) {
                if ((a)inputStream.e() == this.a) {
                    try {
                    } catch (java.io.IOException ioException) {
                        io.grpc.d1 runtimeException = new RuntimeException(ioException);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) runtimeException;
                    }
                    return (a)inputStream.c();
                }
            }
            i = 0;
            try {
                z2 = ioException instanceof n0;
                available = ioException.available();
                i2 = 4194304;
                java.lang.ThreadLocal threadLocal = b.a.c;
                Object obj = threadLocal.get();
                if (obj != null) {
                    obj = obj.get();
                    if (obj != null) {
                        if (obj.length < this.a) {
                            b.a.c.set(new WeakReference(new byte[available]));
                        }
                    }
                }
                while (b.a.c > 0) {
                    int bytesRead = ioException.read(bArr, available - available, available);
                    i3 = -1;
                    if (bytesRead == -1) {
                        break;
                    } else {
                        available = available - bytesRead;
                        while (b.a.c > 0) {
                            bytesRead = ioException.read(bArr, available - available, available);
                            i3 = -1;
                            if (bytesRead == -1) {
                                break;
                            }
                        }
                        if (b.a.c != 0) {
                            int i6 = available - available;
                            StringBuilder stringBuilder = new StringBuilder();
                            String str3 = "size inaccurate: ";
                            String str2 = " != ";
                            ioException = str3 + available + str2 + i6;
                            throw new RuntimeException(ioException);
                        } else {
                            k kVar2 = k.l(bArr, 0, available);
                        }
                    }
                }
                kVar2 = k.l(bArr, 0, available);
                i6 = available - available;
                stringBuilder = new StringBuilder();
                str3 = "size inaccurate: ";
                str2 = " != ";
                ioException = str3 + available + str2 + i6;
                throw new RuntimeException(ioException);
            } catch (java.io.IOException ioException) {
                runtimeException = new RuntimeException(ioException);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) runtimeException;
            }
            if (b.a.c == 0) {
                kVar = k.f(ioException);
            }
            kVar.I(Integer.MAX_VALUE);
            try {
            } catch (com.google.protobuf.InvalidProtocolBufferException invalidProtocolBuffer) {
                runtimeException = d1.m;
                runtimeException = runtimeException.r("Invalid protobuf byte sequence");
                invalidProtocolBuffer = runtimeException.q(invalidProtocolBuffer);
                invalidProtocolBuffer = invalidProtocolBuffer.d();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) invalidProtocolBuffer;
            }
            return d(kVar);
        }

        public InputStream e(T t) {
            return new a(t, this.a);
        }
    }
    static {
        b.a = q.b();
    }

    static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i = 0;
        n.p(inputStream, "inputStream cannot be null!");
        n.p(outputStream, "outputStream cannot be null!");
        byte[] bArr = new byte[8192];
        i = 0;
        int bytesRead = inputStream.read(bArr);
        while (bytesRead == -1) {
            int i2 = 0;
            outputStream.write(bArr, i2, bytesRead);
            l = (long)bytesRead;
            i = i + l;
            bytesRead = inputStream.read(bArr);
        }
        return i;
    }

    public static <T extends t0> u0.c<T> b(T t) {
        return new b.a(t);
    }
}
