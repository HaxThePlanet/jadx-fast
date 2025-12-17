package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0018\u0002\n\u0002\u0008!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001BÍ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ\u008c\u0002\u0010:\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00032\n\u0008\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cø\u0001\u0000¢\u0006\u0004\u0008;\u0010<J-\u0010=\u001a\u0008\u0012\u0004\u0012\u00020\u00030>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020@H\u0001¢\u0006\u0004\u0008C\u0010DJ5\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00030>2\u0006\u0010E\u001a\u00020@2\u0006\u0010?\u001a\u00020@2\u0006\u0010F\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0001¢\u0006\u0004\u0008G\u0010HJ\u0013\u0010I\u001a\u00020@2\u0008\u0010J\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010K\u001a\u00020LH\u0016J%\u0010M\u001a\u0008\u0012\u0004\u0012\u00020\u00030>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0001¢\u0006\u0004\u0008N\u0010OJ-\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00030>2\u0006\u0010P\u001a\u00020@2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0001¢\u0006\u0004\u0008Q\u0010DJ!\u0010R\u001a\u00020\u001c*\u0004\u0018\u00010\u001c2\u000c\u0010S\u001a\u0008\u0012\u0004\u0012\u00020\u001c0TH\u0000¢\u0006\u0002\u0008UR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u0008\u001e\u0010\u001fR\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u0008!\u0010\u001fR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u0019\u0010\u0010\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u0008$\u0010\u001fR\u0019\u0010\u0018\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u0008%\u0010\u001fR\u0019\u0010\u0019\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u0008&\u0010\u001fR\u0019\u0010\u0011\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u0008'\u0010\u001fR\u0019\u0010\u0015\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u0008(\u0010\u001fR\u0019\u0010\u0013\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u0008)\u0010\u001fR\u0019\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u0008*\u0010\u001fR\u0019\u0010\r\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u0008+\u0010\u001fR\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u0008,\u0010\u001fR\u0019\u0010\u001a\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u0008-\u0010\u001fR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u0008.\u0010\u001fR\u0019\u0010\u0008\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u0008/\u0010\u001fR\u0019\u0010\u0014\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u00080\u0010\u001fR\u0019\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u00081\u0010\u001fR\u0019\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u00082\u0010\u001fR\u0019\u0010\u000c\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u00083\u0010\u001fR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u00084\u0010\u001fR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u00085\u0010\u001fR\u0019\u0010\u0016\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u00086\u0010\u001fR\u0019\u0010\u0017\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u00087\u0010\u001fR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u00088\u0010\u001fR\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u00089\u0010\u001f\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006V", d2 = {"Landroidx/compose/material3/DatePickerColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "navigationContentColor", "yearContentColor", "disabledYearContentColor", "currentYearContentColor", "selectedYearContentColor", "disabledSelectedYearContentColor", "selectedYearContainerColor", "disabledSelectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContainerColor", "dayInSelectionRangeContentColor", "dividerColor", "dateTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getCurrentYearContentColor-0d7_KjU", "getDateTextFieldColors", "()Landroidx/compose/material3/TextFieldColors;", "getDayContentColor-0d7_KjU", "getDayInSelectionRangeContainerColor-0d7_KjU", "getDayInSelectionRangeContentColor-0d7_KjU", "getDisabledDayContentColor-0d7_KjU", "getDisabledSelectedDayContainerColor-0d7_KjU", "getDisabledSelectedDayContentColor-0d7_KjU", "getDisabledSelectedYearContainerColor-0d7_KjU", "getDisabledSelectedYearContentColor-0d7_KjU", "getDisabledYearContentColor-0d7_KjU", "getDividerColor-0d7_KjU", "getHeadlineContentColor-0d7_KjU", "getNavigationContentColor-0d7_KjU", "getSelectedDayContainerColor-0d7_KjU", "getSelectedDayContentColor-0d7_KjU", "getSelectedYearContainerColor-0d7_KjU", "getSelectedYearContentColor-0d7_KjU", "getSubheadContentColor-0d7_KjU", "getTitleContentColor-0d7_KjU", "getTodayContentColor-0d7_KjU", "getTodayDateBorderColor-0d7_KjU", "getWeekdayContentColor-0d7_KjU", "getYearContentColor-0d7_KjU", "copy", "copy-tNwlRmA", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;)Landroidx/compose/material3/DatePickerColors;", "dayContainerColor", "Landroidx/compose/runtime/State;", "selected", "", "enabled", "animate", "dayContainerColor$material3_release", "(ZZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "isToday", "inRange", "dayContentColor$material3_release", "(ZZZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "yearContainerColor", "yearContainerColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "currentYear", "yearContentColor$material3_release", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatePickerColors {

    public static final int $stable;
    private final long containerColor;
    private final long currentYearContentColor;
    private final androidx.compose.material3.TextFieldColors dateTextFieldColors;
    private final long dayContentColor;
    private final long dayInSelectionRangeContainerColor;
    private final long dayInSelectionRangeContentColor;
    private final long disabledDayContentColor;
    private final long disabledSelectedDayContainerColor;
    private final long disabledSelectedDayContentColor;
    private final long disabledSelectedYearContainerColor;
    private final long disabledSelectedYearContentColor;
    private final long disabledYearContentColor;
    private final long dividerColor;
    private final long headlineContentColor;
    private final long navigationContentColor;
    private final long selectedDayContainerColor;
    private final long selectedDayContentColor;
    private final long selectedYearContainerColor;
    private final long selectedYearContentColor;
    private final long subheadContentColor;
    private final long titleContentColor;
    private final long todayContentColor;
    private final long todayDateBorderColor;
    private final long weekdayContentColor;
    private final long yearContentColor;
    static {
    }

    private DatePickerColors(long containerColor, long titleContentColor, long headlineContentColor, long weekdayContentColor, long subheadContentColor, long navigationContentColor, long yearContentColor, long disabledYearContentColor, long currentYearContentColor, long selectedYearContentColor, long disabledSelectedYearContentColor, long selectedYearContainerColor, long disabledSelectedYearContainerColor, long dayContentColor, long disabledDayContentColor, long selectedDayContentColor, long disabledSelectedDayContentColor, long selectedDayContainerColor, long disabledSelectedDayContainerColor, long todayContentColor, long todayDateBorderColor, long dayInSelectionRangeContainerColor, long dayInSelectionRangeContentColor, long dividerColor, androidx.compose.material3.TextFieldColors dateTextFieldColors) {
        final Object obj = this;
        super();
        obj.containerColor = containerColor;
        obj.titleContentColor = headlineContentColor;
        obj.headlineContentColor = subheadContentColor;
        obj.weekdayContentColor = yearContentColor;
        obj.subheadContentColor = currentYearContentColor;
        obj.navigationContentColor = disabledSelectedYearContentColor;
        obj.yearContentColor = disabledSelectedYearContainerColor;
        obj.disabledYearContentColor = disabledDayContentColor;
        obj.currentYearContentColor = disabledSelectedDayContentColor;
        obj.selectedYearContentColor = disabledSelectedDayContainerColor;
        obj.disabledSelectedYearContentColor = todayDateBorderColor;
        obj.selectedYearContainerColor = dayInSelectionRangeContentColor;
        obj.disabledSelectedYearContainerColor = dateTextFieldColors;
        obj.dayContentColor = obj43;
        obj.disabledDayContentColor = obj45;
        obj.selectedDayContentColor = obj47;
        obj.disabledSelectedDayContentColor = obj49;
        obj.selectedDayContainerColor = obj51;
        obj.disabledSelectedDayContainerColor = obj53;
        obj.todayContentColor = obj55;
        obj.todayDateBorderColor = obj57;
        obj.dayInSelectionRangeContainerColor = obj59;
        obj.dayInSelectionRangeContentColor = obj61;
        obj.dividerColor = obj63;
        obj.dateTextFieldColors = obj65;
    }

    public DatePickerColors(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, long l14, long l15, long l16, long l17, long l18, long l19, long l20, long l21, long l22, long l23, long l24, androidx.compose.material3.TextFieldColors textFieldColors25, DefaultConstructorMarker defaultConstructorMarker26) {
        super(l, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, textFieldColors25, defaultConstructorMarker26, obj27, obj28, obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43, obj44, obj45, obj46, obj47, obj48, obj49);
    }

    public static androidx.compose.material3.DatePickerColors copy-tNwlRmA$default(androidx.compose.material3.DatePickerColors datePickerColors, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, long l14, long l15, long l16, long l17, long l18, long l19, long l20, long l21, long l22, long l23, long l24, long l25, androidx.compose.material3.TextFieldColors textFieldColors26, int i27, Object object28) {
        long selectedDayContentColor;
        long disabledSelectedDayContentColor;
        long selectedDayContainerColor;
        long disabledSelectedDayContainerColor;
        long todayContentColor;
        long todayDateBorderColor;
        long dayInSelectionRangeContainerColor;
        long dayInSelectionRangeContentColor;
        long dividerColor;
        long containerColor;
        long disabledYearContentColor;
        long currentYearContentColor;
        long selectedYearContentColor;
        long disabledSelectedYearContentColor;
        long selectedYearContainerColor;
        long disabledSelectedYearContainerColor;
        long dayContentColor;
        long disabledDayContentColor;
        androidx.compose.material3.TextFieldColors dateTextFieldColors;
        long titleContentColor;
        long headlineContentColor;
        long weekdayContentColor;
        long subheadContentColor;
        long navigationContentColor;
        long yearContentColor;
        long obj34;
        long obj36;
        long obj38;
        long obj40;
        long obj42;
        long obj44;
        long obj46;
        long obj48;
        long obj50;
        Object obj = datePickerColors;
        int i = obj69;
        containerColor = i & 1 != 0 ? obj.containerColor : l2;
        titleContentColor = i & 2 != 0 ? obj.titleContentColor : l4;
        headlineContentColor = i & 4 != 0 ? obj.headlineContentColor : l6;
        weekdayContentColor = i & 8 != 0 ? obj.weekdayContentColor : l8;
        subheadContentColor = i & 16 != 0 ? obj.subheadContentColor : l10;
        navigationContentColor = i & 32 != 0 ? obj.navigationContentColor : l12;
        yearContentColor = i & 64 != 0 ? obj.yearContentColor : l14;
        disabledYearContentColor = i & 128 != 0 ? obj.disabledYearContentColor : l16;
        currentYearContentColor = i & 256 != 0 ? obj.currentYearContentColor : l18;
        final long obj22 = currentYearContentColor;
        selectedYearContentColor = i & 512 != 0 ? obj.selectedYearContentColor : l20;
        final long obj24 = selectedYearContentColor;
        disabledSelectedYearContentColor = i & 1024 != 0 ? obj.disabledSelectedYearContentColor : l22;
        final long obj26 = disabledSelectedYearContentColor;
        selectedYearContainerColor = i & 2048 != 0 ? obj.selectedYearContainerColor : l24;
        final long obj28 = selectedYearContainerColor;
        disabledSelectedYearContainerColor = i & 4096 != 0 ? obj.disabledSelectedYearContainerColor : textFieldColors26;
        final long obj30 = disabledSelectedYearContainerColor;
        dayContentColor = i & 8192 != 0 ? obj.dayContentColor : object28;
        final long obj32 = dayContentColor;
        disabledDayContentColor = i & 16384 != 0 ? obj.disabledDayContentColor : obj48;
        selectedDayContentColor = i & i36 != 0 ? obj.selectedDayContentColor : obj50;
        disabledSelectedDayContentColor = obj69 & i11 != 0 ? obj.disabledSelectedDayContentColor : obj52;
        selectedDayContainerColor = obj69 & i13 != 0 ? obj.selectedDayContainerColor : obj54;
        disabledSelectedDayContainerColor = obj69 & i15 != 0 ? obj.disabledSelectedDayContainerColor : obj56;
        todayContentColor = obj69 & i17 != 0 ? obj.todayContentColor : obj58;
        todayDateBorderColor = obj69 & i19 != 0 ? obj.todayDateBorderColor : obj60;
        dayInSelectionRangeContainerColor = obj69 & i21 != 0 ? obj.dayInSelectionRangeContainerColor : obj62;
        dayInSelectionRangeContentColor = obj69 & i23 != 0 ? obj.dayInSelectionRangeContentColor : obj64;
        dividerColor = obj69 & i25 != 0 ? obj.dividerColor : obj66;
        dateTextFieldColors = obj69 & i28 != 0 ? obj.dateTextFieldColors : obj68;
        return obj.copy-tNwlRmA(containerColor, obj22, titleContentColor, obj24, headlineContentColor, obj26, weekdayContentColor, obj28, subheadContentColor, obj30, navigationContentColor, obj32, yearContentColor, obj34, disabledYearContentColor, obj36, obj22, obj38, obj24, obj40, obj26, obj42, obj28, obj44, obj30);
    }

    public final androidx.compose.material3.DatePickerColors copy-tNwlRmA(long containerColor, long titleContentColor, long headlineContentColor, long weekdayContentColor, long subheadContentColor, long navigationContentColor, long yearContentColor, long disabledYearContentColor, long currentYearContentColor, long selectedYearContentColor, long disabledSelectedYearContentColor, long selectedYearContainerColor, long disabledSelectedYearContainerColor, long dayContentColor, long disabledDayContentColor, long selectedDayContentColor, long disabledSelectedDayContentColor, long selectedDayContainerColor, long disabledSelectedDayContainerColor, long todayContentColor, long todayDateBorderColor, long dayInSelectionRangeContainerColor, long dayInSelectionRangeContentColor, long dividerColor, androidx.compose.material3.TextFieldColors dateTextFieldColors) {
        int $this$isSpecified$iv$iv2;
        int $this$isSpecified$iv$iv8;
        int $this$isSpecified$iv$iv22;
        int $this$isSpecified$iv$iv19;
        int $this$isSpecified$iv$iv16;
        int $this$isSpecified$iv$iv;
        int $this$isSpecified$iv$iv4;
        int $this$isSpecified$iv$iv5;
        int $this$isSpecified$iv$iv21;
        int $this$isSpecified$iv$iv11;
        int $this$isSpecified$iv$iv9;
        int $this$isSpecified$iv$iv18;
        int $this$isSpecified$iv$iv20;
        int $this$isSpecified$iv$iv6;
        int $this$isSpecified$iv$iv14;
        int $this$isSpecified$iv$iv13;
        int $this$isSpecified$iv$iv3;
        int $this$isSpecified$iv$iv23;
        int $this$isSpecified$iv$iv17;
        int $this$isSpecified$iv$iv7;
        int $this$isSpecified$iv$iv15;
        int $this$isSpecified$iv$iv12;
        int $this$isSpecified$iv$iv10;
        long dividerColor2;
        int i2;
        long l8;
        long l2;
        long l9;
        long l3;
        long l20;
        long l18;
        long l22;
        long l;
        long l7;
        long l11;
        long l15;
        long l12;
        long l13;
        long l19;
        long i3;
        long l6;
        long i;
        long l10;
        long l21;
        long l4;
        long l14;
        long l16;
        long l17;
        long l5;
        final Object obj = this;
        int i4 = containerColor;
        int i5 = 0;
        int i76 = 0;
        int i100 = 16;
        i2 = 1;
        final int i101 = 0;
        $this$isSpecified$iv$iv2 = Long.compare(i29, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv2 != 0) {
            l8 = i4;
        } else {
            int i75 = 0;
            l8 = $this$isSpecified$iv$iv2;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv = headlineContentColor;
        int i6 = 0;
        int i77 = 0;
        $this$isSpecified$iv$iv8 = Long.compare(i30, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv8 != 0) {
            l2 = $this$takeOrElse_u2dDxMtmZc$iv;
        } else {
            int i74 = 0;
            l2 = $this$isSpecified$iv$iv8;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv2 = subheadContentColor;
        int i7 = 0;
        int i78 = 0;
        $this$isSpecified$iv$iv22 = Long.compare(i31, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv22 != 0) {
            l9 = $this$takeOrElse_u2dDxMtmZc$iv2;
        } else {
            int i73 = 0;
            l9 = $this$isSpecified$iv$iv22;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv3 = yearContentColor;
        int i8 = 0;
        int i79 = 0;
        $this$isSpecified$iv$iv19 = Long.compare(i32, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv19 != 0) {
            l3 = $this$takeOrElse_u2dDxMtmZc$iv3;
        } else {
            int i72 = 0;
            l3 = $this$isSpecified$iv$iv19;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv4 = currentYearContentColor;
        int i9 = 0;
        int i80 = 0;
        $this$isSpecified$iv$iv16 = Long.compare(i33, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv16 != 0) {
            l20 = $this$takeOrElse_u2dDxMtmZc$iv4;
        } else {
            int i71 = 0;
            l20 = $this$isSpecified$iv$iv16;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv5 = disabledSelectedYearContentColor;
        int i10 = 0;
        int i81 = 0;
        $this$isSpecified$iv$iv = Long.compare(i34, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv != 0) {
            l18 = $this$takeOrElse_u2dDxMtmZc$iv5;
        } else {
            int i70 = 0;
            l18 = $this$isSpecified$iv$iv;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv6 = disabledSelectedYearContainerColor;
        int i11 = 0;
        int i82 = 0;
        $this$isSpecified$iv$iv4 = Long.compare(i35, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv4 != 0) {
            l22 = $this$takeOrElse_u2dDxMtmZc$iv6;
        } else {
            int i69 = 0;
            l22 = $this$isSpecified$iv$iv4;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv7 = disabledDayContentColor;
        int i12 = 0;
        int i83 = 0;
        $this$isSpecified$iv$iv5 = Long.compare(i36, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv5 != 0) {
            l = $this$takeOrElse_u2dDxMtmZc$iv7;
        } else {
            int i68 = 0;
            l = $this$isSpecified$iv$iv5;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv8 = disabledSelectedDayContentColor;
        int i13 = 0;
        int i84 = 0;
        $this$isSpecified$iv$iv21 = Long.compare(i37, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv21 != 0) {
            l7 = $this$takeOrElse_u2dDxMtmZc$iv8;
        } else {
            int i67 = 0;
            l7 = $this$isSpecified$iv$iv21;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv9 = disabledSelectedDayContainerColor;
        int i14 = 0;
        int i85 = 0;
        $this$isSpecified$iv$iv11 = Long.compare(i38, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv11 != 0) {
            l11 = $this$takeOrElse_u2dDxMtmZc$iv9;
        } else {
            int i66 = 0;
            l11 = $this$isSpecified$iv$iv11;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv10 = todayDateBorderColor;
        int i15 = 0;
        int i86 = 0;
        $this$isSpecified$iv$iv9 = Long.compare(i39, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv9 != 0) {
            l15 = $this$takeOrElse_u2dDxMtmZc$iv10;
        } else {
            int i65 = 0;
            l15 = $this$isSpecified$iv$iv9;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv11 = dayInSelectionRangeContentColor;
        int i16 = 0;
        int i87 = 0;
        $this$isSpecified$iv$iv18 = Long.compare(i40, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv18 != 0) {
            l12 = $this$takeOrElse_u2dDxMtmZc$iv11;
        } else {
            int i64 = 0;
            l12 = $this$isSpecified$iv$iv18;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv12 = dateTextFieldColors;
        int i17 = 0;
        int i88 = 0;
        $this$isSpecified$iv$iv20 = Long.compare(i41, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv20 != 0) {
            l13 = $this$takeOrElse_u2dDxMtmZc$iv12;
        } else {
            int i63 = 0;
            l13 = $this$isSpecified$iv$iv20;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv13 = obj90;
        int i18 = 0;
        int i89 = 0;
        $this$isSpecified$iv$iv6 = Long.compare(i42, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv6 != 0) {
            l19 = $this$takeOrElse_u2dDxMtmZc$iv13;
        } else {
            int i62 = 0;
            l19 = $this$isSpecified$iv$iv6;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv14 = obj92;
        int i19 = 0;
        int i90 = 0;
        $this$isSpecified$iv$iv14 = Long.compare(i43, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv14 != 0) {
            i3 = $this$takeOrElse_u2dDxMtmZc$iv14;
        } else {
            int i61 = 0;
            i3 = $this$isSpecified$iv$iv14;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv15 = obj94;
        int i20 = 0;
        int i91 = 0;
        $this$isSpecified$iv$iv13 = Long.compare(i44, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv13 != 0) {
            l6 = $this$takeOrElse_u2dDxMtmZc$iv15;
        } else {
            int i60 = 0;
            l6 = $this$isSpecified$iv$iv13;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv16 = obj96;
        int i21 = 0;
        int i92 = 0;
        $this$isSpecified$iv$iv3 = Long.compare(i45, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv3 != 0) {
            i = $this$takeOrElse_u2dDxMtmZc$iv16;
        } else {
            int i59 = 0;
            i = $this$isSpecified$iv$iv3;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv17 = obj98;
        int i22 = 0;
        int i93 = 0;
        $this$isSpecified$iv$iv23 = Long.compare(i46, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv23 != 0) {
            l10 = $this$takeOrElse_u2dDxMtmZc$iv17;
        } else {
            int i58 = 0;
            l10 = $this$isSpecified$iv$iv23;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv18 = obj100;
        int i23 = 0;
        int i94 = 0;
        $this$isSpecified$iv$iv17 = Long.compare(i47, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv17 != 0) {
            l21 = $this$takeOrElse_u2dDxMtmZc$iv18;
        } else {
            int i48 = 0;
            l21 = $this$isSpecified$iv$iv17;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv19 = obj102;
        int i24 = 0;
        int i95 = 0;
        $this$isSpecified$iv$iv7 = Long.compare(i49, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv7 != 0) {
            l4 = $this$takeOrElse_u2dDxMtmZc$iv19;
        } else {
            int i57 = 0;
            l4 = $this$isSpecified$iv$iv7;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv20 = obj104;
        int i25 = 0;
        int i96 = 0;
        $this$isSpecified$iv$iv15 = Long.compare(i50, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv15 != 0) {
            l14 = $this$takeOrElse_u2dDxMtmZc$iv20;
        } else {
            int i51 = 0;
            l14 = $this$isSpecified$iv$iv15;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv21 = obj106;
        int i26 = 0;
        int i97 = 0;
        $this$isSpecified$iv$iv12 = Long.compare(i52, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv12 != 0) {
            l16 = $this$takeOrElse_u2dDxMtmZc$iv21;
        } else {
            int i56 = 0;
            l16 = $this$isSpecified$iv$iv12;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv22 = obj108;
        int i27 = 0;
        int i98 = 0;
        $this$isSpecified$iv$iv10 = Long.compare(i53, i100) != 0 ? i2 : i101;
        if ($this$isSpecified$iv$iv10 != 0) {
            l17 = $this$takeOrElse_u2dDxMtmZc$iv22;
        } else {
            int i55 = 0;
            l17 = $this$isSpecified$iv$iv10;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv23 = obj110;
        int i28 = 0;
        int i99 = 0;
        if (Long.compare(dividerColor2, i100) != 0) {
        } else {
            i2 = i101;
        }
        if (i2 != 0) {
            l5 = $this$takeOrElse_u2dDxMtmZc$iv23;
        } else {
            int i54 = 0;
            l5 = dividerColor2;
        }
        DatePickerColors.copy.25 $this$takeOrElse_u2dDxMtmZc$iv24 = new DatePickerColors.copy.25(obj);
        DatePickerColors datePickerColors = new DatePickerColors(l8, obj14, l2, obj16, l9, obj18, l3, obj20, l20, obj22, l18, obj24, l22, obj26, l, obj28, l7, obj30, l11, obj32, l15, obj34, l12, obj36, l13, obj38, l19, obj40, i3, obj42, l6, obj44, i, obj46, l10, obj48, l21, obj50, l4, obj52, l14, obj54, l16, obj56, l17, obj58, l5, obj60, obj.takeOrElse$material3_release(obj112, (Function0)$this$takeOrElse_u2dDxMtmZc$iv24), 0);
        return datePickerColors;
    }

    public final State<Color> dayContainerColor$material3_release(boolean selected, boolean enabled, boolean animate, Composer $composer, int $changed) {
        long disabledSelectedDayContainerColor;
        int tween$default;
        boolean traceInProgress;
        String str;
        androidx.compose.animation.core.TweenSpec tweenSpec;
        int i3;
        int i2;
        Composer $composer2;
        int i4;
        int i;
        State obj14;
        int i5 = -1240482658;
        ComposerKt.sourceInformationMarkerStart($composer, i5, "C(dayContainerColor)P(2,1):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i5, $changed, -1, "androidx.compose.material3.DatePickerColors.dayContainerColor (DatePicker.kt:929)");
        }
        if (selected) {
            disabledSelectedDayContainerColor = enabled ? this.selectedDayContainerColor : this.disabledSelectedDayContainerColor;
        } else {
            disabledSelectedDayContainerColor = Color.Companion.getTransparent-0d7_KjU();
        }
        long l = disabledSelectedDayContainerColor;
        tween$default = 0;
        if (animate) {
            $composer.startReplaceGroup(-217548653);
            ComposerKt.sourceInformation($composer, "937@45329L88");
            i3 = 0;
            $composer2 = $composer;
            obj14 = SingleValueAnimationKt.animateColorAsState-euL9pac(l, obj3, (AnimationSpec)AnimationSpecKt.tween$default(100, tween$default, i3, 6, i3), i3, 0, $composer2, 0);
            $composer2.endReplaceGroup();
        } else {
            $composer2 = $composer;
            $composer2.startReplaceGroup(-217433457);
            ComposerKt.sourceInformation($composer2, "939@45447L28");
            obj14 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(l), $composer2, tween$default);
            $composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer2);
        return obj14;
    }

    public final State<Color> dayContentColor$material3_release(boolean isToday, boolean selected, boolean inRange, boolean enabled, Composer $composer, int $changed) {
        long disabledDayContentColor;
        int traceInProgress;
        String str;
        State animateColorAsState-euL9pac;
        int box-impl;
        int i4;
        Composer composer;
        int i2;
        int i;
        int i3;
        int i5 = -1233694918;
        ComposerKt.sourceInformationMarkerStart($composer, i5, "C(dayContentColor)P(2,3,1):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            i3 = $changed;
            ComposerKt.traceEventStart(i5, $changed, -1, "androidx.compose.material3.DatePickerColors.dayContentColor (DatePicker.kt:897)");
        } else {
            i3 = $changed;
        }
        if (selected && enabled) {
            if (enabled) {
                disabledDayContentColor = this.selectedDayContentColor;
            } else {
                if (selected && !enabled) {
                    if (!enabled) {
                        disabledDayContentColor = this.disabledSelectedDayContentColor;
                    } else {
                        if (inRange && enabled) {
                            if (enabled) {
                                disabledDayContentColor = this.dayInSelectionRangeContentColor;
                            } else {
                                if (inRange && !enabled) {
                                    disabledDayContentColor = !enabled ? this.disabledDayContentColor : isToday ? this.todayContentColor : enabled ? this.dayContentColor : this.disabledDayContentColor;
                                } else {
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
        int i6 = 0;
        if (inRange) {
            $composer.startReplaceGroup(-828488761);
            ComposerKt.sourceInformation($composer, "910@44387L28");
            animateColorAsState-euL9pac = SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledDayContentColor), $composer, i6);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-828426947);
            ComposerKt.sourceInformation($composer, "913@44523L88");
            int i11 = 0;
            animateColorAsState-euL9pac = SingleValueAnimationKt.animateColorAsState-euL9pac(disabledDayContentColor, traceInProgress, (AnimationSpec)AnimationSpecKt.tween$default(100, i6, i11, 6, i11), 0, 0, $composer, 0);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return animateColorAsState-euL9pac;
    }

    public boolean equals(Object other) {
        final int i2 = 0;
        if (!other instanceof DatePickerColors) {
            return i2;
        }
        if (!Color.equals-impl0(this.containerColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.titleContentColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.headlineContentColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.weekdayContentColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.subheadContentColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.yearContentColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.disabledYearContentColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.currentYearContentColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.selectedYearContentColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.disabledSelectedYearContentColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.selectedYearContainerColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.disabledSelectedYearContainerColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.dayContentColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.disabledDayContentColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.selectedDayContentColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.disabledSelectedDayContentColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.selectedDayContainerColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.disabledSelectedDayContainerColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.todayContentColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.todayDateBorderColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.dayInSelectionRangeContainerColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.dayInSelectionRangeContentColor, obj3)) {
            return i2;
        }
        return 1;
    }

    public final long getContainerColor-0d7_KjU() {
        return this.containerColor;
    }

    public final long getCurrentYearContentColor-0d7_KjU() {
        return this.currentYearContentColor;
    }

    public final androidx.compose.material3.TextFieldColors getDateTextFieldColors() {
        return this.dateTextFieldColors;
    }

    public final long getDayContentColor-0d7_KjU() {
        return this.dayContentColor;
    }

    public final long getDayInSelectionRangeContainerColor-0d7_KjU() {
        return this.dayInSelectionRangeContainerColor;
    }

    public final long getDayInSelectionRangeContentColor-0d7_KjU() {
        return this.dayInSelectionRangeContentColor;
    }

    public final long getDisabledDayContentColor-0d7_KjU() {
        return this.disabledDayContentColor;
    }

    public final long getDisabledSelectedDayContainerColor-0d7_KjU() {
        return this.disabledSelectedDayContainerColor;
    }

    public final long getDisabledSelectedDayContentColor-0d7_KjU() {
        return this.disabledSelectedDayContentColor;
    }

    public final long getDisabledSelectedYearContainerColor-0d7_KjU() {
        return this.disabledSelectedYearContainerColor;
    }

    public final long getDisabledSelectedYearContentColor-0d7_KjU() {
        return this.disabledSelectedYearContentColor;
    }

    public final long getDisabledYearContentColor-0d7_KjU() {
        return this.disabledYearContentColor;
    }

    public final long getDividerColor-0d7_KjU() {
        return this.dividerColor;
    }

    public final long getHeadlineContentColor-0d7_KjU() {
        return this.headlineContentColor;
    }

    public final long getNavigationContentColor-0d7_KjU() {
        return this.navigationContentColor;
    }

    public final long getSelectedDayContainerColor-0d7_KjU() {
        return this.selectedDayContainerColor;
    }

    public final long getSelectedDayContentColor-0d7_KjU() {
        return this.selectedDayContentColor;
    }

    public final long getSelectedYearContainerColor-0d7_KjU() {
        return this.selectedYearContainerColor;
    }

    public final long getSelectedYearContentColor-0d7_KjU() {
        return this.selectedYearContentColor;
    }

    public final long getSubheadContentColor-0d7_KjU() {
        return this.subheadContentColor;
    }

    public final long getTitleContentColor-0d7_KjU() {
        return this.titleContentColor;
    }

    public final long getTodayContentColor-0d7_KjU() {
        return this.todayContentColor;
    }

    public final long getTodayDateBorderColor-0d7_KjU() {
        return this.todayDateBorderColor;
    }

    public final long getWeekdayContentColor-0d7_KjU() {
        return this.weekdayContentColor;
    }

    public final long getYearContentColor-0d7_KjU() {
        return this.yearContentColor;
    }

    public int hashCode() {
        return result20 += i44;
    }

    public final androidx.compose.material3.TextFieldColors takeOrElse$material3_release(androidx.compose.material3.TextFieldColors $this$takeOrElse, Function0<androidx.compose.material3.TextFieldColors> block) {
        Object invoke;
        if ($this$takeOrElse == null) {
            invoke = block.invoke();
        } else {
            invoke = $this$takeOrElse;
        }
        return invoke;
    }

    public final State<Color> yearContainerColor$material3_release(boolean selected, boolean enabled, Composer $composer, int $changed) {
        long disabledSelectedYearContainerColor;
        boolean traceInProgress;
        String str;
        int i = -1306331107;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(yearContainerColor)P(1)985@47010L122:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.DatePickerColors.yearContainerColor (DatePicker.kt:978)");
        }
        if (selected) {
            disabledSelectedYearContainerColor = enabled ? this.selectedYearContainerColor : this.disabledSelectedYearContainerColor;
        } else {
            disabledSelectedYearContainerColor = Color.Companion.getTransparent-0d7_KjU();
        }
        final int i5 = 0;
        final Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return SingleValueAnimationKt.animateColorAsState-euL9pac(disabledSelectedYearContainerColor, obj3, (AnimationSpec)AnimationSpecKt.tween$default(100, 0, i5, 6, i5), i5, 0, composer, 0);
    }

    public final State<Color> yearContentColor$material3_release(boolean currentYear, boolean selected, boolean enabled, Composer $composer, int $changed) {
        long selectedYearContentColor;
        boolean traceInProgress;
        String str;
        int i = 874111097;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(yearContentColor)P(!1,2)965@46323L122:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.DatePickerColors.yearContentColor (DatePicker.kt:955)");
        }
        if (selected && enabled) {
            if (enabled) {
                selectedYearContentColor = this.selectedYearContentColor;
            } else {
                if (selected && !enabled) {
                    selectedYearContentColor = !enabled ? this.disabledSelectedYearContentColor : currentYear ? this.currentYearContentColor : enabled ? this.yearContentColor : this.disabledYearContentColor;
                } else {
                }
            }
        } else {
        }
        final int i5 = 0;
        final Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return SingleValueAnimationKt.animateColorAsState-euL9pac(selectedYearContentColor, obj3, (AnimationSpec)AnimationSpecKt.tween$default(100, 0, i5, 6, i5), i5, 0, composer, 0);
    }
}
