package f.f.a;

import java.io.UnsupportedEncodingException;
import l.i;

/* compiled from: Credentials.java */
/* loaded from: classes2.dex */
public final class a {
    public static String a(String str, String str2) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String str4 = ":";
            str5 = str + str4 + str2;
            String str6 = i.t(str5.getBytes("ISO-8859-1")).a();
            StringBuilder stringBuilder2 = new StringBuilder();
            String str3 = "Basic ";
            str7 = str3 + str6;
        } catch (java.io.UnsupportedEncodingException unused) {
            str = new AssertionError();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) str;
        }
        return str7;
    }
}
