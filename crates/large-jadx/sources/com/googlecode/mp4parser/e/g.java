package com.googlecode.mp4parser.e;

import com.googlecode.mp4parser.h.h;
import java.util.Date;

/* loaded from: classes2.dex */
public class g implements java.lang.Cloneable {

    private int A = 0;
    int B;
    private String a;
    private long b;
    private Date c;
    private h v;
    private double w;
    private double x;
    private float y;
    private long z = 1;
    public g() {
        super();
        this.a = "eng";
        Date date = new Date();
        Date date2 = new Date();
        this.c = date2;
        this.v = h.j;
        int i = 1;
        int i2 = 0;
    }

    @Override // java.lang.Cloneable
    public Date a() {
        return this.c;
    }

    @Override // java.lang.Cloneable
    public int b() {
        return this.A;
    }

    @Override // java.lang.Cloneable
    public double c() {
        return this.x;
    }

    @Override // java.lang.Cloneable
    public Object clone() {
        try {
            return super.clone();
            return null;
        }
    }

    @Override // java.lang.Cloneable
    public String d() {
        return this.a;
    }

    @Override // java.lang.Cloneable
    public int e() {
        return this.B;
    }

    @Override // java.lang.Cloneable
    public h f() {
        return this.v;
    }

    @Override // java.lang.Cloneable
    public long g() {
        return this.b;
    }

    @Override // java.lang.Cloneable
    public long h() {
        return this.z;
    }

    @Override // java.lang.Cloneable
    public float j() {
        return this.y;
    }

    @Override // java.lang.Cloneable
    public double k() {
        return this.w;
    }

    @Override // java.lang.Cloneable
    public void l(Date date) {
        this.c = date;
    }

    @Override // java.lang.Cloneable
    public void m(double d) {
        this.x = d;
    }

    @Override // java.lang.Cloneable
    public void n(String string) {
        this.a = string;
    }

    @Override // java.lang.Cloneable
    public void o(int i) {
        this.B = i;
    }

    @Override // java.lang.Cloneable
    public void p(h h) {
        this.v = h;
    }

    @Override // java.lang.Cloneable
    public void r(Date date) {
    }

    @Override // java.lang.Cloneable
    public void s(long l) {
        this.b = l;
    }

    @Override // java.lang.Cloneable
    public void t(long l) {
        this.z = l;
    }

    @Override // java.lang.Cloneable
    public void u(float f) {
        this.y = f;
    }

    @Override // java.lang.Cloneable
    public void v(double d) {
        this.w = d;
    }
}
