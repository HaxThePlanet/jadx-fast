package com.theartofdev.edmodo.cropper;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.d;
import java.io.File;
import java.io.IOException;

/* compiled from: CropImageActivity.java */
/* loaded from: classes2.dex */
public class CropImageActivity extends d implements CropImageView.i, CropImageView.e {

    private CropImageView a;
    private Uri b;
    private f c;
    private void o(Menu menu, int i, int i2) {
        MenuItem item = menu.findItem(i);
        if (item != null && icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
                item.setIcon(icon);
            } catch (Exception e) {
                i = "AIC";
                i2 = "Failed to update menu item color";
                Log.w(i, i2, e);
            }
        }
    }

    @Override // androidx.appcompat.app.d
    public void a(CropImageView cropImageView, Uri uri, Exception exc) {
        if (exc == null) {
            if (this.c.e0 != null) {
                this.a.setCropRect(this.c.e0);
            }
            int i = -1;
            if (this.c.f0 > -1) {
                this.a.setRotatedDegrees(this.c.f0);
            }
        } else {
            uri = null;
            i = 1;
            m(uri, exc, i);
        }
    }

    @Override // androidx.appcompat.app.d
    public void b(CropImageView cropImageView, CropImageView.b bVar) {
        m(bVar.g(), bVar.c(), bVar.f());
    }

    @Override // androidx.appcompat.app.d
    protected void i() {
        if (this.c.d0) {
            int i = 1;
            Uri uri = null;
            m(uri, uri, i);
        } else {
            this.a.p(j(), fVar2.Y, fVar2.Z, fVar2.a0, fVar2.b0, fVar2.c0);
        }
    }

    @Override // androidx.appcompat.app.d
    protected Uri j() {
        String str;
        Uri file;
        if (this.c.X != null) {
            if (this.c.X.equals(Uri.EMPTY)) {
                try {
                    if (this.c.Y == Bitmap.CompressFormat.JPEG) {
                        str = ".jpg";
                    } else {
                        Throwable th = this.c.Y == Bitmap.CompressFormat.PNG ? ".png" : ".webp";
                    }
                    str2 = "cropped";
                    file = Uri.fromFile((this.c.Y == Bitmap.CompressFormat.PNG ? ".png" : ".webp"));
                } catch (java.io.IOException ioException) {
                    throw new RuntimeException("Failed to create temp file for output image", (this.c.Y == Bitmap.CompressFormat.PNG ? ".png" : ".webp"));
                }
            }
        }
        return file;
    }

    @Override // androidx.appcompat.app.d
    protected Intent k(Uri uri, Exception exc, int i) {
        d.c cVar = new d.c(this.a.getImageUri(), uri, exc, this.a.getCropPoints(), this.a.getCropRect(), this.a.getRotatedDegrees(), this.a.getWholeImageRect(), i);
        final Intent intent = new Intent();
        intent.putExtras(getIntent());
        intent.putExtra("CROP_IMAGE_EXTRA_RESULT", cVar);
        return intent;
    }

    @Override // androidx.appcompat.app.d
    protected void l(int i) {
        this.a.o(i);
    }

    @Override // androidx.appcompat.app.d
    protected void m(Uri uri, Exception exc, int i) {
        int r0 = exc == null ? -1 : 204;
        setResult((exc == null ? -1 : 204), this.k(uri, exc, i));
        finish();
    }

    @Override // androidx.appcompat.app.d
    protected void n() {
        setResult(0);
        finish();
    }

    @Override // androidx.appcompat.app.d
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 200 && i2 == 0) {
            n();
            int i3 = -1;
            if (i2 == -1) {
                Uri uri2 = d.h(this, intent);
                this.b = uri2;
                if (d.k(this, uri2)) {
                    requestPermissions(new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 201);
                } else {
                    this.a.setImageUriAsync(this.b);
                }
            }
        }
    }

    @Override // androidx.appcompat.app.d
    public void onBackPressed() {
        super.onBackPressed();
        n();
    }

    @Override // androidx.appcompat.app.d
    public void onCreate(Bundle bundle) throws android.content.res.Resources.NotFoundException {
        android.os.Parcelable parcelable;
        java.lang.CharSequence charSequence;
        String str;
        super.onCreate(bundle);
        setContentView(j.a);
        this.a = (CropImageView)findViewById(i.d);
        Bundle bundleExtra = getIntent().getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE");
        this.b = (Uri)bundleExtra.getParcelable("CROP_IMAGE_EXTRA_SOURCE");
        str = "CROP_IMAGE_EXTRA_OPTIONS";
        this.c = (f)bundleExtra.getParcelable(str);
        if (bundle == null) {
            if (this.b != null) {
                if (this.b.equals(Uri.EMPTY)) {
                    if (d.j(this)) {
                        requestPermissions(new String[] { "android.permission.CAMERA" }, 2011);
                    } else {
                        d.m(this);
                    }
                } else {
                    if (d.k(this, this.b)) {
                        requestPermissions(new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 201);
                    } else {
                        this.a.setImageUriAsync(this.b);
                    }
                }
            }
        }
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null && this.c != null) {
            if (fVar.V == null || fVar.V.length() <= 0) {
                String string = getResources().getString(l.b);
            } else {
            }
            supportActionBar.u(charSequence);
            supportActionBar.s(true);
        }
    }

    @Override // androidx.appcompat.app.d
    public boolean onCreateOptionsMenu(Menu menu) {
        int i2 = 0;
        int i5;
        getMenuInflater().inflate(k.a, menu);
        final boolean z4 = true;
        if (!fVar.g0) {
            menu.removeItem(i.i);
            menu.removeItem(i.j);
        } else {
            if (fVar.i0) {
                menu.findItem(i.i).setVisible(z4);
            }
        }
        if (!this.c.h0) {
            menu.removeItem(i.f);
        }
        if (this.c.m0 != null) {
            menu.findItem(i.e).setTitle(this.c.m0);
        }
        i2 = 0;
        try {
            menu.findItem(i.e).setIcon(a.f(this, this.c.n0));
        } catch (Exception e) {
            Log.w("AIC", "Failed to read menu crop drawable", e);
        }
        if (this.c.W != 0) {
            o(menu, i.i, this.c.W);
            o(menu, i.j, this.c.W);
            o(menu, i.f, this.c.W);
            if (this.c != 0) {
                o(menu, i.e, this.c.W);
            }
        }
        return true;
    }

    @Override // androidx.appcompat.app.d
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        final boolean z = true;
        if (menuItem.getItemId() == i.e) {
            i();
            return true;
        }
        if (menuItem.getItemId() == i.i) {
            l(-this.c.j0);
            return true;
        }
        if (menuItem.getItemId() == i.j) {
            l(this.c.j0);
            return true;
        }
        if (menuItem.getItemId() == i.g) {
            this.a.f();
            return true;
        }
        if (menuItem.getItemId() == i.h) {
            this.a.g();
            return true;
        }
        if (menuItem.getItemId() == 0x0102002c /* Unknown resource */) {
            n();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.appcompat.app.d
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) throws android.content.res.Resources.NotFoundException {
        int length = 0;
        int i2 = 201;
        if (i == 201 && this.b != null) {
            length = iArr.length;
            if (iArr.length > 0) {
                length = 0;
                if (iArr[length] == 0) {
                    this.a.setImageUriAsync(this.b);
                } else {
                    Toast.makeText(this, l.a, 1).show();
                    n();
                }
            }
        }
        if (i == 2011) {
            d.m(this);
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onStart() {
        super.onStart();
        this.a.setOnSetImageUriCompleteListener(this);
        this.a.setOnCropImageCompleteListener(this);
    }

    @Override // androidx.appcompat.app.d
    protected void onStop() {
        super.onStop();
        final com.theartofdev.edmodo.cropper.CropImageView.i iVar = null;
        this.a.setOnSetImageUriCompleteListener(iVar);
        this.a.setOnCropImageCompleteListener(iVar);
    }
}
