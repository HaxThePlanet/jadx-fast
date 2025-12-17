package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.google.common.base.b;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface HttpDataSource extends com.google.android.exoplayer2.upstream.l {

    public static final class b {

        private final Map<String, String> a;
        private Map<String, String> b;
        public b() {
            super();
            HashMap hashMap = new HashMap();
            this.a = hashMap;
        }

        public Map<String, String> a() {
            Map unmodifiableMap;
            Map map;
            synchronized (this) {
                try {
                    HashMap hashMap = new HashMap(this.a);
                    this.b = Collections.unmodifiableMap(hashMap);
                    return this.b;
                    throw th;
                }
            }
        }
    }

    public static class HttpDataSourceException extends com.google.android.exoplayer2.upstream.DataSourceException {

        public final com.google.android.exoplayer2.upstream.n dataSpec;
        public final int type;
        public HttpDataSourceException(com.google.android.exoplayer2.upstream.n n, int i2, int i3) {
            super(HttpDataSource.HttpDataSourceException.a(i2, i3));
            this.dataSpec = n;
            this.type = i3;
        }

        public HttpDataSourceException(IOException iOException, com.google.android.exoplayer2.upstream.n n2, int i3, int i4) {
            super(iOException, HttpDataSource.HttpDataSourceException.a(i3, i4));
            this.dataSpec = n2;
            this.type = i4;
        }

        public HttpDataSourceException(String string, com.google.android.exoplayer2.upstream.n n2, int i3, int i4) {
            super(string, HttpDataSource.HttpDataSourceException.a(i3, i4));
            this.dataSpec = n2;
            this.type = i4;
        }

        public HttpDataSourceException(String string, IOException iOException2, com.google.android.exoplayer2.upstream.n n3, int i4, int i5) {
            super(string, iOException2, HttpDataSource.HttpDataSourceException.a(i4, i5));
            this.dataSpec = n3;
            this.type = i5;
        }

        private static int a(int i, int i2) {
            int i3;
            int obj1;
            if (i == 2000 && i2 == 1) {
                if (i2 == 1) {
                    obj1 = 2001;
                }
            }
            return obj1;
        }

        public static com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException b(IOException iOException, com.google.android.exoplayer2.upstream.n n2, int i3) {
            String message;
            int i;
            boolean httpDataSourceException;
            com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException obj5;
            message = iOException.getMessage();
            final int i2 = 2007;
            if (iOException instanceof SocketTimeoutException != null) {
                i = 2002;
            } else {
                if (iOException instanceof InterruptedIOException != null) {
                    i = 1004;
                } else {
                    if (message != null && b.c(message).matches("cleartext.*not permitted.*")) {
                        i = b.c(message).matches("cleartext.*not permitted.*") ? i2 : 2001;
                    } else {
                    }
                }
            }
            if (i == i2) {
                obj5 = new HttpDataSource.CleartextNotPermittedException(iOException, n2);
            } else {
                httpDataSourceException = new HttpDataSource.HttpDataSourceException(iOException, n2, i, i3);
                obj5 = httpDataSourceException;
            }
            return obj5;
        }
    }

    public interface a extends com.google.android.exoplayer2.upstream.l.a {
        @Override // com.google.android.exoplayer2.upstream.l$a
        public abstract com.google.android.exoplayer2.upstream.HttpDataSource a();
    }

    public static final class CleartextNotPermittedException extends com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {
        public CleartextNotPermittedException(IOException iOException, com.google.android.exoplayer2.upstream.n n2) {
            super("Cleartext HTTP traffic not permitted. See https://exoplayer.dev/issues/cleartext-not-permitted", iOException, n2, 2007, 1);
        }
    }

    public static final class InvalidContentTypeException extends com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {

        public final String contentType;
        public InvalidContentTypeException(String string, com.google.android.exoplayer2.upstream.n n2) {
            String concat;
            String valueOf = String.valueOf(string);
            String str = "Invalid content type: ";
            if (valueOf.length() != 0) {
                concat = str.concat(valueOf);
            } else {
                concat = new String(str);
            }
            super(concat, n2, 2003, 1);
            this.contentType = string;
        }
    }

    public static final class InvalidResponseCodeException extends com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {

        public final Map<String, List<String>> headerFields;
        public final byte[] responseBody;
        public final int responseCode;
        public final String responseMessage;
        public InvalidResponseCodeException(int i, String string2, IOException iOException3, Map<String, List<String>> map4, com.google.android.exoplayer2.upstream.n n5, byte[] b6Arr6) {
            StringBuilder stringBuilder = new StringBuilder(26);
            stringBuilder.append("Response code: ");
            stringBuilder.append(i);
            super(stringBuilder.toString(), iOException3, n5, 2004, 1);
            this.responseCode = i;
            this.responseMessage = string2;
            this.headerFields = map4;
            this.responseBody = b6Arr6;
        }
    }
    static {
        final com.google.android.exoplayer2.upstream.d dVar = d.a;
    }

    public static boolean b(String string) {
        int i;
        boolean contains;
        String obj2;
        if (string == null) {
            return 0;
        }
        obj2 = b.c(string);
        if (!TextUtils.isEmpty(obj2)) {
            if (obj2.contains("text")) {
                if (obj2.contains("text/vtt") && !obj2.contains("html") && !obj2.contains("xml")) {
                    if (!obj2.contains("html")) {
                        if (!obj2.contains("xml")) {
                            i = 1;
                        }
                    }
                }
            } else {
            }
        }
        return i;
    }
}
