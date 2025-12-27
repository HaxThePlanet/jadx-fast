package nl.dionsegijn.konfetti;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import nl.dionsegijn.konfetti.c.c;
import nl.dionsegijn.konfetti.d.a;

/* compiled from: KonfettiView.kt */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001:\u0001\u0006B\u001d\u0008\u0016\u0012\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0008\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\u0008!\u0010\"J\u0013\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0008H\u0014¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\u0008\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u000e\u0010\u001b¨\u0006#", d2 = {"Lnl/dionsegijn/konfetti/KonfettiView;", "Landroid/view/View;", "", "Lnl/dionsegijn/konfetti/b;", "getActiveSystems", "()Ljava/util/List;", "a", "()Lnl/dionsegijn/konfetti/b;", "Landroid/graphics/Canvas;", "canvas", "Lkotlin/w;", "onDraw", "(Landroid/graphics/Canvas;)V", "particleSystem", "b", "(Lnl/dionsegijn/konfetti/b;)V", "Ljava/util/List;", "systems", "Lnl/dionsegijn/konfetti/d/a;", "c", "Lnl/dionsegijn/konfetti/d/a;", "getOnParticleSystemUpdateListener", "()Lnl/dionsegijn/konfetti/d/a;", "setOnParticleSystemUpdateListener", "(Lnl/dionsegijn/konfetti/d/a;)V", "onParticleSystemUpdateListener", "Lnl/dionsegijn/konfetti/KonfettiView$a;", "Lnl/dionsegijn/konfetti/KonfettiView$a;", "timer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "konfetti_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public class KonfettiView extends View {

    /* renamed from: a, reason: from kotlin metadata */
    private final List<b> systems = new ArrayList<>();
    /* renamed from: b, reason: from kotlin metadata */
    private KonfettiView.a timer = new KonfettiView$a();
    /* renamed from: c, reason: from kotlin metadata */
    private a onParticleSystemUpdateListener;

    public static final class a {

        private long a = -1;
        public a() {
            super();
        }

        public final float a() {
            if (this.a == -1) {
                this.a = System.nanoTime();
            }
            long time = System.nanoTime();
            this.a = time;
            return (float)(time - this.a) / (long)1000000 / (float)1000;
        }

        public final long b(long j) {
            return System.currentTimeMillis() - j;
        }

        public final void c() {
            this.a = -1L;
        }
    }
    public KonfettiView(Context context, AttributeSet set) {
        super(context, set);
        ArrayList arrayList = new ArrayList();
        nl.dionsegijn.konfetti.KonfettiView.a aVar = new KonfettiView.a();
    }

    @Override // android.view.View
    /* renamed from: a, reason: from kotlin metadata */
    public final b getActiveSystems() {
        return new b(this);
    }

    @Override // android.view.View
    /* renamed from: b, reason: from kotlin metadata */
    public final void onDraw(b canvas) {
        n.f(canvas, "particleSystem");
        this.systems.add(canvas);
        if (this.onParticleSystemUpdateListener != null) {
            this.onParticleSystemUpdateListener.a(this, canvas, this.systems.size());
        }
        invalidate();
    }

    @Override // android.view.View
    public final List<b> getActiveSystems() {
        return this.systems;
    }

    @Override // android.view.View
    public final a getOnParticleSystemUpdateListener() {
        return this.onParticleSystemUpdateListener;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        boolean z;
        long l;
        long l2;
        n.f(canvas, "canvas");
        super.onDraw(canvas);
        i = this.systems.size() - 1;
        while (this.systems >= 0) {
            Object item = this.systems.get(i);
            long l3 = this.timer.b(item.g().c());
            l2 = item.f();
            i = i - 1;
        }
        if (this.systems.size() != 0) {
            invalidate();
        } else {
            this.timer.c();
        }
    }

    @Override // android.view.View
    public final void setOnParticleSystemUpdateListener(a aVar) {
        this.onParticleSystemUpdateListener = aVar;
    }
}
