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
    
<h2>Miscellaneous</h2>
This project also includes CustomBeanController to experiment with Beans of different scopes. 