package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.View;
import com.google.firebase.inappmessaging.display.internal.Logging;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class VerticalViewGroupMeasure {

    private int h;
    private List<com.google.firebase.inappmessaging.display.internal.layout.util.ViewMeasure> vms;
    private int w;
    public VerticalViewGroupMeasure() {
        super();
        ArrayList arrayList = new ArrayList();
        this.vms = arrayList;
        int i = 0;
        this.w = i;
        this.h = i;
    }

    public VerticalViewGroupMeasure(int i, int i2) {
        super();
        ArrayList arrayList = new ArrayList();
        this.vms = arrayList;
        this.w = i;
        this.h = i2;
    }

    public void add(View view, boolean z2) {
        ViewMeasure viewMeasure = new ViewMeasure(view, z2);
        viewMeasure.setMaxDimens(this.w, this.h);
        this.vms.add(viewMeasure);
    }

    public void allocateSpace(int i) {
        int i6;
        Object next2;
        int i2;
        boolean desiredHeight;
        Object next;
        int i4;
        int i3;
        int i5;
        String str;
        int cmp;
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = this.vms.iterator();
        while (iterator2.hasNext()) {
            next2 = iterator2.next();
            if ((ViewMeasure)next2.isFlex()) {
            }
            arrayList.add(next2);
        }
        VerticalViewGroupMeasure.1 anon = new VerticalViewGroupMeasure.1(this);
        Collections.sort(arrayList, anon);
        i6 = 0;
        Iterator iterator3 = arrayList.iterator();
        for (ViewMeasure next5 : iterator3) {
            i6 += desiredHeight;
        }
        int size = arrayList.size();
        if (size >= 6) {
        } else {
            int i10 = 1045220557;
            i11 -= i8;
            Logging.logdPair("VVGM (minFrac, maxFrac)", i10, i12);
            i2 = 0;
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                f2 /= f4;
                if (Float.compare(i13, i12) > 0) {
                } else {
                }
                i5 = i13;
                if (Float.compare(i13, i10) < 0) {
                }
                Logging.logdPair("\t(desired, granted)", i13, i5);
                next.setMaxDimens(this.w, (int)i16);
                float f5 = Math.min(i10 - i13, i2);
                i2 -= f5;
                i5 = cmp;
                i2 += i14;
                i5 = i12;
            }
        }
        IllegalStateException obj10 = new IllegalStateException("VerticalViewGroupMeasure only supports up to 5 children");
        throw obj10;
    }

    public int getTotalFixedHeight() {
        int i;
        Object desiredHeight;
        boolean flex;
        Iterator iterator = this.vms.iterator();
        i = 0;
        while (iterator.hasNext()) {
            desiredHeight = iterator.next();
            if (!(ViewMeasure)desiredHeight.isFlex()) {
            }
            i += desiredHeight;
        }
        return i;
    }

    public int getTotalHeight() {
        int i;
        int desiredHeight;
        Iterator iterator = this.vms.iterator();
        i = 0;
        for (ViewMeasure next2 : iterator) {
            i += desiredHeight;
        }
        return i;
    }

    public List<com.google.firebase.inappmessaging.display.internal.layout.util.ViewMeasure> getViews() {
        return this.vms;
    }

    public void reset(int i, int i2) {
        this.w = i;
        this.h = i2;
        ArrayList obj1 = new ArrayList();
        this.vms = obj1;
    }
}
