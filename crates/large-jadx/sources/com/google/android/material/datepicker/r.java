package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.internal.e;
import com.google.android.material.internal.n;
import com.google.android.material.textfield.TextInputLayout;
import d.h.k.d;
import f.c.a.e.a0.b;
import f.c.a.e.b;
import f.c.a.e.f;
import f.c.a.e.h;
import f.c.a.e.j;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes2.dex */
public class r implements com.google.android.material.datepicker.e<Long> {

    public static final Parcelable.Creator<com.google.android.material.datepicker.r> CREATOR;
    private Long a;

    static class b implements Parcelable.Creator<com.google.android.material.datepicker.r> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.material.datepicker.r a(Parcel parcel) {
            r rVar = new r();
            r.b(rVar, (Long)parcel.readValue(Long.class.getClassLoader()));
            return rVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.material.datepicker.r[] b(int i) {
            return new r[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }

    class a extends com.google.android.material.datepicker.d {

        final com.google.android.material.datepicker.p y;
        final com.google.android.material.datepicker.r z;
        a(com.google.android.material.datepicker.r r, String string2, DateFormat dateFormat3, TextInputLayout textInputLayout4, com.google.android.material.datepicker.a a5, com.google.android.material.datepicker.p p6) {
            this.z = r;
            this.y = p6;
            super(string2, dateFormat3, textInputLayout4, a5);
        }

        @Override // com.google.android.material.datepicker.d
        void e() {
            this.y.a();
        }

        @Override // com.google.android.material.datepicker.d
        void f(Long long) {
            com.google.android.material.datepicker.r rVar;
            long longValue;
            com.google.android.material.datepicker.r obj4;
            if (long == null) {
                r.a(this.z);
            } else {
                this.z.U1(long.longValue());
            }
            this.y.b(this.z.d());
        }
    }
    static {
        r.b bVar = new r.b();
        r.CREATOR = bVar;
    }

    static void a(com.google.android.material.datepicker.r r) {
        r.c();
    }

    static Long b(com.google.android.material.datepicker.r r, Long long2) {
        r.a = long2;
        return long2;
    }

    private void c() {
        this.a = 0;
    }

    @Override // com.google.android.material.datepicker.e
    public String E(Context context) {
        Resources obj5 = context.getResources();
        Long num = this.a;
        if (num == null) {
            return obj5.getString(j.x);
        }
        Object[] arr = new Object[1];
        return obj5.getString(j.v, f.h(num.longValue()));
    }

    public View G0(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3, com.google.android.material.datepicker.a a4, com.google.android.material.datepicker.p<Long> p5) {
        boolean obj10;
        final View obj8 = layoutInflater.inflate(h.A, viewGroup2, false);
        final View view = obj9;
        EditText obj9 = (TextInputLayout)view.getEditText();
        if (e.a()) {
            obj9.setInputType(17);
        }
        final SimpleDateFormat date = u.k();
        final String str = u.l(obj8.getResources(), date);
        view.setPlaceholderText(str);
        obj10 = this.a;
        if (obj10 != null) {
            obj9.setText(date.format(obj10));
        }
        super(this, str, date, view, a4, p5);
        obj9.addTextChangedListener(obj10);
        n.j(obj9);
        return obj8;
    }

    @Override // com.google.android.material.datepicker.e
    public int I0() {
        return j.w;
    }

    public Collection<d<Long, Long>> L() {
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.e
    public void U(Object object) {
        e((Long)object);
    }

    @Override // com.google.android.material.datepicker.e
    public void U1(long l) {
        this.a = Long.valueOf(l);
    }

    @Override // com.google.android.material.datepicker.e
    public Long d() {
        return this.a;
    }

    @Override // com.google.android.material.datepicker.e
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.e
    public void e(Long long) {
        long l;
        int obj3;
        if (long == null) {
            obj3 = 0;
        } else {
            obj3 = Long.valueOf(u.a(long.longValue()));
        }
        this.a = obj3;
    }

    @Override // com.google.android.material.datepicker.e
    public int e1(Context context) {
        return b.d(context, b.C, j.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.e
    public boolean l1() {
        int i;
        i = this.a != null ? 1 : 0;
        return i;
    }

    public Collection<Long> t1() {
        ArrayList arrayList = new ArrayList();
        final Long num = this.a;
        if (num != null) {
            arrayList.add(num);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.e
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.a);
    }

    @Override // com.google.android.material.datepicker.e
    public Object z1() {
        return d();
    }
}
