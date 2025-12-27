package com.yuyakaido.android.cardstackview.i;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.yuyakaido.android.cardstackview.b;
import com.yuyakaido.android.cardstackview.e;
import com.yuyakaido.android.cardstackview.e.b;
import com.yuyakaido.android.cardstackview.f;
import com.yuyakaido.android.cardstackview.g;
import com.yuyakaido.android.cardstackview.g.b;
import com.yuyakaido.android.cardstackview.h;
import java.util.List;

/* compiled from: CardStackSetting.java */
/* loaded from: classes2.dex */
public class c {

    public f a;
    public int b = 3;
    public float c = 8f;
    public float d = 0.95f;
    public float e = 0.3f;
    public float f = 20f;
    public List<b> g;
    public boolean h = true;
    public boolean i = true;
    public h j;
    public g k;
    public e l;
    public Interpolator m = new LinearInterpolator();
    public c() {
        super();
        this.a = f.None;
        this.g = b.HORIZONTAL;
        this.j = h.AutomaticAndManual;
        this.k = new g.b().a();
        this.l = new e.b().a();
        LinearInterpolator linearInterpolator = new LinearInterpolator();
    }
}
