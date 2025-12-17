package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;

/* loaded from: classes.dex */
final class f extends Drawable.ConstantState {

    int a = 0;
    Drawable.ConstantState b = null;
    ColorStateList c;
    PorterDuff.Mode d = null;
    f(androidx.core.graphics.drawable.f f) {
        Object mode;
        Object obj2;
        super();
        this.c = 0;
        mode = d.y;
        if (f != null) {
            int i2 = f.a;
            Drawable.ConstantState constantState = f.b;
            this.c = f.c;
            this.d = f.d;
        }
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    boolean a() {
        int i;
        i = this.b != null ? 1 : 0;
        return i;
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public int getChangingConfigurations() {
        int changingConfigurations;
        Drawable.ConstantState constantState = this.b;
        if (constantState != null) {
            changingConfigurations = constantState.getChangingConfigurations();
        } else {
            changingConfigurations = 0;
        }
        return i |= changingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public Drawable newDrawable() {
        return newDrawable(0);
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public Drawable newDrawable(Resources resources) {
        if (Build.VERSION.SDK_INT >= 21) {
            e eVar = new e(this, resources);
            return eVar;
        }
        d dVar = new d(this, resources);
        return dVar;
    }
}
