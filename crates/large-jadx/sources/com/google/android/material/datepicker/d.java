package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.internal.k;
import com.google.android.material.textfield.TextInputLayout;
import f.c.a.e.j;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes2.dex */
abstract class d extends k {

    private final TextInputLayout a;
    private final DateFormat b;
    private final com.google.android.material.datepicker.a c;
    private final String v;
    private final Runnable w;
    private Runnable x;

    class a implements Runnable {

        final String a;
        final com.google.android.material.datepicker.d b;
        a(com.google.android.material.datepicker.d d, String string2) {
            this.b = d;
            this.a = string2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout textInputLayout = d.a(this.b);
            Context context = textInputLayout.getContext();
            int i3 = 1;
            Object[] arr2 = new Object[i3];
            final int i5 = 0;
            arr2[i5] = this.a;
            Object[] arr = new Object[i3];
            Date date2 = new Date(u.o().getTimeInMillis(), obj10);
            arr[i5] = d.b(this.b).format(date2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getString(j.z));
            String str = "\n";
            stringBuilder.append(str);
            stringBuilder.append(String.format(context.getString(j.B), arr2));
            stringBuilder.append(str);
            stringBuilder.append(String.format(context.getString(j.A), arr));
            textInputLayout.setError(stringBuilder.toString());
            this.b.e();
        }
    }

    class b implements Runnable {

        final long a;
        final com.google.android.material.datepicker.d b;
        b(com.google.android.material.datepicker.d d, long l2) {
            this.b = d;
            this.a = l2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object[] arr = new Object[1];
            d.a(this.b).setError(String.format(d.c(this.b), f.a(this.a)));
            this.b.e();
        }
    }
    d(String string, DateFormat dateFormat2, TextInputLayout textInputLayout3, com.google.android.material.datepicker.a a4) {
        super();
        this.b = dateFormat2;
        this.a = textInputLayout3;
        this.c = a4;
        this.v = textInputLayout3.getContext().getString(j.D);
        d.a obj2 = new d.a(this, string);
        this.w = obj2;
    }

    static TextInputLayout a(com.google.android.material.datepicker.d d) {
        return d.a;
    }

    static DateFormat b(com.google.android.material.datepicker.d d) {
        return d.b;
    }

    static String c(com.google.android.material.datepicker.d d) {
        return d.v;
    }

    private Runnable d(long l) {
        d.b bVar = new d.b(this, l, obj3);
        return bVar;
    }

    @Override // com.google.android.material.internal.k
    abstract void e();

    @Override // com.google.android.material.internal.k
    abstract void f(Long long);

    @Override // com.google.android.material.internal.k
    public void g(View view, Runnable runnable2) {
        view.postDelayed(runnable2, 1000);
    }

    @Override // com.google.android.material.internal.k
    public void onTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
        Runnable obj1;
        TextInputLayout obj2;
        boolean obj4;
        this.a.removeCallbacks(this.w);
        this.a.removeCallbacks(this.x);
        int obj3 = 0;
        this.a.setError(obj3);
        f(obj3);
        if (TextUtils.isEmpty(charSequence)) {
        }
        obj1 = this.b.parse(charSequence.toString());
        this.a.setError(obj3);
        obj2 = obj1.getTime();
        if (this.c.f().g1(obj2) && this.c.l(obj2)) {
            if (this.c.l(obj2)) {
                f(Long.valueOf(obj1.getTime()));
            }
        }
        obj1 = d(obj2);
        this.x = obj1;
        g(this.a, obj1);
    }
}
