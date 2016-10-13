package ir.dotnetgeek.updatecheckerlib;

import android.content.Context;
import android.content.Intent;
import anywheresoftware.b4a.BA;

@BA.ShortName("UpdateCheckerServiceManager")
@BA.Events(values = {"updatecheckfinished(version as long)"})
public class UpdateCheckerServiceManager
{
    static String eventName;
    private UpdateServiceConnection connection;
    static String packageName;
    public void Initialize(String eventName)
    {
        UpdateCheckerServiceManager.eventName = eventName;
    }
    public  void initService(BA ba) {

        connection = new UpdateServiceConnection();
        connection.setBa(ba);
        BA.Log("initService()");

        Intent i = new Intent(
                "com.farsitel.bazaar.service.UpdateCheckService.BIND");
        i.setPackage("com.farsitel.bazaar");
        boolean ret = BA.applicationContext.bindService(i, connection, Context.BIND_AUTO_CREATE);
        BA.Log("initService() bound value: " + ret);

    }
    public  void releaseService() {
        BA.applicationContext.unbindService(connection);
        connection = null;
        BA.Log("releaseService(): unbound.");
    }

    public void setPackageName(String packageName)
    {
        UpdateCheckerServiceManager.packageName = packageName;
    }

}
