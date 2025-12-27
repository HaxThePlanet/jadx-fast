package app.dogo.com.dogo_android.util.k0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.i0;
import androidx.databinding.a;

/* compiled from: TopBarManager.java */
/* loaded from: classes.dex */
public abstract class g extends a {
    @Override // androidx.databinding.a
    public int getBackArrowColorRes(View view) {
        return getTextColorRes(view);
    }

    @Override // androidx.databinding.a
    public Drawable getBackIconDrawableRes(View view) throws android.content.res.Resources.NotFoundException {
        return view.getResources().getDrawable(2131231058, null);
    }

    @Override // androidx.databinding.a
    public int getBackgroundColorRes(View view) throws android.content.res.Resources.NotFoundException {
        return view.getResources().getColor(2131100379, null);
    }

    @Override // androidx.databinding.a
    public float getElevationDimension(View view) throws android.content.res.Resources.NotFoundException {
        return view.getResources().getDimension(2131165897);
    }

    @Override // androidx.databinding.a
    public int getPopUpMenu() {
        throw new UnsupportedOperationException("need to implement topBarManagers 'getPopUpMenu' method, that supplies teh menu options");
    }

    @Override // androidx.databinding.a
    public int getTextColorRes(View view) throws android.content.res.Resources.NotFoundException {
        return view.getResources().getColor(2131099767, null);
    }

    @Override // androidx.databinding.a
    public void onAction() {
        throw new UnsupportedOperationException("no action defined, overwrite onAction() method");
    }

    @Override // androidx.databinding.a
    public void onBlockAction() {
        throw new UnsupportedOperationException("no block action defined, overwrite onBlockAction() method");
    }

    @Override // androidx.databinding.a
    public boolean onMenuItemClick(MenuItem menuItem) {
        throw new UnsupportedOperationException("need to implement topBarManagers 'onMenuItemClick' method");
    }

    @Override // androidx.databinding.a
    public void onMoreAction(Context context, View view) {
        final i0 i0Var = new i0(context, view);
        i0Var.b().inflate(getPopUpMenu(), i0Var.a());
        i0Var.e(new app.dogo.com.dogo_android.util.interfaces.a(this));
        i0Var.f();
    }

    @Override // androidx.databinding.a
    public String getActionName() {
        return null;
    }

    @Override // androidx.databinding.a
    public abstract String getTitle();

    @Override // androidx.databinding.a
    public abstract boolean isBackVisible();

    @Override // androidx.databinding.a
    public boolean isBlockVisible() {
        return false;
    }

    @Override // androidx.databinding.a
    public boolean isFlagVisible() {
        return false;
    }

    @Override // androidx.databinding.a
    public boolean isMoreActionVisible() {
        return false;
    }

    @Override // androidx.databinding.a
    public abstract void onBack();
}
