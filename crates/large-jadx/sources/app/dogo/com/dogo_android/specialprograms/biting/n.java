package app.dogo.com.dogo_android.u.m;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.google.android.material.appbar.MaterialToolbar;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h0.g;

/* compiled from: BitingProgramOverviewFragment.kt */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a<\u0010\u000b\u001a\u00020\u0001*\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¨\u0006\u0010", d2 = {"setupSpecialProgramOverviewTitleScrollAnimation", "", "programTitle", "Landroid/view/View;", "topAppBar", "Lcom/google/android/material/appbar/MaterialToolbar;", "toolbarTopSpacer", "toolbarTitle", "scrollY", "", "oldScrollY", "setupSpecialProgramOverviewToolbarScrollAnimation", "Landroidx/fragment/app/Fragment;", "programIconBackground", "toolBarIcon", "Landroid/widget/ImageView;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class n {
    /* renamed from: a, reason: from kotlin metadata */
    public static final void setupSpecialProgramOverviewTitleScrollAnimation(View programTitle, MaterialToolbar topAppBar, View toolbarTopSpacer, View toolbarTitle, int scrollY, int oldScrollY) {
        int toolbarTopSpacer2;
        n.f(programTitle, "programTitle");
        n.f(topAppBar, "topAppBar");
        n.f(toolbarTopSpacer, "toolbarTopSpacer");
        n.f(toolbarTitle, "toolbarTitle");
        int measuredHeight2 = toolbarTopSpacer.getMeasuredHeight();
        int i2 = programTitle.getBottom() - (topAppBar.getMeasuredHeight() + measuredHeight2);
        int i3 = programTitle.getBottom() - measuredHeight2;
        toolbarTopSpacer2 = 1;
        toolbarTopSpacer2 = 0;
        int r2 = toolbarTopSpacer2;
        int r3 = toolbarTopSpacer2;
        if (oldScrollY > i3 || i3 > scrollY) {
        }
        if (toolbarTopSpacer2 != 0) {
            float f = 0.0f;
            toolbarTitle.setAlpha(f);
        } else {
            if (toolbarTopSpacer2 != 0) {
                i = scrollY - i2;
                f2 = (float)(i3 - i2);
                f = (float)i / f2;
                toolbarTitle.setAlpha(f);
            } else {
                if (toolbarTopSpacer2 != 0) {
                    f = 1f;
                    toolbarTitle.setAlpha(f);
                }
            }
        }
    }

    public static final void b(Fragment fragment, View view, MaterialToolbar materialToolbar, View view2, ImageView imageView, int i, int i2) throws android.content.res.Resources.NotFoundException {
        int i3;
        n.f(fragment, "<this>");
        n.f(view, "programIconBackground");
        n.f(materialToolbar, "topAppBar");
        n.f(view2, "toolbarTopSpacer");
        i = materialToolbar.getMeasuredHeight() + view2.getMeasuredHeight();
        int bottom = view.getBottom();
        int i5 = bottom - i;
        float dimension = fragment.getResources().getDimension(2131165631);
        int i9 = a.d(fragment.requireContext(), 2131100379);
        int i11 = a.d(fragment.requireContext(), 2131100375);
        i3 = a.d(fragment.requireContext(), 2131099767);
        i2 = 1;
        i2 = 0;
        int r7 = i2;
        int r8 = i2;
        if (i2 > bottom || i < bottom) {
        }
        float f3 = 0.0f;
        if (i2 != 0) {
            materialToolbar.setBackgroundColor(i11);
            view2.setBackgroundColor(i11);
            materialToolbar.setElevation(0.0f);
            view2.setElevation(0.0f);
            materialToolbar.setNavigationIconTint(i9);
            if (imageView != null) {
                imageView.setImageTintList(ColorStateList.valueOf(i9));
            }
        } else {
            if (i2 != 0) {
                int i17 = 255;
                int i16 = (i - i5) * i17 / i;
                int argb = Color.argb(g.e(i16, i17), i17, i17, i17);
                f = (float)i16 / 255f;
                i3 = a.b(i9, i3, f);
                materialToolbar.setBackgroundColor(argb);
                view2.setBackgroundColor(argb);
                materialToolbar.setNavigationIconTint(i3);
                if (imageView != null) {
                    imageView.setImageTintList(ColorStateList.valueOf(i3));
                }
                materialToolbar.setElevation(0.0f);
                view2.setElevation(0.0f);
            } else {
                if (i2 != 0) {
                    materialToolbar.setBackgroundColor(i9);
                    view2.setBackgroundColor(i9);
                    materialToolbar.setNavigationIconTint(i3);
                    if (imageView != null) {
                        imageView.setImageTintList(ColorStateList.valueOf(i3));
                    }
                    materialToolbar.setElevation(dimension);
                    view2.setElevation(dimension);
                }
            }
        }
    }
}
