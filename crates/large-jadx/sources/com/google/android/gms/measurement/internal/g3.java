package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import java.util.List;

/* loaded from: classes2.dex */
public interface g3 extends IInterface {
    @Override // android.os.IInterface
    public abstract void A0(com.google.android.gms.measurement.internal.na na);

    public abstract List<com.google.android.gms.measurement.internal.ea> E1(com.google.android.gms.measurement.internal.na na, boolean z2);

    public abstract List<com.google.android.gms.measurement.internal.ea> F(String string, String string2, String string3, boolean z4);

    @Override // android.os.IInterface
    public abstract void J(com.google.android.gms.measurement.internal.na na);

    @Override // android.os.IInterface
    public abstract void J1(com.google.android.gms.measurement.internal.ea ea, com.google.android.gms.measurement.internal.na na2);

    @Override // android.os.IInterface
    public abstract void M0(com.google.android.gms.measurement.internal.u u, com.google.android.gms.measurement.internal.na na2);

    @Override // android.os.IInterface
    public abstract void M1(com.google.android.gms.measurement.internal.u u, String string2, String string3);

    @Override // android.os.IInterface
    public abstract String R(com.google.android.gms.measurement.internal.na na);

    @Override // android.os.IInterface
    public abstract void T0(com.google.android.gms.measurement.internal.na na);

    @Override // android.os.IInterface
    public abstract void U0(long l, String string2, String string3, String string4);

    public abstract List<com.google.android.gms.measurement.internal.ea> Z0(String string, String string2, boolean z3, com.google.android.gms.measurement.internal.na na4);

    @Override // android.os.IInterface
    public abstract void a0(com.google.android.gms.measurement.internal.c c);

    public abstract List<com.google.android.gms.measurement.internal.c> b0(String string, String string2, String string3);

    @Override // android.os.IInterface
    public abstract byte[] f0(com.google.android.gms.measurement.internal.u u, String string2);

    @Override // android.os.IInterface
    public abstract void q0(com.google.android.gms.measurement.internal.na na);

    public abstract List<com.google.android.gms.measurement.internal.c> s0(String string, String string2, com.google.android.gms.measurement.internal.na na3);

    @Override // android.os.IInterface
    public abstract void t(Bundle bundle, com.google.android.gms.measurement.internal.na na2);

    @Override // android.os.IInterface
    public abstract void z(com.google.android.gms.measurement.internal.c c, com.google.android.gms.measurement.internal.na na2);
}
