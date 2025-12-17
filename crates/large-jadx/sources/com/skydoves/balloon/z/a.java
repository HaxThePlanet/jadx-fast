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

/* loaded from: classes2.dex */
public final class a {

    private final FrameLayout a;
    public final FrameLayout b;
    public final AppCompatImageView c;
    public final RadiusLayout d;
    public final FrameLayout e;
    public final VectorTextView f;
    public final FrameLayout g;
    private a(FrameLayout frameLayout, FrameLayout frameLayout2, AppCompatImageView appCompatImageView3, RadiusLayout radiusLayout4, FrameLayout frameLayout5, VectorTextView vectorTextView6, FrameLayout frameLayout7) {
        super();
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = appCompatImageView3;
        this.d = radiusLayout4;
        this.e = frameLayout5;
        this.f = vectorTextView6;
        this.g = frameLayout7;
    }

    public static com.skydoves.balloon.z.a a(View view) {
        int i;
        View viewById;
        View view3;
        View view4;
        View view2;
        View view5;
        final FrameLayout frameLayout2 = view;
        final View view6 = viewById;
        if ((AppCompatImageView)view6 == null) {
        } else {
            view3 = viewById;
            if ((RadiusLayout)view3 == null) {
            } else {
                view4 = viewById;
                if ((FrameLayout)view4 == null) {
                } else {
                    view2 = viewById;
                    if ((VectorTextView)view2 == null) {
                    } else {
                        view5 = viewById;
                        if ((FrameLayout)view5 == null) {
                        } else {
                            super((FrameLayout)frameLayout2, frameLayout2, (AppCompatImageView)view6, (RadiusLayout)view3, (FrameLayout)view4, (VectorTextView)view2, (FrameLayout)view5);
                            return obj8;
                        }
                    }
                }
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        throw nullPointerException;
    }

    public static com.skydoves.balloon.z.a c(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        View obj2 = layoutInflater.inflate(v.a, viewGroup2, false);
        if (z3) {
            viewGroup2.addView(obj2);
        }
        return a.a(obj2);
    }

    public FrameLayout b() {
        return this.a;
    }
}
