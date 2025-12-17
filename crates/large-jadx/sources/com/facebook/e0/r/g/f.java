package com.facebook.e0.r.g;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0014\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000c2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u000cH\u0007J\u0018\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00132\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u000cH\u0007J\u0010\u0010\u0014\u001a\u00020\u00082\u0006\u0010\u0011\u001a\u00020\u000cH\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u000cH\u0007J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u000cH\u0002J\u0016\u0010\u0018\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u000cH\u0007J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u000cH\u0007J\u0012\u0010\u001f\u001a\u00020\u00042\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u000cH\u0007J\u0014\u0010 \u001a\u0004\u0018\u00010!2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u000cH\u0007J\u0012\u0010\"\u001a\u00020\u00042\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u000cH\u0007J\u001e\u0010#\u001a\u0004\u0018\u00010\u000c2\u0008\u0010$\u001a\u0004\u0018\u00010%2\u0008\u0010&\u001a\u0004\u0018\u00010\u000cH\u0002J\u0010\u0010'\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u000cH\u0002J\u0008\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020\u000cH\u0003J\u0018\u0010,\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020\u000c2\u0008\u0010&\u001a\u0004\u0018\u00010\u000cJ\u0010\u0010-\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020\u000cH\u0002J\u001a\u0010.\u001a\u00020)2\u0006\u0010\u0011\u001a\u00020\u000c2\u0008\u0010/\u001a\u0004\u0018\u00010\u001cH\u0007J \u00100\u001a\u00020)2\u0006\u0010\u0011\u001a\u00020\u000c2\u0006\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u000203H\u0007J\u0018\u00104\u001a\u00020)2\u0006\u0010\u0011\u001a\u00020\u000c2\u0006\u00101\u001a\u00020\u0016H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065", d2 = {"Lcom/facebook/appevents/codeless/internal/ViewHierarchy;", "", "()V", "CLASS_RCTROOTVIEW", "", "CLASS_RCTVIEWGROUP", "CLASS_TOUCHTARGETHELPER", "ICON_MAX_EDGE_LENGTH", "", "METHOD_FIND_TOUCHTARGET_VIEW", "RCTRootViewReference", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "TAG", "methodFindTouchTargetView", "Ljava/lang/reflect/Method;", "findRCTRootView", "view", "getChildrenOfView", "", "getClassTypeBitmask", "getDictionaryOfView", "Lorg/json/JSONObject;", "getDimensionOfView", "getExistingClass", "Ljava/lang/Class;", "className", "getExistingOnClickListener", "Landroid/view/View$OnClickListener;", "getExistingOnTouchListener", "Landroid/view/View$OnTouchListener;", "getHintOfView", "getParentOfView", "Landroid/view/ViewGroup;", "getTextOfView", "getTouchReactView", "location", "", "RCTRootView", "getViewLocationOnScreen", "initTouchTargetHelperMethods", "", "isAdapterViewItem", "", "isRCTButton", "isRCTRootView", "setOnClickListener", "newListener", "updateAppearanceOfView", "json", "displayDensity", "", "updateBasicInfoOfView", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class f {

    private static final String a = "com.facebook.e0.r.g.f";
    private static WeakReference<View> b;
    private static Method c;
    public static final com.facebook.e0.r.g.f d;
    static {
        f fVar = new f();
        f.d = fVar;
        WeakReference weakReference = new WeakReference(0);
        f.b = weakReference;
    }

    public static final View a(View view) {
        boolean z;
        Object obj3;
        final int i = 0;
        if (a.d(f.class)) {
            return i;
        }
        while (obj3 != null) {
        }
        return i;
    }

    public static final List<View> b(View view) {
        boolean childCount;
        int i;
        View childAt;
        if (a.d(f.class)) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            i = 0;
            while (i < (ViewGroup)view.getChildCount()) {
                arrayList.add((ViewGroup)view.getChildAt(i));
                i++;
            }
        }
        return arrayList;
    }

    public static final int c(View view) {
        int i;
        boolean z;
        Object obj;
        Object obj5;
        final int i3 = 0;
        if (a.d(f.class)) {
            return i3;
        }
        n.f(view, "view");
        i = view instanceof ImageView != null ? 2 : i3;
        if (view.isClickable()) {
            i |= 32;
        }
        if (f.o(view)) {
            i |= 512;
        }
        if (view instanceof TextView != null) {
            try {
                if (view instanceof Button) {
                }
                i |= 4;
                if (view instanceof Switch) {
                } else {
                }
                i |= 8192;
                if (view instanceof CheckBox) {
                }
                i |= z;
                if (view instanceof EditText) {
                }
                i |= 2048;
                if (!view instanceof Spinner) {
                } else {
                }
                if (view instanceof DatePicker) {
                } else {
                }
                if (view instanceof RatingBar) {
                } else {
                }
                i |= obj5;
                if (view instanceof RadioGroup) {
                } else {
                }
                i |= 16384;
                if (view instanceof ViewGroup && f.d.p(view, (View)f.b.get())) {
                }
                if (f.d.p(view, (View)f.b.get())) {
                }
                i |= 64;
                i |= 4096;
                return i;
                a.b(view, obj0);
                return obj2;
            }
        } else {
        }
    }

    public static final JSONObject d(View view) {
        boolean weakReference;
        JSONArray jSONArray;
        int i;
        JSONObject jSONObject;
        String obj7;
        if (a.d(f.class)) {
            return null;
        }
        n.f(view, "view");
        if (n.b(view.getClass().getName(), "com.facebook.react.ReactRootView")) {
            weakReference = new WeakReference(view);
            f.b = weakReference;
        }
        JSONObject jSONObject2 = new JSONObject();
        f.s(view, jSONObject2);
        jSONArray = new JSONArray();
        obj7 = f.b(view);
        i = 0;
        while (i < obj7.size()) {
            jSONArray.put(f.d((View)obj7.get(i)));
            i++;
        }
        jSONObject2.put("childviews", jSONArray);
        return jSONObject2;
    }

    private final JSONObject e(View view) {
        String str;
        int scrollY;
        int obj5;
        if (a.d(this)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("top", view.getTop());
        jSONObject.put("left", view.getLeft());
        jSONObject.put("width", view.getWidth());
        jSONObject.put("height", view.getHeight());
        jSONObject.put("scrollx", view.getScrollX());
        jSONObject.put("scrolly", view.getScrollY());
        jSONObject.put("visibility", view.getVisibility());
        return jSONObject;
    }

    private final Class<?> f(String string) {
        String obj3;
        if (a.d(this)) {
            return 0;
        }
        return Class.forName(string);
    }

    public static final View.OnClickListener g(View view) {
        Field declaredField;
        int i;
        String str;
        Object obj5;
        if (a.d(f.class)) {
            return null;
        }
        declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
        n.e(declaredField, "Class.forName(\"android.v…redField(\"mListenerInfo\")");
        int i2 = 1;
        if (declaredField != null) {
            declaredField.setAccessible(i2);
        }
        obj5 = declaredField.get(view);
        declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
        n.e(declaredField, "Class.forName(\"android.v…Field(\"mOnClickListener\")");
        if (obj5 != null && declaredField != null) {
            declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            n.e(declaredField, "Class.forName(\"android.v…Field(\"mOnClickListener\")");
            if (declaredField != null) {
                declaredField.setAccessible(i2);
                obj5 = declaredField.get(obj5);
                if (obj5 == null) {
                } else {
                    i = obj5;
                }
                obj5 = new NullPointerException("null cannot be cast to non-null type android.view.View.OnClickListener");
                throw obj5;
            }
        }
        return i;
    }

    public static final View.OnTouchListener h(View view) {
        String str;
        Field declaredField;
        int i;
        String str2;
        Object obj5;
        if (a.d(f.class)) {
            return null;
        }
        declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
        n.e(declaredField, "Class.forName(\"android.v…redField(\"mListenerInfo\")");
        int i2 = 1;
        if (declaredField != null) {
            declaredField.setAccessible(i2);
        }
        obj5 = declaredField.get(view);
        declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener");
        n.e(declaredField, "Class.forName(\"android.v…Field(\"mOnTouchListener\")");
        if (obj5 != null && declaredField != null) {
            declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener");
            n.e(declaredField, "Class.forName(\"android.v…Field(\"mOnTouchListener\")");
            if (declaredField != null) {
                declaredField.setAccessible(i2);
                obj5 = declaredField.get(obj5);
                if (obj5 == null) {
                } else {
                    i = obj5;
                }
                obj5 = new NullPointerException("null cannot be cast to non-null type android.view.View.OnTouchListener");
                throw obj5;
            }
        }
        return i;
    }

    public static final String i(View view) {
        boolean z;
        java.lang.CharSequence obj3;
        final int i = 0;
        if (a.d(f.class)) {
            return i;
        }
        if (view instanceof EditText) {
            obj3 = (EditText)view.getHint();
        } else {
            if (view instanceof TextView != null) {
                obj3 = (TextView)view.getHint();
            } else {
                obj3 = i;
            }
        }
        if (obj3 != null && obj3.toString() != null) {
            if (obj3.toString() != null) {
            } else {
                try {
                    obj3 = "";
                    return obj3;
                    a.b(view, obj0);
                    return obj2;
                }
            }
        } else {
        }
    }

    public static final ViewGroup j(View view) {
        int i;
        i = 0;
        if (a.d(f.class)) {
            return i;
        }
        if (view == null) {
            return i;
        }
        final android.view.ViewParent obj3 = view.getParent();
        if (obj3 instanceof ViewGroup) {
            i = obj3;
        }
        return i;
    }

    public static final String k(View view) {
        int checkedRadioButtonId;
        java.lang.CharSequence valueOf;
        int childCount;
        int childAt;
        int i2;
        int i3;
        String month;
        Object[] arr;
        int i;
        Object[] arr2;
        String obj11;
        final int i4 = 0;
        if (a.d(f.class)) {
            return i4;
        }
        if (view instanceof TextView != null) {
            valueOf = (TextView)view.getText();
            if (view instanceof Switch) {
                obj11 = (Switch)view.isChecked() ? "1" : "0";
                valueOf = obj11;
            }
        } else {
            if (view instanceof Spinner) {
                obj11 = (Spinner)view.getSelectedItem();
                if ((Spinner)view.getCount() > 0 && obj11 != null) {
                    try {
                        obj11 = (Spinner)view.getSelectedItem();
                        if (obj11 != null) {
                        } else {
                        }
                        valueOf = obj11.toString();
                        childCount = "java.lang.String.format(format, *args)";
                        childAt = 2;
                        i2 = 1;
                        i3 = 0;
                        if (view instanceof DatePicker) {
                        } else {
                        }
                        f0 f0Var2 = f0.a;
                        i = 3;
                        arr2 = new Object[i];
                        arr2[i3] = Integer.valueOf((DatePicker)view.getYear());
                        arr2[i2] = Integer.valueOf((DatePicker)view.getMonth());
                        arr2[childAt] = Integer.valueOf((DatePicker)view.getDayOfMonth());
                        n.e(String.format("%04d-%02d-%02d", Arrays.copyOf(arr2, i)), childCount);
                        if (view instanceof TimePicker) {
                        } else {
                        }
                        Integer currentHour = (TimePicker)view.getCurrentHour();
                        n.e(currentHour, "view.currentHour");
                        obj11 = (TimePicker)view.getCurrentMinute();
                        n.e(obj11, "view.currentMinute");
                        f0 f0Var = f0.a;
                        arr = new Object[childAt];
                        arr[i3] = Integer.valueOf(currentHour.intValue());
                        arr[i2] = Integer.valueOf(obj11.intValue());
                        n.e(String.format("%02d:%02d", Arrays.copyOf(arr, childAt)), childCount);
                        if (view instanceof RadioGroup) {
                        } else {
                        }
                        while (i3 < (RadioGroup)view.getChildCount()) {
                            childAt = (RadioGroup)view.getChildAt(i3);
                            n.e(childAt, "child");
                            i3++;
                        }
                        childAt = (RadioGroup)view.getChildAt(i3);
                        n.e(childAt, "child");
                        if (childAt.getId() == (RadioGroup)view.getCheckedRadioButtonId()) {
                        } else {
                        }
                        if (childAt instanceof RadioButton) {
                        } else {
                        }
                        valueOf = (RadioButton)childAt.getText();
                        i3++;
                        if (view instanceof RatingBar) {
                        } else {
                        }
                        valueOf = String.valueOf((RatingBar)view.getRating());
                        valueOf = i4;
                        if (valueOf != null && valueOf.toString() != null) {
                        } else {
                        }
                        if (valueOf.toString() != null) {
                        } else {
                        }
                        obj11 = "";
                        return obj11;
                        a.b(view, obj0);
                        return obj2;
                    }
                } else {
                }
            } else {
            }
        }
    }

    private final View l(float[] fArr, View view2) {
        Method method;
        Object[] arr;
        int i;
        Object obj5;
        Object obj6;
        final int i2 = 0;
        if (a.d(this)) {
            return i2;
        }
        n();
        method = f.c;
        if (method != null) {
            if (view2 == null) {
            } else {
                if (method == null) {
                } else {
                    arr = new Object[2];
                    obj5 = method.invoke(i2, fArr, view2);
                    obj6 = "null cannot be cast to non-null type android.view.View";
                    if (obj5 == null) {
                    } else {
                        if (obj5 != null && (View)obj5.getId() > 0) {
                            try {
                                if (obj5.getId() > 0) {
                                }
                                obj5 = obj5.getParent();
                                if (obj5 == null) {
                                } else {
                                }
                                return (View)obj5;
                                obj5 = new NullPointerException(obj6);
                                throw obj5;
                                obj5 = new NullPointerException(obj6);
                                throw obj5;
                            } catch (java.lang.IllegalAccessException illegalAccess) {
                            } catch (java.lang.reflect.InvocationTargetException invocationTarget1) {
                            } catch (Throwable th2) {
                            }
                        }
                    }
                }
            }
            obj6 = new IllegalStateException("Required value was null.".toString());
            throw obj6;
        }
        return i2;
    }

    private final float[] m(View view) {
        if (a.d(this)) {
            return null;
        }
        int i = 2;
        int[] iArr = new int[i];
        view.getLocationOnScreen(iArr);
        final float[] obj5 = new float[i];
        int i2 = 0;
        obj5[i2] = (float)i6;
        int i3 = 1;
        obj5[i3] = (float)i5;
        return obj5;
    }

    private final void n() {
        Method declaredMethod;
        String str;
        if (a.d(this)) {
        }
        if (f.c != null) {
        }
        Class forName = Class.forName("com.facebook.react.uimanager.TouchTargetHelper");
        n.e(forName, "Class.forName(CLASS_TOUCHTARGETHELPER)");
        Class[] arr = new Class[2];
        int i3 = 1;
        arr[i3] = ViewGroup.class;
        declaredMethod = forName.getDeclaredMethod("findTouchTargetView", arr);
        f.c = declaredMethod;
        if (declaredMethod == null) {
        } else {
            declaredMethod.setAccessible(i3);
        }
        IllegalStateException illegalStateException = new IllegalStateException("Required value was null.".toString());
        throw illegalStateException;
    }

    private static final boolean o(View view) {
        int i;
        Class instance;
        android.view.ViewParent obj5;
        if (a.d(f.class)) {
            return 0;
        }
        obj5 = view.getParent();
        final int i2 = 1;
        if (obj5 instanceof AdapterView != null) {
            return i2;
        }
        com.facebook.e0.r.g.f fVar = f.d;
        instance = fVar.f("android.support.v4.view.NestedScrollingChild");
        if (instance != null && instance.isInstance(obj5)) {
            if (instance.isInstance(obj5)) {
                return i2;
            }
        }
        Class cls = fVar.f("androidx.core.view.NestedScrollingChild");
        if (cls != null && cls.isInstance(obj5)) {
            if (cls.isInstance(obj5)) {
                i = i2;
            }
        }
        try {
            return i;
            a.b(view, obj0);
            return obj2;
        }
    }

    private final boolean q(View view) {
        if (a.d(this)) {
            return 0;
        }
        return n.b(view.getClass().getName(), "com.facebook.react.ReactRootView");
    }

    public static final void r(View view, View.OnClickListener view$OnClickListener2) {
        int i;
        Field declaredField2;
        Field declaredField;
        String str;
        if (a.d(f.class)) {
        }
        n.f(view, "view");
        i = 0;
        declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
        declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
        if (declaredField2 != null) {
            if (declaredField == null) {
                view.setOnClickListener(onClickListener2);
            } else {
                str = 1;
                declaredField2.setAccessible(str);
                declaredField.setAccessible(str);
                declaredField2.setAccessible(str);
                i = declaredField2.get(view);
                if (i == null) {
                    view.setOnClickListener(onClickListener2);
                }
                try {
                    declaredField.set(i, onClickListener2);
                    view.setOnClickListener(onClickListener2);
                    a.b(view, obj0);
                } catch (java.lang.ClassNotFoundException classNotFound) {
                } catch (java.lang.NoSuchFieldException noSuchField1) {
                } catch (Exception e2) {
                } catch (Throwable th3) {
                }
            }
        } else {
        }
    }

    public static final void s(View view, JSONObject jSONObject2) {
        String str;
        String str2;
        String str3;
        boolean z;
        JSONObject obj8;
        Object obj9;
        if (a.d(f.class)) {
        }
        n.f(view, "view");
        n.f(jSONObject2, "json");
        final Object tag = view.getTag();
        final java.lang.CharSequence contentDescription = view.getContentDescription();
        jSONObject2.put("classname", view.getClass().getCanonicalName());
        jSONObject2.put("classtypebitmask", f.c(view));
        jSONObject2.put("id", view.getId());
        String str16 = "text";
        final String str17 = "";
        if (!d.g(view)) {
            jSONObject2.put(str16, b0.j(b0.y0(f.k(view)), str17));
        } else {
            jSONObject2.put(str16, str17);
            jSONObject2.put("is_user_input", true);
        }
        jSONObject2.put("hint", b0.j(b0.y0(f.i(view)), str17));
        if (tag != null) {
            jSONObject2.put("tag", b0.j(b0.y0(tag.toString()), str17));
        }
        if (contentDescription != null) {
            jSONObject2.put("description", b0.j(b0.y0(contentDescription.toString()), str17));
        }
        try {
            jSONObject2.put("dimension", f.d.e(view));
            jSONObject2 = f.a;
            b0.c0(jSONObject2, view);
            a.b(view, obj0);
        } catch (org.json.JSONException jSON) {
        } catch (Throwable th1) {
        }
    }

    public final boolean p(View view, View view2) {
        boolean z;
        int i;
        Object obj4;
        View obj5;
        if (a.d(this)) {
            return 0;
        }
        n.f(view, "view");
        String name = view.getClass().getName();
        n.e(name, "view.javaClass.name");
        obj5 = l(m(view), view2);
        if (n.b(name, "com.facebook.react.views.view.ReactViewGroup") && obj5 != null && obj5.getId() == view.getId()) {
            obj5 = l(m(view), view2);
            if (obj5 != null) {
                if (obj5.getId() == view.getId()) {
                    i = 1;
                }
            }
        }
        return i;
    }
}
