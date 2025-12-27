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
import androidx.lifecycle.j.b;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.skydoves.balloon.a0.d;
import com.skydoves.balloon.overlay.BalloonAnchorOverlayView;
import com.skydoves.balloon.overlay.c;
import com.skydoves.balloon.radius.RadiusLayout;
import com.skydoves.balloon.vectortext.VectorTextView;
import d.h.l.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.m;
import kotlin.o;
import kotlin.w;
import kotlin.y.h0;

/* compiled from: Balloon.kt */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001:\u0002\u0097\u0001B\u001d\u0012\u0008\u0010\u0095\u0001\u001a\u00030\u0092\u0001\u0012\u0008\u0010\u0089\u0001\u001a\u00030\u0087\u0001¢\u0006\u0006\u0008 \u0001\u0010¡\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u000cH\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012J'\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0002¢\u0006\u0004\u0008\u0018\u0010\u0019J+\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u000c0\u001a2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0002¢\u0006\u0004\u0008\u001b\u0010\u001cJ'\u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000c2\u0006\u0010 \u001a\u00020\u000cH\u0002¢\u0006\u0004\u0008!\u0010\"J\u0017\u0010#\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008#\u0010\u0012J\u0017\u0010$\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008$\u0010%J\u0017\u0010&\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008&\u0010%J\u000f\u0010'\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008(\u0010\u0004J\u000f\u0010)\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008)\u0010\u0004J\u000f\u0010*\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008*\u0010\u0004J\u000f\u0010+\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008+\u0010\u0004J\u000f\u0010,\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008,\u0010\u0004J\u000f\u0010-\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008-\u0010\u0004J\u000f\u0010.\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008.\u0010\u0004J\u000f\u00100\u001a\u00020/H\u0002¢\u0006\u0004\u00080\u00101J\u000f\u00102\u001a\u00020\u0002H\u0002¢\u0006\u0004\u00082\u0010\u0004J\u000f\u00103\u001a\u00020\u0002H\u0002¢\u0006\u0004\u00083\u0010\u0004J\u000f\u00104\u001a\u00020\u0002H\u0002¢\u0006\u0004\u00084\u0010\u0004J\u000f\u00105\u001a\u00020\u0002H\u0002¢\u0006\u0004\u00085\u0010\u0004J\u0011\u00107\u001a\u0004\u0018\u000106H\u0002¢\u0006\u0004\u00087\u00108J\u000f\u00109\u001a\u00020\u0002H\u0002¢\u0006\u0004\u00089\u0010\u0004J\u000f\u0010:\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008:\u0010\u0004J\u0017\u0010;\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008;\u0010\u0012J\u001f\u0010?\u001a\u00020\u00022\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008?\u0010@J\u0017\u0010A\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\u0008A\u0010\u0008J\u001f\u0010C\u001a\u00020\u000c2\u0006\u0010B\u001a\u00020\u000c2\u0006\u0010>\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008C\u0010DJ+\u0010G\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0008\u0008\u0002\u0010E\u001a\u00020\u000c2\u0008\u0008\u0002\u0010F\u001a\u00020\u000cH\u0007¢\u0006\u0004\u0008G\u0010HJ+\u0010I\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0008\u0008\u0002\u0010E\u001a\u00020\u000c2\u0008\u0008\u0002\u0010F\u001a\u00020\u000cH\u0007¢\u0006\u0004\u0008I\u0010HJ\r\u0010J\u001a\u00020\u0002¢\u0006\u0004\u0008J\u0010\u0004J\u0015\u0010M\u001a\u00020/2\u0006\u0010L\u001a\u00020K¢\u0006\u0004\u0008M\u0010NJ\u0017\u0010Q\u001a\u00020\u00022\u0008\u0010P\u001a\u0004\u0018\u00010O¢\u0006\u0004\u0008Q\u0010RJ\u0017\u0010U\u001a\u00020\u00022\u0008\u0010T\u001a\u0004\u0018\u00010S¢\u0006\u0004\u0008U\u0010VJ!\u0010Y\u001a\u00020\u00022\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020W¢\u0006\u0004\u0008Y\u0010ZJ\u0017\u0010]\u001a\u00020\u00022\u0008\u0010\\\u001a\u0004\u0018\u00010[¢\u0006\u0004\u0008]\u0010^J\u001b\u0010`\u001a\u00020\u00022\u000c\u0010X\u001a\u0008\u0012\u0004\u0012\u00020\u00020_¢\u0006\u0004\u0008`\u0010aJ\u0017\u0010d\u001a\u00020\u00022\u0008\u0010c\u001a\u0004\u0018\u00010b¢\u0006\u0004\u0008d\u0010eJ\u0017\u0010h\u001a\u00020\u00022\u0008\u0010g\u001a\u0004\u0018\u00010f¢\u0006\u0004\u0008h\u0010iJ\u0017\u0010j\u001a\u00020\u00022\u0008\u0010g\u001a\u0004\u0018\u00010f¢\u0006\u0004\u0008j\u0010iJ\u0017\u0010m\u001a\u00020\u00022\u0008\u0010l\u001a\u0004\u0018\u00010k¢\u0006\u0004\u0008m\u0010nJ\r\u0010o\u001a\u00020\u000c¢\u0006\u0004\u0008o\u0010\u000eJ\r\u0010p\u001a\u00020\u000c¢\u0006\u0004\u0008p\u0010\u000eJ\r\u0010q\u001a\u00020\u0005¢\u0006\u0004\u0008q\u0010rJ\u000f\u0010s\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008s\u0010\u0004J\u000f\u0010t\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008t\u0010\u0004R\u001d\u0010z\u001a\u00020u8B@\u0002X\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008v\u0010w\u001a\u0004\u0008x\u0010yR\u001d\u0010\u007f\u001a\u00020{8B@\u0002X\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008|\u0010w\u001a\u0004\u0008}\u0010~R\"\u0010\u0084\u0001\u001a\u00030\u0080\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u000f\n\u0005\u0008\u0081\u0001\u0010w\u001a\u0006\u0008\u0082\u0001\u0010\u0083\u0001R$\u0010T\u001a\u0004\u0018\u00010S2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010S8\u0006@FX\u0087\u000e¢\u0006\u0007\n\u0005\u0008\u0016\u0010\u0086\u0001R\u0019\u0010\u0089\u0001\u001a\u00030\u0087\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\u0008\u0018\u0010\u0088\u0001R(\u0010\u008c\u0001\u001a\u00020/2\u0007\u0010\u0085\u0001\u001a\u00020/8\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0005\u0008\u008a\u0001\u00100\u001a\u0005\u0008\u008b\u0001\u00101R\u0017\u0010\u008d\u0001\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0015\u00100R\u001a\u0010\u0091\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008\u008f\u0001\u0010\u0090\u0001R\u001a\u0010\u0095\u0001\u001a\u00030\u0092\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008\u0093\u0001\u0010\u0094\u0001R\u001a\u0010\u0099\u0001\u001a\u00030\u0096\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008\u0097\u0001\u0010\u0098\u0001R\u001a\u0010\u009b\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008\u009a\u0001\u0010\u0090\u0001R\u001a\u0010\u009f\u0001\u001a\u00030\u009c\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008\u009d\u0001\u0010\u009e\u0001¨\u0006¢\u0001", d2 = {"Lcom/skydoves/balloon/Balloon;", "Landroidx/lifecycle/p;", "Lkotlin/w;", "I", "()V", "Landroid/view/ViewGroup;", "parent", "F", "(Landroid/view/ViewGroup;)V", "", "Y", "()F", "", "T", "()I", "Landroid/view/View;", "anchor", "a0", "(Landroid/view/View;)V", "Landroidx/appcompat/widget/AppCompatImageView;", "imageView", "x", "y", "Landroid/graphics/Bitmap;", "D", "(Landroidx/appcompat/widget/AppCompatImageView;FF)Landroid/graphics/Bitmap;", "Lkotlin/o;", "R", "(FF)Lkotlin/o;", "Landroid/graphics/drawable/Drawable;", "drawable", "width", "height", "L", "(Landroid/graphics/drawable/Drawable;II)Landroid/graphics/Bitmap;", "E", "M", "(Landroid/view/View;)F", "N", "b0", "h0", "e0", "g0", "c0", "j0", "k0", "d0", "", "Z", "()Z", "i0", "f0", "G", "H", "Landroid/view/animation/Animation;", "P", "()Landroid/view/animation/Animation;", "z0", "A0", "y0", "Landroidx/appcompat/widget/AppCompatTextView;", "textView", "rootView", "m0", "(Landroidx/appcompat/widget/AppCompatTextView;Landroid/view/View;)V", "B0", "measuredWidth", "W", "(ILandroid/view/View;)I", "xOff", "yOff", "x0", "(Landroid/view/View;II)V", "w0", "J", "", "delay", "K", "(J)Z", "Lcom/skydoves/balloon/o;", "onBalloonClickListener", "n0", "(Lcom/skydoves/balloon/o;)V", "Lcom/skydoves/balloon/q;", "onBalloonInitializedListener", "q0", "(Lcom/skydoves/balloon/q;)V", "Lkotlin/Function1;", "block", "r0", "(Lkotlin/d0/c/l;)V", "Lcom/skydoves/balloon/p;", "onBalloonDismissListener", "o0", "(Lcom/skydoves/balloon/p;)V", "Lkotlin/Function0;", "p0", "(Lkotlin/d0/c/a;)V", "Lcom/skydoves/balloon/r;", "onBalloonOutsideTouchListener", "s0", "(Lcom/skydoves/balloon/r;)V", "Landroid/view/View$OnTouchListener;", "onTouchListener", "v0", "(Landroid/view/View$OnTouchListener;)V", "u0", "Lcom/skydoves/balloon/s;", "onBalloonOverlayClickListener", "t0", "(Lcom/skydoves/balloon/s;)V", "X", "V", "S", "()Landroid/view/ViewGroup;", "onPause", "onDestroy", "Landroid/os/Handler;", "z", "Lkotlin/h;", "U", "()Landroid/os/Handler;", "handler", "Lcom/skydoves/balloon/d;", "A", "O", "()Lcom/skydoves/balloon/d;", "autoDismissRunnable", "Lcom/skydoves/balloon/k;", "B", "Q", "()Lcom/skydoves/balloon/k;", "balloonPersistence", "<set-?>", "Lcom/skydoves/balloon/q;", "Lcom/skydoves/balloon/Balloon$a;", "Lcom/skydoves/balloon/Balloon$a;", "builder", "w", "l0", "isShowing", "destroyed", "Landroid/widget/PopupWindow;", "c", "Landroid/widget/PopupWindow;", "bodyWindow", "Landroid/content/Context;", "C", "Landroid/content/Context;", "context", "Lcom/skydoves/balloon/z/a;", "a", "Lcom/skydoves/balloon/z/a;", "binding", "v", "overlayWindow", "Lcom/skydoves/balloon/z/b;", "b", "Lcom/skydoves/balloon/z/b;", "overlayBinding", "<init>", "(Landroid/content/Context;Lcom/skydoves/balloon/Balloon$a;)V", "balloon_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class Balloon implements androidx.lifecycle.p {

    /* renamed from: A, reason: from kotlin metadata */
    private final h autoDismissRunnable;
    /* renamed from: B, reason: from kotlin metadata */
    private final h balloonPersistence;
    /* renamed from: C, reason: from kotlin metadata */
    private final Context context;
    /* renamed from: D, reason: from kotlin metadata */
    private final Balloon.a builder;
    /* renamed from: a, reason: from kotlin metadata */
    private final com.skydoves.balloon.z.a binding;
    /* renamed from: b, reason: from kotlin metadata */
    private final com.skydoves.balloon.z.b overlayBinding;
    /* renamed from: c, reason: from kotlin metadata */
    private final PopupWindow bodyWindow = new PopupWindow();
    /* renamed from: v, reason: from kotlin metadata */
    private final PopupWindow overlayWindow = new PopupWindow();
    /* renamed from: w, reason: from kotlin metadata */
    private boolean isShowing;
    /* renamed from: x, reason: from kotlin metadata */
    private boolean destroyed;
    /* renamed from: y, reason: from kotlin metadata */
    public q onBalloonInitializedListener;
    /* renamed from: z, reason: from kotlin metadata */
    private final h handler;

    public static final class a {

        public int A;
        public h A0;
        public int B;
        public int B0 = Integer.MIN_VALUE;
        public int C;
        public long C0;
        public float D = 2.5f;
        public String D0;
        public float E;
        public int E0 = 1;
        public int F = -16777216;
        public kotlin.d0.c.a<w> F0;
        public Drawable G;
        public boolean G0 = false;
        public float H;
        public int H0;
        public java.lang.CharSequence I = "";
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
        public y Q;
        public Drawable R;
        public n S;
        public int T;
        public int U;
        public int V;
        public int W = Integer.MIN_VALUE;
        public m X;
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
        public com.skydoves.balloon.overlay.e g0;
        public int h;
        public o h0;
        public int i;
        public p i0;
        public int j;
        public q j0;
        public int k;
        public r k0;
        public int l;
        public View.OnTouchListener l0;
        public int m;
        public View.OnTouchListener m0;
        public int n;
        public s n0;
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
        public c u;
        public q u0;
        public b v;
        public int v0 = Integer.MIN_VALUE;
        public a w;
        public int w0 = Integer.MIN_VALUE;
        public Drawable x;
        public f x0;
        public int y;
        public com.skydoves.balloon.overlay.a y0;
        public int z;
        public long z0 = 500;
        public a(Context context) {
            n.f(context, "context");
            super();
            this.K0 = context;
            this.c = a.c(context).x;
            int i3 = 1;
            Resources system3 = Resources.getSystem();
            final String str5 = "Resources.getSystem()";
            n.e(system3, str5);
            this.s = a.b(TypedValue.applyDimension(i3, (float)12, system3.getDisplayMetrics()));
            this.u = c.ALIGN_BALLOON;
            this.v = b.ALIGN_ANCHOR;
            this.w = a.BOTTOM;
            Resources system = Resources.getSystem();
            n.e(system, str5);
            this.H = TypedValue.applyDimension(i3, 5f, system.getDisplayMetrics());
            this.S = n.START;
            float f2 = (float)28;
            Resources system4 = Resources.getSystem();
            n.e(system4, str5);
            this.T = a.b(TypedValue.applyDimension(i3, f2, system4.getDisplayMetrics()));
            Resources system5 = Resources.getSystem();
            n.e(system5, str5);
            this.U = a.b(TypedValue.applyDimension(i3, f2, system5.getDisplayMetrics()));
            Resources system6 = Resources.getSystem();
            n.e(system6, str5);
            this.V = a.b(TypedValue.applyDimension(i3, (float)8, system6.getDisplayMetrics()));
            Resources system2 = Resources.getSystem();
            n.e(system2, str5);
            this.Z = TypedValue.applyDimension(i3, 2f, system2.getDisplayMetrics());
            this.g0 = c.a;
            this.x0 = f.FADE;
            this.y0 = a.FADE;
            this.A0 = h.NONE;
            Resources resources = context.getResources();
            n.e(resources, "context.resources");
            Configuration configuration = resources.getConfiguration();
            n.e(configuration, "context.resources.configuration");
            context = configuration.getLayoutDirection() == i3 ? /* no value */ : 0;
        }

        public final Balloon.a A(int i) {
            final String string = this.K0.getString(i);
            n.e(string, "context.getString(value)");
            this.I = string;
            return this;
        }

        public final Balloon.a B(float f) {
            this.M = f;
            return this;
        }

        public final Balloon.a C(Typeface typeface) {
            n.f(typeface, "value");
            this.O = typeface;
            return this;
        }

        public final Balloon.a D(float f) {
            this.d = f;
            return this;
        }

        public final Balloon a() {
            return new Balloon(this.K0, this);
        }

        public final Balloon.a b(Drawable drawable) {
            Drawable mutate = null;
            if (drawable != null) {
                mutate = drawable.mutate();
            } else {
                int i3 = 0;
            }
            this.x = mutate;
            if (drawable != null) {
                int i = Integer.MIN_VALUE;
                if (this.s == Integer.MIN_VALUE) {
                    this.s = Math.max(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                }
            }
            return this;
        }

        public final Balloon.a c(a aVar) {
            n.f(aVar, "value");
            this.w = aVar;
            return this;
        }

        public final Balloon.a d(float f) {
            this.t = f;
            return this;
        }

        public final Balloon.a e(c cVar) {
            n.f(cVar, "value");
            this.u = cVar;
            return this;
        }

        public final Balloon.a f(int i) {
            int i2 = -2147483648;
            i2 = Integer.MIN_VALUE;
            if (i != Integer.MIN_VALUE) {
                Resources system = Resources.getSystem();
                str = "Resources.getSystem()";
                n.e(system, str);
                i2 = a.b(TypedValue.applyDimension(1, (float)i, system.getDisplayMetrics()));
            }
            this.s = i2;
            return this;
        }

        public final Balloon.a g(int i) {
            Resources system = Resources.getSystem();
            n.e(system, "Resources.getSystem()");
            this.A = a.b(TypedValue.applyDimension(1, (float)i, system.getDisplayMetrics()));
            return this;
        }

        public final Balloon.a h(long j) {
            this.t0 = j;
            return this;
        }

        public final Balloon.a i(int i) {
            this.F = a.a(this.K0, i);
            return this;
        }

        public final Balloon.a j(f fVar) {
            n.f(fVar, "value");
            this.x0 = fVar;
            if (fVar == f.CIRCULAR) {
                boolean z = false;
                n(z);
            }
            return this;
        }

        public final Balloon.a k(float f) {
            Resources system = Resources.getSystem();
            n.e(system, "Resources.getSystem()");
            this.H = TypedValue.applyDimension(1, f, system.getDisplayMetrics());
            return this;
        }

        public final Balloon.a l(boolean z) {
            this.r0 = z;
            return this;
        }

        public final Balloon.a m(boolean z) {
            this.o0 = z;
            if (!z) {
                n(z);
            }
            return this;
        }

        public final Balloon.a n(boolean z) {
            this.I0 = z;
            return this;
        }

        public final Balloon.a o(int i) {
            int i2 = 0;
            i2 = 1;
            if (i > 0 || i == Integer.MIN_VALUE) {
            }
            if (Integer.MIN_VALUE == 0) {
                throw new IllegalArgumentException("The height of the balloon must bigger than zero.".toString());
            } else {
                Resources system = Resources.getSystem();
                n.e(system, "Resources.getSystem()");
                this.g = a.b(TypedValue.applyDimension(i2, (float)i, system.getDisplayMetrics()));
                return this;
            }
        }

        public final Balloon.a p(boolean z) {
            this.c0 = z;
            return this;
        }

        public final Balloon.a q(View view) {
            n.f(view, "layout");
            this.a0 = view;
            return this;
        }

        public final Balloon.a r(q qVar) {
            this.u0 = qVar;
            return this;
        }

        public final Balloon.a s(int i) {
            Resources system = Resources.getSystem();
            n.e(system, "Resources.getSystem()");
            this.m = a.b(TypedValue.applyDimension(1, (float)i, system.getDisplayMetrics()));
            return this;
        }

        public final Balloon.a t(int i) {
            Resources system = Resources.getSystem();
            n.e(system, "Resources.getSystem()");
            this.l = a.b(TypedValue.applyDimension(1, (float)i, system.getDisplayMetrics()));
            return this;
        }

        public final Balloon.a u(int i) {
            this.d0 = a.a(this.K0, i);
            return this;
        }

        public final Balloon.a v(int i) {
            Resources system = Resources.getSystem();
            n.e(system, "Resources.getSystem()");
            this.k = a.b(TypedValue.applyDimension(1, (float)i, system.getDisplayMetrics()));
            return this;
        }

        public final Balloon.a w(int i) {
            Resources system = Resources.getSystem();
            n.e(system, "Resources.getSystem()");
            this.h = a.b(TypedValue.applyDimension(1, (float)i, system.getDisplayMetrics()));
            return this;
        }

        public final Balloon.a x(int i) {
            Resources system = Resources.getSystem();
            n.e(system, "Resources.getSystem()");
            this.j = a.b(TypedValue.applyDimension(1, (float)i, system.getDisplayMetrics()));
            return this;
        }

        public final Balloon.a y(int i) {
            Resources system = Resources.getSystem();
            n.e(system, "Resources.getSystem()");
            this.i = a.b(TypedValue.applyDimension(1, (float)i, system.getDisplayMetrics()));
            return this;
        }

        public final Balloon.a z(int i) {
            this.J = a.a(this.K0, i);
            return this;
        }
    }

    public static final class d implements Runnable {

        final /* synthetic */ View a;
        final /* synthetic */ long b;
        final /* synthetic */ kotlin.d0.c.a c;
        @Override // java.lang.Runnable
        public final void run() {
            if (this.a.isAttachedToWindow()) {
                i = (this.a.getTop() + this.a.getBottom()) / 2;
                f = (float)(Math.max(this.a.getWidth(), this.a.getHeight()));
                float f2 = 0.0f;
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(this.a, (this.a.getLeft() + this.a.getRight()) / 2, i, f, f2);
                circularReveal.setDuration(this.b);
                circularReveal.start();
                circularReveal.addListener(new Balloon.d.a(this));
            }
        }

        public d(View view, long j, kotlin.d0.c.a aVar) {
            this.a = view;
            this.b = j;
            this.c = aVar;
            super();
        }
    }

    static final class g implements Runnable {

        final /* synthetic */ AppCompatImageView a;
        final /* synthetic */ Balloon b;
        final /* synthetic */ View c;
        @Override // java.lang.Runnable
        public final void run() throws NoWhenBranchMatchedException {
            if (balloon.onBalloonInitializedListener != null) {
                balloon.onBalloonInitializedListener.b(this.b.S());
            }
            this.b.M(this.c);
            int i = e.a[this.b.builder.w.ordinal()];
            str = "this";
            int i2 = 1;
            String str2 = "binding.balloonCard";
            if (this.b.builder.w != i2) {
                float f4 = 0.0f;
                if (this.b.builder.w != 2) {
                    if (this.b.builder.w != 3 && this.b.builder.w == 4) {
                        this.a.setRotation(90f);
                        n.e(this.b.binding.d, "binding.balloonCard");
                        n.e(this.b.binding.d, "binding.balloonCard");
                        f4 = (float)this.b.binding.d.getWidth();
                        this.a.setX((this.b.binding.d.getX() + f4) - (float)i2);
                        this.a.setY(this.b.K(this.c));
                        if (this.b.builder.r) {
                            n.e(this.a, str);
                            n.e(this.b.binding.d, "binding.balloonCard");
                            this.a.setForeground(new BitmapDrawable(this.a.getResources(), this.b.D(this.a, (float)this.b.binding.d.getWidth(), this.a.getY())));
                        }
                    }
                    this.a.setRotation(-90f);
                    n.e(this.b.binding.d, "binding.balloonCard");
                    f3 = (float)this.b.builder.s;
                    this.a.setX((this.b.binding.d.getX() - f3) + (float)i2);
                    this.a.setY(this.b.K(this.c));
                    if (this.b.builder.r) {
                        n.e(this.a, str);
                        this.a.setForeground(new BitmapDrawable(this.a.getResources(), this.b.D(this.a, 0.0f, this.a.getY())));
                    }
                } else {
                    this.a.setRotation(0.0f);
                    this.a.setX(this.b.y0(this.c));
                    n.e(this.b.binding.d, "binding.balloonCard");
                    f3 = (float)this.b.builder.s;
                    f = (float)i2;
                    f2 = (this.b.binding.d.getY() - f3) + f;
                    this.a.setY(f2);
                    if (this.b.builder.r) {
                        n.e(this.a, str);
                        this.a.setForeground(new BitmapDrawable(this.a.getResources(), this.b.D(this.a, this.a.getX(), 0.0f)));
                    }
                }
            } else {
                this.a.setRotation(180f);
                this.a.setX(this.b.y0(this.c));
                n.e(this.b.binding.d, "binding.balloonCard");
                n.e(this.b.binding.d, "binding.balloonCard");
                f4 = (float)this.b.binding.d.getHeight();
                f3 = (this.b.binding.d.getY() + f4) - (float)i2;
                this.a.setY(f3);
                u.s0(this.a, this.b.builder.E);
                if (this.b.builder.r) {
                    n.e(this.a, str);
                    n.e(this.b.binding.d, "binding.balloonCard");
                    f2 = (float)this.b.binding.d.getHeight();
                    this.a.setForeground(new BitmapDrawable(this.a.getResources(), this.b.D(this.a, this.a.getX(), f2)));
                }
            }
            e.d(this.a, this.b.builder.p);
        }

        g(AppCompatImageView appCompatImageView, Balloon balloon, View view) {
            this.a = appCompatImageView;
            this.b = balloon;
            this.c = view;
            super();
        }
    }

    static final class h implements View.OnClickListener {

        final /* synthetic */ Balloon a;
        final /* synthetic */ o b;
        @Override // android.view.View$OnClickListener
        public final void onClick(View view) {
            if (this.b != null) {
                str = "it";
                n.e(view, str);
                this.b.a(view);
            }
            if (this.a.builder.q0) {
                this.a.J();
            }
        }

        h(o oVar) {
            this.a = balloon;
            this.b = oVar;
            super();
        }
    }

    static final class i implements PopupWindow.OnDismissListener {

        final /* synthetic */ Balloon a;
        final /* synthetic */ p b;
        public final void onDismiss() {
            this.a.I();
            this.a.J();
            if (this.b != null) {
                this.b.b();
            }
        }

        i(p pVar) {
            this.a = balloon;
            this.b = pVar;
            super();
        }
    }

    public static final class j implements View.OnTouchListener {

        final /* synthetic */ Balloon a;
        final /* synthetic */ r b;
        j(r rVar) {
            this.a = balloon;
            this.b = rVar;
            super();
        }

        @Override // android.view.View$OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            n.f(view, "view");
            n.f(motionEvent, "event");
            if (motionEvent.getAction() == 4) {
                if (this.a.builder.o0) {
                    this.a.J();
                }
                if (this.b != null) {
                    this.b.a(view, motionEvent);
                }
                return true;
            }
            return false;
        }
    }

    static final class k implements View.OnClickListener {

        final /* synthetic */ Balloon a;
        final /* synthetic */ s b;
        @Override // android.view.View$OnClickListener
        public final void onClick(View view) {
            if (this.b != null) {
                this.b.a();
            }
            if (this.a.builder.r0) {
                this.a.J();
            }
        }

        k(s sVar) {
            this.a = balloon;
            this.b = sVar;
            super();
        }
    }

    public static final class l implements Runnable {

        final /* synthetic */ Balloon a;
        final /* synthetic */ View b;
        final /* synthetic */ Balloon c;
        final /* synthetic */ View v;
        final /* synthetic */ int w;
        final /* synthetic */ int x;
        @Override // java.lang.Runnable
        public final void run() {
            if (this.a.builder.D0 != null) {
                if (this.a.Q().g(this.a.builder.D0, this.a.builder.E0)) {
                    this.a.Q().f(this.a.builder.D0);
                } else {
                    if (this.a.builder.F0 != null) {
                        Object invoke = this.a.builder.F0.invoke();
                    }
                }
                return;
            }
            boolean z2 = true;
            this.a.isShowing = z2;
            if (this.a.builder.t0 != -1) {
                this.a.K(this.a.builder.t0);
            }
            String str = "binding.balloonCard";
            if (this.a.Z()) {
                n.e(this.a.binding.d, "binding.balloonCard");
                this.a.E(this.a.binding.d);
            } else {
                n.e(this.a.binding.f, "binding.balloonText");
                n.e(this.a.binding.d, "binding.balloonCard");
                this.a.m0(this.a.binding.f, this.a.binding.d);
            }
            int i2 = 0;
            this.a.binding.b().measure(i2, i2);
            this.a.bodyWindow.setWidth(this.a.X());
            this.a.bodyWindow.setHeight(this.a.V());
            n.e(this.a.binding.f, "this.binding.balloonText");
            int i6 = -1;
            this.a.binding.f.setLayoutParams(new FrameLayout.LayoutParams(i6, i6));
            this.a.n0(this.b);
            this.a.c0();
            this.a.H();
            this.a.y0(this.b);
            this.a.G();
            this.a.z0();
            this.c.bodyWindow.showAsDropDown(this.v, this.c.builder.H0 * (this.v.getMeasuredWidth() / 2) - (this.c.X() / 2) + this.w, this.x);
        }

        public l(View view, Balloon balloon, View view2, int i, int i2) {
            this.a = balloon;
            this.b = view;
            this.c = balloon2;
            this.v = view2;
            this.w = i;
            this.x = i2;
            super();
        }
    }

    public static final class m implements Runnable {

        final /* synthetic */ Balloon a;
        final /* synthetic */ View b;
        final /* synthetic */ Balloon c;
        final /* synthetic */ View v;
        final /* synthetic */ int w;
        final /* synthetic */ int x;
        @Override // java.lang.Runnable
        public final void run() {
            if (this.a.builder.D0 != null) {
                if (this.a.Q().g(this.a.builder.D0, this.a.builder.E0)) {
                    this.a.Q().f(this.a.builder.D0);
                } else {
                    if (this.a.builder.F0 != null) {
                        Object invoke = this.a.builder.F0.invoke();
                    }
                }
                return;
            }
            boolean z2 = true;
            this.a.isShowing = z2;
            if (this.a.builder.t0 != -1) {
                this.a.K(this.a.builder.t0);
            }
            String str = "binding.balloonCard";
            if (this.a.Z()) {
                n.e(this.a.binding.d, "binding.balloonCard");
                this.a.E(this.a.binding.d);
            } else {
                n.e(this.a.binding.f, "binding.balloonText");
                n.e(this.a.binding.d, "binding.balloonCard");
                this.a.m0(this.a.binding.f, this.a.binding.d);
            }
            int i2 = 0;
            this.a.binding.b().measure(i2, i2);
            this.a.bodyWindow.setWidth(this.a.X());
            this.a.bodyWindow.setHeight(this.a.V());
            n.e(this.a.binding.f, "this.binding.balloonText");
            int i6 = -1;
            this.a.binding.f.setLayoutParams(new FrameLayout.LayoutParams(i6, i6));
            this.a.n0(this.b);
            this.a.c0();
            this.a.H();
            this.a.y0(this.b);
            this.a.G();
            this.a.z0();
            this.c.bodyWindow.showAsDropDown(this.v, this.c.builder.H0 * (this.v.getMeasuredWidth() / 2) - (this.c.X() / 2) + this.w, (-this.c.V() - this.v.getMeasuredHeight()) + this.x);
        }

        public m(View view, Balloon balloon, View view2, int i, int i2) {
            this.a = balloon;
            this.b = view;
            this.c = balloon2;
            this.v = view2;
            this.w = i;
            this.x = i2;
            super();
        }
    }

    static final class n implements Runnable {

        final /* synthetic */ Balloon a;
        @Override // java.lang.Runnable
        public final void run() {
            new Handler(Looper.getMainLooper()).postDelayed(new Balloon.n.a(this), this.a.builder.C0);
        }

        n() {
            this.a = balloon;
            super();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0001\u0010\u0002", d2 = {"Lcom/skydoves/balloon/d;", "a", "()Lcom/skydoves/balloon/d;"}, k = 3, mv = {1, 4, 2})
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.a<d> {
        @Override // kotlin.d0.d.p
        public final d a() {
            return new d(Balloon.this);
        }

        b() {
            super(0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0001\u0010\u0002", d2 = {"Lcom/skydoves/balloon/k;", "a", "()Lcom/skydoves/balloon/k;"}, k = 3, mv = {1, 4, 2})
    static final class c extends kotlin.d0.d.p implements kotlin.d0.c.a<k> {
        @Override // kotlin.d0.d.p
        public final k a() {
            return k.c.a(Balloon.this.context);
        }

        c() {
            super(0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0001\u0010\u0002", d2 = {"Lkotlin/w;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    static final class e extends kotlin.d0.d.p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            Balloon.this.isShowing = 0;
            Balloon.this.bodyWindow.dismiss();
            Balloon.this.overlayWindow.dismiss();
            Balloon.this.U().removeCallbacks(Balloon.this.O());
        }

        e() {
            super(0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0001\u0010\u0002", d2 = {"Landroid/os/Handler;", "a", "()Landroid/os/Handler;"}, k = 3, mv = {1, 4, 2})
    static final class f extends kotlin.d0.d.p implements kotlin.d0.c.a<Handler> {

        public static final Balloon.f a = new Balloon$f();
        @Override // kotlin.d0.d.p
        public final Handler a() {
            return new Handler(Looper.getMainLooper());
        }


        f() {
            super(0);
        }
    }
    public Balloon(Context context, Balloon.a aVar) {
        n.f(context, "context");
        n.f(aVar, "builder");
        super();
        this.context = context;
        this.builder = aVar;
        ViewGroup viewGroup = null;
        final boolean z = false;
        com.skydoves.balloon.z.a aVar2 = a.c(LayoutInflater.from(context), viewGroup, z);
        n.e(aVar2, "LayoutBalloonLibrarySkyd…om(context), null, false)");
        this.binding = aVar2;
        com.skydoves.balloon.z.b bVar2 = b.c(LayoutInflater.from(context), viewGroup, z);
        n.e(bVar2, "LayoutBalloonOverlayLibr…om(context), null, false)");
        this.overlayBinding = bVar2;
        this.onBalloonInitializedListener = aVar.j0;
        m nONE2 = LazyThreadSafetyMode.NONE;
        this.handler = j.a(nONE2, Balloon.f.a);
        this.autoDismissRunnable = j.a(nONE2, new Balloon.b(this));
        this.balloonPersistence = j.a(nONE2, new Balloon.c(this));
        int i2 = -2;
        PopupWindow popupWindow = new PopupWindow(aVar2.b(), i2, i2);
        int i = -1;
        PopupWindow popupWindow2 = new PopupWindow(bVar2.b(), i, i);
        I();
    }

    /* renamed from: A, reason: from kotlin metadata */
    public static final /* synthetic */ void F(Balloon parent) {
        parent.z0();
    }

    /* renamed from: A0, reason: from kotlin metadata */
    private final void I() {
        final Animation animation = this.binding.b.getAnimation();
        if (animation != null) {
            animation.cancel();
            animation.reset();
        }
        this.binding.b.clearAnimation();
    }

    /* renamed from: B, reason: from kotlin metadata */
    public static final /* synthetic */ void a0(Balloon anchor) {
        anchor.I();
    }

    /* renamed from: B0, reason: from kotlin metadata */
    private final void E(ViewGroup anchor) {
        int i = 0;
        boolean z;
        i = 0;
        while (i < anchor.getChildCount()) {
            View childAt = anchor.getChildAt(i);
            n.c(childAt, "getChildAt(index)");
            z = childAt instanceof AppCompatTextView;
            i = i + 1;
        }
    }

    /* renamed from: C, reason: from kotlin metadata */
    public static final /* synthetic */ void R(Balloon x, ViewGroup y) {
        x.E(y);
    }

    private final Bitmap D(AppCompatImageView imageView, float x, float y) throws NoWhenBranchMatchedException {
        Object obj3;
        final Object imageView2 = this;
        java.lang.IllegalArgumentException x3 = imageView;
        x3.setColorFilter(imageView2.builder.F, PorterDuff.Mode.SRC_IN);
        Drawable drawable = imageView.getDrawable();
        String str3 = "imageView.drawable";
        n.e(drawable, str3);
        Drawable drawable2 = imageView.getDrawable();
        n.e(drawable2, str3);
        Drawable drawable3 = imageView.getDrawable();
        n.e(drawable3, str3);
        Bitmap bitmap = L(drawable, drawable2.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
        try {
            o oVar = m0(x, y);
        } catch (java.lang.IllegalArgumentException unused) {
            throw new IllegalArgumentException("Arrow attached outside balloon. Could not get a matching color.");
        }
        final int intValue = (Number)oVar.c().intValue();
        final int intValue2 = (Number)oVar.d().intValue();
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap2);
        float f9 = 0.0f;
        canvas.drawBitmap(bitmap, f9, f9, null);
        final Paint paint = new Paint();
        int i5 = e.b[imageView2.builder.w.ordinal()];
        int i13 = 2;
        if (imageView2.builder.w == 1 || imageView2.builder.w == i13) {
            f = (float)bitmap.getWidth() / (float)i13 - (float)(imageView2.builder.s / i13);
            float f2 = 0.0f;
            f3 = (float)bitmap.getWidth();
            float f4 = 0.0f;
            LinearGradient linearGradient = new LinearGradient(f, f2, f3, f4, intValue, intValue2, Shader.TileMode.CLAMP);
        } else {
            int i = 3;
            f = (float)(imageView2.builder.s / i13) + (float)bitmap.getWidth() / (float)i13;
            f2 = 0.0f;
            float f3 = 0.0f;
            f4 = 0.0f;
            linearGradient = new LinearGradient(f, f2, f3, f4, intValue, intValue2, Shader.TileMode.CLAMP);
        }
        paint.setShader(obj3);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawRect(0.0f, 0.0f, (float)bitmap.getWidth(), (float)bitmap.getHeight(), paint);
        x3.setColorFilter(0, PorterDuff.Mode.SRC_IN);
        n.e(bitmap2, "updatedBitmap");
        return bitmap2;
    }

    /* renamed from: E, reason: from kotlin metadata */
    private final void M(View anchor) {
        int bottom2;
        if (this.builder.v == b.ALIGN_FIXED) {
            return;
        }
        Rect rect = new Rect();
        anchor.getGlobalVisibleRect(rect);
        int[] iArr = new int[] {0, 0};
        this.bodyWindow.getContentView().getLocationOnScreen(iArr);
        final com.skydoves.balloon.a tOP2 = a.TOP;
        final int i2 = 1;
        if (builder22.w == a.TOP) {
            if (iArr[i2] < rect.bottom) {
                this.builder.c(a.BOTTOM);
            } else {
                if (builder22.w == a.BOTTOM) {
                    if (iArr[i2] > rect.top) {
                        this.builder.c(a.TOP);
                    }
                }
            }
        }
        c0();
    }

    /* renamed from: F, reason: from kotlin metadata */
    private final void N(ViewGroup anchor) {
        final boolean z = false;
        anchor.setFitsSystemWindows(z);
        kotlin.h0.f fVar = g.l(z, anchor.getChildCount());
        ArrayList arrayList = new ArrayList(p.r(fVar, 10));
        Iterator item = fVar.iterator();
        while (item.hasNext()) {
            arrayList.add(anchor.getChildAt((IntIterator)item.d()));
        }
        final Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            item = it.next();
            n.e(item, "child");
            item.setFitsSystemWindows(z);
            arrayList = item instanceof ViewGroup;
        }
    }

    private final void G() {
        final int i7 = Integer.MIN_VALUE;
        if (builder2.v0 != Integer.MIN_VALUE) {
            this.bodyWindow.setAnimationStyle(builder2.v0);
        } else {
            int i2 = e.g[builder2.x0.ordinal()];
            if (this.bodyWindow == 1) {
                this.bodyWindow.setAnimationStyle(w.a);
            } else {
                if (builder2.x0 == 2) {
                    View contentView = this.bodyWindow.getContentView();
                    n.e(contentView, "bodyWindow.contentView");
                    e.a(contentView, this.builder.z0);
                    this.bodyWindow.setAnimationStyle(w.c);
                } else {
                    if (this.bodyWindow == 3) {
                        this.bodyWindow.setAnimationStyle(w.b);
                    } else {
                        if (this.bodyWindow == 4) {
                            this.bodyWindow.setAnimationStyle(w.e);
                        } else {
                            int i = 5;
                            if (this.bodyWindow == 5) {
                                this.bodyWindow.setAnimationStyle(w.d);
                            }
                        }
                    }
                }
            }
        }
    }

    private final void H() {
        if (builder2.w0 != -2147483648) {
            this.overlayWindow.setAnimationStyle(builder2.v0);
        } else {
            if (e.h[builder2.y0.ordinal()] != 1) {
                this.overlayWindow.setAnimationStyle(w.d);
            } else {
                this.overlayWindow.setAnimationStyle(w.b);
            }
        }
    }

    private final void I() {
        Context context2;
        boolean z;
        b0();
        g0();
        h0();
        d0();
        c0();
        f0();
        e0();
        FrameLayout frameLayout = this.binding.b();
        n.e(frameLayout, "binding.root");
        N(frameLayout);
        if (builder2.u0 == null) {
            z = context2 instanceof q;
            if (context2 instanceof q) {
                this.builder.r(context2);
                (q)this.context.getLifecycle().a(this);
            } else {
                if (builder2.u0 != null && lifecycle != null) {
                    lifecycle.a(this);
                }
            }
        }
    }

    private final Bitmap L(Drawable drawable, int width, int height) {
        final Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);
        final int i = 0;
        drawable.setBounds(i, i, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        n.e(bitmap, "bitmap");
        return bitmap;
    }

    /* renamed from: M, reason: from kotlin metadata */
    private final float y0(View anchor) throws NoWhenBranchMatchedException {
        int cmp;
        int i;
        float anchor2;
        int i2;
        n.e(this.binding.e, "binding.balloonContent");
        float f12 = (float)builder22.s / 2f;
        i2 = e.d[builder22.u.ordinal()];
        int i3 = 1;
        if (builder22.u != 1) {
            i3 = 2;
            if (builder22.u != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                i2 = anchor.getWidth() + i;
                if (anchor.getWidth() + i >= cmp) {
                    i2 = X() + cmp;
                    float r2 = this.X() + cmp < i ? (float)X() - Y() - (float)builder22.l - (float)builder22.m : anchor2;
                }
                return (this.X() + cmp < i ? (float)X() - Y() - (float)builder22.l - (float)builder22.m : anchor2);
            }
        }
        n.e(this.binding.g, "binding.balloonWrapper");
        anchor2 = (float)this.binding.g.getWidth() * this.builder.t;
        r2 = anchor2 - f12;
    }

    /* renamed from: N, reason: from kotlin metadata */
    private final float K(View delay) throws NoWhenBranchMatchedException {
        float delay2;
        int cmp;
        int i;
        int i2;
        int i3 = e.b(delay, this.builder.J0);
        n.e(this.binding.e, "binding.balloonContent");
        cmp = e.c(this.binding.e).y - i3;
        i = e.c(delay).y - i3;
        final int i15 = 2;
        int i14 = builder23.s / i15;
        i2 = e.e[builder23.u.ordinal()];
        if (this.builder != 1) {
            if (this.builder != i15) {
                throw new NoWhenBranchMatchedException();
            } else {
                i2 = delay.getHeight() + i;
                if (delay.getHeight() + i >= this.binding.e) {
                    i2 = V() + cmp;
                    float r0 = this.V() + cmp < "binding.balloonContent" ? (float)V() - Y() - (float)builder23.n - (float)builder23.o : delay2;
                }
                return (this.V() + cmp < "binding.balloonContent" ? (float)V() - Y() - (float)builder23.n - (float)builder23.o : delay2);
            }
        }
        n.e(this.binding.g, "binding.balloonWrapper");
        delay2 = (float)this.binding.g.getHeight() * this.builder.t;
        r0 = delay2 - (float)i14;
    }

    private final Animation P() throws NoWhenBranchMatchedException, android.content.res.Resources.NotFoundException {
        int i;
        int i2 = Integer.MIN_VALUE;
        if (builder2.B0 == Integer.MIN_VALUE) {
            int i6 = 1;
            if (e.j[builder2.A0.ordinal()] != i6) {
                return null;
            }
            if (builder2.p) {
                int i4 = e.i[builder2.w.ordinal()];
                if (builder2.A0 != i6) {
                    if (builder2.A0 != 2) {
                        if (builder2.A0 != 3) {
                            if (builder2.A0 != 4) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                i = t.c;
                            }
                        }
                        i = t.d;
                    } else {
                        i = t.e;
                    }
                } else {
                    i = t.a;
                }
            } else {
                i = t.b;
            }
        }
        return AnimationUtils.loadAnimation(this.context, i);
    }

    /* renamed from: R, reason: from kotlin metadata */
    private final o<Integer, Integer> m0(float textView, float rootView) throws NoWhenBranchMatchedException {
        int pixel;
        int pixel2;
        String str = "binding.balloonCard";
        n.e(this.binding.d, str);
        Drawable background = this.binding.d.getBackground();
        n.e(background, "binding.balloonCard.background");
        n.e(this.binding.d, str);
        int i = 1;
        n.e(this.binding.d, str);
        Bitmap bitmap = L(background, this.binding.d.getWidth() + i, this.binding.d.getHeight() + i);
        int i5 = e.c[this.builder.w.ordinal()];
        float f8 = 2f;
        if ("binding.balloonCard" == i || "binding.balloonCard" == 2) {
            i3 = (int)rootView;
            pixel = bitmap.getPixel((int)(float)this.builder.s / f8 + textView, i3);
            f = (float)this.builder.s / f8;
            pixel2 = bitmap.getPixel((int)(textView - f), i3);
        } else {
            int i2 = 3;
            if ("binding.balloonCard" != 3) {
                i2 = 4;
                if ("binding.balloonCard" != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            int i14 = (int)textView;
            pixel = bitmap.getPixel(i14, (int)(float)this.builder.s / f8 + rootView);
            f = (float)this.builder.s / f8;
            i3 = (int)(rootView - f);
            pixel2 = bitmap.getPixel(i14, i3);
        }
        return new Pair(Integer.valueOf(pixel), Integer.valueOf(pixel2));
    }

    private final int T() {
        return this.builder.s * 2;
    }

    private final int W(int measuredWidth, View rootView) {
        int i;
        int i2;
        int i3;
        int i5;
        int cmp;
        float f;
        float f2 = 1065353216;
        int i7;
        int i8;
        int measuredWidth2;
        if (builder22.R != null) {
        } else {
            i2 = i4 + builder22.m;
            i5 = builder22.s * 2;
        }
        int i10 = (rootView.getPaddingLeft() + rootView.getPaddingRight()) + (i2 + i5);
        i3 = i - i10;
        final float f9 = 0.0f;
        if (builder22.d != 0.0f) {
            i8 = (int)(float)i * f;
            i7 = i8 - i10;
        }
        return i7;
    }

    private final float Y() {
        return (float)builder2.s * builder2.D + (float)builder2.C;
    }

    private final boolean Z() {
        boolean z = false;
        if (builder2.b0 != null || builder2.a0 != null) {
            int i2 = 1;
        }
        return z;
    }

    /* renamed from: a0, reason: from kotlin metadata */
    private final void n0(View onBalloonClickListener) {
        this.binding.c.setLayoutParams(new FrameLayout.LayoutParams(i3, i3));
        this.binding.c.setAlpha(this.builder.Y);
        if (this.builder.x != null) {
            this.binding.c.setImageDrawable(this.builder.x);
        }
        this.binding.c.setPadding(builder23.y, builder23.A, builder23.z, builder23.B);
        if (builder24.q != -2147483648) {
            g.c(this.binding.c, ColorStateList.valueOf(builder24.q));
        } else {
            g.c(this.binding.c, ColorStateList.valueOf(builder24.F));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.binding.c.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        this.binding.d.post(new Balloon.g(appCompatImageView, this, onBalloonClickListener));
    }

    private final void b0() {
        Drawable drawable;
        this.binding.d.setAlpha(this.builder.Y);
        this.binding.d.setRadius(this.builder.H);
        u.s0(this.binding.d, this.builder.Z);
        if (this.builder.G == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.builder.F);
            gradientDrawable.setCornerRadius(this.builder.H);
            wVar = w.a;
        }
        this.binding.d.setBackground(drawable);
        this.binding.d.setPadding(builder25.h, builder25.i, builder25.j, builder25.k);
    }

    private final void c0() {
        int i2 = 1;
        int i4 = builder2.s - i2;
        int i5 = (int)builder2.Z;
        int i = e.f[builder2.w.ordinal()];
        if (builder2.w == i2) {
            this.binding.e.setPadding(i4, i5, i4, i5);
        } else {
            i2 = 2;
            if (builder2.w == 2) {
                this.binding.e.setPadding(i4, i5, i4, i5);
            } else {
                i2 = 3;
                if (builder2.w == 3) {
                    this.binding.e.setPadding(i5, i4, i5, g.b(i4, i5));
                } else {
                    i2 = 4;
                    if (builder2.w == 4) {
                        this.binding.e.setPadding(i5, i4, i5, g.b(i4, i5));
                    }
                }
            }
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

    public static final /* synthetic */ Bitmap e(Balloon balloon, AppCompatImageView appCompatImageView, float f, float f2) {
        return balloon.D(appCompatImageView, f, f2);
    }

    private final void e0() {
        n0(this.builder.h0);
        o0(this.builder.i0);
        s0(this.builder.k0);
        v0(this.builder.l0);
        t0(this.builder.n0);
        u0(this.builder.m0);
    }

    public static final /* synthetic */ void f(Balloon balloon, View view) {
        balloon.M(view);
    }

    private final void f0() {
        if (builder2.c0) {
            this.overlayBinding.b.setOverlayColor(builder2.d0);
            this.overlayBinding.b.setOverlayPadding(this.builder.e0);
            this.overlayBinding.b.setOverlayPosition(this.builder.f0);
            this.overlayBinding.b.setBalloonOverlayShape(this.builder.g0);
            boolean z = false;
            this.overlayWindow.setClippingEnabled(z);
        }
    }

    /* renamed from: g, reason: from kotlin metadata */
    public static final /* synthetic */ void q0(Balloon onBalloonInitializedListener) {
        onBalloonInitializedListener.G();
    }

    private final void g0() {
        android.view.ViewGroup.LayoutParams layoutParams = this.binding.g.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        layoutParams.setMargins(builder2.m, builder2.n, builder2.l, builder2.o);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ void r0(Balloon block) {
        block.H();
    }

    private final void h0() {
        this.bodyWindow.setOutsideTouchable(true);
        this.bodyWindow.setFocusable(this.builder.I0);
        this.bodyWindow.setBackgroundDrawable(new ColorDrawable(0));
        if (Build.VERSION.SDK_INT >= 21) {
            this.bodyWindow.setElevation(this.builder.Z);
        }
    }

    public static final /* synthetic */ float i(Balloon balloon, View view) {
        return balloon.y0(view);
    }

    private final void i0() {
        View inflate;
        LayoutInflater from;
        RadiusLayout radiusLayout;
        boolean z = false;
        if (this.builder.b0 != null) {
            z = false;
            if (LayoutInflater.from(this.context).inflate(this.builder.b0.intValue(), this.binding.d, z) == null) {
            }
        }
        if (this.builder.a0 == null) {
            throw new IllegalArgumentException("The custom layout is null.");
        } else {
            this.binding.d.removeAllViews();
            this.binding.d.addView(inflate);
            n.e(this.binding.d, "binding.balloonCard");
            E(this.binding.d);
            return;
        }
    }

    public static final /* synthetic */ float j(Balloon balloon, View view) {
        return balloon.K(view);
    }

    private final void j0() {
        if (this.builder.X != null) {
            d.b(this.binding.f, this.builder.X);
        } else {
            Context context = this.binding.f.getContext();
            n.e(context, "context");
            com.skydoves.balloon.m.a aVar = new m.a(context);
            aVar.b(this.builder.R);
            aVar.g(this.builder.T);
            aVar.e(this.builder.U);
            aVar.d(this.builder.W);
            aVar.f(this.builder.V);
            aVar.c(this.builder.S);
            d.b(this.binding.f, aVar.a());
        }
        this.binding.f.j(this.builder.G0);
    }

    /* renamed from: k, reason: from kotlin metadata */
    public static final /* synthetic */ d o0(Balloon onBalloonDismissListener) {
        return onBalloonDismissListener.O();
    }

    private final void k0() {
        if (this.builder.Q != null) {
            d.c(this.binding.f, this.builder.Q);
        } else {
            Context context = this.binding.f.getContext();
            n.e(context, "context");
            com.skydoves.balloon.y.a aVar = new y.a(context);
            aVar.b(this.builder.I);
            aVar.f(this.builder.M);
            aVar.c(this.builder.J);
            aVar.e(this.builder.K);
            aVar.d(this.builder.P);
            aVar.g(this.builder.N);
            aVar.h(this.builder.O);
            this.binding.f.setMovementMethod(this.builder.L);
            d.c(this.binding.f, aVar.a());
        }
        n.e(this.binding.f, "this");
        n.e(this.binding.d, "binding.balloonCard");
        m0(this.binding.f, this.binding.d);
    }

    /* renamed from: l, reason: from kotlin metadata */
    public static final /* synthetic */ Animation p0(Balloon block) {
        return block.P();
    }

    /* renamed from: m, reason: from kotlin metadata */
    public static final /* synthetic */ k s0(Balloon onBalloonOutsideTouchListener) {
        return onBalloonOutsideTouchListener.Q();
    }

    private final void m0(AppCompatTextView appCompatTextView, View view) {
        int i;
        int i2;
        int compoundPaddingStart;
        int compoundPaddingEnd;
        i = (int)appCompatTextView.getPaint().measureText(appCompatTextView.getText().toString());
        Drawable[] compoundDrawablesRelative = appCompatTextView.getCompoundDrawablesRelative();
        String str2 = "compoundDrawablesRelative";
        n.e(compoundDrawablesRelative, str2);
        if (b.e(compoundDrawablesRelative)) {
            Drawable[] compoundDrawablesRelative2 = appCompatTextView.getCompoundDrawablesRelative();
            n.e(compoundDrawablesRelative2, str2);
            appCompatTextView.setMinHeight(b.b(compoundDrawablesRelative2));
            Drawable[] compoundDrawablesRelative3 = appCompatTextView.getCompoundDrawablesRelative();
            n.e(compoundDrawablesRelative3, str2);
            i2 = b.c(compoundDrawablesRelative3);
            compoundPaddingStart = appCompatTextView.getCompoundPaddingStart();
            compoundPaddingEnd = appCompatTextView.getCompoundPaddingEnd();
            i = (int)appCompatTextView.getPaint().measureText(appCompatTextView.getText().toString()) + (i2 + (compoundPaddingStart + compoundPaddingEnd));
        }
        appCompatTextView.setMaxWidth(W(i, view));
    }

    /* renamed from: n, reason: from kotlin metadata */
    public static final /* synthetic */ com.skydoves.balloon.z.a v0(Balloon onTouchListener) {
        return onTouchListener.binding;
    }

    /* renamed from: o, reason: from kotlin metadata */
    public static final /* synthetic */ PopupWindow u0(Balloon onTouchListener) {
        return onTouchListener.bodyWindow;
    }

    /* renamed from: p, reason: from kotlin metadata */
    public static final /* synthetic */ Balloon.a t0(Balloon onBalloonOverlayClickListener) {
        return onBalloonOverlayClickListener.builder;
    }

    public static final /* synthetic */ Context q(Balloon balloon) {
        return balloon.context;
    }

    public static final /* synthetic */ boolean r(Balloon balloon) {
        return balloon.destroyed;
    }

    public static final /* synthetic */ Handler s(Balloon balloon) {
        return balloon.U();
    }

    public static final /* synthetic */ PopupWindow t(Balloon balloon) {
        return balloon.overlayWindow;
    }

    public static final /* synthetic */ boolean u(Balloon balloon) {
        return balloon.Z();
    }

    public static final /* synthetic */ void v(Balloon balloon, View view) {
        balloon.n0(view);
    }

    public static final /* synthetic */ void w(Balloon balloon) {
        balloon.c0();
    }

    /* renamed from: x, reason: from kotlin metadata */
    public static final /* synthetic */ void x0(Balloon anchor, AppCompatTextView xOff, View yOff) {
        anchor.m0(xOff, yOff);
    }

    public static final /* synthetic */ void y(Balloon balloon, boolean z) {
        balloon.isShowing = z;
    }

    private final void y0(View view) {
        if (this.builder.c0) {
            this.overlayBinding.b.setAnchorView(view);
            int i = 17;
            int i2 = 0;
            this.overlayWindow.showAtLocation(view, i, i2, i2);
        }
    }

    public static final /* synthetic */ void z(Balloon balloon, View view) {
        balloon.y0(view);
    }

    private final void z0() {
        this.binding.b.post(new Balloon.n(this));
    }

    public final void J() {
        if (this.isShowing) {
            com.skydoves.balloon.Balloon.e eVar = new Balloon.e(this);
            if (this.builder.x0 != f.CIRCULAR) {
                eVar.invoke();
            } else {
                View contentView = this.bodyWindow.getContentView();
                n.e(contentView, "this.bodyWindow.contentView");
                int i = 21;
                if (Build.VERSION.SDK_INT >= 21) {
                    contentView.post(new Balloon.d(contentView, this.builder.z0, r3, eVar));
                }
            }
        }
    }

    public final boolean K(long j) {
        return U().postDelayed(O(), j);
    }

    public final ViewGroup S() {
        n.e(this.binding.d, "binding.balloonCard");
        return this.binding.d;
    }

    public final int V() {
        if (this.builder.g != -2147483648) {
            return this.builder.g;
        }
        FrameLayout frameLayout = this.binding.b();
        n.e(frameLayout, "this.binding.root");
        return frameLayout.getMeasuredHeight();
    }

    public final int X() {
        int i;
        int i2 = 1065353216;
        float f = 0.0f;
        if (builder2.d != 0.0f) {
            i = (int)(float)i3 * f7;
        } else {
            str = "binding.root";
            if (builder2.e == 0.0f) {
                if (builder2.f != 0.0f) {
                    if (builder2.f == 0.0f) {
                        i2 = 1065353216;
                    }
                    FrameLayout frameLayout2 = this.binding.b();
                    n.e(frameLayout2, "binding.root");
                    float f2 = (float)i3;
                    i = g.g(frameLayout2.getMeasuredWidth(), (int)(this.builder.e * f2), (int)(f2 * i2));
                } else {
                    int measuredWidth = Integer.MIN_VALUE;
                    if (builder2.a != Integer.MIN_VALUE) {
                        i = g.e(builder2.a, i3);
                    } else {
                        FrameLayout frameLayout = this.binding.b();
                        n.e(frameLayout, "binding.root");
                        i = g.g(frameLayout.getMeasuredWidth(), builder22.b, builder22.c);
                    }
                }
            }
        }
        return i;
    }

    public final boolean l0() {
        return this.isShowing;
    }

    public final void n0(o oVar) {
        this.binding.g.setOnClickListener(new Balloon.h(this, oVar));
    }

    public final void o0(p pVar) {
        this.bodyWindow.setOnDismissListener(new Balloon.i(this, pVar));
    }

    @z(j$b.ON_DESTROY)
    public final void onDestroy() {
        this.destroyed = true;
        this.overlayWindow.dismiss();
        this.bodyWindow.dismiss();
    }

    @z(j$b.ON_PAUSE)
    public final void onPause() {
        if (this.builder.s0) {
            J();
        }
    }

    public final /* synthetic */ void p0(kotlin.d0.c.a<w> aVar) {
        n.f(aVar, "block");
        o0(new i(aVar));
    }

    public final void q0(q qVar) {
        this.onBalloonInitializedListener = qVar;
    }

    public final /* synthetic */ void r0(l<? super View, w> lVar) {
        n.f(lVar, "block");
        q0(new j(lVar));
    }

    public final void s0(r rVar) {
        this.bodyWindow.setTouchInterceptor(new Balloon.j(this, rVar));
    }

    public final void t0(s sVar) {
        this.overlayBinding.b().setOnClickListener(new Balloon.k(this, sVar));
    }

    public final void u0(View.OnTouchListener list) {
        if (list != null) {
            this.overlayWindow.setTouchInterceptor(list);
        }
    }

    public final void v0(View.OnTouchListener list) {
        if (list != null) {
            this.bodyWindow.setTouchInterceptor(list);
        }
    }

    public final void w0(View anchor, int xOff, int yOff) {
        boolean z;
        String str;
        n.f(anchor, "anchor");
        if (!l0() && !Balloon.r(this)) {
            if (!a.d(this.context)) {
                View contentView = this.bodyWindow.getContentView();
                str = "bodyWindow.contentView";
                n.e(contentView, str);
                if (contentView.getParent() != null || !u.Q(anchor)) {
                    if (this.builder.p0) {
                        J();
                    }
                } else {
                    Balloon.l lVar = new Balloon.l(this, anchor, this, anchor, xOff, yOff);
                    anchor.post(lVar);
                }
            }
        }
    }

    public final void x0(View view, int i, int i2) {
        boolean z;
        String str;
        n.f(view, "anchor");
        if (!l0() && !Balloon.r(this)) {
            if (!a.d(this.context)) {
                View contentView = this.bodyWindow.getContentView();
                str = "bodyWindow.contentView";
                n.e(contentView, str);
                if (contentView.getParent() != null || !u.Q(view)) {
                    if (this.builder.p0) {
                        J();
                    }
                } else {
                    Balloon.m mVar = new Balloon.m(this, view, this, view, i, i2);
                    view.post(mVar);
                }
            }
        }
    }

    private final d O() {
        return (d)this.autoDismissRunnable.getValue();
    }

    private final k Q() {
        return (k)this.balloonPersistence.getValue();
    }

    private final Handler U() {
        return (Handler)this.handler.getValue();
    }
}
