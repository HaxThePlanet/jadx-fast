package okhttp3.logging;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.io.b;
import kotlin.k0.l;
import kotlin.y.p;
import kotlin.y.q0;
import l.f;
import l.h;
import l.n;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u00002\u00020\u0001:\u0002'(B\u0013\u0008\u0007\u0012\u0008\u0008\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\u0008%\u0010&J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000c¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\u0008\u0012\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0010H\u0007¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\u0008\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008 \u0010!R*\u0010\u0011\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00108\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u0011\u0010#\u001a\u0004\u0008\u0016\u0010\u0015\"\u0004\u0008\u0011\u0010$¨\u0006)", d2 = {"Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Headers;", "headers", "", "i", "Lkotlin/w;", "logHeader", "(Lokhttp3/Headers;I)V", "", "bodyHasUnknownEncoding", "(Lokhttp3/Headers;)Z", "", "name", "redactHeader", "(Ljava/lang/String;)V", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "level", "setLevel", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)Lokhttp3/logging/HttpLoggingInterceptor;", "-deprecated_level", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "getLevel", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "", "headersToRedact", "Ljava/util/Set;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "<set-?>", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", "<init>", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "Level", "Logger", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
public final class HttpLoggingInterceptor implements Interceptor {

    private volatile Set<String> headersToRedact;
    private volatile okhttp3.logging.HttpLoggingInterceptor.Level level;
    private final okhttp3.logging.HttpLoggingInterceptor.Logger logger;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0007\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007¨\u0006\u0008", d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Level;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "BASIC", "HEADERS", "BODY", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
    public static enum Level {

        NONE,
        BASIC,
        HEADERS,
        BODY;
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008æ\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0008", d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "", "message", "Lkotlin/w;", "log", "(Ljava/lang/String;)V", "Companion", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
    public interface Logger {

        public static final okhttp3.logging.HttpLoggingInterceptor.Logger.Companion Companion;
        public static final okhttp3.logging.HttpLoggingInterceptor.Logger DEFAULT;
        static {
            HttpLoggingInterceptor.Logger.Companion companion = new HttpLoggingInterceptor.Logger.Companion(0);
            HttpLoggingInterceptor.Logger.Companion = companion;
            HttpLoggingInterceptor.Logger.Companion.DefaultLogger defaultLogger = new HttpLoggingInterceptor.Logger.Companion.DefaultLogger();
            HttpLoggingInterceptor.Logger.DEFAULT = defaultLogger;
        }

        public abstract void log(String string);
    }
    public HttpLoggingInterceptor() {
        final int i = 0;
        super(i, 1, i);
    }

    public HttpLoggingInterceptor(okhttp3.logging.HttpLoggingInterceptor.Logger httpLoggingInterceptor$Logger) {
        n.f(logger, "logger");
        super();
        this.logger = logger;
        this.headersToRedact = q0.b();
        this.level = HttpLoggingInterceptor.Level.NONE;
    }

    public HttpLoggingInterceptor(okhttp3.logging.HttpLoggingInterceptor.Logger httpLoggingInterceptor$Logger, int i2, g g3) {
        okhttp3.logging.HttpLoggingInterceptor.Logger obj1;
        obj1 = i2 &= 1 != 0 ? HttpLoggingInterceptor.Logger.DEFAULT : obj1;
        super(obj1);
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        int i2;
        boolean str;
        int i;
        String obj4;
        obj4 = headers.get("Content-Encoding");
        i2 = 0;
        i = 1;
        if (obj4 != null && !l.x(obj4, "identity", i) && !l.x(obj4, "gzip", i)) {
            i = 1;
            if (!l.x(obj4, "identity", i)) {
                if (!l.x(obj4, "gzip", i)) {
                    i2 = i;
                }
            }
        }
        return i2;
    }

    private final void logHeader(Headers headers, int i2) {
        String value;
        if (this.headersToRedact.contains(headers.name(i2))) {
            value = "██";
        } else {
            value = headers.value(i2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(headers.name(i2));
        stringBuilder.append(": ");
        stringBuilder.append(value);
        this.logger.log(stringBuilder.toString());
    }

    @Override // okhttp3.Interceptor
    public final okhttp3.logging.HttpLoggingInterceptor.Level -deprecated_level() {
        return this.level;
    }

    @Override // okhttp3.Interceptor
    public final okhttp3.logging.HttpLoggingInterceptor.Level getLevel() {
        return this.level;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        int logger2;
        boolean valueOf;
        java.nio.charset.Charset contentType2;
        Object logger3;
        int logger;
        int bodyHasUnknownEncoding;
        String string3;
        String string4;
        String stringBuilder4;
        Object stringBuilder5;
        int nVar;
        int i2;
        Object contentType;
        okhttp3.logging.HttpLoggingInterceptor.Level hEADERS;
        Object stringBuilder6;
        String string5;
        String string;
        String string2;
        String string6;
        int stringBuilder3;
        java.nio.charset.Charset contentType3;
        StringBuilder stringBuilder;
        String stringBuilder2;
        long contentLength;
        int message;
        String stringBuilder7;
        String str;
        int i;
        int obj21;
        final Object obj2 = this;
        Object obj = chain;
        n.f(obj, "chain");
        okhttp3.logging.HttpLoggingInterceptor.Level level = obj2.level;
        Request request = chain.request();
        if (level == HttpLoggingInterceptor.Level.NONE) {
            return obj.proceed(request);
        }
        bodyHasUnknownEncoding = level == HttpLoggingInterceptor.Level.BODY ? 1 : 0;
        if (bodyHasUnknownEncoding == 0) {
            if (level == HttpLoggingInterceptor.Level.HEADERS) {
                logger2 = 1;
            } else {
                logger2 = 0;
            }
        } else {
        }
        stringBuilder6 = request.body();
        Connection connection = chain.connection();
        StringBuilder stringBuilder11 = new StringBuilder();
        stringBuilder11.append("--> ");
        stringBuilder11.append(request.method());
        stringBuilder11.append(' ');
        stringBuilder11.append(request.url());
        String str26 = "";
        if (connection != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" ");
            stringBuilder.append(connection.protocol());
            string = stringBuilder.toString();
        } else {
            string = str26;
        }
        stringBuilder11.append(string);
        String str23 = "-byte body)";
        String str27 = " (";
        if (logger2 == 0 && stringBuilder6 != null) {
            if (stringBuilder6 != null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(stringBuilder11.toString());
                stringBuilder2.append(str27);
                stringBuilder2.append(stringBuilder6.contentLength());
                stringBuilder2.append(str23);
                string2 = stringBuilder2.toString();
            }
        }
        obj2.logger.log(string2);
        String str22 = "-byte body omitted)";
        String str28 = "UTF_8";
        Headers headers3 = request.headers();
        contentType = stringBuilder6.contentType();
        if (logger2 != 0 && stringBuilder6 != null && contentType != null && headers3.get("Content-Type") == null) {
            headers3 = request.headers();
            if (stringBuilder6 != null) {
                contentType = stringBuilder6.contentType();
                if (contentType != null) {
                    if (headers3.get("Content-Type") == null) {
                        contentLength = new StringBuilder();
                        contentLength.append("Content-Type: ");
                        contentLength.append(contentType);
                        obj2.logger.log(contentLength.toString());
                    }
                }
                if (Long.compare(contentLength, i) != 0 && headers3.get("Content-Length") == null) {
                    if (headers3.get("Content-Length") == null) {
                        StringBuilder stringBuilder13 = new StringBuilder();
                        stringBuilder13.append("Content-Length: ");
                        stringBuilder13.append(stringBuilder6.contentLength());
                        obj2.logger.log(stringBuilder13.toString());
                    }
                }
            }
            stringBuilder3 = 0;
            while (stringBuilder3 < headers3.size()) {
                obj2.logHeader(headers3, stringBuilder3);
                stringBuilder3++;
            }
            String str14 = "--> END ";
            if (bodyHasUnknownEncoding != 0) {
                if (stringBuilder6 == null) {
                    stringBuilder6 = new StringBuilder();
                    stringBuilder6.append(str14);
                    stringBuilder6.append(request.method());
                    obj2.logger.log(stringBuilder6.toString());
                } else {
                    if (obj2.bodyHasUnknownEncoding(request.headers())) {
                        stringBuilder6 = new StringBuilder();
                        stringBuilder6.append(str14);
                        stringBuilder6.append(request.method());
                        stringBuilder6.append(" (encoded body omitted)");
                        obj2.logger.log(stringBuilder6.toString());
                    } else {
                        if (stringBuilder6.isDuplex()) {
                            stringBuilder6 = new StringBuilder();
                            stringBuilder6.append(str14);
                            stringBuilder6.append(request.method());
                            stringBuilder6.append(" (duplex request body omitted)");
                            obj2.logger.log(stringBuilder6.toString());
                        } else {
                            if (stringBuilder6.isOneShot()) {
                                stringBuilder6 = new StringBuilder();
                                stringBuilder6.append(str14);
                                stringBuilder6.append(request.method());
                                stringBuilder6.append(" (one-shot body omitted)");
                                obj2.logger.log(stringBuilder6.toString());
                            } else {
                                f fVar2 = new f();
                                stringBuilder6.writeTo(fVar2);
                                contentType3 = stringBuilder6.contentType();
                                if (contentType3 != null && contentType3.charset(StandardCharsets.UTF_8) != null) {
                                    if (contentType3.charset(StandardCharsets.UTF_8) != null) {
                                    } else {
                                        n.e(StandardCharsets.UTF_8, str28);
                                    }
                                } else {
                                }
                                obj2.logger.log(str26);
                                if (Utf8Kt.isProbablyUtf8(fVar2)) {
                                    obj2.logger.log(fVar2.M0(contentType3));
                                    stringBuilder3 = new StringBuilder();
                                    stringBuilder3.append(str14);
                                    stringBuilder3.append(request.method());
                                    stringBuilder3.append(str27);
                                    stringBuilder3.append(stringBuilder6.contentLength());
                                    stringBuilder3.append(str23);
                                    obj2.logger.log(stringBuilder3.toString());
                                } else {
                                    stringBuilder3 = new StringBuilder();
                                    stringBuilder3.append(str14);
                                    stringBuilder3.append(request.method());
                                    stringBuilder3.append(" (binary ");
                                    stringBuilder3.append(stringBuilder6.contentLength());
                                    stringBuilder3.append(str22);
                                    obj2.logger.log(stringBuilder3.toString());
                                }
                            }
                        }
                    }
                }
            } else {
            }
        }
        Response proceed = obj.proceed(request);
        logger3 = proceed.body();
        n.d(logger3);
        long contentLength2 = logger3.contentLength();
        if (Long.compare(contentLength2, i6) != 0) {
            StringBuilder stringBuilder10 = new StringBuilder();
            stringBuilder10.append(contentLength2);
            stringBuilder10.append("-byte");
            string5 = stringBuilder10.toString();
        } else {
            string5 = "unknown-length";
        }
        StringBuilder stringBuilder12 = new StringBuilder();
        stringBuilder12.append("<-- ");
        stringBuilder12.append(proceed.code());
        message = proceed.message().length() == 0 ? 1 : 0;
        if (message != null) {
            str = str22;
            string6 = str26;
            obj21 = 32;
        } else {
            stringBuilder7 = new StringBuilder();
            str = str22;
            stringBuilder7.append(String.valueOf(' '));
            stringBuilder7.append(proceed.message());
            string6 = stringBuilder7.toString();
        }
        stringBuilder12.append(string6);
        stringBuilder12.append(obj21);
        okhttp3.HttpUrl httpUrl = proceed.request().url();
        stringBuilder12.append(httpUrl);
        stringBuilder12.append(str27);
        stringBuilder12.append(TimeUnit.NANOSECONDS.toMillis(nanoTime2 -= nanoTime));
        stringBuilder12.append("ms");
        if (logger2 == 0) {
            StringBuilder stringBuilder9 = new StringBuilder();
            stringBuilder9.append(", ");
            stringBuilder9.append(string5);
            stringBuilder9.append(" body");
            string4 = stringBuilder9.toString();
        } else {
            string4 = str26;
        }
        stringBuilder12.append(string4);
        stringBuilder12.append(')');
        obj2.logger.log(stringBuilder12.toString());
        if (logger2 != 0) {
            Headers headers = proceed.headers();
            stringBuilder5 = 0;
            while (stringBuilder5 < headers.size()) {
                obj2.logHeader(headers, stringBuilder5);
                stringBuilder5++;
            }
            if (bodyHasUnknownEncoding != 0) {
                if (!HttpHeaders.promisesBody(proceed)) {
                    obj2.logger.log("<-- END HTTP");
                } else {
                    if (obj2.bodyHasUnknownEncoding(proceed.headers())) {
                        obj2.logger.log("<-- END HTTP (encoded body omitted)");
                    } else {
                        h source = logger3.source();
                        source.request(Long.MAX_VALUE);
                        bodyHasUnknownEncoding = source.h();
                        if (l.x("gzip", headers.get("Content-Encoding"), true)) {
                            nVar = new n(bodyHasUnknownEncoding.c());
                            bodyHasUnknownEncoding = new f();
                            bodyHasUnknownEncoding.W0(nVar);
                            b.a(nVar, 0);
                            stringBuilder4 = valueOf;
                        }
                        contentType2 = logger3.contentType();
                        if (contentType2 != null && contentType2.charset(StandardCharsets.UTF_8) != null) {
                            if (contentType2.charset(StandardCharsets.UTF_8) != null) {
                            } else {
                                n.e(StandardCharsets.UTF_8, str28);
                            }
                        } else {
                        }
                        if (!Utf8Kt.isProbablyUtf8(bodyHasUnknownEncoding)) {
                            obj2.logger.log(str26);
                            StringBuilder stringBuilder8 = new StringBuilder();
                            String str13 = "<-- END HTTP (binary ";
                            stringBuilder8.append(str13);
                            stringBuilder8.append(bodyHasUnknownEncoding.size());
                            stringBuilder8.append(str);
                            obj2.logger.log(stringBuilder8.toString());
                            return proceed;
                        }
                        if (Long.compare(l2, i2) != 0) {
                            obj2.logger.log(str26);
                            obj2.logger.log(bodyHasUnknownEncoding.c().M0(contentType2));
                        }
                        String str4 = "<-- END HTTP (";
                        if (stringBuilder4 != 0) {
                            stringBuilder5 = new StringBuilder();
                            stringBuilder5.append(str4);
                            stringBuilder5.append(bodyHasUnknownEncoding.size());
                            stringBuilder5.append("-byte, ");
                            stringBuilder5.append(stringBuilder4);
                            stringBuilder5.append("-gzipped-byte body)");
                            obj2.logger.log(stringBuilder5.toString());
                        } else {
                            stringBuilder4 = new StringBuilder();
                            stringBuilder4.append(str4);
                            stringBuilder4.append(bodyHasUnknownEncoding.size());
                            stringBuilder4.append(str23);
                            obj2.logger.log(stringBuilder4.toString());
                        }
                    }
                }
            } else {
            }
        }
        return proceed;
    }

    @Override // okhttp3.Interceptor
    public final void level(okhttp3.logging.HttpLoggingInterceptor.Level httpLoggingInterceptor$Level) {
        n.f(level, "<set-?>");
        this.level = level;
    }

    @Override // okhttp3.Interceptor
    public final void redactHeader(String string) {
        n.f(string, "name");
        TreeSet treeSet = new TreeSet(l.y(f0.a));
        p.y(treeSet, this.headersToRedact);
        treeSet.add(string);
        this.headersToRedact = treeSet;
    }

    @Override // okhttp3.Interceptor
    public final okhttp3.logging.HttpLoggingInterceptor setLevel(okhttp3.logging.HttpLoggingInterceptor.Level httpLoggingInterceptor$Level) {
        n.f(level, "level");
        this.level = level;
        return this;
    }
}
