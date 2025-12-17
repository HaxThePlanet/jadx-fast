package d.a.l.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;

/* loaded from: classes.dex */
class d extends d.a.l.a.b {

    private d.a.l.a.d.a E;
    private boolean F;

    static class a extends d.a.l.a.b.c {

        int[][] J;
        a(d.a.l.a.d.a d$a, d.a.l.a.d d2, Resources resources3) {
            int[][] obj1;
            super(a, d2, resources3);
            if (a != null) {
                this.J = a.J;
            } else {
                this.J = new int[f()];
            }
        }

        @Override // d.a.l.a.b$c
        int A(int[] iArr) {
            int i;
            boolean stateSetMatches;
            i = 0;
            while (i < h()) {
                i++;
            }
            return -1;
        }

        @Override // d.a.l.a.b$c
        public Drawable newDrawable() {
            d dVar = new d(this, 0);
            return dVar;
        }

        @Override // d.a.l.a.b$c
        public Drawable newDrawable(Resources resources) {
            d dVar = new d(this, resources);
            return dVar;
        }

        @Override // d.a.l.a.b$c
        public void o(int i, int i2) {
            super.o(i, i2);
            final int[][] obj4 = new int[i2];
            final int i3 = 0;
            System.arraycopy(this.J, i3, obj4, i3, i);
            this.J = obj4;
        }

        @Override // d.a.l.a.b$c
        void r() {
            int i;
            Object clone;
            int[] iArr;
            int[][] arr = this.J;
            int[][] iArr2 = new int[arr.length];
            length--;
            while (i >= 0) {
                int[][] arr2 = this.J;
                if (arr2[i] != null) {
                } else {
                }
                clone = 0;
                iArr2[i] = clone;
                i--;
                clone = arr2[i].clone();
            }
            this.J = iArr2;
        }

        @Override // d.a.l.a.b$c
        int z(int[] iArr, Drawable drawable2) {
            final int obj3 = a(drawable2);
            this.J[obj3] = iArr;
            return obj3;
        }
    }
    d(d.a.l.a.d.a d$a) {
        super();
        if (a != null) {
            h(a);
        }
    }

    d(d.a.l.a.d.a d$a, Resources resources2) {
        super();
        d.a aVar = new d.a(a, this, resources2);
        h(aVar);
        onStateChange(getState());
    }

    @Override // d.a.l.a.b
    public void applyTheme(Resources.Theme resources$Theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // d.a.l.a.b
    d.a.l.a.b.c b() {
        return j();
    }

    @Override // d.a.l.a.b
    void h(d.a.l.a.b.c b$c) {
        super.h(c);
        if (c instanceof d.a) {
            this.E = (d.a)c;
        }
    }

    @Override // d.a.l.a.b
    public boolean isStateful() {
        return 1;
    }

    @Override // d.a.l.a.b
    d.a.l.a.d.a j() {
        d.a aVar = new d.a(this.E, this, 0);
        return aVar;
    }

    @Override // d.a.l.a.b
    int[] k(AttributeSet attributeSet) {
        int i;
        int i3;
        int attributeNameResource;
        int i2;
        boolean attributeBooleanValue;
        final int attributeCount = attributeSet.getAttributeCount();
        final int[] iArr = new int[attributeCount];
        final int i4 = 0;
        i3 = i;
        while (i < attributeCount) {
            attributeNameResource = attributeSet.getAttributeNameResource(i);
            if (attributeNameResource != null && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
            }
            i++;
            if (attributeNameResource != 16842960) {
            }
            if (attributeNameResource != 16843161) {
            }
            if (attributeSet.getAttributeBooleanValue(i, i4)) {
            } else {
            }
            attributeNameResource = -attributeNameResource;
            iArr[i3] = attributeNameResource;
            i3 = i2;
        }
        return StateSet.trimStateSet(iArr, i3);
    }

    @Override // d.a.l.a.b
    public Drawable mutate() {
        boolean z;
        super.mutate();
        if (!this.F && this == this) {
            super.mutate();
            if (this == this) {
                this.E.r();
                this.F = true;
            }
        }
        return this;
    }

    @Override // d.a.l.a.b
    protected boolean onStateChange(int[] iArr) {
        d.a.l.a.d.a wILD_CARD;
        int obj3;
        if (this.E.A(iArr) < 0) {
            obj3 = this.E.A(StateSet.WILD_CARD);
        }
        if (!g(obj3)) {
            if (super.onStateChange(iArr)) {
                obj3 = 1;
            } else {
                obj3 = 0;
            }
        } else {
        }
        return obj3;
    }
}
