package androidx.compose.ui.node;

import android.os.Trace;
import android.view.View;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionLocalMap.Companion;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Î\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0018\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0007\n\u0002\u0008\r\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0018\u0002\n\u0002\u0008H\u0008\u0000\u0018\u0000 ñ\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0008ñ\u0002ò\u0002ó\u0002ô\u0002B\u0019\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0013\u0010ç\u0001\u001a\u00030·\u00012\u0007\u0010¨\u0001\u001a\u00020\u0019H\u0002J\u001a\u0010è\u0001\u001a\u00030·\u00012\u0008\u0010Á\u0001\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\u0008é\u0001J\u0010\u0010ê\u0001\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008ë\u0001J\n\u0010ì\u0001\u001a\u00030·\u0001H\u0002J\u0014\u0010í\u0001\u001a\u00030î\u00012\u0008\u0008\u0002\u0010K\u001a\u00020\u000bH\u0002J\u0010\u0010ï\u0001\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008ð\u0001J\u0010\u0010ñ\u0001\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008ò\u0001J&\u0010ó\u0001\u001a\u00030·\u00012\u0008\u0010ô\u0001\u001a\u00030õ\u00012\n\u0010ö\u0001\u001a\u0005\u0018\u00010÷\u0001H\u0000¢\u0006\u0003\u0008ø\u0001J\"\u0010ù\u0001\u001a\u00030·\u00012\u0015\u0010ú\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030·\u00010µ\u0001H\u0086\u0008J(\u0010û\u0001\u001a\u00030·\u00012\u001b\u0010ú\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030·\u00010ü\u0001H\u0086\u0008J)\u0010ý\u0001\u001a\u00030·\u00012\u0016\u0010ú\u0001\u001a\u0011\u0012\u0005\u0012\u00030þ\u0001\u0012\u0005\u0012\u00030·\u00010µ\u0001H\u0080\u0008¢\u0006\u0003\u0008ÿ\u0001J(\u0010\u0080\u0002\u001a\u00030·\u00012\u0015\u0010ú\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030·\u00010µ\u0001H\u0080\u0008¢\u0006\u0003\u0008\u0081\u0002J\n\u0010\u0082\u0002\u001a\u00030·\u0001H\u0016J\u0013\u0010\u0083\u0002\u001a\u000c\u0018\u00010\u0084\u0002j\u0005\u0018\u0001`\u0085\u0002H\u0017J\u0010\u0010\u0086\u0002\u001a\t\u0012\u0005\u0012\u00030\u0087\u00020(H\u0016J\t\u0010\u0088\u0002\u001a\u00020eH\u0002J@\u0010\u0089\u0002\u001a\u00030·\u00012\u0008\u0010\u008a\u0002\u001a\u00030\u008b\u00022\u0008\u0010\u008c\u0002\u001a\u00030\u008d\u00022\t\u0008\u0002\u0010\u008e\u0002\u001a\u00020\t2\t\u0008\u0002\u0010\u008f\u0002\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0006\u0008\u0090\u0002\u0010\u0091\u0002J@\u0010\u0092\u0002\u001a\u00030·\u00012\u0008\u0010\u008a\u0002\u001a\u00030\u008b\u00022\u0008\u0010\u0093\u0002\u001a\u00030\u008d\u00022\t\u0008\u0002\u0010\u008e\u0002\u001a\u00020\t2\t\u0008\u0002\u0010\u008f\u0002\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0006\u0008\u0094\u0002\u0010\u0091\u0002J!\u0010T\u001a\u00030·\u00012\u000f\u0010ú\u0001\u001a\n\u0012\u0005\u0012\u00030·\u00010\u0095\u0002H\u0080\u0008¢\u0006\u0003\u0008\u0096\u0002J\"\u0010\u0097\u0002\u001a\u00030·\u00012\u0007\u0010\u0098\u0002\u001a\u00020\u000b2\u0007\u0010\u0099\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\u0008\u009a\u0002J\n\u0010\u009b\u0002\u001a\u00030·\u0001H\u0002J\u0010\u0010\u009c\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008\u009d\u0002J\u0010\u0010\u009e\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008\u009f\u0002J\u0010\u0010 \u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008¡\u0002J\u0010\u0010¢\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008£\u0002J\u0010\u0010¤\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008¥\u0002J\u0010\u0010¦\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008§\u0002J\u0013\u0010¨\u0002\u001a\u00030·\u00012\t\u0008\u0002\u0010©\u0002\u001a\u00020\tJ\n\u0010ª\u0002\u001a\u00030·\u0001H\u0002J \u0010«\u0002\u001a\u00020\t2\u000c\u0008\u0002\u0010¬\u0002\u001a\u0005\u0018\u00010­\u0002H\u0000ø\u0001\u0000¢\u0006\u0003\u0008®\u0002J\u0010\u0010¯\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008°\u0002J\u0010\u0010±\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008²\u0002J\u0010\u0010³\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008´\u0002J\u0010\u0010µ\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008¶\u0002J\u0010\u0010·\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008¸\u0002J\u0010\u0010¹\u0002\u001a\u00020\u000b2\u0007\u0010Ý\u0001\u001a\u00020\u000bJ\u000f\u0010º\u0002\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000bJ\u0010\u0010»\u0002\u001a\u00020\u000b2\u0007\u0010Ý\u0001\u001a\u00020\u000bJ\u000f\u0010¼\u0002\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000bJ\u0010\u0010½\u0002\u001a\u00020\u000b2\u0007\u0010Ý\u0001\u001a\u00020\u000bJ\u000f\u0010¾\u0002\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000bJ\u0010\u0010¿\u0002\u001a\u00020\u000b2\u0007\u0010Ý\u0001\u001a\u00020\u000bJ\u000f\u0010À\u0002\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000bJ+\u0010Á\u0002\u001a\u00030·\u00012\u0007\u0010Â\u0002\u001a\u00020\u000b2\u0007\u0010Ã\u0002\u001a\u00020\u000b2\u0007\u0010Ä\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\u0008Å\u0002J\u0013\u0010Æ\u0002\u001a\u00030·\u00012\u0007\u0010Ç\u0002\u001a\u00020\u0000H\u0002J\n\u0010È\u0002\u001a\u00030·\u0001H\u0016J\n\u0010É\u0002\u001a\u00030·\u0001H\u0002J\n\u0010Ê\u0002\u001a\u00030·\u0001H\u0016J\n\u0010Ë\u0002\u001a\u00030·\u0001H\u0016J\n\u0010Ì\u0002\u001a\u00030·\u0001H\u0016J\u0010\u0010Í\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008Î\u0002J\"\u0010Ï\u0002\u001a\u00030·\u00012\u0007\u0010Ð\u0002\u001a\u00020\u000b2\u0007\u0010Ñ\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\u0008Ò\u0002J\n\u0010Ó\u0002\u001a\u00030·\u0001H\u0002J \u0010Ô\u0002\u001a\u00020\t2\u000c\u0008\u0002\u0010¬\u0002\u001a\u0005\u0018\u00010­\u0002H\u0000ø\u0001\u0000¢\u0006\u0003\u0008Õ\u0002J\u0010\u0010Ö\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008×\u0002J\"\u0010Ø\u0002\u001a\u00030·\u00012\u0007\u0010\u0098\u0002\u001a\u00020\u000b2\u0007\u0010Ä\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\u0008Ù\u0002J\u0010\u0010Ú\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008Û\u0002J\u001b\u0010Ü\u0002\u001a\u00030·\u00012\t\u0008\u0002\u0010Ý\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\u0008Þ\u0002J1\u0010ß\u0002\u001a\u00030·\u00012\t\u0008\u0002\u0010Ý\u0002\u001a\u00020\t2\t\u0008\u0002\u0010à\u0002\u001a\u00020\t2\t\u0008\u0002\u0010á\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\u0008â\u0002J\u001b\u0010ã\u0002\u001a\u00030·\u00012\t\u0008\u0002\u0010Ý\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\u0008ä\u0002J1\u0010å\u0002\u001a\u00030·\u00012\t\u0008\u0002\u0010Ý\u0002\u001a\u00020\t2\t\u0008\u0002\u0010à\u0002\u001a\u00020\t2\t\u0008\u0002\u0010á\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\u0008æ\u0002J\u0019\u0010ç\u0002\u001a\u00030·\u00012\u0007\u0010è\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\u0008é\u0002J\n\u0010ê\u0002\u001a\u00030·\u0001H\u0002J\u0010\u0010ë\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008ì\u0002J\t\u0010í\u0002\u001a\u00020\tH\u0002J\n\u0010î\u0002\u001a\u00030î\u0001H\u0016J\u0010\u0010ï\u0002\u001a\u00030·\u0001H\u0000¢\u0006\u0003\u0008ð\u0002R\u001a\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008 \u0010\u001eR$\u0010!\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\"\u0010#\u001a\u0004\u0008$\u0010\u001e\"\u0004\u0008%\u0010&R\u001a\u0010'\u001a\u0008\u0012\u0004\u0012\u00020)0(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008*\u0010+R\u001a\u0010,\u001a\u0008\u0012\u0004\u0012\u00020)0(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008-\u0010+R\u001a\u0010.\u001a\u0008\u0012\u0004\u0012\u00020\u00000(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008/\u0010+R\u0016\u00100\u001a\u0004\u0018\u00010\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00081\u00102R,\u00104\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b8W@WX\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u00085\u0010#\u001a\u0004\u00086\u00107\"\u0004\u00088\u00109R$\u0010<\u001a\u00020;2\u0006\u0010:\u001a\u00020;@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008=\u0010>\"\u0004\u0008?\u0010@R\u0014\u0010A\u001a\u00020B8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008C\u0010DR$\u0010F\u001a\u00020E2\u0006\u0010:\u001a\u00020E@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008G\u0010H\"\u0004\u0008I\u0010JR\u001a\u0010K\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008L\u00107\"\u0004\u0008M\u00109R\u001a\u0010N\u001a\u0008\u0012\u0004\u0012\u00020\u00000(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008O\u0010+R\u0014\u0010P\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008Q\u0010\u001eR\u0014\u0010R\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008S\u00107R\u000e\u0010T\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010U\u001a\u00020\u00178@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008V\u0010WR\u0016\u0010X\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008Y\u0010WR\u001a\u0010Z\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008[\u0010\u001e\"\u0004\u0008\\\u0010&R\"\u0010]\u001a\n\u0018\u00010^j\u0004\u0018\u0001`_X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008`\u0010a\"\u0004\u0008b\u0010cR\u0010\u0010d\u001a\u0004\u0018\u00010eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010f\u001a\u00020gX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008h\u0010i\"\u0004\u0008j\u0010kR\u0014\u0010l\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008l\u0010\u001eR\u001e\u0010m\u001a\u00020\t2\u0006\u00103\u001a\u00020\t@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008m\u0010\u001eR\u0014\u0010n\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008n\u0010\u001eR\u0011\u0010o\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008o\u0010\u001eR\u0013\u0010p\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\u0008p\u0010qR\u0014\u0010r\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008r\u0010\u001eR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010s\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008t\u0010\u001e\"\u0004\u0008u\u0010&R\u0014\u0010v\u001a\u00020wX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008x\u0010yR$\u0010{\u001a\u00020z2\u0006\u0010:\u001a\u00020z@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008|\u0010}\"\u0004\u0008~\u0010\u007fR\u0016\u0010\u0080\u0001\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\u0008\u0081\u0001\u0010\u001eR\u0018\u0010\u0082\u0001\u001a\u00030\u0083\u00018@X\u0080\u0004¢\u0006\u0008\u001a\u0006\u0008\u0084\u0001\u0010\u0085\u0001R\u0016\u0010\u0086\u0001\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\u0008\u0087\u0001\u0010\u001eR\u0016\u0010\u0088\u0001\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\u0008\u0089\u0001\u0010\u001eR\u001e\u0010\u008a\u0001\u001a\t\u0018\u00010\u008b\u0001R\u00020w8@X\u0080\u0004¢\u0006\u0008\u001a\u0006\u0008\u008c\u0001\u0010\u008d\u0001R.\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00002\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0000@BX\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\u0008\u0090\u0001\u0010\u0091\u0001\"\u0006\u0008\u0092\u0001\u0010\u0093\u0001R\u0018\u0010\u0094\u0001\u001a\u00030\u0095\u00018@X\u0080\u0004¢\u0006\u0008\u001a\u0006\u0008\u0096\u0001\u0010\u0097\u0001R\u001c\u0010\u0098\u0001\u001a\u00070\u0099\u0001R\u00020w8@X\u0080\u0004¢\u0006\u0008\u001a\u0006\u0008\u009a\u0001\u0010\u009b\u0001R\u0016\u0010\u009c\u0001\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\u0008\u009d\u0001\u0010\u001eR+\u0010\u009f\u0001\u001a\u00030\u009e\u00012\u0007\u0010:\u001a\u00030\u009e\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\u0008 \u0001\u0010¡\u0001\"\u0006\u0008¢\u0001\u0010£\u0001R\u0016\u0010¤\u0001\u001a\u00020g8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\u0008¥\u0001\u0010iR\u0016\u0010¦\u0001\u001a\u00020g8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\u0008§\u0001\u0010iR)\u0010¨\u0001\u001a\u00020\u00192\u0006\u0010:\u001a\u00020\u00198V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\u0008©\u0001\u0010ª\u0001\"\u0006\u0008«\u0001\u0010¬\u0001R\u001d\u0010­\u0001\u001a\u00020\tX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\u0008®\u0001\u0010\u001e\"\u0005\u0008¯\u0001\u0010&R\u0018\u0010°\u0001\u001a\u00030±\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\u0008²\u0001\u0010³\u0001R0\u0010´\u0001\u001a\u0013\u0012\u0005\u0012\u00030¶\u0001\u0012\u0005\u0012\u00030·\u0001\u0018\u00010µ\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\u0008¸\u0001\u0010¹\u0001\"\u0006\u0008º\u0001\u0010»\u0001R0\u0010¼\u0001\u001a\u0013\u0012\u0005\u0012\u00030¶\u0001\u0012\u0005\u0012\u00030·\u0001\u0018\u00010µ\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\u0008½\u0001\u0010¹\u0001\"\u0006\u0008¾\u0001\u0010»\u0001R\u0016\u0010¿\u0001\u001a\u00020\u00178@X\u0080\u0004¢\u0006\u0007\u001a\u0005\u0008À\u0001\u0010WR'\u0010Á\u0001\u001a\u0005\u0018\u00010¶\u00012\t\u00103\u001a\u0005\u0018\u00010¶\u0001@BX\u0080\u000e¢\u0006\n\n\u0000\u001a\u0006\u0008Â\u0001\u0010Ã\u0001R\u0019\u0010Ä\u0001\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\u0008\u001a\u0006\u0008Å\u0001\u0010\u0091\u0001R\u0019\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0008\u001a\u0006\u0008Ç\u0001\u0010È\u0001R\u0011\u0010É\u0001\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Ê\u0001\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\u0008Ë\u0001\u00107R\u000f\u0010Ì\u0001\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\u0008Í\u0001\u00107\"\u0005\u0008Î\u0001\u00109R\"\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\u0008Ñ\u0001\u0010Ò\u0001\"\u0006\u0008Ó\u0001\u0010Ô\u0001R\u000f\u0010Õ\u0001\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010×\u0001\u001a\u00030Ö\u00012\u0007\u0010:\u001a\u00030Ö\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\u0008Ø\u0001\u0010Ù\u0001\"\u0006\u0008Ú\u0001\u0010Û\u0001R\u000f\u0010Ü\u0001\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Ý\u0001\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\u0008Þ\u0001\u00107R\u0018\u0010ß\u0001\u001a\u00030à\u00018BX\u0082\u0004¢\u0006\u0008\u001a\u0006\u0008á\u0001\u0010â\u0001R#\u0010ã\u0001\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u000e8@X\u0081\u0004¢\u0006\u000e\u0012\u0005\u0008ä\u0001\u0010#\u001a\u0005\u0008å\u0001\u0010\u0010R\u000f\u0010æ\u0001\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006õ\u0002", d2 = {"Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/layout/Remeasurement;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/layout/LayoutInfo;", "Landroidx/compose/ui/node/ComposeUiNode;", "Landroidx/compose/ui/node/InteroperableComposeUiNode;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "isVirtual", "", "semanticsId", "", "(ZI)V", "_children", "Landroidx/compose/runtime/collection/MutableVector;", "get_children$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "_collapsedSemantics", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "_foldedChildren", "Landroidx/compose/ui/node/MutableVectorWithMutationTracking;", "_foldedParent", "_innerLayerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "_modifier", "Landroidx/compose/ui/Modifier;", "_unfoldedChildren", "_zSortedChildren", "alignmentLinesRequired", "getAlignmentLinesRequired$ui_release", "()Z", "applyingModifierOnAttach", "getApplyingModifierOnAttach$ui_release", "canMultiMeasure", "getCanMultiMeasure$ui_release$annotations", "()V", "getCanMultiMeasure$ui_release", "setCanMultiMeasure$ui_release", "(Z)V", "childLookaheadMeasurables", "", "Landroidx/compose/ui/layout/Measurable;", "getChildLookaheadMeasurables$ui_release", "()Ljava/util/List;", "childMeasurables", "getChildMeasurables$ui_release", "children", "getChildren$ui_release", "collapsedSemantics", "getCollapsedSemantics$ui_release", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "<set-?>", "compositeKeyHash", "getCompositeKeyHash$annotations", "getCompositeKeyHash", "()I", "setCompositeKeyHash", "(I)V", "value", "Landroidx/compose/runtime/CompositionLocalMap;", "compositionLocalMap", "getCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "setCompositionLocalMap", "(Landroidx/compose/runtime/CompositionLocalMap;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "depth", "getDepth$ui_release", "setDepth$ui_release", "foldedChildren", "getFoldedChildren$ui_release", "hasFixedInnerContentConstraints", "getHasFixedInnerContentConstraints$ui_release", "height", "getHeight", "ignoreRemeasureRequests", "innerCoordinator", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "innerLayerCoordinator", "getInnerLayerCoordinator", "innerLayerCoordinatorIsDirty", "getInnerLayerCoordinatorIsDirty$ui_release", "setInnerLayerCoordinatorIsDirty$ui_release", "interopViewFactoryHolder", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/viewinterop/InteropViewFactoryHolder;", "getInteropViewFactoryHolder$ui_release", "()Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "setInteropViewFactoryHolder$ui_release", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;)V", "intrinsicsPolicy", "Landroidx/compose/ui/node/IntrinsicsPolicy;", "intrinsicsUsageByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getIntrinsicsUsageByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setIntrinsicsUsageByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "isAttached", "isDeactivated", "isPlaced", "isPlacedByParent", "isPlacedInLookahead", "()Ljava/lang/Boolean;", "isValidOwnerScope", "isVirtualLookaheadRoot", "isVirtualLookaheadRoot$ui_release", "setVirtualLookaheadRoot$ui_release", "layoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "getLayoutDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutPending", "getLayoutPending$ui_release", "layoutState", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui_release", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui_release", "lookaheadPassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "getLookaheadPassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "newRoot", "lookaheadRoot", "getLookaheadRoot$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "setLookaheadRoot", "(Landroidx/compose/ui/node/LayoutNode;)V", "mDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getMDrawScope$ui_release", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measurePending", "getMeasurePending$ui_release", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "measuredByParent", "getMeasuredByParent$ui_release", "measuredByParentInLookahead", "getMeasuredByParentInLookahead$ui_release", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "needsOnPositionedDispatch", "getNeedsOnPositionedDispatch$ui_release", "setNeedsOnPositionedDispatch$ui_release", "nodes", "Landroidx/compose/ui/node/NodeChain;", "getNodes$ui_release", "()Landroidx/compose/ui/node/NodeChain;", "onAttach", "Lkotlin/Function1;", "Landroidx/compose/ui/node/Owner;", "", "getOnAttach$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnAttach$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onDetach", "getOnDetach$ui_release", "setOnDetach$ui_release", "outerCoordinator", "getOuterCoordinator$ui_release", "owner", "getOwner$ui_release", "()Landroidx/compose/ui/node/Owner;", "parent", "getParent$ui_release", "parentInfo", "getParentInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "pendingModifier", "placeOrder", "getPlaceOrder$ui_release", "previousIntrinsicsUsageByParent", "getSemanticsId", "setSemanticsId", "subcompositionsState", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "getSubcompositionsState$ui_release", "()Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "setSubcompositionsState$ui_release", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "unfoldedVirtualChildrenListDirty", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "setViewConfiguration", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "virtualChildrenCount", "width", "getWidth", "zIndex", "", "getZIndex", "()F", "zSortedChildren", "getZSortedChildren$annotations", "getZSortedChildren", "zSortedChildrenInvalidated", "applyModifier", "attach", "attach$ui_release", "clearSubtreeIntrinsicsUsage", "clearSubtreeIntrinsicsUsage$ui_release", "clearSubtreePlacementIntrinsicsUsage", "debugTreeToString", "", "detach", "detach$ui_release", "dispatchOnPositionedCallbacks", "dispatchOnPositionedCallbacks$ui_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "draw$ui_release", "forEachChild", "block", "forEachChildIndexed", "Lkotlin/Function2;", "forEachCoordinator", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "forEachCoordinator$ui_release", "forEachCoordinatorIncludingInner", "forEachCoordinatorIncludingInner$ui_release", "forceRemeasure", "getInteropView", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/InteropView;", "getModifierInfo", "Landroidx/compose/ui/layout/ModifierInfo;", "getOrCreateIntrinsicsPolicy", "hitTest", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "hitTest-M_7yMNQ$ui_release", "(JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestSemantics", "hitSemanticsEntities", "hitTestSemantics-M_7yMNQ$ui_release", "Lkotlin/Function0;", "ignoreRemeasureRequests$ui_release", "insertAt", "index", "instance", "insertAt$ui_release", "invalidateFocusOnAttach", "invalidateLayer", "invalidateLayer$ui_release", "invalidateLayers", "invalidateLayers$ui_release", "invalidateMeasurements", "invalidateMeasurements$ui_release", "invalidateOnPositioned", "invalidateOnPositioned$ui_release", "invalidateParentData", "invalidateParentData$ui_release", "invalidateSemantics", "invalidateSemantics$ui_release", "invalidateSubtree", "isRootOfInvalidation", "invalidateUnfoldedVirtualChildren", "lookaheadRemeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lookaheadRemeasure-_Sx5XlM$ui_release", "lookaheadReplace", "lookaheadReplace$ui_release", "markLayoutPending", "markLayoutPending$ui_release", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui_release", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "maxIntrinsicHeight", "maxIntrinsicWidth", "maxLookaheadIntrinsicHeight", "maxLookaheadIntrinsicWidth", "minIntrinsicHeight", "minIntrinsicWidth", "minLookaheadIntrinsicHeight", "minLookaheadIntrinsicWidth", "move", "from", "to", "count", "move$ui_release", "onChildRemoved", "child", "onDeactivate", "onDensityOrLayoutDirectionChanged", "onLayoutComplete", "onRelease", "onReuse", "onZSortedChildrenInvalidated", "onZSortedChildrenInvalidated$ui_release", "place", "x", "y", "place$ui_release", "recreateUnfoldedChildrenIfDirty", "remeasure", "remeasure-_Sx5XlM$ui_release", "removeAll", "removeAll$ui_release", "removeAt", "removeAt$ui_release", "replace", "replace$ui_release", "requestLookaheadRelayout", "forceRequest", "requestLookaheadRelayout$ui_release", "requestLookaheadRemeasure", "scheduleMeasureAndLayout", "invalidateIntrinsics", "requestLookaheadRemeasure$ui_release", "requestRelayout", "requestRelayout$ui_release", "requestRemeasure", "requestRemeasure$ui_release", "rescheduleRemeasureOrRelayout", "it", "rescheduleRemeasureOrRelayout$ui_release", "resetModifierState", "resetSubtreeIntrinsicsUsage", "resetSubtreeIntrinsicsUsage$ui_release", "shouldInvalidateParentLayer", "toString", "updateChildrenIfDirty", "updateChildrenIfDirty$ui_release", "Companion", "LayoutState", "NoIntrinsicsMeasurePolicy", "UsageByParent", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LayoutNode implements ComposeNodeLifecycleCallback, Remeasurement, androidx.compose.ui.node.OwnerScope, LayoutInfo, androidx.compose.ui.node.ComposeUiNode, androidx.compose.ui.node.InteroperableComposeUiNode, androidx.compose.ui.node.Owner.OnLayoutCompletedListener {

    public static final int $stable = 0;
    public static final androidx.compose.ui.node.LayoutNode.Companion Companion = null;
    private static final Function0<androidx.compose.ui.node.LayoutNode> Constructor = null;
    private static final ViewConfiguration DummyViewConfiguration = null;
    private static final androidx.compose.ui.node.LayoutNode.NoIntrinsicsMeasurePolicy ErrorMeasurePolicy = null;
    public static final int NotPlacedPlaceOrder = Integer.MAX_VALUE;
    private static final Comparator<androidx.compose.ui.node.LayoutNode> ZComparator;
    private SemanticsConfiguration _collapsedSemantics;
    private final androidx.compose.ui.node.MutableVectorWithMutationTracking<androidx.compose.ui.node.LayoutNode> _foldedChildren;
    private androidx.compose.ui.node.LayoutNode _foldedParent;
    private androidx.compose.ui.node.NodeCoordinator _innerLayerCoordinator;
    private Modifier _modifier;
    private MutableVector<androidx.compose.ui.node.LayoutNode> _unfoldedChildren;
    private final MutableVector<androidx.compose.ui.node.LayoutNode> _zSortedChildren;
    private boolean canMultiMeasure;
    private int compositeKeyHash;
    private CompositionLocalMap compositionLocalMap;
    private Density density;
    private int depth;
    private boolean ignoreRemeasureRequests;
    private boolean innerLayerCoordinatorIsDirty;
    private AndroidViewHolder interopViewFactoryHolder;
    private androidx.compose.ui.node.IntrinsicsPolicy intrinsicsPolicy;
    private androidx.compose.ui.node.LayoutNode.UsageByParent intrinsicsUsageByParent;
    private boolean isDeactivated;
    private final boolean isVirtual;
    private boolean isVirtualLookaheadRoot;
    private final androidx.compose.ui.node.LayoutNodeLayoutDelegate layoutDelegate;
    private LayoutDirection layoutDirection;
    private androidx.compose.ui.node.LayoutNode lookaheadRoot;
    private MeasurePolicy measurePolicy;
    private boolean needsOnPositionedDispatch;
    private final androidx.compose.ui.node.NodeChain nodes;
    private Function1<? super androidx.compose.ui.node.Owner, Unit> onAttach;
    private Function1<? super androidx.compose.ui.node.Owner, Unit> onDetach;
    private androidx.compose.ui.node.Owner owner;
    private Modifier pendingModifier;
    private androidx.compose.ui.node.LayoutNode.UsageByParent previousIntrinsicsUsageByParent;
    private int semanticsId;
    private LayoutNodeSubcompositionsState subcompositionsState;
    private boolean unfoldedVirtualChildrenListDirty;
    private ViewConfiguration viewConfiguration;
    private int virtualChildrenCount;
    private boolean zSortedChildrenInvalidated;

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008 \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u000cH\u0016J\"\u0010\r\u001a\u00020\u0006*\u00020\u00072\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\u000cH\u0016J\"\u0010\u000f\u001a\u00020\u0006*\u00020\u00072\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u000cH\u0016J\"\u0010\u0010\u001a\u00020\u0006*\u00020\u00072\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\u000cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "error", "", "(Ljava/lang/String;)V", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {

        public static final int $stable;
        private final String error;
        static {
        }

        public NoIntrinsicsMeasurePolicy(String error) {
            super();
            this.error = error;
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List measurables, int width) {
            return (Number)maxIntrinsicHeight($this$maxIntrinsicHeight, measurables, width).intValue();
        }

        public Void maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
            IllegalStateException illegalStateException = new IllegalStateException(this.error.toString());
            throw illegalStateException;
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List measurables, int height) {
            return (Number)maxIntrinsicWidth($this$maxIntrinsicWidth, measurables, height).intValue();
        }

        public Void maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
            IllegalStateException illegalStateException = new IllegalStateException(this.error.toString());
            throw illegalStateException;
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List measurables, int width) {
            return (Number)minIntrinsicHeight($this$minIntrinsicHeight, measurables, width).intValue();
        }

        public Void minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
            IllegalStateException illegalStateException = new IllegalStateException(this.error.toString());
            throw illegalStateException;
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List measurables, int height) {
            return (Number)minIntrinsicWidth($this$minIntrinsicWidth, measurables, height).intValue();
        }

        public Void minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
            IllegalStateException illegalStateException = new IllegalStateException(this.error.toString());
            throw illegalStateException;
        }
    }

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0014\u0010\u0008\u001a\u00020\tX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0010\u0010\u0002R\u001a\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0012X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006\u0015", d2 = {"Landroidx/compose/ui/node/LayoutNode$Companion;", "", "()V", "Constructor", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "getConstructor$ui_release", "()Lkotlin/jvm/functions/Function0;", "DummyViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getDummyViewConfiguration$ui_release", "()Landroidx/compose/ui/platform/ViewConfiguration;", "ErrorMeasurePolicy", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "NotPlacedPlaceOrder", "", "getNotPlacedPlaceOrder$ui_release$annotations", "ZComparator", "Ljava/util/Comparator;", "getZComparator$ui_release", "()Ljava/util/Comparator;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getNotPlacedPlaceOrder$ui_release$annotations() {
        }

        public final Function0<androidx.compose.ui.node.LayoutNode> getConstructor$ui_release() {
            return LayoutNode.access$getConstructor$cp();
        }

        public final ViewConfiguration getDummyViewConfiguration$ui_release() {
            return LayoutNode.access$getDummyViewConfiguration$cp();
        }

        public final Comparator<androidx.compose.ui.node.LayoutNode> getZComparator$ui_release() {
            return LayoutNode.access$getZComparator$cp();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0007\u0008\u0080\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/ui/node/LayoutNode$LayoutState;", "", "(Ljava/lang/String;I)V", "Measuring", "LookaheadMeasuring", "LayingOut", "LookaheadLayingOut", "Idle", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static enum LayoutState {

        Measuring,
        LookaheadMeasuring,
        LayingOut,
        LookaheadLayingOut,
        Idle;
        private static final androidx.compose.ui.node.LayoutNode.LayoutState[] $values() {
            return /* result */;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0080\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "", "(Ljava/lang/String;I)V", "InMeasureBlock", "InLayoutBlock", "NotUsed", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static enum UsageByParent {

        InMeasureBlock,
        InLayoutBlock,
        NotUsed;
        private static final androidx.compose.ui.node.LayoutNode.UsageByParent[] $values() {
            return /* result */;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[LayoutNode.LayoutState.Idle.ordinal()] = 1;
            LayoutNode.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static int $r8$lambda$kGNqy0QTItq0x6QPwXgEjPtPG3w(androidx.compose.ui.node.LayoutNode layoutNode, androidx.compose.ui.node.LayoutNode layoutNode2) {
        return LayoutNode.ZComparator$lambda$42(layoutNode, layoutNode2);
    }

    static {
        LayoutNode.Companion companion = new LayoutNode.Companion(0);
        LayoutNode.Companion = companion;
        LayoutNode.$stable = 8;
        LayoutNode.Companion.ErrorMeasurePolicy.1 anon = new LayoutNode.Companion.ErrorMeasurePolicy.1();
        LayoutNode.ErrorMeasurePolicy = (LayoutNode.NoIntrinsicsMeasurePolicy)anon;
        LayoutNode.Constructor = (Function0)LayoutNode.Companion.Constructor.1.INSTANCE;
        LayoutNode.Companion.DummyViewConfiguration.1 anon2 = new LayoutNode.Companion.DummyViewConfiguration.1();
        LayoutNode.DummyViewConfiguration = (ViewConfiguration)anon2;
        LayoutNode$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new LayoutNode$$ExternalSyntheticLambda0();
        LayoutNode.ZComparator = externalSyntheticLambda0;
    }

    public LayoutNode() {
        final int i3 = 0;
        super(i3, i3, 3, 0);
    }

    public LayoutNode(boolean isVirtual, int semanticsId) {
        super();
        this.isVirtual = isVirtual;
        this.semanticsId = semanticsId;
        int i3 = 0;
        int i7 = 0;
        final int i8 = 0;
        MutableVector mutableVector2 = new MutableVector(new LayoutNode[16], i8);
        LayoutNode._foldedChildren.1 $i$f$mutableVectorOf = new LayoutNode._foldedChildren.1(this);
        MutableVectorWithMutationTracking mutableVectorWithMutationTracking = new MutableVectorWithMutationTracking(mutableVector2, (Function0)$i$f$mutableVectorOf);
        this._foldedChildren = mutableVectorWithMutationTracking;
        int i = 0;
        int i6 = 0;
        MutableVector mutableVector = new MutableVector(new LayoutNode[16], i8);
        this._zSortedChildren = mutableVector;
        int i2 = 1;
        this.zSortedChildrenInvalidated = i2;
        this.measurePolicy = (MeasurePolicy)LayoutNode.ErrorMeasurePolicy;
        this.density = LayoutNodeKt.access$getDefaultDensity$p();
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = LayoutNode.DummyViewConfiguration;
        this.compositionLocalMap = CompositionLocalMap.Companion.getEmpty();
        this.intrinsicsUsageByParent = LayoutNode.UsageByParent.NotUsed;
        this.previousIntrinsicsUsageByParent = LayoutNode.UsageByParent.NotUsed;
        NodeChain nodeChain = new NodeChain(this);
        this.nodes = nodeChain;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = new LayoutNodeLayoutDelegate(this);
        this.layoutDelegate = layoutNodeLayoutDelegate;
        this.innerLayerCoordinatorIsDirty = i2;
        this._modifier = (Modifier)Modifier.Companion;
    }

    public LayoutNode(boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj1;
        int obj2;
        obj1 = i3 & 1 != 0 ? 0 : obj1;
        if (i3 &= 2 != 0) {
            obj2 = SemanticsModifierKt.generateSemanticsId();
        }
        super(obj1, obj2);
    }

    private static final int ZComparator$lambda$42(androidx.compose.ui.node.LayoutNode node1, androidx.compose.ui.node.LayoutNode node2) {
        int i;
        int compare;
        float placeOrder$ui_release;
        i = Float.compare(zIndex, zIndex3) == 0 ? 1 : 0;
        if (i != 0) {
            compare = Intrinsics.compare(node1.getPlaceOrder$ui_release(), node2.getPlaceOrder$ui_release());
        } else {
            compare = Float.compare(node1.getZIndex(), node2.getZIndex());
        }
        return compare;
    }

    public static final Function0 access$getConstructor$cp() {
        return LayoutNode.Constructor;
    }

    public static final ViewConfiguration access$getDummyViewConfiguration$cp() {
        return LayoutNode.DummyViewConfiguration;
    }

    public static final Comparator access$getZComparator$cp() {
        return LayoutNode.ZComparator;
    }

    public static final void access$setIgnoreRemeasureRequests$p(androidx.compose.ui.node.LayoutNode $this, boolean <set-?>) {
        $this.ignoreRemeasureRequests = <set-?>;
    }

    private final void applyModifier(Modifier modifier) {
        androidx.compose.ui.node.LayoutNode lookaheadRoot;
        int $i$f$getApproachMeasureOLwlOKw;
        int i;
        this._modifier = modifier;
        this.nodes.updateFrom$ui_release(modifier);
        this.layoutDelegate.updateParentData();
        int i2 = 0;
        if (this.lookaheadRoot == null && this.nodes.has-H91voCI$ui_release(NodeKind.constructor-impl(512))) {
            i2 = 0;
            if (this.nodes.has-H91voCI$ui_release(NodeKind.constructor-impl(512))) {
                setLookaheadRoot(this);
            }
        }
    }

    private final void clearSubtreePlacementIntrinsicsUsage() {
        int i$iv$iv;
        Object[] content;
        Object obj;
        int i;
        androidx.compose.ui.node.LayoutNode.UsageByParent intrinsicsUsageByParent;
        androidx.compose.ui.node.LayoutNode.UsageByParent inLayoutBlock;
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = LayoutNode.UsageByParent.NotUsed;
        final int i2 = 0;
        final MutableVector mutableVector = this.get_children$ui_release();
        final int i3 = 0;
        final int size = mutableVector.getSize();
        if (size > 0) {
            i$iv$iv = 0;
            obj = mutableVector.getContent()[i$iv$iv];
            i = 0;
            do {
                obj = content[i$iv$iv];
                i = 0;
                if (i$iv$iv++ < size) {
                }
                (LayoutNode)(LayoutNode)obj.clearSubtreePlacementIntrinsicsUsage();
            } while (obj.intrinsicsUsageByParent == LayoutNode.UsageByParent.InLayoutBlock);
        }
    }

    private final String debugTreeToString(int depth) {
        int i2;
        String treeString;
        String str;
        int substring;
        Object str2;
        int i$iv$iv;
        Object[] content;
        Object obj;
        int i;
        String debugTreeToString;
        StringBuilder stringBuilder = new StringBuilder();
        i2 = 0;
        while (i2 < depth) {
            stringBuilder.append("  ");
            i2++;
        }
        stringBuilder.append("|-");
        stringBuilder.append(toString());
        stringBuilder.append('\n');
        substring = 0;
        str2 = this.get_children$ui_release();
        final int i7 = 0;
        final int size = str2.getSize();
        if (size > 0) {
            i$iv$iv = 0;
            i = 0;
            stringBuilder.append((LayoutNode)str2.getContent()[i$iv$iv].debugTreeToString(depth + 1));
            while (i$iv$iv++ >= size) {
                i = 0;
                stringBuilder.append((LayoutNode)content[i$iv$iv].debugTreeToString(depth + 1));
            }
        }
        treeString = stringBuilder.toString();
        if (depth == 0) {
            substring = treeString.substring(0, length--);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            treeString = substring;
        }
        return treeString;
    }

    static String debugTreeToString$default(androidx.compose.ui.node.LayoutNode layoutNode, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return layoutNode.debugTreeToString(obj1);
    }

    @Deprecated(message = "Temporary API to support ConstraintLayout prototyping.")
    public static void getCanMultiMeasure$ui_release$annotations() {
    }

    public static void getCompositeKeyHash$annotations() {
    }

    private final androidx.compose.ui.node.NodeCoordinator getInnerLayerCoordinator() {
        androidx.compose.ui.node.NodeCoordinator coordinator;
        androidx.compose.ui.node.NodeCoordinator wrappedBy$ui_release2;
        int i;
        androidx.compose.ui.node.NodeCoordinator wrappedBy$ui_release;
        if (this.innerLayerCoordinatorIsDirty) {
            coordinator = getInnerCoordinator$ui_release();
            i = 0;
            this._innerLayerCoordinator = i;
            while (!Intrinsics.areEqual(coordinator, getOuterCoordinator$ui_release().getWrappedBy$ui_release())) {
                if (coordinator != null) {
                } else {
                }
                wrappedBy$ui_release = i;
                if (wrappedBy$ui_release != null) {
                    break;
                } else {
                }
                if (coordinator != null) {
                } else {
                }
                wrappedBy$ui_release = i;
                coordinator = wrappedBy$ui_release;
                wrappedBy$ui_release = coordinator.getWrappedBy$ui_release();
                wrappedBy$ui_release = coordinator.getLayer();
            }
        }
        androidx.compose.ui.node.NodeCoordinator coordinator2 = this._innerLayerCoordinator;
        if (coordinator2 != null) {
            i = 0;
            if (coordinator2.getLayer() == null) {
            } else {
            }
            int i2 = 0;
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("layer was not set");
            KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
            throw kotlinNothingValueException;
        }
        return coordinator2;
    }

    private final androidx.compose.ui.node.IntrinsicsPolicy getOrCreateIntrinsicsPolicy() {
        androidx.compose.ui.node.IntrinsicsPolicy intrinsicsPolicy2;
        androidx.compose.ui.node.IntrinsicsPolicy intrinsicsPolicy;
        int i;
        if (this.intrinsicsPolicy == null) {
            intrinsicsPolicy2 = new IntrinsicsPolicy(this, getMeasurePolicy());
            i = 0;
            this.intrinsicsPolicy = intrinsicsPolicy2;
        }
        return intrinsicsPolicy2;
    }

    private final float getZIndex() {
        return getMeasurePassDelegate$ui_release().getZIndex$ui_release();
    }

    public static void getZSortedChildren$annotations() {
    }

    public static void hitTest-M_7yMNQ$ui_release$default(androidx.compose.ui.node.LayoutNode layoutNode, long l2, androidx.compose.ui.node.HitTestResult hitTestResult3, boolean z4, boolean z5, int i6, Object object7) {
        int i;
        int i2;
        int obj10;
        int obj11;
        i = object7 & 4 != 0 ? obj10 : z5;
        i2 = object7 & 8 != 0 ? obj11 : i6;
        layoutNode.hitTest-M_7yMNQ$ui_release(l2, obj2, z4, i);
    }

    public static void hitTestSemantics-M_7yMNQ$ui_release$default(androidx.compose.ui.node.LayoutNode layoutNode, long l2, androidx.compose.ui.node.HitTestResult hitTestResult3, boolean z4, boolean z5, int i6, Object object7) {
        int obj5;
        int obj6;
        final int i = 1;
        if (object7 & 4 != 0) {
            obj5 = i;
        }
        if (object7 &= 8 != 0) {
            obj6 = i;
        }
        layoutNode.hitTestSemantics-M_7yMNQ$ui_release(l2, hitTestResult3, z4, obj5);
    }

    private final void invalidateFocusOnAttach() {
        boolean nodes;
        int $this$or_u2d64DMado$iv;
        Modifier.Node $i$f$getFocusEventOLwlOKw2;
        int i3;
        int i2;
        int i6;
        int kind$iv;
        int $i$f$getFocusEventOLwlOKw;
        int kind$iv2;
        int i7;
        int i4;
        int i5;
        int i8;
        int i;
        int i9 = 0;
        final int i10 = 1024;
        int i11 = 0;
        final int i12 = 2048;
        int i13 = 0;
        int other$iv = 0;
        int i14 = 4096;
        i3 = 0;
        if (this.nodes.has$ui_release(arg0$iv |= $i$f$getFocusEventOLwlOKw2)) {
            $this$or_u2d64DMado$iv = 0;
            $i$f$getFocusEventOLwlOKw2 = this.nodes.getHead$ui_release();
            while ($i$f$getFocusEventOLwlOKw2 != null) {
                i3 = $i$f$getFocusEventOLwlOKw2;
                i2 = 0;
                int i15 = 0;
                int i19 = 0;
                i5 = 1;
                i8 = 0;
                if (kindSet$ui_release &= $i$f$getFocusTargetOLwlOKw2 != 0) {
                } else {
                }
                kind$iv = i8;
                int this_$iv = 0;
                int i22 = 0;
                if (kindSet$ui_release2 &= $i$f$getFocusPropertiesOLwlOKw2 != 0) {
                } else {
                }
                kind$iv2 = i8;
                int i18 = 0;
                i4 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusEventOLwlOKw != 0) {
                } else {
                }
                i5 = i8;
                if (i16 |= i5 != 0) {
                }
                $i$f$getFocusEventOLwlOKw2 = $i$f$getFocusEventOLwlOKw2.getChild$ui_release();
                NodeKindKt.autoInvalidateInsertedNode(i3);
                kind$iv2 = i5;
                kind$iv = i5;
            }
        }
    }

    public static void invalidateSubtree$default(androidx.compose.ui.node.LayoutNode layoutNode, boolean z2, int i3, Object object4) {
        int obj1;
        final int obj3 = 1;
        if (i3 &= obj3 != 0) {
            obj1 = obj3;
        }
        layoutNode.invalidateSubtree(obj1);
    }

    private final void invalidateUnfoldedVirtualChildren() {
        int virtualChildrenCount;
        boolean _foldedParent;
        if (this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }
        _foldedParent = this._foldedParent;
        if (this.isVirtual && _foldedParent != null) {
            _foldedParent = this._foldedParent;
            if (_foldedParent != null) {
                _foldedParent.invalidateUnfoldedVirtualChildren();
            }
        }
    }

    public static boolean lookaheadRemeasure-_Sx5XlM$ui_release$default(androidx.compose.ui.node.LayoutNode layoutNode, Constraints constraints2, int i3, Object object4) {
        Constraints obj1;
        if (i3 &= 1 != 0) {
            obj1 = layoutNode.layoutDelegate.getLastLookaheadConstraints-DWUhwKw();
        }
        return layoutNode.lookaheadRemeasure-_Sx5XlM$ui_release(obj1);
    }

    private final void onChildRemoved(androidx.compose.ui.node.LayoutNode child) {
        int childrenAccessingCoordinatesDuringPlacement;
        int i;
        boolean _foldedChildren;
        int i2;
        MutableVector vector;
        int i3;
        int size;
        int i$iv$iv;
        Object[] content;
        Object obj;
        int i4;
        androidx.compose.ui.node.NodeCoordinator outerCoordinator$ui_release;
        if (child.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            childrenAccessingCoordinatesDuringPlacement = this.layoutDelegate;
            childrenAccessingCoordinatesDuringPlacement.setChildrenAccessingCoordinatesDuringPlacement(childrenAccessingCoordinatesDuringPlacement2--);
        }
        if (this.owner != null) {
            child.detach$ui_release();
        }
        int i5 = 0;
        child._foldedParent = i5;
        child.getOuterCoordinator$ui_release().setWrappedBy$ui_release(i5);
        this.virtualChildrenCount = virtualChildrenCount--;
        i2 = 0;
        vector = child._foldedChildren.getVector();
        i3 = 0;
        size = vector.getSize();
        if (child.isVirtual && size > 0) {
            this.virtualChildrenCount = virtualChildrenCount--;
            i2 = 0;
            vector = child._foldedChildren.getVector();
            i3 = 0;
            size = vector.getSize();
            if (size > 0) {
                i$iv$iv = 0;
                i4 = 0;
                (LayoutNode)vector.getContent()[i$iv$iv].getOuterCoordinator$ui_release().setWrappedBy$ui_release(i5);
                while (i$iv$iv++ >= size) {
                    i4 = 0;
                    (LayoutNode)content[i$iv$iv].getOuterCoordinator$ui_release().setWrappedBy$ui_release(i5);
                }
            }
        }
        invalidateUnfoldedVirtualChildren();
        onZSortedChildrenInvalidated$ui_release();
    }

    private final void onDensityOrLayoutDirectionChanged() {
        invalidateMeasurements$ui_release();
        final androidx.compose.ui.node.LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateLayers$ui_release();
    }

    private final void recreateUnfoldedChildrenIfDirty() {
        boolean this_$iv;
        int i;
        MutableVector $i$a$AlsoLayoutNode$recreateUnfoldedChildrenIfDirty$unfoldedChildren$1;
        int i2;
        MutableVector vector;
        int mutableVector;
        int size2;
        int i$iv$iv;
        Object[] content;
        Object obj;
        int i3;
        boolean isVirtual;
        MutableVector mutableVector2;
        int i4;
        int size;
        i = 0;
        this.unfoldedVirtualChildrenListDirty = i;
        if (this.unfoldedVirtualChildrenListDirty && this._unfoldedChildren == null) {
            i = 0;
            this.unfoldedVirtualChildrenListDirty = i;
            if (this._unfoldedChildren == null) {
                int i5 = 0;
                vector = 0;
                mutableVector = new MutableVector(new LayoutNode[16], i);
                int i6 = 0;
                this._unfoldedChildren = mutableVector;
                $i$a$AlsoLayoutNode$recreateUnfoldedChildrenIfDirty$unfoldedChildren$1 = mutableVector;
            }
            $i$a$AlsoLayoutNode$recreateUnfoldedChildrenIfDirty$unfoldedChildren$1.clear();
            i2 = 0;
            vector = this._foldedChildren.getVector();
            mutableVector = 0;
            size2 = vector.getSize();
            if (size2 > 0) {
                i$iv$iv = 0;
                obj = vector.getContent()[i$iv$iv];
                i3 = 0;
                do {
                    obj = content[i$iv$iv];
                    i3 = 0;
                    $i$a$AlsoLayoutNode$recreateUnfoldedChildrenIfDirty$unfoldedChildren$1.add((LayoutNode)(LayoutNode)obj);
                    if (i$iv$iv++ < size2) {
                    }
                    mutableVector2 = $i$a$AlsoLayoutNode$recreateUnfoldedChildrenIfDirty$unfoldedChildren$1;
                    i4 = 0;
                    mutableVector2.addAll(mutableVector2.getSize(), obj.get_children$ui_release());
                } while (obj.isVirtual);
            }
            this.layoutDelegate.markChildrenDirty();
        }
    }

    public static boolean remeasure-_Sx5XlM$ui_release$default(androidx.compose.ui.node.LayoutNode layoutNode, Constraints constraints2, int i3, Object object4) {
        Constraints obj1;
        if (i3 &= 1 != 0) {
            obj1 = layoutNode.layoutDelegate.getLastConstraints-DWUhwKw();
        }
        return layoutNode.remeasure-_Sx5XlM$ui_release(obj1);
    }

    public static void requestLookaheadRelayout$ui_release$default(androidx.compose.ui.node.LayoutNode layoutNode, boolean z2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        layoutNode.requestLookaheadRelayout$ui_release(obj1);
    }

    public static void requestLookaheadRemeasure$ui_release$default(androidx.compose.ui.node.LayoutNode layoutNode, boolean z2, boolean z3, boolean z4, int i5, Object object6) {
        int obj2;
        int obj3;
        int obj4;
        if (i5 & 1 != 0) {
            obj2 = 0;
        }
        final int i = 1;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        layoutNode.requestLookaheadRemeasure$ui_release(obj2, obj3, obj4);
    }

    public static void requestRelayout$ui_release$default(androidx.compose.ui.node.LayoutNode layoutNode, boolean z2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        layoutNode.requestRelayout$ui_release(obj1);
    }

    public static void requestRemeasure$ui_release$default(androidx.compose.ui.node.LayoutNode layoutNode, boolean z2, boolean z3, boolean z4, int i5, Object object6) {
        int obj2;
        int obj3;
        int obj4;
        if (i5 & 1 != 0) {
            obj2 = 0;
        }
        final int i = 1;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        layoutNode.requestRemeasure$ui_release(obj2, obj3, obj4);
    }

    private final void resetModifierState() {
        this.nodes.resetState$ui_release();
    }

    private final void setLookaheadRoot(androidx.compose.ui.node.LayoutNode newRoot) {
        boolean equal2;
        int i2;
        androidx.compose.ui.node.NodeCoordinator delegate$iv;
        androidx.compose.ui.node.NodeCoordinator wrapped$ui_release;
        boolean equal;
        int i;
        this.lookaheadRoot = newRoot;
        if (!Intrinsics.areEqual(newRoot, this.lookaheadRoot) && newRoot != null) {
            this.lookaheadRoot = newRoot;
            if (newRoot != null) {
                this.layoutDelegate.ensureLookaheadDelegateCreated$ui_release();
                equal2 = this;
                i2 = 0;
                delegate$iv = equal2.getOuterCoordinator$ui_release();
                while (!Intrinsics.areEqual(delegate$iv, equal2.getInnerCoordinator$ui_release().getWrapped$ui_release())) {
                    if (delegate$iv != null) {
                    }
                    i = 0;
                    delegate$iv.ensureLookaheadDelegateCreated();
                    delegate$iv = delegate$iv.getWrapped$ui_release();
                }
            }
            invalidateMeasurements$ui_release();
        }
    }

    private final boolean shouldInvalidateParentLayer() {
        boolean z;
        int $i$f$getLayoutOLwlOKw;
        Modifier.Node node$iv;
        Modifier.Node node2;
        int i3;
        int $i$f$getDrawOLwlOKw;
        int kind$iv;
        Modifier.Node node;
        Modifier.Node $i$f$getLayoutOLwlOKw2;
        int i4;
        int i;
        int i2;
        int i5 = 0;
        final int i7 = 4;
        int i6 = 2;
        final int i8 = 1;
        int i10 = 0;
        if (this.nodes.has-H91voCI$ui_release(NodeKind.constructor-impl(i7)) && !this.nodes.has-H91voCI$ui_release(NodeKind.constructor-impl(i6))) {
            i10 = 0;
            if (!this.nodes.has-H91voCI$ui_release(NodeKind.constructor-impl(i6))) {
                return i8;
            }
        }
        int i9 = 0;
        node$iv = this.nodes.getHead$ui_release();
        while (node$iv != null) {
            node2 = node$iv;
            i3 = 0;
            int i11 = 0;
            int i14 = 0;
            i2 = 0;
            if (kindSet$ui_release &= $i$f$getLayoutOLwlOKw3 != 0) {
            } else {
            }
            kind$iv = i2;
            int i12 = 0;
            i4 = 0;
            if (kindSet$ui_release2 &= $i$f$getDrawOLwlOKw != 0) {
            }
            node$iv = node$iv.getChild$ui_release();
            i2 = i8;
            int i13 = 0;
            kind$iv = i8;
        }
        return i8;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void attach$ui_release(androidx.compose.ui.node.Owner owner) {
        int i;
        int owner3;
        androidx.compose.ui.node.LayoutNode value$iv;
        int i6;
        int lookaheadPassDelegate$ui_release;
        int depth;
        androidx.compose.ui.node.LayoutNode _foldedParent;
        androidx.compose.ui.node.LayoutNode isVirtualLookaheadRoot;
        boolean deactivated2;
        boolean deactivated;
        String debugTreeToString$default;
        int i5;
        androidx.compose.ui.node.NodeCoordinator innerCoordinator$ui_release;
        int $i$f$getSemanticsOLwlOKw;
        androidx.compose.ui.node.NodeCoordinator delegate$iv;
        int i2;
        String $i$a$CheckPreconditionLayoutNode$attach$1;
        int i3;
        StringBuilder append;
        int size;
        String i$iv$iv;
        int owner2;
        Object[] content;
        Object obj;
        int i4;
        lookaheadPassDelegate$ui_release = 0;
        int i8 = 1;
        i = this.owner == null ? i8 : lookaheadPassDelegate$ui_release;
        int i10 = 0;
        int i14 = 0;
        if (i == 0) {
            int i15 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            InlineClassHelperKt.throwIllegalStateException(stringBuilder2.append("Cannot attach ").append(this).append(" as it already is attached.  Tree: ").append(LayoutNode.debugTreeToString$default(this, lookaheadPassDelegate$ui_release, i8, i14)).toString());
        }
        if (this._foldedParent != null) {
            androidx.compose.ui.node.LayoutNode _foldedParent2 = this._foldedParent;
            owner3 = _foldedParent2 != null ? _foldedParent2.owner : i14;
            if (Intrinsics.areEqual(owner3, owner)) {
                i6 = i8;
            } else {
                i6 = lookaheadPassDelegate$ui_release;
            }
        } else {
        }
        i5 = 0;
        if (i6 == 0) {
            $i$a$CheckPreconditionLayoutNode$attach$1 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            androidx.compose.ui.node.LayoutNode parent$ui_release2 = getParent$ui_release();
            owner2 = parent$ui_release2 != null ? parent$ui_release2.owner : i14;
            i$iv$iv = this._foldedParent;
            if (i$iv$iv != null) {
                debugTreeToString$default = LayoutNode.debugTreeToString$default(i$iv$iv, lookaheadPassDelegate$ui_release, i8, i14);
            } else {
                debugTreeToString$default = i14;
            }
            InlineClassHelperKt.throwIllegalStateException(stringBuilder.append("Attaching to a different owner(").append(owner).append(") than the parent's owner(").append(owner2).append("). This tree: ").append(LayoutNode.debugTreeToString$default(this, lookaheadPassDelegate$ui_release, i8, i14)).append(" Parent tree: ").append(debugTreeToString$default).toString());
        }
        androidx.compose.ui.node.LayoutNode parent$ui_release = getParent$ui_release();
        getMeasurePassDelegate$ui_release().setPlaced$ui_release(i8);
        lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        if (parent$ui_release == null && lookaheadPassDelegate$ui_release != null) {
            getMeasurePassDelegate$ui_release().setPlaced$ui_release(i8);
            lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
            if (lookaheadPassDelegate$ui_release != null) {
                i5 = 0;
                lookaheadPassDelegate$ui_release.setPlaced(i8);
            }
        }
        if (parent$ui_release != null) {
            innerCoordinator$ui_release = parent$ui_release.getInnerCoordinator$ui_release();
        } else {
            innerCoordinator$ui_release = i14;
        }
        getOuterCoordinator$ui_release().setWrappedBy$ui_release(innerCoordinator$ui_release);
        this.owner = owner;
        depth = parent$ui_release != null ? parent$ui_release.depth : -1;
        this.depth = depth += i8;
        Modifier pendingModifier = this.pendingModifier;
        if (pendingModifier != null) {
            innerCoordinator$ui_release = 0;
            applyModifier(pendingModifier);
        }
        this.pendingModifier = i14;
        int i11 = 0;
        if (this.nodes.has-H91voCI$ui_release(NodeKind.constructor-impl(8))) {
            invalidateSemantics$ui_release();
        }
        owner.onAttach(this);
        if (this.isVirtualLookaheadRoot) {
            setLookaheadRoot(this);
        } else {
            _foldedParent = this._foldedParent;
            if (_foldedParent != null) {
                if (_foldedParent.lookaheadRoot == null) {
                    _foldedParent = this.lookaheadRoot;
                }
            } else {
            }
            setLookaheadRoot(_foldedParent);
            int i12 = 0;
            if (this.lookaheadRoot == null && this.nodes.has-H91voCI$ui_release(NodeKind.constructor-impl(512))) {
                i12 = 0;
                if (this.nodes.has-H91voCI$ui_release(NodeKind.constructor-impl(512))) {
                    setLookaheadRoot(this);
                }
            }
        }
        if (!isDeactivated()) {
            this.nodes.markAsAttached();
        }
        int i13 = 0;
        MutableVector vector = this._foldedChildren.getVector();
        i3 = 0;
        size = vector.getSize();
        if (size > 0) {
            i$iv$iv = 0;
            i4 = 0;
            (LayoutNode)vector.getContent()[i$iv$iv].attach$ui_release(owner);
            while (i$iv$iv += i8 >= size) {
                i4 = 0;
                (LayoutNode)content[i$iv$iv].attach$ui_release(owner);
            }
        }
        if (!isDeactivated()) {
            this.nodes.runAttachLifecycle();
        }
        invalidateMeasurements$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateMeasurements$ui_release();
        }
        Object obj2 = this;
        int i9 = 0;
        delegate$iv = obj2.getOuterCoordinator$ui_release();
        while (!Intrinsics.areEqual(delegate$iv, obj2.getInnerCoordinator$ui_release().getWrapped$ui_release())) {
            if (delegate$iv != null) {
            }
            size = 0;
            delegate$iv.onLayoutNodeAttach();
            delegate$iv = delegate$iv.getWrapped$ui_release();
        }
        Function1 this_$iv = this.onAttach;
        if (this_$iv != null) {
            this_$iv.invoke(owner);
        }
        this.layoutDelegate.updateParentData();
        if (!isDeactivated()) {
            invalidateFocusOnAttach();
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void clearSubtreeIntrinsicsUsage$ui_release() {
        int i$iv$iv;
        Object[] content;
        Object obj;
        int i;
        androidx.compose.ui.node.LayoutNode.UsageByParent intrinsicsUsageByParent;
        androidx.compose.ui.node.LayoutNode.UsageByParent notUsed;
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = LayoutNode.UsageByParent.NotUsed;
        final int i2 = 0;
        final MutableVector mutableVector = this.get_children$ui_release();
        final int i3 = 0;
        final int size = mutableVector.getSize();
        if (size > 0) {
            i$iv$iv = 0;
            obj = mutableVector.getContent()[i$iv$iv];
            i = 0;
            do {
                obj = content[i$iv$iv];
                i = 0;
                if (i$iv$iv++ < size) {
                }
                (LayoutNode)(LayoutNode)obj.clearSubtreeIntrinsicsUsage$ui_release();
            } while (obj.intrinsicsUsageByParent != LayoutNode.UsageByParent.NotUsed);
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void detach$ui_release() {
        int debugTreeToString$default;
        androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release;
        androidx.compose.ui.node.LayoutNode.UsageByParent notUsed2;
        androidx.compose.ui.node.LayoutNode.UsageByParent notUsed;
        int i$iv$iv;
        Object[] content;
        Object obj;
        int i;
        final Object obj2 = this;
        final androidx.compose.ui.node.Owner owner = obj2.owner;
        int i2 = 0;
        int i3 = 1;
        final int i4 = 0;
        debugTreeToString$default = 0;
        if (owner == null) {
            int i5 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            androidx.compose.ui.node.LayoutNode parent$ui_release2 = obj2.getParent$ui_release();
            if (parent$ui_release2 == null) {
            } else {
                debugTreeToString$default = LayoutNode.debugTreeToString$default(parent$ui_release2, i4, i3, debugTreeToString$default);
            }
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(stringBuilder.append("Cannot detach node that is already detached!  Tree: ").append(debugTreeToString$default).toString());
            KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
            throw kotlinNothingValueException;
        }
        androidx.compose.ui.node.LayoutNode parent$ui_release = obj2.getParent$ui_release();
        parent$ui_release.invalidateLayer$ui_release();
        parent$ui_release.invalidateMeasurements$ui_release();
        obj2.getMeasurePassDelegate$ui_release().setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
        lookaheadPassDelegate$ui_release = obj2.getLookaheadPassDelegate$ui_release();
        if (parent$ui_release != null && lookaheadPassDelegate$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
            parent$ui_release.invalidateMeasurements$ui_release();
            obj2.getMeasurePassDelegate$ui_release().setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
            lookaheadPassDelegate$ui_release = obj2.getLookaheadPassDelegate$ui_release();
            if (lookaheadPassDelegate$ui_release != null) {
                notUsed2 = 0;
                lookaheadPassDelegate$ui_release.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
            }
        }
        obj2.layoutDelegate.resetAlignmentLines();
        Function1 onDetach = obj2.onDetach;
        if (onDetach != null) {
            onDetach.invoke(owner);
        }
        int i6 = 0;
        if (obj2.nodes.has-H91voCI$ui_release(NodeKind.constructor-impl(8))) {
            obj2.invalidateSemantics$ui_release();
        }
        obj2.nodes.runDetachLifecycle$ui_release();
        androidx.compose.ui.node.LayoutNode layoutNode = this;
        int i7 = 0;
        LayoutNode.access$setIgnoreRemeasureRequests$p(layoutNode, i3);
        int i9 = 0;
        final int i10 = 0;
        final MutableVector vector = obj2._foldedChildren.getVector();
        final int i11 = 0;
        final int size = vector.getSize();
        if (size > 0) {
            i$iv$iv = 0;
            i = 0;
            (LayoutNode)vector.getContent()[i$iv$iv].detach$ui_release();
            while (i$iv$iv += i3 >= size) {
                i = 0;
                (LayoutNode)content[i$iv$iv].detach$ui_release();
            }
        }
        LayoutNode.access$setIgnoreRemeasureRequests$p(layoutNode, i4);
        obj2.nodes.markAsDetached$ui_release();
        owner.onDetach(obj2);
        obj2.owner = debugTreeToString$default;
        obj2.setLookaheadRoot(debugTreeToString$default);
        obj2.depth = i4;
        obj2.getMeasurePassDelegate$ui_release().onNodeDetached();
        androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release2 = obj2.getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release2 != null) {
            lookaheadPassDelegate$ui_release2.onNodeDetached();
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void dispatchOnPositionedCallbacks$ui_release() {
        Object obj;
        int this_$iv$iv$iv3;
        Modifier.Node next$iv$iv;
        int capacity$iv$iv$iv$iv;
        androidx.compose.ui.node.LayoutNode.LayoutState layoutState$ui_release;
        androidx.compose.ui.node.NodeChain count$iv$iv3;
        int count$iv$iv4;
        int count$iv$iv;
        int $i$f$getGlobalPositionAwareOLwlOKw;
        Modifier.Node this_$iv$iv$iv2;
        int node$iv$iv;
        int i13;
        int i6;
        Modifier.Node node$iv$iv$iv2;
        Modifier.Node node4;
        int i3;
        Modifier.Node node2;
        int i4;
        Modifier.Node node5;
        int i8;
        int i7;
        int node$iv$iv2;
        int i9;
        androidx.compose.ui.node.NodeChain this_$iv;
        int i5;
        int i12;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node3;
        int i10;
        int this_$iv$iv$iv4;
        int i;
        int i11;
        int count$iv$iv2;
        Modifier.Node this_$iv$iv$iv;
        int i2;
        Modifier.Node node;
        if (getLayoutState$ui_release() == LayoutNode.LayoutState.Idle && !getLayoutPending$ui_release() && !getMeasurePending$ui_release()) {
            if (!getLayoutPending$ui_release()) {
                if (!getMeasurePending$ui_release()) {
                    if (isDeactivated()) {
                    } else {
                        if (!isPlaced()) {
                        }
                        count$iv$iv3 = obj.nodes;
                        int i16 = 0;
                        $i$f$getGlobalPositionAwareOLwlOKw = NodeKind.constructor-impl(256);
                        final int i17 = 0;
                        final int i18 = $i$f$getGlobalPositionAwareOLwlOKw;
                        final androidx.compose.ui.node.NodeChain nodeChain = count$iv$iv3;
                        final int i19 = 0;
                        if (i20 &= i18 != 0) {
                            i6 = 0;
                            node$iv$iv$iv2 = nodeChain.getHead$ui_release();
                            while (node$iv$iv$iv2 != null) {
                                node4 = node$iv$iv$iv2;
                                i3 = 0;
                                if (kindSet$ui_release2 &= i18 != 0) {
                                } else {
                                }
                                this_$iv = count$iv$iv3;
                                i12 = $i$f$getGlobalPositionAwareOLwlOKw;
                                node$iv$iv2 = node$iv$iv;
                                if (aggregateChildKindSet$ui_release &= i18 != 0) {
                                    break;
                                }
                                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                obj = this;
                                node$iv$iv = node$iv$iv2;
                                count$iv$iv3 = this_$iv;
                                $i$f$getGlobalPositionAwareOLwlOKw = i12;
                                i4 = 0;
                                i8 = 0;
                                i7 = 0;
                                int i21 = 0;
                                node$iv$iv = node;
                                while (node$iv$iv != null) {
                                    if (node$iv$iv instanceof GlobalPositionAwareModifierNode) {
                                    } else {
                                    }
                                    i12 = $i$f$getGlobalPositionAwareOLwlOKw;
                                    Modifier.Node node6 = node$iv$iv;
                                    int i15 = 0;
                                    i9 = node6;
                                    if (kindSet$ui_release &= i12 != 0) {
                                    } else {
                                    }
                                    count$iv$iv4 = 0;
                                    if (count$iv$iv4 != 0 && node$iv$iv instanceof DelegatingNode) {
                                    } else {
                                    }
                                    node$iv$iv = DelegatableNodeKt.access$pop(i7);
                                    obj = this;
                                    count$iv$iv3 = this_$iv;
                                    $i$f$getGlobalPositionAwareOLwlOKw = i12;
                                    if (node$iv$iv instanceof DelegatingNode) {
                                    } else {
                                    }
                                    count$iv$iv4 = 0;
                                    i9 = 0;
                                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                                    while (node$iv$iv$iv != null) {
                                        node3 = node$iv$iv$iv;
                                        i10 = 0;
                                        i = 0;
                                        if (kindSet$ui_release3 &= i12 != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv4 = 0;
                                        if (this_$iv$iv$iv4 != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv = this_$iv$iv$iv2;
                                        next$iv$iv = node3;
                                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                        this_$iv$iv$iv2 = this_$iv$iv$iv;
                                        this_$iv$iv$iv3 = 1;
                                        count$iv$iv4++;
                                        if (count$iv$iv4 == this_$iv$iv$iv3) {
                                        } else {
                                        }
                                        if (i7 == 0) {
                                        } else {
                                        }
                                        count$iv$iv2 = count$iv$iv4;
                                        this_$iv$iv$iv = this_$iv$iv$iv2;
                                        capacity$iv$iv$iv$iv = 0;
                                        count$iv$iv = i7;
                                        this_$iv$iv$iv2 = node$iv$iv;
                                        if (this_$iv$iv$iv2 != null && count$iv$iv != 0) {
                                        }
                                        if (count$iv$iv != 0) {
                                        } else {
                                        }
                                        next$iv$iv = node3;
                                        i7 = count$iv$iv;
                                        count$iv$iv4 = count$iv$iv2;
                                        count$iv$iv.add(node3);
                                        if (count$iv$iv != 0) {
                                        }
                                        node$iv$iv = 0;
                                        count$iv$iv.add(this_$iv$iv$iv2);
                                        this_$iv$iv$iv4 = 0;
                                        int i14 = 16;
                                        i11 = 0;
                                        count$iv$iv2 = count$iv$iv4;
                                        this_$iv$iv$iv = this_$iv$iv$iv2;
                                        i2 = i14;
                                        count$iv$iv = new MutableVector(new Modifier.Node[i14], 0);
                                        node$iv$iv = node3;
                                        this_$iv$iv$iv = this_$iv$iv$iv2;
                                        next$iv$iv = node3;
                                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                                    }
                                    this_$iv$iv$iv = this_$iv$iv$iv2;
                                    if (count$iv$iv4 == 1) {
                                    } else {
                                    }
                                    obj = this;
                                    count$iv$iv3 = this_$iv;
                                    $i$f$getGlobalPositionAwareOLwlOKw = i12;
                                    node3 = node$iv$iv$iv;
                                    i10 = 0;
                                    i = 0;
                                    if (kindSet$ui_release3 &= i12 != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv4 = 0;
                                    if (this_$iv$iv$iv4 != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv = this_$iv$iv$iv2;
                                    next$iv$iv = node3;
                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                    this_$iv$iv$iv2 = this_$iv$iv$iv;
                                    this_$iv$iv$iv3 = 1;
                                    count$iv$iv4++;
                                    if (count$iv$iv4 == this_$iv$iv$iv3) {
                                    } else {
                                    }
                                    if (i7 == 0) {
                                    } else {
                                    }
                                    count$iv$iv2 = count$iv$iv4;
                                    this_$iv$iv$iv = this_$iv$iv$iv2;
                                    capacity$iv$iv$iv$iv = 0;
                                    count$iv$iv = i7;
                                    this_$iv$iv$iv2 = node$iv$iv;
                                    if (this_$iv$iv$iv2 != null && count$iv$iv != 0) {
                                    }
                                    if (count$iv$iv != 0) {
                                    } else {
                                    }
                                    next$iv$iv = node3;
                                    i7 = count$iv$iv;
                                    count$iv$iv4 = count$iv$iv2;
                                    count$iv$iv.add(node3);
                                    if (count$iv$iv != 0) {
                                    }
                                    node$iv$iv = 0;
                                    count$iv$iv.add(this_$iv$iv$iv2);
                                    this_$iv$iv$iv4 = 0;
                                    i14 = 16;
                                    i11 = 0;
                                    count$iv$iv2 = count$iv$iv4;
                                    this_$iv$iv$iv = this_$iv$iv$iv2;
                                    i2 = i14;
                                    count$iv$iv = new MutableVector(new Modifier.Node[i14], 0);
                                    node$iv$iv = node3;
                                    this_$iv$iv$iv = this_$iv$iv$iv2;
                                    next$iv$iv = node3;
                                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                                    count$iv$iv4 = this_$iv$iv$iv3;
                                    this_$iv$iv$iv3 = node$iv$iv;
                                    i9 = 0;
                                    this_$iv = count$iv$iv3;
                                    i5 = 0;
                                    i12 = $i$f$getGlobalPositionAwareOLwlOKw;
                                    this_$iv$iv$iv3.onGloballyPositioned((LayoutCoordinates)DelegatableNodeKt.requireCoordinator-64DMado((DelegatableNode)(GlobalPositionAwareModifierNode)this_$iv$iv$iv3, NodeKind.constructor-impl(node$iv$iv)));
                                }
                                this_$iv = count$iv$iv3;
                                i12 = $i$f$getGlobalPositionAwareOLwlOKw;
                                if (node$iv$iv instanceof GlobalPositionAwareModifierNode) {
                                } else {
                                }
                                i12 = $i$f$getGlobalPositionAwareOLwlOKw;
                                node6 = node$iv$iv;
                                i15 = 0;
                                i9 = node6;
                                if (kindSet$ui_release &= i12 != 0) {
                                } else {
                                }
                                count$iv$iv4 = 0;
                                if (count$iv$iv4 != 0 && node$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                node$iv$iv = DelegatableNodeKt.access$pop(i7);
                                obj = this;
                                count$iv$iv3 = this_$iv;
                                $i$f$getGlobalPositionAwareOLwlOKw = i12;
                                if (node$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                count$iv$iv4 = 0;
                                i9 = 0;
                                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                                while (node$iv$iv$iv != null) {
                                    node3 = node$iv$iv$iv;
                                    i10 = 0;
                                    i = 0;
                                    if (kindSet$ui_release3 &= i12 != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv4 = 0;
                                    if (this_$iv$iv$iv4 != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv = this_$iv$iv$iv2;
                                    next$iv$iv = node3;
                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                    this_$iv$iv$iv2 = this_$iv$iv$iv;
                                    this_$iv$iv$iv3 = 1;
                                    count$iv$iv4++;
                                    if (count$iv$iv4 == this_$iv$iv$iv3) {
                                    } else {
                                    }
                                    if (i7 == 0) {
                                    } else {
                                    }
                                    count$iv$iv2 = count$iv$iv4;
                                    this_$iv$iv$iv = this_$iv$iv$iv2;
                                    capacity$iv$iv$iv$iv = 0;
                                    count$iv$iv = i7;
                                    this_$iv$iv$iv2 = node$iv$iv;
                                    if (this_$iv$iv$iv2 != null && count$iv$iv != 0) {
                                    }
                                    if (count$iv$iv != 0) {
                                    } else {
                                    }
                                    next$iv$iv = node3;
                                    i7 = count$iv$iv;
                                    count$iv$iv4 = count$iv$iv2;
                                    count$iv$iv.add(node3);
                                    if (count$iv$iv != 0) {
                                    }
                                    node$iv$iv = 0;
                                    count$iv$iv.add(this_$iv$iv$iv2);
                                    this_$iv$iv$iv4 = 0;
                                    i14 = 16;
                                    i11 = 0;
                                    count$iv$iv2 = count$iv$iv4;
                                    this_$iv$iv$iv = this_$iv$iv$iv2;
                                    i2 = i14;
                                    count$iv$iv = new MutableVector(new Modifier.Node[i14], 0);
                                    node$iv$iv = node3;
                                    this_$iv$iv$iv = this_$iv$iv$iv2;
                                    next$iv$iv = node3;
                                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                                }
                                this_$iv$iv$iv = this_$iv$iv$iv2;
                                if (count$iv$iv4 == 1) {
                                } else {
                                }
                                obj = this;
                                count$iv$iv3 = this_$iv;
                                $i$f$getGlobalPositionAwareOLwlOKw = i12;
                                node3 = node$iv$iv$iv;
                                i10 = 0;
                                i = 0;
                                if (kindSet$ui_release3 &= i12 != 0) {
                                } else {
                                }
                                this_$iv$iv$iv4 = 0;
                                if (this_$iv$iv$iv4 != 0) {
                                } else {
                                }
                                this_$iv$iv$iv = this_$iv$iv$iv2;
                                next$iv$iv = node3;
                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                this_$iv$iv$iv2 = this_$iv$iv$iv;
                                this_$iv$iv$iv3 = 1;
                                count$iv$iv4++;
                                if (count$iv$iv4 == this_$iv$iv$iv3) {
                                } else {
                                }
                                if (i7 == 0) {
                                } else {
                                }
                                count$iv$iv2 = count$iv$iv4;
                                this_$iv$iv$iv = this_$iv$iv$iv2;
                                capacity$iv$iv$iv$iv = 0;
                                count$iv$iv = i7;
                                this_$iv$iv$iv2 = node$iv$iv;
                                if (this_$iv$iv$iv2 != null && count$iv$iv != 0) {
                                }
                                if (count$iv$iv != 0) {
                                } else {
                                }
                                next$iv$iv = node3;
                                i7 = count$iv$iv;
                                count$iv$iv4 = count$iv$iv2;
                                count$iv$iv.add(node3);
                                if (count$iv$iv != 0) {
                                }
                                node$iv$iv = 0;
                                count$iv$iv.add(this_$iv$iv$iv2);
                                this_$iv$iv$iv4 = 0;
                                i14 = 16;
                                i11 = 0;
                                count$iv$iv2 = count$iv$iv4;
                                this_$iv$iv$iv = this_$iv$iv$iv2;
                                i2 = i14;
                                count$iv$iv = new MutableVector(new Modifier.Node[i14], 0);
                                node$iv$iv = node3;
                                this_$iv$iv$iv = this_$iv$iv$iv2;
                                next$iv$iv = node3;
                                this_$iv$iv$iv4 = this_$iv$iv$iv3;
                                count$iv$iv4 = this_$iv$iv$iv3;
                                this_$iv$iv$iv3 = node$iv$iv;
                                i9 = 0;
                                this_$iv = count$iv$iv3;
                                i5 = 0;
                                i12 = $i$f$getGlobalPositionAwareOLwlOKw;
                                this_$iv$iv$iv3.onGloballyPositioned((LayoutCoordinates)DelegatableNodeKt.requireCoordinator-64DMado((DelegatableNode)(GlobalPositionAwareModifierNode)this_$iv$iv$iv3, NodeKind.constructor-impl(node$iv$iv2)));
                            }
                            this_$iv = count$iv$iv3;
                            i12 = $i$f$getGlobalPositionAwareOLwlOKw;
                        } else {
                            this_$iv = count$iv$iv3;
                            i12 = $i$f$getGlobalPositionAwareOLwlOKw;
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void draw$ui_release(Canvas canvas, GraphicsLayer graphicsLayer) {
        getOuterCoordinator$ui_release().draw(canvas, graphicsLayer);
    }

    public final void forEachChild(Function1<? super androidx.compose.ui.node.LayoutNode, Unit> block) {
        int i$iv;
        Object[] content;
        Object obj;
        final int i = 0;
        final MutableVector mutableVector = get_children$ui_release();
        final int i2 = 0;
        final int size = mutableVector.getSize();
        if (size > 0) {
            i$iv = 0;
            block.invoke(mutableVector.getContent()[i$iv]);
            while (i$iv++ >= size) {
                block.invoke(content[i$iv]);
            }
        }
    }

    public final void forEachChildIndexed(Function2<? super Integer, ? super androidx.compose.ui.node.LayoutNode, Unit> block) {
        int i$iv;
        Object[] content;
        Integer valueOf;
        Object obj;
        final int i = 0;
        final MutableVector mutableVector = get_children$ui_release();
        final int i2 = 0;
        final int size = mutableVector.getSize();
        if (size > 0) {
            i$iv = 0;
            block.invoke(Integer.valueOf(i$iv), mutableVector.getContent()[i$iv]);
            while (i$iv++ >= size) {
                block.invoke(Integer.valueOf(i$iv), content[i$iv]);
            }
        }
    }

    public final void forEachCoordinator$ui_release(Function1<? super androidx.compose.ui.node.LayoutModifierNodeCoordinator, Unit> block) {
        androidx.compose.ui.node.NodeCoordinator coordinator;
        androidx.compose.ui.node.NodeCoordinator nodeCoordinator;
        final int i = 0;
        coordinator = getOuterCoordinator$ui_release();
        while (coordinator != getInnerCoordinator$ui_release()) {
            Intrinsics.checkNotNull(coordinator, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            block.invoke((LayoutModifierNodeCoordinator)coordinator);
            coordinator = (LayoutModifierNodeCoordinator)coordinator.getWrapped$ui_release();
        }
    }

    public final void forEachCoordinatorIncludingInner$ui_release(Function1<? super androidx.compose.ui.node.NodeCoordinator, Unit> block) {
        androidx.compose.ui.node.NodeCoordinator delegate;
        boolean equal;
        final int i = 0;
        delegate = getOuterCoordinator$ui_release();
        while (!Intrinsics.areEqual(delegate, getInnerCoordinator$ui_release().getWrapped$ui_release())) {
            if (delegate != null) {
            }
            block.invoke(delegate);
            delegate = delegate.getWrapped$ui_release();
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void forceRemeasure() {
        Object obj2;
        int i2;
        androidx.compose.ui.node.Owner owner;
        int unbox-impl;
        int i5;
        int i3;
        int i4;
        Object obj;
        int i6;
        int i7;
        int i8;
        int i9;
        int i;
        if (this.lookaheadRoot != null) {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(this, false, false, false, 5, 0);
        } else {
            obj = this;
            LayoutNode.requestRemeasure$ui_release$default(obj, false, false, false, 5, 0);
            obj2 = obj;
        }
        Constraints lastConstraints-DWUhwKw = obj2.layoutDelegate.getLastConstraints-DWUhwKw();
        if (lastConstraints-DWUhwKw != null) {
            owner = obj2.owner;
            if (owner != null) {
                owner.measureAndLayout-0kLqBqw(this, lastConstraints-DWUhwKw.unbox-impl());
            }
        } else {
            owner = obj2.owner;
            if (owner != null) {
                Owner.measureAndLayout$default(owner, false, 1, 0);
            }
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final boolean getAlignmentLinesRequired$ui_release() {
        boolean required$ui_release;
        androidx.compose.ui.node.AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release;
        int i;
        int i2;
        final androidx.compose.ui.node.LayoutNodeLayoutDelegate layoutDelegate = this.layoutDelegate;
        final int i3 = 0;
        i = 1;
        if (!layoutDelegate.getAlignmentLinesOwner$ui_release().getAlignmentLines().getRequired$ui_release()) {
            lookaheadAlignmentLinesOwner$ui_release = layoutDelegate.getLookaheadAlignmentLinesOwner$ui_release();
            i2 = 0;
            lookaheadAlignmentLinesOwner$ui_release = lookaheadAlignmentLinesOwner$ui_release.getAlignmentLines();
            if (lookaheadAlignmentLinesOwner$ui_release != null && lookaheadAlignmentLinesOwner$ui_release != null && lookaheadAlignmentLinesOwner$ui_release.getRequired$ui_release() == i) {
                lookaheadAlignmentLinesOwner$ui_release = lookaheadAlignmentLinesOwner$ui_release.getAlignmentLines();
                if (lookaheadAlignmentLinesOwner$ui_release != null) {
                    required$ui_release = lookaheadAlignmentLinesOwner$ui_release.getRequired$ui_release() == i ? i : i2;
                } else {
                }
            } else {
            }
            if (required$ui_release != 0) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final boolean getApplyingModifierOnAttach$ui_release() {
        int i;
        i = this.pendingModifier != null ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final boolean getCanMultiMeasure$ui_release() {
        return this.canMultiMeasure;
    }

    public final List<Measurable> getChildLookaheadMeasurables$ui_release() {
        androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        return lookaheadPassDelegate$ui_release.getChildDelegates$ui_release();
    }

    public final List<Measurable> getChildMeasurables$ui_release() {
        return getMeasurePassDelegate$ui_release().getChildDelegates$ui_release();
    }

    public final List<androidx.compose.ui.node.LayoutNode> getChildren$ui_release() {
        return get_children$ui_release().asMutableList();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final SemanticsConfiguration getCollapsedSemantics$ui_release() {
        boolean _collapsedSemantics;
        final int i = 0;
        Trace.beginSection("collapseSemantics");
        final int i2 = 0;
        int i3 = 0;
        if (this.nodes.has-H91voCI$ui_release(NodeKind.constructor-impl(8)) && this._collapsedSemantics != null) {
            if (this._collapsedSemantics != null) {
            }
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
            objectRef.element = semanticsConfiguration;
            LayoutNode.collapsedSemantics.1.1 anon = new LayoutNode.collapsedSemantics.1.1(this, objectRef);
            LayoutNodeKt.requireOwner(this).getSnapshotObserver().observeSemanticsReads$ui_release(this, (Function0)anon);
            this._collapsedSemantics = (SemanticsConfiguration)objectRef.element;
            Trace.endSection();
            return (SemanticsConfiguration)objectRef.element;
        }
        Trace.endSection();
        return this._collapsedSemantics;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public int getCompositeKeyHash() {
        return this.compositeKeyHash;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public CompositionLocalMap getCompositionLocalMap() {
        return this.compositionLocalMap;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public LayoutCoordinates getCoordinates() {
        return (LayoutCoordinates)getInnerCoordinator$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public Density getDensity() {
        return this.density;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final int getDepth$ui_release() {
        return this.depth;
    }

    public final List<androidx.compose.ui.node.LayoutNode> getFoldedChildren$ui_release() {
        return this._foldedChildren.asList();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final boolean getHasFixedInnerContentConstraints$ui_release() {
        boolean hasFixedHeight-impl;
        int i;
        long lastMeasurementConstraints-msEJaDk$ui_release = getInnerCoordinator$ui_release().getLastMeasurementConstraints-msEJaDk$ui_release();
        if (Constraints.getHasFixedWidth-impl(lastMeasurementConstraints-msEJaDk$ui_release) && Constraints.getHasFixedHeight-impl(lastMeasurementConstraints-msEJaDk$ui_release)) {
            i = Constraints.getHasFixedHeight-impl(lastMeasurementConstraints-msEJaDk$ui_release) ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public int getHeight() {
        return this.layoutDelegate.getHeight$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final androidx.compose.ui.node.NodeCoordinator getInnerCoordinator$ui_release() {
        return (NodeCoordinator)this.nodes.getInnerCoordinator$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final boolean getInnerLayerCoordinatorIsDirty$ui_release() {
        return this.innerLayerCoordinatorIsDirty;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public View getInteropView() {
        View interopView;
        AndroidViewHolder interopViewFactoryHolder = this.interopViewFactoryHolder;
        if (interopViewFactoryHolder != null) {
            interopView = interopViewFactoryHolder.getInteropView();
        } else {
            interopView = 0;
        }
        return interopView;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final AndroidViewHolder getInteropViewFactoryHolder$ui_release() {
        return this.interopViewFactoryHolder;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final androidx.compose.ui.node.LayoutNode.UsageByParent getIntrinsicsUsageByParent$ui_release() {
        return this.intrinsicsUsageByParent;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final androidx.compose.ui.node.LayoutNodeLayoutDelegate getLayoutDelegate$ui_release() {
        return this.layoutDelegate;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final boolean getLayoutPending$ui_release() {
        return this.layoutDelegate.getLayoutPending$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final androidx.compose.ui.node.LayoutNode.LayoutState getLayoutState$ui_release() {
        return this.layoutDelegate.getLayoutState$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final boolean getLookaheadLayoutPending$ui_release() {
        return this.layoutDelegate.getLookaheadLayoutPending$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final boolean getLookaheadMeasurePending$ui_release() {
        return this.layoutDelegate.getLookaheadMeasurePending$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate getLookaheadPassDelegate$ui_release() {
        return this.layoutDelegate.getLookaheadPassDelegate$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final androidx.compose.ui.node.LayoutNode getLookaheadRoot$ui_release() {
        return this.lookaheadRoot;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final androidx.compose.ui.node.LayoutNodeDrawScope getMDrawScope$ui_release() {
        return LayoutNodeKt.requireOwner(this).getSharedDrawScope();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate getMeasurePassDelegate$ui_release() {
        return this.layoutDelegate.getMeasurePassDelegate$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final boolean getMeasurePending$ui_release() {
        return this.layoutDelegate.getMeasurePending$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final androidx.compose.ui.node.LayoutNode.UsageByParent getMeasuredByParent$ui_release() {
        return getMeasurePassDelegate$ui_release().getMeasuredByParent$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final androidx.compose.ui.node.LayoutNode.UsageByParent getMeasuredByParentInLookahead$ui_release() {
        androidx.compose.ui.node.LayoutNode.UsageByParent lookaheadPassDelegate$ui_release;
        lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release != null) {
            if (lookaheadPassDelegate$ui_release.getMeasuredByParent$ui_release() == null) {
                lookaheadPassDelegate$ui_release = LayoutNode.UsageByParent.NotUsed;
            }
        } else {
        }
        return lookaheadPassDelegate$ui_release;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public Modifier getModifier() {
        return this._modifier;
    }

    public List<ModifierInfo> getModifierInfo() {
        return this.nodes.getModifierInfo();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final boolean getNeedsOnPositionedDispatch$ui_release() {
        return this.needsOnPositionedDispatch;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final androidx.compose.ui.node.NodeChain getNodes$ui_release() {
        return this.nodes;
    }

    public final Function1<androidx.compose.ui.node.Owner, Unit> getOnAttach$ui_release() {
        return this.onAttach;
    }

    public final Function1<androidx.compose.ui.node.Owner, Unit> getOnDetach$ui_release() {
        return this.onDetach;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final androidx.compose.ui.node.NodeCoordinator getOuterCoordinator$ui_release() {
        return this.nodes.getOuterCoordinator$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final androidx.compose.ui.node.Owner getOwner$ui_release() {
        return this.owner;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final androidx.compose.ui.node.LayoutNode getParent$ui_release() {
        androidx.compose.ui.node.LayoutNode parent;
        int i;
        boolean isVirtual;
        int i2;
        parent = this._foldedParent;
        i = 0;
        while (parent != null) {
            i2 = 1;
            if (parent.isVirtual == i2) {
            }
            if (i != 0) {
            }
            parent = parent._foldedParent;
            i = 0;
            i = i2;
        }
        return parent;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public LayoutInfo getParentInfo() {
        return (LayoutInfo)getParent$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final int getPlaceOrder$ui_release() {
        return getMeasurePassDelegate$ui_release().getPlaceOrder$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public int getSemanticsId() {
        return this.semanticsId;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final LayoutNodeSubcompositionsState getSubcompositionsState$ui_release() {
        return this.subcompositionsState;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public int getWidth() {
        return this.layoutDelegate.getWidth$ui_release();
    }

    public final MutableVector<androidx.compose.ui.node.LayoutNode> getZSortedChildren() {
        boolean zSortedChildrenInvalidated;
        Comparator zComparator;
        int i;
        int size;
        if (this.zSortedChildrenInvalidated) {
            this._zSortedChildren.clear();
            MutableVector _zSortedChildren3 = this._zSortedChildren;
            i = 0;
            _zSortedChildren3.addAll(_zSortedChildren3.getSize(), get_children$ui_release());
            this._zSortedChildren.sortWith(LayoutNode.ZComparator);
            this.zSortedChildrenInvalidated = false;
        }
        return this._zSortedChildren;
    }

    public final MutableVector<androidx.compose.ui.node.LayoutNode> get_children$ui_release() {
        MutableVector _unfoldedChildren;
        updateChildrenIfDirty$ui_release();
        if (this.virtualChildrenCount == 0) {
            _unfoldedChildren = this._foldedChildren.getVector();
        } else {
            Intrinsics.checkNotNull(this._unfoldedChildren);
        }
        return _unfoldedChildren;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void hitTest-M_7yMNQ$ui_release(long pointerPosition, androidx.compose.ui.node.HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        getOuterCoordinator$ui_release().hitTest-YqVAtuI(NodeCoordinator.Companion.getPointerInputSource(), NodeCoordinator.fromParentPosition-8S9VItk$default(getOuterCoordinator$ui_release(), pointerPosition, obj2, 0, 2), obj9, isTouchEvent, isInLayer);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void hitTestSemantics-M_7yMNQ$ui_release(long pointerPosition, androidx.compose.ui.node.HitTestResult hitSemanticsEntities, boolean isTouchEvent, boolean isInLayer) {
        getOuterCoordinator$ui_release().hitTest-YqVAtuI(NodeCoordinator.Companion.getSemanticsSource(), NodeCoordinator.fromParentPosition-8S9VItk$default(getOuterCoordinator$ui_release(), pointerPosition, obj2, 0, 2), obj9, isTouchEvent, true);
    }

    public final void ignoreRemeasureRequests$ui_release(Function0<Unit> block) {
        final int i = 0;
        LayoutNode.access$setIgnoreRemeasureRequests$p(this, true);
        block.invoke();
        LayoutNode.access$setIgnoreRemeasureRequests$p(this, false);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void insertAt$ui_release(int index, androidx.compose.ui.node.LayoutNode instance) {
        int i2;
        int i3;
        boolean isVirtual;
        int string;
        int childrenAccessingCoordinatesDuringPlacement;
        int i;
        Object append;
        Object append2;
        String $i$a$CheckPreconditionLayoutNode$insertAt$1;
        StringBuilder debugTreeToString$default;
        int debugTreeToString$default2;
        string = 0;
        final int i4 = 1;
        i2 = instance._foldedParent == null ? i4 : string;
        int i5 = 0;
        append = " Other tree: ";
        append2 = "Cannot insert ";
        final int i6 = 0;
        if (i2 == 0) {
            int i7 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            androidx.compose.ui.node.LayoutNode _foldedParent2 = instance._foldedParent;
            if (_foldedParent2 != null) {
                debugTreeToString$default2 = LayoutNode.debugTreeToString$default(_foldedParent2, string, i4, i6);
            } else {
                debugTreeToString$default2 = i6;
            }
            InlineClassHelperKt.throwIllegalStateException(stringBuilder.append(append2).append(instance).append(" because it already has a parent. This tree: ").append(LayoutNode.debugTreeToString$default(this, string, i4, i6)).append(append).append(debugTreeToString$default2).toString());
        }
        i3 = instance.owner == null ? i4 : string;
        i = 0;
        if (i3 == 0) {
            $i$a$CheckPreconditionLayoutNode$insertAt$1 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            InlineClassHelperKt.throwIllegalStateException(stringBuilder2.append(append2).append(instance).append(" because it already has an owner. This tree: ").append(LayoutNode.debugTreeToString$default(this, string, i4, i6)).append(append).append(LayoutNode.debugTreeToString$default(instance, string, i4, i6)).toString());
        }
        instance._foldedParent = this;
        this._foldedChildren.add(index, instance);
        onZSortedChildrenInvalidated$ui_release();
        if (instance.isVirtual) {
            this.virtualChildrenCount = virtualChildrenCount += i4;
        }
        invalidateUnfoldedVirtualChildren();
        androidx.compose.ui.node.Owner owner = this.owner;
        if (owner != null) {
            instance.attach$ui_release(owner);
        }
        if (instance.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            childrenAccessingCoordinatesDuringPlacement = this.layoutDelegate;
            childrenAccessingCoordinatesDuringPlacement.setChildrenAccessingCoordinatesDuringPlacement(childrenAccessingCoordinatesDuringPlacement2 += i4);
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void invalidateLayer$ui_release() {
        androidx.compose.ui.node.LayoutNode parent$ui_release;
        final androidx.compose.ui.node.NodeCoordinator innerLayerCoordinator = getInnerLayerCoordinator();
        if (innerLayerCoordinator != null) {
            innerLayerCoordinator.invalidateLayer();
        } else {
            parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void invalidateLayers$ui_release() {
        androidx.compose.ui.node.NodeCoordinator coordinator$iv;
        androidx.compose.ui.node.NodeCoordinator nodeCoordinator;
        int i;
        androidx.compose.ui.node.OwnedLayer layer;
        Object obj = this;
        final int i2 = 0;
        coordinator$iv = obj.getOuterCoordinator$ui_release();
        while (coordinator$iv != obj.getInnerCoordinator$ui_release()) {
            Intrinsics.checkNotNull(coordinator$iv, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            i = 0;
            layer = (LayoutModifierNodeCoordinator)coordinator$iv.getLayer();
            if (layer != null) {
            }
            coordinator$iv = (LayoutModifierNodeCoordinator)coordinator$iv.getWrapped$ui_release();
            layer.invalidate();
        }
        androidx.compose.ui.node.OwnedLayer layer2 = getInnerCoordinator$ui_release().getLayer();
        if (layer2 != null) {
            layer2.invalidate();
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void invalidateMeasurements$ui_release() {
        Object obj2;
        int i4;
        int i7;
        int i5;
        int i9;
        int i;
        Object obj;
        int i8;
        int i6;
        int i10;
        int i2;
        int i3;
        if (this.lookaheadRoot != null) {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(this, false, false, false, 7, 0);
        } else {
            LayoutNode.requestRemeasure$ui_release$default(this, false, false, false, 7, 0);
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void invalidateOnPositioned$ui_release() {
        boolean layoutPending$ui_release;
        if (!getLayoutPending$ui_release() && !getMeasurePending$ui_release() && this.needsOnPositionedDispatch) {
            if (!getMeasurePending$ui_release()) {
                if (this.needsOnPositionedDispatch) {
                }
                LayoutNodeKt.requireOwner(this).requestOnPositionedCallback(this);
            }
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void invalidateParentData$ui_release() {
        this.layoutDelegate.invalidateParentData();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void invalidateSemantics$ui_release() {
        this._collapsedSemantics = 0;
        LayoutNodeKt.requireOwner(this).onSemanticsChange();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void invalidateSubtree(boolean isRootOfInvalidation) {
        androidx.compose.ui.node.LayoutNode parent$ui_release;
        androidx.compose.ui.node.NodeChain count$iv$iv;
        androidx.compose.ui.node.OwnedLayer this_$iv$iv$iv2;
        androidx.compose.ui.node.LayoutNode $i$f$mutableVectorOf;
        int $i$f$getLayoutOLwlOKw;
        Modifier.Node type$iv2;
        int i$iv;
        int content;
        int i13;
        androidx.compose.ui.node.NodeChain nodeChain;
        int i5;
        androidx.compose.ui.node.NodeChain i14;
        Modifier.Node node2;
        Modifier.Node node5;
        int i6;
        Modifier.Node node$iv$iv$iv2;
        Modifier.Node node;
        int i7;
        int i3;
        int i10;
        Modifier.Node node3;
        int i9;
        int i11;
        int node$iv$iv;
        int node$iv$iv$iv;
        int i;
        int i4;
        androidx.compose.ui.node.NodeChain this_$iv;
        int i8;
        int this_$iv$iv$iv;
        int i2;
        int i15;
        int type$iv;
        int i12;
        Modifier.Node node4;
        parent$ui_release = getParent$ui_release();
        if (isRootOfInvalidation && parent$ui_release != null) {
            parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
        }
        invalidateSemantics$ui_release();
        $i$f$mutableVectorOf = this;
        LayoutNode.requestRemeasure$ui_release$default($i$f$mutableVectorOf, false, false, false, 7, 0);
        count$iv$iv = $i$f$mutableVectorOf.nodes;
        int i19 = 0;
        $i$f$getLayoutOLwlOKw = NodeKind.constructor-impl(2);
        content = 0;
        i13 = $i$f$getLayoutOLwlOKw;
        nodeChain = count$iv$iv;
        i5 = 0;
        if (i24 &= i13 != 0) {
            i6 = 0;
            node$iv$iv$iv2 = nodeChain.getHead$ui_release();
            while (node$iv$iv$iv2 != null) {
                node = node$iv$iv$iv2;
                i7 = 0;
                if (kindSet$ui_release2 &= i13 != 0) {
                } else {
                }
                this_$iv = count$iv$iv;
                type$iv = $i$f$getLayoutOLwlOKw;
                node$iv$iv = i$iv;
                if (aggregateChildKindSet$ui_release &= i13 != 0) {
                    break;
                }
                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                $i$f$mutableVectorOf = this;
                i$iv = node$iv$iv;
                count$iv$iv = this_$iv;
                $i$f$getLayoutOLwlOKw = type$iv;
                i10 = 0;
                i9 = 0;
                i11 = 0;
                int i25 = 0;
                i$iv = node4;
                while (i$iv != null) {
                    if (i$iv instanceof LayoutModifierNode) {
                    } else {
                    }
                    node2 = 0;
                    if (kindSet$ui_release &= $i$f$getLayoutOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0 && i$iv instanceof DelegatingNode) {
                    } else {
                    }
                    type$iv = $i$f$getLayoutOLwlOKw;
                    i$iv = DelegatableNodeKt.access$pop(i11);
                    $i$f$mutableVectorOf = this;
                    count$iv$iv = this_$iv;
                    $i$f$getLayoutOLwlOKw = type$iv;
                    if (i$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    node5 = 0;
                    node$iv$iv$iv = (DelegatingNode)i$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        i4 = node$iv$iv$iv;
                        i8 = 0;
                        i2 = 0;
                        if (kindSet$ui_release3 &= $i$f$getLayoutOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        type$iv = $i$f$getLayoutOLwlOKw;
                        type$iv2 = i4;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $i$f$mutableVectorOf = this;
                        $i$f$getLayoutOLwlOKw = type$iv;
                        this_$iv$iv$iv2++;
                        if (this_$iv$iv$iv2 == 1) {
                        } else {
                        }
                        if (i11 == 0) {
                        } else {
                        }
                        this_$iv$iv$iv = this_$iv$iv$iv2;
                        type$iv = $i$f$getLayoutOLwlOKw;
                        $i$f$mutableVectorOf = i11;
                        Modifier.Node node6 = i$iv;
                        if (node6 != null && $i$f$mutableVectorOf != 0) {
                        }
                        if ($i$f$mutableVectorOf != 0) {
                        } else {
                        }
                        type$iv2 = i4;
                        i11 = $i$f$mutableVectorOf;
                        this_$iv$iv$iv2 = this_$iv$iv$iv;
                        $i$f$mutableVectorOf.add(i4);
                        if ($i$f$mutableVectorOf != 0) {
                        }
                        i$iv = $i$f$getLayoutOLwlOKw;
                        $i$f$mutableVectorOf.add(node6);
                        this_$iv$iv$iv = this_$iv$iv$iv2;
                        int count$iv$iv2 = 16;
                        i2 = 0;
                        i15 = i17;
                        type$iv = $i$f$getLayoutOLwlOKw;
                        i12 = count$iv$iv2;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv2], 0);
                        i$iv = i4;
                        type$iv = $i$f$getLayoutOLwlOKw;
                        type$iv2 = i4;
                        this_$iv$iv$iv = 1;
                    }
                    if (this_$iv$iv$iv2 == 1) {
                    } else {
                    }
                    $i$f$mutableVectorOf = this;
                    count$iv$iv = this_$iv;
                    $i$f$getLayoutOLwlOKw = type$iv;
                    i4 = node$iv$iv$iv;
                    i8 = 0;
                    i2 = 0;
                    if (kindSet$ui_release3 &= $i$f$getLayoutOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    type$iv = $i$f$getLayoutOLwlOKw;
                    type$iv2 = i4;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $i$f$mutableVectorOf = this;
                    $i$f$getLayoutOLwlOKw = type$iv;
                    this_$iv$iv$iv2++;
                    if (this_$iv$iv$iv2 == 1) {
                    } else {
                    }
                    if (i11 == 0) {
                    } else {
                    }
                    this_$iv$iv$iv = this_$iv$iv$iv2;
                    type$iv = $i$f$getLayoutOLwlOKw;
                    $i$f$mutableVectorOf = i11;
                    node6 = i$iv;
                    if (node6 != null && $i$f$mutableVectorOf != 0) {
                    }
                    if ($i$f$mutableVectorOf != 0) {
                    } else {
                    }
                    type$iv2 = i4;
                    i11 = $i$f$mutableVectorOf;
                    this_$iv$iv$iv2 = this_$iv$iv$iv;
                    $i$f$mutableVectorOf.add(i4);
                    if ($i$f$mutableVectorOf != 0) {
                    }
                    i$iv = $i$f$getLayoutOLwlOKw;
                    $i$f$mutableVectorOf.add(node6);
                    this_$iv$iv$iv = this_$iv$iv$iv2;
                    count$iv$iv2 = 16;
                    i2 = 0;
                    i15 = i17;
                    type$iv = $i$f$getLayoutOLwlOKw;
                    i12 = count$iv$iv2;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv2], 0);
                    i$iv = i4;
                    type$iv = $i$f$getLayoutOLwlOKw;
                    type$iv2 = i4;
                    this_$iv$iv$iv = 1;
                    this_$iv$iv$iv2 = 1;
                    node$iv$iv$iv = 0;
                    i4 = 0;
                    this_$iv = count$iv$iv;
                    this_$iv$iv$iv2 = DelegatableNodeKt.requireCoordinator-64DMado((DelegatableNode)(LayoutModifierNode)i$iv, NodeKind.constructor-impl(i$iv)).getLayer();
                    if (this_$iv$iv$iv2 != null) {
                    }
                    type$iv = $i$f$getLayoutOLwlOKw;
                    this_$iv$iv$iv2.invalidate();
                }
                this_$iv = count$iv$iv;
                type$iv = $i$f$getLayoutOLwlOKw;
                if (i$iv instanceof LayoutModifierNode) {
                } else {
                }
                node2 = 0;
                if (kindSet$ui_release &= $i$f$getLayoutOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                if (this_$iv$iv$iv2 != 0 && i$iv instanceof DelegatingNode) {
                } else {
                }
                type$iv = $i$f$getLayoutOLwlOKw;
                i$iv = DelegatableNodeKt.access$pop(i11);
                $i$f$mutableVectorOf = this;
                count$iv$iv = this_$iv;
                $i$f$getLayoutOLwlOKw = type$iv;
                if (i$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                node5 = 0;
                node$iv$iv$iv = (DelegatingNode)i$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    i4 = node$iv$iv$iv;
                    i8 = 0;
                    i2 = 0;
                    if (kindSet$ui_release3 &= $i$f$getLayoutOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    type$iv = $i$f$getLayoutOLwlOKw;
                    type$iv2 = i4;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $i$f$mutableVectorOf = this;
                    $i$f$getLayoutOLwlOKw = type$iv;
                    this_$iv$iv$iv2++;
                    if (this_$iv$iv$iv2 == 1) {
                    } else {
                    }
                    if (i11 == 0) {
                    } else {
                    }
                    this_$iv$iv$iv = this_$iv$iv$iv2;
                    type$iv = $i$f$getLayoutOLwlOKw;
                    $i$f$mutableVectorOf = i11;
                    node6 = i$iv;
                    if (node6 != null && $i$f$mutableVectorOf != 0) {
                    }
                    if ($i$f$mutableVectorOf != 0) {
                    } else {
                    }
                    type$iv2 = i4;
                    i11 = $i$f$mutableVectorOf;
                    this_$iv$iv$iv2 = this_$iv$iv$iv;
                    $i$f$mutableVectorOf.add(i4);
                    if ($i$f$mutableVectorOf != 0) {
                    }
                    i$iv = $i$f$getLayoutOLwlOKw;
                    $i$f$mutableVectorOf.add(node6);
                    this_$iv$iv$iv = this_$iv$iv$iv2;
                    count$iv$iv2 = 16;
                    i2 = 0;
                    i15 = i17;
                    type$iv = $i$f$getLayoutOLwlOKw;
                    i12 = count$iv$iv2;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv2], 0);
                    i$iv = i4;
                    type$iv = $i$f$getLayoutOLwlOKw;
                    type$iv2 = i4;
                    this_$iv$iv$iv = 1;
                }
                if (this_$iv$iv$iv2 == 1) {
                } else {
                }
                $i$f$mutableVectorOf = this;
                count$iv$iv = this_$iv;
                $i$f$getLayoutOLwlOKw = type$iv;
                i4 = node$iv$iv$iv;
                i8 = 0;
                i2 = 0;
                if (kindSet$ui_release3 &= $i$f$getLayoutOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                type$iv = $i$f$getLayoutOLwlOKw;
                type$iv2 = i4;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $i$f$mutableVectorOf = this;
                $i$f$getLayoutOLwlOKw = type$iv;
                this_$iv$iv$iv2++;
                if (this_$iv$iv$iv2 == 1) {
                } else {
                }
                if (i11 == 0) {
                } else {
                }
                this_$iv$iv$iv = this_$iv$iv$iv2;
                type$iv = $i$f$getLayoutOLwlOKw;
                $i$f$mutableVectorOf = i11;
                node6 = i$iv;
                if (node6 != null && $i$f$mutableVectorOf != 0) {
                }
                if ($i$f$mutableVectorOf != 0) {
                } else {
                }
                type$iv2 = i4;
                i11 = $i$f$mutableVectorOf;
                this_$iv$iv$iv2 = this_$iv$iv$iv;
                $i$f$mutableVectorOf.add(i4);
                if ($i$f$mutableVectorOf != 0) {
                }
                i$iv = $i$f$getLayoutOLwlOKw;
                $i$f$mutableVectorOf.add(node6);
                this_$iv$iv$iv = this_$iv$iv$iv2;
                count$iv$iv2 = 16;
                i2 = 0;
                i15 = i17;
                type$iv = $i$f$getLayoutOLwlOKw;
                i12 = count$iv$iv2;
                $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv2], 0);
                i$iv = i4;
                type$iv = $i$f$getLayoutOLwlOKw;
                type$iv2 = i4;
                this_$iv$iv$iv = 1;
                this_$iv$iv$iv2 = 1;
                node$iv$iv$iv = 0;
                i4 = 0;
                this_$iv = count$iv$iv;
                this_$iv$iv$iv2 = DelegatableNodeKt.requireCoordinator-64DMado((DelegatableNode)(LayoutModifierNode)i$iv, NodeKind.constructor-impl(node$iv$iv)).getLayer();
                if (this_$iv$iv$iv2 != null) {
                }
                type$iv = $i$f$getLayoutOLwlOKw;
                this_$iv$iv$iv2.invalidate();
            }
            this_$iv = count$iv$iv;
            type$iv = $i$f$getLayoutOLwlOKw;
        } else {
            this_$iv = count$iv$iv;
            type$iv = $i$f$getLayoutOLwlOKw;
        }
        MutableVector mutableVector = get_children$ui_release();
        int i16 = 0;
        int size = mutableVector.getSize();
        if (size > 0) {
            i$iv = 0;
            nodeChain = null;
            (LayoutNode)mutableVector.getContent()[i$iv].invalidateSubtree(false);
            i = 1;
            while (i$iv++ >= size) {
                nodeChain = null;
                (LayoutNode)content[i$iv].invalidateSubtree(false);
                i = 1;
            }
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public boolean isAttached() {
        int i;
        i = this.owner != null ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public boolean isDeactivated() {
        return this.isDeactivated;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public boolean isPlaced() {
        return getMeasurePassDelegate$ui_release().isPlaced();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final boolean isPlacedByParent() {
        return getMeasurePassDelegate$ui_release().isPlacedByParent();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final Boolean isPlacedInLookahead() {
        Boolean valueOf;
        androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release != null) {
            valueOf = Boolean.valueOf(lookaheadPassDelegate$ui_release.isPlaced());
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public boolean isValidOwnerScope() {
        return isAttached();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final boolean isVirtualLookaheadRoot$ui_release() {
        return this.isVirtualLookaheadRoot;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final boolean lookaheadRemeasure-_Sx5XlM$ui_release(Constraints constraints) {
        androidx.compose.ui.node.LayoutNode lookaheadRoot;
        int remeasure-BRTryo0;
        long unbox-impl;
        if (constraints != null && this.lookaheadRoot != null) {
            if (this.lookaheadRoot != null) {
                androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                remeasure-BRTryo0 = lookaheadPassDelegate$ui_release.remeasure-BRTryo0(constraints.unbox-impl());
            } else {
                remeasure-BRTryo0 = 0;
            }
        } else {
        }
        return remeasure-BRTryo0;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void lookaheadReplace$ui_release() {
        if (this.intrinsicsUsageByParent == LayoutNode.UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        lookaheadPassDelegate$ui_release.replace();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void markLayoutPending$ui_release() {
        this.layoutDelegate.markLayoutPending$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void markLookaheadLayoutPending$ui_release() {
        this.layoutDelegate.markLookaheadLayoutPending$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void markLookaheadMeasurePending$ui_release() {
        this.layoutDelegate.markLookaheadMeasurePending$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void markMeasurePending$ui_release() {
        this.layoutDelegate.markMeasurePending$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final int maxIntrinsicHeight(int width) {
        return getOrCreateIntrinsicsPolicy().maxIntrinsicHeight(width);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final int maxIntrinsicWidth(int height) {
        return getOrCreateIntrinsicsPolicy().maxIntrinsicWidth(height);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final int maxLookaheadIntrinsicHeight(int width) {
        return getOrCreateIntrinsicsPolicy().maxLookaheadIntrinsicHeight(width);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final int maxLookaheadIntrinsicWidth(int height) {
        return getOrCreateIntrinsicsPolicy().maxLookaheadIntrinsicWidth(height);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final int minIntrinsicHeight(int width) {
        return getOrCreateIntrinsicsPolicy().minIntrinsicHeight(width);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final int minIntrinsicWidth(int height) {
        return getOrCreateIntrinsicsPolicy().minIntrinsicWidth(height);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final int minLookaheadIntrinsicHeight(int width) {
        return getOrCreateIntrinsicsPolicy().minLookaheadIntrinsicHeight(width);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final int minLookaheadIntrinsicWidth(int height) {
        return getOrCreateIntrinsicsPolicy().minLookaheadIntrinsicWidth(height);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void move$ui_release(int from, int to, int count) {
        int i2;
        int i;
        int i3;
        Object obj;
        androidx.compose.ui.node.MutableVectorWithMutationTracking _foldedChildren;
        if (from == to) {
        }
        i2 = 0;
        while (i2 < count) {
            if (from > to) {
            } else {
            }
            i = from;
            if (from > to) {
            } else {
            }
            i4 += -2;
            this._foldedChildren.add(i3, (LayoutNode)this._foldedChildren.removeAt(i));
            i2++;
            i3 = to + i2;
            i = from + i2;
        }
        onZSortedChildrenInvalidated$ui_release();
        invalidateUnfoldedVirtualChildren();
        invalidateMeasurements$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onDeactivate() {
        AndroidViewHolder interopViewFactoryHolder = this.interopViewFactoryHolder;
        if (interopViewFactoryHolder != null) {
            interopViewFactoryHolder.onDeactivate();
        }
        LayoutNodeSubcompositionsState subcompositionsState = this.subcompositionsState;
        if (subcompositionsState != null) {
            subcompositionsState.onDeactivate();
        }
        this.isDeactivated = true;
        resetModifierState();
        if (isAttached()) {
            invalidateSemantics$ui_release();
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onLayoutComplete() {
        androidx.compose.ui.node.NodeCoordinator innerCoordinator$ui_release2;
        int this_$iv$iv$iv;
        int capacity$iv$iv$iv$iv;
        int $i$f$getLayoutAwareOLwlOKw;
        int type$iv2;
        int $i$f$visitNodesALcG6gQ;
        Modifier.Node next$iv$iv;
        Modifier.Node parent$ui_release;
        Modifier.Node node$iv$iv;
        Modifier.Node node;
        int i;
        Modifier.Node node3;
        int i2;
        int stack$iv$iv;
        Modifier.Node node$iv$iv2;
        int count$iv$iv;
        Modifier.Node node2;
        int innerCoordinator$ui_release;
        androidx.compose.ui.node.NodeCoordinator this_$iv;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node4;
        int i3;
        int this_$iv$iv$iv2;
        int i6;
        int i4;
        int type$iv;
        int i7;
        int i5;
        innerCoordinator$ui_release2 = getInnerCoordinator$ui_release();
        int i9 = 0;
        $i$f$getLayoutAwareOLwlOKw = NodeKind.constructor-impl(128);
        final boolean includeSelfInTraversal-H91voCI = NodeKindKt.getIncludeSelfInTraversal-H91voCI($i$f$getLayoutAwareOLwlOKw);
        final androidx.compose.ui.node.NodeCoordinator nodeCoordinator = innerCoordinator$ui_release2;
        final int i11 = $i$f$getLayoutAwareOLwlOKw;
        final int i12 = 0;
        if (includeSelfInTraversal-H91voCI) {
            node$iv$iv = NodeCoordinator.access$headNode(nodeCoordinator, includeSelfInTraversal-H91voCI);
            while (node$iv$iv != null) {
                if (kindSet$ui_release &= i11 != 0) {
                } else {
                }
                this_$iv = innerCoordinator$ui_release2;
                type$iv = $i$f$getLayoutAwareOLwlOKw;
                i7 = $i$f$visitNodesALcG6gQ;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                innerCoordinator$ui_release2 = this_$iv;
                $i$f$getLayoutAwareOLwlOKw = type$iv;
                $i$f$visitNodesALcG6gQ = i7;
                i = 0;
                i2 = 0;
                stack$iv$iv = 0;
                int i13 = 0;
                node$iv$iv2 = node3;
                while (node$iv$iv2 != null) {
                    if (node$iv$iv2 instanceof LayoutAwareModifierNode) {
                    } else {
                    }
                    Modifier.Node this_$iv2 = node$iv$iv2;
                    int i14 = 0;
                    innerCoordinator$ui_release = this_$iv2;
                    if (kindSet$ui_release2 &= $i$f$getLayoutAwareOLwlOKw != 0) {
                    } else {
                    }
                    count$iv$iv = 0;
                    if (count$iv$iv != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    type$iv = $i$f$getLayoutAwareOLwlOKw;
                    i7 = $i$f$visitNodesALcG6gQ;
                    node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                    innerCoordinator$ui_release2 = this_$iv;
                    $i$f$getLayoutAwareOLwlOKw = type$iv;
                    $i$f$visitNodesALcG6gQ = i7;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    innerCoordinator$ui_release = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node4 = node$iv$iv$iv;
                        i3 = 0;
                        i6 = 0;
                        if (kindSet$ui_release3 &= $i$f$getLayoutAwareOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        type$iv = $i$f$getLayoutAwareOLwlOKw;
                        i7 = $i$f$visitNodesALcG6gQ;
                        next$iv$iv = node4;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $i$f$getLayoutAwareOLwlOKw = type$iv;
                        $i$f$visitNodesALcG6gQ = i7;
                        this_$iv$iv$iv = 1;
                        if (count$iv$iv++ == this_$iv$iv$iv) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        type$iv = $i$f$getLayoutAwareOLwlOKw;
                        i7 = $i$f$visitNodesALcG6gQ;
                        capacity$iv$iv$iv$iv = 0;
                        type$iv2 = stack$iv$iv;
                        stack$iv$iv = type$iv2;
                        $i$f$getLayoutAwareOLwlOKw = node$iv$iv2;
                        if ($i$f$getLayoutAwareOLwlOKw != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node4;
                        stack$iv$iv.add(node4);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv2 = $i$f$visitNodesALcG6gQ;
                        stack$iv$iv.add($i$f$getLayoutAwareOLwlOKw);
                        this_$iv$iv$iv2 = 0;
                        int i8 = 16;
                        i4 = 0;
                        type$iv = $i$f$getLayoutAwareOLwlOKw;
                        i7 = $i$f$visitNodesALcG6gQ;
                        i5 = i8;
                        type$iv2 = new MutableVector(new Modifier.Node[i8], 0);
                        node$iv$iv2 = node4;
                        type$iv = $i$f$getLayoutAwareOLwlOKw;
                        i7 = $i$f$visitNodesALcG6gQ;
                        next$iv$iv = node4;
                        capacity$iv$iv$iv$iv = 0;
                        this_$iv$iv$iv2 = this_$iv$iv$iv;
                    }
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    innerCoordinator$ui_release2 = this_$iv;
                    $i$f$getLayoutAwareOLwlOKw = type$iv;
                    $i$f$visitNodesALcG6gQ = i7;
                    node4 = node$iv$iv$iv;
                    i3 = 0;
                    i6 = 0;
                    if (kindSet$ui_release3 &= $i$f$getLayoutAwareOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    type$iv = $i$f$getLayoutAwareOLwlOKw;
                    i7 = $i$f$visitNodesALcG6gQ;
                    next$iv$iv = node4;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $i$f$getLayoutAwareOLwlOKw = type$iv;
                    $i$f$visitNodesALcG6gQ = i7;
                    this_$iv$iv$iv = 1;
                    if (count$iv$iv++ == this_$iv$iv$iv) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    type$iv = $i$f$getLayoutAwareOLwlOKw;
                    i7 = $i$f$visitNodesALcG6gQ;
                    capacity$iv$iv$iv$iv = 0;
                    type$iv2 = stack$iv$iv;
                    stack$iv$iv = type$iv2;
                    $i$f$getLayoutAwareOLwlOKw = node$iv$iv2;
                    if ($i$f$getLayoutAwareOLwlOKw != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node4;
                    stack$iv$iv.add(node4);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv2 = $i$f$visitNodesALcG6gQ;
                    stack$iv$iv.add($i$f$getLayoutAwareOLwlOKw);
                    this_$iv$iv$iv2 = 0;
                    i8 = 16;
                    i4 = 0;
                    type$iv = $i$f$getLayoutAwareOLwlOKw;
                    i7 = $i$f$visitNodesALcG6gQ;
                    i5 = i8;
                    type$iv2 = new MutableVector(new Modifier.Node[i8], 0);
                    node$iv$iv2 = node4;
                    type$iv = $i$f$getLayoutAwareOLwlOKw;
                    i7 = $i$f$visitNodesALcG6gQ;
                    next$iv$iv = node4;
                    capacity$iv$iv$iv$iv = 0;
                    this_$iv$iv$iv2 = this_$iv$iv$iv;
                    count$iv$iv = this_$iv$iv$iv;
                    node2 = 0;
                    this_$iv = innerCoordinator$ui_release2;
                    (LayoutAwareModifierNode)node$iv$iv2.onPlaced((LayoutCoordinates)getInnerCoordinator$ui_release());
                    type$iv = $i$f$getLayoutAwareOLwlOKw;
                    i7 = $i$f$visitNodesALcG6gQ;
                }
                this_$iv = innerCoordinator$ui_release2;
                type$iv = $i$f$getLayoutAwareOLwlOKw;
                i7 = $i$f$visitNodesALcG6gQ;
                if (node$iv$iv2 instanceof LayoutAwareModifierNode) {
                } else {
                }
                this_$iv2 = node$iv$iv2;
                i14 = 0;
                innerCoordinator$ui_release = this_$iv2;
                if (kindSet$ui_release2 &= $i$f$getLayoutAwareOLwlOKw != 0) {
                } else {
                }
                count$iv$iv = 0;
                if (count$iv$iv != 0 && node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                type$iv = $i$f$getLayoutAwareOLwlOKw;
                i7 = $i$f$visitNodesALcG6gQ;
                node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                innerCoordinator$ui_release2 = this_$iv;
                $i$f$getLayoutAwareOLwlOKw = type$iv;
                $i$f$visitNodesALcG6gQ = i7;
                if (node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                innerCoordinator$ui_release = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node4 = node$iv$iv$iv;
                    i3 = 0;
                    i6 = 0;
                    if (kindSet$ui_release3 &= $i$f$getLayoutAwareOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    type$iv = $i$f$getLayoutAwareOLwlOKw;
                    i7 = $i$f$visitNodesALcG6gQ;
                    next$iv$iv = node4;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $i$f$getLayoutAwareOLwlOKw = type$iv;
                    $i$f$visitNodesALcG6gQ = i7;
                    this_$iv$iv$iv = 1;
                    if (count$iv$iv++ == this_$iv$iv$iv) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    type$iv = $i$f$getLayoutAwareOLwlOKw;
                    i7 = $i$f$visitNodesALcG6gQ;
                    capacity$iv$iv$iv$iv = 0;
                    type$iv2 = stack$iv$iv;
                    stack$iv$iv = type$iv2;
                    $i$f$getLayoutAwareOLwlOKw = node$iv$iv2;
                    if ($i$f$getLayoutAwareOLwlOKw != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node4;
                    stack$iv$iv.add(node4);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv2 = $i$f$visitNodesALcG6gQ;
                    stack$iv$iv.add($i$f$getLayoutAwareOLwlOKw);
                    this_$iv$iv$iv2 = 0;
                    i8 = 16;
                    i4 = 0;
                    type$iv = $i$f$getLayoutAwareOLwlOKw;
                    i7 = $i$f$visitNodesALcG6gQ;
                    i5 = i8;
                    type$iv2 = new MutableVector(new Modifier.Node[i8], 0);
                    node$iv$iv2 = node4;
                    type$iv = $i$f$getLayoutAwareOLwlOKw;
                    i7 = $i$f$visitNodesALcG6gQ;
                    next$iv$iv = node4;
                    capacity$iv$iv$iv$iv = 0;
                    this_$iv$iv$iv2 = this_$iv$iv$iv;
                }
                if (count$iv$iv == 1) {
                } else {
                }
                innerCoordinator$ui_release2 = this_$iv;
                $i$f$getLayoutAwareOLwlOKw = type$iv;
                $i$f$visitNodesALcG6gQ = i7;
                node4 = node$iv$iv$iv;
                i3 = 0;
                i6 = 0;
                if (kindSet$ui_release3 &= $i$f$getLayoutAwareOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                type$iv = $i$f$getLayoutAwareOLwlOKw;
                i7 = $i$f$visitNodesALcG6gQ;
                next$iv$iv = node4;
                capacity$iv$iv$iv$iv = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $i$f$getLayoutAwareOLwlOKw = type$iv;
                $i$f$visitNodesALcG6gQ = i7;
                this_$iv$iv$iv = 1;
                if (count$iv$iv++ == this_$iv$iv$iv) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                type$iv = $i$f$getLayoutAwareOLwlOKw;
                i7 = $i$f$visitNodesALcG6gQ;
                capacity$iv$iv$iv$iv = 0;
                type$iv2 = stack$iv$iv;
                stack$iv$iv = type$iv2;
                $i$f$getLayoutAwareOLwlOKw = node$iv$iv2;
                if ($i$f$getLayoutAwareOLwlOKw != null && stack$iv$iv != 0) {
                }
                if (stack$iv$iv != 0) {
                } else {
                }
                next$iv$iv = node4;
                stack$iv$iv.add(node4);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv2 = $i$f$visitNodesALcG6gQ;
                stack$iv$iv.add($i$f$getLayoutAwareOLwlOKw);
                this_$iv$iv$iv2 = 0;
                i8 = 16;
                i4 = 0;
                type$iv = $i$f$getLayoutAwareOLwlOKw;
                i7 = $i$f$visitNodesALcG6gQ;
                i5 = i8;
                type$iv2 = new MutableVector(new Modifier.Node[i8], 0);
                node$iv$iv2 = node4;
                type$iv = $i$f$getLayoutAwareOLwlOKw;
                i7 = $i$f$visitNodesALcG6gQ;
                next$iv$iv = node4;
                capacity$iv$iv$iv$iv = 0;
                this_$iv$iv$iv2 = this_$iv$iv$iv;
                count$iv$iv = this_$iv$iv$iv;
                node2 = 0;
                this_$iv = innerCoordinator$ui_release2;
                (LayoutAwareModifierNode)node$iv$iv2.onPlaced((LayoutCoordinates)getInnerCoordinator$ui_release());
                type$iv = $i$f$getLayoutAwareOLwlOKw;
                i7 = $i$f$visitNodesALcG6gQ;
            }
            this_$iv = innerCoordinator$ui_release2;
            type$iv = $i$f$getLayoutAwareOLwlOKw;
            i7 = $i$f$visitNodesALcG6gQ;
        } else {
            if (nodeCoordinator.getTail().getParent$ui_release() == null) {
                this_$iv = innerCoordinator$ui_release2;
                type$iv = $i$f$getLayoutAwareOLwlOKw;
                i7 = $i$f$visitNodesALcG6gQ;
            } else {
            }
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onRelease() {
        androidx.compose.ui.node.NodeCoordinator delegate$iv;
        androidx.compose.ui.node.NodeCoordinator nodeCoordinator;
        int i;
        AndroidViewHolder interopViewFactoryHolder = this.interopViewFactoryHolder;
        if (interopViewFactoryHolder != null) {
            interopViewFactoryHolder.onRelease();
        }
        LayoutNodeSubcompositionsState subcompositionsState = this.subcompositionsState;
        if (subcompositionsState != null) {
            subcompositionsState.onRelease();
        }
        Object obj = this;
        final int i2 = 0;
        delegate$iv = obj.getOuterCoordinator$ui_release();
        while (!Intrinsics.areEqual(delegate$iv, obj.getInnerCoordinator$ui_release().getWrapped$ui_release())) {
            if (delegate$iv != null) {
            }
            i = 0;
            delegate$iv.onRelease();
            delegate$iv = delegate$iv.getWrapped$ui_release();
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onReuse() {
        int deactivated;
        String $i$a$RequirePreconditionLayoutNode$onReuse$1;
        final int i = 0;
        if (!isAttached()) {
            int i2 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("onReuse is only expected on attached node");
        }
        AndroidViewHolder value$iv = this.interopViewFactoryHolder;
        if (value$iv != null) {
            value$iv.onReuse();
        }
        LayoutNodeSubcompositionsState subcompositionsState = this.subcompositionsState;
        if (subcompositionsState != null) {
            subcompositionsState.onReuse();
        }
        if (isDeactivated()) {
            this.isDeactivated = false;
            invalidateSemantics$ui_release();
        } else {
            resetModifierState();
        }
        setSemanticsId(SemanticsModifierKt.generateSemanticsId());
        this.nodes.markAsAttached();
        this.nodes.runAttachLifecycle();
        rescheduleRemeasureOrRelayout$ui_release(this);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void onZSortedChildrenInvalidated$ui_release() {
        int parent$ui_release;
        if (this.isVirtual) {
            parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                parent$ui_release.onZSortedChildrenInvalidated$ui_release();
            }
        } else {
            this.zSortedChildrenInvalidated = true;
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void place$ui_release(int x, int y) {
        Object innerCoordinator$ui_release;
        if (this.intrinsicsUsageByParent == LayoutNode.UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        innerCoordinator$ui_release = getParent$ui_release();
        innerCoordinator$ui_release = innerCoordinator$ui_release.getInnerCoordinator$ui_release();
        if (innerCoordinator$ui_release != null && innerCoordinator$ui_release != null) {
            innerCoordinator$ui_release = innerCoordinator$ui_release.getInnerCoordinator$ui_release();
            if (innerCoordinator$ui_release != null) {
                if (innerCoordinator$ui_release.getPlacementScope() == null) {
                    innerCoordinator$ui_release = LayoutNodeKt.requireOwner(this).getPlacementScope();
                }
            } else {
            }
        } else {
        }
        int i = 0;
        Placeable.PlacementScope.placeRelative$default(innerCoordinator$ui_release, (Placeable)getMeasurePassDelegate$ui_release(), x, y, 0, 4, 0);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final boolean remeasure-_Sx5XlM$ui_release(Constraints constraints) {
        boolean remeasure-BRTryo0;
        long unbox-impl;
        if (constraints != null) {
            if (this.intrinsicsUsageByParent == LayoutNode.UsageByParent.NotUsed) {
                clearSubtreeIntrinsicsUsage$ui_release();
            }
            remeasure-BRTryo0 = getMeasurePassDelegate$ui_release().remeasure-BRTryo0(constraints.unbox-impl());
        } else {
            remeasure-BRTryo0 = 0;
        }
        return remeasure-BRTryo0;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void removeAll$ui_release() {
        int i;
        Object obj;
        size--;
        while (-1 < i) {
            onChildRemoved((LayoutNode)this._foldedChildren.get(i));
            i--;
        }
        this._foldedChildren.clear();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void removeAt$ui_release(int index, int count) {
        int i;
        int i2;
        int i3;
        String $i$a$RequirePreconditionLayoutNode$removeAt$1;
        StringBuilder append;
        String str;
        i = 1;
        i2 = count >= 0 ? i : 0;
        final int i4 = 0;
        if (i2 == 0) {
            int i5 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            InlineClassHelperKt.throwIllegalArgumentException(stringBuilder.append("count (").append(count).append(") must be greater than 0").toString());
        }
        if (index <= value$iv -= i) {
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void replace$ui_release() {
        if (this.intrinsicsUsageByParent == LayoutNode.UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        getMeasurePassDelegate$ui_release().replace();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void requestLookaheadRelayout$ui_release(boolean forceRequest) {
        boolean isVirtual;
        int i;
        isVirtual = this.owner;
        if (!this.isVirtual && isVirtual != null) {
            isVirtual = this.owner;
            if (isVirtual != null) {
                isVirtual.onRequestRelayout(this, true, forceRequest);
            }
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void requestLookaheadRemeasure$ui_release(boolean forceRequest, boolean scheduleMeasureAndLayout, boolean invalidateIntrinsics) {
        int i;
        int lookaheadPassDelegate$ui_release;
        boolean ignoreRemeasureRequests;
        String $i$a$CheckPreconditionLayoutNode$requestLookaheadRemeasure$1;
        lookaheadPassDelegate$ui_release = 1;
        i = this.lookaheadRoot != null ? lookaheadPassDelegate$ui_release : 0;
        int i2 = 0;
        if (i == 0) {
            int i3 = 0;
            InlineClassHelperKt.throwIllegalStateException("Lookahead measure cannot be requested on a node that is not a part of theLookaheadScope");
        }
        androidx.compose.ui.node.Owner value$iv = this.owner;
        if (value$iv == null) {
        }
        value$iv.onRequestMeasure(this, lookaheadPassDelegate$ui_release, forceRequest, scheduleMeasureAndLayout);
        if (!this.ignoreRemeasureRequests && !this.isVirtual && invalidateIntrinsics) {
            if (!this.isVirtual) {
                value$iv.onRequestMeasure(this, lookaheadPassDelegate$ui_release, forceRequest, scheduleMeasureAndLayout);
                if (invalidateIntrinsics) {
                    lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    lookaheadPassDelegate$ui_release.invalidateIntrinsicsParent(forceRequest);
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void requestRelayout$ui_release(boolean forceRequest) {
        androidx.compose.ui.node.Owner owner;
        Object obj;
        int i;
        boolean forceRequest2;
        int i3;
        int i2;
        if (!this.isVirtual) {
            owner = this.owner;
            if (owner != null) {
                Owner.onRequestRelayout$default(owner, this, false, forceRequest, 2, 0);
            } else {
                forceRequest2 = forceRequest;
            }
        } else {
            forceRequest2 = forceRequest;
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void requestRemeasure$ui_release(boolean forceRequest, boolean scheduleMeasureAndLayout, boolean invalidateIntrinsics) {
        boolean ignoreRemeasureRequests;
        androidx.compose.ui.node.Owner owner;
        Object obj;
        int i3;
        boolean forceRequest2;
        boolean z;
        int i;
        int i2;
        androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate obj9;
        if (!this.ignoreRemeasureRequests && !this.isVirtual) {
            if (!this.isVirtual) {
                ignoreRemeasureRequests = this.owner;
                if (ignoreRemeasureRequests == null) {
                }
                forceRequest2 = forceRequest;
                Owner.onRequestMeasure$default(ignoreRemeasureRequests, this, false, forceRequest2, scheduleMeasureAndLayout, 2, 0);
                if (invalidateIntrinsics) {
                    getMeasurePassDelegate$ui_release().invalidateIntrinsicsParent(forceRequest2);
                }
            } else {
                forceRequest2 = forceRequest;
                z = scheduleMeasureAndLayout;
            }
        } else {
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void rescheduleRemeasureOrRelayout$ui_release(androidx.compose.ui.node.LayoutNode it) {
        androidx.compose.ui.node.LayoutNode it2;
        int i4;
        int i5;
        int i7;
        int i;
        int i8;
        androidx.compose.ui.node.LayoutNode layoutNode;
        int i6;
        int i9;
        int i3;
        int i10;
        int i2;
        boolean obj15;
        int i12 = 1;
        if (LayoutNode.WhenMappings.$EnumSwitchMapping$0[it.getLayoutState$ui_release().ordinal()] != i12) {
        } else {
            if (it.getLookaheadMeasurePending$ui_release()) {
                LayoutNode.requestLookaheadRemeasure$ui_release$default(it, true, false, false, 6, 0);
            } else {
                it2 = it;
                if (it2.getLookaheadLayoutPending$ui_release()) {
                    it2.requestLookaheadRelayout$ui_release(i12);
                }
                if (it2.getMeasurePending$ui_release()) {
                    LayoutNode.requestRemeasure$ui_release$default(it2, true, false, false, 6, 0);
                } else {
                    if (it2.getLayoutPending$ui_release()) {
                        it2.requestRelayout$ui_release(i12);
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        obj15 = new IllegalStateException(stringBuilder.append("Unexpected state ").append(it.getLayoutState$ui_release()).toString());
        throw obj15;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void resetSubtreeIntrinsicsUsage$ui_release() {
        int i$iv$iv;
        Object[] content;
        Object obj;
        int i;
        androidx.compose.ui.node.LayoutNode.UsageByParent intrinsicsUsageByParent;
        androidx.compose.ui.node.LayoutNode.UsageByParent notUsed;
        final int i2 = 0;
        final MutableVector mutableVector = this.get_children$ui_release();
        final int i3 = 0;
        final int size = mutableVector.getSize();
        if (size > 0) {
            i$iv$iv = 0;
            obj = mutableVector.getContent()[i$iv$iv];
            i = 0;
            obj.intrinsicsUsageByParent = obj.previousIntrinsicsUsageByParent;
            do {
                obj = content[i$iv$iv];
                i = 0;
                obj.intrinsicsUsageByParent = obj.previousIntrinsicsUsageByParent;
                if (i$iv$iv++ < size) {
                }
                (LayoutNode)(LayoutNode)obj.resetSubtreeIntrinsicsUsage$ui_release();
            } while (obj.intrinsicsUsageByParent != LayoutNode.UsageByParent.NotUsed);
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void setCanMultiMeasure$ui_release(boolean <set-?>) {
        this.canMultiMeasure = <set-?>;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void setCompositeKeyHash(int <set-?>) {
        this.compositeKeyHash = <set-?>;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void setCompositionLocalMap(CompositionLocalMap value) {
        Object node$iv$iv2;
        int capacity$iv$iv$iv$iv;
        Modifier.Node next$iv$iv;
        CompositionLocalMap map;
        Modifier.Node $i$f$mutableVectorOf;
        androidx.compose.ui.node.NodeChain $i$f$isKindH91voCI$ui_release;
        int i9;
        int i8;
        Modifier.Node node$iv$iv$iv2;
        Modifier.Node node;
        int i4;
        int i11;
        int i2;
        Modifier.Node node2;
        int i3;
        int node$iv$iv5;
        int node$iv$iv;
        Modifier.Node node$iv$iv4;
        int i6;
        androidx.compose.ui.node.NodeChain this_$iv;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node3;
        int i5;
        int this_$iv$iv$iv;
        Modifier.Node node$iv$iv3;
        int i10;
        int i7;
        int i12;
        int i;
        node$iv$iv2 = this;
        map = value;
        node$iv$iv2.compositionLocalMap = map;
        node$iv$iv2.setDensity((Density)map.get((CompositionLocal)CompositionLocalsKt.getLocalDensity()));
        node$iv$iv2.setLayoutDirection((LayoutDirection)map.get((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()));
        node$iv$iv2.setViewConfiguration((ViewConfiguration)map.get((CompositionLocal)CompositionLocalsKt.getLocalViewConfiguration()));
        $i$f$isKindH91voCI$ui_release = node$iv$iv2.nodes;
        int i16 = 0;
        int $i$f$getCompositionLocalConsumerOLwlOKw = NodeKind.constructor-impl(32768);
        int i18 = 0;
        final int i19 = $i$f$getCompositionLocalConsumerOLwlOKw;
        final androidx.compose.ui.node.NodeChain nodeChain = $i$f$isKindH91voCI$ui_release;
        final int i20 = 0;
        if (i21 &= i19 != 0) {
            i8 = 0;
            node$iv$iv$iv2 = nodeChain.getHead$ui_release();
            while (node$iv$iv$iv2 != null) {
                node = node$iv$iv$iv2;
                i4 = 0;
                if (kindSet$ui_release &= i19 != 0) {
                } else {
                }
                this_$iv = $i$f$isKindH91voCI$ui_release;
                if (aggregateChildKindSet$ui_release &= i19 != 0) {
                    break;
                }
                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                node$iv$iv2 = this;
                map = value;
                $i$f$isKindH91voCI$ui_release = this_$iv;
                i2 = 0;
                i3 = 0;
                node$iv$iv5 = 0;
                int i22 = 0;
                node$iv$iv2 = node$iv$iv4;
                while (node$iv$iv2 != null) {
                    if (node$iv$iv2 instanceof CompositionLocalConsumerModifierNode) {
                    } else {
                    }
                    $i$f$mutableVectorOf = node$iv$iv2;
                    int i15 = 0;
                    i6 = $i$f$mutableVectorOf;
                    if (kindSet$ui_release2 &= $i$f$getCompositionLocalConsumerOLwlOKw != 0) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    node$iv$iv2 = DelegatableNodeKt.access$pop(node$iv$iv5);
                    map = value;
                    $i$f$isKindH91voCI$ui_release = this_$iv;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    i6 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node3 = node$iv$iv$iv;
                        i5 = 0;
                        node$iv$iv3 = 0;
                        if (kindSet$ui_release3 &= $i$f$getCompositionLocalConsumerOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node3;
                        $i$f$mutableVectorOf = node$iv$iv5;
                        node$iv$iv = node$iv$iv3;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        node$iv$iv2 = node$iv$iv;
                        node$iv$iv5 = $i$f$mutableVectorOf;
                        $i$f$isKindH91voCI$ui_release++;
                        if ($i$f$isKindH91voCI$ui_release == 1) {
                        } else {
                        }
                        if (node$iv$iv5 == 0) {
                        } else {
                        }
                        node$iv$iv3 = node$iv$iv2;
                        i12 = $i$f$isKindH91voCI$ui_release;
                        capacity$iv$iv$iv$iv = 0;
                        $i$f$mutableVectorOf = node$iv$iv5;
                        Modifier.Node node4 = node$iv$iv3;
                        if (node4 != null) {
                        } else {
                        }
                        node$iv$iv = node$iv$iv3;
                        if ($i$f$mutableVectorOf != null) {
                        } else {
                        }
                        next$iv$iv = node3;
                        $i$f$isKindH91voCI$ui_release = i12;
                        $i$f$mutableVectorOf.add(node3);
                        if ($i$f$mutableVectorOf != null) {
                        }
                        node$iv$iv = 0;
                        $i$f$mutableVectorOf.add(node4);
                        node$iv$iv3 = node$iv$iv2;
                        int node$iv$iv6 = 16;
                        i10 = 0;
                        i7 = i14;
                        i12 = $i$f$isKindH91voCI$ui_release;
                        i = node$iv$iv6;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[node$iv$iv6], 0);
                        $i$f$mutableVectorOf = node$iv$iv5;
                        node$iv$iv = next$iv$iv;
                        this_$iv$iv$iv = 1;
                    }
                    node$iv$iv3 = node$iv$iv2;
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    node$iv$iv2 = node$iv$iv3;
                    map = value;
                    $i$f$isKindH91voCI$ui_release = this_$iv;
                    node$iv$iv2 = node$iv$iv3;
                    node3 = node$iv$iv$iv;
                    i5 = 0;
                    node$iv$iv3 = 0;
                    if (kindSet$ui_release3 &= $i$f$getCompositionLocalConsumerOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node3;
                    $i$f$mutableVectorOf = node$iv$iv5;
                    node$iv$iv = node$iv$iv3;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    node$iv$iv2 = node$iv$iv;
                    node$iv$iv5 = $i$f$mutableVectorOf;
                    $i$f$isKindH91voCI$ui_release++;
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    if (node$iv$iv5 == 0) {
                    } else {
                    }
                    node$iv$iv3 = node$iv$iv2;
                    i12 = $i$f$isKindH91voCI$ui_release;
                    capacity$iv$iv$iv$iv = 0;
                    $i$f$mutableVectorOf = node$iv$iv5;
                    node4 = node$iv$iv3;
                    if (node4 != null) {
                    } else {
                    }
                    node$iv$iv = node$iv$iv3;
                    if ($i$f$mutableVectorOf != null) {
                    } else {
                    }
                    next$iv$iv = node3;
                    $i$f$isKindH91voCI$ui_release = i12;
                    $i$f$mutableVectorOf.add(node3);
                    if ($i$f$mutableVectorOf != null) {
                    }
                    node$iv$iv = 0;
                    $i$f$mutableVectorOf.add(node4);
                    node$iv$iv3 = node$iv$iv2;
                    node$iv$iv6 = 16;
                    i10 = 0;
                    i7 = i14;
                    i12 = $i$f$isKindH91voCI$ui_release;
                    i = node$iv$iv6;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[node$iv$iv6], 0);
                    $i$f$mutableVectorOf = node$iv$iv5;
                    node$iv$iv = next$iv$iv;
                    this_$iv$iv$iv = 1;
                    $i$f$isKindH91voCI$ui_release = 1;
                    i6 = 0;
                    $i$f$mutableVectorOf = (CompositionLocalConsumerModifierNode)node$iv$iv2.getNode();
                    if ($i$f$mutableVectorOf.isAttached()) {
                    } else {
                    }
                    this_$iv = $i$f$isKindH91voCI$ui_release;
                    $i$f$mutableVectorOf.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                    NodeKindKt.autoInvalidateUpdatedNode($i$f$mutableVectorOf);
                    this_$iv = $i$f$isKindH91voCI$ui_release;
                }
                this_$iv = $i$f$isKindH91voCI$ui_release;
                if (node$iv$iv2 instanceof CompositionLocalConsumerModifierNode) {
                } else {
                }
                $i$f$mutableVectorOf = node$iv$iv2;
                i15 = 0;
                i6 = $i$f$mutableVectorOf;
                if (kindSet$ui_release2 &= $i$f$getCompositionLocalConsumerOLwlOKw != 0) {
                } else {
                }
                $i$f$isKindH91voCI$ui_release = 0;
                if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                node$iv$iv2 = DelegatableNodeKt.access$pop(node$iv$iv5);
                map = value;
                $i$f$isKindH91voCI$ui_release = this_$iv;
                if (node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                $i$f$isKindH91voCI$ui_release = 0;
                i6 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node3 = node$iv$iv$iv;
                    i5 = 0;
                    node$iv$iv3 = 0;
                    if (kindSet$ui_release3 &= $i$f$getCompositionLocalConsumerOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node3;
                    $i$f$mutableVectorOf = node$iv$iv5;
                    node$iv$iv = node$iv$iv3;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    node$iv$iv2 = node$iv$iv;
                    node$iv$iv5 = $i$f$mutableVectorOf;
                    $i$f$isKindH91voCI$ui_release++;
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    if (node$iv$iv5 == 0) {
                    } else {
                    }
                    node$iv$iv3 = node$iv$iv2;
                    i12 = $i$f$isKindH91voCI$ui_release;
                    capacity$iv$iv$iv$iv = 0;
                    $i$f$mutableVectorOf = node$iv$iv5;
                    node4 = node$iv$iv3;
                    if (node4 != null) {
                    } else {
                    }
                    node$iv$iv = node$iv$iv3;
                    if ($i$f$mutableVectorOf != null) {
                    } else {
                    }
                    next$iv$iv = node3;
                    $i$f$isKindH91voCI$ui_release = i12;
                    $i$f$mutableVectorOf.add(node3);
                    if ($i$f$mutableVectorOf != null) {
                    }
                    node$iv$iv = 0;
                    $i$f$mutableVectorOf.add(node4);
                    node$iv$iv3 = node$iv$iv2;
                    node$iv$iv6 = 16;
                    i10 = 0;
                    i7 = i14;
                    i12 = $i$f$isKindH91voCI$ui_release;
                    i = node$iv$iv6;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[node$iv$iv6], 0);
                    $i$f$mutableVectorOf = node$iv$iv5;
                    node$iv$iv = next$iv$iv;
                    this_$iv$iv$iv = 1;
                }
                node$iv$iv3 = node$iv$iv2;
                if ($i$f$isKindH91voCI$ui_release == 1) {
                } else {
                }
                node$iv$iv2 = node$iv$iv3;
                map = value;
                $i$f$isKindH91voCI$ui_release = this_$iv;
                node$iv$iv2 = node$iv$iv3;
                node3 = node$iv$iv$iv;
                i5 = 0;
                node$iv$iv3 = 0;
                if (kindSet$ui_release3 &= $i$f$getCompositionLocalConsumerOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                next$iv$iv = node3;
                $i$f$mutableVectorOf = node$iv$iv5;
                node$iv$iv = node$iv$iv3;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                node$iv$iv2 = node$iv$iv;
                node$iv$iv5 = $i$f$mutableVectorOf;
                $i$f$isKindH91voCI$ui_release++;
                if ($i$f$isKindH91voCI$ui_release == 1) {
                } else {
                }
                if (node$iv$iv5 == 0) {
                } else {
                }
                node$iv$iv3 = node$iv$iv2;
                i12 = $i$f$isKindH91voCI$ui_release;
                capacity$iv$iv$iv$iv = 0;
                $i$f$mutableVectorOf = node$iv$iv5;
                node4 = node$iv$iv3;
                if (node4 != null) {
                } else {
                }
                node$iv$iv = node$iv$iv3;
                if ($i$f$mutableVectorOf != null) {
                } else {
                }
                next$iv$iv = node3;
                $i$f$isKindH91voCI$ui_release = i12;
                $i$f$mutableVectorOf.add(node3);
                if ($i$f$mutableVectorOf != null) {
                }
                node$iv$iv = 0;
                $i$f$mutableVectorOf.add(node4);
                node$iv$iv3 = node$iv$iv2;
                node$iv$iv6 = 16;
                i10 = 0;
                i7 = i14;
                i12 = $i$f$isKindH91voCI$ui_release;
                i = node$iv$iv6;
                $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[node$iv$iv6], 0);
                $i$f$mutableVectorOf = node$iv$iv5;
                node$iv$iv = next$iv$iv;
                this_$iv$iv$iv = 1;
                $i$f$isKindH91voCI$ui_release = 1;
                i6 = 0;
                $i$f$mutableVectorOf = (CompositionLocalConsumerModifierNode)node$iv$iv2.getNode();
                if ($i$f$mutableVectorOf.isAttached()) {
                } else {
                }
                this_$iv = $i$f$isKindH91voCI$ui_release;
                $i$f$mutableVectorOf.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                NodeKindKt.autoInvalidateUpdatedNode($i$f$mutableVectorOf);
                this_$iv = $i$f$isKindH91voCI$ui_release;
            }
            this_$iv = $i$f$isKindH91voCI$ui_release;
        } else {
            this_$iv = $i$f$isKindH91voCI$ui_release;
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void setDensity(Density value) {
        boolean equal;
        int i2;
        Modifier.Node node$iv;
        Modifier.Node node3;
        int i;
        Modifier.Node node;
        Modifier.Node node2;
        int i3;
        int i4;
        if (!Intrinsics.areEqual(this.density, value)) {
            this.density = value;
            onDensityOrLayoutDirectionChanged();
            i2 = 0;
            node$iv = this.nodes.getHead$ui_release();
            while (node$iv != null) {
                node3 = node$iv;
                i = 0;
                int i5 = 0;
                i3 = 0;
                if (kindSet$ui_release &= $i$f$getPointerInputOLwlOKw != 0) {
                } else {
                }
                i4 = 0;
                if (i4 != 0) {
                } else {
                }
                if (node3 instanceof CacheDrawModifierNode) {
                }
                node$iv = node$iv.getChild$ui_release();
                (CacheDrawModifierNode)node3.invalidateDrawCache();
                (PointerInputModifierNode)node3.onDensityChange();
                i4 = 1;
            }
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void setDepth$ui_release(int <set-?>) {
        this.depth = <set-?>;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void setInnerLayerCoordinatorIsDirty$ui_release(boolean <set-?>) {
        this.innerLayerCoordinatorIsDirty = <set-?>;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void setInteropViewFactoryHolder$ui_release(AndroidViewHolder <set-?>) {
        this.interopViewFactoryHolder = <set-?>;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void setIntrinsicsUsageByParent$ui_release(androidx.compose.ui.node.LayoutNode.UsageByParent <set-?>) {
        this.intrinsicsUsageByParent = <set-?>;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void setLayoutDirection(LayoutDirection value) {
        Object stack$iv$iv;
        MutableVector node$iv$iv;
        LayoutDirection layoutDirection;
        int this_$iv$iv$iv;
        int capacity$iv$iv$iv$iv;
        Modifier.Node next$iv$iv;
        Object count$iv$iv;
        boolean this_$iv2;
        int $i$f$getDrawOLwlOKw;
        int i4;
        int i9;
        androidx.compose.ui.node.NodeChain nodeChain;
        int i15;
        int i5;
        int i6;
        Modifier.Node node$iv$iv$iv2;
        Modifier.Node node3;
        int i11;
        int i2;
        int i12;
        Modifier.Node node2;
        int i14;
        int node$iv$iv5;
        int node$iv$iv4;
        Modifier.Node node$iv$iv2;
        androidx.compose.ui.node.NodeChain this_$iv;
        int i10;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node;
        int i13;
        int this_$iv$iv$iv2;
        int i7;
        int i3;
        Modifier.Node node$iv$iv3;
        int i;
        int i8;
        stack$iv$iv = this;
        layoutDirection = value;
        if (stack$iv$iv.layoutDirection != layoutDirection) {
            stack$iv$iv.layoutDirection = layoutDirection;
            stack$iv$iv.onDensityOrLayoutDirectionChanged();
            count$iv$iv = stack$iv$iv.nodes;
            int i18 = 0;
            $i$f$getDrawOLwlOKw = NodeKind.constructor-impl(4);
            i4 = 0;
            i9 = $i$f$getDrawOLwlOKw;
            nodeChain = count$iv$iv;
            i15 = 0;
            if (i20 &= i9 != 0) {
                i6 = 0;
                node$iv$iv$iv2 = nodeChain.getHead$ui_release();
                while (node$iv$iv$iv2 != null) {
                    node3 = node$iv$iv$iv2;
                    i11 = 0;
                    if (kindSet$ui_release &= i9 != 0) {
                    } else {
                    }
                    this_$iv = count$iv$iv;
                    if (aggregateChildKindSet$ui_release &= i9 != 0) {
                        break;
                    }
                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                    stack$iv$iv = this;
                    layoutDirection = value;
                    count$iv$iv = this_$iv;
                    i12 = 0;
                    i14 = 0;
                    node$iv$iv5 = 0;
                    int i21 = 0;
                    stack$iv$iv = node$iv$iv2;
                    while (stack$iv$iv != null) {
                        if (stack$iv$iv instanceof DrawModifierNode) {
                        } else {
                        }
                        Modifier.Node node4 = stack$iv$iv;
                        int i17 = 0;
                        i10 = node4;
                        if (kindSet$ui_release2 &= $i$f$getDrawOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv2 = 0;
                        if (this_$iv2 != 0 && stack$iv$iv instanceof DelegatingNode) {
                        } else {
                        }
                        stack$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv5);
                        layoutDirection = value;
                        count$iv$iv = this_$iv;
                        if (stack$iv$iv instanceof DelegatingNode) {
                        } else {
                        }
                        this_$iv2 = 0;
                        i10 = 0;
                        node$iv$iv$iv = (DelegatingNode)stack$iv$iv.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node = node$iv$iv$iv;
                            i13 = 0;
                            i7 = 0;
                            if (kindSet$ui_release3 &= $i$f$getDrawOLwlOKw != 0) {
                            } else {
                            }
                            this_$iv$iv$iv2 = 0;
                            if (this_$iv$iv$iv2 != 0) {
                            } else {
                            }
                            node$iv$iv3 = stack$iv$iv;
                            next$iv$iv = node;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            this_$iv$iv$iv = 1;
                            this_$iv2++;
                            if (this_$iv2 == this_$iv$iv$iv) {
                            } else {
                            }
                            if (node$iv$iv5 == 0) {
                            } else {
                            }
                            node$iv$iv3 = stack$iv$iv;
                            i = this_$iv2;
                            capacity$iv$iv$iv$iv = 0;
                            node$iv$iv = node$iv$iv5;
                            Modifier.Node node5 = node$iv$iv3;
                            if (node5 != null) {
                            } else {
                            }
                            node$iv$iv4 = node$iv$iv3;
                            if (node$iv$iv != null) {
                            } else {
                            }
                            next$iv$iv = node;
                            node$iv$iv5 = node$iv$iv;
                            stack$iv$iv = theNode$iv$iv;
                            this_$iv2 = i;
                            node$iv$iv.add(node);
                            if (node$iv$iv != null) {
                            }
                            node$iv$iv4 = 0;
                            node$iv$iv.add(node5);
                            this_$iv$iv$iv2 = 0;
                            int i16 = 16;
                            i3 = 0;
                            node$iv$iv3 = stack$iv$iv;
                            i = this_$iv2;
                            i8 = i16;
                            node$iv$iv = new MutableVector(new Modifier.Node[i16], 0);
                            stack$iv$iv = node;
                            next$iv$iv = node;
                            this_$iv$iv$iv2 = this_$iv$iv$iv;
                        }
                        node$iv$iv3 = stack$iv$iv;
                        if (this_$iv2 == 1) {
                        } else {
                        }
                        stack$iv$iv = node$iv$iv3;
                        layoutDirection = value;
                        count$iv$iv = this_$iv;
                        stack$iv$iv = node$iv$iv3;
                        node = node$iv$iv$iv;
                        i13 = 0;
                        i7 = 0;
                        if (kindSet$ui_release3 &= $i$f$getDrawOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        node$iv$iv3 = stack$iv$iv;
                        next$iv$iv = node;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        this_$iv$iv$iv = 1;
                        this_$iv2++;
                        if (this_$iv2 == this_$iv$iv$iv) {
                        } else {
                        }
                        if (node$iv$iv5 == 0) {
                        } else {
                        }
                        node$iv$iv3 = stack$iv$iv;
                        i = this_$iv2;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv = node$iv$iv5;
                        node5 = node$iv$iv3;
                        if (node5 != null) {
                        } else {
                        }
                        node$iv$iv4 = node$iv$iv3;
                        if (node$iv$iv != null) {
                        } else {
                        }
                        next$iv$iv = node;
                        node$iv$iv5 = node$iv$iv;
                        stack$iv$iv = theNode$iv$iv;
                        this_$iv2 = i;
                        node$iv$iv.add(node);
                        if (node$iv$iv != null) {
                        }
                        node$iv$iv4 = 0;
                        node$iv$iv.add(node5);
                        this_$iv$iv$iv2 = 0;
                        i16 = 16;
                        i3 = 0;
                        node$iv$iv3 = stack$iv$iv;
                        i = this_$iv2;
                        i8 = i16;
                        node$iv$iv = new MutableVector(new Modifier.Node[i16], 0);
                        stack$iv$iv = node;
                        next$iv$iv = node;
                        this_$iv$iv$iv2 = this_$iv$iv$iv;
                        this_$iv2 = this_$iv$iv$iv;
                        this_$iv$iv$iv = stack$iv$iv;
                        node$iv$iv2 = 0;
                        this_$iv = count$iv$iv;
                        if (this_$iv$iv$iv instanceof CacheDrawModifierNode) {
                        }
                        (CacheDrawModifierNode)(DrawModifierNode)this_$iv$iv$iv.invalidateDrawCache();
                    }
                    this_$iv = count$iv$iv;
                    if (stack$iv$iv instanceof DrawModifierNode) {
                    } else {
                    }
                    node4 = stack$iv$iv;
                    i17 = 0;
                    i10 = node4;
                    if (kindSet$ui_release2 &= $i$f$getDrawOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv2 = 0;
                    if (this_$iv2 != 0 && stack$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    stack$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv5);
                    layoutDirection = value;
                    count$iv$iv = this_$iv;
                    if (stack$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv2 = 0;
                    i10 = 0;
                    node$iv$iv$iv = (DelegatingNode)stack$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node = node$iv$iv$iv;
                        i13 = 0;
                        i7 = 0;
                        if (kindSet$ui_release3 &= $i$f$getDrawOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        node$iv$iv3 = stack$iv$iv;
                        next$iv$iv = node;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        this_$iv$iv$iv = 1;
                        this_$iv2++;
                        if (this_$iv2 == this_$iv$iv$iv) {
                        } else {
                        }
                        if (node$iv$iv5 == 0) {
                        } else {
                        }
                        node$iv$iv3 = stack$iv$iv;
                        i = this_$iv2;
                        capacity$iv$iv$iv$iv = 0;
                        node$iv$iv = node$iv$iv5;
                        node5 = node$iv$iv3;
                        if (node5 != null) {
                        } else {
                        }
                        node$iv$iv4 = node$iv$iv3;
                        if (node$iv$iv != null) {
                        } else {
                        }
                        next$iv$iv = node;
                        node$iv$iv5 = node$iv$iv;
                        stack$iv$iv = theNode$iv$iv;
                        this_$iv2 = i;
                        node$iv$iv.add(node);
                        if (node$iv$iv != null) {
                        }
                        node$iv$iv4 = 0;
                        node$iv$iv.add(node5);
                        this_$iv$iv$iv2 = 0;
                        i16 = 16;
                        i3 = 0;
                        node$iv$iv3 = stack$iv$iv;
                        i = this_$iv2;
                        i8 = i16;
                        node$iv$iv = new MutableVector(new Modifier.Node[i16], 0);
                        stack$iv$iv = node;
                        next$iv$iv = node;
                        this_$iv$iv$iv2 = this_$iv$iv$iv;
                    }
                    node$iv$iv3 = stack$iv$iv;
                    if (this_$iv2 == 1) {
                    } else {
                    }
                    stack$iv$iv = node$iv$iv3;
                    layoutDirection = value;
                    count$iv$iv = this_$iv;
                    stack$iv$iv = node$iv$iv3;
                    node = node$iv$iv$iv;
                    i13 = 0;
                    i7 = 0;
                    if (kindSet$ui_release3 &= $i$f$getDrawOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    node$iv$iv3 = stack$iv$iv;
                    next$iv$iv = node;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv = 1;
                    this_$iv2++;
                    if (this_$iv2 == this_$iv$iv$iv) {
                    } else {
                    }
                    if (node$iv$iv5 == 0) {
                    } else {
                    }
                    node$iv$iv3 = stack$iv$iv;
                    i = this_$iv2;
                    capacity$iv$iv$iv$iv = 0;
                    node$iv$iv = node$iv$iv5;
                    node5 = node$iv$iv3;
                    if (node5 != null) {
                    } else {
                    }
                    node$iv$iv4 = node$iv$iv3;
                    if (node$iv$iv != null) {
                    } else {
                    }
                    next$iv$iv = node;
                    node$iv$iv5 = node$iv$iv;
                    stack$iv$iv = theNode$iv$iv;
                    this_$iv2 = i;
                    node$iv$iv.add(node);
                    if (node$iv$iv != null) {
                    }
                    node$iv$iv4 = 0;
                    node$iv$iv.add(node5);
                    this_$iv$iv$iv2 = 0;
                    i16 = 16;
                    i3 = 0;
                    node$iv$iv3 = stack$iv$iv;
                    i = this_$iv2;
                    i8 = i16;
                    node$iv$iv = new MutableVector(new Modifier.Node[i16], 0);
                    stack$iv$iv = node;
                    next$iv$iv = node;
                    this_$iv$iv$iv2 = this_$iv$iv$iv;
                    this_$iv2 = this_$iv$iv$iv;
                    this_$iv$iv$iv = stack$iv$iv;
                    node$iv$iv2 = 0;
                    this_$iv = count$iv$iv;
                    if (this_$iv$iv$iv instanceof CacheDrawModifierNode) {
                    }
                    (CacheDrawModifierNode)(DrawModifierNode)this_$iv$iv$iv.invalidateDrawCache();
                }
                this_$iv = count$iv$iv;
            } else {
                this_$iv = count$iv$iv;
            }
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void setMeasurePolicy(MeasurePolicy value) {
        boolean intrinsicsPolicy;
        MeasurePolicy measurePolicy;
        this.measurePolicy = value;
        intrinsicsPolicy = this.intrinsicsPolicy;
        if (!Intrinsics.areEqual(this.measurePolicy, value) && intrinsicsPolicy != null) {
            this.measurePolicy = value;
            intrinsicsPolicy = this.intrinsicsPolicy;
            if (intrinsicsPolicy != null) {
                intrinsicsPolicy.updateFrom(getMeasurePolicy());
            }
            invalidateMeasurements$ui_release();
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void setModifier(Modifier value) {
        int i;
        boolean isVirtual;
        androidx.compose.ui.Modifier.Companion companion;
        int $i$a$RequirePreconditionLayoutNode$modifier$2;
        String $i$a$RequirePreconditionLayoutNode$modifier$1;
        int i3 = 1;
        if (this.isVirtual) {
            if (getModifier() == Modifier.Companion) {
                i = i3;
            } else {
                i = 0;
            }
        } else {
        }
        $i$a$RequirePreconditionLayoutNode$modifier$2 = 0;
        if (i == 0) {
            int i6 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("Modifiers are not supported on virtual LayoutNodes");
        }
        int i4 = 0;
        if (deactivated ^= i3 == 0) {
            int i5 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("modifier is updated when deactivated");
        }
        if (isAttached()) {
            applyModifier(value);
        } else {
            this.pendingModifier = value;
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void setNeedsOnPositionedDispatch$ui_release(boolean <set-?>) {
        this.needsOnPositionedDispatch = <set-?>;
    }

    public final void setOnAttach$ui_release(Function1<? super androidx.compose.ui.node.Owner, Unit> <set-?>) {
        this.onAttach = <set-?>;
    }

    public final void setOnDetach$ui_release(Function1<? super androidx.compose.ui.node.Owner, Unit> <set-?>) {
        this.onDetach = <set-?>;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void setSemanticsId(int <set-?>) {
        this.semanticsId = <set-?>;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void setSubcompositionsState$ui_release(LayoutNodeSubcompositionsState <set-?>) {
        this.subcompositionsState = <set-?>;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void setViewConfiguration(ViewConfiguration value) {
        Object node$iv$iv2;
        int capacity$iv$iv$iv$iv;
        Modifier.Node node$iv$iv3;
        Object count$iv$iv;
        Modifier.Node count$iv$iv2;
        int count$iv$iv3;
        androidx.compose.ui.node.NodeChain this_$iv3;
        int this_$iv2;
        int $i$f$getPointerInputOLwlOKw;
        int i9;
        int i6;
        androidx.compose.ui.node.NodeChain nodeChain;
        int i2;
        androidx.compose.ui.node.NodeChain i8;
        int i10;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node4;
        int i;
        Modifier.Node node6;
        int i7;
        Modifier.Node node5;
        int i3;
        int node$iv$iv;
        int stack$iv$iv;
        Modifier.Node node$iv$iv4;
        int i11;
        Modifier.Node node2;
        Modifier.Node node$iv$iv$iv2;
        Modifier.Node node;
        int i4;
        Modifier.Node node3;
        int this_$iv$iv$iv;
        int i12;
        int i5;
        int count$iv$iv4;
        androidx.compose.ui.node.NodeChain this_$iv;
        int i13;
        node$iv$iv2 = this;
        count$iv$iv = value;
        if (!Intrinsics.areEqual(node$iv$iv2.viewConfiguration, count$iv$iv)) {
            node$iv$iv2.viewConfiguration = count$iv$iv;
            this_$iv3 = node$iv$iv2.nodes;
            int i15 = 0;
            $i$f$getPointerInputOLwlOKw = NodeKind.constructor-impl(16);
            i9 = 0;
            i6 = $i$f$getPointerInputOLwlOKw;
            nodeChain = this_$iv3;
            i2 = 0;
            if (i17 &= i6 != 0) {
                i10 = 0;
                node$iv$iv$iv = nodeChain.getHead$ui_release();
                while (node$iv$iv$iv != null) {
                    node4 = node$iv$iv$iv;
                    i = 0;
                    if (kindSet$ui_release &= i6 != 0) {
                    } else {
                    }
                    this_$iv = this_$iv3;
                    if (aggregateChildKindSet$ui_release &= i6 != 0) {
                        break;
                    }
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    node$iv$iv2 = this;
                    count$iv$iv = value;
                    this_$iv3 = this_$iv;
                    i7 = 0;
                    i3 = 0;
                    node$iv$iv = 0;
                    int i18 = 0;
                    node$iv$iv2 = node$iv$iv4;
                    while (node$iv$iv2 != null) {
                        if (node$iv$iv2 instanceof PointerInputModifierNode) {
                        } else {
                        }
                        count$iv$iv2 = node$iv$iv2;
                        int i19 = 0;
                        node2 = count$iv$iv2;
                        if (kindSet$ui_release2 &= $i$f$getPointerInputOLwlOKw != 0) {
                        } else {
                        }
                        node$iv$iv4 = 0;
                        if (node$iv$iv4 != null && node$iv$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        this_$iv = this_$iv3;
                        node$iv$iv2 = DelegatableNodeKt.access$pop(node$iv$iv);
                        count$iv$iv = value;
                        this_$iv3 = this_$iv;
                        if (node$iv$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv2 = 0;
                        node2 = 0;
                        node$iv$iv$iv2 = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                        while (node$iv$iv$iv2 != null) {
                            node = node$iv$iv$iv2;
                            i4 = 0;
                            i12 = 0;
                            if (kindSet$ui_release3 &= $i$f$getPointerInputOLwlOKw != 0) {
                            } else {
                            }
                            this_$iv$iv$iv = 0;
                            if (this_$iv$iv$iv != 0) {
                            } else {
                            }
                            this_$iv = this_$iv3;
                            node$iv$iv3 = node;
                            this_$iv2 = node$iv$iv;
                            stack$iv$iv = node3;
                            node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                            node$iv$iv2 = stack$iv$iv;
                            node$iv$iv = this_$iv2;
                            this_$iv3 = this_$iv;
                            count$iv$iv2++;
                            node3 = node$iv$iv2;
                            if (count$iv$iv2 == 1) {
                            } else {
                            }
                            if (node$iv$iv == 0) {
                            } else {
                            }
                            count$iv$iv4 = count$iv$iv2;
                            this_$iv = this_$iv3;
                            capacity$iv$iv$iv$iv = 0;
                            count$iv$iv3 = node$iv$iv;
                            Modifier.Node node7 = node3;
                            if (node7 != null) {
                            } else {
                            }
                            stack$iv$iv = node3;
                            if (count$iv$iv3 != 0) {
                            } else {
                            }
                            node$iv$iv3 = node;
                            this_$iv2 = count$iv$iv3;
                            count$iv$iv2 = count$iv$iv4;
                            count$iv$iv3.add(node);
                            if (count$iv$iv3 != 0) {
                            }
                            stack$iv$iv = 0;
                            count$iv$iv3.add(node7);
                            i12 = i14;
                            int $i$f$mutableVectorOf = 16;
                            i5 = 0;
                            count$iv$iv4 = count$iv$iv2;
                            this_$iv = this_$iv3;
                            i13 = $i$f$mutableVectorOf;
                            count$iv$iv3 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                            this_$iv = this_$iv3;
                            this_$iv2 = node$iv$iv;
                            stack$iv$iv = node$iv$iv3;
                            this_$iv$iv$iv = 1;
                        }
                        node3 = node$iv$iv2;
                        if (count$iv$iv2 == 1) {
                        } else {
                        }
                        node$iv$iv2 = node3;
                        count$iv$iv = value;
                        node$iv$iv2 = node3;
                        this_$iv3 = this_$iv;
                        node = node$iv$iv$iv2;
                        i4 = 0;
                        i12 = 0;
                        if (kindSet$ui_release3 &= $i$f$getPointerInputOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        this_$iv = this_$iv3;
                        node$iv$iv3 = node;
                        this_$iv2 = node$iv$iv;
                        stack$iv$iv = node3;
                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                        node$iv$iv2 = stack$iv$iv;
                        node$iv$iv = this_$iv2;
                        this_$iv3 = this_$iv;
                        count$iv$iv2++;
                        node3 = node$iv$iv2;
                        if (count$iv$iv2 == 1) {
                        } else {
                        }
                        if (node$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv4 = count$iv$iv2;
                        this_$iv = this_$iv3;
                        capacity$iv$iv$iv$iv = 0;
                        count$iv$iv3 = node$iv$iv;
                        node7 = node3;
                        if (node7 != null) {
                        } else {
                        }
                        stack$iv$iv = node3;
                        if (count$iv$iv3 != 0) {
                        } else {
                        }
                        node$iv$iv3 = node;
                        this_$iv2 = count$iv$iv3;
                        count$iv$iv2 = count$iv$iv4;
                        count$iv$iv3.add(node);
                        if (count$iv$iv3 != 0) {
                        }
                        stack$iv$iv = 0;
                        count$iv$iv3.add(node7);
                        i12 = i14;
                        $i$f$mutableVectorOf = 16;
                        i5 = 0;
                        count$iv$iv4 = count$iv$iv2;
                        this_$iv = this_$iv3;
                        i13 = $i$f$mutableVectorOf;
                        count$iv$iv3 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        this_$iv = this_$iv3;
                        this_$iv2 = node$iv$iv;
                        stack$iv$iv = node$iv$iv3;
                        this_$iv$iv$iv = 1;
                        node$iv$iv4 = 1;
                        node$iv$iv4 = 0;
                        (PointerInputModifierNode)node$iv$iv2.onViewConfigurationChange();
                        this_$iv = this_$iv3;
                    }
                    this_$iv = this_$iv3;
                    if (node$iv$iv2 instanceof PointerInputModifierNode) {
                    } else {
                    }
                    count$iv$iv2 = node$iv$iv2;
                    i19 = 0;
                    node2 = count$iv$iv2;
                    if (kindSet$ui_release2 &= $i$f$getPointerInputOLwlOKw != 0) {
                    } else {
                    }
                    node$iv$iv4 = 0;
                    if (node$iv$iv4 != null && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv = this_$iv3;
                    node$iv$iv2 = DelegatableNodeKt.access$pop(node$iv$iv);
                    count$iv$iv = value;
                    this_$iv3 = this_$iv;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    node2 = 0;
                    node$iv$iv$iv2 = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv2 != null) {
                        node = node$iv$iv$iv2;
                        i4 = 0;
                        i12 = 0;
                        if (kindSet$ui_release3 &= $i$f$getPointerInputOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        this_$iv = this_$iv3;
                        node$iv$iv3 = node;
                        this_$iv2 = node$iv$iv;
                        stack$iv$iv = node3;
                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                        node$iv$iv2 = stack$iv$iv;
                        node$iv$iv = this_$iv2;
                        this_$iv3 = this_$iv;
                        count$iv$iv2++;
                        node3 = node$iv$iv2;
                        if (count$iv$iv2 == 1) {
                        } else {
                        }
                        if (node$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv4 = count$iv$iv2;
                        this_$iv = this_$iv3;
                        capacity$iv$iv$iv$iv = 0;
                        count$iv$iv3 = node$iv$iv;
                        node7 = node3;
                        if (node7 != null) {
                        } else {
                        }
                        stack$iv$iv = node3;
                        if (count$iv$iv3 != 0) {
                        } else {
                        }
                        node$iv$iv3 = node;
                        this_$iv2 = count$iv$iv3;
                        count$iv$iv2 = count$iv$iv4;
                        count$iv$iv3.add(node);
                        if (count$iv$iv3 != 0) {
                        }
                        stack$iv$iv = 0;
                        count$iv$iv3.add(node7);
                        i12 = i14;
                        $i$f$mutableVectorOf = 16;
                        i5 = 0;
                        count$iv$iv4 = count$iv$iv2;
                        this_$iv = this_$iv3;
                        i13 = $i$f$mutableVectorOf;
                        count$iv$iv3 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        this_$iv = this_$iv3;
                        this_$iv2 = node$iv$iv;
                        stack$iv$iv = node$iv$iv3;
                        this_$iv$iv$iv = 1;
                    }
                    node3 = node$iv$iv2;
                    if (count$iv$iv2 == 1) {
                    } else {
                    }
                    node$iv$iv2 = node3;
                    count$iv$iv = value;
                    node$iv$iv2 = node3;
                    this_$iv3 = this_$iv;
                    node = node$iv$iv$iv2;
                    i4 = 0;
                    i12 = 0;
                    if (kindSet$ui_release3 &= $i$f$getPointerInputOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    this_$iv = this_$iv3;
                    node$iv$iv3 = node;
                    this_$iv2 = node$iv$iv;
                    stack$iv$iv = node3;
                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                    node$iv$iv2 = stack$iv$iv;
                    node$iv$iv = this_$iv2;
                    this_$iv3 = this_$iv;
                    count$iv$iv2++;
                    node3 = node$iv$iv2;
                    if (count$iv$iv2 == 1) {
                    } else {
                    }
                    if (node$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv4 = count$iv$iv2;
                    this_$iv = this_$iv3;
                    capacity$iv$iv$iv$iv = 0;
                    count$iv$iv3 = node$iv$iv;
                    node7 = node3;
                    if (node7 != null) {
                    } else {
                    }
                    stack$iv$iv = node3;
                    if (count$iv$iv3 != 0) {
                    } else {
                    }
                    node$iv$iv3 = node;
                    this_$iv2 = count$iv$iv3;
                    count$iv$iv2 = count$iv$iv4;
                    count$iv$iv3.add(node);
                    if (count$iv$iv3 != 0) {
                    }
                    stack$iv$iv = 0;
                    count$iv$iv3.add(node7);
                    i12 = i14;
                    $i$f$mutableVectorOf = 16;
                    i5 = 0;
                    count$iv$iv4 = count$iv$iv2;
                    this_$iv = this_$iv3;
                    i13 = $i$f$mutableVectorOf;
                    count$iv$iv3 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    this_$iv = this_$iv3;
                    this_$iv2 = node$iv$iv;
                    stack$iv$iv = node$iv$iv3;
                    this_$iv$iv$iv = 1;
                    node$iv$iv4 = 1;
                    node$iv$iv4 = 0;
                    (PointerInputModifierNode)node$iv$iv2.onViewConfigurationChange();
                    this_$iv = this_$iv3;
                }
                this_$iv = this_$iv3;
            } else {
                this_$iv = this_$iv3;
            }
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void setVirtualLookaheadRoot$ui_release(boolean <set-?>) {
        this.isVirtualLookaheadRoot = <set-?>;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(JvmActuals_jvmKt.simpleIdentityToString(this, 0)).append(" children: ").append(getChildren$ui_release().size()).append(" measurePolicy: ").append(getMeasurePolicy()).toString();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void updateChildrenIfDirty$ui_release() {
        if (this.virtualChildrenCount > 0) {
            recreateUnfoldedChildrenIfDirty();
        }
    }
}
