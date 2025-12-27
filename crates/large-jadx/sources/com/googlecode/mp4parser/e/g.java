package com.googlecode.mp4parser.e;

import com.googlecode.mp4parser.h.h;
import java.util.Date;

/* compiled from: TrackMetaData.java */
/* loaded from: classes2.dex */
public class g implements java.lang.Cloneable {

    private int A = 0;
    int B;
    private String a = "eng";
    private long b;
    private Date c = new Date();
    private h v;
    private double w;
    private double x;
    private float y;
    private long z = 1;
    public g() {
        super();
        Date date = new Date();
        Date date2 = new Date();
        this.v = h.j;
    }

    public Date a() {
        return this.c;
    }

    public int b() {
        return this.A;
    }

    public double c() {
        return this.x;
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
        } catch (java.lang.CloneNotSupportedException unused) {
            return null;
        }
        return super.clone();
    }

    public String d() {
        return this.a;
    }

    public int e() {
        return this.B;
    }

    public h f() {
        return this.v;
    }

    public long g() {
        return this.b;
    }

    public long h() {
        return this.z;
    }

    public float j() {
        return this.y;
    }

    public double k() {
        return this.w;
    }

    public void l(Date date) {
        this.c = date;
    }

    public void m(double d) {
        this.x = d;
    }

    public void n(String str) {
        this.a = str;
    }

    public void o(int i) {
        this.B = i;
    }

    public void p(h hVar) {
        this.v = hVar;
    }

    public void s(long j) {
        this.b = j;
    }

    public void t(long j) {
        this.z = j;
    }

    public void u(float f) {
        this.y = f;
    }

    public void v(double d) {
        this.w = d;
    }

    public void r(Date date) {
    }
}
