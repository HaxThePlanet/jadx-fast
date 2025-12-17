package zendesk.support;

import android.content.Context;
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
import android.os.Build.VERSION;
import android.renderscript.Allocation;
import android.renderscript.Allocation.MipmapControl;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.squareup.picasso.e0;
import java.util.Locale;

/* loaded from: classes3.dex */
public class PicassoTransformations {

    private static class BlurTransformation implements e0 {

        private final RenderScript rs;
        BlurTransformation(Context context) {
            super();
            this.rs = RenderScript.create(context);
        }

        @Override // com.squareup.picasso.e0
        public String key() {
            return "blur";
        }

        @Override // com.squareup.picasso.e0
        public Bitmap transform(Bitmap bitmap) {
            Allocation fromBitmap;
            Throwable th4;
            int mIPMAP_FULL;
            Allocation.MipmapControl mIPMAP_FULL2;
            Throwable th;
            Throwable th2;
            int sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 17) {
                mIPMAP_FULL = 1;
                Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, mIPMAP_FULL);
                RenderScript renderScript4 = this.rs;
                ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript4, Element.U8_4(renderScript4));
                int i4 = 0;
                if (sDK_INT >= 18) {
                    fromBitmap = Allocation.createFromBitmap(this.rs, copy, Allocation.MipmapControl.MIPMAP_FULL, 128);
                } else {
                    fromBitmap = Allocation.createFromBitmap(this.rs, copy, Allocation.MipmapControl.MIPMAP_FULL, mIPMAP_FULL);
                }
                Allocation typed = Allocation.createTyped(this.rs, fromBitmap.getType());
                create.setInput(fromBitmap);
                create.setRadius(1103626240);
                create.forEach(typed);
                typed.copyTo(copy);
                bitmap.recycle();
                this.rs.destroy();
                create.destroy();
                if (fromBitmap != null) {
                    fromBitmap.destroy();
                }
                if (typed != null) {
                    typed.destroy();
                }
                return copy;
            }
            return bitmap;
        }
    }

    private static class RoundedTransformation implements e0 {

        private final int radius;
        private final int strokeColor;
        private final int strokeWidth;
        RoundedTransformation(int i) {
            super(i, 0, -1);
        }

        RoundedTransformation(int i, int i2, int i3) {
            super();
            this.radius = i;
            this.strokeColor = i2;
            this.strokeWidth = i3;
        }

        private RectF getMask(int i, int i2, int i3) {
            final float f = (float)i3;
            RectF rectF = new RectF(f, f, (float)obj3, (float)obj4);
            return rectF;
        }

        private Paint shapePaint(Bitmap bitmap) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            final Shader.TileMode cLAMP = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, cLAMP, cLAMP);
            paint.setShader(bitmapShader);
            return paint;
        }

        private Paint strokePaint() {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.strokeColor);
            return paint;
        }

        @Override // com.squareup.picasso.e0
        public String key() {
            Object[] arr = new Object[3];
            return String.format(Locale.US, "rounded-%s-%s-%s", Integer.valueOf(this.radius), Integer.valueOf(this.strokeColor), Integer.valueOf(this.strokeWidth));
        }

        @Override // com.squareup.picasso.e0
        public Bitmap transform(Bitmap bitmap) {
            int strokeWidth;
            boolean mutable;
            Paint strokePaint;
            Path path;
            RectF mask;
            float f2;
            float f;
            Path.Direction direction;
            Bitmap obj8;
            mutable = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            if (this.strokeWidth > 0 && !bitmap.isMutable() && mutable != bitmap) {
                if (!bitmap.isMutable()) {
                    mutable = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                    if (mutable != bitmap) {
                        bitmap.recycle();
                    }
                    obj8 = mutable;
                }
                strokeWidth = new Canvas(obj8);
                path = new Path();
                path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                int radius2 = this.radius;
                path.addRoundRect(getMask(obj8.getWidth(), obj8.getHeight(), this.strokeWidth), (float)radius2, (float)radius2, Path.Direction.CW);
                strokeWidth.drawPath(path, strokePaint());
            }
            Bitmap bitmap2 = Bitmap.createBitmap(obj8.getWidth(), obj8.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap2);
            int radius = this.radius;
            canvas.drawRoundRect(getMask(obj8.getWidth(), obj8.getHeight(), 0), (float)radius, (float)radius, shapePaint(obj8));
            if (obj8 != bitmap2) {
                obj8.recycle();
            }
            return bitmap2;
        }
    }
    public static e0 getBlurTransformation(Context context) {
        PicassoTransformations.BlurTransformation blurTransformation = new PicassoTransformations.BlurTransformation(context);
        return blurTransformation;
    }

    public static e0 getRoundWithBorderTransformation(int i, int i2, int i3) {
        PicassoTransformations.RoundedTransformation roundedTransformation = new PicassoTransformations.RoundedTransformation(i, i2, i3);
        return roundedTransformation;
    }

    public static e0 getRoundedTransformation(int i) {
        PicassoTransformations.RoundedTransformation roundedTransformation = new PicassoTransformations.RoundedTransformation(i);
        return roundedTransformation;
    }
}
