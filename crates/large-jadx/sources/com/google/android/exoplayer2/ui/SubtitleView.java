package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.text.k;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class SubtitleView extends FrameLayout implements k {

    private com.google.android.exoplayer2.ui.SubtitleView.a A;
    private View B;
    private List<c> a;
    private com.google.android.exoplayer2.ui.k b;
    private int c = 0;
    private float v = 0.0533f;
    private float w = 0.08f;
    private boolean x = true;
    private boolean y = true;
    private int z = 1;

    interface a {
        public abstract void a(List<c> list, com.google.android.exoplayer2.ui.k k2, float f3, int i4, float f5);
    }
    public SubtitleView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        this.a = Collections.emptyList();
        this.b = k.g;
        int obj3 = 0;
        obj3 = 1029329178;
        obj3 = 1034147594;
        obj3 = 1;
        j jVar = new j(context);
        this.A = jVar;
        this.B = jVar;
        addView(jVar);
    }

    private void C(int i, float f2) {
        this.c = i;
        this.v = f2;
        F();
    }

    private void F() {
        this.A.a(getCuesWithStylingPreferencesApplied(), this.b, this.v, this.c, this.w);
    }

    private List<c> getCuesWithStylingPreferencesApplied() {
        boolean z;
        int i;
        c cVar;
        if (this.x && this.y) {
            if (this.y) {
                return this.a;
            }
        }
        ArrayList arrayList = new ArrayList(this.a.size());
        i = 0;
        while (i < this.a.size()) {
            arrayList.add(t((c)this.a.get(i)));
            i++;
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        int systemService;
        int fontScale;
        int enabled;
        fontScale = 1065353216;
        if (p0.a >= 19) {
            if (isInEditMode()) {
            } else {
                systemService = getContext().getSystemService("captioning");
                if (systemService != null && (CaptioningManager)systemService.isEnabled()) {
                    if (systemService.isEnabled()) {
                        fontScale = systemService.getFontScale();
                    }
                }
            }
        }
        return fontScale;
    }

    private com.google.android.exoplayer2.ui.k getUserCaptionStyle() {
        com.google.android.exoplayer2.ui.k kVar;
        int inEditMode;
        String enabled;
        if (p0.a >= 19) {
            if (isInEditMode()) {
            } else {
                Object systemService = getContext().getSystemService("captioning");
                if (systemService != null && (CaptioningManager)systemService.isEnabled()) {
                    if (systemService.isEnabled()) {
                        kVar = k.a(systemService.getUserStyle());
                    } else {
                        kVar = k.g;
                    }
                } else {
                }
            }
            return kVar;
        }
        return k.g;
    }

    private <T extends View & com.google.android.exoplayer2.ui.SubtitleView.a> void setView(T t) {
        removeView(this.B);
        View view2 = this.B;
        if (view2 instanceof b0) {
            (b0)view2.g();
        }
        this.B = t;
        this.A = (SubtitleView.a)t;
        addView(t);
    }

    private c t(c c) {
        boolean z;
        c.b obj2 = c.a();
        if (!this.x) {
            y.c(obj2);
        } else {
            if (!this.y) {
                y.d(obj2);
            }
        }
        return obj2.a();
    }

    @Override // android.widget.FrameLayout
    public void B(float f, boolean z2) {
        C(z2, f);
    }

    @Override // android.widget.FrameLayout
    public void D() {
        setStyle(getUserCaptionStyle());
    }

    @Override // android.widget.FrameLayout
    public void E() {
        setFractionalTextSize(userCaptionFontScale *= i2);
    }

    @Override // android.widget.FrameLayout
    public void setApplyEmbeddedFontSizes(boolean z) {
        this.y = z;
        F();
    }

    @Override // android.widget.FrameLayout
    public void setApplyEmbeddedStyles(boolean z) {
        this.x = z;
        F();
    }

    @Override // android.widget.FrameLayout
    public void setBottomPaddingFraction(float f) {
        this.w = f;
        F();
    }

    public void setCues(List<c> list) {
        List obj1;
        if (list != null) {
        } else {
            obj1 = Collections.emptyList();
        }
        this.a = obj1;
        F();
    }

    @Override // android.widget.FrameLayout
    public void setFractionalTextSize(float f) {
        B(f, false);
    }

    @Override // android.widget.FrameLayout
    public void setStyle(com.google.android.exoplayer2.ui.k k) {
        this.b = k;
        F();
    }

    @Override // android.widget.FrameLayout
    public void setViewType(int i) {
        Object b0Var;
        Context context;
        if (this.z == i) {
        }
        if (i != 1) {
            if (i != 2) {
            } else {
                b0Var = new b0(getContext());
                setView(b0Var);
                this.z = i;
            }
            IllegalArgumentException obj3 = new IllegalArgumentException();
            throw obj3;
        }
        b0Var = new j(getContext());
        setView(b0Var);
    }

    public void u(List<c> list) {
        setCues(list);
    }
}
