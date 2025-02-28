pipeline {
    agent any
    
    environment {
        // Define environment variables
        DOCKER_HUB_CREDS = credentials('docker-hub-credentials')
        DOCKER_IMAGE_NAME = "sharduldev/scientific-calculator"
        DOCKER_IMAGE_TAG = "${env.BUILD_NUMBER}"
    }
    
    stages {
        stage('Checkout') {
            steps {
                // Get the code from the GitHub repository
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                // Build with Maven
                sh 'mvn clean package'
            }
        }
        
        
        stage('Docker Build') {
            steps {
                // Build Docker image
                sh "docker build -t ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG} ."
                sh "docker tag ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG} ${DOCKER_IMAGE_NAME}:latest"
            }
        }
        
        stage('Docker Push') {
            steps {
                // Log in to Docker Hub and push the image
                sh "echo ${DOCKER_HUB_CREDS_PSW} | docker login -u ${DOCKER_HUB_CREDS_USR} --password-stdin"
                sh "docker push ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}"
                sh "docker push ${DOCKER_IMAGE_NAME}:latest"
            }
        }

        stage('Deploy') {
            steps {
                // Run Ansible playbook to deploy the application
                sh "ansible-playbook -i inventory.ini deploy-calculator.yml"
            }
        }
        
    }
    
    post {
        always {
            // Clean up Docker images to save space
            sh "docker rmi ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG} || true"
            sh "docker rmi ${DOCKER_IMAGE_NAME}:latest || true"
        }
    }
}