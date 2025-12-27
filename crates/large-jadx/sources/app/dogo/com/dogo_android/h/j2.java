package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingObservable;
import app.dogo.com.dogo_android.util.f0.m;

/* compiled from: CellEntrySortingChipItemBindingImpl.java */
/* loaded from: classes.dex */
public class j2 extends i2 implements b.a {

    private static final ViewDataBinding.g f0;
    private static final SparseIntArray g0 = new SparseIntArray();
    private final ConstraintLayout X;
    private final View.OnClickListener Y;
    private final View.OnClickListener Z;
    private final View.OnClickListener a0;
    private final View.OnClickListener b0;
    private final View.OnClickListener c0;
    private final View.OnClickListener d0;
    private long e0;
    static {
        obj.put(2131362900, 8);
        obj.put(2131363187, 9);
    }

    public j2(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 10, j2.f0, j2.g0));
    }

    private boolean W(EntrySortingObservable entrySortingObservable, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.e0 |= 1;
                    return true;
                } catch (Throwable unused) {
                }
                throw entrySortingObservable;
            }
        }
        if (i == 182) {
            synchronized (this) {
                try {
                    this.e0 |= 2;
                    return true;
                } catch (Throwable unused) {
                }
                throw entrySortingObservable;
            }
        }
        if (i == 136) {
            synchronized (this) {
                try {
                    this.e0 |= 4;
                    return true;
                } catch (Throwable unused) {
                }
                throw entrySortingObservable;
            }
        }
        if (i == 99) {
            synchronized (this) {
                try {
                    this.e0 |= 8;
                    return true;
                } catch (Throwable unused) {
                }
                throw entrySortingObservable;
            }
        }
        if (i == 186) {
            synchronized (this) {
                try {
                    this.e0 |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 78) {
            synchronized (this) {
                try {
                    this.e0 |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 52) {
            synchronized (this) {
                try {
                    this.e0 |= 64;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 53) {
            synchronized (this) {
                try {
                    this.e0 |= 128;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 190) {
            synchronized (this) {
                try {
                    this.e0 |= 256;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.i2
    public void A() {
        synchronized (this) {
            try {
                this.e0 = 512L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.i2
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.i2
    public boolean O(int i, Object object) {
        boolean z = true;
        if (183 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.i2
    public void V(EntrySortingObservable entrySortingObservable) {
        R(0, entrySortingObservable);
        this.W = entrySortingObservable;
        synchronized (this) {
            try {
                this.e0 |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.i2
    public final void b(int i, View view) {
        int i2 = 1;
        i2 = 1;
        i2 = 0;
        switch (i) {
            case 1:
                this.W.onLatestSelect();
                break;
            case 2:
                this.W.onPopularSelect();
                break;
            case 3:
                this.W.on24HourSelect();
                break;
            case 4:
                this.W.on7DaySelect();
                break;
            case 5:
                this.W.onCountrySelect();
                break;
            case 6:
                this.W.onYourSelect();
                break;
            default:
        }
    }

    @Override // app.dogo.com.dogo_android.h.i2
    protected void m() {
        String str;
        long l;
        long l3;
        int latestTabVisibility;
        int cmp5;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i = 65536;
        boolean countryTabVisible;
        int i2 = 16384;
        int i3;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l12 = 0L;
                obj.e0 = l12;
            } catch (Throwable th) {
            }
        }
        long l13 = 1023L & l;
        long l7 = 641L;
        final long l18 = 529L;
        final long l19 = 517L;
        long l20 = 515L;
        cmp5 = 0;
        latestTabVisibility = 0;
        if (l13 != l12) {
            long l22 = l & 517L;
            if (l22 != l12) {
                if (obj.W != null) {
                    app.dogo.com.dogo_android.k.b selectedTab = obj.W.getSelectedTab();
                } else {
                }
                int r13 = cmp5 == ChallengeSortingTab.POPULAR_TAB ? 1 : latestTabVisibility;
                int r14 = cmp5 == ChallengeSortingTab.YOUR_TAB ? 1 : latestTabVisibility;
                int r7 = cmp5 == ChallengeSortingTab.COUNTRY ? 1 : latestTabVisibility;
                int r8 = cmp5 == ChallengeSortingTab.DAYS_7 ? 1 : latestTabVisibility;
                int r9 = cmp5 == ChallengeSortingTab.HOURS_24 ? 1 : latestTabVisibility;
                int r27 = cmp5 == ChallengeSortingTab.LATEST_TAB ? 1 : latestTabVisibility;
            } else {
            }
            long l23 = l & 529L;
            latestTabVisibility = 8;
            if (l23 != l12) {
                if (obj.W != null) {
                    boolean welcomeTabVisible = obj.W.isWelcomeTabVisible();
                } else {
                }
                if (l23 != l12) {
                    if (latestTabVisibility != 0) {
                        l3 = l | 2048L;
                        i = 131072;
                    } else {
                        l3 = l | 1024L;
                        i = 65536;
                    }
                    l = l3 | i;
                }
                int r6 = latestTabVisibility;
                int r32 = latestTabVisibility;
            } else {
            }
            long l24 = l & 641L;
            if (l24 != l12) {
                if (obj.W != null) {
                    countryTabVisible = obj.W.isCountryTabVisible();
                } else {
                }
                if (l24 != l12) {
                    int r35 = countryTabVisible ? 8192 : 4096;
                    l = l | (countryTabVisible ? 8192 : 4096);
                }
                if (countryTabVisible) {
                } else {
                }
            }
            long l25 = l & 515L;
            if (l25 != l12) {
                if (obj.W != null) {
                    boolean visible = obj.W.isVisible();
                } else {
                }
                if (l25 != l12) {
                    int r36 = latestTabVisibility != 0 ? 32768 : 16384;
                    l = l | (latestTabVisibility != 0 ? 32768 : 16384);
                }
                if (latestTabVisibility != 0) {
                } else {
                }
            }
            long l26 = l & 521L;
            if (l26 == l12 || obj.W == null) {
            } else {
                latestTabVisibility = obj.W.getLatestTabVisibility();
            }
            long l10 = 769L;
            long l27 = l & l10;
            if (l27 == l12 || obj.W == null) {
            } else {
                latestTabVisibility = obj.W.getYourTabVisibility();
            }
            long l9 = 545L;
            long l28 = l & l9;
            if (l28 != l12 && obj.W != null) {
                boolean hour24TabVisible = obj.W.isHour24TabVisible();
                if (l28 != l12) {
                    int r39 = latestTabVisibility != 0 ? 524288 : 262144;
                    l = l | (latestTabVisibility != 0 ? 524288 : 262144);
                }
                if (latestTabVisibility == 0) {
                }
            }
            long l8 = 577L;
            l11 = l & l8;
            if (l11 != l12 && obj.W != null) {
                String countryCode = obj.W.getCountryCode();
            }
        } else {
        }
        long l21 = l & 515L;
        if (l21 != l12) {
            obj.O.setVisibility(latestTabVisibility);
        }
        long l17 = l & 517L;
        if (obj.O != l12) {
            a.a(obj.P, z);
            a.a(obj.Q, z2);
            a.a(obj.R, z3);
            a.a(obj.S, z4);
            a.a(obj.U, z5);
            a.a(obj.V, z6);
        }
        long l14 = 512L & l;
        if (obj.R != l12) {
            obj.P.setOnClickListener(obj.Y);
            obj.Q.setOnClickListener(obj.c0);
            obj.R.setOnClickListener(obj.Z);
            obj.S.setOnClickListener(obj.a0);
            obj.U.setOnClickListener(obj.d0);
            obj.V.setOnClickListener(obj.b0);
        }
        long l15 = 641L & l;
        if (obj.R != l12) {
            obj.P.setVisibility(latestTabVisibility);
        }
        long l16 = 577L & l;
        if (obj.R != l12) {
            app.dogo.com.dogo_android.util.binding.m.m(obj.P, str, 3);
        }
        l4 = l & 529L;
        if (obj.R != l12) {
            obj.Q.setVisibility(latestTabVisibility);
            obj.U.setVisibility(latestTabVisibility);
        }
        l5 = 545L & l;
        if (obj.R != l12) {
            obj.R.setVisibility(latestTabVisibility);
        }
        l6 = 521L & l;
        if (obj.R != l12) {
            obj.S.setVisibility(latestTabVisibility);
        }
        l2 = l & 769L;
        if (obj.e0 != l12) {
            obj.V.setVisibility(latestTabVisibility);
        }
    }

    @Override // app.dogo.com.dogo_android.h.i2
    public boolean y() {
        synchronized (this) {
            try {
                if (this.e0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private j2(e eVar, View view, Object[] objectArr) {
        final Object eVar4 = this;
        int i2 = 5;
        int i = 3;
        super(eVar, view, 1, (ChipGroup)objectArr[1], (Chip)objectArr[6], (Chip)objectArr[i2], (Chip)objectArr[4], (Chip)objectArr[2], (FrameLayout)objectArr[8], (Chip)obj, (HorizontalScrollView)obj2, (Chip)obj3);
        eVar4.e0 = -1L;
        Object obj11 = null;
        eVar4.O.setTag(obj11);
        eVar4.P.setTag(obj11);
        eVar4.Q.setTag(obj11);
        eVar4.R.setTag(obj11);
        eVar4.S.setTag(obj11);
        Object obj10 = objectArr[0];
        eVar4.X = obj10;
        obj10.setTag(obj11);
        eVar4.U.setTag(obj11);
        eVar4.V.setTag(obj11);
        eVar4.N(view);
        eVar4.Y = new b(eVar4, i2);
        eVar4.Z = new b(eVar4, i);
        eVar4.a0 = new b(eVar4, 1);
        eVar4.b0 = new b(eVar4, 6);
        eVar4.c0 = new b(eVar4, 4);
        eVar4.d0 = new b(eVar4, 2);
        A();
    }
}
