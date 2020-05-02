<h1>Customer Products Assignement Application</h1>

<h2>Features</h2>
This application providers REST endpoints to:
    <ol>
        <li>Create and Manage CUSTOMERS.</li>
        <li>Create and Manager PRODUCTS.</li>
        <li>Un/assign PRODUCTS to CUSTOMERS (Many-to-Many)</li>
    </ol>

<h2>Documentation</h2>
Swagger API Documentation: <a href='http://localhost:8080/swagger-ui.html'>http://localhost:8080/swagger-ui.html</a>

<h2>Technologies Used</h2>
    <ol>
        <li>Spring Web</li>
        <li>Spring Data JPA</li>
        <li>Lombok</li>
        <li>H2 (In memory database)</li>
        <li>Flyway (Database Migration)</li>
        <li>Orika (Model Mapping)</li>
    </ol>
    
<h2>Running the Application</h2>
To run the application:
    <ol>
        <li> Run command <b>mvn clean install</b>. This created the customer-products-assignment-application.jar file.
        <li> Run the JAR file using the command <b>java -jar customer-products-assignment-application.jar</b>.
    </ol>
    
To build and run a Docker image:
    <ol>
        <li>Build the Docker image using the command <b>docker build -t product .</b> (where 'products' is the name of the image).</li>
        <li>Run the Docker image using the command <b>docker run -p 8080:8080 products</b> (where 1234 is the local port to redirect the container port to, and products is the image name).</li>
    </ol>
    
<h2>Miscellaneous</h2>
This project also includes CustomBeanController to experiment with Beans of different scopes. 