package androidx.databinding.k;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.databinding.g;

/* loaded from: classes.dex */
public class a {

    static class a implements CompoundButton.OnCheckedChangeListener {

        final CompoundButton.OnCheckedChangeListener a;
        final g b;
        a(CompoundButton.OnCheckedChangeListener compoundButton$OnCheckedChangeListener, g g2) {
            this.a = onCheckedChangeListener;
            this.b = g2;
            super();
        }

        @Override // android.widget.CompoundButton$OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            final CompoundButton.OnCheckedChangeListener list = this.a;
            if (list != null) {
                list.onCheckedChanged(compoundButton, z2);
            }
            this.b.a();
        }
    }
    public static void a(CompoundButton compoundButton, boolean z2) {
        if (compoundButton.isChecked() != z2) {
            compoundButton.setChecked(z2);
        }
    }

    public static void b(CompoundButton compoundButton, CompoundButton.OnCheckedChangeListener compoundButton$OnCheckedChangeListener2, g g3) {
        androidx.databinding.k.a.a aVar;
        if (g3 == null) {
            compoundButton.setOnCheckedChangeListener(onCheckedChangeListener2);
        } else {
            aVar = new a.a(onCheckedChangeListener2, g3);
            compoundButton.setOnCheckedChangeListener(aVar);
        }
    }
}
