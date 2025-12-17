package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.google.android.material.internal.n;
import d.h.l.a;
import d.h.l.e0.c;
import d.h.l.u;
import f.c.a.e.f;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
final class MaterialCalendarGridView extends GridView {

    private final Calendar a;
    private final boolean b;

    class a extends a {
        a(com.google.android.material.datepicker.MaterialCalendarGridView materialCalendarGridView) {
            super();
        }

        @Override // d.h.l.a
        public void g(View view, c c2) {
            super.g(view, c2);
            c2.Z(0);
        }
    }
    public MaterialCalendarGridView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet2, int i3) {
        boolean obj1;
        super(context, attributeSet2, i3);
        this.a = u.q();
        if (j.R1(getContext())) {
            setNextFocusLeftId(f.a);
            setNextFocusRightId(f.c);
        }
        this.b = j.S1(getContext());
        obj1 = new MaterialCalendarGridView.a(this);
        u.l0(this, obj1);
    }

    private void a(int i, Rect rect2) {
        int i2;
        int obj2;
        if (i == 33) {
            setSelection(b().i());
        } else {
            if (i == 130) {
                setSelection(b().b());
            } else {
                super.onFocusChanged(true, i, rect2);
            }
        }
    }

    private View c(int i) {
        return getChildAt(i -= firstVisiblePosition);
    }

    private static int d(View view) {
        return left += obj1;
    }

    private static boolean e(Long long, Long long2, Long long3, Long long4) {
        int i;
        long longValue;
        int obj3;
        int obj4;
        i = 1;
        if (long != 0 && long2 != 0 && long3 != null) {
            if (long2 != 0) {
                if (long3 != null) {
                    if (long4 == null) {
                    } else {
                        if (Long.compare(longValue, obj4) <= 0) {
                            if (Long.compare(obj4, longValue) < 0) {
                            } else {
                                i = 0;
                            }
                        }
                    }
                }
            }
        }
        return i;
    }

    @Override // android.widget.GridView
    public com.google.android.material.datepicker.n b() {
        return (n)super.getAdapter();
    }

    @Override // android.widget.GridView
    public Adapter getAdapter() {
        return b();
    }

    @Override // android.widget.GridView
    public ListAdapter getAdapter() {
        return b();
    }

    @Override // android.widget.GridView
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b().notifyDataSetChanged();
    }

    @Override // android.widget.GridView
    protected final void onDraw(Canvas canvas) {
        Object view;
        com.google.android.material.datepicker.n nVar2;
        Iterator iterator;
        int i7;
        int i8;
        int i;
        int width;
        boolean next;
        long longValue;
        int right2;
        Object obj;
        long longValue2;
        int right;
        long l;
        Long valueOf;
        int cmp;
        Calendar cmp2;
        int i5;
        float f4;
        int width2;
        int i6;
        int i4;
        Iterator it;
        com.google.android.material.datepicker.n nVar;
        Canvas canvas2;
        int i2;
        float f;
        float f2;
        float f3;
        android.graphics.Paint paint;
        int i3;
        view = this;
        super.onDraw(canvas);
        nVar2 = b();
        final com.google.android.material.datepicker.c cVar = nVar2.v;
        Long num = nVar2.c(Math.max(nVar2.b(), getFirstVisiblePosition()));
        final Long num2 = nVar2.c(Math.min(nVar2.i(), getLastVisiblePosition()));
        iterator = nVar2.b.L().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            longValue = next.a;
            if (longValue != null) {
            } else {
            }
            view = this;
            obj = next.b;
            if (obj == null) {
            } else {
            }
            longValue = (Long)longValue.longValue();
            longValue2 = (Long)next.b.longValue();
            if (MaterialCalendarGridView.e(num, num2, Long.valueOf(longValue), Long.valueOf(longValue2))) {
            } else {
            }
            next = n.e(this);
            int i21 = 5;
            if (Long.compare(longValue, longValue3) < 0) {
            } else {
            }
            view.a.setTimeInMillis(longValue);
            obj = MaterialCalendarGridView.d(view.c(nVar2.a(view.a.get(i21))));
            if (Long.compare(longValue2, longValue4) > 0) {
            } else {
            }
            view.a.setTimeInMillis(longValue2);
            l = MaterialCalendarGridView.d(view.c(nVar2.a(view.a.get(i21))));
            valueOf = (int)itemId2;
            while (valueOf <= (int)itemId) {
                numColumns *= valueOf;
                int i22 = i23 + -1;
                View view8 = view.c(i16);
                if (!next) {
                } else {
                }
                if (longValue2 > i22) {
                } else {
                }
                i6 = l;
                if (i16 > longValue) {
                } else {
                }
                width = obj;
                width2 = width;
                i = i3;
                canvas.drawRect((float)i, (float)i10, (float)width2, (float)i12, cVar.h);
                valueOf++;
                view = this;
                iterator = it;
                nVar2 = nVar;
                width = getWidth();
                i6 = 0;
                if (i16 > longValue) {
                } else {
                }
                i = obj;
                if (longValue2 > i22) {
                } else {
                }
                width2 = l;
                width2 = getWidth();
                i = 0;
            }
            view = this;
            i7 = i5;
            i8 = i4;
            numColumns *= valueOf;
            i22 = i23 + -1;
            view8 = view.c(i16);
            if (!next) {
            } else {
            }
            if (longValue2 > i22) {
            } else {
            }
            i6 = l;
            if (i16 > longValue) {
            } else {
            }
            width = obj;
            width2 = width;
            i = i3;
            canvas.drawRect((float)i, (float)i10, (float)width2, (float)i12, cVar.h);
            valueOf++;
            view = this;
            iterator = it;
            nVar2 = nVar;
            width = getWidth();
            i6 = 0;
            if (i16 > longValue) {
            } else {
            }
            i = obj;
            if (longValue2 > i22) {
            } else {
            }
            width2 = l;
            width2 = getWidth();
            i = 0;
            if (nVar2.g(i8)) {
            } else {
            }
            if (!next) {
            } else {
            }
            right = view.c(i8).getLeft();
            l = right;
            longValue2 = i8;
            right = view.c(i8).getRight();
            right = getWidth();
            if (nVar2.f(i7)) {
            } else {
            }
            if (!next) {
            } else {
            }
            right2 = view.c(i7 + -1).getLeft();
            obj = right2;
            longValue = i7;
            right2 = view.c(i7 + -1).getRight();
            right2 = 0;
        }
    }

    @Override // android.widget.GridView
    protected void onFocusChanged(boolean z, int i2, Rect rect3) {
        int obj1;
        if (z != 0) {
            a(i2, rect3);
        } else {
            super.onFocusChanged(false, i2, rect3);
        }
    }

    @Override // android.widget.GridView
    public boolean onKeyDown(int i, KeyEvent keyEvent2) {
        int i2;
        int obj5;
        final int i3 = 0;
        if (!super.onKeyDown(i, keyEvent2)) {
            return i3;
        }
        final int i4 = 1;
        if (getSelectedItemPosition() != -1) {
            if (getSelectedItemPosition() >= b().b()) {
            } else {
                if (19 == i) {
                    setSelection(b().b());
                    return i4;
                }
            }
            return i3;
        }
        return i4;
    }

    @Override // android.widget.GridView
    public void onMeasure(int i, int i2) {
        int z;
        android.view.ViewGroup.LayoutParams obj2;
        int obj3;
        if (this.b) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
            obj2.height = getMeasuredHeight();
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.GridView
    public void setAdapter(Adapter adapter) {
        setAdapter((ListAdapter)adapter);
    }

    @Override // android.widget.GridView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!listAdapter instanceof n) {
        } else {
            super.setAdapter(listAdapter);
        }
        Object[] arr = new Object[2];
        IllegalArgumentException obj4 = new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), n.class.getCanonicalName()));
        throw obj4;
    }

    @Override // android.widget.GridView
    public void setSelection(int i) {
        int obj2;
        if (i < b().b()) {
            super.setSelection(b().b());
        } else {
            super.setSelection(i);
        }
    }
}
