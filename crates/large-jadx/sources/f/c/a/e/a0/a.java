package f.c.a.e.a0;

import android.graphics.Typeface;

/* loaded from: classes2.dex */
public final class a extends f.c.a.e.a0.f {

    private final Typeface a;
    private final f.c.a.e.a0.a.a b;
    private boolean c;

    public interface a {
        public abstract void a(Typeface typeface);
    }
    public a(f.c.a.e.a0.a.a a$a, Typeface typeface2) {
        super();
        this.a = typeface2;
        this.b = a;
    }

    private void d(Typeface typeface) {
        boolean z;
        if (!this.c) {
            this.b.a(typeface);
        }
    }

    @Override // f.c.a.e.a0.f
    public void a(int i) {
        d(this.a);
    }

    @Override // f.c.a.e.a0.f
    public void b(Typeface typeface, boolean z2) {
        d(typeface);
    }

    @Override // f.c.a.e.a0.f
    public void c() {
        this.c = true;
    }
}
