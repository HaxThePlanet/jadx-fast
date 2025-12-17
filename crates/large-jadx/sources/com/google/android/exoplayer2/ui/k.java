package com.google.android.exoplayer2.ui;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes2.dex */
public final class k {

    public static final com.google.android.exoplayer2.ui.k g;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final Typeface f;
    static {
        super(-1, -16777216, 0, 0, -1, 0);
        k.g = kVar2;
    }

    public k(int i, int i2, int i3, int i4, int i5, Typeface typeface6) {
        super();
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = typeface6;
    }

    public static com.google.android.exoplayer2.ui.k a(CaptioningManager.CaptionStyle captioningManager$CaptionStyle) {
        if (p0.a >= 21) {
            return k.c(captionStyle);
        }
        return k.b(captionStyle);
    }

    private static com.google.android.exoplayer2.ui.k b(CaptioningManager.CaptionStyle captioningManager$CaptionStyle) {
        super(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
        return kVar2;
    }

    private static com.google.android.exoplayer2.ui.k c(CaptioningManager.CaptionStyle captioningManager$CaptionStyle) {
        int foregroundColor;
        int backgroundColor;
        int windowColor;
        int edgeType;
        int edgeColor;
        foregroundColor = captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : kVar6.a;
        backgroundColor = captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : kVar5.b;
        windowColor = captionStyle.hasWindowColor() ? captionStyle.windowColor : kVar4.c;
        edgeType = captionStyle.hasEdgeType() ? captionStyle.edgeType : kVar.d;
        edgeColor = captionStyle.hasEdgeColor() ? captionStyle.edgeColor : kVar2.e;
        super(foregroundColor, backgroundColor, windowColor, edgeType, edgeColor, captionStyle.getTypeface());
        return kVar7;
    }
}
