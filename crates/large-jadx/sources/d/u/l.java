package d.u;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: Scene.java */
/* loaded from: classes.dex */
public class l {

    private Context a;
    private int b = -1;
    private ViewGroup c;
    private View d;
    private Runnable e;
    private Runnable f;
    public l(ViewGroup viewGroup, View view) {
        super();
        this.c = viewGroup;
        this.d = view;
    }

    public static l c(ViewGroup viewGroup) {
        return (l)viewGroup.getTag(j.c);
    }

    static void f(ViewGroup viewGroup, l lVar) {
        viewGroup.setTag(j.c, lVar);
    }

    public void a() {
        if (this.b > 0 || this.d != null) {
            d().removeAllViews();
            if (this.b > 0) {
                LayoutInflater.from(this.a).inflate(this.b, this.c);
            } else {
                this.c.addView(this.d);
            }
        }
        if (this.e != null) {
            this.e.run();
        }
        l.f(this.c, this);
    }

    public void b() {
        if (l.c(this.c) == this && this.f != null) {
            this.f.run();
        }
    }

    public ViewGroup d() {
        return this.c;
    }

    boolean e() {
        boolean z = true;
        int r0 = this.b > 0 ? 1 : 0;
        return (this.b > 0 ? 1 : 0);
    }
}
