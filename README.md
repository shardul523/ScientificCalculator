# Scientific Calculator with DevOps Pipeline

A Java-based scientific calculator application with a complete DevOps pipeline for continuous integration and deployment.

## Features

This calculator offers the following operations:
- Square root function (√x)
- Factorial function (x!)
- Natural logarithm (base e) - ln(x)
- Power function (x^b)

## Technical Stack

- **Language**: Java 21
- **Build Tool**: Maven
- **Testing**: JUnit
- **CI/CD**: Jenkins
- **Containerization**: Docker
- **Deployment**: Ansible

## Project Structure

```
scientific-calculator/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── ScientificCalculator.java
│   └── test/
│       └── java/
│           └── ScientificCalculatorTest.java
├── pom.xml
├── Dockerfile
├── Jenkinsfile
├── deploy.yml (Ansible playbook)
├── inventory.ini (Ansible inventory)
└── README.md
```

## Setup Instructions

### Prerequisites

- Java 11 or higher
- Maven
- Docker
- Jenkins
- Ansible

### Running Locally

1. Clone the repository:
   ```
   git clone https://github.com/shardul523/ScientificCalculator.git
   cd ScientificCalculator
   ```

2. Build the project:
   ```
   mvn clean package
   ```

3. Run the application:
   ```
   java -jar target/ScientificCalculator-1.0-SNAPSHOT.jar
   ```

### DevOps Pipeline

#### Setting up Jenkins

1. Install Jenkins and required plugins:
   - Git plugin
   - Maven Integration plugin
   - Docker plugin
   - Pipeline plugin
   - Ansible plugin

2. Create a Jenkins pipeline job:
   - Go to Jenkins dashboard -> New Item -> Pipeline
   - Configure SCM: Select Git and provide your repository URL
   - Use "Jenkinsfile" as the script path

3. Set up Docker Hub credentials in Jenkins:
   - Go to Jenkins dashboard -> Manage Jenkins -> Credentials -> System -> Global credentials
   - Add credentials with ID 'docker-hub-credentials'

#### Setting up Docker

1. Install Docker on your Jenkins server and local machine
2. Create a Docker Hub account if you don't have one

#### Setting up Ansible

1. Install Ansible on your Jenkins server
2. Update the inventory.ini file with your target servers

## Running the Pipeline

1. Make changes to the code and push to your Git repository
2. Jenkins will automatically detect changes and start the pipeline
3. The pipeline will:
   - Build the Java application with Maven
   - Run JUnit tests
   - Build a Docker image
   - Push the image to Docker Hub
   - Deploy the application using Ansible

## Manual Deployment

If you want to manually deploy the application:

1. Build the Docker image:
   ```
   docker build -t sharduldev/scientific-calculator .
   ```

2. Run the container:
   ```
   docker run -it sharduldev/scientific-calculator
   ```

3. Or use Ansible:
   ```
   ansible-playbook -i inventory.ini deploy.yml
   ```

## Running the Calculator

- After either running the pipeline or manual deployment, a container starts in the background.
- Attach the calculator to the terminal in order to work with the calculator.
   ```
   docker attach container_id
   ```