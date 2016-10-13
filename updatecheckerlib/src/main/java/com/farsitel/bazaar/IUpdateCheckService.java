/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\Amir\\Documents\\Android Studio Projects\\UpdateChecker\\updatecheckerlib\\src\\main\\aidl\\com\\farsitel\\bazaar\\IUpdateCheckService.aidl
 */
package com.farsitel.bazaar;
// Declare any non-default types here with import statements

public interface IUpdateCheckService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.farsitel.bazaar.IUpdateCheckService
{
private static final java.lang.String DESCRIPTOR = "com.farsitel.bazaar.IUpdateCheckService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.farsitel.bazaar.IUpdateCheckService interface,
 * generating a proxy if needed.
 */
public static com.farsitel.bazaar.IUpdateCheckService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.farsitel.bazaar.IUpdateCheckService))) {
return ((com.farsitel.bazaar.IUpdateCheckService)iin);
}
return new com.farsitel.bazaar.IUpdateCheckService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getVersionCode:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
long _result = this.getVersionCode(_arg0);
reply.writeNoException();
reply.writeLong(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.farsitel.bazaar.IUpdateCheckService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
@Override public long getVersionCode(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
long _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_getVersionCode, _data, _reply, 0);
_reply.readException();
_result = _reply.readLong();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getVersionCode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
/**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
public long getVersionCode(java.lang.String packageName) throws android.os.RemoteException;
}
