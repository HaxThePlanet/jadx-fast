package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class q0 extends ContextWrapper {

    private static final Object c;
    private static ArrayList<WeakReference<androidx.appcompat.widget.q0>> d;
    private final Resources a;
    private final Resources.Theme b = null;
    static {
        Object object = new Object();
        q0.c = object;
    }

    private q0(Context context) {
        Object s0Var;
        Resources resources;
        Resources.Theme obj3;
        super(context);
        if (y0.c()) {
            y0 y0Var = new y0(this, context.getResources());
            this.a = y0Var;
            s0Var = y0Var.newTheme();
            this.b = s0Var;
            s0Var.setTo(context.getTheme());
        } else {
            s0Var = new s0(this, context.getResources());
            this.a = s0Var;
            obj3 = 0;
        }
    }

    private static boolean a(Context context) {
        boolean z;
        int i;
        Object obj2;
        i = 0;
        if (!context instanceof q0 && !resources instanceof s0) {
            if (!resources instanceof s0) {
                if (obj2 instanceof y0) {
                } else {
                    if (Build.VERSION.SDK_INT >= 21) {
                        if (y0.c()) {
                            i = 1;
                        }
                    } else {
                    }
                }
            }
        }
        return i;
    }

    public static Context b(Context context) {
        int i;
        int arrayList;
        Object obj;
        Context baseContext;
        if (q0.a(context)) {
            Object obj2 = q0.c;
            ArrayList list = q0.d;
            synchronized (obj2) {
                arrayList = new ArrayList();
                q0.d = arrayList;
                q0 q0Var = new q0(context);
                WeakReference weakReference = new WeakReference(q0Var);
                q0.d.add(weakReference);
                return q0Var;
            }
        }
        return context;
    }

    @Override // android.content.ContextWrapper
    public AssetManager getAssets() {
        return this.a.getAssets();
    }

    @Override // android.content.ContextWrapper
    public Resources getResources() {
        return this.a;
    }

    @Override // android.content.ContextWrapper
    public Resources.Theme getTheme() {
        Resources.Theme theme;
        if (this.b == null) {
            theme = super.getTheme();
        }
        return theme;
    }

    @Override // android.content.ContextWrapper
    public void setTheme(int i) {
        int i2;
        final Resources.Theme theme = this.b;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
