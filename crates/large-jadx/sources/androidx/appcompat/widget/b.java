package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class b extends Drawable {

    final androidx.appcompat.widget.ActionBarContainer a;
    public b(androidx.appcompat.widget.ActionBarContainer actionBarContainer) {
        super();
        this.a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        androidx.appcompat.widget.ActionBarContainer actionBarContainer;
        Drawable z;
        androidx.appcompat.widget.ActionBarContainer actionBarContainer2 = this.a;
        if (actionBarContainer2.z) {
            actionBarContainer = actionBarContainer2.y;
            if (actionBarContainer != null) {
                actionBarContainer.draw(canvas);
            }
        } else {
            Drawable drawable = actionBarContainer2.w;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            actionBarContainer = this.a;
            z = actionBarContainer.x;
            if (z != null && actionBarContainer.A) {
                if (actionBarContainer.A) {
                    z.draw(canvas);
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable;
        androidx.appcompat.widget.ActionBarContainer actionBarContainer = this.a;
        if (actionBarContainer.z) {
            drawable = actionBarContainer.y;
            if (drawable != null) {
                drawable.getOutline(outline);
            }
        } else {
            drawable = actionBarContainer.w;
            if (drawable != null) {
                drawable.getOutline(outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
