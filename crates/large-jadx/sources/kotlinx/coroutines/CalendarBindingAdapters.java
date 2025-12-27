package app.dogo.com.dogo_android.u.n.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.h.ol;
import app.dogo.com.dogo_android.k.e;
import app.dogo.com.dogo_android.repository.domain.DogLog;
import app.dogo.com.dogo_android.repository.domain.DogLog.LogStyle;
import app.dogo.com.dogo_android.u.n.p.l.j.a;
import app.dogo.com.dogo_android.u.n.p.m.b;
import app.dogo.com.dogo_android.u.n.p.m.b.a;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.n0.i.b;
import app.dogo.com.dogo_android.util.n0.m;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.material.button.MaterialButton;
import d.a.k.a.a;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.f0;
import kotlin.k0.l;
import kotlin.o;
import kotlin.w;

/* compiled from: CalendarBindingAdapters.kt */
@Metadata(d1 = "\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u00072\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u001b\u0010\u0003\u001a\u00020\u0004*\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012J%\u0010\u0013\u001a\u00020\u0004*\u00020\u000f2\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0017J4\u0010\u0018\u001a\u00020\u0004*\u00020\u00052\u0014\u0010\u0019\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u0007\u0018\u00010\u001a2\u0008\u0010\t\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J&\u0010\u0018\u001a\u00020\u0004*\u00020\u00052\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00072\u0008\u0010\t\u001a\u0004\u0018\u00010 H\u0007J%\u0010!\u001a\u00020\u0004*\u00020\"2\u0008\u0010#\u001a\u0004\u0018\u00010$2\u0008\u0010%\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020\u0004*\u00020\"2\u0008\u0010(\u001a\u0004\u0018\u00010$H\u0007J\u0016\u0010)\u001a\u00020\u0004*\u00020\"2\u0008\u0010(\u001a\u0004\u0018\u00010$H\u0007J#\u0010*\u001a\u00020\u0004*\u00020+2\u0008\u0010,\u001a\u0004\u0018\u00010\u00152\u0006\u0010-\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010.J\u001e\u0010/\u001a\u00020\u0004*\u0002002\u0008\u00101\u001a\u0004\u0018\u00010\u001f2\u0006\u00102\u001a\u00020+H\u0007J&\u00103\u001a\u00020\u0004*\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u00072\u0008\u0010\t\u001a\u0004\u0018\u000105H\u0007J\u0016\u00106\u001a\u00020\u0004*\u00020\"2\u0008\u0010(\u001a\u0004\u0018\u00010$H\u0007J\u0016\u00107\u001a\u00020\u0004*\u00020+2\u0008\u0010(\u001a\u0004\u0018\u00010$H\u0007J\u0016\u00108\u001a\u00020\u0004*\u00020+2\u0008\u0010(\u001a\u0004\u0018\u00010$H\u0007J\u001b\u00109\u001a\u00020\u0004*\u00020+2\u0008\u0010:\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010;J\u001b\u0010<\u001a\u00020\u0004*\u00020=2\u0008\u0010>\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010?J\u001b\u0010@\u001a\u00020\u0004*\u00020+2\u0008\u0010A\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010B¨\u0006C", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/CalendarBindingAdapters;", "", "()V", "setButtonDate", "", "Landroidx/recyclerview/widget/RecyclerView;", "types", "", "Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection;", "callback", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$Callback;", "initialSelection", "", "isNewLog", "", "Lcom/google/android/material/button/MaterialButton;", "timestampMs", "", "(Lcom/google/android/material/button/MaterialButton;Ljava/lang/Long;)V", "setButtonTime", "hours", "", "minutes", "(Lcom/google/android/material/button/MaterialButton;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setDogCalenderAdapter", "result", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$CalendarCellItem;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$Callback;", "textSwitcher", "Lapp/dogo/com/dogo_android/databinding/LayoutMonthTextSwitcherBinding;", "Lapp/dogo/com/dogo_android/repository/domain/DogLog;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectAdapter$DogLogSelectCallback;", "setDogLogBorder", "Landroid/widget/ImageView;", "dogLogType", "Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "isTagSelected", "(Landroid/widget/ImageView;Lapp/dogo/com/dogo_android/enums/DogLogTypes;Ljava/lang/Boolean;)V", "setDogLogCalendarSelectionIcon", "logType", "setDogLogCalendarTagColor", "setDogLogCounter", "Landroid/widget/TextView;", "count", "button", "(Landroid/widget/TextView;Ljava/lang/Integer;Lcom/google/android/material/button/MaterialButton;)V", "setDogLogIcon", "Landroid/view/View;", "dogLog", "textView", "setDogLogSelectionAdapter", "Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection$SelectionItem;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogTypeSelectionAdapter$Callback;", "setDogLogSelectionIcon", "setDogLogSelectionName", "setDogLogSelectionNameColor", "setDogLogTime", "eventTimeMs", "(Landroid/widget/TextView;Ljava/lang/Long;)V", "setMonthToText", "Landroid/widget/TextSwitcher;", "monthNumber", "(Landroid/widget/TextSwitcher;Ljava/lang/Integer;)V", "setShortWeekday", "weekdayNumber", "(Landroid/widget/TextView;Ljava/lang/Integer;)V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class CalendarBindingAdapters {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[DogLogTypes.values().length];
            iArr[DogLogTypes.PEE.ordinal()] = 1;
            iArr[DogLogTypes.POOP.ordinal()] = 2;
            iArr[DogLogTypes.EAT.ordinal()] = 3;
            iArr[DogLogTypes.DRINK.ordinal()] = 4;
            iArr[DogLogTypes.SLEEP.ordinal()] = 5;
            iArr[DogLogTypes.WALK.ordinal()] = 6;
            iArr[DogLogTypes.ACCIDENT_PEE.ordinal()] = 7;
            iArr[DogLogTypes.ACCIDENT_POOP.ordinal()] = 8;
            iArr[DogLogTypes.UNKNOWN_TYPE.ordinal()] = 9;
            kotlinx.coroutines.e.a.a = iArr;
        }
    }
    public static final void b(RecyclerView recyclerView, List<? extends app.dogo.com.dogo_android.util.n0.i> list, j.a aVar, String str, boolean z) {
        int i = 2;
        int i2 = 0;
        str = "<this>";
        n.f(recyclerView, str);
        if (list != null && aVar != null && recyclerView.getLayoutManager() == null) {
            i2 = 0;
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(recyclerView.getContext(), i2);
            i = 2;
            flexboxLayoutManager.g3(i);
            recyclerView.setLayoutManager(flexboxLayoutManager);
            if (recyclerView.getAdapter() == null) {
                recyclerView.setAdapter(new DogLogTypeListAdapter(aVar, list, str, z));
            }
        }
    }

    /* renamed from: c, reason: from kotlin metadata */
    public static final void setDogCalenderAdapter(MaterialButton result, Long callback) {
        str = "<this>";
        n.f(result, str);
        if (callback != null) {
            str2 = "d MMMM, yyyy";
            result.setText(new SimpleDateFormat(str2, Locale.getDefault()).format(new Date(callback.longValue(), r1)));
        }
    }

    /* renamed from: d, reason: from kotlin metadata */
    public static final void setDogCalenderAdapter(MaterialButton result, Integer callback, Integer textSwitcher) {
        int i = 2;
        Object[] arr;
        int i2 = 0;
        Object obj;
        String str2;
        str = "<this>";
        n.f(result, str);
        if (callback != null && textSwitcher != null) {
            if (DateFormat.is24HourFormat(result.getContext())) {
                i = 2;
                arr = new Object[i];
                i2 = 0;
                arr[i2] = callback;
                arr[1] = textSwitcher;
                str2 = "java.lang.String.format(format, *args)";
                n.e(String.format("%02d:%02d", Arrays.copyOf(arr, i)), str2);
            } else {
                Calendar time = Calendar.getInstance();
                time.set(11, callback.intValue());
                time.set(12, textSwitcher.intValue());
                String format = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(time.getTime());
            }
            result.setText(obj);
        }
    }

    /* renamed from: e, reason: from kotlin metadata */
    public static final void setButtonDate(RecyclerView types, y<? extends List<g.a>> callback, g.b initialSelection, ol isNewLog) {
        boolean z = false;
        androidx.recyclerview.widget.RecyclerView.m mVar = null;
        androidx.recyclerview.widget.RecyclerView.h initialSelection2;
        n.f(types, "<this>");
        n.f(isNewLog, "textSwitcher");
        z = callback instanceof LoadResult_Success;
        if (callback instanceof oadResult_Success && initialSelection != null) {
            mVar = null;
            if (types.getAdapter() == null) {
                types.setItemAnimator(null);
                types.setAdapter(new DogLogCalendarAdapter(initialSelection));
            }
            initialSelection2 = types.getAdapter();
            z = initialSelection2 instanceof DogLogCalendarAdapter;
            if (initialSelection2 instanceof DogLogCalendarAdapter) {
            }
            if (mVar != null) {
                mVar.m((List)callback.component1());
            }
            if (types.getItemDecorationCount() == 0) {
                types.h(new i(types.getContext(), 0));
            }
            types.post(new kotlinx.coroutines.a(types, isNewLog));
        }
    }

    public static final void f(RecyclerView recyclerView, List<DogLog> list, b.a aVar) {
        androidx.recyclerview.widget.RecyclerView.h adapter;
        str = "<this>";
        n.f(recyclerView, str);
        if (list != null && aVar != null && recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new DogLogSelectAdapter(list, aVar));
            if (recyclerView.getItemDecorationCount() == 0) {
                Context context = recyclerView.getContext();
                n.e(context, "context");
                recyclerView.h(new GenericInBetweenItemDivider(context, 0));
            }
        }
    }

    /* renamed from: g, reason: from kotlin metadata */
    private static final void setDogLogBorder(RecyclerView dogLogType, ol isTagSelected) throws android.content.res.Resources.NotFoundException {
        int i;
        n.f(dogLogType, "$this_setDogCalenderAdapter");
        n.f(isTagSelected, "$textSwitcher");
        i = 0;
        LinearLayoutManager r0 = dogLogType.getLayoutManager() instanceof LinearLayoutManager ? (inearLayoutManager)dogLogType.getLayoutManager() : 0;
        if (i != 0) {
            if (i.r2() == 0) {
                androidx.recyclerview.widget.RecyclerView.h adapter = dogLogType.getAdapter();
                z = adapter instanceof DogLogCalendarAdapter;
                if (adapter instanceof DogLogCalendarAdapter) {
                }
                if (i != 0) {
                    i.W2(i.i(), (int)(float)dogLogType.getWidth() - dogLogType.getResources().getDimension(2131165283) / (float)2);
                    app.dogo.com.dogo_android.u.n.p.g.a aVar = i.g(i.i());
                    if (aVar != null) {
                        isTagSelected.U(Integer.valueOf(aVar.d()));
                    }
                }
            }
        }
    }

    public static final void h(ImageView imageView, e eVar, Boolean boolean) throws android.content.res.Resources.NotFoundException {
        int i = 2131099855;
        int i2 = 2131230947;
        int color;
        str = "<this>";
        n.f(imageView, str);
        if (eVar != null && boolean != null && boolean.booleanValue()) {
            i2 = 2131230947;
            android.content.res.Resources.Theme theme = null;
            if (boolean.booleanValue()) {
                i = 2131099767;
                color = imageView.getResources().getColor(i, theme);
            } else {
                i = 2131099855;
                color = imageView.getResources().getColor(i, theme);
            }
            BindingAdapters.M(imageView, Integer.valueOf(i2));
            imageView.setImageTintList(ColorStateList.valueOf(color));
        }
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final void setDogLogCounter(ImageView count, e button) throws NoWhenBranchMatchedException {
        Integer num2;
        o pair;
        str = "<this>";
        n.f(count, str);
        if (button == null) {
            return;
        } else {
            int i3 = 2131099817;
            int i10 = 2131099772;
            int i = 2131231086;
            switch (kotlinx.coroutines.e.a.a[button.ordinal()]) {
                case 1: /* ordinal */
                    pair = new Pair(Integer.valueOf(i), Integer.valueOf(i10));
                    break;
                case 2: /* ordinal */
                    pair = new Pair(Integer.valueOf(R.drawable.ic_dog_poo), Integer.valueOf(i10));
                    break;
                case 3: /* ordinal */
                    pair = new Pair(Integer.valueOf(R.drawable.ic_dog_eat), Integer.valueOf(R.color.dog_log_eat_tag));
                    break;
                case 4: /* ordinal */
                    pair = new Pair(Integer.valueOf(R.drawable.ic_dog_water), Integer.valueOf(R.color.dog_log_drink_tag));
                    break;
                case 5: /* ordinal */
                    pair = new Pair(Integer.valueOf(R.drawable.ic_dog_sleep), Integer.valueOf(R.color.dog_log_sleep_tag));
                    break;
                case 6: /* ordinal */
                    pair = new Pair(Integer.valueOf(R.drawable.ic_dog_walk), Integer.valueOf(R.color.dog_log_walk_tag));
                    break;
                case 7: /* ordinal */
                    pair = new Pair(Integer.valueOf(i), Integer.valueOf(i3));
                    break;
                case 8: /* ordinal */
                    pair = new Pair(Integer.valueOf(i), Integer.valueOf(i3));
                    break;
                case 9: /* ordinal */
                    int i6 = 0;
                    pair = new Pair(Integer.valueOf(i6), Integer.valueOf(i6));
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            BindingAdapters.M(count, Integer.valueOf((Number)pair.a().intValue()));
            count.setImageTintList(a.c(count.getContext(), (Number)pair.b().intValue()));
        }
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static final void setDogLogIcon(ImageView dogLog, e textView) throws NoWhenBranchMatchedException {
        int i = 2131099821;
        n.f(dogLog, "<this>");
        if (textView == null) {
            return;
        } else {
            i = 2131099821;
            i = 2131099820;
            switch (kotlinx.coroutines.e.a.a[textView.ordinal()]) {
                case 1: /* ordinal */
                    BindingAdapters.M(dogLog, Integer.valueOf(R.drawable.circle_border));
                    dogLog.setImageTintList(a.c(dogLog.getContext(), i));
                    break;
                case 2: /* ordinal */
                    BindingAdapters.M(dogLog, Integer.valueOf(R.drawable.circle_border));
                    dogLog.setImageTintList(a.c(dogLog.getContext(), i));
                    break;
                case 3: /* ordinal */
                    i = 2131099819;
                    BindingAdapters.M(dogLog, Integer.valueOf(R.drawable.circle_border));
                    dogLog.setImageTintList(a.c(dogLog.getContext(), i));
                    break;
                case 4: /* ordinal */
                    i = 2131099818;
                    BindingAdapters.M(dogLog, Integer.valueOf(R.drawable.circle_border));
                    dogLog.setImageTintList(a.c(dogLog.getContext(), i));
                    break;
                case 5: /* ordinal */
                    i = 2131099822;
                    BindingAdapters.M(dogLog, Integer.valueOf(R.drawable.circle_border));
                    dogLog.setImageTintList(a.c(dogLog.getContext(), i));
                    break;
                case 6: /* ordinal */
                    i = 2131099823;
                    BindingAdapters.M(dogLog, Integer.valueOf(R.drawable.circle_border));
                    dogLog.setImageTintList(a.c(dogLog.getContext(), i));
                    break;
                case 7: /* ordinal */
                    i = 0;
                    BindingAdapters.M(dogLog, Integer.valueOf(R.drawable.circle_border));
                    dogLog.setImageTintList(a.c(dogLog.getContext(), i));
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final void k(TextView textView, Integer integer, MaterialButton materialButton) {
        n.f(textView, "<this>");
        str = "button";
        n.f(materialButton, str);
        if (integer != null) {
            int i = 1;
            if (integer.intValue() > 1) {
                Rect rect = new Rect();
                int i2 = 0;
                materialButton.getPaint().getTextBounds(materialButton.getText().toString(), i2, materialButton.getText().length(), rect);
                textView.setText(integer.toString());
                android.view.ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                str = "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams";
                Objects.requireNonNull(layoutParams, str);
                i3 = (int)(float)rect.width() * (float)textView.getContext().getResources().getDisplayMetrics().densityDpi / (float)160;
                layoutParams.leftMargin = i3;
                textView.setLayoutParams(layoutParams);
            }
        }
    }

    public static final void l(View view, DogLog dogLog, TextView textView) throws android.content.res.Resources.NotFoundException {
        n.f(view, "<this>");
        str = "textView";
        n.f(textView, str);
        if (dogLog != null) {
            view.setBackgroundResource(2131230879);
            view.setBackgroundTintList(a.c(view.getContext(), dogLog.getStyle().getTagColorRes()));
            String string = view.getResources().getString(dogLog.getStyle().getNameRes());
            str2 = "resources.getString(it.style.nameRes)";
            n.e(string, str2);
            textView.setText(String.valueOf(l.c1(string)));
            textView.setTextColor(view.getResources().getColor(dogLog.getStyle().getLetterColorRes(), null));
        }
    }

    public static final void m(RecyclerView recyclerView, List<i.b> list, k.a aVar) {
        Context context;
        String str2;
        str = "<this>";
        n.f(recyclerView, str);
        if (list != null && aVar != null && recyclerView.getItemDecorationCount() == 0) {
            context = recyclerView.getContext();
            str2 = "context";
            n.e(context, str2);
            recyclerView.h(new DogLogTypeSelectorItemDecoration(context));
            if (recyclerView.getAdapter() == null) {
                recyclerView.setAdapter(new DogLogTypeSelectionAdapter(aVar, list));
            }
        }
    }

    /* renamed from: n, reason: from kotlin metadata */
    public static final void setDogLogSelectionAdapter(ImageView types, e callback) throws NoWhenBranchMatchedException {
        Integer num = null;
        int i = 2131099817;
        str = "<this>";
        n.f(types, str);
        if (callback == null) {
            return;
        } else {
            int i10 = 2131231086;
            switch (kotlinx.coroutines.e.a.a[callback.ordinal()]) {
                case 1: /* ordinal */
                    num = Integer.valueOf(i10);
                    break;
                case 2: /* ordinal */
                    num = 2131231087;
                    break;
                case 3: /* ordinal */
                    num = 2131231084;
                    break;
                case 4: /* ordinal */
                    num = 2131231090;
                    break;
                case 5: /* ordinal */
                    num = 2131231088;
                    break;
                case 6: /* ordinal */
                    num = 2131231089;
                    break;
                case 7: /* ordinal */
                    num = Integer.valueOf(i10);
                    break;
                case 8: /* ordinal */
                    num = Integer.valueOf(i10);
                    break;
                case 9: /* ordinal */
                    int i6 = 0;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (callback.isAccident()) {
                i = 2131099817;
            } else {
                callback = callback.isSuccess() ? R.color.darkerGreen : R.color.gray;
            }
            BindingAdapters.M(types, num);
            types.setImageTintList((callback.isSuccess() ? R.color.darkerGreen : R.color.gray));
        }
    }

    public static final void o(TextView textView, e eVar) throws NoWhenBranchMatchedException, android.content.res.Resources.NotFoundException {
        int i = 2131887051;
        str = "<this>";
        n.f(textView, str);
        if (eVar == null) {
            return;
        } else {
            switch (kotlinx.coroutines.e.a.a[eVar.ordinal()]) {
                case 1: /* ordinal */
                    i = 2131887031;
                    break;
                case 2: /* ordinal */
                    i = 2131887051;
                    break;
                case 3: /* ordinal */
                    i = 2131887271;
                    break;
                case 4: /* ordinal */
                    i = 2131887270;
                    break;
                case 5: /* ordinal */
                    i = 2131887275;
                    break;
                case 6: /* ordinal */
                    i = 2131887276;
                    break;
                case 7: /* ordinal */
                    i = 2131887029;
                    break;
                case 8: /* ordinal */
                    i = 2131887049;
                    break;
                case 9: /* ordinal */
                    i = 0;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            textView.setText(textView.getResources().getText(i));
        }
    }

    public static final void p(TextView textView, e eVar) throws NoWhenBranchMatchedException, android.content.res.Resources.NotFoundException {
        int i = 2131099767;
        n.f(textView, "<this>");
        if (eVar == null) {
            return;
        } else {
            switch (kotlinx.coroutines.e.a.a[eVar.ordinal()]) {
                case 1: /* ordinal */
                    i = 2131099767;
                    break;
                case 2: /* ordinal */
                    i = 2131099840;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            android.content.res.Resources.Theme theme = null;
            textView.setTextColor(textView.getResources().getColor(i, theme));
        }
    }

    public static final void q(TextView textView, Long long) {
        str = "<this>";
        n.f(textView, str);
        if (long != null) {
            long.longValue();
            Calendar time = Calendar.getInstance();
            time.setTimeInMillis(long.longValue());
            int i7 = 2;
            Object[] arr = new Object[i7];
            arr[0] = Integer.valueOf(time.get(11));
            int i = 1;
            int i2 = 12;
            arr[i] = Integer.valueOf(time.get(i2));
            String formatted = String.format("%02d:%02d", Arrays.copyOf(arr, i7));
            str = "java.lang.String.format(format, *args)";
            n.e(formatted, str);
            textView.setText(formatted);
        }
    }

    public static final void r(TextSwitcher textSwitcher, Integer integer) throws android.content.res.Resources.NotFoundException {
        android.view.animation.Animation outAnimation;
        n.f(textSwitcher, "<this>");
        if (textSwitcher.getInAnimation() == null || textSwitcher.getOutAnimation() == null) {
            outAnimation = AnimationUtils.loadAnimation(textSwitcher.getContext(), 17432576);
            n.e(outAnimation, "loadAnimation(context, android.R.anim.fade_in)");
            android.view.animation.Animation animation = AnimationUtils.loadAnimation(textSwitcher.getContext(), 17432577);
            str = "loadAnimation(context, android.R.anim.fade_out)";
            n.e(animation, str);
            textSwitcher.setOutAnimation(animation);
            textSwitcher.setInAnimation(outAnimation);
        }
        if (integer != null) {
            integer.intValue();
            textSwitcher.setText(new DateFormatSymbols().getMonths()[integer.intValue()]);
        }
    }

    public static final void s(TextView textView, Integer integer) {
        str = "<this>";
        n.f(textView, str);
        if (integer != null) {
            textView.setText(new DateFormatSymbols().getShortWeekdays()[integer.intValue()]);
        }
    }


    /* renamed from: a, reason: from kotlin metadata */
    public static /* synthetic */ void setButtonTime(RecyclerView hours, ol minutes) {
        CalendarBindingAdapters.setDogLogBorder(hours, minutes);
    }
}
