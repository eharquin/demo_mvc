# A demo MVC application

> This application demonstrates the concepts behind the MVC pattern. This simple project implements a single controller,
> model and view by allowing the user to select a color from a given list.

![The MVC pattern](docs/images/mvc.png)

## Structure

### Controller
The Controller class is in charge of updating the model data when the user interacts with the view :

### Model
The model stores the application state, in this case mostly the color name.

### View
The view represents the interface the user interacts with, and uses the controller to update data.