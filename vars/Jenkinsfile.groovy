def call(Map pipelineParams) {
    stage('Checkout') {
        git branch: pipelineParams.branch, url: pipelineParams.scmUrl
    }

    stage('Build') {
        sh 'echo Building project...'
    }

    stage('Test') {
        sh 'echo Running tests...'
    }

    stage('Deploy') {
        sh "echo Deploying to ${pipelineParams.developmentServer}:${pipelineParams.serverPort}"
    }
}
