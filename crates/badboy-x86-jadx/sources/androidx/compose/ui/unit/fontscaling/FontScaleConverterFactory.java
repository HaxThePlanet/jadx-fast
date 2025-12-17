package androidx.compose.ui.unit.fontscaling;

import _COROUTINE.ArtificialStackFrames;
import _COROUTINE.CoroutineDebuggingKt;
import androidx.collection.SparseArrayCompat;
import androidx.compose.material3.NavigationDrawerKt.DismissibleDrawerSheet.3;
import androidx.compose.material3.NavigationDrawerKt.DismissibleNavigationDrawer.2.1.1.1.1.1;
import androidx.compose.material3.NavigationDrawerKt.DismissibleNavigationDrawer.3;
import androidx.compose.ui.unit.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.Unit;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\tH\u0007J\u0013\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\tH\u0082\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\tH\u0007J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010#\u001a\u00020\rH\u0002J&\u0010$\u001a\u00020\"2\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010#\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\u0008\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u000e\u0010\u0002\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012¨\u0006&", d2 = {"Landroidx/compose/ui/unit/fontscaling/FontScaleConverterFactory;", "", "()V", "CommonFontSizes", "", "LookupTablesWriteLock", "", "[Ljava/lang/Object;", "MinScaleForNonLinear", "", "ScaleKeyMultiplier", "sLookupTables", "Landroidx/collection/SparseArrayCompat;", "Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", "getSLookupTables$annotations", "getSLookupTables", "()Landroidx/collection/SparseArrayCompat;", "setSLookupTables", "(Landroidx/collection/SparseArrayCompat;)V", "createInterpolatedTableBetween", "start", "end", "interpolationPoint", "forScale", "fontScale", "get", "scaleKey", "getKey", "", "getScaleFromKey", "key", "isNonLinearFontScalingActive", "", "put", "", "fontScaleConverter", "putInto", "table", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FontScaleConverterFactory {

    public static final int $stable = 0;
    private static final float[] CommonFontSizes = null;
    public static final androidx.compose.ui.unit.fontscaling.FontScaleConverterFactory INSTANCE = null;
    private static final Object[] LookupTablesWriteLock = null;
    private static final float MinScaleForNonLinear = 1.03f;
    private static final float ScaleKeyMultiplier = 100f;
    private static volatile SparseArrayCompat<androidx.compose.ui.unit.fontscaling.FontScaleConverter> sLookupTables;
    static {
        int str;
        int i;
        FontScaleConverterFactory fontScaleConverterFactory = new FontScaleConverterFactory();
        FontScaleConverterFactory.INSTANCE = fontScaleConverterFactory;
        int i2 = 9;
        float[] fArr2 = new float[i2];
        fArr2 = new int[]{1090519040, 1092616192, 1094713344, 1096810496, 1099956224, 1101004800, 1103101952, 1106247680, 1120403456};
        FontScaleConverterFactory.CommonFontSizes = fArr2;
        i = 0;
        final int i11 = 1;
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat(i, i11, 0);
        FontScaleConverterFactory.sLookupTables = sparseArrayCompat;
        FontScaleConverterFactory.LookupTablesWriteLock = new Object[i];
        Object[] lookupTablesWriteLock = FontScaleConverterFactory.LookupTablesWriteLock;
        str = 0;
        float[] fArr3 = new float[i2];
        fArr3 = new int[]{1090519040, 1092616192, 1094713344, 1096810496, 1099956224, 1101004800, 1103101952, 1106247680, 1120403456};
        float[] fArr8 = new float[i2];
        fArr8 = new int[]{1091777331, 1094189056, 1096600781, 1099117363, 1100899942, 1101948518, 1103731098, 1106247680, 1120403456};
        FontScaleConverterTable fontScaleConverterTable = new FontScaleConverterTable(fArr3, fArr8);
        FontScaleConverterFactory.INSTANCE.putInto(FontScaleConverterFactory.sLookupTables, 1066611507, (FontScaleConverter)fontScaleConverterTable);
        float[] fArr4 = new float[i2];
        fArr4 = new int[]{1090519040, 1092616192, 1094713344, 1096810496, 1099956224, 1101004800, 1103101952, 1106247680, 1120403456};
        float[] fArr9 = new float[i2];
        fArr9 = new int[]{1093035622, 1095761920, 1098488218, 1100375654, 1101843661, 1102892237, 1104360243, 1106247680, 1120403456};
        FontScaleConverterTable fontScaleConverterTable2 = new FontScaleConverterTable(fArr4, fArr9);
        FontScaleConverterFactory.INSTANCE.putInto(FontScaleConverterFactory.sLookupTables, 1067869798, (FontScaleConverter)fontScaleConverterTable2);
        float[] fArr5 = new float[i2];
        fArr5 = new int[]{1090519040, 1092616192, 1094713344, 1096810496, 1099956224, 1101004800, 1103101952, 1106247680, 1120403456};
        float[] fArr10 = new float[i2];
        fArr10 = new int[]{1094713344, 1097859072, 1099956224, 1102053376, 1103101952, 1104150528, 1105199104, 1106247680, 1120403456};
        FontScaleConverterTable fontScaleConverterTable3 = new FontScaleConverterTable(fArr5, fArr10);
        FontScaleConverterFactory.INSTANCE.putInto(FontScaleConverterFactory.sLookupTables, 1069547520, (FontScaleConverter)fontScaleConverterTable3);
        float[] fArr6 = new float[i2];
        fArr6 = new int[]{1090519040, 1092616192, 1094713344, 1096810496, 1099956224, 1101004800, 1103101952, 1106247680, 1120403456};
        float[] fArr11 = new float[i2];
        fArr11 = new int[]{1097229926, 1099956224, 1101843661, 1103311667, 1104989389, 1106667110, 1107505971, 1108030259, 1120403456};
        FontScaleConverterTable fontScaleConverterTable4 = new FontScaleConverterTable(fArr6, fArr11);
        FontScaleConverterFactory.INSTANCE.putInto(FontScaleConverterFactory.sLookupTables, 1072064102, (FontScaleConverter)fontScaleConverterTable4);
        float[] fArr7 = new float[i2];
        fArr7 = new int[]{1090519040, 1092616192, 1094713344, 1096810496, 1099956224, 1101004800, 1103101952, 1106247680, 1120403456};
        float[] fArr = new float[i2];
        fArr = new int[]{1098907648, 1101004800, 1103101952, 1104150528, 1106247680, 1107820544, 1108344832, 1108869120, 1120403456};
        FontScaleConverterTable fontScaleConverterTable5 = new FontScaleConverterTable(fArr7, fArr);
        FontScaleConverterFactory.INSTANCE.putInto(FontScaleConverterFactory.sLookupTables, 1073741824, (FontScaleConverter)fontScaleConverterTable5);
        Unit iNSTANCE = Unit.INSTANCE;
        synchronized (lookupTablesWriteLock) {
            fontScaleConverterFactory = new FontScaleConverterFactory();
            FontScaleConverterFactory.INSTANCE = fontScaleConverterFactory;
            i2 = 9;
            fArr2 = new float[i2];
            fArr2 = new int[]{1090519040, 1092616192, 1094713344, 1096810496, 1099956224, 1101004800, 1103101952, 1106247680, 1120403456};
            FontScaleConverterFactory.CommonFontSizes = fArr2;
            i = 0;
            i11 = 1;
            sparseArrayCompat = new SparseArrayCompat(i, i11, 0);
            FontScaleConverterFactory.sLookupTables = sparseArrayCompat;
            FontScaleConverterFactory.LookupTablesWriteLock = new Object[i];
            lookupTablesWriteLock = FontScaleConverterFactory.LookupTablesWriteLock;
            str = 0;
            fArr3 = new float[i2];
            fArr3 = new int[]{1090519040, 1092616192, 1094713344, 1096810496, 1099956224, 1101004800, 1103101952, 1106247680, 1120403456};
            fArr8 = new float[i2];
            fArr8 = new int[]{1091777331, 1094189056, 1096600781, 1099117363, 1100899942, 1101948518, 1103731098, 1106247680, 1120403456};
            fontScaleConverterTable = new FontScaleConverterTable(fArr3, fArr8);
            FontScaleConverterFactory.INSTANCE.putInto(FontScaleConverterFactory.sLookupTables, 1066611507, (FontScaleConverter)fontScaleConverterTable);
            fArr4 = new float[i2];
            fArr4 = new int[]{1090519040, 1092616192, 1094713344, 1096810496, 1099956224, 1101004800, 1103101952, 1106247680, 1120403456};
            fArr9 = new float[i2];
            fArr9 = new int[]{1093035622, 1095761920, 1098488218, 1100375654, 1101843661, 1102892237, 1104360243, 1106247680, 1120403456};
            fontScaleConverterTable2 = new FontScaleConverterTable(fArr4, fArr9);
            FontScaleConverterFactory.INSTANCE.putInto(FontScaleConverterFactory.sLookupTables, 1067869798, (FontScaleConverter)fontScaleConverterTable2);
            fArr5 = new float[i2];
            fArr5 = new int[]{1090519040, 1092616192, 1094713344, 1096810496, 1099956224, 1101004800, 1103101952, 1106247680, 1120403456};
            fArr10 = new float[i2];
            fArr10 = new int[]{1094713344, 1097859072, 1099956224, 1102053376, 1103101952, 1104150528, 1105199104, 1106247680, 1120403456};
            fontScaleConverterTable3 = new FontScaleConverterTable(fArr5, fArr10);
            FontScaleConverterFactory.INSTANCE.putInto(FontScaleConverterFactory.sLookupTables, 1069547520, (FontScaleConverter)fontScaleConverterTable3);
            fArr6 = new float[i2];
            fArr6 = new int[]{1090519040, 1092616192, 1094713344, 1096810496, 1099956224, 1101004800, 1103101952, 1106247680, 1120403456};
            fArr11 = new float[i2];
            fArr11 = new int[]{1097229926, 1099956224, 1101843661, 1103311667, 1104989389, 1106667110, 1107505971, 1108030259, 1120403456};
            fontScaleConverterTable4 = new FontScaleConverterTable(fArr6, fArr11);
            FontScaleConverterFactory.INSTANCE.putInto(FontScaleConverterFactory.sLookupTables, 1072064102, (FontScaleConverter)fontScaleConverterTable4);
            fArr7 = new float[i2];
            fArr7 = new int[]{1090519040, 1092616192, 1094713344, 1096810496, 1099956224, 1101004800, 1103101952, 1106247680, 1120403456};
            fArr = new float[i2];
            fArr = new int[]{1098907648, 1101004800, 1103101952, 1104150528, 1106247680, 1107820544, 1108344832, 1108869120, 1120403456};
            fontScaleConverterTable5 = new FontScaleConverterTable(fArr7, fArr);
            FontScaleConverterFactory.INSTANCE.putInto(FontScaleConverterFactory.sLookupTables, 1073741824, (FontScaleConverter)fontScaleConverterTable5);
            iNSTANCE = Unit.INSTANCE;
        }
        i = i11;
        int i7 = 0;
        if (i == 0) {
            int i10 = 0;
            InlineClassHelperKt.throwIllegalStateException("You should only apply non-linear scaling to font scales > 1");
        }
        FontScaleConverterFactory.$stable = 8;
    }

    private final androidx.compose.ui.unit.fontscaling.FontScaleConverter createInterpolatedTableBetween(androidx.compose.ui.unit.fontscaling.FontScaleConverter start, androidx.compose.ui.unit.fontscaling.FontScaleConverter end, float interpolationPoint) {
        int i;
        float f;
        float convertSpToDp2;
        float convertSpToDp;
        float lerp;
        float[] fArr = new float[commonFontSizes.length];
        i = 0;
        while (i < commonFontSizes2.length) {
            f = FontScaleConverterFactory.CommonFontSizes[i];
            fArr[i] = MathUtils.INSTANCE.lerp(start.convertSpToDp(f), end.convertSpToDp(f), interpolationPoint);
            i++;
        }
        FontScaleConverterTable i2 = new FontScaleConverterTable(FontScaleConverterFactory.CommonFontSizes, fArr);
        return (FontScaleConverter)i2;
    }

    private final androidx.compose.ui.unit.fontscaling.FontScaleConverter get(float scaleKey) {
        return (FontScaleConverter)FontScaleConverterFactory.sLookupTables.get(getKey(scaleKey));
    }

    private final int getKey(float fontScale) {
        return (int)i2;
    }

    public static void getSLookupTables$annotations() {
    }

    private final float getScaleFromKey(int key) {
        return f /= i2;
    }

    private final void put(float scaleKey, androidx.compose.ui.unit.fontscaling.FontScaleConverter fontScaleConverter) {
        final Object[] lookupTablesWriteLock = FontScaleConverterFactory.LookupTablesWriteLock;
        int i = 0;
        SparseArrayCompat clone = FontScaleConverterFactory.sLookupTables.clone();
        FontScaleConverterFactory.INSTANCE.putInto(clone, scaleKey, fontScaleConverter);
        FontScaleConverterFactory.sLookupTables = clone;
        Unit iNSTANCE = Unit.INSTANCE;
        return;
        synchronized (lookupTablesWriteLock) {
            lookupTablesWriteLock = FontScaleConverterFactory.LookupTablesWriteLock;
            i = 0;
            clone = FontScaleConverterFactory.sLookupTables.clone();
            FontScaleConverterFactory.INSTANCE.putInto(clone, scaleKey, fontScaleConverter);
            FontScaleConverterFactory.sLookupTables = clone;
            iNSTANCE = Unit.INSTANCE;
        }
    }

    private final void putInto(SparseArrayCompat<androidx.compose.ui.unit.fontscaling.FontScaleConverter> table, float scaleKey, androidx.compose.ui.unit.fontscaling.FontScaleConverter fontScaleConverter) {
        table.put(getKey(scaleKey), fontScaleConverter);
    }

    public final androidx.compose.ui.unit.fontscaling.FontScaleConverter forScale(float fontScale) {
        androidx.compose.ui.unit.fontscaling.FontScaleConverter startTable2;
        Object startTable;
        androidx.compose.ui.unit.fontscaling.FontScaleConverter fontScaleConverterTable2;
        float startScale;
        float[] fArr;
        Object fontScaleConverterTable;
        int i2;
        float[] commonFontSizes;
        int i;
        float scaleFromKey;
        float f;
        float obj12;
        if (!isNonLinearFontScalingActive(fontScale)) {
            return null;
        }
        androidx.compose.ui.unit.fontscaling.FontScaleConverter fontScaleConverter = FontScaleConverterFactory.INSTANCE.get(fontScale);
        if (fontScaleConverter != null) {
            return fontScaleConverter;
        }
        int indexOfKey = FontScaleConverterFactory.sLookupTables.indexOfKey(getKey(fontScale));
        if (indexOfKey >= 0) {
            return (FontScaleConverter)FontScaleConverterFactory.sLookupTables.valueAt(indexOfKey);
        }
        int i7 = 1;
        i5 -= i7;
        final int i9 = i6 + 1;
        if (i9 >= FontScaleConverterFactory.sLookupTables.size()) {
            fArr = new float[i7];
            i = 0;
            fArr[i] = 1065353216;
            float[] fArr2 = new float[i7];
            fArr2[i] = fontScale;
            fontScaleConverterTable2 = new FontScaleConverterTable(fArr, fArr2);
            put(fontScale, (FontScaleConverter)fontScaleConverterTable2);
            startTable2 = fontScaleConverterTable2;
            f = fontScale;
        } else {
            int i8 = 0;
            int i10 = 0;
            if (i6 < 0) {
                fontScaleConverterTable = new FontScaleConverterTable(FontScaleConverterFactory.CommonFontSizes, FontScaleConverterFactory.CommonFontSizes);
                startTable = fontScaleConverterTable;
                i = startScale;
            } else {
                startTable = fontScaleConverterTable;
                i = startScale;
            }
            f = fontScale;
            fontScaleConverterTable2 = createInterpolatedTableBetween(startTable, (FontScaleConverter)FontScaleConverterFactory.sLookupTables.valueAt(i9), MathUtils.INSTANCE.constrainedMap(0, 1065353216, i, getScaleFromKey(FontScaleConverterFactory.sLookupTables.keyAt(i9)), f));
            put(f, fontScaleConverterTable2);
            startTable2 = fontScaleConverterTable2;
        }
        return startTable2;
    }

    public final SparseArrayCompat<androidx.compose.ui.unit.fontscaling.FontScaleConverter> getSLookupTables() {
        return FontScaleConverterFactory.sLookupTables;
    }

    public final boolean isNonLinearFontScalingActive(float fontScale) {
        int i;
        i = Float.compare(fontScale, i2) >= 0 ? 1 : 0;
        return i;
    }

    public final void setSLookupTables(SparseArrayCompat<androidx.compose.ui.unit.fontscaling.FontScaleConverter> <set-?>) {
        FontScaleConverterFactory.sLookupTables = <set-?>;
    }
}
