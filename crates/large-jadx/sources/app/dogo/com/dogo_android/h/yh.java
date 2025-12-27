package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.u.j;

/* compiled from: LayoutBitingProgramUnlockCertificateBinding.java */
/* loaded from: classes.dex */
public abstract class yh extends ViewDataBinding {

    public final ImageView O;
    protected SpecialProgramOverviewItem.CertificateData P;
    protected j Q;
    protected yh(Object object, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, ImageView imageView3, TextView textView2) {
        super(object, view, i);
        this.O = imageView2;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(j jVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(SpecialProgramOverviewItem.CertificateData certificateData);
}
