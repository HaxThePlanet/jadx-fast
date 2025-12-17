package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import d.h.k.d;
import java.util.Collection;

/* loaded from: classes2.dex */
public interface e<S>  extends Parcelable {
    @Override // android.os.Parcelable
    public abstract String E(Context context);

    public abstract View G0(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3, com.google.android.material.datepicker.a a4, com.google.android.material.datepicker.p<S> p5);

    @Override // android.os.Parcelable
    public abstract int I0();

    public abstract Collection<d<Long, Long>> L();

    public abstract void U(S s);

    @Override // android.os.Parcelable
    public abstract void U1(long l);

    @Override // android.os.Parcelable
    public abstract int e1(Context context);

    @Override // android.os.Parcelable
    public abstract boolean l1();

    public abstract Collection<Long> t1();

    public abstract S z1();
}
