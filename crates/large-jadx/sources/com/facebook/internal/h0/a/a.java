package com.facebook.internal.h0.a;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u0000 \u00112\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cJ\u0008\u0010\r\u001a\u00020\nH\u0002J\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lcom/facebook/internal/logging/dumpsys/AndroidRootResolver;", "", "()V", "initialized", "", "paramsField", "Ljava/lang/reflect/Field;", "viewsField", "windowManagerObj", "attachActiveRootListener", "", "listener", "Lcom/facebook/internal/logging/dumpsys/AndroidRootResolver$Listener;", "initialize", "listActiveRoots", "", "Lcom/facebook/internal/logging/dumpsys/AndroidRootResolver$Root;", "Companion", "ListenableArrayList", "Listener", "Root", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    private static final String e;
    private boolean a;
    private Object b;
    private Field c;
    private Field d;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Lcom/facebook/internal/logging/dumpsys/AndroidRootResolver$Root;", "", "view", "Landroid/view/View;", "param", "Landroid/view/WindowManager$LayoutParams;", "(Landroid/view/View;Landroid/view/WindowManager$LayoutParams;)V", "getParam", "()Landroid/view/WindowManager$LayoutParams;", "getView", "()Landroid/view/View;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        private final View a;
        private final WindowManager.LayoutParams b;
        public a(View view, WindowManager.LayoutParams windowManager$LayoutParams2) {
            n.f(view, "view");
            n.f(layoutParams2, "param");
            super();
            this.a = view;
            this.b = layoutParams2;
        }

        public final WindowManager.LayoutParams a() {
            return this.b;
        }

        public final View b() {
            return this.a;
        }
    }
    static {
        String simpleName = a.class.getSimpleName();
        n.e(simpleName, "AndroidRootResolver::class.java.simpleName");
        a.e = simpleName;
    }

    private final void a() {
        String str5;
        String str2;
        String str4;
        int i;
        String str3;
        String str;
        Field declaredField;
        Field declaredField2;
        str5 = "reflective setup failed using obj: %s method: %s field: %s";
        final String str6 = "java.lang.String.format(format, *args)";
        i = 1;
        this.a = i;
        int sDK_INT = Build.VERSION.SDK_INT;
        int i2 = 16;
        str = sDK_INT > i2 ? "android.view.WindowManagerGlobal" : "android.view.WindowManagerImpl";
        str3 = sDK_INT > i2 ? "getInstance" : "getDefault";
        int i3 = 3;
        final int i4 = 2;
        final int i5 = 0;
        Class forName = Class.forName(str);
        n.e(forName, "Class.forName(accessClass)");
        Method method = forName.getMethod(str3, new Class[i5]);
        n.e(method, "clazz.getMethod(instanceMethod)");
        this.b = method.invoke(0, new Object[i5]);
        declaredField2 = forName.getDeclaredField("mViews");
        this.c = declaredField2;
        if (declaredField2 != null) {
            declaredField2.setAccessible(i);
        }
        declaredField = forName.getDeclaredField("mParams");
        this.d = declaredField;
        if (declaredField != null) {
            declaredField.setAccessible(i);
        }
    }

    public final List<com.facebook.internal.h0.a.a.a> b() {
        int i2;
        int i3;
        int i;
        int aVar;
        int sDK_INT;
        String str = "java.lang.String.format(format, *args)";
        String str5 = "Reflective access to %s or %s on %s failed.";
        if (!this.a) {
            a();
        }
        Object obj = this.b;
        i = 0;
        if (obj == null) {
            Log.d(a.e, "No reflective access to windowmanager object.");
            return i;
        }
        Field field = this.c;
        if (field == null) {
            Log.d(a.e, "No reflective access to mViews");
            return i;
        }
        if (this.d == null) {
            Log.d(a.e, "No reflective access to mPArams");
            return i;
        }
        int i4 = 2;
        final int i6 = 1;
        final int i8 = 0;
        final int i9 = 3;
        if (Build.VERSION.SDK_INT < 19) {
            if (field != null) {
                i2 = field.get(obj);
            } else {
                i2 = i;
            }
            if ((View[])i2 != 0) {
                i3 = i.a0((View[])i2);
            } else {
                i3 = i;
            }
            Field field2 = this.d;
            if (field2 != null) {
                aVar = field2.get(this.b);
            } else {
                aVar = i;
            }
            if ((WindowManager.LayoutParams[])aVar != 0) {
                i = i.a0((WindowManager.LayoutParams[])aVar);
            }
        } else {
            if (field != null) {
                i3 = field.get(obj);
            } else {
                i3 = i;
            }
            Field field3 = this.d;
            if (field3 != null) {
                aVar = field3.get(this.b);
            } else {
                aVar = i;
            }
            i = aVar;
        }
        ArrayList arrayList = new ArrayList();
        if (i3 != 0) {
        } else {
            i3 = p.g();
        }
        if (i != 0) {
        } else {
            i = p.g();
        }
        Iterator iterator = p.S0(i3, i).iterator();
        for (o next2 : iterator) {
            aVar = new a.a((View)next2.a(), (WindowManager.LayoutParams)next2.b());
            arrayList.add(aVar);
        }
        return arrayList;
    }
}
