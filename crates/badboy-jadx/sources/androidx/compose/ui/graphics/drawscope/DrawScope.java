package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadius.Companion;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendMode.Companion;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.FilterQuality.Companion;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeCap.Companion;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@DrawScopeMarker
@Metadata(d1 = "\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008g\u0018\u0000 u2\u00020\u0001:\u0001uJp\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#Jp\u0010\u0011\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\u0008&\u0010'JX\u0010(\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010)\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+JX\u0010(\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010)\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-JN\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00032\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\u00081\u00102Jl\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\u0008\u0008\u0002\u00103\u001a\u0002042\u0008\u0008\u0002\u00105\u001a\u0002062\u0008\u0008\u0002\u00107\u001a\u0002042\u0008\u0008\u0002\u00108\u001a\u0002062\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H'ø\u0001\u0000¢\u0006\u0004\u00089\u0010:Jv\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u0002002\u0008\u0008\u0002\u00103\u001a\u0002042\u0008\u0008\u0002\u00105\u001a\u0002062\u0008\u0008\u0002\u00107\u001a\u0002042\u0008\u0008\u0002\u00108\u001a\u0002062\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010;\u001a\u00020<H\u0016ø\u0001\u0000¢\u0006\u0004\u0008=\u0010>Jj\u0010?\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00032\u0008\u0008\u0002\u0010B\u001a\u00020\u00162\u0008\u0008\u0002\u0010C\u001a\u00020D2\n\u0008\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\u0008G\u0010HJj\u0010?\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00032\u0008\u0008\u0002\u0010B\u001a\u00020\u00162\u0008\u0008\u0002\u0010C\u001a\u00020D2\n\u0008\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\u0008I\u0010JJX\u0010K\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\u0008L\u0010MJX\u0010K\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\u0008N\u0010OJL\u0010P\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\u0008S\u0010TJL\u0010P\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020R2\u0006\u0010$\u001a\u00020%2\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\u0008U\u0010VJp\u0010W\u001a\u00020\u00122\u000c\u0010X\u001a\u0008\u0012\u0004\u0012\u00020\u00030Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010B\u001a\u00020\u00162\u0008\u0008\u0002\u0010C\u001a\u00020D2\n\u0008\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\u0008\\\u0010]Jp\u0010W\u001a\u00020\u00122\u000c\u0010X\u001a\u0008\u0012\u0004\u0012\u00020\u00030Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010B\u001a\u00020\u00162\u0008\u0008\u0002\u0010C\u001a\u00020D2\n\u0008\u0002\u0010E\u001a\u0004\u0018\u00010F2\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\u0008^\u0010_JX\u0010`\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\u0008a\u0010MJX\u0010`\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\u0008b\u0010OJb\u0010c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010d\u001a\u00020e2\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\u0008f\u0010gJb\u0010c\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010d\u001a\u00020e2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0003\u0010\u001b\u001a\u00020\u00162\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\u0008h\u0010iJ\u001e\u0010j\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010k\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\u0008l\u0010mJ9\u0010n\u001a\u00020\u0012*\u00020o2\u0008\u0008\u0002\u0010\u000e\u001a\u0002062\u0017\u0010p\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120q¢\u0006\u0002\u0008rH\u0016ø\u0001\u0000¢\u0006\u0004\u0008s\u0010tR\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006vÀ\u0006\u0003", d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/unit/Density;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "drawArc", "", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "", "sweepAngle", "useCenter", "", "topLeft", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "offsetSize", "offset", "offsetSize-PENXr5M", "(JJ)J", "record", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "record-JVtK1S4", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;JLkotlin/jvm/functions/Function1;)V", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DrawScope extends Density {

    public static final androidx.compose.ui.graphics.drawscope.DrawScope.Companion Companion;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\n\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000b", d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;", "", "()V", "DefaultBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getDefaultBlendMode-0nO6VwU", "()I", "I", "DefaultFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getDefaultFilterQuality-f-v9h1I", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.graphics.drawscope.DrawScope.Companion $$INSTANCE;
        private static final int DefaultBlendMode;
        private static final int DefaultFilterQuality;
        static {
            DrawScope.Companion companion = new DrawScope.Companion();
            DrawScope.Companion.$$INSTANCE = companion;
            DrawScope.Companion.DefaultBlendMode = BlendMode.Companion.getSrcOver-0nO6VwU();
            DrawScope.Companion.DefaultFilterQuality = FilterQuality.Companion.getLow-f-v9h1I();
        }

        public final int getDefaultBlendMode-0nO6VwU() {
            return DrawScope.Companion.DefaultBlendMode;
        }

        public final int getDefaultFilterQuality-f-v9h1I() {
            return DrawScope.Companion.DefaultFilterQuality;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void drawArc-illE91I$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, Brush brush2, float f3, float f4, boolean z5, long l6, long l7, float f8, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle9, ColorFilter colorFilter10, int i11, int i12, Object object13) {
            DrawScope.drawArc-illE91I$default(drawScope, brush2, f3, f4, z5, l6, l7, f8, drawStyle9, colorFilter10, i11, i12, object13);
        }

        public static void drawArc-yD3GUKo$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, long l2, float f3, float f4, boolean z5, long l6, long l7, float f8, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle9, ColorFilter colorFilter10, int i11, int i12, Object object13) {
            DrawScope.drawArc-yD3GUKo$default(drawScope, l2, f3, f4, z5, l6, l7, f8, drawStyle9, colorFilter10, i11, i12, object13);
        }

        public static void drawCircle-V9BoPsw$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, Brush brush2, float f3, long l4, float f5, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle6, ColorFilter colorFilter7, int i8, int i9, Object object10) {
            DrawScope.drawCircle-V9BoPsw$default(drawScope, brush2, f3, l4, f5, drawStyle6, colorFilter7, i8, i9, object10);
        }

        public static void drawCircle-VaOC9Bg$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, long l2, float f3, long l4, float f5, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle6, ColorFilter colorFilter7, int i8, int i9, Object object10) {
            DrawScope.drawCircle-VaOC9Bg$default(drawScope, l2, f3, l4, f5, drawStyle6, colorFilter7, i8, i9, object10);
        }

        public static void drawImage-9jGpkUE$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, ImageBitmap imageBitmap2, long l3, long l4, long l5, long l6, float f7, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle8, ColorFilter colorFilter9, int i10, int i11, Object object12) {
            DrawScope.drawImage-9jGpkUE$default(drawScope, imageBitmap2, l3, l4, l5, l6, f7, drawStyle8, colorFilter9, i10, i11, object12);
        }

        @Deprecated
        public static void drawImage-AZ2fEMs(androidx.compose.ui.graphics.drawscope.DrawScope $this, ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
            DrawScope.access$drawImage-AZ2fEMs$jd($this, image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, filterQuality);
        }

        public static void drawImage-AZ2fEMs$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, ImageBitmap imageBitmap2, long l3, long l4, long l5, long l6, float f7, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle8, ColorFilter colorFilter9, int i10, int i11, int i12, Object object13) {
            DrawScope.drawImage-AZ2fEMs$default(drawScope, imageBitmap2, l3, l4, l5, l6, f7, drawStyle8, colorFilter9, i10, i11, i12, object13);
        }

        public static void drawImage-gbVJVH8$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, ImageBitmap imageBitmap2, long l3, float f4, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle5, ColorFilter colorFilter6, int i7, int i8, Object object9) {
            DrawScope.drawImage-gbVJVH8$default(drawScope, imageBitmap2, l3, f4, drawStyle5, colorFilter6, i7, i8, object9);
        }

        public static void drawLine-1RTmtNc$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, Brush brush2, long l3, long l4, float f5, int i6, PathEffect pathEffect7, float f8, ColorFilter colorFilter9, int i10, int i11, Object object12) {
            DrawScope.drawLine-1RTmtNc$default(drawScope, brush2, l3, l4, f5, i6, pathEffect7, f8, colorFilter9, i10, i11, object12);
        }

        public static void drawLine-NGM6Ib0$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, long l2, long l3, long l4, float f5, int i6, PathEffect pathEffect7, float f8, ColorFilter colorFilter9, int i10, int i11, Object object12) {
            DrawScope.drawLine-NGM6Ib0$default(drawScope, l2, l3, l4, f5, i6, pathEffect7, f8, colorFilter9, i10, i11, object12);
        }

        public static void drawOval-AsUm42w$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, Brush brush2, long l3, long l4, float f5, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle6, ColorFilter colorFilter7, int i8, int i9, Object object10) {
            DrawScope.drawOval-AsUm42w$default(drawScope, brush2, l3, l4, f5, drawStyle6, colorFilter7, i8, i9, object10);
        }

        public static void drawOval-n-J9OG0$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, long l2, long l3, long l4, float f5, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle6, ColorFilter colorFilter7, int i8, int i9, Object object10) {
            DrawScope.drawOval-n-J9OG0$default(drawScope, l2, l3, l4, f5, drawStyle6, colorFilter7, i8, i9, object10);
        }

        public static void drawPath-GBMwjPU$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, Path path2, Brush brush3, float f4, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle5, ColorFilter colorFilter6, int i7, int i8, Object object9) {
            DrawScope.drawPath-GBMwjPU$default(drawScope, path2, brush3, f4, drawStyle5, colorFilter6, i7, i8, object9);
        }

        public static void drawPath-LG529CI$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, Path path2, long l3, float f4, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle5, ColorFilter colorFilter6, int i7, int i8, Object object9) {
            DrawScope.drawPath-LG529CI$default(drawScope, path2, l3, f4, drawStyle5, colorFilter6, i7, i8, object9);
        }

        public static void drawPoints-F8ZwMP8$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, List list2, int i3, long l4, float f5, int i6, PathEffect pathEffect7, float f8, ColorFilter colorFilter9, int i10, int i11, Object object12) {
            DrawScope.drawPoints-F8ZwMP8$default(drawScope, list2, i3, l4, f5, i6, pathEffect7, f8, colorFilter9, i10, i11, object12);
        }

        public static void drawPoints-Gsft0Ws$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, List list2, int i3, Brush brush4, float f5, int i6, PathEffect pathEffect7, float f8, ColorFilter colorFilter9, int i10, int i11, Object object12) {
            DrawScope.drawPoints-Gsft0Ws$default(drawScope, list2, i3, brush4, f5, i6, pathEffect7, f8, colorFilter9, i10, i11, object12);
        }

        public static void drawRect-AsUm42w$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, Brush brush2, long l3, long l4, float f5, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle6, ColorFilter colorFilter7, int i8, int i9, Object object10) {
            DrawScope.drawRect-AsUm42w$default(drawScope, brush2, l3, l4, f5, drawStyle6, colorFilter7, i8, i9, object10);
        }

        public static void drawRect-n-J9OG0$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, long l2, long l3, long l4, float f5, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle6, ColorFilter colorFilter7, int i8, int i9, Object object10) {
            DrawScope.drawRect-n-J9OG0$default(drawScope, l2, l3, l4, f5, drawStyle6, colorFilter7, i8, i9, object10);
        }

        public static void drawRoundRect-ZuiqVtQ$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, Brush brush2, long l3, long l4, long l5, float f6, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle7, ColorFilter colorFilter8, int i9, int i10, Object object11) {
            DrawScope.drawRoundRect-ZuiqVtQ$default(drawScope, brush2, l3, l4, l5, f6, drawStyle7, colorFilter8, i9, i10, object11);
        }

        public static void drawRoundRect-u-Aw5IA$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, long l2, long l3, long l4, long l5, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle6, float f7, ColorFilter colorFilter8, int i9, int i10, Object object11) {
            DrawScope.drawRoundRect-u-Aw5IA$default(drawScope, l2, l3, l4, l5, drawStyle6, f7, colorFilter8, i9, i10, object11);
        }

        @Deprecated
        public static long getCenter-F1C5BW0(androidx.compose.ui.graphics.drawscope.DrawScope $this) {
            return DrawScope.access$getCenter-F1C5BW0$jd($this);
        }

        @Deprecated
        public static long getSize-NH-jbRc(androidx.compose.ui.graphics.drawscope.DrawScope $this) {
            return DrawScope.access$getSize-NH-jbRc$jd($this);
        }

        @Deprecated
        public static void record-JVtK1S4(androidx.compose.ui.graphics.drawscope.DrawScope $this, GraphicsLayer $receiver, long size, Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, Unit> block) {
            DrawScope.access$record-JVtK1S4$jd($this, $receiver, size, block);
        }

        public static void record-JVtK1S4$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, GraphicsLayer graphicsLayer2, long l3, Function1 function14, int i5, Object object6) {
            DrawScope.record-JVtK1S4$default(drawScope, graphicsLayer2, l3, function14, i5, object6);
        }

        @Deprecated
        public static int roundToPx--R2X_6o(androidx.compose.ui.graphics.drawscope.DrawScope $this, long $receiver) {
            return DrawScope.access$roundToPx--R2X_6o$jd($this, $receiver);
        }

        @Deprecated
        public static int roundToPx-0680j_4(androidx.compose.ui.graphics.drawscope.DrawScope $this, float $receiver) {
            return DrawScope.access$roundToPx-0680j_4$jd($this, $receiver);
        }

        @Deprecated
        public static float toDp-GaN1DYA(androidx.compose.ui.graphics.drawscope.DrawScope $this, long $receiver) {
            return DrawScope.access$toDp-GaN1DYA$jd($this, $receiver);
        }

        @Deprecated
        public static float toDp-u2uoSUM(androidx.compose.ui.graphics.drawscope.DrawScope $this, float $receiver) {
            return DrawScope.access$toDp-u2uoSUM$jd($this, $receiver);
        }

        @Deprecated
        public static float toDp-u2uoSUM(androidx.compose.ui.graphics.drawscope.DrawScope $this, int $receiver) {
            return DrawScope.access$toDp-u2uoSUM$jd($this, $receiver);
        }

        @Deprecated
        public static long toDpSize-k-rfVVM(androidx.compose.ui.graphics.drawscope.DrawScope $this, long $receiver) {
            return DrawScope.access$toDpSize-k-rfVVM$jd($this, $receiver);
        }

        @Deprecated
        public static float toPx--R2X_6o(androidx.compose.ui.graphics.drawscope.DrawScope $this, long $receiver) {
            return DrawScope.access$toPx--R2X_6o$jd($this, $receiver);
        }

        @Deprecated
        public static float toPx-0680j_4(androidx.compose.ui.graphics.drawscope.DrawScope $this, float $receiver) {
            return DrawScope.access$toPx-0680j_4$jd($this, $receiver);
        }

        @Deprecated
        public static Rect toRect(androidx.compose.ui.graphics.drawscope.DrawScope $this, DpRect $receiver) {
            return DrawScope.access$toRect$jd($this, $receiver);
        }

        @Deprecated
        public static long toSize-XkaWNTQ(androidx.compose.ui.graphics.drawscope.DrawScope $this, long $receiver) {
            return DrawScope.access$toSize-XkaWNTQ$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-0xMU5do(androidx.compose.ui.graphics.drawscope.DrawScope $this, float $receiver) {
            return DrawScope.access$toSp-0xMU5do$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-kPz2Gy4(androidx.compose.ui.graphics.drawscope.DrawScope $this, float $receiver) {
            return DrawScope.access$toSp-kPz2Gy4$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-kPz2Gy4(androidx.compose.ui.graphics.drawscope.DrawScope $this, int $receiver) {
            return DrawScope.access$toSp-kPz2Gy4$jd($this, $receiver);
        }
    }
    static {
        DrawScope.Companion = DrawScope.Companion.$$INSTANCE;
    }

    public static void access$drawImage-AZ2fEMs$jd(androidx.compose.ui.graphics.drawscope.DrawScope $this, ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
        super.drawImage-AZ2fEMs(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, filterQuality);
    }

    public static long access$getCenter-F1C5BW0$jd(androidx.compose.ui.graphics.drawscope.DrawScope $this) {
        return super.getCenter-F1C5BW0();
    }

    public static long access$getSize-NH-jbRc$jd(androidx.compose.ui.graphics.drawscope.DrawScope $this) {
        return super.getSize-NH-jbRc();
    }

    public static void access$record-JVtK1S4$jd(androidx.compose.ui.graphics.drawscope.DrawScope $this, GraphicsLayer $receiver, long size, Function1 block) {
        super.record-JVtK1S4($receiver, size, block);
    }

    public static int access$roundToPx--R2X_6o$jd(androidx.compose.ui.graphics.drawscope.DrawScope $this, long $receiver) {
        return super.roundToPx--R2X_6o($receiver);
    }

    public static int access$roundToPx-0680j_4$jd(androidx.compose.ui.graphics.drawscope.DrawScope $this, float $receiver) {
        return super.roundToPx-0680j_4($receiver);
    }

    public static float access$toDp-GaN1DYA$jd(androidx.compose.ui.graphics.drawscope.DrawScope $this, long $receiver) {
        return super.toDp-GaN1DYA($receiver);
    }

    public static float access$toDp-u2uoSUM$jd(androidx.compose.ui.graphics.drawscope.DrawScope $this, float $receiver) {
        return super.toDp-u2uoSUM($receiver);
    }

    public static float access$toDp-u2uoSUM$jd(androidx.compose.ui.graphics.drawscope.DrawScope $this, int $receiver) {
        return super.toDp-u2uoSUM($receiver);
    }

    public static long access$toDpSize-k-rfVVM$jd(androidx.compose.ui.graphics.drawscope.DrawScope $this, long $receiver) {
        return super.toDpSize-k-rfVVM($receiver);
    }

    public static float access$toPx--R2X_6o$jd(androidx.compose.ui.graphics.drawscope.DrawScope $this, long $receiver) {
        return super.toPx--R2X_6o($receiver);
    }

    public static float access$toPx-0680j_4$jd(androidx.compose.ui.graphics.drawscope.DrawScope $this, float $receiver) {
        return super.toPx-0680j_4($receiver);
    }

    public static Rect access$toRect$jd(androidx.compose.ui.graphics.drawscope.DrawScope $this, DpRect $receiver) {
        return super.toRect($receiver);
    }

    public static long access$toSize-XkaWNTQ$jd(androidx.compose.ui.graphics.drawscope.DrawScope $this, long $receiver) {
        return super.toSize-XkaWNTQ($receiver);
    }

    public static long access$toSp-0xMU5do$jd(androidx.compose.ui.graphics.drawscope.DrawScope $this, float $receiver) {
        return super.toSp-0xMU5do($receiver);
    }

    public static long access$toSp-kPz2Gy4$jd(androidx.compose.ui.graphics.drawscope.DrawScope $this, float $receiver) {
        return super.toSp-kPz2Gy4($receiver);
    }

    public static long access$toSp-kPz2Gy4$jd(androidx.compose.ui.graphics.drawscope.DrawScope $this, int $receiver) {
        return super.toSp-kPz2Gy4($receiver);
    }

    public static void drawArc-illE91I$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, Brush brush2, float f3, float f4, boolean z5, long l6, long l7, float f8, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle9, ColorFilter colorFilter10, int i11, int i12, Object object13) {
        int defaultBlendMode-0nO6VwU;
        int zero-F1C5BW0;
        int offsetSize-PENXr5M;
        int i3;
        androidx.compose.ui.graphics.drawscope.Fill iNSTANCE;
        int i4;
        Object obj;
        long l;
        long l2;
        int i5;
        androidx.compose.ui.graphics.drawscope.Fill fill;
        int i;
        int i2;
        int i6 = obj29;
        if (obj30 != null) {
        } else {
            if (i6 & 16 != 0) {
                l = zero-F1C5BW0;
            } else {
                l = l6;
            }
            if (i6 & 32 != 0) {
                l2 = offsetSize-PENXr5M;
            } else {
                obj = drawScope;
                l2 = f8;
            }
            i5 = i6 & 64 != 0 ? i3 : colorFilter10;
            if (i6 & 128 != 0) {
                fill = iNSTANCE;
            } else {
                fill = i11;
            }
            i = i6 & 256 != 0 ? i4 : i12;
            if (i6 &= 512 != 0) {
                i2 = defaultBlendMode-0nO6VwU;
            } else {
                i2 = object13;
            }
            obj.drawArc-illE91I(brush2, f3, f4, z5, l, obj9, l2, obj11, i5, fill);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-illE91I");
        throw unsupportedOperationException;
    }

    public static void drawArc-yD3GUKo$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, long l2, float f3, float f4, boolean z5, long l6, long l7, float f8, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle9, ColorFilter colorFilter10, int i11, int i12, Object object13) {
        int defaultBlendMode-0nO6VwU;
        int zero-F1C5BW0;
        int offsetSize-PENXr5M;
        int i;
        androidx.compose.ui.graphics.drawscope.Fill iNSTANCE;
        int i3;
        Object obj;
        long l3;
        long l;
        int i4;
        androidx.compose.ui.graphics.drawscope.Fill fill;
        int i5;
        int i2;
        int i6 = obj31;
        if (obj32 != null) {
        } else {
            if (i6 & 16 != 0) {
                l3 = zero-F1C5BW0;
            } else {
                l3 = l7;
            }
            if (i6 & 32 != 0) {
                l = offsetSize-PENXr5M;
            } else {
                obj = drawScope;
                l = drawStyle9;
            }
            i4 = i6 & 64 != 0 ? i : i11;
            if (i6 & 128 != 0) {
                fill = iNSTANCE;
            } else {
                fill = i12;
            }
            i5 = i6 & 256 != 0 ? i3 : object13;
            if (i6 &= 512 != 0) {
                i2 = defaultBlendMode-0nO6VwU;
            } else {
                i2 = obj30;
            }
            obj.drawArc-yD3GUKo(l2, obj5, f4, z5, l6, l3, obj10, l, obj12, i4);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawArc-yD3GUKo");
        throw unsupportedOperationException;
    }

    public static void drawCircle-V9BoPsw$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, Brush brush2, float f3, long l4, float f5, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle6, ColorFilter colorFilter7, int i8, int i9, Object object10) {
        int i;
        long l;
        long center-F1C5BW0;
        int i2;
        androidx.compose.ui.graphics.drawscope.Fill iNSTANCE;
        int i3;
        int defaultBlendMode-0nO6VwU;
        if (obj17 != null) {
        } else {
            if (object10 & 2 != 0) {
                minDimension-impl /= l;
            } else {
                i = f3;
            }
            if (object10 & 4 != 0) {
                center-F1C5BW0 = drawScope.getCenter-F1C5BW0();
            } else {
                center-F1C5BW0 = l4;
            }
            i2 = object10 & 8 != 0 ? 1065353216 : drawStyle6;
            if (object10 & 16 != 0) {
                iNSTANCE = Fill.INSTANCE;
            } else {
                iNSTANCE = colorFilter7;
            }
            i3 = object10 & 32 != 0 ? 0 : i8;
            if (object10 & 64 != 0) {
                defaultBlendMode-0nO6VwU = DrawScope.Companion.getDefaultBlendMode-0nO6VwU();
            } else {
                defaultBlendMode-0nO6VwU = i9;
            }
            drawScope.drawCircle-V9BoPsw(brush2, i, center-F1C5BW0, colorFilter7, i2, iNSTANCE, i3);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-V9BoPsw");
        throw unsupportedOperationException;
    }

    public static void drawCircle-VaOC9Bg$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, long l2, float f3, long l4, float f5, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle6, ColorFilter colorFilter7, int i8, int i9, Object object10) {
        int center-F1C5BW0;
        int i3;
        long l;
        int i4;
        androidx.compose.ui.graphics.drawscope.Fill fill;
        int i2;
        int i;
        int obj13;
        if (obj21 != null) {
        } else {
            if (obj20 & 2 != 0) {
                i3 = obj13;
            } else {
                i3 = l4;
            }
            if (obj20 & 4 != 0) {
                l = center-F1C5BW0;
            } else {
                l = f5;
            }
            i4 = obj20 & 8 != 0 ? obj13 : colorFilter7;
            if (obj20 & 16 != 0) {
                fill = obj13;
            } else {
                fill = i8;
            }
            i2 = obj20 & 32 != 0 ? obj13 : i9;
            if (obj20 & 64 != 0) {
                i = obj13;
            } else {
                i = object10;
            }
            drawScope.drawCircle-VaOC9Bg(l2, obj2, i3, l, obj5, i4, fill);
        }
        UnsupportedOperationException obj10 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-VaOC9Bg");
        throw obj10;
    }

    public static void drawImage-9jGpkUE$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, ImageBitmap imageBitmap2, long l3, long l4, long l5, long l6, float f7, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle8, ColorFilter colorFilter9, int i10, int i11, Object object12) {
        int defaultBlendMode-0nO6VwU;
        long zero-nOcc-ac;
        long l2;
        int height;
        long zero-nOcc-ac2;
        long l;
        int i;
        androidx.compose.ui.graphics.drawscope.Fill iNSTANCE;
        int i2;
        int i3 = obj26;
        if (obj27 != null) {
        } else {
            if (i3 & 2 != 0) {
                zero-nOcc-ac = IntOffset.Companion.getZero-nOcc-ac();
            } else {
                zero-nOcc-ac = l3;
            }
            if (i3 & 4 != 0) {
                l2 = IntSizeKt.IntSize(imageBitmap2.getWidth(), imageBitmap2.getHeight());
            } else {
                l2 = l5;
            }
            if (i3 & 8 != 0) {
                zero-nOcc-ac2 = IntOffset.Companion.getZero-nOcc-ac();
            } else {
                zero-nOcc-ac2 = f7;
            }
            l = i3 & 16 != 0 ? l2 : colorFilter9;
            i = i3 & 32 != 0 ? 1065353216 : i11;
            if (i3 & 64 != 0) {
                iNSTANCE = Fill.INSTANCE;
            } else {
                iNSTANCE = object12;
            }
            i2 = i3 & 128 != 0 ? 0 : obj24;
            if (i3 &= 256 != 0) {
                defaultBlendMode-0nO6VwU = DrawScope.Companion.getDefaultBlendMode-0nO6VwU();
            } else {
                defaultBlendMode-0nO6VwU = obj25;
            }
            drawScope.drawImage-9jGpkUE(imageBitmap2, zero-nOcc-ac, l6, l2, drawStyle8, zero-nOcc-ac2, i10, l, object12);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-9jGpkUE");
        throw unsupportedOperationException;
    }

    public static void drawImage-AZ2fEMs$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, ImageBitmap imageBitmap2, long l3, long l4, long l5, long l6, float f7, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle8, ColorFilter colorFilter9, int i10, int i11, int i12, Object object13) {
        int defaultFilterQuality-f-v9h1I;
        long zero-nOcc-ac2;
        long l2;
        int height;
        long zero-nOcc-ac;
        long l;
        int i2;
        androidx.compose.ui.graphics.drawscope.Fill iNSTANCE;
        int i;
        int defaultBlendMode-0nO6VwU;
        int i3 = obj28;
        if (obj29 != null) {
        } else {
            if (i3 & 2 != 0) {
                zero-nOcc-ac2 = IntOffset.Companion.getZero-nOcc-ac();
            } else {
                zero-nOcc-ac2 = l3;
            }
            if (i3 & 4 != 0) {
                l2 = IntSizeKt.IntSize(imageBitmap2.getWidth(), imageBitmap2.getHeight());
            } else {
                l2 = l5;
            }
            if (i3 & 8 != 0) {
                zero-nOcc-ac = IntOffset.Companion.getZero-nOcc-ac();
            } else {
                zero-nOcc-ac = f7;
            }
            l = i3 & 16 != 0 ? l2 : colorFilter9;
            i2 = i3 & 32 != 0 ? 1065353216 : i11;
            if (i3 & 64 != 0) {
                iNSTANCE = Fill.INSTANCE;
            } else {
                iNSTANCE = i12;
            }
            i = i3 & 128 != 0 ? 0 : object13;
            if (i3 & 256 != 0) {
                defaultBlendMode-0nO6VwU = DrawScope.Companion.getDefaultBlendMode-0nO6VwU();
            } else {
                defaultBlendMode-0nO6VwU = obj26;
            }
            if (i3 &= 512 != 0) {
                defaultFilterQuality-f-v9h1I = DrawScope.Companion.getDefaultFilterQuality-f-v9h1I();
            } else {
                defaultFilterQuality-f-v9h1I = obj27;
            }
            drawScope.drawImage-AZ2fEMs(imageBitmap2, zero-nOcc-ac2, l6, l2, drawStyle8, zero-nOcc-ac, i10, l, i12, i2);
        }
        UnsupportedOperationException obj13 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-AZ2fEMs");
        throw obj13;
    }

    public static void drawImage-gbVJVH8$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, ImageBitmap imageBitmap2, long l3, float f4, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle5, ColorFilter colorFilter6, int i7, int i8, Object object9) {
        long zero-F1C5BW0;
        int i2;
        androidx.compose.ui.graphics.drawscope.Fill iNSTANCE;
        int i;
        int defaultBlendMode-0nO6VwU;
        if (obj15 != null) {
        } else {
            if (object9 & 2 != 0) {
                zero-F1C5BW0 = Offset.Companion.getZero-F1C5BW0();
            } else {
                zero-F1C5BW0 = l3;
            }
            i2 = object9 & 4 != 0 ? 1065353216 : drawStyle5;
            if (object9 & 8 != 0) {
                iNSTANCE = Fill.INSTANCE;
            } else {
                iNSTANCE = colorFilter6;
            }
            i = object9 & 16 != 0 ? 0 : i7;
            if (object9 & 32 != 0) {
                defaultBlendMode-0nO6VwU = DrawScope.Companion.getDefaultBlendMode-0nO6VwU();
            } else {
                defaultBlendMode-0nO6VwU = i8;
            }
            drawScope.drawImage-gbVJVH8(imageBitmap2, zero-F1C5BW0, colorFilter6, i2, iNSTANCE, i);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-gbVJVH8");
        throw unsupportedOperationException;
    }

    public static void drawLine-1RTmtNc$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, Brush brush2, long l3, long l4, float f5, int i6, PathEffect pathEffect7, float f8, ColorFilter colorFilter9, int i10, int i11, Object object12) {
        int defaultBlendMode-0nO6VwU;
        int i4;
        int defaultCap-KaPHkGw;
        int i5;
        int i7;
        int i8;
        int i;
        int i3;
        int i9;
        int i2;
        int i12 = obj26;
        if (obj27 != null) {
        } else {
            i7 = i12 & 8 != 0 ? i4 : pathEffect7;
            if (i12 & 16 != 0) {
                i8 = defaultCap-KaPHkGw;
            } else {
                i8 = f8;
            }
            int i15 = 0;
            i = i12 & 32 != 0 ? i15 : colorFilter9;
            i3 = i12 & 64 != 0 ? i5 : i10;
            i9 = i12 & 128 != 0 ? i15 : i11;
            if (i12 &= 256 != 0) {
                i2 = defaultBlendMode-0nO6VwU;
            } else {
                i2 = object12;
            }
            drawScope.drawLine-1RTmtNc(brush2, l3, obj5, f5, obj7, i7, i8, i, i3);
        }
        UnsupportedOperationException obj14 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-1RTmtNc");
        throw obj14;
    }

    public static void drawLine-NGM6Ib0$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, long l2, long l3, long l4, float f5, int i6, PathEffect pathEffect7, float f8, ColorFilter colorFilter9, int i10, int i11, Object object12) {
        int defaultBlendMode-0nO6VwU;
        int i;
        int defaultCap-KaPHkGw;
        int i3;
        int i8;
        int i5;
        int i2;
        int i4;
        int i9;
        int i7;
        int i12 = obj28;
        if (obj29 != null) {
        } else {
            i8 = i12 & 8 != 0 ? i : f8;
            if (i12 & 16 != 0) {
                i5 = defaultCap-KaPHkGw;
            } else {
                i5 = colorFilter9;
            }
            int i15 = 0;
            i2 = i12 & 32 != 0 ? i15 : i10;
            i4 = i12 & 64 != 0 ? i3 : i11;
            i9 = i12 & 128 != 0 ? i15 : object12;
            if (i12 &= 256 != 0) {
                i7 = defaultBlendMode-0nO6VwU;
            } else {
                i7 = obj27;
            }
            drawScope.drawLine-NGM6Ib0(l2, obj4, l4, obj6, i6, obj8, i8, i5, i2);
        }
        UnsupportedOperationException obj15 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-NGM6Ib0");
        throw obj15;
    }

    public static void drawOval-AsUm42w$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, Brush brush2, long l3, long l4, float f5, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle6, ColorFilter colorFilter7, int i8, int i9, Object object10) {
        long zero-F1C5BW0;
        long offsetSize-PENXr5M;
        int i;
        androidx.compose.ui.graphics.drawscope.Fill iNSTANCE;
        int i2;
        int defaultBlendMode-0nO6VwU;
        if (obj19 != null) {
        } else {
            if (obj18 & 2 != 0) {
                zero-F1C5BW0 = Offset.Companion.getZero-F1C5BW0();
            } else {
                zero-F1C5BW0 = l3;
            }
            if (obj18 & 4 != 0) {
                offsetSize-PENXr5M = drawScope.offsetSize-PENXr5M(drawScope.getSize-NH-jbRc(), obj3);
            } else {
                offsetSize-PENXr5M = f5;
            }
            i = obj18 & 8 != 0 ? 1065353216 : colorFilter7;
            if (obj18 & 16 != 0) {
                iNSTANCE = Fill.INSTANCE;
            } else {
                iNSTANCE = i8;
            }
            i2 = obj18 & 32 != 0 ? 0 : i9;
            if (obj18 & 64 != 0) {
                defaultBlendMode-0nO6VwU = DrawScope.Companion.getDefaultBlendMode-0nO6VwU();
            } else {
                defaultBlendMode-0nO6VwU = object10;
            }
            drawScope.drawOval-AsUm42w(brush2, zero-F1C5BW0, drawStyle6, offsetSize-PENXr5M, i8, i, iNSTANCE);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-AsUm42w");
        throw unsupportedOperationException;
    }

    public static void drawOval-n-J9OG0$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, long l2, long l3, long l4, float f5, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle6, ColorFilter colorFilter7, int i8, int i9, Object object10) {
        int zero-F1C5BW0;
        int offsetSize-PENXr5M;
        int i5;
        androidx.compose.ui.graphics.drawscope.Fill iNSTANCE;
        int i4;
        int defaultBlendMode-0nO6VwU;
        long l5;
        long l;
        int i;
        androidx.compose.ui.graphics.drawscope.Fill fill;
        int i3;
        int i2;
        if (obj25 != null) {
        } else {
            if (obj24 & 2 != 0) {
                l5 = zero-F1C5BW0;
            } else {
                l5 = l4;
            }
            if (obj24 & 4 != 0) {
                l = offsetSize-PENXr5M;
            } else {
                l = drawStyle6;
            }
            i = obj24 & 8 != 0 ? i5 : i8;
            if (obj24 & 16 != 0) {
                fill = iNSTANCE;
            } else {
                fill = i9;
            }
            i3 = obj24 & 32 != 0 ? i4 : object10;
            if (obj24 & 64 != 0) {
                i2 = defaultBlendMode-0nO6VwU;
            } else {
                i2 = obj23;
            }
            drawScope.drawOval-n-J9OG0(l2, obj4, l5, obj6, l, obj8, i);
        }
        UnsupportedOperationException obj13 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawOval-n-J9OG0");
        throw obj13;
    }

    public static void drawPath-GBMwjPU$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, Path path2, Brush brush3, float f4, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle5, ColorFilter colorFilter6, int i7, int i8, Object object9) {
        int i;
        androidx.compose.ui.graphics.drawscope.Fill fill;
        int i2;
        int i3;
        int obj10;
        androidx.compose.ui.graphics.drawscope.Fill obj11;
        int obj12;
        int obj13;
        if (object9 != null) {
        } else {
            i = i8 & 4 != 0 ? obj10 : f4;
            if (i8 & 8 != 0) {
                fill = obj11;
            } else {
                fill = drawStyle5;
            }
            i2 = i8 & 16 != 0 ? obj12 : colorFilter6;
            if (i8 & 32 != 0) {
                i3 = obj13;
            } else {
                i3 = i7;
            }
            drawScope.drawPath-GBMwjPU(path2, brush3, i, fill, i2, i3);
        }
        UnsupportedOperationException obj7 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-GBMwjPU");
        throw obj7;
    }

    public static void drawPath-LG529CI$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, Path path2, long l3, float f4, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle5, ColorFilter colorFilter6, int i7, int i8, Object object9) {
        int i2;
        androidx.compose.ui.graphics.drawscope.Fill fill;
        int i;
        int i3;
        int obj12;
        androidx.compose.ui.graphics.drawscope.Fill obj13;
        int obj14;
        if (obj17 != null) {
        } else {
            i2 = object9 & 4 != 0 ? obj12 : drawStyle5;
            if (object9 & 8 != 0) {
                fill = obj13;
            } else {
                fill = colorFilter6;
            }
            i = object9 & 16 != 0 ? obj14 : i7;
            if (object9 & 32 != 0) {
                i3 = obj12;
            } else {
                i3 = i8;
            }
            drawScope.drawPath-LG529CI(path2, l3, obj3, i2, fill, i);
        }
        UnsupportedOperationException obj8 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-LG529CI");
        throw obj8;
    }

    public static void drawPoints-F8ZwMP8$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, List list2, int i3, long l4, float f5, int i6, PathEffect pathEffect7, float f8, ColorFilter colorFilter9, int i10, int i11, Object object12) {
        int defaultBlendMode-0nO6VwU;
        int i8;
        int butt-KaPHkGw;
        int i7;
        int i4;
        int i;
        int i9;
        int i2;
        int i5;
        int i12;
        int i13 = object12;
        if (obj25 != null) {
        } else {
            i4 = i13 & 8 != 0 ? i8 : i6;
            if (i13 & 16 != 0) {
                i = butt-KaPHkGw;
            } else {
                i = pathEffect7;
            }
            int i16 = 0;
            i9 = i13 & 32 != 0 ? i16 : f8;
            i2 = i13 & 64 != 0 ? i7 : colorFilter9;
            i5 = i13 & 128 != 0 ? i16 : i10;
            if (i13 &= 256 != 0) {
                i12 = defaultBlendMode-0nO6VwU;
            } else {
                i12 = i11;
            }
            drawScope.drawPoints-F8ZwMP8(list2, i3, l4, obj6, i4, i, i9, i2, i5);
        }
        UnsupportedOperationException obj13 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-F8ZwMP8");
        throw obj13;
    }

    public static void drawPoints-Gsft0Ws$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, List list2, int i3, Brush brush4, float f5, int i6, PathEffect pathEffect7, float f8, ColorFilter colorFilter9, int i10, int i11, Object object12) {
        int defaultBlendMode-0nO6VwU;
        int i4;
        int butt-KaPHkGw;
        int i12;
        int i8;
        int i5;
        int i2;
        int i7;
        int i;
        int i9;
        int i13 = i11;
        if (object12 != null) {
        } else {
            i8 = i13 & 8 != 0 ? i4 : f5;
            if (i13 & 16 != 0) {
                i5 = butt-KaPHkGw;
            } else {
                i5 = i6;
            }
            int i16 = 0;
            i2 = i13 & 32 != 0 ? i16 : pathEffect7;
            i7 = i13 & 64 != 0 ? i12 : f8;
            i = i13 & 128 != 0 ? i16 : colorFilter9;
            if (i13 &= 256 != 0) {
                i9 = defaultBlendMode-0nO6VwU;
            } else {
                i9 = i10;
            }
            drawScope.drawPoints-Gsft0Ws(list2, i3, brush4, i8, i5, i2, i7, i, i9);
        }
        UnsupportedOperationException obj12 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPoints-Gsft0Ws");
        throw obj12;
    }

    public static void drawRect-AsUm42w$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, Brush brush2, long l3, long l4, float f5, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle6, ColorFilter colorFilter7, int i8, int i9, Object object10) {
        long zero-F1C5BW0;
        long offsetSize-PENXr5M;
        int i2;
        androidx.compose.ui.graphics.drawscope.Fill iNSTANCE;
        int i;
        int defaultBlendMode-0nO6VwU;
        if (obj19 != null) {
        } else {
            if (obj18 & 2 != 0) {
                zero-F1C5BW0 = Offset.Companion.getZero-F1C5BW0();
            } else {
                zero-F1C5BW0 = l3;
            }
            if (obj18 & 4 != 0) {
                offsetSize-PENXr5M = drawScope.offsetSize-PENXr5M(drawScope.getSize-NH-jbRc(), obj3);
            } else {
                offsetSize-PENXr5M = f5;
            }
            i2 = obj18 & 8 != 0 ? 1065353216 : colorFilter7;
            if (obj18 & 16 != 0) {
                iNSTANCE = Fill.INSTANCE;
            } else {
                iNSTANCE = i8;
            }
            i = obj18 & 32 != 0 ? 0 : i9;
            if (obj18 & 64 != 0) {
                defaultBlendMode-0nO6VwU = DrawScope.Companion.getDefaultBlendMode-0nO6VwU();
            } else {
                defaultBlendMode-0nO6VwU = object10;
            }
            drawScope.drawRect-AsUm42w(brush2, zero-F1C5BW0, drawStyle6, offsetSize-PENXr5M, i8, i2, iNSTANCE);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-AsUm42w");
        throw unsupportedOperationException;
    }

    public static void drawRect-n-J9OG0$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, long l2, long l3, long l4, float f5, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle6, ColorFilter colorFilter7, int i8, int i9, Object object10) {
        int zero-F1C5BW0;
        int offsetSize-PENXr5M;
        int i4;
        androidx.compose.ui.graphics.drawscope.Fill iNSTANCE;
        int i5;
        int defaultBlendMode-0nO6VwU;
        long l;
        long l5;
        int i;
        androidx.compose.ui.graphics.drawscope.Fill fill;
        int i2;
        int i3;
        if (obj25 != null) {
        } else {
            if (obj24 & 2 != 0) {
                l = zero-F1C5BW0;
            } else {
                l = l4;
            }
            if (obj24 & 4 != 0) {
                l5 = offsetSize-PENXr5M;
            } else {
                l5 = drawStyle6;
            }
            i = obj24 & 8 != 0 ? i4 : i8;
            if (obj24 & 16 != 0) {
                fill = iNSTANCE;
            } else {
                fill = i9;
            }
            i2 = obj24 & 32 != 0 ? i5 : object10;
            if (obj24 & 64 != 0) {
                i3 = defaultBlendMode-0nO6VwU;
            } else {
                i3 = obj23;
            }
            drawScope.drawRect-n-J9OG0(l2, obj4, l, obj6, l5, obj8, i);
        }
        UnsupportedOperationException obj13 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-n-J9OG0");
        throw obj13;
    }

    public static void drawRoundRect-ZuiqVtQ$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, Brush brush2, long l3, long l4, long l5, float f6, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle7, ColorFilter colorFilter8, int i9, int i10, Object object11) {
        int defaultBlendMode-0nO6VwU;
        long zero-F1C5BW0;
        long offsetSize-PENXr5M;
        long zero-kKHJgLs;
        int i2;
        androidx.compose.ui.graphics.drawscope.Fill iNSTANCE;
        int i;
        int i3 = obj22;
        if (obj23 != null) {
        } else {
            if (i3 & 2 != 0) {
                zero-F1C5BW0 = Offset.Companion.getZero-F1C5BW0();
            } else {
                zero-F1C5BW0 = l3;
            }
            if (i3 & 4 != 0) {
                offsetSize-PENXr5M = drawScope.offsetSize-PENXr5M(drawScope.getSize-NH-jbRc(), obj4);
            } else {
                offsetSize-PENXr5M = l5;
            }
            if (i3 & 8 != 0) {
                zero-kKHJgLs = CornerRadius.Companion.getZero-kKHJgLs();
            } else {
                zero-kKHJgLs = drawStyle7;
            }
            i2 = i3 & 16 != 0 ? 1065353216 : i9;
            if (i3 & 32 != 0) {
                iNSTANCE = Fill.INSTANCE;
            } else {
                iNSTANCE = i10;
            }
            i = i3 & 64 != 0 ? 0 : object11;
            if (i3 &= 128 != 0) {
                defaultBlendMode-0nO6VwU = DrawScope.Companion.getDefaultBlendMode-0nO6VwU();
            } else {
                defaultBlendMode-0nO6VwU = obj21;
            }
            drawScope.drawRoundRect-ZuiqVtQ(brush2, zero-F1C5BW0, f6, offsetSize-PENXr5M, colorFilter8, zero-kKHJgLs, i10, i2);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-ZuiqVtQ");
        throw unsupportedOperationException;
    }

    public static void drawRoundRect-u-Aw5IA$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, long l2, long l3, long l4, long l5, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle6, float f7, ColorFilter colorFilter8, int i9, int i10, Object object11) {
        int defaultBlendMode-0nO6VwU;
        int zero-F1C5BW0;
        int offsetSize-PENXr5M;
        int zero-kKHJgLs;
        androidx.compose.ui.graphics.drawscope.Fill iNSTANCE;
        int i;
        int i2;
        Object obj;
        long l6;
        long l7;
        long l;
        androidx.compose.ui.graphics.drawscope.Fill fill;
        int i5;
        int i4;
        int i3;
        int i6 = obj29;
        if (obj30 != null) {
        } else {
            if (i6 & 2 != 0) {
                l6 = zero-F1C5BW0;
            } else {
                l6 = l4;
            }
            if (i6 & 4 != 0) {
                l7 = offsetSize-PENXr5M;
            } else {
                obj = drawScope;
                l7 = drawStyle6;
            }
            if (i6 & 8 != 0) {
                l = zero-kKHJgLs;
            } else {
                l = colorFilter8;
            }
            if (i6 & 16 != 0) {
                fill = iNSTANCE;
            } else {
                fill = i10;
            }
            i5 = i6 & 32 != 0 ? i : object11;
            i4 = i6 & 64 != 0 ? i2 : obj27;
            if (i6 &= 128 != 0) {
                i3 = defaultBlendMode-0nO6VwU;
            } else {
                i3 = obj28;
            }
            obj.drawRoundRect-u-Aw5IA(l2, obj5, l6, obj7, l7, obj9, l, obj11);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-u-Aw5IA");
        throw unsupportedOperationException;
    }

    private long offsetSize-PENXr5M(long $this$offsetSize_u2dPENXr5M, long offset) {
        return SizeKt.Size(width-impl -= x-impl, height-impl -= y-impl);
    }

    public static void record-JVtK1S4$default(androidx.compose.ui.graphics.drawscope.DrawScope drawScope, GraphicsLayer graphicsLayer2, long l3, Function1 function14, int i5, Object object6) {
        long obj2;
        if (obj6 != null) {
        } else {
            if (object6 &= 1 != 0) {
                obj2 = IntSizeKt.toIntSize-uvyYCjk(drawScope.getSize-NH-jbRc());
            }
            drawScope.record-JVtK1S4(graphicsLayer2, obj2, function14);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: record-JVtK1S4");
        throw obj0;
    }

    @Override // androidx.compose.ui.unit.Density
    public abstract void drawArc-illE91I(Brush brush, float f2, float f3, boolean z4, long l5, long l6, float f7, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle8, ColorFilter colorFilter9, int i10);

    @Override // androidx.compose.ui.unit.Density
    public abstract void drawArc-yD3GUKo(long l, float f2, float f3, boolean z4, long l5, long l6, float f7, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle8, ColorFilter colorFilter9, int i10);

    @Override // androidx.compose.ui.unit.Density
    public abstract void drawCircle-V9BoPsw(Brush brush, float f2, long l3, float f4, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle5, ColorFilter colorFilter6, int i7);

    @Override // androidx.compose.ui.unit.Density
    public abstract void drawCircle-VaOC9Bg(long l, float f2, long l3, float f4, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle5, ColorFilter colorFilter6, int i7);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(...))
    public abstract void drawImage-9jGpkUE(ImageBitmap imageBitmap, long l2, long l3, long l4, long l5, float f6, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle7, ColorFilter colorFilter8, int i9);

    @Override // androidx.compose.ui.unit.Density
    public void drawImage-AZ2fEMs(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
        DrawScope.drawImage-AZ2fEMs$default(this, image, srcOffset, obj3, dstOffset, obj5, alpha, obj7, colorFilter, obj9, filterQuality, obj28, obj29);
    }

    @Override // androidx.compose.ui.unit.Density
    public abstract void drawImage-gbVJVH8(ImageBitmap imageBitmap, long l2, float f3, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle4, ColorFilter colorFilter5, int i6);

    @Override // androidx.compose.ui.unit.Density
    public abstract void drawLine-1RTmtNc(Brush brush, long l2, long l3, float f4, int i5, PathEffect pathEffect6, float f7, ColorFilter colorFilter8, int i9);

    @Override // androidx.compose.ui.unit.Density
    public abstract void drawLine-NGM6Ib0(long l, long l2, long l3, float f4, int i5, PathEffect pathEffect6, float f7, ColorFilter colorFilter8, int i9);

    @Override // androidx.compose.ui.unit.Density
    public abstract void drawOval-AsUm42w(Brush brush, long l2, long l3, float f4, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle5, ColorFilter colorFilter6, int i7);

    @Override // androidx.compose.ui.unit.Density
    public abstract void drawOval-n-J9OG0(long l, long l2, long l3, float f4, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle5, ColorFilter colorFilter6, int i7);

    @Override // androidx.compose.ui.unit.Density
    public abstract void drawPath-GBMwjPU(Path path, Brush brush2, float f3, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle4, ColorFilter colorFilter5, int i6);

    @Override // androidx.compose.ui.unit.Density
    public abstract void drawPath-LG529CI(Path path, long l2, float f3, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle4, ColorFilter colorFilter5, int i6);

    public abstract void drawPoints-F8ZwMP8(List<Offset> list, int i2, long l3, float f4, int i5, PathEffect pathEffect6, float f7, ColorFilter colorFilter8, int i9);

    public abstract void drawPoints-Gsft0Ws(List<Offset> list, int i2, Brush brush3, float f4, int i5, PathEffect pathEffect6, float f7, ColorFilter colorFilter8, int i9);

    @Override // androidx.compose.ui.unit.Density
    public abstract void drawRect-AsUm42w(Brush brush, long l2, long l3, float f4, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle5, ColorFilter colorFilter6, int i7);

    @Override // androidx.compose.ui.unit.Density
    public abstract void drawRect-n-J9OG0(long l, long l2, long l3, float f4, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle5, ColorFilter colorFilter6, int i7);

    @Override // androidx.compose.ui.unit.Density
    public abstract void drawRoundRect-ZuiqVtQ(Brush brush, long l2, long l3, long l4, float f5, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle6, ColorFilter colorFilter7, int i8);

    @Override // androidx.compose.ui.unit.Density
    public abstract void drawRoundRect-u-Aw5IA(long l, long l2, long l3, long l4, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle5, float f6, ColorFilter colorFilter7, int i8);

    @Override // androidx.compose.ui.unit.Density
    public long getCenter-F1C5BW0() {
        return SizeKt.getCenter-uvyYCjk(getDrawContext().getSize-NH-jbRc());
    }

    @Override // androidx.compose.ui.unit.Density
    public abstract androidx.compose.ui.graphics.drawscope.DrawContext getDrawContext();

    @Override // androidx.compose.ui.unit.Density
    public abstract LayoutDirection getLayoutDirection();

    @Override // androidx.compose.ui.unit.Density
    public long getSize-NH-jbRc() {
        return getDrawContext().getSize-NH-jbRc();
    }

    public void record-JVtK1S4(GraphicsLayer $this$record_u2dJVtK1S4, long size, Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, Unit> block) {
        DrawScope.record.1 anon = new DrawScope.record.1(this, obj10);
        $this$record_u2dJVtK1S4.record-mL-hObY((Density)this, getLayoutDirection(), size, obj4);
    }
}
