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

/* loaded from: classes2.dex */
public class c {

    public f a;
    public int b = 3;
    public float c = 8f;
    public float d = 0.95f;
    public float e = 0.3f;
    public float f = 20f;
    public List<b> g = 1101004800;
    public boolean h = true;
    public boolean i = true;
    public h j = 1;
    public g k;
    public e l;
    public Interpolator m;
    public c() {
        super();
        this.a = f.None;
        int i = 3;
        int i2 = 1090519040;
        int i3 = 1064514355;
        int i4 = 1050253722;
        int i5 = 1101004800;
        List hORIZONTAL = b.HORIZONTAL;
        int i6 = 1;
        h automaticAndManual = h.AutomaticAndManual;
        g.b bVar = new g.b();
        this.k = bVar.a();
        e.b bVar2 = new e.b();
        this.l = bVar2.a();
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.m = linearInterpolator;
    }
}
