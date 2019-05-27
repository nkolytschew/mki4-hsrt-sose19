# HowTo Angular

See basics [here](BASIC.md)!

---
Start by installing NodeJs and NPM.
If you are using Ubuntu you can use 'SNAP' to install the current version of NodeJs!

Afterwards you can install angular via 'npm install -g @angular/cli'. This command installs a CLI, which simplifies the use of Angular. See https://cli.angular.io/ for further information.

## Create App

Use 'ng new <APP-NAME>' as an angular-CLI command to create a new application and choose your preferences.

Afterwards you can start developping you Frontend-Application and create HTML and CSS Templates.

## API and Communication

To communicate with a remote API (or your own) you have to use the provided HttpCLient!
This allows you to send request, receive the corresponding response and transform the resource to the required representation.
To make the HttpClient availabe, you have to add the 'HttpClientModule' from @angular/common/http to 'imports' in you app.module.ts!
Afterwards you are able to 'inject' the HttpClient to your services and send requests.
It is recommended to use the HttpClient over the old/deprecated 'http' and 'HttpModule', since it simplifies the communication with you API. You are now able to directly subscribe to an Observable and transform the data, instead of wrapping the response to a 'Response' Object and 'map' it to your Observable-Object and afterwards, transform it to the expected model.

Please see 'api.service.ts' for an simple example for GET and POST.

On your Remote System, you have to add a Cross-Origin functionality. Otherwise your apps will prevent your angular-app from accessing the services, because the request will come from an unknown 'source'. To allow access you have to add '@CrossOrigin' annotation over each function, you want to make accessible to your frontend!

## Hint

Please keep in mind, that model class you are implementing within your TypeScript, are only for your convenience to increase readability. 
After building your app, these classes are transpiled to plain JavaScript, which is a dynamic type language. Therefore you are able to access fields, which exists within the JSON, but are not provided by your model class.

