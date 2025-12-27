package f.g.c;

import android.os.Build.VERSION;
import android.util.Log;
import com.zendesk.service.a;
import f.g.e.g;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: Logger.java */
/* loaded from: classes2.dex */
public class a {

    private static final TimeZone a;
    private static final List<a.c> b = new ArrayList<>();
    private static a.c c;
    private static boolean d;

    public interface c {
        void a(a.d dVar, String str, String str2, Throwable th);
    }

    public enum d {

        DEBUG,
        ERROR,
        INFO,
        VERBOSE,
        WARN;

        private final int priority;
        static /* synthetic */ int access$000(a.d dVar) {
            return dVar.priority;
        }
    }

    static class a implements a.c {
        a() {
            super();
        }

        private boolean b(String str) {
            boolean endsWith;
            boolean z = true;
            if (g.c(str)) {
                if (!str.endsWith("Provider")) {
                    str = str.endsWith("Service") ? 1 : 0;
                }
            }
            return (str.endsWith("Service") ? 1 : 0);
        }

        public void a(a.d dVar, String str, String str2, Throwable th) {
            boolean z;
            String item;
            int i;
            final String str4 = b.a(str);
            if (b(str) && a.d.ERROR == dVar) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                simpleDateFormat.setTimeZone(a.a);
                StringBuilder stringBuilder = new StringBuilder();
                String str6 = "Time in UTC: ";
                String format = simpleDateFormat.format(new Date());
                str = str6 + format;
                Log.println(a.d.ERROR.priority, str4, str);
            }
            if (th != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str7 = g.b;
                String stackTraceString = Log.getStackTraceString(th);
                item = str2 + str7 + stackTraceString;
            }
            Iterator it = b.c(item, 4000).iterator();
            while (it.hasNext()) {
                Log.println(i, str4, (String)it.next());
            }
        }
    }

    static class b implements a.c {
        b() {
            super();
        }

        public void a(a.d dVar, String str, String str2, Throwable th) {
            char c;
            final StringBuilder stringBuilder = new StringBuilder(100);
            stringBuilder.append("[");
            stringBuilder.append(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US).format(new Date()));
            stringBuilder.append("]");
            stringBuilder.append(" ");
            if (dVar == null) {
                c = b.b(a.d.INFO.priority);
            } else {
                c = b.b(dVar.priority);
            }
            stringBuilder.append(c);
            stringBuilder.append("/");
            if (!(g.c(str))) {
                str = "UNKNOWN";
            }
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            System.out.println(stringBuilder.toString());
            if (th != null) {
                th.printStackTrace(System.out);
            }
        }
    }
    static {
        f.g.c.a.b bVar;
        f.g.c.a.c bVar3;
        a.a = TimeZone.getTimeZone("UTC");
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                a.c = new a.a();
            }
        } catch (Throwable th) {
            bVar3 = a.c;
        } catch (java.lang.ClassNotFoundException unused) {
            th = a.c;
        }
        if (a.c == null) {
            bVar = new a.b();
            a.c = bVar;
        }
        a.d = false;
    }

    static /* synthetic */ TimeZone a() {
        return a.a;
    }

    public static void b(String str, String str2, Object... objectArr) {
        a.i(a.d.DEBUG, str, str2, null, objectArr);
    }

    public static void c(String str, a aVar) {
        String str3;
        StringBuilder stringBuilder = new StringBuilder();
        if (aVar != null && g.c(aVar.b())) {
            stringBuilder.append(", Reason: ");
            stringBuilder.append(aVar.b());
        }
        if (!(g.c(stringBuilder.toString()))) {
            str3 = "Unknown error";
        }
        a.i(a.d.ERROR, str, str3, null, new Object[0]);
    }

    public static void d(String str, String str2, Throwable th, Object... objectArr) {
        a.i(a.d.ERROR, str, str2, th, objectArr);
    }

    public static void e(String str, String str2, Object... objectArr) {
        a.i(a.d.ERROR, str, str2, null, objectArr);
    }

    public static void f(String str, String str2, Throwable th, Object... objectArr) {
        a.i(a.d.INFO, str, str2, th, objectArr);
    }

    public static void g(String str, String str2, Object... objectArr) {
        a.i(a.d.INFO, str, str2, null, objectArr);
    }

    public static boolean h() {
        return a.d;
    }

    private static void i(a.d dVar, String str, String str2, Throwable th, Object... objectArr) {
        int length;
        String formatted;
        if (objectArr != null && objectArr.length > 0) {
            formatted = String.format(Locale.US, str2, objectArr);
        }
        if (a.d) {
            a.c.a(dVar, str, formatted, th);
            Iterator it = a.b.iterator();
            while (it.hasNext()) {
                (a.c)it.next().a(dVar, str, formatted, th);
            }
        }
    }

    public static void j(String str, String str2, Throwable th, Object... objectArr) {
        a.i(a.d.WARN, str, str2, th, objectArr);
    }

    public static void k(String str, String str2, Object... objectArr) {
        a.i(a.d.WARN, str, str2, null, objectArr);
    }
}
