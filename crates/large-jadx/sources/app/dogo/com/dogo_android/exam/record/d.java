package app.dogo.com.dogo_android.exam.k;

import java.util.Comparator;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements Comparator {

    public final /* synthetic */ int a;
    public /* synthetic */ d(int i) {
        super();
        this.a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return ExamRecordFragment.v2(this.a, object, object2);
    }
}
