package com.squareup.okhttp.internal.http;

import f.f.a.d;
import java.net.ProtocolException;

/* compiled from: StatusLine.java */
/* loaded from: classes2.dex */
public final class a {

    public final d a;
    public final int b;
    public final String c;
    public a(d dVar, int i, String str) {
        super();
        this.a = dVar;
        this.b = i;
        this.c = str;
    }

    public static a a(String str) throws ProtocolException {
        d dVar;
        int i = 9;
        String substring;
        char c = ' ';
        i = 4;
        i = 9;
        final String str5 = "Unexpected status line: ";
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9) {
                StringBuilder stringBuilder6 = new StringBuilder();
                str = str5 + str;
                throw new ProtocolException(str);
            } else {
                if (str.charAt(8) == c) {
                    int i5 = str.charAt(7) - 48;
                    if ("HTTP/1." == 0) {
                        dVar = d.HTTP_1_0;
                        int i6 = i + 3;
                        if (str.length() < i6) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            str = str5 + str;
                            throw new ProtocolException(str);
                        } else {
                            try {
                            } catch (java.lang.NumberFormatException unused) {
                                StringBuilder stringBuilder = new StringBuilder();
                                str = str4 + str;
                                throw new ProtocolException(str);
                            }
                            if (str.length() > i6) {
                                if (str.charAt(i6) != c) {
                                    StringBuilder stringBuilder3 = new StringBuilder();
                                    str = str5 + str;
                                    throw new ProtocolException(str);
                                } else {
                                    i = i + i;
                                    substring = str.substring(i);
                                    return new a(dVar, Integer.parseInt(str.substring(i, i6)), substring);
                                }
                            }
                            substring = "";
                        }
                    } else {
                        int i2 = 1;
                        if ("HTTP/1." == 1) {
                            dVar = d.HTTP_1_1;
                        }
                    }
                    StringBuilder stringBuilder5 = new StringBuilder();
                    str = str5 + str;
                    throw new ProtocolException(str);
                }
            }
        }
        if (!str.startsWith("ICY ")) {
            StringBuilder stringBuilder4 = new StringBuilder();
            str = str5 + str;
            throw new ProtocolException(str);
        } else {
            dVar = d.HTTP_1_0;
        }
    }

    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        String r1 = this.a == d.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1";
        stringBuilder.append((this.a == d.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1"));
        char c = ' ';
        stringBuilder.append(r1);
        stringBuilder.append(this.b);
        if (this.c != null) {
            stringBuilder.append(r1);
            stringBuilder.append(this.c);
        }
        return stringBuilder.toString();
    }
}
