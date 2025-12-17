package com.squareup.okhttp.internal.http;

import f.f.a.d;
import java.net.ProtocolException;

/* loaded from: classes2.dex */
public final class a {

    public final d a;
    public final int b;
    public final String c;
    public a(d d, int i2, String string3) {
        super();
        this.a = d;
        this.b = i2;
        this.c = string3;
    }

    public static com.squareup.okhttp.internal.http.a a(String string) {
        d hTTP_1_0;
        int charAt2;
        int i;
        int i2;
        char charAt;
        String obj8;
        int i6 = 32;
        final int i7 = 4;
        final String str3 = "Unexpected status line: ";
        if (string.startsWith("HTTP/1.")) {
            if (string.length() < 9) {
            } else {
                if (string.charAt(8) != i6) {
                } else {
                    charAt3 += -48;
                    if (i5 == 0) {
                        hTTP_1_0 = d.HTTP_1_0;
                        charAt = i + 3;
                        if (string.length() < charAt) {
                        } else {
                            if (string.length() > charAt) {
                                if (string.charAt(charAt) != i6) {
                                } else {
                                    obj8 = string.substring(i += i7);
                                    a aVar = new a(hTTP_1_0, Integer.parseInt(string.substring(i, charAt)), obj8);
                                    return aVar;
                                }
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(str3);
                                stringBuilder2.append(string);
                                ProtocolException protocolException2 = new ProtocolException(stringBuilder2.toString());
                                throw protocolException2;
                            }
                            obj8 = "";
                        }
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(str3);
                        stringBuilder3.append(string);
                        ProtocolException protocolException3 = new ProtocolException(stringBuilder3.toString());
                        throw protocolException3;
                    } else {
                        if (i5 != 1) {
                        } else {
                            hTTP_1_0 = d.HTTP_1_1;
                        }
                    }
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append(str3);
                    stringBuilder5.append(string);
                    ProtocolException protocolException5 = new ProtocolException(stringBuilder5.toString());
                    throw protocolException5;
                }
            }
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append(str3);
            stringBuilder6.append(string);
            ProtocolException protocolException6 = new ProtocolException(stringBuilder6.toString());
            throw protocolException6;
        }
        if (!string.startsWith("ICY ")) {
        } else {
            hTTP_1_0 = d.HTTP_1_0;
            i = i7;
        }
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(str3);
        stringBuilder4.append(string);
        ProtocolException protocolException4 = new ProtocolException(stringBuilder4.toString());
        throw protocolException4;
    }

    public String toString() {
        String str;
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        str = this.a == d.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1";
        stringBuilder.append(str);
        i = 32;
        stringBuilder.append(i);
        stringBuilder.append(this.b);
        if (this.c != null) {
            stringBuilder.append(i);
            stringBuilder.append(this.c);
        }
        return stringBuilder.toString();
    }
}
