package app.dogo.com.dogo_android.util.f0;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import app.dogo.com.dogo_android.inappmessaging.OneTenRadioGroup;

/* loaded from: classes.dex */
public final class d implements RadioGroup.OnCheckedChangeListener {

    public final ImageView a;
    public final OneTenRadioGroup b;
    public final Button c;
    public d(ImageView imageView, OneTenRadioGroup oneTenRadioGroup2, Button button3) {
        super();
        this.a = imageView;
        this.b = oneTenRadioGroup2;
        this.c = button3;
    }

    @Override // android.widget.RadioGroup$OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
        n.o(this.a, this.b, this.c, radioGroup, i2);
    }
}
