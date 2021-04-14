# GreenProductsApp
Just a test app, with a small UI and a few API endpoints.

## Endpoints
### UI
UI is accessible from this URL: http://<HOSTNAME>:<PORT>/index

Index page shows all the other pages accessible using this service.

### API
The APIs created for this service are listed below:
1. [GET] /api/v1/product/list -> Lists all registered products.
1. [GET] /api/v1/product/{id} -> Describes the product with the given id.
1. [GET] /api/v1/productorder/list -> Lists all orders.
1. [GET] /api/v1/productorder/{id} -> Describes the order with the given id.
1. [POST] /api/v1/productorder/create -> Creates a new order.

API contracts can be figured out by looking in the code. :P

## Maven
This project is a Maven project, and Maven commands can be used to build this project. Deploy repositories are not configured.

Command: mvn clean install

## Docker
Docker file is included with the project with the name "Dockerfile".

Before creating the docker image, the target jar should be created by building the project (see Maven section).

Command: docker build -t greenproductapp:latest -f Dockerfile --build-arg PROJECT_BUILD_FOLDER='./target' .

Have fun!