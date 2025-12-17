package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import d.m.c;

/* loaded from: classes.dex */
class l implements LayoutInflater.Factory2 {

    final androidx.fragment.app.n a;

    class a implements View.OnAttachStateChangeListener {

        final androidx.fragment.app.u a;
        final androidx.fragment.app.l b;
        a(androidx.fragment.app.l l, androidx.fragment.app.u u2) {
            this.b = l;
            this.a = u2;
            super();
        }

        @Override // android.view.View$OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.a.m();
            c0.n((ViewGroup)obj2.mView.getParent(), lVar.a).j();
        }

        @Override // android.view.View$OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
    l(androidx.fragment.app.n n) {
        super();
        this.a = n;
    }

    @Override // android.view.LayoutInflater$Factory2
    public View onCreateView(View view, String string2, Context context3, AttributeSet attributeSet4) {
        int i2;
        TypedArray styledAttributes;
        int i;
        Object mSavedFragmentState;
        Object obj9;
        String obj10;
        androidx.fragment.app.u obj11;
        boolean obj12;
        if (h.class.getName().equals(string2)) {
            obj9 = new h(context3, attributeSet4, this.a);
            return obj9;
        }
        i2 = 0;
        if (!"fragment".equals(string2)) {
            return i2;
        }
        styledAttributes = context3.obtainStyledAttributes(attributeSet4, c.a);
        if (attributeSet4.getAttributeValue(i2, "class") == null) {
            obj10 = styledAttributes.getString(c.b);
        }
        int i4 = -1;
        int resourceId = styledAttributes.getResourceId(c.c, i4);
        String string = styledAttributes.getString(c.d);
        styledAttributes.recycle();
        if (obj10 != null) {
            if (!j.b(context3.getClassLoader(), obj10)) {
            } else {
                if (view != null) {
                    i = view.getId();
                } else {
                    i = 0;
                }
                if (i == i4 && resourceId == i4) {
                    if (resourceId == i4) {
                        if (string == null) {
                        } else {
                        }
                        obj11 = new StringBuilder();
                        obj11.append(attributeSet4.getPositionDescription());
                        obj11.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
                        obj11.append(obj10);
                        obj9 = new IllegalArgumentException(obj11.toString());
                        throw obj9;
                    }
                }
                if (resourceId != i4) {
                    i2 = this.a.j0(resourceId);
                }
                if (i2 == 0 && string != null) {
                    if (string != null) {
                        i2 = this.a.k0(string);
                    }
                }
                if (i2 == 0 && i != i4) {
                    if (i != i4) {
                        i2 = this.a.j0(i);
                    }
                }
                String str5 = "Fragment ";
                final String str6 = "FragmentManager";
                final int i6 = 2;
                final int i7 = 1;
                if (i2 == 0) {
                    i2 = this.a.t0().a(context3.getClassLoader(), obj10);
                    i2.mFromLayout = i7;
                    obj11 = resourceId != 0 ? resourceId : i;
                    i2.mFragmentId = obj11;
                    i2.mContainerId = i;
                    i2.mTag = string;
                    i2.mInLayout = i7;
                    obj11 = this.a;
                    i2.mFragmentManager = obj11;
                    i2.mHost = obj11.w0();
                    i2.onInflate(this.a.w0().f(), attributeSet4, i2.mSavedFragmentState);
                    obj11 = this.a.g(i2);
                    if (n.I0(i6)) {
                        obj12 = new StringBuilder();
                        obj12.append(str5);
                        obj12.append(i2);
                        obj12.append(" has been inflated via the <fragment> tag: id=0x");
                        obj12.append(Integer.toHexString(resourceId));
                        Log.v(str6, obj12.toString());
                    }
                    i2.mContainer = (ViewGroup)view;
                    obj11.m();
                    obj11.j();
                    obj9 = i2.mView;
                    if (obj9 == null) {
                    } else {
                        if (resourceId != 0) {
                            obj9.setId(resourceId);
                        }
                        if (i2.mView.getTag() == null) {
                            i2.mView.setTag(string);
                        }
                        obj10 = new l.a(this, obj11);
                        i2.mView.addOnAttachStateChangeListener(obj10);
                        return i2.mView;
                    }
                    obj11 = new StringBuilder();
                    obj11.append(str5);
                    obj11.append(obj10);
                    obj11.append(" did not create a view.");
                    obj9 = new IllegalStateException(obj11.toString());
                    throw obj9;
                } else {
                    if (i2.mInLayout) {
                    } else {
                        i2.mInLayout = i7;
                        obj11 = this.a;
                        i2.mFragmentManager = obj11;
                        i2.mHost = obj11.w0();
                        i2.onInflate(this.a.w0().f(), attributeSet4, i2.mSavedFragmentState);
                        obj11 = this.a.x(i2);
                        if (n.I0(i6)) {
                            obj12 = new StringBuilder();
                            obj12.append("Retained Fragment ");
                            obj12.append(i2);
                            obj12.append(" has been re-attached via the <fragment> tag: id=0x");
                            obj12.append(Integer.toHexString(resourceId));
                            Log.v(str6, obj12.toString());
                        }
                    }
                }
            }
            obj11 = new StringBuilder();
            obj11.append(attributeSet4.getPositionDescription());
            obj11.append(": Duplicate id 0x");
            obj11.append(Integer.toHexString(resourceId));
            obj11.append(", tag ");
            obj11.append(string);
            obj11.append(", or parent id 0x");
            obj11.append(Integer.toHexString(i));
            obj11.append(" with another fragment for ");
            obj11.append(obj10);
            obj9 = new IllegalArgumentException(obj11.toString());
            throw obj9;
        }
        return i2;
    }

    @Override // android.view.LayoutInflater$Factory2
    public View onCreateView(String string, Context context2, AttributeSet attributeSet3) {
        return onCreateView(0, string, context2, attributeSet3);
    }
}
