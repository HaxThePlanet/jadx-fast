package io.grpc;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: Codec.java */
/* loaded from: classes2.dex */
public interface m extends o, v {

    public static final class a implements m {
        public InputStream b(InputStream inputStream) throws java.io.IOException {
            return new GZIPInputStream(inputStream);
        }

        public OutputStream c(OutputStream outputStream) throws java.io.IOException {
            return new GZIPOutputStream(outputStream);
        }

        public String a() {
            return "gzip";
        }
    }

    public static final class b implements m {

        public static final m a = new m$b();

        private b() {
            super();
        }

        public String a() {
            return "identity";
        }

        public InputStream b(InputStream inputStream) {
            return inputStream;
        }

        public OutputStream c(OutputStream outputStream) {
            return outputStream;
        }
    }
}
