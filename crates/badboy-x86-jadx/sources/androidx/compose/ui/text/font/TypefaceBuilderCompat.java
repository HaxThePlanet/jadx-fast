package androidx.compose.ui.text.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.Typeface.Builder;
import android.graphics.fonts.FontVariationAxis;
import android.os.ParcelFileDescriptor;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.DensityKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0007J$\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0007J$\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0007J!\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0014*\u00020\u000c2\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0003¢\u0006\u0002\u0010\u0016¨\u0006\u0017", d2 = {"Landroidx/compose/ui/text/font/TypefaceBuilderCompat;", "", "()V", "createFromAssets", "Landroid/graphics/Typeface;", "assetManager", "Landroid/content/res/AssetManager;", "path", "", "context", "Landroid/content/Context;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "createFromFile", "file", "Ljava/io/File;", "createFromFileDescriptor", "fileDescriptor", "Landroid/os/ParcelFileDescriptor;", "toVariationSettings", "", "Landroid/graphics/fonts/FontVariationAxis;", "(Landroidx/compose/ui/text/font/FontVariation$Settings;Landroid/content/Context;)[Landroid/graphics/fonts/FontVariationAxis;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TypefaceBuilderCompat {

    public static final androidx.compose.ui.text.font.TypefaceBuilderCompat INSTANCE;
    static {
        TypefaceBuilderCompat typefaceBuilderCompat = new TypefaceBuilderCompat();
        TypefaceBuilderCompat.INSTANCE = typefaceBuilderCompat;
    }

    private final FontVariationAxis[] toVariationSettings(androidx.compose.ui.text.font.FontVariation.Settings $this$toVariationSettings, Context context) {
        androidx.compose.ui.unit.Density density;
        List settings;
        int index$iv$iv;
        Object obj;
        Object obj2;
        int i2;
        ArrayList list2;
        Object obj3;
        int i;
        FontVariationAxis fontVariationAxis;
        String axisName;
        List list;
        if (context != null) {
            density = AndroidDensity_androidKt.Density(context);
            settings = $this$toVariationSettings.getSettings();
            int i4 = 0;
            ArrayList arrayList = new ArrayList(settings.size());
            List list5 = settings;
            final int i7 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < list5.size()) {
                i2 = 0;
                obj3 = obj2;
                i = 0;
                fontVariationAxis = new FontVariationAxis((FontVariation.Setting)obj3.getAxisName(), obj3.toVariationValue(density));
                (Collection)arrayList.add(fontVariationAxis);
                index$iv$iv++;
                settings = list;
            }
            List $this$fastMap$iv = settings;
            int i5 = 0;
            return (FontVariationAxis[])(Collection)(List)arrayList.toArray(new FontVariationAxis[0]);
        } else {
            if ($this$toVariationSettings.getNeedsDensity$ui_text_release()) {
            } else {
                int i3 = 1065353216;
                density = DensityKt.Density(i3, i3);
            }
        }
        IllegalStateException density2 = new IllegalStateException("Required density, but not provided");
        throw density2;
    }

    public final Typeface createFromAssets(AssetManager assetManager, String path, Context context, androidx.compose.ui.text.font.FontVariation.Settings variationSettings) {
        if (context == null) {
            return null;
        }
        Typeface.Builder builder = new Typeface.Builder(assetManager, path);
        return builder.setFontVariationSettings(toVariationSettings(variationSettings, context)).build();
    }

    public final Typeface createFromFile(File file, Context context, androidx.compose.ui.text.font.FontVariation.Settings variationSettings) {
        if (context == null) {
            return null;
        }
        Typeface.Builder builder = new Typeface.Builder(file);
        return builder.setFontVariationSettings(toVariationSettings(variationSettings, context)).build();
    }

    public final Typeface createFromFileDescriptor(ParcelFileDescriptor fileDescriptor, Context context, androidx.compose.ui.text.font.FontVariation.Settings variationSettings) {
        if (context == null) {
            return null;
        }
        Typeface.Builder builder = new Typeface.Builder(fileDescriptor.getFileDescriptor());
        return builder.setFontVariationSettings(toVariationSettings(variationSettings, context)).build();
    }
}
