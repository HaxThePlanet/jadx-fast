package d.h.l;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnKeyListener;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: KeyEventDispatcher.java */
/* loaded from: classes.dex */
public class f {

    private static boolean a = false;
    private static Method b = null;
    private static boolean c = false;
    private static Field d;

    public interface a {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }
    private static boolean a(ActionBar actionBar, KeyEvent keyEvent) throws java.lang.NoSuchMethodException {
        int i = 1;
        final int i2 = 0;
        if (!f.a) {
            try {
                str = "onMenuKeyEvent";
                Class[] arr = new Class[i];
                obj = KeyEvent.class;
                f.b = actionBar.getClass().getMethod(str, new Class[] { obj });
            } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
                return false;
            }
            f.a = true;
        }
        Method method = f.b;
        if (f.b != null) {
            try {
                Object[] arr2 = new Object[i];
                arr2[i2] = keyEvent;
            } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
                return false;
            }
            return (Boolean)f.b.invoke(actionBar, arr2).booleanValue();
        }
    }

    private static boolean b(Activity activity, KeyEvent keyEvent) {
        android.view.KeyEvent.DispatcherState keyDispatcherState = null;
        activity.onUserInteraction();
        Window window = activity.getWindow();
        final boolean z2 = true;
        if (window.hasFeature(8) && keyEvent.getKeyCode() == 82 && actionBar != null && f.a(actionBar, keyEvent)) {
            return true;
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (u.i(decorView, keyEvent)) {
            return true;
        }
        if (decorView != null) {
            keyDispatcherState = decorView.getKeyDispatcherState();
        } else {
            int i2 = 0;
        }
        return keyEvent.dispatch(activity, keyDispatcherState, activity);
    }

    private static boolean c(Dialog dialog, KeyEvent keyEvent) {
        android.view.KeyEvent.DispatcherState keyDispatcherState = null;
        DialogInterface.OnKeyListener onKeyListener = f.f(dialog);
        final boolean z = true;
        if (onKeyListener != null && onKeyListener.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (u.i(decorView, keyEvent)) {
            return true;
        }
        if (decorView != null) {
            keyDispatcherState = decorView.getKeyDispatcherState();
        } else {
            int i = 0;
        }
        return keyEvent.dispatch(dialog, keyDispatcherState, dialog);
    }

    public static boolean d(View view, KeyEvent keyEvent) {
        return u.j(view, keyEvent);
    }

    public static boolean e(f.a aVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        boolean z = true;
        boolean superDispatchKeyEvent;
        boolean z2;
        z = false;
        if (aVar == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return aVar.superDispatchKeyEvent(keyEvent);
        }
        if (callback instanceof Activity) {
            return f.b(callback, keyEvent);
        }
        if (callback instanceof Dialog) {
            return f.c(callback, keyEvent);
        }
        if (view == null || !u.i(view, keyEvent)) {
            if (aVar.superDispatchKeyEvent(keyEvent)) {
                int i = 1;
            }
        }
        return z;
    }

    private static DialogInterface.OnKeyListener f(Dialog dialog) throws java.lang.NoSuchFieldException {
        if (!f.c) {
            boolean z = true;
            try {
                str = "mOnKeyListener";
                Field declaredField = Dialog.class.getDeclaredField(str);
                f.d = declaredField;
                declaredField.setAccessible(z);
            } catch (java.lang.IllegalAccessException unused) {
                return null;
            }
            f.c = z;
        }
        Field field = f.d;
        if (f.d != null) {
            try {
            } catch (java.lang.IllegalAccessException unused) {
                return null;
            }
            return (DialogInterface.OnKeyListener)f.d.get(dialog);
        }
    }

}
