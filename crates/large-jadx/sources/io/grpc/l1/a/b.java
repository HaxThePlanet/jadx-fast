package io.grpc.l1.a;

import com.google.common.base.n;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.d1;
import com.google.protobuf.k;
import com.google.protobuf.q;
import com.google.protobuf.t0;
import io.grpc.d1;
import io.grpc.u0.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class b {

    static volatile q a;

    private static final class a implements u0.c {

        private static final java.lang.ThreadLocal<Reference<byte[]>> c;
        private final d1<T> a;
        private final T b;
        static {
            ThreadLocal threadLocal = new ThreadLocal();
            b.a.c = threadLocal;
        }

        a(T t) {
            super();
            this.b = t;
            this.a = t.getParserForType();
        }

        private T d(k k) {
            k.a(0);
            return (t0)this.a.c(k, b.a);
        }

        @Override // io.grpc.u0$c
        public Object a(InputStream inputStream) {
            return c(inputStream);
        }

        @Override // io.grpc.u0$c
        public InputStream b(Object object) {
            return e((t0)object);
        }

        public T c(InputStream inputStream) {
            boolean z;
            int i;
            int i2;
            Object str;
            boolean available;
            int bArr;
            WeakReference weakReference;
            int i3;
            if (inputStream instanceof a && (a)inputStream.e() == this.a) {
                if ((a)inputStream.e() == this.a) {
                    return (a)inputStream.c();
                }
            }
            i = 0;
            available = inputStream.available();
            if (inputStream instanceof n0 && available > 0 && available <= 4194304) {
                available = inputStream.available();
                if (available > 0) {
                    if (available <= 4194304) {
                        java.lang.ThreadLocal threadLocal = b.a.c;
                        bArr = threadLocal.get();
                        bArr = (Reference)bArr.get();
                        if (bArr != null && (byte[])bArr != null) {
                            bArr = bArr.get();
                            if ((byte[])(byte[])bArr != null) {
                                if (bArr.length < available) {
                                    weakReference = new WeakReference(new byte[available]);
                                    threadLocal.set(weakReference);
                                }
                            } else {
                            }
                        } else {
                        }
                        i2 = available;
                        while (i2 > 0) {
                            weakReference = inputStream.read(bArr, available - i2, i2);
                            if (weakReference == -1) {
                                break;
                            } else {
                            }
                            i2 -= weakReference;
                        }
                        try {
                            i = k.l(bArr, 0, available);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("size inaccurate: ");
                            stringBuilder.append(available);
                            stringBuilder.append(" != ");
                            stringBuilder.append(available - i2);
                            RuntimeException runtimeException2 = new RuntimeException(stringBuilder.toString());
                            throw runtimeException2;
                            if (available == 0) {
                            }
                            return this.b;
                            if (i == 0) {
                            }
                            i = k.f(inputStream);
                        } catch (java.io.IOException ioException) {
                        }
                        i.I(Integer.MAX_VALUE);
                        return d(i);
                    }
                }
            }
        }

        public InputStream e(T t) {
            a aVar = new a(t, this.a);
            return aVar;
        }
    }
    static {
        b.a = q.b();
    }

    static long a(InputStream inputStream, OutputStream outputStream2) {
        int i;
        long l;
        int i2;
        n.p(inputStream, "inputStream cannot be null!");
        n.p(outputStream2, "outputStream cannot be null!");
        byte[] bArr = new byte[8192];
        i = 0;
        int read = inputStream.read(bArr);
        while (read == -1) {
            outputStream2.write(bArr, 0, read);
            i += l;
            read = inputStream.read(bArr);
        }
        return i;
    }

    public static <T extends t0> u0.c<T> b(T t) {
        b.a aVar = new b.a(t);
        return aVar;
    }
}
