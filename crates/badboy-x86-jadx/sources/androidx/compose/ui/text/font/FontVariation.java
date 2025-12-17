package androidx.compose.ui.text.font;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008Ç\u0002\u0018\u00002\u00020\u0001:\u0005\u0003\u001d\u001e\u001f\tB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008J4\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00040\u0010\"\u00020\u0004ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0008J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0008J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0014J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0008\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006 ", d2 = {"Landroidx/compose/ui/text/font/FontVariation;", "", "()V", "Setting", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "name", "", "value", "", "Settings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "settings", "", "Settings-6EWAqTQ", "(Landroidx/compose/ui/text/font/FontWeight;I[Landroidx/compose/ui/text/font/FontVariation$Setting;)Landroidx/compose/ui/text/font/FontVariation$Settings;", "grade", "", "italic", "opticalSizing", "textSize", "Landroidx/compose/ui/unit/TextUnit;", "opticalSizing--R2X_6o", "(J)Landroidx/compose/ui/text/font/FontVariation$Setting;", "slant", "width", "SettingFloat", "SettingInt", "SettingTextUnit", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FontVariation {

    public static final int $stable;
    public static final androidx.compose.ui.text.font.FontVariation INSTANCE;

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008w\u0018\u00002\u00020\u0001J\u0012\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t\u0082\u0001\u0003\u000e\u000f\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0011À\u0006\u0001", d2 = {"Landroidx/compose/ui/text/font/FontVariation$Setting;", "", "axisName", "", "getAxisName", "()Ljava/lang/String;", "needsDensity", "", "getNeedsDensity", "()Z", "toVariationValue", "", "density", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/text/font/FontVariation$SettingFloat;", "Landroidx/compose/ui/text/font/FontVariation$SettingInt;", "Landroidx/compose/ui/text/font/FontVariation$SettingTextUnit;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Setting {
        public abstract String getAxisName();

        public abstract boolean getNeedsDensity();

        public abstract float toVariationValue(Density density);
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000f\u001a\u00020\n2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016J\u0008\u0010\u0014\u001a\u00020\u0003H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0018", d2 = {"Landroidx/compose/ui/text/font/FontVariation$SettingFloat;", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "axisName", "", "value", "", "(Ljava/lang/String;F)V", "getAxisName", "()Ljava/lang/String;", "needsDensity", "", "getNeedsDensity", "()Z", "getValue", "()F", "equals", "other", "", "hashCode", "", "toString", "toVariationValue", "density", "Landroidx/compose/ui/unit/Density;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class SettingFloat implements androidx.compose.ui.text.font.FontVariation.Setting {

        private final String axisName;
        private final boolean needsDensity;
        private final float value;
        public SettingFloat(String axisName, float value) {
            super();
            this.axisName = axisName;
            this.value = value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public boolean equals(Object other) {
            int i;
            final int i2 = 1;
            if (this == other) {
                return i2;
            }
            final int i3 = 0;
            if (!other instanceof FontVariation.SettingFloat) {
                return i3;
            }
            if (!Intrinsics.areEqual(getAxisName(), (FontVariation.SettingFloat)other.getAxisName())) {
                return i3;
            }
            i = Float.compare(value, value2) == 0 ? i2 : i3;
            if (i == 0) {
                return i3;
            }
            return i2;
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public String getAxisName() {
            return this.axisName;
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public final float getValue() {
            return this.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public int hashCode() {
            return i2 += i4;
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("FontVariation.Setting(axisName='").append(getAxisName()).append("', value=").append(this.value).append(')').toString();
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public float toVariationValue(Density density) {
            return this.value;
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000f\u001a\u00020\n2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0008\u0010\u0012\u001a\u00020\u0005H\u0016J\u0008\u0010\u0013\u001a\u00020\u0003H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0018", d2 = {"Landroidx/compose/ui/text/font/FontVariation$SettingInt;", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "axisName", "", "value", "", "(Ljava/lang/String;I)V", "getAxisName", "()Ljava/lang/String;", "needsDensity", "", "getNeedsDensity", "()Z", "getValue", "()I", "equals", "other", "", "hashCode", "toString", "toVariationValue", "", "density", "Landroidx/compose/ui/unit/Density;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class SettingInt implements androidx.compose.ui.text.font.FontVariation.Setting {

        private final String axisName;
        private final boolean needsDensity;
        private final int value;
        public SettingInt(String axisName, int value) {
            super();
            this.axisName = axisName;
            this.value = value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public boolean equals(Object other) {
            final int i = 1;
            if (this == other) {
                return i;
            }
            final int i2 = 0;
            if (!other instanceof FontVariation.SettingInt) {
                return i2;
            }
            if (!Intrinsics.areEqual(getAxisName(), (FontVariation.SettingInt)other.getAxisName())) {
                return i2;
            }
            if (this.value != obj2.value) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public String getAxisName() {
            return this.axisName;
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public final int getValue() {
            return this.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public int hashCode() {
            return i2 += value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("FontVariation.Setting(axisName='").append(getAxisName()).append("', value=").append(this.value).append(')').toString();
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public float toVariationValue(Density density) {
            return (float)value;
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0010\u001a\u00020\n2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\u0008\u0010\u0015\u001a\u00020\u0003H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000e\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001a", d2 = {"Landroidx/compose/ui/text/font/FontVariation$SettingTextUnit;", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "axisName", "", "value", "Landroidx/compose/ui/unit/TextUnit;", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAxisName", "()Ljava/lang/String;", "needsDensity", "", "getNeedsDensity", "()Z", "getValue-XSAIIZE", "()J", "J", "equals", "other", "", "hashCode", "", "toString", "toVariationValue", "", "density", "Landroidx/compose/ui/unit/Density;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class SettingTextUnit implements androidx.compose.ui.text.font.FontVariation.Setting {

        private final String axisName;
        private final boolean needsDensity;
        private final long value;
        private SettingTextUnit(String axisName, long value) {
            super();
            this.axisName = axisName;
            this.value = value;
            this.needsDensity = true;
        }

        public SettingTextUnit(String string, long l2, DefaultConstructorMarker defaultConstructorMarker3) {
            super(string, l2, defaultConstructorMarker3);
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public boolean equals(Object other) {
            final int i = 1;
            if (this == other) {
                return i;
            }
            final int i2 = 0;
            if (!other instanceof FontVariation.SettingTextUnit) {
                return i2;
            }
            if (!Intrinsics.areEqual(getAxisName(), (FontVariation.SettingTextUnit)other.getAxisName())) {
                return i2;
            }
            if (!TextUnit.equals-impl0(this.value, obj4)) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public String getAxisName() {
            return this.axisName;
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public final long getValue-XSAIIZE() {
            return this.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public int hashCode() {
            return i2 += i4;
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("FontVariation.Setting(axisName='").append(getAxisName()).append("', value=").append(TextUnit.toString-impl(this.value)).append(')').toString();
        }

        @Override // androidx.compose.ui.text.font.FontVariation$Setting
        public float toVariationValue(Density density) {
            if (density == null) {
            } else {
                return value-impl *= fontScale;
            }
            int i2 = 0;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("density must not be null".toString());
            throw illegalArgumentException;
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\r\u001a\u00020\u00072\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0011", d2 = {"Landroidx/compose/ui/text/font/FontVariation$Settings;", "", "settings", "", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "([Landroidx/compose/ui/text/font/FontVariation$Setting;)V", "needsDensity", "", "getNeedsDensity$ui_text_release", "()Z", "", "getSettings", "()Ljava/util/List;", "equals", "other", "hashCode", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Settings {

        public static final int $stable;
        private final boolean needsDensity;
        private final List<androidx.compose.ui.text.font.FontVariation.Setting> settings;
        static {
        }

        public Settings(androidx.compose.ui.text.font.FontVariation.Setting... settings) {
            int index$iv$iv;
            int i3;
            int next;
            boolean next2;
            Object obj;
            int i;
            String it2;
            ArrayList $this$getOrPut$iv$iv$iv;
            int it;
            Object size;
            int i2;
            ArrayList arrayList;
            final Object obj2 = this;
            super();
            int i5 = 0;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Object[] objArr2 = objArr;
            int i8 = 0;
            i3 = 0;
            next = i3;
            while (next < objArr2.length) {
                obj = objArr2[next];
                int i13 = 0;
                it2 = obj.getAxisName();
                LinkedHashMap map2 = linkedHashMap;
                it = 0;
                size = map2.get(it2);
                if (size == null) {
                } else {
                }
                arrayList = size;
                (List)arrayList.add(obj);
                next++;
                i2 = 0;
                arrayList = new ArrayList();
                map2.put(it2, (List)arrayList);
            }
            int i4 = 0;
            ArrayList arrayList3 = new ArrayList();
            int i9 = 0;
            Iterator iterator = (Map)linkedHashMap.entrySet().iterator();
            i = 1;
            while (iterator.hasNext()) {
                next = iterator.next();
                it2 = 0;
                it = next.getValue();
                if ((List)it.size() == i) {
                } else {
                }
                i = i3;
                CollectionsKt.addAll((Collection)arrayList3, (Iterable)it);
                i = 1;
            }
            ArrayList arrayList2 = new ArrayList((Collection)(List)arrayList3);
            obj2.settings = (List)arrayList2;
            int i6 = 0;
            List list = settings2;
            int i7 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < list.size()) {
                $this$getOrPut$iv$iv$iv = 0;
                size = 0;
                index$iv$iv++;
            }
            obj2.needsDensity = i3;
        }

        public boolean equals(Object other) {
            final int i = 1;
            if (this == other) {
                return i;
            }
            final int i2 = 0;
            if (!other instanceof FontVariation.Settings) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.settings, obj.settings)) {
                return i2;
            }
            return i;
        }

        public final boolean getNeedsDensity$ui_text_release() {
            return this.needsDensity;
        }

        public final List<androidx.compose.ui.text.font.FontVariation.Setting> getSettings() {
            return this.settings;
        }

        public int hashCode() {
            return this.settings.hashCode();
        }
    }
    static {
        FontVariation fontVariation = new FontVariation();
        FontVariation.INSTANCE = fontVariation;
    }

    public final androidx.compose.ui.text.font.FontVariation.Setting Setting(String name, float value) {
        int i;
        i = name.length() == 4 ? 1 : 0;
        if (i == 0) {
        } else {
            FontVariation.SettingFloat settingFloat = new FontVariation.SettingFloat(name, value);
            return (FontVariation.Setting)settingFloat;
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Name must be exactly four characters. Actual: '").append(name).append('\'').toString().toString());
        throw illegalArgumentException;
    }

    public final androidx.compose.ui.text.font.FontVariation.Settings Settings-6EWAqTQ(androidx.compose.ui.text.font.FontWeight weight, int style, androidx.compose.ui.text.font.FontVariation.Setting... settings) {
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        spreadBuilder.add(weight(weight.getWeight()));
        spreadBuilder.add(italic((float)style));
        spreadBuilder.addSpread(settings);
        FontVariation.Settings settings2 = new FontVariation.Settings((FontVariation.Setting[])spreadBuilder.toArray(new FontVariation.Setting[spreadBuilder.size()]));
        return settings2;
    }

    public final androidx.compose.ui.text.font.FontVariation.Setting grade(int value) {
        int i2;
        int i;
        i = 0;
        if (-1000 <= value && value < 1001) {
            if (value < 1001) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
            FontVariation.SettingInt settingInt = new FontVariation.SettingInt("GRAD", value);
            return (FontVariation.Setting)settingInt;
        }
        int i3 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("'GRAD' must be in -1000..1000".toString());
        throw illegalArgumentException;
    }

    public final androidx.compose.ui.text.font.FontVariation.Setting italic(float value) {
        int cmp;
        int i;
        i = 0;
        if (Float.compare(i2, value) <= 0 && Float.compare(value, i4) <= 0) {
            if (Float.compare(value, i4) <= 0) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
            FontVariation.SettingFloat settingFloat = new FontVariation.SettingFloat("ital", value);
            return (FontVariation.Setting)settingFloat;
        }
        int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("'ital' must be in 0.0f..1.0f. Actual: ").append(value).toString().toString());
        throw illegalArgumentException;
    }

    public final androidx.compose.ui.text.font.FontVariation.Setting opticalSizing--R2X_6o(long textSize) {
        if (!TextUnit.isSp-impl(textSize)) {
        } else {
            FontVariation.SettingTextUnit settingTextUnit = new FontVariation.SettingTextUnit("opsz", textSize, obj5, 0);
            return (FontVariation.Setting)settingTextUnit;
        }
        int i = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("'opsz' must be provided in sp units".toString());
        throw illegalArgumentException;
    }

    public final androidx.compose.ui.text.font.FontVariation.Setting slant(float value) {
        int cmp;
        int i;
        i = 0;
        if (Float.compare(i2, value) <= 0 && Float.compare(value, i4) <= 0) {
            if (Float.compare(value, i4) <= 0) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
            FontVariation.SettingFloat settingFloat = new FontVariation.SettingFloat("slnt", value);
            return (FontVariation.Setting)settingFloat;
        }
        int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("'slnt' must be in -90f..90f. Actual: ").append(value).toString().toString());
        throw illegalArgumentException;
    }

    public final androidx.compose.ui.text.font.FontVariation.Setting weight(int value) {
        int i;
        int i2;
        i = 0;
        int i4 = 1;
        if (i4 <= value && value < 1001) {
            if (value < 1001) {
                i = i4;
            }
        }
        if (i == 0) {
        } else {
            FontVariation.SettingInt settingInt = new FontVariation.SettingInt("wght", value);
            return (FontVariation.Setting)settingInt;
        }
        int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("'wght' value must be in [1, 1000]. Actual: ").append(value).toString().toString());
        throw illegalArgumentException;
    }

    public final androidx.compose.ui.text.font.FontVariation.Setting width(float value) {
        int i;
        i = Float.compare(value, i2) > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            FontVariation.SettingFloat settingFloat = new FontVariation.SettingFloat("wdth", value);
            return (FontVariation.Setting)settingFloat;
        }
        int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("'wdth' must be strictly > 0.0f. Actual: ").append(value).toString().toString());
        throw illegalArgumentException;
    }
}
