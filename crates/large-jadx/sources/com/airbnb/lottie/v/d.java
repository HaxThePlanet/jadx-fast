package com.airbnb.lottie.v;

import com.airbnb.lottie.v.k.n;
import java.util.List;

/* compiled from: FontCharacter.java */
/* loaded from: classes.dex */
public class d {

    private final List<n> a;
    private final char b;
    private final double c;
    private final String d;
    private final String e;
    public d(List<n> list, char c, double d, double d2, String str, String str2) {
        super();
        this.a = list;
        this.b = c;
        this.c = d2;
        this.d = str;
        this.e = str2;
    }

    public static int c(char c, String str, String str2) {
        return (c * 31) + str.hashCode() * 31 + str2.hashCode();
    }

    public List<n> a() {
        return this.a;
    }

    public double b() {
        return this.c;
    }

    public int hashCode() {
        return d.c(this.b, this.e, this.d);
    }
}
