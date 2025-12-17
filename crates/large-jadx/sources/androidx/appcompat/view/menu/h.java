package androidx.appcompat.view.menu;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;
import androidx.appcompat.app.c;
import androidx.appcompat.app.c.a;
import androidx.appcompat.app.h;
import d.a.g;

/* loaded from: classes.dex */
class h implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, androidx.appcompat.view.menu.m.a {

    private androidx.appcompat.view.menu.g a;
    private c b;
    androidx.appcompat.view.menu.e c;
    private androidx.appcompat.view.menu.m.a v;
    public h(androidx.appcompat.view.menu.g g) {
        super();
        this.a = g;
    }

    @Override // android.content.DialogInterface$OnKeyListener
    public void a() {
        final c cVar = this.b;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    @Override // android.content.DialogInterface$OnKeyListener
    public void b(IBinder iBinder) {
        Object gVar;
        Object view;
        gVar = this.a;
        c.a aVar = new c.a(gVar.w());
        e eVar = new e(aVar.getContext(), g.j);
        this.c = eVar;
        eVar.h(this);
        this.a.b(this.c);
        aVar.a(this.c.a(), this);
        view = gVar.A();
        if (view != null) {
            aVar.c(view);
        } else {
            aVar.d(gVar.y());
            aVar.setTitle(gVar.z());
        }
        aVar.j(this);
        c create = aVar.create();
        this.b = create;
        create.setOnDismissListener(this);
        android.view.WindowManager.LayoutParams attributes = this.b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags = obj6 |= i2;
        this.b.show();
    }

    @Override // android.content.DialogInterface$OnKeyListener
    public void c(androidx.appcompat.view.menu.g g, boolean z2) {
        androidx.appcompat.view.menu.g gVar;
        if (!z2) {
            if (g == this.a) {
                a();
            }
        } else {
        }
        androidx.appcompat.view.menu.m.a aVar = this.v;
        if (aVar != null) {
            aVar.c(g, z2);
        }
    }

    @Override // android.content.DialogInterface$OnKeyListener
    public boolean d(androidx.appcompat.view.menu.g g) {
        final androidx.appcompat.view.menu.m.a aVar = this.v;
        if (aVar != null) {
            return aVar.d(g);
        }
        return 0;
    }

    @Override // android.content.DialogInterface$OnKeyListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.a.N((i)this.c.a().getItem(i2), 0);
    }

    @Override // android.content.DialogInterface$OnKeyListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.c.c(this.a, true);
    }

    @Override // android.content.DialogInterface$OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent3) {
        int keyDispatcherState;
        int i;
        Object obj3;
        if (i2 != 82) {
            if (i2 == 4) {
                i = 1;
                if (keyEvent3.getAction() == 0 && keyEvent3.getRepeatCount() == 0) {
                    if (keyEvent3.getRepeatCount() == 0) {
                        obj3 = this.b.getWindow();
                        obj3 = obj3.getDecorView();
                        obj3 = obj3.getKeyDispatcherState();
                        if (obj3 != null && obj3 != null && obj3 != null) {
                            obj3 = obj3.getDecorView();
                            if (obj3 != null) {
                                obj3 = obj3.getKeyDispatcherState();
                                if (obj3 != null) {
                                    obj3.startTracking(keyEvent3, this);
                                    return i;
                                }
                            }
                        }
                    } else {
                        keyDispatcherState = this.b.getWindow();
                        keyDispatcherState = keyDispatcherState.getDecorView();
                        keyDispatcherState = keyDispatcherState.getKeyDispatcherState();
                        if (keyEvent3.getAction() == i && !keyEvent3.isCanceled() && keyDispatcherState != null && keyDispatcherState != null && keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent3)) {
                            if (!keyEvent3.isCanceled()) {
                                keyDispatcherState = this.b.getWindow();
                                if (keyDispatcherState != null) {
                                    keyDispatcherState = keyDispatcherState.getDecorView();
                                    if (keyDispatcherState != null) {
                                        keyDispatcherState = keyDispatcherState.getKeyDispatcherState();
                                        if (keyDispatcherState != null) {
                                            if (keyDispatcherState.isTracking(keyEvent3)) {
                                                this.a.e(i);
                                                dialogInterface.dismiss();
                                                return i;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                }
            }
        } else {
        }
        return this.a.performShortcut(i2, keyEvent3, 0);
    }
}
