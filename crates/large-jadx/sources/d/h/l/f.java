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

/* loaded from: classes.dex */
public class f {

    private static boolean a = false;
    private static Method b = null;
    private static boolean c = false;
    private static Field d;

    public interface a {
        public abstract boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }
    static {
    }

    private static boolean a(ActionBar actionBar, KeyEvent keyEvent2) {
        boolean method;
        String str;
        Class[] arr;
        Class<KeyEvent> obj;
        int i = 1;
        final int i2 = 0;
        if (!f.a) {
            arr = new Class[i];
            arr[i2] = KeyEvent.class;
            f.b = actionBar.getClass().getMethod("onMenuKeyEvent", arr);
            f.a = i;
        }
        Method method2 = f.b;
        if (method2 != null) {
            Object[] arr2 = new Object[i];
            arr2[i2] = keyEvent2;
            return (Boolean)method2.invoke(actionBar, arr2).booleanValue();
        }
        return i2;
    }

    private static boolean b(Activity activity, KeyEvent keyEvent2) {
        int keyDispatcherState;
        boolean actionBar;
        int keyCode;
        int i;
        activity.onUserInteraction();
        Window window = activity.getWindow();
        final int i3 = 1;
        actionBar = activity.getActionBar();
        if (window.hasFeature(8) && keyEvent2.getKeyCode() == 82 && actionBar != null && f.a(actionBar, keyEvent2)) {
            actionBar = activity.getActionBar();
            if (keyEvent2.getKeyCode() == 82) {
                if (actionBar != null) {
                    if (f.a(actionBar, keyEvent2)) {
                        return i3;
                    }
                }
            }
        }
        if (window.superDispatchKeyEvent(keyEvent2)) {
            return i3;
        }
        View decorView = window.getDecorView();
        if (u.i(decorView, keyEvent2)) {
            return i3;
        }
        if (decorView != null) {
            keyDispatcherState = decorView.getKeyDispatcherState();
        } else {
            keyDispatcherState = 0;
        }
        return keyEvent2.dispatch(activity, keyDispatcherState, activity);
    }

    private static boolean c(Dialog dialog, KeyEvent keyEvent2) {
        DialogInterface.OnKeyListener onKey;
        int keyDispatcherState;
        int keyCode;
        onKey = f.f(dialog);
        final int i = 1;
        if (onKey != null && onKey.onKey(dialog, keyEvent2.getKeyCode(), keyEvent2)) {
            if (onKey.onKey(dialog, keyEvent2.getKeyCode(), keyEvent2)) {
                return i;
            }
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent2)) {
            return i;
        }
        View decorView = window.getDecorView();
        if (u.i(decorView, keyEvent2)) {
            return i;
        }
        if (decorView != null) {
            keyDispatcherState = decorView.getKeyDispatcherState();
        } else {
            keyDispatcherState = 0;
        }
        return keyEvent2.dispatch(dialog, keyDispatcherState, dialog);
    }

    public static boolean d(View view, KeyEvent keyEvent2) {
        return u.j(view, keyEvent2);
    }

    public static boolean e(d.h.l.f.a f$a, View view2, Window.Callback window$Callback3, KeyEvent keyEvent4) {
        int i;
        boolean obj3;
        View obj4;
        if (!a) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return a.superDispatchKeyEvent(keyEvent4);
        }
        if (callback3 instanceof Activity != null) {
            return f.b((Activity)callback3, keyEvent4);
        }
        if (callback3 instanceof Dialog) {
            return f.c((Dialog)callback3, keyEvent4);
        }
        if (view2 != null) {
            if (!u.i(view2, keyEvent4)) {
                if (a.superDispatchKeyEvent(keyEvent4)) {
                    i = 1;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static DialogInterface.OnKeyListener f(Dialog dialog) {
        boolean z;
        Field declaredField;
        String str;
        if (!f.c) {
            z = 1;
            declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
            f.d = declaredField;
            declaredField.setAccessible(z);
            f.c = z;
        }
        Field field = f.d;
        if (field != null) {
            return (DialogInterface.OnKeyListener)field.get(dialog);
        }
        return null;
    }
}
