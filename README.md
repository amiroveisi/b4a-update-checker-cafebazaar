#b4a-update-checker-cafebazaar
this library lets B4A developers to check app updates on Cafebazaar using Cafebazaar services and alert users to update the app.

## how to use
1. download library .jar file from respository.  
2. copy downloaded file into your B4A Libraries folder (or Shared Libraries folder).  
3. select "ir.dotnetgeek.updatecheker" lib in B4A Library Manager.  
4. create a variable of type UpdateCheckerServiceManager like this:  
  `Dim updateChecker as UpdateCheckerServiceManager`   
  you can do this in `sub Globals` or any other sub you like.  
5. initialize `updateChecker` object and give it an event name:  
  `updateChecker.Initialize("updateckecher")`  
6. set the package name of your app on updateChecker object:  
  `updateChecker.PackageName = "example.yourapp.package"`  
7. call `InitService` on `updateChecker` object:  
  `updateChecker.InitService`  
  this method will start checking for updates and when it finished, it will raise an event named `updatecheckfinished`.  
8. handle `updatecheckfinished` event:  
    `Sub updatechecker_updatecheckfinished(version As Long)`  
     	`If version <> -1 Then`    
            `ToastMessageShow("new version found: " & version,True)`    
        `Else`    
            `ToastMessageShow("there is no update",True)`    
        `End If`    
    `End Sub`  
  
  **if there was no updates (or your package name is not valid) returned version number will be -1, else you will get the version number of your updated app in Cafebazaar.**  
  ***notice that according to Cafebazaar documents on this service, you can only check for updates of an app only from same app, in the other words, the package name of the app that sends request for update check, should be the same package name that update check request is sent for.***
