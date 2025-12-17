package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import f.c.a.e.h;
import f.c.a.e.j;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes2.dex */
class h extends BaseAdapter {

    private static final int v = 1;
    private final Calendar a;
    private final int b;
    private final int c;
    static {
        if (Build.VERSION.SDK_INT >= 26) {
            int i = 4;
        }
        int i2 = 1;
    }

    public h() {
        super();
        Calendar calendar = u.q();
        this.a = calendar;
        this.b = calendar.getMaximum(7);
        this.c = calendar.getFirstDayOfWeek();
    }

    private int b(int i) {
        int obj2;
        i += i2;
        int i3 = this.b;
        if (obj2 > i3) {
            obj2 -= i3;
        }
        return obj2;
    }

    @Override // android.widget.BaseAdapter
    public Integer a(int i) {
        if (i >= this.b) {
            return null;
        }
        return Integer.valueOf(b(i));
    }

    @Override // android.widget.BaseAdapter
    public int getCount() {
        return this.b;
    }

    @Override // android.widget.BaseAdapter
    public Object getItem(int i) {
        return a(i);
    }

    @Override // android.widget.BaseAdapter
    public long getItemId(int i) {
        return 0;
    }

    @Override // android.widget.BaseAdapter
    public View getView(int i, View view2, ViewGroup viewGroup3) {
        View view;
        View obj7;
        view = view2;
        final int i3 = 0;
        if (view2 == null) {
            view = obj7;
        }
        final int i4 = 7;
        this.a.set(i4, b(i));
        view.setText(this.a.getDisplayName(i4, h.v, obj6.locale));
        obj7 = new Object[1];
        obj7[i3] = this.a.getDisplayName(i4, 2, Locale.getDefault());
        view.setContentDescription(String.format(viewGroup3.getContext().getString(j.y), obj7));
        return view;
    }
}
