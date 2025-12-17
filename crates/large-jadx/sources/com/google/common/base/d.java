package com.google.common.base;

import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class d {

    public static final Charset a;
    public static final Charset b;
    public static final Charset c;
    public static final Charset d;
    public static final Charset e;
    static {
        d.a = Charset.forName("US-ASCII");
        d.b = Charset.forName("ISO-8859-1");
        d.c = Charset.forName("UTF-8");
        Charset.forName("UTF-16BE");
        d.d = Charset.forName("UTF-16LE");
        d.e = Charset.forName("UTF-16");
    }
}
