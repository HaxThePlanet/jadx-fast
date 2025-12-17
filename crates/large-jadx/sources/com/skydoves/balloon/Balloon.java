package com.skydoves.balloon;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.method.MovementMethod;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.g;
import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.skydoves.balloon.a0.a;
import com.skydoves.balloon.a0.b;
import com.skydoves.balloon.a0.d;
import com.skydoves.balloon.a0.e;
import com.skydoves.balloon.overlay.BalloonAnchorOverlayView;
import com.skydoves.balloon.overlay.a;
import com.skydoves.balloon.overlay.c;
import com.skydoves.balloon.overlay.e;
import com.skydoves.balloon.radius.RadiusLayout;
import com.skydoves.balloon.vectortext.VectorTextView;
import com.skydoves.balloon.z.a;
import com.skydoves.balloon.z.b;
import d.h.l.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.e0.a;
import kotlin.h;
import kotlin.h0.g;
import kotlin.j;
import kotlin.m;
import kotlin.o;
import kotlin.w;
import kotlin.y.h0;
import kotlin.y.p;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001:\u0002\u0097\u0001B\u001d\u0012\u0008\u0010\u0095\u0001\u001a\u00030\u0092\u0001\u0012\u0008\u0010\u0089\u0001\u001a\u00030\u0087\u0001¢\u0006\u0006\u0008 \u0001\u0010¡\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u000cH\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012J'\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0002¢\u0006\u0004\u0008\u0018\u0010\u0019J+\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u000c0\u001a2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0002¢\u0006\u0004\u0008\u001b\u0010\u001cJ'\u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000c2\u0006\u0010 \u001a\u00020\u000cH\u0002¢\u0006\u0004\u0008!\u0010\"J\u0017\u0010#\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008#\u0010\u0012J\u0017\u0010$\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008$\u0010%J\u0017\u0010&\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008&\u0010%J\u000f\u0010'\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008(\u0010\u0004J\u000f\u0010)\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008)\u0010\u0004J\u000f\u0010*\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008*\u0010\u0004J\u000f\u0010+\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008+\u0010\u0004J\u000f\u0010,\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008,\u0010\u0004J\u000f\u0010-\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008-\u0010\u0004J\u000f\u0010.\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008.\u0010\u0004J\u000f\u00100\u001a\u00020/H\u0002¢\u0006\u0004\u00080\u00101J\u000f\u00102\u001a\u00020\u0002H\u0002¢\u0006\u0004\u00082\u0010\u0004J\u000f\u00103\u001a\u00020\u0002H\u0002¢\u0006\u0004\u00083\u0010\u0004J\u000f\u00104\u001a\u00020\u0002H\u0002¢\u0006\u0004\u00084\u0010\u0004J\u000f\u00105\u001a\u00020\u0002H\u0002¢\u0006\u0004\u00085\u0010\u0004J\u0011\u00107\u001a\u0004\u0018\u000106H\u0002¢\u0006\u0004\u00087\u00108J\u000f\u00109\u001a\u00020\u0002H\u0002¢\u0006\u0004\u00089\u0010\u0004J\u000f\u0010:\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008:\u0010\u0004J\u0017\u0010;\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008;\u0010\u0012J\u001f\u0010?\u001a\u00020\u00022\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008?\u0010@J\u0017\u0010A\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\u0008A\u0010\u0008J\u001f\u0010C\u001a\u00020\u000c2\u0006\u0010B\u001a\u00020\u000c2\u0006\u0010>\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008C\u0010DJ+\u0010G\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0008\u0008\u0002\u0010E\u001a\u00020\u000c2\u0008\u0008\u0002\u0010F\u001a\u00020\u000cH\u0007¢\u0006\u0004\u0008G\u0010HJ+\u0010I\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0008\u0008\u0002\u0010E\u001a\u00020\u000c2\u0008\u0008\u0002\u0010F\u001a\u00020\u000cH\u0007¢\u0006\u0004\u0008I\u0010HJ\r\u0010J\u001a\u00020\u0002¢\u0006\u0004\u0008J\u0010\u0004J\u0015\u0010M\u001a\u00020/2\u0006\u0010L\u001a\u00020K¢\u0006\u0004\u0008M\u0010NJ\u0017\u0010Q\u001a\u00020\u00022\u0008\u0010P\u001a\u0004\u0018\u00010O¢\u0006\u0004\u0008Q\u0010RJ\u0017\u0010U\u001a\u00020\u00022\u0008\u0010T\u001a\u0004\u0018\u00010S¢\u0006\u0004\u0008U\u0010VJ!\u0010Y\u001a\u00020\u00022\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020W¢\u0006\u0004\u0008Y\u0010ZJ\u0017\u0010]\u001a\u00020\u00022\u0008\u0010\\\u001a\u0004\u0018\u00010[¢\u0006\u0004\u0008]\u0010^J\u001b\u0010`\u001a\u00020\u00022\u000c\u0010X\u001a\u0008\u0012\u0004\u0012\u00020\u00020_¢\u0006\u0004\u0008`\u0010aJ\u0017\u0010d\u001a\u00020\u00022\u0008\u0010c\u001a\u0004\u0018\u00010b¢\u0006\u0004\u0008d\u0010eJ\u0017\u0010h\u001a\u00020\u00022\u0008\u0010g\u001a\u0004\u0018\u00010f¢\u0006\u0004\u0008h\u0010iJ\u0017\u0010j\u001a\u00020\u00022\u0008\u0010g\u001a\u0004\u0018\u00010f¢\u0006\u0004\u0008j\u0010iJ\u0017\u0010m\u001a\u00020\u00022\u0008\u0010l\u001a\u0004\u0018\u00010k¢\u0006\u0004\u0008m\u0010nJ\r\u0010o\u001a\u00020\u000c¢\u0006\u0004\u0008o\u0010\u000eJ\r\u0010p\u001a\u00020\u000c¢\u0006\u0004\u0008p\u0010\u000eJ\r\u0010q\u001a\u00020\u0005¢\u0006\u0004\u0008q\u0010rJ\u000f\u0010s\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008s\u0010\u0004J\u000f\u0010t\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008t\u0010\u0004R\u001d\u0010z\u001a\u00020u8B@\u0002X\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008v\u0010w\u001a\u0004\u0008x\u0010yR\u001d\u0010\u007f\u001a\u00020{8B@\u0002X\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008|\u0010w\u001a\u0004\u0008}\u0010~R\"\u0010\u0084\u0001\u001a\u00030\u0080\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\u0008\u0081\u0001\u0010w\u001a\u0006\u0008\u0082\u0001\u0010\u0083\u0001R$\u0010T\u001a\u0004\u0018\u00010S2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010S8\u0006@FX\u0087\u000e¢\u0006\u0007\n\u0005\u0008\u0016\u0010\u0086\u0001R\u0019\u0010\u0089\u0001\u001a\u00030\u0087\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\u0008\u0018\u0010\u0088\u0001R(\u0010\u008c\u0001\u001a\u00020/2\u0007\u0010\u0085\u0001\u001a\u00020/8\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0005\u0008\u008a\u0001\u00100\u001a\u0005\u0008\u008b\u0001\u00101R\u0017\u0010\u008d\u0001\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0015\u00100R\u001a\u0010\u0091\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008\u008f\u0001\u0010\u0090\u0001R\u001a\u0010\u0095\u0001\u001a\u00030\u0092\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008\u0093\u0001\u0010\u0094\u0001R\u001a\u0010\u0099\u0001\u001a\u00030\u0096\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008\u0097\u0001\u0010\u0098\u0001R\u001a\u0010\u009b\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008\u009a\u0001\u0010\u0090\u0001R\u001a\u0010\u009f\u0001\u001a\u00030\u009c\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008\u009d\u0001\u0010\u009e\u0001¨\u0006¢\u0001", d2 = {"Lcom/skydoves/balloon/Balloon;", "Landroidx/lifecycle/p;", "Lkotlin/w;", "I", "()V", "Landroid/view/ViewGroup;", "parent", "F", "(Landroid/view/ViewGroup;)V", "", "Y", "()F", "", "T", "()I", "Landroid/view/View;", "anchor", "a0", "(Landroid/view/View;)V", "Landroidx/appcompat/widget/AppCompatImageView;", "imageView", "x", "y", "Landroid/graphics/Bitmap;", "D", "(Landroidx/appcompat/widget/AppCompatImageView;FF)Landroid/graphics/Bitmap;", "Lkotlin/o;", "R", "(FF)Lkotlin/o;", "Landroid/graphics/drawable/Drawable;", "drawable", "width", "height", "L", "(Landroid/graphics/drawable/Drawable;II)Landroid/graphics/Bitmap;", "E", "M", "(Landroid/view/View;)F", "N", "b0", "h0", "e0", "g0", "c0", "j0", "k0", "d0", "", "Z", "()Z", "i0", "f0", "G", "H", "Landroid/view/animation/Animation;", "P", "()Landroid/view/animation/Animation;", "z0", "A0", "y0", "Landroidx/appcompat/widget/AppCompatTextView;", "textView", "rootView", "m0", "(Landroidx/appcompat/widget/AppCompatTextView;Landroid/view/View;)V", "B0", "measuredWidth", "W", "(ILandroid/view/View;)I", "xOff", "yOff", "x0", "(Landroid/view/View;II)V", "w0", "J", "", "delay", "K", "(J)Z", "Lcom/skydoves/balloon/o;", "onBalloonClickListener", "n0", "(Lcom/skydoves/balloon/o;)V", "Lcom/skydoves/balloon/q;", "onBalloonInitializedListener", "q0", "(Lcom/skydoves/balloon/q;)V", "Lkotlin/Function1;", "block", "r0", "(Lkotlin/d0/c/l;)V", "Lcom/skydoves/balloon/p;", "onBalloonDismissListener", "o0", "(Lcom/skydoves/balloon/p;)V", "Lkotlin/Function0;", "p0", "(Lkotlin/d0/c/a;)V", "Lcom/skydoves/balloon/r;", "onBalloonOutsideTouchListener", "s0", "(Lcom/skydoves/balloon/r;)V", "Landroid/view/View$OnTouchListener;", "onTouchListener", "v0", "(Landroid/view/View$OnTouchListener;)V", "u0", "Lcom/skydoves/balloon/s;", "onBalloonOverlayClickListener", "t0", "(Lcom/skydoves/balloon/s;)V", "X", "V", "S", "()Landroid/view/ViewGroup;", "onPause", "onDestroy", "Landroid/os/Handler;", "z", "Lkotlin/h;", "U", "()Landroid/os/Handler;", "handler", "Lcom/skydoves/balloon/d;", "A", "O", "()Lcom/skydoves/balloon/d;", "autoDismissRunnable", "Lcom/skydoves/balloon/k;", "B", "Q", "()Lcom/skydoves/balloon/k;", "balloonPersistence", "<set-?>", "Lcom/skydoves/balloon/q;", "Lcom/skydoves/balloon/Balloon$a;", "Lcom/skydoves/balloon/Balloon$a;", "builder", "w", "l0", "isShowing", "destroyed", "Landroid/widget/PopupWindow;", "c", "Landroid/widget/PopupWindow;", "bodyWindow", "Landroid/content/Context;", "C", "Landroid/content/Context;", "context", "Lcom/skydoves/balloon/z/a;", "a", "Lcom/skydoves/balloon/z/a;", "binding", "v", "overlayWindow", "Lcom/skydoves/balloon/z/b;", "b", "Lcom/skydoves/balloon/z/b;", "overlayBinding", "<init>", "(Landroid/content/Context;Lcom/skydoves/balloon/Balloon$a;)V", "balloon_release"}, k = 1, mv = {1, 4, 2})
public final class Balloon implements p {

    private final h A;
    private final h B;
    private final Context C;
    private final com.skydoves.balloon.Balloon.a D;
    private final a a;
    private final b b;
    private final PopupWindow c;
    private final PopupWindow v;
    private boolean w;
    private boolean x;
    public com.skydoves.balloon.q y;
    private final h z;

    public static final class a {

        public int A;
        public com.skydoves.balloon.h A0 = 500;
        public int B;
        public int B0 = Integer.MIN_VALUE;
        public int C;
        public long C0;
        public float D = 2.5f;
        public String D0;
        public float E;
        public int E0 = 1;
        public int F = -16777216;
        public a<w> F0;
        public Drawable G;
        public boolean G0 = false;
        public float H;
        public int H0;
        public java.lang.CharSequence I;
        public boolean I0 = true;
        public int J = -1;
        public boolean J0 = true;
        public boolean K;
        private final Context K0;
        public MovementMethod L;
        public float M = 12f;
        public int N;
        public Typeface O;
        public int P = 17;
        public com.skydoves.balloon.y Q;
        public Drawable R;
        public com.skydoves.balloon.n S = 17;
        public int T;
        public int U;
        public int V;
        public int W = Integer.MIN_VALUE;
        public com.skydoves.balloon.m X;
        public float Y = 1f;
        public float Z;
        public int a = Integer.MIN_VALUE;
        public View a0;
        public int b;
        public Integer b0;
        public int c;
        public boolean c0;
        public float d;
        public int d0;
        public float e;
        public float e0;
        public float f;
        public Point f0;
        public int g = Integer.MIN_VALUE;
        public e g0;
        public int h;
        public com.skydoves.balloon.o h0;
        public int i;
        public com.skydoves.balloon.p i0;
        public int j;
        public com.skydoves.balloon.q j0;
        public int k;
        public com.skydoves.balloon.r k0;
        public int l;
        public View.OnTouchListener l0;
        public int m;
        public View.OnTouchListener m0;
        public int n;
        public com.skydoves.balloon.s n0;
        public int o;
        public boolean o0 = true;
        public boolean p = true;
        public boolean p0;
        public int q = Integer.MIN_VALUE;
        public boolean q0;
        public boolean r;
        public boolean r0 = true;
        public int s;
        public boolean s0;
        public float t = 0.5f;
        public long t0 = -1;
        public com.skydoves.balloon.c u = 1056964608;
        public q u0;
        public com.skydoves.balloon.b v = 1056964608;
        public int v0 = Integer.MIN_VALUE;
        public com.skydoves.balloon.a w = 1056964608;
        public int w0 = Integer.MIN_VALUE;
        public Drawable x;
        public com.skydoves.balloon.f x0 = -1;
        public int y;
        public a y0 = -1;
        public int z;
        public long z0 = 500;
        public a(Context context) {
            n.f(context, "context");
            super();
            this.K0 = context;
            int i = Integer.MIN_VALUE;
            this.c = point.x;
            int i3 = 1;
            Resources system3 = Resources.getSystem();
            final String str5 = "Resources.getSystem()";
            n.e(system3, str5);
            this.s = a.b(TypedValue.applyDimension(i3, (float)i4, system3.getDisplayMetrics()));
            int i6 = 1056964608;
            com.skydoves.balloon.c aLIGN_BALLOON = c.ALIGN_BALLOON;
            com.skydoves.balloon.b aLIGN_ANCHOR = b.ALIGN_ANCHOR;
            com.skydoves.balloon.a bOTTOM = a.BOTTOM;
            int i7 = 1075838976;
            int i8 = -16777216;
            Resources system = Resources.getSystem();
            n.e(system, str5);
            this.H = TypedValue.applyDimension(i3, 1084227584, system.getDisplayMetrics());
            this.I = "";
            int i9 = -1;
            int i10 = 1094713344;
            int i11 = 17;
            com.skydoves.balloon.n sTART = n.START;
            float f2 = (float)i12;
            Resources system4 = Resources.getSystem();
            n.e(system4, str5);
            this.T = a.b(TypedValue.applyDimension(i3, f2, system4.getDisplayMetrics()));
            Resources system5 = Resources.getSystem();
            n.e(system5, str5);
            this.U = a.b(TypedValue.applyDimension(i3, f2, system5.getDisplayMetrics()));
            Resources system6 = Resources.getSystem();
            n.e(system6, str5);
            this.V = a.b(TypedValue.applyDimension(i3, (float)i14, system6.getDisplayMetrics()));
            int i16 = 1065353216;
            Resources system2 = Resources.getSystem();
            n.e(system2, str5);
            this.Z = TypedValue.applyDimension(i3, 1073741824, system2.getDisplayMetrics());
            this.g0 = c.a;
            int i17 = -1;
            com.skydoves.balloon.f fADE = f.FADE;
            a fADE2 = a.FADE;
            int i18 = 500;
            com.skydoves.balloon.h nONE = h.NONE;
            Resources obj6 = context.getResources();
            n.e(obj6, "context.resources");
            obj6 = obj6.getConfiguration();
            n.e(obj6, "context.resources.configuration");
            obj6 = obj6.getLayoutDirection() == i3 ? i3 : obj6;
            this.H0 = l.b(i3, false);
        }

        public final com.skydoves.balloon.Balloon.a A(int i) {
            final String obj2 = this.K0.getString(i);
            n.e(obj2, "context.getString(value)");
            this.I = obj2;
            return this;
        }

        public final com.skydoves.balloon.Balloon.a B(float f) {
            this.M = f;
            return this;
        }

        public final com.skydoves.balloon.Balloon.a C(Typeface typeface) {
            n.f(typeface, "value");
            this.O = typeface;
            return this;
        }

        public final com.skydoves.balloon.Balloon.a D(float f) {
            this.d = f;
            return this;
        }

        public final com.skydoves.balloon.Balloon a() {
            Balloon balloon = new Balloon(this.K0, this);
            return balloon;
        }

        public final com.skydoves.balloon.Balloon.a b(Drawable drawable) {
            Drawable intrinsicWidth;
            int i;
            int obj3;
            if (drawable != null) {
                intrinsicWidth = drawable.mutate();
            } else {
                intrinsicWidth = 0;
            }
            this.x = intrinsicWidth;
            if (drawable != null && this.s == Integer.MIN_VALUE) {
                if (this.s == Integer.MIN_VALUE) {
                    this.s = Math.max(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                }
            }
            return this;
        }

        public final com.skydoves.balloon.Balloon.a c(com.skydoves.balloon.a a) {
            n.f(a, "value");
            this.w = a;
            return this;
        }

        public final com.skydoves.balloon.Balloon.a d(float f) {
            this.t = f;
            return this;
        }

        public final com.skydoves.balloon.Balloon.a e(com.skydoves.balloon.c c) {
            n.f(c, "value");
            this.u = c;
            return this;
        }

        public final com.skydoves.balloon.Balloon.a f(int i) {
            int i2;
            android.util.DisplayMetrics displayMetrics;
            String str;
            int obj4;
            if (i == Integer.MIN_VALUE) {
            } else {
                Resources system = Resources.getSystem();
                n.e(system, "Resources.getSystem()");
                i2 = a.b(TypedValue.applyDimension(1, (float)i, system.getDisplayMetrics()));
            }
            this.s = i2;
            return this;
        }

        public final com.skydoves.balloon.Balloon.a g(int i) {
            Resources system = Resources.getSystem();
            n.e(system, "Resources.getSystem()");
            this.A = a.b(TypedValue.applyDimension(1, (float)i, system.getDisplayMetrics()));
            return this;
        }

        public final com.skydoves.balloon.Balloon.a h(long l) {
            this.t0 = l;
            return this;
        }

        public final com.skydoves.balloon.Balloon.a i(int i) {
            this.F = a.a(this.K0, i);
            return this;
        }

        public final com.skydoves.balloon.Balloon.a j(com.skydoves.balloon.f f) {
            Object obj2;
            n.f(f, "value");
            this.x0 = f;
            if (f == f.CIRCULAR) {
                n(false);
            }
            return this;
        }

        public final com.skydoves.balloon.Balloon.a k(float f) {
            Resources system = Resources.getSystem();
            n.e(system, "Resources.getSystem()");
            this.H = TypedValue.applyDimension(1, f, system.getDisplayMetrics());
            return this;
        }

        public final com.skydoves.balloon.Balloon.a l(boolean z) {
            this.r0 = z;
            return this;
        }

        public final com.skydoves.balloon.Balloon.a m(boolean z) {
            this.o0 = z;
            if (!z) {
                n(z);
            }
            return this;
        }

        public final com.skydoves.balloon.Balloon.a n(boolean z) {
            this.I0 = z;
            return this;
        }

        public final com.skydoves.balloon.Balloon.a o(int i) {
            int i3;
            int i2;
            int i4 = 1;
            if (i <= 0) {
                if (i == Integer.MIN_VALUE) {
                    i3 = i4;
                } else {
                    i3 = 0;
                }
            } else {
            }
            if (i3 == 0) {
            } else {
                Resources system = Resources.getSystem();
                n.e(system, "Resources.getSystem()");
                this.g = a.b(TypedValue.applyDimension(i4, (float)i, system.getDisplayMetrics()));
                return this;
            }
            IllegalArgumentException obj4 = new IllegalArgumentException("The height of the balloon must bigger than zero.".toString());
            throw obj4;
        }

        public final com.skydoves.balloon.Balloon.a p(boolean z) {
            this.c0 = z;
            return this;
        }

        public final com.skydoves.balloon.Balloon.a q(View view) {
            n.f(view, "layout");
            this.a0 = view;
            return this;
        }

        public final com.skydoves.balloon.Balloon.a r(q q) {
            this.u0 = q;
            return this;
        }

        public final com.skydoves.balloon.Balloon.a s(int i) {
            Resources system = Resources.getSystem();
            n.e(system, "Resources.getSystem()");
            this.m = a.b(TypedValue.applyDimension(1, (float)i, system.getDisplayMetrics()));
            return this;
        }

        public final com.skydoves.balloon.Balloon.a t(int i) {
            Resources system = Resources.getSystem();
            n.e(system, "Resources.getSystem()");
            this.l = a.b(TypedValue.applyDimension(1, (float)i, system.getDisplayMetrics()));
            return this;
        }

        public final com.skydoves.balloon.Balloon.a u(int i) {
            this.d0 = a.a(this.K0, i);
            return this;
        }

        public final com.skydoves.balloon.Balloon.a v(int i) {
            Resources system = Resources.getSystem();
            n.e(system, "Resources.getSystem()");
            this.k = a.b(TypedValue.applyDimension(1, (float)i, system.getDisplayMetrics()));
            return this;
        }

        public final com.skydoves.balloon.Balloon.a w(int i) {
            Resources system = Resources.getSystem();
            n.e(system, "Resources.getSystem()");
            this.h = a.b(TypedValue.applyDimension(1, (float)i, system.getDisplayMetrics()));
            return this;
        }

        public final com.skydoves.balloon.Balloon.a x(int i) {
            Resources system = Resources.getSystem();
            n.e(system, "Resources.getSystem()");
            this.j = a.b(TypedValue.applyDimension(1, (float)i, system.getDisplayMetrics()));
            return this;
        }

        public final com.skydoves.balloon.Balloon.a y(int i) {
            Resources system = Resources.getSystem();
            n.e(system, "Resources.getSystem()");
            this.i = a.b(TypedValue.applyDimension(1, (float)i, system.getDisplayMetrics()));
            return this;
        }

        public final com.skydoves.balloon.Balloon.a z(int i) {
            this.J = a.a(this.K0, i);
            return this;
        }
    }

    public static final class d implements Runnable {

        final View a;
        final long b;
        final a c;
        public d(View view, long l2, a a3) {
            this.a = view;
            this.b = l2;
            this.c = obj4;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean attachedToWindow;
            com.skydoves.balloon.Balloon.d.a aVar;
            int i;
            float f;
            int i2;
            if (this.a.isAttachedToWindow()) {
                View view2 = this.a;
                i5 /= 2;
                attachedToWindow = ViewAnimationUtils.createCircularReveal(view2, i3 /= 2, i, (float)i6, 0);
                attachedToWindow.setDuration(this.b);
                attachedToWindow.start();
                aVar = new Balloon.d.a(this);
                attachedToWindow.addListener(aVar);
            }
        }
    }

    static final class g implements Runnable {

        final AppCompatImageView a;
        final com.skydoves.balloon.Balloon b;
        final View c;
        g(AppCompatImageView appCompatImageView, com.skydoves.balloon.Balloon balloon2, View view3) {
            this.a = appCompatImageView;
            this.b = balloon2;
            this.c = view3;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object balloon;
            boolean z;
            Object str;
            float bitmapDrawable;
            int resources;
            float resources2;
            int i;
            Object view;
            RadiusLayout radiusLayout;
            balloon = this.b;
            com.skydoves.balloon.q qVar = balloon.y;
            if (qVar != null) {
                qVar.b(balloon.S());
            }
            Balloon.f(this.b, this.c);
            int i2 = e.a[aVar.w.ordinal()];
            str = "this";
            int i3 = 1;
            resources = "binding.balloonCard";
            if (i2 != i3) {
                i = 0;
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                        } else {
                            this.a.setRotation(1119092736);
                            RadiusLayout radiusLayout5 = aVar14.d;
                            n.e(radiusLayout5, resources);
                            RadiusLayout radiusLayout7 = aVar16.d;
                            n.e(radiusLayout7, resources);
                            this.a.setX(i14 -= f6);
                            this.a.setY(Balloon.j(this.b, this.c));
                            if (aVar5.r) {
                                view = this.a;
                                n.e(view, str);
                                RadiusLayout radiusLayout2 = aVar7.d;
                                n.e(radiusLayout2, resources);
                                bitmapDrawable = new BitmapDrawable(this.a.getResources(), Balloon.e(this.b, view, (float)width, this.a.getY()));
                                this.a.setForeground(bitmapDrawable);
                            }
                        }
                        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                        throw noWhenBranchMatchedException;
                    }
                    this.a.setRotation(-1028390912);
                    RadiusLayout radiusLayout4 = aVar12.d;
                    n.e(radiusLayout4, resources);
                    this.a.setX(i5 += f5);
                    this.a.setY(Balloon.j(this.b, this.c));
                    if (aVar4.r) {
                        view = this.a;
                        n.e(view, str);
                        bitmapDrawable = new BitmapDrawable(this.a.getResources(), Balloon.e(this.b, view, i, this.a.getY()));
                        this.a.setForeground(bitmapDrawable);
                    }
                } else {
                    this.a.setRotation(i);
                    this.a.setX(Balloon.i(this.b, this.c));
                    RadiusLayout radiusLayout3 = aVar10.d;
                    n.e(radiusLayout3, resources);
                    this.a.setY(i4 += bitmapDrawable);
                    if (aVar3.r) {
                        view = this.a;
                        n.e(view, str);
                        bitmapDrawable = new BitmapDrawable(this.a.getResources(), Balloon.e(this.b, view, this.a.getX(), i));
                        this.a.setForeground(bitmapDrawable);
                    }
                }
            } else {
                this.a.setRotation(1127481344);
                this.a.setX(Balloon.i(this.b, this.c));
                RadiusLayout radiusLayout6 = aVar15.d;
                n.e(radiusLayout6, resources);
                RadiusLayout radiusLayout8 = aVar17.d;
                n.e(radiusLayout8, resources);
                this.a.setY(i17 -= f7);
                u.s0(this.a, aVar9.E);
                if (aVar6.r) {
                    view = this.a;
                    n.e(view, str);
                    radiusLayout = aVar18.d;
                    n.e(radiusLayout, resources);
                    bitmapDrawable = new BitmapDrawable(this.a.getResources(), Balloon.e(this.b, view, this.a.getX(), (float)height));
                    this.a.setForeground(bitmapDrawable);
                }
            }
            e.d(this.a, aVar8.p);
        }
    }

    static final class h implements View.OnClickListener {

        final com.skydoves.balloon.Balloon a;
        final com.skydoves.balloon.o b;
        h(com.skydoves.balloon.Balloon balloon, com.skydoves.balloon.o o2) {
            this.a = balloon;
            this.b = o2;
            super();
        }

        @Override // android.view.View$OnClickListener
        public final void onClick(View view) {
            String str;
            boolean obj3;
            final com.skydoves.balloon.o oVar = this.b;
            if (oVar != null) {
                n.e(view, "it");
                oVar.a(view);
            }
            if (obj3.q0) {
                this.a.J();
            }
        }
    }

    static final class i implements PopupWindow.OnDismissListener {

        final com.skydoves.balloon.Balloon a;
        final com.skydoves.balloon.p b;
        i(com.skydoves.balloon.Balloon balloon, com.skydoves.balloon.p p2) {
            this.a = balloon;
            this.b = p2;
            super();
        }

        @Override // android.widget.PopupWindow$OnDismissListener
        public final void onDismiss() {
            Balloon.B(this.a);
            this.a.J();
            com.skydoves.balloon.p pVar = this.b;
            if (pVar != null) {
                pVar.b();
            }
        }
    }

    public static final class j implements View.OnTouchListener {

        final com.skydoves.balloon.Balloon a;
        final com.skydoves.balloon.r b;
        j(com.skydoves.balloon.Balloon balloon, com.skydoves.balloon.r r2) {
            this.a = balloon;
            this.b = r2;
            super();
        }

        @Override // android.view.View$OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent2) {
            boolean z;
            n.f(view, "view");
            n.f(motionEvent2, "event");
            if (motionEvent2.getAction() == 4 && aVar.o0) {
                if (aVar.o0) {
                    this.a.J();
                }
                com.skydoves.balloon.r rVar = this.b;
                if (rVar != null) {
                    rVar.a(view, motionEvent2);
                }
                return 1;
            }
            return 0;
        }
    }

    static final class k implements View.OnClickListener {

        final com.skydoves.balloon.Balloon a;
        final com.skydoves.balloon.s b;
        k(com.skydoves.balloon.Balloon balloon, com.skydoves.balloon.s s2) {
            this.a = balloon;
            this.b = s2;
            super();
        }

        @Override // android.view.View$OnClickListener
        public final void onClick(View view) {
            boolean obj1;
            obj1 = this.b;
            if (obj1 != null) {
                obj1.a();
            }
            if (obj1.r0) {
                this.a.J();
            }
        }
    }

    public static final class l implements Runnable {

        final com.skydoves.balloon.Balloon a;
        final View b;
        final com.skydoves.balloon.Balloon c;
        final View v;
        final int w;
        final int x;
        public l(com.skydoves.balloon.Balloon balloon, View view2, com.skydoves.balloon.Balloon balloon3, View view4, int i5, int i6) {
            this.a = balloon;
            this.b = view2;
            this.c = balloon3;
            this.v = view4;
            this.w = i5;
            this.x = i6;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.skydoves.balloon.Balloon balloon;
            Object invoke;
            com.skydoves.balloon.k kVar;
            int i;
            int cmp;
            Object obj;
            RadiusLayout radiusLayout;
            String d0 = aVar.D0;
            if (d0 != null) {
                if (Balloon.m(this.a).g(d0, aVar9.E0)) {
                    Balloon.m(this.a).f(d0);
                } else {
                    invoke = aVar5.F0;
                    if (invoke != null) {
                        invoke = invoke.invoke();
                    }
                }
            }
            int i2 = 1;
            Balloon.y(this.a, i2);
            long l = aVar2.t0;
            if (Long.compare(l, i6) != 0) {
                this.a.K(l);
            }
            String str = "binding.balloonCard";
            if (Balloon.u(this.a)) {
                balloon = this.a;
                obj = aVar8.d;
                n.e(obj, str);
                Balloon.C(balloon, obj);
            } else {
                balloon = this.a;
                obj = aVar7.f;
                n.e(obj, "binding.balloonText");
                radiusLayout = aVar10.d;
                n.e(radiusLayout, str);
                Balloon.x(balloon, obj, radiusLayout);
            }
            int i3 = 0;
            Balloon.n(this.a).b().measure(i3, i3);
            Balloon.o(this.a).setWidth(this.a.X());
            Balloon.o(this.a).setHeight(this.a.V());
            VectorTextView view = aVar4.f;
            n.e(view, "this.binding.balloonText");
            int i7 = -1;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i7, i7);
            view.setLayoutParams(layoutParams);
            Balloon.v(this.a, this.b);
            Balloon.w(this.a);
            Balloon.h(this.a);
            Balloon.z(this.a, this.b);
            Balloon.g(this.a);
            Balloon.A(this.a);
            Balloon.o(this.c).showAsDropDown(this.v, h0 *= i11, this.x);
        }
    }

    public static final class m implements Runnable {

        final com.skydoves.balloon.Balloon a;
        final View b;
        final com.skydoves.balloon.Balloon c;
        final View v;
        final int w;
        final int x;
        public m(com.skydoves.balloon.Balloon balloon, View view2, com.skydoves.balloon.Balloon balloon3, View view4, int i5, int i6) {
            this.a = balloon;
            this.b = view2;
            this.c = balloon3;
            this.v = view4;
            this.w = i5;
            this.x = i6;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.skydoves.balloon.Balloon balloon;
            Object invoke;
            com.skydoves.balloon.k kVar;
            int i;
            int cmp;
            Object obj;
            RadiusLayout radiusLayout;
            String d0 = aVar.D0;
            if (d0 != null) {
                if (Balloon.m(this.a).g(d0, aVar9.E0)) {
                    Balloon.m(this.a).f(d0);
                } else {
                    invoke = aVar5.F0;
                    if (invoke != null) {
                        invoke = invoke.invoke();
                    }
                }
            }
            int i2 = 1;
            Balloon.y(this.a, i2);
            long l = aVar2.t0;
            if (Long.compare(l, i6) != 0) {
                this.a.K(l);
            }
            String str = "binding.balloonCard";
            if (Balloon.u(this.a)) {
                balloon = this.a;
                obj = aVar8.d;
                n.e(obj, str);
                Balloon.C(balloon, obj);
            } else {
                balloon = this.a;
                obj = aVar7.f;
                n.e(obj, "binding.balloonText");
                radiusLayout = aVar10.d;
                n.e(radiusLayout, str);
                Balloon.x(balloon, obj, radiusLayout);
            }
            int i3 = 0;
            Balloon.n(this.a).b().measure(i3, i3);
            Balloon.o(this.a).setWidth(this.a.X());
            Balloon.o(this.a).setHeight(this.a.V());
            VectorTextView view = aVar4.f;
            n.e(view, "this.binding.balloonText");
            int i7 = -1;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i7, i7);
            view.setLayoutParams(layoutParams);
            Balloon.v(this.a, this.b);
            Balloon.w(this.a);
            Balloon.h(this.a);
            Balloon.z(this.a, this.b);
            Balloon.g(this.a);
            Balloon.A(this.a);
            Balloon.o(this.c).showAsDropDown(this.v, h0 *= i11, i14 += i19);
        }
    }

    static final class n implements Runnable {

        final com.skydoves.balloon.Balloon a;
        n(com.skydoves.balloon.Balloon balloon) {
            this.a = balloon;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            Handler handler = new Handler(Looper.getMainLooper());
            Balloon.n.a aVar = new Balloon.n.a(this);
            handler.postDelayed(aVar, aVar2.C0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0001\u0010\u0002", d2 = {"Lcom/skydoves/balloon/d;", "a", "()Lcom/skydoves/balloon/d;"}, k = 3, mv = {1, 4, 2})
    static final class b extends p implements a<com.skydoves.balloon.d> {

        final com.skydoves.balloon.Balloon this$0;
        b(com.skydoves.balloon.Balloon balloon) {
            this.this$0 = balloon;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final com.skydoves.balloon.d a() {
            d dVar = new d(this.this$0);
            return dVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0001\u0010\u0002", d2 = {"Lcom/skydoves/balloon/k;", "a", "()Lcom/skydoves/balloon/k;"}, k = 3, mv = {1, 4, 2})
    static final class c extends p implements a<com.skydoves.balloon.k> {

        final com.skydoves.balloon.Balloon this$0;
        c(com.skydoves.balloon.Balloon balloon) {
            this.this$0 = balloon;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final com.skydoves.balloon.k a() {
            return k.c.a(Balloon.q(this.this$0));
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0001\u0010\u0002", d2 = {"Lkotlin/w;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    static final class e extends p implements a<w> {

        final com.skydoves.balloon.Balloon this$0;
        e(com.skydoves.balloon.Balloon balloon) {
            this.this$0 = balloon;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            Balloon.y(this.this$0, false);
            Balloon.o(this.this$0).dismiss();
            Balloon.t(this.this$0).dismiss();
            Balloon.s(this.this$0).removeCallbacks(Balloon.k(this.this$0));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0001\u0010\u0002", d2 = {"Landroid/os/Handler;", "a", "()Landroid/os/Handler;"}, k = 3, mv = {1, 4, 2})
    static final class f extends p implements a<Handler> {

        public static final com.skydoves.balloon.Balloon.f a;
        static {
            Balloon.f fVar = new Balloon.f();
            Balloon.f.a = fVar;
        }

        f() {
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final Handler a() {
            Handler handler = new Handler(Looper.getMainLooper());
            return handler;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    public Balloon(Context context, com.skydoves.balloon.Balloon.a balloon$a2) {
        n.f(context, "context");
        n.f(a2, "builder");
        super();
        this.C = context;
        this.D = a2;
        int i2 = 0;
        final int i4 = 0;
        a aVar = a.c(LayoutInflater.from(context), i2, i4);
        n.e(aVar, "LayoutBalloonLibrarySkyd…om(context), null, false)");
        this.a = aVar;
        b obj5 = b.c(LayoutInflater.from(context), i2, i4);
        n.e(obj5, "LayoutBalloonOverlayLibr…om(context), null, false)");
        this.b = obj5;
        this.y = a2.j0;
        m obj6 = m.NONE;
        this.z = j.a(obj6, Balloon.f.a);
        Balloon.b bVar = new Balloon.b(this);
        this.A = j.a(obj6, bVar);
        Balloon.c cVar = new Balloon.c(this);
        this.B = j.a(obj6, cVar);
        int i3 = -2;
        obj6 = new PopupWindow(aVar.b(), i3, i3);
        this.c = obj6;
        int i = -1;
        obj6 = new PopupWindow(obj5.b(), i, i);
        this.v = obj6;
        I();
    }

    public static final void A(com.skydoves.balloon.Balloon balloon) {
        balloon.z0();
    }

    private final void A0() {
        FrameLayout frameLayout = aVar.b;
        final Animation animation = frameLayout.getAnimation();
        if (animation != null) {
            animation.cancel();
            animation.reset();
        }
        frameLayout.clearAnimation();
    }

    public static final void B(com.skydoves.balloon.Balloon balloon) {
        balloon.A0();
    }

    private final void B0(ViewGroup viewGroup) {
        int i;
        View childAt;
        boolean z;
        i = 0;
        while (i < viewGroup.getChildCount()) {
            childAt = viewGroup.getChildAt(i);
            n.c(childAt, "getChildAt(index)");
            if (childAt instanceof AppCompatTextView != null) {
            } else {
            }
            if (childAt instanceof ViewGroup) {
            }
            i++;
            B0((ViewGroup)childAt);
            m0((AppCompatTextView)childAt, viewGroup);
        }
    }

    public static final void C(com.skydoves.balloon.Balloon balloon, ViewGroup viewGroup2) {
        balloon.B0(viewGroup2);
    }

    private final Bitmap D(AppCompatImageView appCompatImageView, float f2, float f3) {
        LinearGradient linearGradient2;
        int i5;
        int i2;
        int i4;
        float i3;
        int i;
        Shader.TileMode cLAMP;
        LinearGradient linearGradient;
        final Object obj = this;
        java.lang.IllegalArgumentException obj2 = appCompatImageView;
        obj2.setColorFilter(aVar.F, PorterDuff.Mode.SRC_IN);
        Drawable drawable = appCompatImageView.getDrawable();
        String str3 = "imageView.drawable";
        n.e(drawable, str3);
        Drawable drawable2 = appCompatImageView.getDrawable();
        n.e(drawable2, str3);
        Drawable drawable3 = appCompatImageView.getDrawable();
        n.e(drawable3, str3);
        Bitmap bitmap = L(drawable, drawable2.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
        o oVar = R(f2, f3);
        final int intValue = (Number)oVar.c().intValue();
        final int intValue2 = (Number)oVar.d().intValue();
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap2);
        int i13 = 0;
        canvas.drawBitmap(bitmap, i13, i13, 0);
        Paint paint2 = new Paint();
        int i9 = e.b[aVar2.w.ordinal()];
        int i20 = 2;
        if (i9 != 1 && i9 != i20) {
            if (i9 != i20) {
                if (i9 != 3) {
                    if (i9 != 4) {
                    } else {
                    }
                    NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                    throw noWhenBranchMatchedException;
                }
                super(f10 += i11, 0, 0, 0, intValue, intValue2, Shader.TileMode.CLAMP);
            } else {
                super(i10 - f8, 0, (float)width3, 0, intValue, intValue2, Shader.TileMode.CLAMP);
            }
        } else {
        }
        paint2.setShader(linearGradient);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        paint2.setXfermode(porterDuffXfermode);
        canvas.drawRect(0, 0, (float)width5, (float)height, paint2);
        obj2.setColorFilter(0, PorterDuff.Mode.SRC_IN);
        n.e(bitmap2, "updatedBitmap");
        return bitmap2;
    }

    private final void E(View view) {
        Rect rect;
        int bOTTOM;
        int bottom;
        com.skydoves.balloon.a obj8;
        if (aVar.v == b.ALIGN_FIXED) {
        }
        rect = new Rect();
        view.getGlobalVisibleRect(rect);
        obj8 = new int[2];
        obj8 = new int[]{0, 0};
        this.c.getContentView().getLocationOnScreen(obj8);
        com.skydoves.balloon.Balloon.a aVar2 = this.D;
        final com.skydoves.balloon.a aVar3 = aVar2.w;
        final com.skydoves.balloon.a tOP = a.TOP;
        final int i = 1;
        if (aVar3 == tOP && obj8[i] < rect.bottom) {
            if (obj8[i] < rect.bottom) {
                aVar2.c(a.BOTTOM);
            } else {
                if (aVar3 == a.BOTTOM && obj8[i] > rect.top) {
                    if (obj8[i] > rect.top) {
                        aVar2.c(tOP);
                    }
                }
            }
        } else {
        }
        c0();
    }

    private final void F(ViewGroup viewGroup) {
        Iterator iterator;
        ArrayList arrayList;
        int childAt;
        final int i = 0;
        viewGroup.setFitsSystemWindows(i);
        kotlin.h0.f fVar = g.l(i, viewGroup.getChildCount());
        arrayList = new ArrayList(p.r(fVar, 10));
        iterator = fVar.iterator();
        while (iterator.hasNext()) {
            arrayList.add(viewGroup.getChildAt((h0)iterator.d()));
        }
        final Iterator obj5 = arrayList.iterator();
        while (obj5.hasNext()) {
            iterator = obj5.next();
            n.e((View)iterator, "child");
            iterator.setFitsSystemWindows(i);
            if (iterator instanceof ViewGroup != null) {
            }
            F((ViewGroup)iterator);
        }
    }

    private final void G() {
        PopupWindow popupWindow;
        int i;
        com.skydoves.balloon.Balloon.a aVar = this.D;
        i = aVar.v0;
        final int i6 = Integer.MIN_VALUE;
        if (i == i6) {
            popupWindow = e.g[aVar.x0.ordinal()];
            if (popupWindow != 1) {
                if (popupWindow != 2) {
                    if (popupWindow != 3) {
                        if (popupWindow != 4) {
                            if (popupWindow != 5) {
                            } else {
                                this.c.setAnimationStyle(w.d);
                            }
                        } else {
                            this.c.setAnimationStyle(w.e);
                        }
                    } else {
                        this.c.setAnimationStyle(w.b);
                    }
                } else {
                    View contentView = this.c.getContentView();
                    n.e(contentView, "bodyWindow.contentView");
                    e.a(contentView, aVar2.z0);
                    this.c.setAnimationStyle(w.c);
                }
            } else {
                this.c.setAnimationStyle(w.a);
            }
        } else {
            this.c.setAnimationStyle(i);
        }
    }

    private final void H() {
        PopupWindow popupWindow;
        int i;
        com.skydoves.balloon.Balloon.a aVar = this.D;
        if (aVar.w0 == Integer.MIN_VALUE) {
            if (e.h[aVar.y0.ordinal()] != 1) {
                this.v.setAnimationStyle(w.d);
            } else {
                this.v.setAnimationStyle(w.b);
            }
        } else {
            this.v.setAnimationStyle(aVar.v0);
        }
    }

    private final void I() {
        Object lifecycle;
        Context context;
        boolean z;
        b0();
        g0();
        h0();
        d0();
        c0();
        f0();
        e0();
        FrameLayout frameLayout = this.a.b();
        n.e(frameLayout, "binding.root");
        F(frameLayout);
        lifecycle = this.D;
        q qVar = lifecycle.u0;
        context = this.C;
        if (qVar == null && context instanceof q) {
            context = this.C;
            if (context instanceof q) {
                lifecycle.r((q)context);
                (q)this.C.getLifecycle().a(this);
            } else {
                lifecycle = qVar.getLifecycle();
                if (qVar != null && lifecycle != null) {
                    lifecycle = qVar.getLifecycle();
                    if (lifecycle != null) {
                        lifecycle.a(this);
                    }
                }
            }
        } else {
        }
    }

    private final Bitmap L(Drawable drawable, int i2, int i3) {
        final Bitmap obj5 = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas obj6 = new Canvas(obj5);
        final int i = 0;
        drawable.setBounds(i, i, obj6.getWidth(), obj6.getHeight());
        drawable.draw(obj6);
        n.e(obj5, "bitmap");
        return obj5;
    }

    private final float M(View view) {
        int cmp;
        int i3;
        float f;
        int i;
        int i2;
        View obj8;
        FrameLayout frameLayout = aVar.e;
        n.e(frameLayout, "binding.balloonContent");
        cmp = point.x;
        i3 = point2.x;
        com.skydoves.balloon.Balloon.a aVar3 = this.D;
        f8 /= i16;
        i = e.d[aVar3.u.ordinal()];
        if (i != 1) {
            if (i != 2) {
            } else {
                if (width += i3 < cmp) {
                } else {
                    if (i11 += cmp < i3) {
                        f = i10;
                    } else {
                    }
                }
                return f;
            }
            obj8 = new NoWhenBranchMatchedException();
            throw obj8;
        }
        obj8 = obj8.g;
        n.e(obj8, "binding.balloonWrapper");
        f = obj8 - i15;
    }

    private final float N(View view) {
        float cmp2;
        int cmp;
        int i;
        int i2;
        View obj9;
        int i3 = e.b(view, aVar.J0);
        FrameLayout frameLayout = aVar3.e;
        n.e(frameLayout, "binding.balloonContent");
        i6 -= i3;
        i8 -= i3;
        com.skydoves.balloon.Balloon.a aVar4 = this.D;
        final int i18 = 2;
        i16 /= i18;
        i2 = e.e[aVar4.u.ordinal()];
        if (i2 != 1) {
            if (i2 != i18) {
            } else {
                if (height += i < cmp) {
                } else {
                    if (i13 += cmp < i) {
                        cmp2 = i12;
                    } else {
                    }
                }
                return cmp2;
            }
            obj9 = new NoWhenBranchMatchedException();
            throw obj9;
        }
        obj9 = obj9.g;
        n.e(obj9, "binding.balloonWrapper");
        cmp2 = obj9 - f3;
    }

    private final com.skydoves.balloon.d O() {
        return (d)this.A.getValue();
    }

    private final Animation P() {
        com.skydoves.balloon.Balloon.a aVar;
        int i2;
        int i;
        aVar = this.D;
        int i5 = 1;
        if (aVar.B0 == Integer.MIN_VALUE && e.j[aVar.A0.ordinal()] != i5) {
            i5 = 1;
            if (e.j[aVar.A0.ordinal()] != i5) {
                return null;
            }
            aVar = this.D;
            if (aVar.p) {
                aVar = e.i[aVar.w.ordinal()];
                if (aVar != i5) {
                    if (aVar != 2) {
                        if (aVar != 3) {
                            if (aVar != 4) {
                            } else {
                                i2 = t.c;
                            }
                            NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                            throw noWhenBranchMatchedException;
                        }
                        i2 = t.d;
                    } else {
                        i2 = t.e;
                    }
                } else {
                    i2 = t.a;
                }
            } else {
                i2 = t.b;
            }
        }
        return AnimationUtils.loadAnimation(this.C, i2);
    }

    private final com.skydoves.balloon.k Q() {
        return (k)this.B.getValue();
    }

    private final o<Integer, Integer> R(float f, float f2) {
        int pixel;
        int i3;
        int i2;
        int i;
        int obj6;
        int obj7;
        RadiusLayout radiusLayout = aVar.d;
        String str = "binding.balloonCard";
        n.e(radiusLayout, str);
        Drawable background = radiusLayout.getBackground();
        n.e(background, "binding.balloonCard.background");
        RadiusLayout radiusLayout2 = aVar6.d;
        n.e(radiusLayout2, str);
        i3 = 1;
        RadiusLayout radiusLayout3 = aVar9.d;
        n.e(radiusLayout3, str);
        Bitmap bitmap = L(background, width += i3, height += i3);
        int i5 = e.c[aVar2.w.ordinal()];
        int i15 = 1073741824;
        if (i5 != i3 && i5 != 2) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                    } else {
                    }
                    obj6 = new NoWhenBranchMatchedException();
                    throw obj6;
                }
                obj6 = (int)f;
                pixel = bitmap.getPixel(obj6, (int)i12);
                obj6 = bitmap.getPixel(obj6, (int)obj7);
            } else {
                obj7 = (int)f2;
                pixel = bitmap.getPixel((int)i8, obj7);
                obj6 = bitmap.getPixel((int)obj6, obj7);
            }
        } else {
        }
        obj7 = new o(Integer.valueOf(pixel), Integer.valueOf(obj6));
        return obj7;
    }

    private final int T() {
        return i *= 2;
    }

    private final Handler U() {
        return (Handler)this.z.getValue();
    }

    private final int W(int i, View view2) {
        int i3;
        int i5;
        int i4;
        int i2;
        int cmp;
        float obj7;
        int obj8;
        i3 = point.x;
        obj8 = this.D;
        if (obj8.R != null) {
            i5 = obj8.T;
            i2 = obj8.V;
        } else {
            i11 += i12;
            i13 *= 2;
        }
        i6 += i8;
        cmp = obj8.d;
        final int i14 = 0;
        if (Float.compare(cmp, i14) != 0) {
            obj7 = (int)obj7;
            obj7 -= i7;
        } else {
        }
        return obj7;
    }

    private final float Y() {
        com.skydoves.balloon.Balloon.a aVar = this.D;
        return i3 += f;
    }

    private final boolean Z() {
        int i;
        Object aVar;
        aVar = this.D;
        if (aVar.b0 == null) {
            if (aVar.a0 != null) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private final void a0(View view) {
        ColorStateList valueOf;
        int sDK_INT;
        AppCompatImageView view2 = aVar.c;
        int i3 = aVar7.s;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3);
        view2.setLayoutParams(layoutParams);
        view2.setAlpha(aVar2.Y);
        Drawable drawable = aVar3.x;
        if (drawable != null) {
            view2.setImageDrawable(drawable);
        }
        com.skydoves.balloon.Balloon.a aVar4 = this.D;
        view2.setPadding(aVar4.y, aVar4.A, aVar4.z, aVar4.B);
        com.skydoves.balloon.Balloon.a aVar5 = this.D;
        int i5 = aVar5.q;
        if (i5 != Integer.MIN_VALUE) {
            g.c(view2, ColorStateList.valueOf(i5));
        } else {
            g.c(view2, ColorStateList.valueOf(aVar5.F));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            view2.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Balloon.g gVar = new Balloon.g(view2, this, view);
        aVar6.d.post(gVar);
    }

    private final void b0() {
        Object gradientDrawable;
        w wVar;
        RadiusLayout radiusLayout = aVar.d;
        radiusLayout.setAlpha(aVar2.Y);
        radiusLayout.setRadius(aVar3.H);
        u.s0(radiusLayout, aVar4.Z);
        if (aVar5.G != null) {
        } else {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(aVar7.F);
            gradientDrawable.setCornerRadius(aVar8.H);
            wVar = w.a;
        }
        radiusLayout.setBackground(gradientDrawable);
        com.skydoves.balloon.Balloon.a aVar6 = this.D;
        radiusLayout.setPadding(aVar6.h, aVar6.i, aVar6.j, aVar6.k);
    }

    private final void c0() {
        int i2;
        int i;
        com.skydoves.balloon.Balloon.a aVar = this.D;
        i = 1;
        i3 -= i;
        int i5 = (int)f;
        FrameLayout frameLayout = aVar3.e;
        i2 = e.f[aVar.w.ordinal()];
        if (i2 != i) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                    } else {
                        frameLayout.setPadding(i5, i4, i5, g.b(i4, i5));
                    }
                } else {
                    frameLayout.setPadding(i5, i4, i5, g.b(i4, i5));
                }
            } else {
                frameLayout.setPadding(i4, i5, i4, i5);
            }
        } else {
            frameLayout.setPadding(i4, i5, i4, i5);
        }
    }

    private final void d0() {
        if (Z()) {
            i0();
        } else {
            j0();
            k0();
        }
    }

    public static final Bitmap e(com.skydoves.balloon.Balloon balloon, AppCompatImageView appCompatImageView2, float f3, float f4) {
        return balloon.D(appCompatImageView2, f3, f4);
    }

    private final void e0() {
        n0(aVar.h0);
        o0(aVar2.i0);
        s0(aVar3.k0);
        v0(aVar4.l0);
        t0(aVar5.n0);
        u0(aVar6.m0);
    }

    public static final void f(com.skydoves.balloon.Balloon balloon, View view2) {
        balloon.E(view2);
    }

    private final void f0() {
        Object aVar;
        boolean z;
        aVar = this.D;
        if (aVar.c0) {
            BalloonAnchorOverlayView view = bVar.b;
            view.setOverlayColor(aVar.d0);
            view.setOverlayPadding(aVar2.e0);
            view.setOverlayPosition(aVar3.f0);
            view.setBalloonOverlayShape(aVar4.g0);
            this.v.setClippingEnabled(false);
        }
    }

    public static final void g(com.skydoves.balloon.Balloon balloon) {
        balloon.G();
    }

    private final void g0() {
        android.view.ViewGroup.LayoutParams layoutParams = aVar.g.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        com.skydoves.balloon.Balloon.a aVar2 = this.D;
        (ViewGroup.MarginLayoutParams)layoutParams.setMargins(aVar2.m, aVar2.n, aVar2.l, aVar2.o);
    }

    public static final void h(com.skydoves.balloon.Balloon balloon) {
        balloon.H();
    }

    private final void h0() {
        int sDK_INT;
        final PopupWindow popupWindow = this.c;
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(aVar.I0);
        ColorDrawable colorDrawable = new ColorDrawable(0);
        popupWindow.setBackgroundDrawable(colorDrawable);
        if (Build.VERSION.SDK_INT >= 21) {
            popupWindow.setElevation(aVar2.Z);
        }
    }

    public static final float i(com.skydoves.balloon.Balloon balloon, View view2) {
        return balloon.M(view2);
    }

    private final void i0() {
        Object inflate;
        LayoutInflater from;
        RadiusLayout radiusLayout;
        int i;
        inflate = aVar.b0;
        if (inflate != null && LayoutInflater.from(this.C).inflate(inflate.intValue(), aVar6.d, false) != null) {
            if (LayoutInflater.from(this.C).inflate(inflate.intValue(), aVar6.d, false) != null) {
            } else {
                inflate = aVar2.a0;
            }
        } else {
        }
        if (inflate == null) {
        } else {
            aVar4.d.removeAllViews();
            aVar5.d.addView(inflate);
            RadiusLayout radiusLayout2 = aVar3.d;
            n.e(radiusLayout2, "binding.balloonCard");
            B0(radiusLayout2);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The custom layout is null.");
        throw illegalArgumentException;
    }

    public static final float j(com.skydoves.balloon.Balloon balloon, View view2) {
        return balloon.N(view2);
    }

    private final void j0() {
        com.skydoves.balloon.m mVar;
        com.skydoves.balloon.m.a aVar;
        VectorTextView view = aVar2.f;
        mVar = aVar3.X;
        if (mVar != null) {
            d.b(view, mVar);
        } else {
            Context context = view.getContext();
            n.e(context, "context");
            aVar = new m.a(context);
            aVar.b(aVar5.R);
            aVar.g(aVar6.T);
            aVar.e(aVar7.U);
            aVar.d(aVar8.W);
            aVar.f(aVar9.V);
            aVar.c(aVar10.S);
            w wVar = w.a;
            d.b(view, aVar.a());
        }
        view.j(aVar4.G0);
    }

    public static final com.skydoves.balloon.d k(com.skydoves.balloon.Balloon balloon) {
        return balloon.O();
    }

    private final void k0() {
        com.skydoves.balloon.y yVar;
        com.skydoves.balloon.y.a aVar;
        VectorTextView view = aVar2.f;
        yVar = aVar3.Q;
        if (yVar != null) {
            d.c(view, yVar);
        } else {
            Context context = view.getContext();
            n.e(context, "context");
            aVar = new y.a(context);
            aVar.b(aVar5.I);
            aVar.f(aVar6.M);
            aVar.c(aVar7.J);
            aVar.e(aVar8.K);
            aVar.d(aVar9.P);
            aVar.g(aVar10.N);
            aVar.h(aVar11.O);
            view.setMovementMethod(aVar12.L);
            w wVar = w.a;
            d.c(view, aVar.a());
        }
        n.e(view, "this");
        RadiusLayout radiusLayout = aVar4.d;
        n.e(radiusLayout, "binding.balloonCard");
        m0(view, radiusLayout);
    }

    public static final Animation l(com.skydoves.balloon.Balloon balloon) {
        return balloon.P();
    }

    public static final com.skydoves.balloon.k m(com.skydoves.balloon.Balloon balloon) {
        return balloon.Q();
    }

    private final void m0(AppCompatTextView appCompatTextView, View view2) {
        int i2;
        boolean z;
        int i;
        String str;
        int compoundPaddingStart;
        int compoundPaddingEnd;
        Drawable[] compoundDrawablesRelative = appCompatTextView.getCompoundDrawablesRelative();
        String str2 = "compoundDrawablesRelative";
        n.e(compoundDrawablesRelative, str2);
        if (b.e(compoundDrawablesRelative)) {
            Drawable[] compoundDrawablesRelative2 = appCompatTextView.getCompoundDrawablesRelative();
            n.e(compoundDrawablesRelative2, str2);
            appCompatTextView.setMinHeight(b.b(compoundDrawablesRelative2));
            Drawable[] compoundDrawablesRelative3 = appCompatTextView.getCompoundDrawablesRelative();
            n.e(compoundDrawablesRelative3, str2);
            i = b.c(compoundDrawablesRelative3);
            compoundPaddingStart = appCompatTextView.getCompoundPaddingStart();
            compoundPaddingEnd = appCompatTextView.getCompoundPaddingEnd();
            i2 += z;
        } else {
        }
        appCompatTextView.setMaxWidth(W(i2, view2));
    }

    public static final a n(com.skydoves.balloon.Balloon balloon) {
        return balloon.a;
    }

    public static final PopupWindow o(com.skydoves.balloon.Balloon balloon) {
        return balloon.c;
    }

    public static final com.skydoves.balloon.Balloon.a p(com.skydoves.balloon.Balloon balloon) {
        return balloon.D;
    }

    public static final Context q(com.skydoves.balloon.Balloon balloon) {
        return balloon.C;
    }

    public static final boolean r(com.skydoves.balloon.Balloon balloon) {
        return balloon.x;
    }

    public static final Handler s(com.skydoves.balloon.Balloon balloon) {
        return balloon.U();
    }

    public static final PopupWindow t(com.skydoves.balloon.Balloon balloon) {
        return balloon.v;
    }

    public static final boolean u(com.skydoves.balloon.Balloon balloon) {
        return balloon.Z();
    }

    public static final void v(com.skydoves.balloon.Balloon balloon, View view2) {
        balloon.a0(view2);
    }

    public static final void w(com.skydoves.balloon.Balloon balloon) {
        balloon.c0();
    }

    public static final void x(com.skydoves.balloon.Balloon balloon, AppCompatTextView appCompatTextView2, View view3) {
        balloon.m0(appCompatTextView2, view3);
    }

    public static final void y(com.skydoves.balloon.Balloon balloon, boolean z2) {
        balloon.w = z2;
    }

    private final void y0(View view) {
        boolean z;
        int i2;
        int i;
        if (aVar.c0) {
            bVar.b.setAnchorView(view);
            i = 0;
            this.v.showAtLocation(view, 17, i, i);
        }
    }

    public static final void z(com.skydoves.balloon.Balloon balloon, View view2) {
        balloon.y0(view2);
    }

    private final void z0() {
        Balloon.n nVar = new Balloon.n(this);
        aVar.b.post(nVar);
    }

    @Override // androidx.lifecycle.p
    public final void J() {
        boolean eVar;
        Object contentView;
        com.skydoves.balloon.f cIRCULAR;
        int sDK_INT;
        int i;
        if (this.w) {
            eVar = new Balloon.e(this);
            if (aVar.x0 == f.CIRCULAR) {
                contentView = this.c.getContentView();
                n.e(contentView, "this.bodyWindow.contentView");
                if (Build.VERSION.SDK_INT >= 21) {
                    sDK_INT = new Balloon.d(contentView, aVar2.z0, obj3, eVar);
                    contentView.post(sDK_INT);
                }
            } else {
                eVar.invoke();
            }
        }
    }

    @Override // androidx.lifecycle.p
    public final boolean K(long l) {
        return U().postDelayed(O(), l);
    }

    @Override // androidx.lifecycle.p
    public final ViewGroup S() {
        RadiusLayout radiusLayout = aVar.d;
        n.e(radiusLayout, "binding.balloonCard");
        return radiusLayout;
    }

    @Override // androidx.lifecycle.p
    public final int V() {
        int i = aVar.g;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        FrameLayout frameLayout = this.a.b();
        n.e(frameLayout, "this.binding.root");
        return frameLayout.getMeasuredHeight();
    }

    @Override // androidx.lifecycle.p
    public final int X() {
        int i;
        int aVar;
        int cmp;
        int measuredWidth;
        int i2;
        String cmp2;
        int i3 = point.x;
        aVar = this.D;
        measuredWidth = aVar.d;
        i2 = 0;
        if (Float.compare(measuredWidth, i2) != 0) {
            i = (int)i6;
        } else {
            cmp2 = "binding.root";
            if (Float.compare(f3, i2) == 0) {
                if (Float.compare(f4, i2) != 0) {
                    if (Float.compare(aVar, i2) != 0) {
                    } else {
                        aVar = 1065353216;
                    }
                    FrameLayout frameLayout2 = this.a.b();
                    n.e(frameLayout2, cmp2);
                    float f = (float)i3;
                    i = g.g(frameLayout2.getMeasuredWidth(), (int)i7, (int)i4);
                } else {
                    aVar = aVar.a;
                    if (aVar != Integer.MIN_VALUE) {
                        i = g.e(aVar, i3);
                    } else {
                        FrameLayout frameLayout = this.a.b();
                        n.e(frameLayout, cmp2);
                        com.skydoves.balloon.Balloon.a aVar3 = this.D;
                        i = g.g(frameLayout.getMeasuredWidth(), aVar3.b, aVar3.c);
                    }
                }
            } else {
            }
        }
        return i;
    }

    @Override // androidx.lifecycle.p
    public final boolean l0() {
        return this.w;
    }

    @Override // androidx.lifecycle.p
    public final void n0(com.skydoves.balloon.o o) {
        Balloon.h hVar = new Balloon.h(this, o);
        aVar.g.setOnClickListener(hVar);
    }

    @Override // androidx.lifecycle.p
    public final void o0(com.skydoves.balloon.p p) {
        Balloon.i iVar = new Balloon.i(this, p);
        this.c.setOnDismissListener(iVar);
    }

    @z(j$b.ON_DESTROY)
    public final void onDestroy() {
        this.x = true;
        this.v.dismiss();
        this.c.dismiss();
    }

    @z(j$b.ON_PAUSE)
    public final void onPause() {
        if (aVar.s0) {
            J();
        }
    }

    public final void p0(a<w> a) {
        n.f(a, "block");
        i iVar = new i(a);
        o0(iVar);
    }

    @Override // androidx.lifecycle.p
    public final void q0(com.skydoves.balloon.q q) {
        this.y = q;
    }

    public final void r0(l<? super View, w> l) {
        n.f(l, "block");
        j jVar = new j(l);
        q0(jVar);
    }

    @Override // androidx.lifecycle.p
    public final void s0(com.skydoves.balloon.r r) {
        Balloon.j jVar = new Balloon.j(this, r);
        this.c.setTouchInterceptor(jVar);
    }

    @Override // androidx.lifecycle.p
    public final void t0(com.skydoves.balloon.s s) {
        Balloon.k kVar = new Balloon.k(this, s);
        this.b.b().setOnClickListener(kVar);
    }

    @Override // androidx.lifecycle.p
    public final void u0(View.OnTouchListener view$OnTouchListener) {
        PopupWindow popupWindow;
        if (onTouchListener != null) {
            this.v.setTouchInterceptor(onTouchListener);
        }
    }

    @Override // androidx.lifecycle.p
    public final void v0(View.OnTouchListener view$OnTouchListener) {
        PopupWindow popupWindow;
        if (onTouchListener != null) {
            this.c.setTouchInterceptor(onTouchListener);
        }
    }

    @Override // androidx.lifecycle.p
    public final void w0(View view, int i2, int i3) {
        boolean lVar;
        String str;
        com.skydoves.balloon.Balloon balloon;
        Object obj2;
        com.skydoves.balloon.Balloon balloon2;
        Object obj;
        int i;
        int i4;
        boolean obj9;
        n.f(view, "anchor");
        View contentView = Balloon.o(this).getContentView();
        n.e(contentView, "bodyWindow.contentView");
        if (!l0() && !Balloon.r(this) && !a.d(Balloon.q(this)) && contentView.getParent() == null && u.Q(view)) {
            if (!Balloon.r(this)) {
                if (!a.d(Balloon.q(this))) {
                    contentView = Balloon.o(this).getContentView();
                    n.e(contentView, "bodyWindow.contentView");
                    if (contentView.getParent() == null) {
                        if (u.Q(view)) {
                            super(this, view, this, view, i2, i3);
                            view.post(lVar);
                        } else {
                            if (obj9.p0) {
                                J();
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
    }

    @Override // androidx.lifecycle.p
    public final void x0(View view, int i2, int i3) {
        boolean mVar;
        String str;
        com.skydoves.balloon.Balloon balloon2;
        Object obj;
        com.skydoves.balloon.Balloon balloon;
        Object obj2;
        int i;
        int i4;
        boolean obj9;
        n.f(view, "anchor");
        View contentView = Balloon.o(this).getContentView();
        n.e(contentView, "bodyWindow.contentView");
        if (!l0() && !Balloon.r(this) && !a.d(Balloon.q(this)) && contentView.getParent() == null && u.Q(view)) {
            if (!Balloon.r(this)) {
                if (!a.d(Balloon.q(this))) {
                    contentView = Balloon.o(this).getContentView();
                    n.e(contentView, "bodyWindow.contentView");
                    if (contentView.getParent() == null) {
                        if (u.Q(view)) {
                            super(this, view, this, view, i2, i3);
                            view.post(mVar);
                        } else {
                            if (obj9.p0) {
                                J();
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
    }
}
