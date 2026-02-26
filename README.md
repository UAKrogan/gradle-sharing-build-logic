# Gradle Sharing Build Logic

A comprehensive Gradle multi-project setup demonstrating shared build logic, Spring Boot reactive applications, and modern Java development practices with integrated testing strategies.

## 🏗️ Project Structure

```
gradle-sharing-build-logic/
├── build-logic/                    # Shared build logic plugins
│   └── src/main/groovy/            # Custom Gradle plugins
├── service/                        # Main Spring Boot application
│   └── src/
│       ├── main/java/              # Application source code
│       ├── test/java/              # Unit tests
│       ├── integration/java/       # Integration tests
│       └── contract/java/          # Contract tests (Pact)
├── shared/                         # Shared modules (commented out)
│   ├── service-api-dto/
│   ├── service-api-models/
│   └── other-service-client/
├── config/checkstyle/              # Code quality configuration
├── gradle/                         # Gradle wrapper and version catalog
└── docker-compose.yml              # SonarQube setup
```

## 🚀 Features

### Build Logic Plugins
- **Java Base Configuration** (`com.example.java`) - Java 21 with Amazon Corretto
- **Spring Boot Setup** (`com.example.spring-boot`) - Base Spring Boot configuration
- **Reactive Applications** (`com.example.spring-boot-reactive-app`) - WebFlux setup with multiple test types
- **Code Quality** - Checkstyle, JaCoCo, SonarQube integration
- **Contract Testing** - Pact consumer/provider support

### Testing Strategy
- **Unit Tests** - Standard JUnit 5 tests
- **Integration Tests** - Separate source set for integration testing
- **Contract Tests** - Pact-based contract testing with dedicated source set
- **Code Coverage** - JaCoCo integration with SonarQube reporting

### Code Quality
- **Checkstyle** - Sun coding conventions with custom rules
- **SonarQube** - Code quality analysis with Docker setup
- **JaCoCo** - Test coverage reporting

## 🛠️ Technology Stack

- **Java**: 21 (Amazon Corretto)
- **Spring Boot**: 3.5.10
- **Spring Cloud**: 2025.0.0
- **Build Tool**: Gradle 8.14.3
- **Testing**: JUnit 5, Pact 4.6.17
- **Code Quality**: Checkstyle 11.0.1, JaCoCo 0.8.13, SonarQube 6.3.1.5724

## 🏃‍♂️ Getting Started

### Prerequisites
- Java 21 or higher
- Docker and Docker Compose (for SonarQube)

### Build and Run

```bash
# Build the project
./gradlew build

# Run the service
./gradlew :service:bootRun

# Run tests
./gradlew test                    # Unit tests
./gradlew integrationTest         # Integration tests
./gradlew contractTest           # Contract tests

# Code quality checks
./gradlew checkstyleMain         # Checkstyle analysis
./gradlew jacocoTestReport       # Generate coverage report
```

### SonarQube Setup

```bash
# Start SonarQube with PostgreSQL
docker-compose up -d

# Wait for SonarQube to be ready (http://localhost:9000)
# Default credentials: admin/admin

# Run SonarQube analysis
export SONAR_TOKEN=your_token_here
./gradlew sonar
```

## 📋 Available Gradle Tasks

### Build Tasks
- `build` - Assembles and tests the project
- `clean` - Deletes the build directory
- `bootJar` - Creates executable JAR file

### Test Tasks
- `test` - Runs unit tests
- `integrationTest` - Runs integration tests
- `contractTest` - Runs contract tests
- `check` - Runs all verification tasks

### Code Quality Tasks
- `checkstyleMain` - Runs Checkstyle on main source
- `checkstyleTest` - Runs Checkstyle on test source
- `jacocoTestReport` - Generates JaCoCo coverage report
- `sonar` - Runs SonarQube analysis

### Pact Tasks
- `pactPublish` - Publishes Pact contracts to broker
- `pactVerify` - Verifies Pact contracts

## 🔧 Configuration

### Environment Variables for Pact
```bash
PACTBROKER_URL=https://your-pact-broker-url
PACTBROKER_AUTH_TOKEN=your-auth-token
PACT_CONSUMER_BRANCH=main
PACT_CONSUMER_VERSION=1.0.0
PACT_CONSUMER_TAGS=dev,test
```

### Environment Variables for SonarQube
```bash
SONAR_TOKEN=your-sonar-token
```

## 📁 Custom Gradle Plugins

The project includes several custom Gradle plugins in the `build-logic` module:

- `com.example.java` - Base Java configuration with Lombok
- `com.example.java.checkstyle` - Checkstyle integration
- `com.example.java.jacoco` - JaCoCo coverage configuration
- `com.example.java.sonarqube` - SonarQube integration
- `com.example.spring-boot` - Spring Boot base setup
- `com.example.spring-boot-reactive-app` - Reactive app with multiple test types
- `com.example.pact` - Pact broker configuration
- `com.example.pact-consumer` - Pact consumer setup
- `com.example.pact-provider` - Pact provider setup

## 🧪 Testing Architecture

### Source Sets
- `main` - Application code
- `test` - Unit tests
- `integration` - Integration tests with full Spring context
- `contract` - Contract tests using Pact framework

### Test Dependencies
Each test source set inherits from the test configuration and adds specific dependencies as needed.

## 📊 Code Quality Standards

- **Line Length**: Maximum 122 characters
- **Indentation**: 4 spaces (8 for array initialization)
- **Naming**: Sun Java conventions
- **Coverage**: Tracked via JaCoCo and reported to SonarQube

## 🐳 Docker Support

The project includes a `docker-compose.yml` for running SonarQube locally with PostgreSQL backend.

## 📝 Development Guidelines

1. Follow the established package structure (`com.example`)
2. Write tests for all new functionality
3. Ensure code passes Checkstyle validation
4. Maintain test coverage above project standards
5. Use contract testing for external service interactions

## 🤝 Contributing

1. Ensure all tests pass: `./gradlew check`
2. Verify code quality: `./gradlew checkstyleMain checkstyleTest`
3. Check test coverage: `./gradlew jacocoTestReport`
4. Run SonarQube analysis before submitting changes

## 📄 License

This project serves as a template for Gradle multi-project builds with shared build logic and modern Java development practices.
