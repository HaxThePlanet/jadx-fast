package androidx.databinding.k;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import androidx.databinding.g;

/* loaded from: classes.dex */
public class f {

    static class a implements NumberPicker.OnValueChangeListener {

        final NumberPicker.OnValueChangeListener a;
        final g b;
        a(NumberPicker.OnValueChangeListener numberPicker$OnValueChangeListener, g g2) {
            this.a = onValueChangeListener;
            this.b = g2;
            super();
        }

        @Override // android.widget.NumberPicker$OnValueChangeListener
        public void onValueChange(NumberPicker numberPicker, int i2, int i3) {
            final NumberPicker.OnValueChangeListener num = this.a;
            if (num != null) {
                num.onValueChange(numberPicker, i2, i3);
            }
            this.b.a();
        }
    }
    public static void a(NumberPicker numberPicker, NumberPicker.OnValueChangeListener numberPicker$OnValueChangeListener2, g g3) {
        androidx.databinding.k.f.a aVar;
        if (g3 == null) {
            numberPicker.setOnValueChangedListener(onValueChangeListener2);
        } else {
            aVar = new f.a(onValueChangeListener2, g3);
            numberPicker.setOnValueChangedListener(aVar);
        }
    }

    public static void b(NumberPicker numberPicker, int i2) {
        if (numberPicker.getValue() != i2) {
            numberPicker.setValue(i2);
        }
    }
}
