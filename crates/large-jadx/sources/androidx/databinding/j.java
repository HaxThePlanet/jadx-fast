package androidx.databinding;

/* loaded from: classes.dex */
public class j extends androidx.databinding.c<androidx.databinding.h.a, androidx.databinding.h, Void> {

    private static final androidx.databinding.c.a<androidx.databinding.h.a, androidx.databinding.h, Void> x;

    static class a extends androidx.databinding.c.a<androidx.databinding.h.a, androidx.databinding.h, Void> {
        @Override // androidx.databinding.c$a
        public void a(Object object, Object object2, int i3, Object object4) {
            b((h.a)object, (h)object2, i3, (Void)object4);
        }

        @Override // androidx.databinding.c$a
        public void b(androidx.databinding.h.a h$a, androidx.databinding.h h2, int i3, Void void4) {
            a.d(h2, i3);
        }
    }
    static {
        j.a aVar = new j.a();
        j.x = aVar;
    }

    public j() {
        super(j.x);
    }

    @Override // androidx.databinding.c
    public void m(androidx.databinding.h h, int i2) {
        d(h, i2, 0);
    }
}
