## Result Wrapper Example

# Domain
Define an object [ResultState] to manage the result of the call to the repository method.

# Data
Contains the implementation of [MediaRepository].
[MediaRepositoryImpl] uses a random method to get a media list or an error through the object [ResultState].

# App
Simple application to display a media list or an error message.
The repository is called and the handling of [ResultState] is done in the view model [MainViewModel].