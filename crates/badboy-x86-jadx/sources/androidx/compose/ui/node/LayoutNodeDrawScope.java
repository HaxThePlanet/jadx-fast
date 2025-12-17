package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J<\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020%2\u0008\u0010&\u001a\u0004\u0018\u00010'H\u0000ø\u0001\u0000¢\u0006\u0004\u0008(\u0010)Jq\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u0002002\u0008\u0008\u0002\u00101\u001a\u00020\t2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0003\u00102\u001a\u00020\r2\u0008\u0008\u0002\u00103\u001a\u0002042\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\u00089\u0010:Jq\u0010*\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u0002002\u0008\u0008\u0002\u00101\u001a\u00020\t2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0003\u00102\u001a\u00020\r2\u0008\u0008\u0002\u00103\u001a\u0002042\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\u0008=\u0010>JY\u0010?\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\u0008\u0008\u0002\u0010@\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0003\u00102\u001a\u00020\r2\u0008\u0008\u0002\u00103\u001a\u0002042\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\u0008A\u0010BJY\u0010?\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\u0008\u0008\u0002\u0010@\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0003\u00102\u001a\u00020\r2\u0008\u0008\u0002\u00103\u001a\u0002042\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\u0008C\u0010DJ\u0008\u0010E\u001a\u00020 H\u0016J<\u0010F\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0010&\u001a\u0004\u0018\u00010'H\u0000ø\u0001\u0000¢\u0006\u0004\u0008G\u0010HJO\u0010I\u001a\u00020 2\u0006\u0010J\u001a\u00020K2\u0008\u0008\u0002\u00101\u001a\u00020\t2\u0008\u0008\u0003\u00102\u001a\u00020\r2\u0008\u0008\u0002\u00103\u001a\u0002042\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\u0008L\u0010MJm\u0010I\u001a\u00020 2\u0006\u0010J\u001a\u00020K2\u0008\u0008\u0002\u0010N\u001a\u00020O2\u0008\u0008\u0002\u0010P\u001a\u00020Q2\u0008\u0008\u0002\u0010R\u001a\u00020O2\u0008\u0008\u0002\u0010S\u001a\u00020Q2\u0008\u0008\u0003\u00102\u001a\u00020\r2\u0008\u0008\u0002\u00103\u001a\u0002042\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u000208H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008T\u0010UJw\u0010I\u001a\u00020 2\u0006\u0010J\u001a\u00020K2\u0008\u0008\u0002\u0010N\u001a\u00020O2\u0008\u0008\u0002\u0010P\u001a\u00020Q2\u0008\u0008\u0002\u0010R\u001a\u00020O2\u0008\u0008\u0002\u0010S\u001a\u00020Q2\u0008\u0008\u0003\u00102\u001a\u00020\r2\u0008\u0008\u0002\u00103\u001a\u0002042\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u0002082\u0008\u0008\u0002\u0010V\u001a\u00020WH\u0096\u0001ø\u0001\u0000¢\u0006\u0004\u0008X\u0010YJk\u0010Z\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\u0006\u0010[\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\t2\u0008\u0008\u0002\u0010]\u001a\u00020\r2\u0008\u0008\u0002\u0010^\u001a\u00020_2\n\u0008\u0002\u0010`\u001a\u0004\u0018\u00010a2\u0008\u0008\u0003\u00102\u001a\u00020\r2\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\u0008b\u0010cJk\u0010Z\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\u0006\u0010[\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\t2\u0008\u0008\u0002\u0010]\u001a\u00020\r2\u0008\u0008\u0002\u0010^\u001a\u00020_2\n\u0008\u0002\u0010`\u001a\u0004\u0018\u00010a2\u0008\u0008\u0003\u00102\u001a\u00020\r2\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\u0008d\u0010eJY\u0010f\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\u0008\u0008\u0002\u00101\u001a\u00020\t2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0003\u00102\u001a\u00020\r2\u0008\u0008\u0002\u00103\u001a\u0002042\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\u0008g\u0010hJY\u0010f\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\u0008\u0008\u0002\u00101\u001a\u00020\t2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0003\u00102\u001a\u00020\r2\u0008\u0008\u0002\u00103\u001a\u0002042\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\u0008i\u0010jJM\u0010k\u001a\u00020 2\u0006\u0010l\u001a\u00020m2\u0006\u0010+\u001a\u00020,2\u0008\u0008\u0003\u00102\u001a\u00020\r2\u0008\u0008\u0002\u00103\u001a\u0002042\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\u0008n\u0010oJM\u0010k\u001a\u00020 2\u0006\u0010l\u001a\u00020m2\u0006\u0010;\u001a\u00020<2\u0008\u0008\u0003\u00102\u001a\u00020\r2\u0008\u0008\u0002\u00103\u001a\u0002042\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\u0008p\u0010qJq\u0010r\u001a\u00020 2\u000c\u0010s\u001a\u0008\u0012\u0004\u0012\u00020\t0t2\u0006\u0010u\u001a\u00020v2\u0006\u0010+\u001a\u00020,2\u0008\u0008\u0002\u0010]\u001a\u00020\r2\u0008\u0008\u0002\u0010^\u001a\u00020_2\n\u0008\u0002\u0010`\u001a\u0004\u0018\u00010a2\u0008\u0008\u0003\u00102\u001a\u00020\r2\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\u0008w\u0010xJq\u0010r\u001a\u00020 2\u000c\u0010s\u001a\u0008\u0012\u0004\u0012\u00020\t0t2\u0006\u0010u\u001a\u00020v2\u0006\u0010;\u001a\u00020<2\u0008\u0008\u0002\u0010]\u001a\u00020\r2\u0008\u0008\u0002\u0010^\u001a\u00020_2\n\u0008\u0002\u0010`\u001a\u0004\u0018\u00010a2\u0008\u0008\u0003\u00102\u001a\u00020\r2\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\u0008y\u0010zJY\u0010{\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\u0008\u0008\u0002\u00101\u001a\u00020\t2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0003\u00102\u001a\u00020\r2\u0008\u0008\u0002\u00103\u001a\u0002042\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\u0008|\u0010hJY\u0010{\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\u0008\u0008\u0002\u00101\u001a\u00020\t2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0003\u00102\u001a\u00020\r2\u0008\u0008\u0002\u00103\u001a\u0002042\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\u0008}\u0010jJf\u0010~\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\u0008\u0008\u0002\u00101\u001a\u00020\t2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\t\u0008\u0002\u0010\u007f\u001a\u00030\u0080\u00012\u0008\u0008\u0003\u00102\u001a\u00020\r2\u0008\u0008\u0002\u00103\u001a\u0002042\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0006\u0008\u0081\u0001\u0010\u0082\u0001Jf\u0010~\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\u0008\u0008\u0002\u00101\u001a\u00020\t2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\t\u0008\u0002\u0010\u007f\u001a\u00030\u0080\u00012\u0008\u0008\u0002\u00103\u001a\u0002042\u0008\u0008\u0003\u00102\u001a\u00020\r2\n\u0008\u0002\u00105\u001a\u0004\u0018\u0001062\u0008\u0008\u0002\u00107\u001a\u000208H\u0096\u0001ø\u0001\u0000¢\u0006\u0006\u0008\u0083\u0001\u0010\u0084\u0001J\u001d\u0010\u0085\u0001\u001a\u00020 *\u00020\u00152\u0006\u0010!\u001a\u00020\"2\u0008\u0010&\u001a\u0004\u0018\u00010'J@\u0010\u0086\u0001\u001a\u00020 *\u00020'2\u0008\u0008\u0002\u0010\u001c\u001a\u00020Q2\u001a\u0010\u0087\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 0\u0088\u0001¢\u0006\u0003\u0008\u0089\u0001H\u0096\u0001ø\u0001\u0000¢\u0006\u0006\u0008\u008a\u0001\u0010\u008b\u0001J\u001c\u0010\u008c\u0001\u001a\u00030\u008d\u0001*\u00030\u008e\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\u0008\u008f\u0001\u0010\u0090\u0001J\u001c\u0010\u008c\u0001\u001a\u00030\u008d\u0001*\u00030\u0091\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\u0008\u0092\u0001\u0010\u0093\u0001J\u001c\u0010\u0094\u0001\u001a\u00030\u008e\u0001*\u00030\u0091\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\u0008\u0095\u0001\u0010\u0096\u0001J\u001e\u0010\u0094\u0001\u001a\u00030\u008e\u0001*\u00020\rH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\u0008\u0097\u0001\u0010\u0098\u0001J\u001f\u0010\u0094\u0001\u001a\u00030\u008e\u0001*\u00030\u008d\u0001H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\u0008\u0097\u0001\u0010\u0099\u0001J\u001b\u0010\u009a\u0001\u001a\u00030\u009b\u0001*\u00020\u001dH\u0097\u0001ø\u0001\u0000¢\u0006\u0006\u0008\u009c\u0001\u0010\u009d\u0001J\u001b\u0010\u009e\u0001\u001a\u00020\r*\u00030\u008e\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\u0008\u009f\u0001\u0010\u0098\u0001J\u001b\u0010\u009e\u0001\u001a\u00020\r*\u00030\u0091\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\u0008 \u0001\u0010\u0096\u0001J\u0010\u0010¡\u0001\u001a\u00030¢\u0001*\u00030£\u0001H\u0097\u0001J\u001b\u0010¤\u0001\u001a\u00020\u001d*\u00030\u009b\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\u0008¥\u0001\u0010\u009d\u0001J\u001c\u0010¦\u0001\u001a\u00030\u0091\u0001*\u00030\u008e\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\u0008§\u0001\u0010¨\u0001J\u001e\u0010¦\u0001\u001a\u00030\u0091\u0001*\u00020\rH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\u0008©\u0001\u0010¨\u0001J\u001f\u0010¦\u0001\u001a\u00030\u0091\u0001*\u00030\u008d\u0001H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\u0008©\u0001\u0010ª\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u001a\u0010\u0008\u001a\u00020\t8VX\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u000c\u001a\u00020\r8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\r8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u000fR\u0012\u0010\u0018\u001a\u00020\u0019X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u000b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006«\u0001", d2 = {"Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "getCanvasDrawScope", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "density", "", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawNode", "Landroidx/compose/ui/node/DrawModifierNode;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "draw", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/Modifier$Node;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "draw-eZhPAX0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "drawArc", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "sweepAngle", "useCenter", "", "topLeft", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawContent", "drawDirect", "drawDirect-eZhPAX0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/node/DrawModifierNode;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "performDraw", "record", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "record-JVtK1S4", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;JLkotlin/jvm/functions/Function1;)V", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LayoutNodeDrawScope implements DrawScope, ContentDrawScope {

    public static final int $stable;
    private final CanvasDrawScope canvasDrawScope;
    private androidx.compose.ui.node.DrawModifierNode drawNode;
    static {
    }

    public LayoutNodeDrawScope() {
        final int i = 0;
        super(i, 1, i);
    }

    public LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope) {
        super();
        this.canvasDrawScope = canvasDrawScope;
    }

    public LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        CanvasDrawScope obj1;
        if (i2 &= 1 != 0) {
            obj1 = new CanvasDrawScope();
        }
        super(obj1);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final void draw-eZhPAX0$ui_release(Canvas canvas, long size, androidx.compose.ui.node.NodeCoordinator coordinator, Modifier.Node drawNode, GraphicsLayer layer) {
        int kind$iv2;
        int stack$iv;
        Object node$iv;
        int this_$iv$iv;
        Object obj2;
        Canvas canvas2;
        long l;
        androidx.compose.ui.node.NodeCoordinator mutableVector;
        Object node$iv$iv;
        Object obj;
        int i;
        int this_$iv$iv2;
        int i2;
        int i3;
        int kind$iv;
        int i4 = 0;
        kind$iv2 = NodeKind.constructor-impl(4);
        final int i6 = 0;
        stack$iv = 0;
        int i7 = 0;
        node$iv = obj3;
        while (node$iv != null) {
            if (node$iv instanceof DrawModifierNode) {
            } else {
            }
            obj2 = 0;
            l = 0;
            if (kindSet$ui_release &= kind$iv2 != 0) {
            } else {
            }
            this_$iv$iv = l;
            if (this_$iv$iv != 0 && node$iv instanceof DelegatingNode) {
            } else {
            }
            kind$iv = kind$iv2;
            node$iv = DelegatableNodeKt.access$pop(stack$iv);
            kind$iv2 = kind$iv;
            if (node$iv instanceof DelegatingNode) {
            } else {
            }
            this_$iv$iv = 0;
            canvas2 = 0;
            node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
            while (node$iv$iv != null) {
                obj = node$iv$iv;
                i = 0;
                i2 = 0;
                if (kindSet$ui_release2 &= kind$iv2 != 0) {
                } else {
                }
                this_$iv$iv2 = l;
                if (this_$iv$iv2 != 0) {
                } else {
                }
                kind$iv = kind$iv2;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                kind$iv2 = kind$iv;
                mutableVector = 1;
                if (this_$iv$iv++ == mutableVector) {
                } else {
                }
                if (stack$iv == 0) {
                } else {
                }
                kind$iv = kind$iv2;
                mutableVector = stack$iv;
                stack$iv = mutableVector;
                kind$iv2 = node$iv;
                if (kind$iv2 != null && stack$iv != null) {
                }
                if (stack$iv != null) {
                }
                stack$iv.add(obj);
                if (stack$iv != null) {
                }
                node$iv = 0;
                stack$iv.add(kind$iv2);
                this_$iv$iv2 = 0;
                i3 = 0;
                kind$iv = kind$iv2;
                mutableVector = new MutableVector(new Modifier.Node[16], l);
                node$iv = obj;
                kind$iv = kind$iv2;
                this_$iv$iv2 = mutableVector;
            }
            if (this_$iv$iv == 1) {
            } else {
            }
            kind$iv2 = kind$iv;
            obj = node$iv$iv;
            i = 0;
            i2 = 0;
            if (kindSet$ui_release2 &= kind$iv2 != 0) {
            } else {
            }
            this_$iv$iv2 = l;
            if (this_$iv$iv2 != 0) {
            } else {
            }
            kind$iv = kind$iv2;
            node$iv$iv = node$iv$iv.getChild$ui_release();
            kind$iv2 = kind$iv;
            mutableVector = 1;
            if (this_$iv$iv++ == mutableVector) {
            } else {
            }
            if (stack$iv == 0) {
            } else {
            }
            kind$iv = kind$iv2;
            mutableVector = stack$iv;
            stack$iv = mutableVector;
            kind$iv2 = node$iv;
            if (kind$iv2 != null && stack$iv != null) {
            }
            if (stack$iv != null) {
            }
            stack$iv.add(obj);
            if (stack$iv != null) {
            }
            node$iv = 0;
            stack$iv.add(kind$iv2);
            this_$iv$iv2 = 0;
            i3 = 0;
            kind$iv = kind$iv2;
            mutableVector = new MutableVector(new Modifier.Node[16], l);
            node$iv = obj;
            kind$iv = kind$iv2;
            this_$iv$iv2 = mutableVector;
            this_$iv$iv = mutableVector;
            this_$iv$iv = 0;
            this.drawDirect-eZhPAX0$ui_release(canvas, size, mutableVector, drawNode, (DrawModifierNode)node$iv);
            kind$iv = kind$iv2;
        }
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawArc-illE91I(Brush brush, float f2, float f3, boolean z4, long l5, long l6, float f7, DrawStyle drawStyle8, ColorFilter colorFilter9, int i10) {
        this.canvasDrawScope.drawArc-illE91I(brush, f2, f3, z4, l5, obj6, f7, obj8, colorFilter9, i10);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawArc-yD3GUKo(long l, float f2, float f3, boolean z4, long l5, long l6, float f7, DrawStyle drawStyle8, ColorFilter colorFilter9, int i10) {
        this.canvasDrawScope.drawArc-yD3GUKo(l, obj2, f3, z4, l5, l6, obj7, drawStyle8, obj9, i10);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawCircle-V9BoPsw(Brush brush, float f2, long l3, float f4, DrawStyle drawStyle5, ColorFilter colorFilter6, int i7) {
        this.canvasDrawScope.drawCircle-V9BoPsw(brush, f2, l3, obj4, drawStyle5, colorFilter6, i7);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawCircle-VaOC9Bg(long l, float f2, long l3, float f4, DrawStyle drawStyle5, ColorFilter colorFilter6, int i7) {
        this.canvasDrawScope.drawCircle-VaOC9Bg(l, obj2, l3, f4, obj5, colorFilter6, i7);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawContent() {
        Object requireCoordinator-64DMado;
        int mutableVector;
        Object $this$drawIntoCanvas$iv2;
        Modifier.Node $this$drawIntoCanvas$iv;
        int graphicsLayer;
        int $i$f$drawIntoCanvas;
        int constructor-impl;
        Modifier.Node node2;
        int i3;
        int stack$iv;
        Modifier.Node node$iv;
        int this_$iv$iv;
        Modifier.Node node;
        int graphicsLayer2;
        int i2;
        Modifier.Node node$iv$iv;
        Modifier.Node node3;
        int i;
        int this_$iv$iv2;
        int i4;
        int i5;
        Object $this$drawIntoCanvas$iv3;
        Object $this$drawIntoCanvas$iv4;
        int i6;
        int i7;
        requireCoordinator-64DMado = this;
        $this$drawIntoCanvas$iv2 = requireCoordinator-64DMado;
        Canvas canvas = (DrawScope)$this$drawIntoCanvas$iv2.getDrawContext().getCanvas();
        final int i9 = 0;
        final androidx.compose.ui.node.DrawModifierNode drawNode = requireCoordinator-64DMado.drawNode;
        Intrinsics.checkNotNull(drawNode);
        Modifier.Node node5 = LayoutNodeDrawScopeKt.access$nextDrawNode((DelegatableNode)drawNode);
        constructor-impl = 4;
        if (node5 != null) {
            int i10 = 0;
            constructor-impl = NodeKind.constructor-impl(constructor-impl);
            i3 = 0;
            stack$iv = 0;
            int i11 = 0;
            node$iv = node2;
            while (node$iv != null) {
                if (node$iv instanceof DrawModifierNode) {
                } else {
                }
                node = 0;
                if (kindSet$ui_release &= constructor-impl != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0 && node$iv instanceof DelegatingNode) {
                } else {
                }
                $this$drawIntoCanvas$iv4 = $this$drawIntoCanvas$iv2;
                i7 = graphicsLayer;
                node$iv = DelegatableNodeKt.access$pop(stack$iv);
                requireCoordinator-64DMado = this;
                $this$drawIntoCanvas$iv2 = $this$drawIntoCanvas$iv4;
                graphicsLayer = i7;
                if (node$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv = 0;
                graphicsLayer2 = 0;
                node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                while (node$iv$iv != null) {
                    node3 = node$iv$iv;
                    i = 0;
                    i4 = 0;
                    if (kindSet$ui_release2 &= constructor-impl != 0) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    if (this_$iv$iv2 != 0) {
                    } else {
                    }
                    $this$drawIntoCanvas$iv4 = $this$drawIntoCanvas$iv2;
                    i7 = graphicsLayer;
                    $this$drawIntoCanvas$iv = node3;
                    $i$f$drawIntoCanvas = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    requireCoordinator-64DMado = this;
                    $this$drawIntoCanvas$iv2 = $this$drawIntoCanvas$iv4;
                    graphicsLayer = i7;
                    i2 = 1;
                    if (this_$iv$iv++ == i2) {
                    } else {
                    }
                    if (stack$iv == 0) {
                    } else {
                    }
                    $this$drawIntoCanvas$iv4 = $this$drawIntoCanvas$iv2;
                    i7 = graphicsLayer;
                    $i$f$drawIntoCanvas = 0;
                    mutableVector = stack$iv;
                    stack$iv = mutableVector;
                    requireCoordinator-64DMado = node$iv;
                    if (requireCoordinator-64DMado != null && stack$iv != 0) {
                    }
                    if (stack$iv != 0) {
                    } else {
                    }
                    $this$drawIntoCanvas$iv = node3;
                    stack$iv.add(node3);
                    if (stack$iv != 0) {
                    }
                    node$iv = $this$drawIntoCanvas$iv2;
                    stack$iv.add(requireCoordinator-64DMado);
                    this_$iv$iv2 = 0;
                    i5 = 0;
                    $this$drawIntoCanvas$iv4 = $this$drawIntoCanvas$iv2;
                    i7 = graphicsLayer;
                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                    node$iv = node3;
                    $this$drawIntoCanvas$iv4 = $this$drawIntoCanvas$iv2;
                    i7 = graphicsLayer;
                    $this$drawIntoCanvas$iv = node3;
                    $i$f$drawIntoCanvas = 0;
                    this_$iv$iv2 = i2;
                }
                if (this_$iv$iv == 1) {
                } else {
                }
                requireCoordinator-64DMado = this;
                $this$drawIntoCanvas$iv2 = $this$drawIntoCanvas$iv4;
                graphicsLayer = i7;
                node3 = node$iv$iv;
                i = 0;
                i4 = 0;
                if (kindSet$ui_release2 &= constructor-impl != 0) {
                } else {
                }
                this_$iv$iv2 = 0;
                if (this_$iv$iv2 != 0) {
                } else {
                }
                $this$drawIntoCanvas$iv4 = $this$drawIntoCanvas$iv2;
                i7 = graphicsLayer;
                $this$drawIntoCanvas$iv = node3;
                $i$f$drawIntoCanvas = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                requireCoordinator-64DMado = this;
                $this$drawIntoCanvas$iv2 = $this$drawIntoCanvas$iv4;
                graphicsLayer = i7;
                i2 = 1;
                if (this_$iv$iv++ == i2) {
                } else {
                }
                if (stack$iv == 0) {
                } else {
                }
                $this$drawIntoCanvas$iv4 = $this$drawIntoCanvas$iv2;
                i7 = graphicsLayer;
                $i$f$drawIntoCanvas = 0;
                mutableVector = stack$iv;
                stack$iv = mutableVector;
                requireCoordinator-64DMado = node$iv;
                if (requireCoordinator-64DMado != null && stack$iv != 0) {
                }
                if (stack$iv != 0) {
                } else {
                }
                $this$drawIntoCanvas$iv = node3;
                stack$iv.add(node3);
                if (stack$iv != 0) {
                }
                node$iv = $this$drawIntoCanvas$iv2;
                stack$iv.add(requireCoordinator-64DMado);
                this_$iv$iv2 = 0;
                i5 = 0;
                $this$drawIntoCanvas$iv4 = $this$drawIntoCanvas$iv2;
                i7 = graphicsLayer;
                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                node$iv = node3;
                $this$drawIntoCanvas$iv4 = $this$drawIntoCanvas$iv2;
                i7 = graphicsLayer;
                $this$drawIntoCanvas$iv = node3;
                $i$f$drawIntoCanvas = 0;
                this_$iv$iv2 = i2;
                this_$iv$iv = i2;
                node = 0;
                requireCoordinator-64DMado.performDraw((DrawModifierNode)node$iv, canvas, requireCoordinator-64DMado.getDrawContext().getGraphicsLayer());
                $this$drawIntoCanvas$iv4 = $this$drawIntoCanvas$iv2;
                i7 = graphicsLayer;
            }
            $this$drawIntoCanvas$iv3 = $this$drawIntoCanvas$iv2;
            i6 = graphicsLayer;
        } else {
            $this$drawIntoCanvas$iv3 = $this$drawIntoCanvas$iv2;
            i6 = graphicsLayer;
            int i8 = 0;
            requireCoordinator-64DMado = DelegatableNodeKt.requireCoordinator-64DMado((DelegatableNode)drawNode, NodeKind.constructor-impl(constructor-impl));
            if (requireCoordinator-64DMado.getTail() == drawNode.getNode()) {
                Intrinsics.checkNotNull(requireCoordinator-64DMado.getWrapped$ui_release());
            } else {
                $this$drawIntoCanvas$iv2 = requireCoordinator-64DMado;
            }
            $this$drawIntoCanvas$iv2.performDraw(canvas, getDrawContext().getGraphicsLayer());
        }
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final void drawDirect-eZhPAX0$ui_release(Canvas canvas, long size, androidx.compose.ui.node.NodeCoordinator coordinator, androidx.compose.ui.node.DrawModifierNode drawNode, GraphicsLayer layer) {
        final Object obj = this;
        obj.drawNode = layer;
        LayoutDirection layoutDirection = drawNode.getLayoutDirection();
        final CanvasDrawScope canvasDrawScope3 = canvasDrawScope;
        final int i3 = 0;
        DrawContext drawContext6 = canvasDrawScope3.getDrawContext();
        int i5 = 0;
        drawContext6.setDensity((Density)drawNode);
        drawContext6.setLayoutDirection(layoutDirection);
        Canvas canvas3 = canvas;
        drawContext6.setCanvas(canvas3);
        final LayoutDirection layoutDirection3 = layoutDirection;
        drawContext6.setSize-uvyYCjk(size);
        drawContext6.setGraphicsLayer(obj24);
        canvas3.save();
        int i = 0;
        final int i6 = 0;
        final CanvasDrawScope canvasDrawScope4 = canvasDrawScope2;
        layer.draw((ContentDrawScope)obj);
        canvas3.restore();
        DrawContext drawContext7 = canvasDrawScope3.getDrawContext();
        int i2 = 0;
        drawContext7.setDensity(canvasDrawScope3.getDrawContext().getDensity());
        drawContext7.setLayoutDirection(canvasDrawScope3.getDrawContext().getLayoutDirection());
        drawContext7.setCanvas(canvasDrawScope3.getDrawContext().getCanvas());
        drawContext7.setSize-uvyYCjk(canvasDrawScope3.getDrawContext().getSize-NH-jbRc());
        drawContext7.setGraphicsLayer(canvasDrawScope3.getDrawContext().getGraphicsLayer());
        obj.drawNode = obj.drawNode;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(...))
    public void drawImage-9jGpkUE(ImageBitmap imageBitmap, long l2, long l3, long l4, long l5, float f6, DrawStyle drawStyle7, ColorFilter colorFilter8, int i9) {
        this.canvasDrawScope.drawImage-9jGpkUE(imageBitmap, l2, obj3, l4, obj5, f6, obj7, colorFilter8, obj9);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawImage-AZ2fEMs(ImageBitmap imageBitmap, long l2, long l3, long l4, long l5, float f6, DrawStyle drawStyle7, ColorFilter colorFilter8, int i9, int i10) {
        obj.canvasDrawScope.drawImage-AZ2fEMs(imageBitmap, l2, obj4, l4, obj6, f6, obj8, colorFilter8, obj10, i10);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawImage-gbVJVH8(ImageBitmap imageBitmap, long l2, float f3, DrawStyle drawStyle4, ColorFilter colorFilter5, int i6) {
        this.canvasDrawScope.drawImage-gbVJVH8(imageBitmap, l2, obj3, drawStyle4, colorFilter5, i6);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawLine-1RTmtNc(Brush brush, long l2, long l3, float f4, int i5, PathEffect pathEffect6, float f7, ColorFilter colorFilter8, int i9) {
        this.canvasDrawScope.drawLine-1RTmtNc(brush, l2, obj3, f4, obj5, pathEffect6, f7, colorFilter8, i9);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawLine-NGM6Ib0(long l, long l2, long l3, float f4, int i5, PathEffect pathEffect6, float f7, ColorFilter colorFilter8, int i9) {
        this.canvasDrawScope.drawLine-NGM6Ib0(l, obj2, l3, obj4, i5, obj6, f7, colorFilter8, i9);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawOval-AsUm42w(Brush brush, long l2, long l3, float f4, DrawStyle drawStyle5, ColorFilter colorFilter6, int i7) {
        this.canvasDrawScope.drawOval-AsUm42w(brush, l2, obj3, f4, obj5, colorFilter6, i7);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawOval-n-J9OG0(long l, long l2, long l3, float f4, DrawStyle drawStyle5, ColorFilter colorFilter6, int i7) {
        this.canvasDrawScope.drawOval-n-J9OG0(l, obj2, l3, obj4, drawStyle5, obj6, i7);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawPath-GBMwjPU(Path path, Brush brush2, float f3, DrawStyle drawStyle4, ColorFilter colorFilter5, int i6) {
        this.canvasDrawScope.drawPath-GBMwjPU(path, brush2, f3, drawStyle4, colorFilter5, i6);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawPath-LG529CI(Path path, long l2, float f3, DrawStyle drawStyle4, ColorFilter colorFilter5, int i6) {
        this.canvasDrawScope.drawPath-LG529CI(path, l2, obj3, drawStyle4, colorFilter5, i6);
    }

    public void drawPoints-F8ZwMP8(List<Offset> list, int i2, long l3, float f4, int i5, PathEffect pathEffect6, float f7, ColorFilter colorFilter8, int i9) {
        this.canvasDrawScope.drawPoints-F8ZwMP8(list, i2, l3, obj4, i5, pathEffect6, f7, colorFilter8, i9);
    }

    public void drawPoints-Gsft0Ws(List<Offset> list, int i2, Brush brush3, float f4, int i5, PathEffect pathEffect6, float f7, ColorFilter colorFilter8, int i9) {
        this.canvasDrawScope.drawPoints-Gsft0Ws(list, i2, brush3, f4, i5, pathEffect6, f7, colorFilter8, i9);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawRect-AsUm42w(Brush brush, long l2, long l3, float f4, DrawStyle drawStyle5, ColorFilter colorFilter6, int i7) {
        this.canvasDrawScope.drawRect-AsUm42w(brush, l2, obj3, f4, obj5, colorFilter6, i7);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawRect-n-J9OG0(long l, long l2, long l3, float f4, DrawStyle drawStyle5, ColorFilter colorFilter6, int i7) {
        this.canvasDrawScope.drawRect-n-J9OG0(l, obj2, l3, obj4, drawStyle5, obj6, i7);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawRoundRect-ZuiqVtQ(Brush brush, long l2, long l3, long l4, float f5, DrawStyle drawStyle6, ColorFilter colorFilter7, int i8) {
        this.canvasDrawScope.drawRoundRect-ZuiqVtQ(brush, l2, obj3, l4, obj5, drawStyle6, obj7, i8);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public void drawRoundRect-u-Aw5IA(long l, long l2, long l3, long l4, DrawStyle drawStyle5, float f6, ColorFilter colorFilter7, int i8) {
        this.canvasDrawScope.drawRoundRect-u-Aw5IA(l, obj2, l3, obj4, drawStyle5, obj6, colorFilter7, obj8);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final CanvasDrawScope getCanvasDrawScope() {
        return this.canvasDrawScope;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public long getCenter-F1C5BW0() {
        return this.canvasDrawScope.getCenter-F1C5BW0();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public DrawContext getDrawContext() {
        return this.canvasDrawScope.getDrawContext();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.getLayoutDirection();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public long getSize-NH-jbRc() {
        return this.canvasDrawScope.getSize-NH-jbRc();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final void performDraw(androidx.compose.ui.node.DrawModifierNode $this$performDraw, Canvas canvas, GraphicsLayer layer) {
        int i = 0;
        int constructor-impl = NodeKind.constructor-impl(4);
        final androidx.compose.ui.node.NodeCoordinator requireCoordinator-64DMado = DelegatableNodeKt.requireCoordinator-64DMado((DelegatableNode)$this$performDraw, constructor-impl);
        requireCoordinator-64DMado.getLayoutNode().getMDrawScope$ui_release().drawDirect-eZhPAX0$ui_release(canvas, IntSizeKt.toSize-ozmzZPI(requireCoordinator-64DMado.getSize-YbymL2g()), obj5, requireCoordinator-64DMado, $this$performDraw);
    }

    public void record-JVtK1S4(GraphicsLayer graphicsLayer, long l2, Function1<? super DrawScope, Unit> function13) {
        this.canvasDrawScope.record-JVtK1S4(graphicsLayer, l2, function13);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public int roundToPx--R2X_6o(long l) {
        return this.canvasDrawScope.roundToPx--R2X_6o(l);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public int roundToPx-0680j_4(float f) {
        return this.canvasDrawScope.roundToPx-0680j_4(f);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public float toDp-GaN1DYA(long l) {
        return this.canvasDrawScope.toDp-GaN1DYA(l);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public float toDp-u2uoSUM(float f) {
        return this.canvasDrawScope.toDp-u2uoSUM(f);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public float toDp-u2uoSUM(int i) {
        return this.canvasDrawScope.toDp-u2uoSUM(i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public long toDpSize-k-rfVVM(long l) {
        return this.canvasDrawScope.toDpSize-k-rfVVM(l);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public float toPx--R2X_6o(long l) {
        return this.canvasDrawScope.toPx--R2X_6o(l);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public float toPx-0680j_4(float f) {
        return this.canvasDrawScope.toPx-0680j_4(f);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public Rect toRect(DpRect dpRect) {
        return this.canvasDrawScope.toRect(dpRect);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public long toSize-XkaWNTQ(long l) {
        return this.canvasDrawScope.toSize-XkaWNTQ(l);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public long toSp-0xMU5do(float f) {
        return this.canvasDrawScope.toSp-0xMU5do(f);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public long toSp-kPz2Gy4(float f) {
        return this.canvasDrawScope.toSp-kPz2Gy4(f);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public long toSp-kPz2Gy4(int i) {
        return this.canvasDrawScope.toSp-kPz2Gy4(i);
    }
}
