package zendesk.belvedere;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.a;
import androidx.core.graphics.drawable.a;
import com.squareup.picasso.e0;
import java.util.Locale;
import zendesk.belvedere.b0.f;

/* loaded from: classes3.dex */
class a0 {

    private static class a implements e0 {

        private final int a;
        private final int b;
        a(int i, int i2) {
            super();
            this.a = i;
            this.b = i2;
        }

        @Override // com.squareup.picasso.e0
        public String key() {
            Object[] arr = new Object[2];
            return String.format(Locale.US, "rounded-%s-%s", Integer.valueOf(this.a), Integer.valueOf(this.b));
        }

        @Override // com.squareup.picasso.e0
        public Bitmap transform(Bitmap bitmap) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Shader.TileMode cLAMP = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, cLAMP, cLAMP);
            paint.setShader(bitmapShader);
            Bitmap bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap2);
            int i2 = this.b;
            RectF rectF = new RectF((float)i2, (float)i2, (float)i4, (float)i6);
            int i3 = this.a;
            canvas.drawRoundRect(rectF, (float)i3, (float)i3, paint);
            if (bitmap != bitmap2) {
                bitmap.recycle();
            }
            return bitmap2;
        }
    }
    static int a(Context context, int i2) {
        int obj3;
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            int obj4 = typedValue.resourceId;
            if (obj4 == null) {
                obj3 = typedValue.data;
            } else {
                obj3 = a.d(context, obj4);
            }
            return obj3;
        }
        return -16777216;
    }

    static void b(ImageView imageView, int i2) {
        Drawable drawable;
        if (imageView != null) {
            if (imageView.getDrawable() == null) {
            } else {
                a.n(a.r(imageView.getDrawable()).mutate(), i2);
                imageView.invalidate();
            }
        }
    }

    static boolean c(String string, Context context2) {
        try {
            return obj1.enabled;
            string = null;
            return string;
        }
    }

    static e0 d(Context context, int i2) {
        a0.a obj2 = new a0.a(context.getResources().getDimensionPixelOffset(i2), 0);
        return obj2;
    }

    static void e(View view, boolean z2) {
        int i;
        int i2;
        final int i5 = 8;
        i2 = z2 ? i : i5;
        view.findViewById(f.j).setVisibility(i2);
        final View obj4 = view.findViewById(f.k);
        if (obj4 != null) {
            if (z2) {
            } else {
                i = i5;
            }
            obj4.setVisibility(i);
        }
    }
}
