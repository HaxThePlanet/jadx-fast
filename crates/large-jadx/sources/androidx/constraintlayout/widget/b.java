package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import d.f.a.m.e;
import d.f.a.m.h;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class b extends View {

    protected HashMap<Integer, String> A;
    protected int[] a;
    protected int b;
    protected Context c;
    protected h v;
    protected boolean w = false;
    protected String x;
    protected String y;
    private View[] z = null;
    public b(Context context) {
        super(context);
        this.a = new int[32];
        int i2 = 0;
        HashMap hashMap = new HashMap();
        this.A = hashMap;
        this.c = context;
        m(0);
    }

    public b(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        this.a = new int[32];
        int i2 = 0;
        int i3 = 0;
        HashMap hashMap = new HashMap();
        this.A = hashMap;
        this.c = context;
        m(attributeSet2);
    }

    private void d(String string) {
        String length;
        boolean parent;
        Object str;
        Integer valueOf;
        String obj4;
        if (string != null) {
            if (string.length() == 0) {
            } else {
                if (this.c == null) {
                }
                obj4 = string.trim();
                if (parent2 instanceof ConstraintLayout) {
                    parent = getParent();
                }
                length = k(obj4);
                if (length != 0) {
                    this.A.put(Integer.valueOf(length), obj4);
                    e(length);
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Could not find id of \"");
                    stringBuilder.append(obj4);
                    stringBuilder.append("\"");
                    Log.w("ConstraintHelper", stringBuilder.toString());
                }
            }
        }
    }

    private void e(int i) {
        int copyOf;
        if (i == getId()) {
        }
        int[] iArr2 = this.a;
        if (i2++ > iArr2.length) {
            this.a = Arrays.copyOf(iArr2, length *= 2);
        }
        int i4 = this.b;
        this.a[i4] = i;
        this.b = i4++;
    }

    private void f(String string) {
        int length;
        String str;
        int childCount;
        int i;
        View childAt;
        android.view.ViewGroup.LayoutParams stringBuilder;
        boolean str2;
        String obj8;
        if (string != null) {
            if (string.length() == 0) {
            } else {
                if (this.c == null) {
                }
                length = 0;
                if (parent instanceof ConstraintLayout) {
                    length = getParent();
                }
                str = "ConstraintHelper";
                if (length == 0) {
                    Log.w(str, "Parent not a ConstraintLayout");
                }
                i = 0;
                while (i < length.getChildCount()) {
                    childAt = length.getChildAt(i);
                    stringBuilder = childAt.getLayoutParams();
                    if (stringBuilder instanceof ConstraintLayout.b && string.trim().equals(stringBuilder.Z)) {
                    }
                    i++;
                    if (obj8.equals(stringBuilder.Z)) {
                    }
                    if (childAt.getId() == -1) {
                    } else {
                    }
                    e(childAt.getId());
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("to use ConstraintTag view ");
                    stringBuilder.append(childAt.getClass().getSimpleName());
                    stringBuilder.append(" must have an ID");
                    Log.w(str, stringBuilder.toString());
                }
            }
        }
    }

    private int j(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, String string2) {
        Resources resources;
        int childCount;
        int i;
        View childAt;
        int equals;
        int i2;
        final int i3 = 0;
        if (string2 != null) {
            if (constraintLayout == null) {
            } else {
                resources = this.c.getResources();
                if (resources == null) {
                    return i3;
                }
                i = i3;
                while (i < constraintLayout.getChildCount()) {
                    childAt = constraintLayout.getChildAt(i);
                    i++;
                    int i4 = 0;
                }
            }
        }
        return i3;
    }

    private int k(String string) {
        android.view.ViewParent resources;
        int packageName;
        boolean inEditMode;
        int intValue;
        boolean z;
        packageName = 0;
        if (parent instanceof ConstraintLayout) {
            resources = getParent();
        } else {
            resources = packageName;
        }
        inEditMode = resources.g(0, string);
        if (isInEditMode() && resources != null && inEditMode instanceof Integer) {
            if (resources != null) {
                inEditMode = resources.g(intValue, string);
                if (inEditMode instanceof Integer) {
                    intValue = (Integer)inEditMode.intValue();
                }
            }
        }
        if (intValue == 0 && resources != null) {
            if (resources != null) {
                intValue = j(resources, string);
            }
        }
        if (intValue == 0) {
            intValue = h.class.getField(string).getInt(packageName);
        }
        if (intValue == 0) {
            intValue = this.c.getResources().getIdentifier(string, "id", this.c.getPackageName());
        }
        return intValue;
    }

    @Override // android.view.View
    protected void g() {
        boolean z;
        final android.view.ViewParent parent = getParent();
        if (parent != null && parent instanceof ConstraintLayout) {
            if (parent instanceof ConstraintLayout) {
                h((ConstraintLayout)parent);
            }
        }
    }

    @Override // android.view.View
    public int[] getReferencedIds() {
        return Arrays.copyOf(this.a, this.b);
    }

    @Override // android.view.View
    protected void h(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        int elevation;
        int i;
        View view;
        int sDK_INT;
        final int i2 = 21;
        final int i3 = 0;
        if (Build.VERSION.SDK_INT >= i2) {
            elevation = getElevation();
        } else {
            elevation = i3;
        }
        i = 0;
        while (i < this.b) {
            view = constraintLayout.i(this.a[i]);
            view.setVisibility(getVisibility());
            if (view != null && Float.compare(elevation, i3) > 0 && Build.VERSION.SDK_INT >= i2) {
            }
            i++;
            view.setVisibility(visibility);
            if (Float.compare(elevation, i3) > 0) {
            }
            if (Build.VERSION.SDK_INT >= i2) {
            }
            view.setTranslationZ(translationZ += elevation);
        }
    }

    @Override // android.view.View
    protected void i(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
    }

    @Override // android.view.View
    protected View[] l(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        int length;
        int i;
        int i2;
        View[] objArr;
        length = this.z;
        if (length != null) {
            if (length.length != this.b) {
                this.z = new View[this.b];
            }
        } else {
        }
        i = 0;
        while (i < this.b) {
            this.z[i] = constraintLayout.i(this.a[i]);
            i++;
        }
        return this.z;
    }

    @Override // android.view.View
    protected void m(AttributeSet attributeSet) {
        int indexCount;
        int i2;
        int string;
        int i;
        Object obj5;
        if (attributeSet != null) {
            obj5 = getContext().obtainStyledAttributes(attributeSet, i.T0);
            i2 = 0;
            while (i2 < obj5.getIndexCount()) {
                string = obj5.getIndex(i2);
                if (string == i.f1) {
                } else {
                }
                if (string == i.g1) {
                }
                i2++;
                string = obj5.getString(string);
                this.y = string;
                setReferenceTags(string);
                string = obj5.getString(string);
                this.x = string;
                setIds(string);
            }
            obj5.recycle();
        }
    }

    @Override // android.view.View
    public void n(e e, boolean z2) {
    }

    @Override // android.view.View
    public void o(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.x;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.y;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int obj2;
        if (this.w) {
            super.onMeasure(i, i2);
        } else {
            obj2 = 0;
            setMeasuredDimension(obj2, obj2);
        }
    }

    @Override // android.view.View
    public void p(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
    }

    @Override // android.view.View
    public void q(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
    }

    @Override // android.view.View
    public void r(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        boolean inEditMode;
        int i2;
        int i3;
        View view;
        int i;
        Integer valueOf;
        if (isInEditMode()) {
            setIds(this.x);
        }
        h hVar = this.v;
        if (hVar == null) {
        }
        hVar.a();
        i2 = 0;
        while (i2 < this.b) {
            i3 = this.a[i2];
            i3 = this.A.get(Integer.valueOf(i3));
            i = j(constraintLayout, (String)i3);
            if (constraintLayout.i(i3) == null && i != 0) {
            }
            if (view != null) {
            }
            i2++;
            this.v.b(constraintLayout.j(view));
            i3 = this.A.get(Integer.valueOf(i3));
            i = j(constraintLayout, (String)i3);
            if (i != 0) {
            }
            this.a[i2] = i;
            this.A.put(Integer.valueOf(i), i3);
            view = constraintLayout.i(i);
        }
        this.v.c(constraintLayout.c);
    }

    @Override // android.view.View
    public void s() {
        boolean hVar;
        if (this.v == null) {
        }
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            layoutParams.s0 = (e)this.v;
        }
    }

    @Override // android.view.View
    protected void setIds(String string) {
        int i;
        int indexOf;
        int i2;
        this.x = string;
        if (string == null) {
        }
        this.b = 0;
        indexOf = string.indexOf(44, i);
        while (indexOf == -1) {
            d(string.substring(i, indexOf));
            i = indexOf + 1;
            indexOf = string.indexOf(44, i);
        }
        d(string.substring(i));
    }

    @Override // android.view.View
    protected void setReferenceTags(String string) {
        int i2;
        int indexOf;
        int i;
        this.y = string;
        if (string == null) {
        }
        this.b = 0;
        indexOf = string.indexOf(44, i2);
        while (indexOf == -1) {
            f(string.substring(i2, indexOf));
            i2 = indexOf + 1;
            indexOf = string.indexOf(44, i2);
        }
        f(string.substring(i2));
    }

    @Override // android.view.View
    public void setReferencedIds(int[] iArr) {
        int i;
        int i2;
        this.x = 0;
        this.b = 0;
        for (int i2 : iArr) {
            e(i2);
        }
    }

    @Override // android.view.View
    public void setTag(int i, Object object2) {
        Object obj2;
        super.setTag(i, object2);
        if (object2 == null && this.x == null) {
            if (this.x == null) {
                e(i);
            }
        }
    }
}
