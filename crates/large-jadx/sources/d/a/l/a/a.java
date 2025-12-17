package d.a.l.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.widget.j0;
import androidx.core.content.e.g;
import androidx.core.graphics.drawable.b;
import d.a.m.b;
import d.e.d;
import d.e.h;
import d.v.a.a.c;
import d.v.a.a.i;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class a extends d.a.l.a.d implements b {

    private d.a.l.a.a.c G;
    private d.a.l.a.a.g H;
    private int I;
    private int J;
    private boolean K;

    static class a {
    }

    private static class f implements TimeInterpolator {

        private int[] a;
        private int b;
        private int c;
        f(AnimationDrawable animationDrawable, boolean z2) {
            super();
            b(animationDrawable, z2);
        }

        @Override // android.animation.TimeInterpolator
        int a() {
            return this.c;
        }

        @Override // android.animation.TimeInterpolator
        int b(AnimationDrawable animationDrawable, boolean z2) {
            int[] iArr;
            int i2;
            int i3;
            int duration;
            int i;
            final int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.b = numberOfFrames;
            iArr = this.a;
            if (iArr != null) {
                if (iArr.length < numberOfFrames) {
                    this.a = new int[numberOfFrames];
                }
            } else {
            }
            i3 = i2;
            while (i2 < numberOfFrames) {
                if (z2) {
                } else {
                }
                i = i2;
                duration = animationDrawable.getDuration(i);
                this.a[i2] = duration;
                i3 += duration;
                i2++;
                i4--;
            }
            this.c = i3;
            return i3;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int[] iArr;
            int i;
            int i2;
            int obj5;
            obj5 = (int)obj5;
            int i5 = this.b;
            iArr = this.a;
            i = 0;
            while (i < i5) {
                if (obj5 >= iArr[i]) {
                }
                obj5 -= i2;
                i++;
            }
            if (i < i5) {
                obj5 /= iArr;
            } else {
                obj5 = 0;
            }
            return i6 += obj5;
        }
    }

    private static abstract class g {
        g(d.a.l.a.a.a a$a) {
            super();
        }

        public boolean a() {
            return 0;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    private static class b extends d.a.l.a.a.g {

        private final Animatable a;
        b(Animatable animatable) {
            super(0);
            this.a = animatable;
        }

        @Override // d.a.l.a.a$g
        public void c() {
            this.a.start();
        }

        @Override // d.a.l.a.a$g
        public void d() {
            this.a.stop();
        }
    }

    private static class d extends d.a.l.a.a.g {

        private final c a;
        d(c c) {
            super(0);
            this.a = c;
        }

        @Override // d.a.l.a.a$g
        public void c() {
            this.a.start();
        }

        @Override // d.a.l.a.a$g
        public void d() {
            this.a.stop();
        }
    }

    private static class e extends d.a.l.a.a.g {

        private final ObjectAnimator a;
        private final boolean b;
        e(AnimationDrawable animationDrawable, boolean z2, boolean z3) {
            int i;
            int i2;
            super(0);
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            final int i5 = 0;
            i2 = z2 ? numberOfFrames + -1 : i5;
            final int i6 = 1;
            i = z2 ? i5 : numberOfFrames - i6;
            a.f fVar = new a.f(animationDrawable, z2);
            int[] obj7 = new int[2];
            obj7[i5] = i2;
            obj7[i6] = i;
            final ObjectAnimator obj6 = ObjectAnimator.ofInt(animationDrawable, "currentIndex", obj7);
            if (Build.VERSION.SDK_INT >= 18) {
                obj6.setAutoCancel(i6);
            }
            obj6.setDuration((long)obj7);
            obj6.setInterpolator(fVar);
            this.b = z3;
            this.a = obj6;
        }

        @Override // d.a.l.a.a$g
        public boolean a() {
            return this.b;
        }

        @Override // d.a.l.a.a$g
        public void b() {
            this.a.reverse();
        }

        @Override // d.a.l.a.a$g
        public void c() {
            this.a.start();
        }

        @Override // d.a.l.a.a$g
        public void d() {
            this.a.cancel();
        }
    }

    static class c extends d.a.l.a.d.a {

        d<Long> K;
        h<Integer> L;
        c(d.a.l.a.a.c a$c, d.a.l.a.a a2, Resources resources3) {
            h obj1;
            Object obj2;
            super(c, a2, resources3);
            if (c != null) {
                this.K = c.K;
                this.L = c.L;
            } else {
                obj1 = new d();
                this.K = obj1;
                obj1 = new h();
                this.L = obj1;
            }
        }

        private static long D(int i, int i2) {
            return obj2 |= i3;
        }

        @Override // d.a.l.a.d$a
        int B(int[] iArr, Drawable drawable2, int i3) {
            final int obj1 = super.z(iArr, drawable2);
            this.L.j(obj1, Integer.valueOf(i3));
            return obj1;
        }

        @Override // d.a.l.a.d$a
        int C(int i, int i2, Drawable drawable3, boolean z4) {
            long valueOf;
            long l;
            int obj10;
            d obj13;
            final int obj12 = super.a(drawable3);
            l = z4 != null ? 8589934592L : 0;
            final long l3 = (long)obj12;
            this.K.a(a.c.D(i, i2), obj1);
            if (z4 != null) {
                this.K.a(a.c.D(i2, i), i2);
            }
            return obj12;
        }

        @Override // d.a.l.a.d$a
        int E(int i) {
            int intValue;
            h hVar;
            int obj3;
            if (i < 0) {
            } else {
                intValue = (Integer)this.L.f(i, 0).intValue();
            }
            return intValue;
        }

        @Override // d.a.l.a.d$a
        int F(int[] iArr) {
            int obj1 = super.A(iArr);
            if (obj1 >= 0) {
                return obj1;
            }
            return super.A(StateSet.WILD_CARD);
        }

        @Override // d.a.l.a.d$a
        int G(int i, int i2) {
            return (int)obj4;
        }

        @Override // d.a.l.a.d$a
        boolean H(int i, int i2) {
            int obj4;
            obj4 = Long.compare(obj4, i3) != 0 ? 1 : 0;
            return obj4;
        }

        @Override // d.a.l.a.d$a
        boolean I(int i, int i2) {
            int obj4;
            obj4 = Long.compare(obj4, i3) != 0 ? 1 : 0;
            return obj4;
        }

        @Override // d.a.l.a.d$a
        public Drawable newDrawable() {
            a aVar = new a(this, 0);
            return aVar;
        }

        @Override // d.a.l.a.d$a
        public Drawable newDrawable(Resources resources) {
            a aVar = new a(this, resources);
            return aVar;
        }

        @Override // d.a.l.a.d$a
        void r() {
            this.K = this.K.c();
            this.L = this.L.c();
        }
    }
    static {
        final Class<d.a.l.a.a> obj = a.class;
    }

    public a() {
        final int i = 0;
        super(i, i);
    }

    a(d.a.l.a.a.c a$c, Resources resources2) {
        super(0);
        int i2 = -1;
        this.I = i2;
        this.J = i2;
        a.c cVar = new a.c(c, this, resources2);
        h(cVar);
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static d.a.l.a.a m(Context context, Resources resources2, XmlPullParser xmlPullParser3, AttributeSet attributeSet4, Resources.Theme resources$Theme5) {
        String name = xmlPullParser3.getName();
        if (!name.equals("animated-selector")) {
        } else {
            a aVar = new a();
            aVar.n(context, resources2, xmlPullParser3, attributeSet4, theme5);
            return aVar;
        }
        StringBuilder obj9 = new StringBuilder();
        obj9.append(xmlPullParser3.getPositionDescription());
        obj9.append(": invalid animated-selector tag ");
        obj9.append(name);
        XmlPullParserException obj8 = new XmlPullParserException(obj9.toString());
        throw obj8;
    }

    private void o(Context context, Resources resources2, XmlPullParser xmlPullParser3, AttributeSet attributeSet4, Resources.Theme resources$Theme5) {
        int equals;
        int depth;
        int i;
        final int i3 = 1;
        depth2 += i3;
        equals = xmlPullParser3.next();
        while (equals != i3) {
            depth = xmlPullParser3.getDepth();
            if (depth < i2) {
            } else {
            }
            if (equals != 2) {
            } else {
            }
            if (depth > i2) {
            } else {
            }
            if (xmlPullParser3.getName().equals("item")) {
            } else {
            }
            if (xmlPullParser3.getName().equals("transition")) {
            }
            equals = xmlPullParser3.next();
            r(context, resources2, xmlPullParser3, attributeSet4, theme5);
            q(context, resources2, xmlPullParser3, attributeSet4, theme5);
            if (equals != 3) {
            }
        }
    }

    private void p() {
        onStateChange(getState());
    }

    private int q(Context context, Resources resources2, XmlPullParser xmlPullParser3, AttributeSet attributeSet4, Resources.Theme resources$Theme5) {
        j0 str;
        Drawable obj5;
        TypedArray typedArray = g.s(resources2, theme5, attributeSet4, b.h);
        int resourceId2 = typedArray.getResourceId(b.j, -1);
        if (resourceId2 > 0) {
            obj5 = j0.h().j(context, resourceId2);
        } else {
            obj5 = 0;
        }
        typedArray.recycle();
        String str2 = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
        if (obj5 == null) {
        }
        if (obj5 == null) {
        } else {
            return this.G.B(k(attributeSet4), obj5, typedArray.getResourceId(b.i, 0));
        }
        StringBuilder obj6 = new StringBuilder();
        obj6.append(xmlPullParser3.getPositionDescription());
        obj6.append(str2);
        obj5 = new XmlPullParserException(obj6.toString());
        throw obj5;
    }

    private int r(Context context, Resources resources2, XmlPullParser xmlPullParser3, AttributeSet attributeSet4, Resources.Theme resources$Theme5) {
        Drawable fromXmlInner;
        j0 j0Var;
        int str;
        Context obj8;
        TypedArray typedArray = g.s(resources2, theme5, attributeSet4, b.k);
        final int i2 = -1;
        int resourceId = typedArray.getResourceId(b.n, i2);
        int resourceId2 = typedArray.getResourceId(b.m, i2);
        int resourceId3 = typedArray.getResourceId(b.l, i2);
        if (resourceId3 > 0) {
            fromXmlInner = j0.h().j(context, resourceId3);
        } else {
            fromXmlInner = 0;
        }
        typedArray.recycle();
        String str2 = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
        if (fromXmlInner == null) {
        }
        if (fromXmlInner == null) {
        } else {
            if (resourceId == i2) {
            } else {
                if (resourceId2 == i2) {
                } else {
                    return this.G.C(resourceId, resourceId2, fromXmlInner, typedArray.getBoolean(b.o, false));
                }
            }
            StringBuilder obj9 = new StringBuilder();
            obj9.append(xmlPullParser3.getPositionDescription());
            obj9.append(": <transition> tag requires 'fromId' & 'toId' attributes");
            obj8 = new XmlPullParserException(obj9.toString());
            throw obj8;
        }
        obj9 = new StringBuilder();
        obj9.append(xmlPullParser3.getPositionDescription());
        obj9.append(str2);
        obj8 = new XmlPullParserException(obj9.toString());
        throw obj8;
    }

    private boolean s(int i) {
        boolean cVar;
        int i2;
        int i3;
        d.a.l.a.a.g eVar;
        Drawable current;
        boolean z;
        boolean z2;
        d.a.l.a.a.g gVar = this.H;
        final int i7 = 1;
        if (gVar != null) {
            if (i == this.I) {
                return i7;
            }
            if (i == this.J && gVar.a()) {
                if (gVar.a()) {
                    gVar.b();
                    this.I = this.J;
                    this.J = i;
                    return i7;
                }
            }
            i3 = this.I;
            gVar.d();
        } else {
            i3 = c();
        }
        this.H = 0;
        int i6 = -1;
        this.J = i6;
        this.I = i6;
        cVar = this.G;
        int i9 = cVar.E(i3);
        final int i10 = cVar.E(i);
        final int i11 = 0;
        if (i10 != 0) {
            if (i9 == 0) {
            } else {
                int i12 = cVar.G(i9, i10);
                if (i12 < 0) {
                    return i11;
                }
                g(i12);
                current = getCurrent();
                if (current instanceof AnimationDrawable) {
                    eVar = new a.e((AnimationDrawable)current, cVar.H(i9, i10), cVar.I(i9, i10));
                    eVar.c();
                    this.H = eVar;
                    this.J = i3;
                    this.I = i;
                    return i7;
                } else {
                    if (current instanceof c) {
                        eVar = new a.d((c)current);
                    } else {
                        if (current instanceof Animatable) {
                            eVar = new a.b((Animatable)current);
                        }
                    }
                }
            }
        }
        return i11;
    }

    private void t(TypedArray typedArray) {
        int sDK_INT;
        int changingConfigurations;
        d.a.l.a.a.c cVar = this.G;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.d = i6 |= changingConfigurations;
        }
        cVar.x(typedArray.getBoolean(b.d, cVar.i));
        cVar.t(typedArray.getBoolean(b.e, cVar.l));
        cVar.u(typedArray.getInt(b.f, cVar.A));
        cVar.v(typedArray.getInt(b.g, cVar.B));
        setDither(typedArray.getBoolean(b.b, cVar.x));
    }

    @Override // d.a.l.a.d
    d.a.l.a.b.c b() {
        return l();
    }

    @Override // d.a.l.a.d
    void h(d.a.l.a.b.c b$c) {
        super.h(c);
        if (c instanceof a.c) {
            this.G = (a.c)c;
        }
    }

    @Override // d.a.l.a.d
    public boolean isStateful() {
        return 1;
    }

    @Override // d.a.l.a.d
    d.a.l.a.d.a j() {
        return l();
    }

    @Override // d.a.l.a.d
    public void jumpToCurrentState() {
        d.a.l.a.a.g gVar;
        super.jumpToCurrentState();
        gVar = this.H;
        if (gVar != null) {
            gVar.d();
            this.H = 0;
            g(this.I);
            gVar = -1;
            this.I = gVar;
            this.J = gVar;
        }
    }

    @Override // d.a.l.a.d
    d.a.l.a.a.c l() {
        a.c cVar = new a.c(this.G, this, 0);
        return cVar;
    }

    @Override // d.a.l.a.d
    public Drawable mutate() {
        boolean z;
        super.mutate();
        if (!this.K && this == this) {
            super.mutate();
            if (this == this) {
                this.G.r();
                this.K = true;
            }
        }
        return this;
    }

    @Override // d.a.l.a.d
    public void n(Context context, Resources resources2, XmlPullParser xmlPullParser3, AttributeSet attributeSet4, Resources.Theme resources$Theme5) {
        TypedArray typedArray = g.s(resources2, theme5, attributeSet4, b.a);
        final int i2 = 1;
        setVisible(typedArray.getBoolean(b.c, i2), i2);
        t(typedArray);
        i(resources2);
        typedArray.recycle();
        o(context, resources2, xmlPullParser3, attributeSet4, theme5);
        p();
    }

    @Override // d.a.l.a.d
    protected boolean onStateChange(int[] iArr) {
        int i;
        int i2;
        boolean i3;
        int[] obj3;
        i2 = this.G.F(iArr);
        if (i2 != c()) {
            if (!s(i2)) {
                i = g(i2) ? 1 : 0;
            } else {
            }
        } else {
        }
        Drawable current = getCurrent();
        if (current != null) {
            i |= obj3;
        }
        return i;
    }

    @Override // d.a.l.a.d
    public boolean setVisible(boolean z, boolean z2) {
        final boolean visible = super.setVisible(z, z2);
        final d.a.l.a.a.g gVar = this.H;
        if (gVar != null) {
            if (!visible) {
                if (z2) {
                    if (z) {
                        gVar.c();
                    } else {
                        jumpToCurrentState();
                    }
                }
            } else {
            }
        }
        return visible;
    }
}
