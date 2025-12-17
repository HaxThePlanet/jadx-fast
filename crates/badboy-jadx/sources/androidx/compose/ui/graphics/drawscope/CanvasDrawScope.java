package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.PaintingStyle.Companion;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.StrokeJoin.Companion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\r\u0018\u00002\u00020\u0001:\u0002\u0092\u0001B\u0005¢\u0006\u0002\u0010\u0002JJ\u0010\u0019\u001a\u00020\u00112\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&JH\u0010\u0019\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*Jl\u0010+\u001a\u00020\u00112\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0008\u00102\u001a\u0004\u0018\u0001032\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000¢\u0006\u0004\u00084\u00105Jj\u0010+\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0008\u00102\u001a\u0004\u0018\u0001032\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000¢\u0006\u0004\u00086\u00107JL\u00108\u001a\u0002092\u0006\u0010\u0003\u001a\u00020:2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0017\u0010?\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002090@¢\u0006\u0002\u0008AH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008B\u0010CJf\u0010D\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\u0008K\u0010LJf\u0010D\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\u0008M\u0010NJN\u0010O\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020J2\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\u0008R\u0010SJN\u0010O\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020J2\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\u0008T\u0010UJF\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010I\u001a\u00020J2\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\u0008Y\u0010ZJ^\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\\2\u0006\u0010`\u001a\u00020^2\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0017ø\u0001\u0000¢\u0006\u0004\u0008a\u0010bJf\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\\2\u0006\u0010`\u001a\u00020^2\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016ø\u0001\u0000¢\u0006\u0004\u0008c\u0010dJ`\u0010e\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010f\u001a\u00020J2\u0006\u0010g\u001a\u00020J2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0008\u00102\u001a\u0004\u0018\u0001032\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\u0008h\u0010iJ`\u0010e\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010f\u001a\u00020J2\u0006\u0010g\u001a\u00020J2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0008\u00102\u001a\u0004\u0018\u0001032\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\u0008j\u0010kJN\u0010l\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\u0008m\u0010nJN\u0010l\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\u0008o\u0010pJF\u0010q\u001a\u0002092\u0006\u0010r\u001a\u00020s2\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\u0008t\u0010uJF\u0010q\u001a\u0002092\u0006\u0010r\u001a\u00020s2\u0006\u0010'\u001a\u00020(2\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\u0008v\u0010wJf\u0010x\u001a\u0002092\u000c\u0010y\u001a\u0008\u0012\u0004\u0012\u00020J0z2\u0006\u0010{\u001a\u00020|2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0008\u00102\u001a\u0004\u0018\u0001032\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\u0008}\u0010~Jg\u0010x\u001a\u0002092\u000c\u0010y\u001a\u0008\u0012\u0004\u0012\u00020J0z2\u0006\u0010{\u001a\u00020|2\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0008\u00102\u001a\u0004\u0018\u0001032\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0005\u0008\u007f\u0010\u0080\u0001JP\u0010\u0081\u0001\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0005\u0008\u0082\u0001\u0010nJP\u0010\u0081\u0001\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0005\u0008\u0083\u0001\u0010pJ[\u0010\u0084\u0001\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0008\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0006\u0008\u0087\u0001\u0010\u0088\u0001J[\u0010\u0084\u0001\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0008\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u00042\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0006\u0008\u0089\u0001\u0010\u008a\u0001J\t\u0010\u008b\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u008c\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010\u008d\u0001\u001a\u00020\u00112\u0007\u0010\u008e\u0001\u001a\u00020\u001dH\u0002J!\u0010\u008f\u0001\u001a\u00020(*\u00020(2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0006\u0008\u0090\u0001\u0010\u0091\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u000c8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\r\u0010\u0002\u001a\u0004\u0008\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0006R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0093\u0001", d2 = {"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "()V", "density", "", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawParams", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "getDrawParams$annotations", "getDrawParams", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "fillPaint", "Landroidx/compose/ui/graphics/Paint;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "strokePaint", "configurePaint", "brush", "Landroidx/compose/ui/graphics/Brush;", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "alpha", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "configurePaint-swdJneE", "(Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "color", "Landroidx/compose/ui/graphics/Color;", "configurePaint-2qPWKa0", "(JLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint", "strokeWidth", "miter", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "join", "Landroidx/compose/ui/graphics/StrokeJoin;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "configureStrokePaint-ho4zsrM", "(Landroidx/compose/ui/graphics/Brush;FFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint-Q_0CZUI", "(JFFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "draw", "", "Landroidx/compose/ui/unit/Density;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "draw-yzxVdVo", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/functions/Function1;)V", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "center", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "obtainFillPaint", "obtainStrokePaint", "selectPaint", "drawStyle", "modulate", "modulate-5vOe2sY", "(JF)J", "DrawParams", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CanvasDrawScope implements androidx.compose.ui.graphics.drawscope.DrawScope {

    private final androidx.compose.ui.graphics.drawscope.DrawContext drawContext;
    private final androidx.compose.ui.graphics.drawscope.CanvasDrawScope.DrawParams drawParams;
    private Paint fillPaint;
    private Paint strokePaint;

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001b\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0081\u0008\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u0016\u0010\u001f\u001a\u00020\tHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008 \u0010\u0018J;\u0010!\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tHÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#J\u0013\u0010$\u001a\u00020%2\u0008\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\"\u0010\u0008\u001a\u00020\tX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001a\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006+", d2 = {"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCanvas", "()Landroidx/compose/ui/graphics/Canvas;", "setCanvas", "(Landroidx/compose/ui/graphics/Canvas;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "J", "component1", "component2", "component3", "component4", "component4-NH-jbRc", "copy", "copy-Ug5Nnss", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;J)Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DrawParams {

        private Canvas canvas;
        private Density density;
        private LayoutDirection layoutDirection;
        private long size;
        private DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long size) {
            super();
            this.density = density;
            this.layoutDirection = layoutDirection;
            this.canvas = canvas;
            this.size = size;
        }

        public DrawParams(Density density, LayoutDirection layoutDirection2, Canvas canvas3, long l4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
            Density density2;
            LayoutDirection layoutDirection;
            androidx.compose.ui.graphics.drawscope.EmptyCanvas emptyCanvas;
            long l;
            Density obj8;
            LayoutDirection obj9;
            androidx.compose.ui.graphics.drawscope.EmptyCanvas obj10;
            long obj11;
            if (defaultConstructorMarker6 & 1 != 0) {
                density2 = obj8;
            } else {
                density2 = density;
            }
            layoutDirection = defaultConstructorMarker6 & 2 != 0 ? obj9 : layoutDirection2;
            if (defaultConstructorMarker6 & 4 != 0) {
                obj8 = new EmptyCanvas();
                emptyCanvas = obj10;
            } else {
                emptyCanvas = canvas3;
            }
            if (defaultConstructorMarker6 & 8 != 0) {
                l = obj11;
            } else {
                l = l4;
            }
            super(density2, layoutDirection, emptyCanvas, l, obj5, 0);
        }

        public DrawParams(Density density, LayoutDirection layoutDirection2, Canvas canvas3, long l4, DefaultConstructorMarker defaultConstructorMarker5) {
            super(density, layoutDirection2, canvas3, l4, defaultConstructorMarker5);
        }

        public static androidx.compose.ui.graphics.drawscope.CanvasDrawScope.DrawParams copy-Ug5Nnss$default(androidx.compose.ui.graphics.drawscope.CanvasDrawScope.DrawParams canvasDrawScope$DrawParams, Density density2, LayoutDirection layoutDirection3, Canvas canvas4, long l5, int i6, Object object7) {
            Density obj1;
            LayoutDirection obj2;
            Canvas obj3;
            long obj4;
            if (object7 & 1 != 0) {
                obj1 = drawParams.density;
            }
            if (object7 & 2 != 0) {
                obj2 = drawParams.layoutDirection;
            }
            int obj7 = object7 & 4;
            if (obj7 != null) {
                obj3 = drawParams.canvas;
            }
            if (object7 &= 8 != 0) {
                obj4 = drawParams.size;
            }
            return drawParams.copy-Ug5Nnss(obj1, obj2, obj3, obj4);
        }

        public final Density component1() {
            return this.density;
        }

        public final LayoutDirection component2() {
            return this.layoutDirection;
        }

        public final Canvas component3() {
            return this.canvas;
        }

        public final long component4-NH-jbRc() {
            return this.size;
        }

        public final androidx.compose.ui.graphics.drawscope.CanvasDrawScope.DrawParams copy-Ug5Nnss(Density density, LayoutDirection layoutDirection2, Canvas canvas3, long l4) {
            CanvasDrawScope.DrawParams drawParams = new CanvasDrawScope.DrawParams(density, layoutDirection2, canvas3, l4, obj5, 0);
            return drawParams;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof CanvasDrawScope.DrawParams) {
                return i2;
            }
            Object obj = object;
            if (!Intrinsics.areEqual(this.density, obj.density)) {
                return i2;
            }
            if (this.layoutDirection != obj.layoutDirection) {
                return i2;
            }
            Canvas canvas2 = obj.canvas;
            if (!Intrinsics.areEqual(this.canvas, canvas2)) {
                return i2;
            }
            if (!Size.equals-impl0(this.size, canvas2)) {
                return i2;
            }
            return i;
        }

        public final Canvas getCanvas() {
            return this.canvas;
        }

        public final Density getDensity() {
            return this.density;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public final long getSize-NH-jbRc() {
            return this.size;
        }

        public int hashCode() {
            return i6 += i10;
        }

        public final void setCanvas(Canvas <set-?>) {
            this.canvas = <set-?>;
        }

        public final void setDensity(Density <set-?>) {
            this.density = <set-?>;
        }

        public final void setLayoutDirection(LayoutDirection <set-?>) {
            this.layoutDirection = <set-?>;
        }

        public final void setSize-uvyYCjk(long <set-?>) {
            this.size = <set-?>;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("DrawParams(density=").append(this.density).append(", layoutDirection=").append(this.layoutDirection).append(", canvas=").append(this.canvas).append(", size=").append(Size.toString-impl(this.size)).append(')').toString();
        }
    }
    public CanvasDrawScope() {
        super();
        CanvasDrawScope.DrawParams drawParams = new CanvasDrawScope.DrawParams(0, 0, 0, 0, obj5, 15, 0);
        this.drawParams = drawParams;
        CanvasDrawScope.drawContext.1 anon = new CanvasDrawScope.drawContext.1(this);
        this.drawContext = (DrawContext)anon;
    }

    private final Paint configurePaint-2qPWKa0(long color, androidx.compose.ui.graphics.drawscope.DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        android.graphics.Shader shader;
        final Paint paint = selectPaint(alpha);
        final Paint paint2 = paint;
        final int i = 0;
        final long modulate-5vOe2sY = modulate-5vOe2sY(color, style);
        if (!Color.equals-impl0(paint2.getColor-0d7_KjU(), obj6)) {
            paint2.setColor-8_81llA(modulate-5vOe2sY);
        }
        if (paint2.getShader() != null) {
            paint2.setShader(0);
        }
        if (!Intrinsics.areEqual(paint2.getColorFilter(), blendMode)) {
            paint2.setColorFilter(blendMode);
        }
        if (!BlendMode.equals-impl0(paint2.getBlendMode-0nO6VwU(), filterQuality)) {
            paint2.setBlendMode-s9anfk8(filterQuality);
        }
        if (!FilterQuality.equals-impl0(paint2.getFilterQuality-f-v9h1I(), obj14)) {
            paint2.setFilterQuality-vDHp3xo(obj14);
        }
        return paint;
    }

    static Paint configurePaint-2qPWKa0$default(androidx.compose.ui.graphics.drawscope.CanvasDrawScope canvasDrawScope, long l2, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle3, float f4, ColorFilter colorFilter5, int i6, int i7, int i8, Object object9) {
        int defaultFilterQuality-f-v9h1I;
        int i;
        if (object9 & 32 != 0) {
            i = defaultFilterQuality-f-v9h1I;
        } else {
            i = i8;
        }
        return canvasDrawScope.configurePaint-2qPWKa0(l2, obj3, f4, colorFilter5, i6, i7);
    }

    private final Paint configurePaint-swdJneE(Brush brush, androidx.compose.ui.graphics.drawscope.DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        long size-NH-jbRc;
        android.graphics.Shader shader;
        boolean black-0d7_KjU;
        long black-0d7_KjU2;
        final Paint paint = selectPaint(style);
        final Paint paint2 = paint;
        final int i = 0;
        if (brush != null) {
            brush.applyTo-Pq9zytI(getSize-NH-jbRc(), obj4, paint2);
        } else {
            if (paint2.getShader() != null) {
                paint2.setShader(0);
            }
            if (!Color.equals-impl0(paint2.getColor-0d7_KjU(), obj4)) {
                paint2.setColor-8_81llA(Color.Companion.getBlack-0d7_KjU());
            }
            size-NH-jbRc = Float.compare(alpha2, alpha) == 0 ? 1 : 0;
            if (size-NH-jbRc == 0) {
                paint2.setAlpha(alpha);
            }
        }
        if (!Intrinsics.areEqual(paint2.getColorFilter(), colorFilter)) {
            paint2.setColorFilter(colorFilter);
        }
        if (!BlendMode.equals-impl0(paint2.getBlendMode-0nO6VwU(), blendMode)) {
            paint2.setBlendMode-s9anfk8(blendMode);
        }
        if (!FilterQuality.equals-impl0(paint2.getFilterQuality-f-v9h1I(), filterQuality)) {
            paint2.setFilterQuality-vDHp3xo(filterQuality);
        }
        return paint;
    }

    static Paint configurePaint-swdJneE$default(androidx.compose.ui.graphics.drawscope.CanvasDrawScope canvasDrawScope, Brush brush2, androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle3, float f4, ColorFilter colorFilter5, int i6, int i7, int i8, Object object9) {
        int i;
        int obj13;
        if (i8 &= 32 != 0) {
            i = obj13;
        } else {
            i = i7;
        }
        return canvasDrawScope.configurePaint-swdJneE(brush2, drawStyle3, f4, colorFilter5, i6, i);
    }

    private final Paint configureStrokePaint-Q_0CZUI(long color, float strokeWidth, float miter, int cap, int join, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        android.graphics.Shader shader;
        int i;
        int i2;
        final float f = miter;
        final float f2 = cap;
        final int i3 = join;
        final int i4 = pathEffect;
        final Object obj = alpha;
        final Object obj2 = blendMode;
        final int i5 = filterQuality;
        final Paint strokePaint = obtainStrokePaint();
        final Paint paint = strokePaint;
        long l = this;
        final long modulate-5vOe2sY = l.modulate-5vOe2sY(color, obj13);
        final int i8 = i6;
        if (!Color.equals-impl0(paint.getColor-0d7_KjU(), l)) {
            paint.setColor-8_81llA(modulate-5vOe2sY);
        }
        if (paint.getShader() != null) {
            paint.setShader(0);
        }
        if (!Intrinsics.areEqual(paint.getColorFilter(), obj2)) {
            paint.setColorFilter(obj2);
        }
        if (!BlendMode.equals-impl0(paint.getBlendMode-0nO6VwU(), i5)) {
            paint.setBlendMode-s9anfk8(i5);
        }
        final int i9 = 0;
        i = Float.compare(strokeWidth2, f) == 0 ? i2 : i9;
        if (i == 0) {
            paint.setStrokeWidth(f);
        }
        if (Float.compare(strokeMiterLimit, f2) == 0) {
        } else {
            i2 = i9;
        }
        if (i2 == 0) {
            paint.setStrokeMiterLimit(f2);
        }
        if (!StrokeCap.equals-impl0(paint.getStrokeCap-KaPHkGw(), i3)) {
            paint.setStrokeCap-BeK7IIE(i3);
        }
        if (!StrokeJoin.equals-impl0(paint.getStrokeJoin-LxFBmk8(), i4)) {
            paint.setStrokeJoin-Ww9F2mQ(i4);
        }
        if (!Intrinsics.areEqual(paint.getPathEffect(), obj)) {
            paint.setPathEffect(obj);
        }
        int i7 = obj29;
        if (!FilterQuality.equals-impl0(paint.getFilterQuality-f-v9h1I(), i7)) {
            paint.setFilterQuality-vDHp3xo(i7);
        }
        return strokePaint;
    }

    static Paint configureStrokePaint-Q_0CZUI$default(androidx.compose.ui.graphics.drawscope.CanvasDrawScope canvasDrawScope, long l2, float f3, float f4, int i5, int i6, PathEffect pathEffect7, float f8, ColorFilter colorFilter9, int i10, int i11, int i12, Object object13) {
        int defaultFilterQuality-f-v9h1I;
        int i;
        if (i2 &= 512 != 0) {
            i = defaultFilterQuality-f-v9h1I;
        } else {
            i = i12;
        }
        return canvasDrawScope.configureStrokePaint-Q_0CZUI(l2, obj3, f4, i5, i6, pathEffect7, f8, colorFilter9, i10, i11);
    }

    private final Paint configureStrokePaint-ho4zsrM(Brush brush, float strokeWidth, float miter, int cap, int join, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        int size-NH-jbRc;
        int i;
        int i2;
        final Object obj = brush;
        final float f = strokeWidth;
        final float f2 = miter;
        final int i3 = cap;
        final int i4 = join;
        final Object obj2 = pathEffect;
        final float f3 = alpha;
        final Object obj3 = colorFilter;
        final int i5 = blendMode;
        final int i6 = filterQuality;
        final Paint strokePaint = obtainStrokePaint();
        final Paint paint = strokePaint;
        final int i7 = 0;
        if (obj != null) {
            obj.applyTo-Pq9zytI(getSize-NH-jbRc(), obj14, paint);
        } else {
            size-NH-jbRc = Float.compare(alpha2, f3) == 0 ? 1 : 0;
            if (size-NH-jbRc == 0) {
                paint.setAlpha(f3);
            }
        }
        if (!Intrinsics.areEqual(paint.getColorFilter(), obj3)) {
            paint.setColorFilter(obj3);
        }
        if (!BlendMode.equals-impl0(paint.getBlendMode-0nO6VwU(), i5)) {
            paint.setBlendMode-s9anfk8(i5);
        }
        i = Float.compare(strokeWidth2, f) == 0 ? 1 : 0;
        if (i == 0) {
            paint.setStrokeWidth(f);
        }
        i2 = Float.compare(strokeMiterLimit, f2) == 0 ? 1 : 0;
        if (i2 == 0) {
            paint.setStrokeMiterLimit(f2);
        }
        if (!StrokeCap.equals-impl0(paint.getStrokeCap-KaPHkGw(), i3)) {
            paint.setStrokeCap-BeK7IIE(i3);
        }
        if (!StrokeJoin.equals-impl0(paint.getStrokeJoin-LxFBmk8(), i4)) {
            paint.setStrokeJoin-Ww9F2mQ(i4);
        }
        if (!Intrinsics.areEqual(paint.getPathEffect(), obj2)) {
            paint.setPathEffect(obj2);
        }
        if (!FilterQuality.equals-impl0(paint.getFilterQuality-f-v9h1I(), i6)) {
            paint.setFilterQuality-vDHp3xo(i6);
        }
        return strokePaint;
    }

    static Paint configureStrokePaint-ho4zsrM$default(androidx.compose.ui.graphics.drawscope.CanvasDrawScope canvasDrawScope, Brush brush2, float f3, float f4, int i5, int i6, PathEffect pathEffect7, float f8, ColorFilter colorFilter9, int i10, int i11, int i12, Object object13) {
        int defaultFilterQuality-f-v9h1I;
        int i;
        if (i2 &= 512 != 0) {
            i = defaultFilterQuality-f-v9h1I;
        } else {
            i = i11;
        }
        return canvasDrawScope.configureStrokePaint-ho4zsrM(brush2, f3, f4, i5, i6, pathEffect7, f8, colorFilter9, i10, i);
    }

    public static void getDrawParams$annotations() {
    }

    private final long modulate-5vOe2sY(long $this$modulate_u2d5vOe2sY, float alpha) {
        int alpha-impl;
        long $this$modulate_u2d5vOe2sY2;
        int i3;
        int i6;
        int i;
        int i2;
        int i4;
        int i5;
        long obj10;
        alpha-impl = Float.compare(obj12, i7) == 0 ? 1 : 0;
        if (alpha-impl == 0) {
            obj10 = Color.copy-wmQWz5c$default($this$modulate_u2d5vOe2sY, obj2, alpha-impl * obj12, 0, 0, 0, 14);
        } else {
            $this$modulate_u2d5vOe2sY2 = $this$modulate_u2d5vOe2sY;
        }
        return obj10;
    }

    private final Paint obtainFillPaint() {
        Paint fillPaint;
        Paint paint;
        int $i$a$ApplyCanvasDrawScope$obtainFillPaint$1;
        int fill-TiuSbCo;
        if (this.fillPaint == null) {
            paint = fillPaint;
            int i = 0;
            paint.setStyle-k9PVt8s(PaintingStyle.Companion.getFill-TiuSbCo());
            $i$a$ApplyCanvasDrawScope$obtainFillPaint$1 = 0;
            this.fillPaint = paint;
        }
        return fillPaint;
    }

    private final Paint obtainStrokePaint() {
        Paint strokePaint;
        Paint paint;
        int $i$a$ApplyCanvasDrawScope$obtainStrokePaint$1;
        int stroke-TiuSbCo;
        if (this.strokePaint == null) {
            paint = strokePaint;
            int i = 0;
            paint.setStyle-k9PVt8s(PaintingStyle.Companion.getStroke-TiuSbCo());
            $i$a$ApplyCanvasDrawScope$obtainStrokePaint$1 = 0;
            this.strokePaint = paint;
        }
        return strokePaint;
    }

    private final Paint selectPaint(androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle) {
        Paint strokePaint;
        Paint paint;
        int i2;
        boolean pathEffect2;
        int width;
        boolean cap-KaPHkGw;
        int miter2;
        boolean equals-impl0;
        PathEffect pathEffect;
        int i3;
        int i;
        float miter;
        if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
            strokePaint = obtainFillPaint();
            return strokePaint;
        } else {
            if (!drawStyle instanceof Stroke) {
            } else {
                paint = strokePaint;
                i2 = 0;
                i = 0;
                width = Float.compare(strokeWidth, width2) == 0 ? i3 : i;
                if (width == 0) {
                    paint.setStrokeWidth((Stroke)drawStyle.getWidth());
                }
                if (!StrokeCap.equals-impl0(paint.getStrokeCap-KaPHkGw(), (Stroke)drawStyle.getCap-KaPHkGw())) {
                    paint.setStrokeCap-BeK7IIE((Stroke)drawStyle.getCap-KaPHkGw());
                }
                if (Float.compare(strokeMiterLimit, miter) == 0) {
                } else {
                    i3 = i;
                }
                if (i3 == 0) {
                    paint.setStrokeMiterLimit((Stroke)drawStyle.getMiter());
                }
                if (!StrokeJoin.equals-impl0(paint.getStrokeJoin-LxFBmk8(), (Stroke)drawStyle.getJoin-LxFBmk8())) {
                    paint.setStrokeJoin-Ww9F2mQ((Stroke)drawStyle.getJoin-LxFBmk8());
                }
                if (!Intrinsics.areEqual(paint.getPathEffect(), (Stroke)drawStyle.getPathEffect())) {
                    paint.setPathEffect((Stroke)drawStyle.getPathEffect());
                }
            }
        }
        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
        throw noWhenBranchMatchedException;
    }

    public final void draw-yzxVdVo(Density density, LayoutDirection layoutDirection, Canvas canvas, long size, Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, Unit> block) {
        final int i = 0;
        androidx.compose.ui.graphics.drawscope.CanvasDrawScope.DrawParams drawParams = getDrawParams();
        androidx.compose.ui.graphics.drawscope.CanvasDrawScope.DrawParams drawParams2 = getDrawParams();
        int i2 = 0;
        drawParams2.setDensity(density);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.setSize-uvyYCjk(size);
        canvas.save();
        obj14.invoke(this);
        canvas.restore();
        androidx.compose.ui.graphics.drawscope.CanvasDrawScope.DrawParams drawParams3 = getDrawParams();
        int i3 = 0;
        drawParams3.setDensity(drawParams.component1());
        drawParams3.setLayoutDirection(drawParams.component2());
        drawParams3.setCanvas(drawParams.component3());
        drawParams3.setSize-uvyYCjk(drawParams.component4-NH-jbRc());
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawArc-illE91I(Brush brush, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawArc(Offset.getX-impl(topLeft), Offset.getY-impl(topLeft), x-impl + width-impl, y-impl + height-impl, startAngle, sweepAngle, useCenter, CanvasDrawScope.configurePaint-swdJneE$default(this, brush, blendMode, colorFilter, obj25, obj26, 0, 32, 0));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawArc-yD3GUKo(long color, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode) {
        float height-impl = Size.getHeight-impl(style);
        this.drawParams.getCanvas().drawArc(Offset.getX-impl(size), Offset.getY-impl(size), x-impl + width-impl, y-impl + height-impl, sweepAngle, useCenter, topLeft, CanvasDrawScope.configurePaint-2qPWKa0$default(this, color, height-impl, obj26, blendMode, obj27, obj28, 0, 32));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawCircle-V9BoPsw(Brush brush, float radius, long center, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawCircle-9KIMszo(center, alpha, radius);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawCircle-VaOC9Bg(long color, float radius, long center, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode) {
        final androidx.compose.ui.graphics.drawscope.CanvasDrawScope canvasDrawScope = color;
        this.drawParams.getCanvas().drawCircle-9KIMszo(alpha, canvasDrawScope, center);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(...))
    public void drawImage-9jGpkUE(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode) {
        final int i5 = 0;
        final int i3 = 0;
        final androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle = obj23;
        final ColorFilter colorFilter2 = obj24;
        this.drawParams.getCanvas().drawImageRect-HPBpro0(image, srcOffset, drawStyle, dstOffset, colorFilter2, alpha);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawImage-AZ2fEMs(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
        final androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle = obj23;
        final ColorFilter colorFilter2 = obj24;
        final int i3 = obj26;
        this.drawParams.getCanvas().drawImageRect-HPBpro0(image, srcOffset, drawStyle, dstOffset, colorFilter2, alpha);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawImage-gbVJVH8(ImageBitmap image, long topLeft, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawImage-d-4ec7I(image, topLeft, alpha);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawLine-1RTmtNc(Brush brush, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        final int i2 = alpha;
        final PathEffect pathEffect2 = colorFilter;
        this.drawParams.getCanvas().drawLine-Wko1d7g(start, i2, strokeWidth);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawLine-NGM6Ib0(long color, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        final int miter-LxFBmk8 = StrokeJoin.Companion.getMiter-LxFBmk8();
        Paint strokePaint-Q_0CZUI$default = CanvasDrawScope.configureStrokePaint-Q_0CZUI$default(this, color, obj2, alpha, 1082130432, colorFilter, miter-LxFBmk8, blendMode, obj25, obj26, obj27, 0, 512);
        this.drawParams.getCanvas().drawLine-Wko1d7g(end, strokePaint-Q_0CZUI$default, cap);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawOval-AsUm42w(Brush brush, long topLeft, long size, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawOval(Offset.getX-impl(topLeft), Offset.getY-impl(topLeft), x-impl + width-impl, y-impl + height-impl, CanvasDrawScope.configurePaint-swdJneE$default(this, brush, blendMode, colorFilter, obj22, obj23, 0, 32, 0));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawOval-n-J9OG0(long color, long topLeft, long size, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode) {
        float height-impl = Size.getHeight-impl(style);
        this.drawParams.getCanvas().drawOval(Offset.getX-impl(size), Offset.getY-impl(size), x-impl + width-impl, y-impl + height-impl, CanvasDrawScope.configurePaint-2qPWKa0$default(this, color, height-impl, obj23, blendMode, obj24, obj25, 0, 32));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawPath-GBMwjPU(Path path, Brush brush, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawPath(path, CanvasDrawScope.configurePaint-swdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, 0));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawPath-LG529CI(Path path, long color, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawPath(path, CanvasDrawScope.configurePaint-2qPWKa0$default(this, color, obj3, colorFilter, style, blendMode, obj18, 0, 32));
    }

    public void drawPoints-F8ZwMP8(List<Offset> points, int pointMode, long color, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawPoints-O7TthRY(pointMode, points, CanvasDrawScope.configureStrokePaint-Q_0CZUI$default(this, color, obj2, cap, 1082130432, pathEffect, StrokeJoin.Companion.getMiter-LxFBmk8(), alpha, colorFilter, blendMode, obj25, 0, 512));
    }

    public void drawPoints-Gsft0Ws(List<Offset> points, int pointMode, Brush brush, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawPoints-O7TthRY(pointMode, points, CanvasDrawScope.configureStrokePaint-ho4zsrM$default(this, brush, strokeWidth, 1082130432, cap, StrokeJoin.Companion.getMiter-LxFBmk8(), pathEffect, alpha, colorFilter, blendMode, 0, 512, 0));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawRect-AsUm42w(Brush brush, long topLeft, long size, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawRect(Offset.getX-impl(topLeft), Offset.getY-impl(topLeft), x-impl + width-impl, y-impl + height-impl, CanvasDrawScope.configurePaint-swdJneE$default(this, brush, blendMode, colorFilter, obj22, obj23, 0, 32, 0));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawRect-n-J9OG0(long color, long topLeft, long size, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode) {
        float height-impl = Size.getHeight-impl(style);
        this.drawParams.getCanvas().drawRect(Offset.getX-impl(size), Offset.getY-impl(size), x-impl + width-impl, y-impl + height-impl, CanvasDrawScope.configurePaint-2qPWKa0$default(this, color, height-impl, obj23, blendMode, obj24, obj25, 0, 32));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawRoundRect-ZuiqVtQ(Brush brush, long topLeft, long size, long cornerRadius, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode) {
        final Object obj = this;
        obj.drawParams.getCanvas().drawRoundRect(Offset.getX-impl(topLeft), Offset.getY-impl(topLeft), x-impl + width-impl, y-impl + height-impl, CornerRadius.getX-impl(style), CornerRadius.getY-impl(style), CanvasDrawScope.configurePaint-swdJneE$default(obj, brush, obj25, blendMode, obj26, obj27, 0, 32, 0));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawRoundRect-u-Aw5IA(long color, long topLeft, long size, long cornerRadius, androidx.compose.ui.graphics.drawscope.DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode) {
        final Object obj = this;
        float height-impl = Size.getHeight-impl(style);
        obj.drawParams.getCanvas().drawRoundRect(Offset.getX-impl(size), Offset.getY-impl(size), x-impl + width-impl, y-impl + height-impl, CornerRadius.getX-impl(colorFilter), CornerRadius.getY-impl(colorFilter), CanvasDrawScope.configurePaint-2qPWKa0$default(obj, color, height-impl, obj26, obj27, obj28, obj29, 0, 32));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public float getDensity() {
        return this.drawParams.getDensity().getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public androidx.compose.ui.graphics.drawscope.DrawContext getDrawContext() {
        return this.drawContext;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final androidx.compose.ui.graphics.drawscope.CanvasDrawScope.DrawParams getDrawParams() {
        return this.drawParams;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public float getFontScale() {
        return this.drawParams.getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public LayoutDirection getLayoutDirection() {
        return this.drawParams.getLayoutDirection();
    }
}
