package d.h.i;

import android.util.Base64;
import d.h.k.i;
import java.util.List;

/* compiled from: FontRequest.java */
/* loaded from: classes.dex */
public final class d {

    private final String a;
    private final String b;
    private final String c;
    private final List<List<byte[]>> d;
    private final int e = 0;
    private final String f;
    public d(String str, String str2, String str3, List<List<byte[]>> list) {
        super();
        i.c(str);
        this.a = (String)str;
        i.c(str2);
        this.b = (String)str2;
        i.c(str3);
        this.c = (String)str3;
        i.c(list);
        this.d = list;
        this.f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        final StringBuilder stringBuilder = new StringBuilder(str);
        String str4 = "-";
        str5 = str + str4 + str2 + str4 + str3;
        return str5;
    }

    public List<List<byte[]>> b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    String d() {
        return this.f;
    }

    public String e() {
        return this.a;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.c;
    }

    public String toString() {
        int i;
        int size;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        String str6 = "FontRequest {mProviderAuthority: ";
        String str8 = ", mProviderPackage: ";
        String str10 = ", mQuery: ";
        String str12 = ", mCertificates:";
        str3 = str6 + this.a + str8 + this.b + str10 + this.c + str12;
        stringBuilder.append(str3);
        i = 0;
        while (this.a < this.d.size()) {
            stringBuilder.append(" [");
            Object item = this.d.get(i);
            while (i < item.size()) {
                stringBuilder.append(" \"");
                stringBuilder.append(Base64.encodeToString((byte[])item.get(i), i));
                stringBuilder.append("\"");
                i = i + 1;
            }
            str = " ]";
            stringBuilder.append(str);
            i = i + 1;
            stringBuilder.append(" \"");
            stringBuilder.append(Base64.encodeToString((byte[])item.get(i), i));
            stringBuilder.append("\"");
            i = i + 1;
        }
        stringBuilder.append("}");
        StringBuilder stringBuilder3 = new StringBuilder();
        String str13 = "mCertificatesArray: ";
        str5 = str13 + this.e;
        stringBuilder.append(str5);
        return stringBuilder.toString();
    }
}
