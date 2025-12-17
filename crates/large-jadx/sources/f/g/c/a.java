package f.g.c;

import android.os.Build.VERSION;
import android.util.Log;
import com.zendesk.service.a;
import f.g.e.g;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class a {

    private static final TimeZone a;
    private static final List<f.g.c.a.c> b;
    private static f.g.c.a.c c;
    private static boolean d;

    public interface c {
        public abstract void a(f.g.c.a.d a$d, String string2, String string3, Throwable throwable4);
    }

    public static enum d {

        VERBOSE(2),
        DEBUG(3),
        INFO(4),
        WARN(5),
        ERROR(6);

        private final int priority;
        static int access$000(f.g.c.a.d a$d) {
            return d.priority;
        }
    }

    static class a implements f.g.c.a.c {
        private boolean b(String string) {
            boolean endsWith;
            String obj2;
            if (g.c(string)) {
                if (!string.endsWith("Provider")) {
                    obj2 = string.endsWith("Service") ? 1 : 0;
                } else {
                }
            } else {
            }
            return obj2;
        }

        @Override // f.g.c.a$c
        public void a(f.g.c.a.d a$d, String string2, String string3, Throwable throwable4) {
            String string;
            StringBuilder stringBuilder;
            Date date;
            boolean obj6;
            String obj7;
            Throwable obj8;
            final String str = b.a(string2);
            obj6 = a.d.ERROR;
            if (b(string2) && obj6 == d) {
                obj6 = a.d.ERROR;
                if (obj6 == d) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                    simpleDateFormat.setTimeZone(a.a());
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Time in UTC: ");
                    date = new Date();
                    stringBuilder.append(simpleDateFormat.format(date));
                    Log.println(a.d.access$000(obj6), str, stringBuilder.toString());
                }
            }
            if (throwable4 != null) {
                obj6 = new StringBuilder();
                obj6.append(string3);
                obj6.append(g.b);
                obj6.append(Log.getStackTraceString(throwable4));
                obj7 = obj6.toString();
            }
            obj6 = b.c(obj7, 4000).iterator();
            while (obj6.hasNext()) {
                if (d == null) {
                } else {
                }
                obj8 = a.d.access$000(d);
                Log.println(obj8, str, (String)obj6.next());
                obj8 = a.d.access$000(a.d.INFO);
            }
        }
    }

    static class b implements f.g.c.a.c {
        @Override // f.g.c.a$c
        public void a(f.g.c.a.d a$d, String string2, String string3, Throwable throwable4) {
            char obj5;
            String obj6;
            StringBuilder stringBuilder = new StringBuilder(100);
            stringBuilder.append("[");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            Date date = new Date();
            stringBuilder.append(simpleDateFormat.format(date));
            stringBuilder.append("]");
            stringBuilder.append(" ");
            if (d == null) {
                obj5 = b.b(a.d.access$000(a.d.INFO));
            } else {
                obj5 = b.b(a.d.access$000(d));
            }
            stringBuilder.append(obj5);
            stringBuilder.append("/");
            if (g.c(string2)) {
            } else {
                obj6 = "UNKNOWN";
            }
            stringBuilder.append(obj6);
            stringBuilder.append(": ");
            stringBuilder.append(string3);
            System.out.println(stringBuilder.toString());
            if (throwable4 != null) {
                throwable4.printStackTrace(System.out);
            }
        }
    }
    static {
        int sDK_INT;
        f.g.c.a.b bVar2;
        f.g.c.a.c bVar3;
        a.a = TimeZone.getTimeZone("UTC");
        ArrayList arrayList = new ArrayList();
        a.b = arrayList;
        Class.forName("android.os.Build");
        if (Build.VERSION.SDK_INT != 0) {
            sDK_INT = new a.a();
            a.c = sDK_INT;
        }
        if (a.c == null) {
            bVar2 = new a.b();
            a.c = bVar2;
        }
        a.d = false;
    }

    static TimeZone a() {
        return a.a;
    }

    public static void b(String string, String string2, Object... object3Arr3) {
        a.i(a.d.DEBUG, string, string2, 0, object3Arr3);
    }

    public static void c(String string, a a2) {
        boolean str;
        String obj4;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Network Error: ");
        stringBuilder.append(a2.c());
        stringBuilder.append(", Status Code: ");
        stringBuilder.append(a2.m());
        if (a2 != null && g.c(a2.b())) {
            stringBuilder.append("Network Error: ");
            stringBuilder.append(a2.c());
            stringBuilder.append(", Status Code: ");
            stringBuilder.append(a2.m());
            if (g.c(a2.b())) {
                stringBuilder.append(", Reason: ");
                stringBuilder.append(a2.b());
            }
        }
        if (g.c(stringBuilder.toString())) {
        } else {
            obj4 = "Unknown error";
        }
        a.i(a.d.ERROR, string, obj4, 0, new Object[0]);
    }

    public static void d(String string, String string2, Throwable throwable3, Object... object4Arr4) {
        a.i(a.d.ERROR, string, string2, throwable3, object4Arr4);
    }

    public static void e(String string, String string2, Object... object3Arr3) {
        a.i(a.d.ERROR, string, string2, 0, object3Arr3);
    }

    public static void f(String string, String string2, Throwable throwable3, Object... object4Arr4) {
        a.i(a.d.INFO, string, string2, throwable3, object4Arr4);
    }

    public static void g(String string, String string2, Object... object3Arr3) {
        a.i(a.d.INFO, string, string2, 0, object3Arr3);
    }

    public static boolean h() {
        return a.d;
    }

    private static void i(f.g.c.a.d a$d, String string2, String string3, Throwable throwable4, Object... object5Arr5) {
        int length;
        String obj3;
        boolean obj5;
        if (object5Arr5 != null && object5Arr5.length > 0) {
            if (object5Arr5.length > 0) {
                obj3 = String.format(Locale.US, string3, object5Arr5);
            }
        }
        if (a.d) {
            a.c.a(d, string2, obj3, throwable4);
            obj5 = a.b.iterator();
            for (a.c length : obj5) {
                length.a(d, string2, obj3, throwable4);
            }
        }
    }

    public static void j(String string, String string2, Throwable throwable3, Object... object4Arr4) {
        a.i(a.d.WARN, string, string2, throwable3, object4Arr4);
    }

    public static void k(String string, String string2, Object... object3Arr3) {
        a.i(a.d.WARN, string, string2, 0, object3Arr3);
    }
}
