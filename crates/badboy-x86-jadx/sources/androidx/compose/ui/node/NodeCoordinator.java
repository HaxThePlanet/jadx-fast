package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\"\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u001c\n\u0002\u0018\u0002\n\u0002\u0008\u001c\n\u0002\u0018\u0002\n\u0002\u0008&\u0008 \u0018\u0000 ®\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004®\u0002¯\u0002B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010\u0095\u0001\u001a\u00020\u001e2\u0007\u0010\u0096\u0001\u001a\u00020\u00002\u0007\u0010\u0097\u0001\u001a\u00020\u000b2\u0007\u0010\u0098\u0001\u001a\u00020%H\u0002J2\u0010\u0095\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u00002\u0008\u0010\u009a\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u009b\u0001\u001a\u00020%H\u0002ø\u0001\u0000¢\u0006\u0006\u0008\u009c\u0001\u0010\u009d\u0001J\u001d\u0010\u009e\u0001\u001a\u00020`2\u0006\u0010_\u001a\u00020`H\u0004ø\u0001\u0000¢\u0006\u0006\u0008\u009f\u0001\u0010 \u0001J'\u0010¡\u0001\u001a\u00020\u00172\u0008\u0010¢\u0001\u001a\u00030\u0099\u00012\u0006\u0010_\u001a\u00020`H\u0004ø\u0001\u0000¢\u0006\u0006\u0008£\u0001\u0010¤\u0001J\u001b\u0010¥\u0001\u001a\u00020\u001e2\u0007\u0010¦\u0001\u001a\u00020\u001c2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u001dJ\u001c\u0010¨\u0001\u001a\u00020\u001e2\u0007\u0010¦\u0001\u001a\u00020\u001c2\u0008\u0010©\u0001\u001a\u00030ª\u0001H\u0004J\u001d\u0010«\u0001\u001a\u00020\u001e2\u0007\u0010¦\u0001\u001a\u00020\u001c2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u001dH\u0002J\t\u0010¬\u0001\u001a\u00020\u001eH&J\u0018\u0010­\u0001\u001a\u00020\u00002\u0007\u0010®\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\u0008¯\u0001J*\u0010°\u0001\u001a\u00030\u0099\u00012\u0007\u0010q\u001a\u00030\u0099\u00012\t\u0008\u0002\u0010\u009b\u0001\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0006\u0008±\u0001\u0010²\u0001J\u001b\u0010³\u0001\u001a\u00020\u001e2\u0007\u0010´\u0001\u001a\u00020\u000b2\u0007\u0010\u0098\u0001\u001a\u00020%H\u0002J#\u0010µ\u0001\u001a\u00020%2\u000c\u0010¶\u0001\u001a\u0007\u0012\u0002\u0008\u00030·\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\u0008¸\u0001\u0010¹\u0001J$\u0010º\u0001\u001a\u0005\u0018\u00010\u0086\u00012\u000c\u0010¶\u0001\u001a\u0007\u0012\u0002\u0008\u00030·\u0001ø\u0001\u0000¢\u0006\u0006\u0008»\u0001\u0010¼\u0001J\u0015\u0010½\u0001\u001a\u0005\u0018\u00010\u0086\u00012\u0007\u0010¾\u0001\u001a\u00020%H\u0002JC\u0010¿\u0001\u001a\u00020\u001e2\u0008\u0010À\u0001\u001a\u00030Á\u00012\u0008\u0010¢\u0001\u001a\u00030\u0099\u00012\u0008\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020%2\u0007\u0010Å\u0001\u001a\u00020%ø\u0001\u0000¢\u0006\u0006\u0008Æ\u0001\u0010Ç\u0001JE\u0010È\u0001\u001a\u00020\u001e2\u0008\u0010À\u0001\u001a\u00030Á\u00012\u0008\u0010¢\u0001\u001a\u00030\u0099\u00012\u0008\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020%2\u0007\u0010Å\u0001\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0006\u0008É\u0001\u0010Ç\u0001J\t\u0010Ê\u0001\u001a\u00020\u001eH\u0016J\u001f\u0010Ë\u0001\u001a\u00020%2\u0008\u0010¢\u0001\u001a\u00030\u0099\u0001H\u0004ø\u0001\u0000¢\u0006\u0006\u0008Ì\u0001\u0010Í\u0001J\u0007\u0010Î\u0001\u001a\u00020%J\u001c\u0010Ï\u0001\u001a\u00030Ð\u00012\u0007\u0010Ñ\u0001\u001a\u00020\u00032\u0007\u0010\u0098\u0001\u001a\u00020%H\u0016J)\u0010Ò\u0001\u001a\u00030\u0099\u00012\u0007\u0010Ñ\u0001\u001a\u00020\u00032\u0008\u0010Ó\u0001\u001a\u00030\u0099\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\u0008Ô\u0001\u0010Õ\u0001J2\u0010Ò\u0001\u001a\u00030\u0099\u00012\u0007\u0010Ñ\u0001\u001a\u00020\u00032\u0008\u0010Ó\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u009b\u0001\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0006\u0008Ö\u0001\u0010×\u0001J \u0010Ø\u0001\u001a\u00030\u0099\u00012\u0008\u0010Ù\u0001\u001a\u00030\u0099\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\u0008Ú\u0001\u0010 \u0001J \u0010Û\u0001\u001a\u00030\u0099\u00012\u0008\u0010Ù\u0001\u001a\u00030\u0099\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\u0008Ü\u0001\u0010 \u0001J \u0010Ý\u0001\u001a\u00030\u0099\u00012\u0008\u0010Ù\u0001\u001a\u00030\u0099\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\u0008Þ\u0001\u0010 \u0001J \u0010ß\u0001\u001a\u00030\u0099\u00012\u0008\u0010¢\u0001\u001a\u00030\u0099\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\u0008à\u0001\u0010 \u0001J\u000f\u0010á\u0001\u001a\u00020\u001eH\u0000¢\u0006\u0003\u0008â\u0001J\t\u0010ã\u0001\u001a\u00020\u001eH\u0016J\u0007\u0010ä\u0001\u001a\u00020\u001eJ\u001b\u0010å\u0001\u001a\u00020\u001e2\u0007\u0010æ\u0001\u001a\u00020e2\u0007\u0010ç\u0001\u001a\u00020eH\u0014J\u0007\u0010è\u0001\u001a\u00020\u001eJ\u0007\u0010é\u0001\u001a\u00020\u001eJ\u0007\u0010ê\u0001\u001a\u00020\u001eJ\u001d\u0010ë\u0001\u001a\u00020\u001e2\u0007\u0010¦\u0001\u001a\u00020\u001c2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u001dH\u0016J2\u0010ì\u0001\u001a\u00030í\u00012\u0007\u0010î\u0001\u001a\u00020;2\u0010\u0008\u0004\u0010ï\u0001\u001a\t\u0012\u0005\u0012\u00030í\u000102H\u0084\u0008ø\u0001\u0000¢\u0006\u0006\u0008ð\u0001\u0010ñ\u0001JA\u0010ò\u0001\u001a\u00020\u001e2\u0006\u0010q\u001a\u00020p2\u0007\u0010\u0091\u0001\u001a\u00020\u00172\u0019\u0010E\u001a\u0015\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001e\u0018\u00010B¢\u0006\u0002\u0008DH\u0014ø\u0001\u0000¢\u0006\u0006\u0008ó\u0001\u0010ô\u0001J.\u0010ò\u0001\u001a\u00020\u001e2\u0006\u0010q\u001a\u00020p2\u0007\u0010\u0091\u0001\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u001dH\u0014ø\u0001\u0000¢\u0006\u0006\u0008ó\u0001\u0010õ\u0001JK\u0010ö\u0001\u001a\u00020\u001e2\u0006\u0010q\u001a\u00020p2\u0007\u0010\u0091\u0001\u001a\u00020\u00172\u0019\u0010E\u001a\u0015\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001e\u0018\u00010B¢\u0006\u0002\u0008D2\u0008\u0010!\u001a\u0004\u0018\u00010\u001dH\u0002ø\u0001\u0000¢\u0006\u0006\u0008÷\u0001\u0010ø\u0001JI\u0010ù\u0001\u001a\u00020\u001e2\u0006\u0010q\u001a\u00020p2\u0007\u0010\u0091\u0001\u001a\u00020\u00172\u0019\u0010E\u001a\u0015\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001e\u0018\u00010B¢\u0006\u0002\u0008D2\u0008\u0010?\u001a\u0004\u0018\u00010\u001dø\u0001\u0000¢\u0006\u0006\u0008ú\u0001\u0010ø\u0001J,\u0010û\u0001\u001a\u00020\u001e2\u0007\u0010´\u0001\u001a\u00020\u000b2\u0007\u0010\u0098\u0001\u001a\u00020%2\t\u0008\u0002\u0010ü\u0001\u001a\u00020%H\u0000¢\u0006\u0003\u0008ý\u0001J\u0007\u0010þ\u0001\u001a\u00020\u001eJ\u000f\u0010ÿ\u0001\u001a\u00020\u001eH\u0010¢\u0006\u0003\u0008\u0080\u0002J \u0010\u0081\u0002\u001a\u00030\u0099\u00012\u0008\u0010\u0082\u0002\u001a\u00030\u0099\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\u0008\u0083\u0002\u0010 \u0001J\u0007\u0010\u0084\u0002\u001a\u00020%J*\u0010\u0085\u0002\u001a\u00030\u0099\u00012\u0007\u0010q\u001a\u00030\u0099\u00012\t\u0008\u0002\u0010\u009b\u0001\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0006\u0008\u0086\u0002\u0010²\u0001J\u0008\u0010\u0087\u0002\u001a\u00030Ð\u0001J(\u0010\u0088\u0002\u001a\u00020\u001e2\u0007\u0010Ñ\u0001\u001a\u00020\u00032\u0008\u0010\u0089\u0002\u001a\u00030\u008a\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\u0008\u008b\u0002\u0010\u008c\u0002J(\u0010\u008d\u0002\u001a\u00020\u001e2\u0007\u0010\u0096\u0001\u001a\u00020\u00002\u0008\u0010\u0089\u0002\u001a\u00030\u008a\u0002H\u0002ø\u0001\u0000¢\u0006\u0006\u0008\u008e\u0002\u0010\u008f\u0002J(\u0010\u0090\u0002\u001a\u00020\u001e2\u0007\u0010\u0096\u0001\u001a\u00020\u00002\u0008\u0010\u0089\u0002\u001a\u00030\u008a\u0002H\u0002ø\u0001\u0000¢\u0006\u0006\u0008\u0091\u0002\u0010\u008f\u0002J\u001f\u0010\u0092\u0002\u001a\u00020\u001e2\u0008\u0010\u0089\u0002\u001a\u00030\u008a\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\u0008\u0093\u0002\u0010\u0094\u0002J-\u0010\u0095\u0002\u001a\u00020\u001e2\u0019\u0010E\u001a\u0015\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001e\u0018\u00010B¢\u0006\u0002\u0008D2\t\u0008\u0002\u0010\u0096\u0002\u001a\u00020%J\u0014\u0010\u0097\u0002\u001a\u00020\u001e2\t\u0008\u0002\u0010\u0098\u0002\u001a\u00020%H\u0002JF\u0010\u0099\u0002\u001a\u00020\u001e\"\u0007\u0008\u0000\u0010\u009a\u0002\u0018\u00012\u000f\u0010¶\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009a\u00020·\u00012\u0014\u0010ï\u0001\u001a\u000f\u0012\u0005\u0012\u0003H\u009a\u0002\u0012\u0004\u0012\u00020\u001e0BH\u0086\u0008ø\u0001\u0000¢\u0006\u0006\u0008\u009b\u0002\u0010\u009c\u0002J2\u0010\u0099\u0002\u001a\u00020\u001e2\u0007\u0010\u009d\u0002\u001a\u00020e2\u0007\u0010¾\u0001\u001a\u00020%2\u0014\u0010ï\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0086\u0001\u0012\u0004\u0012\u00020\u001e0BH\u0086\u0008J \u0010\u009e\u0002\u001a\u00030\u0099\u00012\u0008\u0010\u009f\u0002\u001a\u00030\u0099\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\u0008 \u0002\u0010 \u0001J(\u0010¡\u0002\u001a\u00020\u001e2\u0007\u0010¦\u0001\u001a\u00020\u001c2\u0013\u0010ï\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001e0BH\u0084\u0008J\u001f\u0010¢\u0002\u001a\u00020%2\u0008\u0010¢\u0001\u001a\u00030\u0099\u0001H\u0004ø\u0001\u0000¢\u0006\u0006\u0008£\u0002\u0010Í\u0001JL\u0010¤\u0002\u001a\u00020\u001e*\u0005\u0018\u00010\u0086\u00012\u0008\u0010À\u0001\u001a\u00030Á\u00012\u0008\u0010¢\u0001\u001a\u00030\u0099\u00012\u0008\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020%2\u0007\u0010Å\u0001\u001a\u00020%H\u0002ø\u0001\u0000¢\u0006\u0006\u0008¥\u0002\u0010¦\u0002JU\u0010§\u0002\u001a\u00020\u001e*\u0005\u0018\u00010\u0086\u00012\u0008\u0010À\u0001\u001a\u00030Á\u00012\u0008\u0010¢\u0001\u001a\u00030\u0099\u00012\u0008\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020%2\u0007\u0010Å\u0001\u001a\u00020%2\u0007\u0010¨\u0002\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0006\u0008©\u0002\u0010ª\u0002JU\u0010«\u0002\u001a\u00020\u001e*\u0005\u0018\u00010\u0086\u00012\u0008\u0010À\u0001\u001a\u00030Á\u00012\u0008\u0010¢\u0001\u001a\u00030\u0099\u00012\u0008\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020%2\u0007\u0010Å\u0001\u001a\u00020%2\u0007\u0010¨\u0002\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0006\u0008¬\u0002\u0010ª\u0002J\r\u0010­\u0002\u001a\u00020\u0000*\u00020\u0003H\u0002R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019R(\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\u001e0\u001bX\u0082\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008#\u0010\u0019R\u001a\u0010$\u001a\u00020%X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008&\u0010'\"\u0004\u0008(\u0010)R\u001a\u0010*\u001a\u00020%X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008+\u0010'\"\u0004\u0008,\u0010)R\u0014\u0010-\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008.\u0010'R\u0014\u0010/\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00080\u0010'R\u0014\u00101\u001a\u0008\u0012\u0004\u0012\u00020\u001e02X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00083\u0010'R\u000e\u00104\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00085\u0010'R\u000e\u00106\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00108\u001a\u00020%2\u0006\u00107\u001a\u00020%@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010'R\u001a\u0010:\u001a\u00020;8@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008<\u0010=R\"\u0010?\u001a\u0004\u0018\u00010>2\u0008\u00107\u001a\u0004\u0018\u00010>@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008@\u0010ARD\u0010E\u001a\u0015\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001e\u0018\u00010B¢\u0006\u0002\u0008D2\u0019\u00107\u001a\u0015\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u001e\u0018\u00010B¢\u0006\u0002\u0008D@BX\u0084\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008F\u0010GR\u000e\u0010H\u001a\u00020IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010N\u001a\u00020K8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008O\u0010PR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008Q\u0010RR&\u0010T\u001a\u0004\u0018\u00010S2\u0008\u00107\u001a\u0004\u0018\u00010S@dX¦\u000e¢\u0006\u000c\u001a\u0004\u0008U\u0010V\"\u0004\u0008W\u0010XR$\u0010Z\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\t8P@PX\u0090\u000e¢\u0006\u000c\u001a\u0004\u0008[\u0010\\\"\u0004\u0008]\u0010^R\u0017\u0010_\u001a\u00020`8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008a\u0010=R\u001c\u0010b\u001a\u0010\u0012\u0004\u0012\u00020d\u0012\u0004\u0012\u00020e\u0018\u00010cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010f\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008g\u0010\u0012R\u0013\u0010h\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\u0008i\u0010\u0015R\u0016\u0010j\u001a\u0004\u0018\u00010k8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008l\u0010mR\u0013\u0010n\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\u0008o\u0010\u0015R,\u0010q\u001a\u00020p2\u0006\u00107\u001a\u00020p@TX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010u\u001a\u0004\u0008r\u0010=\"\u0004\u0008s\u0010tR\u001a\u0010v\u001a\u0008\u0012\u0004\u0012\u00020d0w8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008x\u0010yR\u0014\u0010z\u001a\u00020\u000b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008{\u0010|R\u000e\u0010}\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010~\u001a\u00020\u007f8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0007\u001a\u0005\u0008\u0080\u0001\u0010=R\u0018\u0010\u0081\u0001\u001a\u00030\u0082\u00018BX\u0082\u0004¢\u0006\u0008\u001a\u0006\u0008\u0083\u0001\u0010\u0084\u0001R\u0016\u0010\u0085\u0001\u001a\u00030\u0086\u0001X¦\u0004¢\u0006\u0008\u001a\u0006\u0008\u0087\u0001\u0010\u0088\u0001R!\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\u0008\u008a\u0001\u0010\u008b\u0001\"\u0006\u0008\u008c\u0001\u0010\u008d\u0001R!\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\u0008\u008f\u0001\u0010\u008b\u0001\"\u0006\u0008\u0090\u0001\u0010\u008d\u0001R(\u0010\u0091\u0001\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0017@DX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\u0008\u0092\u0001\u0010\u0019\"\u0006\u0008\u0093\u0001\u0010\u0094\u0001\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006°\u0002", d2 = {"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "density", "", "getDensity", "()F", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "", "getDrawBlock$annotations", "()V", "explicitLayer", "fontScale", "getFontScale", "forceMeasureWithLookaheadConstraints", "", "getForceMeasureWithLookaheadConstraints$ui_release", "()Z", "setForceMeasureWithLookaheadConstraints$ui_release", "(Z)V", "forcePlaceWithLookaheadOffset", "getForcePlaceWithLookaheadOffset$ui_release", "setForcePlaceWithLookaheadOffset$ui_release", "hasMeasureResult", "getHasMeasureResult", "introducesMotionFrameOfReference", "getIntroducesMotionFrameOfReference", "invalidateParentLayer", "Lkotlin/Function0;", "isAttached", "isClipping", "isValidOwnerScope", "lastLayerAlpha", "<set-?>", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "lastMeasurementConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastMeasurementConstraints-msEJaDk$ui_release", "()J", "Landroidx/compose/ui/node/OwnedLayer;", "layer", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "value", "measureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "minimumTouchTargetSize", "Landroidx/compose/ui/geometry/Size;", "getMinimumTouchTargetSize-NH-jbRc", "oldAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "parent", "getParent", "parentCoordinates", "getParentCoordinates", "parentData", "", "getParentData", "()Ljava/lang/Object;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "position", "getPosition-nOcc-ac", "setPosition--gyyYBs", "(J)V", "J", "providedAlignmentLines", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "rectCache", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "released", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrapped", "getWrapped$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "zIndex", "getZIndex", "setZIndex", "(F)V", "ancestorToLocal", "ancestor", "rect", "clipBounds", "Landroidx/compose/ui/geometry/Offset;", "offset", "includeMotionFrameOfReference", "ancestorToLocal-S_NoaFU", "(Landroidx/compose/ui/node/NodeCoordinator;JZ)J", "calculateMinimumTouchTargetPadding", "calculateMinimumTouchTargetPadding-E7KxVPU", "(J)J", "distanceInMinimumTouchTarget", "pointerPosition", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "draw", "canvas", "graphicsLayer", "drawBorder", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawContainedDrawModifiers", "ensureLookaheadDelegateCreated", "findCommonAncestor", "other", "findCommonAncestor$ui_release", "fromParentPosition", "fromParentPosition-8S9VItk", "(JZ)J", "fromParentRect", "bounds", "hasNode", "type", "Landroidx/compose/ui/node/NodeKind;", "hasNode-H91voCI", "(I)Z", "head", "head-H91voCI", "(I)Landroidx/compose/ui/Modifier$Node;", "headNode", "includeTail", "hitTest", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "hitTest-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestChild", "hitTestChild-YqVAtuI", "invalidateLayer", "isPointerInBounds", "isPointerInBounds-k-4lQ0M", "(J)Z", "isTransparent", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "localToScreen", "localToScreen-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "offsetFromEdge", "offsetFromEdge-MK-Hz9U", "onCoordinatesUsed", "onCoordinatesUsed$ui_release", "onLayoutModifierNodeChanged", "onLayoutNodeAttach", "onMeasureResultChanged", "width", "height", "onMeasured", "onPlaced", "onRelease", "performDraw", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "block", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelf", "placeSelf-MLgxB_4", "(JFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelfApparentToRealOffset", "placeSelfApparentToRealOffset-MLgxB_4", "rectInParent", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "releaseLayer", "replace", "replace$ui_release", "screenToLocal", "relativeToScreen", "screenToLocal-MK-Hz9U", "shouldSharePointerInputWithSiblings", "toParentPosition", "toParentPosition-8S9VItk", "touchBoundsInRoot", "transformFrom", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFromAncestor", "transformFromAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformToAncestor", "transformToAncestor-EL8BTi8", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "updateLayerBlock", "forceUpdateLayerParameters", "updateLayerParameters", "invokeOnLayoutChange", "visitNodes", "T", "visitNodes-aLcG6gQ", "(ILkotlin/jvm/functions/Function1;)V", "mask", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "withPositionTranslation", "withinLayerBounds", "withinLayerBounds-k-4lQ0M", "hit", "hit-1hIXUjU", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitNear", "distanceFromEdge", "hitNear-JHbHoSQ", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZF)V", "speculativeHit", "speculativeHit-JHbHoSQ", "toCoordinator", "Companion", "HitTestSource", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class NodeCoordinator extends androidx.compose.ui.node.LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, androidx.compose.ui.node.OwnerScope {

    public static final int $stable = 0;
    public static final androidx.compose.ui.node.NodeCoordinator.Companion Companion = null;
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    private static final androidx.compose.ui.node.NodeCoordinator.HitTestSource PointerInputSource = null;
    private static final androidx.compose.ui.node.NodeCoordinator.HitTestSource SemanticsSource = null;
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    private static final ReusableGraphicsLayerScope graphicsLayerScope;
    private static final Function1<androidx.compose.ui.node.NodeCoordinator, Unit> onCommitAffectingLayer;
    private static final Function1<androidx.compose.ui.node.NodeCoordinator, Unit> onCommitAffectingLayerParams;
    private static final androidx.compose.ui.node.LayerPositionalProperties tmpLayerPositionalProperties;
    private static final float[] tmpMatrix;
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private final Function2<Canvas, GraphicsLayer, Unit> drawBlock;
    private GraphicsLayer explicitLayer;
    private boolean forceMeasureWithLookaheadConstraints;
    private boolean forcePlaceWithLookaheadOffset;
    private final Function0<Unit> invalidateParentLayer;
    private boolean isClipping;
    private float lastLayerAlpha = 0.8f;
    private boolean lastLayerDrawingWasSkipped;
    private androidx.compose.ui.node.OwnedLayer layer;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private Density layerDensity;
    private LayoutDirection layerLayoutDirection;
    private androidx.compose.ui.node.LayerPositionalProperties layerPositionalProperties;
    private final androidx.compose.ui.node.LayoutNode layoutNode;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position;
    private boolean released;
    private androidx.compose.ui.node.NodeCoordinator wrapped;
    private androidx.compose.ui.node.NodeCoordinator wrappedBy;
    private float zIndex;

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008`\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000bH&ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0006\u0012\u0002\u0008\u00030\u0010H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0005H&ø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006\u0018À\u0006\u0001", d2 = {"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "Landroidx/compose/ui/Modifier$Node;", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface HitTestSource {
        public abstract void childHitTest-YqVAtuI(androidx.compose.ui.node.LayoutNode layoutNode, long l2, androidx.compose.ui.node.HitTestResult hitTestResult3, boolean z4, boolean z5);

        public abstract int entityType-OLwlOKw();

        public abstract boolean interceptOutOfBoundsChildEvents(Modifier.Node modifier$Node);

        public abstract boolean shouldHitTestChildren(androidx.compose.ui.node.LayoutNode layoutNode);
    }

    @Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0018", d2 = {"Landroidx/compose/ui/node/NodeCoordinator$Companion;", "", "()V", "ExpectAttachedLayoutCoordinates", "", "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "getSemanticsSource", "UnmeasuredError", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "onCommitAffectingLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", "", "onCommitAffectingLayerParams", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.ui.node.NodeCoordinator.HitTestSource getPointerInputSource() {
            return NodeCoordinator.access$getPointerInputSource$cp();
        }

        public final androidx.compose.ui.node.NodeCoordinator.HitTestSource getSemanticsSource() {
            return NodeCoordinator.access$getSemanticsSource$cp();
        }
    }
    static {
        final int i2 = 0;
        NodeCoordinator.Companion companion = new NodeCoordinator.Companion(i2);
        NodeCoordinator.Companion = companion;
        NodeCoordinator.onCommitAffectingLayerParams = (Function1)NodeCoordinator.Companion.onCommitAffectingLayerParams.1.INSTANCE;
        NodeCoordinator.onCommitAffectingLayer = (Function1)NodeCoordinator.Companion.onCommitAffectingLayer.1.INSTANCE;
        ReusableGraphicsLayerScope reusableGraphicsLayerScope = new ReusableGraphicsLayerScope();
        NodeCoordinator.graphicsLayerScope = reusableGraphicsLayerScope;
        LayerPositionalProperties layerPositionalProperties = new LayerPositionalProperties();
        NodeCoordinator.tmpLayerPositionalProperties = layerPositionalProperties;
        NodeCoordinator.tmpMatrix = Matrix.constructor-impl$default(i2, 1, i2);
        NodeCoordinator.Companion.PointerInputSource.1 anon = new NodeCoordinator.Companion.PointerInputSource.1();
        NodeCoordinator.PointerInputSource = (NodeCoordinator.HitTestSource)anon;
        NodeCoordinator.Companion.SemanticsSource.1 anon2 = new NodeCoordinator.Companion.SemanticsSource.1();
        NodeCoordinator.SemanticsSource = (NodeCoordinator.HitTestSource)anon2;
    }

    public NodeCoordinator(androidx.compose.ui.node.LayoutNode layoutNode) {
        super();
        this.layoutNode = layoutNode;
        this.layerDensity = getLayoutNode().getDensity();
        this.layerLayoutDirection = getLayoutNode().getLayoutDirection();
        int i = 1061997773;
        this.position = IntOffset.Companion.getZero-nOcc-ac();
        NodeCoordinator.drawBlock.1 anon = new NodeCoordinator.drawBlock.1(this);
        this.drawBlock = (Function2)anon;
        NodeCoordinator.invalidateParentLayer.1 anon2 = new NodeCoordinator.invalidateParentLayer.1(this);
        this.invalidateParentLayer = (Function0)anon2;
    }

    public static final void access$drawContainedDrawModifiers(androidx.compose.ui.node.NodeCoordinator $this, Canvas canvas, GraphicsLayer graphicsLayer) {
        $this.drawContainedDrawModifiers(canvas, graphicsLayer);
    }

    public static final ReusableGraphicsLayerScope access$getGraphicsLayerScope$cp() {
        return NodeCoordinator.graphicsLayerScope;
    }

    public static final androidx.compose.ui.node.LayerPositionalProperties access$getLayerPositionalProperties$p(androidx.compose.ui.node.NodeCoordinator $this) {
        return $this.layerPositionalProperties;
    }

    public static final Function1 access$getOnCommitAffectingLayer$cp() {
        return NodeCoordinator.onCommitAffectingLayer;
    }

    public static final androidx.compose.ui.node.NodeCoordinator.HitTestSource access$getPointerInputSource$cp() {
        return NodeCoordinator.PointerInputSource;
    }

    public static final androidx.compose.ui.node.NodeCoordinator.HitTestSource access$getSemanticsSource$cp() {
        return NodeCoordinator.SemanticsSource;
    }

    public static final androidx.compose.ui.node.OwnerSnapshotObserver access$getSnapshotObserver(androidx.compose.ui.node.NodeCoordinator $this) {
        return $this.getSnapshotObserver();
    }

    public static final androidx.compose.ui.node.LayerPositionalProperties access$getTmpLayerPositionalProperties$cp() {
        return NodeCoordinator.tmpLayerPositionalProperties;
    }

    public static final Modifier.Node access$headNode(androidx.compose.ui.node.NodeCoordinator $this, boolean includeTail) {
        return $this.headNode(includeTail);
    }

    public static final void access$hit-1hIXUjU(androidx.compose.ui.node.NodeCoordinator $this, Modifier.Node $receiver, androidx.compose.ui.node.NodeCoordinator.HitTestSource hitTestSource, long pointerPosition, androidx.compose.ui.node.HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        $this.hit-1hIXUjU($receiver, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
    }

    public static final void access$hitNear-JHbHoSQ(androidx.compose.ui.node.NodeCoordinator $this, Modifier.Node $receiver, androidx.compose.ui.node.NodeCoordinator.HitTestSource hitTestSource, long pointerPosition, androidx.compose.ui.node.HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer, float distanceFromEdge) {
        $this.hitNear-JHbHoSQ($receiver, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge);
    }

    public static final void access$setLastLayerDrawingWasSkipped$p(androidx.compose.ui.node.NodeCoordinator $this, boolean <set-?>) {
        $this.lastLayerDrawingWasSkipped = <set-?>;
    }

    public static final void access$setMeasurementConstraints-BRTryo0(androidx.compose.ui.node.NodeCoordinator $this, long value) {
        $this.setMeasurementConstraints-BRTryo0(value);
    }

    public static final void access$speculativeHit-JHbHoSQ(androidx.compose.ui.node.NodeCoordinator $this, Modifier.Node $receiver, androidx.compose.ui.node.NodeCoordinator.HitTestSource hitTestSource, long pointerPosition, androidx.compose.ui.node.HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer, float distanceFromEdge) {
        $this.speculativeHit-JHbHoSQ($receiver, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge);
    }

    private final void ancestorToLocal(androidx.compose.ui.node.NodeCoordinator ancestor, MutableRect rect, boolean clipBounds) {
        if (ancestor == this) {
        }
        final androidx.compose.ui.node.NodeCoordinator wrappedBy = this.wrappedBy;
        if (wrappedBy != null) {
            wrappedBy.ancestorToLocal(ancestor, rect, clipBounds);
        }
        fromParentRect(rect, clipBounds);
    }

    private final long ancestorToLocal-S_NoaFU(androidx.compose.ui.node.NodeCoordinator ancestor, long offset, boolean includeMotionFrameOfReference) {
        boolean equal;
        if (ancestor == this) {
            return offset;
        }
        final androidx.compose.ui.node.NodeCoordinator wrappedBy = this.wrappedBy;
        if (wrappedBy != null && Intrinsics.areEqual(ancestor, wrappedBy)) {
            if (Intrinsics.areEqual(ancestor, wrappedBy)) {
            }
            return fromParentPosition-8S9VItk(wrappedBy.ancestorToLocal-S_NoaFU(ancestor, offset, includeMotionFrameOfReference), obj2);
        }
        return fromParentPosition-8S9VItk(offset, includeMotionFrameOfReference);
    }

    private final void drawContainedDrawModifiers(Canvas canvas, GraphicsLayer graphicsLayer) {
        int constructor-impl;
        int mDrawScope$ui_release;
        Canvas canvas2;
        long size-ozmzZPI;
        Modifier.Node node;
        GraphicsLayer graphicsLayer2;
        int i = 0;
        final Modifier.Node head-H91voCI = head-H91voCI(NodeKind.constructor-impl(4));
        if (head-H91voCI == null) {
            performDraw(canvas, graphicsLayer);
            canvas2 = canvas;
            graphicsLayer2 = graphicsLayer;
        } else {
            getLayoutNode().getMDrawScope$ui_release().draw-eZhPAX0$ui_release(canvas, IntSizeKt.toSize-ozmzZPI(getSize-YbymL2g()), obj4, this, head-H91voCI);
        }
    }

    public static long fromParentPosition-8S9VItk$default(androidx.compose.ui.node.NodeCoordinator nodeCoordinator, long l2, boolean z3, int i4, Object object5) {
        int obj3;
        if (obj5 != null) {
        } else {
            if (object5 &= 2 != 0) {
                obj3 = 1;
            }
            return nodeCoordinator.fromParentPosition-8S9VItk(l2, z3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fromParentPosition-8S9VItk");
        throw obj0;
    }

    private final void fromParentRect(MutableRect bounds, boolean clipBounds) {
        float isClipping;
        long l;
        long i;
        int x-impl = IntOffset.getX-impl(getPosition-nOcc-ac());
        bounds.setLeft(left -= f);
        float f2 = (float)x-impl;
        bounds.setRight(right -= f2);
        int y-impl = IntOffset.getY-impl(getPosition-nOcc-ac());
        bounds.setTop(top -= f3);
        bounds.setBottom(bottom -= isClipping);
        androidx.compose.ui.node.OwnedLayer layer = this.layer;
        layer.mapBounds(bounds, true);
        i = 0;
        bounds.intersect(i, i, (float)width-impl, (float)height-impl);
        if (layer != null && this.isClipping && clipBounds && bounds.isEmpty()) {
            layer.mapBounds(bounds, true);
            if (this.isClipping) {
                if (clipBounds) {
                    i = 0;
                    bounds.intersect(i, i, (float)width-impl, (float)height-impl);
                    if (bounds.isEmpty()) {
                    }
                }
            }
        }
    }

    private static void getDrawBlock$annotations() {
    }

    private final androidx.compose.ui.node.OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    private final boolean hasNode-H91voCI(int type) {
        Modifier.Node headNode;
        int i2;
        int i;
        headNode = headNode(NodeKindKt.getIncludeSelfInTraversal-H91voCI(type));
        i2 = 0;
        i = 1;
        if (headNode != null && DelegatableNodeKt.has-64DMado((DelegatableNode)headNode, type) == i) {
            i = 1;
            if (DelegatableNodeKt.has-64DMado((DelegatableNode)headNode, type) == i) {
                i2 = i;
            }
        }
        return i2;
    }

    private final Modifier.Node headNode(boolean includeTail) {
        int child$ui_release;
        Object wrappedBy;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            child$ui_release = getLayoutNode().getNodes$ui_release().getHead$ui_release();
        } else {
            child$ui_release = 0;
            if (includeTail) {
                wrappedBy = this.wrappedBy;
                wrappedBy = wrappedBy.getTail();
                if (wrappedBy != null && wrappedBy != null) {
                    wrappedBy = wrappedBy.getTail();
                    if (wrappedBy != null) {
                        child$ui_release = wrappedBy.getChild$ui_release();
                    }
                }
            } else {
                wrappedBy = this.wrappedBy;
                if (wrappedBy != null) {
                    child$ui_release = wrappedBy.getTail();
                }
            }
        }
        return child$ui_release;
    }

    private final void hit-1hIXUjU(Modifier.Node $this$hit_u2d1hIXUjU, androidx.compose.ui.node.NodeCoordinator.HitTestSource hitTestSource, long pointerPosition, androidx.compose.ui.node.HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        androidx.compose.ui.node.NodeCoordinator.hit.1 anon;
        Object obj2;
        long l;
        Object obj;
        boolean z4;
        boolean z2;
        boolean z3;
        boolean z;
        boolean z5;
        if ($this$hit_u2d1hIXUjU == null) {
            this.hitTestChild-YqVAtuI(hitTestSource, pointerPosition, obj3, isTouchEvent, isInLayer);
            z5 = obj16;
        } else {
            z5 = obj16;
            anon = new NodeCoordinator.hit.1(this, $this$hit_u2d1hIXUjU, hitTestSource, pointerPosition, obj5, isTouchEvent, isInLayer, z5);
            isTouchEvent.hit($this$hit_u2d1hIXUjU, z5, (Function0)anon);
        }
    }

    private final void hitNear-JHbHoSQ(Modifier.Node $this$hitNear_u2dJHbHoSQ, androidx.compose.ui.node.NodeCoordinator.HitTestSource hitTestSource, long pointerPosition, androidx.compose.ui.node.HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer, float distanceFromEdge) {
        androidx.compose.ui.node.NodeCoordinator.hitNear.1 anon;
        Object obj2;
        long l;
        Object obj;
        boolean z4;
        boolean z;
        boolean z3;
        boolean z2;
        float f2;
        float f;
        if ($this$hitNear_u2dJHbHoSQ == null) {
            this.hitTestChild-YqVAtuI(hitTestSource, pointerPosition, obj3, isTouchEvent, isInLayer);
            f2 = distanceFromEdge;
            f = obj18;
        } else {
            f2 = distanceFromEdge;
            f = obj18;
            anon = new NodeCoordinator.hitNear.1(this, $this$hitNear_u2dJHbHoSQ, hitTestSource, pointerPosition, obj5, isTouchEvent, isInLayer, f2, f);
            isTouchEvent.hitInMinimumTouchTarget($this$hitNear_u2dJHbHoSQ, f, f2, (Function0)anon);
        }
    }

    private final long offsetFromEdge-MK-Hz9U(long pointerPosition) {
        int i;
        int i2;
        final float x-impl = Offset.getX-impl(pointerPosition);
        int i3 = 0;
        if (Float.compare(x-impl, i3) < 0) {
            i = -x-impl;
        } else {
            i = x-impl - f3;
        }
        final float y-impl = Offset.getY-impl(pointerPosition);
        if (Float.compare(y-impl, i3) < 0) {
            i2 = -y-impl;
        } else {
            i2 = y-impl - f4;
        }
        return OffsetKt.Offset(Math.max(i3, i), Math.max(i3, i2));
    }

    private final void placeSelf-MLgxB_4(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer explicitLayer) {
        androidx.compose.ui.node.OwnedLayer invalidateParentLayer;
        boolean layer;
        boolean placingForAlignment$ui_release;
        int owner$ui_release;
        int layoutNode;
        int explicitLayer2;
        int i2;
        GraphicsLayer value$iv;
        int i;
        String str;
        invalidateParentLayer = 2;
        owner$ui_release = 0;
        layoutNode = 0;
        if (obj12 != null) {
            explicitLayer2 = 1;
            i2 = explicitLayer == null ? explicitLayer2 : owner$ui_release;
            if (i2 == 0) {
                int i3 = 0;
                InlineClassHelperKt.throwIllegalArgumentException("both ways to create layers shouldn't be used together");
            }
            if (this.explicitLayer != obj12) {
                this.explicitLayer = layoutNode;
                NodeCoordinator.updateLayerBlock$default(this, layoutNode, owner$ui_release, invalidateParentLayer, layoutNode);
                this.explicitLayer = obj12;
            }
            if (this.layer == null) {
                androidx.compose.ui.node.OwnedLayer layer2 = LayoutNodeKt.requireOwner(getLayoutNode()).createLayer(this.drawBlock, this.invalidateParentLayer, obj12);
                owner$ui_release = layer2;
                layoutNode = 0;
                owner$ui_release.resize-ozmzZPI(getMeasuredSize-YbymL2g());
                owner$ui_release.move--gyyYBs(position);
                this.layer = layer2;
                getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(explicitLayer2);
                this.invalidateParentLayer.invoke();
            }
        } else {
            if (this.explicitLayer != null) {
                this.explicitLayer = layoutNode;
                NodeCoordinator.updateLayerBlock$default(this, layoutNode, owner$ui_release, invalidateParentLayer, layoutNode);
            }
            NodeCoordinator.updateLayerBlock$default(this, explicitLayer, owner$ui_release, invalidateParentLayer, layoutNode);
        }
        if (!IntOffset.equals-impl0(getPosition-nOcc-ac(), owner$ui_release)) {
            setPosition--gyyYBs(position);
            getLayoutNode().getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
            layer = this.layer;
            if (layer != null) {
                layer.move--gyyYBs(position);
            } else {
                owner$ui_release = this.wrappedBy;
                if (owner$ui_release != null) {
                    owner$ui_release.invalidateLayer();
                }
            }
            invalidateAlignmentLinesFromPositionChange(this);
            owner$ui_release = getLayoutNode().getOwner$ui_release();
            if (owner$ui_release != null) {
                owner$ui_release.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = layerBlock;
        if (!isPlacingForAlignment$ui_release()) {
            captureRulers$ui_release(getMeasureResult$ui_release());
        }
    }

    public static void rectInParent$ui_release$default(androidx.compose.ui.node.NodeCoordinator nodeCoordinator, MutableRect mutableRect2, boolean z3, boolean z4, int i5, Object object6) {
        int obj3;
        if (object6 != null) {
        } else {
            if (i5 &= 4 != 0) {
                obj3 = 0;
            }
            nodeCoordinator.rectInParent$ui_release(mutableRect2, z3, obj3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        throw obj0;
    }

    private final void speculativeHit-JHbHoSQ(Modifier.Node $this$speculativeHit_u2dJHbHoSQ, androidx.compose.ui.node.NodeCoordinator.HitTestSource hitTestSource, long pointerPosition, androidx.compose.ui.node.HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer, float distanceFromEdge) {
        androidx.compose.ui.node.NodeCoordinator.speculativeHit.1 anon;
        Object hitTestSource2;
        long l;
        androidx.compose.ui.node.HitTestResult hitTestResult2;
        boolean z4;
        boolean z3;
        boolean z2;
        boolean z;
        float f;
        float f2;
        if ($this$speculativeHit_u2dJHbHoSQ == null) {
            this.hitTestChild-YqVAtuI(hitTestSource, pointerPosition, obj3, isTouchEvent, isInLayer);
        } else {
            if (hitTestSource.interceptOutOfBoundsChildEvents($this$speculativeHit_u2dJHbHoSQ)) {
                anon = new NodeCoordinator.speculativeHit.1(this, $this$speculativeHit_u2dJHbHoSQ, hitTestSource, pointerPosition, obj5, isTouchEvent, isInLayer, distanceFromEdge, obj18);
                isTouchEvent.speculativeHit($this$speculativeHit_u2dJHbHoSQ, obj18, distanceFromEdge, (Function0)anon);
            } else {
                int i = 0;
                this.speculativeHit-JHbHoSQ(NodeCoordinatorKt.access$nextUntil-hw7D004((DelegatableNode)$this$speculativeHit_u2dJHbHoSQ, hitTestSource.entityType-OLwlOKw(), NodeKind.constructor-impl(2)), hitTestSource, pointerPosition, obj4, isTouchEvent, isInLayer, distanceFromEdge);
            }
        }
    }

    private final androidx.compose.ui.node.NodeCoordinator toCoordinator(LayoutCoordinates $this$toCoordinator) {
        Object coordinator;
        if ($this$toCoordinator instanceof LookaheadLayoutCoordinates) {
            coordinator = $this$toCoordinator;
        } else {
            coordinator = 0;
        }
        if (coordinator != null) {
            if (coordinator.getCoordinator() == null) {
                Intrinsics.checkNotNull($this$toCoordinator, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
                coordinator = $this$toCoordinator;
            }
        } else {
        }
        return coordinator;
    }

    public static long toParentPosition-8S9VItk$default(androidx.compose.ui.node.NodeCoordinator nodeCoordinator, long l2, boolean z3, int i4, Object object5) {
        int obj3;
        if (obj5 != null) {
        } else {
            if (object5 &= 2 != 0) {
                obj3 = 1;
            }
            return nodeCoordinator.toParentPosition-8S9VItk(l2, z3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toParentPosition-8S9VItk");
        throw obj0;
    }

    private final void transformFromAncestor-EL8BTi8(androidx.compose.ui.node.NodeCoordinator ancestor, float[] matrix) {
        boolean tmpMatrix2;
        boolean equal;
        long tmpMatrix;
        long zero-nOcc-ac;
        long l;
        long l2;
        int i2;
        int i;
        androidx.compose.ui.node.NodeCoordinator wrappedBy = this.wrappedBy;
        Intrinsics.checkNotNull(wrappedBy);
        wrappedBy.transformFromAncestor-EL8BTi8(ancestor, matrix);
        if (!Intrinsics.areEqual(ancestor, this) && !IntOffset.equals-impl0(getPosition-nOcc-ac(), obj1)) {
            wrappedBy = this.wrappedBy;
            Intrinsics.checkNotNull(wrappedBy);
            wrappedBy.transformFromAncestor-EL8BTi8(ancestor, matrix);
            if (!IntOffset.equals-impl0(getPosition-nOcc-ac(), obj1)) {
                Matrix.reset-impl(NodeCoordinator.tmpMatrix);
                Matrix.translate-impl$default(NodeCoordinator.tmpMatrix, -f, -f2, 0, 4, 0);
                Matrix.timesAssign-58bKbWc(matrix, NodeCoordinator.tmpMatrix);
            }
            equal = this.layer;
            if (equal != null) {
                equal.inverseTransform-58bKbWc(matrix);
            }
        }
    }

    private final void transformToAncestor-EL8BTi8(androidx.compose.ui.node.NodeCoordinator ancestor, float[] matrix) {
        Object wrapper;
        long position-nOcc-ac;
        androidx.compose.ui.node.NodeCoordinator wrappedBy;
        boolean tmpMatrix;
        float[] tmpMatrix2;
        float f;
        float f2;
        int i;
        int i3;
        int i2;
        wrapper = this;
        while (!Intrinsics.areEqual(wrapper, ancestor)) {
            androidx.compose.ui.node.OwnedLayer layer = wrapper.layer;
            if (layer != null) {
            }
            position-nOcc-ac = wrapper.getPosition-nOcc-ac();
            if (!IntOffset.equals-impl0(position-nOcc-ac, obj2)) {
            }
            wrappedBy = wrapper.wrappedBy;
            Intrinsics.checkNotNull(wrappedBy);
            wrapper = wrappedBy;
            Matrix.reset-impl(NodeCoordinator.tmpMatrix);
            Matrix.translate-impl$default(NodeCoordinator.tmpMatrix, (float)x-impl, (float)y-impl, 0, 4, 0);
            Matrix.timesAssign-58bKbWc(matrix, NodeCoordinator.tmpMatrix);
            layer.transform-58bKbWc(matrix);
        }
    }

    public static void updateLayerBlock$default(androidx.compose.ui.node.NodeCoordinator nodeCoordinator, Function1 function12, boolean z3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = 0;
            }
            nodeCoordinator.updateLayerBlock(function12, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
        throw obj0;
    }

    private final void updateLayerParameters(boolean invokeOnLayoutChange) {
        int layerBlock;
        androidx.compose.ui.node.LayerPositionalProperties layerPositionalProperties;
        Object obj;
        String owner$ui_release;
        Function1 onCommitAffectingLayerParams;
        androidx.compose.ui.node.NodeCoordinator.updateLayerParameters.1 anon;
        if (this.explicitLayer != null) {
        }
        androidx.compose.ui.node.OwnedLayer layer = this.layer;
        if (layer != null) {
            layerBlock = this.layerBlock;
            int i = 0;
            if (layerBlock == null) {
            } else {
                NodeCoordinator.graphicsLayerScope.reset();
                NodeCoordinator.graphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
                NodeCoordinator.graphicsLayerScope.setLayoutDirection$ui_release(getLayoutNode().getLayoutDirection());
                NodeCoordinator.graphicsLayerScope.setSize-uvyYCjk(IntSizeKt.toSize-ozmzZPI(getSize-YbymL2g()));
                anon = new NodeCoordinator.updateLayerParameters.1(layerBlock);
                getSnapshotObserver().observeReads$ui_release((OwnerScope)this, NodeCoordinator.onCommitAffectingLayerParams, (Function0)anon);
                if (this.layerPositionalProperties == null) {
                    layerPositionalProperties = new LayerPositionalProperties();
                    onCommitAffectingLayerParams = 0;
                    this.layerPositionalProperties = layerPositionalProperties;
                }
                layerPositionalProperties.copyFrom((GraphicsLayerScope)NodeCoordinator.graphicsLayerScope);
                layer.updateLayerProperties(NodeCoordinator.graphicsLayerScope);
                this.isClipping = NodeCoordinator.graphicsLayerScope.getClip();
                this.lastLayerAlpha = NodeCoordinator.graphicsLayerScope.getAlpha();
                owner$ui_release = getLayoutNode().getOwner$ui_release();
                if (invokeOnLayoutChange && owner$ui_release != null) {
                    owner$ui_release = getLayoutNode().getOwner$ui_release();
                    if (owner$ui_release != null) {
                        owner$ui_release.onLayoutChange(getLayoutNode());
                    }
                }
            }
            int i2 = 0;
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("updateLayerParameters requires a non-null layerBlock");
            KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
            throw kotlinNothingValueException;
        }
        layerBlock = this.layerBlock == null ? 1 : 0;
        layerPositionalProperties = 0;
        if (layerBlock == 0) {
            int i3 = 0;
            InlineClassHelperKt.throwIllegalStateException("null layer with a non-null layerBlock");
        }
    }

    static void updateLayerParameters$default(androidx.compose.ui.node.NodeCoordinator nodeCoordinator, boolean z2, int i3, Object object4) {
        int obj1;
        if (object4 != null) {
        } else {
            final int obj3 = 1;
            if (i3 &= obj3 != 0) {
                obj1 = obj3;
            }
            nodeCoordinator.updateLayerParameters(obj1);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
        throw obj0;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    protected final long calculateMinimumTouchTargetPadding-E7KxVPU(long minimumTouchTargetSize) {
        int i3 = 1073741824;
        final int i6 = 0;
        return SizeKt.Size(Math.max(i6, i / i3), Math.max(i6, i2 / i3));
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    protected final float distanceInMinimumTouchTarget-tz77jQw(long pointerPosition, long minimumTouchTargetSize) {
        int cmp;
        float distanceSquared-impl;
        float height-impl;
        int cmp2;
        if (Float.compare(f, width-impl2) >= 0 && Float.compare(f2, height-impl) >= 0) {
            if (Float.compare(f2, height-impl) >= 0) {
                return 2139095040;
            }
        }
        long minimumTouchTargetPadding-E7KxVPU = calculateMinimumTouchTargetPadding-E7KxVPU(obj10);
        int i = 0;
        float width-impl = Size.getWidth-impl(minimumTouchTargetPadding-E7KxVPU);
        final int i2 = 0;
        float height-impl2 = Size.getHeight-impl(minimumTouchTargetPadding-E7KxVPU);
        final long offsetFromEdge-MK-Hz9U = offsetFromEdge-MK-Hz9U(pointerPosition);
        cmp2 = 0;
        if (Float.compare(width-impl, cmp2) <= 0) {
            if (Float.compare(height-impl2, cmp2) > 0 && Float.compare(x-impl, width-impl) <= 0 && Float.compare(y-impl, height-impl2) <= 0) {
                if (Float.compare(x-impl, width-impl) <= 0) {
                    if (Float.compare(y-impl, height-impl2) <= 0) {
                        distanceSquared-impl = Offset.getDistanceSquared-impl(offsetFromEdge-MK-Hz9U);
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return distanceSquared-impl;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void draw(Canvas canvas, GraphicsLayer graphicsLayer) {
        float f;
        long l2;
        long l;
        int i;
        final androidx.compose.ui.node.OwnedLayer layer = this.layer;
        if (layer != null) {
            layer.drawLayer(canvas, graphicsLayer);
        } else {
            f = (float)x-impl;
            l2 = (float)y-impl;
            canvas.translate(f, l2);
            drawContainedDrawModifiers(canvas, graphicsLayer);
            canvas.translate(-f, -l2);
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    protected final void drawBorder(Canvas canvas, Paint paint) {
        final int i2 = 1056964608;
        Rect rect = new Rect(i2, i2, f -= i2, f2 -= i2);
        canvas.drawRect(rect, paint);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public abstract void ensureLookaheadDelegateCreated();

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final androidx.compose.ui.node.NodeCoordinator findCommonAncestor$ui_release(androidx.compose.ui.node.NodeCoordinator other) {
        androidx.compose.ui.node.LayoutNode ancestor1;
        androidx.compose.ui.node.LayoutNode ancestor2;
        androidx.compose.ui.node.LayoutNode parent$ui_release3;
        int parent$ui_release4;
        int parent$ui_release;
        androidx.compose.ui.node.NodeCoordinator innerCoordinator$ui_release;
        int parent$ui_release2;
        Modifier.Node next$iv;
        int i;
        String str;
        ancestor2 = getLayoutNode();
        Modifier.Node tail2 = getTail();
        int i2 = 0;
        int i4 = 0;
        i = 0;
        if (other.getLayoutNode() == ancestor2 && !(DelegatableNode)tail2.getNode().isAttached()) {
            tail2 = getTail();
            i2 = 0;
            i4 = 0;
            i = 0;
            if (!(DelegatableNode)tail2.getNode().isAttached()) {
                int i5 = 0;
                InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
            }
            next$iv = tail2.getNode().getParent$ui_release();
            while (next$iv != null) {
                next$iv = next$iv.getParent$ui_release();
                str = 0;
            }
            return this;
        }
        while (ancestor1.getDepth$ui_release() > ancestor2.getDepth$ui_release()) {
            parent$ui_release3 = ancestor1.getParent$ui_release();
            Intrinsics.checkNotNull(parent$ui_release3);
            ancestor1 = parent$ui_release3;
        }
        while (ancestor2.getDepth$ui_release() > ancestor1.getDepth$ui_release()) {
            parent$ui_release4 = ancestor2.getParent$ui_release();
            Intrinsics.checkNotNull(parent$ui_release4);
            ancestor2 = parent$ui_release4;
        }
        while (ancestor1 != ancestor2) {
            parent$ui_release = ancestor1.getParent$ui_release();
            parent$ui_release2 = ancestor2.getParent$ui_release();
            ancestor1 = parent$ui_release;
            ancestor2 = parent$ui_release2;
        }
        if (ancestor2 == getLayoutNode()) {
            innerCoordinator$ui_release = this;
        } else {
            if (ancestor1 == other.getLayoutNode()) {
                innerCoordinator$ui_release = other;
            } else {
                innerCoordinator$ui_release = ancestor1.getInnerCoordinator$ui_release();
            }
        }
        return innerCoordinator$ui_release;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public long fromParentPosition-8S9VItk(long position, boolean includeMotionFrameOfReference) {
        boolean placedUnderMotionFrameOfReference;
        long minus-Nv-tHpc;
        long mapOffset-8S9VItk;
        if (obj8 == null && isPlacedUnderMotionFrameOfReference()) {
            if (isPlacedUnderMotionFrameOfReference()) {
                minus-Nv-tHpc = position;
            } else {
                minus-Nv-tHpc = IntOffsetKt.minus-Nv-tHpc(position, includeMotionFrameOfReference);
            }
        } else {
        }
        final androidx.compose.ui.node.OwnedLayer layer = this.layer;
        if (layer != null) {
            mapOffset-8S9VItk = layer.mapOffset-8S9VItk(minus-Nv-tHpc, obj1);
        } else {
            mapOffset-8S9VItk = minus-Nv-tHpc;
        }
        return mapOffset-8S9VItk;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public androidx.compose.ui.node.AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public androidx.compose.ui.node.LookaheadCapablePlaceable getChild() {
        return (LookaheadCapablePlaceable)this.wrapped;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutCoordinates getCoordinates() {
        return (LayoutCoordinates)this;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final boolean getForceMeasureWithLookaheadConstraints$ui_release() {
        return this.forceMeasureWithLookaheadConstraints;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final boolean getForcePlaceWithLookaheadOffset$ui_release() {
        return this.forcePlaceWithLookaheadOffset;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean getHasMeasureResult() {
        int i;
        i = this._measureResult != null ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean getIntroducesMotionFrameOfReference() {
        return isPlacedUnderMotionFrameOfReference();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final boolean getLastLayerDrawingWasSkipped$ui_release() {
        return this.lastLayerDrawingWasSkipped;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final long getLastMeasurementConstraints-msEJaDk$ui_release() {
        return getMeasurementConstraints-msEJaDk();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final androidx.compose.ui.node.OwnedLayer getLayer() {
        return this.layer;
    }

    protected final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public androidx.compose.ui.node.LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public abstract androidx.compose.ui.node.LookaheadDelegate getLookaheadDelegate();

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult _measureResult = this._measureResult;
        if (_measureResult == null) {
        } else {
            return _measureResult;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Asking for measurement result of unmeasured layout modifier".toString());
        throw illegalStateException;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final long getMinimumTouchTargetSize-NH-jbRc() {
        final int i = 0;
        return this.layerDensity.toSize-XkaWNTQ(getLayoutNode().getViewConfiguration().getMinimumTouchTargetSize-MYxV2XQ());
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public androidx.compose.ui.node.LookaheadCapablePlaceable getParent() {
        return (LookaheadCapablePlaceable)this.wrappedBy;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LayoutCoordinates getParentCoordinates() {
        String str;
        final int i = 0;
        if (!isAttached()) {
            int i2 = 0;
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        onCoordinatesUsed$ui_release();
        return (LayoutCoordinates)this.wrappedBy;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public Object getParentData() {
        int count$iv2;
        int this_$iv$iv2;
        androidx.compose.ui.node.NodeChain nodes$ui_release;
        int this_$iv2;
        MutableVector $i$f$mutableVectorOf;
        Modifier.Node next$iv;
        int $i$f$tailToHead$ui_release;
        Modifier.Node parent$ui_release;
        int node$iv2;
        int node$iv;
        Modifier.Node node4;
        int i2;
        int kind$iv;
        Modifier.Node node;
        int i3;
        int stack$iv;
        Modifier.Node element;
        int i6;
        Modifier.Node node$iv3;
        Modifier.Node node$iv$iv;
        int i5;
        Modifier.Node node2;
        androidx.compose.ui.node.NodeChain this_$iv;
        int this_$iv$iv;
        androidx.compose.ui.node.LayoutNode layoutNode;
        int count$iv;
        int i;
        int i7;
        int i4;
        Modifier.Node node3;
        int i8 = 0;
        if (getLayoutNode().getNodes$ui_release().has-H91voCI$ui_release(NodeKind.constructor-impl(64))) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            $i$f$tailToHead$ui_release = 0;
            parent$ui_release = getLayoutNode().getNodes$ui_release().getTail$ui_release();
            while (parent$ui_release != null) {
                node4 = parent$ui_release;
                i2 = 0;
                int i10 = 0;
                i3 = 0;
                if (kindSet$ui_release &= constructor-impl2 != 0) {
                } else {
                }
                kind$iv = 0;
                if (kind$iv != 0) {
                } else {
                }
                this_$iv = nodes$ui_release;
                i4 = $i$f$tailToHead$ui_release;
                node3 = parent$ui_release;
                if (node4 != getTail()) {
                }
                parent$ui_release = node3.getParent$ui_release();
                nodes$ui_release = this_$iv;
                $i$f$tailToHead$ui_release = i4;
                count$iv2 = 64;
                int i11 = 0;
                kind$iv = NodeKind.constructor-impl(count$iv2);
                i3 = 0;
                stack$iv = 0;
                int i12 = 0;
                node$iv3 = node;
                while (node$iv3 != null) {
                    if (node$iv3 instanceof ParentDataModifierNode) {
                    } else {
                    }
                    element = 0;
                    if (kindSet$ui_release2 &= kind$iv != 0) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    if (this_$iv$iv2 != 0 && node$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv = nodes$ui_release;
                    i4 = $i$f$tailToHead$ui_release;
                    node3 = parent$ui_release;
                    this_$iv2 = 1;
                    node$iv2 = 0;
                    node$iv3 = DelegatableNodeKt.access$pop(stack$iv);
                    nodes$ui_release = this_$iv;
                    $i$f$tailToHead$ui_release = i4;
                    parent$ui_release = node3;
                    count$iv2 = 64;
                    if (node$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv2 = 0;
                    i6 = 0;
                    node$iv$iv = (DelegatingNode)node$iv3.getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        i5 = node$iv$iv;
                        node2 = 0;
                        count$iv = 0;
                        if (kindSet$ui_release3 &= kind$iv != 0) {
                        } else {
                        }
                        this_$iv$iv = 0;
                        if (this_$iv$iv != 0) {
                        } else {
                        }
                        this_$iv = nodes$ui_release;
                        i4 = $i$f$tailToHead$ui_release;
                        node3 = parent$ui_release;
                        next$iv = i5;
                        node$iv = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        nodes$ui_release = this_$iv;
                        $i$f$tailToHead$ui_release = i4;
                        parent$ui_release = node3;
                        this_$iv$iv2++;
                        this_$iv = nodes$ui_release;
                        if (this_$iv$iv2 == 1) {
                        } else {
                        }
                        if (stack$iv == 0) {
                        } else {
                        }
                        count$iv = this_$iv$iv2;
                        i4 = $i$f$tailToHead$ui_release;
                        node3 = parent$ui_release;
                        node$iv = 0;
                        $i$f$mutableVectorOf = stack$iv;
                        stack$iv = $i$f$mutableVectorOf;
                        Modifier.Node node6 = node$iv3;
                        if (node6 != null && stack$iv != null) {
                        }
                        if (stack$iv != null) {
                        } else {
                        }
                        next$iv = i5;
                        this_$iv$iv2 = count$iv;
                        stack$iv.add(i5);
                        if (stack$iv != null) {
                        }
                        node$iv3 = $i$f$mutableVectorOf;
                        stack$iv.add(node6);
                        count$iv = this_$iv$iv2;
                        i = 0;
                        i7 = i9;
                        i4 = $i$f$tailToHead$ui_release;
                        node3 = parent$ui_release;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        node$iv3 = i5;
                        i4 = $i$f$tailToHead$ui_release;
                        node3 = parent$ui_release;
                        next$iv = i5;
                        node$iv = 0;
                        this_$iv$iv = 1;
                    }
                    node$iv2 = 0;
                    if (this_$iv$iv2 == 1) {
                    } else {
                    }
                    nodes$ui_release = this_$iv;
                    $i$f$tailToHead$ui_release = i4;
                    parent$ui_release = node3;
                    count$iv2 = 64;
                    i5 = node$iv$iv;
                    node2 = 0;
                    count$iv = 0;
                    if (kindSet$ui_release3 &= kind$iv != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    this_$iv = nodes$ui_release;
                    i4 = $i$f$tailToHead$ui_release;
                    node3 = parent$ui_release;
                    next$iv = i5;
                    node$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    nodes$ui_release = this_$iv;
                    $i$f$tailToHead$ui_release = i4;
                    parent$ui_release = node3;
                    this_$iv$iv2++;
                    this_$iv = nodes$ui_release;
                    if (this_$iv$iv2 == 1) {
                    } else {
                    }
                    if (stack$iv == 0) {
                    } else {
                    }
                    count$iv = this_$iv$iv2;
                    i4 = $i$f$tailToHead$ui_release;
                    node3 = parent$ui_release;
                    node$iv = 0;
                    $i$f$mutableVectorOf = stack$iv;
                    stack$iv = $i$f$mutableVectorOf;
                    node6 = node$iv3;
                    if (node6 != null && stack$iv != null) {
                    }
                    if (stack$iv != null) {
                    } else {
                    }
                    next$iv = i5;
                    this_$iv$iv2 = count$iv;
                    stack$iv.add(i5);
                    if (stack$iv != null) {
                    }
                    node$iv3 = $i$f$mutableVectorOf;
                    stack$iv.add(node6);
                    count$iv = this_$iv$iv2;
                    i = 0;
                    i7 = i9;
                    i4 = $i$f$tailToHead$ui_release;
                    node3 = parent$ui_release;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    node$iv3 = i5;
                    i4 = $i$f$tailToHead$ui_release;
                    node3 = parent$ui_release;
                    next$iv = i5;
                    node$iv = 0;
                    this_$iv$iv = 1;
                    this_$iv$iv2 = 1;
                    i5 = 0;
                    int i13 = 0;
                    objectRef.element = (ParentDataModifierNode)node$iv3.modifyParentData(getLayoutNode().getDensity(), objectRef.element);
                    this_$iv = nodes$ui_release;
                    i4 = $i$f$tailToHead$ui_release;
                    node3 = parent$ui_release;
                    this_$iv2 = 1;
                    node$iv2 = 0;
                }
                this_$iv = nodes$ui_release;
                i4 = $i$f$tailToHead$ui_release;
                node3 = parent$ui_release;
                if (node$iv3 instanceof ParentDataModifierNode) {
                } else {
                }
                element = 0;
                if (kindSet$ui_release2 &= kind$iv != 0) {
                } else {
                }
                this_$iv$iv2 = 0;
                if (this_$iv$iv2 != 0 && node$iv3 instanceof DelegatingNode) {
                } else {
                }
                this_$iv = nodes$ui_release;
                i4 = $i$f$tailToHead$ui_release;
                node3 = parent$ui_release;
                this_$iv2 = 1;
                node$iv2 = 0;
                node$iv3 = DelegatableNodeKt.access$pop(stack$iv);
                nodes$ui_release = this_$iv;
                $i$f$tailToHead$ui_release = i4;
                parent$ui_release = node3;
                count$iv2 = 64;
                if (node$iv3 instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv2 = 0;
                i6 = 0;
                node$iv$iv = (DelegatingNode)node$iv3.getDelegate$ui_release();
                while (node$iv$iv != null) {
                    i5 = node$iv$iv;
                    node2 = 0;
                    count$iv = 0;
                    if (kindSet$ui_release3 &= kind$iv != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    this_$iv = nodes$ui_release;
                    i4 = $i$f$tailToHead$ui_release;
                    node3 = parent$ui_release;
                    next$iv = i5;
                    node$iv = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    nodes$ui_release = this_$iv;
                    $i$f$tailToHead$ui_release = i4;
                    parent$ui_release = node3;
                    this_$iv$iv2++;
                    this_$iv = nodes$ui_release;
                    if (this_$iv$iv2 == 1) {
                    } else {
                    }
                    if (stack$iv == 0) {
                    } else {
                    }
                    count$iv = this_$iv$iv2;
                    i4 = $i$f$tailToHead$ui_release;
                    node3 = parent$ui_release;
                    node$iv = 0;
                    $i$f$mutableVectorOf = stack$iv;
                    stack$iv = $i$f$mutableVectorOf;
                    node6 = node$iv3;
                    if (node6 != null && stack$iv != null) {
                    }
                    if (stack$iv != null) {
                    } else {
                    }
                    next$iv = i5;
                    this_$iv$iv2 = count$iv;
                    stack$iv.add(i5);
                    if (stack$iv != null) {
                    }
                    node$iv3 = $i$f$mutableVectorOf;
                    stack$iv.add(node6);
                    count$iv = this_$iv$iv2;
                    i = 0;
                    i7 = i9;
                    i4 = $i$f$tailToHead$ui_release;
                    node3 = parent$ui_release;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    node$iv3 = i5;
                    i4 = $i$f$tailToHead$ui_release;
                    node3 = parent$ui_release;
                    next$iv = i5;
                    node$iv = 0;
                    this_$iv$iv = 1;
                }
                node$iv2 = 0;
                if (this_$iv$iv2 == 1) {
                } else {
                }
                nodes$ui_release = this_$iv;
                $i$f$tailToHead$ui_release = i4;
                parent$ui_release = node3;
                count$iv2 = 64;
                i5 = node$iv$iv;
                node2 = 0;
                count$iv = 0;
                if (kindSet$ui_release3 &= kind$iv != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0) {
                } else {
                }
                this_$iv = nodes$ui_release;
                i4 = $i$f$tailToHead$ui_release;
                node3 = parent$ui_release;
                next$iv = i5;
                node$iv = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                nodes$ui_release = this_$iv;
                $i$f$tailToHead$ui_release = i4;
                parent$ui_release = node3;
                this_$iv$iv2++;
                this_$iv = nodes$ui_release;
                if (this_$iv$iv2 == 1) {
                } else {
                }
                if (stack$iv == 0) {
                } else {
                }
                count$iv = this_$iv$iv2;
                i4 = $i$f$tailToHead$ui_release;
                node3 = parent$ui_release;
                node$iv = 0;
                $i$f$mutableVectorOf = stack$iv;
                stack$iv = $i$f$mutableVectorOf;
                node6 = node$iv3;
                if (node6 != null && stack$iv != null) {
                }
                if (stack$iv != null) {
                } else {
                }
                next$iv = i5;
                this_$iv$iv2 = count$iv;
                stack$iv.add(i5);
                if (stack$iv != null) {
                }
                node$iv3 = $i$f$mutableVectorOf;
                stack$iv.add(node6);
                count$iv = this_$iv$iv2;
                i = 0;
                i7 = i9;
                i4 = $i$f$tailToHead$ui_release;
                node3 = parent$ui_release;
                $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                node$iv3 = i5;
                i4 = $i$f$tailToHead$ui_release;
                node3 = parent$ui_release;
                next$iv = i5;
                node$iv = 0;
                this_$iv$iv = 1;
                this_$iv$iv2 = 1;
                i5 = 0;
                i13 = 0;
                objectRef.element = (ParentDataModifierNode)node$iv3.modifyParentData(getLayoutNode().getDensity(), objectRef.element);
                this_$iv = nodes$ui_release;
                i4 = $i$f$tailToHead$ui_release;
                node3 = parent$ui_release;
                this_$iv2 = 1;
                node$iv2 = 0;
                kind$iv = 1;
            }
            return objectRef.element;
        }
        return null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LayoutCoordinates getParentLayoutCoordinates() {
        String str;
        final int i = 0;
        if (!isAttached()) {
            int i2 = 0;
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        onCoordinatesUsed$ui_release();
        return (LayoutCoordinates)outerCoordinator$ui_release.wrappedBy;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public long getPosition-nOcc-ac() {
        return this.position;
    }

    public Set<AlignmentLine> getProvidedAlignmentLines() {
        int set;
        Object coordinator;
        Map alignmentLines;
        Set emptySet;
        int linkedHashSet;
        int i;
        int i2;
        set = 0;
        coordinator = this;
        while (coordinator != null) {
            MeasureResult _measureResult = coordinator._measureResult;
            if (_measureResult != null) {
            } else {
            }
            alignmentLines = 0;
            linkedHashSet = 0;
            i2 = 1;
            if (alignmentLines != null && empty ^= i2 == i2) {
            }
            if (linkedHashSet != null && set == null) {
            }
            coordinator = coordinator.wrapped;
            if (set == null) {
            }
            set.addAll((Collection)alignmentLines.keySet());
            linkedHashSet = new LinkedHashSet();
            set = linkedHashSet;
            i2 = 1;
            if (empty ^= i2 == i2) {
            }
            linkedHashSet = i2;
            alignmentLines = _measureResult.getAlignmentLines();
        }
        if (set == null) {
            emptySet = SetsKt.emptySet();
        } else {
            emptySet = set;
        }
        return emptySet;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    protected final MutableRect getRectCache() {
        MutableRect mutableRect;
        MutableRect mutableRect2;
        int i;
        if (this._rectCache == null) {
            int i2 = 0;
            mutableRect = new MutableRect(i2, i2, i2, i2);
            i = 0;
            this._rectCache = mutableRect;
        }
        return mutableRect;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final long getSize-YbymL2g() {
        return getMeasuredSize-YbymL2g();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public abstract Modifier.Node getTail();

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final androidx.compose.ui.node.NodeCoordinator getWrapped$ui_release() {
        return this.wrapped;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final androidx.compose.ui.node.NodeCoordinator getWrappedBy$ui_release() {
        return this.wrappedBy;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final float getZIndex() {
        return this.zIndex;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final Modifier.Node head-H91voCI(int type) {
        Modifier.Node parent$ui_release;
        Modifier.Node node$iv;
        int i;
        boolean includeSelfInTraversal-H91voCI = NodeKindKt.getIncludeSelfInTraversal-H91voCI(type);
        final androidx.compose.ui.node.NodeCoordinator nodeCoordinator = this;
        final int i2 = type;
        final int i3 = 0;
        if (includeSelfInTraversal-H91voCI) {
            node$iv = NodeCoordinator.access$headNode(nodeCoordinator, includeSelfInTraversal-H91voCI);
            while (node$iv != null) {
                node$iv = node$iv.getChild$ui_release();
            }
        } else {
            if (nodeCoordinator.getTail().getParent$ui_release() == null) {
            } else {
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void hitTest-YqVAtuI(androidx.compose.ui.node.NodeCoordinator.HitTestSource hitTestSource, long pointerPosition, androidx.compose.ui.node.HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        boolean withinLayerBounds-k-4lQ0M;
        int hitInMinimumTouchTargetBetter;
        androidx.compose.ui.node.NodeCoordinator.HitTestSource i;
        long minimumTouchTargetSize-NH-jbRc;
        boolean z2;
        int distanceInMinimumTouchTarget-tz77jQw;
        boolean infinite;
        boolean z;
        boolean f;
        int distanceInMinimumTouchTarget-tz77jQw2;
        final Modifier.Node head-H91voCI = head-H91voCI(hitTestSource.entityType-OLwlOKw());
        hitInMinimumTouchTargetBetter = 1;
        i = 0;
        if (!withinLayerBounds-k-4lQ0M(pointerPosition)) {
            if (isInLayer) {
                distanceInMinimumTouchTarget-tz77jQw2 = distanceInMinimumTouchTarget-tz77jQw(pointerPosition, hitTestResult);
                if (!Float.isInfinite(distanceInMinimumTouchTarget-tz77jQw2) && !Float.isNaN(distanceInMinimumTouchTarget-tz77jQw2)) {
                    if (!Float.isNaN(distanceInMinimumTouchTarget-tz77jQw2)) {
                    } else {
                        hitInMinimumTouchTargetBetter = i;
                    }
                } else {
                }
                if (hitInMinimumTouchTargetBetter != 0 && isTouchEvent.isHitInMinimumTouchTargetBetter(distanceInMinimumTouchTarget-tz77jQw2, i)) {
                    if (isTouchEvent.isHitInMinimumTouchTargetBetter(distanceInMinimumTouchTarget-tz77jQw2, i)) {
                        this.hitNear-JHbHoSQ(head-H91voCI, hitTestSource, pointerPosition, obj5, isTouchEvent, isInLayer, 0);
                    }
                }
            }
        } else {
            if (head-H91voCI == null) {
                hitTestChild-YqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            } else {
                if (isPointerInBounds-k-4lQ0M(pointerPosition)) {
                    this.hit-1hIXUjU(head-H91voCI, hitTestSource, pointerPosition, obj5, isTouchEvent, isInLayer);
                } else {
                    if (!isInLayer) {
                        distanceInMinimumTouchTarget-tz77jQw2 = distanceInMinimumTouchTarget-tz77jQw;
                    } else {
                        distanceInMinimumTouchTarget-tz77jQw2 = distanceInMinimumTouchTarget-tz77jQw;
                    }
                    if (!Float.isInfinite(distanceInMinimumTouchTarget-tz77jQw2) && !Float.isNaN(distanceInMinimumTouchTarget-tz77jQw2)) {
                        if (!Float.isNaN(distanceInMinimumTouchTarget-tz77jQw2)) {
                        } else {
                            hitInMinimumTouchTargetBetter = i;
                        }
                    } else {
                    }
                    f = obj16;
                    if (hitInMinimumTouchTargetBetter != 0 && isTouchEvent.isHitInMinimumTouchTargetBetter(distanceInMinimumTouchTarget-tz77jQw2, f)) {
                        f = obj16;
                        if (isTouchEvent.isHitInMinimumTouchTargetBetter(distanceInMinimumTouchTarget-tz77jQw2, f)) {
                            this.hitNear-JHbHoSQ(head-H91voCI, hitTestSource, pointerPosition, obj5, isTouchEvent, isInLayer, f);
                        } else {
                            this.speculativeHit-JHbHoSQ(head-H91voCI, hitTestSource, pointerPosition, obj5, isTouchEvent, isInLayer, obj16);
                        }
                    } else {
                    }
                }
            }
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void hitTestChild-YqVAtuI(androidx.compose.ui.node.NodeCoordinator.HitTestSource hitTestSource, long pointerPosition, androidx.compose.ui.node.HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        androidx.compose.ui.node.NodeCoordinator.HitTestSource hitTestSource2;
        long l;
        int i;
        boolean z;
        boolean z2;
        Object obj;
        androidx.compose.ui.node.NodeCoordinator nodeCoordinator;
        long obj11;
        final androidx.compose.ui.node.NodeCoordinator wrapped = this.wrapped;
        if (wrapped != null) {
            i = 0;
            androidx.compose.ui.node.NodeCoordinator nodeCoordinator2 = pointerPosition;
            nodeCoordinator = nodeCoordinator2;
            wrapped.hitTest-YqVAtuI(hitTestSource, NodeCoordinator.fromParentPosition-8S9VItk$default(wrapped, nodeCoordinator2, obj2, i, 2), i, isTouchEvent, isInLayer);
        } else {
            hitTestSource2 = hitTestSource;
            nodeCoordinator = pointerPosition;
            z = isTouchEvent;
            z2 = isInLayer;
            obj = obj15;
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void invalidateLayer() {
        androidx.compose.ui.node.NodeCoordinator wrappedBy;
        final androidx.compose.ui.node.OwnedLayer layer = this.layer;
        if (layer != null) {
            layer.invalidate();
        } else {
            wrappedBy = this.wrappedBy;
            if (wrappedBy != null) {
                wrappedBy.invalidateLayer();
            }
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean isAttached() {
        return getTail().isAttached();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    protected final boolean isPointerInBounds-k-4lQ0M(long pointerPosition) {
        int cmp;
        int i;
        final float x-impl = Offset.getX-impl(pointerPosition);
        final float y-impl = Offset.getY-impl(pointerPosition);
        cmp = 0;
        if (Float.compare(x-impl, cmp) >= 0 && Float.compare(y-impl, cmp) >= 0 && Float.compare(x-impl, f) < 0 && Float.compare(y-impl, f2) < 0) {
            if (Float.compare(y-impl, cmp) >= 0) {
                if (Float.compare(x-impl, f) < 0) {
                    i = Float.compare(y-impl, f2) < 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final boolean isTransparent() {
        androidx.compose.ui.node.OwnedLayer layer;
        int i;
        if (this.layer != null && Float.compare(lastLayerAlpha, i) <= 0) {
            if (Float.compare(lastLayerAlpha, i) <= 0) {
                return 1;
            }
        }
        androidx.compose.ui.node.NodeCoordinator wrappedBy = this.wrappedBy;
        if (wrappedBy != null) {
            return wrappedBy.isTransparent();
        }
        return 0;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean isValidOwnerScope() {
        int i;
        androidx.compose.ui.node.OwnedLayer released;
        if (this.layer != null && !this.released && getLayoutNode().isAttached()) {
            if (!this.released) {
                i = getLayoutNode().isAttached() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        String string;
        androidx.compose.ui.node.NodeCoordinator coordinator;
        StringBuilder append;
        String str;
        long size-YbymL2g;
        long l;
        int i2;
        int i;
        long obj10;
        int i3 = 0;
        if (!isAttached()) {
            int i7 = 0;
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        int i4 = 0;
        if (!sourceCoordinates.isAttached()) {
            int i5 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            InlineClassHelperKt.throwIllegalStateException(stringBuilder.append("LayoutCoordinates ").append(sourceCoordinates).append(" is not attached!").toString());
        }
        androidx.compose.ui.node.NodeCoordinator coordinator2 = toCoordinator(sourceCoordinates);
        coordinator2.onCoordinatesUsed$ui_release();
        androidx.compose.ui.node.NodeCoordinator commonAncestor$ui_release = findCommonAncestor$ui_release(coordinator2);
        MutableRect rectCache = getRectCache();
        int i6 = 0;
        rectCache.setLeft(i6);
        rectCache.setTop(i6);
        rectCache.setRight((float)width-impl);
        rectCache.setBottom((float)height-impl);
        coordinator = coordinator2;
        while (coordinator != commonAncestor$ui_release) {
            size-YbymL2g = obj10;
            NodeCoordinator.rectInParent$ui_release$default(coordinator, rectCache, size-YbymL2g, 0L, 4, 0);
            obj10 = coordinator.wrappedBy;
            Intrinsics.checkNotNull(obj10);
            coordinator = obj10;
            obj10 = size-YbymL2g;
        }
        ancestorToLocal(commonAncestor$ui_release, rectCache, obj10);
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public long localPositionOf-R5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        return localPositionOf-S_NoaFU(sourceCoordinates, relativeToSource, obj5);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public long localPositionOf-S_NoaFU(LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference) {
        long position;
        androidx.compose.ui.node.NodeCoordinator coordinator;
        androidx.compose.ui.node.NodeCoordinator wrappedBy;
        if (sourceCoordinates instanceof LookaheadLayoutCoordinates) {
            (LookaheadLayoutCoordinates)sourceCoordinates.getCoordinator().onCoordinatesUsed$ui_release();
            long unaryMinus-F1C5BW02 = Offset.unaryMinus-F1C5BW0(relativeToSource);
            return Offset.unaryMinus-F1C5BW0(sourceCoordinates.localPositionOf-S_NoaFU((LayoutCoordinates)this, unaryMinus-F1C5BW02, obj2));
        }
        androidx.compose.ui.node.NodeCoordinator coordinator3 = toCoordinator(sourceCoordinates);
        coordinator3.onCoordinatesUsed$ui_release();
        androidx.compose.ui.node.NodeCoordinator commonAncestor$ui_release = findCommonAncestor$ui_release(coordinator3);
        position = relativeToSource;
        coordinator = coordinator3;
        while (coordinator != commonAncestor$ui_release) {
            position = coordinator.toParentPosition-8S9VItk(position, obj3);
            wrappedBy = coordinator.wrappedBy;
            Intrinsics.checkNotNull(wrappedBy);
            coordinator = wrappedBy;
        }
        return ancestorToLocal-S_NoaFU(commonAncestor$ui_release, position, obj3);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public long localToRoot-MK-Hz9U(long relativeToLocal) {
        String str;
        Object coordinator;
        androidx.compose.ui.node.NodeCoordinator position;
        int i3;
        int i;
        int i2;
        int i4 = 0;
        if (!isAttached()) {
            int i5 = 0;
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        onCoordinatesUsed$ui_release();
        coordinator = obj;
        position = nodeCoordinator;
        while (coordinator != null) {
            position = NodeCoordinator.toParentPosition-8S9VItk$default(coordinator, position, obj5, 0, 2);
            coordinator = coordinator.wrappedBy;
        }
        return position;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public long localToScreen-MK-Hz9U(long relativeToLocal) {
        String str;
        if (!isAttached()) {
            int i2 = 0;
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return LayoutNodeKt.requireOwner(getLayoutNode()).localToScreen-MK-Hz9U(localToRoot-MK-Hz9U(relativeToLocal));
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public long localToWindow-MK-Hz9U(long relativeToLocal) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).calculatePositionInWindow-MK-Hz9U(localToRoot-MK-Hz9U(relativeToLocal));
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void onCoordinatesUsed$ui_release() {
        getLayoutNode().getLayoutDelegate$ui_release().onCoordinatesUsed();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void onLayoutModifierNodeChanged() {
        final androidx.compose.ui.node.OwnedLayer layer = this.layer;
        if (layer != null) {
            layer.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void onLayoutNodeAttach() {
        updateLayerBlock(this.layerBlock, true);
        androidx.compose.ui.node.OwnedLayer layer = this.layer;
        if (layer != null) {
            layer.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    protected void onMeasureResultChanged(int width, int height) {
        Object count$iv$iv2;
        Modifier.Node count$iv$iv;
        androidx.compose.ui.node.OwnedLayer layer;
        boolean wrappedBy;
        int type$iv;
        Modifier.Node type$iv2;
        int node$iv$iv;
        Modifier.Node node4;
        int node$iv$iv6;
        int node$iv$iv2;
        Modifier.Node parent$ui_release;
        Modifier.Node node$iv$iv4;
        Modifier.Node node2;
        int i3;
        Modifier.Node node;
        int i;
        int i4;
        Modifier.Node node$iv$iv3;
        int i5;
        int i9;
        Modifier.Node node5;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node3;
        int i2;
        androidx.compose.ui.node.OwnedLayer layer2;
        int this_$iv$iv$iv;
        int count$iv$iv3;
        int i7;
        int i6;
        int i8;
        Modifier.Node node$iv$iv5;
        count$iv$iv2 = this;
        layer = count$iv$iv2.layer;
        if (layer != null) {
            layer.resize-ozmzZPI(IntSizeKt.IntSize(width, height));
        } else {
            wrappedBy = count$iv$iv2.wrappedBy;
            if (count$iv$iv2.getLayoutNode().isPlaced() && wrappedBy != null) {
                wrappedBy = count$iv$iv2.wrappedBy;
                if (wrappedBy != null) {
                    wrappedBy.invalidateLayer();
                }
            }
        }
        count$iv$iv2.setMeasuredSize-ozmzZPI(IntSizeKt.IntSize(width, height));
        if (count$iv$iv2.layerBlock != null) {
            count$iv$iv2.updateLayerParameters(false);
        }
        int i11 = 0;
        type$iv = NodeKind.constructor-impl(4);
        final int i13 = 0;
        final boolean includeSelfInTraversal-H91voCI = NodeKindKt.getIncludeSelfInTraversal-H91voCI(type$iv);
        final int i14 = type$iv;
        final androidx.compose.ui.node.NodeCoordinator nodeCoordinator = obj;
        final int i15 = 0;
        if (includeSelfInTraversal-H91voCI) {
            node$iv$iv4 = NodeCoordinator.access$headNode(nodeCoordinator, includeSelfInTraversal-H91voCI);
            while (node$iv$iv4 != null) {
                if (kindSet$ui_release &= i14 != 0) {
                } else {
                }
                layer2 = layer;
                i8 = type$iv;
                node$iv$iv4 = node$iv$iv4.getChild$ui_release();
                count$iv$iv2 = this;
                layer = layer2;
                type$iv = i8;
                i3 = 0;
                i = 0;
                i4 = 0;
                int i16 = 0;
                node4 = node$iv$iv3;
                while (node4 != null) {
                    if (node4 instanceof DrawModifierNode) {
                    } else {
                    }
                    count$iv$iv = node4;
                    int i17 = 0;
                    Modifier.Node node8 = count$iv$iv;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    i5 = 0;
                    if (i5 != 0 && node4 instanceof DelegatingNode) {
                    } else {
                    }
                    layer2 = layer;
                    i8 = type$iv;
                    node5 = node4;
                    node$iv$iv6 = 0;
                    node$iv$iv5 = node5;
                    node4 = node6;
                    layer = layer2;
                    type$iv = i8;
                    count$iv$iv2 = this;
                    if (node4 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    node5 = 0;
                    node$iv$iv$iv = (DelegatingNode)node4.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node3 = node$iv$iv$iv;
                        i2 = 0;
                        count$iv$iv3 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        layer2 = layer;
                        i8 = type$iv;
                        node$iv$iv5 = node4;
                        type$iv2 = node3;
                        node$iv$iv2 = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        layer = layer2;
                        type$iv = i8;
                        node4 = node$iv$iv5;
                        count$iv$iv++;
                        layer2 = layer;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (i4 == 0) {
                        } else {
                        }
                        count$iv$iv3 = count$iv$iv;
                        i8 = type$iv;
                        node$iv$iv5 = node4;
                        node$iv$iv2 = 0;
                        layer = i4;
                        Modifier.Node node7 = node$iv$iv5;
                        if (node7 != null && layer != 0) {
                        }
                        if (layer != 0) {
                        } else {
                        }
                        type$iv2 = node3;
                        i4 = layer;
                        count$iv$iv = count$iv$iv3;
                        layer.add(node3);
                        if (layer != 0) {
                        }
                        node$iv$iv5 = type$iv;
                        layer.add(node7);
                        count$iv$iv3 = count$iv$iv;
                        i7 = 0;
                        i6 = i10;
                        i8 = type$iv;
                        node$iv$iv5 = node4;
                        layer = new MutableVector(new Modifier.Node[16], 0);
                        i8 = type$iv;
                        node$iv$iv5 = node$iv$iv7;
                        type$iv2 = node3;
                        node$iv$iv2 = 0;
                        this_$iv$iv$iv = 1;
                    }
                    node$iv$iv6 = 0;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    count$iv$iv2 = this;
                    layer = layer2;
                    type$iv = i8;
                    node4 = node$iv$iv5;
                    node3 = node$iv$iv$iv;
                    i2 = 0;
                    count$iv$iv3 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    layer2 = layer;
                    i8 = type$iv;
                    node$iv$iv5 = node4;
                    type$iv2 = node3;
                    node$iv$iv2 = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    layer = layer2;
                    type$iv = i8;
                    node4 = node$iv$iv5;
                    count$iv$iv++;
                    layer2 = layer;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (i4 == 0) {
                    } else {
                    }
                    count$iv$iv3 = count$iv$iv;
                    i8 = type$iv;
                    node$iv$iv5 = node4;
                    node$iv$iv2 = 0;
                    layer = i4;
                    node7 = node$iv$iv5;
                    if (node7 != null && layer != 0) {
                    }
                    if (layer != 0) {
                    } else {
                    }
                    type$iv2 = node3;
                    i4 = layer;
                    count$iv$iv = count$iv$iv3;
                    layer.add(node3);
                    if (layer != 0) {
                    }
                    node$iv$iv5 = type$iv;
                    layer.add(node7);
                    count$iv$iv3 = count$iv$iv;
                    i7 = 0;
                    i6 = i10;
                    i8 = type$iv;
                    node$iv$iv5 = node4;
                    layer = new MutableVector(new Modifier.Node[16], 0);
                    i8 = type$iv;
                    node$iv$iv5 = node$iv$iv7;
                    type$iv2 = node3;
                    node$iv$iv2 = 0;
                    this_$iv$iv$iv = 1;
                    i5 = 1;
                    i5 = 0;
                    (DrawModifierNode)node4.onMeasureResultChanged();
                    layer2 = layer;
                    i8 = type$iv;
                    node5 = node4;
                    node$iv$iv6 = 0;
                }
                layer2 = layer;
                i8 = type$iv;
                node5 = node4;
                node$iv$iv = 0;
                if (node4 instanceof DrawModifierNode) {
                } else {
                }
                count$iv$iv = node4;
                i17 = 0;
                node8 = count$iv$iv;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                i5 = 0;
                if (i5 != 0 && node4 instanceof DelegatingNode) {
                } else {
                }
                layer2 = layer;
                i8 = type$iv;
                node5 = node4;
                node$iv$iv6 = 0;
                node$iv$iv5 = node5;
                node4 = node6;
                layer = layer2;
                type$iv = i8;
                count$iv$iv2 = this;
                if (node4 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                node5 = 0;
                node$iv$iv$iv = (DelegatingNode)node4.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node3 = node$iv$iv$iv;
                    i2 = 0;
                    count$iv$iv3 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    layer2 = layer;
                    i8 = type$iv;
                    node$iv$iv5 = node4;
                    type$iv2 = node3;
                    node$iv$iv2 = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    layer = layer2;
                    type$iv = i8;
                    node4 = node$iv$iv5;
                    count$iv$iv++;
                    layer2 = layer;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (i4 == 0) {
                    } else {
                    }
                    count$iv$iv3 = count$iv$iv;
                    i8 = type$iv;
                    node$iv$iv5 = node4;
                    node$iv$iv2 = 0;
                    layer = i4;
                    node7 = node$iv$iv5;
                    if (node7 != null && layer != 0) {
                    }
                    if (layer != 0) {
                    } else {
                    }
                    type$iv2 = node3;
                    i4 = layer;
                    count$iv$iv = count$iv$iv3;
                    layer.add(node3);
                    if (layer != 0) {
                    }
                    node$iv$iv5 = type$iv;
                    layer.add(node7);
                    count$iv$iv3 = count$iv$iv;
                    i7 = 0;
                    i6 = i10;
                    i8 = type$iv;
                    node$iv$iv5 = node4;
                    layer = new MutableVector(new Modifier.Node[16], 0);
                    i8 = type$iv;
                    node$iv$iv5 = node$iv$iv7;
                    type$iv2 = node3;
                    node$iv$iv2 = 0;
                    this_$iv$iv$iv = 1;
                }
                node$iv$iv6 = 0;
                if (count$iv$iv == 1) {
                } else {
                }
                count$iv$iv2 = this;
                layer = layer2;
                type$iv = i8;
                node4 = node$iv$iv5;
                node3 = node$iv$iv$iv;
                i2 = 0;
                count$iv$iv3 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                layer2 = layer;
                i8 = type$iv;
                node$iv$iv5 = node4;
                type$iv2 = node3;
                node$iv$iv2 = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                layer = layer2;
                type$iv = i8;
                node4 = node$iv$iv5;
                count$iv$iv++;
                layer2 = layer;
                if (count$iv$iv == 1) {
                } else {
                }
                if (i4 == 0) {
                } else {
                }
                count$iv$iv3 = count$iv$iv;
                i8 = type$iv;
                node$iv$iv5 = node4;
                node$iv$iv2 = 0;
                layer = i4;
                node7 = node$iv$iv5;
                if (node7 != null && layer != 0) {
                }
                if (layer != 0) {
                } else {
                }
                type$iv2 = node3;
                i4 = layer;
                count$iv$iv = count$iv$iv3;
                layer.add(node3);
                if (layer != 0) {
                }
                node$iv$iv5 = type$iv;
                layer.add(node7);
                count$iv$iv3 = count$iv$iv;
                i7 = 0;
                i6 = i10;
                i8 = type$iv;
                node$iv$iv5 = node4;
                layer = new MutableVector(new Modifier.Node[16], 0);
                i8 = type$iv;
                node$iv$iv5 = node$iv$iv7;
                type$iv2 = node3;
                node$iv$iv2 = 0;
                this_$iv$iv$iv = 1;
                i5 = 1;
                i5 = 0;
                (DrawModifierNode)node4.onMeasureResultChanged();
                layer2 = layer;
                i8 = type$iv;
                node5 = node4;
                node$iv$iv6 = 0;
            }
            layer2 = layer;
            i8 = type$iv;
        } else {
            if (nodeCoordinator.getTail().getParent$ui_release() == null) {
                layer2 = layer;
                i8 = type$iv;
            } else {
            }
        }
        androidx.compose.ui.node.Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(getLayoutNode());
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void onMeasured() {
        boolean node-H91voCI;
        int readObserver;
        int node$iv$iv4;
        int node$iv$iv2;
        int constructor-impl;
        Modifier.Node this_$iv$iv$iv;
        int capacity$iv$iv$iv$iv;
        Modifier.Node next$iv$iv;
        Modifier.Node[] arr;
        Snapshot.Companion companion;
        int i7;
        Snapshot currentThreadSnapshot;
        Function1 function1;
        Snapshot currentNonObservable;
        androidx.compose.ui.node.NodeCoordinator count$iv$iv2;
        long count$iv$iv;
        int i3;
        boolean includeSelfInTraversal-H91voCI;
        int i8;
        androidx.compose.ui.node.NodeCoordinator nodeCoordinator;
        int i9;
        Modifier.Node parent$ui_release;
        Modifier.Node node$iv$iv5;
        int i14;
        int i4;
        Modifier.Node node;
        int i5;
        int i2;
        int node$iv$iv;
        int type$iv;
        int i10;
        androidx.compose.ui.node.NodeCoordinator this_$iv;
        int i;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i12;
        int this_$iv$iv$iv2;
        int i6;
        int i13;
        Modifier.Node node$iv$iv3;
        int i11;
        Modifier.Node node3;
        int i15 = 0;
        constructor-impl = 128;
        if (this.hasNode-H91voCI(NodeKind.constructor-impl(constructor-impl))) {
            companion = Snapshot.Companion;
            i7 = 0;
            currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            if (currentThreadSnapshot != null) {
                readObserver = currentThreadSnapshot.getReadObserver();
            } else {
                readObserver = 0;
            }
            int i17 = 0;
            constructor-impl = NodeKind.constructor-impl(constructor-impl);
            count$iv$iv2 = this;
            includeSelfInTraversal-H91voCI = NodeKindKt.getIncludeSelfInTraversal-H91voCI(constructor-impl);
            i8 = constructor-impl;
            nodeCoordinator = count$iv$iv2;
            i9 = 0;
            if (includeSelfInTraversal-H91voCI) {
                parent$ui_release = nodeCoordinator.getTail();
                node$iv$iv5 = NodeCoordinator.access$headNode(nodeCoordinator, includeSelfInTraversal-H91voCI);
                while (node$iv$iv5 != null) {
                    if (kindSet$ui_release2 &= i8 != 0) {
                    } else {
                    }
                    node$iv$iv = node$iv$iv4;
                    type$iv = constructor-impl;
                    this_$iv = count$iv$iv2;
                    i = i3;
                    node$iv$iv5 = child$ui_release;
                    arr = this;
                    node$iv$iv4 = node$iv$iv;
                    constructor-impl = type$iv;
                    count$iv$iv2 = this_$iv;
                    i3 = i;
                    i4 = 0;
                    i5 = 0;
                    i2 = 0;
                    int i19 = 0;
                    node$iv$iv = node$iv$iv4;
                    node$iv$iv4 = node3;
                    while (node$iv$iv4 != null) {
                        type$iv = constructor-impl;
                        if (node$iv$iv4 instanceof LayoutAwareModifierNode) {
                        } else {
                        }
                        Modifier.Node node5 = node$iv$iv4;
                        int i18 = 0;
                        i10 = node5;
                        if (kindSet$ui_release &= type$iv != 0) {
                        } else {
                        }
                        count$iv$iv = 0;
                        if (count$iv$iv != 0 && node$iv$iv4 instanceof DelegatingNode) {
                        } else {
                        }
                        node$iv$iv4 = node4;
                        arr = this;
                        constructor-impl = type$iv;
                        count$iv$iv2 = this_$iv;
                        i3 = i;
                        if (node$iv$iv4 instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv = 0;
                        i10 = 0;
                        node$iv$iv$iv = (DelegatingNode)node$iv$iv4.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node2 = node$iv$iv$iv;
                            i12 = 0;
                            i6 = 0;
                            if (kindSet$ui_release3 &= type$iv != 0) {
                            } else {
                            }
                            this_$iv$iv$iv2 = 0;
                            if (this_$iv$iv$iv2 != 0) {
                            } else {
                            }
                            node$iv$iv3 = node$iv$iv4;
                            next$iv$iv = node2;
                            node$iv$iv$iv = child$ui_release2;
                            this_$iv$iv$iv = 1;
                            arr = this;
                            if (count$iv$iv++ == this_$iv$iv$iv) {
                            } else {
                            }
                            if (i2 == 0) {
                            } else {
                            }
                            node$iv$iv3 = node$iv$iv4;
                            capacity$iv$iv$iv$iv = 0;
                            node$iv$iv2 = i2;
                            arr = node$iv$iv3;
                            if (arr != null && node$iv$iv2 != 0) {
                            }
                            if (node$iv$iv2 != 0) {
                            } else {
                            }
                            next$iv$iv = node2;
                            i2 = node$iv$iv2;
                            node$iv$iv4 = node$iv$iv3;
                            node$iv$iv2.add(node2);
                            if (node$iv$iv2 != 0) {
                            }
                            node$iv$iv3 = i2;
                            node$iv$iv2.add(arr);
                            this_$iv$iv$iv2 = 0;
                            int i16 = 16;
                            i13 = 0;
                            node$iv$iv3 = node$iv$iv4;
                            i11 = i16;
                            node$iv$iv2 = new MutableVector(new Modifier.Node[i16], 0);
                            node$iv$iv4 = node2;
                            next$iv$iv = node2;
                            this_$iv$iv$iv2 = this_$iv$iv$iv;
                        }
                        node$iv$iv3 = node$iv$iv4;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        node$iv$iv4 = node$iv$iv3;
                        arr = this;
                        constructor-impl = type$iv;
                        count$iv$iv2 = this_$iv;
                        i3 = i;
                        node$iv$iv4 = node$iv$iv3;
                        node2 = node$iv$iv$iv;
                        i12 = 0;
                        i6 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        node$iv$iv3 = node$iv$iv4;
                        next$iv$iv = node2;
                        node$iv$iv$iv = child$ui_release2;
                        this_$iv$iv$iv = 1;
                        arr = this;
                        if (count$iv$iv++ == this_$iv$iv$iv) {
                        } else {
                        }
                        if (i2 == 0) {
                        } else {
                        }
                        node$iv$iv3 = node$iv$iv4;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv2 = i2;
                        arr = node$iv$iv3;
                        if (arr != null && node$iv$iv2 != 0) {
                        }
                        if (node$iv$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv = node2;
                        i2 = node$iv$iv2;
                        node$iv$iv4 = node$iv$iv3;
                        node$iv$iv2.add(node2);
                        if (node$iv$iv2 != 0) {
                        }
                        node$iv$iv3 = i2;
                        node$iv$iv2.add(arr);
                        this_$iv$iv$iv2 = 0;
                        i16 = 16;
                        i13 = 0;
                        node$iv$iv3 = node$iv$iv4;
                        i11 = i16;
                        node$iv$iv2 = new MutableVector(new Modifier.Node[i16], 0);
                        node$iv$iv4 = node2;
                        next$iv$iv = node2;
                        this_$iv$iv$iv2 = this_$iv$iv$iv;
                        count$iv$iv = this_$iv$iv$iv;
                        i10 = 0;
                        this_$iv = count$iv$iv2;
                        i = i3;
                        (LayoutAwareModifierNode)node$iv$iv4.onRemeasured-ozmzZPI(arr.getMeasuredSize-YbymL2g());
                    }
                    type$iv = constructor-impl;
                    this_$iv = count$iv$iv2;
                    i = i3;
                    type$iv = constructor-impl;
                    if (node$iv$iv4 instanceof LayoutAwareModifierNode) {
                    } else {
                    }
                    node5 = node$iv$iv4;
                    i18 = 0;
                    i10 = node5;
                    if (kindSet$ui_release &= type$iv != 0) {
                    } else {
                    }
                    count$iv$iv = 0;
                    if (count$iv$iv != 0 && node$iv$iv4 instanceof DelegatingNode) {
                    } else {
                    }
                    node$iv$iv4 = node4;
                    arr = this;
                    constructor-impl = type$iv;
                    count$iv$iv2 = this_$iv;
                    i3 = i;
                    if (node$iv$iv4 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    i10 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv4.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i12 = 0;
                        i6 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        node$iv$iv3 = node$iv$iv4;
                        next$iv$iv = node2;
                        node$iv$iv$iv = child$ui_release2;
                        this_$iv$iv$iv = 1;
                        arr = this;
                        if (count$iv$iv++ == this_$iv$iv$iv) {
                        } else {
                        }
                        if (i2 == 0) {
                        } else {
                        }
                        node$iv$iv3 = node$iv$iv4;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv2 = i2;
                        arr = node$iv$iv3;
                        if (arr != null && node$iv$iv2 != 0) {
                        }
                        if (node$iv$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv = node2;
                        i2 = node$iv$iv2;
                        node$iv$iv4 = node$iv$iv3;
                        node$iv$iv2.add(node2);
                        if (node$iv$iv2 != 0) {
                        }
                        node$iv$iv3 = i2;
                        node$iv$iv2.add(arr);
                        this_$iv$iv$iv2 = 0;
                        i16 = 16;
                        i13 = 0;
                        node$iv$iv3 = node$iv$iv4;
                        i11 = i16;
                        node$iv$iv2 = new MutableVector(new Modifier.Node[i16], 0);
                        node$iv$iv4 = node2;
                        next$iv$iv = node2;
                        this_$iv$iv$iv2 = this_$iv$iv$iv;
                    }
                    node$iv$iv3 = node$iv$iv4;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    node$iv$iv4 = node$iv$iv3;
                    arr = this;
                    constructor-impl = type$iv;
                    count$iv$iv2 = this_$iv;
                    i3 = i;
                    node$iv$iv4 = node$iv$iv3;
                    node2 = node$iv$iv$iv;
                    i12 = 0;
                    i6 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    node$iv$iv3 = node$iv$iv4;
                    next$iv$iv = node2;
                    node$iv$iv$iv = child$ui_release2;
                    this_$iv$iv$iv = 1;
                    arr = this;
                    if (count$iv$iv++ == this_$iv$iv$iv) {
                    } else {
                    }
                    if (i2 == 0) {
                    } else {
                    }
                    node$iv$iv3 = node$iv$iv4;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv2 = i2;
                    arr = node$iv$iv3;
                    if (arr != null && node$iv$iv2 != 0) {
                    }
                    if (node$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    i2 = node$iv$iv2;
                    node$iv$iv4 = node$iv$iv3;
                    node$iv$iv2.add(node2);
                    if (node$iv$iv2 != 0) {
                    }
                    node$iv$iv3 = i2;
                    node$iv$iv2.add(arr);
                    this_$iv$iv$iv2 = 0;
                    i16 = 16;
                    i13 = 0;
                    node$iv$iv3 = node$iv$iv4;
                    i11 = i16;
                    node$iv$iv2 = new MutableVector(new Modifier.Node[i16], 0);
                    node$iv$iv4 = node2;
                    next$iv$iv = node2;
                    this_$iv$iv$iv2 = this_$iv$iv$iv;
                    count$iv$iv = this_$iv$iv$iv;
                    i10 = 0;
                    this_$iv = count$iv$iv2;
                    i = i3;
                    (LayoutAwareModifierNode)node$iv$iv4.onRemeasured-ozmzZPI(arr.getMeasuredSize-YbymL2g());
                }
                node$iv$iv = node$iv$iv4;
                type$iv = constructor-impl;
                this_$iv = count$iv$iv2;
                i = i3;
            } else {
                if (nodeCoordinator.getTail().getParent$ui_release() == null) {
                    node$iv$iv = node$iv$iv4;
                    type$iv = constructor-impl;
                    this_$iv = count$iv$iv2;
                    i = i3;
                } else {
                }
            }
            node-H91voCI = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), readObserver);
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void onPlaced() {
        int constructor-impl;
        int this_$iv$iv$iv;
        int capacity$iv$iv$iv$iv;
        Object nodeCoordinator;
        int this_$iv2;
        int arr;
        Modifier.Node next$iv$iv;
        Modifier.Node parent$ui_release;
        Modifier.Node node$iv$iv;
        Modifier.Node node2;
        int i2;
        Modifier.Node node5;
        int i;
        int stack$iv$iv;
        Modifier.Node node$iv$iv2;
        int count$iv$iv;
        Modifier.Node node;
        int type$iv;
        Modifier.Node node4;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node3;
        int i5;
        int this_$iv$iv$iv2;
        int i6;
        int i3;
        Modifier.Node this_$iv;
        int i4;
        int i7;
        int i8 = 0;
        constructor-impl = NodeKind.constructor-impl(128);
        nodeCoordinator = this;
        final boolean includeSelfInTraversal-H91voCI = NodeKindKt.getIncludeSelfInTraversal-H91voCI(constructor-impl);
        final androidx.compose.ui.node.NodeCoordinator nodeCoordinator2 = nodeCoordinator;
        final int i11 = constructor-impl;
        final int i12 = 0;
        if (includeSelfInTraversal-H91voCI) {
            node$iv$iv = NodeCoordinator.access$headNode(nodeCoordinator2, includeSelfInTraversal-H91voCI);
            while (node$iv$iv != null) {
                if (kindSet$ui_release &= i11 != 0) {
                } else {
                }
                type$iv = constructor-impl;
                this_$iv = nodeCoordinator;
                i4 = arr;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                constructor-impl = type$iv;
                nodeCoordinator = this_$iv;
                arr = i4;
                i2 = 0;
                i = 0;
                stack$iv$iv = 0;
                int i13 = 0;
                node$iv$iv2 = node5;
                while (node$iv$iv2 != null) {
                    if (node$iv$iv2 instanceof LayoutAwareModifierNode) {
                    } else {
                    }
                    type$iv = constructor-impl;
                    Modifier.Node type$iv2 = node$iv$iv2;
                    int i14 = 0;
                    node4 = type$iv2;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    count$iv$iv = 0;
                    if (count$iv$iv != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv = nodeCoordinator;
                    i4 = arr;
                    node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                    constructor-impl = type$iv;
                    nodeCoordinator = this_$iv;
                    arr = i4;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    node4 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node3 = node$iv$iv$iv;
                        i5 = 0;
                        i6 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        this_$iv = nodeCoordinator;
                        i4 = arr;
                        next$iv$iv = node3;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        nodeCoordinator = this_$iv;
                        arr = i4;
                        this_$iv$iv$iv = 1;
                        if (count$iv$iv++ == this_$iv$iv$iv) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        this_$iv = nodeCoordinator;
                        i4 = arr;
                        capacity$iv$iv$iv$iv = 0;
                        this_$iv2 = stack$iv$iv;
                        stack$iv$iv = this_$iv2;
                        nodeCoordinator = node$iv$iv2;
                        if (nodeCoordinator != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node3;
                        stack$iv$iv.add(node3);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv2 = arr;
                        stack$iv$iv.add(nodeCoordinator);
                        this_$iv$iv$iv2 = 0;
                        int i9 = 16;
                        i3 = 0;
                        this_$iv = nodeCoordinator;
                        i4 = arr;
                        i7 = i9;
                        this_$iv2 = new MutableVector(new Modifier.Node[i9], 0);
                        node$iv$iv2 = node3;
                        this_$iv = nodeCoordinator;
                        i4 = arr;
                        next$iv$iv = node3;
                        capacity$iv$iv$iv$iv = 0;
                        this_$iv$iv$iv2 = this_$iv$iv$iv;
                    }
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    constructor-impl = type$iv;
                    nodeCoordinator = this_$iv;
                    arr = i4;
                    node3 = node$iv$iv$iv;
                    i5 = 0;
                    i6 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    this_$iv = nodeCoordinator;
                    i4 = arr;
                    next$iv$iv = node3;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    nodeCoordinator = this_$iv;
                    arr = i4;
                    this_$iv$iv$iv = 1;
                    if (count$iv$iv++ == this_$iv$iv$iv) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    this_$iv = nodeCoordinator;
                    i4 = arr;
                    capacity$iv$iv$iv$iv = 0;
                    this_$iv2 = stack$iv$iv;
                    stack$iv$iv = this_$iv2;
                    nodeCoordinator = node$iv$iv2;
                    if (nodeCoordinator != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node3;
                    stack$iv$iv.add(node3);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv2 = arr;
                    stack$iv$iv.add(nodeCoordinator);
                    this_$iv$iv$iv2 = 0;
                    i9 = 16;
                    i3 = 0;
                    this_$iv = nodeCoordinator;
                    i4 = arr;
                    i7 = i9;
                    this_$iv2 = new MutableVector(new Modifier.Node[i9], 0);
                    node$iv$iv2 = node3;
                    this_$iv = nodeCoordinator;
                    i4 = arr;
                    next$iv$iv = node3;
                    capacity$iv$iv$iv$iv = 0;
                    this_$iv$iv$iv2 = this_$iv$iv$iv;
                    count$iv$iv = this_$iv$iv$iv;
                    node = 0;
                    type$iv = constructor-impl;
                    (LayoutAwareModifierNode)node$iv$iv2.onPlaced((LayoutCoordinates)this);
                    this_$iv = nodeCoordinator;
                    i4 = arr;
                }
                type$iv = constructor-impl;
                this_$iv = nodeCoordinator;
                i4 = arr;
                if (node$iv$iv2 instanceof LayoutAwareModifierNode) {
                } else {
                }
                type$iv = constructor-impl;
                type$iv2 = node$iv$iv2;
                i14 = 0;
                node4 = type$iv2;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                count$iv$iv = 0;
                if (count$iv$iv != 0 && node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                this_$iv = nodeCoordinator;
                i4 = arr;
                node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                constructor-impl = type$iv;
                nodeCoordinator = this_$iv;
                arr = i4;
                if (node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                node4 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node3 = node$iv$iv$iv;
                    i5 = 0;
                    i6 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    this_$iv = nodeCoordinator;
                    i4 = arr;
                    next$iv$iv = node3;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    nodeCoordinator = this_$iv;
                    arr = i4;
                    this_$iv$iv$iv = 1;
                    if (count$iv$iv++ == this_$iv$iv$iv) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    this_$iv = nodeCoordinator;
                    i4 = arr;
                    capacity$iv$iv$iv$iv = 0;
                    this_$iv2 = stack$iv$iv;
                    stack$iv$iv = this_$iv2;
                    nodeCoordinator = node$iv$iv2;
                    if (nodeCoordinator != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node3;
                    stack$iv$iv.add(node3);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv2 = arr;
                    stack$iv$iv.add(nodeCoordinator);
                    this_$iv$iv$iv2 = 0;
                    i9 = 16;
                    i3 = 0;
                    this_$iv = nodeCoordinator;
                    i4 = arr;
                    i7 = i9;
                    this_$iv2 = new MutableVector(new Modifier.Node[i9], 0);
                    node$iv$iv2 = node3;
                    this_$iv = nodeCoordinator;
                    i4 = arr;
                    next$iv$iv = node3;
                    capacity$iv$iv$iv$iv = 0;
                    this_$iv$iv$iv2 = this_$iv$iv$iv;
                }
                if (count$iv$iv == 1) {
                } else {
                }
                constructor-impl = type$iv;
                nodeCoordinator = this_$iv;
                arr = i4;
                node3 = node$iv$iv$iv;
                i5 = 0;
                i6 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                this_$iv = nodeCoordinator;
                i4 = arr;
                next$iv$iv = node3;
                capacity$iv$iv$iv$iv = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                nodeCoordinator = this_$iv;
                arr = i4;
                this_$iv$iv$iv = 1;
                if (count$iv$iv++ == this_$iv$iv$iv) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                this_$iv = nodeCoordinator;
                i4 = arr;
                capacity$iv$iv$iv$iv = 0;
                this_$iv2 = stack$iv$iv;
                stack$iv$iv = this_$iv2;
                nodeCoordinator = node$iv$iv2;
                if (nodeCoordinator != null && stack$iv$iv != 0) {
                }
                if (stack$iv$iv != 0) {
                } else {
                }
                next$iv$iv = node3;
                stack$iv$iv.add(node3);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv2 = arr;
                stack$iv$iv.add(nodeCoordinator);
                this_$iv$iv$iv2 = 0;
                i9 = 16;
                i3 = 0;
                this_$iv = nodeCoordinator;
                i4 = arr;
                i7 = i9;
                this_$iv2 = new MutableVector(new Modifier.Node[i9], 0);
                node$iv$iv2 = node3;
                this_$iv = nodeCoordinator;
                i4 = arr;
                next$iv$iv = node3;
                capacity$iv$iv$iv$iv = 0;
                this_$iv$iv$iv2 = this_$iv$iv$iv;
                count$iv$iv = this_$iv$iv$iv;
                node = 0;
                type$iv = constructor-impl;
                (LayoutAwareModifierNode)node$iv$iv2.onPlaced((LayoutCoordinates)this);
                this_$iv = nodeCoordinator;
                i4 = arr;
            }
            type$iv = constructor-impl;
            this_$iv = nodeCoordinator;
            i4 = arr;
        } else {
            if (nodeCoordinator2.getTail().getParent$ui_release() == null) {
                type$iv = constructor-impl;
                this_$iv = nodeCoordinator;
                i4 = arr;
            } else {
            }
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void onRelease() {
        this.released = true;
        this.invalidateParentLayer.invoke();
        releaseLayer();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) {
        final androidx.compose.ui.node.NodeCoordinator wrapped = this.wrapped;
        if (wrapped != null) {
            wrapped.draw(canvas, graphicsLayer);
        }
    }

    protected final Placeable performingMeasure-K40F9xA(long constraints, Function0<? extends Placeable> block) {
        final int i = 0;
        NodeCoordinator.access$setMeasurementConstraints-BRTryo0(this, constraints);
        return (Placeable)obj5.invoke();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    protected void placeAt-f8xVGno(long position, float zIndex, GraphicsLayer layer) {
        Object obj;
        long position-nOcc-ac;
        Function1 function1;
        int i;
        Object obj2;
        if (this.forcePlaceWithLookaheadOffset != null) {
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            this.placeSelf-MLgxB_4(lookaheadDelegate.getPosition-nOcc-ac(), obj2, layer, 0);
        } else {
            this.placeSelf-MLgxB_4(position, obj2, layer, 0);
        }
    }

    protected void placeAt-f8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        Object obj;
        long position-nOcc-ac;
        Function1 function1;
        GraphicsLayer graphicsLayer;
        int i;
        if (this.forcePlaceWithLookaheadOffset != null) {
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            this.placeSelf-MLgxB_4(lookaheadDelegate.getPosition-nOcc-ac(), obj2, layerBlock, obj10);
        } else {
            this.placeSelf-MLgxB_4(position, obj2, layerBlock, obj10);
        }
    }

    public final void placeSelfApparentToRealOffset-MLgxB_4(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer layer) {
        this.placeSelf-MLgxB_4(IntOffset.plus-qkQi6aY(position, zIndex), obj4, layerBlock, layer);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void rectInParent$ui_release(MutableRect bounds, boolean clipBounds, boolean clipToMinimumTouchTargetSize) {
        int i2;
        long minimumTouchTargetSize-NH-jbRc;
        long l2;
        long l;
        int i;
        int i5;
        int i3;
        int i4;
        long l3;
        final androidx.compose.ui.node.OwnedLayer layer = this.layer;
        if (layer != null && this.isClipping) {
            if (this.isClipping) {
                if (clipToMinimumTouchTargetSize) {
                    minimumTouchTargetSize-NH-jbRc = getMinimumTouchTargetSize-NH-jbRc();
                    int i10 = 1073741824;
                    width-impl2 /= i10;
                    height-impl2 /= i10;
                    bounds.intersect(-l, -i5, f5 += l, f6 += i5);
                } else {
                    if (clipBounds) {
                        l = 0;
                        bounds.intersect(l, l, (float)width-impl, (float)height-impl);
                    }
                }
                if (bounds.isEmpty()) {
                }
            }
            layer.mapBounds(bounds, false);
        }
        int x-impl = IntOffset.getX-impl(getPosition-nOcc-ac());
        bounds.setLeft(left += f);
        float f2 = (float)x-impl;
        bounds.setRight(right += f2);
        int y-impl = IntOffset.getY-impl(getPosition-nOcc-ac());
        bounds.setTop(top += f3);
        bounds.setBottom(bottom += f4);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void releaseLayer() {
        Object layoutNode;
        int i3;
        int i;
        int i2;
        i3 = 0;
        if (this.layer != null && this.explicitLayer != null) {
            i3 = 0;
            if (this.explicitLayer != null) {
                this.explicitLayer = i3;
            }
            i = 0;
            NodeCoordinator.updateLayerBlock$default(this, i3, i, 2, i3);
            LayoutNode.requestRelayout$ui_release$default(getLayoutNode(), i, 1, i3);
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void replace$ui_release() {
        long position-nOcc-ac;
        float zIndex;
        Function1 layerBlock;
        final GraphicsLayer explicitLayer = this.explicitLayer;
        if (explicitLayer != null) {
            placeAt-f8xVGno(getPosition-nOcc-ac(), obj2, this.zIndex);
        } else {
            placeAt-f8xVGno(getPosition-nOcc-ac(), obj2, this.zIndex);
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public long screenToLocal-MK-Hz9U(long relativeToScreen) {
        String str;
        int i = 0;
        if (!isAttached()) {
            int i2 = 0;
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return localPositionOf-R5De75A(LayoutCoordinatesKt.findRootCoordinates((LayoutCoordinates)this), LayoutNodeKt.requireOwner(getLayoutNode()).screenToLocal-MK-Hz9U(relativeToScreen));
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void setForceMeasureWithLookaheadConstraints$ui_release(boolean <set-?>) {
        this.forceMeasureWithLookaheadConstraints = <set-?>;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void setForcePlaceWithLookaheadOffset$ui_release(boolean <set-?>) {
        this.forcePlaceWithLookaheadOffset = <set-?>;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    protected abstract void setLookaheadDelegate(androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate);

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void setMeasureResult$ui_release(MeasureResult value) {
        int oldAlignmentLines;
        Map oldAlignmentLines3;
        int oldAlignmentLines2;
        int i;
        final MeasureResult _measureResult = this._measureResult;
        if (value != _measureResult) {
            this._measureResult = value;
            if (_measureResult != null && value.getWidth() == _measureResult.getWidth()) {
                if (value.getWidth() == _measureResult.getWidth()) {
                    if (value.getHeight() != _measureResult.getHeight()) {
                        onMeasureResultChanged(value.getWidth(), value.getHeight());
                    }
                } else {
                }
            } else {
            }
            oldAlignmentLines3 = this.oldAlignmentLines;
            if (oldAlignmentLines3 != null) {
                if (oldAlignmentLines3.isEmpty()) {
                    oldAlignmentLines = 1;
                } else {
                    oldAlignmentLines = 0;
                }
            } else {
            }
            if (oldAlignmentLines != 0) {
                getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                if (!value.getAlignmentLines().isEmpty() && !Intrinsics.areEqual(value.getAlignmentLines(), this.oldAlignmentLines) && this.oldAlignmentLines == null) {
                    if (!Intrinsics.areEqual(value.getAlignmentLines(), this.oldAlignmentLines)) {
                        getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                        if (this.oldAlignmentLines == null) {
                            oldAlignmentLines = new LinkedHashMap();
                            i = 0;
                            this.oldAlignmentLines = (Map)oldAlignmentLines;
                        }
                        oldAlignmentLines.clear();
                        oldAlignmentLines.putAll(value.getAlignmentLines());
                    }
                }
            } else {
            }
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    protected void setPosition--gyyYBs(long <set-?>) {
        this.position = <set-?>;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void setWrapped$ui_release(androidx.compose.ui.node.NodeCoordinator <set-?>) {
        this.wrapped = <set-?>;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void setWrappedBy$ui_release(androidx.compose.ui.node.NodeCoordinator <set-?>) {
        this.wrappedBy = <set-?>;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    protected final void setZIndex(float <set-?>) {
        this.zIndex = <set-?>;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final boolean shouldSharePointerInputWithSiblings() {
        Modifier.Node count$iv$iv3;
        int count$iv$iv;
        int type$iv;
        Modifier.Node[] arr;
        Modifier.Node next$iv$iv;
        int node$iv$iv;
        Modifier.Node attached;
        int i10;
        int i4;
        int i11;
        Modifier.Node node;
        int i7;
        Modifier.Node node3;
        Modifier.Node next$iv$iv2;
        String str;
        int i8;
        Modifier.Node node2;
        int i;
        int i2;
        Modifier.Node node$iv$iv2;
        Modifier.Node start;
        Modifier.Node start2;
        Modifier.Node this_$iv$iv$iv2;
        int i5;
        boolean sharePointerInputWithSiblings;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node4;
        int i12;
        int type$iv2;
        int this_$iv$iv$iv;
        int count$iv$iv2;
        int i3;
        int i6;
        int i9;
        int i13 = 0;
        type$iv = 16;
        count$iv$iv3 = this.headNode(NodeKindKt.getIncludeSelfInTraversal-H91voCI(NodeKind.constructor-impl(type$iv)));
        if (count$iv$iv3 == null) {
            return 0;
        }
        if (count$iv$iv3.isAttached()) {
            int i15 = 0;
            type$iv = NodeKind.constructor-impl(type$iv);
            i10 = 0;
            i4 = 1;
            i11 = type$iv;
            node = attached;
            i7 = 0;
            int i16 = 0;
            if (!node.getNode().isAttached()) {
                int i17 = 0;
                InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
            }
            node3 = node.getNode();
            if (aggregateChildKindSet$ui_release &= i11 != 0) {
                next$iv$iv2 = node3;
                while (next$iv$iv2 != null) {
                    if (kindSet$ui_release &= i11 != 0) {
                    } else {
                    }
                    start = count$iv$iv3;
                    type$iv2 = type$iv;
                    next$iv$iv2 = next$iv$iv2.getChild$ui_release();
                    arr = this;
                    count$iv$iv3 = start;
                    type$iv = type$iv2;
                    node$iv$iv = 0;
                    i8 = 0;
                    i = 0;
                    i2 = 0;
                    int i18 = 0;
                    node$iv$iv = node$iv$iv2;
                    while (node$iv$iv != null) {
                        start = count$iv$iv3;
                        count$iv$iv = 1;
                        i5 = 0;
                        if (kindSet$ui_release2 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                        } else {
                        }
                        type$iv2 = type$iv;
                        node$iv$iv = DelegatableNodeKt.access$pop(i2);
                        arr = this;
                        count$iv$iv3 = start;
                        type$iv = type$iv2;
                        if (node$iv$iv instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv = 0;
                        sharePointerInputWithSiblings = 0;
                        node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node4 = node$iv$iv$iv;
                            i12 = 0;
                            count$iv$iv2 = 0;
                            if (kindSet$ui_release3 &= type$iv != 0) {
                            } else {
                            }
                            this_$iv$iv$iv = 0;
                            if (this_$iv$iv$iv != 0) {
                            } else {
                            }
                            type$iv2 = type$iv;
                            next$iv$iv = node4;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            arr = this;
                            type$iv = type$iv2;
                            count$iv$iv++;
                            type$iv2 = type$iv;
                            if (count$iv$iv == 1) {
                            } else {
                            }
                            if (i2 == 0) {
                            } else {
                            }
                            count$iv$iv2 = count$iv$iv;
                            type$iv = i2;
                            Modifier.Node node5 = node$iv$iv;
                            if (node5 != null && type$iv != 0) {
                            }
                            if (type$iv != 0) {
                            } else {
                            }
                            next$iv$iv = node4;
                            i2 = type$iv;
                            count$iv$iv = count$iv$iv2;
                            type$iv.add(node4);
                            if (type$iv != 0) {
                            }
                            node$iv$iv = arr;
                            type$iv.add(node5);
                            count$iv$iv2 = count$iv$iv;
                            int count$iv$iv4 = 16;
                            i3 = 0;
                            i6 = i14;
                            i9 = count$iv$iv4;
                            type$iv = new MutableVector(new Modifier.Node[count$iv$iv4], 0);
                            node$iv$iv = node4;
                            next$iv$iv = node4;
                            this_$iv$iv$iv = 1;
                        }
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        arr = this;
                        count$iv$iv3 = start;
                        type$iv = type$iv2;
                        node4 = node$iv$iv$iv;
                        i12 = 0;
                        count$iv$iv2 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        type$iv2 = type$iv;
                        next$iv$iv = node4;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        arr = this;
                        type$iv = type$iv2;
                        count$iv$iv++;
                        type$iv2 = type$iv;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (i2 == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv;
                        type$iv = i2;
                        node5 = node$iv$iv;
                        if (node5 != null && type$iv != 0) {
                        }
                        if (type$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node4;
                        i2 = type$iv;
                        count$iv$iv = count$iv$iv2;
                        type$iv.add(node4);
                        if (type$iv != 0) {
                        }
                        node$iv$iv = arr;
                        type$iv.add(node5);
                        count$iv$iv2 = count$iv$iv;
                        count$iv$iv4 = 16;
                        i3 = 0;
                        i6 = i14;
                        i9 = count$iv$iv4;
                        type$iv = new MutableVector(new Modifier.Node[count$iv$iv4], 0);
                        node$iv$iv = node4;
                        next$iv$iv = node4;
                        this_$iv$iv$iv = 1;
                        this_$iv$iv$iv2 = count$iv$iv;
                        i5 = 0;
                        type$iv2 = type$iv;
                    }
                    start = count$iv$iv3;
                    type$iv2 = type$iv;
                    start = count$iv$iv3;
                    count$iv$iv = 1;
                    i5 = 0;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    type$iv2 = type$iv;
                    node$iv$iv = DelegatableNodeKt.access$pop(i2);
                    arr = this;
                    count$iv$iv3 = start;
                    type$iv = type$iv2;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    sharePointerInputWithSiblings = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node4 = node$iv$iv$iv;
                        i12 = 0;
                        count$iv$iv2 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        type$iv2 = type$iv;
                        next$iv$iv = node4;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        arr = this;
                        type$iv = type$iv2;
                        count$iv$iv++;
                        type$iv2 = type$iv;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (i2 == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv;
                        type$iv = i2;
                        node5 = node$iv$iv;
                        if (node5 != null && type$iv != 0) {
                        }
                        if (type$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node4;
                        i2 = type$iv;
                        count$iv$iv = count$iv$iv2;
                        type$iv.add(node4);
                        if (type$iv != 0) {
                        }
                        node$iv$iv = arr;
                        type$iv.add(node5);
                        count$iv$iv2 = count$iv$iv;
                        count$iv$iv4 = 16;
                        i3 = 0;
                        i6 = i14;
                        i9 = count$iv$iv4;
                        type$iv = new MutableVector(new Modifier.Node[count$iv$iv4], 0);
                        node$iv$iv = node4;
                        next$iv$iv = node4;
                        this_$iv$iv$iv = 1;
                    }
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    arr = this;
                    count$iv$iv3 = start;
                    type$iv = type$iv2;
                    node4 = node$iv$iv$iv;
                    i12 = 0;
                    count$iv$iv2 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    type$iv2 = type$iv;
                    next$iv$iv = node4;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    arr = this;
                    type$iv = type$iv2;
                    count$iv$iv++;
                    type$iv2 = type$iv;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (i2 == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv;
                    type$iv = i2;
                    node5 = node$iv$iv;
                    if (node5 != null && type$iv != 0) {
                    }
                    if (type$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node4;
                    i2 = type$iv;
                    count$iv$iv = count$iv$iv2;
                    type$iv.add(node4);
                    if (type$iv != 0) {
                    }
                    node$iv$iv = arr;
                    type$iv.add(node5);
                    count$iv$iv2 = count$iv$iv;
                    count$iv$iv4 = 16;
                    i3 = 0;
                    i6 = i14;
                    i9 = count$iv$iv4;
                    type$iv = new MutableVector(new Modifier.Node[count$iv$iv4], 0);
                    node$iv$iv = node4;
                    next$iv$iv = node4;
                    this_$iv$iv$iv = 1;
                    this_$iv$iv$iv2 = count$iv$iv;
                    i5 = 0;
                    type$iv2 = type$iv;
                }
                start2 = count$iv$iv3;
                type$iv2 = type$iv;
            } else {
                start2 = count$iv$iv3;
                type$iv2 = type$iv;
            }
        } else {
            start2 = count$iv$iv3;
        }
        return 0;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public long toParentPosition-8S9VItk(long position, boolean includeMotionFrameOfReference) {
        long mapOffset-8S9VItk;
        long plus-Nv-tHpc;
        boolean placedUnderMotionFrameOfReference;
        final androidx.compose.ui.node.OwnedLayer layer = this.layer;
        if (layer != null) {
            mapOffset-8S9VItk = layer.mapOffset-8S9VItk(position, includeMotionFrameOfReference);
        } else {
            mapOffset-8S9VItk = position;
        }
        if (obj8 == null && isPlacedUnderMotionFrameOfReference()) {
            if (isPlacedUnderMotionFrameOfReference()) {
                plus-Nv-tHpc = mapOffset-8S9VItk;
            } else {
                plus-Nv-tHpc = IntOffsetKt.plus-Nv-tHpc(mapOffset-8S9VItk, obj2);
            }
        } else {
        }
        return plus-Nv-tHpc;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final Rect touchBoundsInRoot() {
        LayoutCoordinates coordinator;
        float wrappedBy;
        int i;
        if (!isAttached()) {
            return Rect.Companion.getZero();
        }
        final MutableRect rectCache = getRectCache();
        long minimumTouchTargetPadding-E7KxVPU = calculateMinimumTouchTargetPadding-E7KxVPU(getMinimumTouchTargetSize-NH-jbRc());
        rectCache.setLeft(-width-impl);
        rectCache.setTop(-height-impl);
        rectCache.setRight(f += width-impl2);
        rectCache.setBottom(f2 += wrappedBy);
        coordinator = this;
        while (coordinator != LayoutCoordinatesKt.findRootCoordinates((LayoutCoordinates)this)) {
            coordinator.rectInParent$ui_release(rectCache, false, true);
            wrappedBy = coordinator.wrappedBy;
            Intrinsics.checkNotNull(wrappedBy);
            coordinator = wrappedBy;
        }
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void transformFrom-EL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        final androidx.compose.ui.node.NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        final androidx.compose.ui.node.NodeCoordinator commonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        Matrix.reset-impl(matrix);
        coordinator.transformToAncestor-EL8BTi8(commonAncestor$ui_release, matrix);
        transformFromAncestor-EL8BTi8(commonAncestor$ui_release, matrix);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void transformToScreen-58bKbWc(float[] matrix) {
        transformToAncestor-EL8BTi8(toCoordinator(LayoutCoordinatesKt.findRootCoordinates((LayoutCoordinates)this)), matrix);
        LayoutNodeKt.requireOwner(getLayoutNode()).localToScreen-58bKbWc(matrix);
    }

    public final void updateLayerBlock(Function1<? super GraphicsLayerScope, Unit> layerBlock, boolean forceUpdateLayerParameters) {
        int invalidateParentLayer;
        int owner$ui_release;
        GraphicsLayer explicitLayer;
        int i3;
        int i;
        int layerLayoutDirection;
        String layoutDirection;
        androidx.compose.ui.node.OwnedLayer layer$default;
        int i6;
        int i2;
        long position-nOcc-ac;
        int i7;
        int i4;
        int i5;
        invalidateParentLayer = 0;
        owner$ui_release = 1;
        if (layerBlock != null) {
            if (this.explicitLayer == null) {
                i3 = owner$ui_release;
            } else {
                i3 = invalidateParentLayer;
            }
        } else {
        }
        layerLayoutDirection = 0;
        if (i3 == 0) {
            int i8 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("layerBlock can't be provided when explicitLayer is provided");
        }
        androidx.compose.ui.node.LayoutNode layoutNode = getLayoutNode();
        if (!forceUpdateLayerParameters && this.layerBlock == layerBlock && Intrinsics.areEqual(this.layerDensity, layoutNode.getDensity())) {
            if (this.layerBlock == layerBlock) {
                if (Intrinsics.areEqual(this.layerDensity, layoutNode.getDensity())) {
                    if (this.layerLayoutDirection != layoutNode.getLayoutDirection()) {
                        i = owner$ui_release;
                    } else {
                        i = invalidateParentLayer;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        this.layerDensity = layoutNode.getDensity();
        this.layerLayoutDirection = layoutNode.getLayoutDirection();
        final int i9 = 0;
        if (layoutNode.isAttached() && layerBlock != null) {
            if (layerBlock != null) {
                this.layerBlock = layerBlock;
                if (this.layer == null) {
                    i7 = 0;
                    layer$default = Owner.createLayer$default(LayoutNodeKt.requireOwner(layoutNode), this.drawBlock, this.invalidateParentLayer, i7, 4, 0);
                    i6 = layer$default;
                    i2 = 0;
                    i6.resize-ozmzZPI(getMeasuredSize-YbymL2g());
                    i6.move--gyyYBs(getPosition-nOcc-ac());
                    this.layer = layer$default;
                    NodeCoordinator.updateLayerParameters$default(this, invalidateParentLayer, owner$ui_release, i9);
                    layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(owner$ui_release);
                    this.invalidateParentLayer.invoke();
                } else {
                    if (i != 0) {
                        NodeCoordinator.updateLayerParameters$default(this, invalidateParentLayer, owner$ui_release, i9);
                    }
                }
            } else {
                this.layerBlock = i9;
                layer$default = this.layer;
                i6 = 0;
                layer$default.destroy();
                layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(owner$ui_release);
                this.invalidateParentLayer.invoke();
                owner$ui_release = layoutNode.getOwner$ui_release();
                if (layer$default != null && isAttached() && owner$ui_release != null) {
                    i6 = 0;
                    layer$default.destroy();
                    layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(owner$ui_release);
                    this.invalidateParentLayer.invoke();
                    if (isAttached()) {
                        owner$ui_release = layoutNode.getOwner$ui_release();
                        if (owner$ui_release != null) {
                            owner$ui_release.onLayoutChange(layoutNode);
                        }
                    }
                }
                this.layer = i9;
                this.lastLayerDrawingWasSkipped = invalidateParentLayer;
            }
        } else {
        }
    }

    public final void visitNodes(int mask, boolean includeTail, Function1<? super Modifier.Node, Unit> block) {
        Modifier.Node parent$ui_release;
        Modifier.Node node;
        int i;
        final int i2 = 0;
        if (includeTail) {
        } else {
            if (getTail().getParent$ui_release() == null) {
            }
        }
        node = NodeCoordinator.access$headNode(this, includeTail);
        while (node != null) {
            if (kindSet$ui_release &= mask != 0) {
            }
            node = node.getChild$ui_release();
            block.invoke(node);
        }
    }

    public final <T> void visitNodes-aLcG6gQ(int type, Function1<? super T, Unit> block) {
        int i10;
        boolean includeTail$iv2;
        int includeTail$iv3;
        androidx.compose.ui.node.NodeCoordinator nodeCoordinator;
        int this_$iv2;
        int i5;
        Modifier.Node parent$ui_release;
        Modifier.Node node$iv2;
        int i8;
        int i;
        Modifier.Node node2;
        int i9;
        int stack$iv;
        Modifier.Node node$iv;
        Object obj;
        int count$iv;
        Modifier.Node node;
        int i3;
        int i11;
        Modifier.Node node$iv$iv;
        int i12;
        boolean includeTail$iv;
        int this_$iv$iv;
        int i7;
        int i2;
        androidx.compose.ui.node.NodeCoordinator this_$iv;
        int i4;
        int i6;
        includeTail$iv2 = NodeKindKt.getIncludeSelfInTraversal-H91voCI(type);
        nodeCoordinator = this;
        i5 = type;
        final int i17 = 0;
        if (includeTail$iv2) {
            node$iv2 = NodeCoordinator.access$headNode(nodeCoordinator, includeTail$iv2);
            while (node$iv2 != null) {
                if (kindSet$ui_release &= i5 != 0) {
                } else {
                }
                obj = block;
                i11 = i10;
                includeTail$iv = includeTail$iv2;
                this_$iv = nodeCoordinator;
                i4 = i5;
                node$iv2 = node$iv2.getChild$ui_release();
                i10 = i11;
                includeTail$iv2 = includeTail$iv;
                nodeCoordinator = this_$iv;
                i5 = i4;
                i = 0;
                i9 = 0;
                stack$iv = 0;
                int i18 = 0;
                node$iv = node2;
                while (node$iv != null) {
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (node$iv instanceof Object != null) {
                    } else {
                    }
                    obj = block;
                    node = 0;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    count$iv = 0;
                    if (count$iv != 0 && node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    includeTail$iv = includeTail$iv2;
                    this_$iv = nodeCoordinator;
                    i4 = i5;
                    node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                    i10 = i11;
                    includeTail$iv2 = includeTail$iv;
                    nodeCoordinator = this_$iv;
                    i5 = i4;
                    if (node$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv = 0;
                    i3 = 0;
                    node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                    while (node$iv$iv != null) {
                        i10 = node$iv$iv;
                        i12 = 0;
                        i7 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv = 0;
                        if (this_$iv$iv != 0) {
                        } else {
                        }
                        includeTail$iv = includeTail$iv2;
                        this_$iv = nodeCoordinator;
                        i4 = i5;
                        includeTail$iv3 = 0;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        includeTail$iv2 = includeTail$iv;
                        nodeCoordinator = this_$iv;
                        i5 = i4;
                        includeTail$iv = includeTail$iv2;
                        if (count$iv++ == 1) {
                        } else {
                        }
                        int i14 = stack$iv;
                        if ((MutableVector)i14 == 0) {
                        } else {
                        }
                        this_$iv = nodeCoordinator;
                        i4 = i5;
                        this_$iv2 = i14;
                        includeTail$iv3 = 0;
                        stack$iv = this_$iv2;
                        nodeCoordinator = node$iv;
                        int i16 = stack$iv;
                        if ((Modifier.Node)nodeCoordinator != null && (MutableVector)i16 != 0) {
                        }
                        i5 = stack$iv;
                        if ((MutableVector)i5 != 0) {
                        }
                        (MutableVector)i5.add(i10);
                        i16 = stack$iv;
                        if ((MutableVector)(MutableVector)i16 != 0) {
                        }
                        node$iv = i5;
                        (MutableVector)(MutableVector)i16.add((Modifier.Node)nodeCoordinator);
                        i7 = i15;
                        int $i$f$mutableVectorOf = 16;
                        i2 = 0;
                        this_$iv = nodeCoordinator;
                        i4 = i5;
                        i6 = $i$f$mutableVectorOf;
                        this_$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        i5 = this_$iv2;
                        node$iv = i10;
                        this_$iv = nodeCoordinator;
                        i4 = i5;
                        includeTail$iv3 = 0;
                        this_$iv$iv = 1;
                    }
                    if (count$iv == 1) {
                    } else {
                    }
                    i10 = i11;
                    includeTail$iv2 = includeTail$iv;
                    nodeCoordinator = this_$iv;
                    i5 = i4;
                    i10 = node$iv$iv;
                    i12 = 0;
                    i7 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    includeTail$iv = includeTail$iv2;
                    this_$iv = nodeCoordinator;
                    i4 = i5;
                    includeTail$iv3 = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    includeTail$iv2 = includeTail$iv;
                    nodeCoordinator = this_$iv;
                    i5 = i4;
                    includeTail$iv = includeTail$iv2;
                    if (count$iv++ == 1) {
                    } else {
                    }
                    i14 = stack$iv;
                    if ((MutableVector)(MutableVector)i14 == 0) {
                    } else {
                    }
                    this_$iv = nodeCoordinator;
                    i4 = i5;
                    this_$iv2 = i14;
                    includeTail$iv3 = 0;
                    stack$iv = this_$iv2;
                    nodeCoordinator = node$iv;
                    i16 = stack$iv;
                    if ((Modifier.Node)nodeCoordinator != null && (MutableVector)i16 != 0) {
                    }
                    i5 = stack$iv;
                    if ((MutableVector)i5 != 0) {
                    }
                    (MutableVector)i5.add(i10);
                    i16 = stack$iv;
                    if ((MutableVector)(MutableVector)i16 != 0) {
                    }
                    node$iv = i5;
                    (MutableVector)(MutableVector)i16.add((Modifier.Node)nodeCoordinator);
                    i7 = i15;
                    $i$f$mutableVectorOf = 16;
                    i2 = 0;
                    this_$iv = nodeCoordinator;
                    i4 = i5;
                    i6 = $i$f$mutableVectorOf;
                    this_$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i5 = this_$iv2;
                    node$iv = i10;
                    this_$iv = nodeCoordinator;
                    i4 = i5;
                    includeTail$iv3 = 0;
                    this_$iv$iv = 1;
                    count$iv = 1;
                    block.invoke(node$iv);
                    i11 = i10;
                    includeTail$iv = includeTail$iv2;
                    this_$iv = nodeCoordinator;
                    i4 = i5;
                }
                obj = block;
                i11 = i10;
                includeTail$iv = includeTail$iv2;
                this_$iv = nodeCoordinator;
                i4 = i5;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (node$iv instanceof Object != null) {
                } else {
                }
                obj = block;
                node = 0;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                count$iv = 0;
                if (count$iv != 0 && node$iv instanceof DelegatingNode) {
                } else {
                }
                includeTail$iv = includeTail$iv2;
                this_$iv = nodeCoordinator;
                i4 = i5;
                node$iv = DelegatableNodeKt.access$pop((MutableVector)stack$iv);
                i10 = i11;
                includeTail$iv2 = includeTail$iv;
                nodeCoordinator = this_$iv;
                i5 = i4;
                if (node$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv = 0;
                i3 = 0;
                node$iv$iv = (DelegatingNode)node$iv.getDelegate$ui_release();
                while (node$iv$iv != null) {
                    i10 = node$iv$iv;
                    i12 = 0;
                    i7 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    includeTail$iv = includeTail$iv2;
                    this_$iv = nodeCoordinator;
                    i4 = i5;
                    includeTail$iv3 = 0;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    includeTail$iv2 = includeTail$iv;
                    nodeCoordinator = this_$iv;
                    i5 = i4;
                    includeTail$iv = includeTail$iv2;
                    if (count$iv++ == 1) {
                    } else {
                    }
                    i14 = stack$iv;
                    if ((MutableVector)(MutableVector)(MutableVector)i14 == 0) {
                    } else {
                    }
                    this_$iv = nodeCoordinator;
                    i4 = i5;
                    this_$iv2 = i14;
                    includeTail$iv3 = 0;
                    stack$iv = this_$iv2;
                    nodeCoordinator = node$iv;
                    i16 = stack$iv;
                    if ((Modifier.Node)nodeCoordinator != null && (MutableVector)i16 != 0) {
                    }
                    i5 = stack$iv;
                    if ((MutableVector)i5 != 0) {
                    }
                    (MutableVector)i5.add(i10);
                    i16 = stack$iv;
                    if ((MutableVector)(MutableVector)i16 != 0) {
                    }
                    node$iv = i5;
                    (MutableVector)(MutableVector)i16.add((Modifier.Node)nodeCoordinator);
                    i7 = i15;
                    $i$f$mutableVectorOf = 16;
                    i2 = 0;
                    this_$iv = nodeCoordinator;
                    i4 = i5;
                    i6 = $i$f$mutableVectorOf;
                    this_$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    i5 = this_$iv2;
                    node$iv = i10;
                    this_$iv = nodeCoordinator;
                    i4 = i5;
                    includeTail$iv3 = 0;
                    this_$iv$iv = 1;
                }
                if (count$iv == 1) {
                } else {
                }
                i10 = i11;
                includeTail$iv2 = includeTail$iv;
                nodeCoordinator = this_$iv;
                i5 = i4;
                i10 = node$iv$iv;
                i12 = 0;
                i7 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0) {
                } else {
                }
                includeTail$iv = includeTail$iv2;
                this_$iv = nodeCoordinator;
                i4 = i5;
                includeTail$iv3 = 0;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                includeTail$iv2 = includeTail$iv;
                nodeCoordinator = this_$iv;
                i5 = i4;
                includeTail$iv = includeTail$iv2;
                if (count$iv++ == 1) {
                } else {
                }
                i14 = stack$iv;
                if ((MutableVector)(MutableVector)(MutableVector)(MutableVector)i14 == 0) {
                } else {
                }
                this_$iv = nodeCoordinator;
                i4 = i5;
                this_$iv2 = i14;
                includeTail$iv3 = 0;
                stack$iv = this_$iv2;
                nodeCoordinator = node$iv;
                i16 = stack$iv;
                if ((Modifier.Node)nodeCoordinator != null && (MutableVector)i16 != 0) {
                }
                i5 = stack$iv;
                if ((MutableVector)i5 != 0) {
                }
                (MutableVector)i5.add(i10);
                i16 = stack$iv;
                if ((MutableVector)(MutableVector)i16 != 0) {
                }
                node$iv = i5;
                (MutableVector)(MutableVector)i16.add((Modifier.Node)nodeCoordinator);
                i7 = i15;
                $i$f$mutableVectorOf = 16;
                i2 = 0;
                this_$iv = nodeCoordinator;
                i4 = i5;
                i6 = $i$f$mutableVectorOf;
                this_$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                i5 = this_$iv2;
                node$iv = i10;
                this_$iv = nodeCoordinator;
                i4 = i5;
                includeTail$iv3 = 0;
                this_$iv$iv = 1;
                count$iv = 1;
                block.invoke(node$iv);
                i11 = i10;
                includeTail$iv = includeTail$iv2;
                this_$iv = nodeCoordinator;
                i4 = i5;
            }
            obj = block;
            i11 = i10;
            includeTail$iv = includeTail$iv2;
            this_$iv = nodeCoordinator;
            i4 = i5;
        } else {
            if (nodeCoordinator.getTail().getParent$ui_release() == null) {
                obj = block;
                i11 = i10;
            } else {
            }
        }
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public long windowToLocal-MK-Hz9U(long relativeToWindow) {
        String str;
        int i = 0;
        if (!isAttached()) {
            int i2 = 0;
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        LayoutCoordinates rootCoordinates = LayoutCoordinatesKt.findRootCoordinates((LayoutCoordinates)this);
        return localPositionOf-R5De75A(rootCoordinates, Offset.minus-MK-Hz9U(LayoutNodeKt.requireOwner(getLayoutNode()).calculateLocalPosition-MK-Hz9U(relativeToWindow), str));
    }

    protected final void withPositionTranslation(Canvas canvas, Function1<? super Canvas, Unit> block) {
        final int i = 0;
        float f = (float)x-impl;
        float f2 = (float)y-impl;
        canvas.translate(f, f2);
        block.invoke(canvas);
        canvas.translate(-f, -f2);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    protected final boolean withinLayerBounds-k-4lQ0M(long pointerPosition) {
        int i;
        boolean inLayer-k-4lQ0M;
        if (!OffsetKt.isFinite-k-4lQ0M(pointerPosition)) {
            return 0;
        }
        androidx.compose.ui.node.OwnedLayer layer = this.layer;
        if (layer != null && this.isClipping) {
            if (this.isClipping) {
                if (layer.isInLayer-k-4lQ0M(pointerPosition)) {
                    i = 1;
                }
            } else {
            }
        } else {
        }
        return i;
    }
}
