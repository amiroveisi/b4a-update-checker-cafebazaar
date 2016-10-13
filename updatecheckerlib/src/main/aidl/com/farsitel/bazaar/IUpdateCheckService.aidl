// IUpdateCheckService.aidl
package com.farsitel.bazaar;

// Declare any non-default types here with import statements

interface IUpdateCheckService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
   long getVersionCode(String packageName);
}
