package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.u.j;

/* loaded from: classes.dex */
public abstract class yh extends ViewDataBinding {

    public final ImageView O;
    protected SpecialProgramOverviewItem.CertificateData P;
    protected j Q;
    protected yh(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, TextView textView6, ImageView imageView7, TextView textView8) {
        super(object, view2, i3);
        this.O = imageView5;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(j j);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(SpecialProgramOverviewItem.CertificateData specialProgramOverviewItem$CertificateData);
}
