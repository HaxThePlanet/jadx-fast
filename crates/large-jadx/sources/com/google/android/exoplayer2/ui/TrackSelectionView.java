package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.n2.f.f;
import com.google.android.exoplayer2.n2.i.a;
import com.google.android.exoplayer2.source.k0;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.util.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public class TrackSelectionView extends LinearLayout {

    private com.google.android.exoplayer2.ui.a0 A;
    private CheckedTextView[][] B;
    private i.a C;
    private int D;
    private l0 E;
    private boolean F;
    private Comparator<com.google.android.exoplayer2.ui.TrackSelectionView.c> G;
    private com.google.android.exoplayer2.ui.TrackSelectionView.d H;
    private final int a;
    private final LayoutInflater b;
    private final CheckedTextView c;
    private final CheckedTextView v;
    private final com.google.android.exoplayer2.ui.TrackSelectionView.b w;
    private final SparseArray<f.f> x;
    private boolean y;
    private boolean z;

    static class a {
    }

    private class b implements View.OnClickListener {

        final com.google.android.exoplayer2.ui.TrackSelectionView a;
        private b(com.google.android.exoplayer2.ui.TrackSelectionView trackSelectionView) {
            this.a = trackSelectionView;
            super();
        }

        b(com.google.android.exoplayer2.ui.TrackSelectionView trackSelectionView, com.google.android.exoplayer2.ui.TrackSelectionView.a trackSelectionView$a2) {
            super(trackSelectionView);
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            TrackSelectionView.a(this.a, view);
        }
    }

    private static final class c {

        public final int a;
        public final int b;
        public final i1 c;
        public c(int i, int i2, i1 i13) {
            super();
            this.a = i;
            this.b = i2;
            this.c = i13;
        }
    }

    public interface d {
        public abstract void a(boolean z, List<f.f> list2);
    }
    public TrackSelectionView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        final int obj7 = 1;
        setOrientation(obj7);
        SparseArray obj8 = new SparseArray();
        this.x = obj8;
        obj8 = 0;
        setSaveFromParentEnabled(obj8);
        int[] iArr = new int[obj7];
        iArr[obj8] = 16843534;
        TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(iArr);
        int resourceId = styledAttributes.getResourceId(obj8, obj8);
        this.a = resourceId;
        styledAttributes.recycle();
        LayoutInflater obj6 = LayoutInflater.from(context);
        this.b = obj6;
        TrackSelectionView.b bVar = new TrackSelectionView.b(this, 0);
        this.w = bVar;
        m mVar = new m(getResources());
        this.A = mVar;
        this.E = l0.v;
        int i5 = 17367055;
        View inflate = obj6.inflate(i5, this, obj8);
        this.c = (CheckedTextView)inflate;
        inflate.setBackgroundResource(resourceId);
        inflate.setText(u.q);
        inflate.setEnabled(obj8);
        inflate.setFocusable(obj7);
        inflate.setOnClickListener(bVar);
        inflate.setVisibility(8);
        addView(inflate);
        addView(obj6.inflate(t.a, this, obj8));
        obj6 = obj6.inflate(i5, this, obj8);
        this.v = (CheckedTextView)obj6;
        obj6.setBackgroundResource(resourceId);
        obj6.setText(u.p);
        obj6.setEnabled(obj8);
        obj6.setFocusable(obj7);
        obj6.setOnClickListener(bVar);
        addView(obj6);
    }

    static void a(com.google.android.exoplayer2.ui.TrackSelectionView trackSelectionView, View view2) {
        trackSelectionView.d(view2);
    }

    private static int[] b(int[] iArr, int i2) {
        final int[] obj1 = Arrays.copyOf(iArr, length++);
        obj1[length2--] = i2;
        return obj1;
    }

    private static int[] c(int[] iArr, int i2) {
        int i4;
        int i3;
        int i;
        int i5;
        int[] iArr2 = new int[length--];
        i3 = i4;
        while (i4 < iArr.length) {
            i = iArr[i4];
            if (i != i2) {
            }
            i4++;
            iArr2[i3] = i;
            i3 = i5;
        }
        return iArr2;
    }

    private void d(View view) {
        CheckedTextView isDisabled;
        List overrides;
        if (view == this.c) {
            f();
        } else {
            if (view == this.v) {
                e();
            } else {
                g(view);
            }
        }
        j();
        final com.google.android.exoplayer2.ui.TrackSelectionView.d obj3 = this.H;
        if (obj3 != null) {
            obj3.a(getIsDisabled(), getOverrides());
        }
    }

    private void e() {
        this.F = false;
        this.x.clear();
    }

    private void f() {
        this.F = true;
        this.x.clear();
    }

    private void g(View view) {
        int i;
        int fVar2;
        f.f fVar;
        int[] iArr;
        int i2;
        boolean z;
        boolean z2;
        boolean obj9;
        i = 0;
        this.F = i;
        Object tag = view.getTag();
        g.e(tag);
        final int i3 = tag.a;
        fVar2 = tag.b;
        Object obj = this.x.get(i3);
        g.e(this.C);
        iArr = 1;
        if ((f.f)obj == null) {
            if (!this.z && this.x.size() > 0) {
                if (this.x.size() > 0) {
                    this.x.clear();
                }
            }
            iArr = new int[iArr];
            iArr[i] = fVar2;
            fVar = new f.f(i3, iArr);
            this.x.put(i3, fVar);
        } else {
            fVar = obj.b;
            obj9 = (CheckedTextView)view.isChecked();
            z = h(i3);
            if (!z) {
                if (i()) {
                    z2 = iArr;
                } else {
                    z2 = i;
                }
            } else {
            }
            if (obj9 != null && z2 != 0) {
                if (z2 != 0) {
                    if (obj.c == iArr) {
                        this.x.remove(i3);
                    } else {
                        fVar2 = new f.f(i3, TrackSelectionView.c(fVar, fVar2));
                        this.x.put(i3, fVar2);
                    }
                } else {
                    if (obj9 == null) {
                        if (z) {
                            fVar2 = new f.f(i3, TrackSelectionView.b(fVar, fVar2));
                            this.x.put(i3, fVar2);
                        } else {
                            iArr = new int[iArr];
                            iArr[i] = fVar2;
                            fVar = new f.f(i3, iArr);
                            this.x.put(i3, fVar);
                        }
                    }
                }
            } else {
            }
        }
    }

    @RequiresNonNull("mappedTrackInfo")
    private boolean h(int i) {
        i.a z;
        int i2;
        int i3;
        int obj5;
        final int i4 = 0;
        if (this.y && k0Var.a > 1 && this.C.a(this.D, i, i4) != 0) {
            if (k0Var.a > 1) {
                if (this.C.a(this.D, i, i4) != 0) {
                } else {
                    i2 = i4;
                }
            } else {
            }
        } else {
        }
        return i2;
    }

    private boolean i() {
        boolean z;
        int i;
        if (this.z && l0Var.a > 1) {
            if (l0Var.a > 1) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private void j() {
        int i;
        boolean size;
        int i3;
        int i2;
        CheckedTextView[][] arr;
        int length;
        this.c.setChecked(this.F);
        final int i4 = 0;
        if (!this.F && this.x.size() == 0) {
            i3 = this.x.size() == 0 ? 1 : i4;
        } else {
        }
        this.v.setChecked(i3);
        i = i4;
        while (i < arr2.length) {
            i3 = this.x.get(i);
            i2 = i4;
            arr = this.B;
            for (Object length : obj5) {
                if ((f.f)i3 != 0) {
                } else {
                }
                arr[i][i2].setChecked(i4);
                arr = this.B;
                Object tag = arr[i][i2].getTag();
                g.e(tag);
                length.setChecked((f.f)i3.a(tag.b));
            }
            i++;
            if (i3 != 0) {
            } else {
            }
            arr[i][i2].setChecked(i4);
            i2++;
            tag = arr[i][i2].getTag();
            g.e((TrackSelectionView.c)tag);
            this.B[i][i2].setChecked(i3.a(tag.b));
        }
    }

    private void k() {
        int i4;
        int i5;
        int i7;
        int i3;
        boolean z;
        com.google.android.exoplayer2.ui.TrackSelectionView.c[] arr;
        int i2;
        int inflate;
        int i;
        int cVar;
        com.google.android.exoplayer2.ui.TrackSelectionView.b i6;
        i1 i1Var;
        final int i9 = 1;
        childCount -= i9;
        while (i4 >= 3) {
            removeViewAt(i4);
            i4--;
        }
        int i10 = 0;
        if (this.C == null) {
            this.c.setEnabled(i10);
            this.v.setEnabled(i10);
        }
        this.c.setEnabled(i9);
        this.v.setEnabled(i9);
        l0 l0Var = this.C.e(this.D);
        this.E = l0Var;
        this.B = new CheckedTextView[l0Var.a];
        i7 = i10;
        l0 l0Var2 = this.E;
        while (i7 < l0Var2.a) {
            k0 k0Var = l0Var2.a(i7);
            i2 = k0Var.a;
            this.B[i7] = new CheckedTextView[i2];
            arr = new TrackSelectionView.c[i2];
            inflate = i10;
            while (inflate < k0Var.a) {
                cVar = new TrackSelectionView.c(i7, inflate, k0Var.a(inflate));
                arr[inflate] = cVar;
                inflate++;
            }
            Comparator comparator = this.G;
            if (comparator != null) {
            }
            i3 = i10;
            while (i3 < i2) {
                if (i3 == 0) {
                }
                if (!h(i7)) {
                } else {
                }
                i = 17367056;
                inflate = this.b.inflate(i, this, i10);
                (CheckedTextView)inflate.setBackgroundResource(this.a);
                inflate.setText(this.A.a(view6.c));
                inflate.setTag(arr[i3]);
                if (this.C.f(this.D, i7, i3) == 4) {
                } else {
                }
                inflate.setFocusable(i10);
                inflate.setEnabled(i10);
                this.B[i7][i3] = inflate;
                addView(inflate);
                i3++;
                inflate.setFocusable(i9);
                inflate.setOnClickListener(this.w);
                if (i()) {
                } else {
                }
                i = 17367055;
                addView(this.b.inflate(t.a, this, i10));
            }
            i7++;
            l0Var2 = this.E;
            if (i3 == 0) {
            }
            if (!h(i7)) {
            } else {
            }
            i = 17367056;
            inflate = this.b.inflate(i, this, i10);
            (CheckedTextView)inflate.setBackgroundResource(this.a);
            inflate.setText(this.A.a(view6.c));
            inflate.setTag(arr[i3]);
            if (this.C.f(this.D, i7, i3) == 4) {
            } else {
            }
            inflate.setFocusable(i10);
            inflate.setEnabled(i10);
            this.B[i7][i3] = inflate;
            addView(inflate);
            i3++;
            inflate.setFocusable(i9);
            inflate.setOnClickListener(this.w);
            if (i()) {
            } else {
            }
            i = 17367055;
            addView(this.b.inflate(t.a, this, i10));
            Arrays.sort(arr, comparator);
            cVar = new TrackSelectionView.c(i7, inflate, k0Var.a(inflate));
            arr[inflate] = cVar;
            inflate++;
        }
        j();
    }

    @Override // android.widget.LinearLayout
    public boolean getIsDisabled() {
        return this.F;
    }

    public List<f.f> getOverrides() {
        int i;
        Object valueAt;
        ArrayList arrayList = new ArrayList(this.x.size());
        i = 0;
        while (i < this.x.size()) {
            arrayList.add((f.f)this.x.valueAt(i));
            i++;
        }
        return arrayList;
    }

    @Override // android.widget.LinearLayout
    public void setAllowAdaptiveSelections(boolean z) {
        if (this.y != z) {
            this.y = z;
            k();
        }
    }

    @Override // android.widget.LinearLayout
    public void setAllowMultipleOverrides(boolean z) {
        boolean z2;
        boolean obj2;
        this.z = z;
        z2 = 1;
        if (this.z != z && !z && this.x.size() > z2) {
            this.z = z;
            if (!z) {
                z2 = 1;
                if (this.x.size() > z2) {
                    obj2 -= z2;
                    while (obj2 > 0) {
                        this.x.remove(obj2);
                        obj2--;
                    }
                }
            }
            k();
        }
    }

    @Override // android.widget.LinearLayout
    public void setShowDisableOption(boolean z) {
        int obj2;
        obj2 = z ? 0 : 8;
        this.c.setVisibility(obj2);
    }

    @Override // android.widget.LinearLayout
    public void setTrackNameProvider(com.google.android.exoplayer2.ui.a0 a0) {
        g.e(a0);
        this.A = (a0)a0;
        k();
    }
}
