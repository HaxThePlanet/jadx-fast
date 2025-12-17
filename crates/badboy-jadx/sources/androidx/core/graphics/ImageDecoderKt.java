package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder.ImageInfo;
import android.graphics.ImageDecoder.Source;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u00020\u0001*\u00020\u00022C\u0008\u0004\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0002\u0008\u000cH\u0087\u0008\u001aR\u0010\r\u001a\u00020\u000e*\u00020\u00022C\u0008\u0004\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0002\u0008\u000cH\u0087\u0008¨\u0006\u000f", d2 = {"decodeBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/ImageDecoder$Source;", "action", "Lkotlin/Function3;", "Landroid/graphics/ImageDecoder;", "Landroid/graphics/ImageDecoder$ImageInfo;", "Lkotlin/ParameterName;", "name", "info", "source", "", "Lkotlin/ExtensionFunctionType;", "decodeDrawable", "Landroid/graphics/drawable/Drawable;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ImageDecoderKt {
    public static final Bitmap decodeBitmap(ImageDecoder.Source $this$decodeBitmap, Function3<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> action) {
        final int i = 0;
        ImageDecoderKt.decodeBitmap.1 anon = new ImageDecoderKt.decodeBitmap.1(action);
        return ImageDecoder.decodeBitmap($this$decodeBitmap, (ImageDecoder.OnHeaderDecodedListener)anon);
    }

    public static final Drawable decodeDrawable(ImageDecoder.Source $this$decodeDrawable, Function3<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> action) {
        final int i = 0;
        ImageDecoderKt.decodeDrawable.1 anon = new ImageDecoderKt.decodeDrawable.1(action);
        return ImageDecoder.decodeDrawable($this$decodeDrawable, (ImageDecoder.OnHeaderDecodedListener)anon);
    }
}
