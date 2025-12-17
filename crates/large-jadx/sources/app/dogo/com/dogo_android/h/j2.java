package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.a;
import app.dogo.com.dogo_android.k.b;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingObservable;
import app.dogo.com.dogo_android.util.f0.m;

/* loaded from: classes.dex */
public class j2 extends app.dogo.com.dogo_android.h.i2 implements b.a {

    private static final ViewDataBinding.g f0;
    private static final SparseIntArray g0;
    private final ConstraintLayout X;
    private final View.OnClickListener Y;
    private final View.OnClickListener Z;
    private final View.OnClickListener a0;
    private final View.OnClickListener b0;
    private final View.OnClickListener c0;
    private final View.OnClickListener d0;
    private long e0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j2.g0 = sparseIntArray;
        sparseIntArray.put(2131362900, 8);
        sparseIntArray.put(2131363187, 9);
    }

    public j2(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 10, j2.f0, j2.g0));
    }

    private j2(e e, View view2, Object[] object3Arr3) {
        final Object obj22 = this;
        int i15 = 5;
        int i11 = 3;
        super(e, view2, 1, (ChipGroup)object3Arr3[1], (Chip)object3Arr3[6], (Chip)object3Arr3[i15], (Chip)object3Arr3[4], (Chip)object3Arr3[2], (FrameLayout)object3Arr3[8], (Chip)object3Arr3[i11], (HorizontalScrollView)object3Arr3[9], (Chip)object3Arr3[7]);
        obj22.e0 = -1;
        int i6 = 0;
        obj22.O.setTag(i6);
        obj22.P.setTag(i6);
        obj22.Q.setTag(i6);
        obj22.R.setTag(i6);
        obj22.S.setTag(i6);
        Object obj11 = object3Arr3[0];
        obj22.X = (ConstraintLayout)obj11;
        obj11.setTag(i6);
        obj22.U.setTag(i6);
        obj22.V.setTag(i6);
        obj22.N(view2);
        b bVar = new b(obj22, i15);
        obj22.Y = bVar;
        b bVar2 = new b(obj22, i11);
        obj22.Z = bVar2;
        b bVar3 = new b(obj22, 1);
        obj22.a0 = bVar3;
        b bVar4 = new b(obj22, 6);
        obj22.b0 = bVar4;
        b bVar5 = new b(obj22, 4);
        obj22.c0 = bVar5;
        b bVar6 = new b(obj22, 2);
        obj22.d0 = bVar6;
        A();
    }

    private boolean W(EntrySortingObservable entrySortingObservable, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.e0 = l9 |= i27;
            return obj5;
            synchronized (this) {
                this.e0 = l9 |= i27;
                return obj5;
            }
        }
        if (i2 == 182) {
            this.e0 = l8 |= i26;
            return obj5;
            synchronized (this) {
                this.e0 = l8 |= i26;
                return obj5;
            }
        }
        if (i2 == 136) {
            this.e0 = l7 |= i25;
            return obj5;
            synchronized (this) {
                this.e0 = l7 |= i25;
                return obj5;
            }
        }
        if (i2 == 99) {
            this.e0 = l6 |= i24;
            return obj5;
            synchronized (this) {
                this.e0 = l6 |= i24;
                return obj5;
            }
        }
        if (i2 == 186) {
            this.e0 = l5 |= i23;
            return obj5;
            synchronized (this) {
                this.e0 = l5 |= i23;
                return obj5;
            }
        }
        if (i2 == 78) {
            this.e0 = l4 |= i22;
            return obj5;
            synchronized (this) {
                this.e0 = l4 |= i22;
                return obj5;
            }
        }
        if (i2 == 52) {
            this.e0 = l3 |= i21;
            return obj5;
            synchronized (this) {
                this.e0 = l3 |= i21;
                return obj5;
            }
        }
        try {
            if (i2 == 53) {
            }
            this.e0 = l |= i19;
            return obj5;
            throw entrySortingObservable;
            if (i2 == 190) {
            }
            this.e0 = l2 |= i20;
            return obj5;
            throw entrySortingObservable;
            return 0;
        } catch (Throwable th) {
        }
    }

    @Override // app.dogo.com.dogo_android.h.i2
    public void A() {
        this.e0 = 512;
        I();
        return;
        synchronized (this) {
            this.e0 = 512;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i2
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return W((EntrySortingObservable)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.i2
    public boolean O(int i, Object object2) {
        int obj2;
        if (183 == i) {
            V((EntrySortingObservable)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.i2
    public void V(EntrySortingObservable entrySortingObservable) {
        R(0, entrySortingObservable);
        this.W = entrySortingObservable;
        this.e0 = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(0, entrySortingObservable);
            this.W = entrySortingObservable;
            this.e0 = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i2
    public final void b(int i, View view2) {
        EntrySortingObservable obj2;
        int obj3;
        obj3 = 1;
        final int i2 = 0;
        switch (i) {
            case 1:
                obj2 = this.W;
                obj3 = i2;
                obj2.onLatestSelect();
                break;
            case 2:
                obj2 = this.W;
                obj3 = i2;
                obj2.onPopularSelect();
                break;
            case 3:
                obj2 = this.W;
                obj3 = i2;
                obj2.on24HourSelect();
                break;
            case 4:
                obj2 = this.W;
                obj3 = i2;
                obj2.on7DaySelect();
                break;
            case 5:
                obj2 = this.W;
                obj3 = i2;
                obj2.onCountrySelect();
                break;
            case 6:
                obj2 = this.W;
                obj3 = i2;
                obj2.onYourSelect();
                break;
            default:
        }
    }

    @Override // app.dogo.com.dogo_android.h.i2
    protected void m() {
        int i24;
        int cmp;
        int cmp8;
        int cmp3;
        int cmp4;
        long l;
        int i2;
        int i23;
        int i29;
        int cmp5;
        int cmp7;
        int cmp6;
        int cmp2;
        int i14;
        int i18;
        int i12;
        int selectedTab;
        int i26;
        int i9;
        int i13;
        int i7;
        int i19;
        b lATEST_TAB;
        int i20;
        int i16;
        int i28;
        int i4;
        int i11;
        int countryCode;
        int i;
        int i8;
        int i10;
        int i3;
        int i17;
        int i15;
        int welcomeTabVisible;
        int i6;
        int countryTabVisible;
        int latestTabVisibility;
        int yourTabVisibility;
        int i21;
        int hour24TabVisible;
        int i22;
        int i5;
        int i30;
        int i25;
        int i27;
        final Object obj = this;
        l = obj.e0;
        final int i31 = 0;
        obj.e0 = i31;
        EntrySortingObservable entrySortingObservable = obj.W;
        final int i46 = 529;
        final int i47 = 517;
        int i48 = 515;
        countryCode = 0;
        i = 0;
        synchronized (this) {
            obj = this;
            l = obj.e0;
            i31 = 0;
            obj.e0 = i31;
            entrySortingObservable = obj.W;
            i46 = 529;
            i47 = 517;
            i48 = 515;
            countryCode = 0;
            i = 0;
        }
        if (Long.compare(i50, i31) != 0) {
            if (entrySortingObservable != null) {
                try {
                    selectedTab = entrySortingObservable.getSelectedTab();
                    selectedTab = countryCode;
                    if (selectedTab == b.POPULAR_TAB) {
                    } else {
                    }
                    i28 = 1;
                    i28 = i;
                    i4 = 1;
                }
                i4 = i;
                i9 = selectedTab == b.COUNTRY ? 1 : i;
                i13 = selectedTab == b.DAYS_7 ? 1 : i;
                i7 = selectedTab == b.HOURS_24 ? 1 : i;
                i10 = selectedTab == b.LATEST_TAB ? 1 : i;
            } else {
            }
        } else {
            i10 = i4;
        }
        int cmp10 = Long.compare(i51, i31);
        int i43 = 8;
        if (cmp10 != 0) {
            if (entrySortingObservable != null) {
                welcomeTabVisible = entrySortingObservable.isWelcomeTabVisible();
            } else {
                welcomeTabVisible = i;
            }
            if (cmp10 != 0) {
                if (welcomeTabVisible != 0) {
                    l |= i53;
                    i6 = 131072;
                } else {
                    l |= i52;
                    i6 = 65536;
                }
                i23 |= i6;
            }
            i26 = welcomeTabVisible != 0 ? i : i43;
            i15 = welcomeTabVisible != 0 ? i43 : i;
        } else {
            i15 = i26;
        }
        int cmp13 = Long.compare(i54, i31);
        if (cmp13 != 0) {
            if (entrySortingObservable != null) {
                countryTabVisible = entrySortingObservable.isCountryTabVisible();
            } else {
                countryTabVisible = i;
            }
            if (cmp13 != 0) {
                latestTabVisibility = countryTabVisible != 0 ? 8192 : 4096;
                l |= latestTabVisibility;
            }
            if (countryTabVisible != 0) {
                i6 = i;
            } else {
                i6 = i43;
            }
        } else {
        }
        int cmp14 = Long.compare(i55, i31);
        if (cmp14 != 0) {
            if (entrySortingObservable != null) {
                latestTabVisibility = entrySortingObservable.isVisible();
            } else {
                latestTabVisibility = i;
            }
            if (cmp14 != 0) {
                yourTabVisibility = latestTabVisibility != 0 ? 32768 : 16384;
                l |= yourTabVisibility;
            }
            if (latestTabVisibility != 0) {
                countryTabVisible = i;
            } else {
                countryTabVisible = i43;
            }
        } else {
        }
        if (Long.compare(i56, i31) != 0 && entrySortingObservable != null) {
            if (entrySortingObservable != null) {
                latestTabVisibility = entrySortingObservable.getLatestTabVisibility();
            } else {
                latestTabVisibility = i;
            }
        } else {
        }
        if (Long.compare(i57, i31) != 0 && entrySortingObservable != null) {
            if (entrySortingObservable != null) {
                yourTabVisibility = entrySortingObservable.getYourTabVisibility();
            } else {
                yourTabVisibility = i;
            }
        } else {
        }
        int cmp17 = Long.compare(i58, i31);
        if (cmp17 != 0) {
            if (entrySortingObservable != null) {
                hour24TabVisible = entrySortingObservable.isHour24TabVisible();
            } else {
                hour24TabVisible = i;
            }
            if (cmp17 != 0) {
                i22 = hour24TabVisible != 0 ? 524288 : 262144;
                l |= i22;
            }
            if (hour24TabVisible != 0) {
            } else {
                i = i43;
            }
        }
        if (Long.compare(i21, i31) != 0 && entrySortingObservable != null) {
            if (entrySortingObservable != null) {
                countryCode = entrySortingObservable.getCountryCode();
            }
        }
        i16 = i26;
        i24 = countryCode;
        i30 = i;
        i19 = i10;
        i5 = i15;
        i20 = i6;
        i29 = countryTabVisible;
        i25 = latestTabVisibility;
        i27 = yourTabVisibility;
        if (Long.compare(i49, i31) != 0) {
            obj.O.setVisibility(i29);
        }
        if (Long.compare(i45, i31) != 0) {
            a.a(obj.P, i9);
            a.a(obj.Q, i13);
            a.a(obj.R, i7);
            a.a(obj.S, i19);
            a.a(obj.U, i28);
            a.a(obj.V, i4);
        }
        if (Long.compare(i35, i31) != 0) {
            obj.P.setOnClickListener(obj.Y);
            obj.Q.setOnClickListener(obj.c0);
            obj.R.setOnClickListener(obj.Z);
            obj.S.setOnClickListener(obj.a0);
            obj.U.setOnClickListener(obj.d0);
            obj.V.setOnClickListener(obj.b0);
        }
        if (Long.compare(i37, i31) != 0) {
            obj.P.setVisibility(i20);
        }
        if (Long.compare(i39, i31) != 0) {
            m.m(obj.P, i24, 3);
        }
        if (Long.compare(i14, i31) != 0) {
            obj.Q.setVisibility(i16);
            obj.U.setVisibility(i5);
        }
        if (Long.compare(i18, i31) != 0) {
            obj.R.setVisibility(i30);
        }
        if (Long.compare(i12, i31) != 0) {
            obj.S.setVisibility(i25);
        }
        if (Long.compare(i2, i31) != 0) {
            obj.V.setVisibility(i27);
        }
    }

    @Override // app.dogo.com.dogo_android.h.i2
    public boolean y() {
        synchronized (this) {
            try {
                return 1;
                return 0;
                throw th;
            }
        }
    }
}
