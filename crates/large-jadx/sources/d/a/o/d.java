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

/* loaded from: classes.dex */
public class d extends ContextWrapper {

    private int a;
    private Resources.Theme b;
    private LayoutInflater c;
    private Configuration d;
    private Resources e;
    public d() {
        super(0);
    }

    public d(Context context, int i2) {
        super(context);
        this.a = i2;
    }

    public d(Context context, Resources.Theme resources$Theme2) {
        super(context);
        this.b = theme2;
    }

    private Resources b() {
        Object displayMetrics;
        Configuration configuration;
        Resources resources;
        AssetManager assets;
        if (this.e == null) {
            Configuration configuration2 = this.d;
            if (configuration2 == null) {
                this.e = super.getResources();
            } else {
                if (Build.VERSION.SDK_INT >= 17) {
                    this.e = createConfigurationContext(configuration2).getResources();
                } else {
                    Resources resources2 = super.getResources();
                    configuration = new Configuration(resources2.getConfiguration());
                    configuration.updateFrom(this.d);
                    resources = new Resources(resources2.getAssets(), resources2.getDisplayMetrics(), configuration);
                    this.e = resources;
                }
            }
        }
        return this.e;
    }

    private void d() {
        int i;
        Resources.Theme theme2;
        Resources.Theme theme;
        i = this.b == null ? 1 : 0;
        this.b = getResources().newTheme();
        theme2 = getBaseContext().getTheme();
        if (i != 0 && theme2 != null) {
            this.b = getResources().newTheme();
            theme2 = getBaseContext().getTheme();
            if (theme2 != null) {
                this.b.setTo(theme2);
            }
        }
        e(this.b, this.a, i);
    }

    @Override // android.content.ContextWrapper
    public void a(Configuration configuration) {
        if (this.e != null) {
        } else {
            if (this.d != null) {
            } else {
                Configuration configuration3 = new Configuration(configuration);
                this.d = configuration3;
            }
            IllegalStateException obj2 = new IllegalStateException("Override configuration has already been set");
            throw obj2;
        }
        obj2 = new IllegalStateException("getResources() or getAssets() has already been called");
        throw obj2;
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
    protected void e(Resources.Theme resources$Theme, int i2, boolean z3) {
        theme.applyStyle(i2, true);
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
    public Object getSystemService(String string) {
        LayoutInflater obj2;
        if ("layout_inflater".equals(string) && this.c == null) {
            if (this.c == null) {
                this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.c;
        }
        return getBaseContext().getSystemService(string);
    }

    @Override // android.content.ContextWrapper
    public Resources.Theme getTheme() {
        int i;
        Resources.Theme theme = this.b;
        if (theme != null) {
            return theme;
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
}
