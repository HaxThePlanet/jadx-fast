package d.h.i;

import android.util.Base64;
import d.h.k.i;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    private final String a;
    private final String b;
    private final String c;
    private final List<List<byte[]>> d;
    private final int e = 0;
    private final String f;
    public d(String string, String string2, String string3, List<List<byte[]>> list4) {
        super();
        i.c(string);
        this.a = (String)string;
        i.c(string2);
        this.b = (String)string2;
        i.c(string3);
        this.c = (String)string3;
        i.c(list4);
        this.d = (List)list4;
        final int obj5 = 0;
        this.f = a(string, string2, string3);
    }

    private String a(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder(string);
        String obj2 = "-";
        stringBuilder.append(obj2);
        stringBuilder.append(string2);
        stringBuilder.append(obj2);
        stringBuilder.append(string3);
        return stringBuilder.toString();
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
        String str;
        int i2;
        int size;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("FontRequest {mProviderAuthority: ");
        stringBuilder2.append(this.a);
        stringBuilder2.append(", mProviderPackage: ");
        stringBuilder2.append(this.b);
        stringBuilder2.append(", mQuery: ");
        stringBuilder2.append(this.c);
        stringBuilder2.append(", mCertificates:");
        stringBuilder.append(stringBuilder2.toString());
        int i3 = 0;
        i = i3;
        while (i < this.d.size()) {
            stringBuilder.append(" [");
            Object obj = this.d.get(i);
            i2 = i3;
            while (i2 < (List)obj.size()) {
                stringBuilder.append(" \"");
                stringBuilder.append(Base64.encodeToString((byte[])obj.get(i2), i3));
                stringBuilder.append("\"");
                i2++;
            }
            stringBuilder.append(" ]");
            i++;
            stringBuilder.append(" \"");
            stringBuilder.append(Base64.encodeToString((byte[])obj.get(i2), i3));
            stringBuilder.append("\"");
            i2++;
        }
        stringBuilder.append("}");
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("mCertificatesArray: ");
        stringBuilder3.append(this.e);
        stringBuilder.append(stringBuilder3.toString());
        return stringBuilder.toString();
    }
}
