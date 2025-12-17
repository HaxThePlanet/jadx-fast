package androidx.compose.ui.text.font;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.File;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000b\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000e\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014\u001a\u0008\u0010\u0015\u001a\u00020\u0016H\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0017", d2 = {"Font", "Landroidx/compose/ui/text/font/Font;", "fileDescriptor", "Landroid/os/ParcelFileDescriptor;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "Font-Ej4NQ78", "(Landroid/os/ParcelFileDescriptor;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "file", "Ljava/io/File;", "(Ljava/io/File;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "path", "", "assetManager", "Landroid/content/res/AssetManager;", "Font-MuC2MFs", "(Ljava/lang/String;Landroid/content/res/AssetManager;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "generateAndroidFontKtForApiCompatibility", "", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidFontKt {
    public static final androidx.compose.ui.text.font.Font Font-Ej4NQ78(ParcelFileDescriptor fileDescriptor, androidx.compose.ui.text.font.FontWeight weight, int style, androidx.compose.ui.text.font.FontVariation.Settings variationSettings) {
        AndroidFileDescriptorFont androidFileDescriptorFont = new AndroidFileDescriptorFont(fileDescriptor, weight, style, variationSettings, 0);
        return (Font)androidFileDescriptorFont;
    }

    public static final androidx.compose.ui.text.font.Font Font-Ej4NQ78(File file, androidx.compose.ui.text.font.FontWeight weight, int style, androidx.compose.ui.text.font.FontVariation.Settings variationSettings) {
        AndroidFileFont androidFileFont = new AndroidFileFont(file, weight, style, variationSettings, 0);
        return (Font)androidFileFont;
    }

    public static androidx.compose.ui.text.font.Font Font-Ej4NQ78$default(ParcelFileDescriptor parcelFileDescriptor, androidx.compose.ui.text.font.FontWeight fontWeight2, int i3, androidx.compose.ui.text.font.FontVariation.Settings fontVariation$Settings4, int i5, Object object6) {
        androidx.compose.ui.text.font.FontWeight obj1;
        int obj2;
        androidx.compose.ui.text.font.FontVariation.Settings obj3;
        int obj4;
        if (i5 & 2 != 0) {
            obj1 = FontWeight.Companion.getNormal();
        }
        if (i5 & 4 != 0) {
            obj2 = FontStyle.Companion.getNormal-_-LCdwA();
        }
        if (i5 &= 8 != 0) {
            obj3 = FontVariation.INSTANCE.Settings-6EWAqTQ(obj1, obj2, new FontVariation.Setting[0]);
        }
        return AndroidFontKt.Font-Ej4NQ78(parcelFileDescriptor, obj1, obj2, obj3);
    }

    public static androidx.compose.ui.text.font.Font Font-Ej4NQ78$default(File file, androidx.compose.ui.text.font.FontWeight fontWeight2, int i3, androidx.compose.ui.text.font.FontVariation.Settings fontVariation$Settings4, int i5, Object object6) {
        androidx.compose.ui.text.font.FontWeight obj1;
        int obj2;
        androidx.compose.ui.text.font.FontVariation.Settings obj3;
        int obj4;
        if (i5 & 2 != 0) {
            obj1 = FontWeight.Companion.getNormal();
        }
        if (i5 & 4 != 0) {
            obj2 = FontStyle.Companion.getNormal-_-LCdwA();
        }
        if (i5 &= 8 != 0) {
            obj3 = FontVariation.INSTANCE.Settings-6EWAqTQ(obj1, obj2, new FontVariation.Setting[0]);
        }
        return AndroidFontKt.Font-Ej4NQ78(file, obj1, obj2, obj3);
    }

    public static final androidx.compose.ui.text.font.Font Font-MuC2MFs(String path, AssetManager assetManager, androidx.compose.ui.text.font.FontWeight weight, int style, androidx.compose.ui.text.font.FontVariation.Settings variationSettings) {
        AndroidAssetFont androidAssetFont = new AndroidAssetFont(assetManager, path, weight, style, variationSettings, 0);
        return (Font)androidAssetFont;
    }

    public static androidx.compose.ui.text.font.Font Font-MuC2MFs$default(String string, AssetManager assetManager2, androidx.compose.ui.text.font.FontWeight fontWeight3, int i4, androidx.compose.ui.text.font.FontVariation.Settings fontVariation$Settings5, int i6, Object object7) {
        androidx.compose.ui.text.font.FontWeight obj2;
        int obj3;
        androidx.compose.ui.text.font.FontVariation.Settings obj4;
        int obj5;
        if (i6 & 4 != 0) {
            obj2 = FontWeight.Companion.getNormal();
        }
        if (i6 & 8 != 0) {
            obj3 = FontStyle.Companion.getNormal-_-LCdwA();
        }
        if (i6 &= 16 != 0) {
            obj4 = FontVariation.INSTANCE.Settings-6EWAqTQ(obj2, obj3, new FontVariation.Setting[0]);
        }
        return AndroidFontKt.Font-MuC2MFs(string, assetManager2, obj2, obj3, obj4);
    }

    private static final void generateAndroidFontKtForApiCompatibility() {
    }
}
