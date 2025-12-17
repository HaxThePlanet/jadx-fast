package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.a;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.g2.b;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.n2.j;
import com.google.android.exoplayer2.n2.k;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.z;
import com.google.android.exoplayer2.v1;
import com.google.android.exoplayer2.v1.e;
import com.google.android.exoplayer2.v1.f;
import com.google.android.exoplayer2.video.a0;
import com.google.android.exoplayer2.x0;
import com.google.common.collect.v;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public class PlayerView extends FrameLayout {

    private final TextView A;
    private final com.google.android.exoplayer2.ui.o B;
    private final FrameLayout C;
    private final FrameLayout D;
    private v1 E;
    private boolean F;
    private com.google.android.exoplayer2.ui.o.e G;
    private boolean H;
    private Drawable I;
    private int J;
    private boolean K;
    private o<? super PlaybackException> L;
    private java.lang.CharSequence M;
    private int N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private int R;
    private boolean S;
    private final com.google.android.exoplayer2.ui.PlayerView.a a;
    private final com.google.android.exoplayer2.ui.AspectRatioFrameLayout b;
    private final View c;
    private final View v;
    private final boolean w;
    private final ImageView x;
    private final com.google.android.exoplayer2.ui.SubtitleView y;
    private final View z;

    private final class a implements v1.e, View.OnLayoutChangeListener, View.OnClickListener, com.google.android.exoplayer2.ui.o.e {

        private final g2.b a;
        private Object b;
        final com.google.android.exoplayer2.ui.PlayerView c;
        public a(com.google.android.exoplayer2.ui.PlayerView playerView) {
            this.c = playerView;
            super();
            g2.b obj1 = new g2.b();
            this.a = obj1;
        }

        @Override // com.google.android.exoplayer2.v1$e
        public void b(a0 a0) {
            PlayerView.b(this.c);
        }

        @Override // com.google.android.exoplayer2.v1$e
        public void d(v1.f v1$f, v1.f v1$f2, int i3) {
            boolean obj1;
            if (PlayerView.m(this.c) && PlayerView.n(this.c)) {
                if (PlayerView.n(this.c)) {
                    this.c.u();
                }
            }
        }

        @Override // com.google.android.exoplayer2.v1$e
        public void l(int i) {
            PlayerView.j(this.c);
            PlayerView.k(this.c);
            PlayerView.l(this.c);
        }

        @Override // com.google.android.exoplayer2.v1$e
        public void onClick(View view) {
            PlayerView.e(this.c);
        }

        @Override // com.google.android.exoplayer2.v1$e
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            PlayerView.d((TextureView)view, PlayerView.c(this.c));
        }

        @Override // com.google.android.exoplayer2.v1$e
        public void r() {
            View view;
            int i;
            if (PlayerView.g(this.c) != null) {
                PlayerView.g(this.c).setVisibility(4);
            }
        }

        @Override // com.google.android.exoplayer2.v1$e
        public void t(int i) {
            PlayerView.f(this.c);
        }

        public void u(List<c> list) {
            com.google.android.exoplayer2.ui.SubtitleView view;
            if (PlayerView.a(this.c) != null) {
                PlayerView.a(this.c).u(list);
            }
        }

        @Override // com.google.android.exoplayer2.v1$e
        public void v(boolean z, int i2) {
            PlayerView.j(this.c);
            PlayerView.l(this.c);
        }

        @Override // com.google.android.exoplayer2.v1$e
        public void w(l0 l0, k k2) {
            g2.b z;
            int i2;
            int i;
            v1 obj4;
            g2 obj5;
            obj4 = PlayerView.h(this.c);
            g.e(obj4);
            obj5 = (v1)obj4.O();
            i2 = 0;
            if (obj5.q()) {
                this.b = i2;
            } else {
                if (!obj4.M().c()) {
                    this.b = obj4.b;
                } else {
                    z = this.b;
                    z = obj5.b(z);
                    if (z != null && z != -1 && obj4.x() == obj5.c) {
                        z = obj5.b(z);
                        if (z != -1) {
                            if (obj4.x() == obj5.c) {
                            }
                        }
                        this.b = i2;
                    }
                }
            }
            PlayerView.i(this.c, false);
        }
    }
    public PlayerView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public PlayerView(Context context, AttributeSet attributeSet2, int i3) {
        Object parent;
        Resources resources;
        int indexOfChild;
        int i8;
        int i14;
        int i5;
        int i2;
        boolean z3;
        int i12;
        View viewById;
        Object viewById2;
        int i13;
        boolean z;
        int integer;
        boolean z4;
        int i;
        Object textureView;
        int i9;
        int i6;
        int i10;
        int i7;
        boolean arr;
        boolean z6;
        int i11;
        int int;
        Class<Context> from;
        int i4;
        boolean z2;
        int i15;
        boolean z5;
        int obj23;
        final com.google.android.exoplayer2.ui.PlayerView view = this;
        parent = context;
        indexOfChild = attributeSet2;
        super(context, attributeSet2, i3);
        PlayerView.a aVar = new PlayerView.a(view);
        view.a = aVar;
        int i32 = 0;
        int i35 = 0;
        if (isInEditMode()) {
            view.b = i32;
            view.c = i32;
            view.v = i32;
            view.w = i35;
            view.x = i32;
            view.y = i32;
            view.z = i32;
            view.A = i32;
            view.B = i32;
            view.C = i32;
            view.D = i32;
            ImageView imageView = new ImageView(parent);
            if (p0.a >= 23) {
                PlayerView.r(getResources(), imageView);
            } else {
                PlayerView.q(getResources(), imageView);
            }
            view.addView(imageView);
        }
        int i40 = 5000;
        int i41 = 1;
        if (indexOfChild != null) {
            TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(indexOfChild, v.B, i3, i35);
            int i44 = v.L;
            integer = styledAttributes.getInteger(v.J, 0);
            view.K = styledAttributes.getBoolean(v.G, view.K);
            styledAttributes.recycle();
            z4 = boolean4;
            z3 = z8;
            i12 = i15;
            z2 = boolean6;
            i11 = resourceId2;
            z6 = boolean5;
            arr = value;
            i6 = color;
            i = int;
            i8 = obj23;
            obj23 = int3;
            z = z5;
        } else {
            obj23 = i40;
            z3 = 1;
            i12 = 0;
            z = 1;
            integer = 0;
            z4 = 1;
            i = 1;
            i6 = 0;
            arr = 0;
            z6 = 1;
            i11 = 0;
            z2 = 1;
        }
        LayoutInflater.from(context).inflate(i8, view);
        view.setDescendantFocusability(262144);
        View viewById3 = view.findViewById(r.d);
        view.b = (AspectRatioFrameLayout)viewById3;
        if (viewById3 != null) {
            PlayerView.B(viewById3, i12);
        }
        viewById = view.findViewById(r.u);
        view.c = viewById;
        if (viewById != null && arr) {
            if (arr) {
                viewById.setBackgroundColor(i6);
            }
        }
        if (viewById3 != null && i != 0) {
            if (i != 0) {
                int i46 = -1;
                ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(i46, i46);
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            textureView = new SurfaceView(parent);
                            view.v = textureView;
                        } else {
                            i7 = 1;
                            Class[] arr2 = new Class[i7];
                            i4 = 0;
                            arr2[i4] = Context.class;
                            arr = new Object[i7];
                            arr[i4] = parent;
                            view.v = (View)Class.forName("com.google.android.exoplayer2.video.t").getConstructor(arr2).newInstance(arr);
                        }
                        i10 = 1;
                        i = 0;
                    } else {
                        i10 = 1;
                        Class[] arr3 = new Class[i10];
                        i4 = 0;
                        arr3[i4] = Context.class;
                        arr = new Object[i10];
                        arr[i4] = parent;
                        view.v = (View)Class.forName("com.google.android.exoplayer2.video.b0.l").getConstructor(arr3).newInstance(arr);
                        i = i10;
                    }
                } else {
                    i10 = 1;
                    textureView = new TextureView(parent);
                    view.v = textureView;
                }
                view.v.setLayoutParams(layoutParams2);
                view.v.setOnClickListener(aVar);
                arr = 0;
                view.v.setClickable(arr);
                viewById3.addView(view.v, arr);
                i14 = i;
            } else {
                i10 = 1;
                view.v = 0;
                i14 = 0;
            }
        } else {
        }
        view.w = i14;
        view.C = (FrameLayout)view.findViewById(r.a);
        view.D = (FrameLayout)view.findViewById(r.k);
        View viewById6 = view.findViewById(r.b);
        view.x = (ImageView)viewById6;
        if (z6 && viewById6 != null) {
            i5 = viewById6 != null ? i10 : 0;
        } else {
        }
        view.H = i5;
        if (i11 != 0) {
            view.I = a.f(getContext(), i11);
        }
        View viewById7 = view.findViewById(r.v);
        view.y = (SubtitleView)viewById7;
        if (viewById7 != null) {
            viewById7.D();
            viewById7.E();
        }
        View viewById8 = view.findViewById(r.c);
        view.z = viewById8;
        int i39 = 8;
        if (viewById8 != null) {
            viewById8.setVisibility(i39);
        }
        view.J = integer;
        View viewById9 = view.findViewById(r.h);
        view.A = (TextView)viewById9;
        if (viewById9 != null) {
            viewById9.setVisibility(i39);
        }
        int i31 = r.e;
        viewById2 = view.findViewById(i31);
        View viewById10 = view.findViewById(r.f);
        if ((o)viewById2 != null) {
            view.B = (o)viewById2;
            i9 = 0;
        } else {
            if (viewById10 != null) {
                viewById2 = new o(parent, 0, 0, indexOfChild);
                view.B = viewById2;
                viewById2.setId(i31);
                viewById2.setLayoutParams(viewById10.getLayoutParams());
                parent = viewById10.getParent();
                parent.removeView(viewById10);
                parent.addView(viewById2, (ViewGroup)parent.indexOfChild(viewById10));
            } else {
                i9 = 0;
                view.B = 0;
            }
        }
        com.google.android.exoplayer2.ui.o oVar = view.B;
        i2 = oVar != null ? obj23 : i9;
        view.N = i2;
        view.Q = z4;
        view.O = z3;
        view.P = z;
        if (z2 && oVar != null) {
            i13 = oVar != null ? i10 : i9;
        } else {
        }
        view.F = i13;
        u();
        I();
        com.google.android.exoplayer2.ui.o oVar2 = view.B;
        if (oVar2 != null) {
            oVar2.y(aVar);
        }
    }

    @RequiresNonNull("artworkView")
    private boolean A(Drawable drawable) {
        int intrinsicWidth;
        int intrinsicHeight;
        final int i = 0;
        intrinsicWidth = drawable.getIntrinsicWidth();
        intrinsicHeight = drawable.getIntrinsicHeight();
        if (drawable != null && intrinsicWidth > 0 && intrinsicHeight > 0) {
            intrinsicWidth = drawable.getIntrinsicWidth();
            intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0) {
                if (intrinsicHeight > 0) {
                    y(this.b, f /= f2);
                    this.x.setImageDrawable(drawable);
                    this.x.setVisibility(i);
                    return 1;
                }
            }
        }
        return i;
    }

    private static void B(com.google.android.exoplayer2.ui.AspectRatioFrameLayout aspectRatioFrameLayout, int i2) {
        aspectRatioFrameLayout.setResizeMode(i2);
    }

    private boolean C() {
        int i;
        int i2;
        boolean z;
        v1 v1Var = this.E;
        i2 = 1;
        if (v1Var == null) {
            return i2;
        }
        i = v1Var.E();
        if (this.O) {
            if (i != i2 && i != 4) {
                if (i != 4) {
                    if (!this.E.l()) {
                    } else {
                        i2 = 0;
                    }
                }
            }
        } else {
        }
        return i2;
    }

    private void E(boolean z) {
        int obj2;
        if (!N()) {
        }
        obj2 = z ? 0 : this.N;
        this.B.setShowTimeoutMs(obj2);
        this.B.Q();
    }

    private boolean F() {
        boolean z;
        boolean z2;
        if (N()) {
            if (this.E == null) {
            } else {
                final int i2 = 1;
                if (!this.B.I()) {
                    x(i2);
                } else {
                    if (this.Q) {
                        this.B.F();
                    }
                }
            }
            return i2;
        }
        return 0;
    }

    private void G() {
        a0 a0Var;
        View view;
        int i4;
        int cmp;
        int i;
        boolean i3;
        int i2;
        v1 v1Var = this.E;
        if (v1Var != null) {
            a0Var = v1Var.s();
        } else {
            a0Var = a0.e;
        }
        int i5 = a0Var.a;
        int i7 = a0Var.b;
        final int i9 = a0Var.c;
        i2 = 0;
        if (i7 != 0) {
            if (i5 == 0) {
                i4 = i2;
            } else {
                i6 /= a0Var;
            }
        } else {
        }
        view = this.v;
        if (view instanceof TextureView != null && Float.compare(i4, i2) > 0) {
            if (Float.compare(i4, i2) > 0) {
                if (i9 != 90) {
                    if (i9 == 270) {
                        i4 = cmp;
                    }
                } else {
                }
            }
            if (this.R != 0) {
                view.removeOnLayoutChangeListener(this.a);
            }
            this.R = i9;
            if (i9 != 0) {
                this.v.addOnLayoutChangeListener(this.a);
            }
            PlayerView.o((TextureView)this.v, this.R);
        }
        if (this.w) {
        } else {
            i2 = i4;
        }
        y(this.b, i2);
    }

    private void H() {
        v1 v1Var;
        View view;
        int i3;
        int i;
        int i2;
        if (this.z != null) {
            v1Var = this.E;
            i2 = 2;
            if (v1Var != null && v1Var.E() == i2) {
                i2 = 2;
                if (v1Var.E() == i2) {
                    v1Var = this.J;
                    if (v1Var != i2) {
                        if (v1Var == 1 && this.E.l()) {
                            if (this.E.l()) {
                            } else {
                                i3 = i;
                            }
                        } else {
                        }
                    }
                } else {
                }
            } else {
            }
            if (i3 != 0) {
            } else {
                i = 8;
            }
            this.z.setVisibility(i);
        }
    }

    private void I() {
        String resources;
        int string;
        boolean z;
        resources = this.B;
        if (resources != null) {
            if (!this.F) {
                setContentDescription(0);
            } else {
                if (resources.getVisibility() == 0) {
                    if (this.Q) {
                        string = getResources().getString(u.a);
                    }
                    setContentDescription(string);
                } else {
                    setContentDescription(getResources().getString(u.e));
                }
            }
        } else {
        }
    }

    private void J() {
        boolean z;
        if (w() && this.P) {
            if (this.P) {
                u();
            } else {
                x(false);
            }
        } else {
        }
    }

    private void K() {
        TextView view;
        int i;
        TextView view2;
        Object charSequence;
        int i2;
        view = this.A;
        charSequence = this.M;
        i2 = 0;
        if (view != null && charSequence != null) {
            charSequence = this.M;
            i2 = 0;
            if (charSequence != null) {
                view.setText(charSequence);
                this.A.setVisibility(i2);
            }
            v1 v1Var = this.E;
            if (v1Var != null) {
                i = v1Var.z();
            } else {
                i = 0;
            }
            charSequence = this.L;
            if (i != 0 && charSequence != null) {
                charSequence = this.L;
                if (charSequence != null) {
                    this.A.setText((CharSequence)pair.second);
                    this.A.setVisibility(i2);
                } else {
                    this.A.setVisibility(8);
                }
            } else {
            }
        }
    }

    private void L(boolean z) {
        boolean z2;
        int i3;
        j jVar;
        int i2;
        int length;
        int i;
        boolean obj8;
        final v1 v1Var = this.E;
        if (v1Var != null) {
            if (v1Var.M().c()) {
            } else {
                if (z && !this.K) {
                    if (!this.K) {
                        p();
                    }
                }
                obj8 = v1Var.V();
                int i4 = 0;
                i3 = i4;
                while (i3 < obj8.a) {
                    jVar = obj8.a(i3);
                    if (jVar != null) {
                    } else {
                    }
                    i3++;
                    i2 = i4;
                    while (i2 < jVar.length()) {
                        i2++;
                    }
                    i2++;
                }
                p();
                if (M() && z(v1Var.X())) {
                    if (z(v1Var.X())) {
                    }
                    if (A(this.I)) {
                    }
                }
            }
            t();
        }
        if (!this.K) {
            t();
            p();
        }
    }

    @EnsuresNonNullIf(expression = "artworkView", result = true)
    private boolean M() {
        if (this.H) {
            g.h(this.x);
            return 1;
        }
        return 0;
    }

    @EnsuresNonNullIf(expression = "controller", result = true)
    private boolean N() {
        if (this.F) {
            g.h(this.B);
            return 1;
        }
        return 0;
    }

    static com.google.android.exoplayer2.ui.SubtitleView a(com.google.android.exoplayer2.ui.PlayerView playerView) {
        return playerView.y;
    }

    static void b(com.google.android.exoplayer2.ui.PlayerView playerView) {
        playerView.G();
    }

    static int c(com.google.android.exoplayer2.ui.PlayerView playerView) {
        return playerView.R;
    }

    static void d(TextureView textureView, int i2) {
        PlayerView.o(textureView, i2);
    }

    static boolean e(com.google.android.exoplayer2.ui.PlayerView playerView) {
        return playerView.F();
    }

    static void f(com.google.android.exoplayer2.ui.PlayerView playerView) {
        playerView.I();
    }

    static View g(com.google.android.exoplayer2.ui.PlayerView playerView) {
        return playerView.c;
    }

    static v1 h(com.google.android.exoplayer2.ui.PlayerView playerView) {
        return playerView.E;
    }

    static void i(com.google.android.exoplayer2.ui.PlayerView playerView, boolean z2) {
        playerView.L(z2);
    }

    static void j(com.google.android.exoplayer2.ui.PlayerView playerView) {
        playerView.H();
    }

    static void k(com.google.android.exoplayer2.ui.PlayerView playerView) {
        playerView.K();
    }

    static void l(com.google.android.exoplayer2.ui.PlayerView playerView) {
        playerView.J();
    }

    static boolean m(com.google.android.exoplayer2.ui.PlayerView playerView) {
        return playerView.w();
    }

    static boolean n(com.google.android.exoplayer2.ui.PlayerView playerView) {
        return playerView.P;
    }

    private static void o(TextureView textureView, int i2) {
        float i3;
        float i4;
        int rectF;
        int cmp;
        int i;
        float obj7;
        Matrix matrix = new Matrix();
        i3 = (float)width;
        i4 = (float)height;
        rectF = 0;
        if (Float.compare(i3, rectF) != 0 && Float.compare(i4, rectF) != 0 && i2 != 0) {
            if (Float.compare(i4, rectF) != 0) {
                if (i2 != 0) {
                    int i5 = 1073741824;
                    i = i3 / i5;
                    cmp = i4 / i5;
                    matrix.postRotate((float)i2, i, cmp);
                    obj7 = new RectF(rectF, rectF, i3, i4);
                    rectF = new RectF();
                    matrix.mapRect(rectF, obj7);
                    matrix.postScale(i3 /= obj7, i4 /= obj7, i, cmp);
                }
            }
        }
        textureView.setTransform(matrix);
    }

    private void p() {
        int i;
        final View view = this.c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private static void q(Resources resources, ImageView imageView2) {
        imageView2.setImageDrawable(resources.getDrawable(q.f));
        imageView2.setBackgroundColor(resources.getColor(p.a));
    }

    private static void r(Resources resources, ImageView imageView2) {
        final int i3 = 0;
        imageView2.setImageDrawable(resources.getDrawable(q.f, i3));
        imageView2.setBackgroundColor(resources.getColor(p.a, i3));
    }

    private void t() {
        ImageView view;
        int i;
        view = this.x;
        if (view != null) {
            view.setImageResource(17170445);
            this.x.setVisibility(4);
        }
    }

    private boolean v(int i) {
        int i2;
        int obj2;
        if (i != 19 && i != 270 && i != 22 && i != 271 && i != 20 && i != 269 && i != 21 && i != 268) {
            if (i != 270) {
                if (i != 22) {
                    if (i != 271) {
                        if (i != 20) {
                            if (i != 269) {
                                if (i != 21) {
                                    if (i != 268) {
                                        if (i == 23) {
                                            obj2 = 1;
                                        } else {
                                            obj2 = 0;
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    private boolean w() {
        int i;
        v1 v1Var;
        v1Var = this.E;
        if (v1Var != null && v1Var.h() && this.E.l()) {
            if (v1Var.h()) {
                i = this.E.l() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private void x(boolean z) {
        boolean z4;
        boolean z2;
        boolean showTimeoutMs;
        boolean z3;
        if (w() && this.P) {
            if (this.P) {
            }
        }
        if (N()) {
            if (this.B.I() && this.B.getShowTimeoutMs() <= 0) {
                z2 = this.B.getShowTimeoutMs() <= 0 ? 1 : 0;
            } else {
            }
            z3 = C();
            if (!z && z2 == 0) {
                if (z2 == 0) {
                    if (z3) {
                        E(z3);
                    }
                } else {
                }
            } else {
            }
        }
    }

    @RequiresNonNull("artworkView")
    private boolean z(n1 n1) {
        byte[] obj3 = n1.k;
        int i = 0;
        if (obj3 == null) {
            return i;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(obj3, i, obj3.length));
        return A(bitmapDrawable);
    }

    @Override // android.widget.FrameLayout
    public void D() {
        E(C());
    }

    @Override // android.widget.FrameLayout
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        v1 v1Var;
        int i;
        boolean z;
        KeyEvent obj5;
        v1Var = this.E;
        if (v1Var != null && v1Var.h()) {
            if (v1Var.h()) {
                return super.dispatchKeyEvent(keyEvent);
            }
        }
        boolean z2 = v(keyEvent.getKeyCode());
        i = 0;
        final int i2 = 1;
        if (z2 && N() && !this.B.I()) {
            if (N()) {
                if (!this.B.I()) {
                    x(i2);
                    i = i2;
                } else {
                    if (!s(keyEvent)) {
                        if (super.dispatchKeyEvent(keyEvent)) {
                            x(i2);
                        } else {
                            if (z2 && N()) {
                                if (N()) {
                                    x(i2);
                                }
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public List<com.google.android.exoplayer2.ui.i> getAdOverlayInfos() {
        com.google.android.exoplayer2.ui.i iVar;
        int i;
        String str;
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.D;
        if (frameLayout != null) {
            iVar = new i(frameLayout, 3, "Transparent overlay does not impact viewability");
            arrayList.add(iVar);
        }
        com.google.android.exoplayer2.ui.o oVar = this.B;
        if (oVar != null) {
            iVar = new i(oVar, 0);
            arrayList.add(iVar);
        }
        return v.u(arrayList);
    }

    @Override // android.widget.FrameLayout
    public ViewGroup getAdViewGroup() {
        final FrameLayout frameLayout = this.C;
        g.i(frameLayout, "exo_ad_overlay must be present for ad playback");
        return (ViewGroup)frameLayout;
    }

    @Override // android.widget.FrameLayout
    public boolean getControllerAutoShow() {
        return this.O;
    }

    @Override // android.widget.FrameLayout
    public boolean getControllerHideOnTouch() {
        return this.Q;
    }

    @Override // android.widget.FrameLayout
    public int getControllerShowTimeoutMs() {
        return this.N;
    }

    @Override // android.widget.FrameLayout
    public Drawable getDefaultArtwork() {
        return this.I;
    }

    @Override // android.widget.FrameLayout
    public FrameLayout getOverlayFrameLayout() {
        return this.D;
    }

    @Override // android.widget.FrameLayout
    public v1 getPlayer() {
        return this.E;
    }

    @Override // android.widget.FrameLayout
    public int getResizeMode() {
        g.h(this.b);
        return this.b.getResizeMode();
    }

    @Override // android.widget.FrameLayout
    public com.google.android.exoplayer2.ui.SubtitleView getSubtitleView() {
        return this.y;
    }

    @Override // android.widget.FrameLayout
    public boolean getUseArtwork() {
        return this.H;
    }

    @Override // android.widget.FrameLayout
    public boolean getUseController() {
        return this.F;
    }

    @Override // android.widget.FrameLayout
    public View getVideoSurfaceView() {
        return this.v;
    }

    @Override // android.widget.FrameLayout
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        final int i2 = 0;
        if (N()) {
            if (this.E == null) {
            } else {
                int obj3 = motionEvent.getAction();
                int i = 1;
                if (obj3 != null && obj3 != i) {
                    if (obj3 != i) {
                        return i2;
                    }
                    if (this.S) {
                        this.S = i2;
                        performClick();
                        return i;
                    }
                    return i2;
                }
            }
            this.S = i;
            return i;
        }
        return i2;
    }

    @Override // android.widget.FrameLayout
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        boolean obj1;
        if (N() && this.E == null) {
            if (this.E == null) {
            }
            obj1 = 1;
            x(obj1);
            return obj1;
        }
        return 0;
    }

    @Override // android.widget.FrameLayout
    public boolean performClick() {
        super.performClick();
        return F();
    }

    @Override // android.widget.FrameLayout
    public boolean s(KeyEvent keyEvent) {
        boolean z;
        KeyEvent obj2;
        if (N() && this.B.A(keyEvent)) {
            obj2 = this.B.A(keyEvent) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // android.widget.FrameLayout
    public void setAspectRatioListener(com.google.android.exoplayer2.ui.AspectRatioFrameLayout.b aspectRatioFrameLayout$b) {
        g.h(this.b);
        this.b.setAspectRatioListener(b);
    }

    @Deprecated
    public void setControlDispatcher(x0 x0) {
        g.h(this.B);
        this.B.setControlDispatcher(x0);
    }

    @Override // android.widget.FrameLayout
    public void setControllerAutoShow(boolean z) {
        this.O = z;
    }

    @Override // android.widget.FrameLayout
    public void setControllerHideDuringAds(boolean z) {
        this.P = z;
    }

    @Override // android.widget.FrameLayout
    public void setControllerHideOnTouch(boolean z) {
        g.h(this.B);
        this.Q = z;
        I();
    }

    @Override // android.widget.FrameLayout
    public void setControllerShowTimeoutMs(int i) {
        g.h(this.B);
        this.N = i;
        if (this.B.I()) {
            D();
        }
    }

    @Override // android.widget.FrameLayout
    public void setControllerVisibilityListener(com.google.android.exoplayer2.ui.o.e o$e) {
        Object eVar;
        com.google.android.exoplayer2.ui.o oVar;
        g.h(this.B);
        eVar = this.G;
        if (eVar == e) {
        }
        if (eVar != null) {
            this.B.K(eVar);
        }
        this.G = e;
        if (e != null) {
            this.B.y(e);
        }
    }

    @Override // android.widget.FrameLayout
    public void setCustomErrorMessage(java.lang.CharSequence charSequence) {
        int i;
        i = this.A != null ? 1 : 0;
        g.f(i);
        this.M = charSequence;
        K();
    }

    @Override // android.widget.FrameLayout
    public void setDefaultArtwork(Drawable drawable) {
        Drawable obj2;
        if (this.I != drawable) {
            this.I = drawable;
            L(false);
        }
    }

    public void setErrorMessageProvider(o<? super PlaybackException> o) {
        if (this.L != o) {
            this.L = o;
            K();
        }
    }

    @Override // android.widget.FrameLayout
    public void setKeepContentOnPlayerReset(boolean z) {
        boolean obj2;
        if (this.K != z) {
            this.K = z;
            L(false);
        }
    }

    @Override // android.widget.FrameLayout
    public void setPlayer(v1 v1) {
        int i2;
        int i;
        boolean z;
        boolean z2;
        com.google.android.exoplayer2.ui.SubtitleView view;
        Looper mainLooper;
        boolean i3;
        boolean z3;
        boolean z4;
        final int i5 = 1;
        final int i6 = 0;
        i2 = Looper.myLooper() == Looper.getMainLooper() ? i5 : i6;
        g.f(i2);
        if (v1 != null) {
            if (v1.P() == Looper.getMainLooper()) {
                i = i5;
            } else {
                i = i6;
            }
        } else {
        }
        g.a(i);
        v1 v1Var = this.E;
        if (v1Var == v1) {
        }
        i3 = 26;
        v1Var.t(this.a);
        if (v1Var != null && v1Var.I(i3)) {
            v1Var.t(this.a);
            if (v1Var.I(i3)) {
                z3 = this.v;
                if (z3 instanceof TextureView != null) {
                    v1Var.r((TextureView)z3);
                } else {
                    if (z3 instanceof SurfaceView != null) {
                        v1Var.K((SurfaceView)z3);
                    }
                }
            }
        }
        com.google.android.exoplayer2.ui.SubtitleView view2 = this.y;
        if (view2 != null) {
            view2.setCues(0);
        }
        this.E = v1;
        if (N()) {
            this.B.setPlayer(v1);
        }
        H();
        K();
        L(i5);
        if (v1 != null) {
            if (v1.I(i3)) {
                z2 = this.v;
                if (z2 instanceof TextureView != null) {
                    v1.U((TextureView)z2);
                } else {
                    if (z2 instanceof SurfaceView != null) {
                        v1.v((SurfaceView)z2);
                    }
                }
                G();
            }
            if (this.y != null && v1.I(27)) {
                if (v1.I(27)) {
                    this.y.setCues(v1.G());
                }
            }
            v1.D(this.a);
            x(i6);
        } else {
            u();
        }
    }

    @Override // android.widget.FrameLayout
    public void setRepeatToggleModes(int i) {
        g.h(this.B);
        this.B.setRepeatToggleModes(i);
    }

    @Override // android.widget.FrameLayout
    public void setResizeMode(int i) {
        g.h(this.b);
        this.b.setResizeMode(i);
    }

    @Override // android.widget.FrameLayout
    public void setShowBuffering(int i) {
        if (this.J != i) {
            this.J = i;
            H();
        }
    }

    @Override // android.widget.FrameLayout
    public void setShowFastForwardButton(boolean z) {
        g.h(this.B);
        this.B.setShowFastForwardButton(z);
    }

    @Override // android.widget.FrameLayout
    public void setShowMultiWindowTimeBar(boolean z) {
        g.h(this.B);
        this.B.setShowMultiWindowTimeBar(z);
    }

    @Override // android.widget.FrameLayout
    public void setShowNextButton(boolean z) {
        g.h(this.B);
        this.B.setShowNextButton(z);
    }

    @Override // android.widget.FrameLayout
    public void setShowPreviousButton(boolean z) {
        g.h(this.B);
        this.B.setShowPreviousButton(z);
    }

    @Override // android.widget.FrameLayout
    public void setShowRewindButton(boolean z) {
        g.h(this.B);
        this.B.setShowRewindButton(z);
    }

    @Override // android.widget.FrameLayout
    public void setShowShuffleButton(boolean z) {
        g.h(this.B);
        this.B.setShowShuffleButton(z);
    }

    @Override // android.widget.FrameLayout
    public void setShutterBackgroundColor(int i) {
        final View view = this.c;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    @Override // android.widget.FrameLayout
    public void setUseArtwork(boolean z) {
        int i;
        ImageView view;
        final int i2 = 0;
        if (z) {
            if (this.x != null) {
                i = 1;
            } else {
                i = i2;
            }
        } else {
        }
        g.f(i);
        if (this.H != z) {
            this.H = z;
            L(i2);
        }
    }

    @Override // android.widget.FrameLayout
    public void setUseController(boolean z) {
        int i;
        boolean z2;
        com.google.android.exoplayer2.ui.o oVar;
        com.google.android.exoplayer2.ui.o obj2;
        if (z) {
            if (this.B != null) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        g.f(i);
        if (this.F == z) {
        }
        this.F = z;
        if (N()) {
            this.B.setPlayer(this.E);
        } else {
            obj2 = this.B;
            if (obj2 != null) {
                obj2.F();
                this.B.setPlayer(0);
            }
        }
        I();
    }

    @Override // android.widget.FrameLayout
    public void setVisibility(int i) {
        super.setVisibility(i);
        final View view = this.v;
        if (view instanceof SurfaceView != null) {
            view.setVisibility(i);
        }
    }

    @Override // android.widget.FrameLayout
    public void u() {
        final com.google.android.exoplayer2.ui.o oVar = this.B;
        if (oVar != null) {
            oVar.F();
        }
    }

    @Override // android.widget.FrameLayout
    protected void y(com.google.android.exoplayer2.ui.AspectRatioFrameLayout aspectRatioFrameLayout, float f2) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f2);
        }
    }
}
