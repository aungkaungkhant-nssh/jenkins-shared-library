package com.example

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName, String dockerfilePath = '.') {
        script.sh "docker build -t ${imageName} ${dockerfilePath}"
    }

    def dockerLogin() {
        script.withCredentials([
            script.usernamePassword(
            credentialsId: 'docker-hub-id',
            usernameVariable: 'DOCKER_HUB_USERNAME',
            passwordVariable: 'DOCKER_HUB_PASSWORD'
        )
    ]) {
        script.sh '''
            echo "$DOCKER_HUB_PASSWORD" | docker login -u "$DOCKER_HUB_USERNAME" --password-stdin
        '''
    }
    }

    def pushDockerImage(String imageName) {
        script.sh "docker push ${imageName}"
    }
}