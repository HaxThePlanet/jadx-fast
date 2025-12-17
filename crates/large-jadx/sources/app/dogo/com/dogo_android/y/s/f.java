package app.dogo.com.dogo_android.y.s;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class f implements y {

    public final app.dogo.com.dogo_android.y.s.j a;
    public f(app.dogo.com.dogo_android.y.s.j j) {
        super();
        this.a = j;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        j.G1(this.a, (ProgramLessonItem)object);
    }
}
