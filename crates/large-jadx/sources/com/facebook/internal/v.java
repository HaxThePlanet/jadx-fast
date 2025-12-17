package com.facebook.internal;

import android.util.Log;
import com.facebook.o;
import com.facebook.v;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00052\u0012\u0010\u0015\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00010\u0016\"\u00020\u0001¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0011\u001a\u00020\u00122\n\u0010\u0018\u001a\u00060\u0008j\u0002`\tJ\u0016\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0001J\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u0012J\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u0008\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\u0008j\u0002`\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Lcom/facebook/internal/Logger;", "", "behavior", "Lcom/facebook/LoggingBehavior;", "tag", "", "(Lcom/facebook/LoggingBehavior;Ljava/lang/String;)V", "contents", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "", "priority", "getPriority", "()I", "setPriority", "(I)V", "append", "", "string", "format", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "stringBuilder", "appendKeyValue", "key", "getContents", "log", "logString", "shouldLog", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class v {

    private static final HashMap<String, String> e;
    public static final com.facebook.internal.v.a f;
    private final v a;
    private final String b;
    private StringBuilder c;
    private int d = 3;

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0002\u0008\t\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007JA\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0012\u0010\u0011\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00010\u0012\"\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0013J \u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J9\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0012\u0010\u0011\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00010\u0012\"\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Lcom/facebook/internal/Logger$Companion;", "", "()V", "LOG_TAG_BASE", "", "stringsToReplace", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "log", "", "behavior", "Lcom/facebook/LoggingBehavior;", "priority", "", "tag", "string", "format", "args", "", "(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "registerAccessToken", "accessToken", "registerStringToReplace", "original", "replace", "replaceStrings", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        private final String f(String string) {
            Object th;
            Object key;
            Object obj;
            int i;
            int i2;
            int i3;
            Object obj8;
            Iterator iterator = v.a().entrySet().iterator();
            th = string;
            synchronized (this) {
                try {
                    for (Map.Entry obj8 : iterator) {
                        th = l.G(th, (String)obj8.getKey(), (String)obj8.getValue(), false, 4, 0);
                    }
                    obj8 = iterator.next();
                    th = l.G(th, (String)(Map.Entry)obj8.getKey(), (String)obj8.getValue(), false, 4, 0);
                    return th;
                    throw string;
                }
            }
        }

        public final void a(v v, int i2, String string3, String string4) {
            boolean stringBuilder;
            int i;
            int i3;
            String str;
            Object obj5;
            int obj6;
            Object obj7;
            Object obj8;
            n.f(v, "behavior");
            n.f(string3, "tag");
            n.f(string4, "string");
            str = "FacebookSDK.";
            if (o.A(v) && !l.M(string3, str, false, 2, 0)) {
                str = "FacebookSDK.";
                if (!l.M(string3, str, false, 2, 0)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(string3);
                    obj7 = stringBuilder.toString();
                }
                Log.println(i2, obj7, f(string4));
                if (v == v.DEVELOPER_ERRORS) {
                    obj5 = new Exception();
                    obj5.printStackTrace();
                }
            }
        }

        public final void b(v v, String string2, String string3) {
            n.f(v, "behavior");
            n.f(string2, "tag");
            n.f(string3, "string");
            a(v, 3, string2, string3);
        }

        public final void c(v v, String string2, String string3, Object... object4Arr4) {
            boolean length;
            Object obj4;
            Object obj5;
            n.f(v, "behavior");
            n.f(string2, "tag");
            n.f(string3, "format");
            n.f(object4Arr4, "args");
            if (o.A(v)) {
                f0 f0Var = f0.a;
                obj5 = Arrays.copyOf(object4Arr4, object4Arr4.length);
                obj4 = String.format(string3, Arrays.copyOf(obj5, obj5.length));
                n.e(obj4, "java.lang.String.format(format, *args)");
                a(v, 3, string2, obj4);
            }
        }

        public final void d(String string) {
            boolean str;
            n.f(string, "accessToken");
            synchronized (this) {
                try {
                    e(string, "ACCESS_TOKEN_REMOVED");
                    throw string;
                }
            }
        }

        public final void e(String string, String string2) {
            n.f(string, "original");
            n.f(string2, "replace");
            v.a().put(string, string2);
            return;
            synchronized (this) {
                n.f(string, "original");
                n.f(string2, "replace");
                v.a().put(string, string2);
            }
        }
    }
    static {
        v.a aVar = new v.a(0);
        v.f = aVar;
        HashMap hashMap = new HashMap();
        v.e = hashMap;
    }

    public v(v v, String string2) {
        n.f(v, "behavior");
        String str2 = "tag";
        n.f(string2, str2);
        super();
        int i = 3;
        this.a = v;
        StringBuilder obj3 = new StringBuilder();
        obj3.append("FacebookSDK.");
        c0.k(string2, str2);
        obj3.append(string2);
        this.b = obj3.toString();
        obj3 = new StringBuilder();
        this.c = obj3;
    }

    public static final HashMap a() {
        return v.e;
    }

    private final boolean g() {
        return o.A(this.a);
    }

    public final void b(String string) {
        boolean z;
        n.f(string, "string");
        if (g()) {
            this.c.append(string);
        }
    }

    public final void c(String string, Object... object2Arr2) {
        boolean z;
        int length;
        Object obj3;
        Object obj4;
        n.f(string, "format");
        n.f(object2Arr2, "args");
        if (g()) {
            f0 f0Var = f0.a;
            obj4 = Arrays.copyOf(object2Arr2, object2Arr2.length);
            obj3 = String.format(string, Arrays.copyOf(obj4, obj4.length));
            n.e(obj3, "java.lang.String.format(format, *args)");
            this.c.append(obj3);
        }
    }

    public final void d(String string, Object object2) {
        n.f(string, "key");
        n.f(object2, "value");
        Object[] arr = new Object[2];
        c("  %s:\t%s\n", string, object2);
    }

    public final void e() {
        String string = this.c.toString();
        n.e(string, "contents.toString()");
        f(string);
        StringBuilder stringBuilder = new StringBuilder();
        this.c = stringBuilder;
    }

    public final void f(String string) {
        n.f(string, "string");
        v.f.a(this.a, this.d, this.b, string);
    }
}
