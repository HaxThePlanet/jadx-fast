package androidx.core.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class SharedElementCallback {

    private static final String BUNDLE_SNAPSHOT_BITMAP = "sharedElement:snapshot:bitmap";
    private static final String BUNDLE_SNAPSHOT_IMAGE_MATRIX = "sharedElement:snapshot:imageMatrix";
    private static final String BUNDLE_SNAPSHOT_IMAGE_SCALETYPE = "sharedElement:snapshot:imageScaleType";
    private static final int MAX_IMAGE_SIZE = 1048576;
    private Matrix mTempMatrix;

    public interface OnSharedElementsReadyListener {
        public abstract void onSharedElementsReady();
    }
    private static Bitmap createDrawableBitmap(Drawable drawable) {
        int cmp;
        final int intrinsicWidth = drawable.getIntrinsicWidth();
        final int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth > 0) {
            if (intrinsicHeight <= 0) {
            } else {
                cmp = 1065353216;
                float f3 = Math.min(cmp, i4 /= f);
                if (drawable instanceof BitmapDrawable && Float.compare(f3, cmp) == 0) {
                    if (Float.compare(f3, cmp) == 0) {
                        return (BitmapDrawable)drawable.getBitmap();
                    }
                }
            }
            int i3 = (int)i2;
            int i7 = (int)i6;
            Bitmap bitmap2 = Bitmap.createBitmap(i3, i7, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap2);
            final android.graphics.Rect bounds = drawable.getBounds();
            final int i8 = 0;
            drawable.setBounds(i8, i8, i3, i7);
            drawable.draw(canvas);
            drawable.setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
            return bitmap2;
        }
        return null;
    }

    public Parcelable onCaptureSharedElementSnapshot(View sharedElement, Matrix viewToGlobalMatrix, RectF screenBounds) {
        boolean z;
        int bitmapWidth;
        Drawable drawable;
        int bitmapHeight;
        Drawable background;
        int bitmap;
        Bitmap drawableBitmap;
        Canvas canvas;
        Matrix mTempMatrix2;
        Matrix mTempMatrix;
        Object imageMatrix;
        int i;
        ImageView.ScaleType mATRIX;
        String str;
        z = sharedElement;
        drawable = (ImageView)z.getDrawable();
        drawableBitmap = SharedElementCallback.createDrawableBitmap(drawable);
        Bundle bundle = new Bundle();
        bundle.putParcelable("sharedElement:snapshot:bitmap", drawableBitmap);
        bundle.putString("sharedElement:snapshot:imageScaleType", z.getScaleType().toString());
        if (sharedElement instanceof ImageView != null && drawable != null && z.getBackground() == null && drawableBitmap != null && z.getScaleType() == ImageView.ScaleType.MATRIX) {
            z = sharedElement;
            drawable = (ImageView)z.getDrawable();
            if (drawable != null) {
                if (z.getBackground() == null) {
                    drawableBitmap = SharedElementCallback.createDrawableBitmap(drawable);
                    if (drawableBitmap != null) {
                        bundle = new Bundle();
                        bundle.putParcelable("sharedElement:snapshot:bitmap", drawableBitmap);
                        bundle.putString("sharedElement:snapshot:imageScaleType", z.getScaleType().toString());
                        if (z.getScaleType() == ImageView.ScaleType.MATRIX) {
                            mATRIX = new float[9];
                            z.getImageMatrix().getValues(mATRIX);
                            bundle.putFloatArray("sharedElement:snapshot:imageMatrix", mATRIX);
                        }
                        return bundle;
                    }
                }
            }
        }
        bitmapWidth = Math.round(screenBounds.width());
        bitmapHeight = Math.round(screenBounds.height());
        bitmap = 0;
        drawableBitmap = Math.min(1065353216, i4 /= f);
        if (bitmapWidth > 0 && bitmapHeight > 0 && this.mTempMatrix == null) {
            if (bitmapHeight > 0) {
                drawableBitmap = Math.min(1065353216, i4 /= f);
                if (this.mTempMatrix == null) {
                    mTempMatrix2 = new Matrix();
                    this.mTempMatrix = mTempMatrix2;
                }
                this.mTempMatrix.set(viewToGlobalMatrix);
                this.mTempMatrix.postTranslate(-left, -top);
                this.mTempMatrix.postScale(drawableBitmap, drawableBitmap);
                canvas = new Canvas(Bitmap.createBitmap((int)i6, (int)i7, Bitmap.Config.ARGB_8888));
                canvas.concat(this.mTempMatrix);
                sharedElement.draw(canvas);
            }
        }
        return bitmap;
    }

    public View onCreateSnapshotView(Context context, Parcelable snapshot) {
        int view;
        boolean bundle;
        Parcelable imageView;
        ImageView imageView2;
        ImageView.ScaleType floatArray;
        Object mATRIX;
        view = 0;
        if (snapshot instanceof Bundle != null) {
            bundle = snapshot;
            imageView = (Bundle)bundle.getParcelable("sharedElement:snapshot:bitmap");
            if ((Bitmap)imageView == null) {
                return null;
            }
            imageView2 = new ImageView(context);
            view = imageView2;
            imageView2.setImageBitmap((Bitmap)imageView);
            imageView2.setScaleType(ImageView.ScaleType.valueOf(bundle.getString("sharedElement:snapshot:imageScaleType")));
            if (imageView2.getScaleType() == ImageView.ScaleType.MATRIX) {
                mATRIX = new Matrix();
                mATRIX.setValues(bundle.getFloatArray("sharedElement:snapshot:imageMatrix"));
                imageView2.setImageMatrix(mATRIX);
            }
        } else {
            if (snapshot instanceof Bitmap != null) {
                imageView = new ImageView(context);
                imageView.setImageBitmap((Bitmap)snapshot);
            } else {
            }
        }
        return view;
    }

    public void onMapSharedElements(List<String> list, Map<String, View> map2) {
    }

    public void onRejectSharedElements(List<View> list) {
    }

    public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
    }

    public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
    }

    public void onSharedElementsArrived(List<String> list, List<View> list2, androidx.core.app.SharedElementCallback.OnSharedElementsReadyListener listener) {
        listener.onSharedElementsReady();
    }
}
