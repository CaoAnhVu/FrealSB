
![Logo](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/th5xamgrr6se0x5ro4g6.png)


## Screenshots

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)

## Table of Contents

- [Freal](#freal)
  - [Authors](#authors)
  - [Features](#features)
  - [Installation](#installation)
    - [Clone the repository](#clone-the-repository)
    - [Configure Application Properties](#configure-application-properties)
  - [Build and Run the Application](#build-and-run-the-application)
  - [Acknowledgements](#acknowledgements)
  - [License](#license)

# Freal

Freal is a dynamic application that combines the best of food discovery, travel adventures, and social media interaction. Built with Java Spring Boot, Freal aims to provide users with a seamless experience in exploring culinary delights, planning travel itineraries, and connecting with like-minded individuals.


## Authors

- [@HydraCoder](https://www.github.com/ngodat213)
- [@AndyVuCoder](https://github.com/CaoAnhVu)
- [@Nguyễn Ngọc Cát Tường](https://github.com/nguyenngoccattuong)



## Features

- Manage food, travel, event, and culture information
- User authentication and authorization using Spring Security
- Real-time communication using SocketIO
- File upload and management using Cloudinary


## Installation

### Clone the repository

```bash
git clone https://github.com/ngodat213/FrealSB.git
cd frealsb
```
### Configure Application Properties
- Sign up for a Cloudinary account.
- Retrieve your Cloudinary credentials (cloud name, API key, and API secret).
- Create an application.properties file in the src/main/resources directory and add the following properties:

```bash
# Application name
spring.application.name=FrealSB

# Database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/FrealSB
spring.datasource.username=root
spring.datasource.password=your_password

# JPA configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Cloudinary configuration
cloudinary.cloud_name=your_cloud_name
cloudinary.api_key=your_api_key
cloudinary.api_secret=your_api_secret
```



    
# Build and Run the Application

```bash
mvn clean install
mvn spring-boot:run
```

The application will start on http://localhost:8080.
## Acknowledgements

- Spring Boot
- Spring Security
- Cloudinary
- SocketIO
- Thymeleaf


## License

[MIT]([https://choosealicense.com/licenses/mit/](https://github.com/ngodat213/FrealSB?tab=MIT-1-ov-file))

