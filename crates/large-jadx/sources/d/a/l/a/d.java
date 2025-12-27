package d.a.l.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;

/* compiled from: StateListDrawable.java */
/* loaded from: classes.dex */
class d extends b {

    private d.a E;
    private boolean F;

    static class a extends b.c {

        int[][] J;
        a(d.a aVar, d dVar, Resources resources) {
            super(aVar, dVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[f()];
            }
        }

        @Override // d.a.l.a.b$c
        int A(int[] iArr) {
            int i = 0;
            i = 0;
            while (i < h()) {
                if (StateSet.stateSetMatches(this.J[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // d.a.l.a.b$c
        public Drawable newDrawable() {
            return new d(this, null);
        }

        @Override // d.a.l.a.b$c
        public void o(int i, int i2) {
            super.o(i, i2);
            final int[][] iArr = new int[i2];
            final int i3 = 0;
            System.arraycopy(this.J, i3, iArr, i3, i);
            this.J = iArr;
        }

        @Override // d.a.l.a.b$c
        void r() {
            int i;
            Object clone = null;
            int[][] iArr2 = new int[arr.length];
            i = arr.length - 1;
            while (this.J >= 0) {
                iArr2[i] = clone;
                i = i - 1;
            }
            this.J = iArr2;
        }

        @Override // d.a.l.a.b$c
        int z(int[] iArr, Drawable drawable) {
            final int i = a(drawable);
            this.J[i] = iArr;
            return i;
        }

        @Override // d.a.l.a.b$c
        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }
    d(d.a aVar, Resources resources) {
        super();
        h(new d.a(aVar, this, resources));
        onStateChange(getState());
    }

    @Override // d.a.l.a.b
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // d.a.l.a.b
    void h(b.c cVar) {
        super.h(cVar);
        if (cVar instanceof d.a) {
            this.E = cVar;
        }
    }

    @Override // d.a.l.a.b
    d.a j() {
        return new d.a(this.E, this, null);
    }

    @Override // d.a.l.a.b
    int[] k(AttributeSet set) {
        int i;
        int attributeNameResource;
        boolean attributeBooleanValue;
        final int attributeCount = set.getAttributeCount();
        final int[] iArr = new int[attributeCount];
        final boolean z = false;
        while (i < attributeCount) {
            attributeNameResource = set.getAttributeNameResource(i);
            i = i + 1;
        }
        return StateSet.trimStateSet(iArr, i);
    }

    @Override // d.a.l.a.b
    public Drawable mutate() {
        if (!this.F && this == this) {
            this.E.r();
            boolean z = true;
            this.F = z;
        }
        return this;
    }

    @Override // d.a.l.a.b
    protected boolean onStateChange(int[] iArr) {
        int i;
        boolean z2 = false;
        if (this.E.A(iArr) < 0) {
            i = this.E.A(StateSet.WILD_CARD);
        }
        if (g(i) || super.onStateChange(iArr)) {
            int i3 = 1;
        }
        return z2;
    }

    d(d.a aVar) {
        super();
        if (aVar != null) {
            h(aVar);
        }
    }

    @Override // d.a.l.a.b
    public boolean isStateful() {
        return true;
    }
}
