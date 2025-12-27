package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.view.dailytraining.ClickerSoundMaterialButton;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentClickerBinding.java */
/* loaded from: classes.dex */
public abstract class ka extends ViewDataBinding {

    public final ClickerSoundMaterialButton O;
    public final ConstraintLayout P;
    public final ImageView Q;
    public final MaterialToolbar R;
    protected ka(Object object, View view, int i, Guideline guideline, Guideline guideline2, ClickerSoundMaterialButton clickerSoundMaterialButton, ConstraintLayout constraintLayout, Guideline guideline3, ImageView imageView, ImageView imageView2, Guideline guideline4, Guideline guideline5, ImageView imageView3, AppBarLayout appBarLayout, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = clickerSoundMaterialButton;
        this.P = constraintLayout;
        this.Q = imageView2;
        this.R = materialToolbar;
    }

    public static ka T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ka.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ka U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ka)ViewDataBinding.z(layoutInflater, 2131558633, viewGroup, z, object);
    }
}
