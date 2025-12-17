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
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.Hyphens.Companion;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineBreak.Companion;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextAlign.Companion;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextDirection.Companion;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextForegroundStyle.Companion;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnit.Companion;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008U\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\r\u0008\u0007\u0018\u0000 £\u00012\u00020\u0001:\u0002£\u0001B\u0017\u0008\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006BÕ\u0001\u0008\u0017\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0008\u0012\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\u0008\u0008\u0002\u0010%\u001a\u00020\n\u0012\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'¢\u0006\u0002\u0010(Bí\u0001\u0008\u0017\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0008\u0012\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\u0008\u0008\u0002\u0010%\u001a\u00020\n\u0012\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010,¢\u0006\u0002\u0010-B\u0085\u0002\u0008\u0017\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0008\u0012\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\u0008\u0008\u0002\u0010%\u001a\u00020\n\u0012\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\u0008\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\u0008\u0002\u00100\u001a\u0004\u0018\u000101¢\u0006\u0002\u00102B\u009d\u0002\u0008\u0017\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0008\u0012\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\u0008\u0002\u00103\u001a\u0004\u0018\u000104\u0012\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\u0008\u0008\u0002\u0010%\u001a\u00020\n\u0012\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\u0008\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\u0008\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\u0008\u0002\u00105\u001a\u0004\u0018\u000106¢\u0006\u0002\u00107B\u0095\u0002\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0008\u0012\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\u0008\u0002\u00103\u001a\u0004\u0018\u000104\u0012\u0008\u0008\u0002\u0010!\u001a\u00020\"\u0012\u0008\u0008\u0002\u0010#\u001a\u00020$\u0012\u0008\u0008\u0002\u0010%\u001a\u00020\n\u0012\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\u0008\u0008\u0002\u0010.\u001a\u00020/\u0012\u0008\u0008\u0002\u00100\u001a\u000201\u0012\n\u0008\u0002\u00105\u001a\u0004\u0018\u000106¢\u0006\u0002\u00108B\u009f\u0002\u0008\u0016\u0012\u0008\u00109\u001a\u0004\u0018\u00010:\u0012\u0008\u0008\u0002\u0010;\u001a\u00020<\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0008\u0012\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\u0008\u0002\u00103\u001a\u0004\u0018\u000104\u0012\u0008\u0008\u0002\u0010!\u001a\u00020\"\u0012\u0008\u0008\u0002\u0010#\u001a\u00020$\u0012\u0008\u0008\u0002\u0010%\u001a\u00020\n\u0012\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\u0008\u0008\u0002\u0010.\u001a\u00020/\u0012\u0008\u0008\u0002\u00100\u001a\u000201\u0012\n\u0008\u0002\u00105\u001a\u0004\u0018\u000106¢\u0006\u0002\u0010=B§\u0002\u0008\u0017\u0012\u0008\u00109\u001a\u0004\u0018\u00010:\u0012\u0008\u0008\u0002\u0010;\u001a\u00020<\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0008\u0012\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\u0008\u0002\u00103\u001a\u0004\u0018\u000104\u0012\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\u0008\u0008\u0002\u0010%\u001a\u00020\n\u0012\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\u0008\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\u0008\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\u0008\u0002\u00105\u001a\u0004\u0018\u000106¢\u0006\u0002\u0010>B#\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010*¢\u0006\u0002\u0010?J«\u0002\u0010\u0082\u0001\u001a\u00020\u00002\u0008\u00109\u001a\u0004\u0018\u00010:2\u0008\u0008\u0002\u0010;\u001a\u00020<2\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\n2\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00082\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0008\u0002\u00103\u001a\u0004\u0018\u0001042\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020\n2\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010,2\u0008\u0008\u0002\u0010.\u001a\u00020/2\u0008\u0008\u0002\u00100\u001a\u0002012\n\u0008\u0002\u00105\u001a\u0004\u0018\u000106ø\u0001\u0000¢\u0006\u0006\u0008\u0083\u0001\u0010\u0084\u0001Jµ\u0002\u0010\u0082\u0001\u001a\u00020\u00002\u0008\u00109\u001a\u0004\u0018\u00010:2\u0008\u0008\u0002\u0010;\u001a\u00020<2\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\n2\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00082\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0008\u0002\u00103\u001a\u0004\u0018\u0001042\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0008\u0008\u0002\u0010%\u001a\u00020\n2\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\u0008\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\u0008\u0002\u00100\u001a\u0004\u0018\u0001012\n\u0008\u0002\u00105\u001a\u0004\u0018\u000106H\u0007ø\u0001\u0000¢\u0006\u0006\u0008\u0085\u0001\u0010\u0086\u0001J¡\u0002\u0010\u0082\u0001\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\n2\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00082\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0008\u0002\u00103\u001a\u0004\u0018\u0001042\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020\n2\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010,2\u0008\u0008\u0002\u0010.\u001a\u00020/2\u0008\u0008\u0002\u00100\u001a\u0002012\n\u0008\u0002\u00105\u001a\u0004\u0018\u000106ø\u0001\u0000¢\u0006\u0006\u0008\u0087\u0001\u0010\u0088\u0001J«\u0002\u0010\u0082\u0001\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\n2\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00082\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0008\u0002\u00103\u001a\u0004\u0018\u0001042\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0008\u0008\u0002\u0010%\u001a\u00020\n2\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\u0008\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\u0008\u0002\u00100\u001a\u0004\u0018\u0001012\n\u0008\u0002\u00105\u001a\u0004\u0018\u000106H\u0007ø\u0001\u0000¢\u0006\u0006\u0008\u0089\u0001\u0010\u008a\u0001Jã\u0001\u0010\u0082\u0001\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\n2\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00082\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0008\u0008\u0002\u0010%\u001a\u00020\n2\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0007ø\u0001\u0000¢\u0006\u0006\u0008\u008b\u0001\u0010\u008c\u0001Jû\u0001\u0010\u0082\u0001\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\n2\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00082\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0008\u0008\u0002\u0010%\u001a\u00020\n2\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010,H\u0007ø\u0001\u0000¢\u0006\u0006\u0008\u008d\u0001\u0010\u008e\u0001J\u0093\u0002\u0010\u0082\u0001\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\n2\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00082\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0008\u0008\u0002\u0010%\u001a\u00020\n2\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\u0008\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\u0008\u0002\u00100\u001a\u0004\u0018\u000101H\u0007ø\u0001\u0000¢\u0006\u0006\u0008\u008f\u0001\u0010\u0090\u0001J\u0016\u0010\u0091\u0001\u001a\u00030\u0092\u00012\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0011\u0010\u0094\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u0000J\u0011\u0010\u0095\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u0000J\n\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0016J\u0010\u0010\u0098\u0001\u001a\u00030\u0097\u0001H\u0000¢\u0006\u0003\u0008\u0099\u0001J£\u0002\u0010\u009a\u0001\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\n2\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00082\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0008\u0002\u00103\u001a\u0004\u0018\u0001042\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020\n2\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010,2\u0008\u0008\u0002\u0010.\u001a\u00020/2\u0008\u0008\u0002\u00100\u001a\u0002012\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\u0008\u0002\u00105\u001a\u0004\u0018\u000106H\u0007ø\u0001\u0000¢\u0006\u0006\u0008\u009b\u0001\u0010\u009c\u0001J«\u0002\u0010\u009a\u0001\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\n2\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00082\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0008\u0002\u00103\u001a\u0004\u0018\u0001042\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0008\u0008\u0002\u0010%\u001a\u00020\n2\n\u0008\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\u0008\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\u0008\u0002\u00100\u001a\u0004\u0018\u0001012\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\u0008\u0002\u00105\u001a\u0004\u0018\u000106H\u0007ø\u0001\u0000¢\u0006\u0006\u0008\u009d\u0001\u0010\u009e\u0001J\u0012\u0010\u009a\u0001\u001a\u00020\u00002\u0007\u0010\u0093\u0001\u001a\u00020\u0005H\u0007J\u0012\u0010\u009a\u0001\u001a\u00020\u00002\u0007\u0010\u0093\u0001\u001a\u00020\u0003H\u0007J\u0016\u0010\u009a\u0001\u001a\u00020\u00002\u000b\u0008\u0002\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0000H\u0007J\u0013\u0010\u009f\u0001\u001a\u00020\u00002\u0007\u0010\u0093\u0001\u001a\u00020\u0005H\u0087\u0002J\u0013\u0010\u009f\u0001\u001a\u00020\u00002\u0007\u0010\u0093\u0001\u001a\u00020\u0003H\u0087\u0002J\u0013\u0010\u009f\u0001\u001a\u00020\u00002\u0007\u0010\u0093\u0001\u001a\u00020\u0000H\u0087\u0002J\t\u0010 \u0001\u001a\u00020\u0005H\u0007J\t\u0010¡\u0001\u001a\u00020\u0003H\u0007J\t\u0010¢\u0001\u001a\u00020\u0014H\u0016R\u0011\u0010;\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\u0008@\u0010AR\u0017\u0010\u001c\u001a\u00020\u00088Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008B\u0010CR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00178Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008D\u0010ER\u0013\u00109\u001a\u0004\u0018\u00010:8F¢\u0006\u0006\u001a\u0004\u0008F\u0010GR\u0017\u0010\u0007\u001a\u00020\u00088Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008H\u0010CR\"\u0010I\u001a\u0004\u0018\u0001018GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008J\u0010K\u001a\u0004\u0008L\u0010MR\"\u0010N\u001a\u0004\u0018\u00010/8GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008O\u0010K\u001a\u0004\u0008P\u0010QR\"\u0010R\u001a\u0004\u0018\u00010\"8GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008S\u0010K\u001a\u0004\u0008T\u0010UR\"\u0010V\u001a\u0004\u0018\u00010$8GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008W\u0010K\u001a\u0004\u0008X\u0010YR\u0013\u00103\u001a\u0004\u0018\u0001048F¢\u0006\u0006\u001a\u0004\u0008Z\u0010[R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\u0008\\\u0010]R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\u0008^\u0010_R\u0017\u0010\t\u001a\u00020\n8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008`\u0010CR\u0019\u0010\r\u001a\u0004\u0018\u00010\u000e8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008a\u0010bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00108Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008c\u0010dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u000c8F¢\u0006\u0006\u001a\u0004\u0008e\u0010fR\u0017\u00100\u001a\u0002018Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008g\u0010hR\u0017\u0010\u0015\u001a\u00020\n8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008i\u0010CR\u0017\u0010.\u001a\u00020/8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008j\u0010hR\u0017\u0010%\u001a\u00020\n8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008k\u0010CR\u0013\u0010+\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\u0008l\u0010mR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\u0008n\u0010oR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008p\u0010qR\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\u0008\n\u0000\u001a\u0004\u0008r\u0010sR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\u0008t\u0010uR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008v\u0010wR\u0017\u0010!\u001a\u00020\"8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008x\u0010hR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\u0008y\u0010zR\u0017\u0010#\u001a\u00020$8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008{\u0010hR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\u0008|\u0010}R\u0013\u0010&\u001a\u0004\u0018\u00010'8F¢\u0006\u0006\u001a\u0004\u0008~\u0010\u007fR\u0015\u00105\u001a\u0004\u0018\u0001068F¢\u0006\u0008\u001a\u0006\u0008\u0080\u0001\u0010\u0081\u0001\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006¤\u0001", d2 = {"Landroidx/compose/ui/text/TextStyle;", "", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;)V", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "platformStyle", "Landroidx/compose/ui/text/PlatformTextStyle;", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;Landroidx/compose/ui/text/PlatformTextStyle;)V", "getAlpha", "()F", "getBackground-0d7_KjU", "()J", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getColor-0d7_KjU", "deprecated_boxing_hyphens", "getHyphens-EaSxIns$annotations", "()V", "getHyphens-EaSxIns", "()Landroidx/compose/ui/text/style/Hyphens;", "deprecated_boxing_lineBreak", "getLineBreak-LgCVezo$annotations", "getLineBreak-LgCVezo", "()Landroidx/compose/ui/text/style/LineBreak;", "deprecated_boxing_textAlign", "getTextAlign-buA522U$annotations", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "deprecated_boxing_textDirection", "getTextDirection-mmuk1to$annotations", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "()Ljava/lang/String;", "getFontSize-XSAIIZE", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getHyphens-vmbZdU8", "()I", "getLetterSpacing-XSAIIZE", "getLineBreak-rAG3T2k", "getLineHeight-XSAIIZE", "getLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getParagraphStyle$ui_text_release", "()Landroidx/compose/ui/text/ParagraphStyle;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformTextStyle;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getSpanStyle$ui_text_release", "()Landroidx/compose/ui/text/SpanStyle;", "getTextAlign-e0LSkKk", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getTextDirection-s_7X-co", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "getTextMotion", "()Landroidx/compose/ui/text/style/TextMotion;", "copy", "copy-Ns73l9s", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-aIRg9q4", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-p1EtxEg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-v2rsoow", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-HL5avdY", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/TextStyle;", "copy-NOaFTUo", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;)Landroidx/compose/ui/text/TextStyle;", "copy-CXVQc50", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;)Landroidx/compose/ui/text/TextStyle;", "equals", "", "other", "hasSameDrawAffectingAttributes", "hasSameLayoutAffectingAttributes", "hashCode", "", "hashCodeLayoutAffectingAttributes", "hashCodeLayoutAffectingAttributes$ui_text_release", "merge", "merge-dA7vx0o", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "merge-Z1GrekI", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "plus", "toParagraphStyle", "toSpanStyle", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextStyle {

    public static final int $stable;
    public static final androidx.compose.ui.text.TextStyle.Companion Companion;
    private static final androidx.compose.ui.text.TextStyle Default;
    private final androidx.compose.ui.text.ParagraphStyle paragraphStyle;
    private final androidx.compose.ui.text.PlatformTextStyle platformStyle;
    private final androidx.compose.ui.text.SpanStyle spanStyle;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/ui/text/TextStyle$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/TextStyle;", "getDefault$annotations", "getDefault", "()Landroidx/compose/ui/text/TextStyle;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getDefault$annotations() {
        }

        public final androidx.compose.ui.text.TextStyle getDefault() {
            return TextStyle.access$getDefault$cp();
        }
    }
    static {
        TextStyle.Companion companion = new TextStyle.Companion(0);
        TextStyle.Companion = companion;
        TextStyle textStyle = new TextStyle(0, obj4, 0, obj6, 0, 0, 0, 0, 0, 0, obj13, 0, 0, 0, 0, obj18, 0, 0, 0, 0, 0, 0, obj25, 0, 0, 0, 0, 0, 0, 16777215, 0);
        TextStyle.Default = textStyle;
    }

    private TextStyle(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int textAlign, int textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, int lineBreak, int hyphens, TextMotion textMotion) {
        androidx.compose.ui.text.PlatformSpanStyle spanStyle;
        androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle;
        int paragraphStyle;
        final androidx.compose.ui.text.PlatformTextStyle platformTextStyle = obj49;
        if (platformTextStyle != null) {
            platformSpanStyle = spanStyle;
        } else {
            platformSpanStyle = paragraphStyle;
        }
        final FontSynthesis fontSynthesis2 = fontSynthesis;
        SpanStyle spanStyle2 = new SpanStyle(color, obj3, fontWeight, obj5, fontSynthesis2, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, obj12, background, textDecoration, shadow, drawStyle, obj17, textDirection, lineHeight, platformSpanStyle, textIndent, 0);
        if (platformTextStyle != null) {
            paragraphStyle = platformTextStyle.getParagraphStyle();
        }
        ParagraphStyle paragraphStyle2 = new ParagraphStyle(platformStyle, lineHeightStyle, lineBreak, fontSynthesis2, textMotion, paragraphStyle, obj50, obj51, obj52, obj53, 0);
        super(spanStyle2, paragraphStyle2, platformTextStyle);
    }

    public TextStyle(long l, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, DrawStyle drawStyle15, int i16, int i17, long l18, TextIndent textIndent19, androidx.compose.ui.text.PlatformTextStyle platformTextStyle20, LineHeightStyle lineHeightStyle21, int i22, int i23, TextMotion textMotion24, int i25, DefaultConstructorMarker defaultConstructorMarker26) {
        int i9;
        long unspecified-0d7_KjU;
        int i14;
        int i13;
        long unspecified-XSAIIZE3;
        int i3;
        int companion;
        int i7;
        int i8;
        int i5;
        int i15;
        int i11;
        long unspecified-XSAIIZE;
        int i10;
        int i6;
        int i2;
        long unspecified-0d7_KjU2;
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        long unspecified-XSAIIZE2;
        int i12;
        int i4;
        int i;
        int unspecified-rAG3T2k;
        int unspecified-vmbZdU8;
        int i18 = obj60;
        if (i18 & 1 != 0) {
            unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU = l;
        }
        if (i18 & 2 != 0) {
            unspecified-XSAIIZE3 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE3 = fontWeight3;
        }
        i3 = i18 & 4 != 0 ? 0 : fontSynthesis5;
        i8 = i18 & 8 != 0 ? 0 : fontFamily6;
        i5 = i18 & 16 != 0 ? 0 : string7;
        i15 = i18 & 32 != 0 ? 0 : l8;
        i11 = i18 & 64 != 0 ? 0 : baselineShift9;
        if (i18 & 128 != 0) {
            unspecified-XSAIIZE = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE = textGeometricTransform10;
        }
        i10 = i18 & 256 != 0 ? 0 : l12;
        i6 = i18 & 512 != 0 ? 0 : textDecoration13;
        i2 = i18 & 1024 != 0 ? 0 : shadow14;
        if (i18 & 2048 != 0) {
            unspecified-0d7_KjU2 = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU2 = drawStyle15;
        }
        i7 = i18 & 4096 != 0 ? 0 : i17;
        i14 = i18 & 8192 != 0 ? 0 : l18;
        i13 = i18 & 16384 != 0 ? 0 : textIndent19;
        if (i18 & i37 != 0) {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        } else {
            unspecified-e0LSkKk = platformTextStyle20;
        }
        if (i18 & i39 != 0) {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        } else {
            unspecified-s_7X-co = lineHeightStyle21;
        }
        if (i18 & i41 != 0) {
            unspecified-XSAIIZE2 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE2 = i22;
        }
        i12 = i18 & i43 != 0 ? 0 : textMotion24;
        i4 = i18 & i45 != 0 ? 0 : i25;
        i = i18 & i47 != 0 ? 0 : defaultConstructorMarker26;
        if (i18 & i49 != 0) {
            unspecified-rAG3T2k = LineBreak.Companion.getUnspecified-rAG3T2k();
        } else {
            unspecified-rAG3T2k = obj57;
        }
        if (i18 & i51 != 0) {
            unspecified-vmbZdU8 = Hyphens.Companion.getUnspecified-vmbZdU8();
        } else {
            unspecified-vmbZdU8 = obj58;
        }
        i9 = i18 &= i53 != 0 ? 0 : obj59;
        super(unspecified-0d7_KjU, fontWeight3, unspecified-XSAIIZE3, fontSynthesis5, i3, i8, i5, i15, i11, unspecified-XSAIIZE, l12, i10, i6, i2, unspecified-0d7_KjU2, i17, i7, i14, i13, unspecified-e0LSkKk, unspecified-s_7X-co, unspecified-XSAIIZE2, textMotion24, i12, i4, i, unspecified-rAG3T2k, unspecified-vmbZdU8, i9, 0);
    }

    public TextStyle(long l, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, DrawStyle drawStyle15, int i16, int i17, long l18, TextIndent textIndent19, androidx.compose.ui.text.PlatformTextStyle platformTextStyle20, LineHeightStyle lineHeightStyle21, int i22, int i23, TextMotion textMotion24, DefaultConstructorMarker defaultConstructorMarker25) {
        super(l, l2, fontWeight3, fontStyle4, fontSynthesis5, fontFamily6, string7, l8, baselineShift9, textGeometricTransform10, localeList11, l12, textDecoration13, shadow14, drawStyle15, i16, i17, l18, textIndent19, platformTextStyle20, lineHeightStyle21, i22, i23, textMotion24, defaultConstructorMarker25, obj26, obj27, obj28, obj29);
    }

    private TextStyle(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        androidx.compose.ui.text.PlatformSpanStyle spanStyle;
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        int unspecified-rAG3T2k;
        int unbox-impl;
        androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle;
        int paragraphStyle;
        final androidx.compose.ui.text.PlatformTextStyle platformTextStyle = obj49;
        if (platformTextStyle != null) {
            platformSpanStyle = spanStyle;
        } else {
            platformSpanStyle = paragraphStyle;
        }
        final FontSynthesis fontSynthesis2 = fontSynthesis;
        SpanStyle spanStyle2 = new SpanStyle(color, obj3, fontWeight, obj5, fontSynthesis2, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, obj12, background, textDecoration, shadow, drawStyle, obj17, textDirection, lineHeight, platformSpanStyle, textIndent, 0);
        if (platformStyle != null) {
            unspecified-e0LSkKk = platformStyle.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (lineHeightStyle != null) {
            unspecified-s_7X-co = lineHeightStyle.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        if (platformTextStyle != null) {
            paragraphStyle = platformTextStyle.getParagraphStyle();
        }
        if (obj51 != null) {
            unspecified-rAG3T2k = obj51.unbox-impl();
        } else {
            unspecified-rAG3T2k = LineBreak.Companion.getUnspecified-rAG3T2k();
        }
        if (obj52 != null) {
            unbox-impl = obj52.unbox-impl();
        } else {
            unbox-impl = Hyphens.Companion.getUnspecified-vmbZdU8();
        }
        ParagraphStyle paragraphStyle2 = new ParagraphStyle(unspecified-e0LSkKk, unspecified-s_7X-co, lineBreak, fontSynthesis2, textMotion, paragraphStyle, obj50, unspecified-rAG3T2k, unbox-impl, obj53, 0);
        super(spanStyle2, paragraphStyle2, platformTextStyle);
    }

    public TextStyle(long l, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, DrawStyle drawStyle15, TextAlign textAlign16, TextDirection textDirection17, long l18, TextIndent textIndent19, androidx.compose.ui.text.PlatformTextStyle platformTextStyle20, LineHeightStyle lineHeightStyle21, LineBreak lineBreak22, Hyphens hyphens23, TextMotion textMotion24, int i25, DefaultConstructorMarker defaultConstructorMarker26) {
        int i6;
        long unspecified-0d7_KjU2;
        int i2;
        int i7;
        long unspecified-XSAIIZE2;
        int i14;
        int companion;
        int i15;
        int i5;
        int i8;
        int i9;
        int i3;
        long unspecified-XSAIIZE3;
        int i10;
        int i4;
        int i;
        long unspecified-0d7_KjU;
        int i11;
        int i12;
        long unspecified-XSAIIZE;
        int hyphens;
        int i18;
        int i17;
        int i13;
        int i16;
        int i19 = obj60;
        if (i19 & 1 != 0) {
            unspecified-0d7_KjU2 = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU2 = l;
        }
        if (i19 & 2 != 0) {
            unspecified-XSAIIZE2 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE2 = fontWeight3;
        }
        i14 = i19 & 4 != 0 ? 0 : fontSynthesis5;
        i5 = i19 & 8 != 0 ? 0 : fontFamily6;
        i8 = i19 & 16 != 0 ? 0 : string7;
        i9 = i19 & 32 != 0 ? 0 : l8;
        i3 = i19 & 64 != 0 ? 0 : baselineShift9;
        if (i19 & 128 != 0) {
            unspecified-XSAIIZE3 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE3 = textGeometricTransform10;
        }
        i10 = i19 & 256 != 0 ? 0 : l12;
        i4 = i19 & 512 != 0 ? 0 : textDecoration13;
        i = i19 & 1024 != 0 ? 0 : shadow14;
        if (i19 & 2048 != 0) {
            unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU = drawStyle15;
        }
        i15 = i19 & 4096 != 0 ? 0 : textDirection17;
        i2 = i19 & 8192 != 0 ? 0 : l18;
        i7 = i19 & 16384 != 0 ? 0 : textIndent19;
        i11 = i19 & i36 != 0 ? 0 : platformTextStyle20;
        i12 = i19 & i38 != 0 ? 0 : lineHeightStyle21;
        if (i19 & i40 != 0) {
            unspecified-XSAIIZE = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE = lineBreak22;
        }
        hyphens = i19 & i42 != 0 ? 0 : textMotion24;
        i18 = i19 & i44 != 0 ? 0 : i25;
        i17 = i19 & i46 != 0 ? 0 : defaultConstructorMarker26;
        i13 = i19 & i48 != 0 ? 0 : obj57;
        i16 = i19 & i50 != 0 ? 0 : obj58;
        i6 = i19 &= i52 != 0 ? 0 : obj59;
        super(unspecified-0d7_KjU2, fontWeight3, unspecified-XSAIIZE2, fontSynthesis5, i14, i5, i8, i9, i3, unspecified-XSAIIZE3, l12, i10, i4, i, unspecified-0d7_KjU, textDirection17, i15, i2, i7, i11, i12, unspecified-XSAIIZE, textMotion24, hyphens, i18, i17, i13, i16, i6, 0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    public TextStyle(long l, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, DrawStyle drawStyle15, TextAlign textAlign16, TextDirection textDirection17, long l18, TextIndent textIndent19, androidx.compose.ui.text.PlatformTextStyle platformTextStyle20, LineHeightStyle lineHeightStyle21, LineBreak lineBreak22, Hyphens hyphens23, TextMotion textMotion24, DefaultConstructorMarker defaultConstructorMarker25) {
        super(l, l2, fontWeight3, fontStyle4, fontSynthesis5, fontFamily6, string7, l8, baselineShift9, textGeometricTransform10, localeList11, l12, textDecoration13, shadow14, drawStyle15, textAlign16, textDirection17, l18, textIndent19, platformTextStyle20, lineHeightStyle21, lineBreak22, hyphens23, textMotion24, defaultConstructorMarker25, obj26, obj27, obj28, obj29);
    }

    private TextStyle(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent) {
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        final FontSynthesis fontSynthesis2 = fontSynthesis;
        SpanStyle spanStyle = new SpanStyle(color, obj2, fontWeight, obj4, fontSynthesis2, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, obj11, background, textDecoration, shadow, textAlign, obj16, lineHeight, textIndent, 0, 0, 0);
        if (obj41 != null) {
            unspecified-e0LSkKk = obj41.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (obj42 != null) {
            unspecified-s_7X-co = obj42.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        ParagraphStyle paragraphStyle = new ParagraphStyle(unspecified-e0LSkKk, unspecified-s_7X-co, obj43, fontSynthesis2, obj45, 0, 0, LineBreak.Companion.getUnspecified-rAG3T2k(), Hyphens.Companion.getUnspecified-vmbZdU8(), 0, 0);
        super(spanStyle, paragraphStyle, 0);
    }

    public TextStyle(long l, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, TextAlign textAlign15, TextDirection textDirection16, long l17, TextIndent textIndent18, int i19, DefaultConstructorMarker defaultConstructorMarker20) {
        int i4;
        long unspecified-0d7_KjU;
        int i5;
        int i8;
        long unspecified-XSAIIZE3;
        int i;
        Color.Companion companion;
        int i11;
        int i7;
        int i9;
        int i3;
        int i2;
        long unspecified-XSAIIZE2;
        int i13;
        int i6;
        int i10;
        long unspecified-0d7_KjU2;
        int i12;
        long unspecified-XSAIIZE;
        int i14 = obj48;
        if (i14 & 1 != 0) {
            unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU = l;
        }
        if (i14 & 2 != 0) {
            unspecified-XSAIIZE3 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE3 = fontWeight3;
        }
        i = i14 & 4 != 0 ? 0 : fontSynthesis5;
        i7 = i14 & 8 != 0 ? 0 : fontFamily6;
        i9 = i14 & 16 != 0 ? 0 : string7;
        i3 = i14 & 32 != 0 ? 0 : l8;
        i2 = i14 & 64 != 0 ? 0 : baselineShift9;
        if (i14 & 128 != 0) {
            unspecified-XSAIIZE2 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE2 = textGeometricTransform10;
        }
        i13 = i14 & 256 != 0 ? 0 : l12;
        i6 = i14 & 512 != 0 ? 0 : textDecoration13;
        i10 = i14 & 1024 != 0 ? 0 : shadow14;
        if (i14 & 2048 != 0) {
            unspecified-0d7_KjU2 = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU2 = textAlign15;
        }
        i11 = i14 & 4096 != 0 ? 0 : l17;
        i5 = i14 & 8192 != 0 ? 0 : textIndent18;
        i8 = i14 & 16384 != 0 ? 0 : i19;
        i12 = i14 & i31 != 0 ? 0 : defaultConstructorMarker20;
        if (i14 & i33 != 0) {
            unspecified-XSAIIZE = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE = obj45;
        }
        i4 = i14 &= i35 != 0 ? 0 : obj47;
        super(unspecified-0d7_KjU, fontWeight3, unspecified-XSAIIZE3, fontSynthesis5, i, i7, i9, i3, i2, unspecified-XSAIIZE2, l12, i13, i6, i10, unspecified-0d7_KjU2, l17, i11, i5, i8, i12, unspecified-XSAIIZE, obj47, i4, 0);
    }

    private TextStyle(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle) {
        androidx.compose.ui.text.PlatformSpanStyle spanStyle;
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        int i;
        int paragraphStyle;
        final androidx.compose.ui.text.PlatformTextStyle platformTextStyle = obj48;
        if (platformTextStyle != null) {
            i = spanStyle;
        } else {
            i = paragraphStyle;
        }
        final FontSynthesis fontSynthesis2 = fontSynthesis;
        SpanStyle spanStyle2 = new SpanStyle(color, obj3, fontWeight, obj5, fontSynthesis2, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, obj12, background, textDecoration, shadow, textAlign, obj17, lineHeight, textIndent, i, 0, 0);
        if (platformStyle != null) {
            unspecified-e0LSkKk = platformStyle.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (lineHeightStyle != null) {
            unspecified-s_7X-co = lineHeightStyle.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        if (platformTextStyle != null) {
            paragraphStyle = platformTextStyle.getParagraphStyle();
        }
        ParagraphStyle paragraphStyle2 = new ParagraphStyle(unspecified-e0LSkKk, unspecified-s_7X-co, obj45, fontSynthesis2, obj47, paragraphStyle, obj49, LineBreak.Companion.getUnspecified-rAG3T2k(), Hyphens.Companion.getUnspecified-vmbZdU8(), 0, 0);
        super(spanStyle2, paragraphStyle2, platformTextStyle);
    }

    public TextStyle(long l, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, TextAlign textAlign15, TextDirection textDirection16, long l17, TextIndent textIndent18, androidx.compose.ui.text.PlatformTextStyle platformTextStyle19, LineHeightStyle lineHeightStyle20, int i21, DefaultConstructorMarker defaultConstructorMarker22) {
        int i11;
        long unspecified-0d7_KjU;
        int i5;
        int i6;
        long unspecified-XSAIIZE;
        int i12;
        int companion;
        int i7;
        int i9;
        int i2;
        int i3;
        int i10;
        long unspecified-XSAIIZE2;
        int i14;
        int i8;
        int i15;
        long unspecified-0d7_KjU2;
        int i;
        long unspecified-XSAIIZE3;
        int i13;
        int i4;
        int i16 = obj52;
        if (i16 & 1 != 0) {
            unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU = l;
        }
        if (i16 & 2 != 0) {
            unspecified-XSAIIZE = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE = fontWeight3;
        }
        i12 = i16 & 4 != 0 ? 0 : fontSynthesis5;
        i9 = i16 & 8 != 0 ? 0 : fontFamily6;
        i2 = i16 & 16 != 0 ? 0 : string7;
        i3 = i16 & 32 != 0 ? 0 : l8;
        i10 = i16 & 64 != 0 ? 0 : baselineShift9;
        if (i16 & 128 != 0) {
            unspecified-XSAIIZE2 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE2 = textGeometricTransform10;
        }
        i14 = i16 & 256 != 0 ? 0 : l12;
        i8 = i16 & 512 != 0 ? 0 : textDecoration13;
        i15 = i16 & 1024 != 0 ? 0 : shadow14;
        if (i16 & 2048 != 0) {
            unspecified-0d7_KjU2 = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU2 = textAlign15;
        }
        i7 = i16 & 4096 != 0 ? 0 : l17;
        i5 = i16 & 8192 != 0 ? 0 : textIndent18;
        i6 = i16 & 16384 != 0 ? 0 : platformTextStyle19;
        i = i16 & i33 != 0 ? 0 : lineHeightStyle20;
        if (i16 & i35 != 0) {
            unspecified-XSAIIZE3 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE3 = i21;
        }
        i13 = i16 & i37 != 0 ? 0 : obj49;
        i4 = i16 & i39 != 0 ? 0 : obj50;
        i11 = i16 &= i41 != 0 ? 0 : obj51;
        super(unspecified-0d7_KjU, fontWeight3, unspecified-XSAIIZE, fontSynthesis5, i12, i9, i2, i3, i10, unspecified-XSAIIZE2, l12, i14, i8, i15, unspecified-0d7_KjU2, l17, i7, i5, i6, i, unspecified-XSAIIZE3, obj49, i13, i4, i11, 0);
    }

    private TextStyle(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens) {
        androidx.compose.ui.text.PlatformSpanStyle spanStyle;
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        int unspecified-rAG3T2k;
        int unbox-impl;
        androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle;
        int paragraphStyle;
        final androidx.compose.ui.text.PlatformTextStyle platformTextStyle = obj49;
        if (platformTextStyle != null) {
            platformSpanStyle = spanStyle;
        } else {
            platformSpanStyle = paragraphStyle;
        }
        final FontSynthesis fontSynthesis2 = fontSynthesis;
        SpanStyle spanStyle2 = new SpanStyle(color, obj3, fontWeight, obj5, fontSynthesis2, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, obj12, background, textDecoration, shadow, textAlign, obj17, lineHeight, textIndent, platformSpanStyle, 0, 32768, 0);
        if (platformStyle != null) {
            unspecified-e0LSkKk = platformStyle.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (lineHeightStyle != null) {
            unspecified-s_7X-co = lineHeightStyle.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        if (platformTextStyle != null) {
            paragraphStyle = platformTextStyle.getParagraphStyle();
        }
        if (obj51 != null) {
            unspecified-rAG3T2k = obj51.unbox-impl();
        } else {
            unspecified-rAG3T2k = LineBreak.Companion.getUnspecified-rAG3T2k();
        }
        if (obj52 != null) {
            unbox-impl = obj52.unbox-impl();
        } else {
            unbox-impl = Hyphens.Companion.getUnspecified-vmbZdU8();
        }
        ParagraphStyle paragraphStyle2 = new ParagraphStyle(unspecified-e0LSkKk, unspecified-s_7X-co, lineBreak, fontSynthesis2, obj48, paragraphStyle, obj50, unspecified-rAG3T2k, unbox-impl, 0, 256, 0);
        super(spanStyle2, paragraphStyle2, platformTextStyle);
    }

    public TextStyle(long l, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, TextAlign textAlign15, TextDirection textDirection16, long l17, TextIndent textIndent18, androidx.compose.ui.text.PlatformTextStyle platformTextStyle19, LineHeightStyle lineHeightStyle20, LineBreak lineBreak21, Hyphens hyphens22, int i23, DefaultConstructorMarker defaultConstructorMarker24) {
        int i9;
        long unspecified-0d7_KjU2;
        int i11;
        int i10;
        long unspecified-XSAIIZE3;
        int i5;
        int companion;
        int i12;
        int i7;
        int i16;
        int i4;
        int i13;
        long unspecified-XSAIIZE;
        int i14;
        int i8;
        int i;
        long unspecified-0d7_KjU;
        int i3;
        long unspecified-XSAIIZE2;
        int i15;
        int i6;
        int i17;
        int i2;
        int i18 = obj56;
        if (i18 & 1 != 0) {
            unspecified-0d7_KjU2 = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU2 = l;
        }
        if (i18 & 2 != 0) {
            unspecified-XSAIIZE3 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE3 = fontWeight3;
        }
        i5 = i18 & 4 != 0 ? 0 : fontSynthesis5;
        i7 = i18 & 8 != 0 ? 0 : fontFamily6;
        i16 = i18 & 16 != 0 ? 0 : string7;
        i4 = i18 & 32 != 0 ? 0 : l8;
        i13 = i18 & 64 != 0 ? 0 : baselineShift9;
        if (i18 & 128 != 0) {
            unspecified-XSAIIZE = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE = textGeometricTransform10;
        }
        i14 = i18 & 256 != 0 ? 0 : l12;
        i8 = i18 & 512 != 0 ? 0 : textDecoration13;
        i = i18 & 1024 != 0 ? 0 : shadow14;
        if (i18 & 2048 != 0) {
            unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU = textAlign15;
        }
        i12 = i18 & 4096 != 0 ? 0 : l17;
        i11 = i18 & 8192 != 0 ? 0 : textIndent18;
        i10 = i18 & 16384 != 0 ? 0 : platformTextStyle19;
        i3 = i18 & i35 != 0 ? 0 : lineHeightStyle20;
        if (i18 & i37 != 0) {
            unspecified-XSAIIZE2 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE2 = lineBreak21;
        }
        i15 = i18 & i39 != 0 ? 0 : i23;
        i6 = i18 & i41 != 0 ? 0 : defaultConstructorMarker24;
        i17 = i18 & i43 != 0 ? 0 : obj53;
        i2 = i18 & i45 != 0 ? 0 : obj54;
        i9 = i18 &= i47 != 0 ? 0 : obj55;
        super(unspecified-0d7_KjU2, fontWeight3, unspecified-XSAIIZE3, fontSynthesis5, i5, i7, i16, i4, i13, unspecified-XSAIIZE, l12, i14, i8, i, unspecified-0d7_KjU, l17, i12, i11, i10, i3, unspecified-XSAIIZE2, i23, i15, i6, i17, i2, i9, 0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that do not take new stable parameters like TextMotion are deprecated. Please use the new stable constructor.")
    public TextStyle(long l, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, TextAlign textAlign15, TextDirection textDirection16, long l17, TextIndent textIndent18, androidx.compose.ui.text.PlatformTextStyle platformTextStyle19, LineHeightStyle lineHeightStyle20, LineBreak lineBreak21, Hyphens hyphens22, DefaultConstructorMarker defaultConstructorMarker23) {
        super(l, l2, fontWeight3, fontStyle4, fontSynthesis5, fontFamily6, string7, l8, baselineShift9, textGeometricTransform10, localeList11, l12, textDecoration13, shadow14, textAlign15, textDirection16, l17, textIndent18, platformTextStyle19, lineHeightStyle20, lineBreak21, hyphens22, defaultConstructorMarker23, obj24, obj25, obj26, obj27);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.")
    public TextStyle(long l, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, TextAlign textAlign15, TextDirection textDirection16, long l17, TextIndent textIndent18, androidx.compose.ui.text.PlatformTextStyle platformTextStyle19, LineHeightStyle lineHeightStyle20, DefaultConstructorMarker defaultConstructorMarker21) {
        super(l, l2, fontWeight3, fontStyle4, fontSynthesis5, fontFamily6, string7, l8, baselineShift9, textGeometricTransform10, localeList11, l12, textDecoration13, shadow14, textAlign15, textDirection16, l17, textIndent18, platformTextStyle19, lineHeightStyle20, defaultConstructorMarker21, obj22, obj23, obj24, obj25);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.")
    public TextStyle(long l, long l2, FontWeight fontWeight3, FontStyle fontStyle4, FontSynthesis fontSynthesis5, FontFamily fontFamily6, String string7, long l8, BaselineShift baselineShift9, TextGeometricTransform textGeometricTransform10, LocaleList localeList11, long l12, TextDecoration textDecoration13, Shadow shadow14, TextAlign textAlign15, TextDirection textDirection16, long l17, TextIndent textIndent18, DefaultConstructorMarker defaultConstructorMarker19) {
        super(l, l2, fontWeight3, fontStyle4, fontSynthesis5, fontFamily6, string7, l8, baselineShift9, textGeometricTransform10, localeList11, l12, textDecoration13, shadow14, textAlign15, textDirection16, l17, textIndent18, defaultConstructorMarker19, obj20, obj21, obj22, obj23);
    }

    private TextStyle(Brush brush, float alpha, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int textAlign, int textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, int lineBreak, int hyphens, TextMotion textMotion) {
        androidx.compose.ui.text.PlatformSpanStyle spanStyle;
        androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle;
        int paragraphStyle;
        final androidx.compose.ui.text.PlatformTextStyle platformTextStyle = textMotion;
        if (platformTextStyle != null) {
            platformSpanStyle = spanStyle;
        } else {
            platformSpanStyle = paragraphStyle;
        }
        final FontStyle fontStyle2 = fontStyle;
        SpanStyle spanStyle2 = new SpanStyle(brush, alpha, fontSize, obj5, fontStyle2, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, obj12, localeList, background, textDecoration, shadow, obj17, textAlign, textDirection, platformSpanStyle, lineHeight, 0);
        if (platformTextStyle != null) {
            paragraphStyle = platformTextStyle.getParagraphStyle();
        }
        ParagraphStyle paragraphStyle2 = new ParagraphStyle(textIndent, platformStyle, lineHeightStyle, fontStyle2, hyphens, paragraphStyle, obj50, obj51, obj52, obj53, 0);
        super(spanStyle2, paragraphStyle2, platformTextStyle);
    }

    public TextStyle(Brush brush, float f2, long l3, FontWeight fontWeight4, FontStyle fontStyle5, FontSynthesis fontSynthesis6, FontFamily fontFamily7, String string8, long l9, BaselineShift baselineShift10, TextGeometricTransform textGeometricTransform11, LocaleList localeList12, long l13, TextDecoration textDecoration14, Shadow shadow15, DrawStyle drawStyle16, int i17, int i18, long l19, TextIndent textIndent20, androidx.compose.ui.text.PlatformTextStyle platformTextStyle21, LineHeightStyle lineHeightStyle22, int i23, int i24, TextMotion textMotion25, int i26, DefaultConstructorMarker defaultConstructorMarker27) {
        int i10;
        int unspecified-XSAIIZE3;
        int companion2;
        int companion3;
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        int companion;
        int unspecified-rAG3T2k;
        int unspecified-vmbZdU8;
        int i20;
        long l;
        int i11;
        int i;
        int i5;
        int i6;
        int i7;
        long unspecified-XSAIIZE;
        int i21;
        int i2;
        int i16;
        long unspecified-0d7_KjU;
        int i3;
        int i8;
        int i25;
        int i19;
        int i9;
        long unspecified-XSAIIZE2;
        int i13;
        int i15;
        int i14;
        int i12;
        int i4;
        int i22;
        int i27 = obj63;
        i20 = i27 & 2 != 0 ? i10 : f2;
        if (i27 & 4 != 0) {
            l = unspecified-XSAIIZE3;
        } else {
            l = l3;
        }
        int i53 = 0;
        i11 = i27 & 8 != 0 ? i53 : fontStyle5;
        i = i27 & 16 != 0 ? i53 : fontSynthesis6;
        i5 = i27 & 32 != 0 ? i53 : fontFamily7;
        i6 = i27 & 64 != 0 ? i53 : string8;
        i7 = i27 & 128 != 0 ? i53 : l9;
        if (i27 & 256 != 0) {
            unspecified-XSAIIZE = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE = baselineShift10;
        }
        i21 = i27 & 512 != 0 ? i53 : localeList12;
        i2 = i27 & 1024 != 0 ? i53 : l13;
        i16 = i27 & 2048 != 0 ? i53 : textDecoration14;
        if (i27 & 4096 != 0) {
            unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU = shadow15;
        }
        i3 = i27 & 8192 != 0 ? i53 : i17;
        i8 = i27 & 16384 != 0 ? i53 : i18;
        i25 = i39 &= i27 != 0 ? i53 : l19;
        if (i41 &= i27 != 0) {
            i19 = unspecified-e0LSkKk;
        } else {
            i19 = textIndent20;
        }
        if (i42 &= i27 != 0) {
            i9 = unspecified-s_7X-co;
        } else {
            i9 = platformTextStyle21;
        }
        if (i43 &= i27 != 0) {
            unspecified-XSAIIZE2 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE2 = lineHeightStyle22;
        }
        i13 = i44 &= i27 != 0 ? i53 : i24;
        i15 = i46 &= i27 != 0 ? i53 : textMotion25;
        i14 = i48 &= i27 != 0 ? i53 : i26;
        if (i50 &= i27 != 0) {
            i12 = unspecified-rAG3T2k;
        } else {
            i12 = defaultConstructorMarker27;
        }
        if (i51 &= i27 != 0) {
            i4 = unspecified-vmbZdU8;
        } else {
            i4 = obj61;
        }
        i22 = i27 &= i52 != 0 ? i53 : obj62;
        super(brush, i20, l, obj6, i11, i, i5, i6, i7, unspecified-XSAIIZE, obj13, i21, i2, i16, unspecified-0d7_KjU, obj18, i3, i8, i25, i19, i9, unspecified-XSAIIZE2, obj25, i13, i15, i14, i12, i4, i22, 0);
    }

    public TextStyle(Brush brush, float f2, long l3, FontWeight fontWeight4, FontStyle fontStyle5, FontSynthesis fontSynthesis6, FontFamily fontFamily7, String string8, long l9, BaselineShift baselineShift10, TextGeometricTransform textGeometricTransform11, LocaleList localeList12, long l13, TextDecoration textDecoration14, Shadow shadow15, DrawStyle drawStyle16, int i17, int i18, long l19, TextIndent textIndent20, androidx.compose.ui.text.PlatformTextStyle platformTextStyle21, LineHeightStyle lineHeightStyle22, int i23, int i24, TextMotion textMotion25, DefaultConstructorMarker defaultConstructorMarker26) {
        super(brush, f2, l3, fontWeight4, fontStyle5, fontSynthesis6, fontFamily7, string8, l9, baselineShift10, textGeometricTransform11, localeList12, l13, textDecoration14, shadow15, drawStyle16, i17, i18, l19, textIndent20, platformTextStyle21, lineHeightStyle22, i23, i24, textMotion25, defaultConstructorMarker26, obj27, obj28, obj29);
    }

    private TextStyle(Brush brush, float alpha, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        androidx.compose.ui.text.PlatformSpanStyle spanStyle;
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        int unspecified-rAG3T2k;
        int unbox-impl;
        androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle;
        int paragraphStyle;
        final androidx.compose.ui.text.PlatformTextStyle platformTextStyle = textMotion;
        if (platformTextStyle != null) {
            platformSpanStyle = spanStyle;
        } else {
            platformSpanStyle = paragraphStyle;
        }
        final FontStyle fontStyle2 = fontStyle;
        SpanStyle spanStyle2 = new SpanStyle(brush, alpha, fontSize, obj5, fontStyle2, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, obj12, localeList, background, textDecoration, shadow, obj17, textAlign, textDirection, platformSpanStyle, lineHeight, 0);
        if (textIndent != null) {
            unspecified-e0LSkKk = textIndent.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (platformStyle != null) {
            unspecified-s_7X-co = platformStyle.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        if (platformTextStyle != null) {
            paragraphStyle = platformTextStyle.getParagraphStyle();
        }
        if (obj51 != null) {
            unspecified-rAG3T2k = obj51.unbox-impl();
        } else {
            unspecified-rAG3T2k = LineBreak.Companion.getUnspecified-rAG3T2k();
        }
        if (obj52 != null) {
            unbox-impl = obj52.unbox-impl();
        } else {
            unbox-impl = Hyphens.Companion.getUnspecified-vmbZdU8();
        }
        ParagraphStyle paragraphStyle2 = new ParagraphStyle(unspecified-e0LSkKk, unspecified-s_7X-co, lineHeightStyle, fontStyle2, hyphens, paragraphStyle, obj50, unspecified-rAG3T2k, unbox-impl, obj53, 0);
        super(spanStyle2, paragraphStyle2, platformTextStyle);
    }

    public TextStyle(Brush brush, float f2, long l3, FontWeight fontWeight4, FontStyle fontStyle5, FontSynthesis fontSynthesis6, FontFamily fontFamily7, String string8, long l9, BaselineShift baselineShift10, TextGeometricTransform textGeometricTransform11, LocaleList localeList12, long l13, TextDecoration textDecoration14, Shadow shadow15, DrawStyle drawStyle16, TextAlign textAlign17, TextDirection textDirection18, long l19, TextIndent textIndent20, androidx.compose.ui.text.PlatformTextStyle platformTextStyle21, LineHeightStyle lineHeightStyle22, LineBreak lineBreak23, Hyphens hyphens24, TextMotion textMotion25, int i26, DefaultConstructorMarker defaultConstructorMarker27) {
        int i3;
        int unspecified-XSAIIZE3;
        int companion3;
        int companion2;
        int companion;
        int i20;
        long l;
        int i;
        int i5;
        int i10;
        int i17;
        int i16;
        long unspecified-XSAIIZE2;
        int i7;
        int i19;
        int i12;
        long unspecified-0d7_KjU;
        int i21;
        int i18;
        int i6;
        int i11;
        int i2;
        long unspecified-XSAIIZE;
        int i9;
        int i8;
        int i4;
        int i14;
        int i13;
        int i15;
        int i22 = obj63;
        i20 = i22 & 2 != 0 ? i3 : f2;
        if (i22 & 4 != 0) {
            l = unspecified-XSAIIZE3;
        } else {
            l = l3;
        }
        int i53 = 0;
        i = i22 & 8 != 0 ? i53 : fontStyle5;
        i5 = i22 & 16 != 0 ? i53 : fontSynthesis6;
        i10 = i22 & 32 != 0 ? i53 : fontFamily7;
        i17 = i22 & 64 != 0 ? i53 : string8;
        i16 = i22 & 128 != 0 ? i53 : l9;
        if (i22 & 256 != 0) {
            unspecified-XSAIIZE2 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE2 = baselineShift10;
        }
        i7 = i22 & 512 != 0 ? i53 : localeList12;
        i19 = i22 & 1024 != 0 ? i53 : l13;
        i12 = i22 & 2048 != 0 ? i53 : textDecoration14;
        if (i22 & 4096 != 0) {
            unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU = shadow15;
        }
        i21 = i22 & 8192 != 0 ? i53 : textAlign17;
        i18 = i22 & 16384 != 0 ? i53 : textDirection18;
        i6 = i35 &= i22 != 0 ? i53 : l19;
        i11 = i37 &= i22 != 0 ? i53 : textIndent20;
        i2 = i39 &= i22 != 0 ? i53 : platformTextStyle21;
        if (i41 &= i22 != 0) {
            unspecified-XSAIIZE = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE = lineHeightStyle22;
        }
        i9 = i42 &= i22 != 0 ? i53 : hyphens24;
        i8 = i44 &= i22 != 0 ? i53 : textMotion25;
        i4 = i46 &= i22 != 0 ? i53 : i26;
        i14 = i48 &= i22 != 0 ? i53 : defaultConstructorMarker27;
        i13 = i50 &= i22 != 0 ? i53 : obj61;
        i15 = i22 &= i52 != 0 ? i53 : obj62;
        super(brush, i20, l, obj6, i, i5, i10, i17, i16, unspecified-XSAIIZE2, obj13, i7, i19, i12, unspecified-0d7_KjU, obj18, i21, i18, i6, i11, i2, unspecified-XSAIIZE, obj25, i9, i8, i4, i14, i13, i15, 0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    public TextStyle(Brush brush, float f2, long l3, FontWeight fontWeight4, FontStyle fontStyle5, FontSynthesis fontSynthesis6, FontFamily fontFamily7, String string8, long l9, BaselineShift baselineShift10, TextGeometricTransform textGeometricTransform11, LocaleList localeList12, long l13, TextDecoration textDecoration14, Shadow shadow15, DrawStyle drawStyle16, TextAlign textAlign17, TextDirection textDirection18, long l19, TextIndent textIndent20, androidx.compose.ui.text.PlatformTextStyle platformTextStyle21, LineHeightStyle lineHeightStyle22, LineBreak lineBreak23, Hyphens hyphens24, TextMotion textMotion25, DefaultConstructorMarker defaultConstructorMarker26) {
        super(brush, f2, l3, fontWeight4, fontStyle5, fontSynthesis6, fontFamily7, string8, l9, baselineShift10, textGeometricTransform11, localeList12, l13, textDecoration14, shadow15, drawStyle16, textAlign17, textDirection18, l19, textIndent20, platformTextStyle21, lineHeightStyle22, lineBreak23, hyphens24, textMotion25, defaultConstructorMarker26, obj27, obj28, obj29);
    }

    public TextStyle(androidx.compose.ui.text.SpanStyle spanStyle, androidx.compose.ui.text.ParagraphStyle paragraphStyle) {
        super(spanStyle, paragraphStyle, TextStyleKt.access$createPlatformTextStyleInternal(spanStyle.getPlatformStyle(), paragraphStyle.getPlatformStyle()));
    }

    public TextStyle(androidx.compose.ui.text.SpanStyle spanStyle, androidx.compose.ui.text.ParagraphStyle paragraphStyle, androidx.compose.ui.text.PlatformTextStyle platformStyle) {
        super();
        this.spanStyle = spanStyle;
        this.paragraphStyle = paragraphStyle;
        this.platformStyle = platformStyle;
    }

    public TextStyle(androidx.compose.ui.text.SpanStyle spanStyle, androidx.compose.ui.text.ParagraphStyle paragraphStyle2, androidx.compose.ui.text.PlatformTextStyle platformTextStyle3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj3;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(spanStyle, paragraphStyle2, obj3);
    }

    public static final androidx.compose.ui.text.TextStyle access$getDefault$cp() {
        return TextStyle.Default;
    }

    public static androidx.compose.ui.text.TextStyle copy-CXVQc50$default(androidx.compose.ui.text.TextStyle textStyle, long l2, long l3, FontWeight fontWeight4, FontStyle fontStyle5, FontSynthesis fontSynthesis6, FontFamily fontFamily7, String string8, long l9, BaselineShift baselineShift10, TextGeometricTransform textGeometricTransform11, LocaleList localeList12, long l13, TextDecoration textDecoration14, Shadow shadow15, TextAlign textAlign16, TextDirection textDirection17, long l18, TextIndent textIndent19, androidx.compose.ui.text.PlatformTextStyle platformTextStyle20, LineHeightStyle lineHeightStyle21, LineBreak lineBreak22, Hyphens hyphens23, int i24, Object object25) {
        TextDirection paragraphStyle;
        Object textIndent;
        androidx.compose.ui.text.PlatformTextStyle platformStyle;
        LineHeightStyle lineHeightStyle;
        LineBreak box-impl3;
        Hyphens box-impl;
        long color-0d7_KjU;
        long background-0d7_KjU;
        TextDecoration textDecoration;
        TextAlign box-impl2;
        Shadow shadow;
        long fontSize-XSAIIZE;
        FontWeight fontWeight;
        FontStyle fontStyle-4Lr2A7w;
        FontSynthesis fontSynthesis-ZQGJjVo;
        FontFamily fontFamily;
        String fontFeatureSettings;
        long letterSpacing-XSAIIZE;
        BaselineShift baselineShift-5SSeXJ0;
        TextGeometricTransform textGeometricTransform;
        LocaleList localeList;
        long lineHeight-XSAIIZE;
        TextDirection obj25;
        TextIndent obj26;
        androidx.compose.ui.text.PlatformTextStyle obj27;
        LineHeightStyle obj28;
        LineBreak obj29;
        Object obj = textStyle;
        int i = obj49;
        if (i & 1 != 0) {
            color-0d7_KjU = obj.spanStyle.getColor-0d7_KjU();
        } else {
            color-0d7_KjU = l2;
        }
        if (i & 2 != 0) {
            fontSize-XSAIIZE = obj.spanStyle.getFontSize-XSAIIZE();
        } else {
            fontSize-XSAIIZE = fontWeight4;
        }
        if (i & 4 != 0) {
            fontWeight = obj.spanStyle.getFontWeight();
        } else {
            fontWeight = fontSynthesis6;
        }
        if (i & 8 != 0) {
            fontStyle-4Lr2A7w = obj.spanStyle.getFontStyle-4Lr2A7w();
        } else {
            fontStyle-4Lr2A7w = fontFamily7;
        }
        if (i & 16 != 0) {
            fontSynthesis-ZQGJjVo = obj.spanStyle.getFontSynthesis-ZQGJjVo();
        } else {
            fontSynthesis-ZQGJjVo = string8;
        }
        if (i & 32 != 0) {
            fontFamily = obj.spanStyle.getFontFamily();
        } else {
            fontFamily = l9;
        }
        if (i & 64 != 0) {
            fontFeatureSettings = obj.spanStyle.getFontFeatureSettings();
        } else {
            fontFeatureSettings = baselineShift10;
        }
        if (i & 128 != 0) {
            letterSpacing-XSAIIZE = obj.spanStyle.getLetterSpacing-XSAIIZE();
        } else {
            letterSpacing-XSAIIZE = textGeometricTransform11;
        }
        if (i & 256 != 0) {
            baselineShift-5SSeXJ0 = obj.spanStyle.getBaselineShift-5SSeXJ0();
        } else {
            baselineShift-5SSeXJ0 = l13;
        }
        if (i & 512 != 0) {
            textGeometricTransform = obj.spanStyle.getTextGeometricTransform();
        } else {
            textGeometricTransform = textDecoration14;
        }
        if (i & 1024 != 0) {
            localeList = obj.spanStyle.getLocaleList();
        } else {
            localeList = shadow15;
        }
        if (i & 2048 != 0) {
            background-0d7_KjU = obj.spanStyle.getBackground-0d7_KjU();
        } else {
            background-0d7_KjU = textAlign16;
        }
        if (i & 4096 != 0) {
            textDecoration = obj.spanStyle.getTextDecoration();
        } else {
            textDecoration = l18;
        }
        if (i & 8192 != 0) {
            shadow = obj.spanStyle.getShadow();
        } else {
            shadow = textIndent19;
        }
        final TextDecoration obj24 = textDecoration;
        if (i & 16384 != 0) {
            box-impl2 = TextAlign.box-impl(obj.paragraphStyle.getTextAlign-e0LSkKk());
        } else {
            box-impl2 = platformTextStyle20;
        }
        if (i & i19 != 0) {
            paragraphStyle = TextDirection.box-impl(obj.paragraphStyle.getTextDirection-s_7X-co());
        } else {
            paragraphStyle = lineHeightStyle21;
        }
        if (obj49 & i21 != 0) {
            obj25 = paragraphStyle;
            lineHeight-XSAIIZE = obj.paragraphStyle.getLineHeight-XSAIIZE();
        } else {
            obj25 = paragraphStyle;
            lineHeight-XSAIIZE = lineBreak22;
        }
        if (obj49 & i2 != 0) {
            textIndent = obj.paragraphStyle.getTextIndent();
        } else {
            textIndent = i24;
        }
        platformStyle = obj49 & i23 != 0 ? obj.platformStyle : object25;
        if (obj49 & i26 != 0) {
            obj27 = platformStyle;
            lineHeightStyle = obj.paragraphStyle.getLineHeightStyle();
        } else {
            obj27 = platformStyle;
            lineHeightStyle = obj46;
        }
        if (obj49 & i28 != 0) {
            obj28 = lineHeightStyle;
            box-impl3 = LineBreak.box-impl(obj.paragraphStyle.getLineBreak-rAG3T2k());
        } else {
            obj28 = lineHeightStyle;
            box-impl3 = obj47;
        }
        if (obj49 & i30 != 0) {
            obj29 = box-impl3;
            box-impl = Hyphens.box-impl(obj.paragraphStyle.getHyphens-vmbZdU8());
        } else {
            obj29 = box-impl3;
            box-impl = obj48;
        }
        return obj.copy-CXVQc50(color-0d7_KjU, obj24, fontSize-XSAIIZE, obj26, fontWeight, fontStyle-4Lr2A7w, fontSynthesis-ZQGJjVo, fontFamily, fontFeatureSettings, letterSpacing-XSAIIZE, l13, baselineShift-5SSeXJ0, textGeometricTransform, localeList, background-0d7_KjU, l18, obj24, shadow, box-impl2, obj25, lineHeight-XSAIIZE, i24);
    }

    public static androidx.compose.ui.text.TextStyle copy-HL5avdY$default(androidx.compose.ui.text.TextStyle textStyle, long l2, long l3, FontWeight fontWeight4, FontStyle fontStyle5, FontSynthesis fontSynthesis6, FontFamily fontFamily7, String string8, long l9, BaselineShift baselineShift10, TextGeometricTransform textGeometricTransform11, LocaleList localeList12, long l13, TextDecoration textDecoration14, Shadow shadow15, TextAlign textAlign16, TextDirection textDirection17, long l18, TextIndent textIndent19, int i20, Object object21) {
        TextDirection paragraphStyle;
        TextIndent textIndent;
        long color-0d7_KjU;
        long background-0d7_KjU;
        TextDecoration textDecoration;
        TextAlign box-impl;
        Shadow shadow;
        long fontSize-XSAIIZE;
        Object fontWeight;
        FontStyle fontStyle-4Lr2A7w;
        FontSynthesis fontSynthesis-ZQGJjVo;
        FontFamily fontFamily;
        String fontFeatureSettings;
        long letterSpacing-XSAIIZE;
        BaselineShift baselineShift-5SSeXJ0;
        TextGeometricTransform textGeometricTransform;
        LocaleList localeList;
        long lineHeight-XSAIIZE;
        TextDirection obj24;
        Object obj = textStyle;
        int i = obj44;
        if (i & 1 != 0) {
            color-0d7_KjU = obj.spanStyle.getColor-0d7_KjU();
        } else {
            color-0d7_KjU = l2;
        }
        if (i & 2 != 0) {
            fontSize-XSAIIZE = obj.spanStyle.getFontSize-XSAIIZE();
        } else {
            fontSize-XSAIIZE = fontWeight4;
        }
        if (i & 4 != 0) {
            fontWeight = obj.spanStyle.getFontWeight();
        } else {
            fontWeight = fontSynthesis6;
        }
        if (i & 8 != 0) {
            fontStyle-4Lr2A7w = obj.spanStyle.getFontStyle-4Lr2A7w();
        } else {
            fontStyle-4Lr2A7w = fontFamily7;
        }
        if (i & 16 != 0) {
            fontSynthesis-ZQGJjVo = obj.spanStyle.getFontSynthesis-ZQGJjVo();
        } else {
            fontSynthesis-ZQGJjVo = string8;
        }
        if (i & 32 != 0) {
            fontFamily = obj.spanStyle.getFontFamily();
        } else {
            fontFamily = l9;
        }
        if (i & 64 != 0) {
            fontFeatureSettings = obj.spanStyle.getFontFeatureSettings();
        } else {
            fontFeatureSettings = baselineShift10;
        }
        if (i & 128 != 0) {
            letterSpacing-XSAIIZE = obj.spanStyle.getLetterSpacing-XSAIIZE();
        } else {
            letterSpacing-XSAIIZE = textGeometricTransform11;
        }
        if (i & 256 != 0) {
            baselineShift-5SSeXJ0 = obj.spanStyle.getBaselineShift-5SSeXJ0();
        } else {
            baselineShift-5SSeXJ0 = l13;
        }
        if (i & 512 != 0) {
            textGeometricTransform = obj.spanStyle.getTextGeometricTransform();
        } else {
            textGeometricTransform = textDecoration14;
        }
        if (i & 1024 != 0) {
            localeList = obj.spanStyle.getLocaleList();
        } else {
            localeList = shadow15;
        }
        if (i & 2048 != 0) {
            background-0d7_KjU = obj.spanStyle.getBackground-0d7_KjU();
        } else {
            background-0d7_KjU = textAlign16;
        }
        if (i & 4096 != 0) {
            textDecoration = obj.spanStyle.getTextDecoration();
        } else {
            textDecoration = l18;
        }
        if (i & 8192 != 0) {
            shadow = obj.spanStyle.getShadow();
        } else {
            shadow = textIndent19;
        }
        final TextDecoration obj23 = textDecoration;
        if (i & 16384 != 0) {
            box-impl = TextAlign.box-impl(obj.paragraphStyle.getTextAlign-e0LSkKk());
        } else {
            box-impl = i20;
        }
        if (i & i19 != 0) {
            paragraphStyle = TextDirection.box-impl(obj.paragraphStyle.getTextDirection-s_7X-co());
        } else {
            paragraphStyle = object21;
        }
        if (obj44 & i22 != 0) {
            obj24 = paragraphStyle;
            lineHeight-XSAIIZE = obj.paragraphStyle.getLineHeight-XSAIIZE();
        } else {
            obj24 = paragraphStyle;
            lineHeight-XSAIIZE = obj41;
        }
        if (obj44 & i2 != 0) {
            textIndent = obj.paragraphStyle.getTextIndent();
        } else {
            textIndent = obj43;
        }
        return obj.copy-HL5avdY(color-0d7_KjU, obj23, fontSize-XSAIIZE, fontSynthesis6, fontWeight, fontStyle-4Lr2A7w, fontSynthesis-ZQGJjVo, fontFamily, fontFeatureSettings, letterSpacing-XSAIIZE, l13, baselineShift-5SSeXJ0, textGeometricTransform, localeList, background-0d7_KjU, l18, obj23, shadow);
    }

    public static androidx.compose.ui.text.TextStyle copy-NOaFTUo$default(androidx.compose.ui.text.TextStyle textStyle, long l2, long l3, FontWeight fontWeight4, FontStyle fontStyle5, FontSynthesis fontSynthesis6, FontFamily fontFamily7, String string8, long l9, BaselineShift baselineShift10, TextGeometricTransform textGeometricTransform11, LocaleList localeList12, long l13, TextDecoration textDecoration14, Shadow shadow15, TextAlign textAlign16, TextDirection textDirection17, long l18, TextIndent textIndent19, androidx.compose.ui.text.PlatformTextStyle platformTextStyle20, LineHeightStyle lineHeightStyle21, int i22, Object object23) {
        TextDirection paragraphStyle;
        TextIndent textIndent;
        androidx.compose.ui.text.PlatformTextStyle platformStyle;
        LineHeightStyle lineHeightStyle;
        long color-0d7_KjU;
        long background-0d7_KjU;
        TextDecoration textDecoration;
        TextAlign box-impl;
        Shadow shadow;
        long fontSize-XSAIIZE;
        FontWeight fontWeight;
        FontStyle fontStyle-4Lr2A7w;
        FontSynthesis fontSynthesis-ZQGJjVo;
        FontFamily fontFamily;
        String fontFeatureSettings;
        long letterSpacing-XSAIIZE;
        BaselineShift baselineShift-5SSeXJ0;
        TextGeometricTransform textGeometricTransform;
        LocaleList localeList;
        long lineHeight-XSAIIZE;
        TextDirection obj25;
        TextIndent obj26;
        androidx.compose.ui.text.PlatformTextStyle obj27;
        Object obj = textStyle;
        int i = obj47;
        if (i & 1 != 0) {
            color-0d7_KjU = obj.spanStyle.getColor-0d7_KjU();
        } else {
            color-0d7_KjU = l2;
        }
        if (i & 2 != 0) {
            fontSize-XSAIIZE = obj.spanStyle.getFontSize-XSAIIZE();
        } else {
            fontSize-XSAIIZE = fontWeight4;
        }
        if (i & 4 != 0) {
            fontWeight = obj.spanStyle.getFontWeight();
        } else {
            fontWeight = fontSynthesis6;
        }
        if (i & 8 != 0) {
            fontStyle-4Lr2A7w = obj.spanStyle.getFontStyle-4Lr2A7w();
        } else {
            fontStyle-4Lr2A7w = fontFamily7;
        }
        if (i & 16 != 0) {
            fontSynthesis-ZQGJjVo = obj.spanStyle.getFontSynthesis-ZQGJjVo();
        } else {
            fontSynthesis-ZQGJjVo = string8;
        }
        if (i & 32 != 0) {
            fontFamily = obj.spanStyle.getFontFamily();
        } else {
            fontFamily = l9;
        }
        if (i & 64 != 0) {
            fontFeatureSettings = obj.spanStyle.getFontFeatureSettings();
        } else {
            fontFeatureSettings = baselineShift10;
        }
        if (i & 128 != 0) {
            letterSpacing-XSAIIZE = obj.spanStyle.getLetterSpacing-XSAIIZE();
        } else {
            letterSpacing-XSAIIZE = textGeometricTransform11;
        }
        if (i & 256 != 0) {
            baselineShift-5SSeXJ0 = obj.spanStyle.getBaselineShift-5SSeXJ0();
        } else {
            baselineShift-5SSeXJ0 = l13;
        }
        if (i & 512 != 0) {
            textGeometricTransform = obj.spanStyle.getTextGeometricTransform();
        } else {
            textGeometricTransform = textDecoration14;
        }
        if (i & 1024 != 0) {
            localeList = obj.spanStyle.getLocaleList();
        } else {
            localeList = shadow15;
        }
        if (i & 2048 != 0) {
            background-0d7_KjU = obj.spanStyle.getBackground-0d7_KjU();
        } else {
            background-0d7_KjU = textAlign16;
        }
        if (i & 4096 != 0) {
            textDecoration = obj.spanStyle.getTextDecoration();
        } else {
            textDecoration = l18;
        }
        if (i & 8192 != 0) {
            shadow = obj.spanStyle.getShadow();
        } else {
            shadow = textIndent19;
        }
        final TextDecoration obj24 = textDecoration;
        if (i & 16384 != 0) {
            box-impl = TextAlign.box-impl(obj.paragraphStyle.getTextAlign-e0LSkKk());
        } else {
            box-impl = platformTextStyle20;
        }
        if (i & i19 != 0) {
            paragraphStyle = TextDirection.box-impl(obj.paragraphStyle.getTextDirection-s_7X-co());
        } else {
            paragraphStyle = lineHeightStyle21;
        }
        if (obj47 & i21 != 0) {
            obj25 = paragraphStyle;
            lineHeight-XSAIIZE = obj.paragraphStyle.getLineHeight-XSAIIZE();
        } else {
            obj25 = paragraphStyle;
            lineHeight-XSAIIZE = i22;
        }
        if (obj47 & i2 != 0) {
            textIndent = obj.paragraphStyle.getTextIndent();
        } else {
            textIndent = obj44;
        }
        platformStyle = obj47 & i24 != 0 ? obj.platformStyle : obj45;
        if (obj47 & i26 != 0) {
            obj27 = platformStyle;
            lineHeightStyle = obj.paragraphStyle.getLineHeightStyle();
        } else {
            obj27 = platformStyle;
            lineHeightStyle = obj46;
        }
        return obj.copy-NOaFTUo(color-0d7_KjU, obj24, fontSize-XSAIIZE, obj26, fontWeight, fontStyle-4Lr2A7w, fontSynthesis-ZQGJjVo, fontFamily, fontFeatureSettings, letterSpacing-XSAIIZE, l13, baselineShift-5SSeXJ0, textGeometricTransform, localeList, background-0d7_KjU, l18, obj24, shadow, box-impl, obj25);
    }

    public static androidx.compose.ui.text.TextStyle copy-Ns73l9s$default(androidx.compose.ui.text.TextStyle textStyle, Brush brush2, float f3, long l4, FontWeight fontWeight5, FontStyle fontStyle6, FontSynthesis fontSynthesis7, FontFamily fontFamily8, String string9, long l10, BaselineShift baselineShift11, TextGeometricTransform textGeometricTransform12, LocaleList localeList13, long l14, TextDecoration textDecoration15, Shadow shadow16, DrawStyle drawStyle17, int i18, int i19, long l20, TextIndent textIndent21, androidx.compose.ui.text.PlatformTextStyle platformTextStyle22, LineHeightStyle lineHeightStyle23, int i24, int i25, TextMotion textMotion26, int i27, Object object28) {
        DrawStyle drawStyle;
        int textAlign-e0LSkKk;
        int textDirection-s_7X-co;
        TextIndent textIndent;
        androidx.compose.ui.text.PlatformTextStyle platformStyle;
        LineHeightStyle lineHeightStyle;
        int lineBreak-rAG3T2k;
        int hyphens-vmbZdU8;
        TextMotion textMotion;
        float alpha;
        TextDecoration textDecoration;
        Object shadow;
        long fontSize-XSAIIZE;
        FontWeight fontWeight;
        FontStyle fontStyle-4Lr2A7w;
        FontSynthesis fontSynthesis-ZQGJjVo;
        FontFamily fontFamily;
        String fontFeatureSettings;
        long letterSpacing-XSAIIZE;
        BaselineShift baselineShift-5SSeXJ0;
        TextGeometricTransform textGeometricTransform;
        LocaleList localeList;
        long background-0d7_KjU;
        long lineHeight-XSAIIZE;
        DrawStyle obj24;
        int obj25;
        int obj26;
        TextIndent obj27;
        androidx.compose.ui.text.PlatformTextStyle obj28;
        LineHeightStyle obj29;
        int obj30;
        int obj31;
        Object obj = textStyle;
        int i = obj50;
        if (i & 2 != 0) {
            alpha = obj.spanStyle.getAlpha();
        } else {
            alpha = f3;
        }
        if (i & 4 != 0) {
            fontSize-XSAIIZE = obj.spanStyle.getFontSize-XSAIIZE();
        } else {
            fontSize-XSAIIZE = l4;
        }
        if (i & 8 != 0) {
            fontWeight = obj.spanStyle.getFontWeight();
        } else {
            fontWeight = fontStyle6;
        }
        if (i & 16 != 0) {
            fontStyle-4Lr2A7w = obj.spanStyle.getFontStyle-4Lr2A7w();
        } else {
            fontStyle-4Lr2A7w = fontSynthesis7;
        }
        if (i & 32 != 0) {
            fontSynthesis-ZQGJjVo = obj.spanStyle.getFontSynthesis-ZQGJjVo();
        } else {
            fontSynthesis-ZQGJjVo = fontFamily8;
        }
        if (i & 64 != 0) {
            fontFamily = obj.spanStyle.getFontFamily();
        } else {
            fontFamily = string9;
        }
        if (i & 128 != 0) {
            fontFeatureSettings = obj.spanStyle.getFontFeatureSettings();
        } else {
            fontFeatureSettings = l10;
        }
        if (i & 256 != 0) {
            letterSpacing-XSAIIZE = obj.spanStyle.getLetterSpacing-XSAIIZE();
        } else {
            letterSpacing-XSAIIZE = baselineShift11;
        }
        if (i & 512 != 0) {
            baselineShift-5SSeXJ0 = obj.spanStyle.getBaselineShift-5SSeXJ0();
        } else {
            baselineShift-5SSeXJ0 = localeList13;
        }
        if (i & 1024 != 0) {
            textGeometricTransform = obj.spanStyle.getTextGeometricTransform();
        } else {
            textGeometricTransform = l14;
        }
        if (i & 2048 != 0) {
            localeList = obj.spanStyle.getLocaleList();
        } else {
            localeList = textDecoration15;
        }
        if (i & 4096 != 0) {
            background-0d7_KjU = obj.spanStyle.getBackground-0d7_KjU();
        } else {
            background-0d7_KjU = shadow16;
        }
        if (i & 8192 != 0) {
            textDecoration = obj.spanStyle.getTextDecoration();
        } else {
            textDecoration = i18;
        }
        if (i & 16384 != 0) {
            shadow = obj.spanStyle.getShadow();
        } else {
            shadow = i19;
        }
        if (i & i20 != 0) {
            drawStyle = obj.spanStyle.getDrawStyle();
        } else {
            drawStyle = l20;
        }
        if (obj50 & i22 != 0) {
            obj24 = drawStyle;
            textAlign-e0LSkKk = obj.paragraphStyle.getTextAlign-e0LSkKk();
        } else {
            obj24 = drawStyle;
            textAlign-e0LSkKk = textIndent21;
        }
        if (obj50 & i26 != 0) {
            obj25 = textAlign-e0LSkKk;
            textDirection-s_7X-co = obj.paragraphStyle.getTextDirection-s_7X-co();
        } else {
            obj25 = textAlign-e0LSkKk;
            textDirection-s_7X-co = platformTextStyle22;
        }
        if (obj50 & i29 != 0) {
            obj26 = textDirection-s_7X-co;
            lineHeight-XSAIIZE = obj.paragraphStyle.getLineHeight-XSAIIZE();
        } else {
            obj26 = textDirection-s_7X-co;
            lineHeight-XSAIIZE = lineHeightStyle23;
        }
        if (obj50 & i2 != 0) {
            textIndent = obj.paragraphStyle.getTextIndent();
        } else {
            textIndent = i25;
        }
        platformStyle = obj50 & i31 != 0 ? obj.platformStyle : textMotion26;
        if (obj50 & i33 != 0) {
            obj28 = platformStyle;
            lineHeightStyle = obj.paragraphStyle.getLineHeightStyle();
        } else {
            obj28 = platformStyle;
            lineHeightStyle = i27;
        }
        if (obj50 & i35 != 0) {
            obj29 = lineHeightStyle;
            lineBreak-rAG3T2k = obj.paragraphStyle.getLineBreak-rAG3T2k();
        } else {
            obj29 = lineHeightStyle;
            lineBreak-rAG3T2k = object28;
        }
        if (obj50 & i37 != 0) {
            obj30 = lineBreak-rAG3T2k;
            hyphens-vmbZdU8 = obj.paragraphStyle.getHyphens-vmbZdU8();
        } else {
            obj30 = lineBreak-rAG3T2k;
            hyphens-vmbZdU8 = obj48;
        }
        if (obj50 & i39 != 0) {
            obj31 = hyphens-vmbZdU8;
            textMotion = obj.paragraphStyle.getTextMotion();
        } else {
            obj31 = hyphens-vmbZdU8;
            textMotion = obj49;
        }
        return obj.copy-Ns73l9s(brush2, alpha, fontSize-XSAIIZE, obj26, fontWeight, fontStyle-4Lr2A7w, fontSynthesis-ZQGJjVo, fontFamily, fontFeatureSettings, letterSpacing-XSAIIZE, l14, baselineShift-5SSeXJ0, textGeometricTransform, localeList, background-0d7_KjU, i19, textDecoration, shadow, obj24, obj25, obj26, lineHeight-XSAIIZE, textMotion26, obj27, obj28);
    }

    public static androidx.compose.ui.text.TextStyle copy-aIRg9q4$default(androidx.compose.ui.text.TextStyle textStyle, Brush brush2, float f3, long l4, FontWeight fontWeight5, FontStyle fontStyle6, FontSynthesis fontSynthesis7, FontFamily fontFamily8, String string9, long l10, BaselineShift baselineShift11, TextGeometricTransform textGeometricTransform12, LocaleList localeList13, long l14, TextDecoration textDecoration15, Shadow shadow16, DrawStyle drawStyle17, TextAlign textAlign18, TextDirection textDirection19, long l20, TextIndent textIndent21, androidx.compose.ui.text.PlatformTextStyle platformTextStyle22, LineHeightStyle lineHeightStyle23, LineBreak lineBreak24, Hyphens hyphens25, TextMotion textMotion26, int i27, Object object28) {
        DrawStyle drawStyle;
        TextAlign box-impl2;
        TextDirection paragraphStyle;
        TextIndent textIndent;
        Object platformStyle;
        LineHeightStyle lineHeightStyle;
        LineBreak box-impl;
        Hyphens box-impl3;
        TextMotion textMotion;
        float alpha;
        TextDecoration textDecoration;
        Object shadow;
        long fontSize-XSAIIZE;
        FontWeight fontWeight;
        FontStyle fontStyle-4Lr2A7w;
        FontSynthesis fontSynthesis-ZQGJjVo;
        FontFamily fontFamily;
        String fontFeatureSettings;
        long letterSpacing-XSAIIZE;
        BaselineShift baselineShift-5SSeXJ0;
        TextGeometricTransform textGeometricTransform;
        LocaleList localeList;
        long background-0d7_KjU;
        long lineHeight-XSAIIZE;
        DrawStyle obj24;
        TextAlign obj25;
        TextDirection obj26;
        TextIndent obj27;
        androidx.compose.ui.text.PlatformTextStyle obj28;
        LineHeightStyle obj29;
        LineBreak obj30;
        Hyphens obj31;
        Object obj = textStyle;
        int i = obj50;
        if (i & 2 != 0) {
            alpha = obj.spanStyle.getAlpha();
        } else {
            alpha = f3;
        }
        if (i & 4 != 0) {
            fontSize-XSAIIZE = obj.spanStyle.getFontSize-XSAIIZE();
        } else {
            fontSize-XSAIIZE = l4;
        }
        if (i & 8 != 0) {
            fontWeight = obj.spanStyle.getFontWeight();
        } else {
            fontWeight = fontStyle6;
        }
        if (i & 16 != 0) {
            fontStyle-4Lr2A7w = obj.spanStyle.getFontStyle-4Lr2A7w();
        } else {
            fontStyle-4Lr2A7w = fontSynthesis7;
        }
        if (i & 32 != 0) {
            fontSynthesis-ZQGJjVo = obj.spanStyle.getFontSynthesis-ZQGJjVo();
        } else {
            fontSynthesis-ZQGJjVo = fontFamily8;
        }
        if (i & 64 != 0) {
            fontFamily = obj.spanStyle.getFontFamily();
        } else {
            fontFamily = string9;
        }
        if (i & 128 != 0) {
            fontFeatureSettings = obj.spanStyle.getFontFeatureSettings();
        } else {
            fontFeatureSettings = l10;
        }
        if (i & 256 != 0) {
            letterSpacing-XSAIIZE = obj.spanStyle.getLetterSpacing-XSAIIZE();
        } else {
            letterSpacing-XSAIIZE = baselineShift11;
        }
        if (i & 512 != 0) {
            baselineShift-5SSeXJ0 = obj.spanStyle.getBaselineShift-5SSeXJ0();
        } else {
            baselineShift-5SSeXJ0 = localeList13;
        }
        if (i & 1024 != 0) {
            textGeometricTransform = obj.spanStyle.getTextGeometricTransform();
        } else {
            textGeometricTransform = l14;
        }
        if (i & 2048 != 0) {
            localeList = obj.spanStyle.getLocaleList();
        } else {
            localeList = textDecoration15;
        }
        if (i & 4096 != 0) {
            background-0d7_KjU = obj.spanStyle.getBackground-0d7_KjU();
        } else {
            background-0d7_KjU = shadow16;
        }
        if (i & 8192 != 0) {
            textDecoration = obj.spanStyle.getTextDecoration();
        } else {
            textDecoration = textAlign18;
        }
        if (i & 16384 != 0) {
            shadow = obj.spanStyle.getShadow();
        } else {
            shadow = textDirection19;
        }
        if (i & i18 != 0) {
            drawStyle = obj.spanStyle.getDrawStyle();
        } else {
            drawStyle = l20;
        }
        if (obj50 & i20 != 0) {
            obj24 = drawStyle;
            box-impl2 = TextAlign.box-impl(obj.paragraphStyle.getTextAlign-e0LSkKk());
        } else {
            obj24 = drawStyle;
            box-impl2 = textIndent21;
        }
        if (obj50 & i22 != 0) {
            obj25 = box-impl2;
            paragraphStyle = TextDirection.box-impl(obj.paragraphStyle.getTextDirection-s_7X-co());
        } else {
            obj25 = box-impl2;
            paragraphStyle = platformTextStyle22;
        }
        if (obj50 & i24 != 0) {
            obj26 = paragraphStyle;
            lineHeight-XSAIIZE = obj.paragraphStyle.getLineHeight-XSAIIZE();
        } else {
            obj26 = paragraphStyle;
            lineHeight-XSAIIZE = lineHeightStyle23;
        }
        if (obj50 & i2 != 0) {
            textIndent = obj.paragraphStyle.getTextIndent();
        } else {
            textIndent = hyphens25;
        }
        platformStyle = obj50 & i26 != 0 ? obj.platformStyle : textMotion26;
        if (obj50 & i29 != 0) {
            obj28 = platformStyle;
            lineHeightStyle = obj.paragraphStyle.getLineHeightStyle();
        } else {
            obj28 = platformStyle;
            lineHeightStyle = i27;
        }
        if (obj50 & i31 != 0) {
            obj29 = lineHeightStyle;
            box-impl = LineBreak.box-impl(obj.paragraphStyle.getLineBreak-rAG3T2k());
        } else {
            obj29 = lineHeightStyle;
            box-impl = object28;
        }
        if (obj50 & i33 != 0) {
            obj30 = box-impl;
            box-impl3 = Hyphens.box-impl(obj.paragraphStyle.getHyphens-vmbZdU8());
        } else {
            obj30 = box-impl;
            box-impl3 = obj48;
        }
        if (obj50 & i35 != 0) {
            obj31 = box-impl3;
            textMotion = obj.paragraphStyle.getTextMotion();
        } else {
            obj31 = box-impl3;
            textMotion = obj49;
        }
        return obj.copy-aIRg9q4(brush2, alpha, fontSize-XSAIIZE, obj26, fontWeight, fontStyle-4Lr2A7w, fontSynthesis-ZQGJjVo, fontFamily, fontFeatureSettings, letterSpacing-XSAIIZE, l14, baselineShift-5SSeXJ0, textGeometricTransform, localeList, background-0d7_KjU, textDirection19, textDecoration, shadow, obj24, obj25, obj26, lineHeight-XSAIIZE, textMotion26, obj27, obj28);
    }

    public static androidx.compose.ui.text.TextStyle copy-p1EtxEg$default(androidx.compose.ui.text.TextStyle textStyle, long l2, long l3, FontWeight fontWeight4, FontStyle fontStyle5, FontSynthesis fontSynthesis6, FontFamily fontFamily7, String string8, long l9, BaselineShift baselineShift10, TextGeometricTransform textGeometricTransform11, LocaleList localeList12, long l13, TextDecoration textDecoration14, Shadow shadow15, DrawStyle drawStyle16, int i17, int i18, long l19, TextIndent textIndent20, androidx.compose.ui.text.PlatformTextStyle platformTextStyle21, LineHeightStyle lineHeightStyle22, int i23, int i24, TextMotion textMotion25, int i26, Object object27) {
        int textAlign-e0LSkKk;
        int textDirection-s_7X-co;
        TextIndent textIndent;
        androidx.compose.ui.text.PlatformTextStyle platformStyle;
        LineHeightStyle lineHeightStyle;
        int lineBreak-rAG3T2k;
        int hyphens-vmbZdU8;
        TextMotion textMotion;
        long color-0d7_KjU;
        long background-0d7_KjU;
        TextDecoration textDecoration;
        DrawStyle drawStyle;
        Shadow shadow;
        long fontSize-XSAIIZE;
        FontWeight fontWeight;
        FontStyle fontStyle-4Lr2A7w;
        FontSynthesis fontSynthesis-ZQGJjVo;
        FontFamily fontFamily;
        String fontFeatureSettings;
        long letterSpacing-XSAIIZE;
        BaselineShift baselineShift-5SSeXJ0;
        TextGeometricTransform textGeometricTransform;
        LocaleList localeList;
        long lineHeight-XSAIIZE;
        int obj25;
        int obj26;
        TextIndent obj27;
        androidx.compose.ui.text.PlatformTextStyle obj28;
        LineHeightStyle obj29;
        int obj30;
        int obj31;
        Object obj = textStyle;
        int i = obj51;
        if (i & 1 != 0) {
            color-0d7_KjU = obj.spanStyle.getColor-0d7_KjU();
        } else {
            color-0d7_KjU = l2;
        }
        if (i & 2 != 0) {
            fontSize-XSAIIZE = obj.spanStyle.getFontSize-XSAIIZE();
        } else {
            fontSize-XSAIIZE = fontWeight4;
        }
        if (i & 4 != 0) {
            fontWeight = obj.spanStyle.getFontWeight();
        } else {
            fontWeight = fontSynthesis6;
        }
        if (i & 8 != 0) {
            fontStyle-4Lr2A7w = obj.spanStyle.getFontStyle-4Lr2A7w();
        } else {
            fontStyle-4Lr2A7w = fontFamily7;
        }
        if (i & 16 != 0) {
            fontSynthesis-ZQGJjVo = obj.spanStyle.getFontSynthesis-ZQGJjVo();
        } else {
            fontSynthesis-ZQGJjVo = string8;
        }
        if (i & 32 != 0) {
            fontFamily = obj.spanStyle.getFontFamily();
        } else {
            fontFamily = l9;
        }
        if (i & 64 != 0) {
            fontFeatureSettings = obj.spanStyle.getFontFeatureSettings();
        } else {
            fontFeatureSettings = baselineShift10;
        }
        if (i & 128 != 0) {
            letterSpacing-XSAIIZE = obj.spanStyle.getLetterSpacing-XSAIIZE();
        } else {
            letterSpacing-XSAIIZE = textGeometricTransform11;
        }
        if (i & 256 != 0) {
            baselineShift-5SSeXJ0 = obj.spanStyle.getBaselineShift-5SSeXJ0();
        } else {
            baselineShift-5SSeXJ0 = l13;
        }
        if (i & 512 != 0) {
            textGeometricTransform = obj.spanStyle.getTextGeometricTransform();
        } else {
            textGeometricTransform = textDecoration14;
        }
        if (i & 1024 != 0) {
            localeList = obj.spanStyle.getLocaleList();
        } else {
            localeList = shadow15;
        }
        if (i & 2048 != 0) {
            background-0d7_KjU = obj.spanStyle.getBackground-0d7_KjU();
        } else {
            background-0d7_KjU = drawStyle16;
        }
        if (i & 4096 != 0) {
            textDecoration = obj.spanStyle.getTextDecoration();
        } else {
            textDecoration = i18;
        }
        if (i & 8192 != 0) {
            shadow = obj.spanStyle.getShadow();
        } else {
            shadow = l19;
        }
        final TextDecoration obj24 = textDecoration;
        if (i & 16384 != 0) {
            drawStyle = obj.spanStyle.getDrawStyle();
        } else {
            drawStyle = textIndent20;
        }
        if (i & i21 != 0) {
            textAlign-e0LSkKk = obj.paragraphStyle.getTextAlign-e0LSkKk();
        } else {
            textAlign-e0LSkKk = platformTextStyle21;
        }
        if (obj51 & i25 != 0) {
            obj25 = textAlign-e0LSkKk;
            textDirection-s_7X-co = obj.paragraphStyle.getTextDirection-s_7X-co();
        } else {
            obj25 = textAlign-e0LSkKk;
            textDirection-s_7X-co = lineHeightStyle22;
        }
        if (obj51 & i28 != 0) {
            obj26 = textDirection-s_7X-co;
            lineHeight-XSAIIZE = obj.paragraphStyle.getLineHeight-XSAIIZE();
        } else {
            obj26 = textDirection-s_7X-co;
            lineHeight-XSAIIZE = i23;
        }
        if (obj51 & i2 != 0) {
            textIndent = obj.paragraphStyle.getTextIndent();
        } else {
            textIndent = textMotion25;
        }
        platformStyle = obj51 & i30 != 0 ? obj.platformStyle : i26;
        if (obj51 & i32 != 0) {
            obj28 = platformStyle;
            lineHeightStyle = obj.paragraphStyle.getLineHeightStyle();
        } else {
            obj28 = platformStyle;
            lineHeightStyle = object27;
        }
        if (obj51 & i34 != 0) {
            obj29 = lineHeightStyle;
            lineBreak-rAG3T2k = obj.paragraphStyle.getLineBreak-rAG3T2k();
        } else {
            obj29 = lineHeightStyle;
            lineBreak-rAG3T2k = obj48;
        }
        if (obj51 & i36 != 0) {
            obj30 = lineBreak-rAG3T2k;
            hyphens-vmbZdU8 = obj.paragraphStyle.getHyphens-vmbZdU8();
        } else {
            obj30 = lineBreak-rAG3T2k;
            hyphens-vmbZdU8 = obj49;
        }
        if (obj51 & i38 != 0) {
            obj31 = hyphens-vmbZdU8;
            textMotion = obj.paragraphStyle.getTextMotion();
        } else {
            obj31 = hyphens-vmbZdU8;
            textMotion = obj50;
        }
        return obj.copy-p1EtxEg(color-0d7_KjU, obj24, fontSize-XSAIIZE, obj26, fontWeight, fontStyle-4Lr2A7w, fontSynthesis-ZQGJjVo, fontFamily, fontFeatureSettings, letterSpacing-XSAIIZE, l13, baselineShift-5SSeXJ0, textGeometricTransform, localeList, background-0d7_KjU, i18, obj24, shadow, drawStyle, obj25, obj26, lineHeight-XSAIIZE, textMotion25, obj27);
    }

    public static androidx.compose.ui.text.TextStyle copy-v2rsoow$default(androidx.compose.ui.text.TextStyle textStyle, long l2, long l3, FontWeight fontWeight4, FontStyle fontStyle5, FontSynthesis fontSynthesis6, FontFamily fontFamily7, String string8, long l9, BaselineShift baselineShift10, TextGeometricTransform textGeometricTransform11, LocaleList localeList12, long l13, TextDecoration textDecoration14, Shadow shadow15, DrawStyle drawStyle16, TextAlign textAlign17, TextDirection textDirection18, long l19, TextIndent textIndent20, androidx.compose.ui.text.PlatformTextStyle platformTextStyle21, LineHeightStyle lineHeightStyle22, LineBreak lineBreak23, Hyphens hyphens24, TextMotion textMotion25, int i26, Object object27) {
        TextAlign box-impl3;
        TextDirection paragraphStyle;
        Object textIndent;
        androidx.compose.ui.text.PlatformTextStyle platformStyle;
        LineHeightStyle lineHeightStyle;
        LineBreak box-impl;
        Hyphens box-impl2;
        TextMotion textMotion;
        long color-0d7_KjU;
        long background-0d7_KjU;
        TextDecoration textDecoration;
        DrawStyle drawStyle;
        Shadow shadow;
        long fontSize-XSAIIZE;
        FontWeight fontWeight;
        FontStyle fontStyle-4Lr2A7w;
        FontSynthesis fontSynthesis-ZQGJjVo;
        FontFamily fontFamily;
        String fontFeatureSettings;
        long letterSpacing-XSAIIZE;
        BaselineShift baselineShift-5SSeXJ0;
        TextGeometricTransform textGeometricTransform;
        LocaleList localeList;
        long lineHeight-XSAIIZE;
        TextAlign obj25;
        TextDirection obj26;
        TextIndent obj27;
        androidx.compose.ui.text.PlatformTextStyle obj28;
        LineHeightStyle obj29;
        LineBreak obj30;
        Hyphens obj31;
        Object obj = textStyle;
        int i = obj51;
        if (i & 1 != 0) {
            color-0d7_KjU = obj.spanStyle.getColor-0d7_KjU();
        } else {
            color-0d7_KjU = l2;
        }
        if (i & 2 != 0) {
            fontSize-XSAIIZE = obj.spanStyle.getFontSize-XSAIIZE();
        } else {
            fontSize-XSAIIZE = fontWeight4;
        }
        if (i & 4 != 0) {
            fontWeight = obj.spanStyle.getFontWeight();
        } else {
            fontWeight = fontSynthesis6;
        }
        if (i & 8 != 0) {
            fontStyle-4Lr2A7w = obj.spanStyle.getFontStyle-4Lr2A7w();
        } else {
            fontStyle-4Lr2A7w = fontFamily7;
        }
        if (i & 16 != 0) {
            fontSynthesis-ZQGJjVo = obj.spanStyle.getFontSynthesis-ZQGJjVo();
        } else {
            fontSynthesis-ZQGJjVo = string8;
        }
        if (i & 32 != 0) {
            fontFamily = obj.spanStyle.getFontFamily();
        } else {
            fontFamily = l9;
        }
        if (i & 64 != 0) {
            fontFeatureSettings = obj.spanStyle.getFontFeatureSettings();
        } else {
            fontFeatureSettings = baselineShift10;
        }
        if (i & 128 != 0) {
            letterSpacing-XSAIIZE = obj.spanStyle.getLetterSpacing-XSAIIZE();
        } else {
            letterSpacing-XSAIIZE = textGeometricTransform11;
        }
        if (i & 256 != 0) {
            baselineShift-5SSeXJ0 = obj.spanStyle.getBaselineShift-5SSeXJ0();
        } else {
            baselineShift-5SSeXJ0 = l13;
        }
        if (i & 512 != 0) {
            textGeometricTransform = obj.spanStyle.getTextGeometricTransform();
        } else {
            textGeometricTransform = textDecoration14;
        }
        if (i & 1024 != 0) {
            localeList = obj.spanStyle.getLocaleList();
        } else {
            localeList = shadow15;
        }
        if (i & 2048 != 0) {
            background-0d7_KjU = obj.spanStyle.getBackground-0d7_KjU();
        } else {
            background-0d7_KjU = drawStyle16;
        }
        if (i & 4096 != 0) {
            textDecoration = obj.spanStyle.getTextDecoration();
        } else {
            textDecoration = textDirection18;
        }
        if (i & 8192 != 0) {
            shadow = obj.spanStyle.getShadow();
        } else {
            shadow = l19;
        }
        final TextDecoration obj24 = textDecoration;
        if (i & 16384 != 0) {
            drawStyle = obj.spanStyle.getDrawStyle();
        } else {
            drawStyle = textIndent20;
        }
        if (i & i19 != 0) {
            box-impl3 = TextAlign.box-impl(obj.paragraphStyle.getTextAlign-e0LSkKk());
        } else {
            box-impl3 = platformTextStyle21;
        }
        if (obj51 & i21 != 0) {
            obj25 = box-impl3;
            paragraphStyle = TextDirection.box-impl(obj.paragraphStyle.getTextDirection-s_7X-co());
        } else {
            obj25 = box-impl3;
            paragraphStyle = lineHeightStyle22;
        }
        if (obj51 & i23 != 0) {
            obj26 = paragraphStyle;
            lineHeight-XSAIIZE = obj.paragraphStyle.getLineHeight-XSAIIZE();
        } else {
            obj26 = paragraphStyle;
            lineHeight-XSAIIZE = lineBreak23;
        }
        if (obj51 & i2 != 0) {
            textIndent = obj.paragraphStyle.getTextIndent();
        } else {
            textIndent = textMotion25;
        }
        platformStyle = obj51 & i25 != 0 ? obj.platformStyle : i26;
        if (obj51 & i28 != 0) {
            obj28 = platformStyle;
            lineHeightStyle = obj.paragraphStyle.getLineHeightStyle();
        } else {
            obj28 = platformStyle;
            lineHeightStyle = object27;
        }
        if (obj51 & i30 != 0) {
            obj29 = lineHeightStyle;
            box-impl = LineBreak.box-impl(obj.paragraphStyle.getLineBreak-rAG3T2k());
        } else {
            obj29 = lineHeightStyle;
            box-impl = obj48;
        }
        if (obj51 & i32 != 0) {
            obj30 = box-impl;
            box-impl2 = Hyphens.box-impl(obj.paragraphStyle.getHyphens-vmbZdU8());
        } else {
            obj30 = box-impl;
            box-impl2 = obj49;
        }
        if (obj51 & i34 != 0) {
            obj31 = box-impl2;
            textMotion = obj.paragraphStyle.getTextMotion();
        } else {
            obj31 = box-impl2;
            textMotion = obj50;
        }
        return obj.copy-v2rsoow(color-0d7_KjU, obj24, fontSize-XSAIIZE, obj26, fontWeight, fontStyle-4Lr2A7w, fontSynthesis-ZQGJjVo, fontFamily, fontFeatureSettings, letterSpacing-XSAIIZE, l13, baselineShift-5SSeXJ0, textGeometricTransform, localeList, background-0d7_KjU, textDirection18, obj24, shadow, drawStyle, obj25, obj26, lineHeight-XSAIIZE, textMotion25, obj27);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    public static void getHyphens-EaSxIns$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    public static void getLineBreak-LgCVezo$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    public static void getTextAlign-buA522U$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    public static void getTextDirection-mmuk1to$annotations() {
    }

    public static androidx.compose.ui.text.TextStyle merge$default(androidx.compose.ui.text.TextStyle textStyle, androidx.compose.ui.text.TextStyle textStyle2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return textStyle.merge(obj1);
    }

    public static androidx.compose.ui.text.TextStyle merge-Z1GrekI$default(androidx.compose.ui.text.TextStyle textStyle, long l2, long l3, FontWeight fontWeight4, FontStyle fontStyle5, FontSynthesis fontSynthesis6, FontFamily fontFamily7, String string8, long l9, BaselineShift baselineShift10, TextGeometricTransform textGeometricTransform11, LocaleList localeList12, long l13, TextDecoration textDecoration14, Shadow shadow15, DrawStyle drawStyle16, TextAlign textAlign17, TextDirection textDirection18, long l19, TextIndent textIndent20, LineHeightStyle lineHeightStyle21, LineBreak lineBreak22, Hyphens hyphens23, androidx.compose.ui.text.PlatformTextStyle platformTextStyle24, TextMotion textMotion25, int i26, Object object27) {
        int i8;
        long unspecified-0d7_KjU2;
        int i15;
        int i5;
        long unspecified-XSAIIZE2;
        int i10;
        int companion;
        int i12;
        int i13;
        int i16;
        int i14;
        int i11;
        long unspecified-XSAIIZE3;
        int i7;
        int i9;
        int i17;
        long unspecified-0d7_KjU;
        int i18;
        int i6;
        long unspecified-XSAIIZE;
        int platformTextStyle;
        int i;
        int i2;
        int i3;
        int i4;
        int i19 = obj60;
        if (i19 & 1 != 0) {
            unspecified-0d7_KjU2 = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU2 = l2;
        }
        if (i19 & 2 != 0) {
            unspecified-XSAIIZE2 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE2 = fontWeight4;
        }
        i10 = i19 & 4 != 0 ? 0 : fontSynthesis6;
        i13 = i19 & 8 != 0 ? 0 : fontFamily7;
        i16 = i19 & 16 != 0 ? 0 : string8;
        i14 = i19 & 32 != 0 ? 0 : l9;
        i11 = i19 & 64 != 0 ? 0 : baselineShift10;
        if (i19 & 128 != 0) {
            unspecified-XSAIIZE3 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE3 = textGeometricTransform11;
        }
        i7 = i19 & 256 != 0 ? 0 : l13;
        i9 = i19 & 512 != 0 ? 0 : textDecoration14;
        i17 = i19 & 1024 != 0 ? 0 : shadow15;
        if (i19 & 2048 != 0) {
            unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU = drawStyle16;
        }
        i12 = i19 & 4096 != 0 ? 0 : textDirection18;
        i15 = i19 & 8192 != 0 ? 0 : l19;
        i5 = i19 & 16384 != 0 ? 0 : textIndent20;
        i18 = i19 & i36 != 0 ? 0 : lineHeightStyle21;
        i6 = i19 & i38 != 0 ? 0 : lineBreak22;
        if (i19 & i40 != 0) {
            unspecified-XSAIIZE = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE = hyphens23;
        }
        platformTextStyle = i19 & i42 != 0 ? 0 : textMotion25;
        i = i19 & i44 != 0 ? 0 : i26;
        i2 = i19 & i46 != 0 ? 0 : object27;
        i3 = i19 & i48 != 0 ? 0 : obj57;
        i4 = i19 & i50 != 0 ? 0 : obj58;
        i8 = i19 &= i52 != 0 ? 0 : obj59;
        return textStyle.merge-Z1GrekI(unspecified-0d7_KjU2, fontWeight4, unspecified-XSAIIZE2, fontSynthesis6, i10, i13, i16, i14, i11, unspecified-XSAIIZE3, l13, i7, i9, i17, unspecified-0d7_KjU, textDirection18, i12, i15, i5, i18, i6, unspecified-XSAIIZE, textMotion25, platformTextStyle);
    }

    public static androidx.compose.ui.text.TextStyle merge-dA7vx0o$default(androidx.compose.ui.text.TextStyle textStyle, long l2, long l3, FontWeight fontWeight4, FontStyle fontStyle5, FontSynthesis fontSynthesis6, FontFamily fontFamily7, String string8, long l9, BaselineShift baselineShift10, TextGeometricTransform textGeometricTransform11, LocaleList localeList12, long l13, TextDecoration textDecoration14, Shadow shadow15, DrawStyle drawStyle16, int i17, int i18, long l19, TextIndent textIndent20, LineHeightStyle lineHeightStyle21, int i22, int i23, androidx.compose.ui.text.PlatformTextStyle platformTextStyle24, TextMotion textMotion25, int i26, Object object27) {
        int i8;
        long unspecified-0d7_KjU;
        int i;
        int i7;
        long unspecified-XSAIIZE;
        int i9;
        int companion;
        int i12;
        int i2;
        int i10;
        int i4;
        int i13;
        long unspecified-XSAIIZE3;
        int i14;
        int i11;
        int i3;
        long unspecified-0d7_KjU2;
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        long unspecified-XSAIIZE2;
        int platformTextStyle;
        int i5;
        int unspecified-rAG3T2k;
        int unspecified-vmbZdU8;
        int i6;
        int i15 = obj60;
        if (i15 & 1 != 0) {
            unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU = l2;
        }
        if (i15 & 2 != 0) {
            unspecified-XSAIIZE = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE = fontWeight4;
        }
        i9 = i15 & 4 != 0 ? 0 : fontSynthesis6;
        i2 = i15 & 8 != 0 ? 0 : fontFamily7;
        i10 = i15 & 16 != 0 ? 0 : string8;
        i4 = i15 & 32 != 0 ? 0 : l9;
        i13 = i15 & 64 != 0 ? 0 : baselineShift10;
        if (i15 & 128 != 0) {
            unspecified-XSAIIZE3 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE3 = textGeometricTransform11;
        }
        i14 = i15 & 256 != 0 ? 0 : l13;
        i11 = i15 & 512 != 0 ? 0 : textDecoration14;
        i3 = i15 & 1024 != 0 ? 0 : shadow15;
        if (i15 & 2048 != 0) {
            unspecified-0d7_KjU2 = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU2 = drawStyle16;
        }
        i12 = i15 & 4096 != 0 ? 0 : i18;
        i = i15 & 8192 != 0 ? 0 : l19;
        i7 = i15 & 16384 != 0 ? 0 : textIndent20;
        if (i15 & i36 != 0) {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        } else {
            unspecified-e0LSkKk = lineHeightStyle21;
        }
        if (i15 & i38 != 0) {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        } else {
            unspecified-s_7X-co = i22;
        }
        if (i15 & i40 != 0) {
            unspecified-XSAIIZE2 = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE2 = i23;
        }
        platformTextStyle = i15 & i42 != 0 ? 0 : textMotion25;
        i5 = i15 & i44 != 0 ? 0 : i26;
        if (i15 & i46 != 0) {
            unspecified-rAG3T2k = LineBreak.Companion.getUnspecified-rAG3T2k();
        } else {
            unspecified-rAG3T2k = object27;
        }
        if (i15 & i48 != 0) {
            unspecified-vmbZdU8 = Hyphens.Companion.getUnspecified-vmbZdU8();
        } else {
            unspecified-vmbZdU8 = obj57;
        }
        i6 = i15 & i50 != 0 ? 0 : obj58;
        i8 = i15 &= i52 != 0 ? 0 : obj59;
        return textStyle.merge-dA7vx0o(unspecified-0d7_KjU, fontWeight4, unspecified-XSAIIZE, fontSynthesis6, i9, i2, i10, i4, i13, unspecified-XSAIIZE3, l13, i14, i11, i3, unspecified-0d7_KjU2, i18, i12, i, i7, unspecified-e0LSkKk, unspecified-s_7X-co, unspecified-XSAIIZE2, textMotion25, platformTextStyle);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle copy constructors that do not take new stable parameters like LineBreak, Hyphens, and TextMotion are deprecated. Please use the new stable copy constructor.")
    public final androidx.compose.ui.text.TextStyle copy-CXVQc50(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens) {
        TextForegroundStyle textForegroundStyle$ui_text_release;
        androidx.compose.ui.text.PlatformSpanStyle spanStyle;
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        int unspecified-rAG3T2k;
        int unbox-impl;
        androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle;
        int paragraphStyle;
        final Object obj = this;
        final long l = color;
        final androidx.compose.ui.text.PlatformTextStyle platformTextStyle = obj51;
        if (Color.equals-impl0(l, obj2)) {
            textForegroundStyle$ui_text_release = obj.spanStyle.getTextForegroundStyle$ui_text_release();
        } else {
            textForegroundStyle$ui_text_release = TextForegroundStyle.Companion.from-8_81llA(l);
        }
        if (platformTextStyle != null) {
            platformSpanStyle = spanStyle;
        } else {
            platformSpanStyle = paragraphStyle;
        }
        final FontSynthesis fontSynthesis2 = fontFamily;
        SpanStyle spanStyle2 = new SpanStyle(textForegroundStyle$ui_text_release, fontWeight, obj8, fontSynthesis, fontSynthesis2, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, obj15, background, textDecoration, shadow, textAlign, obj20, lineHeight, textIndent, platformSpanStyle, obj.getDrawStyle(), 0);
        if (platformStyle != null) {
            unspecified-e0LSkKk = platformStyle.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (lineHeightStyle != null) {
            unspecified-s_7X-co = lineHeightStyle.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        if (platformTextStyle != null) {
            paragraphStyle = platformTextStyle.getParagraphStyle();
        }
        if (obj53 != null) {
            unspecified-rAG3T2k = obj53.unbox-impl();
        } else {
            unspecified-rAG3T2k = LineBreak.Companion.getUnspecified-rAG3T2k();
        }
        if (obj54 != null) {
            unbox-impl = obj54.unbox-impl();
        } else {
            unbox-impl = Hyphens.Companion.getUnspecified-vmbZdU8();
        }
        ParagraphStyle paragraphStyle2 = new ParagraphStyle(unspecified-e0LSkKk, unspecified-s_7X-co, lineBreak, fontSynthesis2, obj50, paragraphStyle, obj52, unspecified-rAG3T2k, unbox-impl, obj.getTextMotion(), 0);
        TextStyle textStyle = new TextStyle(spanStyle2, paragraphStyle2, platformTextStyle);
        return textStyle;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    public final androidx.compose.ui.text.TextStyle copy-HL5avdY(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent) {
        TextForegroundStyle textForegroundStyle$ui_text_release;
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        final Object obj = this;
        final long l = color;
        if (Color.equals-impl0(l, obj2)) {
            textForegroundStyle$ui_text_release = obj.spanStyle.getTextForegroundStyle$ui_text_release();
        } else {
            textForegroundStyle$ui_text_release = TextForegroundStyle.Companion.from-8_81llA(l);
        }
        final FontSynthesis fontSynthesis2 = fontFamily;
        SpanStyle spanStyle = new SpanStyle(textForegroundStyle$ui_text_release, fontWeight, obj7, fontSynthesis, fontSynthesis2, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, obj14, background, textDecoration, shadow, textAlign, obj19, lineHeight, textIndent, obj.spanStyle.getPlatformStyle(), obj.spanStyle.getDrawStyle(), 0);
        if (obj44 != null) {
            unspecified-e0LSkKk = obj44.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (obj45 != null) {
            unspecified-s_7X-co = obj45.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        ParagraphStyle paragraphStyle = new ParagraphStyle(unspecified-e0LSkKk, unspecified-s_7X-co, obj46, fontSynthesis2, obj48, obj.paragraphStyle.getPlatformStyle(), obj.getLineHeightStyle(), obj.getLineBreak-rAG3T2k(), obj.getHyphens-vmbZdU8(), obj.getTextMotion(), 0);
        TextStyle textStyle = new TextStyle(spanStyle, paragraphStyle, obj.platformStyle);
        return textStyle;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    public final androidx.compose.ui.text.TextStyle copy-NOaFTUo(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle) {
        TextForegroundStyle textForegroundStyle$ui_text_release;
        androidx.compose.ui.text.PlatformSpanStyle spanStyle;
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle;
        int paragraphStyle;
        final Object obj = this;
        final long l = color;
        final androidx.compose.ui.text.PlatformTextStyle platformTextStyle = obj51;
        if (Color.equals-impl0(l, obj2)) {
            textForegroundStyle$ui_text_release = obj.spanStyle.getTextForegroundStyle$ui_text_release();
        } else {
            textForegroundStyle$ui_text_release = TextForegroundStyle.Companion.from-8_81llA(l);
        }
        if (platformTextStyle != null) {
            platformSpanStyle = spanStyle;
        } else {
            platformSpanStyle = paragraphStyle;
        }
        final FontSynthesis fontSynthesis2 = fontFamily;
        SpanStyle spanStyle2 = new SpanStyle(textForegroundStyle$ui_text_release, fontWeight, obj8, fontSynthesis, fontSynthesis2, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, obj15, background, textDecoration, shadow, textAlign, obj20, lineHeight, textIndent, platformSpanStyle, obj.spanStyle.getDrawStyle(), 0);
        if (platformStyle != null) {
            unspecified-e0LSkKk = platformStyle.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (lineHeightStyle != null) {
            unspecified-s_7X-co = lineHeightStyle.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        if (platformTextStyle != null) {
            paragraphStyle = platformTextStyle.getParagraphStyle();
        }
        ParagraphStyle paragraphStyle2 = new ParagraphStyle(unspecified-e0LSkKk, unspecified-s_7X-co, obj48, fontSynthesis2, obj50, paragraphStyle, obj52, obj.getLineBreak-rAG3T2k(), obj.getHyphens-vmbZdU8(), obj.getTextMotion(), 0);
        TextStyle textStyle = new TextStyle(spanStyle2, paragraphStyle2, platformTextStyle);
        return textStyle;
    }

    public final androidx.compose.ui.text.TextStyle copy-Ns73l9s(Brush brush, float alpha, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int textAlign, int textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, int lineBreak, int hyphens, TextMotion textMotion) {
        androidx.compose.ui.text.PlatformSpanStyle spanStyle;
        androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle;
        int paragraphStyle;
        final androidx.compose.ui.text.PlatformTextStyle platformTextStyle = textMotion;
        if (platformTextStyle != null) {
            platformSpanStyle = spanStyle;
        } else {
            platformSpanStyle = paragraphStyle;
        }
        final FontStyle fontStyle2 = fontStyle;
        SpanStyle spanStyle2 = new SpanStyle(brush, alpha, fontSize, obj6, fontStyle2, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, obj13, localeList, background, textDecoration, shadow, obj18, textAlign, textDirection, platformSpanStyle, lineHeight, 0);
        if (platformTextStyle != null) {
            paragraphStyle = platformTextStyle.getParagraphStyle();
        }
        ParagraphStyle paragraphStyle2 = new ParagraphStyle(textIndent, platformStyle, lineHeightStyle, fontStyle2, hyphens, paragraphStyle, obj51, obj52, obj53, obj54, 0);
        TextStyle textStyle = new TextStyle(spanStyle2, paragraphStyle2, platformTextStyle);
        return textStyle;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "copy constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    public final androidx.compose.ui.text.TextStyle copy-aIRg9q4(Brush brush, float alpha, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        androidx.compose.ui.text.PlatformSpanStyle spanStyle;
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        int unspecified-rAG3T2k;
        int unbox-impl;
        androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle;
        int paragraphStyle;
        final androidx.compose.ui.text.PlatformTextStyle platformTextStyle = textMotion;
        if (platformTextStyle != null) {
            platformSpanStyle = spanStyle;
        } else {
            platformSpanStyle = paragraphStyle;
        }
        final FontStyle fontStyle2 = fontStyle;
        SpanStyle spanStyle2 = new SpanStyle(brush, alpha, fontSize, obj6, fontStyle2, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, obj13, localeList, background, textDecoration, shadow, obj18, textAlign, textDirection, platformSpanStyle, lineHeight, 0);
        if (textIndent != null) {
            unspecified-e0LSkKk = textIndent.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (platformStyle != null) {
            unspecified-s_7X-co = platformStyle.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        if (platformTextStyle != null) {
            paragraphStyle = platformTextStyle.getParagraphStyle();
        }
        if (obj52 != null) {
            unspecified-rAG3T2k = obj52.unbox-impl();
        } else {
            unspecified-rAG3T2k = LineBreak.Companion.getUnspecified-rAG3T2k();
        }
        if (obj53 != null) {
            unbox-impl = obj53.unbox-impl();
        } else {
            unbox-impl = Hyphens.Companion.getUnspecified-vmbZdU8();
        }
        ParagraphStyle paragraphStyle2 = new ParagraphStyle(unspecified-e0LSkKk, unspecified-s_7X-co, lineHeightStyle, fontStyle2, hyphens, paragraphStyle, obj51, unspecified-rAG3T2k, unbox-impl, obj54, 0);
        TextStyle textStyle = new TextStyle(spanStyle2, paragraphStyle2, platformTextStyle);
        return textStyle;
    }

    public final androidx.compose.ui.text.TextStyle copy-p1EtxEg(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int textAlign, int textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, int lineBreak, int hyphens, TextMotion textMotion) {
        TextForegroundStyle textForegroundStyle$ui_text_release;
        androidx.compose.ui.text.PlatformSpanStyle spanStyle;
        int i;
        int paragraphStyle;
        final Object obj = this;
        final long l = color;
        final androidx.compose.ui.text.PlatformTextStyle platformTextStyle = obj52;
        if (Color.equals-impl0(l, obj2)) {
            textForegroundStyle$ui_text_release = obj.spanStyle.getTextForegroundStyle$ui_text_release();
        } else {
            textForegroundStyle$ui_text_release = TextForegroundStyle.Companion.from-8_81llA(l);
        }
        if (platformTextStyle != null) {
            i = spanStyle;
        } else {
            i = paragraphStyle;
        }
        final FontSynthesis fontSynthesis2 = fontFamily;
        SpanStyle spanStyle2 = new SpanStyle(textForegroundStyle$ui_text_release, fontWeight, obj8, fontSynthesis, fontSynthesis2, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, obj15, background, textDecoration, shadow, drawStyle, obj20, textDirection, lineHeight, i, textIndent, 0);
        if (platformTextStyle != null) {
            paragraphStyle = platformTextStyle.getParagraphStyle();
        }
        ParagraphStyle paragraphStyle2 = new ParagraphStyle(platformStyle, lineHeightStyle, lineBreak, fontSynthesis2, textMotion, paragraphStyle, obj53, obj54, obj55, obj56, 0);
        TextStyle textStyle = new TextStyle(spanStyle2, paragraphStyle2, platformTextStyle);
        return textStyle;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "copy constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    public final androidx.compose.ui.text.TextStyle copy-v2rsoow(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        TextForegroundStyle textForegroundStyle$ui_text_release;
        androidx.compose.ui.text.PlatformSpanStyle spanStyle;
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        int unspecified-rAG3T2k;
        int unbox-impl;
        androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle;
        int paragraphStyle;
        final Object obj = this;
        final long l = color;
        final androidx.compose.ui.text.PlatformTextStyle platformTextStyle = obj52;
        if (Color.equals-impl0(l, obj2)) {
            textForegroundStyle$ui_text_release = obj.spanStyle.getTextForegroundStyle$ui_text_release();
        } else {
            textForegroundStyle$ui_text_release = TextForegroundStyle.Companion.from-8_81llA(l);
        }
        if (platformTextStyle != null) {
            platformSpanStyle = spanStyle;
        } else {
            platformSpanStyle = paragraphStyle;
        }
        final FontSynthesis fontSynthesis2 = fontFamily;
        SpanStyle spanStyle2 = new SpanStyle(textForegroundStyle$ui_text_release, fontWeight, obj8, fontSynthesis, fontSynthesis2, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, obj15, background, textDecoration, shadow, drawStyle, obj20, textDirection, lineHeight, platformSpanStyle, textIndent, 0);
        if (platformStyle != null) {
            unspecified-e0LSkKk = platformStyle.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (lineHeightStyle != null) {
            unspecified-s_7X-co = lineHeightStyle.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        if (platformTextStyle != null) {
            paragraphStyle = platformTextStyle.getParagraphStyle();
        }
        if (obj54 != null) {
            unspecified-rAG3T2k = obj54.unbox-impl();
        } else {
            unspecified-rAG3T2k = LineBreak.Companion.getUnspecified-rAG3T2k();
        }
        if (obj55 != null) {
            unbox-impl = obj55.unbox-impl();
        } else {
            unbox-impl = Hyphens.Companion.getUnspecified-vmbZdU8();
        }
        ParagraphStyle paragraphStyle2 = new ParagraphStyle(unspecified-e0LSkKk, unspecified-s_7X-co, lineBreak, fontSynthesis2, textMotion, paragraphStyle, obj53, unspecified-rAG3T2k, unbox-impl, obj56, 0);
        TextStyle textStyle = new TextStyle(spanStyle2, paragraphStyle2, platformTextStyle);
        return textStyle;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof TextStyle) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.spanStyle, obj.spanStyle)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.paragraphStyle, obj2.paragraphStyle)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.platformStyle, obj3.platformStyle)) {
            return i2;
        }
        return i;
    }

    public final float getAlpha() {
        return this.spanStyle.getAlpha();
    }

    public final long getBackground-0d7_KjU() {
        return this.spanStyle.getBackground-0d7_KjU();
    }

    public final BaselineShift getBaselineShift-5SSeXJ0() {
        return this.spanStyle.getBaselineShift-5SSeXJ0();
    }

    public final Brush getBrush() {
        return this.spanStyle.getBrush();
    }

    public final long getColor-0d7_KjU() {
        return this.spanStyle.getColor-0d7_KjU();
    }

    public final DrawStyle getDrawStyle() {
        return this.spanStyle.getDrawStyle();
    }

    public final FontFamily getFontFamily() {
        return this.spanStyle.getFontFamily();
    }

    public final String getFontFeatureSettings() {
        return this.spanStyle.getFontFeatureSettings();
    }

    public final long getFontSize-XSAIIZE() {
        return this.spanStyle.getFontSize-XSAIIZE();
    }

    public final FontStyle getFontStyle-4Lr2A7w() {
        return this.spanStyle.getFontStyle-4Lr2A7w();
    }

    public final FontSynthesis getFontSynthesis-ZQGJjVo() {
        return this.spanStyle.getFontSynthesis-ZQGJjVo();
    }

    public final FontWeight getFontWeight() {
        return this.spanStyle.getFontWeight();
    }

    public final Hyphens getHyphens-EaSxIns() {
        return Hyphens.box-impl(getHyphens-vmbZdU8());
    }

    public final int getHyphens-vmbZdU8() {
        return this.paragraphStyle.getHyphens-vmbZdU8();
    }

    public final long getLetterSpacing-XSAIIZE() {
        return this.spanStyle.getLetterSpacing-XSAIIZE();
    }

    public final LineBreak getLineBreak-LgCVezo() {
        return LineBreak.box-impl(getLineBreak-rAG3T2k());
    }

    public final int getLineBreak-rAG3T2k() {
        return this.paragraphStyle.getLineBreak-rAG3T2k();
    }

    public final long getLineHeight-XSAIIZE() {
        return this.paragraphStyle.getLineHeight-XSAIIZE();
    }

    public final LineHeightStyle getLineHeightStyle() {
        return this.paragraphStyle.getLineHeightStyle();
    }

    public final LocaleList getLocaleList() {
        return this.spanStyle.getLocaleList();
    }

    public final androidx.compose.ui.text.ParagraphStyle getParagraphStyle$ui_text_release() {
        return this.paragraphStyle;
    }

    public final androidx.compose.ui.text.PlatformTextStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public final Shadow getShadow() {
        return this.spanStyle.getShadow();
    }

    public final androidx.compose.ui.text.SpanStyle getSpanStyle$ui_text_release() {
        return this.spanStyle;
    }

    public final TextAlign getTextAlign-buA522U() {
        return TextAlign.box-impl(getTextAlign-e0LSkKk());
    }

    public final int getTextAlign-e0LSkKk() {
        return this.paragraphStyle.getTextAlign-e0LSkKk();
    }

    public final TextDecoration getTextDecoration() {
        return this.spanStyle.getTextDecoration();
    }

    public final TextDirection getTextDirection-mmuk1to() {
        return TextDirection.box-impl(getTextDirection-s_7X-co());
    }

    public final int getTextDirection-s_7X-co() {
        return this.paragraphStyle.getTextDirection-s_7X-co();
    }

    public final TextGeometricTransform getTextGeometricTransform() {
        return this.spanStyle.getTextGeometricTransform();
    }

    public final TextIndent getTextIndent() {
        return this.paragraphStyle.getTextIndent();
    }

    public final TextMotion getTextMotion() {
        return this.paragraphStyle.getTextMotion();
    }

    public final boolean hasSameDrawAffectingAttributes(androidx.compose.ui.text.TextStyle other) {
        int i;
        boolean sameNonLayoutAttributes$ui_text_release;
        androidx.compose.ui.text.SpanStyle spanStyle;
        if (this != other) {
            if (this.spanStyle.hasSameNonLayoutAttributes$ui_text_release(other.spanStyle)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final boolean hasSameLayoutAffectingAttributes(androidx.compose.ui.text.TextStyle other) {
        boolean sameLayoutAffectingAttributes$ui_text_release;
        int i;
        Object paragraphStyle;
        if (this != other) {
            if (Intrinsics.areEqual(this.paragraphStyle, other.paragraphStyle) && this.spanStyle.hasSameLayoutAffectingAttributes$ui_text_release(other.spanStyle)) {
                if (this.spanStyle.hasSameLayoutAffectingAttributes$ui_text_release(other.spanStyle)) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public int hashCode() {
        int i;
        androidx.compose.ui.text.PlatformTextStyle platformStyle = this.platformStyle;
        if (platformStyle != null) {
            i = platformStyle.hashCode();
        } else {
            i = 0;
        }
        return result += i;
    }

    public final int hashCodeLayoutAffectingAttributes$ui_text_release() {
        int i;
        androidx.compose.ui.text.PlatformTextStyle platformStyle = this.platformStyle;
        if (platformStyle != null) {
            i = platformStyle.hashCode();
        } else {
            i = 0;
        }
        return result += i;
    }

    public final androidx.compose.ui.text.TextStyle merge(androidx.compose.ui.text.ParagraphStyle other) {
        TextStyle textStyle = new TextStyle(toSpanStyle(), toParagraphStyle().merge(other));
        return textStyle;
    }

    public final androidx.compose.ui.text.TextStyle merge(androidx.compose.ui.text.SpanStyle other) {
        TextStyle textStyle = new TextStyle(toSpanStyle().merge(other), toParagraphStyle());
        return textStyle;
    }

    public final androidx.compose.ui.text.TextStyle merge(androidx.compose.ui.text.TextStyle other) {
        boolean equal;
        if (other != null && Intrinsics.areEqual(other, TextStyle.Default)) {
            if (Intrinsics.areEqual(other, TextStyle.Default)) {
            }
            TextStyle textStyle = new TextStyle(toSpanStyle().merge(other.toSpanStyle()), toParagraphStyle().merge(other.toParagraphStyle()));
            return textStyle;
        }
        return this;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "merge that takes nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    public final androidx.compose.ui.text.TextStyle merge-Z1GrekI(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, androidx.compose.ui.text.PlatformTextStyle platformStyle, TextMotion textMotion) {
        androidx.compose.ui.text.PlatformSpanStyle spanStyle;
        int unspecified-e0LSkKk;
        Object paragraphStyle;
        int unspecified-s_7X-co;
        int unspecified-rAG3T2k;
        int unbox-impl;
        androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle;
        int paragraphStyle2;
        final Object obj = this;
        if (obj53 != null) {
            platformSpanStyle = spanStyle;
        } else {
            platformSpanStyle = paragraphStyle2;
        }
        final long l = fontWeight;
        androidx.compose.ui.text.SpanStyle fastMerge-dSHsh3o = SpanStyleKt.fastMerge-dSHsh3o(obj.spanStyle, color, obj3, 0, 2143289344, l, obj7, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, obj14, background, textDecoration, shadow, drawStyle, obj19);
        if (lineHeightStyle != null) {
            unspecified-e0LSkKk = lineHeightStyle.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (lineBreak != null) {
            unspecified-s_7X-co = lineBreak.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        if (obj53 != null) {
            paragraphStyle2 = obj53.getParagraphStyle();
        }
        if (obj51 != null) {
            unspecified-rAG3T2k = obj51.unbox-impl();
        } else {
            unspecified-rAG3T2k = LineBreak.Companion.getUnspecified-rAG3T2k();
        }
        if (obj52 != null) {
            unbox-impl = obj52.unbox-impl();
        } else {
            unbox-impl = Hyphens.Companion.getUnspecified-vmbZdU8();
        }
        androidx.compose.ui.text.ParagraphStyle fastMerge-j5T8yCg = ParagraphStyleKt.fastMerge-j5T8yCg(obj.paragraphStyle, unspecified-e0LSkKk, unspecified-s_7X-co, hyphens, l, textMotion, paragraphStyle2, obj50, unspecified-rAG3T2k, unbox-impl);
        if (obj.spanStyle == fastMerge-dSHsh3o && obj.paragraphStyle == fastMerge-j5T8yCg) {
            if (obj.paragraphStyle == fastMerge-j5T8yCg) {
                return obj;
            }
        }
        TextStyle textStyle = new TextStyle(fastMerge-dSHsh3o, fastMerge-j5T8yCg);
        return textStyle;
    }

    public final androidx.compose.ui.text.TextStyle merge-dA7vx0o(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int textAlign, int textDirection, long lineHeight, TextIndent textIndent, LineHeightStyle lineHeightStyle, int lineBreak, int hyphens, androidx.compose.ui.text.PlatformTextStyle platformStyle, TextMotion textMotion) {
        androidx.compose.ui.text.PlatformSpanStyle spanStyle;
        Object paragraphStyle2;
        int i;
        int paragraphStyle;
        final Object obj = this;
        if (obj53 != null) {
            i = spanStyle;
        } else {
            i = paragraphStyle;
        }
        final long l = fontWeight;
        androidx.compose.ui.text.SpanStyle fastMerge-dSHsh3o = SpanStyleKt.fastMerge-dSHsh3o(obj.spanStyle, color, obj3, 0, 2143289344, l, obj7, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, obj14, background, textDecoration, shadow, drawStyle, obj19);
        if (obj53 != null) {
            paragraphStyle = obj53.getParagraphStyle();
        }
        androidx.compose.ui.text.ParagraphStyle fastMerge-j5T8yCg = ParagraphStyleKt.fastMerge-j5T8yCg(obj.paragraphStyle, lineHeightStyle, lineBreak, hyphens, l, textMotion, paragraphStyle, obj50, obj51, obj52);
        if (obj.spanStyle == fastMerge-dSHsh3o && obj.paragraphStyle == fastMerge-j5T8yCg) {
            if (obj.paragraphStyle == fastMerge-j5T8yCg) {
                return obj;
            }
        }
        TextStyle textStyle = new TextStyle(fastMerge-dSHsh3o, fastMerge-j5T8yCg);
        return textStyle;
    }

    public final androidx.compose.ui.text.TextStyle plus(androidx.compose.ui.text.ParagraphStyle other) {
        return merge(other);
    }

    public final androidx.compose.ui.text.TextStyle plus(androidx.compose.ui.text.SpanStyle other) {
        return merge(other);
    }

    public final androidx.compose.ui.text.TextStyle plus(androidx.compose.ui.text.TextStyle other) {
        return merge(other);
    }

    public final androidx.compose.ui.text.ParagraphStyle toParagraphStyle() {
        return this.paragraphStyle;
    }

    public final androidx.compose.ui.text.SpanStyle toSpanStyle() {
        return this.spanStyle;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TextStyle(color=").append(Color.toString-impl(getColor-0d7_KjU())).append(", brush=").append(getBrush()).append(", alpha=").append(getAlpha()).append(", fontSize=").append(TextUnit.toString-impl(getFontSize-XSAIIZE())).append(", fontWeight=").append(getFontWeight()).append(", fontStyle=").append(getFontStyle-4Lr2A7w()).append(", fontSynthesis=").append(getFontSynthesis-ZQGJjVo()).append(", fontFamily=").append(getFontFamily()).append(", fontFeatureSettings=").append(getFontFeatureSettings()).append(", letterSpacing=").append(TextUnit.toString-impl(getLetterSpacing-XSAIIZE())).append(", baselineShift=").append(getBaselineShift-5SSeXJ0()).append(", textGeometricTransform=");
        stringBuilder.append(getTextGeometricTransform()).append(", localeList=").append(getLocaleList()).append(", background=").append(Color.toString-impl(getBackground-0d7_KjU())).append(", textDecoration=").append(getTextDecoration()).append(", shadow=").append(getShadow()).append(", drawStyle=").append(getDrawStyle()).append(", textAlign=").append(TextAlign.toString-impl(getTextAlign-e0LSkKk())).append(", textDirection=").append(TextDirection.toString-impl(getTextDirection-s_7X-co())).append(", lineHeight=").append(TextUnit.toString-impl(getLineHeight-XSAIIZE())).append(", textIndent=").append(getTextIndent()).append(", platformStyle=").append(this.platformStyle).append(", lineHeightStyle=").append(getLineHeightStyle());
        stringBuilder.append(", lineBreak=").append(LineBreak.toString-impl(getLineBreak-rAG3T2k())).append(", hyphens=").append(Hyphens.toString-impl(getHyphens-vmbZdU8())).append(", textMotion=").append(getTextMotion()).append(')');
        return stringBuilder.toString();
    }
}
