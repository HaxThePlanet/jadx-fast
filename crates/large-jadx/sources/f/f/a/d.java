package f.f.a;

import java.io.IOException;

/* compiled from: Protocol.java */
/* loaded from: classes2.dex */
public enum d {

    HTTP_1_0,
    HTTP_1_1,
    HTTP_2,
    SPDY_3;

    private final String protocol;
    public static d get(String str) throws IOException {
        f.f.a.d hTTP_1_02 = d.HTTP_1_0;
        if (str.equals(hTTP_1_02.protocol)) {
            return d.HTTP_1_0;
        }
        f.f.a.d hTTP_1_12 = d.HTTP_1_1;
        if (str.equals(hTTP_1_12.protocol)) {
            return d.HTTP_1_1;
        }
        f.f.a.d hTTP_22 = d.HTTP_2;
        if (str.equals(hTTP_22.protocol)) {
            return d.HTTP_2;
        }
        f.f.a.d sPDY_32 = d.SPDY_3;
        if (!str.equals(sPDY_32.protocol)) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str2 = "Unexpected protocol: ";
            str = str2 + str;
            throw new IOException(str);
        } else {
            return d.SPDY_3;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
