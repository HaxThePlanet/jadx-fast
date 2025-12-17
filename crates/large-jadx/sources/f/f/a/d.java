package f.f.a;

import java.io.IOException;

/* loaded from: classes2.dex */
public enum d {

    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    private final String protocol;
    public static f.f.a.d get(String string) {
        f.f.a.d hTTP_1_0 = d.HTTP_1_0;
        if (string.equals(hTTP_1_0.protocol)) {
            return hTTP_1_0;
        }
        f.f.a.d hTTP_1_1 = d.HTTP_1_1;
        if (string.equals(hTTP_1_1.protocol)) {
            return hTTP_1_1;
        }
        f.f.a.d hTTP_2 = d.HTTP_2;
        if (string.equals(hTTP_2.protocol)) {
            return hTTP_2;
        }
        f.f.a.d sPDY_3 = d.SPDY_3;
        if (!string.equals(sPDY_3.protocol)) {
        } else {
            return sPDY_3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected protocol: ");
        stringBuilder.append(string);
        IOException iOException = new IOException(stringBuilder.toString());
        throw iOException;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
