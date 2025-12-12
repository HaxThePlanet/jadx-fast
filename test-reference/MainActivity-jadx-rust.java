package com.topjohnwu.magisk.ui;

public final class MainActivity extends w1.i {

	public static final int S;
	public static final int T;
	public final s2.i M;
	public final int N;
	public final Object O;
	public final int P;
	public final P0.d Q;
	public boolean R;

	public MainActivity() {
		super();
		Object v0 = new a();
		Object i4 = 9;
		new a(i4, this);
		i4 = new i();
		new i(v0);
		this.M = i4;
		v0 = 2131492892;
		this.N = v0;
		v0 = new e();
		i4 = 0;
		new e(i4, this);
		i4 = 3;
		v0 = e.s(i4, v0);
		this.O = v0;
		v0 = 2131296597;
		this.P = v0;
		v0 = new d();
		new d(this);
		this.Q = v0;
		v0 = 1;
		this.R = v0;
	}

	public static void B(com.topjohnwu.magisk.ui.MainActivity mainActivity, boolean flag1, boolean flag2, int i3) {
		if (i == 0) {
			flag1 = i2;
		}
		if (i3 == 0) {
			flag2 = i2;
		}
		if (mainActivity == 0) {
		} else {
			mainActivity = 0;
		}
		if (flag2 == 0) {
			mainActivity.setVisibility(i3);
			mainActivity.setHidden(flag1);
		}
		if (flag1 == 0) {
			i3 = 8;
		}
		mainActivity.setVisibility(i3);
	}

	public final w1.e A() {
		if (i2 == 0) {
			v0 = (e) v0;
			return v0;
		}
		Object v0 = 0;
		return v0;
	}

	public final void C(boolean flag) {
		if (i == 0) {
		} else {
			Object i = i5;
		}
		if (flag == 0) {
			flag = this.K;
			Object i5 = flag;
			i5 = (a) i5;
			flag = i5.I;
			i = 2131230904;
			flag.setNavigationIcon(i);
		}
		if (flag == 0) {
		} else {
			flag = i5;
		}
		flag = (a) flag;
		flag = flag.I;
		flag.setNavigationIcon(i5);
	}

	public final boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
		if (v0 == 0) {
			Object v0 = this.A();
			v0 = v0.W(keyEvent);
			int i = 1;
			return i;
		}
		keyEvent = super.dispatchKeyEvent(keyEvent);
		return keyEvent;
	}

	public final w1.g g() {
		Object v0 = this.O;
		v0 = v0.getValue();
		v0 = (f) v0;
		return v0;
	}

	public final void onBackPressed() {
		if (v0 == 0) {
			Object v0 = this.A();
			v0 = v0.V();
			super.onBackPressed();
		}
	}

	public final void onCreate(android.os.Bundle bundle) {
		if (v0 != 0) {
			v0 = a.n;
		}
		if (v1 == 0) {
			v1 = d.n;
			Object v1 = v2.getTheme();
			int i = 2131886513;
			v1.applyStyle(i, 1);
		}
		if (v1 != 0) {
			v1 = Build$VERSION.SDK_INT;
			i = 31;
			v1 = new c();
			new c(v2);
			v1 = new i();
			new i(v2);
			v1.E();
			Object v2 = new f();
			i = 15;
			new f(i);
			v1.Q(v2);
		}
		if (v1 == 0) {
			v0.d(bundle);
		}
		v1 = f.l;
		v2 = new d();
		new d(v0, bundle);
		p.c(v1, v2);
	}

	public final boolean onOptionsItemSelected(android.view.MenuItem menuItem) {
		if (v0 != 16908332) {
			this.onBackPressed();
			menuItem = 1;
			return menuItem;
		}
		menuItem = super.onOptionsItemSelected(menuItem);
		return menuItem;
	}

	public final void onResume() {
		if (i == 0) {
			Object i = 0;
			obj.d(i);
		}
	}

	public final int v() {
		Object v0 = this.N;
		return v0;
	}

	public final android.view.View w() {
		if (v0 == 0) {
			Object v0 = v0.T();
		} else {
			v0 = i8;
		}
		if (v0 == 0) {
			Object v2 = v0.getVisibility();
			return v0;
		}
		if (v0 == 0) {
		} else {
			v0 = i8;
		}
		if (v0 != 0) {
			v0 = this.K;
			Object i8 = v0;
			i8 = (a) i8;
			v0 = i8.H;
			return v0;
		}
		return i8;
	}

	public final android.view.View x() {
		if (v0 == 0) {
			Object v0 = v0.U();
		} else {
			v0 = 0;
		}
		if (v0 != 0) {
			v0 = super.x();
		}
		return v0;
	}
}
