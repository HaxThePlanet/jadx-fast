package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

/* loaded from: classes5.dex */
class RoundedBitmapDrawable21 extends androidx.core.graphics.drawable.RoundedBitmapDrawable {
    protected RoundedBitmapDrawable21(Resources res, Bitmap bitmap) {
        super(res, bitmap);
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public void getOutline(Outline outline) {
        updateDstRect();
        outline.setRoundRect(this.mDstRect, getCornerRadius());
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    void gravityCompatApply(int gravity, int bitmapWidth, int bitmapHeight, Rect bounds, Rect outRect) {
        Gravity.apply(gravity, bitmapWidth, bitmapHeight, bounds, outRect, 0);
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public boolean hasMipMap() {
        Bitmap mBitmap;
        int i;
        if (this.mBitmap != null && this.mBitmap.hasMipMap()) {
            i = this.mBitmap.hasMipMap() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public void setMipMap(boolean mipMap) {
        Bitmap mBitmap;
        if (this.mBitmap != null) {
            this.mBitmap.setHasMipMap(mipMap);
            invalidateSelf();
        }
    }
}
