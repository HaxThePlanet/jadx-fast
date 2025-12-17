package app.dogo.com.dogo_android.util.k0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.i0;
import androidx.databinding.a;

/* loaded from: classes.dex */
public abstract class g extends a {
    @Override // androidx.databinding.a
    public String getActionName() {
        return null;
    }

    @Override // androidx.databinding.a
    public int getBackArrowColorRes(View view) {
        return getTextColorRes(view);
    }

    @Override // androidx.databinding.a
    public Drawable getBackIconDrawableRes(View view) {
        return view.getResources().getDrawable(2131231058, 0);
    }

    @Override // androidx.databinding.a
    public int getBackgroundColorRes(View view) {
        return view.getResources().getColor(2131100379, 0);
    }

    @Override // androidx.databinding.a
    public float getElevationDimension(View view) {
        return view.getResources().getDimension(2131165897);
    }

    @Override // androidx.databinding.a
    public int getPopUpMenu() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("need to implement topBarManagers 'getPopUpMenu' method, that supplies teh menu options");
        throw unsupportedOperationException;
    }

    @Override // androidx.databinding.a
    public int getTextColorRes(View view) {
        return view.getResources().getColor(2131099767, 0);
    }

    @Override // androidx.databinding.a
    public abstract String getTitle();

    @Override // androidx.databinding.a
    public abstract boolean isBackVisible();

    @Override // androidx.databinding.a
    public boolean isBlockVisible() {
        return 0;
    }

    @Override // androidx.databinding.a
    public boolean isFlagVisible() {
        return 0;
    }

    @Override // androidx.databinding.a
    public boolean isMoreActionVisible() {
        return 0;
    }

    @Override // androidx.databinding.a
    public void onAction() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("no action defined, overwrite onAction() method");
        throw unsupportedOperationException;
    }

    @Override // androidx.databinding.a
    public abstract void onBack();

    @Override // androidx.databinding.a
    public void onBlockAction() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("no block action defined, overwrite onBlockAction() method");
        throw unsupportedOperationException;
    }

    @Override // androidx.databinding.a
    public boolean onMenuItemClick(MenuItem menuItem) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("need to implement topBarManagers 'onMenuItemClick' method");
        throw obj2;
    }

    @Override // androidx.databinding.a
    public void onMoreAction(Context context, View view2) {
        i0 i0Var = new i0(context, view2);
        i0Var.b().inflate(getPopUpMenu(), i0Var.a());
        a obj3 = new a(this);
        i0Var.e(obj3);
        i0Var.f();
    }
}
