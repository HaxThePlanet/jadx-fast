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

/* compiled from: LayoutBitingProgramCertificateBinding.java */
/* loaded from: classes.dex */
public abstract class qh extends ViewDataBinding {

    public final ImageView O;
    public final Button P;
    protected SpecialProgramOverviewItem.CertificateData Q;
    protected j R;
    protected qh(Object object, View view, int i, Barrier barrier, TextView textView, ImageView imageView, ImageView imageView2, Guideline guideline, Guideline guideline2, Button button, TextView textView2) {
        super(object, view, i);
        this.O = imageView;
        this.P = button;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(j jVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(SpecialProgramOverviewItem.CertificateData certificateData);
}
