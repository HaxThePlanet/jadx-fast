package com.facebook.internal.g0;

import com.facebook.internal.b0;
import com.facebook.internal.l;
import com.facebook.internal.l.b;
import com.facebook.o;
import com.facebook.p;
import com.facebook.p.b;
import com.facebook.p.c;
import com.facebook.r;
import com.facebook.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0002\u0008\u0005\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0007J\r\u0010\n\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0008\u000bJ\r\u0010\u000c\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0008\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lcom/facebook/internal/instrument/ExceptionAnalyzer;", "", "()V", "enabled", "", "enable", "", "execute", "e", "", "isDebug", "isDebug$facebook_core_release", "sendExceptionAnalysisReports", "sendExceptionAnalysisReports$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    private static boolean a;
    public static final com.facebook.internal.g0.a b;

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "response", "Lcom/facebook/GraphResponse;", "onCompleted"}, k = 3, mv = {1, 5, 1})
    static final class a implements p.b {

        final com.facebook.internal.g0.b a;
        a(com.facebook.internal.g0.b b) {
            this.a = b;
            super();
        }

        @Override // com.facebook.p$b
        public final void b(s s) {
            com.facebook.n nVar;
            Object obj2;
            n.f(s, "response");
            obj2 = s.d();
            if (s.b() == null && obj2 != null && obj2.getBoolean("success") == 1) {
                obj2 = s.d();
                if (obj2 != null) {
                    if (obj2.getBoolean("success") == 1) {
                        this.a.a();
                    }
                }
            }
        }
    }
    static {
        a aVar = new a();
        a.b = aVar;
    }

    public static final void a() {
        boolean z;
        a.a = true;
        if (o.j()) {
            a.b.d();
        }
    }

    public static final void b(Throwable throwable) {
        boolean hashSet;
        int length;
        int i;
        l.b string;
        l.b unknown;
        boolean obj5;
        if (a.a && !a.c()) {
            if (!a.c()) {
                if (throwable == null) {
                } else {
                    hashSet = new HashSet();
                    obj5 = throwable.getStackTrace();
                    n.e(obj5, "e.stackTrace");
                    i = 0;
                    while (i < obj5.length) {
                        java.lang.StackTraceElement stack = obj5[i];
                        n.e(stack, "it");
                        String className = stack.getClassName();
                        n.e(className, "it.className");
                        string = l.d(className);
                        if (string != l.b.Unknown) {
                        }
                        i++;
                        l.c(string);
                        hashSet.add(string.toString());
                    }
                    if (o.j() && obj5 ^= 1 != 0) {
                        if (obj5 ^= 1 != 0) {
                            obj5 = new JSONArray(hashSet);
                            b.a.c(obj5).g();
                        }
                    }
                }
            }
        }
    }

    public static final boolean c() {
        return 0;
    }

    public final void d() {
        int i;
        com.facebook.internal.g0.b bVar;
        boolean jSONObject;
        p.c cVar;
        int i2;
        String format;
        com.facebook.internal.g0.a.a aVar;
        Object[] arr;
        String str;
        if (b0.T()) {
        }
        java.io.File[] objArr = f.i();
        ArrayList arrayList = new ArrayList();
        final int i3 = 0;
        i = i3;
        while (i < objArr.length) {
            bVar = b.a.d(objArr[i]);
            if (bVar.f()) {
            }
            i++;
            jSONObject = new JSONObject();
            jSONObject.put("crash_shield", bVar.toString());
            f0 f0Var = f0.a;
            int i4 = 1;
            arr = new Object[i4];
            arr[i3] = o.g();
            format = String.format("%s/instruments", Arrays.copyOf(arr, i4));
            n.e(format, "java.lang.String.format(format, *args)");
            aVar = new a.a(bVar);
            arrayList.add(p.t.x(0, format, jSONObject, aVar));
        }
        if (arrayList.isEmpty()) {
        }
        r rVar = new r(arrayList);
        rVar.m();
    }
}
