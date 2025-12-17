package androidx.appcompat.app;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.d;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.g;
import androidx.appcompat.widget.k;
import androidx.appcompat.widget.m;
import androidx.appcompat.widget.p;
import androidx.appcompat.widget.q;
import androidx.appcompat.widget.q0;
import androidx.appcompat.widget.r;
import androidx.appcompat.widget.t;
import androidx.appcompat.widget.x;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.Creator;
import d.a.j;
import d.a.o.d;
import d.e.g;
import d.h.l.u;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class j {

    private static final Class<?>[] b;
    private static final int[] c;
    private static final String[] d;
    private static final g<String, Constructor<? extends View>> e;
    private final Object[] a;

    private static class a implements View.OnClickListener {

        private final View a;
        private final String b;
        private Method c;
        private Context v;
        public a(View view, String string2) {
            super();
            this.a = view;
            this.b = string2;
        }

        private void a(Context context) {
            boolean z;
            StringBuilder stringBuilder;
            boolean restricted;
            Resources resources;
            Class[] arr;
            int i;
            Class<View> obj;
            Context obj6;
            while (obj6 != null) {
                if (obj6 instanceof ContextWrapper) {
                } else {
                }
                obj6 = 0;
                obj6 = (ContextWrapper)obj6.getBaseContext();
                arr = new Class[1];
                restricted = obj6.getClass().getMethod(this.b, View.class);
            }
            obj6 = this.a.getId();
            if (obj6 == -1) {
                obj6 = "";
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(" with id '");
                stringBuilder.append(this.a.getContext().getResources().getResourceEntryName(obj6));
                stringBuilder.append("'");
                obj6 = stringBuilder.toString();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Could not find method ");
            stringBuilder2.append(this.b);
            stringBuilder2.append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
            stringBuilder2.append(this.a.getClass());
            stringBuilder2.append(obj6);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder2.toString());
            throw illegalStateException;
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            Object context;
            if (this.c == null) {
                a(this.a.getContext());
            }
            Object[] arr = new Object[1];
            this.c.invoke(this.v, view);
        }
    }
    static {
        Class[] arr = new Class[2];
        int i3 = 0;
        arr[i3] = Context.class;
        final int i4 = 1;
        arr[i4] = AttributeSet.class;
        j.b = arr;
        int[] iArr = new int[i4];
        iArr[i3] = 16843375;
        j.c = iArr;
        j.d = /* result */;
        g gVar = new g();
        j.e = gVar;
    }

    public j() {
        super();
        this.a = new Object[2];
    }

    private void a(View view, AttributeSet attributeSet2) {
        Object context;
        boolean sDK_INT;
        int i;
        Object obj5;
        context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT >= 15 && !u.M(view)) {
                if (!u.M(view)) {
                } else {
                    obj5 = context.obtainStyledAttributes(attributeSet2, j.c);
                    context = obj5.getString(0);
                    if (context != null) {
                        sDK_INT = new j.a(view, context);
                        view.setOnClickListener(sDK_INT);
                    }
                    obj5.recycle();
                }
            } else {
            }
        }
    }

    private View r(Context context, String string2, String string3) {
        Object stringBuilder;
        Class obj3;
        Object obj5;
        final g gVar = j.e;
        if ((Constructor)gVar.get(string2) == null) {
            if (string3 != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                stringBuilder.append(string2);
                obj5 = stringBuilder.toString();
            } else {
                obj5 = string2;
            }
            gVar.put(string2, Class.forName(obj5, false, context.getClassLoader()).asSubclass(View.class).getConstructor(j.b));
        }
        stringBuilder.setAccessible(true);
        return (View)stringBuilder.newInstance(this.a);
    }

    private View s(Context context, String string2, AttributeSet attributeSet3) {
        int indexOf;
        int length;
        String obj7;
        int obj8;
        final int i2 = 0;
        if (string2.equals("view")) {
            obj7 = attributeSet3.getAttributeValue(i2, "class");
        }
        int i = 1;
        final int i3 = 0;
        Object[] objArr = this.a;
        objArr[i3] = context;
        objArr[i] = attributeSet3;
        if (-1 == obj7.indexOf(46)) {
            obj8 = i3;
            String[] strArr = j.d;
            for (Object str2 : obj3) {
                indexOf = r(context, obj7, str2);
                strArr = j.d;
            }
            Object[] obj6 = this.a;
            obj6[i3] = i2;
            obj6[i] = i2;
            return i2;
        }
        obj7 = this.a;
        obj7[i3] = i2;
        obj7[i] = i2;
        return r(context, obj7, i2);
    }

    private static Context t(Context context, AttributeSet attributeSet2, boolean z3, boolean z4) {
        int[] str;
        Object obj2;
        TypedArray obj3;
        int obj4;
        String obj5;
        final int i = 0;
        obj3 = context.obtainStyledAttributes(attributeSet2, j.A3, i, i);
        if (z3) {
            obj4 = obj3.getResourceId(j.B3, i);
        } else {
            obj4 = i;
        }
        if (z4 != null && obj4 == null && obj3.getResourceId(j.C3, i) != 0) {
            if (obj4 == null) {
                if (obj3.getResourceId(j.C3, i) != 0) {
                    Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
                }
            }
        }
        obj3.recycle();
        if (obj4 != null) {
            if (context instanceof d) {
                if ((d)context.c() != obj4) {
                    obj3 = new d(context, obj4);
                    obj2 = obj3;
                }
            } else {
            }
        }
        return obj2;
    }

    private void u(View view, String string2) {
        if (view == null) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(" asked to inflate view for <");
        stringBuilder.append(string2);
        stringBuilder.append(">, but returned null");
        IllegalStateException obj3 = new IllegalStateException(stringBuilder.toString());
        throw obj3;
    }

    protected d b(Context context, AttributeSet attributeSet2) {
        d dVar = new d(context, attributeSet2);
        return dVar;
    }

    protected f c(Context context, AttributeSet attributeSet2) {
        f fVar = new f(context, attributeSet2);
        return fVar;
    }

    protected AppCompatCheckBox d(Context context, AttributeSet attributeSet2) {
        AppCompatCheckBox appCompatCheckBox = new AppCompatCheckBox(context, attributeSet2);
        return appCompatCheckBox;
    }

    protected g e(Context context, AttributeSet attributeSet2) {
        g gVar = new g(context, attributeSet2);
        return gVar;
    }

    protected AppCompatEditText f(Context context, AttributeSet attributeSet2) {
        AppCompatEditText appCompatEditText = new AppCompatEditText(context, attributeSet2);
        return appCompatEditText;
    }

    protected k g(Context context, AttributeSet attributeSet2) {
        k kVar = new k(context, attributeSet2);
        return kVar;
    }

    protected AppCompatImageView h(Context context, AttributeSet attributeSet2) {
        AppCompatImageView appCompatImageView = new AppCompatImageView(context, attributeSet2);
        return appCompatImageView;
    }

    protected m i(Context context, AttributeSet attributeSet2) {
        m mVar = new m(context, attributeSet2);
        return mVar;
    }

    protected p j(Context context, AttributeSet attributeSet2) {
        p pVar = new p(context, attributeSet2);
        return pVar;
    }

    protected q k(Context context, AttributeSet attributeSet2) {
        q qVar = new q(context, attributeSet2);
        return qVar;
    }

    protected r l(Context context, AttributeSet attributeSet2) {
        r rVar = new r(context, attributeSet2);
        return rVar;
    }

    protected t m(Context context, AttributeSet attributeSet2) {
        t tVar = new t(context, attributeSet2);
        return tVar;
    }

    protected AppCompatTextView n(Context context, AttributeSet attributeSet2) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context, attributeSet2);
        return appCompatTextView;
    }

    protected x o(Context context, AttributeSet attributeSet2) {
        x xVar = new x(context, attributeSet2);
        return xVar;
    }

    protected View p(Context context, String string2, AttributeSet attributeSet3) {
        return null;
    }

    final View q(View view, String string2, Context context3, AttributeSet attributeSet4, boolean z5, boolean z6, boolean z7, boolean z8) {
        Context obj1;
        int obj5;
        boolean obj6;
        if (z5 != null && view != null) {
            if (view != null) {
                obj1 = view.getContext();
            } else {
                obj1 = context3;
            }
        } else {
        }
        if (!z6) {
            if (z7) {
                obj1 = j.t(obj1, attributeSet4, z6, z7);
            }
        } else {
        }
        if (z8 != 0) {
            obj1 = q0.b(obj1);
        }
        string2.hashCode();
        obj5 = -1;
        switch (string2) {
            case "RatingBar":
                obj5 = 0;
                break;
            case "CheckedTextView":
                obj5 = 1;
                break;
            case "MultiAutoCompleteTextView":
                obj5 = 2;
                break;
            case "TextView":
                obj5 = 3;
                break;
            case "ImageButton":
                obj5 = 4;
                break;
            case "SeekBar":
                obj5 = 5;
                break;
            case "Spinner":
                obj5 = 6;
                break;
            case "RadioButton":
                obj5 = 7;
                break;
            case "ToggleButton":
                obj5 = 8;
                break;
            case "ImageView":
                obj5 = 9;
                break;
            case "AutoCompleteTextView":
                obj5 = 10;
                break;
            case "CheckBox":
                obj5 = 11;
                break;
            case "EditText":
                obj5 = 12;
                break;
            case "Button":
                obj5 = 13;
                break;
            default:
        }
        switch (obj5) {
            case 0:
                u(k(obj1, attributeSet4), string2);
                break;
            case 1:
                u(e(obj1, attributeSet4), string2);
                break;
            case 2:
                u(i(obj1, attributeSet4), string2);
                break;
            case 3:
                u(n(obj1, attributeSet4), string2);
                break;
            case 4:
                u(g(obj1, attributeSet4), string2);
                break;
            case 5:
                u(l(obj1, attributeSet4), string2);
                break;
            case 6:
                u(m(obj1, attributeSet4), string2);
                break;
            case 7:
                u(j(obj1, attributeSet4), string2);
                break;
            case 8:
                u(o(obj1, attributeSet4), string2);
                break;
            case 9:
                u(h(obj1, attributeSet4), string2);
                break;
            case 10:
                u(b(obj1, attributeSet4), string2);
                break;
            case 11:
                u(d(obj1, attributeSet4), string2);
                break;
            case 12:
                u(f(obj1, attributeSet4), string2);
                break;
            case 13:
                u(c(obj1, attributeSet4), string2);
                break;
            default:
                obj5 = p(obj1, string2, attributeSet4);
        }
        if (obj5 == null && context3 != obj1) {
            if (context3 != obj1) {
                obj5 = s(obj1, string2, attributeSet4);
            }
        }
        if (obj5 != null) {
            a(obj5, attributeSet4);
        }
        return obj5;
    }
}
