package com.skydoves.balloon.z;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.skydoves.balloon.radius.RadiusLayout;
import com.skydoves.balloon.u;
import com.skydoves.balloon.v;
import com.skydoves.balloon.vectortext.VectorTextView;

/* compiled from: LayoutBalloonLibrarySkydovesBinding.java */
/* loaded from: classes2.dex */
public final class a {

    private final FrameLayout a;
    public final FrameLayout b;
    public final AppCompatImageView c;
    public final RadiusLayout d;
    public final FrameLayout e;
    public final VectorTextView f;
    public final FrameLayout g;
    private a(FrameLayout frameLayout, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, RadiusLayout radiusLayout, FrameLayout frameLayout3, VectorTextView vectorTextView, FrameLayout frameLayout4) {
        super();
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = appCompatImageView;
        this.d = radiusLayout;
        this.e = frameLayout3;
        this.f = vectorTextView;
        this.g = frameLayout4;
    }

    public static a a(View view) throws android.content.res.Resources.NotFoundException {
        int i;
        final FrameLayout view3 = view;
        final Object obj5 = view.findViewById(u.a);
        if (obj5 == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        } else {
            obj = view.findViewById(u.b);
            if (obj != null) {
                obj2 = view.findViewById(u.c);
                if (obj2 != null) {
                    obj3 = view.findViewById(u.d);
                    if (obj3 != null) {
                        obj4 = view.findViewById(u.e);
                        if (obj4 != null) {
                            a view2 = new a(view3, view3, obj5, obj, obj2, obj3, obj4);
                            return view2;
                        }
                    }
                }
            }
        }
    }

    public static a c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(v.a, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a.a(inflate);
    }

    public FrameLayout b() {
        return this.a;
    }
}
