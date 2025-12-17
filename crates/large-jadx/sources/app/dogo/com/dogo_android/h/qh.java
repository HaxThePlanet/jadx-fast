package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.u.j;

/* loaded from: classes.dex */
public abstract class qh extends ViewDataBinding {

    public final ImageView O;
    public final Button P;
    protected SpecialProgramOverviewItem.CertificateData Q;
    protected j R;
    protected qh(Object object, View view2, int i3, Barrier barrier4, TextView textView5, ImageView imageView6, ImageView imageView7, Guideline guideline8, Guideline guideline9, Button button10, TextView textView11) {
        super(object, view2, i3);
        this.O = imageView6;
        this.P = button10;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(j j);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(SpecialProgramOverviewItem.CertificateData specialProgramOverviewItem$CertificateData);
}
