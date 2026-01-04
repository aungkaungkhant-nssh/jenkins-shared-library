def call() {
    return sh(
        script: "cat package.json | grep '\"version\"' | head -1 | sed 's/.*: \"//;s/\",//'",
        returnStdout: true
    ).trim()
}
