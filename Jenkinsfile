pipeline{
    agent any

    environment{
        DOCKER_IMAGE_NAME = "myswaggerapp"
        DOCKER_CONTAINER_NAME = "swaggerappcontainer"
    }

    stages{

        stage('git checkout code'){
            steps{
                checkout scm
            }
        }

        stage('maven build for jar'){
            steps{
                bat "mvn clean package"
            }
        }

         stage('docker login'){
              steps{
                    withCredentials([usernamePassword(credentialsId:'dockerhub-credentials',usernameVariable:'DOCKER_USERNAME',passwordVariable:'DOCKER_PASSWORD')]){
                        bat "echo %DOCKER_PASSWORD% | docker login -u %DOCKER_USERNAME%  --password-stdin"
                   }
             }
         }

        stage('docker image build'){
            steps{
                bat "docker build -t prasanna0218/${DOCKER_IMAGE_NAME}:${BUILD_NUMBER} ."
            }
        }

        stage('docker push'){
            steps{
                bat "docker push prasanna0218/${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}"
            }
        }

        stage('docker image pull'){
            steps{
                bat "docker pull prasanna0218/${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}"
            }
        }

        stage('removing old images except last build image'){
            steps{
                script{
                    def current_buildNumber = env.BUILD_NUMBER.toInteger()
                    def second_oldBuildNumber =  current_buildNumber - 2

                    if(second_oldBuildNumber > 0){
                        try{
                            bat "docker rmi prasanna0218/${DOCKER_IMAGE_NAME}:${second_oldBuildNumber}"
                        }catch(Exception e){
                            echo "Old image for build ${second_oldBuildNumber} not found. Skipping delete."
                        }
                    }else{
                          echo "No old images found so we skipped deletion of Images"
                    }
                }
            }
        }

        stage('docker remove old containers & docker run new container'){
            steps{
                script{
                    try{
                        bat "docker stop ${DOCKER_CONTAINER_NAME}"
                        bat "docker rm ${DOCKER_CONTAINER_NAME}"
                    }catch(Exception e){
                        echo "No existing containers found so skipping deletion of containers"
                    }

                    bat "docker run -d --name ${DOCKER_CONTAINER_NAME} -p 8080:8080 prasanna0218/${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}"
                }
            }
        }
    }

    post{
        success{
             emailext (
                            subject : "Build Success So Please kindly check it !",
                            body:"""<html>
                                            <body>
                                                <h1>Build Status : Success for ${JOB_NAME} for build ${currentBuild.number}</h1>
                                                <h3>Please Verify all the APIs from the QA 😊</h3>
                                                <h4>Info from Operation Team ❤️</h4>
                                           </body>
                                         </html> """,
                           to:"prasannap0218@gmail.com",
                           from:"devjenkins0218@gmail.com",
                           replyTo: "devjenkins0218@gmail.com",
                           mimeType:"text/html"
            )
        }
    }
}