package app.dogo.com.dogo_android.u.n.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import app.dogo.com.dogo_android.h.ol;
import app.dogo.com.dogo_android.k.e;
import app.dogo.com.dogo_android.repository.domain.DogLog;
import app.dogo.com.dogo_android.repository.domain.DogLog.LogStyle;
import app.dogo.com.dogo_android.u.n.p.l.j;
import app.dogo.com.dogo_android.u.n.p.l.j.a;
import app.dogo.com.dogo_android.u.n.p.m.b;
import app.dogo.com.dogo_android.u.n.p.m.b.a;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.n0.i;
import app.dogo.com.dogo_android.util.n0.i.b;
import app.dogo.com.dogo_android.util.n0.j;
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
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.o;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u00072\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u001b\u0010\u0003\u001a\u00020\u0004*\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012J%\u0010\u0013\u001a\u00020\u0004*\u00020\u000f2\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0017J4\u0010\u0018\u001a\u00020\u0004*\u00020\u00052\u0014\u0010\u0019\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u0007\u0018\u00010\u001a2\u0008\u0010\t\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J&\u0010\u0018\u001a\u00020\u0004*\u00020\u00052\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00072\u0008\u0010\t\u001a\u0004\u0018\u00010 H\u0007J%\u0010!\u001a\u00020\u0004*\u00020\"2\u0008\u0010#\u001a\u0004\u0018\u00010$2\u0008\u0010%\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020\u0004*\u00020\"2\u0008\u0010(\u001a\u0004\u0018\u00010$H\u0007J\u0016\u0010)\u001a\u00020\u0004*\u00020\"2\u0008\u0010(\u001a\u0004\u0018\u00010$H\u0007J#\u0010*\u001a\u00020\u0004*\u00020+2\u0008\u0010,\u001a\u0004\u0018\u00010\u00152\u0006\u0010-\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010.J\u001e\u0010/\u001a\u00020\u0004*\u0002002\u0008\u00101\u001a\u0004\u0018\u00010\u001f2\u0006\u00102\u001a\u00020+H\u0007J&\u00103\u001a\u00020\u0004*\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u00072\u0008\u0010\t\u001a\u0004\u0018\u000105H\u0007J\u0016\u00106\u001a\u00020\u0004*\u00020\"2\u0008\u0010(\u001a\u0004\u0018\u00010$H\u0007J\u0016\u00107\u001a\u00020\u0004*\u00020+2\u0008\u0010(\u001a\u0004\u0018\u00010$H\u0007J\u0016\u00108\u001a\u00020\u0004*\u00020+2\u0008\u0010(\u001a\u0004\u0018\u00010$H\u0007J\u001b\u00109\u001a\u00020\u0004*\u00020+2\u0008\u0010:\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010;J\u001b\u0010<\u001a\u00020\u0004*\u00020=2\u0008\u0010>\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010?J\u001b\u0010@\u001a\u00020\u0004*\u00020+2\u0008\u0010A\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010B¨\u0006C", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/CalendarBindingAdapters;", "", "()V", "setButtonDate", "", "Landroidx/recyclerview/widget/RecyclerView;", "types", "", "Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection;", "callback", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$Callback;", "initialSelection", "", "isNewLog", "", "Lcom/google/android/material/button/MaterialButton;", "timestampMs", "", "(Lcom/google/android/material/button/MaterialButton;Ljava/lang/Long;)V", "setButtonTime", "hours", "", "minutes", "(Lcom/google/android/material/button/MaterialButton;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setDogCalenderAdapter", "result", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$CalendarCellItem;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$Callback;", "textSwitcher", "Lapp/dogo/com/dogo_android/databinding/LayoutMonthTextSwitcherBinding;", "Lapp/dogo/com/dogo_android/repository/domain/DogLog;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectAdapter$DogLogSelectCallback;", "setDogLogBorder", "Landroid/widget/ImageView;", "dogLogType", "Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "isTagSelected", "(Landroid/widget/ImageView;Lapp/dogo/com/dogo_android/enums/DogLogTypes;Ljava/lang/Boolean;)V", "setDogLogCalendarSelectionIcon", "logType", "setDogLogCalendarTagColor", "setDogLogCounter", "Landroid/widget/TextView;", "count", "button", "(Landroid/widget/TextView;Ljava/lang/Integer;Lcom/google/android/material/button/MaterialButton;)V", "setDogLogIcon", "Landroid/view/View;", "dogLog", "textView", "setDogLogSelectionAdapter", "Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection$SelectionItem;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogTypeSelectionAdapter$Callback;", "setDogLogSelectionIcon", "setDogLogSelectionName", "setDogLogSelectionNameColor", "setDogLogTime", "eventTimeMs", "(Landroid/widget/TextView;Ljava/lang/Long;)V", "setMonthToText", "Landroid/widget/TextSwitcher;", "monthNumber", "(Landroid/widget/TextSwitcher;Ljava/lang/Integer;)V", "setShortWeekday", "weekdayNumber", "(Landroid/widget/TextView;Ljava/lang/Integer;)V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[e.PEE.ordinal()] = 1;
            iArr[e.POOP.ordinal()] = 2;
            iArr[e.EAT.ordinal()] = 3;
            iArr[e.DRINK.ordinal()] = 4;
            iArr[e.SLEEP.ordinal()] = 5;
            iArr[e.WALK.ordinal()] = 6;
            iArr[e.ACCIDENT_PEE.ordinal()] = 7;
            iArr[e.ACCIDENT_POOP.ordinal()] = 8;
            iArr[e.UNKNOWN_TYPE.ordinal()] = 9;
            e.a.a = iArr;
        }
    }
    static {
    }

    public static void a(RecyclerView recyclerView, ol ol2) {
        e.g(recyclerView, ol2);
    }

    public static final void b(RecyclerView recyclerView, List<? extends i> list2, j.a j$a3, String string4, boolean z5) {
        Object flexboxLayoutManager;
        Object jVar;
        int i;
        int i2;
        n.f(recyclerView, "<this>");
        if (list2 != null && a3 != null && recyclerView.getLayoutManager() == null) {
            if (a3 != null) {
                if (recyclerView.getLayoutManager() == null) {
                    flexboxLayoutManager = new FlexboxLayoutManager(recyclerView.getContext(), 0);
                    flexboxLayoutManager.g3(2);
                    recyclerView.setLayoutManager(flexboxLayoutManager);
                }
                if (recyclerView.getAdapter() == null) {
                    jVar = new j(a3, list2, string4, z5);
                    recyclerView.setAdapter(jVar);
                }
            }
        }
    }

    public static final void c(MaterialButton materialButton, Long long2) {
        String longValue;
        Date date;
        String str;
        String obj5;
        n.f(materialButton, "<this>");
        if (long2 == null) {
        } else {
            obj5 = new SimpleDateFormat("d MMMM, yyyy", Locale.getDefault());
            date = new Date(long2.longValue(), obj1);
            materialButton.setText(obj5.format(date));
        }
    }

    public static final void d(MaterialButton materialButton, Integer integer2, Integer integer3) {
        int instance;
        Object[] arr;
        int i;
        String obj4;
        Object obj5;
        n.f(materialButton, "<this>");
        if (integer2 != null && integer3 != null) {
            if (integer3 != null) {
                if (DateFormat.is24HourFormat(materialButton.getContext())) {
                    f0 f0Var = f0.a;
                    instance = 2;
                    arr = new Object[instance];
                    arr[0] = integer2;
                    arr[1] = integer3;
                    n.e(String.format("%02d:%02d", Arrays.copyOf(arr, instance)), "java.lang.String.format(format, *args)");
                } else {
                    instance = Calendar.getInstance();
                    instance.set(11, integer2.intValue());
                    instance.set(12, integer3.intValue());
                    obj4 = w.a;
                    obj4 = new SimpleDateFormat("hh:mm a", Locale.getDefault());
                    obj4 = obj4.format(instance.getTime());
                }
                materialButton.setText(obj4);
            }
        }
    }

    public static final void e(RecyclerView recyclerView, y<? extends List<app.dogo.com.dogo_android.u.n.p.g.a>> y2, app.dogo.com.dogo_android.u.n.p.g.b g$b3, ol ol4) {
        androidx.recyclerview.widget.RecyclerView.h gVar;
        boolean z;
        int i;
        Object obj3;
        Object obj4;
        n.f(recyclerView, "<this>");
        n.f(ol4, "textSwitcher");
        if (y2 instanceof y.c && b3 != null && recyclerView.getAdapter() == null) {
            if (b3 != null) {
                if (recyclerView.getAdapter() == null) {
                    recyclerView.setItemAnimator(0);
                    gVar = new g(b3);
                    recyclerView.setAdapter(gVar);
                }
                obj4 = recyclerView.getAdapter();
                if (obj4 instanceof g) {
                    i = obj4;
                }
                if (i == 0) {
                } else {
                    i.m((List)(y.c)y2.a());
                }
                if (recyclerView.getItemDecorationCount() == 0) {
                    obj3 = new i(recyclerView.getContext(), 0);
                    recyclerView.h(obj3);
                }
                obj3 = new a(recyclerView, ol4);
                recyclerView.post(obj3);
            }
        }
    }

    public static final void f(RecyclerView recyclerView, List<DogLog> list2, b.a b$a3) {
        androidx.recyclerview.widget.RecyclerView.h bVar;
        List obj2;
        Object obj3;
        n.f(recyclerView, "<this>");
        if (list2 != null && a3 != null && recyclerView.getAdapter() == null) {
            if (a3 != null) {
                if (recyclerView.getAdapter() == null) {
                    bVar = new b(list2, a3);
                    recyclerView.setAdapter(bVar);
                }
                if (recyclerView.getItemDecorationCount() == 0) {
                    obj3 = recyclerView.getContext();
                    n.e(obj3, "context");
                    obj2 = new m(obj3, 0);
                    recyclerView.h(obj2);
                }
            }
        }
    }

    private static final void g(RecyclerView recyclerView, ol ol2) {
        int layoutManager;
        int adapter;
        int i;
        boolean z;
        Object obj4;
        n.f(recyclerView, "$this_setDogCalenderAdapter");
        n.f(ol2, "$textSwitcher");
        if (layoutManager instanceof LinearLayoutManager != null) {
        } else {
            layoutManager = i;
        }
        if (layoutManager == null) {
        } else {
            adapter = recyclerView.getAdapter();
            if (layoutManager.r2() == 0 && adapter instanceof g) {
                adapter = recyclerView.getAdapter();
                if (adapter instanceof g) {
                    i = adapter;
                }
                layoutManager.W2(i.i(), (int)i3);
                obj4 = i.g(i.i());
                if (i != 0 && obj4 != null) {
                    layoutManager.W2(i.i(), (int)i3);
                    obj4 = i.g(i.i());
                    if (obj4 != null) {
                        ol2.U(Integer.valueOf(obj4.d()));
                    }
                }
            }
        }
    }

    public static final void h(ImageView imageView, e e2, Boolean boolean3) {
        String str;
        int i;
        ColorStateList obj3;
        int obj4;
        n.f(imageView, "<this>");
        if (e2 != null && boolean3 != 0) {
            if (boolean3 != 0) {
                obj3 = boolean3.booleanValue() ? R.drawable.dog_log_cell_thick_border : R.drawable.dog_log_cell_border;
                str = 0;
                if (boolean3.booleanValue()) {
                    obj4 = imageView.getResources().getColor(2131099767, str);
                } else {
                    obj4 = imageView.getResources().getColor(2131099855, str);
                }
                n.M(imageView, Integer.valueOf(obj3));
                imageView.setImageTintList(ColorStateList.valueOf(obj4));
            }
        }
    }

    public static final void i(ImageView imageView, e e2) {
        Object context;
        Integer valueOf2;
        Integer valueOf;
        int i;
        ColorStateList obj4;
        n.f(imageView, "<this>");
        if (e2 == null) {
        } else {
            int i3 = 2131099817;
            int i10 = 2131099772;
            i = 2131231086;
            switch (obj4) {
                case 1:
                    obj4 = new o(Integer.valueOf(i), Integer.valueOf(i10));
                    break;
                case 2:
                    obj4 = new o(2131231087, Integer.valueOf(i10));
                    break;
                case 3:
                    obj4 = new o(2131231084, 2131099819);
                    break;
                case 4:
                    obj4 = new o(2131231090, 2131099818);
                    break;
                case 5:
                    obj4 = new o(2131231088, 2131099822);
                    break;
                case 6:
                    obj4 = new o(2131231089, 2131099823);
                    break;
                case 7:
                    obj4 = new o(Integer.valueOf(i), Integer.valueOf(i3));
                    break;
                case 8:
                    obj4 = new o(Integer.valueOf(i), Integer.valueOf(i3));
                    break;
                case 9:
                    int i6 = 0;
                    obj4 = new o(Integer.valueOf(i6), Integer.valueOf(i6));
                    break;
                default:
                    NoWhenBranchMatchedException obj3 = new NoWhenBranchMatchedException();
                    throw obj3;
            }
            n.M(imageView, Integer.valueOf((Number)obj4.a().intValue()));
            imageView.setImageTintList(a.c(imageView.getContext(), (Number)obj4.b().intValue()));
        }
    }

    public static final void j(ImageView imageView, e e2) {
        int str;
        int i;
        ColorStateList obj3;
        n.f(imageView, "<this>");
        if (e2 == null) {
        } else {
            str = 2131099821;
            switch (obj3) {
                case 1:
                    str = i;
                    n.M(imageView, 2131230879);
                    imageView.setImageTintList(a.c(imageView.getContext(), str));
                    break;
                case 2:
                    n.M(imageView, 2131230879);
                    imageView.setImageTintList(a.c(imageView.getContext(), str));
                    break;
                case 3:
                    str = 2131099819;
                    n.M(imageView, 2131230879);
                    imageView.setImageTintList(a.c(imageView.getContext(), str));
                    break;
                case 4:
                    str = 2131099818;
                    n.M(imageView, 2131230879);
                    imageView.setImageTintList(a.c(imageView.getContext(), str));
                    break;
                case 5:
                    str = 2131099822;
                    n.M(imageView, 2131230879);
                    imageView.setImageTintList(a.c(imageView.getContext(), str));
                    break;
                case 6:
                    str = 2131099823;
                    n.M(imageView, 2131230879);
                    imageView.setImageTintList(a.c(imageView.getContext(), str));
                    break;
                case 7:
                    str = 0;
                    n.M(imageView, 2131230879);
                    imageView.setImageTintList(a.c(imageView.getContext(), str));
                    break;
                default:
                    NoWhenBranchMatchedException obj2 = new NoWhenBranchMatchedException();
                    throw obj2;
            }
        }
    }

    public static final void k(TextView textView, Integer integer2, MaterialButton materialButton3) {
        String intValue;
        int paint;
        String string;
        int i;
        int obj5;
        Object obj6;
        n.f(textView, "<this>");
        n.f(materialButton3, "button");
        if (integer2 != 0 && integer2.intValue() > 1) {
            if (integer2.intValue() > 1) {
                Rect rect = new Rect();
                materialButton3.getPaint().getTextBounds(materialButton3.getText().toString(), 0, materialButton3.getText().length(), rect);
                textView.setText(integer2.toString());
                obj6 = textView.getLayoutParams();
                Objects.requireNonNull(obj6, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                obj6.leftMargin = (int)obj5;
                textView.setLayoutParams((ConstraintLayout.b)obj6);
            }
        }
    }

    public static final void l(View view, DogLog dogLog2, TextView textView3) {
        String str2;
        String str;
        Object obj2;
        int obj3;
        n.f(view, "<this>");
        n.f(textView3, "textView");
        if (dogLog2 == 0) {
        } else {
            view.setBackgroundResource(2131230879);
            view.setBackgroundTintList(a.c(view.getContext(), dogLog2.getStyle().getTagColorRes()));
            String string = view.getResources().getString(dogLog2.getStyle().getNameRes());
            n.e(string, "resources.getString(it.style.nameRes)");
            textView3.setText(String.valueOf(l.c1(string)));
            textView3.setTextColor(view.getResources().getColor(dogLog2.getStyle().getLetterColorRes(), 0));
        }
    }

    public static final void m(RecyclerView recyclerView, List<i.b> list2, app.dogo.com.dogo_android.u.n.p.k.a k$a3) {
        int itemDecorationCount;
        Object kVar;
        Context context;
        String str;
        n.f(recyclerView, "<this>");
        if (list2 != null && a3 != null && recyclerView.getItemDecorationCount() == 0) {
            if (a3 != null) {
                if (recyclerView.getItemDecorationCount() == 0) {
                    context = recyclerView.getContext();
                    n.e(context, "context");
                    itemDecorationCount = new j(context);
                    recyclerView.h(itemDecorationCount);
                }
                if (recyclerView.getAdapter() == null) {
                    kVar = new k(a3, list2);
                    recyclerView.setAdapter(kVar);
                }
            }
        }
    }

    public static final void n(ImageView imageView, e e2) {
        Integer valueOf;
        Object context;
        boolean accident;
        int obj3;
        n.f(imageView, "<this>");
        if (e2 == null) {
        } else {
            int i8 = 2131231086;
            switch (i2) {
                case 1:
                    valueOf = Integer.valueOf(i8);
                    break;
                case 2:
                    valueOf = 2131231087;
                    break;
                case 3:
                    valueOf = 2131231084;
                    break;
                case 4:
                    valueOf = 2131231090;
                    break;
                case 5:
                    valueOf = 2131231088;
                    break;
                case 6:
                    valueOf = 2131231089;
                    break;
                case 7:
                    valueOf = Integer.valueOf(i8);
                    break;
                case 8:
                    valueOf = Integer.valueOf(i8);
                    break;
                case 9:
                    valueOf = 0;
                    break;
                default:
                    NoWhenBranchMatchedException obj2 = new NoWhenBranchMatchedException();
                    throw obj2;
            }
            obj3 = e2.isAccident() ? R.color.dog_log_accident_tag : obj3 != null ? R.color.darkerGreen : R.color.gray;
            n.M(imageView, valueOf);
            imageView.setImageTintList(a.c(imageView.getContext(), obj3));
        }
    }

    public static final void o(TextView textView, e e2) {
        Object resources;
        java.lang.CharSequence obj2;
        n.f(textView, "<this>");
        if (e2 == null) {
        } else {
            switch (obj2) {
                case 1:
                    obj2 = 2131887031;
                    break;
                case 2:
                    obj2 = 2131887051;
                    break;
                case 3:
                    obj2 = 2131887271;
                    break;
                case 4:
                    obj2 = 2131887270;
                    break;
                case 5:
                    obj2 = 2131887275;
                    break;
                case 6:
                    obj2 = 2131887276;
                    break;
                case 7:
                    obj2 = 2131887029;
                    break;
                case 8:
                    obj2 = 2131887049;
                    break;
                case 9:
                    obj2 = 0;
                    break;
                default:
                    NoWhenBranchMatchedException obj1 = new NoWhenBranchMatchedException();
                    throw obj1;
            }
            textView.setText(textView.getResources().getText(obj2));
        }
    }

    public static final void p(TextView textView, e e2) {
        Object resources;
        int i;
        int obj3;
        n.f(textView, "<this>");
        if (e2 == 0) {
        } else {
            switch (obj3) {
                case 1:
                    obj3 = 2131099767;
                    break;
                case 2:
                    obj3 = 2131099840;
                    break;
                default:
                    NoWhenBranchMatchedException obj2 = new NoWhenBranchMatchedException();
                    throw obj2;
            }
            textView.setTextColor(textView.getResources().getColor(obj3, 0));
        }
    }

    public static final void q(TextView textView, Long long2) {
        String str;
        Object[] arr;
        int i;
        int i2;
        String obj5;
        n.f(textView, "<this>");
        if (long2 == null) {
        } else {
            long2.longValue();
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(long2.longValue());
            obj5 = f0.a;
            obj5 = 2;
            arr = new Object[obj5];
            arr[0] = Integer.valueOf(instance.get(11));
            arr[1] = Integer.valueOf(instance.get(12));
            obj5 = String.format("%02d:%02d", Arrays.copyOf(arr, obj5));
            n.e(obj5, "java.lang.String.format(format, *args)");
            textView.setText(obj5);
        }
    }

    public static final void r(TextSwitcher textSwitcher, Integer integer2) {
        android.view.animation.Animation outAnimation;
        android.view.animation.Animation animation;
        String str;
        String obj4;
        n.f(textSwitcher, "<this>");
        if (textSwitcher.getInAnimation() != null) {
            if (textSwitcher.getOutAnimation() == null) {
                outAnimation = AnimationUtils.loadAnimation(textSwitcher.getContext(), 17432576);
                n.e(outAnimation, "loadAnimation(context, android.R.anim.fade_in)");
                animation = AnimationUtils.loadAnimation(textSwitcher.getContext(), 17432577);
                n.e(animation, "loadAnimation(context, android.R.anim.fade_out)");
                textSwitcher.setOutAnimation(animation);
                textSwitcher.setInAnimation(outAnimation);
            }
        } else {
        }
        if (integer2 == null) {
        } else {
            integer2.intValue();
            DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
            textSwitcher.setText(dateFormatSymbols.getMonths()[integer2.intValue()]);
        }
    }

    public static final void s(TextView textView, Integer integer2) {
        String shortWeekdays;
        String obj2;
        n.f(textView, "<this>");
        if (integer2 == null) {
        } else {
            DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
            textView.setText(dateFormatSymbols.getShortWeekdays()[integer2.intValue()]);
        }
    }
}
