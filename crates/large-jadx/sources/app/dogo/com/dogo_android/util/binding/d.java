package app.dogo.com.dogo_android.util.f0;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import app.dogo.com.dogo_android.inappmessaging.OneTenRadioGroup;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements RadioGroup.OnCheckedChangeListener {

    public final /* synthetic */ ImageView a;
    public final /* synthetic */ OneTenRadioGroup b;
    public final /* synthetic */ Button c;
    public /* synthetic */ d(ImageView imageView, OneTenRadioGroup oneTenRadioGroup, Button button) {
        super();
        this.a = imageView;
        this.b = oneTenRadioGroup;
        this.c = button;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        BindingAdapters.d0(this.a, this.b, this.c, radioGroup, i);
    }
}
