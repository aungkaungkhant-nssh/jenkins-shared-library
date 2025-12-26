def buildImage(){
    echo 'building the docker image.....'
    withCredentials([usernamePassword(credentialsId: 'docker-hub-id', passwordVariable: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_HUB_USERNAME')]) {
        sh '''
            docker build -t aungkaungkhant107/docker-test:v1.0.2 .
            echo $DOCKER_HUB_PASSWORD | docker login -u $DOCKER_HUB_USERNAME --password-stdin
            docker push aungkaungkhant107/docker-test:v1.0.2
        '''
    }
}
