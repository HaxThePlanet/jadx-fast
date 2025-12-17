package com.skydoves.balloon.z;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.skydoves.balloon.overlay.BalloonAnchorOverlayView;
import com.skydoves.balloon.v;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class b {

    private final BalloonAnchorOverlayView a;
    public final BalloonAnchorOverlayView b;
    private b(BalloonAnchorOverlayView balloonAnchorOverlayView, BalloonAnchorOverlayView balloonAnchorOverlayView2) {
        super();
        this.a = balloonAnchorOverlayView;
        this.b = balloonAnchorOverlayView2;
    }

    public static com.skydoves.balloon.z.b a(View view) {
        Objects.requireNonNull(view, "rootView");
        b bVar = new b((BalloonAnchorOverlayView)view, view);
        return bVar;
    }

    public static com.skydoves.balloon.z.b c(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        View obj2 = layoutInflater.inflate(v.b, viewGroup2, false);
        if (z3) {
            viewGroup2.addView(obj2);
        }
        return b.a(obj2);
    }

    public BalloonAnchorOverlayView b() {
        return this.a;
    }
}
