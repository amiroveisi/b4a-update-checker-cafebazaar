package ir.dotnetgeek.updatecheckerlib;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.farsitel.bazaar.IUpdateCheckService;

import anywheresoftware.b4a.BA;

import static ir.dotnetgeek.updatecheckerlib.UpdateCheckerServiceManager.packageName;

/**
 * Created by Amir on 12/10/2016.
 */

class UpdateServiceConnection implements ServiceConnection {
    private IUpdateCheckService service;
    private BA ba;

//
    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        service = IUpdateCheckService.Stub.asInterface(iBinder);
        try {
            long vCode = service.getVersionCode(packageName);
           BA.LogInfo("package name: " + packageName);
            BA.LogInfo("version code from lib: " + String.valueOf(vCode));
            if(ba.subExists(UpdateCheckerServiceManager.eventName + "_updatecheckfinished"))
            {
                BA.LogInfo("event sub exists: " + UpdateCheckerServiceManager.eventName);
                ba.raiseEvent(this,UpdateCheckerServiceManager.eventName + "_updatecheckfinished",vCode);
            }
            else
            {
                BA.LogError("event sub does not exist: " + UpdateCheckerServiceManager.eventName);
            }
        } catch (Exception e) {
            BA.LogError("onServiceConnected exception: " + e.getMessage());
        }
        BA.LogInfo("onServiceConnected(): Connected");
//
//
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        service = null;
        BA.Log("onServiceDisconnected(): Disconnected");

    }

    void setBa(BA ba)
    {
        this.ba = ba;
    }






}
