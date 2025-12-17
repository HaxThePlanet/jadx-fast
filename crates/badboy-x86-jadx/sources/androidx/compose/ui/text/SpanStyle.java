package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextForegroundStyle.Companion;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnit.Companion;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008/\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0008\u0007\u0018\u00002\u00020\u0001B§\u0001\u0008\u0017\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cB³\u0001\u0008\u0017\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010\u001fB¿\u0001\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\u0008\u0002\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010\"BÉ\u0001\u0008\u0016\u0012\u0008\u0010#\u001a\u0004\u0018\u00010$\u0012\u0008\u0008\u0002\u0010%\u001a\u00020&\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\u0008\u0002\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010'B½\u0001\u0008\u0000\u0012\u0006\u0010(\u001a\u00020)\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\u0008\u0002\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010*JÒ\u0001\u0010O\u001a\u00020\u00002\u0008\u0010#\u001a\u0004\u0018\u00010$2\u0008\u0008\u0002\u0010%\u001a\u00020&2\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00052\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00032\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\u0008\u0002\u0010 \u001a\u0004\u0018\u00010!ø\u0001\u0000¢\u0006\u0004\u0008P\u0010QJ²\u0001\u0010O\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00052\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00032\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008R\u0010SJ¾\u0001\u0010O\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00052\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00032\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008T\u0010UJÈ\u0001\u0010O\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00052\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00032\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\u0008\u0002\u0010 \u001a\u0004\u0018\u00010!ø\u0001\u0000¢\u0006\u0004\u0008V\u0010WJ\u0013\u0010X\u001a\u00020Y2\u0008\u0010Z\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0015\u0010[\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u0000H\u0000¢\u0006\u0002\u0008\\J\u0015\u0010]\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u0000H\u0000¢\u0006\u0002\u0008^J\u0008\u0010_\u001a\u00020`H\u0016J\r\u0010a\u001a\u00020`H\u0000¢\u0006\u0002\u0008bJ\u0014\u0010c\u001a\u00020\u00002\n\u0008\u0002\u0010Z\u001a\u0004\u0018\u00010\u0000H\u0007J\u0011\u0010d\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020\u0000H\u0087\u0002J\u0008\u0010e\u001a\u00020\u000fH\u0016R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\u0008+\u0010,R\u0019\u0010\u0017\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010/\u001a\u0004\u0008-\u0010.R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u0012ø\u0001\u0000ø\u0001\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u00101R\u0013\u0010#\u001a\u0004\u0018\u00010$8F¢\u0006\u0006\u001a\u0004\u00082\u00103R\u0017\u0010\u0002\u001a\u00020\u00038Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u00084\u0010.R\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u00106R\u0013\u0010\u000c\u001a\u0004\u0018\u00010\r¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u00108R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010:R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010/\u001a\u0004\u0008;\u0010.R\u0019\u0010\u0008\u001a\u0004\u0018\u00010\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008<\u0010=R\u0019\u0010\n\u001a\u0004\u0018\u00010\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010?R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008@\u0010AR\u0019\u0010\u0010\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010/\u001a\u0004\u0008B\u0010.R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008C\u0010DR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008E\u0010FR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0008\n\u0000\u001a\u0004\u0008G\u0010HR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008I\u0010JR\u0014\u0010(\u001a\u00020)X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008K\u0010LR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008M\u0010N\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006f", d2 = {"Landroidx/compose/ui/text/SpanStyle;", "", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "platformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "textForegroundStyle", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "(Landroidx/compose/ui/text/style/TextForegroundStyle;JLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlpha", "()F", "getBackground-0d7_KjU", "()J", "J", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getColor-0d7_KjU", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "()Ljava/lang/String;", "getFontSize-XSAIIZE", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getLetterSpacing-XSAIIZE", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformSpanStyle;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getTextForegroundStyle$ui_text_release", "()Landroidx/compose/ui/text/style/TextForegroundStyle;", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "copy", "copy-NcG25M8", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "copy-IuqyXdg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;)Landroidx/compose/ui/text/SpanStyle;", "copy-2BkPm_w", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;)Landroidx/compose/ui/text/SpanStyle;", "copy-GSF8kmg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "equals", "", "other", "hasSameLayoutAffectingAttributes", "hasSameLayoutAffectingAttributes$ui_text_release", "hasSameNonLayoutAttributes", "hasSameNonLayoutAttributes$ui_text_release", "hashCode", "", "hashCodeLayoutAffectingAttributes", "hashCodeLayoutAffectingAttributes$ui_text_release", "merge", "plus", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SpanStyle {

    public static final int $stable;
    private final long background;
    private final BaselineShift baselineShift;
    private final DrawStyle drawStyle;
    private final FontFamily fontFamily;
    private final String fontFeatureSettings;
    private final long fontSize;
    private final FontStyle fontStyle;
    private final FontSynthesis fontSynthesis;
    private final FontWeight fontWeight;
    private final long letterSpacing;
    private final LocaleList localeList;
    private final androidx.compose.ui.text.PlatformSpanStyle platformStyle;
    private final Shadow shadow;
    private final TextDecoration textDecoration;
    private final TextForegroundStyle textForegroundStyle;
    private final TextGeometricTransform textGeometricTransform;
    static {
    }

    private SpanStyle(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow) {
        super(TextForegroundStyle.Companion.from-8_81llA(color), fontWeight, obj6, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, obj13, background, textDecoration, shadow, obj40, obj18, obj42, obj43, 0, 0, 32768, 0);
    }

    public SpanStyle(long l, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, int i15, DefaultConstructorMarker defaultConstructorMarker16) {
        int i4;
        long unspecified-0d7_KjU;
        long unspecified-XSAIIZE2;
        int i7;
        Color.Companion companion;
        int i6;
        int i5;
        int i2;
        int i;
        int i10;
        long unspecified-XSAIIZE;
        int i3;
        int i9;
        int i8;
        long unspecified-0d7_KjU2;
        int i11 = obj38;
        if (i11 & 1 != 0) {
            unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU = l;
        }
        if (i11 & 2 != 0) {
            unspecified-XSAIIZE2 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE2 = fontWeight3;
        }
        i7 = i11 & 4 != 0 ? 0 : fontSynthesis5;
        i5 = i11 & 8 != 0 ? 0 : fontFamily6;
        i2 = i11 & 16 != 0 ? 0 : string7;
        i = i11 & 32 != 0 ? 0 : l8;
        i10 = i11 & 64 != 0 ? 0 : baselineShift9;
        if (i11 & 128 != 0) {
            unspecified-XSAIIZE = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE = textGeometricTransform10;
        }
        i3 = i11 & 256 != 0 ? 0 : l12;
        i9 = i11 & 512 != 0 ? 0 : textDecoration13;
        i8 = i11 & 1024 != 0 ? 0 : shadow14;
        if (i11 & 2048 != 0) {
            unspecified-0d7_KjU2 = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU2 = i15;
        }
        i6 = i11 & 4096 != 0 ? 0 : obj36;
        i4 = i11 &= 8192 != 0 ? 0 : obj37;
        super(unspecified-0d7_KjU, fontWeight3, unspecified-XSAIIZE2, fontSynthesis5, i7, i5, i2, i, i10, unspecified-XSAIIZE, l12, i3, i9, i8, unspecified-0d7_KjU2, obj36, i6, i4, 0);
    }

    private SpanStyle(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, androidx.compose.ui.text.PlatformSpanStyle platformStyle) {
        super(TextForegroundStyle.Companion.from-8_81llA(color), fontWeight, obj6, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, obj13, background, textDecoration, shadow, platformStyle, obj18, obj42, obj43, obj44, 0, 32768, 0);
    }

    public SpanStyle(long l, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle15, int i16, DefaultConstructorMarker defaultConstructorMarker17) {
        int i9;
        long unspecified-0d7_KjU;
        int i5;
        long unspecified-XSAIIZE2;
        int i6;
        Color.Companion companion;
        int i3;
        int i7;
        int i10;
        int i;
        int i4;
        long unspecified-XSAIIZE;
        int i2;
        int i11;
        int i8;
        long unspecified-0d7_KjU2;
        int i12 = obj40;
        if (i12 & 1 != 0) {
            unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU = l;
        }
        if (i12 & 2 != 0) {
            unspecified-XSAIIZE2 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE2 = fontWeight3;
        }
        i6 = i12 & 4 != 0 ? 0 : fontSynthesis5;
        i7 = i12 & 8 != 0 ? 0 : fontFamily6;
        i10 = i12 & 16 != 0 ? 0 : string7;
        i = i12 & 32 != 0 ? 0 : l8;
        i4 = i12 & 64 != 0 ? 0 : baselineShift9;
        if (i12 & 128 != 0) {
            unspecified-XSAIIZE = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE = textGeometricTransform10;
        }
        i2 = i12 & 256 != 0 ? 0 : l12;
        i11 = i12 & 512 != 0 ? 0 : textDecoration13;
        i8 = i12 & 1024 != 0 ? 0 : shadow14;
        if (i12 & 2048 != 0) {
            unspecified-0d7_KjU2 = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU2 = platformSpanStyle15;
        }
        i3 = i12 & 4096 != 0 ? 0 : defaultConstructorMarker17;
        i5 = i12 & 8192 != 0 ? 0 : obj38;
        i9 = i12 &= 16384 != 0 ? 0 : obj39;
        super(unspecified-0d7_KjU, fontWeight3, unspecified-XSAIIZE2, fontSynthesis5, i6, i7, i10, i, i4, unspecified-XSAIIZE, l12, i2, i11, i8, unspecified-0d7_KjU2, defaultConstructorMarker17, i3, i5, i9, 0);
    }

    private SpanStyle(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, androidx.compose.ui.text.PlatformSpanStyle platformStyle, DrawStyle drawStyle) {
        super(TextForegroundStyle.Companion.from-8_81llA(color), fontWeight, obj6, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, obj13, background, textDecoration, shadow, platformStyle, obj18, obj41, obj42, obj43, obj44, 0);
    }

    public SpanStyle(long l, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle15, DrawStyle drawStyle16, int i17, DefaultConstructorMarker defaultConstructorMarker18) {
        int i10;
        long unspecified-0d7_KjU2;
        int i9;
        int i2;
        long unspecified-XSAIIZE;
        int i4;
        Color.Companion companion;
        int i11;
        int i;
        int i6;
        int i3;
        int i5;
        long unspecified-XSAIIZE2;
        int i8;
        int i7;
        int i12;
        long unspecified-0d7_KjU;
        int i13 = obj42;
        if (i13 & 1 != 0) {
            unspecified-0d7_KjU2 = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU2 = l;
        }
        if (i13 & 2 != 0) {
            unspecified-XSAIIZE = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE = fontWeight3;
        }
        i4 = i13 & 4 != 0 ? 0 : fontSynthesis5;
        i = i13 & 8 != 0 ? 0 : fontFamily6;
        i6 = i13 & 16 != 0 ? 0 : string7;
        i3 = i13 & 32 != 0 ? 0 : l8;
        i5 = i13 & 64 != 0 ? 0 : baselineShift9;
        if (i13 & 128 != 0) {
            unspecified-XSAIIZE2 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE2 = textGeometricTransform10;
        }
        i8 = i13 & 256 != 0 ? 0 : l12;
        i7 = i13 & 512 != 0 ? 0 : textDecoration13;
        i12 = i13 & 1024 != 0 ? 0 : shadow14;
        if (i13 & 2048 != 0) {
            unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU = platformSpanStyle15;
        }
        i11 = i13 & 4096 != 0 ? 0 : i17;
        i9 = i13 & 8192 != 0 ? 0 : defaultConstructorMarker18;
        i2 = i13 & 16384 != 0 ? 0 : obj40;
        i10 = i13 &= i30 != 0 ? 0 : obj41;
        super(unspecified-0d7_KjU2, fontWeight3, unspecified-XSAIIZE, fontSynthesis5, i4, i, i6, i3, i5, unspecified-XSAIIZE2, l12, i8, i7, i12, unspecified-0d7_KjU, i17, i11, i9, i2, i10, 0);
    }

    public SpanStyle(long l, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle15, DrawStyle drawStyle16, DefaultConstructorMarker defaultConstructorMarker17) {
        super(l, l2, fontWeight3, fontStyle4, fontSynthesis5, fontFamily6, string7, l8, baselineShift9, textGeometricTransform10, localeList11, l12, textDecoration13, shadow14, platformSpanStyle15, drawStyle16, defaultConstructorMarker17, obj18, obj19, obj20);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "SpanStyle constructors that do not take new stable parameters like PlatformStyle, DrawStyle are deprecated. Please use the new stable constructor.")
    public SpanStyle(long l, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle15, DefaultConstructorMarker defaultConstructorMarker16) {
        super(l, l2, fontWeight3, fontStyle4, fontSynthesis5, fontFamily6, string7, l8, baselineShift9, textGeometricTransform10, localeList11, l12, textDecoration13, shadow14, platformSpanStyle15, defaultConstructorMarker16, obj17, obj18, obj19);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "SpanStyle constructors that do not take new stable parameters like PlatformStyle, DrawStyle are deprecated. Please use the new stable constructor.")
    public SpanStyle(long l, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, DefaultConstructorMarker defaultConstructorMarker15) {
        super(l, l2, fontWeight3, fontStyle4, fontSynthesis5, fontFamily6, string7, l8, baselineShift9, textGeometricTransform10, localeList11, l12, textDecoration13, shadow14, defaultConstructorMarker15, obj16, obj17, obj18);
    }

    private SpanStyle(Brush brush, float alpha, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, androidx.compose.ui.text.PlatformSpanStyle platformStyle, DrawStyle drawStyle) {
        super(TextForegroundStyle.Companion.from(brush, alpha), fontSize, obj6, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, obj13, localeList, background, textDecoration, shadow, obj18, drawStyle, obj42, obj43, obj44, 0);
    }

    public SpanStyle(Brush brush, float f2, long l3, FontWeight fontWeight4, FontStyle fontStyle5, FontSynthesis fontSynthesis6, FontFamily fontFamily7, String string8, long l9, BaselineShift baselineShift10, TextGeometricTransform textGeometricTransform11, LocaleList localeList12, long l13, TextDecoration textDecoration14, Shadow shadow15, androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle16, DrawStyle drawStyle17, int i18, DefaultConstructorMarker defaultConstructorMarker19) {
        int i8;
        int unspecified-XSAIIZE2;
        TextUnit.Companion companion2;
        Color.Companion companion;
        int i7;
        long l;
        int i3;
        int i5;
        int i11;
        int i13;
        int i14;
        long unspecified-XSAIIZE;
        int i9;
        int i10;
        int i12;
        long unspecified-0d7_KjU;
        int i2;
        int i4;
        int i6;
        int i;
        int i15 = obj45;
        i7 = i15 & 2 != 0 ? i8 : f2;
        if (i15 & 4 != 0) {
            l = unspecified-XSAIIZE2;
        } else {
            l = l3;
        }
        int i31 = 0;
        i3 = i15 & 8 != 0 ? i31 : fontStyle5;
        i5 = i15 & 16 != 0 ? i31 : fontSynthesis6;
        i11 = i15 & 32 != 0 ? i31 : fontFamily7;
        i13 = i15 & 64 != 0 ? i31 : string8;
        i14 = i15 & 128 != 0 ? i31 : l9;
        if (i15 & 256 != 0) {
            unspecified-XSAIIZE = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE = baselineShift10;
        }
        i9 = i15 & 512 != 0 ? i31 : localeList12;
        i10 = i15 & 1024 != 0 ? i31 : l13;
        i12 = i15 & 2048 != 0 ? i31 : textDecoration14;
        if (i15 & 4096 != 0) {
            unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU = shadow15;
        }
        i2 = i15 & 8192 != 0 ? i31 : drawStyle17;
        i4 = i15 & 16384 != 0 ? i31 : i18;
        i6 = i28 &= i15 != 0 ? i31 : defaultConstructorMarker19;
        i = i15 &= i30 != 0 ? i31 : obj44;
        super(brush, i7, l, obj6, i3, i5, i11, i13, i14, unspecified-XSAIIZE, obj13, i9, i10, i12, unspecified-0d7_KjU, obj18, i2, i4, i6, i, 0);
    }

    public SpanStyle(Brush brush, float f2, long l3, FontWeight fontWeight4, FontStyle fontStyle5, FontSynthesis fontSynthesis6, FontFamily fontFamily7, String string8, long l9, BaselineShift baselineShift10, TextGeometricTransform textGeometricTransform11, LocaleList localeList12, long l13, TextDecoration textDecoration14, Shadow shadow15, androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle16, DrawStyle drawStyle17, DefaultConstructorMarker defaultConstructorMarker18) {
        super(brush, f2, l3, fontWeight4, fontStyle5, fontSynthesis6, fontFamily7, string8, l9, baselineShift10, textGeometricTransform11, localeList12, l13, textDecoration14, shadow15, platformSpanStyle16, drawStyle17, defaultConstructorMarker18, obj19, obj20);
    }

    private SpanStyle(TextForegroundStyle textForegroundStyle, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, androidx.compose.ui.text.PlatformSpanStyle platformStyle, DrawStyle drawStyle) {
        final Object obj = this;
        super();
        obj.textForegroundStyle = textForegroundStyle;
        obj.fontSize = fontSize;
        obj.fontWeight = fontStyle;
        obj.fontStyle = fontSynthesis;
        obj.fontSynthesis = fontFamily;
        obj.fontFamily = fontFeatureSettings;
        obj.fontFeatureSettings = letterSpacing;
        obj.letterSpacing = baselineShift;
        obj.baselineShift = localeList;
        obj.textGeometricTransform = background;
        obj.localeList = textDecoration;
        obj.background = shadow;
        obj.textDecoration = drawStyle;
        obj.shadow = obj33;
        obj.platformStyle = obj34;
        obj.drawStyle = obj35;
    }

    public SpanStyle(TextForegroundStyle textForegroundStyle, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle15, DrawStyle drawStyle16, int i17, DefaultConstructorMarker defaultConstructorMarker18) {
        int unspecified-XSAIIZE;
        int companion2;
        Color.Companion companion;
        long unspecified-0d7_KjU;
        long l;
        int i11;
        int i10;
        int i6;
        int i12;
        int i7;
        long l3;
        int i8;
        int i9;
        int i4;
        long l4;
        int i2;
        int i5;
        int i;
        int i3;
        int i13 = obj44;
        if (i13 & 2 != 0) {
            l = unspecified-XSAIIZE;
        } else {
            l = l2;
        }
        final int i28 = 0;
        i11 = i13 & 4 != 0 ? i28 : fontStyle4;
        i10 = i13 & 8 != 0 ? i28 : fontSynthesis5;
        i6 = i13 & 16 != 0 ? i28 : fontFamily6;
        i12 = i13 & 32 != 0 ? i28 : string7;
        i7 = i13 & 64 != 0 ? i28 : l8;
        if (i13 & 128 != 0) {
            l3 = unspecified-0d7_KjU;
        } else {
            l3 = baselineShift9;
        }
        i8 = i13 & 256 != 0 ? i28 : localeList11;
        i9 = i13 & 512 != 0 ? i28 : l12;
        i4 = i13 & 1024 != 0 ? i28 : textDecoration13;
        if (i13 & 2048 != 0) {
            l4 = unspecified-0d7_KjU;
        } else {
            l4 = shadow14;
        }
        i2 = i13 & 4096 != 0 ? i28 : drawStyle16;
        i5 = i13 & 8192 != 0 ? i28 : i17;
        i = i13 & 16384 != 0 ? i28 : defaultConstructorMarker18;
        i3 = i13 &= i27 != 0 ? i28 : obj43;
        super(textForegroundStyle, l, obj6, i11, i10, i6, i12, i7, l3, obj13, i8, i9, i4, l4, obj18, i2, i5, i, i3, 0);
    }

    public SpanStyle(TextForegroundStyle textForegroundStyle, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle15, DrawStyle drawStyle16, DefaultConstructorMarker defaultConstructorMarker17) {
        super(textForegroundStyle, l2, fontWeight3, fontStyle4, fontSynthesis5, fontFamily6, string7, l8, baselineShift9, textGeometricTransform10, localeList11, l12, textDecoration13, shadow14, platformSpanStyle15, drawStyle16, defaultConstructorMarker17, obj18, obj19);
    }

    public static androidx.compose.ui.text.SpanStyle copy-2BkPm_w$default(androidx.compose.ui.text.SpanStyle spanStyle, long l2, long l3, FontWeight fontWeight4, FontStyle fontStyle5, FontSynthesis fontSynthesis6, FontFamily fontFamily7, String string8, long l9, BaselineShift baselineShift10, TextGeometricTransform textGeometricTransform11, LocaleList localeList12, long l13, TextDecoration textDecoration14, Shadow shadow15, androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle16, int i17, Object object18) {
        androidx.compose.ui.text.PlatformSpanStyle platformStyle;
        long color-0d7_KjU;
        long background;
        TextDecoration textDecoration;
        Shadow shadow;
        long fontSize;
        Object fontWeight;
        FontStyle fontStyle;
        FontSynthesis fontSynthesis;
        FontFamily fontFamily;
        String fontFeatureSettings;
        long letterSpacing;
        BaselineShift baselineShift;
        TextGeometricTransform textGeometricTransform;
        LocaleList localeList;
        Object obj = spanStyle;
        int i = obj38;
        if (i & 1 != 0) {
            color-0d7_KjU = obj.getColor-0d7_KjU();
        } else {
            color-0d7_KjU = l2;
        }
        fontSize = i & 2 != 0 ? obj.fontSize : fontWeight4;
        fontWeight = i & 4 != 0 ? obj.fontWeight : fontSynthesis6;
        fontStyle = i & 8 != 0 ? obj.fontStyle : fontFamily7;
        fontSynthesis = i & 16 != 0 ? obj.fontSynthesis : string8;
        fontFamily = i & 32 != 0 ? obj.fontFamily : l9;
        fontFeatureSettings = i & 64 != 0 ? obj.fontFeatureSettings : baselineShift10;
        letterSpacing = i & 128 != 0 ? obj.letterSpacing : textGeometricTransform11;
        baselineShift = i & 256 != 0 ? obj.baselineShift : l13;
        textGeometricTransform = i & 512 != 0 ? obj.textGeometricTransform : textDecoration14;
        localeList = i & 1024 != 0 ? obj.localeList : shadow15;
        background = i & 2048 != 0 ? obj.background : platformSpanStyle16;
        textDecoration = i & 4096 != 0 ? obj.textDecoration : object18;
        shadow = i & 8192 != 0 ? obj.shadow : obj36;
        platformStyle = i &= 16384 != 0 ? obj.platformStyle : obj37;
        return obj.copy-2BkPm_w(color-0d7_KjU, fontWeight4, fontSize, fontSynthesis6, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, l13, baselineShift, textGeometricTransform, localeList, background);
    }

    public static androidx.compose.ui.text.SpanStyle copy-GSF8kmg$default(androidx.compose.ui.text.SpanStyle spanStyle, long l2, long l3, FontWeight fontWeight4, FontStyle fontStyle5, FontSynthesis fontSynthesis6, FontFamily fontFamily7, String string8, long l9, BaselineShift baselineShift10, TextGeometricTransform textGeometricTransform11, LocaleList localeList12, long l13, TextDecoration textDecoration14, Shadow shadow15, androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle16, DrawStyle drawStyle17, int i18, Object object19) {
        DrawStyle drawStyle;
        long color-0d7_KjU;
        long background;
        TextDecoration textDecoration;
        androidx.compose.ui.text.PlatformSpanStyle platformStyle;
        Shadow shadow;
        long fontSize;
        Object fontWeight;
        FontStyle fontStyle;
        FontSynthesis fontSynthesis;
        FontFamily fontFamily;
        String fontFeatureSettings;
        long letterSpacing;
        BaselineShift baselineShift;
        TextGeometricTransform textGeometricTransform;
        LocaleList localeList;
        Object obj = spanStyle;
        int i = obj40;
        if (i & 1 != 0) {
            color-0d7_KjU = obj.getColor-0d7_KjU();
        } else {
            color-0d7_KjU = l2;
        }
        fontSize = i & 2 != 0 ? obj.fontSize : fontWeight4;
        fontWeight = i & 4 != 0 ? obj.fontWeight : fontSynthesis6;
        fontStyle = i & 8 != 0 ? obj.fontStyle : fontFamily7;
        fontSynthesis = i & 16 != 0 ? obj.fontSynthesis : string8;
        fontFamily = i & 32 != 0 ? obj.fontFamily : l9;
        fontFeatureSettings = i & 64 != 0 ? obj.fontFeatureSettings : baselineShift10;
        letterSpacing = i & 128 != 0 ? obj.letterSpacing : textGeometricTransform11;
        baselineShift = i & 256 != 0 ? obj.baselineShift : l13;
        textGeometricTransform = i & 512 != 0 ? obj.textGeometricTransform : textDecoration14;
        localeList = i & 1024 != 0 ? obj.localeList : shadow15;
        background = i & 2048 != 0 ? obj.background : platformSpanStyle16;
        textDecoration = i & 4096 != 0 ? obj.textDecoration : i18;
        shadow = i & 8192 != 0 ? obj.shadow : object19;
        final TextDecoration obj22 = textDecoration;
        platformStyle = i & 16384 != 0 ? obj.platformStyle : obj38;
        drawStyle = i &= i19 != 0 ? obj.drawStyle : obj39;
        return obj.copy-GSF8kmg(color-0d7_KjU, obj22, fontSize, fontSynthesis6, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, l13, baselineShift, textGeometricTransform, localeList, background, i18);
    }

    public static androidx.compose.ui.text.SpanStyle copy-IuqyXdg$default(androidx.compose.ui.text.SpanStyle spanStyle, long l2, long l3, FontWeight fontWeight4, FontStyle fontStyle5, FontSynthesis fontSynthesis6, FontFamily fontFamily7, String string8, long l9, BaselineShift baselineShift10, TextGeometricTransform textGeometricTransform11, LocaleList localeList12, long l13, TextDecoration textDecoration14, Shadow shadow15, int i16, Object object17) {
        Shadow shadow;
        long color-0d7_KjU;
        long background;
        TextDecoration textDecoration;
        long fontSize;
        Object fontWeight;
        FontStyle fontStyle;
        FontSynthesis fontSynthesis;
        FontFamily fontFamily;
        String fontFeatureSettings;
        long letterSpacing;
        BaselineShift baselineShift;
        TextGeometricTransform textGeometricTransform;
        LocaleList localeList;
        Object obj = spanStyle;
        int i = obj37;
        if (i & 1 != 0) {
            color-0d7_KjU = obj.getColor-0d7_KjU();
        } else {
            color-0d7_KjU = l2;
        }
        fontSize = i & 2 != 0 ? obj.fontSize : fontWeight4;
        fontWeight = i & 4 != 0 ? obj.fontWeight : fontSynthesis6;
        fontStyle = i & 8 != 0 ? obj.fontStyle : fontFamily7;
        fontSynthesis = i & 16 != 0 ? obj.fontSynthesis : string8;
        fontFamily = i & 32 != 0 ? obj.fontFamily : l9;
        fontFeatureSettings = i & 64 != 0 ? obj.fontFeatureSettings : baselineShift10;
        letterSpacing = i & 128 != 0 ? obj.letterSpacing : textGeometricTransform11;
        baselineShift = i & 256 != 0 ? obj.baselineShift : l13;
        textGeometricTransform = i & 512 != 0 ? obj.textGeometricTransform : textDecoration14;
        localeList = i & 1024 != 0 ? obj.localeList : shadow15;
        background = i & 2048 != 0 ? obj.background : i16;
        textDecoration = i & 4096 != 0 ? obj.textDecoration : obj35;
        shadow = i &= 8192 != 0 ? obj.shadow : obj36;
        return obj.copy-IuqyXdg(color-0d7_KjU, fontWeight4, fontSize, fontSynthesis6, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, l13, baselineShift, textGeometricTransform, localeList);
    }

    public static androidx.compose.ui.text.SpanStyle copy-NcG25M8$default(androidx.compose.ui.text.SpanStyle spanStyle, Brush brush2, float f3, long l4, FontWeight fontWeight5, FontStyle fontStyle6, FontSynthesis fontSynthesis7, FontFamily fontFamily8, String string9, long l10, BaselineShift baselineShift11, TextGeometricTransform textGeometricTransform12, LocaleList localeList13, long l14, TextDecoration textDecoration15, Shadow shadow16, androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle17, DrawStyle drawStyle18, int i19, Object object20) {
        androidx.compose.ui.text.PlatformSpanStyle platformStyle;
        DrawStyle drawStyle;
        float alpha;
        long background;
        long fontSize;
        TextDecoration textDecoration;
        FontWeight fontWeight;
        Object fontStyle;
        FontSynthesis fontSynthesis;
        FontFamily fontFamily;
        String fontFeatureSettings;
        long letterSpacing;
        BaselineShift baselineShift;
        TextGeometricTransform textGeometricTransform;
        LocaleList localeList;
        Shadow shadow;
        float obj19;
        long obj20;
        androidx.compose.ui.text.PlatformSpanStyle obj22;
        Object obj = spanStyle;
        int i = obj38;
        if (i & 2 != 0) {
            alpha = obj.getAlpha();
        } else {
            alpha = f3;
        }
        fontSize = i & 4 != 0 ? obj.fontSize : l4;
        fontWeight = i & 8 != 0 ? obj.fontWeight : fontStyle6;
        fontStyle = i & 16 != 0 ? obj.fontStyle : fontSynthesis7;
        fontSynthesis = i & 32 != 0 ? obj.fontSynthesis : fontFamily8;
        fontFamily = i & 64 != 0 ? obj.fontFamily : string9;
        fontFeatureSettings = i & 128 != 0 ? obj.fontFeatureSettings : l10;
        letterSpacing = i & 256 != 0 ? obj.letterSpacing : baselineShift11;
        baselineShift = i & 512 != 0 ? obj.baselineShift : localeList13;
        textGeometricTransform = i & 1024 != 0 ? obj.textGeometricTransform : l14;
        localeList = i & 2048 != 0 ? obj.localeList : textDecoration15;
        if (i & 4096 != 0) {
            obj19 = alpha;
            obj20 = fontSize;
            background = obj.background;
        } else {
            obj19 = alpha;
            obj20 = fontSize;
            background = shadow16;
        }
        textDecoration = i & 8192 != 0 ? obj.textDecoration : drawStyle18;
        shadow = i & 16384 != 0 ? obj.shadow : i19;
        platformStyle = i & i16 != 0 ? obj.platformStyle : object20;
        drawStyle = obj38 & i18 != 0 ? obj.drawStyle : obj37;
        return obj.copy-NcG25M8(brush2, obj19, obj20, fontSynthesis7, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, l14, baselineShift, textGeometricTransform, localeList, background, i19, textDecoration);
    }

    public static androidx.compose.ui.text.SpanStyle merge$default(androidx.compose.ui.text.SpanStyle spanStyle, androidx.compose.ui.text.SpanStyle spanStyle2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return spanStyle.merge(obj1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "SpanStyle copy constructors that do not take new stable parameters like PlatformStyle, DrawStyle are deprecated. Please use the new stable copy constructor.")
    public final androidx.compose.ui.text.SpanStyle copy-2BkPm_w(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, androidx.compose.ui.text.PlatformSpanStyle platformStyle) {
        Object obj;
        TextForegroundStyle textForegroundStyle;
        final long l = color;
        if (Color.equals-impl0(l, obj1)) {
            textForegroundStyle = obj.textForegroundStyle;
        } else {
            obj = this;
            textForegroundStyle = TextForegroundStyle.Companion.from-8_81llA(l);
        }
        SpanStyle spanStyle = new SpanStyle(textForegroundStyle, fontWeight, obj5, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, obj12, background, textDecoration, shadow, platformStyle, obj17, obj41, obj42, obj43, 0, 32768, 0);
        return spanStyle;
    }

    public final androidx.compose.ui.text.SpanStyle copy-GSF8kmg(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, androidx.compose.ui.text.PlatformSpanStyle platformStyle, DrawStyle drawStyle) {
        Object obj;
        TextForegroundStyle textForegroundStyle;
        final long l = color;
        if (Color.equals-impl0(l, obj1)) {
            textForegroundStyle = obj.textForegroundStyle;
        } else {
            obj = this;
            textForegroundStyle = TextForegroundStyle.Companion.from-8_81llA(l);
        }
        SpanStyle spanStyle = new SpanStyle(textForegroundStyle, fontWeight, obj5, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, obj12, background, textDecoration, shadow, platformStyle, obj17, obj40, obj41, obj42, obj43, 0);
        return spanStyle;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "SpanStyle copy constructors that do not take new stable parameters like PlatformStyle, DrawStyle are deprecated. Please use the new stable copy constructor.")
    public final androidx.compose.ui.text.SpanStyle copy-IuqyXdg(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow) {
        TextForegroundStyle textForegroundStyle;
        final Object obj = this;
        final long l = color;
        if (Color.equals-impl0(l, obj2)) {
            textForegroundStyle = obj.textForegroundStyle;
        } else {
            textForegroundStyle = TextForegroundStyle.Companion.from-8_81llA(l);
        }
        final DrawStyle drawStyle = obj.drawStyle;
        SpanStyle spanStyle = new SpanStyle(textForegroundStyle, fontWeight, drawStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, obj13, background, textDecoration, shadow, obj39, obj18, obj41, obj42, obj.platformStyle, drawStyle, 0);
        return spanStyle;
    }

    public final androidx.compose.ui.text.SpanStyle copy-NcG25M8(Brush brush, float alpha, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, androidx.compose.ui.text.PlatformSpanStyle platformStyle, DrawStyle drawStyle) {
        final float f = alpha;
        SpanStyle spanStyle = new SpanStyle(TextForegroundStyle.Companion.from(brush, f), fontSize, f, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, obj10, localeList, background, textDecoration, shadow, obj15, drawStyle, obj39, obj40, obj41, 0);
        return spanStyle;
    }

    public boolean equals(Object other) {
        int i;
        boolean sameLayoutAffectingAttributes$ui_text_release;
        if (this == other) {
            return 1;
        }
        final int i2 = 0;
        if (!other instanceof SpanStyle) {
            return i2;
        }
        if (hasSameLayoutAffectingAttributes$ui_text_release((SpanStyle)other) && hasSameNonLayoutAttributes$ui_text_release((SpanStyle)other)) {
            if (hasSameNonLayoutAttributes$ui_text_release((SpanStyle)other)) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    public final float getAlpha() {
        return this.textForegroundStyle.getAlpha();
    }

    public final long getBackground-0d7_KjU() {
        return this.background;
    }

    public final BaselineShift getBaselineShift-5SSeXJ0() {
        return this.baselineShift;
    }

    public final Brush getBrush() {
        return this.textForegroundStyle.getBrush();
    }

    public final long getColor-0d7_KjU() {
        return this.textForegroundStyle.getColor-0d7_KjU();
    }

    public final DrawStyle getDrawStyle() {
        return this.drawStyle;
    }

    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    public final long getFontSize-XSAIIZE() {
        return this.fontSize;
    }

    public final FontStyle getFontStyle-4Lr2A7w() {
        return this.fontStyle;
    }

    public final FontSynthesis getFontSynthesis-ZQGJjVo() {
        return this.fontSynthesis;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final long getLetterSpacing-XSAIIZE() {
        return this.letterSpacing;
    }

    public final LocaleList getLocaleList() {
        return this.localeList;
    }

    public final androidx.compose.ui.text.PlatformSpanStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public final Shadow getShadow() {
        return this.shadow;
    }

    public final TextDecoration getTextDecoration() {
        return this.textDecoration;
    }

    public final TextForegroundStyle getTextForegroundStyle$ui_text_release() {
        return this.textForegroundStyle;
    }

    public final TextGeometricTransform getTextGeometricTransform() {
        return this.textGeometricTransform;
    }

    public final boolean hasSameLayoutAffectingAttributes$ui_text_release(androidx.compose.ui.text.SpanStyle other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!TextUnit.equals-impl0(this.fontSize, obj2)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.fontWeight, other.fontWeight)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.fontStyle, other.fontStyle)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.fontSynthesis, other.fontSynthesis)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.fontFamily, other.fontFamily)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.fontFeatureSettings, other.fontFeatureSettings)) {
            return i2;
        }
        if (!TextUnit.equals-impl0(this.letterSpacing, obj4)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.baselineShift, other.baselineShift)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.textGeometricTransform, other.textGeometricTransform)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.localeList, other.localeList)) {
            return i2;
        }
        if (!Color.equals-impl0(this.background, obj4)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.platformStyle, other.platformStyle)) {
            return i2;
        }
        return i;
    }

    public final boolean hasSameNonLayoutAttributes$ui_text_release(androidx.compose.ui.text.SpanStyle other) {
        int i2 = 0;
        if (!Intrinsics.areEqual(this.textForegroundStyle, other.textForegroundStyle)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.textDecoration, other.textDecoration)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.shadow, other.shadow)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.drawStyle, other.drawStyle)) {
            return i2;
        }
        return 1;
    }

    public int hashCode() {
        int i10;
        int i9;
        int i11;
        int i12;
        int i;
        int i13;
        int i4;
        int i2;
        int i7;
        int i3;
        int i5;
        int i6;
        int i8;
        Brush brush = getBrush();
        i8 = 0;
        if (brush != null) {
            i10 = brush.hashCode();
        } else {
            i10 = i8;
        }
        FontWeight fontWeight = this.fontWeight;
        if (fontWeight != null) {
            i9 = fontWeight.hashCode();
        } else {
            i9 = i8;
        }
        FontStyle fontStyle = this.fontStyle;
        if (fontStyle != null) {
            i11 = FontStyle.hashCode-impl(fontStyle.unbox-impl());
        } else {
            i11 = i8;
        }
        FontSynthesis fontSynthesis = this.fontSynthesis;
        if (fontSynthesis != null) {
            i12 = FontSynthesis.hashCode-impl(fontSynthesis.unbox-impl());
        } else {
            i12 = i8;
        }
        FontFamily fontFamily = this.fontFamily;
        if (fontFamily != null) {
            i = fontFamily.hashCode();
        } else {
            i = i8;
        }
        String fontFeatureSettings = this.fontFeatureSettings;
        if (fontFeatureSettings != null) {
            i13 = fontFeatureSettings.hashCode();
        } else {
            i13 = i8;
        }
        BaselineShift baselineShift = this.baselineShift;
        if (baselineShift != null) {
            i4 = BaselineShift.hashCode-impl(baselineShift.unbox-impl());
        } else {
            i4 = i8;
        }
        TextGeometricTransform textGeometricTransform = this.textGeometricTransform;
        if (textGeometricTransform != null) {
            i2 = textGeometricTransform.hashCode();
        } else {
            i2 = i8;
        }
        LocaleList localeList = this.localeList;
        if (localeList != null) {
            i7 = localeList.hashCode();
        } else {
            i7 = i8;
        }
        TextDecoration textDecoration = this.textDecoration;
        if (textDecoration != null) {
            i3 = textDecoration.hashCode();
        } else {
            i3 = i8;
        }
        Shadow shadow = this.shadow;
        if (shadow != null) {
            i5 = shadow.hashCode();
        } else {
            i5 = i8;
        }
        androidx.compose.ui.text.PlatformSpanStyle platformStyle = this.platformStyle;
        if (platformStyle != null) {
            i6 = platformStyle.hashCode();
        } else {
            i6 = i8;
        }
        DrawStyle drawStyle = this.drawStyle;
        if (drawStyle != null) {
            i8 = drawStyle.hashCode();
        }
        return result16 += i8;
    }

    public final int hashCodeLayoutAffectingAttributes$ui_text_release() {
        int i5;
        int i6;
        int i2;
        int i;
        int i3;
        int i9;
        int i7;
        int i4;
        int i8;
        FontWeight fontWeight = this.fontWeight;
        i8 = 0;
        if (fontWeight != null) {
            i5 = fontWeight.hashCode();
        } else {
            i5 = i8;
        }
        FontStyle fontStyle = this.fontStyle;
        if (fontStyle != null) {
            i6 = FontStyle.hashCode-impl(fontStyle.unbox-impl());
        } else {
            i6 = i8;
        }
        FontSynthesis fontSynthesis = this.fontSynthesis;
        if (fontSynthesis != null) {
            i2 = FontSynthesis.hashCode-impl(fontSynthesis.unbox-impl());
        } else {
            i2 = i8;
        }
        FontFamily fontFamily = this.fontFamily;
        if (fontFamily != null) {
            i = fontFamily.hashCode();
        } else {
            i = i8;
        }
        String fontFeatureSettings = this.fontFeatureSettings;
        if (fontFeatureSettings != null) {
            i3 = fontFeatureSettings.hashCode();
        } else {
            i3 = i8;
        }
        BaselineShift baselineShift = this.baselineShift;
        if (baselineShift != null) {
            i9 = BaselineShift.hashCode-impl(baselineShift.unbox-impl());
        } else {
            i9 = i8;
        }
        TextGeometricTransform textGeometricTransform = this.textGeometricTransform;
        if (textGeometricTransform != null) {
            i7 = textGeometricTransform.hashCode();
        } else {
            i7 = i8;
        }
        LocaleList localeList = this.localeList;
        if (localeList != null) {
            i4 = localeList.hashCode();
        } else {
            i4 = i8;
        }
        androidx.compose.ui.text.PlatformSpanStyle platformStyle = this.platformStyle;
        if (platformStyle != null) {
            i8 = platformStyle.hashCode();
        }
        return result10 += i8;
    }

    public final androidx.compose.ui.text.SpanStyle merge(androidx.compose.ui.text.SpanStyle other) {
        final Object obj = other;
        if (obj == null) {
            return this;
        }
        return SpanStyleKt.fastMerge-dSHsh3o(this, obj.textForegroundStyle.getColor-0d7_KjU(), obj4, obj.textForegroundStyle.getBrush(), obj.textForegroundStyle.getAlpha(), obj.fontSize, obj8, obj.fontWeight, obj.fontStyle, obj.fontSynthesis, obj.fontFamily, obj.fontFeatureSettings, obj.letterSpacing, obj15, obj.baselineShift, obj.textGeometricTransform, obj.localeList, obj.background, obj20);
    }

    public final androidx.compose.ui.text.SpanStyle plus(androidx.compose.ui.text.SpanStyle other) {
        return merge(other);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SpanStyle(color=").append(Color.toString-impl(getColor-0d7_KjU())).append(", brush=").append(getBrush()).append(", alpha=").append(getAlpha()).append(", fontSize=").append(TextUnit.toString-impl(this.fontSize)).append(", fontWeight=").append(this.fontWeight).append(", fontStyle=").append(this.fontStyle).append(", fontSynthesis=").append(this.fontSynthesis).append(", fontFamily=").append(this.fontFamily).append(", fontFeatureSettings=").append(this.fontFeatureSettings).append(", letterSpacing=").append(TextUnit.toString-impl(this.letterSpacing)).append(", baselineShift=").append(this.baselineShift).append(", textGeometricTransform=");
        stringBuilder.append(this.textGeometricTransform).append(", localeList=").append(this.localeList).append(", background=").append(Color.toString-impl(this.background)).append(", textDecoration=").append(this.textDecoration).append(", shadow=").append(this.shadow).append(", platformStyle=").append(this.platformStyle).append(", drawStyle=").append(this.drawStyle).append(')');
        return stringBuilder.toString();
    }
}
