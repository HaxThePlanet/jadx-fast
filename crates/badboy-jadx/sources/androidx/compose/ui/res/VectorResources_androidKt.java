package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import android.util.Xml;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.ImageVector.Builder;
import androidx.compose.ui.graphics.vector.ImageVector.Companion;
import androidx.compose.ui.graphics.vector.compat.AndroidVectorParser;
import androidx.compose.ui.graphics.vector.compat.XmlVectorParser_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a0\u0010\u0000\u001a\u00020\u00012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0018\u00010\u0003R\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0000\u001a*\u0010\n\u001a\u00020\u000b*\u00020\u000c2\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0018\u00010\u0003R\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\t\u001a\u001b\u0010\n\u001a\u00020\u000b*\u00020\u000c2\u0008\u0008\u0001\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010", d2 = {"loadVectorResourceInner", "Landroidx/compose/ui/res/ImageVectorCache$ImageVectorEntry;", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "res", "parser", "Landroid/content/res/XmlResourceParser;", "changingConfigurations", "", "vectorResource", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Landroidx/compose/ui/graphics/vector/ImageVector$Companion;", "resId", "id", "(Landroidx/compose/ui/graphics/vector/ImageVector$Companion;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/ImageVector;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class VectorResources_androidKt {
    public static final androidx.compose.ui.res.ImageVectorCache.ImageVectorEntry loadVectorResourceInner(Resources.Theme theme, Resources res, XmlResourceParser parser, int changingConfigurations) throws XmlPullParserException {
        int atEnd;
        int i2;
        int i;
        int nestedGroups;
        final android.util.AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)parser);
        AndroidVectorParser androidVectorParser = new AndroidVectorParser((XmlPullParser)parser, 0, 2, 0);
        ImageVector.Builder vectorImageBuilder = XmlVectorParser_androidKt.createVectorImageBuilder(androidVectorParser, res, theme, attributeSet);
        nestedGroups = atEnd;
        while (XmlVectorParser_androidKt.isAtEnd((XmlPullParser)parser) == 0) {
            nestedGroups = XmlVectorParser_androidKt.parseCurrentVectorNode(androidVectorParser, res, attributeSet, theme, vectorImageBuilder, nestedGroups);
            parser.next();
        }
        Resources.Theme theme2 = theme;
        Resources resources = res;
        ImageVectorCache.ImageVectorEntry obj7 = new ImageVectorCache.ImageVectorEntry(vectorImageBuilder.build(), changingConfigurations);
        return obj7;
    }

    public static androidx.compose.ui.res.ImageVectorCache.ImageVectorEntry loadVectorResourceInner$default(Resources.Theme resources$Theme, Resources resources2, XmlResourceParser xmlResourceParser3, int i4, int i5, Object object6) throws XmlPullParserException {
        int obj0;
        if (i5 &= 1 != 0) {
            obj0 = 0;
        }
        return VectorResources_androidKt.loadVectorResourceInner(obj0, resources2, xmlResourceParser3, i4);
    }

    public static final ImageVector vectorResource(ImageVector.Companion $this$vectorResource, int id, Composer $composer, int $changed) {
        boolean traceInProgress;
        int i;
        String str;
        boolean changed;
        Object $i$a$CacheVectorResources_androidKt$vectorResource$1;
        Object empty;
        int i2 = 44534090;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(vectorResource)48@1967L7,49@1989L11,52@2043L90:VectorResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.ui.res.vectorResource (VectorResources.android.kt:47)");
        }
        int i3 = 6;
        int i7 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        Resources resources = Resources_androidKt.resources($composer, 0);
        Resources.Theme theme = (Context)$composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalContext()).getTheme();
        ComposerKt.sourceInformationMarkerStart($composer, -1769560526, "CC(remember):VectorResources.android.kt#9igjgp");
        int i12 = 32;
        if (i10 ^= 48 > i12) {
            if (!$composer.changed(id)) {
                if ($changed & 48 == i12) {
                    i = 1;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i11 = 0;
        Object rememberedValue = composer.rememberedValue();
        final int i13 = 0;
        if (i5 |= changed2 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i14 = 0;
                composer.updateRememberedValue(VectorResources_androidKt.vectorResource($this$vectorResource, theme, resources, id));
            } else {
                $i$a$CacheVectorResources_androidKt$vectorResource$1 = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (ImageVector)$i$a$CacheVectorResources_androidKt$vectorResource$1;
    }

    public static final ImageVector vectorResource(ImageVector.Companion $this$vectorResource, Resources.Theme theme, Resources res, int resId) throws XmlPullParserException {
        TypedValue typedValue = new TypedValue();
        res.getValue(resId, typedValue, true);
        XmlResourceParser xml = res.getXml(resId);
        final int i2 = 0;
        XmlVectorParser_androidKt.seekToStartTag((XmlPullParser)xml);
        Unit $this$vectorResource_u24lambda_u241 = Unit.INSTANCE;
        return VectorResources_androidKt.loadVectorResourceInner(theme, res, xml, typedValue.changingConfigurations).getImageVector();
    }

    public static ImageVector vectorResource$default(ImageVector.Companion imageVector$Companion, Resources.Theme resources$Theme2, Resources resources3, int i4, int i5, Object object6) throws XmlPullParserException {
        int obj1;
        if (i5 &= 1 != 0) {
            obj1 = 0;
        }
        return VectorResources_androidKt.vectorResource(companion, obj1, resources3, i4);
    }
}
