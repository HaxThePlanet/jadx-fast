package f.c.a.e.a0;

import android.graphics.Typeface;

/* compiled from: CancelableFontCallback.java */
/* loaded from: classes2.dex */
public final class a extends f {

    private final Typeface a;
    private final a.a b;
    private boolean c;

    public interface a {
        void a(Typeface typeface);
    }
    public a(a.a aVar, Typeface typeface) {
        super();
        this.a = typeface;
        this.b = aVar;
    }

    private void d(Typeface typeface) {
        if (!this.c) {
            this.b.a(typeface);
        }
    }

    @Override // f.c.a.e.a0.f
    public void a(int i) {
        d(this.a);
    }

    @Override // f.c.a.e.a0.f
    public void b(Typeface typeface, boolean z) {
        d(typeface);
    }

    @Override // f.c.a.e.a0.f
    public void c() {
        this.c = true;
    }
}
