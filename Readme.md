# 🧾 Asset Management System

This is a simple Spring Boot web application for managing organizational assets, built with Thymeleaf for templating and H2 for in-memory persistence.

## 🚀 Features

- Add, view, and list assets
- Record asset amount, useful life, and depreciation
- View last depreciation date and asset status
- Web UI using Thymeleaf

## 🛠️ Tech Stack

- Java 17+
- Spring Boot 3+
- Thymeleaf (HTML templating engine)
- H2 in-memory database
- Spring MVC
- Maven


## 📁 Project Structure

src
├── main
│ ├── java
│ │ └── com.example
│ │ ├── controller
│ │ ├── dto
│ │ ├── model
│ │ ├── repository
│ │ └── service
│ └── resources
│ ├── templates
│ │ └── home.html
│ └── application.properties


---

## ⚙️ Getting Started

### Prerequisites

- Java 17+
- Maven 3+

### Running the App

```bash
git clone https://github.com/Chaos97-oss/Mini-web-app.git
cd asset-management
mvn spring-boot:run
Visit: http://localhost:8080/ in your browser.

🧪 Testing
This is a simple web app, so manual UI testing is sufficient for now. (Optional: add unit tests later.)

🗃 Sample Data
Once the app is running, you can manually input asset data using the form on the homepage.

## 🧾 Add New Asset via Web Form

Visit [http://localhost:8080](http://localhost:8080) and use the form to add a new asset.

Fields:
- Asset Name
- Amount
- Useful Life
- Purchase Date
- Branch

The added asset will appear in the table below the form.
Example:

Asset Name	Amount	Useful Life	Last Depreciation Date
Laptop	500000	5 years	2025-08-01

📄 API (Optional)
If you expose REST endpoints later, document them here with sample requests and responses.

🧑‍💻 Author
Your Name
GitHub
Email

📜 License
This project is licensed under the MIT License.

