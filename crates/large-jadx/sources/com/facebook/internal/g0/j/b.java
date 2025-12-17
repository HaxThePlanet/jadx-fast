package com.facebook.internal.g0.j;

import com.facebook.internal.b0;
import com.facebook.internal.g0.f;
import com.facebook.o;
import com.facebook.p.b;
import com.facebook.s;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import kotlin.k0.h;
import kotlin.y.p;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0005\u001a\u00020\u0006H\u0007J\u0013\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008H\u0007¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\u00062\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0007J\u0008\u0010\u000e\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lcom/facebook/internal/instrument/errorreport/ErrorReportHandler;", "", "()V", "MAX_ERROR_REPORT_NUM", "", "enable", "", "listErrorReportFiles", "", "Ljava/io/File;", "()[Ljava/io/File;", "save", "msg", "", "sendErrorReports", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class b {

    @Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\u0008\u0007", d2 = {"<anonymous>", "", "dir", "Ljava/io/File;", "kotlin.jvm.PlatformType", "name", "", "accept"}, k = 3, mv = {1, 5, 1})
    static final class a implements FilenameFilter {

        public static final com.facebook.internal.g0.j.b.a a;
        static {
            b.a aVar = new b.a();
            b.a.a = aVar;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String string2) {
            n.e(string2, "name");
            f0 f0Var = f0.a;
            int i = 1;
            Object[] arr = new Object[i];
            arr[0] = "error_log_";
            String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(arr, i));
            n.e(format, "java.lang.String.format(format, *args)");
            h obj5 = new h(format);
            return obj5.d(string2);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\u0008\u0006", d2 = {"<anonymous>", "", "o1", "Lcom/facebook/internal/instrument/errorreport/ErrorReportData;", "kotlin.jvm.PlatformType", "o2", "compare"}, k = 3, mv = {1, 5, 1})
    static final class b implements Comparator {

        public static final com.facebook.internal.g0.j.b.b a;
        static {
            b.b bVar = new b.b();
            b.b.a = bVar;
        }

        @Override // java.util.Comparator
        public final int a(com.facebook.internal.g0.j.a a, com.facebook.internal.g0.j.a a2) {
            n.e(a2, "o2");
            return a.b(a2);
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((a)object, (a)object2);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "response", "Lcom/facebook/GraphResponse;", "onCompleted"}, k = 3, mv = {1, 5, 1})
    static final class c implements p.b {

        final ArrayList a;
        c(ArrayList arrayList) {
            this.a = arrayList;
            super();
        }

        @Override // com.facebook.p$b
        public final void b(s s) {
            int next;
            Object obj2;
            n.f(s, "response");
            obj2 = s.d();
            if (s.b() == null && obj2 != null && obj2.getBoolean("success") == 1) {
                obj2 = s.d();
                if (obj2 != null) {
                    if (obj2.getBoolean("success") == 1) {
                        obj2 = this.a.iterator();
                        for (a next : obj2) {
                            next.a();
                        }
                    }
                }
            }
        }
    }
    static {
    }

    public static final void a() {
        if (o.j()) {
            b.d();
        }
    }

    public static final File[] b() {
        File file = f.c();
        if (file != null) {
            File[] listFiles = file.listFiles(b.a.a);
            n.e(listFiles, "reportDir.listFiles { di…OR_REPORT_PREFIX)))\n    }");
            return listFiles;
        }
        return new File[0];
    }

    public static final void c(String string) {
        try {
            a aVar = new a(string);
            aVar.e();
        }
    }

    public static final void d() {
        int length;
        int size;
        int i2;
        int i;
        boolean z;
        com.facebook.internal.g0.j.a aVar;
        if (b0.T()) {
        }
        File[] objArr = b.b();
        ArrayList arrayList = new ArrayList();
        i = i2;
        while (i < objArr.length) {
            aVar = new a(objArr[i]);
            if (aVar.d()) {
            }
            i++;
            arrayList.add(aVar);
        }
        p.x(arrayList, b.b.a);
        JSONArray jSONArray = new JSONArray();
        while (i2 < arrayList.size()) {
            if (i2 < 1000) {
            }
            jSONArray.put(arrayList.get(i2));
            i2++;
        }
        b.c cVar = new b.c(arrayList);
        f.l("error_reports", jSONArray, cVar);
    }
}
