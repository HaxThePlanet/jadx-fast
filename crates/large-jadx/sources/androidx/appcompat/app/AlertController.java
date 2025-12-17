package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView.b;
import d.a.a;
import d.a.f;
import d.a.j;
import d.h.l.u;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class AlertController {

    NestedScrollView A;
    private int B = 0;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    int I = -1;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    private int Q = 0;
    Handler R;
    private final View.OnClickListener S;
    private final Context a;
    final androidx.appcompat.app.h b;
    private final Window c;
    private final int d;
    private java.lang.CharSequence e;
    private java.lang.CharSequence f;
    ListView g;
    private View h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private boolean n = false;
    Button o;
    private java.lang.CharSequence p;
    Message q;
    private Drawable r;
    Button s;
    private java.lang.CharSequence t;
    Message u;
    private Drawable v;
    Button w;
    private java.lang.CharSequence x;
    Message y;
    private Drawable z;

    public static class RecycleListView extends ListView {

        private final int a;
        private final int b;
        public RecycleListView(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
            TypedArray obj2 = context.obtainStyledAttributes(attributeSet2, j.T1);
            int i = -1;
            this.b = obj2.getDimensionPixelOffset(j.U1, i);
            this.a = obj2.getDimensionPixelOffset(j.V1, i);
        }

        @Override // android.widget.ListView
        public void a(boolean z, boolean z2) {
            int paddingLeft;
            int paddingRight;
            int obj3;
            int obj4;
            if (z2 != 0) {
                if (z == 0) {
                    if (z != 0) {
                        obj3 = getPaddingTop();
                    } else {
                        obj3 = this.a;
                    }
                    if (z2 != 0) {
                        obj4 = getPaddingBottom();
                    } else {
                        obj4 = this.b;
                    }
                    setPadding(getPaddingLeft(), obj3, getPaddingRight(), obj4);
                }
            } else {
            }
        }
    }

    class a implements View.OnClickListener {

        final androidx.appcompat.app.AlertController a;
        a(androidx.appcompat.app.AlertController alertController) {
            this.a = alertController;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            Object button;
            Object obj3;
            androidx.appcompat.app.AlertController alertController = this.a;
            button = alertController.q;
            if (view == alertController.o && button != null) {
                button = alertController.q;
                if (button != null) {
                    obj3 = Message.obtain(button);
                } else {
                    button = alertController.u;
                    if (view == alertController.s && button != null) {
                        button = alertController.u;
                        if (button != null) {
                            obj3 = Message.obtain(button);
                        } else {
                            obj3 = alertController.y;
                            if (view == alertController.w && obj3 != null) {
                                obj3 = alertController.y;
                                if (obj3 != null) {
                                    obj3 = Message.obtain(obj3);
                                } else {
                                    obj3 = 0;
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
            if (obj3 != null) {
                obj3.sendToTarget();
            }
            obj3 = this.a;
            obj3.R.obtainMessage(1, obj3.b).sendToTarget();
        }
    }

    class c implements Runnable {

        final View a;
        final View b;
        final androidx.appcompat.app.AlertController c;
        c(androidx.appcompat.app.AlertController alertController, View view2, View view3) {
            this.c = alertController;
            this.a = view2;
            this.b = view3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.f(alertController.A, this.a, this.b);
        }
    }

    class d implements AbsListView.OnScrollListener {

        final View a;
        final View b;
        d(androidx.appcompat.app.AlertController alertController, View view2, View view3) {
            this.a = view2;
            this.b = view3;
            super();
        }

        @Override // android.widget.AbsListView$OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            AlertController.f(absListView, this.a, this.b);
        }

        @Override // android.widget.AbsListView$OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
        }
    }

    class e implements Runnable {

        final View a;
        final View b;
        final androidx.appcompat.app.AlertController c;
        e(androidx.appcompat.app.AlertController alertController, View view2, View view3) {
            this.c = alertController;
            this.a = view2;
            this.b = view3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.f(alertController.g, this.a, this.b);
        }
    }

    public static class f {

        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E = false;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public int I = -1;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public androidx.appcompat.app.AlertController.f.e O;
        public final Context a;
        public final LayoutInflater b;
        public int c = 0;
        public Drawable d;
        public int e = 0;
        public java.lang.CharSequence f;
        public View g;
        public java.lang.CharSequence h;
        public java.lang.CharSequence i;
        public Drawable j;
        public DialogInterface.OnClickListener k;
        public java.lang.CharSequence l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public java.lang.CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public boolean r = true;
        public DialogInterface.OnCancelListener s;
        public DialogInterface.OnDismissListener t;
        public DialogInterface.OnKeyListener u;
        public java.lang.CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;
        public f(Context context) {
            super();
            int i = 0;
            int i2 = -1;
            this.a = context;
            int i3 = 1;
            this.b = (LayoutInflater)context.getSystemService("layout_inflater");
        }

        private void b(androidx.appcompat.app.AlertController alertController) {
            Object iArr;
            Object cVar;
            boolean z;
            int i;
            Object obj2;
            Context context;
            Cursor cursor;
            int i2;
            Object strArr;
            Object obj;
            Object simpleCursorAdapter;
            View inflate = this.b.inflate(alertController.L, 0);
            final int i7 = 1;
            if (this.G) {
                if (this.K == null) {
                    super(this, this.a, alertController.M, 16908308, this.v, (AlertController.RecycleListView)inflate);
                } else {
                    super(this, this.a, this.K, 0, inflate, alertController);
                }
            } else {
                i = this.H ? alertController.N : alertController.O;
                cursor = i;
                obj2 = 16908308;
                if (this.K != null) {
                    strArr = new String[i7];
                    int i6 = 0;
                    strArr[i6] = this.L;
                    iArr = new int[i7];
                    iArr[i6] = obj2;
                    super(this.a, cursor, this.K, strArr, iArr);
                } else {
                    if (this.w != null) {
                    } else {
                        simpleCursorAdapter = new AlertController.h(this.a, cursor, obj2, this.v);
                    }
                }
            }
            androidx.appcompat.app.AlertController.f.e eVar = this.O;
            if (eVar != null) {
                eVar.a(inflate);
            }
            alertController.H = simpleCursorAdapter;
            alertController.I = this.I;
            if (this.x != null) {
                cVar = new AlertController.f.c(this, alertController);
                inflate.setOnItemClickListener(cVar);
            } else {
                if (this.J != null) {
                    cVar = new AlertController.f.d(this, inflate, alertController);
                    inflate.setOnItemClickListener(cVar);
                }
            }
            AdapterView.OnItemSelectedListener list2 = this.N;
            if (list2 != null) {
                inflate.setOnItemSelectedListener(list2);
            }
            if (this.H) {
                inflate.setChoiceMode(i7);
            } else {
                if (this.G) {
                    inflate.setChoiceMode(2);
                }
            }
            alertController.g = inflate;
        }

        public void a(androidx.appcompat.app.AlertController alertController) {
            int view;
            Object charSequence2;
            Object objArr;
            boolean z;
            int i;
            int i4;
            Object charSequence;
            DialogInterface.OnClickListener list2;
            int i2;
            Drawable drawable2;
            androidx.appcompat.app.AlertController alertController2;
            int i3;
            DialogInterface.OnClickListener list;
            int i5;
            Drawable drawable;
            view = this.g;
            if (view != null) {
                alertController.l(view);
            } else {
                java.lang.CharSequence charSequence3 = this.f;
                if (charSequence3 != null) {
                    alertController.q(charSequence3);
                }
                Drawable drawable3 = this.d;
                if (drawable3 != null) {
                    alertController.n(drawable3);
                }
                int i6 = this.c;
                if (i6 != 0) {
                    alertController.m(i6);
                }
                view = this.e;
                if (view != null) {
                    alertController.m(alertController.c(view));
                }
            }
            charSequence2 = this.h;
            if (charSequence2 != null) {
                alertController.o(charSequence2);
            }
            charSequence = this.i;
            if (charSequence == null) {
                if (this.j != null) {
                    alertController.k(-1, charSequence, this.k, 0, this.j);
                }
            } else {
            }
            final java.lang.CharSequence charSequence5 = this.l;
            if (charSequence5 == null) {
                if (this.m != null) {
                    alertController.k(-2, charSequence5, this.n, 0, this.m);
                }
            } else {
            }
            java.lang.CharSequence charSequence4 = this.o;
            if (charSequence4 == null) {
                if (this.p != null) {
                    alertController.k(-3, charSequence4, this.q, 0, this.p);
                }
            } else {
            }
            if (this.v == null && this.K == null) {
                if (this.K == null) {
                    if (this.w != null) {
                        b(alertController);
                    }
                } else {
                }
            } else {
            }
            View view2 = this.z;
            if (view2 != null) {
                if (this.E) {
                    alertController.t(view2, this.A, this.B, this.C, this.D);
                } else {
                    alertController.s(view2);
                }
            } else {
                z = this.y;
                if (z != 0) {
                    alertController.r(z);
                }
            }
        }
    }

    private static final class g extends Handler {

        private WeakReference<DialogInterface> a;
        public g(DialogInterface dialogInterface) {
            super();
            WeakReference weakReference = new WeakReference(dialogInterface);
            this.a = weakReference;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object what;
            Object obj;
            int i;
            int obj3;
            what = message.what;
            if (what != -3 && what != -2 && what != -1) {
                if (what != -2) {
                    if (what != -1) {
                        if (what != 1) {
                        } else {
                            (DialogInterface)message.obj.dismiss();
                        }
                    } else {
                        (DialogInterface.OnClickListener)message.obj.onClick((DialogInterface)this.a.get(), message.what);
                    }
                } else {
                }
            } else {
            }
        }
    }

    private static class h extends ArrayAdapter<java.lang.CharSequence> {
        public h(Context context, int i2, int i3, java.lang.CharSequence[] charSequence4Arr4) {
            super(context, i2, i3, charSequence4Arr4);
        }

        @Override // android.widget.ArrayAdapter
        public long getItemId(int i) {
            return (long)i;
        }

        @Override // android.widget.ArrayAdapter
        public boolean hasStableIds() {
            return 1;
        }
    }

    class b implements NestedScrollView.b {

        final View a;
        final View b;
        b(androidx.appcompat.app.AlertController alertController, View view2, View view3) {
            this.a = view2;
            this.b = view3;
            super();
        }

        @Override // androidx.core.widget.NestedScrollView$b
        public void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            AlertController.f(nestedScrollView, this.a, this.b);
        }
    }
    public AlertController(Context context, androidx.appcompat.app.h h2, Window window3) {
        super();
        final int i = 0;
        int i2 = -1;
        AlertController.a aVar = new AlertController.a(this);
        this.S = aVar;
        this.a = context;
        this.b = h2;
        this.c = window3;
        AlertController.g obj6 = new AlertController.g(h2);
        this.R = obj6;
        final TypedArray obj4 = context.obtainStyledAttributes(0, j.D, a.n, i);
        this.J = obj4.getResourceId(j.E, i);
        this.K = obj4.getResourceId(j.G, i);
        this.L = obj4.getResourceId(j.I, i);
        this.M = obj4.getResourceId(j.J, i);
        this.N = obj4.getResourceId(j.L, i);
        this.O = obj4.getResourceId(j.H, i);
        int i4 = 1;
        this.P = obj4.getBoolean(j.K, i4);
        this.d = obj4.getDimensionPixelSize(j.F, i);
        obj4.recycle();
        h2.supportRequestWindowFeature(i4);
    }

    static boolean a(View view) {
        int childCount;
        boolean z;
        final int i = 1;
        if (view.onCheckIsTextEditor()) {
            return i;
        }
        final int i2 = 0;
        if (!view instanceof ViewGroup) {
            return i2;
        }
        childCount = (ViewGroup)view.getChildCount();
        while (childCount > 0) {
        }
        return i2;
    }

    private void b(Button button) {
        final ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 1056964608;
        button.setLayoutParams((LinearLayout.LayoutParams)layoutParams);
    }

    static void f(View view, View view2, View view3) {
        int i2;
        int i;
        boolean obj3;
        int obj4;
        final int i3 = 4;
        if (view2 != null) {
            i = view.canScrollVertically(-1) ? i2 : i3;
            view2.setVisibility(i);
        }
        if (view3 != null) {
            if (view.canScrollVertically(1)) {
            } else {
                i2 = i3;
            }
            view3.setVisibility(i2);
        }
    }

    private ViewGroup i(View view, View view2) {
        android.view.ViewParent parent;
        boolean z;
        Object obj3;
        Object obj4;
        if (view == null && view2 instanceof ViewStub) {
            if (view2 instanceof ViewStub) {
                obj4 = (ViewStub)view2.inflate();
            }
            return (ViewGroup)obj4;
        }
        parent = view2.getParent();
        if (view2 != null && parent instanceof ViewGroup) {
            parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                (ViewGroup)parent.removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            obj3 = (ViewStub)view.inflate();
        }
        return (ViewGroup)obj3;
    }

    private int j() {
        int i = this.K;
        if (i == 0) {
            return this.J;
        }
        if (this.Q == 1) {
            return i;
        }
        return this.J;
    }

    private void p(ViewGroup viewGroup, View view2, int i3, int i4) {
        View viewById2;
        View viewById;
        Object obj5;
        View obj6;
        int obj7;
        int obj8;
        viewById2 = this.c.findViewById(f.v);
        viewById = this.c.findViewById(f.u);
        if (Build.VERSION.SDK_INT >= 23) {
            u.A0(view2, i3, i4);
            if (viewById2 != null) {
                viewGroup.removeView(viewById2);
            }
            if (viewById != null) {
                viewGroup.removeView(viewById);
            }
        } else {
            obj6 = 0;
            if (viewById2 != null && i3 & 1 == 0) {
                if (i3 & 1 == 0) {
                    viewGroup.removeView(viewById2);
                    viewById2 = obj6;
                }
            }
            if (viewById != null && i3 &= 2 == 0) {
                if (i3 &= 2 == 0) {
                    viewGroup.removeView(viewById);
                    viewById = obj6;
                }
            }
            if (viewById2 == null) {
                if (viewById != null) {
                    if (this.f != null) {
                        obj6 = new AlertController.b(this, viewById2, viewById);
                        this.A.setOnScrollChangeListener(obj6);
                        obj6 = new AlertController.c(this, viewById2, viewById);
                        this.A.post(obj6);
                    } else {
                        obj6 = this.g;
                        if (obj6 != null) {
                            obj5 = new AlertController.d(this, viewById2, viewById);
                            obj6.setOnScrollListener(obj5);
                            obj6 = new AlertController.e(this, viewById2, viewById);
                            this.g.post(obj6);
                        } else {
                            if (viewById2 != null) {
                                viewGroup.removeView(viewById2);
                            }
                            if (viewById != null) {
                                viewGroup.removeView(viewById);
                            }
                        }
                    }
                }
            } else {
            }
        }
    }

    private void u(ViewGroup viewGroup) {
        boolean empty3;
        Object drawable;
        int i;
        int i2;
        Button button2;
        boolean z;
        Object charSequence;
        boolean empty2;
        Object drawable2;
        Button button;
        boolean empty;
        Object list;
        Object list2;
        View viewById = viewGroup.findViewById(16908313);
        this.o = (Button)viewById;
        viewById.setOnClickListener(this.S);
        i2 = 1;
        final int i4 = 8;
        int i5 = 0;
        final int i7 = 0;
        if (TextUtils.isEmpty(this.p) && this.r == null) {
            if (this.r == null) {
                this.o.setVisibility(i4);
                i = i7;
            } else {
                this.o.setText(this.p);
                drawable = this.r;
                if (drawable != null) {
                    int i8 = this.d;
                    drawable.setBounds(i7, i7, i8, i8);
                    this.o.setCompoundDrawables(this.r, i5, i5, i5);
                }
                this.o.setVisibility(i7);
                i = i2;
            }
        } else {
        }
        View viewById2 = viewGroup.findViewById(16908314);
        this.s = (Button)viewById2;
        viewById2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.t) && this.v == null) {
            if (this.v == null) {
                this.s.setVisibility(i4);
            } else {
                this.s.setText(this.t);
                drawable2 = this.v;
                if (drawable2 != null) {
                    int i11 = this.d;
                    drawable2.setBounds(i7, i7, i11, i11);
                    this.s.setCompoundDrawables(this.v, i5, i5, i5);
                }
                this.s.setVisibility(i7);
                i |= 2;
            }
        } else {
        }
        View viewById3 = viewGroup.findViewById(16908315);
        this.w = (Button)viewById3;
        viewById3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.x) && this.z == null) {
            if (this.z == null) {
                this.w.setVisibility(i4);
            } else {
                this.w.setText(this.x);
                empty = this.z;
                if (empty != null) {
                    int i12 = this.d;
                    empty.setBounds(i7, i7, i12, i12);
                    this.w.setCompoundDrawables(this.z, i5, i5, i5);
                }
                this.w.setVisibility(i7);
                i |= 4;
            }
        } else {
        }
        if (AlertController.z(this.a)) {
            if (i == i2) {
                b(this.o);
            } else {
                if (i == 2) {
                    b(this.s);
                } else {
                    if (i == 4) {
                        b(this.w);
                    }
                }
            }
        }
        if (i != 0) {
        } else {
            i2 = i7;
        }
        if (i2 == 0) {
            viewGroup.setVisibility(i4);
        }
    }

    private void v(ViewGroup viewGroup) {
        View indexOfChild;
        java.lang.CharSequence charSequence;
        Object layoutParams;
        int i;
        android.view.ViewParent obj5;
        View viewById = this.c.findViewById(f.w);
        this.A = (NestedScrollView)viewById;
        int i4 = 0;
        viewById.setFocusable(i4);
        this.A.setNestedScrollingEnabled(i4);
        indexOfChild = viewGroup.findViewById(16908299);
        this.F = (TextView)indexOfChild;
        if (indexOfChild == null) {
        }
        charSequence = this.f;
        if (charSequence != null) {
            indexOfChild.setText(charSequence);
        } else {
            charSequence = 8;
            indexOfChild.setVisibility(charSequence);
            this.A.removeView(this.F);
            if (this.g != null) {
                obj5 = this.A.getParent();
                indexOfChild = (ViewGroup)obj5.indexOfChild(this.A);
                obj5.removeViewAt(indexOfChild);
                i = -1;
                layoutParams = new ViewGroup.LayoutParams(i, i);
                obj5.addView(this.g, indexOfChild, layoutParams);
            } else {
                viewGroup.setVisibility(charSequence);
            }
        }
    }

    private void w(ViewGroup viewGroup) {
        View inflate;
        boolean z;
        ListView list;
        int viewById;
        int layoutParams;
        int i;
        int i2;
        Object obj6;
        if (this.h != null) {
        } else {
            if (this.i != 0) {
                inflate = LayoutInflater.from(this.a).inflate(this.i, viewGroup, false);
            } else {
                inflate = 0;
            }
        }
        if (inflate != null) {
            viewById = 1;
        }
        if (viewById != 0) {
            if (!AlertController.a(inflate)) {
                i = 131072;
                this.c.setFlags(i, i);
            }
        } else {
        }
        if (viewById != 0) {
            viewById = this.c.findViewById(f.n);
            i = -1;
            layoutParams = new ViewGroup.LayoutParams(i, i);
            (FrameLayout)viewById.addView(inflate, layoutParams);
            if (this.n) {
                viewById.setPadding(this.j, this.k, this.l, this.m);
            }
            if (this.g != null) {
                obj6.a = 0;
            }
        } else {
            viewGroup.setVisibility(8);
        }
    }

    private void x(ViewGroup viewGroup) {
        ImageView paddingLeft;
        int i;
        int paddingTop;
        int paddingRight;
        int paddingBottom;
        Drawable obj6;
        final int i3 = 8;
        if (this.G != null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            viewGroup.addView(this.G, 0, layoutParams);
            this.c.findViewById(f.O).setVisibility(i3);
        } else {
            this.D = (ImageView)this.c.findViewById(16908294);
            if (empty ^= 1 != 0 && this.P) {
                if (this.P) {
                    obj6 = this.c.findViewById(f.j);
                    this.E = (TextView)obj6;
                    obj6.setText(this.e);
                    obj6 = this.B;
                    if (obj6 != null) {
                        this.D.setImageResource(obj6);
                    } else {
                        obj6 = this.C;
                        if (obj6 != null) {
                            this.D.setImageDrawable(obj6);
                        } else {
                            this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
                            this.D.setVisibility(i3);
                        }
                    }
                } else {
                    this.c.findViewById(f.O).setVisibility(i3);
                    this.D.setVisibility(i3);
                    viewGroup.setVisibility(i3);
                }
            } else {
            }
        }
    }

    private void y() {
        View viewById;
        int i3;
        Object viewById2;
        ListView list;
        ViewGroup view;
        int i4;
        ViewGroup visibility;
        int viewById3;
        int i;
        int i2;
        int visibility2;
        Object obj;
        View viewById4 = this.c.findViewById(f.t);
        int i6 = f.P;
        int i8 = f.m;
        int i11 = f.k;
        viewById = viewById4.findViewById(f.o);
        w((ViewGroup)viewById);
        viewById2 = i(viewById.findViewById(i6), viewById4.findViewById(i6));
        view = i(viewById.findViewById(i8), viewById4.findViewById(i8));
        visibility = i(viewById.findViewById(i11), viewById4.findViewById(i11));
        v(view);
        u(visibility);
        x(viewById2);
        viewById3 = 8;
        int i12 = 1;
        i = 0;
        if (viewById != null && viewById.getVisibility() != viewById3) {
            i3 = viewById.getVisibility() != viewById3 ? i12 : i;
        } else {
        }
        if (viewById2 != null && viewById2.getVisibility() != viewById3) {
            i2 = viewById2.getVisibility() != viewById3 ? i12 : i;
        } else {
        }
        if (visibility != null && visibility.getVisibility() != viewById3) {
            i4 = visibility.getVisibility() != viewById3 ? i12 : i;
        } else {
        }
        viewById3 = view.findViewById(f.K);
        if (i4 == 0 && view != null && viewById3 != null) {
            if (view != null) {
                viewById3 = view.findViewById(f.K);
                if (viewById3 != null) {
                    viewById3.setVisibility(i);
                }
            }
        }
        if (i2 != 0) {
            NestedScrollView view2 = this.A;
            if (view2 != null) {
                view2.setClipToPadding(i12);
            }
            viewById3 = 0;
            if (this.f == null) {
                if (this.g != null) {
                    viewById3 = viewById2.findViewById(f.N);
                }
            } else {
            }
            if (viewById3 != null) {
                viewById3.setVisibility(i);
            }
        } else {
            viewById2 = view.findViewById(f.L);
            if (view != null && viewById2 != null) {
                viewById2 = view.findViewById(f.L);
                if (viewById2 != null) {
                    viewById2.setVisibility(i);
                }
            }
        }
        list = this.g;
        if (list instanceof AlertController.RecycleListView != null) {
            (AlertController.RecycleListView)list.a(i2, i4);
        }
        if (i3 == 0) {
            if (this.g != null) {
            } else {
                i3 = this.A;
            }
            if (i3 != null && i4 != 0) {
                if (i4 != 0) {
                    i = 2;
                }
                p(view, i3, i2 | i, 3);
            }
        }
        ListView list2 = this.g;
        list = this.H;
        list2.setAdapter(list);
        list = this.I;
        if (list2 != null && list != null && list > -1) {
            list = this.H;
            if (list != null) {
                list2.setAdapter(list);
                list = this.I;
                if (list > -1) {
                    list2.setItemChecked(list, i12);
                    list2.setSelection(list);
                }
            }
        }
    }

    private static boolean z(Context context) {
        int i;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.m, typedValue, true);
        if (typedValue.data != null) {
        } else {
            i = 0;
        }
        return i;
    }

    public int c(int i) {
        TypedValue typedValue = new TypedValue();
        this.a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.g;
    }

    public void e() {
        this.b.setContentView(j());
        y();
    }

    public boolean g(int i, KeyEvent keyEvent2) {
        NestedScrollView obj1;
        obj1 = this.A;
        if (obj1 != null && obj1.k(keyEvent2)) {
            obj1 = obj1.k(keyEvent2) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public boolean h(int i, KeyEvent keyEvent2) {
        NestedScrollView obj1;
        obj1 = this.A;
        if (obj1 != null && obj1.k(keyEvent2)) {
            obj1 = obj1.k(keyEvent2) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public void k(int i, java.lang.CharSequence charSequence2, DialogInterface.OnClickListener dialogInterface$OnClickListener3, Message message4, Drawable drawable5) {
        int obj3;
        Message obj4;
        if (message4 == null && onClickListener3 != null) {
            if (onClickListener3 != null) {
                obj4 = this.R.obtainMessage(i, onClickListener3);
            }
        }
        if (i != -3) {
            if (i != -2) {
                if (i != -1) {
                } else {
                    this.p = charSequence2;
                    this.q = obj4;
                    this.r = drawable5;
                }
                IllegalArgumentException obj1 = new IllegalArgumentException("Button does not exist");
                throw obj1;
            }
            this.t = charSequence2;
            this.u = obj4;
            this.v = drawable5;
        } else {
            this.x = charSequence2;
            this.y = obj4;
            this.z = drawable5;
        }
    }

    public void l(View view) {
        this.G = view;
    }

    public void m(int i) {
        ImageView view;
        int obj2;
        this.C = 0;
        this.B = i;
        view = this.D;
        if (view != null) {
            if (i != 0) {
                view.setVisibility(0);
                this.D.setImageResource(this.B);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public void n(Drawable drawable) {
        int i;
        Drawable obj3;
        this.C = drawable;
        i = 0;
        this.B = i;
        final ImageView view = this.D;
        if (view != null) {
            if (drawable != null) {
                view.setVisibility(i);
                this.D.setImageDrawable(drawable);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public void o(java.lang.CharSequence charSequence) {
        this.f = charSequence;
        final TextView view = this.F;
        if (view != null) {
            view.setText(charSequence);
        }
    }

    public void q(java.lang.CharSequence charSequence) {
        this.e = charSequence;
        final TextView view = this.E;
        if (view != null) {
            view.setText(charSequence);
        }
    }

    public void r(int i) {
        this.h = 0;
        this.i = i;
        this.n = false;
    }

    public void s(View view) {
        this.h = view;
        final int obj1 = 0;
        this.i = obj1;
        this.n = obj1;
    }

    public void t(View view, int i2, int i3, int i4, int i5) {
        this.h = view;
        this.i = 0;
        this.n = true;
        this.j = i2;
        this.k = i3;
        this.l = i4;
        this.m = i5;
    }
}
