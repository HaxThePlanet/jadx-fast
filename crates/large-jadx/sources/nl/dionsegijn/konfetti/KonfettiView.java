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

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001:\u0001\u0006B\u001d\u0008\u0016\u0012\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0008\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\u0008!\u0010\"J\u0013\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0008H\u0014¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\u0008\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u000e\u0010\u001b¨\u0006#", d2 = {"Lnl/dionsegijn/konfetti/KonfettiView;", "Landroid/view/View;", "", "Lnl/dionsegijn/konfetti/b;", "getActiveSystems", "()Ljava/util/List;", "a", "()Lnl/dionsegijn/konfetti/b;", "Landroid/graphics/Canvas;", "canvas", "Lkotlin/w;", "onDraw", "(Landroid/graphics/Canvas;)V", "particleSystem", "b", "(Lnl/dionsegijn/konfetti/b;)V", "Ljava/util/List;", "systems", "Lnl/dionsegijn/konfetti/d/a;", "c", "Lnl/dionsegijn/konfetti/d/a;", "getOnParticleSystemUpdateListener", "()Lnl/dionsegijn/konfetti/d/a;", "setOnParticleSystemUpdateListener", "(Lnl/dionsegijn/konfetti/d/a;)V", "onParticleSystemUpdateListener", "Lnl/dionsegijn/konfetti/KonfettiView$a;", "Lnl/dionsegijn/konfetti/KonfettiView$a;", "timer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "konfetti_release"}, k = 1, mv = {1, 4, 0})
public class KonfettiView extends View {

    private final List<nl.dionsegijn.konfetti.b> a;
    private nl.dionsegijn.konfetti.KonfettiView.a b;
    private a c;

    public static final class a {

        private long a = -1;
        public a() {
            super();
            final int i = -1;
        }

        public final float a() {
            int nanoTime;
            if (Long.compare(l, i3) == 0) {
                this.a = System.nanoTime();
            }
            long nanoTime2 = System.nanoTime();
            this.a = nanoTime2;
            return f /= f2;
        }

        public final long b(long l) {
            return currentTimeMillis -= l;
        }

        public final void c() {
            this.a = -1;
        }
    }
    public KonfettiView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        ArrayList obj1 = new ArrayList();
        this.a = obj1;
        obj1 = new KonfettiView.a();
        this.b = obj1;
    }

    @Override // android.view.View
    public final nl.dionsegijn.konfetti.b a() {
        b bVar = new b(this);
        return bVar;
    }

    @Override // android.view.View
    public final void b(nl.dionsegijn.konfetti.b b) {
        int size;
        n.f(b, "particleSystem");
        this.a.add(b);
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(this, b, this.a.size());
        }
        invalidate();
    }

    public final List<nl.dionsegijn.konfetti.b> getActiveSystems() {
        return this.a;
    }

    @Override // android.view.View
    public final a getOnParticleSystemUpdateListener() {
        return this.c;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        Object obj;
        boolean z;
        int cmp;
        long size;
        long l;
        nl.dionsegijn.konfetti.KonfettiView.a obj8;
        n.f(canvas, "canvas");
        super.onDraw(canvas);
        size2--;
        while (i >= 0) {
            obj = this.a.get(i);
            if (Long.compare(l2, l) >= 0) {
            }
            this.a.remove(i);
            z = this.c;
            if (obj.e() && z != null) {
            }
            i--;
            this.a.remove(i);
            z = this.c;
            if (z != null) {
            }
            z.b(this, obj, this.a.size());
            obj.g().f(canvas, this.b.a());
        }
        if (this.a.size() != 0) {
            invalidate();
        } else {
            this.b.c();
        }
    }

    @Override // android.view.View
    public final void setOnParticleSystemUpdateListener(a a) {
        this.c = a;
    }
}
