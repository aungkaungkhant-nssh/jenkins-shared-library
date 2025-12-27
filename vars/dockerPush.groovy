import com.example.com.Docker
def call(String imageName){
    return new Docker(this).pushDockerImage(imageName)
}


