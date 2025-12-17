package androidx.databinding;

/* loaded from: classes.dex */
public class a implements androidx.databinding.h {

    private transient androidx.databinding.j mCallbacks;
    @Override // androidx.databinding.h
    public void addOnPropertyChangedCallback(androidx.databinding.h.a h$a) {
        androidx.databinding.j mCallbacks;
        synchronized (this) {
            try {
                mCallbacks = new j();
                this.mCallbacks = mCallbacks;
                this.mCallbacks.a(a);
                throw a;
            }
        }
    }

    @Override // androidx.databinding.h
    public void notifyChange() {
        final androidx.databinding.j mCallbacks = this.mCallbacks;
        synchronized (this) {
            try {
                mCallbacks.d(this, 0, 0);
                throw th;
            }
        }
    }

    @Override // androidx.databinding.h
    public void notifyPropertyChanged(int i) {
        final androidx.databinding.j mCallbacks = this.mCallbacks;
        synchronized (this) {
            try {
                mCallbacks.d(this, i, 0);
                throw i;
            }
        }
    }

    @Override // androidx.databinding.h
    public void removeOnPropertyChangedCallback(androidx.databinding.h.a h$a) {
        final androidx.databinding.j mCallbacks = this.mCallbacks;
        synchronized (this) {
            try {
                mCallbacks.j(a);
                throw a;
            }
        }
    }
}
