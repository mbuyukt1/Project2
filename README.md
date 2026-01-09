# Project2 - Task 2

This document covers **Task 2 (Final Implementation)**. It builds upon Task 1 by implementing a full Product Management System with **CRUD** (Create, Read, Update, Delete) operations, **Exception Handling**, and an **In-Memory Repository**.

## 🚀 Features
* **Create Product:** Add new products to the system via API.
* **Read Product:** Retrieve detailed product information by ID.
* **Delete Product:** Remove a product from the database.
* **Exception Handling:** Custom **404 Not Found** error when accessing non-existent IDs.
* **In-Memory Storage:** Uses **H2 Database** for data persistence as per requirements.
* **API Documentation:** Fully integrated with **Swagger UI**.

## 🛠 Technologies Used
* **Java 21**
* **Spring Boot 3.4.1**
* **Spring Web** (REST API)
* **SpringDoc OpenAPI** (Swagger UI)
* **Maven**

## ⚙️ How to Run
1.  Open the project in **IntelliJ IDEA**.
2.  Run the `Task2Application` class.
3.  Once the application starts, open **Swagger UI** to test the API:
    👉 **[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)**

---

## 📸 API Usage & Screenshots
Below is the step-by-step verification of all functionalities using Swagger UI.

### 0️⃣ API Overview
The main dashboard showing all available endpoints in the `product-controller`.
![Swagger Menu](screenshots/Swagger.png)

### 1️⃣ Create Product (POST)
**Action:** Adding a new product named "Test Product".
* **Request:**
  ![Post Request](screenshots/Post.png)


### 2️⃣ Read Product (GET)
**Action:** Retrieving details of the product with ID `1`.
* **Request :**
  ![Get Request](screenshots/Get.png)

### 3️⃣ Delete Product (DELETE)
**Action:** Removing the product with ID `1`.
* **Request :**
  ![Delete Request](screenshots/Delete.png)

---

## 🔌 API Endpoints Reference
| Method | Endpoint             | Description |
| :--- |:---------------------| :--- |
| **POST** | `/api/products`      | Create a new product |
| **GET** | `/api/products/{id}` | Get product details |
| **PUT** | `/api/products/{id}` | Update product name |
| **DELETE** | `/api/products/{id}` | Delete a product |

## 👨‍💻 Author
* **Student:** Miray Büyüktepe
* **Task:** #2 - CRUD Operations
*
