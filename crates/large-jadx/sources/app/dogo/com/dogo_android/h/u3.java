package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellPottyOverviewNewReminderBinding.java */
/* loaded from: classes.dex */
public abstract class u3 extends ViewDataBinding {
    protected u3(Object object, View view, int i, AppCompatImageView appCompatImageView, TextView textView, AppCompatImageView appCompatImageView2) {
        super(object, view, i);
    }

    public static u3 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return u3.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static u3 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (u3)ViewDataBinding.z(layoutInflater, 2131558508, viewGroup, z, object);
    }
}
