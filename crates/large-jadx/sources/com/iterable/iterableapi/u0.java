package com.iterable.iterableapi;

import java.util.Date;
import java.util.UUID;

/* compiled from: IterableTask.java */
/* loaded from: classes2.dex */
class u0 {

    String a;
    String b;
    int c;
    long d;
    long e;
    long f;
    long g;
    long h;
    boolean i;
    boolean j;
    boolean k;
    String l;
    String m;
    x0 n;
    int o;
    u0(String str, String str2, int i, long j, long j2, long j3, long j4, long j5, boolean z, boolean z2, boolean z3, String str3, String str4, x0 x0Var, int i2) {
        final Object str6 = this;
        super();
        str6.a = str;
        str6.b = str2;
        str6.c = i;
        str6.d = j;
        str6.e = j2;
        str6.f = j3;
        str6.g = j4;
        str6.h = j5;
        str6.i = z;
        str6.j = z2;
        str6.k = z3;
        str6.l = str3;
        str6.m = str4;
        str6.n = x0Var;
        str6.o = i2;
    }

    u0(String str, x0 x0Var, String str2) {
        super();
        this.a = UUID.randomUUID().toString();
        this.b = str;
        this.d = new Date().getTime();
        this.g = new Date().getTime();
        this.h = new Date().getTime();
        this.l = str2;
        this.n = x0Var;
    }
}
