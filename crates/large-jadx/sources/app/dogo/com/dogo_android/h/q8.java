package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.d.e.e;

/* compiled from: DialogChallengeReportBinding.java */
/* loaded from: classes.dex */
public abstract class q8 extends ViewDataBinding {

    public final Button O;
    public final AppCompatEditText P;
    public final Button Q;
    protected e R;
    protected q8(Object object, View view, int i, Button button, AppCompatEditText appCompatEditText, Button button2, TextView textView) {
        super(object, view, i);
        this.O = button;
        this.P = appCompatEditText;
        this.Q = button2;
    }

    public static q8 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return q8.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static q8 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (q8)ViewDataBinding.z(layoutInflater, 2131558596, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e eVar);
}
