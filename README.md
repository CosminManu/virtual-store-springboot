# order management app -  gestionare comenzi plasate clienti

- subiect mpai 23.01.2025
- MVC SpringBoot, Thymeleaf, H2, Spring Data

This is a Spring Boot application for managing orders, providing a structured backend with controllers, services, and repository layers.

## Project Structure

```
order-management
│── src
│   ├── main
│   │   ├── java/com/example/order
│   │   │   ├── controller     # Handles HTTP requests (OrderController)
│   │   │   ├── dto            # Data Transfer Objects (OrderDTO)
│   │   │   ├── model          # Defines entities (Order, OrderStatus)
│   │   │   ├── service        # Business logic (OrderService)
│   │   │   ├── view           # Handles UI logic (OrderView)
│   │   │   ├── OrderManagementApplication.java  # Main Spring Boot app
│   │   ├── resources
│   │   │   ├── templates      # Thymeleaf templates (home.html, orders.html)
│   │   │   ├── static         # CSS, JavaScript
│   │   │   ├── application.properties  # Configuration file
│── pom.xml                     # Maven dependencies
│── README.md                   # Project documentation
```

## Features

- **Order Management:** Create, update, and retrieve orders.
- **MVC Architecture:** Uses Spring Boot’s Model-View-Controller structure.
- **Database Integration:** Utilizes a service layer to interact with the model.
- **Thymeleaf Views:** Simple front-end templates for displaying orders.

## Getting Started

### Prerequisites

- Java 17+
- Maven 3+
- Spring Boot 3+
- Database (H2, MySQL, or PostgreSQL)

### Installation & Running

1. **Clone the repository**
   ```sh
   git clone https://github.com/CosminManu/virtual-store-springboot.git
   cd virtual-store-springboot
   ```

2. **Build and run the application**
   ```sh
   mvn spring-boot:run
   ```

3. **Access the application**
    - API: `http://localhost:8080/api/orders`
    - UI : `http://localhost:8080/orders`

## API Endpoints

| Method | Endpoint           | Description              |
|--------|-------------------|--------------------------|
| GET    | /api/orders       | Get all orders          |
| GET    | /api/orders/{id}  | Get order by ID         |
| POST   | /api/orders       | Create a new order      |
| PUT    | /api/orders/{id}  | Update an order         |
| DELETE | /api/orders/{id}  | Delete an order         |

## Configuration

- Modify `src/main/resources/application.properties` to set up database configurations and other settings.

### 🔹Git commit message format
```
<type>: <short description>
```
- **`feat/feature:`**  → Adding a new feature.
- **`fix:`** → Fixing a bug.
- **`ref/refactor:`** → Improving existing code without changing functionality.
- **`docs:`** → Updating documentation.
- **`style:`** → Formatting changes (indentation, comments, etc)
- **`test:`** → Adding or modifying tests

### **🔹 Example Commit Messages**
#### **📌 Adding a New Model (Entity)**
```
feat: add Order model and OrderStatus enum
```
#### **📌 Updating an Existing Model**
```
refactor: update Order entity with JPA annotations
```
#### **📌 Fixing an Issue in the Model**
```
fix: resolve ID generation issue in Order entity
```
#### **📌 Updating Documentation**
```
docs: add Git commit best practices to README
```
