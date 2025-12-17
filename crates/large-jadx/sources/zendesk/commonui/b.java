package zendesk.commonui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.squareup.picasso.e0;
import java.util.Locale;

/* loaded from: classes3.dex */
public class b {

    private static class a implements e0 {

        private final int a;
        private final int b;
        private final int c;
        a(int i, int i2, int i3) {
            super();
            this.a = i;
            this.c = i2;
            this.b = i3;
        }

        private RectF a(int i, int i2, int i3) {
            final float f = (float)i3;
            RectF rectF = new RectF(f, f, (float)obj3, (float)obj4);
            return rectF;
        }

        private Paint b(Bitmap bitmap) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            final Shader.TileMode cLAMP = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, cLAMP, cLAMP);
            paint.setShader(bitmapShader);
            return paint;
        }

        private Paint c() {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.c);
            return paint;
        }

        @Override // com.squareup.picasso.e0
        public String key() {
            Object[] arr = new Object[3];
            return String.format(Locale.US, "rounded-%s-%s-%s", Integer.valueOf(this.a), Integer.valueOf(this.c), Integer.valueOf(this.b));
        }

        @Override // com.squareup.picasso.e0
        public Bitmap transform(Bitmap bitmap) {
            int canvas;
            Paint paint;
            Path path;
            RectF rectF;
            float f2;
            float f;
            Path.Direction direction;
            if (this.b > 0) {
                canvas = new Canvas(bitmap);
                path = new Path();
                path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                int i = this.a;
                path.addRoundRect(a(bitmap.getWidth(), bitmap.getHeight(), this.b), (float)i, (float)i, Path.Direction.CW);
                canvas.drawPath(path, c());
            }
            Bitmap bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmap2);
            int i2 = this.a;
            canvas2.drawRoundRect(a(bitmap.getWidth(), bitmap.getHeight(), 0), (float)i2, (float)i2, b(bitmap));
            if (bitmap != bitmap2) {
                bitmap.recycle();
            }
            return bitmap2;
        }
    }
    public static e0 a(int i, int i2, int i3) {
        b.a aVar = new b.a(i, i2, i3);
        return aVar;
    }
}
