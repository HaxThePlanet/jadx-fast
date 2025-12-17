package androidx.databinding.k;

import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import androidx.databinding.g;
import androidx.databinding.library.baseAdapters.a;

/* loaded from: classes.dex */
public class c {

    static class a {
    }

    private static class b implements DatePicker.OnDateChangedListener {

        DatePicker.OnDateChangedListener a;
        g b;
        g c;
        g d;
        b(androidx.databinding.k.c.a c$a) {
            super();
        }

        @Override // android.widget.DatePicker$OnDateChangedListener
        public void a(DatePicker.OnDateChangedListener datePicker$OnDateChangedListener, g g2, g g3, g g4) {
            this.a = onDateChangedListener;
            this.b = g2;
            this.c = g3;
            this.d = g4;
        }

        @Override // android.widget.DatePicker$OnDateChangedListener
        public void onDateChanged(DatePicker datePicker, int i2, int i3, int i4) {
            final DatePicker.OnDateChangedListener list = this.a;
            if (list != null) {
                list.onDateChanged(datePicker, i2, i3, i4);
            }
            g obj2 = this.b;
            if (obj2 != null) {
                obj2.a();
            }
            obj2 = this.c;
            if (obj2 != null) {
                obj2.a();
            }
            obj2 = this.d;
            if (obj2 != null) {
                obj2.a();
            }
        }
    }
    public static void a(DatePicker datePicker, int i2, int i3, int i4, DatePicker.OnDateChangedListener datePicker$OnDateChangedListener5, g g6, g g7, g g8) {
        int i5;
        Object bVar;
        int i;
        int obj4;
        int obj6;
        if (i2 == 0) {
            obj4 = datePicker.getYear();
        }
        if (i4 == 0) {
            obj6 = datePicker.getDayOfMonth();
        }
        if (g6 == null && g7 == null && g8 == null) {
            if (g7 == null) {
                if (g8 == null) {
                    datePicker.init(obj4, i3, obj6, onDateChangedListener5);
                } else {
                    i5 = a.a;
                    if ((c.b)e.a(datePicker, i5) == null) {
                        bVar = new c.b(0);
                        e.b(datePicker, bVar, i5);
                    }
                    bVar.a(onDateChangedListener5, g6, g7, g8);
                    datePicker.init(obj4, i3, obj6, bVar);
                }
            } else {
            }
        } else {
        }
    }
}
