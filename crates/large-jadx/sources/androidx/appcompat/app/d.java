package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.y0;
import androidx.core.app.a;
import androidx.core.app.f;
import androidx.core.app.h;
import androidx.core.app.q;
import androidx.core.app.q.a;
import androidx.fragment.app.e;
import d.a.o.b;
import d.a.o.b.a;

/* loaded from: classes.dex */
public class d extends e implements androidx.appcompat.app.e, q.a {

    private androidx.appcompat.app.f mDelegate;
    private Resources mResources;
    public d(int i) {
        super(i);
    }

    private boolean performMenuItemShortcut(KeyEvent keyEvent) {
        int metaStateHasNoModifiers;
        int decorView;
        KeyEvent obj3;
        metaStateHasNoModifiers = getWindow();
        if (Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode()) && metaStateHasNoModifiers != null && metaStateHasNoModifiers.getDecorView() != null && metaStateHasNoModifiers.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            if (!keyEvent.isCtrlPressed()) {
                if (!KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
                    if (keyEvent.getRepeatCount() == 0) {
                        if (!KeyEvent.isModifierKey(keyEvent.getKeyCode())) {
                            metaStateHasNoModifiers = getWindow();
                            if (metaStateHasNoModifiers != null) {
                                if (metaStateHasNoModifiers.getDecorView() != null) {
                                    if (metaStateHasNoModifiers.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
                                        return 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    @Override // androidx.fragment.app.e
    public void addContentView(View view, ViewGroup.LayoutParams viewGroup$LayoutParams2) {
        getDelegate().d(view, layoutParams2);
    }

    @Override // androidx.fragment.app.e
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(getDelegate().f(context));
    }

    @Override // androidx.fragment.app.e
    public void closeOptionsMenu() {
        androidx.appcompat.app.a supportActionBar;
        supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar != null) {
                if (!supportActionBar.g()) {
                    super.closeOptionsMenu();
                }
            } else {
            }
        }
    }

    @Override // androidx.fragment.app.e
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode;
        final androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (keyEvent.getKeyCode() == 82 && supportActionBar != null && supportActionBar.p(keyEvent)) {
            if (supportActionBar != null) {
                if (supportActionBar.p(keyEvent)) {
                    return 1;
                }
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public <T extends View> T findViewById(int i) {
        return getDelegate().i(i);
    }

    @Override // androidx.fragment.app.e
    public androidx.appcompat.app.f getDelegate() {
        androidx.appcompat.app.f mDelegate;
        if (this.mDelegate == null) {
            this.mDelegate = f.g(this, this);
        }
        return this.mDelegate;
    }

    @Override // androidx.fragment.app.e
    public androidx.appcompat.app.b getDrawerToggleDelegate() {
        return getDelegate().k();
    }

    @Override // androidx.fragment.app.e
    public MenuInflater getMenuInflater() {
        return getDelegate().m();
    }

    @Override // androidx.fragment.app.e
    public Resources getResources() {
        Resources mResources;
        Resources mResources2;
        Resources resources;
        if (this.mResources == null && y0.c()) {
            if (y0.c()) {
                mResources = new y0(this, super.getResources());
                this.mResources = mResources;
            }
        }
        if (this.mResources == null) {
            mResources2 = super.getResources();
        }
        return mResources2;
    }

    @Override // androidx.fragment.app.e
    public androidx.appcompat.app.a getSupportActionBar() {
        return getDelegate().n();
    }

    @Override // androidx.fragment.app.e
    public Intent getSupportParentActivityIntent() {
        return h.a(this);
    }

    @Override // androidx.fragment.app.e
    public void invalidateOptionsMenu() {
        getDelegate().p();
    }

    @Override // androidx.fragment.app.e
    public void onConfigurationChanged(Configuration configuration) {
        Object displayMetrics;
        Resources mResources;
        super.onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        getDelegate().r(configuration);
    }

    @Override // androidx.fragment.app.e
    public void onContentChanged() {
        onSupportContentChanged();
    }

    @Override // androidx.fragment.app.e
    protected void onCreate(Bundle bundle) {
        final androidx.appcompat.app.f delegate = getDelegate();
        delegate.o();
        delegate.s(bundle);
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.e
    public void onCreateSupportNavigateUpTaskStack(q q) {
        q.g(this);
    }

    @Override // androidx.fragment.app.e
    protected void onDestroy() {
        super.onDestroy();
        getDelegate().t();
    }

    @Override // androidx.fragment.app.e
    public boolean onKeyDown(int i, KeyEvent keyEvent2) {
        if (performMenuItemShortcut(keyEvent2)) {
            return 1;
        }
        return super.onKeyDown(i, keyEvent2);
    }

    @Override // androidx.fragment.app.e
    public final boolean onMenuItemSelected(int i, MenuItem menuItem2) {
        androidx.appcompat.app.a obj2;
        if (super.onMenuItemSelected(i, menuItem2)) {
            return 1;
        }
        obj2 = getSupportActionBar();
        if (menuItem2.getItemId() == 16908332 && obj2 != null && obj2 &= 4 != 0) {
            if (obj2 != null) {
                if (obj2 &= 4 != 0) {
                    return onSupportNavigateUp();
                }
            }
        }
        return 0;
    }

    @Override // androidx.fragment.app.e
    public boolean onMenuOpened(int i, Menu menu2) {
        return super.onMenuOpened(i, menu2);
    }

    @Override // androidx.fragment.app.e
    protected void onNightModeChanged(int i) {
    }

    @Override // androidx.fragment.app.e
    public void onPanelClosed(int i, Menu menu2) {
        super.onPanelClosed(i, menu2);
    }

    @Override // androidx.fragment.app.e
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().u(bundle);
    }

    @Override // androidx.fragment.app.e
    protected void onPostResume() {
        super.onPostResume();
        getDelegate().v();
    }

    @Override // androidx.fragment.app.e
    public void onPrepareSupportNavigateUpTaskStack(q q) {
    }

    @Override // androidx.fragment.app.e
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getDelegate().w(bundle);
    }

    @Override // androidx.fragment.app.e
    protected void onStart() {
        super.onStart();
        getDelegate().x();
    }

    @Override // androidx.fragment.app.e
    protected void onStop() {
        super.onStop();
        getDelegate().y();
    }

    @Override // androidx.fragment.app.e
    public void onSupportActionModeFinished(b b) {
    }

    @Override // androidx.fragment.app.e
    public void onSupportActionModeStarted(b b) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    @Override // androidx.fragment.app.e
    public boolean onSupportNavigateUp() {
        Object supportParentActivityIntent;
        supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent != null) {
            if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
                supportParentActivityIntent = q.i(this);
                onCreateSupportNavigateUpTaskStack(supportParentActivityIntent);
                onPrepareSupportNavigateUpTaskStack(supportParentActivityIntent);
                supportParentActivityIntent.l();
                a.o(this);
            } else {
                supportNavigateUpTo(supportParentActivityIntent);
            }
            return 1;
        }
        return 0;
    }

    @Override // androidx.fragment.app.e
    protected void onTitleChanged(java.lang.CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        getDelegate().I(charSequence);
    }

    @Override // androidx.fragment.app.e
    public b onWindowStartingSupportActionMode(b.a b$a) {
        return null;
    }

    @Override // androidx.fragment.app.e
    public void openOptionsMenu() {
        androidx.appcompat.app.a supportActionBar;
        supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar != null) {
                if (!supportActionBar.q()) {
                    super.openOptionsMenu();
                }
            } else {
            }
        }
    }

    @Override // androidx.fragment.app.e
    public void setContentView(int i) {
        getDelegate().D(i);
    }

    @Override // androidx.fragment.app.e
    public void setContentView(View view) {
        getDelegate().E(view);
    }

    @Override // androidx.fragment.app.e
    public void setContentView(View view, ViewGroup.LayoutParams viewGroup$LayoutParams2) {
        getDelegate().F(view, layoutParams2);
    }

    @Override // androidx.fragment.app.e
    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().G(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int i) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    @Override // androidx.fragment.app.e
    public void setTheme(int i) {
        super.setTheme(i);
        getDelegate().H(i);
    }

    @Override // androidx.fragment.app.e
    public b startSupportActionMode(b.a b$a) {
        return getDelegate().J(a);
    }

    @Override // androidx.fragment.app.e
    public void supportInvalidateOptionsMenu() {
        getDelegate().p();
    }

    @Override // androidx.fragment.app.e
    public void supportNavigateUpTo(Intent intent) {
        h.e(this, intent);
    }

    @Override // androidx.fragment.app.e
    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().B(i);
    }

    @Override // androidx.fragment.app.e
    public boolean supportShouldUpRecreateTask(Intent intent) {
        return h.f(this, intent);
    }
}
