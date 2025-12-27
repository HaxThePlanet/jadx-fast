package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: LayoutChallengeCommentDeleteReportBinding.java */
/* loaded from: classes.dex */
public abstract class ai extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    protected ai(Object object, View view, int i, AppCompatImageView appCompatImageView, TextView textView, TextView textView2) {
        super(object, view, i);
        this.O = textView;
        this.P = textView2;
    }

    public static ai T(LayoutInflater layoutInflater) {
        return ai.U(layoutInflater, f.e());
    }

    @Deprecated
    public static ai U(LayoutInflater layoutInflater, Object object) {
        return (ai)ViewDataBinding.z(layoutInflater, 2131558742, null, false, object);
    }
}
