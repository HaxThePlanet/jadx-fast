package com.facebook.internal.g0;

import android.content.Context;
import com.facebook.internal.b0;
import com.facebook.o;
import com.facebook.p;
import com.facebook.p.b;
import com.facebook.p.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import kotlin.k0.d;
import kotlin.k0.h;
import kotlin.k0.l;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010\u0019\u001a\u00020\u000f2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010\u001a\u001a\u00020\u000f2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u0013\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u001cH\u0007¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u001cH\u0007¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u001cH\u0007¢\u0006\u0002\u0010\u001dJ\u001c\u0010 \u001a\u0004\u0018\u00010!2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020\u000fH\u0007J$\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020'2\u0008\u0010(\u001a\u0004\u0018\u00010)H\u0007J\u001c\u0010*\u001a\u00020$2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0008\u0010+\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006,", d2 = {"Lcom/facebook/internal/instrument/InstrumentUtility;", "", "()V", "ANALYSIS_REPORT_PREFIX", "", "ANR_REPORT_PREFIX", "CODELESS_PREFIX", "CRASH_REPORT_PREFIX", "CRASH_SHIELD_PREFIX", "ERROR_REPORT_PREFIX", "FBSDK_PREFIX", "INSTRUMENT_DIR", "SUGGESTED_EVENTS_PREFIX", "THREAD_CHECK_PREFIX", "deleteFile", "", "filename", "getCause", "e", "", "getInstrumentReportDir", "Ljava/io/File;", "getStackTrace", "thread", "Ljava/lang/Thread;", "isSDKRelatedException", "isSDKRelatedThread", "listAnrReportFiles", "", "()[Ljava/io/File;", "listExceptionAnalysisReportFiles", "listExceptionReportFiles", "readFile", "Lorg/json/JSONObject;", "deleteOnException", "sendReports", "", "key", "reports", "Lorg/json/JSONArray;", "callback", "Lcom/facebook/GraphRequest$Callback;", "writeFile", "content", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class f {

    @Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\u0008\u0007", d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/io/File;", "kotlin.jvm.PlatformType", "name", "", "accept"}, k = 3, mv = {1, 5, 1})
    static final class a implements FilenameFilter {

        public static final com.facebook.internal.g0.f.a a;
        static {
            f.a aVar = new f.a();
            f.a.a = aVar;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String string2) {
            n.e(string2, "name");
            f0 obj4 = f0.a;
            obj4 = 1;
            Object[] arr = new Object[obj4];
            arr[0] = "anr_log_";
            obj4 = String.format("^%s[0-9]+.json$", Arrays.copyOf(arr, obj4));
            n.e(obj4, "java.lang.String.format(format, *args)");
            h hVar = new h(obj4);
            return hVar.d(string2);
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\u0008\u0007", d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/io/File;", "kotlin.jvm.PlatformType", "name", "", "accept"}, k = 3, mv = {1, 5, 1})
    static final class b implements FilenameFilter {

        public static final com.facebook.internal.g0.f.b a;
        static {
            f.b bVar = new f.b();
            f.b.a = bVar;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String string2) {
            n.e(string2, "name");
            f0 obj4 = f0.a;
            obj4 = 1;
            Object[] arr = new Object[obj4];
            arr[0] = "analysis_log_";
            obj4 = String.format("^%s[0-9]+.json$", Arrays.copyOf(arr, obj4));
            n.e(obj4, "java.lang.String.format(format, *args)");
            h hVar = new h(obj4);
            return hVar.d(string2);
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\u0008\u0007", d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/io/File;", "kotlin.jvm.PlatformType", "name", "", "accept"}, k = 3, mv = {1, 5, 1})
    static final class c implements FilenameFilter {

        public static final com.facebook.internal.g0.f.c a;
        static {
            f.c cVar = new f.c();
            f.c.a = cVar;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String string2) {
            n.e(string2, "name");
            f0 obj4 = f0.a;
            obj4 = 3;
            Object[] arr = new Object[obj4];
            arr[0] = "crash_log_";
            arr[1] = "shield_log_";
            arr[2] = "thread_check_log_";
            obj4 = String.format("^(%s|%s|%s)[0-9]+.json$", Arrays.copyOf(arr, obj4));
            n.e(obj4, "java.lang.String.format(format, *args)");
            h hVar = new h(obj4);
            return hVar.d(string2);
        }
    }
    static {
    }

    public static final boolean a(String string) {
        final File file = f.c();
        if (file != null && string == null) {
            if (string == null) {
            }
            File file2 = new File(file, string);
            return file2.delete();
        }
        return 0;
    }

    public static final String b(Throwable throwable) {
        String obj1;
        if (throwable == null) {
            return null;
        }
        if (throwable.getCause() == null) {
            obj1 = throwable.toString();
        } else {
            obj1 = String.valueOf(throwable.getCause());
        }
        return obj1;
    }

    public static final File c() {
        boolean exists;
        File file;
        file = new File(o.f().getCacheDir(), "instrument");
        if (file.exists() == null) {
            if (file.mkdirs() != null) {
            } else {
                file = 0;
            }
        }
        return file;
    }

    public static final String d(Thread thread) {
        int i;
        String string;
        n.f(thread, "thread");
        java.lang.StackTraceElement[] obj4 = thread.getStackTrace();
        JSONArray jSONArray = new JSONArray();
        i = 0;
        while (i < obj4.length) {
            jSONArray.put(obj4[i].toString());
            i++;
        }
        return jSONArray.toString();
    }

    public static final String e(Throwable throwable) {
        int i;
        int length;
        int i2;
        String string;
        Throwable th;
        int obj6;
        if (throwable == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        while (obj6 != null) {
            if (obj6 != i) {
            }
            java.lang.StackTraceElement[] stackTrace = obj6.getStackTrace();
            i2 = 0;
            while (i2 < stackTrace.length) {
                jSONArray.put(stackTrace[i2].toString());
                i2++;
            }
            i = obj6;
            obj6 = th;
            jSONArray.put(stackTrace[i2].toString());
            i2++;
        }
        return jSONArray.toString();
    }

    public static final boolean f(Throwable throwable) {
        int i;
        int length;
        int i3;
        boolean z;
        int i2;
        String str;
        Throwable th;
        int obj9;
        final int i4 = 0;
        if (throwable == null) {
            return i4;
        }
        final int i5 = 0;
        i = i5;
        while (obj9 != null) {
            if (obj9 != i) {
            }
            java.lang.StackTraceElement[] stackTrace = obj9.getStackTrace();
            i3 = i4;
            while (i3 < stackTrace.length) {
                java.lang.StackTraceElement stack = stackTrace[i3];
                n.e(stack, "element");
                String className = stack.getClassName();
                n.e(className, "element.className");
                i3++;
            }
            i = obj9;
            obj9 = th;
            stack = stackTrace[i3];
            n.e(stack, "element");
            className = stack.getClassName();
            n.e(className, "element.className");
            i3++;
        }
        return i4;
    }

    public static final boolean g(Thread thread) {
        int length;
        int i3;
        java.lang.StackTraceElement stack;
        boolean str;
        String str2;
        String str3;
        int i;
        int i2;
        java.lang.StackTraceElement[] obj9;
        final int i4 = 0;
        obj9 = thread.getStackTrace();
        if (thread != null && obj9 != null) {
            obj9 = thread.getStackTrace();
            if (obj9 != null) {
                i3 = i4;
                while (i3 < obj9.length) {
                    stack = obj9[i3];
                    n.e(stack, "element");
                    String className = stack.getClassName();
                    str2 = "element.className";
                    n.e(className, str2);
                    i = 2;
                    i2 = 0;
                    i3++;
                    String className2 = stack.getClassName();
                    n.e(className2, str2);
                    String methodName2 = stack.getMethodName();
                    str2 = "element.methodName";
                    n.e(methodName2, str2);
                    String methodName3 = stack.getMethodName();
                    n.e(methodName3, str2);
                    String methodName = stack.getMethodName();
                    n.e(methodName, str2);
                    String className3 = stack.getClassName();
                    n.e(className3, str2);
                }
            }
        }
        return i4;
    }

    public static final File[] h() {
        File[] listFiles;
        File file = f.c();
        final int i = 0;
        if (file != null) {
            if (file.listFiles(f.a.a) != null) {
            } else {
                listFiles = new File[i];
            }
            return listFiles;
        }
        return new File[i];
    }

    public static final File[] i() {
        File[] listFiles;
        File file = f.c();
        final int i = 0;
        if (file != null) {
            if (file.listFiles(f.b.a) != null) {
            } else {
                listFiles = new File[i];
            }
            return listFiles;
        }
        return new File[i];
    }

    public static final File[] j() {
        File[] listFiles;
        File file = f.c();
        final int i = 0;
        if (file != null) {
            if (file.listFiles(f.c.a) != null) {
            } else {
                listFiles = new File[i];
            }
            return listFiles;
        }
        return new File[i];
    }

    public static final JSONObject k(String string, boolean z2) {
        File file = f.c();
        if (file != null && string == null) {
            if (string == null) {
            }
            File file2 = new File(file, string);
            FileInputStream fileInputStream = new FileInputStream(file2);
            JSONObject jSONObject = new JSONObject(b0.m0(fileInputStream));
            return jSONObject;
        }
        return null;
    }

    public static final void l(String string, JSONArray jSONArray2, p.b p$b3) {
        Object next;
        Object obj;
        Object obj6;
        n.f(jSONArray2, "reports");
        if (jSONArray2.length() == 0) {
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(string, jSONArray2.toString());
        JSONObject obj5 = b0.z();
        if (obj5 != null) {
            obj6 = obj5.keys();
            for (String next : obj6) {
                jSONObject.put(next, obj5.get(next));
            }
        }
        f0 f0Var = f0.a;
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = o.g();
        String format = String.format("%s/instruments", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(format, *args)");
        p.t.x(0, format, jSONObject, b3).j();
    }

    public static final void m(String string, String string2) {
        Object str;
        File file;
        Object obj2;
        byte[] obj3;
        str = f.c();
        if (str != null && string != null) {
            if (string != null) {
                if (string2 == null) {
                } else {
                    file = new File(str, string);
                    obj2 = new FileOutputStream(file);
                    obj3 = string2.getBytes(d.a);
                    n.e(obj3, "(this as java.lang.String).getBytes(charset)");
                    obj2.write(obj3);
                    obj2.close();
                }
            }
        }
    }
}
