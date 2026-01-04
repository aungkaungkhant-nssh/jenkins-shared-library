def call() {
    return sh(
        script: "node -p \"require('./package.json').version\"",
        returnStdout: true
    ).trim()
}
