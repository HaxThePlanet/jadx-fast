package io.grpc;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public interface m extends io.grpc.o, io.grpc.v {

    public static final class a implements io.grpc.m {
        @Override // io.grpc.m
        public String a() {
            return "gzip";
        }

        @Override // io.grpc.m
        public InputStream b(InputStream inputStream) {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
            return gZIPInputStream;
        }

        @Override // io.grpc.m
        public OutputStream c(OutputStream outputStream) {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            return gZIPOutputStream;
        }
    }

    public static final class b implements io.grpc.m {

        public static final io.grpc.m a;
        static {
            m.b bVar = new m.b();
            m.b.a = bVar;
        }

        @Override // io.grpc.m
        public String a() {
            return "identity";
        }

        @Override // io.grpc.m
        public InputStream b(InputStream inputStream) {
            return inputStream;
        }

        @Override // io.grpc.m
        public OutputStream c(OutputStream outputStream) {
            return outputStream;
        }
    }
}
