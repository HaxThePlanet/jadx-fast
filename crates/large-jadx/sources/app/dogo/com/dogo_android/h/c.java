package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.dogcreation.g;

/* compiled from: ActivityDogCreationBinding.java */
/* loaded from: classes.dex */
public abstract class c extends ViewDataBinding {

    public final FrameLayout O;
    protected c(Object object, View view, int i, FrameLayout frameLayout) {
        super(object, view, i);
        this.O = frameLayout;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(g gVar);
}
