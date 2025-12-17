package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import androidx.compose.ui.text.AnnotatedString.Builder;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDecoration.Companion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003:\u0003BCDB\u0005¢\u0006\u0002\u0010\u0004J \u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\nH\u0002J0\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,ø\u0001\u0000¢\u0006\u0004\u0008-\u0010.J \u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0016J\u0010\u00103\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u00104\u001a\u0002052\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\"\u00106\u001a\u0002052\u0017\u00107\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020508¢\u0006\u0002\u00089H\u0082\u0008J&\u0010:\u001a\u0002052\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R/\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0008\u0010\t\u001a\u0004\u0018\u00010\n8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0010\u0010\u0011\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0008\u0010\t\u001a\u0004\u0018\u00010\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0018\u0010\u0011\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001f\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006E", d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache;", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/text/TextLayoutResult;", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "<set-?>", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;", "measureInputs", "getMeasureInputs", "()Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;", "setMeasureInputs", "(Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;)V", "measureInputs$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;", "nonMeasureInputs", "getNonMeasureInputs", "()Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;", "setNonMeasureInputs", "(Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;)V", "nonMeasureInputs$delegate", "record", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$CacheRecord;", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "value", "getValue", "()Landroidx/compose/ui/text/TextLayoutResult;", "computeLayout", "visualText", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getOrComputeLayout", "layoutWithNewMeasureInputs", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutWithNewMeasureInputs--hBUhpc", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)Landroidx/compose/ui/text/TextLayoutResult;", "mergeRecords", "previous", "current", "applied", "obtainTextMeasurer", "prependStateRecord", "", "updateCacheIfWritable", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "updateNonMeasureInputs", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "softWrap", "CacheRecord", "MeasureInputs", "NonMeasureInputs", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldLayoutStateCache implements State<TextLayoutResult>, StateObject {

    public static final int $stable;
    private final MutableState measureInputs$delegate;
    private final MutableState nonMeasureInputs$delegate;
    private androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.CacheRecord record;
    private TextMeasurer textMeasurer;

    @Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\r\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0001H\u0016J\u0008\u0010C\u001a\u00020\u0001H\u0016J\u0008\u0010D\u001a\u00020EH\u0016R\"\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\"\u0010\t\u001a\u00020\nX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019\"\u0004\u0008\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001d\u0010\u0013\"\u0004\u0008\u001e\u0010\u0015R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\"\"\u0004\u0008#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008'\u0010(\"\u0004\u0008)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008-\u0010.\"\u0004\u0008/\u00100R\u001a\u00101\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00082\u0010.\"\u0004\u00083\u00100R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00086\u00107\"\u0004\u00088\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008<\u0010=\"\u0004\u0008>\u0010?\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006F", d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$CacheRecord;", "Landroidx/compose/runtime/snapshots/StateRecord;", "()V", "composition", "Landroidx/compose/ui/text/TextRange;", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "setComposition-OEnZFl4", "(Landroidx/compose/ui/text/TextRange;)V", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-msEJaDk", "()J", "setConstraints-BRTryo0", "(J)V", "J", "densityValue", "", "getDensityValue", "()F", "setDensityValue", "(F)V", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "fontScale", "getFontScale", "setFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "singleLine", "", "getSingleLine", "()Z", "setSingleLine", "(Z)V", "softWrap", "getSoftWrap", "setSoftWrap", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "getTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "setTextStyle", "(Landroidx/compose/ui/text/TextStyle;)V", "visualText", "", "getVisualText", "()Ljava/lang/CharSequence;", "setVisualText", "(Ljava/lang/CharSequence;)V", "assign", "", "value", "create", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class CacheRecord extends StateRecord {

        private TextRange composition;
        private long constraints;
        private float densityValue = NaNf;
        private FontFamily.Resolver fontFamilyResolver;
        private float fontScale = NaNf;
        private LayoutDirection layoutDirection;
        private TextLayoutResult layoutResult;
        private boolean singleLine;
        private boolean softWrap;
        private TextStyle textStyle;
        private java.lang.CharSequence visualText;
        public CacheRecord() {
            super();
            int i = 2143289344;
            this.constraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, 0);
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.CacheRecord");
            Object obj = value;
            this.visualText = obj2.visualText;
            this.composition = obj3.composition;
            this.textStyle = obj4.textStyle;
            this.singleLine = obj5.singleLine;
            this.softWrap = obj6.softWrap;
            this.densityValue = obj7.densityValue;
            this.fontScale = obj8.fontScale;
            this.layoutDirection = obj9.layoutDirection;
            this.fontFamilyResolver = obj10.fontFamilyResolver;
            this.constraints = obj11.constraints;
            this.layoutResult = obj12.layoutResult;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            TextFieldLayoutStateCache.CacheRecord cacheRecord = new TextFieldLayoutStateCache.CacheRecord();
            return (StateRecord)cacheRecord;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final TextRange getComposition-MzsxiRA() {
            return this.composition;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final long getConstraints-msEJaDk() {
            return this.constraints;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final float getDensityValue() {
            return this.densityValue;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final FontFamily.Resolver getFontFamilyResolver() {
            return this.fontFamilyResolver;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final float getFontScale() {
            return this.fontScale;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final TextLayoutResult getLayoutResult() {
            return this.layoutResult;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final boolean getSingleLine() {
            return this.singleLine;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final boolean getSoftWrap() {
            return this.softWrap;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final TextStyle getTextStyle() {
            return this.textStyle;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final java.lang.CharSequence getVisualText() {
            return this.visualText;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setComposition-OEnZFl4(TextRange <set-?>) {
            this.composition = <set-?>;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setConstraints-BRTryo0(long <set-?>) {
            this.constraints = <set-?>;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setDensityValue(float <set-?>) {
            this.densityValue = <set-?>;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setFontFamilyResolver(FontFamily.Resolver <set-?>) {
            this.fontFamilyResolver = <set-?>;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setFontScale(float <set-?>) {
            this.fontScale = <set-?>;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setLayoutDirection(LayoutDirection <set-?>) {
            this.layoutDirection = <set-?>;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setLayoutResult(TextLayoutResult <set-?>) {
            this.layoutResult = <set-?>;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setSingleLine(boolean <set-?>) {
            this.singleLine = <set-?>;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setSoftWrap(boolean <set-?>) {
            this.softWrap = <set-?>;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setTextStyle(TextStyle <set-?>) {
            this.textStyle = <set-?>;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void setVisualText(java.lang.CharSequence <set-?>) {
            this.visualText = <set-?>;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CacheRecord(visualText=").append(this.visualText).append(", composition=").append(this.composition).append(", textStyle=").append(this.textStyle).append(", singleLine=").append(this.singleLine).append(", softWrap=").append(this.softWrap).append(", densityValue=").append(this.densityValue).append(", fontScale=").append(this.fontScale).append(", layoutDirection=").append(this.layoutDirection).append(", fontFamilyResolver=").append(this.fontFamilyResolver).append(", constraints=").append(Constraints.toString-impl(this.constraints)).append(", layoutResult=").append(this.layoutResult).append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0008\u0010\u001a\u001a\u00020\u001bH\u0016R\u0019\u0010\u0008\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001d", d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "densityValue", "", "getDensityValue", "()F", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontScale", "getFontScale", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class MeasureInputs {

        public static final androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.MeasureInputs.Companion Companion;
        private static final SnapshotMutationPolicy<androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.MeasureInputs> mutationPolicy;
        private final long constraints;
        private final Density density;
        private final float densityValue;
        private final FontFamily.Resolver fontFamilyResolver;
        private final float fontScale;
        private final LayoutDirection layoutDirection;
        static {
            TextFieldLayoutStateCache.MeasureInputs.Companion companion = new TextFieldLayoutStateCache.MeasureInputs.Companion(0);
            TextFieldLayoutStateCache.MeasureInputs.Companion = companion;
            TextFieldLayoutStateCache.MeasureInputs.Companion.mutationPolicy.1 anon = new TextFieldLayoutStateCache.MeasureInputs.Companion.mutationPolicy.1();
            TextFieldLayoutStateCache.MeasureInputs.mutationPolicy = (SnapshotMutationPolicy)anon;
        }

        private MeasureInputs(Density density, LayoutDirection layoutDirection, FontFamily.Resolver fontFamilyResolver, long constraints) {
            super();
            this.density = density;
            this.layoutDirection = layoutDirection;
            this.fontFamilyResolver = fontFamilyResolver;
            this.constraints = constraints;
            this.densityValue = this.density.getDensity();
            this.fontScale = this.density.getFontScale();
        }

        public MeasureInputs(Density density, LayoutDirection layoutDirection2, FontFamily.Resolver fontFamily$Resolver3, long l4, DefaultConstructorMarker defaultConstructorMarker5) {
            super(density, layoutDirection2, resolver3, l4, defaultConstructorMarker5);
        }

        public static final SnapshotMutationPolicy access$getMutationPolicy$cp() {
            return TextFieldLayoutStateCache.MeasureInputs.mutationPolicy;
        }

        public final long getConstraints-msEJaDk() {
            return this.constraints;
        }

        public final Density getDensity() {
            return this.density;
        }

        public final float getDensityValue() {
            return this.densityValue;
        }

        public final FontFamily.Resolver getFontFamilyResolver() {
            return this.fontFamilyResolver;
        }

        public final float getFontScale() {
            return this.fontScale;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("MeasureInputs(density=").append(this.density).append(", densityValue=").append(this.densityValue).append(", fontScale=").append(this.fontScale).append(", layoutDirection=").append(this.layoutDirection).append(", fontFamilyResolver=").append(this.fontFamilyResolver).append(", constraints=").append(Constraints.toString-impl(this.constraints)).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0008\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0014", d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "softWrap", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextStyle;ZZ)V", "getSingleLine", "()Z", "getSoftWrap", "getTextFieldState", "()Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "getTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class NonMeasureInputs {

        public static final androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.NonMeasureInputs.Companion Companion;
        private static final SnapshotMutationPolicy<androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.NonMeasureInputs> mutationPolicy;
        private final boolean singleLine;
        private final boolean softWrap;
        private final androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState;
        private final TextStyle textStyle;
        static {
            TextFieldLayoutStateCache.NonMeasureInputs.Companion companion = new TextFieldLayoutStateCache.NonMeasureInputs.Companion(0);
            TextFieldLayoutStateCache.NonMeasureInputs.Companion = companion;
            TextFieldLayoutStateCache.NonMeasureInputs.Companion.mutationPolicy.1 anon = new TextFieldLayoutStateCache.NonMeasureInputs.Companion.mutationPolicy.1();
            TextFieldLayoutStateCache.NonMeasureInputs.mutationPolicy = (SnapshotMutationPolicy)anon;
        }

        public NonMeasureInputs(androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState, TextStyle textStyle, boolean singleLine, boolean softWrap) {
            super();
            this.textFieldState = textFieldState;
            this.textStyle = textStyle;
            this.singleLine = singleLine;
            this.softWrap = softWrap;
        }

        public static final SnapshotMutationPolicy access$getMutationPolicy$cp() {
            return TextFieldLayoutStateCache.NonMeasureInputs.mutationPolicy;
        }

        public final boolean getSingleLine() {
            return this.singleLine;
        }

        public final boolean getSoftWrap() {
            return this.softWrap;
        }

        public final androidx.compose.foundation.text.input.internal.TransformedTextFieldState getTextFieldState() {
            return this.textFieldState;
        }

        public final TextStyle getTextStyle() {
            return this.textStyle;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("NonMeasureInputs(textFieldState=").append(this.textFieldState).append(", textStyle=").append(this.textStyle).append(", singleLine=").append(this.singleLine).append(", softWrap=").append(this.softWrap).append(')').toString();
        }
    }
    static {
    }

    public TextFieldLayoutStateCache() {
        super();
        final int i = 0;
        this.nonMeasureInputs$delegate = SnapshotStateKt.mutableStateOf(i, TextFieldLayoutStateCache.NonMeasureInputs.Companion.getMutationPolicy());
        this.measureInputs$delegate = SnapshotStateKt.mutableStateOf(i, TextFieldLayoutStateCache.MeasureInputs.Companion.getMutationPolicy());
        TextFieldLayoutStateCache.CacheRecord cacheRecord = new TextFieldLayoutStateCache.CacheRecord();
        this.record = cacheRecord;
    }

    private final TextLayoutResult computeLayout(TextFieldCharSequence visualText, androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.NonMeasureInputs nonMeasureInputs, androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.MeasureInputs measureInputs) {
        int i8;
        TextRange composition-MzsxiRA;
        SpanStyle spanStyle;
        int max-impl;
        int i9;
        int i11;
        int i;
        int i7;
        int i3;
        int i13;
        int i16;
        int i14;
        int i12;
        int i5;
        int i2;
        TextDecoration underline;
        int i15;
        int i10;
        int i17;
        int i4;
        int i6;
        final androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.MeasureInputs field = measureInputs;
        int i18 = 0;
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, 0);
        AnnotatedString.Builder str = builder;
        int i22 = 0;
        str.append(visualText.toString());
        if (visualText.getComposition-MzsxiRA() != null) {
            spanStyle = new SpanStyle(0, obj11, 0, obj13, 0, 0, 0, 0, 0, 0, obj20, 0, 0, 0, 0, obj25, TextDecoration.Companion.getUnderline(), 0, 0, 0, 61439, 0);
            str.addStyle(spanStyle, TextRange.getMin-impl(visualText.getComposition-MzsxiRA().unbox-impl()), TextRange.getMax-impl(visualText.getComposition-MzsxiRA().unbox-impl()));
        }
        if (nonMeasureInputs.getSingleLine()) {
        } else {
            i8 = Integer.MAX_VALUE;
        }
        return TextMeasurer.measure-xDpz5zY$default(this.obtainTextMeasurer(field), builder.toAnnotatedString(), nonMeasureInputs.getTextStyle(), 0, nonMeasureInputs.getSoftWrap(), i8, 0, field.getConstraints-msEJaDk(), max-impl, field.getLayoutDirection(), field.getDensity(), field.getFontFamilyResolver(), 0, 1060);
    }

    private final androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.MeasureInputs getMeasureInputs() {
        final int i = 0;
        final int i2 = 0;
        return (TextFieldLayoutStateCache.MeasureInputs)(State)this.measureInputs$delegate.getValue();
    }

    private final androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.NonMeasureInputs getNonMeasureInputs() {
        final int i = 0;
        final int i2 = 0;
        return (TextFieldLayoutStateCache.NonMeasureInputs)(State)this.nonMeasureInputs$delegate.getValue();
    }

    private final TextLayoutResult getOrComputeLayout(androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.NonMeasureInputs nonMeasureInputs, androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.MeasureInputs measureInputs) {
        StateRecord hasStaleResolvedFonts;
        Object $this$getOrComputeLayout_u24lambda_u243_u24lambda_u242_u24lambda_u241;
        java.lang.CharSequence contentEquals;
        Object obj;
        Object visualText;
        int fontFamilyResolver;
        int sameDrawAffectingAttributes;
        TextFieldCharSequence composition-MzsxiRA;
        long constraints-msEJaDk;
        boolean equal;
        int i2;
        Snapshot current;
        boolean readOnly;
        int i5;
        int i3;
        Object lock;
        int i6;
        int i4;
        TextLayoutResult textLayoutResult;
        int i;
        Object obj3;
        TextFieldCharSequence field;
        obj = this;
        visualText = nonMeasureInputs.getTextFieldState().getVisualText();
        final int i7 = 0;
        final StateRecord stateRecord = hasStaleResolvedFonts;
        final int i8 = 0;
        final TextLayoutResult layoutResult = (TextFieldLayoutStateCache.CacheRecord)stateRecord.getLayoutResult();
        if (layoutResult != null) {
            contentEquals = stateRecord.getVisualText();
            fontFamilyResolver = 1;
            sameDrawAffectingAttributes = 0;
            if (contentEquals != null && StringsKt.contentEquals(contentEquals, (CharSequence)visualText) == fontFamilyResolver) {
                hasStaleResolvedFonts = StringsKt.contentEquals(contentEquals, (CharSequence)visualText) == fontFamilyResolver ? fontFamilyResolver : sameDrawAffectingAttributes;
            } else {
            }
            if (hasStaleResolvedFonts != 0 && Intrinsics.areEqual(stateRecord.getComposition-MzsxiRA(), visualText.getComposition-MzsxiRA()) && stateRecord.getSingleLine() == nonMeasureInputs.getSingleLine() && stateRecord.getSoftWrap() == nonMeasureInputs.getSoftWrap() && stateRecord.getLayoutDirection() == measureInputs.getLayoutDirection()) {
                if (Intrinsics.areEqual(stateRecord.getComposition-MzsxiRA(), visualText.getComposition-MzsxiRA())) {
                    if (stateRecord.getSingleLine() == nonMeasureInputs.getSingleLine()) {
                        if (stateRecord.getSoftWrap() == nonMeasureInputs.getSoftWrap()) {
                            if (stateRecord.getLayoutDirection() == measureInputs.getLayoutDirection()) {
                                hasStaleResolvedFonts = Float.compare(densityValue, composition-MzsxiRA) == 0 ? fontFamilyResolver : sameDrawAffectingAttributes;
                                if (hasStaleResolvedFonts != 0) {
                                    if (Float.compare(fontScale, composition-MzsxiRA) == 0) {
                                    } else {
                                        fontFamilyResolver = sameDrawAffectingAttributes;
                                    }
                                    composition-MzsxiRA = stateRecord.getConstraints-msEJaDk();
                                    if (fontFamilyResolver != 0 && Constraints.equals-impl0(composition-MzsxiRA, obj11) && Intrinsics.areEqual(stateRecord.getFontFamilyResolver(), measureInputs.getFontFamilyResolver()) && !layoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts()) {
                                        composition-MzsxiRA = stateRecord.getConstraints-msEJaDk();
                                        if (Constraints.equals-impl0(composition-MzsxiRA, obj11)) {
                                            if (Intrinsics.areEqual(stateRecord.getFontFamilyResolver(), measureInputs.getFontFamilyResolver())) {
                                                if (!layoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts()) {
                                                    TextStyle textStyle = stateRecord.getTextStyle();
                                                    if (textStyle != null) {
                                                        hasStaleResolvedFonts = textStyle.hasSameLayoutAffectingAttributes(nonMeasureInputs.getTextStyle());
                                                    } else {
                                                        hasStaleResolvedFonts = sameDrawAffectingAttributes;
                                                    }
                                                    fontFamilyResolver = stateRecord.getTextStyle();
                                                    if (fontFamilyResolver != null) {
                                                        sameDrawAffectingAttributes = fontFamilyResolver.hasSameDrawAffectingAttributes(nonMeasureInputs.getTextStyle());
                                                    }
                                                    if (hasStaleResolvedFonts && sameDrawAffectingAttributes != 0) {
                                                        if (sameDrawAffectingAttributes != 0) {
                                                            return layoutResult;
                                                        }
                                                    }
                                                    if (hasStaleResolvedFonts) {
                                                        TextLayoutInput textLayoutInput2 = new TextLayoutInput(layoutResult.getLayoutInput().getText(), nonMeasureInputs.getTextStyle(), layoutResult.getLayoutInput().getPlaceholders(), layoutResult.getLayoutInput().getMaxLines(), layoutResult.getLayoutInput().getSoftWrap(), layoutResult.getLayoutInput().getOverflow-gIe3tQ8(), layoutResult.getLayoutInput().getDensity(), layoutResult.getLayoutInput().getLayoutDirection(), layoutResult.getLayoutInput().getFontFamilyResolver(), layoutResult.getLayoutInput().getConstraints-msEJaDk(), obj25, 0);
                                                        return TextLayoutResult.copy-O0kMr_c$default(layoutResult, textLayoutInput2, 0, composition-MzsxiRA, 2);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.NonMeasureInputs field4 = nonMeasureInputs;
        androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.MeasureInputs field5 = measureInputs;
        $this$getOrComputeLayout_u24lambda_u243_u24lambda_u242_u24lambda_u241 = obj.computeLayout(visualText, field4, field5);
        TextLayoutResult textLayoutResult2 = $this$getOrComputeLayout_u24lambda_u243_u24lambda_u242_u24lambda_u241;
        int i10 = 0;
        if (!Intrinsics.areEqual(textLayoutResult2, layoutResult)) {
            equal = this;
            i2 = 0;
            current = Snapshot.Companion.getCurrent();
            if (!current.getReadOnly()) {
                i5 = 0;
                i3 = 0;
                lock = SnapshotKt.getLock();
                i6 = 0;
                i4 = 0;
                textLayoutResult = $this$getOrComputeLayout_u24lambda_u243_u24lambda_u242_u24lambda_u241;
                StateRecord writableRecord = SnapshotKt.writableRecord((StateRecord)equal.record, (StateObject)equal, current);
                i = 0;
                (TextFieldLayoutStateCache.CacheRecord)writableRecord.setVisualText((CharSequence)visualText);
                writableRecord.setComposition-OEnZFl4(visualText.getComposition-MzsxiRA());
                writableRecord.setSingleLine(field4.getSingleLine());
                writableRecord.setSoftWrap(field4.getSoftWrap());
                writableRecord.setTextStyle(field4.getTextStyle());
                writableRecord.setLayoutDirection(field5.getLayoutDirection());
                writableRecord.setDensityValue(field5.getDensityValue());
                writableRecord.setFontScale(field5.getFontScale());
                field = visualText;
                writableRecord.setConstraints-BRTryo0(field5.getConstraints-msEJaDk());
                writableRecord.setFontFamilyResolver(field5.getFontFamilyResolver());
                writableRecord.setLayoutResult(textLayoutResult2);
                $this$getOrComputeLayout_u24lambda_u243_u24lambda_u242_u24lambda_u241 = Unit.INSTANCE;
                obj = 0;
                SnapshotKt.notifyWrite(current, (StateObject)equal);
                synchronized (lock) {
                    i5 = 0;
                    i3 = 0;
                    lock = SnapshotKt.getLock();
                    i6 = 0;
                    i4 = 0;
                    textLayoutResult = $this$getOrComputeLayout_u24lambda_u243_u24lambda_u242_u24lambda_u241;
                    writableRecord = SnapshotKt.writableRecord((StateRecord)equal.record, (StateObject)equal, current);
                    i = 0;
                    (TextFieldLayoutStateCache.CacheRecord)writableRecord.setVisualText((CharSequence)visualText);
                    writableRecord.setComposition-OEnZFl4(visualText.getComposition-MzsxiRA());
                    writableRecord.setSingleLine(field4.getSingleLine());
                    writableRecord.setSoftWrap(field4.getSoftWrap());
                    writableRecord.setTextStyle(field4.getTextStyle());
                    writableRecord.setLayoutDirection(field5.getLayoutDirection());
                    writableRecord.setDensityValue(field5.getDensityValue());
                    writableRecord.setFontScale(field5.getFontScale());
                    field = visualText;
                    writableRecord.setConstraints-BRTryo0(field5.getConstraints-msEJaDk());
                    writableRecord.setFontFamilyResolver(field5.getFontFamilyResolver());
                    writableRecord.setLayoutResult(textLayoutResult2);
                    $this$getOrComputeLayout_u24lambda_u243_u24lambda_u242_u24lambda_u241 = Unit.INSTANCE;
                    obj = 0;
                    SnapshotKt.notifyWrite(current, (StateObject)equal);
                }
            } else {
                textLayoutResult = $this$getOrComputeLayout_u24lambda_u243_u24lambda_u242_u24lambda_u241;
                field = visualText;
            }
        } else {
            textLayoutResult = $this$getOrComputeLayout_u24lambda_u243_u24lambda_u242_u24lambda_u241;
            field = visualText;
        }
        return textLayoutResult;
    }

    private final TextMeasurer obtainTextMeasurer(androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.MeasureInputs measureInputs) {
        TextMeasurer textMeasurer2;
        TextMeasurer textMeasurer;
        int i;
        LayoutDirection layoutDirection;
        int i2;
        if (this.textMeasurer == null) {
            textMeasurer2 = new TextMeasurer(measureInputs.getFontFamilyResolver(), measureInputs.getDensity(), measureInputs.getLayoutDirection(), 1);
            i = 0;
            this.textMeasurer = textMeasurer2;
        }
        return textMeasurer2;
    }

    private final void setMeasureInputs(androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.MeasureInputs <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.measureInputs$delegate.setValue(<set-?>);
    }

    private final void setNonMeasureInputs(androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.NonMeasureInputs <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.nonMeasureInputs$delegate.setValue(<set-?>);
    }

    private final void updateCacheIfWritable(Function1<? super androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.CacheRecord, Unit> block) {
        boolean readOnly;
        int i2;
        int i3;
        Object obj;
        int i;
        Throwable th;
        Object invoke;
        final int i4 = 0;
        Snapshot current = Snapshot.Companion.getCurrent();
        if (!current.getReadOnly()) {
            i2 = 0;
            int i5 = 0;
            Object lock = SnapshotKt.getLock();
            i = 0;
            th = 0;
            invoke = block.invoke(SnapshotKt.writableRecord((StateRecord)this.record, (StateObject)this, current));
            i3 = 0;
            SnapshotKt.notifyWrite(current, (StateObject)this);
            synchronized (lock) {
                i2 = 0;
                i5 = 0;
                lock = SnapshotKt.getLock();
                i = 0;
                th = 0;
                invoke = block.invoke(SnapshotKt.writableRecord((StateRecord)this.record, (StateObject)this, current));
                i3 = 0;
                SnapshotKt.notifyWrite(current, (StateObject)this);
            }
        }
    }

    @Override // androidx.compose.runtime.State
    public StateRecord getFirstStateRecord() {
        return (StateRecord)this.record;
    }

    @Override // androidx.compose.runtime.State
    public TextLayoutResult getValue() {
        final androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.NonMeasureInputs nonMeasureInputs = getNonMeasureInputs();
        int i = 0;
        if (nonMeasureInputs == null) {
            return i;
        }
        final androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.MeasureInputs measureInputs = getMeasureInputs();
        if (measureInputs == null) {
            return i;
        }
        return getOrComputeLayout(nonMeasureInputs, measureInputs);
    }

    @Override // androidx.compose.runtime.State
    public Object getValue() {
        return getValue();
    }

    @Override // androidx.compose.runtime.State
    public final TextLayoutResult layoutWithNewMeasureInputs--hBUhpc(Density density, LayoutDirection layoutDirection, FontFamily.Resolver fontFamilyResolver, long constraints) {
        TextFieldLayoutStateCache.MeasureInputs measureInputs = new TextFieldLayoutStateCache.MeasureInputs(density, layoutDirection, fontFamilyResolver, constraints, obj5, 0);
        setMeasureInputs(measureInputs);
        androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.NonMeasureInputs obj8 = getNonMeasureInputs();
        if (obj8 == null) {
        } else {
            return getOrComputeLayout(obj8, measureInputs);
        }
        obj8 = 0;
        obj8 = new IllegalStateException("Called layoutWithNewMeasureInputs before updateNonMeasureInputs".toString());
        throw obj8;
    }

    @Override // androidx.compose.runtime.State
    public StateRecord mergeRecords(StateRecord previous, StateRecord current, StateRecord applied) {
        return applied;
    }

    @Override // androidx.compose.runtime.State
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.CacheRecord");
        this.record = (TextFieldLayoutStateCache.CacheRecord)value;
    }

    @Override // androidx.compose.runtime.State
    public final void updateNonMeasureInputs(androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState, TextStyle textStyle, boolean singleLine, boolean softWrap) {
        TextFieldLayoutStateCache.NonMeasureInputs nonMeasureInputs = new TextFieldLayoutStateCache.NonMeasureInputs(textFieldState, textStyle, singleLine, softWrap);
        setNonMeasureInputs(nonMeasureInputs);
    }
}
