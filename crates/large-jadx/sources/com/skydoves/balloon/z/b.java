package com.skydoves.balloon.z;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.skydoves.balloon.overlay.BalloonAnchorOverlayView;
import com.skydoves.balloon.v;
import java.util.Objects;

/* compiled from: LayoutBalloonOverlayLibrarySkydovesBinding.java */
/* loaded from: classes2.dex */
public final class b {

    private final BalloonAnchorOverlayView a;
    public final BalloonAnchorOverlayView b;
    private b(BalloonAnchorOverlayView balloonAnchorOverlayView, BalloonAnchorOverlayView balloonAnchorOverlayView2) {
        super();
        this.a = balloonAnchorOverlayView;
        this.b = balloonAnchorOverlayView2;
    }

    public static b a(View view) {
        Objects.requireNonNull(view, "rootView");
        return new b(view, view);
    }

    public static b c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(v.b, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return b.a(inflate);
    }

    public BalloonAnchorOverlayView b() {
        return this.a;
    }
}
