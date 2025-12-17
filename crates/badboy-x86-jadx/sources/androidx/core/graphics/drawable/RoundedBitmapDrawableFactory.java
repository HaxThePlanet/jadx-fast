package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;
import androidx.core.graphics.BitmapCompat;
import androidx.core.view.GravityCompat;
import java.io.InputStream;

/* loaded from: classes5.dex */
public final class RoundedBitmapDrawableFactory {

    private static final String TAG = "RoundedBitmapDrawableFa";

    private static class DefaultRoundedBitmapDrawable extends androidx.core.graphics.drawable.RoundedBitmapDrawable {
        DefaultRoundedBitmapDrawable(Resources res, Bitmap bitmap) {
            super(res, bitmap);
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        void gravityCompatApply(int gravity, int bitmapWidth, int bitmapHeight, Rect bounds, Rect outRect) {
            GravityCompat.apply(gravity, bitmapWidth, bitmapHeight, bounds, outRect, 0);
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        public boolean hasMipMap() {
            Bitmap mBitmap;
            int i;
            if (this.mBitmap != null && BitmapCompat.hasMipMap(this.mBitmap)) {
                i = BitmapCompat.hasMipMap(this.mBitmap) ? 1 : 0;
            } else {
            }
            return i;
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        public void setMipMap(boolean mipMap) {
            Bitmap mBitmap;
            if (this.mBitmap != null) {
                BitmapCompat.setHasMipMap(this.mBitmap, mipMap);
                invalidateSelf();
            }
        }
    }
    public static androidx.core.graphics.drawable.RoundedBitmapDrawable create(Resources res, Bitmap bitmap) {
        RoundedBitmapDrawable21 roundedBitmapDrawable21 = new RoundedBitmapDrawable21(res, bitmap);
        return roundedBitmapDrawable21;
    }

    public static androidx.core.graphics.drawable.RoundedBitmapDrawable create(Resources res, InputStream is) {
        Object bitmap;
        String str;
        androidx.core.graphics.drawable.RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(res, BitmapFactory.decodeStream(is));
        if (create.getBitmap() == null) {
            StringBuilder stringBuilder = new StringBuilder();
            Log.w("RoundedBitmapDrawableFa", stringBuilder.append("RoundedBitmapDrawable cannot decode ").append(is).toString());
        }
        return create;
    }

    public static androidx.core.graphics.drawable.RoundedBitmapDrawable create(Resources res, String filepath) {
        Object bitmap;
        String str;
        androidx.core.graphics.drawable.RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(res, BitmapFactory.decodeFile(filepath));
        if (create.getBitmap() == null) {
            StringBuilder stringBuilder = new StringBuilder();
            Log.w("RoundedBitmapDrawableFa", stringBuilder.append("RoundedBitmapDrawable cannot decode ").append(filepath).toString());
        }
        return create;
    }
}
