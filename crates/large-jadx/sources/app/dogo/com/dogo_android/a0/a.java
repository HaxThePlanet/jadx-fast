package app.dogo.com.dogo_android.a0;

import com.google.android.play.core.tasks.c;

/* loaded from: classes.dex */
public final class a implements c {

    public final app.dogo.com.dogo_android.a0.c a;
    public final String b;
    public a(app.dogo.com.dogo_android.a0.c c, String string2) {
        super();
        this.a = c;
        this.b = string2;
    }

    @Override // com.google.android.play.core.tasks.c
    public final void onSuccess(Object object) {
        c.b(this.a, this.b, (Void)object);
    }
}
