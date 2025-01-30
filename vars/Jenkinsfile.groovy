def call(Map pipelineParams) {
    pipeline{
        agent any
        stages {
            stage('Checkout') {
                step {
                    git branch: pipelineParams.branch, url: pipelineParams.scmUrl
                }
            }

            stage('Build') {
                step {
                    sh 'echo Building project...'
                }
            }

            stage('Test') {
                step {
                    sh 'echo Running tests...'
                }
            }

            stage('Deploy') {
                step{
                    sh "echo Deploying to ${pipelineParams.developmentServer}:${pipelineParams.serverPort}"
                }
            }
        }
    }
}
