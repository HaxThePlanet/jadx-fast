package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import f.c.a.e.h;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
class n extends BaseAdapter {

    static final int x;
    final com.google.android.material.datepicker.m a;
    final com.google.android.material.datepicker.e<?> b;
    private Collection<Long> c;
    com.google.android.material.datepicker.c v;
    final com.google.android.material.datepicker.a w;
    static {
        n.x = u.q().getMaximum(4);
    }

    n(com.google.android.material.datepicker.m m, com.google.android.material.datepicker.e<?> e2, com.google.android.material.datepicker.a a3) {
        super();
        this.a = m;
        this.b = e2;
        this.w = a3;
        this.c = e2.t1();
    }

    private void e(Context context) {
        com.google.android.material.datepicker.c cVar;
        if (this.v == null) {
            cVar = new c(context);
            this.v = cVar;
        }
    }

    private boolean h(long l) {
        int cmp;
        long l2;
        Iterator iterator = this.b.t1().iterator();
        for (Long next2 : iterator) {
        }
        return 0;
    }

    private void k(TextView textView, long l2) {
        long timeInMillis;
        com.google.android.material.datepicker.b obj4;
        if (textView == null) {
        }
        if (this.w.f().g1(l2)) {
            textView.setEnabled(true);
            obj4 = h(l2) ? obj4.b : obj4 == null ? obj4.c : obj4.a;
        } else {
            textView.setEnabled(false);
            obj4 = obj4.g;
        }
        obj4.d(textView);
    }

    private void l(com.google.android.material.datepicker.MaterialCalendarGridView materialCalendarGridView, long l2) {
        boolean equals;
        com.google.android.material.datepicker.m firstVisiblePosition;
        View obj3;
        if (m.e(l2).equals(this.a)) {
            k((TextView)materialCalendarGridView.getChildAt(i2 -= firstVisiblePosition), l2);
        }
    }

    @Override // android.widget.BaseAdapter
    int a(int i) {
        return i2 += obj2;
    }

    @Override // android.widget.BaseAdapter
    int b() {
        return this.a.i();
    }

    @Override // android.widget.BaseAdapter
    public Long c(int i) {
        int i2;
        if (i >= this.a.i() && i > i()) {
            if (i > i()) {
            }
            return Long.valueOf(this.a.j(j(i)));
        }
        return null;
    }

    @Override // android.widget.BaseAdapter
    public TextView d(int i, View view2, ViewGroup viewGroup3) {
        View view;
        int i3;
        int i4;
        int i2;
        View obj7;
        Object obj8;
        e(viewGroup3.getContext());
        view = view2;
        final int i6 = 0;
        if (view2 == null) {
            view = obj7;
        }
        obj7 = i - obj7;
        if (obj7 >= 0) {
            obj8 = this.a;
            if (obj7 >= obj8.w) {
                view.setVisibility(8);
                view.setEnabled(i6);
            } else {
                i3 = 1;
                obj7 += i3;
                view.setTag(obj8);
                Object[] arr = new Object[i3];
                arr[i6] = Integer.valueOf(obj7);
                view.setText(String.format(obj8.locale, "%d", arr));
                obj8 = this.a;
                obj7 = obj8.j(obj7);
                if (mVar.c == mVar2.c) {
                    view.setContentDescription(f.e(obj7));
                } else {
                    view.setContentDescription(f.j(obj7));
                }
                view.setVisibility(i6);
                view.setEnabled(i3);
            }
        } else {
        }
        Long obj6 = c(i);
        if (obj6 == null) {
            return view;
        }
        k(view, obj6.longValue());
        return view;
    }

    @Override // android.widget.BaseAdapter
    boolean f(int i) {
        int obj2;
        obj2 = i %= i2 == 0 ? 1 : 0;
        return obj2;
    }

    @Override // android.widget.BaseAdapter
    boolean g(int i) {
        int i2;
        if (obj3 %= i3 == 0) {
        } else {
            i2 = 0;
        }
        return i2;
    }

    @Override // android.widget.BaseAdapter
    public int getCount() {
        return i += i3;
    }

    @Override // android.widget.BaseAdapter
    public Object getItem(int i) {
        return c(i);
    }

    @Override // android.widget.BaseAdapter
    public long getItemId(int i) {
        return (long)obj3;
    }

    @Override // android.widget.BaseAdapter
    public View getView(int i, View view2, ViewGroup viewGroup3) {
        return d(i, view2, viewGroup3);
    }

    @Override // android.widget.BaseAdapter
    public boolean hasStableIds() {
        return 1;
    }

    @Override // android.widget.BaseAdapter
    int i() {
        return i2--;
    }

    @Override // android.widget.BaseAdapter
    int j(int i) {
        return obj2++;
    }

    @Override // android.widget.BaseAdapter
    public void m(com.google.android.material.datepicker.MaterialCalendarGridView materialCalendarGridView) {
        Object iterator;
        long longValue2;
        boolean longValue;
        Object obj4;
        Iterator iterator2 = this.c.iterator();
        for (Long next2 : iterator2) {
            l(materialCalendarGridView, next2.longValue());
        }
        iterator = this.b;
        if (iterator != null) {
            iterator = iterator.t1().iterator();
            for (Long next : iterator) {
                l(materialCalendarGridView, next.longValue());
            }
            this.c = this.b.t1();
        }
    }

    @Override // android.widget.BaseAdapter
    boolean n(int i) {
        int i2;
        int obj2;
        if (i >= b() && i <= i()) {
            obj2 = i <= i() ? 1 : 0;
        } else {
        }
        return obj2;
    }
}
