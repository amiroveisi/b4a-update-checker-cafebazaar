# b4a-update-checker-cafebazaar
this library lets B4A developers to check app updates on Cafebazaar using Cafebazaar services and alert users to update the app.

# how to use
1 - download library .jar file from respository.</br>
2- copy downloaded file into your B4A Libraries folder (or Shared Libraries folder).</br>
3- select "ir.dotnetgeek.updatecheker" lib in B4A Library Manager.</br>
4- create a variable of type UpdateCheckerServiceManager like this:</br>
  Dim updateChecker as UpdateCheckerServiceManager</br>
  you can do this in sub Globals or any other sub you like.</br>
5- initialize updateChecker object and give it an event name:</br>
  updateChecker.Initialize("updateckecher")</br>
6- set the package name of your app on updateChecker object:</br>
  updateChecker.PackageName = "example.yourapp.package"</br>
7- call InitService on updateChecker object:</br>
  updateChecker.InitService</br>
  this method will start checking for updates and when it finished, it will raise an event named 'updatecheckfinished'.</br>
8- handle 'updatecheckfinished' event:</br>
  Sub updatechecker_updatecheckfinished(version As Long)</br>
	  If version <> -1 Then</br>
		  ToastMessageShow("new version found: " & version,True)</br>
	  Else</br>
		  ToastMessageShow("there is no update",True)</br>
	  End If</br>
  End Sub</br>
  
  if there was no updates (or your package name is not valid) returned version number will be -1, else you will get the version number of your updated app in Cafebazaar.</br>
  notice that according to Cafebazaar documents on this service, you can only check for updates of an app only from same app, in the other words, the package name of the app that sends request for update check, should be the same package name that update check request is sent for.
