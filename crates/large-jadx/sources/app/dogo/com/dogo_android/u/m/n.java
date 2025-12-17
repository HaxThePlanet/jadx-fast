package app.dogo.com.dogo_android.u.m;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.a;
import androidx.fragment.app.Fragment;
import com.google.android.material.appbar.MaterialToolbar;
import d.h.f.a;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h0.g;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a<\u0010\u000b\u001a\u00020\u0001*\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¨\u0006\u0010", d2 = {"setupSpecialProgramOverviewTitleScrollAnimation", "", "programTitle", "Landroid/view/View;", "topAppBar", "Lcom/google/android/material/appbar/MaterialToolbar;", "toolbarTopSpacer", "toolbarTitle", "scrollY", "", "oldScrollY", "setupSpecialProgramOverviewToolbarScrollAnimation", "Landroidx/fragment/app/Fragment;", "programIconBackground", "toolBarIcon", "Landroid/widget/ImageView;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class n {
    public static final void a(View view, MaterialToolbar materialToolbar2, View view3, View view4, int i5, int i6) {
        int i;
        int i2;
        int obj4;
        float obj5;
        int obj6;
        int obj8;
        n.f(view, "programTitle");
        n.f(materialToolbar2, "topAppBar");
        n.f(view3, "toolbarTopSpacer");
        n.f(view4, "toolbarTitle");
        obj6 = view3.getMeasuredHeight();
        bottom -= obj5;
        obj4 -= obj6;
        obj6 = 1;
        final int i4 = 0;
        if (i5 >= 0 && i5 <= i3) {
            i = i5 <= i3 ? obj6 : i4;
        } else {
        }
        if (i3 <= i5 && i5 <= obj4) {
            i2 = i5 <= obj4 ? obj6 : i4;
        } else {
        }
        if (i6 <= obj4 && obj4 <= i5) {
            if (obj4 <= i5) {
            } else {
                obj6 = i4;
            }
        } else {
        }
        if (i != 0) {
            view4.setAlpha(0);
        } else {
            if (i2 != 0) {
                view4.setAlpha(obj4 /= obj5);
            } else {
                if (obj6 != null) {
                    view4.setAlpha(1065353216);
                }
            }
        }
    }

    public static final void b(Fragment fragment, View view2, MaterialToolbar materialToolbar3, View view4, ImageView imageView5, int i6, int i7) {
        int i2;
        int i3;
        int i4;
        int i;
        int obj9;
        int obj14;
        int obj15;
        n.f(fragment, "<this>");
        n.f(view2, "programIconBackground");
        n.f(materialToolbar3, "topAppBar");
        n.f(view4, "toolbarTopSpacer");
        measuredHeight += measuredHeight2;
        int obj10 = view2.getBottom();
        int i8 = obj10 - i2;
        float dimension = fragment.getResources().getDimension(2131165631);
        int i10 = a.d(fragment.requireContext(), 2131100379);
        int i12 = a.d(fragment.requireContext(), 2131100375);
        obj9 = a.d(fragment.requireContext(), 2131099767);
        i3 = 1;
        final int i15 = 0;
        if (i6 >= 0 && i6 <= i8) {
            i4 = i6 <= i8 ? i3 : i15;
        } else {
        }
        if (i8 <= i6 && i6 <= obj10) {
            i = i6 <= obj10 ? i3 : i15;
        } else {
        }
        if (i7 <= obj10 && i6 >= obj10) {
            if (i6 >= obj10) {
            } else {
                i3 = i15;
            }
        } else {
        }
        obj10 = 0;
        if (i4 != 0) {
            materialToolbar3.setBackgroundColor(i12);
            view4.setBackgroundColor(i12);
            materialToolbar3.setElevation(obj10);
            view4.setElevation(obj10);
            materialToolbar3.setNavigationIconTint(i10);
            if (imageView5 == null) {
            } else {
                imageView5.setImageTintList(ColorStateList.valueOf(i10));
            }
        } else {
            if (i != 0) {
                obj15 = 255;
                obj14 /= i2;
                obj15 = Color.argb(g.e(obj14, obj15), obj15, obj15, obj15);
                obj9 = a.b(i10, obj9, obj14 /= i2);
                materialToolbar3.setBackgroundColor(obj15);
                view4.setBackgroundColor(obj15);
                materialToolbar3.setNavigationIconTint(obj9);
                if (imageView5 == null) {
                } else {
                    imageView5.setImageTintList(ColorStateList.valueOf(obj9));
                }
                materialToolbar3.setElevation(obj10);
                view4.setElevation(obj10);
            } else {
                if (i3 != 0) {
                    materialToolbar3.setBackgroundColor(i10);
                    view4.setBackgroundColor(i10);
                    materialToolbar3.setNavigationIconTint(obj9);
                    if (imageView5 == null) {
                    } else {
                        imageView5.setImageTintList(ColorStateList.valueOf(obj9));
                    }
                    materialToolbar3.setElevation(dimension);
                    view4.setElevation(dimension);
                }
            }
        }
    }
}
