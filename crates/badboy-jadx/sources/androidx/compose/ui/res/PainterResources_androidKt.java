package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.graphics.vector.compat.XmlVectorParser_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0002\u001a1\u0010\n\u001a\u00020\u000b2\n\u0010\u000c\u001a\u00060\rR\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0001\u0010\u0008\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"errorMessage", "", "loadImageBitmapResource", "Landroidx/compose/ui/graphics/ImageBitmap;", "path", "", "res", "Landroid/content/res/Resources;", "id", "", "loadVectorResource", "Landroidx/compose/ui/graphics/vector/ImageVector;", "theme", "Landroid/content/res/Resources$Theme;", "changingConfigurations", "(Landroid/content/res/Resources$Theme;Landroid/content/res/Resources;IILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/ImageVector;", "painterResource", "Landroidx/compose/ui/graphics/painter/Painter;", "(ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PainterResources_androidKt {

    private static final String errorMessage = "Only VectorDrawables and rasterized asset types are supported ex. PNG, JPG, WEBP";
    private static final ImageBitmap loadImageBitmapResource(java.lang.CharSequence path, Resources res, int id) {
        return ImageResources_androidKt.imageResource(ImageBitmap.Companion, res, id);
    }

    private static final ImageVector loadVectorResource(Resources.Theme theme, Resources res, int id, int changingConfigurations, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        androidx.compose.ui.res.ImageVectorCache.ImageVectorEntry imageVectorEntry;
        Object consume;
        String equal;
        String str2;
        int i = 21855625;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(loadVectorResource)P(3,2,1)92@3720L7:PainterResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.ui.res.loadVectorResource (PainterResources.android.kt:91)");
        }
        int i2 = 6;
        int i3 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        Object this_$iv = consume;
        ImageVectorCache.Key key = new ImageVectorCache.Key(theme, id);
        if ((ImageVectorCache)this_$iv.get(key) == null) {
            consume = res.getXml(id);
            if (!Intrinsics.areEqual(XmlVectorParser_androidKt.seekToStartTag((XmlPullParser)consume).getName(), "vector")) {
            } else {
                this_$iv.set(key, VectorResources_androidKt.loadVectorResourceInner(theme, res, consume, changingConfigurations));
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Only VectorDrawables and rasterized asset types are supported ex. PNG, JPG, WEBP");
            throw illegalArgumentException;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return imageVectorEntry.getImageVector();
    }

    public static final Painter painterResource(int id, Composer $composer, int $changed) {
        int i2;
        Painter imageVector;
        boolean traceInProgress;
        String str;
        int i7;
        int changingConfigurations;
        int endsWith$default;
        int consume;
        int i4;
        int rememberedValue;
        int i3;
        boolean changed;
        int empty;
        Object $i$a$CachePainterResources_androidKt$painterResource$imageBitmap$1;
        BitmapPainter bitmapPainter;
        Object obj;
        int i8;
        int i5;
        int i6;
        int i;
        final int i15 = id;
        final Composer composer = $composer;
        final int i22 = $changed;
        int i9 = 473971343;
        ComposerKt.sourceInformationMarkerStart(composer, i9, "C(painterResource)58@2487L7,61@2609L7,63@2696L7:PainterResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i9, i22, -1, "androidx.compose.ui.res.painterResource (PainterResources.android.kt:57)");
        }
        int i13 = 6;
        int i16 = 0;
        int i19 = 2023513938;
        String str6 = "CC:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer, i19, str6);
        final Object consume2 = composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i14 = 6;
        int i17 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, i19, str6);
        composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalConfiguration());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Resources resources = (Context)consume2.getResources();
        endsWith$default = 6;
        int i23 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, i19, str6);
        ComposerKt.sourceInformationMarkerEnd(composer);
        android.util.TypedValue resolveResourcePath = (ResourceIdCache)composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalResourceIdCache()).resolveResourcePath(resources, i15);
        final java.lang.CharSequence string = resolveResourcePath.string;
        i2 = 1;
        rememberedValue = 0;
        if (string != null && StringsKt.endsWith$default(string, (CharSequence)".xml", rememberedValue, 2, 0) == i2) {
            i7 = StringsKt.endsWith$default(string, (CharSequence)".xml", rememberedValue, 2, 0) == i2 ? i2 : rememberedValue;
        } else {
        }
        if (i7 != 0) {
            composer.startReplaceGroup(-803040357);
            ComposerKt.sourceInformation(composer, "69@2937L72,70@3018L34");
            imageVector = VectorPainterKt.rememberVectorPainter(PainterResources_androidKt.loadVectorResource(consume2.getTheme(), resources, i15, resolveResourcePath.changingConfigurations, composer, i20 &= 896), composer, rememberedValue);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-802884675);
            ComposerKt.sourceInformation(composer, "73@3138L96");
            ComposerKt.sourceInformationMarkerStart(composer, -1411370574, "CC(remember):PainterResources.android.kt#9igjgp");
            empty = 4;
            if (i24 ^= 6 > empty) {
                if (!composer.changed(i15)) {
                    if (i22 & 6 == empty) {
                    } else {
                        i2 = rememberedValue;
                    }
                } else {
                }
            } else {
            }
            changingConfigurations = $composer;
            i4 = 0;
            rememberedValue = changingConfigurations.rememberedValue();
            i3 = 0;
            if (i11 |= changed2 == 0) {
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    int i25 = 0;
                    changingConfigurations.updateRememberedValue(PainterResources_androidKt.loadImageBitmapResource(string, resources, i15));
                } else {
                    $i$a$CachePainterResources_androidKt$painterResource$imageBitmap$1 = rememberedValue;
                }
            } else {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            bitmapPainter = new BitmapPainter((ImageBitmap)$i$a$CachePainterResources_androidKt$painterResource$imageBitmap$1, 0, obj17, 0, obj19, 6, 0);
            composer.endReplaceGroup();
            imageVector = bitmapPainter;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return imageVector;
    }
}
