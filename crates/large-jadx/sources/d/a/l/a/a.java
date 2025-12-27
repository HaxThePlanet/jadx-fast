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
import d.e.d;
import d.e.h;
import d.v.a.a.c;
import d.v.a.a.i;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatedStateListDrawableCompat.java */
/* loaded from: classes.dex */
public class a extends d implements androidx.core.graphics.drawable.b {

    private a.c G;
    private a.g H;
    private int I;
    private int J;
    private boolean K;

    static class a {
    }

    private static class f implements TimeInterpolator {

        private int[] a;
        private int b;
        private int c;
        f(AnimationDrawable animationDrawable, boolean z) {
            super();
            b(animationDrawable, z);
        }

        int a() {
            return this.c;
        }

        int b(AnimationDrawable animationDrawable, boolean z) {
            int i = 0;
            final int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.b = numberOfFrames;
            if (this.a != null) {
                if (iArr.length < numberOfFrames) {
                    this.a = new int[numberOfFrames];
                }
            }
            i = 0;
            while (i < numberOfFrames) {
                int duration = animationDrawable.getDuration(i);
                this.a[i] = duration;
                i = i + duration;
                i = i + 1;
            }
            this.c = i;
            return i;
        }

        public float getInterpolation(float f) {
            int i = 0;
            int i2;
            int i3;
            int i4 = 0;
            i3 = (int)(f * (float)this.c) + 0.5f;
            i = 0;
            while (i < this.b) {
            }
            if (i < this.b) {
                float f11 = (float)i3 / (float)this.c;
            } else {
                i4 = 0;
            }
            return (float)i / (float)i7 + i4;
        }
    }

    private static abstract class g {
        private g() {
            super();
        }

        /* synthetic */ g(a.a aVar) {
            this();
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    private static class b extends a.g {

        private final Animatable a;
        b(Animatable animatable) {
            super(null);
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

    private static class d extends a.g {

        private final c a;
        d(c cVar) {
            super(null);
            this.a = cVar;
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

    private static class e extends a.g {

        private final ObjectAnimator a;
        private final boolean b;
        e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            int i;
            super(null);
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            i = 0;
            int r2 = z ? numberOfFrames - 1 : i;
            final int i4 = 1;
            int r0 = z ? i : numberOfFrames - i4;
            final d.a.l.a.a.f fVar = new a.f(animationDrawable, z);
            int[] iArr = new int[2];
            final ObjectAnimator _int = ObjectAnimator.ofInt(animationDrawable, (z ? i : numberOfFrames - i4), new int[] { i, (z ? i : numberOfFrames - i4) });
            if (Build.VERSION.SDK_INT >= 18) {
                _int.setAutoCancel(true);
            }
            _int.setDuration((long)fVar.a());
            _int.setInterpolator(fVar);
            this.b = z2;
            this.a = _int;
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

    static class c extends d.a {

        d<Long> K = new d<>();
        h<Integer> L = new h<>();
        c(a.c cVar, a aVar, Resources resources) {
            super(cVar, aVar, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
            } else {
                d dVar2 = new d();
                h hVar = new h();
            }
        }

        @Override // d.a.l.a.d$a
        int B(int[] iArr, Drawable drawable, int i) {
            i = super.z(iArr, drawable);
            this.L.j(i, Integer.valueOf(i));
            return i;
        }

        @Override // d.a.l.a.d$a
        int C(int i, int i2, Drawable drawable, boolean z) {
            long l2 = 8589934592L;
            final int i4 = super.a(drawable);
            int r2 = z ? 8589934592L : 0;
            final long l7 = (long)i4;
            this.K.a(a.c.D(i, i2), Long.valueOf(l7 | (z ? 8589934592L : 0)));
            if (z) {
                this.K.a(a.c.D(i2, i), Long.valueOf((4294967296L | l7) | r2));
            }
            return i4;
        }

        @Override // d.a.l.a.d$a
        int E(int i) {
            int value = 0;
            value = 0;
            if (i >= 0) {
                value = (Integer)this.L.f(i, null).intValue();
            }
            return value;
        }

        @Override // d.a.l.a.d$a
        int F(int[] iArr) {
            int i = super.A(iArr);
            if (i >= 0) {
                return i;
            }
            return super.A(StateSet.WILD_CARD);
        }

        @Override // d.a.l.a.d$a
        int G(int i, int i2) {
            return (int)(Long)this.K.g(a.c.D(i, i2), Long.valueOf(-1L)).longValue();
        }

        @Override // d.a.l.a.d$a
        boolean H(int i, int i2) {
            boolean z = true;
            long l4 = (Long)this.K.g(a.c.D(i, i2), Long.valueOf(-1L)).longValue() & 4294967296L;
            i = l4 != 0 ? 1 : 0;
            return (l4 != 0 ? 1 : 0);
        }

        @Override // d.a.l.a.d$a
        boolean I(int i, int i2) {
            boolean z = true;
            long l4 = (Long)this.K.g(a.c.D(i, i2), Long.valueOf(-1L)).longValue() & 8589934592L;
            i = l4 != 0 ? 1 : 0;
            return (l4 != 0 ? 1 : 0);
        }

        @Override // d.a.l.a.d$a
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // d.a.l.a.d$a
        void r() {
            this.K = this.K.c();
            this.L = this.L.c();
        }

        @Override // d.a.l.a.d$a
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }

        private static long D(int i, int i2) {
            return (long)i2 | (long)i << 32L;
        }
    }

    public a() {
        final d.a.l.a.a.c cVar = null;
        this(cVar, cVar);
    }

    public static a m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet set, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (!name.equals("animated-selector")) {
            StringBuilder stringBuilder = new StringBuilder();
            String positionDescription = xmlPullParser.getPositionDescription();
            String str2 = ": invalid animated-selector tag ";
            resources = positionDescription + str2 + name;
            throw new XmlPullParserException(resources);
        } else {
            d.a.l.a.a aVar = new a();
            aVar.n(context, resources, xmlPullParser, set, theme);
            return aVar;
        }
    }

    private void o(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet set, Resources.Theme theme) throws java.io.IOException, XmlPullParserException {
        int depth;
        int i = 2;
        final int i3 = 1;
        int i2 = xmlPullParser.getDepth() + i3;
        int next = xmlPullParser.next();
        while (next != i3) {
            depth = xmlPullParser.getDepth();
        }
    }

    private void p() {
        onStateChange(getState());
    }

    private int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet set, Resources.Theme theme) throws XmlPullParserException, java.io.IOException {
        j0 j0Var;
        Drawable fromXmlInner = null;
        TypedArray typedArray = g.s(resources, theme, set, b.h);
        int resourceId2 = typedArray.getResourceId(b.j, -1);
        if (resourceId2 > 0) {
            fromXmlInner = j0.h().j(context, resourceId2);
        } else {
            int i8 = 0;
        }
        typedArray.recycle();
        String str = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
        if (fromXmlInner == null) {
            int next = xmlPullParser.next();
            j0Var = 4;
            while (next == 4) {
                next = xmlPullParser.next();
                j0Var = 4;
            }
            if (next != 2) {
                StringBuilder stringBuilder = new StringBuilder();
                String positionDescription = xmlPullParser.getPositionDescription();
                resources = positionDescription + str;
                throw new XmlPullParserException(resources);
            } else {
                if (xmlPullParser.getName().equals("vector")) {
                    i iVar = i.c(resources, xmlPullParser, set, theme);
                } else {
                    if (Build.VERSION.SDK_INT >= 21) {
                        fromXmlInner = Drawable.createFromXmlInner(resources, xmlPullParser, set, theme);
                    } else {
                        fromXmlInner = Drawable.createFromXmlInner(resources, xmlPullParser, set);
                    }
                }
            }
        }
        if (Build.VERSION.SDK_INT == null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String positionDescription2 = xmlPullParser.getPositionDescription();
            resources = positionDescription2 + str;
            throw new XmlPullParserException(resources);
        } else {
            return this.G.B(k(set), fromXmlInner, typedArray.getResourceId(b.i, 0));
        }
    }

    private int r(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet set, Resources.Theme theme) throws java.io.IOException, XmlPullParserException {
        Drawable fromXmlInner = null;
        TypedArray typedArray = g.s(resources, theme, set, b.k);
        final int i2 = -1;
        int resourceId = typedArray.getResourceId(b.n, i2);
        int resourceId2 = typedArray.getResourceId(b.m, i2);
        int resourceId3 = typedArray.getResourceId(b.l, i2);
        if (resourceId3 > 0) {
            fromXmlInner = j0.h().j(context, resourceId3);
        } else {
            int i6 = 0;
        }
        boolean z = false;
        typedArray.recycle();
        String str = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
        if (b.l == null) {
            int next = xmlPullParser.next();
            z = 4;
            while (next == 4) {
                next = xmlPullParser.next();
                z = 4;
            }
            if (next != 2) {
                StringBuilder stringBuilder = new StringBuilder();
                String positionDescription = xmlPullParser.getPositionDescription();
                resources = positionDescription + str;
                throw new XmlPullParserException(resources);
            } else {
                if (xmlPullParser.getName().equals("animated-vector")) {
                    c cVar = c.a(context, resources, xmlPullParser, set, theme);
                } else {
                    if (Build.VERSION.SDK_INT >= 21) {
                        fromXmlInner = Drawable.createFromXmlInner(resources, xmlPullParser, set, theme);
                    } else {
                        fromXmlInner = Drawable.createFromXmlInner(resources, xmlPullParser, set);
                    }
                }
            }
        }
        if (b.l == null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            String positionDescription3 = xmlPullParser.getPositionDescription();
            resources = positionDescription3 + str;
            throw new XmlPullParserException(resources);
        } else {
            if (resourceId == i2) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String positionDescription2 = xmlPullParser.getPositionDescription();
                String str3 = ": <transition> tag requires 'fromId' & 'toId' attributes";
                resources = positionDescription2 + str3;
                throw new XmlPullParserException(resources);
            } else {
                if (resourceId2 != i2) {
                    return this.G.C(resourceId, resourceId2, fromXmlInner, typedArray.getBoolean(b.o, z));
                }
            }
        }
    }

    private boolean s(int i) {
        int i3;
        d.a.l.a.a.e eVar;
        final boolean z4 = true;
        if (this.H != null) {
            if (i == this.I) {
                return true;
            }
            if (i == this.J && this.H.a()) {
                this.H.b();
                this.I = this.J;
                this.J = i;
                return true;
            }
            this.H.d();
        } else {
            i3 = c();
        }
        this.H = null;
        int i6 = -1;
        this.J = i6;
        this.I = i6;
        int i8 = this.G.E(i3);
        final int i9 = this.G.E(i);
        final boolean z6 = false;
        return false;
    }

    private void t(TypedArray typedArray) {
        int changingConfigurations = 21;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.d |= changingConfigurations;
        }
        this.G.x(typedArray.getBoolean(b.d, cVar.i));
        this.G.t(typedArray.getBoolean(b.e, cVar.l));
        this.G.u(typedArray.getInt(b.f, cVar.A));
        this.G.v(typedArray.getInt(b.g, cVar.B));
        setDither(typedArray.getBoolean(b.b, cVar.x));
    }

    @Override // d.a.l.a.d
    void h(b.c cVar) {
        super.h(cVar);
        if (cVar instanceof a.c) {
            this.G = cVar;
        }
    }

    @Override // d.a.l.a.d
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        if (this.H != null) {
            this.H.d();
            this.H = null;
            g(this.I);
            int i3 = -1;
            this.I = i3;
            this.J = i3;
        }
    }

    @Override // d.a.l.a.d
    a.c l() {
        return new a.c(this.G, this, null);
    }

    @Override // d.a.l.a.d
    public Drawable mutate() {
        if (!this.K && this == this) {
            this.G.r();
            boolean z = true;
            this.K = z;
        }
        return this;
    }

    @Override // d.a.l.a.d
    public void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet set, Resources.Theme theme) {
        TypedArray typedArray = g.s(resources, theme, set, b.a);
        final boolean z = true;
        setVisible(typedArray.getBoolean(b.c, z), z);
        t(typedArray);
        i(resources);
        typedArray.recycle();
        o(context, resources, xmlPullParser, set, theme);
        p();
    }

    @Override // d.a.l.a.d
    protected boolean onStateChange(int[] iArr) {
        int i2 = 1;
        boolean z2;
        int i3;
        int i = this.G.F(iArr);
        if (i == c() || !this.s(i)) {
            i2 = 0;
        } else {
            int r0 = g(i) ? 1 : 0;
        }
        Drawable current = getCurrent();
        if (current != null) {
            i2 |= state;
        }
        return z2;
    }

    @Override // d.a.l.a.d
    public boolean setVisible(boolean z, boolean z2) {
        final boolean visible = super.setVisible(z, z2);
        if (this.H != null && !visible && z2 && z) {
            this.H.c();
        }
        return setVisible(z, z2);
    }

    a(a.c cVar, Resources resources) {
        super(null);
        int i2 = -1;
        this.I = i2;
        this.J = i2;
        h(new a.c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    @Override // d.a.l.a.d
    public boolean isStateful() {
        return true;
    }
}
