package androidx.databinding.library.baseAdapters;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DataBinderMapperImpl extends d {

    private static final SparseIntArray a;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray(0);
        DataBinderMapperImpl.a = sparseIntArray;
    }

    public List<d> a() {
        ArrayList arrayList = new ArrayList(0);
        return arrayList;
    }

    @Override // androidx.databinding.d
    public ViewDataBinding b(e e, View view2, int i3) {
        int obj1;
        if (DataBinderMapperImpl.a.get(i3) > 0) {
            if (view2.getTag() == null) {
            } else {
            }
            obj1 = new RuntimeException("view must have a tag");
            throw obj1;
        }
        return null;
    }

    @Override // androidx.databinding.d
    public ViewDataBinding c(e e, View[] view2Arr2, int i3) {
        SparseIntArray length;
        Object obj3;
        int obj4;
        if (view2Arr2 != null) {
            if (view2Arr2.length == 0) {
            } else {
                if (DataBinderMapperImpl.a.get(i3) > 0) {
                    if (view2Arr2[0].getTag() == null) {
                    } else {
                    }
                    RuntimeException obj2 = new RuntimeException("view must have a tag");
                    throw obj2;
                }
            }
        }
        return null;
    }
}
