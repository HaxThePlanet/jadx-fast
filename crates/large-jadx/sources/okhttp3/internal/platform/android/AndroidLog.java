package okhttp3.internal.platform.android;

import android.util.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.j0;
import okhttp3.internal.SuppressSignatureCheck;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0002\u0008\u0006\n\u0002\u0010$\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008Ç\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u001e\u0010\u0014J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\u00082\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\t\u0010\nJ1\u0010\u0012\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0008¢\u0006\u0004\u0008\u0013\u0010\u0014R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u001c\u0010\u001d¨\u0006\u001f", d2 = {"Lokhttp3/internal/platform/android/AndroidLog;", "", "", "loggerName", "loggerTag", "(Ljava/lang/String;)Ljava/lang/String;", "logger", "tag", "Lkotlin/w;", "enableLogging", "(Ljava/lang/String;Ljava/lang/String;)V", "", "logLevel", "message", "", "t", "androidLog$okhttp", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V", "androidLog", "enable", "()V", "", "knownLoggers", "Ljava/util/Map;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/logging/Logger;", "configuredLoggers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "MAX_LOG_LENGTH", "I", "<init>", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class AndroidLog {

    public static final okhttp3.internal.platform.android.AndroidLog INSTANCE = null;
    private static final int MAX_LOG_LENGTH = 4000;
    private static final CopyOnWriteArraySet<Logger> configuredLoggers;
    private static final Map<String, String> knownLoggers;
    static {
        String name;
        String str;
        AndroidLog androidLog = new AndroidLog();
        AndroidLog.INSTANCE = androidLog;
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        AndroidLog.configuredLoggers = copyOnWriteArraySet;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        java.lang.Package package = OkHttpClient.class.getPackage();
        if (package != null) {
            name = package.getName();
        } else {
            name = 0;
        }
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = OkHttpClient.class.getName();
        n.e(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = Http2.class.getName();
        n.e(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = TaskRunner.class.getName();
        n.e(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        AndroidLog.knownLoggers = j0.u(linkedHashMap);
    }

    private final void enableLogging(String string, String string2) {
        boolean loggable;
        Object obj3;
        final Logger obj2 = Logger.getLogger(string);
        if (AndroidLog.configuredLoggers.add(obj2)) {
            n.e(obj2, "logger");
            obj2.setUseParentHandlers(false);
            obj3 = Log.isLoggable(string2, 3) ? Level.FINE : obj3 != null ? Level.INFO : Level.WARNING;
            obj2.setLevel(obj3);
            obj2.addHandler(AndroidLogHandler.INSTANCE);
        }
    }

    private final String loggerTag(String string) {
        Object obj;
        if ((String)AndroidLog.knownLoggers.get(string) != null) {
        } else {
            obj = l.f1(string, 23);
        }
        return obj;
    }

    public final void androidLog$okhttp(String string, int i2, String string3, Throwable throwable4) {
        boolean stringBuilder;
        int i4;
        int str;
        int i;
        int i3;
        int i5;
        int length;
        Object obj10;
        Throwable obj11;
        n.f(string, "loggerName");
        n.f(string3, "message");
        final String obj8 = loggerTag(string);
        if (Log.isLoggable(obj8, i2) && throwable4 != null) {
            if (throwable4 != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                stringBuilder.append("\n");
                stringBuilder.append(Log.getStackTraceString(throwable4));
                obj10 = stringBuilder.toString();
            }
            obj11 = 0;
            length = obj10.length();
            while (obj11 < length) {
                if (l.d0(obj10, '\n', obj11, false, 4, 0) != -1) {
                } else {
                }
                stringBuilder = length;
                i4 = Math.min(stringBuilder, obj11 + 4000);
                Objects.requireNonNull(obj10, "null cannot be cast to non-null type java.lang.String");
                obj11 = obj10.substring(obj11, i4);
                n.e(obj11, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Log.println(i2, obj8, obj11);
                while (i4 >= stringBuilder) {
                    obj11 = i4;
                    i4 = Math.min(stringBuilder, obj11 + 4000);
                    Objects.requireNonNull(obj10, "null cannot be cast to non-null type java.lang.String");
                    obj11 = obj10.substring(obj11, i4);
                    n.e(obj11, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.println(i2, obj8, obj11);
                }
                obj11 = i4;
                obj11 = i4 + 1;
            }
        }
    }

    public final void enable() {
        Object value;
        Object key;
        Iterator iterator = AndroidLog.knownLoggers.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            enableLogging((String)next2.getKey(), (String)next2.getValue());
        }
    }
}
