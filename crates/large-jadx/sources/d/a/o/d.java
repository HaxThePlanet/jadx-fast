package d.a.o;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import d.a.i;

/* compiled from: ContextThemeWrapper.java */
/* loaded from: classes.dex */
public class d extends ContextWrapper {

    private int a;
    private Resources.Theme b;
    private LayoutInflater c;
    private Configuration d;
    private Resources e;
    public d() {
        super(null);
    }

    private Resources b() {
        if (this.e == null && this.d == null) {
            this.e = super.getResources();
        }
        return this.e;
    }

    private void d() {
        boolean z = true;
        int r0 = this.b == null ? 1 : 0;
        if (this.b) {
            this.b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        e(this.b, this.a, z);
    }

    @Override // android.content.ContextWrapper
    public void a(Configuration configuration) {
        if (this.e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else {
            if (this.d != null) {
                throw new IllegalStateException("Override configuration has already been set");
            } else {
                this.d = new Configuration(configuration);
                return;
            }
        }
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper
    public int c() {
        return this.a;
    }

    @Override // android.content.ContextWrapper
    protected void e(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    @Override // android.content.ContextWrapper
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str) && this.c == null) {
            this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            return this.c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper
    public Resources.Theme getTheme() {
        if (this.b != null) {
            return this.b;
        }
        if (this.a == 0) {
            this.a = i.d;
        }
        d();
        return this.b;
    }

    @Override // android.content.ContextWrapper
    public void setTheme(int i) {
        if (this.a != i) {
            this.a = i;
            d();
        }
    }

    public d(Context context, int i) {
        super(context);
        this.a = i;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.b = theme;
    }
}
