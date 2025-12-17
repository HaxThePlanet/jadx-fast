package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmap.Companion;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0001\u0010\u0005\u001a\u00020\u0006\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0001\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\u0008", d2 = {"imageResource", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroidx/compose/ui/graphics/ImageBitmap$Companion;", "res", "Landroid/content/res/Resources;", "id", "", "(Landroidx/compose/ui/graphics/ImageBitmap$Companion;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/ImageBitmap;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ImageResources_androidKt {
    public static final ImageBitmap imageResource(ImageBitmap.Companion $this$imageResource, int id, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int empty;
        Object typedValue;
        Object $i$a$CacheImageResources_androidKt$imageResource$1;
        Resources resources;
        int i = -304919470;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(imageResource)53@2046L7,54@2070L25,57@2238L54:ImageResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.ui.res.imageResource (ImageResources.android.kt:52)");
        }
        int i2 = 6;
        int i5 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        Object this_$iv = consume;
        String str3 = "CC(remember):ImageResources.android.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, 552189435, str3);
        int i4 = 0;
        Composer composer = $composer;
        int i7 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i11 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            empty = 0;
            typedValue = new TypedValue();
            composer.updateRememberedValue(typedValue);
        } else {
            typedValue = rememberedValue;
        }
        TypedValue invalid$iv = typedValue;
        ComposerKt.sourceInformationMarkerEnd($composer);
        (Context)this_$iv.getResources().getValue(id, (TypedValue)invalid$iv, true);
        java.lang.CharSequence string = invalid$iv.string;
        Intrinsics.checkNotNull(string);
        ComposerKt.sourceInformationMarkerStart($composer, 552194840, str3);
        Composer composer2 = $composer;
        int i10 = 0;
        Object rememberedValue2 = composer2.rememberedValue();
        int i12 = 0;
        if (!$composer.changed(string.toString())) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                int i13 = 0;
                composer2.updateRememberedValue(ImageResources_androidKt.imageResource($this$imageResource, this_$iv.getResources(), id));
            } else {
                $i$a$CacheImageResources_androidKt$imageResource$1 = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (ImageBitmap)$i$a$CacheImageResources_androidKt$imageResource$1;
    }

    public static final ImageBitmap imageResource(ImageBitmap.Companion $this$imageResource, Resources res, int id) {
        android.graphics.drawable.Drawable drawable = res.getDrawable(id, 0);
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        return AndroidImageBitmap_androidKt.asImageBitmap((BitmapDrawable)drawable.getBitmap());
    }
}
