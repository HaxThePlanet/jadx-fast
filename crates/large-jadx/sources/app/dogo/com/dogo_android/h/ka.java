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

/* loaded from: classes.dex */
public abstract class ka extends ViewDataBinding {

    public final ClickerSoundMaterialButton O;
    public final ConstraintLayout P;
    public final ImageView Q;
    public final MaterialToolbar R;
    protected ka(Object object, View view2, int i3, Guideline guideline4, Guideline guideline5, ClickerSoundMaterialButton clickerSoundMaterialButton6, ConstraintLayout constraintLayout7, Guideline guideline8, ImageView imageView9, ImageView imageView10, Guideline guideline11, Guideline guideline12, ImageView imageView13, AppBarLayout appBarLayout14, MaterialToolbar materialToolbar15) {
        super(object, view2, i3);
        this.O = clickerSoundMaterialButton6;
        this.P = constraintLayout7;
        this.Q = imageView10;
        this.R = materialToolbar15;
    }

    public static app.dogo.com.dogo_android.h.ka T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ka.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ka U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ka)ViewDataBinding.z(layoutInflater, 2131558633, viewGroup2, z3, object4);
    }
}
