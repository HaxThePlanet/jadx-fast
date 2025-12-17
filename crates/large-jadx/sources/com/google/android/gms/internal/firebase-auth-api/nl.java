package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.l.a;
import com.google.firebase.auth.PhoneAuthCredential;

/* loaded from: classes2.dex */
public class nl {

    private final com.google.android.gms.internal.firebase-auth-api.zl a;
    private final a b;
    public nl(com.google.android.gms.internal.firebase-auth-api.nl nl) {
        super(nl.a, nl.b);
    }

    public nl(com.google.android.gms.internal.firebase-auth-api.zl zl, a a2) {
        super();
        r.j(zl);
        this.a = (zl)zl;
        r.j(a2);
        this.b = (a)a2;
    }

    public final void a(String string) {
        try {
            this.a.x0(string);
            int arr = 0;
            arr = new Object[arr];
            this.b.b("RemoteException when sending auto retrieval timeout response.", string, arr);
        }
    }

    public void b(String string) {
        try {
            this.a.g0(string);
            int arr = 0;
            arr = new Object[arr];
            this.b.b("RemoteException when sending send verification code response.", string, arr);
        }
    }

    public final void c(com.google.android.gms.internal.firebase-auth-api.yn yn) {
        try {
            this.a.M(yn);
            int arr = 0;
            arr = new Object[arr];
            this.b.b("RemoteException when sending create auth uri response.", yn, arr);
        }
    }

    public final void d() {
        try {
            this.a.d();
            int arr = 0;
            arr = new Object[arr];
            this.b.b("RemoteException when sending delete account response.", th, arr);
        }
    }

    public final void e(com.google.android.gms.internal.firebase-auth-api.vf vf) {
        try {
            this.a.r1(vf);
            int arr = 0;
            arr = new Object[arr];
            this.b.b("RemoteException when sending failure result with credential", vf, arr);
        }
    }

    public final void f(com.google.android.gms.internal.firebase-auth-api.yf yf) {
        try {
            this.a.O1(yf);
            int arr = 0;
            arr = new Object[arr];
            this.b.b("RemoteException when sending failure result for mfa", yf, arr);
        }
    }

    public final void g(Status status, PhoneAuthCredential phoneAuthCredential2) {
        try {
            this.a.A(status, phoneAuthCredential2);
            phoneAuthCredential2 = this.b;
            int arr = 0;
            arr = new Object[arr];
            phoneAuthCredential2.b("RemoteException when sending failure result.", status, arr);
        }
    }

    public void h(Status status) {
        try {
            this.a.S1(status);
            int arr = 0;
            arr = new Object[arr];
            this.b.b("RemoteException when sending failure result.", status, arr);
        }
    }

    public final void i(com.google.android.gms.internal.firebase-auth-api.to to, com.google.android.gms.internal.firebase-auth-api.mo mo2) {
        try {
            this.a.Y0(to, mo2);
            mo2 = this.b;
            int arr = 0;
            arr = new Object[arr];
            mo2.b("RemoteException when sending get token and account info user response", to, arr);
        }
    }

    public final void j(com.google.android.gms.internal.firebase-auth-api.fp fp) {
        try {
            this.a.v0(fp);
            int arr = 0;
            arr = new Object[arr];
            this.b.b("RemoteException when sending password reset response.", fp, arr);
        }
    }

    public final void k() {
        try {
            this.a.f();
            int arr = 0;
            arr = new Object[arr];
            this.b.b("RemoteException when sending email verification response.", th, arr);
        }
    }

    public final void l(String string) {
        try {
            this.a.m1(string);
            int arr = 0;
            arr = new Object[arr];
            this.b.b("RemoteException when sending set account info response.", string, arr);
        }
    }

    public final void m() {
        try {
            this.a.e();
            int arr = 0;
            arr = new Object[arr];
            this.b.b("RemoteException when setting FirebaseUI Version", th, arr);
        }
    }

    public final void n(com.google.android.gms.internal.firebase-auth-api.to to) {
        try {
            this.a.m2(to);
            int arr = 0;
            arr = new Object[arr];
            this.b.b("RemoteException when sending token result.", to, arr);
        }
    }

    public final void o(PhoneAuthCredential phoneAuthCredential) {
        try {
            this.a.V0(phoneAuthCredential);
            int arr = 0;
            arr = new Object[arr];
            this.b.b("RemoteException when sending verification completed response.", phoneAuthCredential, arr);
        }
    }
}
